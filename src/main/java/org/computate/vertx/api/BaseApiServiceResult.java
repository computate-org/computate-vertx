/*
 * Copyright (c) 2018-2022 Computate Limited Liability Company in Utah, USA. 
 *
 * This program and the accompanying materials are made available under the
 * terms of the GNU GENERAL PUBLIC LICENSE Version 3 which is available at
 * 
 * https://www.gnu.org/licenses/gpl-3.0.en.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.vertx.api;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.computate.search.tool.SearchTool;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.model.user.ComputateSiteUser;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.result.base.ComputateBaseResult;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.verticle.EmailVerticle;

import com.google.common.io.Resources;

import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.predicate.ResponsePredicate;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public abstract class BaseApiServiceResult extends BaseApiService {

	public <Q extends ComputateBaseResult, SiteRequest extends ComputateSiteRequest> void configureUiContextResult(Promise<Void> promise, Q result, JsonObject ctx) {
		promise.complete();
	}

	public <Q extends ComputateBaseResult, SiteRequest extends ComputateSiteRequest> void configureUiResult(Router router, Class<Q> classResult, Class<SiteRequest> classSiteRequest, String uriPrefix) {
		router.getWithRegex("(?<uri>" + uriPrefix.replace("/", "\\/") + "\\/.*)").handler(handler -> {
			ServiceRequest serviceRequest = generateServiceRequest(handler);
			SiteRequest siteRequest = generateSiteRequest(null, null, serviceRequest, classSiteRequest);

			String uri = handler.pathParam("uri");
			SearchList<Q> l = new SearchList<>();
			l.q("*:*");
			l.setC(classResult);
			l.fq(String.format("%s_docvalues_string:%s", "uri", SearchTool.escapeQueryChars(uri)));
			l.setStore(true);
			handler.response().headers().add("Content-Type", "text/html");
			l.promiseDeepForClass(siteRequest).onSuccess(a -> {
				Q result = l.first();
				try {
					JsonObject resultJson = JsonObject.mapFrom(result);
					String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
					Path resourceTemplatePath = Path.of(siteTemplatePath, resultJson.getString("templateUri"));
					String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
					JsonObject ctx = ComputateConfigKeys.getPageContext(config);
					ctx.put(classResult.getSimpleName(), result);
					Matcher m = Pattern.compile("<meta name=\"([^\"]+)\"\\s+content=\"([^\"]*)\"/>", Pattern.MULTILINE).matcher(template);
					boolean trouve = m.find();
					while (trouve) {
						String siteKey = m.group(1);
						if(siteKey.startsWith("site:")) {
							String key = StringUtils.substringAfter(siteKey, "site:");
							String val = m.group(2);
							if(val instanceof String) {
								String rendered = jinjava.render(val, ctx.getMap());
								ctx.put(key, rendered);
							} else {
								ctx.put(key, val);
							}
						}
						trouve = m.find();
					}
					Promise<Void> promise = Promise.promise();
					configureUiContextResult(promise, result, ctx);
					promise.future().onSuccess(o -> {
						String renderedTemplate = jinjava.render(template, ctx.getMap());
						Buffer buffer = Buffer.buffer(renderedTemplate);
						handler.response().putHeader("Content-Type", "text/html");
						handler.end(buffer);
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch (Exception ex) {
					LOG.error(String.format("Failed to render page %s", uri), ex);
					handler.fail(ex);
				}
				
			}).onFailure(ex -> {
				LOG.error(String.format("Failed to render page %s", uri), ex);
				handler.fail(ex);
			});
		});
	}

	public <Q extends ComputateBaseResult, SiteRequest extends ComputateSiteRequest, SiteUser extends ComputateSiteUser> void configureUserUiResult(Router router, Class<Q> classResult, Class<SiteRequest> classSiteRequest, Class<SiteUser> classSiteUser, String apiAddressSiteUser, String uriPrefix, String uriPrefixUser) {
		router.getWithRegex("(?<uri>" + uriPrefixUser.replace("/", "\\/") + "\\/.*)").handler(oauth2AuthHandler).handler(handler -> {
			ServiceRequest serviceRequest = generateServiceRequest(handler);
			String userUri = handler.pathParam("uri");

			user(serviceRequest, classSiteRequest, classSiteUser, apiAddressSiteUser, "postSiteUserFuture", "patchSiteUserFuture", false).onSuccess(siteRequest -> {
				SearchList<Q> l = new SearchList<>();
				l.q("*:*");
				l.setC(classResult);
				l.fq(String.format("%s_docvalues_string:%s", "userUri", SearchTool.escapeQueryChars(userUri)));
				l.setStore(true);
				l.promiseDeepForClass(siteRequest).onSuccess(a -> {
					try {
						Q result = l.first();
						if(result != null) {
							String uri = (String)result.obtainForClass("uri");

							webClient.post(
									Integer.parseInt(config.getString(ComputateConfigKeys.AUTH_PORT))
									, config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
									, config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
									)
									.ssl(Boolean.parseBoolean(config.getString(ComputateConfigKeys.AUTH_SSL)))
									.putHeader("Authorization", String.format("Bearer %s", siteRequest.getUser().principal().getString("access_token")))
									.expect(ResponsePredicate.status(200))
									.sendForm(MultiMap.caseInsensitiveMultiMap()
											.add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket")
											.add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT))
											.add("response_mode", "permissions")
											.add("permission", String.format("%s#%s", uri, "GET"))
							).onComplete(future -> {
								try {
									HttpResponse<Buffer> authorizationDecision = null;
									if(future.succeeded())
										authorizationDecision = future.result();
									JsonArray scopes = Optional.ofNullable(authorizationDecision).map(authDecision -> authDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray())).orElse(new JsonArray());
									SiteUser user = siteRequest.getSiteUser_(classSiteUser);
									try {
										JsonObject resultJson = JsonObject.mapFrom(result);
										String siteTemplatePath = config.getString(ComputateConfigKeys.TEMPLATE_PATH);
										Path resourceTemplatePath = Path.of(siteTemplatePath, resultJson.getString("templateUri"));
										String template = siteTemplatePath == null ? Resources.toString(Resources.getResource(resourceTemplatePath.toString()), StandardCharsets.UTF_8) : Files.readString(resourceTemplatePath, Charset.forName("UTF-8"));
										JsonObject ctx = ComputateConfigKeys.getPageContext(config);
										ctx.put(classResult.getSimpleName(), result);
										String userName = user.getUserName();
										ctx.put("userName", userName);
										ctx.put("userFirstName", user.getUserFirstName());
										ctx.put("userLastName", user.getUserLastName());
										if(scopes.contains("GET")) {
											ctx.put("scope", "GET");
										}
										Matcher m = Pattern.compile("<meta name=\"([^\"]+)\"\\s+content=\"([^\"]*)\"/>", Pattern.MULTILINE).matcher(template);
										boolean trouve = m.find();
										while (trouve) {
											String siteKey = m.group(1);
											if(siteKey.startsWith("site:")) {
												String key = StringUtils.substringAfter(siteKey, "site:");
												String val = m.group(2);
												if(val instanceof String) {
													String rendered = jinjava.render(val, ctx.getMap());
													ctx.put(key, rendered);
												} else {
													ctx.put(key, val);
												}
											}
											trouve = m.find();
										}
										if(ctx.getString("scope") == null && "0.00".equals(ctx.getString("price"))) {
											ZoneId zoneId = ZoneId.of(config.getString(ComputateConfigKeys.SITE_ZONE));
											ZonedDateTime createdAt = ZonedDateTime.now(zoneId);
											String groupName = uri;
											String authAdminUsername = config.getString(ComputateConfigKeys.AUTH_ADMIN_USERNAME);
											String authAdminPassword = config.getString(ComputateConfigKeys.AUTH_ADMIN_PASSWORD);
											Integer authPort = Integer.parseInt(config.getString(ComputateConfigKeys.AUTH_PORT));
											String authHostName = config.getString(ComputateConfigKeys.AUTH_HOST_NAME);
											Boolean authSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.AUTH_SSL));
											String authRealm = config.getString(ComputateConfigKeys.AUTH_REALM);
											webClient.post(authPort, authHostName, "/realms/master/protocol/openid-connect/token").ssl(authSsl)
													.sendForm(MultiMap.caseInsensitiveMultiMap()
															.add("username", authAdminUsername)
															.add("password", authAdminPassword)
															.add("grant_type", "password")
															.add("client_id", "admin-cli")
															)
													.expecting(HttpResponseExpectation.SC_OK)
															.onSuccess(tokenResponse -> {
												try {
													String authToken = tokenResponse.bodyAsJsonObject().getString("access_token");
													webClient.get(authPort, authHostName, String.format("/admin/realms/%s/groups?exact=false&global=true&first=0&max=1&search=%s", authRealm, URLEncoder.encode(groupName, "UTF-8"))).ssl(authSsl).putHeader("Authorization", String.format("Bearer %s", authToken))
													.send()
													.expecting(HttpResponseExpectation.SC_OK)
													.onSuccess(groupResponse -> {
														try {
															JsonArray groups = Optional.ofNullable(groupResponse.bodyAsJsonArray()).orElse(new JsonArray());
															JsonObject group = groups.stream().findFirst().map(o -> (JsonObject)o).orElse(null);
															if(group != null) {
																String groupId = group.getString("id");
																String userId = user.getUserId();
																webClient.put(authPort, authHostName, String.format("/admin/realms/%s/users/%s/groups/%s", authRealm, userId, groupId)).ssl(authSsl)
																		.putHeader("Authorization", String.format("Bearer %s", authToken))
																		.putHeader("Content-Type", "application/json")
																		.putHeader("Content-Length", "0")
																		.send()
																		.expecting(HttpResponseExpectation.SC_NO_CONTENT)
																		.onSuccess(groupUserResponse -> {
																	try {
																		DeliveryOptions options = new DeliveryOptions();
																		String siteName = config.getString(ComputateConfigKeys.SITE_NAME);
																		String emailFrom = config.getString(ComputateConfigKeys.EMAIL_FROM);
																		String emailTo = user.getUserEmail();
																		String customerName = user.getUserFullName();

																		String emailTemplate = (String)result.obtainForClass("emailTemplate");
																		String orderItemName = (String)result.obtainForClass("name");
																		String subject = String.format("Thank you for ordering the %s from %s! ", customerName, orderItemName, siteName);
																		options.addHeader(EmailVerticle.MAIL_HEADER_SUBJECT, subject);
																		options.addHeader(EmailVerticle.MAIL_HEADER_FROM, emailFrom);
																		options.addHeader(EmailVerticle.MAIL_HEADER_TO, emailTo);
																		options.addHeader(EmailVerticle.MAIL_HEADER_TEMPLATE, emailTemplate);
																		JsonObject body = new JsonObject();
																		body.put(ComputateConfigKeys.SITE_BASE_URL, config.getString(ComputateConfigKeys.SITE_BASE_URL));
																		body.put("siteName", siteName);
																		body.put("githubUsername", userName);
																		body.put("orderId", "FREE");
																		body.put("subject", subject);
																		body.put("emailTo", emailTo);
																		body.put("customerName", customerName);
																		body.put("result", JsonObject.mapFrom(result));

																		Locale locale = Locale.forLanguageTag(config.getString(ComputateConfigKeys.SITE_LOCALE));
																		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEE d MMM uuuu h:mm a VV", locale);
																		String createdAtStr = dateFormat.format(createdAt.withZoneSameInstant(zoneId));
																		body.put("createdAt", createdAtStr);

																		vertx.eventBus().request(EmailVerticle.MAIL_EVENTBUS_ADDRESS, body.encode(), options).onSuccess(b -> {
																			ctx.put("scope", "GET");
																			Promise<Void> promise = Promise.promise();
																			configureUiContextResult(promise, result, ctx);
																			promise.future().onSuccess(o -> {
																				String renderedTemplate = jinjava.render(template, ctx.getMap());
																				Buffer buffer = Buffer.buffer(renderedTemplate);
																				handler.response().putHeader("Content-Type", "text/html");
																				handler.end(buffer);
																			}).onFailure(ex -> {
																				promise.fail(ex);
																			});
																		}).onFailure(ex -> {
																			LOG.error("Failed to render page. ", ex);
																			handler.fail(ex);
																		});
																	} catch(Throwable ex) {
																		LOG.error("Failed to render page. ", ex);
																		handler.fail(ex);
																	}
																}).onFailure(ex -> {
																	LOG.error("Failed to render page. ", ex);
																	handler.fail(ex);
																});
															} else {
																Throwable ex = new RuntimeException("Failed to find group. ");
																LOG.error(ex.getMessage(), ex);
																handler.fail(ex);
															}
														} catch(Throwable ex) {
															LOG.error("Failed to render page. ", ex);
															handler.fail(ex);
														}
													}).onFailure(ex -> {
														LOG.error("Failed to render page. ", ex);
														handler.fail(ex);
													});
												} catch(Throwable ex) {
													LOG.error("Failed to render page. ", ex);
													handler.fail(ex);
												}
											}).onFailure(ex -> {
												LOG.error("Failed to render page. ", ex);
												handler.fail(ex);
											});
										} else {
											String renderedTemplate = jinjava.render(template, ctx.getMap());
											Buffer buffer = Buffer.buffer(renderedTemplate);
											handler.response().putHeader("Content-Type", "text/html");
											handler.end(buffer);
										}
									} catch (Exception ex) {
										LOG.error(String.format("Failed to render page %s", userUri), ex);
										handler.fail(ex);
									}
								} catch (Exception ex) {
									LOG.error(String.format("Failed to render page %s", userUri), ex);
									handler.fail(ex);
								}
							});
						} else {
							Throwable ex = new RuntimeException(String.format("Failed to query page by userUri %s", userUri));
							LOG.error(ex.getMessage(), ex);
							handler.fail(ex);
						}
					} catch(Exception ex) {
						LOG.error("Failed to load page. ", ex);
						handler.fail(ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("Failed to render page %s", userUri), ex);
					handler.fail(ex);
				});
			}).onFailure(ex -> {
				LOG.error(String.format("Failed to render page %s", userUri), ex);
				handler.fail(ex);
			});
		});
	}
}
