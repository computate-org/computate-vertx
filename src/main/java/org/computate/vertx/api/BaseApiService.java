/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.vertx.api;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.curator.shaded.com.google.common.base.Strings;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.computate.i18n.I18n;
import org.computate.search.request.SearchRequest;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.tool.SearchTool;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.model.base.ComputateBaseModel;
import org.computate.vertx.model.user.ComputateSiteUser;
import org.computate.vertx.openapi.ComputateOAuth2AuthHandlerImpl;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.result.base.ComputateBaseResult;
import org.computate.vertx.search.list.SearchList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.MultiMap;
import io.vertx.core.Promise;
import io.vertx.core.WorkerExecutor;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.http.HttpResponseExpectation;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.http.impl.headers.HeadersMultiMap;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.impl.JsonUtil;
import io.vertx.ext.auth.User;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.api.service.ServiceResponse;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.predicate.ResponsePredicate;
import io.vertx.kafka.client.producer.KafkaProducer;
import io.vertx.mqtt.MqttClient;
import io.vertx.amqp.AmqpClient;
import io.vertx.amqp.AmqpSender;
import io.vertx.rabbitmq.RabbitMQClient;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Pool;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.Tuple;
import jinjava.org.jsoup.Jsoup;
import jinjava.org.jsoup.nodes.Document;
import io.vertx.config.yaml.YamlProcessor;
import io.vertx.core.Vertx;

import static org.apache.commons.lang3.Validate.notNull;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.computate.search.tool.TimeTool;

abstract class BaseApiService implements BaseApiServiceInterface {

  protected static final Logger LOG = LoggerFactory.getLogger(BaseApiServiceImpl.class);

  public final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss VV");
  public static final String importTimerScheduling = "Scheduling the %s import at %s";
  public static final String importTimerSkip = "Skip importing %s data. ";
  public static final String importTimerFail = "Scheduling the import of %s data failed. ";
  public static final String importDataFail = "Importing all %s data failed. ";
  public static final String importDataComplete = "Importing all %s data completed. Search the imported data here: %s ";
  public static final String importDataFileFail = "Importing %s data file failed. ";
  public static final String importDataFileComplete = "Importing %s data file completed. ";
  public static final String importModelComplete = "Importing page completed: %s";
  public static final String importModelFail = "Importing page failed: %s";

  ComputateOAuth2AuthHandlerImpl oauth2AuthHandler;

  protected Vertx vertx;

  protected EventBus eventBus;

  protected JsonObject config;

  protected WorkerExecutor workerExecutor;

  protected Pool pgPool;

  protected KafkaProducer<String, String> kafkaProducer;

  protected MqttClient mqttClient;

  protected AmqpClient amqpClient;

  protected AmqpSender amqpSender;

  protected RabbitMQClient rabbitmqClient;

  protected WebClient webClient;

  protected OAuth2Auth oauth2AuthenticationProvider;

  protected AuthorizationProvider authorizationProvider;

  protected Jinjava jinjava;

  protected JsonObject i18n;

  public void setOauth2AuthHandler(ComputateOAuth2AuthHandlerImpl oauth2AuthHandler) {
    this.oauth2AuthHandler = oauth2AuthHandler;
  }

  public void setVertx(Vertx vertx) {
    this.vertx = vertx;
  }

  public void setEventBus(EventBus eventBus) {
    this.eventBus = eventBus;
  }

  public void setConfig(JsonObject config) {
    this.config = config;
  }

  public void setWorkerExecutor(WorkerExecutor workerExecutor) {
    this.workerExecutor = workerExecutor;
  }

  public void setPgPool(Pool pgPool) {
    this.pgPool = pgPool;
  }

