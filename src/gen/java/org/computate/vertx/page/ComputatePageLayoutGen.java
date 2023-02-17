package org.computate.vertx.page;

import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.MathContext;
import org.apache.commons.lang3.math.NumberUtils;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import java.util.Map;
import java.lang.Object;
import java.lang.String;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.service.ServiceRequest;
import java.lang.Long;
import java.lang.Integer;
import java.lang.Void;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**	
<ol>
0<h3>Suggestions that can generate more code for you: </h3></ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ComputatePageLayout objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ComputatePageLayoutGen into the class ComputatePageLayout. 
 * </li>
 * <h3>About the ComputatePageLayout class and it's generated class ComputatePageLayoutGen&lt;Object&gt;: </h3>extends ComputatePageLayoutGen
 * <p>
 * This Java class extends a generated Java class ComputatePageLayoutGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout">Find the class ComputatePageLayout in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ComputatePageLayoutGen<Object>
 * <p>This <code>class ComputatePageLayout extends ComputatePageLayoutGen&lt;Object&gt;</code>, which means it extends a newly generated ComputatePageLayoutGen. 
 * The generated <code>class ComputatePageLayoutGen extends Object</code> which means that ComputatePageLayout extends ComputatePageLayoutGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * Api: true
 * ApiTag.enUS: null
 * ApiUri.enUS: null
 * Color: null
 * IconGroup: null
 * IconName: null
 * Indexed: true
 * {@inheritDoc}
 * <p>By adding a class comment "{@inheritDoc}", the ComputatePageLayout class will inherit the helpful inherited class comments from the super class ComputatePageLayoutGen. 
 * </p>
 * Rows: null
 * Model: true
 * Page: true
 * SuperPage.enUS: null
 * Promise: true
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the ComputatePageLayout Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
 * </p>
 * <p>
 *   Adding protected void methods beginning with an underscore with a Promise as the only parameter will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   <pre>
 *   
 *   	protected void _promiseBefore(Promise&lt;Void&gt; promise) {
 *   		promise.complete();
 *   	}
 *   </pre>
 * </p>
 * <p>
 *   Java classes with the `Model: true` will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   If a super class of this Java class with `Model: true`, then the child class will also inherit `Promise: true`. 
 * </p>
 * AName.enUS: null
 * <p>
 * Delete the class ComputatePageLayout in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.page in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.page&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 **/
