package org.computate.vertx.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.vertx.ext.web.client.WebClient;
import org.computate.vertx.model.user.ComputateVertxSiteUser;
import org.slf4j.LoggerFactory;
import io.vertx.core.MultiMap;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.search.request.SiteRequest;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
import io.vertx.sqlclient.SqlConnection;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import java.math.RoundingMode;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import io.vertx.ext.web.api.service.ServiceRequest;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import io.vertx.core.json.JsonArray;
import java.util.List;
import io.vertx.ext.auth.User;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ComputateVertxSiteRequestGen<DEV> extends SiteRequest {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateVertxSiteRequest.class);

	////////////
	// config //
	////////////

	/**	 The entity config
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonObject config;

	/**	<br> The entity config
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:config">Find the entity config in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _config(Wrap<JsonObject> c);

	public JsonObject getConfig() {
		return config;
	}

	public void setConfig(JsonObject config) {
		this.config = config;
	}
	public static JsonObject staticSetConfig(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest configInit() {
		Wrap<JsonObject> configWrap = new Wrap<JsonObject>().var("config");
		if(config == null) {
			_config(configWrap);
			setConfig(configWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateVertxSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<ComputateVertxSiteRequest> c);

	public ComputateVertxSiteRequest getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(ComputateVertxSiteRequest siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static ComputateVertxSiteRequest staticSetSiteRequest_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest siteRequest_Init() {
		Wrap<ComputateVertxSiteRequest> siteRequest_Wrap = new Wrap<ComputateVertxSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	///////////////
	// webClient //
	///////////////

	/**	 The entity webClient
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected WebClient webClient;

	/**	<br> The entity webClient
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:webClient">Find the entity webClient in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _webClient(Wrap<WebClient> c);

	public WebClient getWebClient() {
		return webClient;
	}

	public void setWebClient(WebClient webClient) {
		this.webClient = webClient;
	}
	public static WebClient staticSetWebClient(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest webClientInit() {
		Wrap<WebClient> webClientWrap = new Wrap<WebClient>().var("webClient");
		if(webClient == null) {
			_webClient(webClientWrap);
			setWebClient(webClientWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	/////////////////
	// apiRequest_ //
	/////////////////

	/**	 The entity apiRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ApiRequest apiRequest_;

	/**	<br> The entity apiRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:apiRequest_">Find the entity apiRequest_ in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _apiRequest_(Wrap<ApiRequest> c);

	public ApiRequest getApiRequest_() {
		return apiRequest_;
	}

	public void setApiRequest_(ApiRequest apiRequest_) {
		this.apiRequest_ = apiRequest_;
	}
	public static ApiRequest staticSetApiRequest_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest apiRequest_Init() {
		Wrap<ApiRequest> apiRequest_Wrap = new Wrap<ApiRequest>().var("apiRequest_");
		if(apiRequest_ == null) {
			_apiRequest_(apiRequest_Wrap);
			setApiRequest_(apiRequest_Wrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	////////////////
	// jsonObject //
	////////////////

	/**	 The entity jsonObject
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonObject jsonObject;

	/**	<br> The entity jsonObject
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:jsonObject">Find the entity jsonObject in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _jsonObject(Wrap<JsonObject> c);

	public JsonObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JsonObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	public static JsonObject staticSetJsonObject(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest jsonObjectInit() {
		Wrap<JsonObject> jsonObjectWrap = new Wrap<JsonObject>().var("jsonObject");
		if(jsonObject == null) {
			_jsonObject(jsonObjectWrap);
			setJsonObject(jsonObjectWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	////////////////////
	// serviceRequest //
	////////////////////

	/**	 The entity serviceRequest
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ServiceRequest serviceRequest;

	/**	<br> The entity serviceRequest
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:serviceRequest">Find the entity serviceRequest in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _serviceRequest(Wrap<ServiceRequest> c);

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
	public static ServiceRequest staticSetServiceRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest serviceRequestInit() {
		Wrap<ServiceRequest> serviceRequestWrap = new Wrap<ServiceRequest>().var("serviceRequest");
		if(serviceRequest == null) {
			_serviceRequest(serviceRequestWrap);
			setServiceRequest(serviceRequestWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	//////////
	// user //
	//////////

	/**	 The entity user
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected User user;

	/**	<br> The entity user
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:user">Find the entity user in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _user(Wrap<User> c);

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public static User staticSetUser(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest userInit() {
		Wrap<User> userWrap = new Wrap<User>().var("user");
		if(user == null) {
			_user(userWrap);
			setUser(userWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	////////////
	// userId //
	////////////

	/**	 The entity userId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userId;

	/**	<br> The entity userId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userId">Find the entity userId in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userId(Wrap<String> c);

	public String getUserId() {
		return userId;
	}
	public void setUserId(String o) {
		this.userId = ComputateVertxSiteRequest.staticSetUserId(siteRequest_, o);
	}
	public static String staticSetUserId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest userIdInit() {
		Wrap<String> userIdWrap = new Wrap<String>().var("userId");
		if(userId == null) {
			_userId(userIdWrap);
			setUserId(userIdWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrUserId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserId(siteRequest_, ComputateVertxSiteRequest.staticSolrUserId(siteRequest_, ComputateVertxSiteRequest.staticSetUserId(siteRequest_, o)));
	}

	/////////////
	// userKey //
	/////////////

	/**	 The entity userKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long userKey;

	/**	<br> The entity userKey
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKey">Find the entity userKey in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userKey(Wrap<Long> c);

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}
	@JsonIgnore
	public void setUserKey(String o) {
		this.userKey = ComputateVertxSiteRequest.staticSetUserKey(siteRequest_, o);
	}
	public static Long staticSetUserKey(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxSiteRequest userKeyInit() {
		Wrap<Long> userKeyWrap = new Wrap<Long>().var("userKey");
		if(userKey == null) {
			_userKey(userKeyWrap);
			setUserKey(userKeyWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static Long staticSolrUserKey(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrUserKey(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserKey(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserKey(siteRequest_, ComputateVertxSiteRequest.staticSolrUserKey(siteRequest_, ComputateVertxSiteRequest.staticSetUserKey(siteRequest_, o)));
	}

	///////////////
	// sessionId //
	///////////////

	/**	 The entity sessionId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String sessionId;

	/**	<br> The entity sessionId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sessionId">Find the entity sessionId in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sessionId(Wrap<String> c);

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String o) {
		this.sessionId = ComputateVertxSiteRequest.staticSetSessionId(siteRequest_, o);
	}
	public static String staticSetSessionId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest sessionIdInit() {
		Wrap<String> sessionIdWrap = new Wrap<String>().var("sessionId");
		if(sessionId == null) {
			_sessionId(sessionIdWrap);
			setSessionId(sessionIdWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrSessionId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSessionId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSessionId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrSessionId(siteRequest_, ComputateVertxSiteRequest.staticSolrSessionId(siteRequest_, ComputateVertxSiteRequest.staticSetSessionId(siteRequest_, o)));
	}

	/////////////////////
	// sessionIdBefore //
	/////////////////////

	/**	 The entity sessionIdBefore
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String sessionIdBefore;

	/**	<br> The entity sessionIdBefore
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sessionIdBefore">Find the entity sessionIdBefore in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sessionIdBefore(Wrap<String> c);

	public String getSessionIdBefore() {
		return sessionIdBefore;
	}
	public void setSessionIdBefore(String o) {
		this.sessionIdBefore = ComputateVertxSiteRequest.staticSetSessionIdBefore(siteRequest_, o);
	}
	public static String staticSetSessionIdBefore(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest sessionIdBeforeInit() {
		Wrap<String> sessionIdBeforeWrap = new Wrap<String>().var("sessionIdBefore");
		if(sessionIdBefore == null) {
			_sessionIdBefore(sessionIdBeforeWrap);
			setSessionIdBefore(sessionIdBeforeWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrSessionIdBefore(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSessionIdBefore(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSessionIdBefore(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrSessionIdBefore(siteRequest_, ComputateVertxSiteRequest.staticSolrSessionIdBefore(siteRequest_, ComputateVertxSiteRequest.staticSetSessionIdBefore(siteRequest_, o)));
	}

	//////////////
	// userName //
	//////////////

	/**	 The entity userName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userName;

	/**	<br> The entity userName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userName">Find the entity userName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userName(Wrap<String> c);

	public String getUserName() {
		return userName;
	}
	public void setUserName(String o) {
		this.userName = ComputateVertxSiteRequest.staticSetUserName(siteRequest_, o);
	}
	public static String staticSetUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest userNameInit() {
		Wrap<String> userNameWrap = new Wrap<String>().var("userName");
		if(userName == null) {
			_userName(userNameWrap);
			setUserName(userNameWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserName(siteRequest_, ComputateVertxSiteRequest.staticSolrUserName(siteRequest_, ComputateVertxSiteRequest.staticSetUserName(siteRequest_, o)));
	}

	//////////////////
	// userLastName //
	//////////////////

	/**	 The entity userLastName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userLastName;

	/**	<br> The entity userLastName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userLastName">Find the entity userLastName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userLastName(Wrap<String> c);

	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String o) {
		this.userLastName = ComputateVertxSiteRequest.staticSetUserLastName(siteRequest_, o);
	}
	public static String staticSetUserLastName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest userLastNameInit() {
		Wrap<String> userLastNameWrap = new Wrap<String>().var("userLastName");
		if(userLastName == null) {
			_userLastName(userLastNameWrap);
			setUserLastName(userLastNameWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrUserLastName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserLastName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserLastName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserLastName(siteRequest_, ComputateVertxSiteRequest.staticSolrUserLastName(siteRequest_, ComputateVertxSiteRequest.staticSetUserLastName(siteRequest_, o)));
	}

	///////////////////
	// userFirstName //
	///////////////////

	/**	 The entity userFirstName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userFirstName;

	/**	<br> The entity userFirstName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userFirstName">Find the entity userFirstName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userFirstName(Wrap<String> c);

	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String o) {
		this.userFirstName = ComputateVertxSiteRequest.staticSetUserFirstName(siteRequest_, o);
	}
	public static String staticSetUserFirstName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest userFirstNameInit() {
		Wrap<String> userFirstNameWrap = new Wrap<String>().var("userFirstName");
		if(userFirstName == null) {
			_userFirstName(userFirstNameWrap);
			setUserFirstName(userFirstNameWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrUserFirstName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserFirstName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserFirstName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserFirstName(siteRequest_, ComputateVertxSiteRequest.staticSolrUserFirstName(siteRequest_, ComputateVertxSiteRequest.staticSetUserFirstName(siteRequest_, o)));
	}

	//////////////////
	// userFullName //
	//////////////////

	/**	 The entity userFullName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userFullName;

	/**	<br> The entity userFullName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userFullName">Find the entity userFullName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userFullName(Wrap<String> c);

	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String o) {
		this.userFullName = ComputateVertxSiteRequest.staticSetUserFullName(siteRequest_, o);
	}
	public static String staticSetUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest userFullNameInit() {
		Wrap<String> userFullNameWrap = new Wrap<String>().var("userFullName");
		if(userFullName == null) {
			_userFullName(userFullNameWrap);
			setUserFullName(userFullNameWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserFullName(siteRequest_, ComputateVertxSiteRequest.staticSolrUserFullName(siteRequest_, ComputateVertxSiteRequest.staticSetUserFullName(siteRequest_, o)));
	}

	///////////////
	// userEmail //
	///////////////

	/**	 The entity userEmail
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userEmail;

	/**	<br> The entity userEmail
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userEmail">Find the entity userEmail in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userEmail(Wrap<String> c);

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String o) {
		this.userEmail = ComputateVertxSiteRequest.staticSetUserEmail(siteRequest_, o);
	}
	public static String staticSetUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest userEmailInit() {
		Wrap<String> userEmailWrap = new Wrap<String>().var("userEmail");
		if(userEmail == null) {
			_userEmail(userEmailWrap);
			setUserEmail(userEmailWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserEmail(siteRequest_, ComputateVertxSiteRequest.staticSolrUserEmail(siteRequest_, ComputateVertxSiteRequest.staticSetUserEmail(siteRequest_, o)));
	}

	////////////////////
	// userRealmRoles //
	////////////////////

	/**	 The entity userRealmRoles
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> userRealmRoles = new ArrayList<String>();

	/**	<br> The entity userRealmRoles
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userRealmRoles">Find the entity userRealmRoles in Solr</a>
	 * <br>
	 * @param o is the entity already constructed. 
	 **/
	protected abstract void _userRealmRoles(List<String> o);

	public List<String> getUserRealmRoles() {
		return userRealmRoles;
	}

	public void setUserRealmRoles(List<String> userRealmRoles) {
		this.userRealmRoles = userRealmRoles;
	}
	public static String staticSetUserRealmRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateVertxSiteRequest addUserRealmRoles(String...objets) {
		for(String o : objets) {
			addUserRealmRoles(o);
		}
		return (ComputateVertxSiteRequest)this;
	}
	public ComputateVertxSiteRequest addUserRealmRoles(String o) {
		if(o != null)
			this.userRealmRoles.add(o);
		return (ComputateVertxSiteRequest)this;
	}
	@JsonIgnore
	public void setUserRealmRoles(JsonArray objets) {
		userRealmRoles.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addUserRealmRoles(o);
		}
	}
	protected ComputateVertxSiteRequest userRealmRolesInit() {
		_userRealmRoles(userRealmRoles);
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrUserRealmRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserRealmRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserRealmRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserRealmRoles(siteRequest_, ComputateVertxSiteRequest.staticSolrUserRealmRoles(siteRequest_, ComputateVertxSiteRequest.staticSetUserRealmRoles(siteRequest_, o)));
	}

	//////////////////
	// userResource //
	//////////////////

	/**	 The entity userResource
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonObject userResource;

	/**	<br> The entity userResource
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userResource">Find the entity userResource in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userResource(Wrap<JsonObject> c);

	public JsonObject getUserResource() {
		return userResource;
	}

	public void setUserResource(JsonObject userResource) {
		this.userResource = userResource;
	}
	public static JsonObject staticSetUserResource(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest userResourceInit() {
		Wrap<JsonObject> userResourceWrap = new Wrap<JsonObject>().var("userResource");
		if(userResource == null) {
			_userResource(userResourceWrap);
			setUserResource(userResourceWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	///////////////////////
	// userResourceRoles //
	///////////////////////

	/**	 The entity userResourceRoles
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> userResourceRoles = new ArrayList<String>();

	/**	<br> The entity userResourceRoles
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userResourceRoles">Find the entity userResourceRoles in Solr</a>
	 * <br>
	 * @param o is the entity already constructed. 
	 **/
	protected abstract void _userResourceRoles(List<String> o);

	public List<String> getUserResourceRoles() {
		return userResourceRoles;
	}

	public void setUserResourceRoles(List<String> userResourceRoles) {
		this.userResourceRoles = userResourceRoles;
	}
	public static String staticSetUserResourceRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateVertxSiteRequest addUserResourceRoles(String...objets) {
		for(String o : objets) {
			addUserResourceRoles(o);
		}
		return (ComputateVertxSiteRequest)this;
	}
	public ComputateVertxSiteRequest addUserResourceRoles(String o) {
		if(o != null)
			this.userResourceRoles.add(o);
		return (ComputateVertxSiteRequest)this;
	}
	@JsonIgnore
	public void setUserResourceRoles(JsonArray objets) {
		userResourceRoles.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addUserResourceRoles(o);
		}
	}
	protected ComputateVertxSiteRequest userResourceRolesInit() {
		_userResourceRoles(userResourceRoles);
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrUserResourceRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserResourceRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserResourceRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrUserResourceRoles(siteRequest_, ComputateVertxSiteRequest.staticSolrUserResourceRoles(siteRequest_, ComputateVertxSiteRequest.staticSetUserResourceRoles(siteRequest_, o)));
	}

	///////////////
	// siteUser_ //
	///////////////

	/**	 The entity siteUser_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateVertxSiteUser siteUser_;

	/**	<br> The entity siteUser_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteUser_">Find the entity siteUser_ in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteUser_(Wrap<ComputateVertxSiteUser> c);

	public ComputateVertxSiteUser getSiteUser_() {
		return siteUser_;
	}

	public void setSiteUser_(ComputateVertxSiteUser siteUser_) {
		this.siteUser_ = siteUser_;
	}
	public static ComputateVertxSiteUser staticSetSiteUser_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest siteUser_Init() {
		Wrap<ComputateVertxSiteUser> siteUser_Wrap = new Wrap<ComputateVertxSiteUser>().var("siteUser_");
		if(siteUser_ == null) {
			_siteUser_(siteUser_Wrap);
			setSiteUser_(siteUser_Wrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	//////////////////
	// solrDocument //
	//////////////////

	/**	 The entity solrDocument
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonObject solrDocument;

	/**	<br> The entity solrDocument
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:solrDocument">Find the entity solrDocument in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _solrDocument(Wrap<JsonObject> c);

	public JsonObject getSolrDocument() {
		return solrDocument;
	}

	public void setSolrDocument(JsonObject solrDocument) {
		this.solrDocument = solrDocument;
	}
	public static JsonObject staticSetSolrDocument(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest solrDocumentInit() {
		Wrap<JsonObject> solrDocumentWrap = new Wrap<JsonObject>().var("solrDocument");
		if(solrDocument == null) {
			_solrDocument(solrDocumentWrap);
			setSolrDocument(solrDocumentWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	///////////////
	// pageAdmin //
	///////////////

	/**	 The entity pageAdmin
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean pageAdmin;

	/**	<br> The entity pageAdmin
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageAdmin">Find the entity pageAdmin in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageAdmin(Wrap<Boolean> c);

	public Boolean getPageAdmin() {
		return pageAdmin;
	}

	public void setPageAdmin(Boolean pageAdmin) {
		this.pageAdmin = pageAdmin;
	}
	@JsonIgnore
	public void setPageAdmin(String o) {
		this.pageAdmin = ComputateVertxSiteRequest.staticSetPageAdmin(siteRequest_, o);
	}
	public static Boolean staticSetPageAdmin(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ComputateVertxSiteRequest pageAdminInit() {
		Wrap<Boolean> pageAdminWrap = new Wrap<Boolean>().var("pageAdmin");
		if(pageAdmin == null) {
			_pageAdmin(pageAdminWrap);
			setPageAdmin(pageAdminWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static Boolean staticSolrPageAdmin(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrPageAdmin(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageAdmin(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrPageAdmin(siteRequest_, ComputateVertxSiteRequest.staticSolrPageAdmin(siteRequest_, ComputateVertxSiteRequest.staticSetPageAdmin(siteRequest_, o)));
	}

	///////////////
	// requestPk //
	///////////////

	/**	 The entity requestPk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long requestPk;

	/**	<br> The entity requestPk
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requestPk">Find the entity requestPk in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _requestPk(Wrap<Long> c);

	public Long getRequestPk() {
		return requestPk;
	}

	public void setRequestPk(Long requestPk) {
		this.requestPk = requestPk;
	}
	@JsonIgnore
	public void setRequestPk(String o) {
		this.requestPk = ComputateVertxSiteRequest.staticSetRequestPk(siteRequest_, o);
	}
	public static Long staticSetRequestPk(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxSiteRequest requestPkInit() {
		Wrap<Long> requestPkWrap = new Wrap<Long>().var("requestPk");
		if(requestPk == null) {
			_requestPk(requestPkWrap);
			setRequestPk(requestPkWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static Long staticSolrRequestPk(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrRequestPk(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRequestPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrRequestPk(siteRequest_, ComputateVertxSiteRequest.staticSolrRequestPk(siteRequest_, ComputateVertxSiteRequest.staticSetRequestPk(siteRequest_, o)));
	}

	////////////////
	// requestUri //
	////////////////

	/**	 The entity requestUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String requestUri;

	/**	<br> The entity requestUri
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requestUri">Find the entity requestUri in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _requestUri(Wrap<String> c);

	public String getRequestUri() {
		return requestUri;
	}
	public void setRequestUri(String o) {
		this.requestUri = ComputateVertxSiteRequest.staticSetRequestUri(siteRequest_, o);
	}
	public static String staticSetRequestUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest requestUriInit() {
		Wrap<String> requestUriWrap = new Wrap<String>().var("requestUri");
		if(requestUri == null) {
			_requestUri(requestUriWrap);
			setRequestUri(requestUriWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrRequestUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRequestUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRequestUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrRequestUri(siteRequest_, ComputateVertxSiteRequest.staticSolrRequestUri(siteRequest_, ComputateVertxSiteRequest.staticSetRequestUri(siteRequest_, o)));
	}

	///////////////////
	// requestMethod //
	///////////////////

	/**	 The entity requestMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String requestMethod;

	/**	<br> The entity requestMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requestMethod">Find the entity requestMethod in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _requestMethod(Wrap<String> c);

	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String o) {
		this.requestMethod = ComputateVertxSiteRequest.staticSetRequestMethod(siteRequest_, o);
	}
	public static String staticSetRequestMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteRequest requestMethodInit() {
		Wrap<String> requestMethodWrap = new Wrap<String>().var("requestMethod");
		if(requestMethod == null) {
			_requestMethod(requestMethodWrap);
			setRequestMethod(requestMethodWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	public static String staticSolrRequestMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRequestMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRequestMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteRequest.staticSolrStrRequestMethod(siteRequest_, ComputateVertxSiteRequest.staticSolrRequestMethod(siteRequest_, ComputateVertxSiteRequest.staticSetRequestMethod(siteRequest_, o)));
	}

	///////////////////
	// sqlConnection //
	///////////////////

	/**	 The entity sqlConnection
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SqlConnection sqlConnection;

	/**	<br> The entity sqlConnection
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sqlConnection">Find the entity sqlConnection in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sqlConnection(Wrap<SqlConnection> c);

	public SqlConnection getSqlConnection() {
		return sqlConnection;
	}

	public void setSqlConnection(SqlConnection sqlConnection) {
		this.sqlConnection = sqlConnection;
	}
	public static SqlConnection staticSetSqlConnection(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest sqlConnectionInit() {
		Wrap<SqlConnection> sqlConnectionWrap = new Wrap<SqlConnection>().var("sqlConnection");
		if(sqlConnection == null) {
			_sqlConnection(sqlConnectionWrap);
			setSqlConnection(sqlConnectionWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	////////////////////
	// requestHeaders //
	////////////////////

	/**	 The entity requestHeaders
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected MultiMap requestHeaders;

	/**	<br> The entity requestHeaders
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requestHeaders">Find the entity requestHeaders in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _requestHeaders(Wrap<MultiMap> c);

	public MultiMap getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(MultiMap requestHeaders) {
		this.requestHeaders = requestHeaders;
	}
	public static MultiMap staticSetRequestHeaders(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest requestHeadersInit() {
		Wrap<MultiMap> requestHeadersWrap = new Wrap<MultiMap>().var("requestHeaders");
		if(requestHeaders == null) {
			_requestHeaders(requestHeadersWrap);
			setRequestHeaders(requestHeadersWrap.o);
		}
		return (ComputateVertxSiteRequest)this;
	}

	/////////////////
	// requestVars //
	/////////////////

	/**	 The entity requestVars
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Map<String, String> requestVars = new HashMap<String, String>();

	/**	<br> The entity requestVars
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.request.ComputateVertxSiteRequest&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requestVars">Find the entity requestVars in Solr</a>
	 * <br>
	 * @param m is the entity already constructed. 
	 **/
	protected abstract void _requestVars(Map<String, String> m);

	public Map<String, String> getRequestVars() {
		return requestVars;
	}

	public void setRequestVars(Map<String, String> requestVars) {
		this.requestVars = requestVars;
	}
	public static Map<String, String> staticSetRequestVars(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteRequest requestVarsInit() {
		_requestVars(requestVars);
		return (ComputateVertxSiteRequest)this;
	}

	//////////////
	// initDeep //
	//////////////

	public ComputateVertxSiteRequest initDeepComputateVertxSiteRequest(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepComputateVertxSiteRequest();
		return (ComputateVertxSiteRequest)this;
	}

	public void initDeepComputateVertxSiteRequest() {
		initComputateVertxSiteRequest();
	}

	public void initComputateVertxSiteRequest() {
				configInit();
				siteRequest_Init();
				webClientInit();
				apiRequest_Init();
				jsonObjectInit();
				serviceRequestInit();
				userInit();
				userIdInit();
				userKeyInit();
				sessionIdInit();
				sessionIdBeforeInit();
				userNameInit();
				userLastNameInit();
				userFirstNameInit();
				userFullNameInit();
				userEmailInit();
				userRealmRolesInit();
				userResourceInit();
				userResourceRolesInit();
				siteUser_Init();
				solrDocumentInit();
				pageAdminInit();
				requestPkInit();
				requestUriInit();
				requestMethodInit();
				sqlConnectionInit();
				requestHeadersInit();
				requestVarsInit();
	}

	public void initDeepForClass(ComputateVertxSiteRequest siteRequest_) {
		initDeepComputateVertxSiteRequest(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateVertxSiteRequest(ComputateVertxSiteRequest siteRequest_) {
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
		siteRequestComputateVertxSiteRequest(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateVertxSiteRequest(v);
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.obtainForClass(v);
			}
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainComputateVertxSiteRequest(String var) {
		ComputateVertxSiteRequest oComputateVertxSiteRequest = (ComputateVertxSiteRequest)this;
		switch(var) {
			case "config":
				return oComputateVertxSiteRequest.config;
			case "siteRequest_":
				return oComputateVertxSiteRequest.siteRequest_;
			case "webClient":
				return oComputateVertxSiteRequest.webClient;
			case "apiRequest_":
				return oComputateVertxSiteRequest.apiRequest_;
			case "jsonObject":
				return oComputateVertxSiteRequest.jsonObject;
			case "serviceRequest":
				return oComputateVertxSiteRequest.serviceRequest;
			case "user":
				return oComputateVertxSiteRequest.user;
			case "userId":
				return oComputateVertxSiteRequest.userId;
			case "userKey":
				return oComputateVertxSiteRequest.userKey;
			case "sessionId":
				return oComputateVertxSiteRequest.sessionId;
			case "sessionIdBefore":
				return oComputateVertxSiteRequest.sessionIdBefore;
			case "userName":
				return oComputateVertxSiteRequest.userName;
			case "userLastName":
				return oComputateVertxSiteRequest.userLastName;
			case "userFirstName":
				return oComputateVertxSiteRequest.userFirstName;
			case "userFullName":
				return oComputateVertxSiteRequest.userFullName;
			case "userEmail":
				return oComputateVertxSiteRequest.userEmail;
			case "userRealmRoles":
				return oComputateVertxSiteRequest.userRealmRoles;
			case "userResource":
				return oComputateVertxSiteRequest.userResource;
			case "userResourceRoles":
				return oComputateVertxSiteRequest.userResourceRoles;
			case "siteUser_":
				return oComputateVertxSiteRequest.siteUser_;
			case "solrDocument":
				return oComputateVertxSiteRequest.solrDocument;
			case "pageAdmin":
				return oComputateVertxSiteRequest.pageAdmin;
			case "requestPk":
				return oComputateVertxSiteRequest.requestPk;
			case "requestUri":
				return oComputateVertxSiteRequest.requestUri;
			case "requestMethod":
				return oComputateVertxSiteRequest.requestMethod;
			case "sqlConnection":
				return oComputateVertxSiteRequest.sqlConnection;
			case "requestHeaders":
				return oComputateVertxSiteRequest.requestHeaders;
			case "requestVars":
				return oComputateVertxSiteRequest.requestVars;
			default:
				return null;
		}
	}

	///////////////
	// relate //
	///////////////

	public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateComputateVertxSiteRequest(v, val);
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateComputateVertxSiteRequest(String var, Object val) {
		ComputateVertxSiteRequest oComputateVertxSiteRequest = (ComputateVertxSiteRequest)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetComputateVertxSiteRequest(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateVertxSiteRequest(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "userId":
			return ComputateVertxSiteRequest.staticSetUserId(siteRequest_, o);
		case "userKey":
			return ComputateVertxSiteRequest.staticSetUserKey(siteRequest_, o);
		case "sessionId":
			return ComputateVertxSiteRequest.staticSetSessionId(siteRequest_, o);
		case "sessionIdBefore":
			return ComputateVertxSiteRequest.staticSetSessionIdBefore(siteRequest_, o);
		case "userName":
			return ComputateVertxSiteRequest.staticSetUserName(siteRequest_, o);
		case "userLastName":
			return ComputateVertxSiteRequest.staticSetUserLastName(siteRequest_, o);
		case "userFirstName":
			return ComputateVertxSiteRequest.staticSetUserFirstName(siteRequest_, o);
		case "userFullName":
			return ComputateVertxSiteRequest.staticSetUserFullName(siteRequest_, o);
		case "userEmail":
			return ComputateVertxSiteRequest.staticSetUserEmail(siteRequest_, o);
		case "userRealmRoles":
			return ComputateVertxSiteRequest.staticSetUserRealmRoles(siteRequest_, o);
		case "userResourceRoles":
			return ComputateVertxSiteRequest.staticSetUserResourceRoles(siteRequest_, o);
		case "pageAdmin":
			return ComputateVertxSiteRequest.staticSetPageAdmin(siteRequest_, o);
		case "requestPk":
			return ComputateVertxSiteRequest.staticSetRequestPk(siteRequest_, o);
		case "requestUri":
			return ComputateVertxSiteRequest.staticSetRequestUri(siteRequest_, o);
		case "requestMethod":
			return ComputateVertxSiteRequest.staticSetRequestMethod(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrComputateVertxSiteRequest(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrComputateVertxSiteRequest(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "userId":
			return ComputateVertxSiteRequest.staticSolrUserId(siteRequest_, (String)o);
		case "userKey":
			return ComputateVertxSiteRequest.staticSolrUserKey(siteRequest_, (Long)o);
		case "sessionId":
			return ComputateVertxSiteRequest.staticSolrSessionId(siteRequest_, (String)o);
		case "sessionIdBefore":
			return ComputateVertxSiteRequest.staticSolrSessionIdBefore(siteRequest_, (String)o);
		case "userName":
			return ComputateVertxSiteRequest.staticSolrUserName(siteRequest_, (String)o);
		case "userLastName":
			return ComputateVertxSiteRequest.staticSolrUserLastName(siteRequest_, (String)o);
		case "userFirstName":
			return ComputateVertxSiteRequest.staticSolrUserFirstName(siteRequest_, (String)o);
		case "userFullName":
			return ComputateVertxSiteRequest.staticSolrUserFullName(siteRequest_, (String)o);
		case "userEmail":
			return ComputateVertxSiteRequest.staticSolrUserEmail(siteRequest_, (String)o);
		case "userRealmRoles":
			return ComputateVertxSiteRequest.staticSolrUserRealmRoles(siteRequest_, (String)o);
		case "userResourceRoles":
			return ComputateVertxSiteRequest.staticSolrUserResourceRoles(siteRequest_, (String)o);
		case "pageAdmin":
			return ComputateVertxSiteRequest.staticSolrPageAdmin(siteRequest_, (Boolean)o);
		case "requestPk":
			return ComputateVertxSiteRequest.staticSolrRequestPk(siteRequest_, (Long)o);
		case "requestUri":
			return ComputateVertxSiteRequest.staticSolrRequestUri(siteRequest_, (String)o);
		case "requestMethod":
			return ComputateVertxSiteRequest.staticSolrRequestMethod(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrStrComputateVertxSiteRequest(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrComputateVertxSiteRequest(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "userId":
			return ComputateVertxSiteRequest.staticSolrStrUserId(siteRequest_, (String)o);
		case "userKey":
			return ComputateVertxSiteRequest.staticSolrStrUserKey(siteRequest_, (Long)o);
		case "sessionId":
			return ComputateVertxSiteRequest.staticSolrStrSessionId(siteRequest_, (String)o);
		case "sessionIdBefore":
			return ComputateVertxSiteRequest.staticSolrStrSessionIdBefore(siteRequest_, (String)o);
		case "userName":
			return ComputateVertxSiteRequest.staticSolrStrUserName(siteRequest_, (String)o);
		case "userLastName":
			return ComputateVertxSiteRequest.staticSolrStrUserLastName(siteRequest_, (String)o);
		case "userFirstName":
			return ComputateVertxSiteRequest.staticSolrStrUserFirstName(siteRequest_, (String)o);
		case "userFullName":
			return ComputateVertxSiteRequest.staticSolrStrUserFullName(siteRequest_, (String)o);
		case "userEmail":
			return ComputateVertxSiteRequest.staticSolrStrUserEmail(siteRequest_, (String)o);
		case "userRealmRoles":
			return ComputateVertxSiteRequest.staticSolrStrUserRealmRoles(siteRequest_, (String)o);
		case "userResourceRoles":
			return ComputateVertxSiteRequest.staticSolrStrUserResourceRoles(siteRequest_, (String)o);
		case "pageAdmin":
			return ComputateVertxSiteRequest.staticSolrStrPageAdmin(siteRequest_, (Boolean)o);
		case "requestPk":
			return ComputateVertxSiteRequest.staticSolrStrRequestPk(siteRequest_, (Long)o);
		case "requestUri":
			return ComputateVertxSiteRequest.staticSolrStrRequestUri(siteRequest_, (String)o);
		case "requestMethod":
			return ComputateVertxSiteRequest.staticSolrStrRequestMethod(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSolrFqComputateVertxSiteRequest(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqComputateVertxSiteRequest(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "userId":
			return ComputateVertxSiteRequest.staticSolrFqUserId(siteRequest_, o);
		case "userKey":
			return ComputateVertxSiteRequest.staticSolrFqUserKey(siteRequest_, o);
		case "sessionId":
			return ComputateVertxSiteRequest.staticSolrFqSessionId(siteRequest_, o);
		case "sessionIdBefore":
			return ComputateVertxSiteRequest.staticSolrFqSessionIdBefore(siteRequest_, o);
		case "userName":
			return ComputateVertxSiteRequest.staticSolrFqUserName(siteRequest_, o);
		case "userLastName":
			return ComputateVertxSiteRequest.staticSolrFqUserLastName(siteRequest_, o);
		case "userFirstName":
			return ComputateVertxSiteRequest.staticSolrFqUserFirstName(siteRequest_, o);
		case "userFullName":
			return ComputateVertxSiteRequest.staticSolrFqUserFullName(siteRequest_, o);
		case "userEmail":
			return ComputateVertxSiteRequest.staticSolrFqUserEmail(siteRequest_, o);
		case "userRealmRoles":
			return ComputateVertxSiteRequest.staticSolrFqUserRealmRoles(siteRequest_, o);
		case "userResourceRoles":
			return ComputateVertxSiteRequest.staticSolrFqUserResourceRoles(siteRequest_, o);
		case "pageAdmin":
			return ComputateVertxSiteRequest.staticSolrFqPageAdmin(siteRequest_, o);
		case "requestPk":
			return ComputateVertxSiteRequest.staticSolrFqRequestPk(siteRequest_, o);
		case "requestUri":
			return ComputateVertxSiteRequest.staticSolrFqRequestUri(siteRequest_, o);
		case "requestMethod":
			return ComputateVertxSiteRequest.staticSolrFqRequestMethod(siteRequest_, o);
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineComputateVertxSiteRequest(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineComputateVertxSiteRequest(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return null;
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.toString();
	}

	public static final String VAR_config = "config";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_webClient = "webClient";
	public static final String VAR_apiRequest_ = "apiRequest_";
	public static final String VAR_jsonObject = "jsonObject";
	public static final String VAR_serviceRequest = "serviceRequest";
	public static final String VAR_user = "user";
	public static final String VAR_userId = "userId";
	public static final String VAR_userKey = "userKey";
	public static final String VAR_sessionId = "sessionId";
	public static final String VAR_sessionIdBefore = "sessionIdBefore";
	public static final String VAR_userName = "userName";
	public static final String VAR_userLastName = "userLastName";
	public static final String VAR_userFirstName = "userFirstName";
	public static final String VAR_userFullName = "userFullName";
	public static final String VAR_userEmail = "userEmail";
	public static final String VAR_userRealmRoles = "userRealmRoles";
	public static final String VAR_userResource = "userResource";
	public static final String VAR_userResourceRoles = "userResourceRoles";
	public static final String VAR_siteUser_ = "siteUser_";
	public static final String VAR_solrDocument = "solrDocument";
	public static final String VAR_pageAdmin = "pageAdmin";
	public static final String VAR_requestPk = "requestPk";
	public static final String VAR_requestUri = "requestUri";
	public static final String VAR_requestMethod = "requestMethod";
	public static final String VAR_sqlConnection = "sqlConnection";
	public static final String VAR_requestHeaders = "requestHeaders";
	public static final String VAR_requestVars = "requestVars";

	public static final String DISPLAY_NAME_config = "";
	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_webClient = "";
	public static final String DISPLAY_NAME_apiRequest_ = "";
	public static final String DISPLAY_NAME_jsonObject = "";
	public static final String DISPLAY_NAME_serviceRequest = "";
	public static final String DISPLAY_NAME_user = "";
	public static final String DISPLAY_NAME_userId = "";
	public static final String DISPLAY_NAME_userKey = "";
	public static final String DISPLAY_NAME_sessionId = "";
	public static final String DISPLAY_NAME_sessionIdBefore = "";
	public static final String DISPLAY_NAME_userName = "";
	public static final String DISPLAY_NAME_userLastName = "";
	public static final String DISPLAY_NAME_userFirstName = "";
	public static final String DISPLAY_NAME_userFullName = "";
	public static final String DISPLAY_NAME_userEmail = "";
	public static final String DISPLAY_NAME_userRealmRoles = "";
	public static final String DISPLAY_NAME_userResource = "";
	public static final String DISPLAY_NAME_userResourceRoles = "";
	public static final String DISPLAY_NAME_siteUser_ = "";
	public static final String DISPLAY_NAME_solrDocument = "";
	public static final String DISPLAY_NAME_pageAdmin = "";
	public static final String DISPLAY_NAME_requestPk = "";
	public static final String DISPLAY_NAME_requestUri = "";
	public static final String DISPLAY_NAME_requestMethod = "";
	public static final String DISPLAY_NAME_sqlConnection = "";
	public static final String DISPLAY_NAME_requestHeaders = "";
	public static final String DISPLAY_NAME_requestVars = "";

	public static String displayNameForClass(String var) {
		return ComputateVertxSiteRequest.displayNameComputateVertxSiteRequest(var);
	}
	public static String displayNameComputateVertxSiteRequest(String var) {
		switch(var) {
		case VAR_config:
			return DISPLAY_NAME_config;
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_webClient:
			return DISPLAY_NAME_webClient;
		case VAR_apiRequest_:
			return DISPLAY_NAME_apiRequest_;
		case VAR_jsonObject:
			return DISPLAY_NAME_jsonObject;
		case VAR_serviceRequest:
			return DISPLAY_NAME_serviceRequest;
		case VAR_user:
			return DISPLAY_NAME_user;
		case VAR_userId:
			return DISPLAY_NAME_userId;
		case VAR_userKey:
			return DISPLAY_NAME_userKey;
		case VAR_sessionId:
			return DISPLAY_NAME_sessionId;
		case VAR_sessionIdBefore:
			return DISPLAY_NAME_sessionIdBefore;
		case VAR_userName:
			return DISPLAY_NAME_userName;
		case VAR_userLastName:
			return DISPLAY_NAME_userLastName;
		case VAR_userFirstName:
			return DISPLAY_NAME_userFirstName;
		case VAR_userFullName:
			return DISPLAY_NAME_userFullName;
		case VAR_userEmail:
			return DISPLAY_NAME_userEmail;
		case VAR_userRealmRoles:
			return DISPLAY_NAME_userRealmRoles;
		case VAR_userResource:
			return DISPLAY_NAME_userResource;
		case VAR_userResourceRoles:
			return DISPLAY_NAME_userResourceRoles;
		case VAR_siteUser_:
			return DISPLAY_NAME_siteUser_;
		case VAR_solrDocument:
			return DISPLAY_NAME_solrDocument;
		case VAR_pageAdmin:
			return DISPLAY_NAME_pageAdmin;
		case VAR_requestPk:
			return DISPLAY_NAME_requestPk;
		case VAR_requestUri:
			return DISPLAY_NAME_requestUri;
		case VAR_requestMethod:
			return DISPLAY_NAME_requestMethod;
		case VAR_sqlConnection:
			return DISPLAY_NAME_sqlConnection;
		case VAR_requestHeaders:
			return DISPLAY_NAME_requestHeaders;
		case VAR_requestVars:
			return DISPLAY_NAME_requestVars;
		default:
			return null;
		}
	}
}
