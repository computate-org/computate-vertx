package org.computate.vertx.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.tool.SearchTool;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
import org.computate.vertx.model.user.ComputateVertxSiteUser;
import org.computate.vertx.model.user.ComputateVertxSiteUserEnUSApiServiceImpl;
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
public class BaseApiServiceImpl {

	protected static final Logger LOG = LoggerFactory.getLogger(BaseApiServiceImpl.class);

	protected EventBus eventBus;

	protected JsonObject config;

	protected WorkerExecutor workerExecutor;

	protected PgPool pgPool;

	protected WebClient webClient;

	protected OAuth2Auth oauth2AuthenticationProvider;

	protected AuthorizationProvider authorizationProvider;

	protected HandlebarsTemplateEngine templateEngine;

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

	public ComputateVertxSiteRequest generateComputateVertxSiteRequest(User user, ServiceRequest serviceRequest) {
		return generateComputateVertxSiteRequest(user, serviceRequest, serviceRequest.getParams().getJsonObject("body"));
	}

	public ComputateVertxSiteRequest generateComputateVertxSiteRequest(User user, ServiceRequest serviceRequest, JsonObject body) {
		ComputateVertxSiteRequest siteRequest = new ComputateVertxSiteRequest();
		siteRequest.setWebClient(webClient);
		siteRequest.setJsonObject(body);
		siteRequest.setUser(user);
		siteRequest.setConfig(config);
		siteRequest.setServiceRequest(serviceRequest);
		siteRequest.initDeepComputateVertxSiteRequest(siteRequest);

		return siteRequest;
	}

	public Future<ComputateVertxSiteRequest> user(ServiceRequest serviceRequest) {
		Promise<ComputateVertxSiteRequest> promise = Promise.promise();
		try {
			JsonObject userJson = serviceRequest.getUser();
			if(userJson == null) {
				ComputateVertxSiteRequest siteRequest = generateComputateVertxSiteRequest(null, serviceRequest);
				promise.complete(siteRequest);
			} else {
				User token = User.create(userJson);
				oauth2AuthenticationProvider.authenticate(token.principal()).onSuccess(user -> {
					user.attributes().put("accessToken", user.principal());
					authorizationProvider.getAuthorizations(user).onSuccess(b -> {
						try {
							JsonObject userAttributes = user.attributes();
							JsonObject accessToken = userAttributes.getJsonObject("accessToken");
							String userId = accessToken.getString("sub");
							ComputateVertxSiteRequest siteRequest = generateComputateVertxSiteRequest(user, serviceRequest);
							SearchList<ComputateVertxSiteUser> searchList = new SearchList<ComputateVertxSiteUser>();
							searchList.q("*:*");
							searchList.setStore(true);
							searchList.setC(ComputateVertxSiteUser.class);
							searchList.fq("userId_docvalues_string:" + SearchTool.escapeQueryChars(userId));
							searchList.promiseDeepSearchList(siteRequest).onSuccess(c -> {
								ComputateVertxSiteUser siteUser1 = searchList.getList().stream().findFirst().orElse(null);
								ComputateVertxSiteUserEnUSApiServiceImpl userService = new ComputateVertxSiteUserEnUSApiServiceImpl(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);

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
									siteRequest2.initDeepComputateVertxSiteRequest(siteRequest);

									ApiRequest apiRequest = new ApiRequest();
									apiRequest.setRows(1L);
									apiRequest.setNumFound(1L);
									apiRequest.setNumPATCH(0L);
									apiRequest.initDeepApiRequest(siteRequest2);
									siteRequest2.setApiRequest_(apiRequest);

									userService.postComputateVertxSiteUserFuture(siteRequest2, false).onSuccess(siteUser -> {
										siteRequest.setUserName(accessToken.getString("preferred_username"));
										siteRequest.setUserFirstName(accessToken.getString("given_name"));
										siteRequest.setUserLastName(accessToken.getString("family_name"));
										siteRequest.setUserEmail(accessToken.getString("email"));
										siteRequest.setUserId(accessToken.getString("sub"));
										siteRequest.setUserKey(siteUser.getPk());
										promise.complete(siteRequest);
									}).onFailure(ex -> {
										error(siteRequest, null, ex);
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
										siteRequest2.initDeepComputateVertxSiteRequest(siteRequest);
										siteUser1.setSiteRequest_(siteRequest2);

										ApiRequest apiRequest = new ApiRequest();
										apiRequest.setRows(1L);
										apiRequest.setNumFound(1L);
										apiRequest.setNumPATCH(0L);
										apiRequest.initDeepApiRequest(siteRequest2);
										siteRequest2.setApiRequest_(apiRequest);

										userService.patchComputateVertxSiteUserFuture(siteUser1, false).onSuccess(siteUser2 -> {
											siteRequest.setUserName(siteUser2.getUserName());
											siteRequest.setUserFirstName(siteUser2.getUserFirstName());
											siteRequest.setUserLastName(siteUser2.getUserLastName());
											siteRequest.setUserKey(siteUser2.getPk());
											promise.complete(siteRequest);
										}).onFailure(ex -> {
											promise.fail(ex);
										});
									} else {
										siteRequest.setUserName(siteUser1.getUserName());
										siteRequest.setUserFirstName(siteUser1.getUserFirstName());
										siteRequest.setUserLastName(siteUser1.getUserLastName());
										siteRequest.setUserKey(siteUser1.getPk());
										promise.complete(siteRequest);
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
						user(serviceRequest).onSuccess(siteRequest -> {
							promise.complete(siteRequest);
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
				searchList.setC(ComputateVertxBaseModel.class);
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
				siteRequest.getSqlConnection().preparedQuery(String.format("UPDATE %s SET %s=$1 WHERE pk=null", c1.getSimpleName(), entityVar1)).execute(Tuple.of(pk1)).onSuccess(a -> {
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
}
