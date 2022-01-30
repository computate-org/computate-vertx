package org.computate.vertx.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import java.math.RoundingMode;
import java.lang.Void;
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
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ComputateVertxPageLayoutGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateVertxPageLayout.class);

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected ComputateVertxSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<ComputateVertxSiteRequest> w);

	public ComputateVertxSiteRequest getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(ComputateVertxSiteRequest siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static ComputateVertxSiteRequest staticSetSiteRequest_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxPageLayout siteRequest_Init() {
		Wrap<ComputateVertxSiteRequest> siteRequest_Wrap = new Wrap<ComputateVertxSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (ComputateVertxPageLayout)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:serviceRequest">Find the entity serviceRequest in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _serviceRequest(Wrap<ServiceRequest> w);

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
	public static ServiceRequest staticSetServiceRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxPageLayout serviceRequestInit() {
		Wrap<ServiceRequest> serviceRequestWrap = new Wrap<ServiceRequest>().var("serviceRequest");
		if(serviceRequest == null) {
			_serviceRequest(serviceRequestWrap);
			setServiceRequest(serviceRequestWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	///////////////////
	// requestZoneId //
	///////////////////

	/**	 The entity requestZoneId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String requestZoneId;

	/**	<br> The entity requestZoneId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requestZoneId">Find the entity requestZoneId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _requestZoneId(Wrap<String> w);

	public String getRequestZoneId() {
		return requestZoneId;
	}
	public void setRequestZoneId(String o) {
		this.requestZoneId = ComputateVertxPageLayout.staticSetRequestZoneId(siteRequest_, o);
	}
	public static String staticSetRequestZoneId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout requestZoneIdInit() {
		Wrap<String> requestZoneIdWrap = new Wrap<String>().var("requestZoneId");
		if(requestZoneId == null) {
			_requestZoneId(requestZoneIdWrap);
			setRequestZoneId(requestZoneIdWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrRequestZoneId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRequestZoneId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRequestZoneId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrRequestZoneId(siteRequest_, ComputateVertxPageLayout.staticSolrRequestZoneId(siteRequest_, ComputateVertxPageLayout.staticSetRequestZoneId(siteRequest_, o)));
	}

	/////////////////////
	// requestLocaleId //
	/////////////////////

	/**	 The entity requestLocaleId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String requestLocaleId;

	/**	<br> The entity requestLocaleId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requestLocaleId">Find the entity requestLocaleId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _requestLocaleId(Wrap<String> w);

	public String getRequestLocaleId() {
		return requestLocaleId;
	}
	public void setRequestLocaleId(String o) {
		this.requestLocaleId = ComputateVertxPageLayout.staticSetRequestLocaleId(siteRequest_, o);
	}
	public static String staticSetRequestLocaleId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout requestLocaleIdInit() {
		Wrap<String> requestLocaleIdWrap = new Wrap<String>().var("requestLocaleId");
		if(requestLocaleId == null) {
			_requestLocaleId(requestLocaleIdWrap);
			setRequestLocaleId(requestLocaleIdWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrRequestLocaleId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRequestLocaleId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRequestLocaleId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrRequestLocaleId(siteRequest_, ComputateVertxPageLayout.staticSolrRequestLocaleId(siteRequest_, ComputateVertxPageLayout.staticSetRequestLocaleId(siteRequest_, o)));
	}

	///////////////////
	// staticBaseUrl //
	///////////////////

	/**	 The entity staticBaseUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String staticBaseUrl;

	/**	<br> The entity staticBaseUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:staticBaseUrl">Find the entity staticBaseUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _staticBaseUrl(Wrap<String> w);

	public String getStaticBaseUrl() {
		return staticBaseUrl;
	}
	public void setStaticBaseUrl(String o) {
		this.staticBaseUrl = ComputateVertxPageLayout.staticSetStaticBaseUrl(siteRequest_, o);
	}
	public static String staticSetStaticBaseUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout staticBaseUrlInit() {
		Wrap<String> staticBaseUrlWrap = new Wrap<String>().var("staticBaseUrl");
		if(staticBaseUrl == null) {
			_staticBaseUrl(staticBaseUrlWrap);
			setStaticBaseUrl(staticBaseUrlWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrStaticBaseUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrStaticBaseUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqStaticBaseUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrStaticBaseUrl(siteRequest_, ComputateVertxPageLayout.staticSolrStaticBaseUrl(siteRequest_, ComputateVertxPageLayout.staticSetStaticBaseUrl(siteRequest_, o)));
	}

	/////////////
	// authUrl //
	/////////////

	/**	 The entity authUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String authUrl;

	/**	<br> The entity authUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:authUrl">Find the entity authUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _authUrl(Wrap<String> w);

	public String getAuthUrl() {
		return authUrl;
	}
	public void setAuthUrl(String o) {
		this.authUrl = ComputateVertxPageLayout.staticSetAuthUrl(siteRequest_, o);
	}
	public static String staticSetAuthUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout authUrlInit() {
		Wrap<String> authUrlWrap = new Wrap<String>().var("authUrl");
		if(authUrl == null) {
			_authUrl(authUrlWrap);
			setAuthUrl(authUrlWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrAuthUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrAuthUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAuthUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrAuthUrl(siteRequest_, ComputateVertxPageLayout.staticSolrAuthUrl(siteRequest_, ComputateVertxPageLayout.staticSetAuthUrl(siteRequest_, o)));
	}

	///////////////
	// authRealm //
	///////////////

	/**	 The entity authRealm
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String authRealm;

	/**	<br> The entity authRealm
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:authRealm">Find the entity authRealm in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _authRealm(Wrap<String> w);

	public String getAuthRealm() {
		return authRealm;
	}
	public void setAuthRealm(String o) {
		this.authRealm = ComputateVertxPageLayout.staticSetAuthRealm(siteRequest_, o);
	}
	public static String staticSetAuthRealm(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout authRealmInit() {
		Wrap<String> authRealmWrap = new Wrap<String>().var("authRealm");
		if(authRealm == null) {
			_authRealm(authRealmWrap);
			setAuthRealm(authRealmWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrAuthRealm(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrAuthRealm(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAuthRealm(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrAuthRealm(siteRequest_, ComputateVertxPageLayout.staticSolrAuthRealm(siteRequest_, ComputateVertxPageLayout.staticSetAuthRealm(siteRequest_, o)));
	}

	/////////////
	// pageUri //
	/////////////

	/**	 The entity pageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUri;

	/**	<br> The entity pageUri
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUri(Wrap<String> w);

	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String o) {
		this.pageUri = ComputateVertxPageLayout.staticSetPageUri(siteRequest_, o);
	}
	public static String staticSetPageUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout pageUriInit() {
		Wrap<String> pageUriWrap = new Wrap<String>().var("pageUri");
		if(pageUri == null) {
			_pageUri(pageUriWrap);
			setPageUri(pageUriWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrPageUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrPageUri(siteRequest_, ComputateVertxPageLayout.staticSolrPageUri(siteRequest_, ComputateVertxPageLayout.staticSetPageUri(siteRequest_, o)));
	}

	////////////////
	// pageMethod //
	////////////////

	/**	 The entity pageMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageMethod;

	/**	<br> The entity pageMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageMethod">Find the entity pageMethod in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageMethod(Wrap<String> w);

	public String getPageMethod() {
		return pageMethod;
	}
	public void setPageMethod(String o) {
		this.pageMethod = ComputateVertxPageLayout.staticSetPageMethod(siteRequest_, o);
	}
	public static String staticSetPageMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout pageMethodInit() {
		Wrap<String> pageMethodWrap = new Wrap<String>().var("pageMethod");
		if(pageMethod == null) {
			_pageMethod(pageMethodWrap);
			setPageMethod(pageMethodWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrPageMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrPageMethod(siteRequest_, ComputateVertxPageLayout.staticSolrPageMethod(siteRequest_, ComputateVertxPageLayout.staticSetPageMethod(siteRequest_, o)));
	}

	////////////
	// params //
	////////////

	/**	 The entity params
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonObject params;

	/**	<br> The entity params
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:params">Find the entity params in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _params(Wrap<JsonObject> w);

	public JsonObject getParams() {
		return params;
	}

	public void setParams(JsonObject params) {
		this.params = params;
	}
	public static JsonObject staticSetParams(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxPageLayout paramsInit() {
		Wrap<JsonObject> paramsWrap = new Wrap<JsonObject>().var("params");
		if(params == null) {
			_params(paramsWrap);
			setParams(paramsWrap.o);
		}
		return (ComputateVertxPageLayout)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKey">Find the entity userKey in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userKey(Wrap<Long> w);

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}
	@JsonIgnore
	public void setUserKey(String o) {
		this.userKey = ComputateVertxPageLayout.staticSetUserKey(siteRequest_, o);
	}
	public static Long staticSetUserKey(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxPageLayout userKeyInit() {
		Wrap<Long> userKeyWrap = new Wrap<Long>().var("userKey");
		if(userKey == null) {
			_userKey(userKeyWrap);
			setUserKey(userKeyWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static Long staticSolrUserKey(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrUserKey(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserKey(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrUserKey(siteRequest_, ComputateVertxPageLayout.staticSolrUserKey(siteRequest_, ComputateVertxPageLayout.staticSetUserKey(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userFullName">Find the entity userFullName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userFullName(Wrap<String> w);

	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String o) {
		this.userFullName = ComputateVertxPageLayout.staticSetUserFullName(siteRequest_, o);
	}
	public static String staticSetUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout userFullNameInit() {
		Wrap<String> userFullNameWrap = new Wrap<String>().var("userFullName");
		if(userFullName == null) {
			_userFullName(userFullNameWrap);
			setUserFullName(userFullNameWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrUserFullName(siteRequest_, ComputateVertxPageLayout.staticSolrUserFullName(siteRequest_, ComputateVertxPageLayout.staticSetUserFullName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userName">Find the entity userName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userName(Wrap<String> w);

	public String getUserName() {
		return userName;
	}
	public void setUserName(String o) {
		this.userName = ComputateVertxPageLayout.staticSetUserName(siteRequest_, o);
	}
	public static String staticSetUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout userNameInit() {
		Wrap<String> userNameWrap = new Wrap<String>().var("userName");
		if(userName == null) {
			_userName(userNameWrap);
			setUserName(userNameWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrUserName(siteRequest_, ComputateVertxPageLayout.staticSolrUserName(siteRequest_, ComputateVertxPageLayout.staticSetUserName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userEmail">Find the entity userEmail in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userEmail(Wrap<String> w);

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String o) {
		this.userEmail = ComputateVertxPageLayout.staticSetUserEmail(siteRequest_, o);
	}
	public static String staticSetUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout userEmailInit() {
		Wrap<String> userEmailWrap = new Wrap<String>().var("userEmail");
		if(userEmail == null) {
			_userEmail(userEmailWrap);
			setUserEmail(userEmailWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrUserEmail(siteRequest_, ComputateVertxPageLayout.staticSolrUserEmail(siteRequest_, ComputateVertxPageLayout.staticSetUserEmail(siteRequest_, o)));
	}

	///////////////
	// logoutUrl //
	///////////////

	/**	 The entity logoutUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String logoutUrl;

	/**	<br> The entity logoutUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:logoutUrl">Find the entity logoutUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _logoutUrl(Wrap<String> w);

	public String getLogoutUrl() {
		return logoutUrl;
	}
	public void setLogoutUrl(String o) {
		this.logoutUrl = ComputateVertxPageLayout.staticSetLogoutUrl(siteRequest_, o);
	}
	public static String staticSetLogoutUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout logoutUrlInit() {
		Wrap<String> logoutUrlWrap = new Wrap<String>().var("logoutUrl");
		if(logoutUrl == null) {
			_logoutUrl(logoutUrlWrap);
			setLogoutUrl(logoutUrlWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrLogoutUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrLogoutUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqLogoutUrl(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrLogoutUrl(siteRequest_, ComputateVertxPageLayout.staticSolrLogoutUrl(siteRequest_, ComputateVertxPageLayout.staticSetLogoutUrl(siteRequest_, o)));
	}

	///////////
	// long0 //
	///////////

	/**	 The entity long0
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long long0;

	/**	<br> The entity long0
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:long0">Find the entity long0 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _long0(Wrap<Long> w);

	public Long getLong0() {
		return long0;
	}

	public void setLong0(Long long0) {
		this.long0 = long0;
	}
	@JsonIgnore
	public void setLong0(String o) {
		this.long0 = ComputateVertxPageLayout.staticSetLong0(siteRequest_, o);
	}
	public static Long staticSetLong0(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxPageLayout long0Init() {
		Wrap<Long> long0Wrap = new Wrap<Long>().var("long0");
		if(long0 == null) {
			_long0(long0Wrap);
			setLong0(long0Wrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static Long staticSolrLong0(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrLong0(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqLong0(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrLong0(siteRequest_, ComputateVertxPageLayout.staticSolrLong0(siteRequest_, ComputateVertxPageLayout.staticSetLong0(siteRequest_, o)));
	}

	///////////
	// long1 //
	///////////

	/**	 The entity long1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long long1;

	/**	<br> The entity long1
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:long1">Find the entity long1 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _long1(Wrap<Long> w);

	public Long getLong1() {
		return long1;
	}

	public void setLong1(Long long1) {
		this.long1 = long1;
	}
	@JsonIgnore
	public void setLong1(String o) {
		this.long1 = ComputateVertxPageLayout.staticSetLong1(siteRequest_, o);
	}
	public static Long staticSetLong1(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxPageLayout long1Init() {
		Wrap<Long> long1Wrap = new Wrap<Long>().var("long1");
		if(long1 == null) {
			_long1(long1Wrap);
			setLong1(long1Wrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static Long staticSolrLong1(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrLong1(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqLong1(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrLong1(siteRequest_, ComputateVertxPageLayout.staticSolrLong1(siteRequest_, ComputateVertxPageLayout.staticSetLong1(siteRequest_, o)));
	}

	//////////
	// int0 //
	//////////

	/**	 The entity int0
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer int0;

	/**	<br> The entity int0
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:int0">Find the entity int0 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _int0(Wrap<Integer> w);

	public Integer getInt0() {
		return int0;
	}

	public void setInt0(Integer int0) {
		this.int0 = int0;
	}
	@JsonIgnore
	public void setInt0(String o) {
		this.int0 = ComputateVertxPageLayout.staticSetInt0(siteRequest_, o);
	}
	public static Integer staticSetInt0(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputateVertxPageLayout int0Init() {
		Wrap<Integer> int0Wrap = new Wrap<Integer>().var("int0");
		if(int0 == null) {
			_int0(int0Wrap);
			setInt0(int0Wrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static Integer staticSolrInt0(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrInt0(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInt0(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrInt0(siteRequest_, ComputateVertxPageLayout.staticSolrInt0(siteRequest_, ComputateVertxPageLayout.staticSetInt0(siteRequest_, o)));
	}

	//////////
	// int1 //
	//////////

	/**	 The entity int1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer int1;

	/**	<br> The entity int1
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:int1">Find the entity int1 in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _int1(Wrap<Integer> w);

	public Integer getInt1() {
		return int1;
	}

	public void setInt1(Integer int1) {
		this.int1 = int1;
	}
	@JsonIgnore
	public void setInt1(String o) {
		this.int1 = ComputateVertxPageLayout.staticSetInt1(siteRequest_, o);
	}
	public static Integer staticSetInt1(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputateVertxPageLayout int1Init() {
		Wrap<Integer> int1Wrap = new Wrap<Integer>().var("int1");
		if(int1 == null) {
			_int1(int1Wrap);
			setInt1(int1Wrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static Integer staticSolrInt1(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrInt1(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInt1(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrInt1(siteRequest_, ComputateVertxPageLayout.staticSolrInt1(siteRequest_, ComputateVertxPageLayout.staticSetInt1(siteRequest_, o)));
	}

	///////////////////
	// promiseBefore //
	///////////////////

	/**	 The entity promiseBefore
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseBefore;

	/**	<br> The entity promiseBefore
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseBefore(Promise<Void> promise);

	public Void getPromiseBefore() {
		return promiseBefore;
	}

	public void setPromiseBefore(Void promiseBefore) {
		this.promiseBefore = promiseBefore;
	}
	public static Void staticSetPromiseBefore(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseBeforePromise() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		_promiseBefore(promise2);
		promise2.future().onSuccess(o -> {
			setPromiseBefore(o);
			promise.complete(o);
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	/////////////////////
	// classSimpleName //
	/////////////////////

	/**	 The entity classSimpleName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classSimpleName;

	/**	<br> The entity classSimpleName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSimpleName(Wrap<String> c);

	public String getClassSimpleName() {
		return classSimpleName;
	}
	public void setClassSimpleName(String o) {
		this.classSimpleName = ComputateVertxPageLayout.staticSetClassSimpleName(siteRequest_, o);
	}
	public static String staticSetClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout classSimpleNameInit() {
		Wrap<String> classSimpleNameWrap = new Wrap<String>().var("classSimpleName");
		if(classSimpleName == null) {
			_classSimpleName(classSimpleNameWrap);
			setClassSimpleName(classSimpleNameWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrClassSimpleName(siteRequest_, ComputateVertxPageLayout.staticSolrClassSimpleName(siteRequest_, ComputateVertxPageLayout.staticSetClassSimpleName(siteRequest_, o)));
	}

	///////////////
	// pageTitle //
	///////////////

	/**	 The entity pageTitle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageTitle;

	/**	<br> The entity pageTitle
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageTitle(Wrap<String> c);

	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String o) {
		this.pageTitle = ComputateVertxPageLayout.staticSetPageTitle(siteRequest_, o);
	}
	public static String staticSetPageTitle(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout pageTitleInit() {
		Wrap<String> pageTitleWrap = new Wrap<String>().var("pageTitle");
		if(pageTitle == null) {
			_pageTitle(pageTitleWrap);
			setPageTitle(pageTitleWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrPageTitle(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageTitle(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageTitle(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrPageTitle(siteRequest_, ComputateVertxPageLayout.staticSolrPageTitle(siteRequest_, ComputateVertxPageLayout.staticSetPageTitle(siteRequest_, o)));
	}

	///////////
	// roles //
	///////////

	/**	 The entity roles
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> roles = new ArrayList<String>();

	/**	<br> The entity roles
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:roles">Find the entity roles in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _roles(List<String> l);

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public static String staticSetRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateVertxPageLayout addRoles(String...objets) {
		for(String o : objets) {
			addRoles(o);
		}
		return (ComputateVertxPageLayout)this;
	}
	public ComputateVertxPageLayout addRoles(String o) {
		if(o != null)
			this.roles.add(o);
		return (ComputateVertxPageLayout)this;
	}
	@JsonIgnore
	public void setRoles(JsonArray objets) {
		roles.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addRoles(o);
		}
	}
	protected ComputateVertxPageLayout rolesInit() {
		_roles(roles);
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrRoles(siteRequest_, ComputateVertxPageLayout.staticSolrRoles(siteRequest_, ComputateVertxPageLayout.staticSetRoles(siteRequest_, o)));
	}

	///////////////////
	// rolesRequired //
	///////////////////

	/**	 The entity rolesRequired
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> rolesRequired = new ArrayList<String>();

	/**	<br> The entity rolesRequired
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:rolesRequired">Find the entity rolesRequired in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _rolesRequired(List<String> l);

	public List<String> getRolesRequired() {
		return rolesRequired;
	}

	public void setRolesRequired(List<String> rolesRequired) {
		this.rolesRequired = rolesRequired;
	}
	public static String staticSetRolesRequired(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateVertxPageLayout addRolesRequired(String...objets) {
		for(String o : objets) {
			addRolesRequired(o);
		}
		return (ComputateVertxPageLayout)this;
	}
	public ComputateVertxPageLayout addRolesRequired(String o) {
		if(o != null)
			this.rolesRequired.add(o);
		return (ComputateVertxPageLayout)this;
	}
	@JsonIgnore
	public void setRolesRequired(JsonArray objets) {
		rolesRequired.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addRolesRequired(o);
		}
	}
	protected ComputateVertxPageLayout rolesRequiredInit() {
		_rolesRequired(rolesRequired);
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrRolesRequired(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrRolesRequired(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqRolesRequired(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrRolesRequired(siteRequest_, ComputateVertxPageLayout.staticSolrRolesRequired(siteRequest_, ComputateVertxPageLayout.staticSetRolesRequired(siteRequest_, o)));
	}

	////////////////////
	// authRolesAdmin //
	////////////////////

	/**	 The entity authRolesAdmin
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> authRolesAdmin = new ArrayList<String>();

	/**	<br> The entity authRolesAdmin
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:authRolesAdmin">Find the entity authRolesAdmin in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _authRolesAdmin(List<String> l);

	public List<String> getAuthRolesAdmin() {
		return authRolesAdmin;
	}

	public void setAuthRolesAdmin(List<String> authRolesAdmin) {
		this.authRolesAdmin = authRolesAdmin;
	}
	public static String staticSetAuthRolesAdmin(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateVertxPageLayout addAuthRolesAdmin(String...objets) {
		for(String o : objets) {
			addAuthRolesAdmin(o);
		}
		return (ComputateVertxPageLayout)this;
	}
	public ComputateVertxPageLayout addAuthRolesAdmin(String o) {
		if(o != null)
			this.authRolesAdmin.add(o);
		return (ComputateVertxPageLayout)this;
	}
	@JsonIgnore
	public void setAuthRolesAdmin(JsonArray objets) {
		authRolesAdmin.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addAuthRolesAdmin(o);
		}
	}
	protected ComputateVertxPageLayout authRolesAdminInit() {
		_authRolesAdmin(authRolesAdmin);
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrAuthRolesAdmin(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrAuthRolesAdmin(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqAuthRolesAdmin(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrAuthRolesAdmin(siteRequest_, ComputateVertxPageLayout.staticSolrAuthRolesAdmin(siteRequest_, ComputateVertxPageLayout.staticSetAuthRolesAdmin(siteRequest_, o)));
	}

	////////////////
	// pagination //
	////////////////

	/**	 The entity pagination
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonObject pagination = new JsonObject();

	/**	<br> The entity pagination
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pagination">Find the entity pagination in Solr</a>
	 * <br>
	 * @param pagination is the entity already constructed. 
	 **/
	protected abstract void _pagination(JsonObject pagination);

	public JsonObject getPagination() {
		return pagination;
	}

	public void setPagination(JsonObject pagination) {
		this.pagination = pagination;
	}
	public static JsonObject staticSetPagination(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxPageLayout paginationInit() {
		_pagination(pagination);
		return (ComputateVertxPageLayout)this;
	}

	///////////
	// query //
	///////////

	/**	 The entity query
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonObject query = new JsonObject();

	/**	<br> The entity query
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:query">Find the entity query in Solr</a>
	 * <br>
	 * @param query is the entity already constructed. 
	 **/
	protected abstract void _query(JsonObject query);

	public JsonObject getQuery() {
		return query;
	}

	public void setQuery(JsonObject query) {
		this.query = query;
	}
	public static JsonObject staticSetQuery(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxPageLayout queryInit() {
		_query(query);
		return (ComputateVertxPageLayout)this;
	}

	//////////////////
	// promiseAfter //
	//////////////////

	/**	 The entity promiseAfter
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseAfter;

	/**	<br> The entity promiseAfter
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:promiseAfter">Find the entity promiseAfter in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseAfter(Promise<Void> promise);

	public Void getPromiseAfter() {
		return promiseAfter;
	}

	public void setPromiseAfter(Void promiseAfter) {
		this.promiseAfter = promiseAfter;
	}
	public static Void staticSetPromiseAfter(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseAfterPromise() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		_promiseAfter(promise2);
		promise2.future().onSuccess(o -> {
			setPromiseAfter(o);
			promise.complete(o);
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	//////////////////
	// pageImageUri //
	//////////////////

	/**	 The entity pageImageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageImageUri;

	/**	<br> The entity pageImageUri
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageUri(Wrap<String> c);

	public String getPageImageUri() {
		return pageImageUri;
	}
	public void setPageImageUri(String o) {
		this.pageImageUri = ComputateVertxPageLayout.staticSetPageImageUri(siteRequest_, o);
	}
	public static String staticSetPageImageUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout pageImageUriInit() {
		Wrap<String> pageImageUriWrap = new Wrap<String>().var("pageImageUri");
		if(pageImageUri == null) {
			_pageImageUri(pageImageUriWrap);
			setPageImageUri(pageImageUriWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrPageImageUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageImageUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageImageUri(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrPageImageUri(siteRequest_, ComputateVertxPageLayout.staticSolrPageImageUri(siteRequest_, ComputateVertxPageLayout.staticSetPageImageUri(siteRequest_, o)));
	}

	//////////////////////
	// contextIconGroup //
	//////////////////////

	/**	 The entity contextIconGroup
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String contextIconGroup;

	/**	<br> The entity contextIconGroup
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconGroup">Find the entity contextIconGroup in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconGroup(Wrap<String> c);

	public String getContextIconGroup() {
		return contextIconGroup;
	}
	public void setContextIconGroup(String o) {
		this.contextIconGroup = ComputateVertxPageLayout.staticSetContextIconGroup(siteRequest_, o);
	}
	public static String staticSetContextIconGroup(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout contextIconGroupInit() {
		Wrap<String> contextIconGroupWrap = new Wrap<String>().var("contextIconGroup");
		if(contextIconGroup == null) {
			_contextIconGroup(contextIconGroupWrap);
			setContextIconGroup(contextIconGroupWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrContextIconGroup(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconGroup(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconGroup(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrContextIconGroup(siteRequest_, ComputateVertxPageLayout.staticSolrContextIconGroup(siteRequest_, ComputateVertxPageLayout.staticSetContextIconGroup(siteRequest_, o)));
	}

	/////////////////////
	// contextIconName //
	/////////////////////

	/**	 The entity contextIconName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String contextIconName;

	/**	<br> The entity contextIconName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputateVertxPageLayout&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextIconName">Find the entity contextIconName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextIconName(Wrap<String> c);

	public String getContextIconName() {
		return contextIconName;
	}
	public void setContextIconName(String o) {
		this.contextIconName = ComputateVertxPageLayout.staticSetContextIconName(siteRequest_, o);
	}
	public static String staticSetContextIconName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxPageLayout contextIconNameInit() {
		Wrap<String> contextIconNameWrap = new Wrap<String>().var("contextIconName");
		if(contextIconName == null) {
			_contextIconName(contextIconNameWrap);
			setContextIconName(contextIconNameWrap.o);
		}
		return (ComputateVertxPageLayout)this;
	}

	public static String staticSolrContextIconName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrContextIconName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqContextIconName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxPageLayout.staticSolrStrContextIconName(siteRequest_, ComputateVertxPageLayout.staticSolrContextIconName(siteRequest_, ComputateVertxPageLayout.staticSetContextIconName(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepComputateVertxPageLayout(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepComputateVertxPageLayout();
	}

	public Future<Void> promiseDeepComputateVertxPageLayout() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseComputateVertxPageLayout(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputateVertxPageLayout(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				serviceRequestInit();
				requestZoneIdInit();
				requestLocaleIdInit();
				staticBaseUrlInit();
				authUrlInit();
				authRealmInit();
				pageUriInit();
				pageMethodInit();
				paramsInit();
				userKeyInit();
				userFullNameInit();
				userNameInit();
				userEmailInit();
				logoutUrlInit();
				long0Init();
				long1Init();
				int0Init();
				int1Init();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			promiseBeforePromise().onSuccess(promiseBefore -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				classSimpleNameInit();
				pageTitleInit();
				rolesInit();
				rolesRequiredInit();
				authRolesAdminInit();
				paginationInit();
				queryInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			promiseAfterPromise().onSuccess(promiseAfter -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				pageImageUriInit();
				contextIconGroupInit();
				contextIconNameInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseDeepForClass(ComputateVertxSiteRequest siteRequest_) {
		return promiseDeepComputateVertxPageLayout(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateVertxPageLayout(ComputateVertxSiteRequest siteRequest_) {
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
		siteRequestComputateVertxPageLayout(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateVertxPageLayout(v);
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
	public Object obtainComputateVertxPageLayout(String var) {
		ComputateVertxPageLayout oComputateVertxPageLayout = (ComputateVertxPageLayout)this;
		switch(var) {
			case "siteRequest_":
				return oComputateVertxPageLayout.siteRequest_;
			case "serviceRequest":
				return oComputateVertxPageLayout.serviceRequest;
			case "requestZoneId":
				return oComputateVertxPageLayout.requestZoneId;
			case "requestLocaleId":
				return oComputateVertxPageLayout.requestLocaleId;
			case "staticBaseUrl":
				return oComputateVertxPageLayout.staticBaseUrl;
			case "authUrl":
				return oComputateVertxPageLayout.authUrl;
			case "authRealm":
				return oComputateVertxPageLayout.authRealm;
			case "pageUri":
				return oComputateVertxPageLayout.pageUri;
			case "pageMethod":
				return oComputateVertxPageLayout.pageMethod;
			case "params":
				return oComputateVertxPageLayout.params;
			case "userKey":
				return oComputateVertxPageLayout.userKey;
			case "userFullName":
				return oComputateVertxPageLayout.userFullName;
			case "userName":
				return oComputateVertxPageLayout.userName;
			case "userEmail":
				return oComputateVertxPageLayout.userEmail;
			case "logoutUrl":
				return oComputateVertxPageLayout.logoutUrl;
			case "long0":
				return oComputateVertxPageLayout.long0;
			case "long1":
				return oComputateVertxPageLayout.long1;
			case "int0":
				return oComputateVertxPageLayout.int0;
			case "int1":
				return oComputateVertxPageLayout.int1;
			case "promiseBefore":
				return oComputateVertxPageLayout.promiseBefore;
			case "classSimpleName":
				return oComputateVertxPageLayout.classSimpleName;
			case "pageTitle":
				return oComputateVertxPageLayout.pageTitle;
			case "roles":
				return oComputateVertxPageLayout.roles;
			case "rolesRequired":
				return oComputateVertxPageLayout.rolesRequired;
			case "authRolesAdmin":
				return oComputateVertxPageLayout.authRolesAdmin;
			case "pagination":
				return oComputateVertxPageLayout.pagination;
			case "query":
				return oComputateVertxPageLayout.query;
			case "promiseAfter":
				return oComputateVertxPageLayout.promiseAfter;
			case "pageImageUri":
				return oComputateVertxPageLayout.pageImageUri;
			case "contextIconGroup":
				return oComputateVertxPageLayout.contextIconGroup;
			case "contextIconName":
				return oComputateVertxPageLayout.contextIconName;
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
				o = relateComputateVertxPageLayout(v, val);
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateComputateVertxPageLayout(String var, Object val) {
		ComputateVertxPageLayout oComputateVertxPageLayout = (ComputateVertxPageLayout)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetComputateVertxPageLayout(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateVertxPageLayout(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "requestZoneId":
			return ComputateVertxPageLayout.staticSetRequestZoneId(siteRequest_, o);
		case "requestLocaleId":
			return ComputateVertxPageLayout.staticSetRequestLocaleId(siteRequest_, o);
		case "staticBaseUrl":
			return ComputateVertxPageLayout.staticSetStaticBaseUrl(siteRequest_, o);
		case "authUrl":
			return ComputateVertxPageLayout.staticSetAuthUrl(siteRequest_, o);
		case "authRealm":
			return ComputateVertxPageLayout.staticSetAuthRealm(siteRequest_, o);
		case "pageUri":
			return ComputateVertxPageLayout.staticSetPageUri(siteRequest_, o);
		case "pageMethod":
			return ComputateVertxPageLayout.staticSetPageMethod(siteRequest_, o);
		case "userKey":
			return ComputateVertxPageLayout.staticSetUserKey(siteRequest_, o);
		case "userFullName":
			return ComputateVertxPageLayout.staticSetUserFullName(siteRequest_, o);
		case "userName":
			return ComputateVertxPageLayout.staticSetUserName(siteRequest_, o);
		case "userEmail":
			return ComputateVertxPageLayout.staticSetUserEmail(siteRequest_, o);
		case "logoutUrl":
			return ComputateVertxPageLayout.staticSetLogoutUrl(siteRequest_, o);
		case "long0":
			return ComputateVertxPageLayout.staticSetLong0(siteRequest_, o);
		case "long1":
			return ComputateVertxPageLayout.staticSetLong1(siteRequest_, o);
		case "int0":
			return ComputateVertxPageLayout.staticSetInt0(siteRequest_, o);
		case "int1":
			return ComputateVertxPageLayout.staticSetInt1(siteRequest_, o);
		case "classSimpleName":
			return ComputateVertxPageLayout.staticSetClassSimpleName(siteRequest_, o);
		case "pageTitle":
			return ComputateVertxPageLayout.staticSetPageTitle(siteRequest_, o);
		case "roles":
			return ComputateVertxPageLayout.staticSetRoles(siteRequest_, o);
		case "rolesRequired":
			return ComputateVertxPageLayout.staticSetRolesRequired(siteRequest_, o);
		case "authRolesAdmin":
			return ComputateVertxPageLayout.staticSetAuthRolesAdmin(siteRequest_, o);
		case "pageImageUri":
			return ComputateVertxPageLayout.staticSetPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return ComputateVertxPageLayout.staticSetContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return ComputateVertxPageLayout.staticSetContextIconName(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrComputateVertxPageLayout(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrComputateVertxPageLayout(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "requestZoneId":
			return ComputateVertxPageLayout.staticSolrRequestZoneId(siteRequest_, (String)o);
		case "requestLocaleId":
			return ComputateVertxPageLayout.staticSolrRequestLocaleId(siteRequest_, (String)o);
		case "staticBaseUrl":
			return ComputateVertxPageLayout.staticSolrStaticBaseUrl(siteRequest_, (String)o);
		case "authUrl":
			return ComputateVertxPageLayout.staticSolrAuthUrl(siteRequest_, (String)o);
		case "authRealm":
			return ComputateVertxPageLayout.staticSolrAuthRealm(siteRequest_, (String)o);
		case "pageUri":
			return ComputateVertxPageLayout.staticSolrPageUri(siteRequest_, (String)o);
		case "pageMethod":
			return ComputateVertxPageLayout.staticSolrPageMethod(siteRequest_, (String)o);
		case "userKey":
			return ComputateVertxPageLayout.staticSolrUserKey(siteRequest_, (Long)o);
		case "userFullName":
			return ComputateVertxPageLayout.staticSolrUserFullName(siteRequest_, (String)o);
		case "userName":
			return ComputateVertxPageLayout.staticSolrUserName(siteRequest_, (String)o);
		case "userEmail":
			return ComputateVertxPageLayout.staticSolrUserEmail(siteRequest_, (String)o);
		case "logoutUrl":
			return ComputateVertxPageLayout.staticSolrLogoutUrl(siteRequest_, (String)o);
		case "long0":
			return ComputateVertxPageLayout.staticSolrLong0(siteRequest_, (Long)o);
		case "long1":
			return ComputateVertxPageLayout.staticSolrLong1(siteRequest_, (Long)o);
		case "int0":
			return ComputateVertxPageLayout.staticSolrInt0(siteRequest_, (Integer)o);
		case "int1":
			return ComputateVertxPageLayout.staticSolrInt1(siteRequest_, (Integer)o);
		case "classSimpleName":
			return ComputateVertxPageLayout.staticSolrClassSimpleName(siteRequest_, (String)o);
		case "pageTitle":
			return ComputateVertxPageLayout.staticSolrPageTitle(siteRequest_, (String)o);
		case "roles":
			return ComputateVertxPageLayout.staticSolrRoles(siteRequest_, (String)o);
		case "rolesRequired":
			return ComputateVertxPageLayout.staticSolrRolesRequired(siteRequest_, (String)o);
		case "authRolesAdmin":
			return ComputateVertxPageLayout.staticSolrAuthRolesAdmin(siteRequest_, (String)o);
		case "pageImageUri":
			return ComputateVertxPageLayout.staticSolrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return ComputateVertxPageLayout.staticSolrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return ComputateVertxPageLayout.staticSolrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrStrComputateVertxPageLayout(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrComputateVertxPageLayout(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "requestZoneId":
			return ComputateVertxPageLayout.staticSolrStrRequestZoneId(siteRequest_, (String)o);
		case "requestLocaleId":
			return ComputateVertxPageLayout.staticSolrStrRequestLocaleId(siteRequest_, (String)o);
		case "staticBaseUrl":
			return ComputateVertxPageLayout.staticSolrStrStaticBaseUrl(siteRequest_, (String)o);
		case "authUrl":
			return ComputateVertxPageLayout.staticSolrStrAuthUrl(siteRequest_, (String)o);
		case "authRealm":
			return ComputateVertxPageLayout.staticSolrStrAuthRealm(siteRequest_, (String)o);
		case "pageUri":
			return ComputateVertxPageLayout.staticSolrStrPageUri(siteRequest_, (String)o);
		case "pageMethod":
			return ComputateVertxPageLayout.staticSolrStrPageMethod(siteRequest_, (String)o);
		case "userKey":
			return ComputateVertxPageLayout.staticSolrStrUserKey(siteRequest_, (Long)o);
		case "userFullName":
			return ComputateVertxPageLayout.staticSolrStrUserFullName(siteRequest_, (String)o);
		case "userName":
			return ComputateVertxPageLayout.staticSolrStrUserName(siteRequest_, (String)o);
		case "userEmail":
			return ComputateVertxPageLayout.staticSolrStrUserEmail(siteRequest_, (String)o);
		case "logoutUrl":
			return ComputateVertxPageLayout.staticSolrStrLogoutUrl(siteRequest_, (String)o);
		case "long0":
			return ComputateVertxPageLayout.staticSolrStrLong0(siteRequest_, (Long)o);
		case "long1":
			return ComputateVertxPageLayout.staticSolrStrLong1(siteRequest_, (Long)o);
		case "int0":
			return ComputateVertxPageLayout.staticSolrStrInt0(siteRequest_, (Integer)o);
		case "int1":
			return ComputateVertxPageLayout.staticSolrStrInt1(siteRequest_, (Integer)o);
		case "classSimpleName":
			return ComputateVertxPageLayout.staticSolrStrClassSimpleName(siteRequest_, (String)o);
		case "pageTitle":
			return ComputateVertxPageLayout.staticSolrStrPageTitle(siteRequest_, (String)o);
		case "roles":
			return ComputateVertxPageLayout.staticSolrStrRoles(siteRequest_, (String)o);
		case "rolesRequired":
			return ComputateVertxPageLayout.staticSolrStrRolesRequired(siteRequest_, (String)o);
		case "authRolesAdmin":
			return ComputateVertxPageLayout.staticSolrStrAuthRolesAdmin(siteRequest_, (String)o);
		case "pageImageUri":
			return ComputateVertxPageLayout.staticSolrStrPageImageUri(siteRequest_, (String)o);
		case "contextIconGroup":
			return ComputateVertxPageLayout.staticSolrStrContextIconGroup(siteRequest_, (String)o);
		case "contextIconName":
			return ComputateVertxPageLayout.staticSolrStrContextIconName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSolrFqComputateVertxPageLayout(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqComputateVertxPageLayout(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "requestZoneId":
			return ComputateVertxPageLayout.staticSolrFqRequestZoneId(siteRequest_, o);
		case "requestLocaleId":
			return ComputateVertxPageLayout.staticSolrFqRequestLocaleId(siteRequest_, o);
		case "staticBaseUrl":
			return ComputateVertxPageLayout.staticSolrFqStaticBaseUrl(siteRequest_, o);
		case "authUrl":
			return ComputateVertxPageLayout.staticSolrFqAuthUrl(siteRequest_, o);
		case "authRealm":
			return ComputateVertxPageLayout.staticSolrFqAuthRealm(siteRequest_, o);
		case "pageUri":
			return ComputateVertxPageLayout.staticSolrFqPageUri(siteRequest_, o);
		case "pageMethod":
			return ComputateVertxPageLayout.staticSolrFqPageMethod(siteRequest_, o);
		case "userKey":
			return ComputateVertxPageLayout.staticSolrFqUserKey(siteRequest_, o);
		case "userFullName":
			return ComputateVertxPageLayout.staticSolrFqUserFullName(siteRequest_, o);
		case "userName":
			return ComputateVertxPageLayout.staticSolrFqUserName(siteRequest_, o);
		case "userEmail":
			return ComputateVertxPageLayout.staticSolrFqUserEmail(siteRequest_, o);
		case "logoutUrl":
			return ComputateVertxPageLayout.staticSolrFqLogoutUrl(siteRequest_, o);
		case "long0":
			return ComputateVertxPageLayout.staticSolrFqLong0(siteRequest_, o);
		case "long1":
			return ComputateVertxPageLayout.staticSolrFqLong1(siteRequest_, o);
		case "int0":
			return ComputateVertxPageLayout.staticSolrFqInt0(siteRequest_, o);
		case "int1":
			return ComputateVertxPageLayout.staticSolrFqInt1(siteRequest_, o);
		case "classSimpleName":
			return ComputateVertxPageLayout.staticSolrFqClassSimpleName(siteRequest_, o);
		case "pageTitle":
			return ComputateVertxPageLayout.staticSolrFqPageTitle(siteRequest_, o);
		case "roles":
			return ComputateVertxPageLayout.staticSolrFqRoles(siteRequest_, o);
		case "rolesRequired":
			return ComputateVertxPageLayout.staticSolrFqRolesRequired(siteRequest_, o);
		case "authRolesAdmin":
			return ComputateVertxPageLayout.staticSolrFqAuthRolesAdmin(siteRequest_, o);
		case "pageImageUri":
			return ComputateVertxPageLayout.staticSolrFqPageImageUri(siteRequest_, o);
		case "contextIconGroup":
			return ComputateVertxPageLayout.staticSolrFqContextIconGroup(siteRequest_, o);
		case "contextIconName":
			return ComputateVertxPageLayout.staticSolrFqContextIconName(siteRequest_, o);
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
					o = defineComputateVertxPageLayout(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineComputateVertxPageLayout(String var, Object val) {
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

	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_serviceRequest = "serviceRequest";
	public static final String VAR_requestZoneId = "requestZoneId";
	public static final String VAR_requestLocaleId = "requestLocaleId";
	public static final String VAR_staticBaseUrl = "staticBaseUrl";
	public static final String VAR_authUrl = "authUrl";
	public static final String VAR_authRealm = "authRealm";
	public static final String VAR_pageUri = "pageUri";
	public static final String VAR_pageMethod = "pageMethod";
	public static final String VAR_params = "params";
	public static final String VAR_userKey = "userKey";
	public static final String VAR_userFullName = "userFullName";
	public static final String VAR_userName = "userName";
	public static final String VAR_userEmail = "userEmail";
	public static final String VAR_logoutUrl = "logoutUrl";
	public static final String VAR_long0 = "long0";
	public static final String VAR_long1 = "long1";
	public static final String VAR_int0 = "int0";
	public static final String VAR_int1 = "int1";
	public static final String VAR_promiseBefore = "promiseBefore";
	public static final String VAR_classSimpleName = "classSimpleName";
	public static final String VAR_pageTitle = "pageTitle";
	public static final String VAR_roles = "roles";
	public static final String VAR_rolesRequired = "rolesRequired";
	public static final String VAR_authRolesAdmin = "authRolesAdmin";
	public static final String VAR_pagination = "pagination";
	public static final String VAR_query = "query";
	public static final String VAR_promiseAfter = "promiseAfter";
	public static final String VAR_pageImageUri = "pageImageUri";
	public static final String VAR_contextIconGroup = "contextIconGroup";
	public static final String VAR_contextIconName = "contextIconName";

	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_serviceRequest = "";
	public static final String DISPLAY_NAME_requestZoneId = "";
	public static final String DISPLAY_NAME_requestLocaleId = "";
	public static final String DISPLAY_NAME_staticBaseUrl = "";
	public static final String DISPLAY_NAME_authUrl = "";
	public static final String DISPLAY_NAME_authRealm = "";
	public static final String DISPLAY_NAME_pageUri = "";
	public static final String DISPLAY_NAME_pageMethod = "";
	public static final String DISPLAY_NAME_params = "";
	public static final String DISPLAY_NAME_userKey = "";
	public static final String DISPLAY_NAME_userFullName = "";
	public static final String DISPLAY_NAME_userName = "";
	public static final String DISPLAY_NAME_userEmail = "";
	public static final String DISPLAY_NAME_logoutUrl = "";
	public static final String DISPLAY_NAME_long0 = "";
	public static final String DISPLAY_NAME_long1 = "";
	public static final String DISPLAY_NAME_int0 = "";
	public static final String DISPLAY_NAME_int1 = "";
	public static final String DISPLAY_NAME_promiseBefore = "";
	public static final String DISPLAY_NAME_classSimpleName = "";
	public static final String DISPLAY_NAME_pageTitle = "";
	public static final String DISPLAY_NAME_roles = "";
	public static final String DISPLAY_NAME_rolesRequired = "";
	public static final String DISPLAY_NAME_authRolesAdmin = "";
	public static final String DISPLAY_NAME_pagination = "";
	public static final String DISPLAY_NAME_query = "";
	public static final String DISPLAY_NAME_promiseAfter = "";
	public static final String DISPLAY_NAME_pageImageUri = "";
	public static final String DISPLAY_NAME_contextIconGroup = "";
	public static final String DISPLAY_NAME_contextIconName = "";

	public static String displayNameForClass(String var) {
		return ComputateVertxPageLayout.displayNameComputateVertxPageLayout(var);
	}
	public static String displayNameComputateVertxPageLayout(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_serviceRequest:
			return DISPLAY_NAME_serviceRequest;
		case VAR_requestZoneId:
			return DISPLAY_NAME_requestZoneId;
		case VAR_requestLocaleId:
			return DISPLAY_NAME_requestLocaleId;
		case VAR_staticBaseUrl:
			return DISPLAY_NAME_staticBaseUrl;
		case VAR_authUrl:
			return DISPLAY_NAME_authUrl;
		case VAR_authRealm:
			return DISPLAY_NAME_authRealm;
		case VAR_pageUri:
			return DISPLAY_NAME_pageUri;
		case VAR_pageMethod:
			return DISPLAY_NAME_pageMethod;
		case VAR_params:
			return DISPLAY_NAME_params;
		case VAR_userKey:
			return DISPLAY_NAME_userKey;
		case VAR_userFullName:
			return DISPLAY_NAME_userFullName;
		case VAR_userName:
			return DISPLAY_NAME_userName;
		case VAR_userEmail:
			return DISPLAY_NAME_userEmail;
		case VAR_logoutUrl:
			return DISPLAY_NAME_logoutUrl;
		case VAR_long0:
			return DISPLAY_NAME_long0;
		case VAR_long1:
			return DISPLAY_NAME_long1;
		case VAR_int0:
			return DISPLAY_NAME_int0;
		case VAR_int1:
			return DISPLAY_NAME_int1;
		case VAR_promiseBefore:
			return DISPLAY_NAME_promiseBefore;
		case VAR_classSimpleName:
			return DISPLAY_NAME_classSimpleName;
		case VAR_pageTitle:
			return DISPLAY_NAME_pageTitle;
		case VAR_roles:
			return DISPLAY_NAME_roles;
		case VAR_rolesRequired:
			return DISPLAY_NAME_rolesRequired;
		case VAR_authRolesAdmin:
			return DISPLAY_NAME_authRolesAdmin;
		case VAR_pagination:
			return DISPLAY_NAME_pagination;
		case VAR_query:
			return DISPLAY_NAME_query;
		case VAR_promiseAfter:
			return DISPLAY_NAME_promiseAfter;
		case VAR_pageImageUri:
			return DISPLAY_NAME_pageImageUri;
		case VAR_contextIconGroup:
			return DISPLAY_NAME_contextIconGroup;
		case VAR_contextIconName:
			return DISPLAY_NAME_contextIconName;
		default:
			return null;
		}
	}
}
