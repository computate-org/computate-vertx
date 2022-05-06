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

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.request.SearchRequest;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.tool.SearchTool;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
import org.computate.vertx.model.user.ComputateVertxSiteUser;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.verticle.EmailVerticle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.impl.JsonUtil;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Tuple;


/**
 * Keyword: classSimpleNameBaseApiServiceImpl
 * Map.hackathonMission: to create a new Java class BaseApiServiceImpl containing the base structure for all the API implementation classes in the site with helpful methods for persistence, authentication and more. 
 * Map.hackathonColumn: Develop Base Classes
 * Map.hackathonLabels: Java,Vert.x
 **/
public abstract class BaseApiServiceImpl {

	protected static final Logger LOG = LoggerFactory.getLogger(BaseApiServiceImpl.class);

	protected EventBus eventBus;

	protected JsonObject config;

	protected WorkerExecutor workerExecutor;

	protected PgPool pgPool;

	protected WebClient webClient;

	protected OAuth2Auth oauth2AuthenticationProvider;

	protected AuthorizationProvider authorizationProvider;

	protected HandlebarsTemplateEngine templateEngine;

	public BaseApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient) {
		this.eventBus = eventBus;
		this.config = config;
		this.workerExecutor = workerExecutor;
		this.pgPool = pgPool;
		this.webClient = webClient;
	}

	public BaseApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider) {
		this.eventBus = eventBus;
		this.config = config;
		this.workerExecutor = workerExecutor;
		this.pgPool = pgPool;
		this.webClient = webClient;
		this.oauth2AuthenticationProvider = oauth2AuthenticationProvider;
		this.authorizationProvider = authorizationProvider;
	}

	public BaseApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		this.eventBus = eventBus;
		this.config = config;
		this.workerExecutor = workerExecutor;
		this.pgPool = pgPool;
		this.webClient = webClient;
		this.oauth2AuthenticationProvider = oauth2AuthenticationProvider;
		this.authorizationProvider = authorizationProvider;
		this.templateEngine = templateEngine;
	}

	// General //

	public void error(ComputateVertxSiteRequest siteRequest, Handler<AsyncResult<ServiceResponse>> eventHandler, Throwable ex) {
		JsonObject json = new JsonObject();
		JsonObject jsonError = new JsonObject();
		json.put("error", jsonError);
		jsonError.put("message", Optional.ofNullable(ex).map(Throwable::getMessage).orElse(null));
		if(siteRequest != null) {
			jsonError.put("userName", siteRequest.getUserName());
			jsonError.put("userFullName", siteRequest.getUserFullName());
			jsonError.put("requestUri", siteRequest.getRequestUri());
			jsonError.put("requestMethod", siteRequest.getRequestMethod());
			jsonError.put("params", Optional.ofNullable(siteRequest.getServiceRequest()).map(o -> o.getParams()).orElse(null));
		}
		LOG.error("error: ", ex);
		ServiceResponse responseOperation = new ServiceResponse(400, "BAD REQUEST", 
				Buffer.buffer().appendString(json.encodePrettily())
				, MultiMap.caseInsensitiveMultiMap().add("Content-Type", "application/json")
		);
		if(siteRequest != null) {
			DeliveryOptions options = new DeliveryOptions();
			options.addHeader(EmailVerticle.MAIL_HEADER_SUBJECT, String.format("%s %s", config.getString(ComputateVertxConfigKeys.SITE_BASE_URL), Optional.ofNullable(ex).map(Throwable::getMessage).orElse(null)));
			eventBus.publish(EmailVerticle.MAIL_EVENTBUS_ADDRESS, String.format("%s\n\n%s", json.encodePrettily(), ExceptionUtils.getStackTrace(ex)));
			if(eventHandler != null)
				eventHandler.handle(Future.succeededFuture(responseOperation));
		} else {
			if(eventHandler != null)
				eventHandler.handle(Future.succeededFuture(responseOperation));
		}
	}

	public <T extends ComputateVertxSiteRequest> T generateSiteRequest(User user, ServiceRequest serviceRequest, Class<T> clazz) {
		return generateSiteRequest(user, serviceRequest, serviceRequest.getParams().getJsonObject("body"), clazz);
	}

	public <T extends ComputateVertxSiteRequest> T generateSiteRequest(User user, ServiceRequest serviceRequest, JsonObject body, Class<T> clazz) {
		T siteRequest = null;
		try {
			siteRequest = clazz.getDeclaredConstructor().newInstance();
			siteRequest.setWebClient(webClient);
			siteRequest.setJsonObject(body);
			siteRequest.setUser(user);
			siteRequest.setConfig(config);
			siteRequest.setServiceRequest(serviceRequest);
			siteRequest.setSiteRequest_(siteRequest);
			siteRequest.initDeepForClass();
		} catch (Exception ex) {
			ExceptionUtils.rethrow(ex);
		}

		return siteRequest;
	}

	public <T extends ComputateVertxSiteRequest> Future<T> user(ServiceRequest serviceRequest, Class<T> cSiteRequest, Class<?> cSiteUser, String vertxAddress, String postAction, String patchAction) {
		Promise<T> promise = Promise.promise();
		try {
			JsonObject userPrincipal = serviceRequest.getUser();
			if(userPrincipal == null) {
				ComputateVertxSiteRequest siteRequest = generateSiteRequest(null, serviceRequest, cSiteRequest);
				promise.complete((T)siteRequest);
			} else {
				User token = User.create(userPrincipal);
				oauth2AuthenticationProvider.authenticate(token.principal()).onSuccess(user -> {
					user.attributes().put("principal", user.principal());
					authorizationProvider.getAuthorizations(user).onSuccess(b -> {
						try {
							JsonObject userAttributes = user.attributes();
							JsonObject accessToken = userAttributes.getJsonObject("accessToken");
							String userId = accessToken.getString("sub");
							T siteRequest = generateSiteRequest(user, serviceRequest, cSiteRequest);
							SearchList<ComputateVertxSiteUser> searchList = new SearchList<ComputateVertxSiteUser>();
							searchList.q("*:*");
							searchList.setStore(true);
							searchList.setC(cSiteUser);
							searchList.fq("userId_docvalues_string:" + SearchTool.escapeQueryChars(userId));
							searchList.promiseDeepSearchList(siteRequest).onSuccess(c -> {
								ComputateVertxSiteUser siteUser1 = searchList.getList().stream().findFirst().orElse(null);

								if(siteUser1 == null) {
									JsonObject jsonObject = new JsonObject();
									jsonObject.put("userName", accessToken.getString("preferred_username"));
									jsonObject.put("userFirstName", accessToken.getString("given_name"));
									jsonObject.put("userLastName", accessToken.getString("family_name"));
									jsonObject.put("userFullName", accessToken.getString("name"));
									jsonObject.put("userId", accessToken.getString("sub"));
									jsonObject.put("userEmail", accessToken.getString("email"));
									userDefine(siteRequest, jsonObject, false);

									ComputateVertxSiteRequest siteRequest2 = siteRequest.copy();
									siteRequest2.setJsonObject(jsonObject);
									siteRequest2.setSiteRequest_(siteRequest);
									siteRequest2.initDeepForClass();

									ApiRequest apiRequest = new ApiRequest();
									apiRequest.setRows(1L);
									apiRequest.setNumFound(1L);
									apiRequest.setNumPATCH(0L);
									apiRequest.initDeepApiRequest(siteRequest2);
									siteRequest2.setApiRequest_(apiRequest);

									JsonObject params = new JsonObject();
									params.put("body", jsonObject);
									params.put("path", new JsonObject());
									params.put("cookie", new JsonObject());
									params.put("header", new JsonObject());
									params.put("form", new JsonObject());
									JsonObject query = new JsonObject();
									Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
									Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
									if(softCommit == null && commitWithin == null)
										softCommit = true;
									if(softCommit)
										query.put("softCommit", softCommit);
									if(commitWithin != null)
										query.put("commitWithin", commitWithin);
									params.put("query", query);
									JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(u -> u.attributes().getJsonObject("tokenPrincipal")).orElse(null));
									JsonObject json = new JsonObject().put("context", context);
									eventBus.request(vertxAddress, json, new DeliveryOptions().addHeader("action", postAction)).onSuccess(a -> {
										JsonObject responseMessage = (JsonObject)a.body();
										JsonObject responseBody = new JsonObject(Buffer.buffer(JsonUtil.BASE64_DECODER.decode(responseMessage.getString("payload"))));
										Long pk = Long.parseLong(responseBody.getString("pk"));
										siteRequest.setUserName(accessToken.getString("preferred_username"));
										siteRequest.setUserFirstName(accessToken.getString("given_name"));
										siteRequest.setUserLastName(accessToken.getString("family_name"));
										siteRequest.setUserEmail(accessToken.getString("email"));
										siteRequest.setUserId(accessToken.getString("sub"));
										apiRequest.setPk(pk);
										siteRequest.setUserKey(pk);
										siteRequest.setApiRequest_(apiRequest);
										siteRequest.setUserPrincipal(userPrincipal);
										promise.complete(siteRequest);
									}).onFailure(ex -> {
										LOG.error(String.format("postSiteUser failed. "), ex);
										promise.fail(ex);
									});
								} else {
									JsonObject jsonObject = new JsonObject();
									jsonObject.put("setUserName", accessToken.getString("preferred_username"));
									jsonObject.put("setUserFirstName", accessToken.getString("given_name"));
									jsonObject.put("setUserLastName", accessToken.getString("family_name"));
									jsonObject.put("setUserCompleteName", accessToken.getString("name"));
									jsonObject.put("setUserId", accessToken.getString("sub"));
									jsonObject.put("setUserEmail", accessToken.getString("email"));
									Boolean define = userDefine(siteRequest, jsonObject, true);
									if(define) {

										ComputateVertxSiteRequest siteRequest2 = siteRequest.copy();
										siteRequest2.setJsonObject(jsonObject);
										siteRequest2.setSiteRequest_(siteRequest);
										siteRequest2.initDeepForClass();
										siteUser1.setSiteRequest_(siteRequest2);

										ApiRequest apiRequest = new ApiRequest();
										apiRequest.setRows(1L);
										apiRequest.setNumFound(1L);
										apiRequest.setNumPATCH(0L);
										apiRequest.initDeepApiRequest(siteRequest2);
										siteRequest2.setApiRequest_(apiRequest);

										JsonObject params = new JsonObject();
										params.put("body", jsonObject);
										params.put("path", new JsonObject());
										params.put("cookie", new JsonObject());
										params.put("header", new JsonObject());
										params.put("form", new JsonObject());
										JsonObject query = new JsonObject();
										Boolean softCommit = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getBoolean("softCommit")).orElse(null);
										Integer commitWithin = Optional.ofNullable(siteRequest.getServiceRequest().getParams()).map(p -> p.getJsonObject("query")).map( q -> q.getInteger("commitWithin")).orElse(null);
										if(softCommit == null && commitWithin == null)
											softCommit = true;
										if(softCommit)
											query.put("softCommit", softCommit);
										if(commitWithin != null)
											query.put("commitWithin", commitWithin);
										query.put("q", "*:*").put("fq", new JsonArray().add("pk:" + siteUser1.getPk())).put("var", new JsonArray().add("refresh:false"));
										params.put("query", query);
										JsonObject context = new JsonObject().put("params", params).put("user", Optional.ofNullable(siteRequest.getUser()).map(u -> u.attributes().getJsonObject("tokenPrincipal")).orElse(null));
										JsonObject json = new JsonObject().put("context", context);
										eventBus.request(vertxAddress, json, new DeliveryOptions().addHeader("action", postAction)).onSuccess(a -> {
											JsonObject responseBody = (JsonObject)a.body();
											siteRequest.setUserName(accessToken.getString("preferred_username"));
											siteRequest.setUserFirstName(accessToken.getString("given_name"));
											siteRequest.setUserLastName(accessToken.getString("family_name"));
											siteRequest.setUserEmail(accessToken.getString("email"));
											siteRequest.setUserId(accessToken.getString("sub"));
											siteRequest.setUserKey(Long.parseLong(responseBody.getString("pk")));
											siteRequest.setApiRequest_(apiRequest);
											siteRequest.setUserPrincipal(userPrincipal);
											promise.complete(siteRequest);
										}).onFailure(ex -> {
											LOG.error(String.format("postSiteUser failed. "), ex);
											promise.fail(ex);
										});
									} else {
										siteRequest.setUserName(siteUser1.getUserName());
										siteRequest.setUserFirstName(siteUser1.getUserFirstName());
										siteRequest.setUserLastName(siteUser1.getUserLastName());
										siteRequest.setUserKey(siteUser1.getPk());
										promise.complete((T)siteRequest);
									}
								}
							}).onFailure(ex -> {
								LOG.error(String.format("user failed. "), ex);
								promise.fail(ex);
							});
						} catch(Exception ex) {
							LOG.error(String.format("user failed. "), ex);
							promise.fail(ex);
						}
					}).onFailure(ex -> {
						LOG.error(String.format("user failed. ", ex));
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					oauth2AuthenticationProvider.refresh(token).onSuccess(user -> {
						serviceRequest.setUser(user.principal());
						user(serviceRequest, cSiteRequest, cSiteUser, vertxAddress, postAction, patchAction).onSuccess(siteRequest -> {
							promise.complete((T)siteRequest);
						}).onFailure(ex2 -> {
							LOG.error(String.format("user failed. ", ex2));
							promise.fail(ex2);
						});
					}).onFailure(ex2 -> {
						LOG.error(String.format("user failed. ", ex2));
						promise.fail(ex2);
					});
				});
			}
		} catch(Exception ex) {
			LOG.error(String.format("user failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Boolean userDefine(ComputateVertxSiteRequest siteRequest, JsonObject jsonObject, Boolean patch) {
		return false;
	}

	public void attributeArrayFuture(ComputateVertxSiteRequest siteRequest, Class<?> c1, Long pk1, Class<?> c2, String pk2, List<Future<?>> futures, String entityVar, Boolean inheritPk) {
		ApiRequest apiRequest = siteRequest.getApiRequest_();
		List<Long> pks = apiRequest.getPks();

		for(String l : Optional.ofNullable(siteRequest.getJsonObject().getJsonArray(entityVar)).orElse(new JsonArray()).stream().map(a -> (String)a).collect(Collectors.toList())) {
			if(l != null) {
				SearchList<ComputateVertxBaseModel> searchList = new SearchList<ComputateVertxBaseModel>();
				searchList.q("*:*");
				searchList.setStore(true);
				searchList.setC(c1);
				searchList.fq("classCanonicalNames_docvalues_strings:" + SearchTool.escapeQueryChars(c2.getCanonicalName()));
				searchList.fq((inheritPk ? "inheritPk_docvalues_string:" : "pk_docvalues_long:") + SearchTool.escapeQueryChars(l));
				searchList.promiseDeepSearchList(siteRequest).onSuccess(s -> {
					Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
					if(l2 != null) {
						futures.add(siteRequest.getSqlConnection().preparedQuery(String.format("UPDATE %s SET %s=$1 WHERE pk=$2", c1.getSimpleName(), entityVar)).execute(Tuple.of(pk1, l2)));
						if(!pks.contains(l2)) {
							pks.add(l2);
							apiRequest.getClasses().add(c2.getSimpleName());
						}
					}
				}).onFailure(ex -> {
					LOG.error("update %s failed. ", entityVar);
				});
			}
		}
	}

	///////////////
	// SqlUpdate //
	///////////////

	public class SqlUpdate {
		private Class<?> c1;
		private Class<?> c2;
		private String entityVar1;
		private String entityVar2;
		private Long pk1;
		private ApiRequest apiRequest;
		private List<Long> pks;
		private List<String> classes;
		private ComputateVertxSiteRequest siteRequest;

		public SqlUpdate(ComputateVertxSiteRequest siteRequest) {
			this.siteRequest = siteRequest;
			this.apiRequest = siteRequest.getApiRequest_();
			this.pks = apiRequest.getPks();
			this.classes = apiRequest.getClasses();
		}

		public SqlUpdate update(Class<? extends ComputateVertxBaseModel> c1, Long pk1) {
			this.c1 = c1;
			this.pk1 = pk1;
			return this;
		}

		public SqlUpdate insertInto(Class<? extends ComputateVertxBaseModel> c1, String entityVar1, Class<? extends ComputateVertxBaseModel> c2, String entityVar2) {
			this.c1 = c1;
			this.entityVar1 = entityVar1;
			this.c2 = c2;
			this.entityVar2 = entityVar2;
			return this;
		}

		public SqlUpdate deleteFrom(Class<? extends ComputateVertxBaseModel> c1, String entityVar1, Class<? extends ComputateVertxBaseModel> c2, String entityVar2) {
			this.c1 = c1;
			this.entityVar1 = entityVar1;
			this.c2 = c2;
			this.entityVar2 = entityVar2;
			return this;
		}

		public Future<Void> set(String entityVar1, Class<? extends ComputateVertxBaseModel> c2, Long pk2) {
			Promise<Void> promise = Promise.promise();
			if(pk2 == null) {
				promise.complete();
			} else {
				if(!pks.contains(pk2)) {
					pks.add(pk2);
					classes.add(c2.getSimpleName());
				}
				siteRequest.getSqlConnection().preparedQuery(String.format("UPDATE %s SET %s=$1 WHERE pk=$2", c1.getSimpleName(), entityVar1)).execute(Tuple.of(pk2, pk1)).onSuccess(a -> {
					promise.complete();
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}
			return promise.future();
		}

		public Future<Void> setToNull(String entityVar1, Class<? extends ComputateVertxBaseModel> c2, Long pk2) {
			Promise<Void> promise = Promise.promise();
			if(pk2 == null) {
				promise.complete();
			} else {
				if(!pks.contains(pk2)) {
					pks.add(pk2);
					classes.add(c2.getSimpleName());
				}
				siteRequest.getSqlConnection().preparedQuery(String.format("UPDATE %s SET %s=null WHERE pk=$1", c1.getSimpleName(), entityVar1)).execute(Tuple.of(pk1)).onSuccess(a -> {
					promise.complete();
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}
			return promise.future();
		}

		public Future<Void> values(Long pk1, Long pk2) {
			Promise<Void> promise = Promise.promise();
			if(pk2 == null) {
				promise.complete();
			} else {
				if(!pks.contains(pk2)) {
					pks.add(pk2);
					classes.add(c2.getSimpleName());
				}
				siteRequest.getSqlConnection().preparedQuery(String.format("INSERT INTO %s%s_%s%s(pk1, pk2) VALUES($1, $2)", c1.getSimpleName(), StringUtils.capitalize(entityVar1), c2.getSimpleName(), StringUtils.capitalize(entityVar2), entityVar2)).execute(Tuple.of(pk1, pk2)).onSuccess(a -> {
					promise.complete();
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}
			return promise.future();
		}

		public Future<Void> where(Long pk1, Long pk2) {
			Promise<Void> promise = Promise.promise();
			if(pk2 == null) {
				promise.complete();
			} else {
				if(!pks.contains(pk2)) {
					pks.add(pk2);
					classes.add(c2.getSimpleName());
				}
				siteRequest.getSqlConnection().preparedQuery(String.format("DELETE FROM %s%s_%s%s WHERE pk1=$1 AND pk2=$2", c1.getSimpleName(), StringUtils.capitalize(entityVar1), c2.getSimpleName(), StringUtils.capitalize(entityVar2), entityVar2)).execute(Tuple.of(pk1, pk2)).onSuccess(a -> {
					promise.complete();
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}
			return promise.future();
		}
	}

	public SqlUpdate sql(ComputateVertxSiteRequest siteRequest) {
		return new SqlUpdate(siteRequest);
	}

	/////////////////
	// SearchQuery //
	/////////////////

	public class SearchQuery {
		private ComputateVertxSiteRequest siteRequest;

		public SearchQuery(ComputateVertxSiteRequest siteRequest) {
			this.siteRequest = siteRequest;
		}

		public Future<Long> query(Class<? extends ComputateVertxBaseModel> c, String pk, Boolean inheritPk) {
			Promise<Long> promise = Promise.promise();
			if(pk != null) {
				SearchList<ComputateVertxBaseModel> searchList = new SearchList<ComputateVertxBaseModel>();
				searchList.q("*:*");
				searchList.setStore(true);
				searchList.setC(c);
				searchList.fq((inheritPk ? "inheritPk_docvalues_string:" : "pk_docvalues_long:") + pk);
				searchList.promiseDeepSearchList(siteRequest).onSuccess(s -> {
					Long l2 = Optional.ofNullable(searchList.getList().stream().findFirst().orElse(null)).map(a -> a.getPk()).orElse(null);
					promise.complete(l2);
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
			return promise.future();
		}
	}

	public SearchQuery search(ComputateVertxSiteRequest siteRequest) {
		return new SearchQuery(siteRequest);
	}

	public Future<ServiceResponse> response200Search(SearchRequest searchRequest, SolrResponse responseSearch, JsonObject json) {
		Promise<ServiceResponse> promise = Promise.promise();
		try {
			List<SolrResponse.Doc> solrDocuments = responseSearch.getResponse().getDocs();
			Long searchInMillis = Long.valueOf(responseSearch.getResponseHeader().getqTime());
			Long startNum = searchRequest.getStart();
			Long foundNum = responseSearch.getResponse().getNumFound();
			Integer returnedNum = responseSearch.getResponse().getDocs().size();
			String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
			String nextCursorMark = responseSearch.getNextCursorMark();
			String exceptionSearch = Optional.ofNullable(responseSearch.getError()).map(error -> error.getMsg()).orElse(null);
			List<String> fls = searchRequest.getFields();

			json.put("startNum", startNum);
			json.put("foundNum", foundNum);
			json.put("returnedNum", returnedNum);
			if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
				json.put("searchTime", searchTime);
			}
			Optional.ofNullable(responseSearch.getStats()).map(s -> s.getStatsFields()).map(s -> s.getFields()).ifPresent(stats -> {
				JsonObject stats2 = new JsonObject();
				stats.forEach((key, val) -> {
					String var = StringUtils.substringBefore(key, "_");
					stats2.put(var, val);
				});
				json.put("stats", stats2);
			});
			Optional.ofNullable(responseSearch.getFacetCounts()).ifPresent(facetCounts -> {
				JsonObject facetCounts2 = new JsonObject();
				Optional.ofNullable(facetCounts.getFacetFields()).map(f -> f.getFacets()).ifPresent(facets -> {
					JsonObject facets2 = new JsonObject();
					for(SolrResponse.FacetField facetField : facets.values()) {
						String facetFieldVar = StringUtils.substringBefore(facetField.getName(), "_");
						JsonObject facetFieldCounts = new JsonObject();
						facets2.put(facetFieldVar, facetFieldCounts);
						facetField.getCounts().forEach((name, count) -> {
							facetFieldCounts.put(name, count);
						});
					}
					facetCounts2.put("facet_fields", facets2);
				});
				Optional.ofNullable(facetCounts.getFacetHeatMaps()).map(f -> f.getFacets()).ifPresent(facets -> {
					JsonObject facets2 = new JsonObject();
					for(SolrResponse.FacetField facetField : facets.values()) {
						String facetFieldVar = StringUtils.substringBefore(facetField.getName(), "_");
						JsonObject facetFieldCounts = new JsonObject();
						facets2.put(facetFieldVar, facetFieldCounts);
						facetField.getCounts().forEach((name, count) -> {
							facetFieldCounts.put(name, count);
						});
					}
					facetCounts2.put("facet_heatmaps", facets2);
				});
				Optional.ofNullable(facetCounts.getFacetIntervals()).map(f -> f.getFacets()).ifPresent(facets -> {
					JsonObject facets2 = new JsonObject();
					for(SolrResponse.FacetField facetField : facets.values()) {
						String facetFieldVar = StringUtils.substringBefore(facetField.getName(), "_");
						JsonObject facetFieldCounts = new JsonObject();
						facets2.put(facetFieldVar, facetFieldCounts);
						facetField.getCounts().forEach((name, count) -> {
							facetFieldCounts.put(name, count);
						});
					}
					facetCounts2.put("facet_intervals", facets2);
				});
				Optional.ofNullable(facetCounts.getFacetPivot()).map(f -> f.getPivotMap()).ifPresent(facets -> {
					JsonObject facets2 = new JsonObject();
					JsonObject pivotMap = new JsonObject();
//					for(SolrResponse.Pivot pivot : facets.values()) {
//						String[] varsIndexed = pivot.getName().trim().split(",");
//						String[] entityVars = new String[varsIndexed.length];
//						for(Integer i = 0; i < entityVars.length; i++) {
//							String entityIndexed = varsIndexed[i];
//							entityVars[i] = StringUtils.substringBefore(entityIndexed, "_docvalues_");
//						}
//						JsonArray pivotArray = new JsonArray();
//						facets2.put(StringUtils.join(entityVars, ","), pivotArray);
//						responsePivotSearch(pivot.getPivotList(), pivotArray);
//					}
					responsePivotSearch(facets, pivotMap);
					facetCounts2.put("facet_pivot", facets2);
				});
				Optional.ofNullable(facetCounts.getFacetQueries()).map(f -> f.getFacets()).ifPresent(facets -> {
					JsonObject facets2 = new JsonObject();
					facetCounts2.put("facet_queries", facets2);
				});
				Optional.ofNullable(facetCounts.getFacetRanges()).map(f -> f.getRanges()).ifPresent(facets -> {
					JsonObject facets2 = new JsonObject();
					for(SolrResponse.FacetRange facetField : facets.values()) {
						JsonObject rangeFacetJson = new JsonObject();
						String rangeFacetVar = StringUtils.substringBefore(facetField.getName(), "_docvalues_");
						facets2.put(rangeFacetVar, rangeFacetJson);
						JsonObject rangeFacetCountsMap = new JsonObject();
						rangeFacetJson.put("counts", rangeFacetCountsMap);
						facetField.getCounts().forEach((name, count) -> {
							rangeFacetCountsMap.put(name, count);
						});
					}
					facetCounts2.put("facet_ranges", facets2);
				});
				json.put("facet_counts", facetCounts2);
			});
			if(nextCursorMark != null) {
				json.put("nextCursorMark", nextCursorMark);
			}
			if(exceptionSearch != null) {
				json.put("exceptionSearch", exceptionSearch);
			}
			promise.complete(ServiceResponse.completedWithJson(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily())));
		} catch(Exception ex) {
			LOG.error(String.format("response200Search failed. "), ex);
			promise.fail(ex);
		}
		return promise.future();
	}
	public void responsePivotSearch(Map<String, SolrResponse.Pivot> pivots, JsonObject pivotMap) {
		if(pivots != null) {
			for(SolrResponse.Pivot pivotField : pivots.values()) {
				String entityIndexed = pivotField.getField();
				String entityVar = StringUtils.substringBefore(entityIndexed, "_docvalues_");
				JsonObject pivotJson = new JsonObject();
				pivotMap.put(pivotField.getName(), pivotJson);
				pivotJson.put("field", entityVar);
				pivotJson.put("value", pivotField.getValue());
				pivotJson.put("count", pivotField.getCount());
				Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
				if(pivotRanges != null) {
					JsonObject rangeJson = new JsonObject();
					pivotJson.put("ranges", rangeJson);
					for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
						JsonObject rangeFacetJson = new JsonObject();
						String rangeFacetVar = StringUtils.substringBefore(rangeFacet.getName(), "_docvalues_");
						rangeJson.put(rangeFacetVar, rangeFacetJson);
						JsonObject rangeFacetCountsObject = new JsonObject();
						rangeFacetJson.put("counts", rangeFacetCountsObject);
						rangeFacet.getCounts().forEach((value, count) -> {
							rangeFacetCountsObject.put(value, count);
						});
					}
				}
				Optional.ofNullable(pivotField.getPivotMap()).ifPresent(pivotFields2 -> {
					JsonObject pivotMap2 = new JsonObject();
					pivotJson.put("pivot", pivotMap2);
					responsePivotSearch(pivotFields2, pivotMap2);
				});
			}
		}
	}
}