  public void setKafkaProducer(KafkaProducer<String, String> kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  public void setMqttClient(MqttClient mqttClient) {
    this.mqttClient = mqttClient;
  }

  public void setAmqpClient(AmqpClient amqpClient) {
    this.amqpClient = amqpClient;
  }

  public void setAmqpSender(AmqpSender amqpSender) {
    this.amqpSender = amqpSender;
  }

  public void setRabbitmqClient(RabbitMQClient rabbitmqClient) {
    this.rabbitmqClient = rabbitmqClient;
  }

  public void setWebClient(WebClient webClient) {
    this.webClient = webClient;
  }

  public void setOauth2AuthenticationProvider(OAuth2Auth oauth2AuthenticationProvider) {
    this.oauth2AuthenticationProvider = oauth2AuthenticationProvider;
  }

  public void setAuthorizationProvider(AuthorizationProvider authorizationProvider) {
    this.authorizationProvider = authorizationProvider;
  }

  public void setJinjava(Jinjava jinjava) {
    this.jinjava = jinjava;
  }

  public void setI18n(JsonObject i18n) {
    this.i18n = i18n;
  }

  // General //

  public void error(ComputateSiteRequest siteRequest, Handler<AsyncResult<ServiceResponse>> eventHandler, Throwable ex) {
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
    if(eventHandler != null)
      eventHandler.handle(Future.succeededFuture(responseOperation));
  }

  public ServiceRequest generateServiceRequest(RoutingContext ctx) {
    ServiceRequest serviceRequest = new ServiceRequest(
        new JsonObject().put("path", JsonObject.mapFrom(ctx.pathParams())).put("query", JsonObject.mapFrom(ctx.queryParams())).put("cookie", JsonObject.mapFrom(ctx.cookieMap()))
            , ctx.request().headers()
            , Optional.ofNullable(ctx.user()).map(u -> u.principal()).orElse(null)
            , new JsonObject()
        );
    return serviceRequest;
  }

  public <T extends ComputateSiteRequest> T generateSiteRequest(User user, JsonObject userPrincipal, ServiceRequest serviceRequest, Class<T> clazz) {
    return generateSiteRequest(user, userPrincipal, serviceRequest, Optional.ofNullable(serviceRequest.getParams().getValue("body")).map(v -> (v instanceof JsonObject ? (JsonObject)v : null)).orElse(null), clazz);
  }

  public <T extends ComputateSiteRequest> T generateSiteRequest(User user, JsonObject userPrincipal, ServiceRequest serviceRequest, JsonObject body, Class<T> clazz) {
    T siteRequest = null;
    try {
      siteRequest = clazz.getDeclaredConstructor().newInstance();
      siteRequest.setWebClient(webClient);
      siteRequest.setJsonObject(body);
      siteRequest.setUserPrincipal(userPrincipal);
      siteRequest.setUser(user);
      siteRequest.setConfig(config);
      siteRequest.setServiceRequest(serviceRequest);
      siteRequest.setI18n(i18n);
      siteRequest.setSiteRequest_(siteRequest);
      siteRequest.initDeepForClass();
    } catch (Exception ex) {
      ExceptionUtils.rethrow(ex);
    }

    return siteRequest;
  }

  public <T extends ComputateSiteRequest> Future<JsonObject> getUserPrincipal(ServiceRequest serviceRequest, Class<T> cSiteRequest, Class<?> cSiteUser, String vertxAddress, String postAction, String patchAction) {
    Promise<JsonObject> promise = Promise.promise();
    try {
      JsonObject userPrincipal = serviceRequest.getUser();
      if(userPrincipal == null) {
        promise.complete();
      } else {
        String accessToken = userPrincipal.getString("access_token");
        if(accessToken == null) {
          promise.complete(userPrincipal);
        } else {
          promise.complete(userPrincipal);
//          JsonObject result = new JsonObject();
//          result.put("access_token", accessToken);
//          promise.complete(result);
        }
      }
    } catch(Exception ex) {
      LOG.error(String.format("user failed. "), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public <T extends ComputateSiteRequest> Future<User> getTokenUser(ServiceRequest serviceRequest, Class<T> cSiteRequest, Class<?> cSiteUser, String vertxAddress, String postAction, String patchAction, Boolean refresh) {
    Promise<User> promise = Promise.promise();
    try {
      JsonObject userPrincipal = serviceRequest.getUser();
      if(userPrincipal == null) {
        promise.complete();
      } else {
        String accessToken = userPrincipal.getString("access_token");
        if(accessToken == null) {
            promise.complete(User.create(userPrincipal));
        } else {
          User token = User.create(userPrincipal);
          oauth2AuthenticationProvider.authenticate(token.principal()).onSuccess(user -> {
            promise.complete(user);
          }).onFailure(ex -> {
            if(refresh) {
              if(!"GET".equals(Optional.ofNullable(serviceRequest.getExtra()).map(s -> s.getString("method")).orElse(null))) {
                // For requests that are not GET requests, we want to obtain a refresh token if available, 
                // so that the request does not fail, and a logout cannot be performed with a non GET method. 
                oauth2AuthenticationProvider.refresh(token).onSuccess(user -> {
                  serviceRequest.setUser(user.principal());
                  getTokenUser(serviceRequest, cSiteRequest, cSiteUser, vertxAddress, postAction, patchAction, refresh).onSuccess(user2 -> {
                    promise.complete(user2);
                  }).onFailure(ex2 -> {
                    promise.fail(ex2);
                  });
                }).onFailure(ex2 -> {
                  LOG.error(String.format("user failed. ", ex2));
                  promise.fail(ex2);
                });
              } else {
                // For GET requests, we can fails with an "Inactive Token" RuntimeException 
                // to force an application session logout to obtain a new token. 
                RuntimeException ex2 = new RuntimeException("Inactive Token", ex);
                promise.fail(ex2);
              }
            } else {
              RuntimeException ex2 = new RuntimeException("Inactive Token", ex);
              promise.fail(ex2);
            }
          });
        }
      }
    } catch(Exception ex) {
      LOG.error(String.format("user failed. "), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  private <T extends ComputateSiteUser> Future<T> getDbUser(ComputateSiteRequest siteRequest, String userId, Class<?> cSiteUser) {
    Promise<T> promise = Promise.promise();
    Promise<T> promise1 = Promise.promise();
    try {
      T siteUser = (T)cSiteUser.getDeclaredConstructor().newInstance();
      siteUser.setSiteRequest_(siteRequest);
      siteUser.persistForClass("userId", userId);
      promise.complete(siteUser);
    } catch(Exception ex) {
      LOG.error(String.format("getDbUser failed. "), ex);
      promise1.fail(ex);
    }
    return promise.future();
  }

  public <T extends ComputateSiteRequest> Future<T> user(ServiceRequest serviceRequest, Class<T> cSiteRequest, Class<?> cSiteUser, String vertxAddress, String postAction, String patchAction, Boolean publicRead) {
    return userRefresh(serviceRequest, cSiteRequest, cSiteUser, vertxAddress, postAction, patchAction, publicRead, false);
  }

  public <T extends ComputateSiteRequest> Future<T> userRefresh(ServiceRequest serviceRequest, Class<T> cSiteRequest, Class<?> cSiteUser, String vertxAddress, String postAction, String patchAction, Boolean publicRead, Boolean refresh) {
    Promise<T> promise = Promise.promise();
    try {
      getUserPrincipal(serviceRequest, cSiteRequest, cSiteUser, vertxAddress, postAction, patchAction).onSuccess(userPrincipal -> {
        getTokenUser(serviceRequest, cSiteRequest, cSiteUser, vertxAddress, postAction, patchAction, refresh).onSuccess(user -> {
          try {
            if(user == null) {
              ComputateSiteRequest siteRequest = generateSiteRequest(null, null, serviceRequest, cSiteRequest);
              siteRequest.setPublicRead(publicRead);
              siteRequest.setSessionId(Optional.ofNullable(serviceRequest.getParams()).map(params -> Optional.ofNullable(params.getJsonObject("cookie")).map(cookie -> cookie.getString("vertx-web.session")).orElse(null)).orElse(null));
              siteRequest.setSessionIdBefore(Optional.ofNullable(serviceRequest.getParams()).map(params -> Optional.ofNullable(params.getJsonObject("cookie")).map(cookie -> cookie.getString("sessionIdBefore")).orElse(null)).orElse(null));
              promise.complete((T)siteRequest);
            } else {
              user.attributes().put("principal", userPrincipal);
              JsonObject userAttributes = user.attributes();
              JsonObject accessToken = Optional.ofNullable(userAttributes.getJsonObject("accessToken")).orElse(user.principal());
              user.attributes().put("accessToken", accessToken);
              String userId = accessToken.getString("sub");
              T siteRequest = generateSiteRequest(user, userPrincipal, serviceRequest, cSiteRequest);
              siteRequest.setPublicRead(publicRead);
              siteRequest.setSessionId(Optional.ofNullable(serviceRequest.getParams()).map(params -> Optional.ofNullable(params.getJsonObject("cookie")).map(cookie -> cookie.getString("vertx-web.session")).orElse(null)).orElse(null));
              siteRequest.setSessionIdBefore(Optional.ofNullable(serviceRequest.getParams()).map(params -> Optional.ofNullable(params.getJsonObject("cookie")).map(cookie -> cookie.getString("sessionIdBefore")).orElse(null)).orElse(null));

              getDbUser(siteRequest, userId, cSiteUser).onSuccess(siteUser1 -> {
                siteRequest.setSiteUser(siteUser1);
                siteUser1.setCustomerProfileId(accessToken.getString("customerProfileId"));
                siteUser1.setUserName(accessToken.getString("preferred_username"));
                siteUser1.setUserFirstName(accessToken.getString("given_name"));
                siteUser1.setUserLastName(accessToken.getString("family_name"));
                siteUser1.setUserFullName(accessToken.getString("name"));
                siteUser1.setUserEmail(accessToken.getString("email"));
                // siteUser1.setSeeArchived(accessToken.getString("seeArchived"));

                Promise<Boolean> promise2 = Promise.promise();
                userDefine(promise2, siteRequest, null, true);
                promise2.future().onSuccess(define -> {
  
                  ApiRequest apiRequest = new ApiRequest();
                  apiRequest.setRows(1L);
                  apiRequest.setNumFound(1L);
                  apiRequest.setNumPATCH(0L);
                  apiRequest.initDeepApiRequest(siteRequest);
                  siteRequest.setApiRequest_(apiRequest);

                  siteRequest.setCustomerProfileId(accessToken.getString("customerProfileId"));
                  siteRequest.setUserName(accessToken.getString("preferred_username"));
                  siteRequest.setUserFirstName(accessToken.getString("given_name"));
                  siteRequest.setUserLastName(accessToken.getString("family_name"));
                  siteRequest.setUserEmail(accessToken.getString("email"));
                  siteRequest.setUserId(accessToken.getString("sub"));
                  siteRequest.setGroups(Optional.ofNullable(accessToken.getJsonArray("groups")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
                  siteRequest.setApiRequest_(apiRequest);
                  siteRequest.setUserPrincipal(userPrincipal);
                  siteRequest.setSiteUser(siteUser1);
                  siteRequest.setPublicRead(publicRead);
                  promise.complete(siteRequest);
                }).onFailure(ex -> {
                  LOG.error(String.format("user failed. "), ex);
                  promise.fail(ex);
                });
              }).onFailure(ex -> {
                LOG.error(String.format("user failed. "), ex);
                promise.fail(ex);
              });
            }
          } catch(Exception ex) {
            LOG.error(String.format("user failed. "), ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          promise.fail(ex);
        });
      }).onFailure(ex -> {
        LOG.error(String.format("user failed. "), ex);
        promise.tryFail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("user failed. "), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public void userDefine(Promise<Boolean> promise, ComputateSiteRequest siteRequest, JsonObject jsonObject, Boolean patch) {
    promise.complete(false);
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
    private List<String> solrIds;
    private List<String> classes;
    private ComputateSiteRequest siteRequest;

    public SqlUpdate(ComputateSiteRequest siteRequest) {
      this.siteRequest = siteRequest;
      this.apiRequest = siteRequest.getApiRequest_();
      this.solrIds = apiRequest.getSolrIds();
      this.classes = apiRequest.getClasses();
    }

    public SqlUpdate update(Class<? extends ComputateBaseModel> c1, Long pk1) {
      this.c1 = c1;
      this.pk1 = pk1;
      return this;
    }

    public SqlUpdate insertInto(Class<? extends ComputateBaseModel> c1, String entityVar1, Class<? extends ComputateBaseModel> c2, String entityVar2) {
      this.c1 = c1;
      this.entityVar1 = entityVar1;
      this.c2 = c2;
      this.entityVar2 = entityVar2;
      return this;
    }

    public SqlUpdate deleteFrom(Class<? extends ComputateBaseModel> c1, String entityVar1, Class<? extends ComputateBaseModel> c2, String entityVar2) {
      this.c1 = c1;
      this.entityVar1 = entityVar1;
      this.c2 = c2;
      this.entityVar2 = entityVar2;
      return this;
    }

    public Future<Void> set(String entityVar1, Class<?> c2, String solrId2, Object val) {
      Promise<Void> promise = Promise.promise();
      if(solrId2 == null) {
        promise.complete();
      } else {
        if(!solrIds.contains(solrId2)) {
          solrIds.add(solrId2);
          classes.add(c2.getSimpleName());
        }
        siteRequest.getSqlConnection().preparedQuery(String.format("UPDATE %s SET %s=$1 WHERE pk=$2", c1.getSimpleName(), entityVar1)).execute(Tuple.of(val, pk1)).onSuccess(a -> {
          promise.complete();
        }).onFailure(ex -> {
          promise.fail(ex);
        });
      }
      return promise.future();
    }

    public Future<Void> setToNull(String entityVar1, Class<?> c2, String solrId2) {
      Promise<Void> promise = Promise.promise();
      if(solrId2 != null) {
        if(!solrIds.contains(solrId2)) {
          solrIds.add(solrId2);
          classes.add(c2.getSimpleName());
        }
      }
      siteRequest.getSqlConnection().preparedQuery(String.format("UPDATE %s SET %s=null WHERE pk=$1", c1.getSimpleName(), entityVar1)).execute(Tuple.of(pk1)).onSuccess(a -> {
        promise.complete();
      }).onFailure(ex -> {
        promise.fail(ex);
      });
      return promise.future();
    }

    public Future<Void> relateValues(Long pk1, Long pk2, String solrId2) {
      Promise<Void> promise = Promise.promise();
      if(solrId2 == null) {
        promise.complete();
      } else {
        if(!solrIds.contains(solrId2)) {
          solrIds.add(solrId2);
          classes.add(c2.getSimpleName());
        }
        siteRequest.getSqlConnection().preparedQuery(String.format("INSERT INTO %s%s_%s%s(pk1, pk2) VALUES($1, $2) ON CONFLICT DO NOTHING", c1.getSimpleName(), StringUtils.capitalize(entityVar1), c2.getSimpleName(), StringUtils.capitalize(entityVar2), entityVar2)).execute(Tuple.of(pk1, pk2)).onSuccess(a -> {
          promise.complete();
        }).onFailure(ex -> {
          promise.fail(ex);
        });
      }
      return promise.future();
    }

    public Future<Void> unrelateValues(Long pk1, Long pk2, String solrId2) {
      Promise<Void> promise = Promise.promise();
      if(pk2 == null) {
        promise.complete();
      } else {
        if(!solrIds.contains(solrId2)) {
          solrIds.add(solrId2);
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

    public Future<Void> where(Long pk1, Long pk2, String solrId2) {
      Promise<Void> promise = Promise.promise();
      if(pk2 == null) {
        promise.complete();
      } else {
        if(!solrIds.contains(solrId2)) {
          solrIds.add(solrId2);
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

  public SqlUpdate sql(ComputateSiteRequest siteRequest) {
    return new SqlUpdate(siteRequest);
  }

  /////////////////
  // SearchQuery //
  /////////////////

  public class ResultSearchQuery {
    private ComputateSiteRequest siteRequest;

    public ResultSearchQuery(ComputateSiteRequest siteRequest) {
      this.siteRequest = siteRequest;
    }

    public Future<ComputateBaseResult> query(String idSearchVar, Class<?> c, String id) {
      Promise<ComputateBaseResult> promise = Promise.promise();
      if(id != null) {
        SearchList<ComputateBaseResult> searchList = new SearchList<ComputateBaseResult>();
        searchList.q("*:*");
        searchList.setStore(true);
        searchList.setC(c);
        searchList.fq(idSearchVar + ":" + id);
        searchList.promiseDeepSearchList(siteRequest).onSuccess(s -> {
          promise.complete(searchList.getList().stream().findFirst().orElse(null));
        }).onFailure(ex -> {
          promise.fail(ex);
        });
      } else {
        promise.complete();
      }
      return promise.future();
    }
  }

  public class ModelSearchQuery {
    private ComputateSiteRequest siteRequest;

    public ModelSearchQuery(ComputateSiteRequest siteRequest) {
      this.siteRequest = siteRequest;
    }

    public Future<ComputateBaseModel> query(String idSearchVar, Class<?> c, String id) {
      Promise<ComputateBaseModel> promise = Promise.promise();
      if(id != null) {
        SearchList<ComputateBaseModel> searchList = new SearchList<ComputateBaseModel>();
        searchList.q("*:*");
        searchList.setStore(true);
        searchList.setC(c);
        searchList.fq(idSearchVar + ":" + id);
        searchList.promiseDeepSearchList(siteRequest).onSuccess(s -> {
          promise.complete(searchList.getList().stream().findFirst().orElse(null));
        }).onFailure(ex -> {
          promise.fail(ex);
        });
      } else {
        promise.complete();
      }
      return promise.future();
    }
  }

  public ResultSearchQuery searchResult(ComputateSiteRequest siteRequest) {
    return new ResultSearchQuery(siteRequest);
  }

  public ModelSearchQuery searchModel(ComputateSiteRequest siteRequest) {
    return new ModelSearchQuery(siteRequest);
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
          JsonObject values = JsonObject.mapFrom(val);
          String var = searchVar(key);
          values.remove("name");
          values.put("var", var);
          stats2.put(var, values);
        });
        json.put("stats", stats2);
      });
      Optional.ofNullable(responseSearch.getFacetCounts()).ifPresent(facetCounts -> {
        JsonObject facetCounts2 = new JsonObject();
        Optional.ofNullable(facetCounts.getFacetFields()).map(f -> f.getFacets()).ifPresent(facets -> {
          JsonObject facets2 = new JsonObject();
          for(SolrResponse.FacetField facetField : facets.values()) {
            String facetFieldVar = searchVar(facetField.getName());
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
            String facetFieldVar = searchVar(facetField.getName());
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
            String facetFieldVar = searchVar(facetField.getName());
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
//          for(SolrResponse.Pivot pivot : facets.values()) {
//            String[] varsIndexed = pivot.getName().trim().split(",");
//            String[] entityVars = new String[varsIndexed.length];
//            for(Integer i = 0; i < entityVars.length; i++) {
//              String entityIndexed = varsIndexed[i];
//              entityVars[i] = searchVar(entityIndexed);
//            }
//            facets2.put(StringUtils.join(entityVars, ","), pivotMap);
//            responsePivotSearch(pivot.getPivotMap(), pivotMap);
//          }
          responsePivotSearch(facets, pivotMap);
          facetCounts2.put("facet_pivot", pivotMap);
        });
        Optional.ofNullable(facetCounts.getFacetQueries()).map(f -> f.getFacets()).ifPresent(facets -> {
          JsonObject facets2 = new JsonObject();
          facetCounts2.put("facet_queries", facets2);
        });
        Optional.ofNullable(facetCounts.getFacetRanges()).map(f -> f.getRanges()).ifPresent(facets -> {
          JsonObject facets2 = new JsonObject();
          for(SolrResponse.FacetRange facetField : facets.values()) {
            JsonObject rangeFacetJson = new JsonObject();
            String rangeFacetVar = searchVar(facetField.getName());
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
        String entityVar = searchVar(entityIndexed);
        String pivotValue = pivotField.getValue();
        JsonObject pivotJson = new JsonObject();
        pivotJson.put("var", entityVar);
        if(pivotValue == null) {
          pivotMap.put(entityVar, pivotJson);
        } else {
          pivotJson.put("count", pivotField.getCount());
          pivotMap.put(pivotValue, pivotJson);
          Collection<SolrResponse.PivotRange> pivotRanges = pivotField.getRanges().values();
          if(pivotRanges != null) {
            JsonObject rangeJson = new JsonObject();
            pivotJson.put("ranges", rangeJson);
            for(SolrResponse.PivotRange rangeFacet : pivotRanges) {
              JsonObject rangeFacetJson = new JsonObject();
              String rangeFacetVar = searchVar(rangeFacet.getName());
              rangeJson.put(rangeFacetVar, rangeFacetJson);
              JsonObject rangeFacetCountsObject = new JsonObject();
              rangeFacetJson.put("counts", rangeFacetCountsObject);
              rangeFacet.getCounts().forEach((value, count) -> {
                rangeFacetCountsObject.put(value, count);
              });
            }
          }
        }
        if(Optional.ofNullable(pivotField.getPivotMap()).map(m -> m.size()).orElse(0) > 0) {
          JsonObject pivotValues = new JsonObject();
          pivotJson.put("pivot", pivotValues);
          responsePivotSearch(pivotField.getPivotMap(), pivotValues);
        }
      }
    }
  }

  /**
   * Val.Scheduling.enUS:Scheduling the %s import at %s
   * Val.Skip.enUS:Skip importing %s data. 
   * Val.Fail.enUS:Scheduling the import of %s data failed. 
   */
  public Future<Void> importTimer(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest, String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    if(Boolean.parseBoolean(config.getString(String.format("%s_%s", ComputateConfigKeys.ENABLE_IMPORT_DATA, classSimpleName), "true"))) {
      Boolean importDataOnce = config.getBoolean(ComputateConfigKeys.IMPORT_DATA_ONCE, false);
      if(importDataOnce) {
        importData(pagePath, vertx, siteRequest, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, varPageId, varUserUrl, varDownload).onSuccess(a -> {
          promise.complete();
        }).onFailure(ex -> {
          LOG.error(String.format(importTimerFail, classSimpleName), ex);
          promise.fail(ex);
        });
      } else {
        // Load the import start time and period configuration. 
        String importStartTime = config.getString(String.format("%s_%s", ComputateConfigKeys.IMPORT_DATA_START_TIME, classSimpleName));
        String importPeriod = config.getString(String.format("%s_%s", ComputateConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
        // Get the duration of the import period. 
        // Calculate the next start time, or the next start time after that, if the start time is in less than a minute, 
        // to give the following code enough time to complete it's calculations to ensure the import starts correctly. 

        Duration nextStartDuration = null;
        ZonedDateTime nextStartTime = null;
        if(!Strings.isNullOrEmpty(importPeriod)) {
          Duration duration = TimeTool.parseNextDuration(importPeriod);
          if(Strings.isNullOrEmpty(importStartTime)) {
            nextStartTime = Optional.of(ZonedDateTime.now(ZoneId.of(config.getString(ComputateConfigKeys.SITE_ZONE))))
                .map(t -> Duration.between(Instant.now(), t).toMinutes() < 1L ? t.plus(duration) : t).get();
          } else {
            nextStartTime = TimeTool.parseNextZonedTime(importStartTime);
          }

          // Get the time now for the import start time zone. 
          ZonedDateTime now = ZonedDateTime.now(nextStartTime.getZone());
          BigDecimal[] divideAndRemainder = BigDecimal.valueOf(Duration.between(now, nextStartTime).toMillis())
              .divideAndRemainder(BigDecimal.valueOf(duration.toMillis()));
          nextStartDuration = Duration.between(now, nextStartTime);
          if(divideAndRemainder[0].compareTo(BigDecimal.ONE) >= 0) {
            nextStartDuration = Duration.ofMillis(divideAndRemainder[1].longValueExact());
            nextStartTime = now.plus(nextStartDuration);
          }
          LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
        }
        ZonedDateTime nextStartTime2 = nextStartTime;

        if(Strings.isNullOrEmpty(importStartTime)) {
          try {
            vertx.setTimer(1, a -> {
              workerExecutor.executeBlocking(() -> {
                return importBlocking(pagePath, vertx, siteRequest, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, null, varPageId, varUserUrl, varDownload);
              });
            });
            promise.complete();
          } catch(Exception ex) {
            LOG.error(String.format(importTimerFail, classSimpleName), ex);
            promise.fail(ex);
          }
        } else {
          try {
            vertx.setTimer(nextStartDuration.toMillis(), a -> {
              workerExecutor.executeBlocking(() -> {
                return importBlocking(pagePath, vertx, siteRequest, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, nextStartTime2, varPageId, varUserUrl, varDownload);
              });
            });
            promise.complete();
          } catch(Exception ex) {
            LOG.error(String.format(importTimerFail, classSimpleName), ex);
            promise.fail(ex);
          }
        }
      }
    } else {
      LOG.info(String.format(importTimerSkip, classSimpleName));
      promise.complete();
    }
    return promise.future();
  }
  /**
   * Description: Import initial data
   * Val.Complete.enUS:Configuring the import of %s data completed. 
   * Val.Fail.enUS:Configuring the import of %s data failed. 
   **/
  public Future<Object> importBlocking(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest, String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, ZonedDateTime startDateTime, String varPageId, String varUserUrl, String varDownload) {
    Promise<Object> promise = Promise.promise();
    importData(pagePath, vertx, siteRequest, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, varPageId, varUserUrl, varDownload).onComplete(a -> {
      String importPeriod = config.getString(String.format("%s_%s", ComputateConfigKeys.IMPORT_DATA_PERIOD, classSimpleName));
      if(importPeriod != null && startDateTime != null) {
        Duration duration = TimeTool.parseNextDuration(importPeriod);
        ZonedDateTime nextStartTime = startDateTime.plus(duration);
        LOG.info(String.format(importTimerScheduling, classSimpleName, nextStartTime.format(TIME_FORMAT)));
        Duration nextStartDuration = Duration.between(Instant.now(), nextStartTime);
        vertx.setTimer(nextStartDuration.toMillis(), b -> {
          workerExecutor.executeBlocking(() -> {
            return importBlocking(pagePath, vertx, siteRequest, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, nextStartTime, varPageId, varUserUrl, varDownload);
          });
        });
        promise.complete();
      } else {
        promise.complete();
      }
    });
    return promise.future();
  }

  private static String staticSearchZonedDateTime(ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  private static String staticSearchStr(ComputateSiteRequest siteRequest, String o) {
    return staticSearchZonedDateTime(staticSetDateTime(siteRequest, o));
  }
  
  private static ZonedDateTime staticSetDateTime(ComputateSiteRequest siteRequest, String o) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }

  /**
   * Description: Delete page data
   * Val.Complete.enUS:Importing %s data completed. 
   * Val.Fail.enUS:Importing %s data failed. 
   */
  private Future<Void> deletePageData(ComputateSiteRequest siteRequest, ZonedDateTime now, String classSimpleName) {
    Promise<Void> promise = Promise.promise();
    String solrHostName = config.getString(ComputateConfigKeys.SOLR_HOST_NAME);
    Integer solrPort = Integer.parseInt(config.getString(ComputateConfigKeys.SOLR_PORT));
    String solrCollection = config.getString(ComputateConfigKeys.SOLR_COLLECTION);
    Boolean solrSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.SOLR_SSL));
    String solrRequestUri = String.format("/solr/%s/update%s", solrCollection, "?softCommit=true&overwrite=true&wt=json");
    String deleteQuery = String.format("classSimpleName_docvalues_string:(%s) AND created_docvalues_date:[* TO %s]", classSimpleName, staticSearchStr(siteRequest, staticSearchZonedDateTime(now)));
    String deleteXml = String.format("<delete><query>%s</query></delete>", deleteQuery);
    webClient.post(solrPort, solrHostName, solrRequestUri)
        .ssl(solrSsl)
        .putHeader("Content-Type", "text/xml")
        .sendBuffer(Buffer.buffer().appendString(deleteXml))
        .onSuccess(d -> {
      try {
        promise.complete();
      } catch(Exception ex) {
        LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
        promise.fail(ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("Search failed. "), new RuntimeException(ex));
      promise.fail(ex);
    });
    return promise.future();
  }

  /**
   * Creates computate project related Keycloak authorization scopes. 
   * These include POST, PATCH, GET, DELETE, SiteAdmin, and SuperAdmin scopes. 
   * @return access_token String for creating other authorization resources. 
   */
  public Future<String> createAuthorizationScopes() {
    Promise<String> promise = Promise.promise();
    try {
      String authAdminUsername = config.getString(ComputateConfigKeys.AUTH_ADMIN_USERNAME);
      String authAdminPassword = config.getString(ComputateConfigKeys.AUTH_ADMIN_PASSWORD);
      String authScopeAdmin = config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN);
      String authScopeSuperAdmin = config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN);
      Integer authPort = Integer.parseInt(config.getString(ComputateConfigKeys.AUTH_PORT));
      String authHostName = config.getString(ComputateConfigKeys.AUTH_HOST_NAME);
      Boolean authSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.AUTH_SSL));
      String authRealm = config.getString(ComputateConfigKeys.AUTH_REALM);
      String authClient = config.getString(ComputateConfigKeys.AUTH_CLIENT);
      List<Future<?>> futures = new ArrayList<>();
      String[] authScopes = new String[] {"POST", "PATCH", "GET", "DELETE", "PUT"
          , config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN)
          , config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN)
          };

      webClient.post(authPort, authHostName, "/realms/master/protocol/openid-connect/token").ssl(authSsl)
          .sendForm(MultiMap.caseInsensitiveMultiMap()
              .add("username", authAdminUsername)
              .add("password", authAdminPassword)
              .add("grant_type", "password")
              .add("client_id", "admin-cli")
              ).onSuccess(tokenResponse -> {
        try {
          String authToken = tokenResponse.bodyAsJsonObject().getString("access_token");
          for(String scopeName : authScopes) {
            futures.add(Future.future(promise1 -> {
              try {
                String scopeId = String.format("%s-%s", authRealm, scopeName);
                webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/scope", authRealm, authClient)).ssl(authSsl)
                    .putHeader("Authorization", String.format("Bearer %s", authToken))
                    .sendJson(new JsonObject().put("id", scopeId).put("name", scopeName))
                    .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                    .onSuccess(createScopeResponse -> {
                  if(createScopeResponse.statusCode() == 201)
                    LOG.info(String.format("Created auth scope %s", scopeName));
                  promise1.complete();
                }).onFailure(ex -> {
                  LOG.error(String.format("Failed to import auth scope %s", scopeName), ex);
                  promise1.fail(ex);
                });
              } catch(Throwable ex) {
                LOG.error(String.format("Failed to import auth scope %s", scopeName), ex);
                promise1.fail(ex);
              }
            }));
          }
          Future.all(futures).onSuccess(a -> {
            promise.complete(authToken);
          }).onFailure(ex -> {
            LOG.error(String.format("Failed to import auth scopes %s", authScopes.toString()), ex);
            promise.fail(ex);
          });
        } catch(Throwable ex) {
          LOG.error(String.format("Failed to import auth scopes %s", authScopes.toString()), ex);
          promise.fail(ex);
        }
      }).onFailure(ex -> {
        LOG.error(String.format("Failed to import auth scopes %s", authScopes.toString()), ex);
        promise.fail(ex);
      });
    } catch(Throwable ex) {
      LOG.error("Failed to import auth scopes", ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  // /**
  //  * Creates Keycloak group and authorization resource, policy, and permission for the group to class data in the site. 
  //  */
  // public Future<Void> authorizeClientData(String authToken, String classSimpleName, String clientId, String[] scopes) {
  //   Promise<Void> promise = Promise.promise();
  //   try {
  //     if(clientId != null && scopes != null) {
  //       String authScopeAdmin = config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN);
  //       String authScopeSuperAdmin = config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN);
  //       Integer authPort = Integer.parseInt(config.getString(ComputateConfigKeys.AUTH_PORT));
  //       String authHostName = config.getString(ComputateConfigKeys.AUTH_HOST_NAME);
  //       Boolean authSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.AUTH_SSL));
  //       String authRealm = config.getString(ComputateConfigKeys.AUTH_REALM);
  //       String authClient = config.getString(ComputateConfigKeys.AUTH_CLIENT);

  //       String policyId = String.format("%s-client-%s", authRealm, clientId);
  //       String policyName = String.format("%s-client-%s", authRealm, clientId);
  //       String permissionName = String.format("%s-client-%s-%s", authRealm, clientId, classSimpleName);
  //       JsonArray authScopesJson = new JsonArray();
  //       for(String scope : scopes) {
  //         authScopesJson.add(String.format("%s-%s", authRealm, scope));
  //       }
  //       webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/policy/client", authRealm, authClient)).ssl(authSsl)
  //           .putHeader("Authorization", String.format("Bearer %s", authToken))
  //           .sendJson(new JsonObject().put("id", policyId).put("name", policyName).put("description", String.format("%s client", clientId)).put("clients", new JsonArray().add(clientId)))
  //           .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
  //           .onSuccess(createPolicyResponse -> {
  //         webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/resource", authRealm, authClient)).ssl(authSsl)
  //             .putHeader("Authorization", String.format("Bearer %s", authToken))
  //             .sendJson(new JsonObject()
  //                 .put("name", classSimpleName)
  //                 .put("displayName", classSimpleName)
  //                 .put("scopes", new JsonArray().add("POST").add("PATCH").add("GET").add("DELETE").add(authScopeAdmin).add(authScopeSuperAdmin))
  //                 )
  //             .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
  //             .onSuccess(createResourceResponse -> {

  //           webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/permission/scope", authRealm, authClient)).ssl(authSsl)
  //               .putHeader("Authorization", String.format("Bearer %s", authToken))
  //               .sendJson(new JsonObject()
  //                   .put("name", permissionName)
  //                   .put("description", String.format("GET %s", clientId))
  //                   .put("decisionStrategy", "AFFIRMATIVE")
  //                   .put("resources", new JsonArray().add(classSimpleName))
  //                   .put("policies", new JsonArray().add(policyName))
  //                   .put("scopes", authScopesJson)
  //                   )
  //               .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
  //               .onSuccess(createPermissionResponse -> {
  //             LOG.info(String.format("Successfully granted %s permission to %s policy to %s resource", authScopesJson.encode(), policyName, classSimpleName));
  //             promise.complete();
  //           }).onFailure(ex -> {
  //             LOG.error(String.format("Failed to grant %s permission to %s policy to %s resource", authScopesJson.encode(), policyName, classSimpleName), ex);
  //             promise.fail(ex);
  //           });
  //         }).onFailure(ex -> {
  //           LOG.error(String.format("Failed to create %s auth resource %s", authScopesJson.encode(), classSimpleName), ex);
  //           promise.fail(ex);
  //         });
  //       }).onFailure(ex -> {
  //         LOG.error(String.format("Failed to create auth policy %s for resource %s", policyName, classSimpleName), ex);
  //         promise.fail(ex);
  //       });
  //     } else {
  //       promise.complete();
  //     }
  //   } catch(Throwable ex) {
  //     LOG.error(String.format("Failed to set up Keycloak credentials while creating fine-grained resource permissions for client %s for resource %s", clientId, classSimpleName), ex);
  //     promise.fail(ex);
  //   }
  //   return promise.future();
  // }

  /**
   * Creates Keycloak group and authorization resource, policy, and permission for the group to class data in the site. 
   */
  public Future<Void> authorizeGroupData(String authToken, String classAuthResource, String groupName, String[] scopes) {
    Promise<Void> promise = Promise.promise();
    try {
      if(groupName != null && scopes != null) {
        String authScopeAdmin = config.getString(ComputateConfigKeys.AUTH_SCOPE_ADMIN);
        String authScopeSuperAdmin = config.getString(ComputateConfigKeys.AUTH_SCOPE_SUPER_ADMIN);
        Integer authPort = Integer.parseInt(config.getString(ComputateConfigKeys.AUTH_PORT));
        String authHostName = config.getString(ComputateConfigKeys.AUTH_HOST_NAME);
        Boolean authSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.AUTH_SSL));
        String authRealm = config.getString(ComputateConfigKeys.AUTH_REALM);
        String authClient = config.getString(ComputateConfigKeys.AUTH_CLIENT);

        String policyId = String.format("%s-group-%s", authRealm, groupName);
        String policyName = String.format("%s-group-%s", authRealm, groupName);
        String permissionName = String.format("%s-group-%s-%s", authRealm, groupName, classAuthResource);
        JsonArray authScopesJson = new JsonArray();
        for(String scope : scopes) {
          authScopesJson.add(String.format("%s-%s", authRealm, scope));
        }
        webClient.post(authPort, authHostName, String.format("/admin/realms/%s/groups", authRealm)).ssl(authSsl)
            .putHeader("Authorization", String.format("Bearer %s", authToken))
            .sendJson(new JsonObject().put("name", groupName))
            .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
            .onSuccess(createGroupResponse -> {
          try {
            webClient.get(authPort, authHostName, String.format("/admin/realms/%s/groups?exact=false&global=true&first=0&max=1&search=%s", authRealm, URLEncoder.encode(groupName, "UTF-8"))).ssl(authSsl)
                .putHeader("Authorization", String.format("Bearer %s", authToken))
                .send()
                .expecting(HttpResponseExpectation.SC_OK)
                .onSuccess(groupsResponse -> {
              try {
                JsonArray groups = Optional.ofNullable(groupsResponse.bodyAsJsonArray()).orElse(new JsonArray());
                JsonObject group = groups.stream().findFirst().map(o -> (JsonObject)o).orElse(null);
                if(group != null) {
                  String groupId = group.getString("id");
                  webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/policy/group", authRealm, authClient)).ssl(authSsl)
                      .putHeader("Authorization", String.format("Bearer %s", authToken))
                      .sendJson(new JsonObject().put("id", policyId).put("name", policyName).put("description", String.format("%s group", groupName)).put("groups", new JsonArray().add(groupId)))
                      .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                      .onSuccess(createPolicyResponse -> {
                    webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/resource", authRealm, authClient)).ssl(authSsl)
                        .putHeader("Authorization", String.format("Bearer %s", authToken))
                        .sendJson(new JsonObject()
                            .put("name", classAuthResource)
                            .put("displayName", classAuthResource)
                            .put("scopes", new JsonArray().add("POST").add("PATCH").add("GET").add("DELETE").add(authScopeAdmin).add(authScopeSuperAdmin))
                            )
                        .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                        .onSuccess(createResourceResponse -> {

                      webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/permission/scope", authRealm, authClient)).ssl(authSsl)
                          .putHeader("Authorization", String.format("Bearer %s", authToken))
                          .sendJson(new JsonObject()
                              .put("name", permissionName)
                              .put("description", String.format("GET %s", groupName))
                              .put("decisionStrategy", "AFFIRMATIVE")
                              .put("resources", new JsonArray().add(classAuthResource))
                              .put("policies", new JsonArray().add(policyName))
                              .put("scopes", authScopesJson)
                              )
                          .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                          .onSuccess(createPermissionResponse -> {
                        LOG.info(String.format("Successfully granted %s permission to %s policy to %s resource", authScopesJson.encode(), policyName, classAuthResource));
                        promise.complete();
                      }).onFailure(ex -> {
                        LOG.error(String.format("Failed to grant %s permission to %s policy to %s resource", authScopesJson.encode(), policyName, classAuthResource), ex);
                        promise.fail(ex);
                      });
                    }).onFailure(ex -> {
                      LOG.error(String.format("Failed to create %s auth resource %s", authScopesJson.encode(), classAuthResource), ex);
                      promise.fail(ex);
                    });
                  }).onFailure(ex -> {
                    LOG.error(String.format("Failed to create auth policy %s for resource %s", policyName, classAuthResource), ex);
                    promise.fail(ex);
                  });
                } else {
                  Throwable ex = new RuntimeException(String.format("Failed to find group %s for resource %s", groupName, classAuthResource));
                  LOG.error(ex.getMessage(), ex);
                  promise.fail(ex);
                }
              } catch(Throwable ex) {
                LOG.error(String.format("Failed to set up fine-grained resource permissions for resource %s. ", classAuthResource), ex);
                promise.fail(ex);
              }
            }).onFailure(ex -> {
              LOG.error(String.format("Failed to query the group %s for resource %s. ", groupName, classAuthResource), ex);
              promise.fail(ex);
            });
          } catch(Throwable ex) {
            LOG.error(String.format("Failed to set up fine-grained resource permissions for resource %s. ", classAuthResource), ex);
            promise.fail(ex);
          }
        }).onFailure(ex -> {
          LOG.error(String.format("Failed to create the group %s for resource %s. ", groupName, classAuthResource), ex);
          promise.fail(ex);
        });
      } else {
        promise.complete();
      }
    } catch(Throwable ex) {
      LOG.error(String.format("Failed to set up Keycloak credentials while creating fine-grained resource permissions for group %s for resource %s", groupName, classAuthResource), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  /**
   * Description: Import all Site HTML data
   * Val.Complete.enUS:Importing %s data completed. 
   * Val.Fail.enUS:Importing %s data failed. 
   */
  public Future<Void> importData(Path pagePath, Vertx vertx, ComputateSiteRequest siteRequest, String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    ZonedDateTime now = ZonedDateTime.now(ZoneId.of(config.getString(ComputateConfigKeys.SITE_ZONE)));
    // i18nGenerator().onSuccess(i18n -> {
    try {
      if(Boolean.parseBoolean(config.getString(String.format("%s_%s", ComputateConfigKeys.ENABLE_IMPORT_DATA, classSimpleName), "true"))) {
        List<String> pageTemplatePaths = new ArrayList<>();
        if(Files.exists(pagePath)) {
          try(Stream<Path> stream = Files.walk(pagePath, FileVisitOption.FOLLOW_LINKS)) {
            stream.filter(Files::isRegularFile).filter(p -> 
                p.getFileName().toString().endsWith(".htm")
                || p.getFileName().toString().endsWith(".html")
                || p.getFileName().toString().endsWith(".md")
                ).forEach(path -> {
              pageTemplatePaths.add(path.toAbsolutePath().toString());
            });
          }
          YamlProcessor yamlProcessor = new YamlProcessor();
  
          importDataFile(vertx, siteRequest, yamlProcessor, pageTemplatePaths, 0, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, varPageId, varUserUrl, varDownload).onSuccess(a -> {
            deletePageData(siteRequest, now, classSimpleName).onSuccess(b -> {
              LOG.info(String.format(importDataComplete, classSimpleName, config.getString(ComputateConfigKeys.SITE_BASE_URL)));
              promise.complete();
            }).onFailure(ex -> {
              LOG.error(String.format(importDataFail, classSimpleName), ex);
              promise.fail(ex);
            });
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFail, classSimpleName), ex);
            promise.fail(ex);
          });
        } else {
          promise.complete();
        }
      } else {
        promise.complete();
      }
    } catch(Throwable ex) {
      LOG.error(String.format(importDataFail, classSimpleName), ex);
      promise.fail(ex);
    }
    // }).onFailure(ex -> {
    //   LOG.error(String.format(importDataFail, classSimpleName), ex);
    //   promise.fail(ex);
    // });
    return promise.future();
  }

  /**
   * Description: Import Site HTML data
   * Val.Complete.enUS:Importing %s data file completed. 
   * Val.Fail.enUS:Importing %s data file failed. 
   */
  protected Future<Void> importDataFile(Vertx vertx, ComputateSiteRequest siteRequest, YamlProcessor yamlProcessor, List<String> pageTemplatePaths, Integer i, String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    try {
      if(i < pageTemplatePaths.size()) {
        String pageTemplatePath = pageTemplatePaths.get(i);
        importModelFromFile(vertx, siteRequest, yamlProcessor, pageTemplatePath, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, varPageId, varUserUrl, varDownload).onSuccess(a -> {
          importDataFile(vertx, siteRequest, yamlProcessor, pageTemplatePaths, i + 1, classCanonicalName, classSimpleName, classApiAddress, classAuthResource, varPageId, varUserUrl, varDownload).onSuccess(b -> {
            promise.complete();
          }).onFailure(ex -> {
            LOG.error(String.format(importDataFileFail, pageTemplatePath), ex);
            promise.fail(ex);
          });
        }).onFailure(ex -> {
          LOG.error(String.format(importDataFileFail, pageTemplatePath), ex);
          promise.fail(ex);
        });
      } else {
        promise.complete();
      }
    } catch(Exception ex) {
      LOG.error(String.format(importDataFileFail, classSimpleName), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public Future<JsonObject> generatePageBody(ComputateSiteRequest siteRequest, Map<String, Object> ctx, String templatePath, String classSimpleName, String pageTemplate) {
    Promise<JsonObject> promise = Promise.promise();
    promise.complete(new JsonObject());
    return promise.future();
  }

  /**
   * Description: Import page
   */
  protected Future<Void> importModelFromFile(Vertx vertx, ComputateSiteRequest siteRequest, YamlProcessor yamlProcessor, String templatePath, String classCanonicalName, String classSimpleName, String classApiAddress, String classAuthResource, String varPageId, String varUserUrl, String varDownload) {
    Promise<Void> promise = Promise.promise();
    vertx.fileSystem().readFile(templatePath).onSuccess(buffer -> {
      try {
        // Jinjava template rendering
        Map<String, Object> ctx = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        String shortFileName = FilenameUtils.getBaseName(templatePath);
        String template = Files.readString(Path.of(templatePath), Charset.forName("UTF-8"));
        if(shortFileName.startsWith(classSimpleName)) {
          promise.complete();
        } else {
          result.put(i18n.getString(I18n.var_nomFichierCourt), shortFileName);
          ctx.put(ComputateConfigKeys.STATIC_BASE_URL, config.getString(ComputateConfigKeys.STATIC_BASE_URL));
          ctx.put(ComputateConfigKeys.SITE_BASE_URL, config.getString(ComputateConfigKeys.SITE_BASE_URL));
          ctx.put(ComputateConfigKeys.GITHUB_ORG, config.getString(ComputateConfigKeys.GITHUB_ORG));
          ctx.put(ComputateConfigKeys.SITE_NAME, config.getString(ComputateConfigKeys.SITE_NAME));
          ctx.put(ComputateConfigKeys.SITE_SHORT_NAME, config.getString(ComputateConfigKeys.SITE_SHORT_NAME));
          ctx.put(ComputateConfigKeys.SITE_DISPLAY_NAME, config.getString(ComputateConfigKeys.SITE_DISPLAY_NAME));
          ctx.put(ComputateConfigKeys.SITE_DESCRIPTION, config.getString(ComputateConfigKeys.SITE_DESCRIPTION));
          ctx.put(ComputateConfigKeys.SITE_POWERED_BY_URL, config.getString(ComputateConfigKeys.SITE_POWERED_BY_URL));
          ctx.put(ComputateConfigKeys.SITE_POWERED_BY_NAME, config.getString(ComputateConfigKeys.SITE_POWERED_BY_NAME));
          ctx.put(ComputateConfigKeys.SITE_POWERED_BY_IMAGE, config.getString(ComputateConfigKeys.SITE_POWERED_BY_IMAGE));
          ctx.put(ComputateConfigKeys.FONTAWESOME_KIT, config.getString(ComputateConfigKeys.FONTAWESOME_KIT));
          ctx.put(ComputateConfigKeys.FONTAWESOME_STYLE, config.getString(ComputateConfigKeys.FONTAWESOME_STYLE));
          ctx.put(ComputateConfigKeys.WEB_COMPONENTS_CSS, config.getString(ComputateConfigKeys.WEB_COMPONENTS_CSS));
          ctx.put(ComputateConfigKeys.WEB_COMPONENTS_PREFIX, config.getString(ComputateConfigKeys.WEB_COMPONENTS_PREFIX));
          ctx.put(ComputateConfigKeys.WEB_COMPONENTS_JS, config.getString(ComputateConfigKeys.WEB_COMPONENTS_JS));
          ctx.put(ComputateConfigKeys.WEB_COMPONENTS_THEME, config.getString(ComputateConfigKeys.WEB_COMPONENTS_THEME));
          ctx.put(ComputateConfigKeys.WEB_COMPONENTS_KIT, config.getString(ComputateConfigKeys.WEB_COMPONENTS_KIT));
          ctx.put(ComputateConfigKeys.WEB_COMPONENTS_PRO, config.getString(ComputateConfigKeys.WEB_COMPONENTS_PRO));
          ctx.put(ComputateConfigKeys.PUBLIC_SEARCH_URI, config.getString(ComputateConfigKeys.PUBLIC_SEARCH_URI));
          ctx.put(ComputateConfigKeys.USER_SEARCH_URI, config.getString(ComputateConfigKeys.USER_SEARCH_URI));
          ctx.put(i18n.getString(I18n.var_resultat), result);

          String metaPrefixResult = String.format("%s.", i18n.getString(I18n.var_resultat));
          String pageTemplate;
          if(templatePath.endsWith(".md")) {
            String body = "";
            // Process markdown metadata
            if(template.startsWith("---\n")) {
              Matcher mMeta = Pattern.compile("---\n([\\w\\W]+?)\n---\n([\\w\\W]+)", Pattern.MULTILINE).matcher(template);
              if(mMeta.find()) {
                String meta = mMeta.group(1);
                body = mMeta.group(2);
                // Matcher m = Pattern.compile("^([^:]+?): (.*)", Pattern.MULTILINE).matcher(meta);
                Yaml yaml = new Yaml();
                Map<String, Object> map = yaml.load(meta);
                map.forEach((resultKey, value) -> {
                  if(resultKey.startsWith(metaPrefixResult)) {
                    String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                    String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                    if(val instanceof String) {
                      String rendered = jinjava.render(val, ctx);
                      result.put(key, rendered);
                    } else {
                      result.put(key, val);
                    }
                  }
                });
                ctx.put(i18n.getString(I18n.var_resultat), result);
                map.forEach((resultKey, value) -> {
                  if(resultKey.startsWith(metaPrefixResult)) {
                    String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                    String val = Optional.ofNullable(value).map(v -> v.toString()).orElse(null);
                    if(val instanceof String) {
                      String rendered = jinjava.render(val, ctx);
                      result.put(key, rendered);
                    } else {
                      result.put(key, val);
                    }
                  }
                });
              }
            }
            Parser parser = Parser.builder().build();
            Node document = parser.parse(body);
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            String pageExtends =  Optional.ofNullable((String)result.get("extends")).orElse("en-us/Article.htm");
            pageTemplate = "{% extends \"" + pageExtends + "\" %}\n{% block htmBodyMiddleArticle %}\n" + renderer.render(document) + "\n{% endblock htmBodyMiddleArticle %}\n";
          } else {
            // Process HTM metadata
            Matcher m = Pattern.compile("<meta name=\"([^\"]+)\"\\s+content=\"([^\"]*)\"\\s*/>", Pattern.MULTILINE).matcher(template);
            boolean trouve = m.find();
            while (trouve) {
              String resultKey = m.group(1);
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = m.group(2);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx);
                  result.put(key, rendered);
                } else {
                  result.put(key, val);
                }
              }
              trouve = m.find();
            }
            ctx.put(i18n.getString(I18n.var_resultat), result);
            m.reset();
            trouve = m.find();
            while (trouve) {
              String resultKey = m.group(1);
              if(resultKey.startsWith(metaPrefixResult)) {
                String key = StringUtils.substringAfter(resultKey, metaPrefixResult);
                String val = m.group(2);
                if(val instanceof String) {
                  String rendered = jinjava.render(val, ctx);
                  result.put(key, rendered);
                } else {
                  result.put(key, val);
                }
              }
              trouve = m.find();
            }
            pageTemplate = template;
          }

          generatePageBody(siteRequest, ctx, templatePath, classSimpleName, pageTemplate).onSuccess(pageBody -> {
            try {
              String pageId = (String)result.get(varPageId);
              // JSoup HTML parsing
              String renderedTemplate = jinjava.render(pageTemplate, ctx);
              Document htmDoc = Jsoup.parse(renderedTemplate);

              JsonObject pageParams = new JsonObject();
              pageParams.put("body", pageBody);
              pageParams.put("path", new JsonObject());
              pageParams.put("cookie", new JsonObject());
              pageParams.put("scopes", new JsonArray().add("GET"));
              pageParams.put("query", new JsonObject().put("softCommit", true).put("q", "*:*").put("var", new JsonArray().add("refresh:false")));
              JsonObject pageContext = new JsonObject().put("params", pageParams);
              JsonObject pageRequest = new JsonObject().put("context", pageContext);

              vertx.eventBus().request(classApiAddress, pageRequest, new DeliveryOptions().setSendTimeout(config.getLong(ComputateConfigKeys.VERTX_MAX_EVENT_LOOP_EXECUTE_TIME) * 1000).addHeader("action", String.format("putimport%sFuture", classSimpleName))).onSuccess(message -> {
                try {
                  String siteBaseUrl = config.getString(ComputateConfigKeys.SITE_BASE_URL);
                  if(varUserUrl == null && varDownload == null) {
                    promise.complete();
                  } else {
                    SearchList<Object> searchList = new SearchList<Object>();
                    searchList.setStore(true);
                    searchList.q("*:*");
                    searchList.setC(Class.forName(classCanonicalName));
                    searchList.fq("archived_docvalues_boolean:false");
                    searchList.fq(String.format("%s_docvalues_string:", varPageId) + SearchTool.escapeQueryChars(pageId));
                    searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
                      try {
                        JsonObject resultJsonObject = JsonObject.mapFrom(searchList.getList().stream().findFirst().orElse(null));
                        String userUrl = Optional.ofNullable(varUserUrl).map(url -> resultJsonObject.getString(url)).orElse(null);
                        String downloadUrl = Optional.ofNullable(varDownload).map(url -> resultJsonObject.getString(url)).orElse(null);
                        if(userUrl == null && downloadUrl == null) {
                          promise.complete();
                        } else {
                          ZoneId zoneId = ZoneId.of(config.getString(ComputateConfigKeys.SITE_ZONE));
                          String groupName = String.format("%s-%s-GET", classAuthResource, pageId);
                          String policyId = String.format("%s-%s-GET", classAuthResource, pageId);
                          String policyName = String.format("%s-%s-GET", classAuthResource, pageId);
                          String resourceName = String.format("%s-%s", classAuthResource, pageId);
                          String resourceDisplayName = String.format("%s %s", classAuthResource, pageId);
                          String authAdminUsername = config.getString(ComputateConfigKeys.AUTH_ADMIN_USERNAME);
                          String authAdminPassword = config.getString(ComputateConfigKeys.AUTH_ADMIN_PASSWORD);
                          Integer authPort = Integer.parseInt(config.getString(ComputateConfigKeys.AUTH_PORT));
                          String authHostName = config.getString(ComputateConfigKeys.AUTH_HOST_NAME);
                          Boolean authSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.AUTH_SSL));
                          String authRealm = config.getString(ComputateConfigKeys.AUTH_REALM);
                          String authClient = config.getString(ComputateConfigKeys.AUTH_CLIENT);
                          webClient.post(authPort, authHostName, "/realms/master/protocol/openid-connect/token").ssl(authSsl)
                              .sendForm(MultiMap.caseInsensitiveMultiMap()
                                  .add("username", authAdminUsername)
                                  .add("password", authAdminPassword)
                                  .add("grant_type", "password")
                                  .add("client_id", "admin-cli")
                                  ).onSuccess(tokenResponse -> {
                            try {
                              String authToken = tokenResponse.bodyAsJsonObject().getString("access_token");
                              webClient.post(authPort, authHostName, String.format("/admin/realms/%s/groups", authRealm)).ssl(authSsl)
                                  .putHeader("Authorization", String.format("Bearer %s", authToken))
                                  .sendJson(new JsonObject().put("name", groupName))
                                  .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                                  .onSuccess(createGroupResponse -> {
                                try {
                                  webClient.get(authPort, authHostName, String.format("/admin/realms/%s/groups?exact=false&global=true&first=0&max=1&search=%s", authRealm, URLEncoder.encode(groupName, "UTF-8"))).ssl(authSsl)
                                      .putHeader("Authorization", String.format("Bearer %s", authToken))
                                      .send()
                                      .expecting(HttpResponseExpectation.SC_OK)
                                      .onSuccess(groupsResponse -> {
                                    try {
                                      JsonArray groups = Optional.ofNullable(groupsResponse.bodyAsJsonArray()).orElse(new JsonArray());
                                      JsonObject group = groups.stream().findFirst().map(o -> (JsonObject)o).orElse(null);
                                      if(group != null) {
                                        String groupId = group.getString("id");
                                        webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/policy/group", authRealm, authClient)).ssl(authSsl)
                                            .putHeader("Authorization", String.format("Bearer %s", authToken))
                                            .sendJson(new JsonObject().put("id", policyId).put("name", policyName).put("description", String.format("%s group", groupName)).put("groups", new JsonArray().add(groupId)))
                                            .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                                            .onSuccess(createPolicyResponse -> {
                                          JsonArray uris = new JsonArray();
                                          if(userUrl != null)
                                              uris.add(StringUtils.substringAfter(userUrl, siteBaseUrl));
                                          if(downloadUrl != null)
                                              uris.add(StringUtils.substringAfter(downloadUrl, siteBaseUrl));
                                          webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/resource", authRealm, authClient)).ssl(authSsl)
                                              .putHeader("Authorization", String.format("Bearer %s", authToken))
                                              .sendJson(new JsonObject()
                                                  .put("name", resourceName)
                                                  .put("displayName", resourceDisplayName)
                                                  .put("uris", uris)
                                                  .put("scopes", new JsonArray().add("GET").add("PATCH"))
                                                  )
                                              .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                                              .onSuccess(createResourceResponse -> {
                                            webClient.post(authPort, authHostName, String.format("/admin/realms/%s/clients/%s/authz/resource-server/permission/scope", authRealm, authClient)).ssl(authSsl)
                                                .putHeader("Authorization", String.format("Bearer %s", authToken))
                                                .sendJson(new JsonObject()
                                                    .put("name", String.format("%s-%s", authRealm, groupName))
                                                    .put("description", String.format("GET %s", groupName))
                                                    .put("decisionStrategy", "AFFIRMATIVE")
                                                    .put("resources", new JsonArray().add(resourceName))
                                                    .put("policies", new JsonArray().add(policyName))
                                                    .put("scopes", new JsonArray().add(String.format("%s-GET", authRealm)))
                                                    )
                                                .expecting(HttpResponseExpectation.SC_CREATED.or(HttpResponseExpectation.SC_CONFLICT))
                                                .onSuccess(createPermissionResponse -> {
                                              LOG.info(String.format("Successfully granted %s access to %s", "GET", resourceName));
                                              promise.complete();
                                            }).onFailure(ex -> {
                                              LOG.error(String.format("Failed to create an auth permission for resource %s. ", resourceName), ex);
                                              promise.fail(ex);
                                            });
                                          }).onFailure(ex -> {
                                            LOG.error(String.format("Failed to create an auth resource %s. ", resourceName), ex);
                                            promise.fail(ex);
                                          });
                                        }).onFailure(ex -> {
                                          LOG.error(String.format("Failed to create an auth policy for group %s. ", groupName), ex);
                                          promise.fail(ex);
                                        });
                                      } else {
                                        Throwable ex = new RuntimeException(String.format("Failed to find group %s", groupName));
                                        LOG.error(ex.getMessage(), ex);
                                        promise.fail(ex);
                                      }
                                    } catch(Throwable ex) {
                                      LOG.error("Failed to set up fine-grained resource permissions. ", ex);
                                      promise.fail(ex);
                                    }
                                  }).onFailure(ex -> {
                                    LOG.error(String.format("Failed to query the group %s. ", groupName), ex);
                                    promise.fail(ex);
                                  });
                                } catch(Throwable ex) {
                                  LOG.error("Failed to set up fine-grained resource permissions. ", ex);
                                  promise.fail(ex);
                                }
                              }).onFailure(ex -> {
                                LOG.error(String.format("Failed to create the group %s. ", groupName), ex);
                                promise.fail(ex);
                              });
                            } catch(Throwable ex) {
                              LOG.error(String.format("Failed to set up the auth token for fine-grained resource permissions for group %s", groupName), ex);
                              promise.fail(ex);
                            }
                          }).onFailure(ex -> {
                            LOG.error(String.format("Failed to get an admin token while creating fine-grained resource permissions for group %s", groupName), ex);
                            promise.fail(ex);
                          });
                        }
                      } catch(Throwable ex) {
                        LOG.error(String.format("Failed to set up Keycloak credentials while creating fine-grained resource permissions for page %s", pageId), ex);
                        promise.fail(ex);
                      }
                    }).onFailure(ex -> {
                      promise.fail(ex);
                    });
                  }
                } catch(Throwable ex) {
                  LOG.error(String.format("Failed to set up Keycloak credentials while creating fine-grained resource permissions for page"), ex);
                  promise.fail(ex);
                }
              }).onFailure(ex -> {
                promise.fail(ex);
              });
            } catch(Exception ex) {
              LOG.error(String.format("Failed to import model from file: %s", templatePath), ex);
              promise.fail(ex);
            }
          }).onFailure(ex -> {
            LOG.error(String.format("Failed to import model from file: %s", templatePath), ex);
            promise.fail(ex);
          });
        }
      } catch(Exception ex) {
        LOG.error(String.format("Failed to import model from file: %s", templatePath), ex);
        promise.fail(ex);
      }
    }).onFailure(ex -> {
      LOG.error(String.format("Failed to import model from file: %s", templatePath), ex);
      promise.fail(ex);
    });
    return promise.future();
  }

  public static String varIndexedBaseModel(String entityVar) {
    switch(entityVar) {
      case "pk":
        return "pk_docvalues_long";
      case "inheritPk":
        return "inheritPk_docvalues_string";
      case "created":
        return "created_docvalues_date";
      case "modified":
        return "modified_docvalues_date";
      case "archived":
        return "archived_docvalues_boolean";
      case "deleted":
        return "deleted_docvalues_boolean";
      case "classCanonicalName":
        return "classCanonicalName_docvalues_string";
      case "classSimpleName":
        return "classSimpleName_docvalues_string";
      case "classCanonicalNames":
        return "classCanonicalNames_docvalues_strings";
      case "sessionId":
        return "sessionId_docvalues_string";
      case "userKey":
        return "userKey_docvalues_long";
      case "saves":
        return "saves_docvalues_strings";
      case "objectTitle":
        return "objectTitle_docvalues_string";
      case "objectId":
        return "objectId_docvalues_string";
      case "objectSuggest":
        return "objectSuggest_suggested";
      case "objectText":
        return "objectText_text_enUS";
      case "pageUrlId":
        return "pageUrlId_docvalues_string";
      case "pageUrlPk":
        return "pageUrlPk_docvalues_string";
      case "pageUrlApi":
        return "pageUrlApi_docvalues_string";
      case "id":
        return "id";
      default:
        return null;
    }
  }

  public static <SiteRequest extends ComputateSiteRequest> Long staticSetPk(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }

  public static <SiteRequest extends ComputateSiteRequest> Long staticSearchPk(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrPk(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqPk(SiteRequest siteRequest_, String o) {
    return staticSearchPk(siteRequest_, staticSetPk(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetInheritPk(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchInheritPk(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrInheritPk(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqInheritPk(SiteRequest siteRequest_, String o) {
    return staticSearchInheritPk(siteRequest_, staticSetInheritPk(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> ZonedDateTime staticSetCreated(SiteRequest siteRequest_, String o) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchCreated(SiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrCreated(SiteRequest siteRequest_, String o) {
    return staticSearchCreated(siteRequest_, staticSetCreated(siteRequest_, o));
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqCreated(SiteRequest siteRequest_, String o) {
    return staticSearchCreated(siteRequest_, staticSetCreated(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> ZonedDateTime staticSetModified(SiteRequest siteRequest_, String o) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchModified(SiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrModified(SiteRequest siteRequest_, String o) {
    return staticSearchModified(siteRequest_, staticSetModified(siteRequest_, o));
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqModified(SiteRequest siteRequest_, String o) {
    return staticSearchModified(siteRequest_, staticSetModified(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> Boolean staticSetArchived(SiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }

  public static <SiteRequest extends ComputateSiteRequest> Boolean staticSearchArchived(SiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrArchived(SiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqArchived(SiteRequest siteRequest_, String o) {
    return staticSearchArchived(siteRequest_, staticSetArchived(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetClassCanonicalName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchClassCanonicalName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrClassCanonicalName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqClassCanonicalName(SiteRequest siteRequest_, String o) {
    return staticSearchClassCanonicalName(siteRequest_, staticSetClassCanonicalName(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetClassSimpleName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchClassSimpleName(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrClassSimpleName(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqClassSimpleName(SiteRequest siteRequest_, String o) {
    return staticSearchClassSimpleName(siteRequest_, staticSetClassSimpleName(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetClassCanonicalNames(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchClassCanonicalNames(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrClassCanonicalNames(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqClassCanonicalNames(SiteRequest siteRequest_, String o) {
    return staticSearchClassCanonicalNames(siteRequest_, staticSetClassCanonicalNames(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetSessionId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchSessionId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrSessionId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqSessionId(SiteRequest siteRequest_, String o) {
    return staticSearchSessionId(siteRequest_, staticSetSessionId(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> Long staticSetUserKey(SiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }

  public static <SiteRequest extends ComputateSiteRequest> Long staticSearchUserKey(SiteRequest siteRequest_, Long o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrUserKey(SiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqUserKey(SiteRequest siteRequest_, String o) {
    return staticSearchUserKey(siteRequest_, staticSetUserKey(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetSaves(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchSaves(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrSaves(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqSaves(SiteRequest siteRequest_, String o) {
    return staticSearchSaves(siteRequest_, staticSetSaves(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetObjectTitle(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchObjectTitle(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrObjectTitle(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqObjectTitle(SiteRequest siteRequest_, String o) {
    return staticSearchObjectTitle(siteRequest_, staticSetObjectTitle(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetObjectId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchObjectId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrObjectId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqObjectId(SiteRequest siteRequest_, String o) {
    return staticSearchObjectId(siteRequest_, staticSetObjectId(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetObjectSuggest(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchObjectSuggest(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrObjectSuggest(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqObjectSuggest(SiteRequest siteRequest_, String o) {
    return staticSearchObjectSuggest(siteRequest_, staticSetObjectSuggest(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetObjectText(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchObjectText(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrObjectText(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqObjectText(SiteRequest siteRequest_, String o) {
    return staticSearchObjectText(siteRequest_, staticSetObjectText(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetPageUrlId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchPageUrlId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrPageUrlId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqPageUrlId(SiteRequest siteRequest_, String o) {
    return staticSearchPageUrlId(siteRequest_, staticSetPageUrlId(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetPageUrlPk(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchPageUrlPk(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrPageUrlPk(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqPageUrlPk(SiteRequest siteRequest_, String o) {
    return staticSearchPageUrlPk(siteRequest_, staticSetPageUrlPk(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetPageUrlApi(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchPageUrlApi(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrPageUrlApi(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqPageUrlApi(SiteRequest siteRequest_, String o) {
    return staticSearchPageUrlApi(siteRequest_, staticSetPageUrlApi(siteRequest_, o)).toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSetId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchId(SiteRequest siteRequest_, String o) {
    return o;
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchStrId(SiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqId(SiteRequest siteRequest_, String o) {
    return staticSearchId(siteRequest_, staticSetId(siteRequest_, o)).toString();
  }



  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqForClass(String entityVar, SiteRequest siteRequest_, String o) {
    return staticSearchFqBaseModel(entityVar,  siteRequest_, o);
  }

  public static <SiteRequest extends ComputateSiteRequest> String staticSearchFqBaseModel(String entityVar, SiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "pk":
      return staticSearchFqPk(siteRequest_, o);
    case "inheritPk":
      return staticSearchFqInheritPk(siteRequest_, o);
    case "created":
      return staticSearchFqCreated(siteRequest_, o);
    case "modified":
      return staticSearchFqModified(siteRequest_, o);
    case "archived":
      return staticSearchFqArchived(siteRequest_, o);
    case "classCanonicalName":
      return staticSearchFqClassCanonicalName(siteRequest_, o);
    case "classSimpleName":
      return staticSearchFqClassSimpleName(siteRequest_, o);
    case "classCanonicalNames":
      return staticSearchFqClassCanonicalNames(siteRequest_, o);
    case "sessionId":
      return staticSearchFqSessionId(siteRequest_, o);
    case "userKey":
      return staticSearchFqUserKey(siteRequest_, o);
    case "saves":
      return staticSearchFqSaves(siteRequest_, o);
    case "objectTitle":
      return staticSearchFqObjectTitle(siteRequest_, o);
    case "objectId":
      return staticSearchFqObjectId(siteRequest_, o);
    case "objectSuggest":
      return staticSearchFqObjectSuggest(siteRequest_, o);
    case "objectText":
      return staticSearchFqObjectText(siteRequest_, o);
    case "pageUrlId":
      return staticSearchFqPageUrlId(siteRequest_, o);
    case "pageUrlPk":
      return staticSearchFqPageUrlPk(siteRequest_, o);
    case "pageUrlApi":
      return staticSearchFqPageUrlApi(siteRequest_, o);
    case "id":
      return staticSearchFqId(siteRequest_, o);
      default:
        return null;
    }
  }

  public <SiteRequest extends ComputateSiteRequest> String searchBaseModelFq(SiteRequest siteRequest, SearchList<?> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    if(StringUtils.startsWith(valueIndexed, "[")) {
      String[] fqs = StringUtils.substringAfter(StringUtils.substringBeforeLast(valueIndexed, "]"), "[").split(" TO ");
      if(fqs.length != 2)
        throw new RuntimeException(String.format("\"%s\" invalid range query. ", valueIndexed));
      String fq1 = fqs[0].equals("*") ? fqs[0] : staticSearchFqForClass(entityVar, siteRequest, fqs[0]);
      String fq2 = fqs[1].equals("*") ? fqs[1] : staticSearchFqForClass(entityVar, siteRequest, fqs[1]);
       return varIndexed + ":[" + fq1 + " TO " + fq2 + "]";
    } else {
      return varIndexed + ":" + SearchTool.escapeQueryChars(staticSearchFqForClass(entityVar, siteRequest, valueIndexed)).replace("\\", "\\\\");
    }
  }

  public void searchBaseModelSort(SearchList<?> searchList, String entityVar, String valueIndexed, String varIndexed) {
    if(varIndexed == null)
      throw new RuntimeException(String.format("\"%s\" is not an indexed entity. ", entityVar));
    searchList.sort(varIndexed, valueIndexed);
  }

  public void searchBaseModelRows(SearchList<?> searchList, Long valueRows) {
      searchList.rows(valueRows != null ? valueRows : 10L);
  }

  public void searchBaseModelStart(SearchList<?> searchList, Long valueStart) {
    searchList.start(valueStart);
  }

  public <SiteRequest extends ComputateSiteRequest, U extends ComputateSiteUser> void configureUserSearchApi(String uri, Router router, Class<SiteRequest> classSiteRequest, Class<U> classSiteUser, String userApiAddress, JsonObject config, WebClient webClient, List<String> authResources, List<String> classSimpleNames) {
    router.getWithRegex(String.format("(?<uri>%s)", uri.replace("/", "\\/"))).handler(handler -> {
      ServiceRequest serviceRequest = generateServiceRequest(handler);
      JsonObject query = new JsonObject();
      MultiMap queryParams = handler.queryParams();
      for(String name : queryParams.names()) {
        JsonArray array = query.getJsonArray(name);
        List<String> vals = queryParams.getAll(name);
        if(array == null) {
          array = new JsonArray();
          query.put(name, array);
        }
        for(String val : vals) {
          array.add(val);
        }
      }
      user(serviceRequest, classSiteRequest, classSiteUser, userApiAddress, "postSiteUserFuture", "patchSiteUserFuture", false).onSuccess(siteRequest -> {
        MultiMap multiMap = MultiMap.caseInsensitiveMultiMap()
            .add("grant_type", "urn:ietf:params:oauth:grant-type:uma-ticket")
            .add("audience", config.getString(ComputateConfigKeys.AUTH_CLIENT))
            .add("response_mode", "permissions");
        authResources.forEach(resource -> {
          multiMap.add("permission", String.format("%s#%s", resource, "GET"));
        });
        webClient.post(
            Integer.parseInt(config.getString(ComputateConfigKeys.AUTH_PORT))
            , config.getString(ComputateConfigKeys.AUTH_HOST_NAME)
            , config.getString(ComputateConfigKeys.AUTH_TOKEN_URI)
            )
            .ssl(Boolean.parseBoolean(config.getString(ComputateConfigKeys.AUTH_SSL)))
            .putHeader("Authorization", String.format("Bearer %s", siteRequest.getUser().principal().getString("access_token")))
            .expect(ResponsePredicate.status(200))
            .sendForm(multiMap).onFailure(ex -> {
          String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
          handler.fail(403, new RuntimeException("search failed"));
        }).onSuccess(authorizationDecision -> {
          try {
            JsonArray scopes = authorizationDecision.bodyAsJsonArray().stream().findFirst().map(decision -> ((JsonObject)decision).getJsonArray("scopes")).orElse(new JsonArray());
            List<String> rsnames = authorizationDecision.bodyAsJsonArray().stream().map(decision -> ((JsonObject)decision).getString("rsname")).collect(Collectors.toList());
            if(!scopes.contains("GET")) {
              String msg = String.format("403 FORBIDDEN user %s to %s %s", siteRequest.getUser().attributes().getJsonObject("accessToken").getString("preferred_username"), serviceRequest.getExtra().getString("method"), serviceRequest.getExtra().getString("uri"));
              handler.fail(403, new RuntimeException("search failed"));
            } else {
              siteRequest.setScopes(scopes.stream().map(o -> o.toString()).collect(Collectors.toList()));
              HttpServerRequest request = handler.request();
              String solrUsername = config.getString(ComputateConfigKeys.SOLR_USERNAME);
              String solrPassword = config.getString(ComputateConfigKeys.SOLR_PASSWORD);
              String solrHostName = config.getString(ComputateConfigKeys.SOLR_HOST_NAME);
              Integer solrPort = Integer.parseInt(config.getString(ComputateConfigKeys.SOLR_PORT));
              String solrCollection = config.getString(ComputateConfigKeys.SOLR_COLLECTION);
              Boolean solrSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.SOLR_SSL));

              SearchList<Object> searchList = new SearchList<Object>();
              String facetRange = null;
              Date facetRangeStart = null;
              Date facetRangeEnd = null;
              String facetRangeGap = null;
              String statsField = null;
              String statsFieldIndexed = null;
              searchList.setStore(true);
              searchList.q("*:*");
              searchList.setSiteRequest_(siteRequest);
              searchList.fq(String.format("classSimpleName_docvalues_string:%s", rsnames.stream().map(rsname -> classSimpleNames.get(authResources.indexOf(rsname))).collect(Collectors.joining(" OR ", "(", ")"))));

              for(String paramName : query.fieldNames()) {
                Object paramValuesObject = query.getValue(paramName);
                String entityVar = null;
                String valueIndexed = null;
                String varIndexed = null;
                String valueSort = null;
                Long valueStart = null;
                Long valueRows = null;
                String valueCursorMark = null;
                JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

                try {
                  if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
                    Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
                    if(mFacetPivot.find()) {
                      String solrLocalParams = mFacetPivot.group(1);
                      String[] entityVars = mFacetPivot.group(2).trim().split(",");
                      String[] varsIndexed = new String[entityVars.length];
                      for(Integer i = 0; i < entityVars.length; i++) {
                        entityVar = entityVars[i];
                        varsIndexed[i] = varIndexedBaseModel(entityVar);
                      }
                      searchList.facetPivot((solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
                    }
                  } else if(paramValuesObject != null) {
                    for(Object paramObject : paramObjects) {
                      if(paramName.equals("q")) {
                        Matcher mQ = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|\\^|$)))").matcher((String)paramObject);
                        StringBuffer sb = new StringBuffer();
                        while(mQ.find()) {
                          entityVar = mQ.group(1).trim();
                          valueIndexed = mQ.group(2).trim();
                          varIndexed = varIndexedBaseModel(entityVar);
                          String entityQ = searchBaseModelFq(siteRequest, searchList, entityVar, valueIndexed, varIndexed);
                          mQ.appendReplacement(sb, entityQ);
                        }
                        if(!sb.isEmpty()) {
                          mQ.appendTail(sb);
                          searchList.q(sb.toString());
                        }
                      } else if(paramName.equals("fq")) {
                        Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
                        StringBuffer sb = new StringBuffer();
                        while(mFq.find()) {
                          entityVar = mFq.group(1).trim();
                          valueIndexed = mFq.group(2).trim();
                          varIndexed = varIndexedBaseModel(entityVar);
                          String entityFq = searchBaseModelFq(siteRequest, searchList, entityVar, valueIndexed, varIndexed);
                          mFq.appendReplacement(sb, entityFq);
                        }
                        if(!sb.isEmpty()) {
                          mFq.appendTail(sb);
                          searchList.fq(sb.toString());
                        }
                      } else if(paramName.equals("sort")) {
                        entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                        valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                        varIndexed = varIndexedBaseModel(entityVar);
                        searchBaseModelSort(searchList, entityVar, valueIndexed, varIndexed);
                      } else if(paramName.equals("start")) {
                        valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                        searchBaseModelStart(searchList, valueStart);
                      } else if(paramName.equals("rows")) {
                        valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                        searchBaseModelRows(searchList, valueRows);
                      } else if(paramName.equals("stats")) {
                        searchList.stats((Boolean)paramObject);
                      } else if(paramName.equals("stats.field")) {
                        Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                        if(mStats.find()) {
                          String solrLocalParams = mStats.group(1);
                          entityVar = mStats.group(2).trim();
                          varIndexed = varIndexedBaseModel(entityVar);
                          searchList.statsField((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                          statsField = entityVar;
                          statsFieldIndexed = varIndexed;
                        }
                      } else if(paramName.equals("facet")) {
                        searchList.facet((Boolean)paramObject);
                      } else if(paramName.equals("facet.range.start")) {
                        String startMathStr = (String)paramObject;
                        Date start = SearchTool.parseMath(startMathStr);
                        searchList.facetRangeStart(start.toInstant().toString());
                        facetRangeStart = start;
                      } else if(paramName.equals("facet.range.end")) {
                        String endMathStr = (String)paramObject;
                        Date end = SearchTool.parseMath(endMathStr);
                        searchList.facetRangeEnd(end.toInstant().toString());
                        facetRangeEnd = end;
                      } else if(paramName.equals("facet.range.gap")) {
                        String gap = (String)paramObject;
                        searchList.facetRangeGap(gap);
                        facetRangeGap = gap;
                      } else if(paramName.equals("facet.range")) {
                        Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                        if(mFacetRange.find()) {
                          String solrLocalParams = mFacetRange.group(1);
                          entityVar = mFacetRange.group(2).trim();
                          varIndexed = varIndexedBaseModel(entityVar);
                          searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                          facetRange = entityVar;
                        }
                      } else if(paramName.equals("facet.field")) {
                        entityVar = (String)paramObject;
                        varIndexed = varIndexedBaseModel(entityVar);
                        if(varIndexed != null)
                          searchList.facetField(varIndexed);
                      } else if(paramName.equals("cursorMark")) {
                        valueCursorMark = (String)paramObject;
                        searchList.cursorMark((String)paramObject);
                      }
                    }
                  }
                } catch(Exception e) {
                  ExceptionUtils.rethrow(e);
                }
              }

              searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {

                HttpServerResponse response = handler.response();
                response.putHeader("content-type", "application/json");
                List<String> fls = searchList.getRequest().getFields();
                JsonObject json = new JsonObject();
                JsonArray l = new JsonArray();
                searchList.getList().stream().forEach(o -> {
                  JsonObject json2 = JsonObject.mapFrom(o);
                  if(fls.size() > 0) {
                    Set<String> fieldNames = new HashSet<String>();
                    for(String fieldName : json2.fieldNames()) {
                      String v = varIndexedBaseModel(fieldName);
                      if(v != null)
                        fieldNames.add(varIndexedBaseModel(fieldName));
                    }
                    if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
                      fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
                      fieldNames.remove("_docvalues_long");
                      fieldNames.remove("created_docvalues_date");
                    }
                    else if(fls.size() >= 1) {
                      fieldNames.removeAll(fls);
                    }
                    for(String fieldName : fieldNames) {
                      if(!fls.contains(fieldName))
                        json2.remove(fieldName);
                    }
                  }
                  l.add(json2);
                });
                json.put("list", l);

                SolrResponse responseSearch = searchList.getResponse();
                SearchRequest searchRequest = searchList.getRequest();
                List<SolrResponse.Doc> solrDocuments = responseSearch.getResponse().getDocs();
                Long searchInMillis = Long.valueOf(responseSearch.getResponseHeader().getqTime());
                Long startNum = searchRequest.getStart();
                Long foundNum = responseSearch.getResponse().getNumFound();
                Integer returnedNum = responseSearch.getResponse().getDocs().size();
                String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
                String nextCursorMark = responseSearch.getNextCursorMark();
                String exceptionSearch = Optional.ofNullable(responseSearch.getError()).map(error -> error.getMsg()).orElse(null);

                json.put("startNum", startNum);
                json.put("foundNum", foundNum);
                json.put("returnedNum", returnedNum);
                if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
                  json.put("searchTime", searchTime);
                }
                Optional.ofNullable(responseSearch.getStats()).map(s -> s.getStatsFields()).map(s -> s.getFields()).ifPresent(stats -> {
                  JsonObject stats2 = new JsonObject();
                  stats.forEach((key, val) -> {
                    JsonObject values = JsonObject.mapFrom(val);
                    String var = searchVar(key);
                    values.remove("name");
                    values.put("var", var);
                    stats2.put(var, values);
                  });
                  json.put("stats", stats2);
                });
                Optional.ofNullable(responseSearch.getFacetCounts()).ifPresent(facetCounts -> {
                  JsonObject facetCounts2 = new JsonObject();
                  Optional.ofNullable(facetCounts.getFacetFields()).map(f -> f.getFacets()).ifPresent(facets -> {
                    JsonObject facets2 = new JsonObject();
                    for(SolrResponse.FacetField facetField : facets.values()) {
                      String facetFieldVar = searchVar(facetField.getName());
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
                      String facetFieldVar = searchVar(facetField.getName());
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
                      String facetFieldVar = searchVar(facetField.getName());
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
                    responsePivotSearch(facets, pivotMap);
                    facetCounts2.put("facet_pivot", pivotMap);
                  });
                  Optional.ofNullable(facetCounts.getFacetQueries()).map(f -> f.getFacets()).ifPresent(facets -> {
                    JsonObject facets2 = new JsonObject();
                    facetCounts2.put("facet_queries", facets2);
                  });
                  Optional.ofNullable(facetCounts.getFacetRanges()).map(f -> f.getRanges()).ifPresent(facets -> {
                    JsonObject facets2 = new JsonObject();
                    for(SolrResponse.FacetRange facetField : facets.values()) {
                      JsonObject rangeFacetJson = new JsonObject();
                      String rangeFacetVar = searchVar(facetField.getName());
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
                response.end(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()));
              }).onFailure(ex -> {
                handler.fail(ex);
                LOG.error(String.format("Solr search failed. "), ex);
              });
            }
          } catch(Exception ex) {
            LOG.error("search failed", ex);
            handler.fail(500, new RuntimeException("search failed"));
          }
        });
      }).onFailure(ex -> {
        if("Inactive Token".equals(ex.getMessage()) || StringUtils.startsWith(ex.getMessage(), "invalid_grant:")) {
          try {
            handler.redirect(config.getString(ComputateConfigKeys.AUTH_LOGOUT_URI));
          } catch(Exception ex2) {
            LOG.error("search login redirect failed", ex2);
            handler.fail(401, new RuntimeException("SSO Resource Permission check returned DENY"));
          }
        } else if(StringUtils.startsWith(ex.getMessage(), "401 UNAUTHORIZED ")) {
          handler.fail(401, new RuntimeException("SSO Resource Permission check returned DENY"));
        } else {
          LOG.error("search failed", ex);
          handler.fail(401, new RuntimeException("SSO Resource Permission check failed"));
        }
      });
    });
  }

  public <SiteRequest extends ComputateSiteRequest, U extends ComputateSiteUser> void configurePublicSearchApi(String uri, Router router, Class<SiteRequest> classSiteRequest, JsonObject config, WebClient webClient, List<String> classSimpleNames) {
    router.getWithRegex(String.format("(?<uri>%s)", uri.replace("/", "\\/"))).handler(handler -> {
      try {
        ServiceRequest serviceRequest = generateServiceRequest(handler);
        JsonObject query = new JsonObject();
        MultiMap queryParams = handler.queryParams();
        for(String name : queryParams.names()) {
          JsonArray array = query.getJsonArray(name);
          List<String> vals = queryParams.getAll(name);
          if(array == null) {
            array = new JsonArray();
            query.put(name, array);
          }
          for(String val : vals) {
            array.add(val);
          }
        }
        HttpServerRequest request = handler.request();
        String solrUsername = config.getString(ComputateConfigKeys.SOLR_USERNAME);
        String solrPassword = config.getString(ComputateConfigKeys.SOLR_PASSWORD);
        String solrHostName = config.getString(ComputateConfigKeys.SOLR_HOST_NAME);
        Integer solrPort = Integer.parseInt(config.getString(ComputateConfigKeys.SOLR_PORT));
        String solrCollection = config.getString(ComputateConfigKeys.SOLR_COLLECTION);
        Boolean solrSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.SOLR_SSL));

        SiteRequest siteRequest = generateSiteRequest(null, config, serviceRequest, classSiteRequest);
        siteRequest.setPublicRead(true);

        SearchList<Object> searchList = new SearchList<Object>();
        String facetRange = null;
        Date facetRangeStart = null;
        Date facetRangeEnd = null;
        String facetRangeGap = null;
        String statsField = null;
        String statsFieldIndexed = null;
        searchList.setStore(true);
        searchList.q("*:*");
        searchList.setSiteRequest_(siteRequest);
        searchList.fq(String.format("classSimpleName_docvalues_string:%s", classSimpleNames.stream().collect(Collectors.joining(" OR ", "(", ")"))));

        for(String paramName : query.fieldNames()) {
          Object paramValuesObject = query.getValue(paramName);
          String entityVar = null;
          String valueIndexed = null;
          String varIndexed = null;
          String valueSort = null;
          Long valueStart = null;
          Long valueRows = null;
          String valueCursorMark = null;
          JsonArray paramObjects = paramValuesObject instanceof JsonArray ? (JsonArray)paramValuesObject : new JsonArray().add(paramValuesObject);

          if(paramValuesObject != null && "facet.pivot".equals(paramName)) {
            Matcher mFacetPivot = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher(StringUtils.join(paramObjects.getList().toArray(), ","));
            if(mFacetPivot.find()) {
              String solrLocalParams = mFacetPivot.group(1);
              String[] entityVars = mFacetPivot.group(2).trim().split(",");
              String[] varsIndexed = new String[entityVars.length];
              for(Integer i = 0; i < entityVars.length; i++) {
                entityVar = entityVars[i];
                varsIndexed[i] = varIndexedBaseModel(entityVar);
              }
              searchList.facetPivot((solrLocalParams == null ? "" : solrLocalParams) + StringUtils.join(varsIndexed, ","));
            }
          } else if(paramValuesObject != null) {
            for(Object paramObject : paramObjects) {
              if(paramName.equals("q")) {
                Matcher mQ = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|\\^|$)))").matcher((String)paramObject);
                StringBuffer sb = new StringBuffer();
                while(mQ.find()) {
                  entityVar = mQ.group(1).trim();
                  valueIndexed = mQ.group(2).trim();
                  varIndexed = varIndexedBaseModel(entityVar);
                  String entityQ = searchBaseModelFq(siteRequest, searchList, entityVar, valueIndexed, varIndexed);
                  mQ.appendReplacement(sb, entityQ);
                }
                if(!sb.isEmpty()) {
                  mQ.appendTail(sb);
                  searchList.q(sb.toString());
                }
              } else if(paramName.equals("fq")) {
                Matcher mFq = Pattern.compile("(\\w+):(.+?(?=(\\)|\\s+OR\\s+|\\s+AND\\s+|$)))").matcher((String)paramObject);
                StringBuffer sb = new StringBuffer();
                while(mFq.find()) {
                  entityVar = mFq.group(1).trim();
                  valueIndexed = mFq.group(2).trim();
                  varIndexed = varIndexedBaseModel(entityVar);
                  String entityFq = searchBaseModelFq(siteRequest, searchList, entityVar, valueIndexed, varIndexed);
                  mFq.appendReplacement(sb, entityFq);
                }
                if(!sb.isEmpty()) {
                  mFq.appendTail(sb);
                  searchList.fq(sb.toString());
                }
              } else if(paramName.equals("sort")) {
                entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, " "));
                valueIndexed = StringUtils.trim(StringUtils.substringAfter((String)paramObject, " "));
                varIndexed = varIndexedBaseModel(entityVar);
                searchBaseModelSort(searchList, entityVar, valueIndexed, varIndexed);
              } else if(paramName.equals("start")) {
                valueStart = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchBaseModelStart(searchList, valueStart);
              } else if(paramName.equals("rows")) {
                valueRows = paramObject instanceof Long ? (Long)paramObject : Long.parseLong(paramObject.toString());
                searchBaseModelRows(searchList, valueRows);
              } else if(paramName.equals("stats")) {
                searchList.stats((Boolean)paramObject);
              } else if(paramName.equals("stats.field")) {
                Matcher mStats = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mStats.find()) {
                  String solrLocalParams = mStats.group(1);
                  entityVar = mStats.group(2).trim();
                  varIndexed = varIndexedBaseModel(entityVar);
                  searchList.statsField((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  statsField = entityVar;
                  statsFieldIndexed = varIndexed;
                }
              } else if(paramName.equals("facet")) {
                searchList.facet((Boolean)paramObject);
              } else if(paramName.equals("facet.range.start")) {
                String startMathStr = (String)paramObject;
                Date start = SearchTool.parseMath(startMathStr);
                searchList.facetRangeStart(start.toInstant().toString());
                facetRangeStart = start;
              } else if(paramName.equals("facet.range.end")) {
                String endMathStr = (String)paramObject;
                Date end = SearchTool.parseMath(endMathStr);
                searchList.facetRangeEnd(end.toInstant().toString());
                facetRangeEnd = end;
              } else if(paramName.equals("facet.range.gap")) {
                String gap = (String)paramObject;
                searchList.facetRangeGap(gap);
                facetRangeGap = gap;
              } else if(paramName.equals("facet.range")) {
                Matcher mFacetRange = Pattern.compile("(?:(\\{![^\\}]+\\}))?(.*)").matcher((String)paramObject);
                if(mFacetRange.find()) {
                  String solrLocalParams = mFacetRange.group(1);
                  entityVar = mFacetRange.group(2).trim();
                  varIndexed = varIndexedBaseModel(entityVar);
                  searchList.facetRange((solrLocalParams == null ? "" : solrLocalParams) + varIndexed);
                  facetRange = entityVar;
                }
              } else if(paramName.equals("facet.field")) {
                entityVar = (String)paramObject;
                varIndexed = varIndexedBaseModel(entityVar);
                if(varIndexed != null) {
                  searchList.facetField(varIndexed);
                }
              } else if(paramName.equals("cursorMark")) {
                valueCursorMark = (String)paramObject;
                searchList.cursorMark((String)paramObject);
              }
            }
          }
        }

        searchList.promiseDeepForClass(siteRequest).onSuccess(a -> {
          HttpServerResponse response = handler.response();
          response.putHeader("content-type", "application/json");
          List<String> fls = searchList.getRequest().getFields();
          JsonObject json = new JsonObject();
          JsonArray l = new JsonArray();
          searchList.getList().stream().forEach(o -> {
            JsonObject json2 = JsonObject.mapFrom(o);
            if(fls.size() > 0) {
              Set<String> fieldNames = new HashSet<String>();
              for(String fieldName : json2.fieldNames()) {
                String v = varIndexedBaseModel(fieldName);
                if(v != null)
                  fieldNames.add(varIndexedBaseModel(fieldName));
              }
              if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves_docvalues_strings")) {
                fieldNames.removeAll(Optional.ofNullable(json2.getJsonArray("saves_docvalues_strings")).orElse(new JsonArray()).stream().map(s -> s.toString()).collect(Collectors.toList()));
                fieldNames.remove("_docvalues_long");
                fieldNames.remove("created_docvalues_date");
              }
              else if(fls.size() >= 1) {
                fieldNames.removeAll(fls);
              }
              for(String fieldName : fieldNames) {
                if(!fls.contains(fieldName))
                  json2.remove(fieldName);
              }
            }
            l.add(json2);
          });
          json.put("list", l);

          SolrResponse responseSearch = searchList.getResponse();
          SearchRequest searchRequest = searchList.getRequest();
          List<SolrResponse.Doc> solrDocuments = responseSearch.getResponse().getDocs();
          Long searchInMillis = Long.valueOf(responseSearch.getResponseHeader().getqTime());
          Long startNum = searchRequest.getStart();
          Long foundNum = responseSearch.getResponse().getNumFound();
          Integer returnedNum = responseSearch.getResponse().getDocs().size();
          String searchTime = String.format("%d.%03d sec", TimeUnit.MILLISECONDS.toSeconds(searchInMillis), TimeUnit.MILLISECONDS.toMillis(searchInMillis) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(searchInMillis)));
          String nextCursorMark = responseSearch.getNextCursorMark();
          String exceptionSearch = Optional.ofNullable(responseSearch.getError()).map(error -> error.getMsg()).orElse(null);

          json.put("startNum", startNum);
          json.put("foundNum", foundNum);
          json.put("returnedNum", returnedNum);
          if(fls.size() == 1 && fls.stream().findFirst().orElse(null).equals("saves")) {
            json.put("searchTime", searchTime);
          }
          Optional.ofNullable(responseSearch.getStats()).map(s -> s.getStatsFields()).map(s -> s.getFields()).ifPresent(stats -> {
            JsonObject stats2 = new JsonObject();
            stats.forEach((key, val) -> {
              JsonObject values = JsonObject.mapFrom(val);
              String var = searchVar(key);
              values.remove("name");
              values.put("var", var);
              stats2.put(var, values);
            });
            json.put("stats", stats2);
          });
          Optional.ofNullable(responseSearch.getFacetCounts()).ifPresent(facetCounts -> {
            JsonObject facetCounts2 = new JsonObject();
            Optional.ofNullable(facetCounts.getFacetFields()).map(f -> f.getFacets()).ifPresent(facets -> {
              JsonObject facets2 = new JsonObject();
              for(SolrResponse.FacetField facetField : facets.values()) {
                String facetFieldVar = searchVar(facetField.getName());
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
                String facetFieldVar = searchVar(facetField.getName());
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
                String facetFieldVar = searchVar(facetField.getName());
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
              responsePivotSearch(facets, pivotMap);
              facetCounts2.put("facet_pivot", pivotMap);
            });
            Optional.ofNullable(facetCounts.getFacetQueries()).map(f -> f.getFacets()).ifPresent(facets -> {
              JsonObject facets2 = new JsonObject();
              facetCounts2.put("facet_queries", facets2);
            });
            Optional.ofNullable(facetCounts.getFacetRanges()).map(f -> f.getRanges()).ifPresent(facets -> {
              JsonObject facets2 = new JsonObject();
              for(SolrResponse.FacetRange facetField : facets.values()) {
                JsonObject rangeFacetJson = new JsonObject();
                String rangeFacetVar = searchVar(facetField.getName());
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
          response.end(Buffer.buffer(Optional.ofNullable(json).orElse(new JsonObject()).encodePrettily()));
        }).onFailure(ex -> {
          LOG.error(String.format("Solr search failed. "), ex);
          handler.fail(ex);
        });
      } catch(Exception ex) {
          LOG.error(String.format("Solr search failed. "), ex);
        handler.fail(ex);
      }
    });
  }

  public Future<Void> listPUTImportSmartDataModel(RoutingContext eventHandler) {
    Promise<Void> promise = Promise.promise();
    List<Future<?>> futures = new ArrayList<>();
    JsonArray jsonArray = Optional.ofNullable(eventHandler.body().asJsonObject()).map(o -> o.getJsonArray("data")).orElse(new JsonArray());
    try {
      String ngsildHostName = config.getString(ComputateConfigKeys.CONTEXT_BROKER_HOST_NAME);
      Integer ngsildPort = Integer.parseInt(config.getString(ComputateConfigKeys.CONTEXT_BROKER_PORT));
      Boolean ngsildSsl = Boolean.parseBoolean(config.getString(ComputateConfigKeys.CONTEXT_BROKER_SSL));

      MultiMap headers = eventHandler.request().headers();
      final String fiwareService = headers.get("Fiware-Service");
      final String fiwareServicePath = headers.get("Fiware-ServicePath");
      final String ngsildTenant = headers.get("NGSILD-Tenant");
      final String ngsildPath = headers.get("NGSILD-Path");
      final String computateApi = headers.get("Computate-API");
      final String computateClassSimpleName = headers.get("Computate-ClassSimpleName");
      final String link = headers.get("Link");

      jsonArray.forEach(subscriptionObj -> {
        JsonObject subscriptionEntity = (JsonObject)subscriptionObj;
        futures.add(Future.future(promise1 -> {
          try {
            JsonObject importData = new JsonObject();
            String entityId = subscriptionEntity.getString("id");
            String entityType = subscriptionEntity.getString("type");
            String ngsildUri = String.format("/ngsi-ld/v1/entities/%s", URLEncoder.encode(entityId, "UTF-8"));
  
            webClient.get(ngsildPort, ngsildHostName, ngsildUri).ssl(ngsildSsl)
                .putHeader("Fiware-Service", fiwareService)
                .putHeader("Fiware-ServicePath", fiwareServicePath)
                .putHeader("NGSILD-Tenant", ngsildTenant)
                .putHeader("NGSILD-Path", ngsildPath)
                .putHeader("Link", link)
                .putHeader("Accept", "*/*")
                .send()
                .expecting(HttpResponseExpectation.SC_OK)
                .onSuccess(entityResponse -> {
              LOG.debug(String.format("Context Broker request received %s", entityResponse.bodyAsJsonObject()));
              JsonObject entity = entityResponse.bodyAsJsonObject();
              importData.put("setNgsildData", entity);

              JsonObject headers2 = new JsonObject();
              headers2.put("Fiware-Service", fiwareService);
              headers2.put("Fiware-ServicePath", fiwareServicePath);
              headers2.put("NGSILD-Tenant", ngsildTenant);
              headers2.put("NGSILD-Path", ngsildPath);
              headers2.put("Link", link);
              headers2.put("Content-Type", "application/json");

              JsonObject params = new JsonObject();
              params.put("body", importData);
              params.put("path", new JsonObject());
              params.put("cookie", new JsonObject());
              params.put("header", headers2);
              params.put("form", new JsonObject());
              JsonObject query = new JsonObject().put("fq", new JsonArray().add(String.format("entityId:%s", entityId)));
              query.put("softCommit", true);
              params.put("query", query);
              JsonObject context = new JsonObject().put("params", params);
              JsonObject json = new JsonObject().put("context", context);
              eventBus.request(computateApi, json, new DeliveryOptions().addHeader("action", String.format("patch%sFuture", computateClassSimpleName))).onSuccess(a -> {
                promise1.complete();
              }).onFailure(ex -> {
                LOG.error(String.format("listPUTImportSmartDataModel failed. "), ex);
                promise1.fail(ex);
              });
            }).onFailure(ex -> {
              LOG.error(String.format("listPUTImportSmartDataModel failed. "), new RuntimeException(ex));
              promise1.fail(ex);
            });
          } catch(Exception ex) {
            LOG.error(String.format("listPUTImportSmartDataModel failed. "), new RuntimeException(ex));
            promise1.fail(ex);
          }
        }));
      });
      Future.all(futures).onSuccess(a -> {
        promise.complete();
      }).onFailure(ex -> {
        LOG.error(String.format("listPUTImportSmartDataModel failed. "), ex);
        promise.fail(ex);
      });
    } catch(Exception ex) {
      LOG.error(String.format("listPUTImportSmartDataModel failed. "), ex);
      promise.fail(ex);
    }
    return promise.future();
  }

  public static String urlEncode(String str) {
    try {
      return URLEncoder.encode(str, "UTF-8");
    } catch(Throwable ex) {
      ExceptionUtils.rethrow(ex);
      return null;
    }
  }

  public abstract String searchVar(String varIndexed);

  public abstract String getClassApiAddress();

  public void calendarStuff() {
    
  }
}