public abstract class ComputatePageLayoutGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputatePageLayout.class);

	//////////////////
	// siteRequest_ //
	//////////////////


	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected ComputateSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<ComputateSiteRequest> w);

	public ComputateSiteRequest getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(ComputateSiteRequest siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static ComputateSiteRequest staticSetSiteRequest_(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputatePageLayout siteRequest_Init() {
		Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (ComputatePageLayout)this;
	}

	//////////
	// lang //
	//////////


	/**	 The entity lang
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String lang;

	/**	<br> The entity lang
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:lang">Find the entity lang in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _lang(Wrap<String> w);

	public String getLang() {
		return lang;
	}
	public void setLang(String o) {
		this.lang = ComputatePageLayout.staticSetLang(siteRequest_, o);
	}
	public static String staticSetLang(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout langInit() {
		Wrap<String> langWrap = new Wrap<String>().var("lang");
		if(lang == null) {
			_lang(langWrap);
			setLang(langWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchLang(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLang(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLang(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrLang(siteRequest_, ComputatePageLayout.staticSearchLang(siteRequest_, ComputatePageLayout.staticSetLang(siteRequest_, o)));
	}

	/////////////////
	// requestVars //
	/////////////////


	/**	 The entity requestVars
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Map<String, String> requestVars;

	/**	<br> The entity requestVars
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:requestVars">Find the entity requestVars in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _requestVars(Wrap<Map<String, String>> w);

	public Map<String, String> getRequestVars() {
		return requestVars;
	}

	public void setRequestVars(Map<String, String> requestVars) {
		this.requestVars = requestVars;
	}
	public static Map<String, String> staticSetRequestVars(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputatePageLayout requestVarsInit() {
		Wrap<Map<String, String>> requestVarsWrap = new Wrap<Map<String, String>>().var("requestVars");
		if(requestVars == null) {
			_requestVars(requestVarsWrap);
			setRequestVars(requestVarsWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	////////////
	// config //
	////////////


	/**	 The entity config
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected JsonObject config;

	/**	<br> The entity config
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:config">Find the entity config in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _config(Wrap<JsonObject> w);

	public JsonObject getConfig() {
		return config;
	}

	public void setConfig(JsonObject config) {
		this.config = config;
	}
	@JsonIgnore
	public void setConfig(String o) {
		this.config = ComputatePageLayout.staticSetConfig(siteRequest_, o);
	}
	public static JsonObject staticSetConfig(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputatePageLayout configInit() {
		Wrap<JsonObject> configWrap = new Wrap<JsonObject>().var("config");
		if(config == null) {
			_config(configWrap);
			setConfig(configWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static JsonObject staticSearchConfig(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrConfig(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqConfig(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrConfig(siteRequest_, ComputatePageLayout.staticSearchConfig(siteRequest_, ComputatePageLayout.staticSetConfig(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:serviceRequest">Find the entity serviceRequest in Solr</a>
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
	public static ServiceRequest staticSetServiceRequest(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputatePageLayout serviceRequestInit() {
		Wrap<ServiceRequest> serviceRequestWrap = new Wrap<ServiceRequest>().var("serviceRequest");
		if(serviceRequest == null) {
			_serviceRequest(serviceRequestWrap);
			setServiceRequest(serviceRequestWrap.o);
		}
		return (ComputatePageLayout)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:staticBaseUrl">Find the entity staticBaseUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _staticBaseUrl(Wrap<String> w);

	public String getStaticBaseUrl() {
		return staticBaseUrl;
	}
	public void setStaticBaseUrl(String o) {
		this.staticBaseUrl = ComputatePageLayout.staticSetStaticBaseUrl(siteRequest_, o);
	}
	public static String staticSetStaticBaseUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout staticBaseUrlInit() {
		Wrap<String> staticBaseUrlWrap = new Wrap<String>().var("staticBaseUrl");
		if(staticBaseUrl == null) {
			_staticBaseUrl(staticBaseUrlWrap);
			setStaticBaseUrl(staticBaseUrlWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchStaticBaseUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrStaticBaseUrl(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqStaticBaseUrl(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrStaticBaseUrl(siteRequest_, ComputatePageLayout.staticSearchStaticBaseUrl(siteRequest_, ComputatePageLayout.staticSetStaticBaseUrl(siteRequest_, o)));
	}

	/////////////////
	// siteBaseUrl //
	/////////////////


	/**	 The entity siteBaseUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String siteBaseUrl;

	/**	<br> The entity siteBaseUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:siteBaseUrl">Find the entity siteBaseUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteBaseUrl(Wrap<String> w);

	public String getSiteBaseUrl() {
		return siteBaseUrl;
	}
	public void setSiteBaseUrl(String o) {
		this.siteBaseUrl = ComputatePageLayout.staticSetSiteBaseUrl(siteRequest_, o);
	}
	public static String staticSetSiteBaseUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout siteBaseUrlInit() {
		Wrap<String> siteBaseUrlWrap = new Wrap<String>().var("siteBaseUrl");
		if(siteBaseUrl == null) {
			_siteBaseUrl(siteBaseUrlWrap);
			setSiteBaseUrl(siteBaseUrlWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchSiteBaseUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSiteBaseUrl(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSiteBaseUrl(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrSiteBaseUrl(siteRequest_, ComputatePageLayout.staticSearchSiteBaseUrl(siteRequest_, ComputatePageLayout.staticSetSiteBaseUrl(siteRequest_, o)));
	}

	/////////////////
	// siteAuthUrl //
	/////////////////


	/**	 The entity siteAuthUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String siteAuthUrl;

	/**	<br> The entity siteAuthUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:siteAuthUrl">Find the entity siteAuthUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteAuthUrl(Wrap<String> w);

	public String getSiteAuthUrl() {
		return siteAuthUrl;
	}
	public void setSiteAuthUrl(String o) {
		this.siteAuthUrl = ComputatePageLayout.staticSetSiteAuthUrl(siteRequest_, o);
	}
	public static String staticSetSiteAuthUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout siteAuthUrlInit() {
		Wrap<String> siteAuthUrlWrap = new Wrap<String>().var("siteAuthUrl");
		if(siteAuthUrl == null) {
			_siteAuthUrl(siteAuthUrlWrap);
			setSiteAuthUrl(siteAuthUrlWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchSiteAuthUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSiteAuthUrl(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSiteAuthUrl(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrSiteAuthUrl(siteRequest_, ComputatePageLayout.staticSearchSiteAuthUrl(siteRequest_, ComputatePageLayout.staticSetSiteAuthUrl(siteRequest_, o)));
	}

	///////////////////
	// siteAuthRealm //
	///////////////////


	/**	 The entity siteAuthRealm
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String siteAuthRealm;

	/**	<br> The entity siteAuthRealm
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:siteAuthRealm">Find the entity siteAuthRealm in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteAuthRealm(Wrap<String> w);

	public String getSiteAuthRealm() {
		return siteAuthRealm;
	}
	public void setSiteAuthRealm(String o) {
		this.siteAuthRealm = ComputatePageLayout.staticSetSiteAuthRealm(siteRequest_, o);
	}
	public static String staticSetSiteAuthRealm(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout siteAuthRealmInit() {
		Wrap<String> siteAuthRealmWrap = new Wrap<String>().var("siteAuthRealm");
		if(siteAuthRealm == null) {
			_siteAuthRealm(siteAuthRealmWrap);
			setSiteAuthRealm(siteAuthRealmWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchSiteAuthRealm(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSiteAuthRealm(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSiteAuthRealm(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrSiteAuthRealm(siteRequest_, ComputatePageLayout.staticSearchSiteAuthRealm(siteRequest_, ComputatePageLayout.staticSetSiteAuthRealm(siteRequest_, o)));
	}

	////////////////////
	// fontAwesomeKit //
	////////////////////


	/**	 The entity fontAwesomeKit
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String fontAwesomeKit;

	/**	<br> The entity fontAwesomeKit
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:fontAwesomeKit">Find the entity fontAwesomeKit in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _fontAwesomeKit(Wrap<String> w);

	public String getFontAwesomeKit() {
		return fontAwesomeKit;
	}
	public void setFontAwesomeKit(String o) {
		this.fontAwesomeKit = ComputatePageLayout.staticSetFontAwesomeKit(siteRequest_, o);
	}
	public static String staticSetFontAwesomeKit(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout fontAwesomeKitInit() {
		Wrap<String> fontAwesomeKitWrap = new Wrap<String>().var("fontAwesomeKit");
		if(fontAwesomeKit == null) {
			_fontAwesomeKit(fontAwesomeKitWrap);
			setFontAwesomeKit(fontAwesomeKitWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchFontAwesomeKit(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrFontAwesomeKit(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFontAwesomeKit(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrFontAwesomeKit(siteRequest_, ComputatePageLayout.staticSearchFontAwesomeKit(siteRequest_, ComputatePageLayout.staticSetFontAwesomeKit(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUri(Wrap<String> w);

	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String o) {
		this.pageUri = ComputatePageLayout.staticSetPageUri(siteRequest_, o);
	}
	public static String staticSetPageUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout pageUriInit() {
		Wrap<String> pageUriWrap = new Wrap<String>().var("pageUri");
		if(pageUri == null) {
			_pageUri(pageUriWrap);
			setPageUri(pageUriWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchPageUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUri(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUri(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageUri(siteRequest_, ComputatePageLayout.staticSearchPageUri(siteRequest_, ComputatePageLayout.staticSetPageUri(siteRequest_, o)));
	}

	////////////
	// pageId //
	////////////


	/**	 The entity pageId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageId;

	/**	<br> The entity pageId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageId">Find the entity pageId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageId(Wrap<String> w);

	public String getPageId() {
		return pageId;
	}
	public void setPageId(String o) {
		this.pageId = ComputatePageLayout.staticSetPageId(siteRequest_, o);
	}
	public static String staticSetPageId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout pageIdInit() {
		Wrap<String> pageIdWrap = new Wrap<String>().var("pageId");
		if(pageId == null) {
			_pageId(pageIdWrap);
			setPageId(pageIdWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchPageId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageId(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageId(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageId(siteRequest_, ComputatePageLayout.staticSearchPageId(siteRequest_, ComputatePageLayout.staticSetPageId(siteRequest_, o)));
	}

	////////////
	// apiUri //
	////////////


	/**	 The entity apiUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String apiUri;

	/**	<br> The entity apiUri
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:apiUri">Find the entity apiUri in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _apiUri(Wrap<String> w);

	public String getApiUri() {
		return apiUri;
	}
	public void setApiUri(String o) {
		this.apiUri = ComputatePageLayout.staticSetApiUri(siteRequest_, o);
	}
	public static String staticSetApiUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout apiUriInit() {
		Wrap<String> apiUriWrap = new Wrap<String>().var("apiUri");
		if(apiUri == null) {
			_apiUri(apiUriWrap);
			setApiUri(apiUriWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchApiUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrApiUri(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqApiUri(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrApiUri(siteRequest_, ComputatePageLayout.staticSearchApiUri(siteRequest_, ComputatePageLayout.staticSetApiUri(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageMethod">Find the entity pageMethod in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageMethod(Wrap<String> w);

	public String getPageMethod() {
		return pageMethod;
	}
	public void setPageMethod(String o) {
		this.pageMethod = ComputatePageLayout.staticSetPageMethod(siteRequest_, o);
	}
	public static String staticSetPageMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout pageMethodInit() {
		Wrap<String> pageMethodWrap = new Wrap<String>().var("pageMethod");
		if(pageMethod == null) {
			_pageMethod(pageMethodWrap);
			setPageMethod(pageMethodWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchPageMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageMethod(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageMethod(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageMethod(siteRequest_, ComputatePageLayout.staticSearchPageMethod(siteRequest_, ComputatePageLayout.staticSetPageMethod(siteRequest_, o)));
	}

	////////////
	// params //
	////////////


	/**	 The entity params
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject params;

	/**	<br> The entity params
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:params">Find the entity params in Solr</a>
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
	@JsonIgnore
	public void setParams(String o) {
		this.params = ComputatePageLayout.staticSetParams(siteRequest_, o);
	}
	public static JsonObject staticSetParams(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputatePageLayout paramsInit() {
		Wrap<JsonObject> paramsWrap = new Wrap<JsonObject>().var("params");
		if(params == null) {
			_params(paramsWrap);
			setParams(paramsWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static JsonObject staticSearchParams(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrParams(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqParams(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrParams(siteRequest_, ComputatePageLayout.staticSearchParams(siteRequest_, ComputatePageLayout.staticSetParams(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:userKey">Find the entity userKey in Solr</a>
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
		this.userKey = ComputatePageLayout.staticSetUserKey(siteRequest_, o);
	}
	public static Long staticSetUserKey(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputatePageLayout userKeyInit() {
		Wrap<Long> userKeyWrap = new Wrap<Long>().var("userKey");
		if(userKey == null) {
			_userKey(userKeyWrap);
			setUserKey(userKeyWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static Long staticSearchUserKey(ComputateSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrUserKey(ComputateSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUserKey(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrUserKey(siteRequest_, ComputatePageLayout.staticSearchUserKey(siteRequest_, ComputatePageLayout.staticSetUserKey(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:userFullName">Find the entity userFullName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userFullName(Wrap<String> w);

	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String o) {
		this.userFullName = ComputatePageLayout.staticSetUserFullName(siteRequest_, o);
	}
	public static String staticSetUserFullName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout userFullNameInit() {
		Wrap<String> userFullNameWrap = new Wrap<String>().var("userFullName");
		if(userFullName == null) {
			_userFullName(userFullNameWrap);
			setUserFullName(userFullNameWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchUserFullName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrUserFullName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUserFullName(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrUserFullName(siteRequest_, ComputatePageLayout.staticSearchUserFullName(siteRequest_, ComputatePageLayout.staticSetUserFullName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:userName">Find the entity userName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userName(Wrap<String> w);

	public String getUserName() {
		return userName;
	}
	public void setUserName(String o) {
		this.userName = ComputatePageLayout.staticSetUserName(siteRequest_, o);
	}
	public static String staticSetUserName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout userNameInit() {
		Wrap<String> userNameWrap = new Wrap<String>().var("userName");
		if(userName == null) {
			_userName(userNameWrap);
			setUserName(userNameWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchUserName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrUserName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUserName(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrUserName(siteRequest_, ComputatePageLayout.staticSearchUserName(siteRequest_, ComputatePageLayout.staticSetUserName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:userEmail">Find the entity userEmail in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userEmail(Wrap<String> w);

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String o) {
		this.userEmail = ComputatePageLayout.staticSetUserEmail(siteRequest_, o);
	}
	public static String staticSetUserEmail(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout userEmailInit() {
		Wrap<String> userEmailWrap = new Wrap<String>().var("userEmail");
		if(userEmail == null) {
			_userEmail(userEmailWrap);
			setUserEmail(userEmailWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchUserEmail(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrUserEmail(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUserEmail(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrUserEmail(siteRequest_, ComputatePageLayout.staticSearchUserEmail(siteRequest_, ComputatePageLayout.staticSetUserEmail(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:logoutUrl">Find the entity logoutUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _logoutUrl(Wrap<String> w);

	public String getLogoutUrl() {
		return logoutUrl;
	}
	public void setLogoutUrl(String o) {
		this.logoutUrl = ComputatePageLayout.staticSetLogoutUrl(siteRequest_, o);
	}
	public static String staticSetLogoutUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout logoutUrlInit() {
		Wrap<String> logoutUrlWrap = new Wrap<String>().var("logoutUrl");
		if(logoutUrl == null) {
			_logoutUrl(logoutUrlWrap);
			setLogoutUrl(logoutUrlWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchLogoutUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLogoutUrl(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLogoutUrl(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrLogoutUrl(siteRequest_, ComputatePageLayout.staticSearchLogoutUrl(siteRequest_, ComputatePageLayout.staticSetLogoutUrl(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:long0">Find the entity long0 in Solr</a>
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
		this.long0 = ComputatePageLayout.staticSetLong0(siteRequest_, o);
	}
	public static Long staticSetLong0(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputatePageLayout long0Init() {
		Wrap<Long> long0Wrap = new Wrap<Long>().var("long0");
		if(long0 == null) {
			_long0(long0Wrap);
			setLong0(long0Wrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static Long staticSearchLong0(ComputateSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrLong0(ComputateSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLong0(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrLong0(siteRequest_, ComputatePageLayout.staticSearchLong0(siteRequest_, ComputatePageLayout.staticSetLong0(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:long1">Find the entity long1 in Solr</a>
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
		this.long1 = ComputatePageLayout.staticSetLong1(siteRequest_, o);
	}
	public static Long staticSetLong1(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputatePageLayout long1Init() {
		Wrap<Long> long1Wrap = new Wrap<Long>().var("long1");
		if(long1 == null) {
			_long1(long1Wrap);
			setLong1(long1Wrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static Long staticSearchLong1(ComputateSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrLong1(ComputateSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLong1(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrLong1(siteRequest_, ComputatePageLayout.staticSearchLong1(siteRequest_, ComputatePageLayout.staticSetLong1(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:int0">Find the entity int0 in Solr</a>
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
		this.int0 = ComputatePageLayout.staticSetInt0(siteRequest_, o);
	}
	public static Integer staticSetInt0(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputatePageLayout int0Init() {
		Wrap<Integer> int0Wrap = new Wrap<Integer>().var("int0");
		if(int0 == null) {
			_int0(int0Wrap);
			setInt0(int0Wrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static Integer staticSearchInt0(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrInt0(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInt0(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrInt0(siteRequest_, ComputatePageLayout.staticSearchInt0(siteRequest_, ComputatePageLayout.staticSetInt0(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:int1">Find the entity int1 in Solr</a>
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
		this.int1 = ComputatePageLayout.staticSetInt1(siteRequest_, o);
	}
	public static Integer staticSetInt1(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputatePageLayout int1Init() {
		Wrap<Integer> int1Wrap = new Wrap<Integer>().var("int1");
		if(int1 == null) {
			_int1(int1Wrap);
			setInt1(int1Wrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static Integer staticSearchInt1(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrInt1(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqInt1(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrInt1(siteRequest_, ComputatePageLayout.staticSearchInt1(siteRequest_, ComputatePageLayout.staticSetInt1(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
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
	public static Void staticSetPromiseBefore(ComputateSiteRequest siteRequest_, String o) {
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSimpleName(Wrap<String> w);

	public String getClassSimpleName() {
		return classSimpleName;
	}
	public void setClassSimpleName(String o) {
		this.classSimpleName = ComputatePageLayout.staticSetClassSimpleName(siteRequest_, o);
	}
	public static String staticSetClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout classSimpleNameInit() {
		Wrap<String> classSimpleNameWrap = new Wrap<String>().var("classSimpleName");
		if(classSimpleName == null) {
			_classSimpleName(classSimpleNameWrap);
			setClassSimpleName(classSimpleNameWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrClassSimpleName(siteRequest_, ComputatePageLayout.staticSearchClassSimpleName(siteRequest_, ComputatePageLayout.staticSetClassSimpleName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageTitle(Wrap<String> w);

	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String o) {
		this.pageTitle = ComputatePageLayout.staticSetPageTitle(siteRequest_, o);
	}
	public static String staticSetPageTitle(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout pageTitleInit() {
		Wrap<String> pageTitleWrap = new Wrap<String>().var("pageTitle");
		if(pageTitle == null) {
			_pageTitle(pageTitleWrap);
			setPageTitle(pageTitleWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchPageTitle(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageTitle(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageTitle(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageTitle(siteRequest_, ComputatePageLayout.staticSearchPageTitle(siteRequest_, ComputatePageLayout.staticSetPageTitle(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:roles">Find the entity roles in Solr</a>
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
	public static String staticSetRoles(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputatePageLayout addRoles(String...objects) {
		for(String o : objects) {
			addRoles(o);
		}
		return (ComputatePageLayout)this;
	}
	public ComputatePageLayout addRoles(String o) {
		if(o != null)
			this.roles.add(o);
		return (ComputatePageLayout)this;
	}
	@JsonIgnore
	public void setRoles(JsonArray objects) {
		roles.clear();
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addRoles(o);
		}
	}
	protected ComputatePageLayout rolesInit() {
		_roles(roles);
		return (ComputatePageLayout)this;
	}

	public static String staticSearchRoles(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRoles(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRoles(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrRoles(siteRequest_, ComputatePageLayout.staticSearchRoles(siteRequest_, ComputatePageLayout.staticSetRoles(siteRequest_, o)));
	}

	//////////////////
	// roleRequired //
	//////////////////


	/**	 The entity roleRequired
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> roleRequired = new ArrayList<String>();

	/**	<br> The entity roleRequired
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:roleRequired">Find the entity roleRequired in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _roleRequired(List<String> l);

	public List<String> getRoleRequired() {
		return roleRequired;
	}

	public void setRoleRequired(List<String> roleRequired) {
		this.roleRequired = roleRequired;
	}
	public static String staticSetRoleRequired(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputatePageLayout addRoleRequired(String...objects) {
		for(String o : objects) {
			addRoleRequired(o);
		}
		return (ComputatePageLayout)this;
	}
	public ComputatePageLayout addRoleRequired(String o) {
		if(o != null)
			this.roleRequired.add(o);
		return (ComputatePageLayout)this;
	}
	@JsonIgnore
	public void setRoleRequired(JsonArray objects) {
		roleRequired.clear();
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addRoleRequired(o);
		}
	}
	protected ComputatePageLayout roleRequiredInit() {
		_roleRequired(roleRequired);
		return (ComputatePageLayout)this;
	}

	public static String staticSearchRoleRequired(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRoleRequired(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRoleRequired(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrRoleRequired(siteRequest_, ComputatePageLayout.staticSearchRoleRequired(siteRequest_, ComputatePageLayout.staticSetRoleRequired(siteRequest_, o)));
	}

	///////////////////
	// authRoleAdmin //
	///////////////////


	/**	 The entity authRoleAdmin
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> authRoleAdmin = new ArrayList<String>();

	/**	<br> The entity authRoleAdmin
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:authRoleAdmin">Find the entity authRoleAdmin in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _authRoleAdmin(List<String> l);

	public List<String> getAuthRoleAdmin() {
		return authRoleAdmin;
	}

	public void setAuthRoleAdmin(List<String> authRoleAdmin) {
		this.authRoleAdmin = authRoleAdmin;
	}
	public static String staticSetAuthRoleAdmin(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputatePageLayout addAuthRoleAdmin(String...objects) {
		for(String o : objects) {
			addAuthRoleAdmin(o);
		}
		return (ComputatePageLayout)this;
	}
	public ComputatePageLayout addAuthRoleAdmin(String o) {
		if(o != null)
			this.authRoleAdmin.add(o);
		return (ComputatePageLayout)this;
	}
	@JsonIgnore
	public void setAuthRoleAdmin(JsonArray objects) {
		authRoleAdmin.clear();
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addAuthRoleAdmin(o);
		}
	}
	protected ComputatePageLayout authRoleAdminInit() {
		_authRoleAdmin(authRoleAdmin);
		return (ComputatePageLayout)this;
	}

	public static String staticSearchAuthRoleAdmin(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAuthRoleAdmin(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAuthRoleAdmin(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrAuthRoleAdmin(siteRequest_, ComputatePageLayout.staticSearchAuthRoleAdmin(siteRequest_, ComputatePageLayout.staticSetAuthRoleAdmin(siteRequest_, o)));
	}

	////////////////
	// pagination //
	////////////////


	/**	 The entity pagination
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject pagination = new JsonObject();

	/**	<br> The entity pagination
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pagination">Find the entity pagination in Solr</a>
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
	@JsonIgnore
	public void setPagination(String o) {
		this.pagination = ComputatePageLayout.staticSetPagination(siteRequest_, o);
	}
	public static JsonObject staticSetPagination(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputatePageLayout paginationInit() {
		_pagination(pagination);
		return (ComputatePageLayout)this;
	}

	public static JsonObject staticSearchPagination(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrPagination(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPagination(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPagination(siteRequest_, ComputatePageLayout.staticSearchPagination(siteRequest_, ComputatePageLayout.staticSetPagination(siteRequest_, o)));
	}

	///////////
	// varsQ //
	///////////


	/**	 The entity varsQ
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject varsQ = new JsonObject();

	/**	<br> The entity varsQ
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:varsQ">Find the entity varsQ in Solr</a>
	 * <br>
	 * @param vars is the entity already constructed. 
	 **/
	protected abstract void _varsQ(JsonObject vars);

	public JsonObject getVarsQ() {
		return varsQ;
	}

	public void setVarsQ(JsonObject varsQ) {
		this.varsQ = varsQ;
	}
	@JsonIgnore
	public void setVarsQ(String o) {
		this.varsQ = ComputatePageLayout.staticSetVarsQ(siteRequest_, o);
	}
	public static JsonObject staticSetVarsQ(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputatePageLayout varsQInit() {
		_varsQ(varsQ);
		return (ComputatePageLayout)this;
	}

	public static JsonObject staticSearchVarsQ(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrVarsQ(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVarsQ(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrVarsQ(siteRequest_, ComputatePageLayout.staticSearchVarsQ(siteRequest_, ComputatePageLayout.staticSetVarsQ(siteRequest_, o)));
	}

	////////////
	// varsFq //
	////////////


	/**	 The entity varsFq
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject varsFq = new JsonObject();

	/**	<br> The entity varsFq
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:varsFq">Find the entity varsFq in Solr</a>
	 * <br>
	 * @param vars is the entity already constructed. 
	 **/
	protected abstract void _varsFq(JsonObject vars);

	public JsonObject getVarsFq() {
		return varsFq;
	}

	public void setVarsFq(JsonObject varsFq) {
		this.varsFq = varsFq;
	}
	@JsonIgnore
	public void setVarsFq(String o) {
		this.varsFq = ComputatePageLayout.staticSetVarsFq(siteRequest_, o);
	}
	public static JsonObject staticSetVarsFq(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputatePageLayout varsFqInit() {
		_varsFq(varsFq);
		return (ComputatePageLayout)this;
	}

	public static JsonObject staticSearchVarsFq(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrVarsFq(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVarsFq(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrVarsFq(siteRequest_, ComputatePageLayout.staticSearchVarsFq(siteRequest_, ComputatePageLayout.staticSetVarsFq(siteRequest_, o)));
	}

	///////////////
	// varsRange //
	///////////////


	/**	 The entity varsRange
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject varsRange = new JsonObject();

	/**	<br> The entity varsRange
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:varsRange">Find the entity varsRange in Solr</a>
	 * <br>
	 * @param vars is the entity already constructed. 
	 **/
	protected abstract void _varsRange(JsonObject vars);

	public JsonObject getVarsRange() {
		return varsRange;
	}

	public void setVarsRange(JsonObject varsRange) {
		this.varsRange = varsRange;
	}
	@JsonIgnore
	public void setVarsRange(String o) {
		this.varsRange = ComputatePageLayout.staticSetVarsRange(siteRequest_, o);
	}
	public static JsonObject staticSetVarsRange(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputatePageLayout varsRangeInit() {
		_varsRange(varsRange);
		return (ComputatePageLayout)this;
	}

	public static JsonObject staticSearchVarsRange(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrVarsRange(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVarsRange(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrVarsRange(siteRequest_, ComputatePageLayout.staticSearchVarsRange(siteRequest_, ComputatePageLayout.staticSetVarsRange(siteRequest_, o)));
	}

	///////////
	// query //
	///////////


	/**	 The entity query
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject query = new JsonObject();

	/**	<br> The entity query
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:query">Find the entity query in Solr</a>
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
	@JsonIgnore
	public void setQuery(String o) {
		this.query = ComputatePageLayout.staticSetQuery(siteRequest_, o);
	}
	public static JsonObject staticSetQuery(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputatePageLayout queryInit() {
		_query(query);
		return (ComputatePageLayout)this;
	}

	public static JsonObject staticSearchQuery(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrQuery(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqQuery(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrQuery(siteRequest_, ComputatePageLayout.staticSearchQuery(siteRequest_, ComputatePageLayout.staticSetQuery(siteRequest_, o)));
	}

	//////////////
	// queryStr //
	//////////////


	/**	 The entity queryStr
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String queryStr;

	/**	<br> The entity queryStr
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:queryStr">Find the entity queryStr in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _queryStr(Wrap<String> w);

	public String getQueryStr() {
		return queryStr;
	}
	public void setQueryStr(String o) {
		this.queryStr = ComputatePageLayout.staticSetQueryStr(siteRequest_, o);
	}
	public static String staticSetQueryStr(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout queryStrInit() {
		Wrap<String> queryStrWrap = new Wrap<String>().var("queryStr");
		if(queryStr == null) {
			_queryStr(queryStrWrap);
			setQueryStr(queryStrWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchQueryStr(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrQueryStr(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqQueryStr(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrQueryStr(siteRequest_, ComputatePageLayout.staticSearchQueryStr(siteRequest_, ComputatePageLayout.staticSetQueryStr(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:promiseAfter">Find the entity promiseAfter in Solr</a>
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
	public static Void staticSetPromiseAfter(ComputateSiteRequest siteRequest_, String o) {
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageUri(Wrap<String> w);

	public String getPageImageUri() {
		return pageImageUri;
	}
	public void setPageImageUri(String o) {
		this.pageImageUri = ComputatePageLayout.staticSetPageImageUri(siteRequest_, o);
	}
	public static String staticSetPageImageUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout pageImageUriInit() {
		Wrap<String> pageImageUriWrap = new Wrap<String>().var("pageImageUri");
		if(pageImageUri == null) {
			_pageImageUri(pageImageUriWrap);
			setPageImageUri(pageImageUriWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchPageImageUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageImageUri(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageImageUri(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageImageUri(siteRequest_, ComputatePageLayout.staticSearchPageImageUri(siteRequest_, ComputatePageLayout.staticSetPageImageUri(siteRequest_, o)));
	}

	////////////////////
	// pageImageWidth //
	////////////////////


	/**	 The entity pageImageWidth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pageImageWidth;

	/**	<br> The entity pageImageWidth
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageImageWidth">Find the entity pageImageWidth in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageWidth(Wrap<Integer> c);

	public Integer getPageImageWidth() {
		return pageImageWidth;
	}

	public void setPageImageWidth(Integer pageImageWidth) {
		this.pageImageWidth = pageImageWidth;
	}
	@JsonIgnore
	public void setPageImageWidth(String o) {
		this.pageImageWidth = ComputatePageLayout.staticSetPageImageWidth(siteRequest_, o);
	}
	public static Integer staticSetPageImageWidth(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputatePageLayout pageImageWidthInit() {
		Wrap<Integer> pageImageWidthWrap = new Wrap<Integer>().var("pageImageWidth");
		if(pageImageWidth == null) {
			_pageImageWidth(pageImageWidthWrap);
			setPageImageWidth(pageImageWidthWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static Integer staticSearchPageImageWidth(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrPageImageWidth(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageImageWidth(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageImageWidth(siteRequest_, ComputatePageLayout.staticSearchPageImageWidth(siteRequest_, ComputatePageLayout.staticSetPageImageWidth(siteRequest_, o)));
	}

	/////////////////////
	// pageImageHeight //
	/////////////////////


	/**	 The entity pageImageHeight
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer pageImageHeight;

	/**	<br> The entity pageImageHeight
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageImageHeight">Find the entity pageImageHeight in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageHeight(Wrap<Integer> c);

	public Integer getPageImageHeight() {
		return pageImageHeight;
	}

	public void setPageImageHeight(Integer pageImageHeight) {
		this.pageImageHeight = pageImageHeight;
	}
	@JsonIgnore
	public void setPageImageHeight(String o) {
		this.pageImageHeight = ComputatePageLayout.staticSetPageImageHeight(siteRequest_, o);
	}
	public static Integer staticSetPageImageHeight(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputatePageLayout pageImageHeightInit() {
		Wrap<Integer> pageImageHeightWrap = new Wrap<Integer>().var("pageImageHeight");
		if(pageImageHeight == null) {
			_pageImageHeight(pageImageHeightWrap);
			setPageImageHeight(pageImageHeightWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static Integer staticSearchPageImageHeight(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrPageImageHeight(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageImageHeight(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageImageHeight(siteRequest_, ComputatePageLayout.staticSearchPageImageHeight(siteRequest_, ComputatePageLayout.staticSetPageImageHeight(siteRequest_, o)));
	}

	/////////////////
	// pageVideoId //
	/////////////////


	/**	 The entity pageVideoId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageVideoId;

	/**	<br> The entity pageVideoId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageVideoId">Find the entity pageVideoId in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageVideoId(Wrap<String> c);

	public String getPageVideoId() {
		return pageVideoId;
	}
	public void setPageVideoId(String o) {
		this.pageVideoId = ComputatePageLayout.staticSetPageVideoId(siteRequest_, o);
	}
	public static String staticSetPageVideoId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout pageVideoIdInit() {
		Wrap<String> pageVideoIdWrap = new Wrap<String>().var("pageVideoId");
		if(pageVideoId == null) {
			_pageVideoId(pageVideoIdWrap);
			setPageVideoId(pageVideoIdWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchPageVideoId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageVideoId(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageVideoId(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageVideoId(siteRequest_, ComputatePageLayout.staticSearchPageVideoId(siteRequest_, ComputatePageLayout.staticSetPageVideoId(siteRequest_, o)));
	}

	////////////////////
	// classIconGroup //
	////////////////////


	/**	 The entity classIconGroup
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classIconGroup;

	/**	<br> The entity classIconGroup
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:classIconGroup">Find the entity classIconGroup in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classIconGroup(Wrap<String> w);

	public String getClassIconGroup() {
		return classIconGroup;
	}
	public void setClassIconGroup(String o) {
		this.classIconGroup = ComputatePageLayout.staticSetClassIconGroup(siteRequest_, o);
	}
	public static String staticSetClassIconGroup(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout classIconGroupInit() {
		Wrap<String> classIconGroupWrap = new Wrap<String>().var("classIconGroup");
		if(classIconGroup == null) {
			_classIconGroup(classIconGroupWrap);
			setClassIconGroup(classIconGroupWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchClassIconGroup(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassIconGroup(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassIconGroup(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrClassIconGroup(siteRequest_, ComputatePageLayout.staticSearchClassIconGroup(siteRequest_, ComputatePageLayout.staticSetClassIconGroup(siteRequest_, o)));
	}

	///////////////////
	// classIconName //
	///////////////////


	/**	 The entity classIconName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classIconName;

	/**	<br> The entity classIconName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:classIconName">Find the entity classIconName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classIconName(Wrap<String> w);

	public String getClassIconName() {
		return classIconName;
	}
	public void setClassIconName(String o) {
		this.classIconName = ComputatePageLayout.staticSetClassIconName(siteRequest_, o);
	}
	public static String staticSetClassIconName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout classIconNameInit() {
		Wrap<String> classIconNameWrap = new Wrap<String>().var("classIconName");
		if(classIconName == null) {
			_classIconName(classIconNameWrap);
			setClassIconName(classIconNameWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchClassIconName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassIconName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassIconName(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrClassIconName(siteRequest_, ComputatePageLayout.staticSearchClassIconName(siteRequest_, ComputatePageLayout.staticSetClassIconName(siteRequest_, o)));
	}

	/////////////////////////
	// classIconCssClasses //
	/////////////////////////


	/**	 The entity classIconCssClasses
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classIconCssClasses;

	/**	<br> The entity classIconCssClasses
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:classIconCssClasses">Find the entity classIconCssClasses in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classIconCssClasses(Wrap<String> w);

	public String getClassIconCssClasses() {
		return classIconCssClasses;
	}
	public void setClassIconCssClasses(String o) {
		this.classIconCssClasses = ComputatePageLayout.staticSetClassIconCssClasses(siteRequest_, o);
	}
	public static String staticSetClassIconCssClasses(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout classIconCssClassesInit() {
		Wrap<String> classIconCssClassesWrap = new Wrap<String>().var("classIconCssClasses");
		if(classIconCssClasses == null) {
			_classIconCssClasses(classIconCssClassesWrap);
			setClassIconCssClasses(classIconCssClassesWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchClassIconCssClasses(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassIconCssClasses(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassIconCssClasses(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrClassIconCssClasses(siteRequest_, ComputatePageLayout.staticSearchClassIconCssClasses(siteRequest_, ComputatePageLayout.staticSetClassIconCssClasses(siteRequest_, o)));
	}

	/////////////////////
	// pageDescription //
	/////////////////////


	/**	 The entity pageDescription
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageDescription;

	/**	<br> The entity pageDescription
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageDescription">Find the entity pageDescription in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageDescription(Wrap<String> w);

	public String getPageDescription() {
		return pageDescription;
	}
	public void setPageDescription(String o) {
		this.pageDescription = ComputatePageLayout.staticSetPageDescription(siteRequest_, o);
	}
	public static String staticSetPageDescription(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputatePageLayout pageDescriptionInit() {
		Wrap<String> pageDescriptionWrap = new Wrap<String>().var("pageDescription");
		if(pageDescription == null) {
			_pageDescription(pageDescriptionWrap);
			setPageDescription(pageDescriptionWrap.o);
		}
		return (ComputatePageLayout)this;
	}

	public static String staticSearchPageDescription(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageDescription(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageDescription(ComputateSiteRequest siteRequest_, String o) {
		return ComputatePageLayout.staticSearchStrPageDescription(siteRequest_, ComputatePageLayout.staticSearchPageDescription(siteRequest_, ComputatePageLayout.staticSetPageDescription(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepComputatePageLayout(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepComputatePageLayout();
	}

	public Future<Void> promiseDeepComputatePageLayout() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseComputatePageLayout(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputatePageLayout(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				langInit();
				requestVarsInit();
				configInit();
				serviceRequestInit();
				staticBaseUrlInit();
				siteBaseUrlInit();
				siteAuthUrlInit();
				siteAuthRealmInit();
				fontAwesomeKitInit();
				pageUriInit();
				pageIdInit();
				apiUriInit();
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
				roleRequiredInit();
				authRoleAdminInit();
				paginationInit();
				varsQInit();
				varsFqInit();
				varsRangeInit();
				queryInit();
				queryStrInit();
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
				pageImageWidthInit();
				pageImageHeightInit();
				pageVideoIdInit();
				classIconGroupInit();
				classIconNameInit();
				classIconCssClassesInit();
				pageDescriptionInit();
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

	public Future<Void> promiseDeepForClass(ComputateSiteRequest siteRequest_) {
		return promiseDeepComputatePageLayout(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputatePageLayout(ComputateSiteRequest siteRequest_) {
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestComputatePageLayout(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputatePageLayout(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainComputatePageLayout(String var) {
		ComputatePageLayout oComputatePageLayout = (ComputatePageLayout)this;
		switch(var) {
			case "siteRequest_":
				return oComputatePageLayout.siteRequest_;
			case "lang":
				return oComputatePageLayout.lang;
			case "requestVars":
				return oComputatePageLayout.requestVars;
			case "config":
				return oComputatePageLayout.config;
			case "serviceRequest":
				return oComputatePageLayout.serviceRequest;
			case "staticBaseUrl":
				return oComputatePageLayout.staticBaseUrl;
			case "siteBaseUrl":
				return oComputatePageLayout.siteBaseUrl;
			case "siteAuthUrl":
				return oComputatePageLayout.siteAuthUrl;
			case "siteAuthRealm":
				return oComputatePageLayout.siteAuthRealm;
			case "fontAwesomeKit":
				return oComputatePageLayout.fontAwesomeKit;
			case "pageUri":
				return oComputatePageLayout.pageUri;
			case "pageId":
				return oComputatePageLayout.pageId;
			case "apiUri":
				return oComputatePageLayout.apiUri;
			case "pageMethod":
				return oComputatePageLayout.pageMethod;
			case "params":
				return oComputatePageLayout.params;
			case "userKey":
				return oComputatePageLayout.userKey;
			case "userFullName":
				return oComputatePageLayout.userFullName;
			case "userName":
				return oComputatePageLayout.userName;
			case "userEmail":
				return oComputatePageLayout.userEmail;
			case "logoutUrl":
				return oComputatePageLayout.logoutUrl;
			case "long0":
				return oComputatePageLayout.long0;
			case "long1":
				return oComputatePageLayout.long1;
			case "int0":
				return oComputatePageLayout.int0;
			case "int1":
				return oComputatePageLayout.int1;
			case "promiseBefore":
				return oComputatePageLayout.promiseBefore;
			case "classSimpleName":
				return oComputatePageLayout.classSimpleName;
			case "pageTitle":
				return oComputatePageLayout.pageTitle;
			case "roles":
				return oComputatePageLayout.roles;
			case "roleRequired":
				return oComputatePageLayout.roleRequired;
			case "authRoleAdmin":
				return oComputatePageLayout.authRoleAdmin;
			case "pagination":
				return oComputatePageLayout.pagination;
			case "varsQ":
				return oComputatePageLayout.varsQ;
			case "varsFq":
				return oComputatePageLayout.varsFq;
			case "varsRange":
				return oComputatePageLayout.varsRange;
			case "query":
				return oComputatePageLayout.query;
			case "queryStr":
				return oComputatePageLayout.queryStr;
			case "promiseAfter":
				return oComputatePageLayout.promiseAfter;
			case "pageImageUri":
				return oComputatePageLayout.pageImageUri;
			case "pageImageWidth":
				return oComputatePageLayout.pageImageWidth;
			case "pageImageHeight":
				return oComputatePageLayout.pageImageHeight;
			case "pageVideoId":
				return oComputatePageLayout.pageVideoId;
			case "classIconGroup":
				return oComputatePageLayout.classIconGroup;
			case "classIconName":
				return oComputatePageLayout.classIconName;
			case "classIconCssClasses":
				return oComputatePageLayout.classIconCssClasses;
			case "pageDescription":
				return oComputatePageLayout.pageDescription;
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
				o = relateComputatePageLayout(v, val);
		}
		return o != null;
	}
	public Object relateComputatePageLayout(String var, Object val) {
		ComputatePageLayout oComputatePageLayout = (ComputatePageLayout)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetComputatePageLayout(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputatePageLayout(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "lang":
			return ComputatePageLayout.staticSetLang(siteRequest_, o);
		case "config":
			return ComputatePageLayout.staticSetConfig(siteRequest_, o);
		case "staticBaseUrl":
			return ComputatePageLayout.staticSetStaticBaseUrl(siteRequest_, o);
		case "siteBaseUrl":
			return ComputatePageLayout.staticSetSiteBaseUrl(siteRequest_, o);
		case "siteAuthUrl":
			return ComputatePageLayout.staticSetSiteAuthUrl(siteRequest_, o);
		case "siteAuthRealm":
			return ComputatePageLayout.staticSetSiteAuthRealm(siteRequest_, o);
		case "fontAwesomeKit":
			return ComputatePageLayout.staticSetFontAwesomeKit(siteRequest_, o);
		case "pageUri":
			return ComputatePageLayout.staticSetPageUri(siteRequest_, o);
		case "pageId":
			return ComputatePageLayout.staticSetPageId(siteRequest_, o);
		case "apiUri":
			return ComputatePageLayout.staticSetApiUri(siteRequest_, o);
		case "pageMethod":
			return ComputatePageLayout.staticSetPageMethod(siteRequest_, o);
		case "params":
			return ComputatePageLayout.staticSetParams(siteRequest_, o);
		case "userKey":
			return ComputatePageLayout.staticSetUserKey(siteRequest_, o);
		case "userFullName":
			return ComputatePageLayout.staticSetUserFullName(siteRequest_, o);
		case "userName":
			return ComputatePageLayout.staticSetUserName(siteRequest_, o);
		case "userEmail":
			return ComputatePageLayout.staticSetUserEmail(siteRequest_, o);
		case "logoutUrl":
			return ComputatePageLayout.staticSetLogoutUrl(siteRequest_, o);
		case "long0":
			return ComputatePageLayout.staticSetLong0(siteRequest_, o);
		case "long1":
			return ComputatePageLayout.staticSetLong1(siteRequest_, o);
		case "int0":
			return ComputatePageLayout.staticSetInt0(siteRequest_, o);
		case "int1":
			return ComputatePageLayout.staticSetInt1(siteRequest_, o);
		case "classSimpleName":
			return ComputatePageLayout.staticSetClassSimpleName(siteRequest_, o);
		case "pageTitle":
			return ComputatePageLayout.staticSetPageTitle(siteRequest_, o);
		case "roles":
			return ComputatePageLayout.staticSetRoles(siteRequest_, o);
		case "roleRequired":
			return ComputatePageLayout.staticSetRoleRequired(siteRequest_, o);
		case "authRoleAdmin":
			return ComputatePageLayout.staticSetAuthRoleAdmin(siteRequest_, o);
		case "pagination":
			return ComputatePageLayout.staticSetPagination(siteRequest_, o);
		case "varsQ":
			return ComputatePageLayout.staticSetVarsQ(siteRequest_, o);
		case "varsFq":
			return ComputatePageLayout.staticSetVarsFq(siteRequest_, o);
		case "varsRange":
			return ComputatePageLayout.staticSetVarsRange(siteRequest_, o);
		case "query":
			return ComputatePageLayout.staticSetQuery(siteRequest_, o);
		case "queryStr":
			return ComputatePageLayout.staticSetQueryStr(siteRequest_, o);
		case "pageImageUri":
			return ComputatePageLayout.staticSetPageImageUri(siteRequest_, o);
		case "pageImageWidth":
			return ComputatePageLayout.staticSetPageImageWidth(siteRequest_, o);
		case "pageImageHeight":
			return ComputatePageLayout.staticSetPageImageHeight(siteRequest_, o);
		case "pageVideoId":
			return ComputatePageLayout.staticSetPageVideoId(siteRequest_, o);
		case "classIconGroup":
			return ComputatePageLayout.staticSetClassIconGroup(siteRequest_, o);
		case "classIconName":
			return ComputatePageLayout.staticSetClassIconName(siteRequest_, o);
		case "classIconCssClasses":
			return ComputatePageLayout.staticSetClassIconCssClasses(siteRequest_, o);
		case "pageDescription":
			return ComputatePageLayout.staticSetPageDescription(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchComputatePageLayout(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchComputatePageLayout(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "lang":
			return ComputatePageLayout.staticSearchLang(siteRequest_, (String)o);
		case "config":
			return ComputatePageLayout.staticSearchConfig(siteRequest_, (JsonObject)o);
		case "staticBaseUrl":
			return ComputatePageLayout.staticSearchStaticBaseUrl(siteRequest_, (String)o);
		case "siteBaseUrl":
			return ComputatePageLayout.staticSearchSiteBaseUrl(siteRequest_, (String)o);
		case "siteAuthUrl":
			return ComputatePageLayout.staticSearchSiteAuthUrl(siteRequest_, (String)o);
		case "siteAuthRealm":
			return ComputatePageLayout.staticSearchSiteAuthRealm(siteRequest_, (String)o);
		case "fontAwesomeKit":
			return ComputatePageLayout.staticSearchFontAwesomeKit(siteRequest_, (String)o);
		case "pageUri":
			return ComputatePageLayout.staticSearchPageUri(siteRequest_, (String)o);
		case "pageId":
			return ComputatePageLayout.staticSearchPageId(siteRequest_, (String)o);
		case "apiUri":
			return ComputatePageLayout.staticSearchApiUri(siteRequest_, (String)o);
		case "pageMethod":
			return ComputatePageLayout.staticSearchPageMethod(siteRequest_, (String)o);
		case "params":
			return ComputatePageLayout.staticSearchParams(siteRequest_, (JsonObject)o);
		case "userKey":
			return ComputatePageLayout.staticSearchUserKey(siteRequest_, (Long)o);
		case "userFullName":
			return ComputatePageLayout.staticSearchUserFullName(siteRequest_, (String)o);
		case "userName":
			return ComputatePageLayout.staticSearchUserName(siteRequest_, (String)o);
		case "userEmail":
			return ComputatePageLayout.staticSearchUserEmail(siteRequest_, (String)o);
		case "logoutUrl":
			return ComputatePageLayout.staticSearchLogoutUrl(siteRequest_, (String)o);
		case "long0":
			return ComputatePageLayout.staticSearchLong0(siteRequest_, (Long)o);
		case "long1":
			return ComputatePageLayout.staticSearchLong1(siteRequest_, (Long)o);
		case "int0":
			return ComputatePageLayout.staticSearchInt0(siteRequest_, (Integer)o);
		case "int1":
			return ComputatePageLayout.staticSearchInt1(siteRequest_, (Integer)o);
		case "classSimpleName":
			return ComputatePageLayout.staticSearchClassSimpleName(siteRequest_, (String)o);
		case "pageTitle":
			return ComputatePageLayout.staticSearchPageTitle(siteRequest_, (String)o);
		case "roles":
			return ComputatePageLayout.staticSearchRoles(siteRequest_, (String)o);
		case "roleRequired":
			return ComputatePageLayout.staticSearchRoleRequired(siteRequest_, (String)o);
		case "authRoleAdmin":
			return ComputatePageLayout.staticSearchAuthRoleAdmin(siteRequest_, (String)o);
		case "pagination":
			return ComputatePageLayout.staticSearchPagination(siteRequest_, (JsonObject)o);
		case "varsQ":
			return ComputatePageLayout.staticSearchVarsQ(siteRequest_, (JsonObject)o);
		case "varsFq":
			return ComputatePageLayout.staticSearchVarsFq(siteRequest_, (JsonObject)o);
		case "varsRange":
			return ComputatePageLayout.staticSearchVarsRange(siteRequest_, (JsonObject)o);
		case "query":
			return ComputatePageLayout.staticSearchQuery(siteRequest_, (JsonObject)o);
		case "queryStr":
			return ComputatePageLayout.staticSearchQueryStr(siteRequest_, (String)o);
		case "pageImageUri":
			return ComputatePageLayout.staticSearchPageImageUri(siteRequest_, (String)o);
		case "pageImageWidth":
			return ComputatePageLayout.staticSearchPageImageWidth(siteRequest_, (Integer)o);
		case "pageImageHeight":
			return ComputatePageLayout.staticSearchPageImageHeight(siteRequest_, (Integer)o);
		case "pageVideoId":
			return ComputatePageLayout.staticSearchPageVideoId(siteRequest_, (String)o);
		case "classIconGroup":
			return ComputatePageLayout.staticSearchClassIconGroup(siteRequest_, (String)o);
		case "classIconName":
			return ComputatePageLayout.staticSearchClassIconName(siteRequest_, (String)o);
		case "classIconCssClasses":
			return ComputatePageLayout.staticSearchClassIconCssClasses(siteRequest_, (String)o);
		case "pageDescription":
			return ComputatePageLayout.staticSearchPageDescription(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrComputatePageLayout(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrComputatePageLayout(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "lang":
			return ComputatePageLayout.staticSearchStrLang(siteRequest_, (String)o);
		case "config":
			return ComputatePageLayout.staticSearchStrConfig(siteRequest_, (JsonObject)o);
		case "staticBaseUrl":
			return ComputatePageLayout.staticSearchStrStaticBaseUrl(siteRequest_, (String)o);
		case "siteBaseUrl":
			return ComputatePageLayout.staticSearchStrSiteBaseUrl(siteRequest_, (String)o);
		case "siteAuthUrl":
			return ComputatePageLayout.staticSearchStrSiteAuthUrl(siteRequest_, (String)o);
		case "siteAuthRealm":
			return ComputatePageLayout.staticSearchStrSiteAuthRealm(siteRequest_, (String)o);
		case "fontAwesomeKit":
			return ComputatePageLayout.staticSearchStrFontAwesomeKit(siteRequest_, (String)o);
		case "pageUri":
			return ComputatePageLayout.staticSearchStrPageUri(siteRequest_, (String)o);
		case "pageId":
			return ComputatePageLayout.staticSearchStrPageId(siteRequest_, (String)o);
		case "apiUri":
			return ComputatePageLayout.staticSearchStrApiUri(siteRequest_, (String)o);
		case "pageMethod":
			return ComputatePageLayout.staticSearchStrPageMethod(siteRequest_, (String)o);
		case "params":
			return ComputatePageLayout.staticSearchStrParams(siteRequest_, (JsonObject)o);
		case "userKey":
			return ComputatePageLayout.staticSearchStrUserKey(siteRequest_, (Long)o);
		case "userFullName":
			return ComputatePageLayout.staticSearchStrUserFullName(siteRequest_, (String)o);
		case "userName":
			return ComputatePageLayout.staticSearchStrUserName(siteRequest_, (String)o);
		case "userEmail":
			return ComputatePageLayout.staticSearchStrUserEmail(siteRequest_, (String)o);
		case "logoutUrl":
			return ComputatePageLayout.staticSearchStrLogoutUrl(siteRequest_, (String)o);
		case "long0":
			return ComputatePageLayout.staticSearchStrLong0(siteRequest_, (Long)o);
		case "long1":
			return ComputatePageLayout.staticSearchStrLong1(siteRequest_, (Long)o);
		case "int0":
			return ComputatePageLayout.staticSearchStrInt0(siteRequest_, (Integer)o);
		case "int1":
			return ComputatePageLayout.staticSearchStrInt1(siteRequest_, (Integer)o);
		case "classSimpleName":
			return ComputatePageLayout.staticSearchStrClassSimpleName(siteRequest_, (String)o);
		case "pageTitle":
			return ComputatePageLayout.staticSearchStrPageTitle(siteRequest_, (String)o);
		case "roles":
			return ComputatePageLayout.staticSearchStrRoles(siteRequest_, (String)o);
		case "roleRequired":
			return ComputatePageLayout.staticSearchStrRoleRequired(siteRequest_, (String)o);
		case "authRoleAdmin":
			return ComputatePageLayout.staticSearchStrAuthRoleAdmin(siteRequest_, (String)o);
		case "pagination":
			return ComputatePageLayout.staticSearchStrPagination(siteRequest_, (JsonObject)o);
		case "varsQ":
			return ComputatePageLayout.staticSearchStrVarsQ(siteRequest_, (JsonObject)o);
		case "varsFq":
			return ComputatePageLayout.staticSearchStrVarsFq(siteRequest_, (JsonObject)o);
		case "varsRange":
			return ComputatePageLayout.staticSearchStrVarsRange(siteRequest_, (JsonObject)o);
		case "query":
			return ComputatePageLayout.staticSearchStrQuery(siteRequest_, (JsonObject)o);
		case "queryStr":
			return ComputatePageLayout.staticSearchStrQueryStr(siteRequest_, (String)o);
		case "pageImageUri":
			return ComputatePageLayout.staticSearchStrPageImageUri(siteRequest_, (String)o);
		case "pageImageWidth":
			return ComputatePageLayout.staticSearchStrPageImageWidth(siteRequest_, (Integer)o);
		case "pageImageHeight":
			return ComputatePageLayout.staticSearchStrPageImageHeight(siteRequest_, (Integer)o);
		case "pageVideoId":
			return ComputatePageLayout.staticSearchStrPageVideoId(siteRequest_, (String)o);
		case "classIconGroup":
			return ComputatePageLayout.staticSearchStrClassIconGroup(siteRequest_, (String)o);
		case "classIconName":
			return ComputatePageLayout.staticSearchStrClassIconName(siteRequest_, (String)o);
		case "classIconCssClasses":
			return ComputatePageLayout.staticSearchStrClassIconCssClasses(siteRequest_, (String)o);
		case "pageDescription":
			return ComputatePageLayout.staticSearchStrPageDescription(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqComputatePageLayout(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqComputatePageLayout(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "lang":
			return ComputatePageLayout.staticSearchFqLang(siteRequest_, o);
		case "config":
			return ComputatePageLayout.staticSearchFqConfig(siteRequest_, o);
		case "staticBaseUrl":
			return ComputatePageLayout.staticSearchFqStaticBaseUrl(siteRequest_, o);
		case "siteBaseUrl":
			return ComputatePageLayout.staticSearchFqSiteBaseUrl(siteRequest_, o);
		case "siteAuthUrl":
			return ComputatePageLayout.staticSearchFqSiteAuthUrl(siteRequest_, o);
		case "siteAuthRealm":
			return ComputatePageLayout.staticSearchFqSiteAuthRealm(siteRequest_, o);
		case "fontAwesomeKit":
			return ComputatePageLayout.staticSearchFqFontAwesomeKit(siteRequest_, o);
		case "pageUri":
			return ComputatePageLayout.staticSearchFqPageUri(siteRequest_, o);
		case "pageId":
			return ComputatePageLayout.staticSearchFqPageId(siteRequest_, o);
		case "apiUri":
			return ComputatePageLayout.staticSearchFqApiUri(siteRequest_, o);
		case "pageMethod":
			return ComputatePageLayout.staticSearchFqPageMethod(siteRequest_, o);
		case "params":
			return ComputatePageLayout.staticSearchFqParams(siteRequest_, o);
		case "userKey":
			return ComputatePageLayout.staticSearchFqUserKey(siteRequest_, o);
		case "userFullName":
			return ComputatePageLayout.staticSearchFqUserFullName(siteRequest_, o);
		case "userName":
			return ComputatePageLayout.staticSearchFqUserName(siteRequest_, o);
		case "userEmail":
			return ComputatePageLayout.staticSearchFqUserEmail(siteRequest_, o);
		case "logoutUrl":
			return ComputatePageLayout.staticSearchFqLogoutUrl(siteRequest_, o);
		case "long0":
			return ComputatePageLayout.staticSearchFqLong0(siteRequest_, o);
		case "long1":
			return ComputatePageLayout.staticSearchFqLong1(siteRequest_, o);
		case "int0":
			return ComputatePageLayout.staticSearchFqInt0(siteRequest_, o);
		case "int1":
			return ComputatePageLayout.staticSearchFqInt1(siteRequest_, o);
		case "classSimpleName":
			return ComputatePageLayout.staticSearchFqClassSimpleName(siteRequest_, o);
		case "pageTitle":
			return ComputatePageLayout.staticSearchFqPageTitle(siteRequest_, o);
		case "roles":
			return ComputatePageLayout.staticSearchFqRoles(siteRequest_, o);
		case "roleRequired":
			return ComputatePageLayout.staticSearchFqRoleRequired(siteRequest_, o);
		case "authRoleAdmin":
			return ComputatePageLayout.staticSearchFqAuthRoleAdmin(siteRequest_, o);
		case "pagination":
			return ComputatePageLayout.staticSearchFqPagination(siteRequest_, o);
		case "varsQ":
			return ComputatePageLayout.staticSearchFqVarsQ(siteRequest_, o);
		case "varsFq":
			return ComputatePageLayout.staticSearchFqVarsFq(siteRequest_, o);
		case "varsRange":
			return ComputatePageLayout.staticSearchFqVarsRange(siteRequest_, o);
		case "query":
			return ComputatePageLayout.staticSearchFqQuery(siteRequest_, o);
		case "queryStr":
			return ComputatePageLayout.staticSearchFqQueryStr(siteRequest_, o);
		case "pageImageUri":
			return ComputatePageLayout.staticSearchFqPageImageUri(siteRequest_, o);
		case "pageImageWidth":
			return ComputatePageLayout.staticSearchFqPageImageWidth(siteRequest_, o);
		case "pageImageHeight":
			return ComputatePageLayout.staticSearchFqPageImageHeight(siteRequest_, o);
		case "pageVideoId":
			return ComputatePageLayout.staticSearchFqPageVideoId(siteRequest_, o);
		case "classIconGroup":
			return ComputatePageLayout.staticSearchFqClassIconGroup(siteRequest_, o);
		case "classIconName":
			return ComputatePageLayout.staticSearchFqClassIconName(siteRequest_, o);
		case "classIconCssClasses":
			return ComputatePageLayout.staticSearchFqClassIconCssClasses(siteRequest_, o);
		case "pageDescription":
			return ComputatePageLayout.staticSearchFqPageDescription(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "ComputatePageLayout";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_lang = "lang";
	public static final String VAR_requestVars = "requestVars";
	public static final String VAR_config = "config";
	public static final String VAR_serviceRequest = "serviceRequest";
	public static final String VAR_staticBaseUrl = "staticBaseUrl";
	public static final String VAR_siteBaseUrl = "siteBaseUrl";
	public static final String VAR_siteAuthUrl = "siteAuthUrl";
	public static final String VAR_siteAuthRealm = "siteAuthRealm";
	public static final String VAR_fontAwesomeKit = "fontAwesomeKit";
	public static final String VAR_pageUri = "pageUri";
	public static final String VAR_pageId = "pageId";
	public static final String VAR_apiUri = "apiUri";
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
	public static final String VAR_roleRequired = "roleRequired";
	public static final String VAR_authRoleAdmin = "authRoleAdmin";
	public static final String VAR_pagination = "pagination";
	public static final String VAR_varsQ = "varsQ";
	public static final String VAR_varsFq = "varsFq";
	public static final String VAR_varsRange = "varsRange";
	public static final String VAR_query = "query";
	public static final String VAR_queryStr = "queryStr";
	public static final String VAR_promiseAfter = "promiseAfter";
	public static final String VAR_pageImageUri = "pageImageUri";
	public static final String VAR_pageImageWidth = "pageImageWidth";
	public static final String VAR_pageImageHeight = "pageImageHeight";
	public static final String VAR_pageVideoId = "pageVideoId";
	public static final String VAR_classIconGroup = "classIconGroup";
	public static final String VAR_classIconName = "classIconName";
	public static final String VAR_classIconCssClasses = "classIconCssClasses";
	public static final String VAR_pageDescription = "pageDescription";

	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_lang = "";
	public static final String DISPLAY_NAME_requestVars = "";
	public static final String DISPLAY_NAME_config = "";
	public static final String DISPLAY_NAME_serviceRequest = "";
	public static final String DISPLAY_NAME_staticBaseUrl = "";
	public static final String DISPLAY_NAME_siteBaseUrl = "";
	public static final String DISPLAY_NAME_siteAuthUrl = "";
	public static final String DISPLAY_NAME_siteAuthRealm = "";
	public static final String DISPLAY_NAME_fontAwesomeKit = "";
	public static final String DISPLAY_NAME_pageUri = "";
	public static final String DISPLAY_NAME_pageId = "";
	public static final String DISPLAY_NAME_apiUri = "";
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
	public static final String DISPLAY_NAME_roleRequired = "";
	public static final String DISPLAY_NAME_authRoleAdmin = "";
	public static final String DISPLAY_NAME_pagination = "";
	public static final String DISPLAY_NAME_varsQ = "";
	public static final String DISPLAY_NAME_varsFq = "";
	public static final String DISPLAY_NAME_varsRange = "";
	public static final String DISPLAY_NAME_query = "";
	public static final String DISPLAY_NAME_queryStr = "";
	public static final String DISPLAY_NAME_promiseAfter = "";
	public static final String DISPLAY_NAME_pageImageUri = "";
	public static final String DISPLAY_NAME_pageImageWidth = "";
	public static final String DISPLAY_NAME_pageImageHeight = "";
	public static final String DISPLAY_NAME_pageVideoId = "";
	public static final String DISPLAY_NAME_classIconGroup = "";
	public static final String DISPLAY_NAME_classIconName = "";
	public static final String DISPLAY_NAME_classIconCssClasses = "";
	public static final String DISPLAY_NAME_pageDescription = "";

	public static String displayNameForClass(String var) {
		return ComputatePageLayout.displayNameComputatePageLayout(var);
	}
	public static String displayNameComputatePageLayout(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_lang:
			return DISPLAY_NAME_lang;
		case VAR_requestVars:
			return DISPLAY_NAME_requestVars;
		case VAR_config:
			return DISPLAY_NAME_config;
		case VAR_serviceRequest:
			return DISPLAY_NAME_serviceRequest;
		case VAR_staticBaseUrl:
			return DISPLAY_NAME_staticBaseUrl;
		case VAR_siteBaseUrl:
			return DISPLAY_NAME_siteBaseUrl;
		case VAR_siteAuthUrl:
			return DISPLAY_NAME_siteAuthUrl;
		case VAR_siteAuthRealm:
			return DISPLAY_NAME_siteAuthRealm;
		case VAR_fontAwesomeKit:
			return DISPLAY_NAME_fontAwesomeKit;
		case VAR_pageUri:
			return DISPLAY_NAME_pageUri;
		case VAR_pageId:
			return DISPLAY_NAME_pageId;
		case VAR_apiUri:
			return DISPLAY_NAME_apiUri;
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
		case VAR_roleRequired:
			return DISPLAY_NAME_roleRequired;
		case VAR_authRoleAdmin:
			return DISPLAY_NAME_authRoleAdmin;
		case VAR_pagination:
			return DISPLAY_NAME_pagination;
		case VAR_varsQ:
			return DISPLAY_NAME_varsQ;
		case VAR_varsFq:
			return DISPLAY_NAME_varsFq;
		case VAR_varsRange:
			return DISPLAY_NAME_varsRange;
		case VAR_query:
			return DISPLAY_NAME_query;
		case VAR_queryStr:
			return DISPLAY_NAME_queryStr;
		case VAR_promiseAfter:
			return DISPLAY_NAME_promiseAfter;
		case VAR_pageImageUri:
			return DISPLAY_NAME_pageImageUri;
		case VAR_pageImageWidth:
			return DISPLAY_NAME_pageImageWidth;
		case VAR_pageImageHeight:
			return DISPLAY_NAME_pageImageHeight;
		case VAR_pageVideoId:
			return DISPLAY_NAME_pageVideoId;
		case VAR_classIconGroup:
			return DISPLAY_NAME_classIconGroup;
		case VAR_classIconName:
			return DISPLAY_NAME_classIconName;
		case VAR_classIconCssClasses:
			return DISPLAY_NAME_classIconCssClasses;
		case VAR_pageDescription:
			return DISPLAY_NAME_pageDescription;
		default:
			return null;
		}
	}
}
