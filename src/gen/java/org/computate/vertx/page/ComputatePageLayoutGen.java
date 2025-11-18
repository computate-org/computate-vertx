package org.computate.vertx.page;

import org.computate.vertx.request.ComputateSiteRequest;
import java.lang.Object;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateConfigKeys;
import java.util.Optional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import java.lang.String;
import io.vertx.core.json.JsonObject;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import io.vertx.ext.web.api.service.ServiceRequest;
import java.lang.Long;
import java.lang.Void;
import io.vertx.core.json.JsonArray;
import org.computate.search.response.solr.SolrResponse.Stats;
import org.computate.search.response.solr.SolrResponse.FacetCounts;
import java.time.ZoneId;
import java.util.Locale;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.lang.Integer;
import java.math.BigDecimal;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ComputatePageLayout objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ComputatePageLayoutGen into the class ComputatePageLayout. 
 * </li>
 * <h3>About the ComputatePageLayout class and it's generated class ComputatePageLayoutGen&lt;Object&gt;: </h3>extends ComputatePageLayoutGen
 * <p>
 * This Java class extends a generated Java class ComputatePageLayoutGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout">Find the class ComputatePageLayout in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ComputatePageLayoutGen<Object>
 * <p>This <code>class ComputatePageLayout extends ComputatePageLayoutGen&lt;Object&gt;</code>, which means it extends a newly generated ComputatePageLayoutGen. 
 * The generated <code>class ComputatePageLayoutGen extends Object</code> which means that ComputatePageLayout extends ComputatePageLayoutGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the ComputatePageLayout class will inherit the helpful inherited class comments from the super class ComputatePageLayoutGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
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
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class ComputatePageLayout in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.page in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.page&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class ComputatePageLayoutGen<DEV> extends Object {
  protected static final Logger LOG = LoggerFactory.getLogger(ComputatePageLayout.class);

	//////////////////
  // siteRequest_ //
	//////////////////


  /**
   *  The entity siteRequest_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected ComputateSiteRequest siteRequest_;

  /**
   * <br> The entity siteRequest_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
      Optional.ofNullable(siteRequest_Wrap.getO()).ifPresent(o -> {
        setSiteRequest_(o);
      });
    }
    return (ComputatePageLayout)this;
  }

	//////////
  // lang //
	//////////


  /**
   *  The entity lang
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String lang;

  /**
   * <br> The entity lang
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:lang">Find the entity lang in Solr</a>
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
      Optional.ofNullable(langWrap.getO()).ifPresent(o -> {
        setLang(o);
      });
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
    return ComputatePageLayout.staticSearchLang(siteRequest_, ComputatePageLayout.staticSetLang(siteRequest_, o)).toString();
  }

	/////////////////
  // requestVars //
	/////////////////


  /**
   *  The entity requestVars
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Map<String, String> requestVars;

  /**
   * <br> The entity requestVars
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:requestVars">Find the entity requestVars in Solr</a>
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
      Optional.ofNullable(requestVarsWrap.getO()).ifPresent(o -> {
        setRequestVars(o);
      });
    }
    return (ComputatePageLayout)this;
  }

	////////////
  // config //
	////////////


  /**
   *  The entity config
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected JsonObject config;

  /**
   * <br> The entity config
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:config">Find the entity config in Solr</a>
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
      Optional.ofNullable(configWrap.getO()).ifPresent(o -> {
        setConfig(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchConfig(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrConfig(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqConfig(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchConfig(siteRequest_, ComputatePageLayout.staticSetConfig(siteRequest_, o)).toString();
  }

	////////////////////
  // serviceRequest //
	////////////////////


  /**
   *  The entity serviceRequest
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected ServiceRequest serviceRequest;

  /**
   * <br> The entity serviceRequest
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:serviceRequest">Find the entity serviceRequest in Solr</a>
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
      Optional.ofNullable(serviceRequestWrap.getO()).ifPresent(o -> {
        setServiceRequest(o);
      });
    }
    return (ComputatePageLayout)this;
  }

	///////////////////
  // staticBaseUrl //
	///////////////////


  /**
   *  The entity staticBaseUrl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String staticBaseUrl;

  /**
   * <br> The entity staticBaseUrl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:staticBaseUrl">Find the entity staticBaseUrl in Solr</a>
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
      Optional.ofNullable(staticBaseUrlWrap.getO()).ifPresent(o -> {
        setStaticBaseUrl(o);
      });
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
    return ComputatePageLayout.staticSearchStaticBaseUrl(siteRequest_, ComputatePageLayout.staticSetStaticBaseUrl(siteRequest_, o)).toString();
  }

	/////////////////
  // siteBaseUrl //
	/////////////////


  /**
   *  The entity siteBaseUrl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String siteBaseUrl;

  /**
   * <br> The entity siteBaseUrl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:siteBaseUrl">Find the entity siteBaseUrl in Solr</a>
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
      Optional.ofNullable(siteBaseUrlWrap.getO()).ifPresent(o -> {
        setSiteBaseUrl(o);
      });
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
    return ComputatePageLayout.staticSearchSiteBaseUrl(siteRequest_, ComputatePageLayout.staticSetSiteBaseUrl(siteRequest_, o)).toString();
  }

	/////////////////
  // siteAuthUrl //
	/////////////////


  /**
   *  The entity siteAuthUrl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String siteAuthUrl;

  /**
   * <br> The entity siteAuthUrl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:siteAuthUrl">Find the entity siteAuthUrl in Solr</a>
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
      Optional.ofNullable(siteAuthUrlWrap.getO()).ifPresent(o -> {
        setSiteAuthUrl(o);
      });
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
    return ComputatePageLayout.staticSearchSiteAuthUrl(siteRequest_, ComputatePageLayout.staticSetSiteAuthUrl(siteRequest_, o)).toString();
  }

	///////////////////
  // siteAuthRealm //
	///////////////////


  /**
   *  The entity siteAuthRealm
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String siteAuthRealm;

  /**
   * <br> The entity siteAuthRealm
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:siteAuthRealm">Find the entity siteAuthRealm in Solr</a>
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
      Optional.ofNullable(siteAuthRealmWrap.getO()).ifPresent(o -> {
        setSiteAuthRealm(o);
      });
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
    return ComputatePageLayout.staticSearchSiteAuthRealm(siteRequest_, ComputatePageLayout.staticSetSiteAuthRealm(siteRequest_, o)).toString();
  }

	////////////////////
  // fontAwesomeKit //
	////////////////////


  /**
   *  The entity fontAwesomeKit
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String fontAwesomeKit;

  /**
   * <br> The entity fontAwesomeKit
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:fontAwesomeKit">Find the entity fontAwesomeKit in Solr</a>
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
      Optional.ofNullable(fontAwesomeKitWrap.getO()).ifPresent(o -> {
        setFontAwesomeKit(o);
      });
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
    return ComputatePageLayout.staticSearchFontAwesomeKit(siteRequest_, ComputatePageLayout.staticSetFontAwesomeKit(siteRequest_, o)).toString();
  }

	//////////////////////////
  // facebookGraphVersion //
	//////////////////////////


  /**
   *  The entity facebookGraphVersion
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String facebookGraphVersion;

  /**
   * <br> The entity facebookGraphVersion
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:facebookGraphVersion">Find the entity facebookGraphVersion in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _facebookGraphVersion(Wrap<String> w);

  public String getFacebookGraphVersion() {
    return facebookGraphVersion;
  }
  public void setFacebookGraphVersion(String o) {
    this.facebookGraphVersion = ComputatePageLayout.staticSetFacebookGraphVersion(siteRequest_, o);
  }
  public static String staticSetFacebookGraphVersion(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout facebookGraphVersionInit() {
    Wrap<String> facebookGraphVersionWrap = new Wrap<String>().var("facebookGraphVersion");
    if(facebookGraphVersion == null) {
      _facebookGraphVersion(facebookGraphVersionWrap);
      Optional.ofNullable(facebookGraphVersionWrap.getO()).ifPresent(o -> {
        setFacebookGraphVersion(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchFacebookGraphVersion(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrFacebookGraphVersion(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqFacebookGraphVersion(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchFacebookGraphVersion(siteRequest_, ComputatePageLayout.staticSetFacebookGraphVersion(siteRequest_, o)).toString();
  }

	///////////////////
  // facebookAppId //
	///////////////////


  /**
   *  The entity facebookAppId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String facebookAppId;

  /**
   * <br> The entity facebookAppId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:facebookAppId">Find the entity facebookAppId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _facebookAppId(Wrap<String> w);

  public String getFacebookAppId() {
    return facebookAppId;
  }
  public void setFacebookAppId(String o) {
    this.facebookAppId = ComputatePageLayout.staticSetFacebookAppId(siteRequest_, o);
  }
  public static String staticSetFacebookAppId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout facebookAppIdInit() {
    Wrap<String> facebookAppIdWrap = new Wrap<String>().var("facebookAppId");
    if(facebookAppId == null) {
      _facebookAppId(facebookAppIdWrap);
      Optional.ofNullable(facebookAppIdWrap.getO()).ifPresent(o -> {
        setFacebookAppId(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchFacebookAppId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrFacebookAppId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqFacebookAppId(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchFacebookAppId(siteRequest_, ComputatePageLayout.staticSetFacebookAppId(siteRequest_, o)).toString();
  }

	/////////////
  // pageUri //
	/////////////


  /**
   *  The entity pageUri
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUri;

  /**
   * <br> The entity pageUri
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
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
      Optional.ofNullable(pageUriWrap.getO()).ifPresent(o -> {
        setPageUri(o);
      });
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
    return ComputatePageLayout.staticSearchPageUri(siteRequest_, ComputatePageLayout.staticSetPageUri(siteRequest_, o)).toString();
  }

	////////////
  // pageId //
	////////////


  /**
   *  The entity pageId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageId;

  /**
   * <br> The entity pageId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageId">Find the entity pageId in Solr</a>
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
      Optional.ofNullable(pageIdWrap.getO()).ifPresent(o -> {
        setPageId(o);
      });
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
    return ComputatePageLayout.staticSearchPageId(siteRequest_, ComputatePageLayout.staticSetPageId(siteRequest_, o)).toString();
  }

	////////////
  // apiUri //
	////////////


  /**
   *  The entity apiUri
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String apiUri;

  /**
   * <br> The entity apiUri
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:apiUri">Find the entity apiUri in Solr</a>
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
      Optional.ofNullable(apiUriWrap.getO()).ifPresent(o -> {
        setApiUri(o);
      });
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
    return ComputatePageLayout.staticSearchApiUri(siteRequest_, ComputatePageLayout.staticSetApiUri(siteRequest_, o)).toString();
  }

	////////////////
  // pageMethod //
	////////////////


  /**
   *  The entity pageMethod
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageMethod;

  /**
   * <br> The entity pageMethod
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageMethod">Find the entity pageMethod in Solr</a>
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
      Optional.ofNullable(pageMethodWrap.getO()).ifPresent(o -> {
        setPageMethod(o);
      });
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
    return ComputatePageLayout.staticSearchPageMethod(siteRequest_, ComputatePageLayout.staticSetPageMethod(siteRequest_, o)).toString();
  }

	////////////
  // params //
	////////////


  /**
   *  The entity params
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject params;

  /**
   * <br> The entity params
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:params">Find the entity params in Solr</a>
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
      Optional.ofNullable(paramsWrap.getO()).ifPresent(o -> {
        setParams(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchParams(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrParams(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqParams(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchParams(siteRequest_, ComputatePageLayout.staticSetParams(siteRequest_, o)).toString();
  }

	/////////////
  // userKey //
	/////////////


  /**
   *  The entity userKey
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long userKey;

  /**
   * <br> The entity userKey
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:userKey">Find the entity userKey in Solr</a>
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
      Optional.ofNullable(userKeyWrap.getO()).ifPresent(o -> {
        setUserKey(o);
      });
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
    return ComputatePageLayout.staticSearchUserKey(siteRequest_, ComputatePageLayout.staticSetUserKey(siteRequest_, o)).toString();
  }

	//////////////////
  // userFullName //
	//////////////////


  /**
   *  The entity userFullName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String userFullName;

  /**
   * <br> The entity userFullName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:userFullName">Find the entity userFullName in Solr</a>
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
      Optional.ofNullable(userFullNameWrap.getO()).ifPresent(o -> {
        setUserFullName(o);
      });
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
    return ComputatePageLayout.staticSearchUserFullName(siteRequest_, ComputatePageLayout.staticSetUserFullName(siteRequest_, o)).toString();
  }

	//////////////
  // userName //
	//////////////


  /**
   *  The entity userName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String userName;

  /**
   * <br> The entity userName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:userName">Find the entity userName in Solr</a>
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
      Optional.ofNullable(userNameWrap.getO()).ifPresent(o -> {
        setUserName(o);
      });
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
    return ComputatePageLayout.staticSearchUserName(siteRequest_, ComputatePageLayout.staticSetUserName(siteRequest_, o)).toString();
  }

	///////////////
  // userEmail //
	///////////////


  /**
   *  The entity userEmail
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String userEmail;

  /**
   * <br> The entity userEmail
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:userEmail">Find the entity userEmail in Solr</a>
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
      Optional.ofNullable(userEmailWrap.getO()).ifPresent(o -> {
        setUserEmail(o);
      });
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
    return ComputatePageLayout.staticSearchUserEmail(siteRequest_, ComputatePageLayout.staticSetUserEmail(siteRequest_, o)).toString();
  }

	///////////////
  // logoutUrl //
	///////////////


  /**
   *  The entity logoutUrl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String logoutUrl;

  /**
   * <br> The entity logoutUrl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:logoutUrl">Find the entity logoutUrl in Solr</a>
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
      Optional.ofNullable(logoutUrlWrap.getO()).ifPresent(o -> {
        setLogoutUrl(o);
      });
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
    return ComputatePageLayout.staticSearchLogoutUrl(siteRequest_, ComputatePageLayout.staticSetLogoutUrl(siteRequest_, o)).toString();
  }

	///////////////////
  // promiseBefore //
	///////////////////


  /**
   *  The entity promiseBefore
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected Void promiseBefore;

  /**
   * <br> The entity promiseBefore
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
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


  /**
   *  The entity classSimpleName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classSimpleName;

  /**
   * <br> The entity classSimpleName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
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
      Optional.ofNullable(classSimpleNameWrap.getO()).ifPresent(o -> {
        setClassSimpleName(o);
      });
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
    return ComputatePageLayout.staticSearchClassSimpleName(siteRequest_, ComputatePageLayout.staticSetClassSimpleName(siteRequest_, o)).toString();
  }

	///////////////
  // pageTitle //
	///////////////


  /**
   *  The entity pageTitle
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageTitle;

  /**
   * <br> The entity pageTitle
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
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
      Optional.ofNullable(pageTitleWrap.getO()).ifPresent(o -> {
        setPageTitle(o);
      });
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
    return ComputatePageLayout.staticSearchPageTitle(siteRequest_, ComputatePageLayout.staticSetPageTitle(siteRequest_, o)).toString();
  }

	////////////
  // scopes //
	////////////


  /**
   *  The entity scopes
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> scopes = new ArrayList<String>();

  /**
   * <br> The entity scopes
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:scopes">Find the entity scopes in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _scopes(List<String> l);

  public List<String> getScopes() {
    return scopes;
  }

  public void setScopes(List<String> scopes) {
    this.scopes = scopes;
  }
  @JsonIgnore
  public void setScopes(String o) {
    String l = ComputatePageLayout.staticSetScopes(siteRequest_, o);
    if(l != null)
      addScopes(l);
  }
  public static String staticSetScopes(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputatePageLayout addScopes(String...objects) {
    for(String o : objects) {
      addScopes(o);
    }
    return (ComputatePageLayout)this;
  }
  public ComputatePageLayout addScopes(String o) {
    if(o != null)
      this.scopes.add(o);
    return (ComputatePageLayout)this;
  }
  @JsonIgnore
  public void setScopes(JsonArray objects) {
    scopes.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addScopes(o);
    }
  }
  protected ComputatePageLayout scopesInit() {
    _scopes(scopes);
    return (ComputatePageLayout)this;
  }

  public static String staticSearchScopes(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrScopes(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqScopes(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchScopes(siteRequest_, ComputatePageLayout.staticSetScopes(siteRequest_, o)).toString();
  }

	//////////////////
  // roleRequired //
	//////////////////


  /**
   *  The entity roleRequired
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> roleRequired = new ArrayList<String>();

  /**
   * <br> The entity roleRequired
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:roleRequired">Find the entity roleRequired in Solr</a>
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
  @JsonIgnore
  public void setRoleRequired(String o) {
    String l = ComputatePageLayout.staticSetRoleRequired(siteRequest_, o);
    if(l != null)
      addRoleRequired(l);
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
    if(objects == null)
      return;
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
    return ComputatePageLayout.staticSearchRoleRequired(siteRequest_, ComputatePageLayout.staticSetRoleRequired(siteRequest_, o)).toString();
  }

	///////////////////
  // authRoleAdmin //
	///////////////////


  /**
   *  The entity authRoleAdmin
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> authRoleAdmin = new ArrayList<String>();

  /**
   * <br> The entity authRoleAdmin
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:authRoleAdmin">Find the entity authRoleAdmin in Solr</a>
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
  @JsonIgnore
  public void setAuthRoleAdmin(String o) {
    String l = ComputatePageLayout.staticSetAuthRoleAdmin(siteRequest_, o);
    if(l != null)
      addAuthRoleAdmin(l);
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
    if(objects == null)
      return;
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
    return ComputatePageLayout.staticSearchAuthRoleAdmin(siteRequest_, ComputatePageLayout.staticSetAuthRoleAdmin(siteRequest_, o)).toString();
  }

	////////////////////////
  // authRoleSuperAdmin //
	////////////////////////


  /**
   *  The entity authRoleSuperAdmin
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> authRoleSuperAdmin = new ArrayList<String>();

  /**
   * <br> The entity authRoleSuperAdmin
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:authRoleSuperAdmin">Find the entity authRoleSuperAdmin in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _authRoleSuperAdmin(List<String> l);

  public List<String> getAuthRoleSuperAdmin() {
    return authRoleSuperAdmin;
  }

  public void setAuthRoleSuperAdmin(List<String> authRoleSuperAdmin) {
    this.authRoleSuperAdmin = authRoleSuperAdmin;
  }
  @JsonIgnore
  public void setAuthRoleSuperAdmin(String o) {
    String l = ComputatePageLayout.staticSetAuthRoleSuperAdmin(siteRequest_, o);
    if(l != null)
      addAuthRoleSuperAdmin(l);
  }
  public static String staticSetAuthRoleSuperAdmin(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputatePageLayout addAuthRoleSuperAdmin(String...objects) {
    for(String o : objects) {
      addAuthRoleSuperAdmin(o);
    }
    return (ComputatePageLayout)this;
  }
  public ComputatePageLayout addAuthRoleSuperAdmin(String o) {
    if(o != null)
      this.authRoleSuperAdmin.add(o);
    return (ComputatePageLayout)this;
  }
  @JsonIgnore
  public void setAuthRoleSuperAdmin(JsonArray objects) {
    authRoleSuperAdmin.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addAuthRoleSuperAdmin(o);
    }
  }
  protected ComputatePageLayout authRoleSuperAdminInit() {
    _authRoleSuperAdmin(authRoleSuperAdmin);
    return (ComputatePageLayout)this;
  }

  public static String staticSearchAuthRoleSuperAdmin(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrAuthRoleSuperAdmin(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqAuthRoleSuperAdmin(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchAuthRoleSuperAdmin(siteRequest_, ComputatePageLayout.staticSetAuthRoleSuperAdmin(siteRequest_, o)).toString();
  }

	///////////
  // stats //
	///////////


  /**
   *  The entity stats
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Stats stats;

  /**
   * <br> The entity stats
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:stats">Find the entity stats in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _stats(Wrap<Stats> w);

  public Stats getStats() {
    return stats;
  }

  public void setStats(Stats stats) {
    this.stats = stats;
  }
  public static Stats staticSetStats(ComputateSiteRequest siteRequest_, String o) {
    return null;
  }
  protected ComputatePageLayout statsInit() {
    Wrap<Stats> statsWrap = new Wrap<Stats>().var("stats");
    if(stats == null) {
      _stats(statsWrap);
      Optional.ofNullable(statsWrap.getO()).ifPresent(o -> {
        setStats(o);
      });
    }
    return (ComputatePageLayout)this;
  }

	/////////////////
  // facetCounts //
	/////////////////


  /**
   *  The entity facetCounts
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected FacetCounts facetCounts;

  /**
   * <br> The entity facetCounts
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:facetCounts">Find the entity facetCounts in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _facetCounts(Wrap<FacetCounts> w);

  public FacetCounts getFacetCounts() {
    return facetCounts;
  }

  public void setFacetCounts(FacetCounts facetCounts) {
    this.facetCounts = facetCounts;
  }
  public static FacetCounts staticSetFacetCounts(ComputateSiteRequest siteRequest_, String o) {
    return null;
  }
  protected ComputatePageLayout facetCountsInit() {
    Wrap<FacetCounts> facetCountsWrap = new Wrap<FacetCounts>().var("facetCounts");
    if(facetCounts == null) {
      _facetCounts(facetCountsWrap);
      Optional.ofNullable(facetCountsWrap.getO()).ifPresent(o -> {
        setFacetCounts(o);
      });
    }
    return (ComputatePageLayout)this;
  }

	////////////////
  // pagination //
	////////////////


  /**
   *  The entity pagination
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject pagination = new JsonObject();

  /**
   * <br> The entity pagination
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pagination">Find the entity pagination in Solr</a>
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

  public static String staticSearchPagination(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrPagination(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPagination(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchPagination(siteRequest_, ComputatePageLayout.staticSetPagination(siteRequest_, o)).toString();
  }

	/////////////////////
  // defaultSortVars //
	/////////////////////


  /**
   *  The entity defaultSortVars
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> defaultSortVars = new ArrayList<String>();

  /**
   * <br> The entity defaultSortVars
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultSortVars">Find the entity defaultSortVars in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _defaultSortVars(List<String> l);

  public List<String> getDefaultSortVars() {
    return defaultSortVars;
  }

  public void setDefaultSortVars(List<String> defaultSortVars) {
    this.defaultSortVars = defaultSortVars;
  }
  @JsonIgnore
  public void setDefaultSortVars(String o) {
    String l = ComputatePageLayout.staticSetDefaultSortVars(siteRequest_, o);
    if(l != null)
      addDefaultSortVars(l);
  }
  public static String staticSetDefaultSortVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputatePageLayout addDefaultSortVars(String...objects) {
    for(String o : objects) {
      addDefaultSortVars(o);
    }
    return (ComputatePageLayout)this;
  }
  public ComputatePageLayout addDefaultSortVars(String o) {
    if(o != null)
      this.defaultSortVars.add(o);
    return (ComputatePageLayout)this;
  }
  @JsonIgnore
  public void setDefaultSortVars(JsonArray objects) {
    defaultSortVars.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addDefaultSortVars(o);
    }
  }
  protected ComputatePageLayout defaultSortVarsInit() {
    _defaultSortVars(defaultSortVars);
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultSortVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultSortVars(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultSortVars(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultSortVars(siteRequest_, ComputatePageLayout.staticSetDefaultSortVars(siteRequest_, o)).toString();
  }

	//////////////////////////
  // defaultFieldListVars //
	//////////////////////////


  /**
   *  The entity defaultFieldListVars
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> defaultFieldListVars = new ArrayList<String>();

  /**
   * <br> The entity defaultFieldListVars
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultFieldListVars">Find the entity defaultFieldListVars in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _defaultFieldListVars(List<String> l);

  public List<String> getDefaultFieldListVars() {
    return defaultFieldListVars;
  }

  public void setDefaultFieldListVars(List<String> defaultFieldListVars) {
    this.defaultFieldListVars = defaultFieldListVars;
  }
  @JsonIgnore
  public void setDefaultFieldListVars(String o) {
    String l = ComputatePageLayout.staticSetDefaultFieldListVars(siteRequest_, o);
    if(l != null)
      addDefaultFieldListVars(l);
  }
  public static String staticSetDefaultFieldListVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputatePageLayout addDefaultFieldListVars(String...objects) {
    for(String o : objects) {
      addDefaultFieldListVars(o);
    }
    return (ComputatePageLayout)this;
  }
  public ComputatePageLayout addDefaultFieldListVars(String o) {
    if(o != null)
      this.defaultFieldListVars.add(o);
    return (ComputatePageLayout)this;
  }
  @JsonIgnore
  public void setDefaultFieldListVars(JsonArray objects) {
    defaultFieldListVars.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addDefaultFieldListVars(o);
    }
  }
  protected ComputatePageLayout defaultFieldListVarsInit() {
    _defaultFieldListVars(defaultFieldListVars);
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultFieldListVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultFieldListVars(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultFieldListVars(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultFieldListVars(siteRequest_, ComputatePageLayout.staticSetDefaultFieldListVars(siteRequest_, o)).toString();
  }

	//////////////////////
  // defaultStatsVars //
	//////////////////////


  /**
   *  The entity defaultStatsVars
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> defaultStatsVars = new ArrayList<String>();

  /**
   * <br> The entity defaultStatsVars
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultStatsVars">Find the entity defaultStatsVars in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _defaultStatsVars(List<String> l);

  public List<String> getDefaultStatsVars() {
    return defaultStatsVars;
  }

  public void setDefaultStatsVars(List<String> defaultStatsVars) {
    this.defaultStatsVars = defaultStatsVars;
  }
  @JsonIgnore
  public void setDefaultStatsVars(String o) {
    String l = ComputatePageLayout.staticSetDefaultStatsVars(siteRequest_, o);
    if(l != null)
      addDefaultStatsVars(l);
  }
  public static String staticSetDefaultStatsVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputatePageLayout addDefaultStatsVars(String...objects) {
    for(String o : objects) {
      addDefaultStatsVars(o);
    }
    return (ComputatePageLayout)this;
  }
  public ComputatePageLayout addDefaultStatsVars(String o) {
    if(o != null)
      this.defaultStatsVars.add(o);
    return (ComputatePageLayout)this;
  }
  @JsonIgnore
  public void setDefaultStatsVars(JsonArray objects) {
    defaultStatsVars.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addDefaultStatsVars(o);
    }
  }
  protected ComputatePageLayout defaultStatsVarsInit() {
    _defaultStatsVars(defaultStatsVars);
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultStatsVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultStatsVars(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultStatsVars(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultStatsVars(siteRequest_, ComputatePageLayout.staticSetDefaultStatsVars(siteRequest_, o)).toString();
  }

	//////////////////////
  // defaultPivotVars //
	//////////////////////


  /**
   *  The entity defaultPivotVars
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> defaultPivotVars = new ArrayList<String>();

  /**
   * <br> The entity defaultPivotVars
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultPivotVars">Find the entity defaultPivotVars in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _defaultPivotVars(List<String> l);

  public List<String> getDefaultPivotVars() {
    return defaultPivotVars;
  }

  public void setDefaultPivotVars(List<String> defaultPivotVars) {
    this.defaultPivotVars = defaultPivotVars;
  }
  @JsonIgnore
  public void setDefaultPivotVars(String o) {
    String l = ComputatePageLayout.staticSetDefaultPivotVars(siteRequest_, o);
    if(l != null)
      addDefaultPivotVars(l);
  }
  public static String staticSetDefaultPivotVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputatePageLayout addDefaultPivotVars(String...objects) {
    for(String o : objects) {
      addDefaultPivotVars(o);
    }
    return (ComputatePageLayout)this;
  }
  public ComputatePageLayout addDefaultPivotVars(String o) {
    if(o != null)
      this.defaultPivotVars.add(o);
    return (ComputatePageLayout)this;
  }
  @JsonIgnore
  public void setDefaultPivotVars(JsonArray objects) {
    defaultPivotVars.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addDefaultPivotVars(o);
    }
  }
  protected ComputatePageLayout defaultPivotVarsInit() {
    _defaultPivotVars(defaultPivotVars);
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultPivotVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultPivotVars(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultPivotVars(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultPivotVars(siteRequest_, ComputatePageLayout.staticSetDefaultPivotVars(siteRequest_, o)).toString();
  }

	///////////
  // varsQ //
	///////////


  /**
   *  The entity varsQ
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject varsQ = new JsonObject();

  /**
   * <br> The entity varsQ
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:varsQ">Find the entity varsQ in Solr</a>
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

  public static String staticSearchVarsQ(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrVarsQ(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVarsQ(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchVarsQ(siteRequest_, ComputatePageLayout.staticSetVarsQ(siteRequest_, o)).toString();
  }

	////////////
  // varsFq //
	////////////


  /**
   *  The entity varsFq
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject varsFq = new JsonObject();

  /**
   * <br> The entity varsFq
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:varsFq">Find the entity varsFq in Solr</a>
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

  public static String staticSearchVarsFq(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrVarsFq(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVarsFq(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchVarsFq(siteRequest_, ComputatePageLayout.staticSetVarsFq(siteRequest_, o)).toString();
  }

	///////////////
  // varsRange //
	///////////////


  /**
   *  The entity varsRange
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject varsRange = new JsonObject();

  /**
   * <br> The entity varsRange
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:varsRange">Find the entity varsRange in Solr</a>
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

  public static String staticSearchVarsRange(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrVarsRange(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVarsRange(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchVarsRange(siteRequest_, ComputatePageLayout.staticSetVarsRange(siteRequest_, o)).toString();
  }

	///////////
  // query //
	///////////


  /**
   *  The entity query
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject query = new JsonObject();

  /**
   * <br> The entity query
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:query">Find the entity query in Solr</a>
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

  public static String staticSearchQuery(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrQuery(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqQuery(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchQuery(siteRequest_, ComputatePageLayout.staticSetQuery(siteRequest_, o)).toString();
  }

	//////////////////
  // pageResponse //
	//////////////////


  /**
   *  The entity pageResponse
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageResponse;

  /**
   * <br> The entity pageResponse
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageResponse">Find the entity pageResponse in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageResponse(Wrap<String> w);

  public String getPageResponse() {
    return pageResponse;
  }
  public void setPageResponse(String o) {
    this.pageResponse = ComputatePageLayout.staticSetPageResponse(siteRequest_, o);
  }
  public static String staticSetPageResponse(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout pageResponseInit() {
    Wrap<String> pageResponseWrap = new Wrap<String>().var("pageResponse");
    if(pageResponse == null) {
      _pageResponse(pageResponseWrap);
      Optional.ofNullable(pageResponseWrap.getO()).ifPresent(o -> {
        setPageResponse(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchPageResponse(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageResponse(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageResponse(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchPageResponse(siteRequest_, ComputatePageLayout.staticSetPageResponse(siteRequest_, o)).toString();
  }

	///////////////////
  // defaultZoneId //
	///////////////////


  /**
   *  The entity defaultZoneId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String defaultZoneId;

  /**
   * <br> The entity defaultZoneId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultZoneId">Find the entity defaultZoneId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultZoneId(Wrap<String> w);

  public String getDefaultZoneId() {
    return defaultZoneId;
  }
  public void setDefaultZoneId(String o) {
    this.defaultZoneId = ComputatePageLayout.staticSetDefaultZoneId(siteRequest_, o);
  }
  public static String staticSetDefaultZoneId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout defaultZoneIdInit() {
    Wrap<String> defaultZoneIdWrap = new Wrap<String>().var("defaultZoneId");
    if(defaultZoneId == null) {
      _defaultZoneId(defaultZoneIdWrap);
      Optional.ofNullable(defaultZoneIdWrap.getO()).ifPresent(o -> {
        setDefaultZoneId(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultZoneId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultZoneId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultZoneId(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultZoneId(siteRequest_, ComputatePageLayout.staticSetDefaultZoneId(siteRequest_, o)).toString();
  }

	/////////////////////
  // defaultTimeZone //
	/////////////////////


  /**
   *  The entity defaultTimeZone
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected ZoneId defaultTimeZone;

  /**
   * <br> The entity defaultTimeZone
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultTimeZone">Find the entity defaultTimeZone in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultTimeZone(Wrap<ZoneId> w);

  public ZoneId getDefaultTimeZone() {
    return defaultTimeZone;
  }

  public void setDefaultTimeZone(ZoneId defaultTimeZone) {
    this.defaultTimeZone = defaultTimeZone;
  }
  public static ZoneId staticSetDefaultTimeZone(ComputateSiteRequest siteRequest_, String o) {
    return null;
  }
  protected ComputatePageLayout defaultTimeZoneInit() {
    Wrap<ZoneId> defaultTimeZoneWrap = new Wrap<ZoneId>().var("defaultTimeZone");
    if(defaultTimeZone == null) {
      _defaultTimeZone(defaultTimeZoneWrap);
      Optional.ofNullable(defaultTimeZoneWrap.getO()).ifPresent(o -> {
        setDefaultTimeZone(o);
      });
    }
    return (ComputatePageLayout)this;
  }

	/////////////////////
  // defaultLocaleId //
	/////////////////////


  /**
   *  The entity defaultLocaleId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String defaultLocaleId;

  /**
   * <br> The entity defaultLocaleId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultLocaleId">Find the entity defaultLocaleId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultLocaleId(Wrap<String> w);

  public String getDefaultLocaleId() {
    return defaultLocaleId;
  }
  public void setDefaultLocaleId(String o) {
    this.defaultLocaleId = ComputatePageLayout.staticSetDefaultLocaleId(siteRequest_, o);
  }
  public static String staticSetDefaultLocaleId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout defaultLocaleIdInit() {
    Wrap<String> defaultLocaleIdWrap = new Wrap<String>().var("defaultLocaleId");
    if(defaultLocaleId == null) {
      _defaultLocaleId(defaultLocaleIdWrap);
      Optional.ofNullable(defaultLocaleIdWrap.getO()).ifPresent(o -> {
        setDefaultLocaleId(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultLocaleId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultLocaleId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultLocaleId(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultLocaleId(siteRequest_, ComputatePageLayout.staticSetDefaultLocaleId(siteRequest_, o)).toString();
  }

	//////////
  // rows //
	//////////


  /**
   *  The entity rows
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long rows;

  /**
   * <br> The entity rows
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:rows">Find the entity rows in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _rows(Wrap<Long> w);

  public Long getRows() {
    return rows;
  }

  public void setRows(Long rows) {
    this.rows = rows;
  }
  @JsonIgnore
  public void setRows(String o) {
    this.rows = ComputatePageLayout.staticSetRows(siteRequest_, o);
  }
  public static Long staticSetRows(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected ComputatePageLayout rowsInit() {
    Wrap<Long> rowsWrap = new Wrap<Long>().var("rows");
    if(rows == null) {
      _rows(rowsWrap);
      Optional.ofNullable(rowsWrap.getO()).ifPresent(o -> {
        setRows(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static Long staticSearchRows(ComputateSiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrRows(ComputateSiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRows(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchRows(siteRequest_, ComputatePageLayout.staticSetRows(siteRequest_, o)).toString();
  }

	///////////
  // start //
	///////////


  /**
   *  The entity start
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long start;

  /**
   * <br> The entity start
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:start">Find the entity start in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _start(Wrap<Long> w);

  public Long getStart() {
    return start;
  }

  public void setStart(Long start) {
    this.start = start;
  }
  @JsonIgnore
  public void setStart(String o) {
    this.start = ComputatePageLayout.staticSetStart(siteRequest_, o);
  }
  public static Long staticSetStart(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected ComputatePageLayout startInit() {
    Wrap<Long> startWrap = new Wrap<Long>().var("start");
    if(start == null) {
      _start(startWrap);
      Optional.ofNullable(startWrap.getO()).ifPresent(o -> {
        setStart(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static Long staticSearchStart(ComputateSiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrStart(ComputateSiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqStart(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchStart(siteRequest_, ComputatePageLayout.staticSetStart(siteRequest_, o)).toString();
  }

	///////////////////
  // defaultLocale //
	///////////////////


  /**
   *  The entity defaultLocale
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected Locale defaultLocale;

  /**
   * <br> The entity defaultLocale
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultLocale">Find the entity defaultLocale in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultLocale(Wrap<Locale> w);

  public Locale getDefaultLocale() {
    return defaultLocale;
  }

  public void setDefaultLocale(Locale defaultLocale) {
    this.defaultLocale = defaultLocale;
  }
  public static Locale staticSetDefaultLocale(ComputateSiteRequest siteRequest_, String o) {
    return null;
  }
  protected ComputatePageLayout defaultLocaleInit() {
    Wrap<Locale> defaultLocaleWrap = new Wrap<Locale>().var("defaultLocale");
    if(defaultLocale == null) {
      _defaultLocale(defaultLocaleWrap);
      Optional.ofNullable(defaultLocaleWrap.getO()).ifPresent(o -> {
        setDefaultLocale(o);
      });
    }
    return (ComputatePageLayout)this;
  }

	//////////////
  // rangeGap //
	//////////////


  /**
   *  The entity rangeGap
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String rangeGap;

  /**
   * <br> The entity rangeGap
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:rangeGap">Find the entity rangeGap in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _rangeGap(Wrap<String> w);

  public String getRangeGap() {
    return rangeGap;
  }
  public void setRangeGap(String o) {
    this.rangeGap = ComputatePageLayout.staticSetRangeGap(siteRequest_, o);
  }
  public static String staticSetRangeGap(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout rangeGapInit() {
    Wrap<String> rangeGapWrap = new Wrap<String>().var("rangeGap");
    if(rangeGap == null) {
      _rangeGap(rangeGapWrap);
      Optional.ofNullable(rangeGapWrap.getO()).ifPresent(o -> {
        setRangeGap(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchRangeGap(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrRangeGap(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRangeGap(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchRangeGap(siteRequest_, ComputatePageLayout.staticSetRangeGap(siteRequest_, o)).toString();
  }

	//////////////
  // rangeEnd //
	//////////////


  /**
   *  The entity rangeEnd
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime rangeEnd;

  /**
   * <br> The entity rangeEnd
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:rangeEnd">Find the entity rangeEnd in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _rangeEnd(Wrap<ZonedDateTime> w);

  public ZonedDateTime getRangeEnd() {
    return rangeEnd;
  }

  public void setRangeEnd(ZonedDateTime rangeEnd) {
    this.rangeEnd = Optional.ofNullable(rangeEnd).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setRangeEnd(Instant o) {
    this.rangeEnd = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setRangeEnd(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.rangeEnd = ComputatePageLayout.staticSetRangeEnd(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setRangeEnd(Date o) {
    this.rangeEnd = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetRangeEnd(ComputateSiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected ComputatePageLayout rangeEndInit() {
    Wrap<ZonedDateTime> rangeEndWrap = new Wrap<ZonedDateTime>().var("rangeEnd");
    if(rangeEnd == null) {
      _rangeEnd(rangeEndWrap);
      Optional.ofNullable(rangeEndWrap.getO()).ifPresent(o -> {
        setRangeEnd(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchRangeEnd(ComputateSiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrRangeEnd(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputatePageLayout.staticSearchRangeEnd(siteRequest_, ComputatePageLayout.staticSetRangeEnd(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqRangeEnd(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputatePageLayout.staticSearchRangeEnd(siteRequest_, ComputatePageLayout.staticSetRangeEnd(siteRequest_, o, zoneId)).toString();
  }

	////////////////
  // rangeStart //
	////////////////


  /**
   *  The entity rangeStart
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime rangeStart;

  /**
   * <br> The entity rangeStart
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:rangeStart">Find the entity rangeStart in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _rangeStart(Wrap<ZonedDateTime> w);

  public ZonedDateTime getRangeStart() {
    return rangeStart;
  }

  public void setRangeStart(ZonedDateTime rangeStart) {
    this.rangeStart = Optional.ofNullable(rangeStart).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setRangeStart(Instant o) {
    this.rangeStart = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setRangeStart(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.rangeStart = ComputatePageLayout.staticSetRangeStart(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setRangeStart(Date o) {
    this.rangeStart = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetRangeStart(ComputateSiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected ComputatePageLayout rangeStartInit() {
    Wrap<ZonedDateTime> rangeStartWrap = new Wrap<ZonedDateTime>().var("rangeStart");
    if(rangeStart == null) {
      _rangeStart(rangeStartWrap);
      Optional.ofNullable(rangeStartWrap.getO()).ifPresent(o -> {
        setRangeStart(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchRangeStart(ComputateSiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrRangeStart(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputatePageLayout.staticSearchRangeStart(siteRequest_, ComputatePageLayout.staticSetRangeStart(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqRangeStart(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputatePageLayout.staticSearchRangeStart(siteRequest_, ComputatePageLayout.staticSetRangeStart(siteRequest_, o, zoneId)).toString();
  }

	///////////////////////
  // defaultRangeStats //
	///////////////////////


  /**
   *  The entity defaultRangeStats
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject defaultRangeStats;

  /**
   * <br> The entity defaultRangeStats
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultRangeStats">Find the entity defaultRangeStats in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultRangeStats(Wrap<JsonObject> w);

  public JsonObject getDefaultRangeStats() {
    return defaultRangeStats;
  }

  public void setDefaultRangeStats(JsonObject defaultRangeStats) {
    this.defaultRangeStats = defaultRangeStats;
  }
  @JsonIgnore
  public void setDefaultRangeStats(String o) {
    this.defaultRangeStats = ComputatePageLayout.staticSetDefaultRangeStats(siteRequest_, o);
  }
  public static JsonObject staticSetDefaultRangeStats(ComputateSiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected ComputatePageLayout defaultRangeStatsInit() {
    Wrap<JsonObject> defaultRangeStatsWrap = new Wrap<JsonObject>().var("defaultRangeStats");
    if(defaultRangeStats == null) {
      _defaultRangeStats(defaultRangeStatsWrap);
      Optional.ofNullable(defaultRangeStatsWrap.getO()).ifPresent(o -> {
        setDefaultRangeStats(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultRangeStats(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrDefaultRangeStats(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultRangeStats(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultRangeStats(siteRequest_, ComputatePageLayout.staticSetDefaultRangeStats(siteRequest_, o)).toString();
  }

	/////////////////////
  // defaultRangeGap //
	/////////////////////


  /**
   *  The entity defaultRangeGap
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String defaultRangeGap;

  /**
   * <br> The entity defaultRangeGap
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultRangeGap">Find the entity defaultRangeGap in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultRangeGap(Wrap<String> w);

  public String getDefaultRangeGap() {
    return defaultRangeGap;
  }
  public void setDefaultRangeGap(String o) {
    this.defaultRangeGap = ComputatePageLayout.staticSetDefaultRangeGap(siteRequest_, o);
  }
  public static String staticSetDefaultRangeGap(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout defaultRangeGapInit() {
    Wrap<String> defaultRangeGapWrap = new Wrap<String>().var("defaultRangeGap");
    if(defaultRangeGap == null) {
      _defaultRangeGap(defaultRangeGapWrap);
      Optional.ofNullable(defaultRangeGapWrap.getO()).ifPresent(o -> {
        setDefaultRangeGap(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultRangeGap(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultRangeGap(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultRangeGap(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultRangeGap(siteRequest_, ComputatePageLayout.staticSetDefaultRangeGap(siteRequest_, o)).toString();
  }

	/////////////////////
  // defaultRangeEnd //
	/////////////////////


  /**
   *  The entity defaultRangeEnd
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime defaultRangeEnd;

  /**
   * <br> The entity defaultRangeEnd
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultRangeEnd">Find the entity defaultRangeEnd in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultRangeEnd(Wrap<ZonedDateTime> w);

  public ZonedDateTime getDefaultRangeEnd() {
    return defaultRangeEnd;
  }

  public void setDefaultRangeEnd(ZonedDateTime defaultRangeEnd) {
    this.defaultRangeEnd = Optional.ofNullable(defaultRangeEnd).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setDefaultRangeEnd(Instant o) {
    this.defaultRangeEnd = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setDefaultRangeEnd(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.defaultRangeEnd = ComputatePageLayout.staticSetDefaultRangeEnd(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setDefaultRangeEnd(Date o) {
    this.defaultRangeEnd = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetDefaultRangeEnd(ComputateSiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected ComputatePageLayout defaultRangeEndInit() {
    Wrap<ZonedDateTime> defaultRangeEndWrap = new Wrap<ZonedDateTime>().var("defaultRangeEnd");
    if(defaultRangeEnd == null) {
      _defaultRangeEnd(defaultRangeEndWrap);
      Optional.ofNullable(defaultRangeEndWrap.getO()).ifPresent(o -> {
        setDefaultRangeEnd(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultRangeEnd(ComputateSiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrDefaultRangeEnd(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputatePageLayout.staticSearchDefaultRangeEnd(siteRequest_, ComputatePageLayout.staticSetDefaultRangeEnd(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqDefaultRangeEnd(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputatePageLayout.staticSearchDefaultRangeEnd(siteRequest_, ComputatePageLayout.staticSetDefaultRangeEnd(siteRequest_, o, zoneId)).toString();
  }

	///////////////////////
  // defaultRangeStart //
	///////////////////////


  /**
   *  The entity defaultRangeStart
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime defaultRangeStart;

  /**
   * <br> The entity defaultRangeStart
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultRangeStart">Find the entity defaultRangeStart in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultRangeStart(Wrap<ZonedDateTime> w);

  public ZonedDateTime getDefaultRangeStart() {
    return defaultRangeStart;
  }

  public void setDefaultRangeStart(ZonedDateTime defaultRangeStart) {
    this.defaultRangeStart = Optional.ofNullable(defaultRangeStart).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setDefaultRangeStart(Instant o) {
    this.defaultRangeStart = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setDefaultRangeStart(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.defaultRangeStart = ComputatePageLayout.staticSetDefaultRangeStart(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setDefaultRangeStart(Date o) {
    this.defaultRangeStart = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetDefaultRangeStart(ComputateSiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected ComputatePageLayout defaultRangeStartInit() {
    Wrap<ZonedDateTime> defaultRangeStartWrap = new Wrap<ZonedDateTime>().var("defaultRangeStart");
    if(defaultRangeStart == null) {
      _defaultRangeStart(defaultRangeStartWrap);
      Optional.ofNullable(defaultRangeStartWrap.getO()).ifPresent(o -> {
        setDefaultRangeStart(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultRangeStart(ComputateSiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrDefaultRangeStart(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputatePageLayout.staticSearchDefaultRangeStart(siteRequest_, ComputatePageLayout.staticSetDefaultRangeStart(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqDefaultRangeStart(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputatePageLayout.staticSearchDefaultRangeStart(siteRequest_, ComputatePageLayout.staticSetDefaultRangeStart(siteRequest_, o, zoneId)).toString();
  }

	/////////////////////
  // defaultRangeVar //
	/////////////////////


  /**
   *  The entity defaultRangeVar
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String defaultRangeVar;

  /**
   * <br> The entity defaultRangeVar
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultRangeVar">Find the entity defaultRangeVar in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultRangeVar(Wrap<String> w);

  public String getDefaultRangeVar() {
    return defaultRangeVar;
  }
  public void setDefaultRangeVar(String o) {
    this.defaultRangeVar = ComputatePageLayout.staticSetDefaultRangeVar(siteRequest_, o);
  }
  public static String staticSetDefaultRangeVar(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout defaultRangeVarInit() {
    Wrap<String> defaultRangeVarWrap = new Wrap<String>().var("defaultRangeVar");
    if(defaultRangeVar == null) {
      _defaultRangeVar(defaultRangeVarWrap);
      Optional.ofNullable(defaultRangeVarWrap.getO()).ifPresent(o -> {
        setDefaultRangeVar(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultRangeVar(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultRangeVar(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultRangeVar(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultRangeVar(siteRequest_, ComputatePageLayout.staticSetDefaultRangeVar(siteRequest_, o)).toString();
  }

	//////////////////////
  // defaultFacetSort //
	//////////////////////


  /**
   *  The entity defaultFacetSort
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String defaultFacetSort;

  /**
   * <br> The entity defaultFacetSort
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultFacetSort">Find the entity defaultFacetSort in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultFacetSort(Wrap<String> w);

  public String getDefaultFacetSort() {
    return defaultFacetSort;
  }
  public void setDefaultFacetSort(String o) {
    this.defaultFacetSort = ComputatePageLayout.staticSetDefaultFacetSort(siteRequest_, o);
  }
  public static String staticSetDefaultFacetSort(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputatePageLayout defaultFacetSortInit() {
    Wrap<String> defaultFacetSortWrap = new Wrap<String>().var("defaultFacetSort");
    if(defaultFacetSort == null) {
      _defaultFacetSort(defaultFacetSortWrap);
      Optional.ofNullable(defaultFacetSortWrap.getO()).ifPresent(o -> {
        setDefaultFacetSort(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDefaultFacetSort(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDefaultFacetSort(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultFacetSort(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultFacetSort(siteRequest_, ComputatePageLayout.staticSetDefaultFacetSort(siteRequest_, o)).toString();
  }

	///////////////////////
  // defaultFacetLimit //
	///////////////////////


  /**
   *  The entity defaultFacetLimit
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer defaultFacetLimit;

  /**
   * <br> The entity defaultFacetLimit
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultFacetLimit">Find the entity defaultFacetLimit in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultFacetLimit(Wrap<Integer> w);

  public Integer getDefaultFacetLimit() {
    return defaultFacetLimit;
  }

  public void setDefaultFacetLimit(Integer defaultFacetLimit) {
    this.defaultFacetLimit = defaultFacetLimit;
  }
  @JsonIgnore
  public void setDefaultFacetLimit(String o) {
    this.defaultFacetLimit = ComputatePageLayout.staticSetDefaultFacetLimit(siteRequest_, o);
  }
  public static Integer staticSetDefaultFacetLimit(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected ComputatePageLayout defaultFacetLimitInit() {
    Wrap<Integer> defaultFacetLimitWrap = new Wrap<Integer>().var("defaultFacetLimit");
    if(defaultFacetLimit == null) {
      _defaultFacetLimit(defaultFacetLimitWrap);
      Optional.ofNullable(defaultFacetLimitWrap.getO()).ifPresent(o -> {
        setDefaultFacetLimit(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static Integer staticSearchDefaultFacetLimit(ComputateSiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrDefaultFacetLimit(ComputateSiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultFacetLimit(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultFacetLimit(siteRequest_, ComputatePageLayout.staticSetDefaultFacetLimit(siteRequest_, o)).toString();
  }

	//////////////////////////
  // defaultFacetMinCount //
	//////////////////////////


  /**
   *  The entity defaultFacetMinCount
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer defaultFacetMinCount;

  /**
   * <br> The entity defaultFacetMinCount
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultFacetMinCount">Find the entity defaultFacetMinCount in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultFacetMinCount(Wrap<Integer> w);

  public Integer getDefaultFacetMinCount() {
    return defaultFacetMinCount;
  }

  public void setDefaultFacetMinCount(Integer defaultFacetMinCount) {
    this.defaultFacetMinCount = defaultFacetMinCount;
  }
  @JsonIgnore
  public void setDefaultFacetMinCount(String o) {
    this.defaultFacetMinCount = ComputatePageLayout.staticSetDefaultFacetMinCount(siteRequest_, o);
  }
  public static Integer staticSetDefaultFacetMinCount(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected ComputatePageLayout defaultFacetMinCountInit() {
    Wrap<Integer> defaultFacetMinCountWrap = new Wrap<Integer>().var("defaultFacetMinCount");
    if(defaultFacetMinCount == null) {
      _defaultFacetMinCount(defaultFacetMinCountWrap);
      Optional.ofNullable(defaultFacetMinCountWrap.getO()).ifPresent(o -> {
        setDefaultFacetMinCount(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static Integer staticSearchDefaultFacetMinCount(ComputateSiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrDefaultFacetMinCount(ComputateSiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultFacetMinCount(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultFacetMinCount(siteRequest_, ComputatePageLayout.staticSetDefaultFacetMinCount(siteRequest_, o)).toString();
  }

	//////////////////////////
  // defaultPivotMinCount //
	//////////////////////////


  /**
   *  The entity defaultPivotMinCount
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer defaultPivotMinCount;

  /**
   * <br> The entity defaultPivotMinCount
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:defaultPivotMinCount">Find the entity defaultPivotMinCount in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _defaultPivotMinCount(Wrap<Integer> w);

  public Integer getDefaultPivotMinCount() {
    return defaultPivotMinCount;
  }

  public void setDefaultPivotMinCount(Integer defaultPivotMinCount) {
    this.defaultPivotMinCount = defaultPivotMinCount;
  }
  @JsonIgnore
  public void setDefaultPivotMinCount(String o) {
    this.defaultPivotMinCount = ComputatePageLayout.staticSetDefaultPivotMinCount(siteRequest_, o);
  }
  public static Integer staticSetDefaultPivotMinCount(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected ComputatePageLayout defaultPivotMinCountInit() {
    Wrap<Integer> defaultPivotMinCountWrap = new Wrap<Integer>().var("defaultPivotMinCount");
    if(defaultPivotMinCount == null) {
      _defaultPivotMinCount(defaultPivotMinCountWrap);
      Optional.ofNullable(defaultPivotMinCountWrap.getO()).ifPresent(o -> {
        setDefaultPivotMinCount(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static Integer staticSearchDefaultPivotMinCount(ComputateSiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrDefaultPivotMinCount(ComputateSiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDefaultPivotMinCount(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDefaultPivotMinCount(siteRequest_, ComputatePageLayout.staticSetDefaultPivotMinCount(siteRequest_, o)).toString();
  }

	//////////////////////////
  // DEFAULT_MAP_LOCATION //
	//////////////////////////


  /**
   *  The entity DEFAULT_MAP_LOCATION
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject DEFAULT_MAP_LOCATION;

  /**
   * <br> The entity DEFAULT_MAP_LOCATION
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:DEFAULT_MAP_LOCATION">Find the entity DEFAULT_MAP_LOCATION in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _DEFAULT_MAP_LOCATION(Wrap<JsonObject> w);

  public JsonObject getDEFAULT_MAP_LOCATION() {
    return DEFAULT_MAP_LOCATION;
  }

  public void setDEFAULT_MAP_LOCATION(JsonObject DEFAULT_MAP_LOCATION) {
    this.DEFAULT_MAP_LOCATION = DEFAULT_MAP_LOCATION;
  }
  @JsonIgnore
  public void setDEFAULT_MAP_LOCATION(String o) {
    this.DEFAULT_MAP_LOCATION = ComputatePageLayout.staticSetDEFAULT_MAP_LOCATION(siteRequest_, o);
  }
  public static JsonObject staticSetDEFAULT_MAP_LOCATION(ComputateSiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected ComputatePageLayout DEFAULT_MAP_LOCATIONInit() {
    Wrap<JsonObject> DEFAULT_MAP_LOCATIONWrap = new Wrap<JsonObject>().var("DEFAULT_MAP_LOCATION");
    if(DEFAULT_MAP_LOCATION == null) {
      _DEFAULT_MAP_LOCATION(DEFAULT_MAP_LOCATIONWrap);
      Optional.ofNullable(DEFAULT_MAP_LOCATIONWrap.getO()).ifPresent(o -> {
        setDEFAULT_MAP_LOCATION(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static String staticSearchDEFAULT_MAP_LOCATION(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrDEFAULT_MAP_LOCATION(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDEFAULT_MAP_LOCATION(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDEFAULT_MAP_LOCATION(siteRequest_, ComputatePageLayout.staticSetDEFAULT_MAP_LOCATION(siteRequest_, o)).toString();
  }

	//////////////////////
  // DEFAULT_MAP_ZOOM //
	//////////////////////


  /**
   *  The entity DEFAULT_MAP_ZOOM
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected BigDecimal DEFAULT_MAP_ZOOM;

  /**
   * <br> The entity DEFAULT_MAP_ZOOM
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:DEFAULT_MAP_ZOOM">Find the entity DEFAULT_MAP_ZOOM in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _DEFAULT_MAP_ZOOM(Wrap<BigDecimal> w);

  public BigDecimal getDEFAULT_MAP_ZOOM() {
    return DEFAULT_MAP_ZOOM;
  }

  public void setDEFAULT_MAP_ZOOM(BigDecimal DEFAULT_MAP_ZOOM) {
    this.DEFAULT_MAP_ZOOM = DEFAULT_MAP_ZOOM;
  }
  @JsonIgnore
  public void setDEFAULT_MAP_ZOOM(String o) {
    this.DEFAULT_MAP_ZOOM = ComputatePageLayout.staticSetDEFAULT_MAP_ZOOM(siteRequest_, o);
  }
  public static BigDecimal staticSetDEFAULT_MAP_ZOOM(ComputateSiteRequest siteRequest_, String o) {
    o = StringUtils.removeAll(o, "[^\\d\\.]");
    if(NumberUtils.isParsable(o))
      return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
    return null;
  }
  @JsonIgnore
  public void setDEFAULT_MAP_ZOOM(Double o) {
    setDEFAULT_MAP_ZOOM(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
  }
  @JsonIgnore
  public void setDEFAULT_MAP_ZOOM(Integer o) {
    setDEFAULT_MAP_ZOOM(new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
  }
  @JsonIgnore
  public void setDEFAULT_MAP_ZOOM(Number o) {
    setDEFAULT_MAP_ZOOM(new BigDecimal(o.doubleValue(), MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP));
  }
  protected ComputatePageLayout DEFAULT_MAP_ZOOMInit() {
    Wrap<BigDecimal> DEFAULT_MAP_ZOOMWrap = new Wrap<BigDecimal>().var("DEFAULT_MAP_ZOOM");
    if(DEFAULT_MAP_ZOOM == null) {
      _DEFAULT_MAP_ZOOM(DEFAULT_MAP_ZOOMWrap);
      Optional.ofNullable(DEFAULT_MAP_ZOOMWrap.getO()).ifPresent(o -> {
        setDEFAULT_MAP_ZOOM(o);
      });
    }
    return (ComputatePageLayout)this;
  }

  public static Double staticSearchDEFAULT_MAP_ZOOM(ComputateSiteRequest siteRequest_, BigDecimal o) {
    return o == null ? null : o.doubleValue();
  }

  public static String staticSearchStrDEFAULT_MAP_ZOOM(ComputateSiteRequest siteRequest_, Double o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDEFAULT_MAP_ZOOM(ComputateSiteRequest siteRequest_, String o) {
    return ComputatePageLayout.staticSearchDEFAULT_MAP_ZOOM(siteRequest_, ComputatePageLayout.staticSetDEFAULT_MAP_ZOOM(siteRequest_, o)).toString();
  }

	//////////////
  // queryStr //
	//////////////


  /**
   *  The entity queryStr
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String queryStr;

  /**
   * <br> The entity queryStr
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:queryStr">Find the entity queryStr in Solr</a>
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
      Optional.ofNullable(queryStrWrap.getO()).ifPresent(o -> {
        setQueryStr(o);
      });
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
    return ComputatePageLayout.staticSearchQueryStr(siteRequest_, ComputatePageLayout.staticSetQueryStr(siteRequest_, o)).toString();
  }

	//////////////////
  // promiseAfter //
	//////////////////


  /**
   *  The entity promiseAfter
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected Void promiseAfter;

  /**
   * <br> The entity promiseAfter
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:promiseAfter">Find the entity promiseAfter in Solr</a>
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


  /**
   *  The entity pageImageUri
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageImageUri;

  /**
   * <br> The entity pageImageUri
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
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
      Optional.ofNullable(pageImageUriWrap.getO()).ifPresent(o -> {
        setPageImageUri(o);
      });
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
    return ComputatePageLayout.staticSearchPageImageUri(siteRequest_, ComputatePageLayout.staticSetPageImageUri(siteRequest_, o)).toString();
  }

	////////////////////
  // pageImageWidth //
	////////////////////


  /**
   *  The entity pageImageWidth
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer pageImageWidth;

  /**
   * <br> The entity pageImageWidth
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageImageWidth">Find the entity pageImageWidth in Solr</a>
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
      Optional.ofNullable(pageImageWidthWrap.getO()).ifPresent(o -> {
        setPageImageWidth(o);
      });
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
    return ComputatePageLayout.staticSearchPageImageWidth(siteRequest_, ComputatePageLayout.staticSetPageImageWidth(siteRequest_, o)).toString();
  }

	/////////////////////
  // pageImageHeight //
	/////////////////////


  /**
   *  The entity pageImageHeight
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer pageImageHeight;

  /**
   * <br> The entity pageImageHeight
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageImageHeight">Find the entity pageImageHeight in Solr</a>
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
      Optional.ofNullable(pageImageHeightWrap.getO()).ifPresent(o -> {
        setPageImageHeight(o);
      });
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
    return ComputatePageLayout.staticSearchPageImageHeight(siteRequest_, ComputatePageLayout.staticSetPageImageHeight(siteRequest_, o)).toString();
  }

	/////////////////
  // pageVideoId //
	/////////////////


  /**
   *  The entity pageVideoId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageVideoId;

  /**
   * <br> The entity pageVideoId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageVideoId">Find the entity pageVideoId in Solr</a>
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
      Optional.ofNullable(pageVideoIdWrap.getO()).ifPresent(o -> {
        setPageVideoId(o);
      });
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
    return ComputatePageLayout.staticSearchPageVideoId(siteRequest_, ComputatePageLayout.staticSetPageVideoId(siteRequest_, o)).toString();
  }

	////////////////////
  // classIconGroup //
	////////////////////


  /**
   *  The entity classIconGroup
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classIconGroup;

  /**
   * <br> The entity classIconGroup
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:classIconGroup">Find the entity classIconGroup in Solr</a>
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
      Optional.ofNullable(classIconGroupWrap.getO()).ifPresent(o -> {
        setClassIconGroup(o);
      });
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
    return ComputatePageLayout.staticSearchClassIconGroup(siteRequest_, ComputatePageLayout.staticSetClassIconGroup(siteRequest_, o)).toString();
  }

	///////////////////
  // classIconName //
	///////////////////


  /**
   *  The entity classIconName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classIconName;

  /**
   * <br> The entity classIconName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:classIconName">Find the entity classIconName in Solr</a>
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
      Optional.ofNullable(classIconNameWrap.getO()).ifPresent(o -> {
        setClassIconName(o);
      });
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
    return ComputatePageLayout.staticSearchClassIconName(siteRequest_, ComputatePageLayout.staticSetClassIconName(siteRequest_, o)).toString();
  }

	/////////////////////////
  // classIconCssClasses //
	/////////////////////////


  /**
   *  The entity classIconCssClasses
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classIconCssClasses;

  /**
   * <br> The entity classIconCssClasses
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:classIconCssClasses">Find the entity classIconCssClasses in Solr</a>
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
      Optional.ofNullable(classIconCssClassesWrap.getO()).ifPresent(o -> {
        setClassIconCssClasses(o);
      });
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
    return ComputatePageLayout.staticSearchClassIconCssClasses(siteRequest_, ComputatePageLayout.staticSetClassIconCssClasses(siteRequest_, o)).toString();
  }

	/////////////////////
  // pageDescription //
	/////////////////////


  /**
   *  The entity pageDescription
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageDescription;

  /**
   * <br> The entity pageDescription
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.page.ComputatePageLayout&fq=entiteVar_enUS_indexed_string:pageDescription">Find the entity pageDescription in Solr</a>
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
      Optional.ofNullable(pageDescriptionWrap.getO()).ifPresent(o -> {
        setPageDescription(o);
      });
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
    return ComputatePageLayout.staticSearchPageDescription(siteRequest_, ComputatePageLayout.staticSetPageDescription(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<ComputatePageLayoutGen<DEV>> promiseDeepComputatePageLayout(ComputateSiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepComputatePageLayout();
  }

  public Future<ComputatePageLayoutGen<DEV>> promiseDeepComputatePageLayout() {
    Promise<ComputatePageLayoutGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseComputatePageLayout(promise2);
    promise2.future().onSuccess(a -> {
      promise.complete(this);
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
        facebookGraphVersionInit();
        facebookAppIdInit();
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
        scopesInit();
        roleRequiredInit();
        authRoleAdminInit();
        authRoleSuperAdminInit();
        statsInit();
        facetCountsInit();
        paginationInit();
        defaultSortVarsInit();
        defaultFieldListVarsInit();
        defaultStatsVarsInit();
        defaultPivotVarsInit();
        varsQInit();
        varsFqInit();
        varsRangeInit();
        queryInit();
        pageResponseInit();
        defaultZoneIdInit();
        defaultTimeZoneInit();
        defaultLocaleIdInit();
        rowsInit();
        startInit();
        defaultLocaleInit();
        rangeGapInit();
        rangeEndInit();
        rangeStartInit();
        defaultRangeStatsInit();
        defaultRangeGapInit();
        defaultRangeEndInit();
        defaultRangeStartInit();
        defaultRangeVarInit();
        defaultFacetSortInit();
        defaultFacetLimitInit();
        defaultFacetMinCountInit();
        defaultPivotMinCountInit();
        DEFAULT_MAP_LOCATIONInit();
        DEFAULT_MAP_ZOOMInit();
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

  public Future<? extends ComputatePageLayoutGen<DEV>> promiseDeepForClass(ComputateSiteRequest siteRequest_) {
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
      case "facebookGraphVersion":
        return oComputatePageLayout.facebookGraphVersion;
      case "facebookAppId":
        return oComputatePageLayout.facebookAppId;
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
      case "promiseBefore":
        return oComputatePageLayout.promiseBefore;
      case "classSimpleName":
        return oComputatePageLayout.classSimpleName;
      case "pageTitle":
        return oComputatePageLayout.pageTitle;
      case "scopes":
        return oComputatePageLayout.scopes;
      case "roleRequired":
        return oComputatePageLayout.roleRequired;
      case "authRoleAdmin":
        return oComputatePageLayout.authRoleAdmin;
      case "authRoleSuperAdmin":
        return oComputatePageLayout.authRoleSuperAdmin;
      case "stats":
        return oComputatePageLayout.stats;
      case "facetCounts":
        return oComputatePageLayout.facetCounts;
      case "pagination":
        return oComputatePageLayout.pagination;
      case "defaultSortVars":
        return oComputatePageLayout.defaultSortVars;
      case "defaultFieldListVars":
        return oComputatePageLayout.defaultFieldListVars;
      case "defaultStatsVars":
        return oComputatePageLayout.defaultStatsVars;
      case "defaultPivotVars":
        return oComputatePageLayout.defaultPivotVars;
      case "varsQ":
        return oComputatePageLayout.varsQ;
      case "varsFq":
        return oComputatePageLayout.varsFq;
      case "varsRange":
        return oComputatePageLayout.varsRange;
      case "query":
        return oComputatePageLayout.query;
      case "pageResponse":
        return oComputatePageLayout.pageResponse;
      case "defaultZoneId":
        return oComputatePageLayout.defaultZoneId;
      case "defaultTimeZone":
        return oComputatePageLayout.defaultTimeZone;
      case "defaultLocaleId":
        return oComputatePageLayout.defaultLocaleId;
      case "rows":
        return oComputatePageLayout.rows;
      case "start":
        return oComputatePageLayout.start;
      case "defaultLocale":
        return oComputatePageLayout.defaultLocale;
      case "rangeGap":
        return oComputatePageLayout.rangeGap;
      case "rangeEnd":
        return oComputatePageLayout.rangeEnd;
      case "rangeStart":
        return oComputatePageLayout.rangeStart;
      case "defaultRangeStats":
        return oComputatePageLayout.defaultRangeStats;
      case "defaultRangeGap":
        return oComputatePageLayout.defaultRangeGap;
      case "defaultRangeEnd":
        return oComputatePageLayout.defaultRangeEnd;
      case "defaultRangeStart":
        return oComputatePageLayout.defaultRangeStart;
      case "defaultRangeVar":
        return oComputatePageLayout.defaultRangeVar;
      case "defaultFacetSort":
        return oComputatePageLayout.defaultFacetSort;
      case "defaultFacetLimit":
        return oComputatePageLayout.defaultFacetLimit;
      case "defaultFacetMinCount":
        return oComputatePageLayout.defaultFacetMinCount;
      case "defaultPivotMinCount":
        return oComputatePageLayout.defaultPivotMinCount;
      case "DEFAULT_MAP_LOCATION":
        return oComputatePageLayout.DEFAULT_MAP_LOCATION;
      case "DEFAULT_MAP_ZOOM":
        return oComputatePageLayout.DEFAULT_MAP_ZOOM;
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

  public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String v, ComputatePageLayout o) {
    return staticSetComputatePageLayout(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetComputatePageLayout(String entityVar, ComputateSiteRequest siteRequest_, String v, ComputatePageLayout o) {
    switch(entityVar) {
    case "lang":
      return ComputatePageLayout.staticSetLang(siteRequest_, v);
    case "config":
      return ComputatePageLayout.staticSetConfig(siteRequest_, v);
    case "staticBaseUrl":
      return ComputatePageLayout.staticSetStaticBaseUrl(siteRequest_, v);
    case "siteBaseUrl":
      return ComputatePageLayout.staticSetSiteBaseUrl(siteRequest_, v);
    case "siteAuthUrl":
      return ComputatePageLayout.staticSetSiteAuthUrl(siteRequest_, v);
    case "siteAuthRealm":
      return ComputatePageLayout.staticSetSiteAuthRealm(siteRequest_, v);
    case "fontAwesomeKit":
      return ComputatePageLayout.staticSetFontAwesomeKit(siteRequest_, v);
    case "facebookGraphVersion":
      return ComputatePageLayout.staticSetFacebookGraphVersion(siteRequest_, v);
    case "facebookAppId":
      return ComputatePageLayout.staticSetFacebookAppId(siteRequest_, v);
    case "pageUri":
      return ComputatePageLayout.staticSetPageUri(siteRequest_, v);
    case "pageId":
      return ComputatePageLayout.staticSetPageId(siteRequest_, v);
    case "apiUri":
      return ComputatePageLayout.staticSetApiUri(siteRequest_, v);
    case "pageMethod":
      return ComputatePageLayout.staticSetPageMethod(siteRequest_, v);
    case "params":
      return ComputatePageLayout.staticSetParams(siteRequest_, v);
    case "userKey":
      return ComputatePageLayout.staticSetUserKey(siteRequest_, v);
    case "userFullName":
      return ComputatePageLayout.staticSetUserFullName(siteRequest_, v);
    case "userName":
      return ComputatePageLayout.staticSetUserName(siteRequest_, v);
    case "userEmail":
      return ComputatePageLayout.staticSetUserEmail(siteRequest_, v);
    case "logoutUrl":
      return ComputatePageLayout.staticSetLogoutUrl(siteRequest_, v);
    case "classSimpleName":
      return ComputatePageLayout.staticSetClassSimpleName(siteRequest_, v);
    case "pageTitle":
      return ComputatePageLayout.staticSetPageTitle(siteRequest_, v);
    case "scopes":
      return ComputatePageLayout.staticSetScopes(siteRequest_, v);
    case "roleRequired":
      return ComputatePageLayout.staticSetRoleRequired(siteRequest_, v);
    case "authRoleAdmin":
      return ComputatePageLayout.staticSetAuthRoleAdmin(siteRequest_, v);
    case "authRoleSuperAdmin":
      return ComputatePageLayout.staticSetAuthRoleSuperAdmin(siteRequest_, v);
    case "pagination":
      return ComputatePageLayout.staticSetPagination(siteRequest_, v);
    case "defaultSortVars":
      return ComputatePageLayout.staticSetDefaultSortVars(siteRequest_, v);
    case "defaultFieldListVars":
      return ComputatePageLayout.staticSetDefaultFieldListVars(siteRequest_, v);
    case "defaultStatsVars":
      return ComputatePageLayout.staticSetDefaultStatsVars(siteRequest_, v);
    case "defaultPivotVars":
      return ComputatePageLayout.staticSetDefaultPivotVars(siteRequest_, v);
    case "varsQ":
      return ComputatePageLayout.staticSetVarsQ(siteRequest_, v);
    case "varsFq":
      return ComputatePageLayout.staticSetVarsFq(siteRequest_, v);
    case "varsRange":
      return ComputatePageLayout.staticSetVarsRange(siteRequest_, v);
    case "query":
      return ComputatePageLayout.staticSetQuery(siteRequest_, v);
    case "pageResponse":
      return ComputatePageLayout.staticSetPageResponse(siteRequest_, v);
    case "defaultZoneId":
      return ComputatePageLayout.staticSetDefaultZoneId(siteRequest_, v);
    case "defaultLocaleId":
      return ComputatePageLayout.staticSetDefaultLocaleId(siteRequest_, v);
    case "rows":
      return ComputatePageLayout.staticSetRows(siteRequest_, v);
    case "start":
      return ComputatePageLayout.staticSetStart(siteRequest_, v);
    case "rangeGap":
      return ComputatePageLayout.staticSetRangeGap(siteRequest_, v);
    case "rangeEnd":
    case "rangeStart":
    case "defaultRangeStats":
      return ComputatePageLayout.staticSetDefaultRangeStats(siteRequest_, v);
    case "defaultRangeGap":
      return ComputatePageLayout.staticSetDefaultRangeGap(siteRequest_, v);
    case "defaultRangeEnd":
    case "defaultRangeStart":
    case "defaultRangeVar":
      return ComputatePageLayout.staticSetDefaultRangeVar(siteRequest_, v);
    case "defaultFacetSort":
      return ComputatePageLayout.staticSetDefaultFacetSort(siteRequest_, v);
    case "defaultFacetLimit":
      return ComputatePageLayout.staticSetDefaultFacetLimit(siteRequest_, v);
    case "defaultFacetMinCount":
      return ComputatePageLayout.staticSetDefaultFacetMinCount(siteRequest_, v);
    case "defaultPivotMinCount":
      return ComputatePageLayout.staticSetDefaultPivotMinCount(siteRequest_, v);
    case "DEFAULT_MAP_LOCATION":
      return ComputatePageLayout.staticSetDEFAULT_MAP_LOCATION(siteRequest_, v);
    case "DEFAULT_MAP_ZOOM":
      return ComputatePageLayout.staticSetDEFAULT_MAP_ZOOM(siteRequest_, v);
    case "queryStr":
      return ComputatePageLayout.staticSetQueryStr(siteRequest_, v);
    case "pageImageUri":
      return ComputatePageLayout.staticSetPageImageUri(siteRequest_, v);
    case "pageImageWidth":
      return ComputatePageLayout.staticSetPageImageWidth(siteRequest_, v);
    case "pageImageHeight":
      return ComputatePageLayout.staticSetPageImageHeight(siteRequest_, v);
    case "pageVideoId":
      return ComputatePageLayout.staticSetPageVideoId(siteRequest_, v);
    case "classIconGroup":
      return ComputatePageLayout.staticSetClassIconGroup(siteRequest_, v);
    case "classIconName":
      return ComputatePageLayout.staticSetClassIconName(siteRequest_, v);
    case "classIconCssClasses":
      return ComputatePageLayout.staticSetClassIconCssClasses(siteRequest_, v);
    case "pageDescription":
      return ComputatePageLayout.staticSetPageDescription(siteRequest_, v);
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
    case "facebookGraphVersion":
      return ComputatePageLayout.staticSearchFacebookGraphVersion(siteRequest_, (String)o);
    case "facebookAppId":
      return ComputatePageLayout.staticSearchFacebookAppId(siteRequest_, (String)o);
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
    case "classSimpleName":
      return ComputatePageLayout.staticSearchClassSimpleName(siteRequest_, (String)o);
    case "pageTitle":
      return ComputatePageLayout.staticSearchPageTitle(siteRequest_, (String)o);
    case "scopes":
      return ComputatePageLayout.staticSearchScopes(siteRequest_, (String)o);
    case "roleRequired":
      return ComputatePageLayout.staticSearchRoleRequired(siteRequest_, (String)o);
    case "authRoleAdmin":
      return ComputatePageLayout.staticSearchAuthRoleAdmin(siteRequest_, (String)o);
    case "authRoleSuperAdmin":
      return ComputatePageLayout.staticSearchAuthRoleSuperAdmin(siteRequest_, (String)o);
    case "pagination":
      return ComputatePageLayout.staticSearchPagination(siteRequest_, (JsonObject)o);
    case "defaultSortVars":
      return ComputatePageLayout.staticSearchDefaultSortVars(siteRequest_, (String)o);
    case "defaultFieldListVars":
      return ComputatePageLayout.staticSearchDefaultFieldListVars(siteRequest_, (String)o);
    case "defaultStatsVars":
      return ComputatePageLayout.staticSearchDefaultStatsVars(siteRequest_, (String)o);
    case "defaultPivotVars":
      return ComputatePageLayout.staticSearchDefaultPivotVars(siteRequest_, (String)o);
    case "varsQ":
      return ComputatePageLayout.staticSearchVarsQ(siteRequest_, (JsonObject)o);
    case "varsFq":
      return ComputatePageLayout.staticSearchVarsFq(siteRequest_, (JsonObject)o);
    case "varsRange":
      return ComputatePageLayout.staticSearchVarsRange(siteRequest_, (JsonObject)o);
    case "query":
      return ComputatePageLayout.staticSearchQuery(siteRequest_, (JsonObject)o);
    case "pageResponse":
      return ComputatePageLayout.staticSearchPageResponse(siteRequest_, (String)o);
    case "defaultZoneId":
      return ComputatePageLayout.staticSearchDefaultZoneId(siteRequest_, (String)o);
    case "defaultLocaleId":
      return ComputatePageLayout.staticSearchDefaultLocaleId(siteRequest_, (String)o);
    case "rows":
      return ComputatePageLayout.staticSearchRows(siteRequest_, (Long)o);
    case "start":
      return ComputatePageLayout.staticSearchStart(siteRequest_, (Long)o);
    case "rangeGap":
      return ComputatePageLayout.staticSearchRangeGap(siteRequest_, (String)o);
    case "rangeEnd":
      return ComputatePageLayout.staticSearchRangeEnd(siteRequest_, (ZonedDateTime)o);
    case "rangeStart":
      return ComputatePageLayout.staticSearchRangeStart(siteRequest_, (ZonedDateTime)o);
    case "defaultRangeStats":
      return ComputatePageLayout.staticSearchDefaultRangeStats(siteRequest_, (JsonObject)o);
    case "defaultRangeGap":
      return ComputatePageLayout.staticSearchDefaultRangeGap(siteRequest_, (String)o);
    case "defaultRangeEnd":
      return ComputatePageLayout.staticSearchDefaultRangeEnd(siteRequest_, (ZonedDateTime)o);
    case "defaultRangeStart":
      return ComputatePageLayout.staticSearchDefaultRangeStart(siteRequest_, (ZonedDateTime)o);
    case "defaultRangeVar":
      return ComputatePageLayout.staticSearchDefaultRangeVar(siteRequest_, (String)o);
    case "defaultFacetSort":
      return ComputatePageLayout.staticSearchDefaultFacetSort(siteRequest_, (String)o);
    case "defaultFacetLimit":
      return ComputatePageLayout.staticSearchDefaultFacetLimit(siteRequest_, (Integer)o);
    case "defaultFacetMinCount":
      return ComputatePageLayout.staticSearchDefaultFacetMinCount(siteRequest_, (Integer)o);
    case "defaultPivotMinCount":
      return ComputatePageLayout.staticSearchDefaultPivotMinCount(siteRequest_, (Integer)o);
    case "DEFAULT_MAP_LOCATION":
      return ComputatePageLayout.staticSearchDEFAULT_MAP_LOCATION(siteRequest_, (JsonObject)o);
    case "DEFAULT_MAP_ZOOM":
      return ComputatePageLayout.staticSearchDEFAULT_MAP_ZOOM(siteRequest_, (BigDecimal)o);
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
      return ComputatePageLayout.staticSearchStrConfig(siteRequest_, (String)o);
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
    case "facebookGraphVersion":
      return ComputatePageLayout.staticSearchStrFacebookGraphVersion(siteRequest_, (String)o);
    case "facebookAppId":
      return ComputatePageLayout.staticSearchStrFacebookAppId(siteRequest_, (String)o);
    case "pageUri":
      return ComputatePageLayout.staticSearchStrPageUri(siteRequest_, (String)o);
    case "pageId":
      return ComputatePageLayout.staticSearchStrPageId(siteRequest_, (String)o);
    case "apiUri":
      return ComputatePageLayout.staticSearchStrApiUri(siteRequest_, (String)o);
    case "pageMethod":
      return ComputatePageLayout.staticSearchStrPageMethod(siteRequest_, (String)o);
    case "params":
      return ComputatePageLayout.staticSearchStrParams(siteRequest_, (String)o);
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
    case "classSimpleName":
      return ComputatePageLayout.staticSearchStrClassSimpleName(siteRequest_, (String)o);
    case "pageTitle":
      return ComputatePageLayout.staticSearchStrPageTitle(siteRequest_, (String)o);
    case "scopes":
      return ComputatePageLayout.staticSearchStrScopes(siteRequest_, (String)o);
    case "roleRequired":
      return ComputatePageLayout.staticSearchStrRoleRequired(siteRequest_, (String)o);
    case "authRoleAdmin":
      return ComputatePageLayout.staticSearchStrAuthRoleAdmin(siteRequest_, (String)o);
    case "authRoleSuperAdmin":
      return ComputatePageLayout.staticSearchStrAuthRoleSuperAdmin(siteRequest_, (String)o);
    case "pagination":
      return ComputatePageLayout.staticSearchStrPagination(siteRequest_, (String)o);
    case "defaultSortVars":
      return ComputatePageLayout.staticSearchStrDefaultSortVars(siteRequest_, (String)o);
    case "defaultFieldListVars":
      return ComputatePageLayout.staticSearchStrDefaultFieldListVars(siteRequest_, (String)o);
    case "defaultStatsVars":
      return ComputatePageLayout.staticSearchStrDefaultStatsVars(siteRequest_, (String)o);
    case "defaultPivotVars":
      return ComputatePageLayout.staticSearchStrDefaultPivotVars(siteRequest_, (String)o);
    case "varsQ":
      return ComputatePageLayout.staticSearchStrVarsQ(siteRequest_, (String)o);
    case "varsFq":
      return ComputatePageLayout.staticSearchStrVarsFq(siteRequest_, (String)o);
    case "varsRange":
      return ComputatePageLayout.staticSearchStrVarsRange(siteRequest_, (String)o);
    case "query":
      return ComputatePageLayout.staticSearchStrQuery(siteRequest_, (String)o);
    case "pageResponse":
      return ComputatePageLayout.staticSearchStrPageResponse(siteRequest_, (String)o);
    case "defaultZoneId":
      return ComputatePageLayout.staticSearchStrDefaultZoneId(siteRequest_, (String)o);
    case "defaultLocaleId":
      return ComputatePageLayout.staticSearchStrDefaultLocaleId(siteRequest_, (String)o);
    case "rows":
      return ComputatePageLayout.staticSearchStrRows(siteRequest_, (Long)o);
    case "start":
      return ComputatePageLayout.staticSearchStrStart(siteRequest_, (Long)o);
    case "rangeGap":
      return ComputatePageLayout.staticSearchStrRangeGap(siteRequest_, (String)o);
    case "rangeEnd":
      return ComputatePageLayout.staticSearchStrRangeEnd(siteRequest_, (String)o);
    case "rangeStart":
      return ComputatePageLayout.staticSearchStrRangeStart(siteRequest_, (String)o);
    case "defaultRangeStats":
      return ComputatePageLayout.staticSearchStrDefaultRangeStats(siteRequest_, (String)o);
    case "defaultRangeGap":
      return ComputatePageLayout.staticSearchStrDefaultRangeGap(siteRequest_, (String)o);
    case "defaultRangeEnd":
      return ComputatePageLayout.staticSearchStrDefaultRangeEnd(siteRequest_, (String)o);
    case "defaultRangeStart":
      return ComputatePageLayout.staticSearchStrDefaultRangeStart(siteRequest_, (String)o);
    case "defaultRangeVar":
      return ComputatePageLayout.staticSearchStrDefaultRangeVar(siteRequest_, (String)o);
    case "defaultFacetSort":
      return ComputatePageLayout.staticSearchStrDefaultFacetSort(siteRequest_, (String)o);
    case "defaultFacetLimit":
      return ComputatePageLayout.staticSearchStrDefaultFacetLimit(siteRequest_, (Integer)o);
    case "defaultFacetMinCount":
      return ComputatePageLayout.staticSearchStrDefaultFacetMinCount(siteRequest_, (Integer)o);
    case "defaultPivotMinCount":
      return ComputatePageLayout.staticSearchStrDefaultPivotMinCount(siteRequest_, (Integer)o);
    case "DEFAULT_MAP_LOCATION":
      return ComputatePageLayout.staticSearchStrDEFAULT_MAP_LOCATION(siteRequest_, (String)o);
    case "DEFAULT_MAP_ZOOM":
      return ComputatePageLayout.staticSearchStrDEFAULT_MAP_ZOOM(siteRequest_, (Double)o);
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
    case "facebookGraphVersion":
      return ComputatePageLayout.staticSearchFqFacebookGraphVersion(siteRequest_, o);
    case "facebookAppId":
      return ComputatePageLayout.staticSearchFqFacebookAppId(siteRequest_, o);
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
    case "classSimpleName":
      return ComputatePageLayout.staticSearchFqClassSimpleName(siteRequest_, o);
    case "pageTitle":
      return ComputatePageLayout.staticSearchFqPageTitle(siteRequest_, o);
    case "scopes":
      return ComputatePageLayout.staticSearchFqScopes(siteRequest_, o);
    case "roleRequired":
      return ComputatePageLayout.staticSearchFqRoleRequired(siteRequest_, o);
    case "authRoleAdmin":
      return ComputatePageLayout.staticSearchFqAuthRoleAdmin(siteRequest_, o);
    case "authRoleSuperAdmin":
      return ComputatePageLayout.staticSearchFqAuthRoleSuperAdmin(siteRequest_, o);
    case "pagination":
      return ComputatePageLayout.staticSearchFqPagination(siteRequest_, o);
    case "defaultSortVars":
      return ComputatePageLayout.staticSearchFqDefaultSortVars(siteRequest_, o);
    case "defaultFieldListVars":
      return ComputatePageLayout.staticSearchFqDefaultFieldListVars(siteRequest_, o);
    case "defaultStatsVars":
      return ComputatePageLayout.staticSearchFqDefaultStatsVars(siteRequest_, o);
    case "defaultPivotVars":
      return ComputatePageLayout.staticSearchFqDefaultPivotVars(siteRequest_, o);
    case "varsQ":
      return ComputatePageLayout.staticSearchFqVarsQ(siteRequest_, o);
    case "varsFq":
      return ComputatePageLayout.staticSearchFqVarsFq(siteRequest_, o);
    case "varsRange":
      return ComputatePageLayout.staticSearchFqVarsRange(siteRequest_, o);
    case "query":
      return ComputatePageLayout.staticSearchFqQuery(siteRequest_, o);
    case "pageResponse":
      return ComputatePageLayout.staticSearchFqPageResponse(siteRequest_, o);
    case "defaultZoneId":
      return ComputatePageLayout.staticSearchFqDefaultZoneId(siteRequest_, o);
    case "defaultLocaleId":
      return ComputatePageLayout.staticSearchFqDefaultLocaleId(siteRequest_, o);
    case "rows":
      return ComputatePageLayout.staticSearchFqRows(siteRequest_, o);
    case "start":
      return ComputatePageLayout.staticSearchFqStart(siteRequest_, o);
    case "rangeGap":
      return ComputatePageLayout.staticSearchFqRangeGap(siteRequest_, o);
    case "rangeEnd":
      return ComputatePageLayout.staticSearchFqRangeEnd(siteRequest_, o);
    case "rangeStart":
      return ComputatePageLayout.staticSearchFqRangeStart(siteRequest_, o);
    case "defaultRangeStats":
      return ComputatePageLayout.staticSearchFqDefaultRangeStats(siteRequest_, o);
    case "defaultRangeGap":
      return ComputatePageLayout.staticSearchFqDefaultRangeGap(siteRequest_, o);
    case "defaultRangeEnd":
      return ComputatePageLayout.staticSearchFqDefaultRangeEnd(siteRequest_, o);
    case "defaultRangeStart":
      return ComputatePageLayout.staticSearchFqDefaultRangeStart(siteRequest_, o);
    case "defaultRangeVar":
      return ComputatePageLayout.staticSearchFqDefaultRangeVar(siteRequest_, o);
    case "defaultFacetSort":
      return ComputatePageLayout.staticSearchFqDefaultFacetSort(siteRequest_, o);
    case "defaultFacetLimit":
      return ComputatePageLayout.staticSearchFqDefaultFacetLimit(siteRequest_, o);
    case "defaultFacetMinCount":
      return ComputatePageLayout.staticSearchFqDefaultFacetMinCount(siteRequest_, o);
    case "defaultPivotMinCount":
      return ComputatePageLayout.staticSearchFqDefaultPivotMinCount(siteRequest_, o);
    case "DEFAULT_MAP_LOCATION":
      return ComputatePageLayout.staticSearchFqDEFAULT_MAP_LOCATION(siteRequest_, o);
    case "DEFAULT_MAP_ZOOM":
      return ComputatePageLayout.staticSearchFqDEFAULT_MAP_ZOOM(siteRequest_, o);
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
  public static final String CLASS_CANONICAL_NAME = "org.computate.vertx.page.ComputatePageLayout";
  public static final String CLASS_AUTH_RESOURCE = "";
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
  public static final String VAR_facebookGraphVersion = "facebookGraphVersion";
  public static final String VAR_facebookAppId = "facebookAppId";
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
  public static final String VAR_promiseBefore = "promiseBefore";
  public static final String VAR_classSimpleName = "classSimpleName";
  public static final String VAR_pageTitle = "pageTitle";
  public static final String VAR_scopes = "scopes";
  public static final String VAR_roleRequired = "roleRequired";
  public static final String VAR_authRoleAdmin = "authRoleAdmin";
  public static final String VAR_authRoleSuperAdmin = "authRoleSuperAdmin";
  public static final String VAR_stats = "stats";
  public static final String VAR_facetCounts = "facetCounts";
  public static final String VAR_pagination = "pagination";
  public static final String VAR_defaultSortVars = "defaultSortVars";
  public static final String VAR_defaultFieldListVars = "defaultFieldListVars";
  public static final String VAR_defaultStatsVars = "defaultStatsVars";
  public static final String VAR_defaultPivotVars = "defaultPivotVars";
  public static final String VAR_varsQ = "varsQ";
  public static final String VAR_varsFq = "varsFq";
  public static final String VAR_varsRange = "varsRange";
  public static final String VAR_query = "query";
  public static final String VAR_pageResponse = "pageResponse";
  public static final String VAR_defaultZoneId = "defaultZoneId";
  public static final String VAR_defaultTimeZone = "defaultTimeZone";
  public static final String VAR_defaultLocaleId = "defaultLocaleId";
  public static final String VAR_rows = "rows";
  public static final String VAR_start = "start";
  public static final String VAR_defaultLocale = "defaultLocale";
  public static final String VAR_rangeGap = "rangeGap";
  public static final String VAR_rangeEnd = "rangeEnd";
  public static final String VAR_rangeStart = "rangeStart";
  public static final String VAR_defaultRangeStats = "defaultRangeStats";
  public static final String VAR_defaultRangeGap = "defaultRangeGap";
  public static final String VAR_defaultRangeEnd = "defaultRangeEnd";
  public static final String VAR_defaultRangeStart = "defaultRangeStart";
  public static final String VAR_defaultRangeVar = "defaultRangeVar";
  public static final String VAR_defaultFacetSort = "defaultFacetSort";
  public static final String VAR_defaultFacetLimit = "defaultFacetLimit";
  public static final String VAR_defaultFacetMinCount = "defaultFacetMinCount";
  public static final String VAR_defaultPivotMinCount = "defaultPivotMinCount";
  public static final String VAR_DEFAULT_MAP_LOCATION = "DEFAULT_MAP_LOCATION";
  public static final String VAR_DEFAULT_MAP_ZOOM = "DEFAULT_MAP_ZOOM";
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
  public static final String DISPLAY_NAME_facebookGraphVersion = "";
  public static final String DISPLAY_NAME_facebookAppId = "";
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
  public static final String DISPLAY_NAME_promiseBefore = "";
  public static final String DISPLAY_NAME_classSimpleName = "";
  public static final String DISPLAY_NAME_pageTitle = "";
  public static final String DISPLAY_NAME_scopes = "";
  public static final String DISPLAY_NAME_roleRequired = "";
  public static final String DISPLAY_NAME_authRoleAdmin = "";
  public static final String DISPLAY_NAME_authRoleSuperAdmin = "";
  public static final String DISPLAY_NAME_stats = "";
  public static final String DISPLAY_NAME_facetCounts = "";
  public static final String DISPLAY_NAME_pagination = "";
  public static final String DISPLAY_NAME_defaultSortVars = "";
  public static final String DISPLAY_NAME_defaultFieldListVars = "";
  public static final String DISPLAY_NAME_defaultStatsVars = "";
  public static final String DISPLAY_NAME_defaultPivotVars = "";
  public static final String DISPLAY_NAME_varsQ = "";
  public static final String DISPLAY_NAME_varsFq = "";
  public static final String DISPLAY_NAME_varsRange = "";
  public static final String DISPLAY_NAME_query = "";
  public static final String DISPLAY_NAME_pageResponse = "";
  public static final String DISPLAY_NAME_defaultZoneId = "";
  public static final String DISPLAY_NAME_defaultTimeZone = "";
  public static final String DISPLAY_NAME_defaultLocaleId = "";
  public static final String DISPLAY_NAME_rows = "";
  public static final String DISPLAY_NAME_start = "";
  public static final String DISPLAY_NAME_defaultLocale = "";
  public static final String DISPLAY_NAME_rangeGap = "";
  public static final String DISPLAY_NAME_rangeEnd = "";
  public static final String DISPLAY_NAME_rangeStart = "";
  public static final String DISPLAY_NAME_defaultRangeStats = "";
  public static final String DISPLAY_NAME_defaultRangeGap = "";
  public static final String DISPLAY_NAME_defaultRangeEnd = "";
  public static final String DISPLAY_NAME_defaultRangeStart = "";
  public static final String DISPLAY_NAME_defaultRangeVar = "";
  public static final String DISPLAY_NAME_defaultFacetSort = "";
  public static final String DISPLAY_NAME_defaultFacetLimit = "";
  public static final String DISPLAY_NAME_defaultFacetMinCount = "";
  public static final String DISPLAY_NAME_defaultPivotMinCount = "";
  public static final String DISPLAY_NAME_DEFAULT_MAP_LOCATION = "";
  public static final String DISPLAY_NAME_DEFAULT_MAP_ZOOM = "";
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

  public String idForClass() {
    return null;
  }

  public String titleForClass() {
    return null;
  }

  public String nameForClass() {
    return null;
  }

  public String classNameAdjectiveSingularForClass() {
    return null;
  }

  public String descriptionForClass() {
    return null;
  }

  public String classStringFormatUrlEditPageForClass() {
    return null;
  }

  public String classStringFormatUrlDisplayPageForClass() {
    return null;
  }

  public String classStringFormatUrlUserPageForClass() {
    return null;
  }

  public String classStringFormatUrlDownloadForClass() {
    return null;
  }

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
    case VAR_facebookGraphVersion:
      return DISPLAY_NAME_facebookGraphVersion;
    case VAR_facebookAppId:
      return DISPLAY_NAME_facebookAppId;
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
    case VAR_promiseBefore:
      return DISPLAY_NAME_promiseBefore;
    case VAR_classSimpleName:
      return DISPLAY_NAME_classSimpleName;
    case VAR_pageTitle:
      return DISPLAY_NAME_pageTitle;
    case VAR_scopes:
      return DISPLAY_NAME_scopes;
    case VAR_roleRequired:
      return DISPLAY_NAME_roleRequired;
    case VAR_authRoleAdmin:
      return DISPLAY_NAME_authRoleAdmin;
    case VAR_authRoleSuperAdmin:
      return DISPLAY_NAME_authRoleSuperAdmin;
    case VAR_stats:
      return DISPLAY_NAME_stats;
    case VAR_facetCounts:
      return DISPLAY_NAME_facetCounts;
    case VAR_pagination:
      return DISPLAY_NAME_pagination;
    case VAR_defaultSortVars:
      return DISPLAY_NAME_defaultSortVars;
    case VAR_defaultFieldListVars:
      return DISPLAY_NAME_defaultFieldListVars;
    case VAR_defaultStatsVars:
      return DISPLAY_NAME_defaultStatsVars;
    case VAR_defaultPivotVars:
      return DISPLAY_NAME_defaultPivotVars;
    case VAR_varsQ:
      return DISPLAY_NAME_varsQ;
    case VAR_varsFq:
      return DISPLAY_NAME_varsFq;
    case VAR_varsRange:
      return DISPLAY_NAME_varsRange;
    case VAR_query:
      return DISPLAY_NAME_query;
    case VAR_pageResponse:
      return DISPLAY_NAME_pageResponse;
    case VAR_defaultZoneId:
      return DISPLAY_NAME_defaultZoneId;
    case VAR_defaultTimeZone:
      return DISPLAY_NAME_defaultTimeZone;
    case VAR_defaultLocaleId:
      return DISPLAY_NAME_defaultLocaleId;
    case VAR_rows:
      return DISPLAY_NAME_rows;
    case VAR_start:
      return DISPLAY_NAME_start;
    case VAR_defaultLocale:
      return DISPLAY_NAME_defaultLocale;
    case VAR_rangeGap:
      return DISPLAY_NAME_rangeGap;
    case VAR_rangeEnd:
      return DISPLAY_NAME_rangeEnd;
    case VAR_rangeStart:
      return DISPLAY_NAME_rangeStart;
    case VAR_defaultRangeStats:
      return DISPLAY_NAME_defaultRangeStats;
    case VAR_defaultRangeGap:
      return DISPLAY_NAME_defaultRangeGap;
    case VAR_defaultRangeEnd:
      return DISPLAY_NAME_defaultRangeEnd;
    case VAR_defaultRangeStart:
      return DISPLAY_NAME_defaultRangeStart;
    case VAR_defaultRangeVar:
      return DISPLAY_NAME_defaultRangeVar;
    case VAR_defaultFacetSort:
      return DISPLAY_NAME_defaultFacetSort;
    case VAR_defaultFacetLimit:
      return DISPLAY_NAME_defaultFacetLimit;
    case VAR_defaultFacetMinCount:
      return DISPLAY_NAME_defaultFacetMinCount;
    case VAR_defaultPivotMinCount:
      return DISPLAY_NAME_defaultPivotMinCount;
    case VAR_DEFAULT_MAP_LOCATION:
      return DISPLAY_NAME_DEFAULT_MAP_LOCATION;
    case VAR_DEFAULT_MAP_ZOOM:
      return DISPLAY_NAME_DEFAULT_MAP_ZOOM;
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

  public static String descriptionComputatePageLayout(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_siteRequest_:
      return "The current request object";
    case VAR_lang:
      return "The current request language";
    case VAR_requestVars:
      return "The current request vars";
    case VAR_config:
      return "the site configuration";
    case VAR_serviceRequest:
      return "The current Vert.x service request";
    case VAR_pageUri:
      return "The current request URI";
    case VAR_pageId:
      return "The current page name";
    case VAR_apiUri:
      return "The API request URI";
    case VAR_pageMethod:
      return "The current request HTTP method";
    case VAR_params:
      return "The current request parameters";
    case VAR_userKey:
      return "The current user's primary key";
    case VAR_userFullName:
      return "The current user's full name";
    case VAR_userName:
      return "The current user's username";
    case VAR_userEmail:
      return "The current user's email";
    case VAR_logoutUrl:
      return "The logout URL";
    case VAR_promiseBefore:
      return "A method that can be overridden at the start of the request that makes this main template be initialized with a Vert.x promise for reactive initialization";
    case VAR_classSimpleName:
      return "The simple name of this Java class";
    case VAR_pageTitle:
      return "The page title to override";
    case VAR_scopes:
      return "The user's roles";
    case VAR_roleRequired:
      return "The required roles to access this page";
    case VAR_authRoleAdmin:
      return "The admin roles required to access this page";
    case VAR_authRoleSuperAdmin:
      return "The super-admin roles required to access this page";
    case VAR_pagination:
      return "The pagination data about this request";
    case VAR_query:
      return "The query data about this request";
    case VAR_queryStr:
      return "The query String for this request";
    case VAR_promiseAfter:
      return "A method that can be overridden at the end of the request that makes this main template be initialized with a Vert.x promise for reactive initialization";
    case VAR_pageImageUri:
      return "The image URI for this page";
    case VAR_pageImageWidth:
      return "The image width";
    case VAR_pageImageHeight:
      return "The image height";
    case VAR_pageVideoId:
      return "The video ID for this page";
    case VAR_classIconGroup:
      return "The icon group for this page";
    case VAR_classIconName:
      return "The icon name for this page";
    case VAR_classIconCssClasses:
      return "The icon CSS classes for this page";
    case VAR_pageDescription:
      return "An optional description field for the page";
      default:
        return null;
    }
  }

  public static String classSimpleNameComputatePageLayout(String var) {
    switch(var) {
    case VAR_siteRequest_:
      return "ComputateSiteRequest";
    case VAR_lang:
      return "String";
    case VAR_requestVars:
      return "Map";
    case VAR_config:
      return "JsonObject";
    case VAR_serviceRequest:
      return "ServiceRequest";
    case VAR_staticBaseUrl:
      return "String";
    case VAR_siteBaseUrl:
      return "String";
    case VAR_siteAuthUrl:
      return "String";
    case VAR_siteAuthRealm:
      return "String";
    case VAR_fontAwesomeKit:
      return "String";
    case VAR_facebookGraphVersion:
      return "String";
    case VAR_facebookAppId:
      return "String";
    case VAR_pageUri:
      return "String";
    case VAR_pageId:
      return "String";
    case VAR_apiUri:
      return "String";
    case VAR_pageMethod:
      return "String";
    case VAR_params:
      return "JsonObject";
    case VAR_userKey:
      return "Long";
    case VAR_userFullName:
      return "String";
    case VAR_userName:
      return "String";
    case VAR_userEmail:
      return "String";
    case VAR_logoutUrl:
      return "String";
    case VAR_promiseBefore:
      return "Void";
    case VAR_classSimpleName:
      return "String";
    case VAR_pageTitle:
      return "String";
    case VAR_scopes:
      return "List";
    case VAR_roleRequired:
      return "List";
    case VAR_authRoleAdmin:
      return "List";
    case VAR_authRoleSuperAdmin:
      return "List";
    case VAR_stats:
      return "Stats";
    case VAR_facetCounts:
      return "FacetCounts";
    case VAR_pagination:
      return "JsonObject";
    case VAR_defaultSortVars:
      return "List";
    case VAR_defaultFieldListVars:
      return "List";
    case VAR_defaultStatsVars:
      return "List";
    case VAR_defaultPivotVars:
      return "List";
    case VAR_varsQ:
      return "JsonObject";
    case VAR_varsFq:
      return "JsonObject";
    case VAR_varsRange:
      return "JsonObject";
    case VAR_query:
      return "JsonObject";
    case VAR_pageResponse:
      return "String";
    case VAR_defaultZoneId:
      return "String";
    case VAR_defaultTimeZone:
      return "ZoneId";
    case VAR_defaultLocaleId:
      return "String";
    case VAR_rows:
      return "Long";
    case VAR_start:
      return "Long";
    case VAR_defaultLocale:
      return "Locale";
    case VAR_rangeGap:
      return "String";
    case VAR_rangeEnd:
      return "ZonedDateTime";
    case VAR_rangeStart:
      return "ZonedDateTime";
    case VAR_defaultRangeStats:
      return "JsonObject";
    case VAR_defaultRangeGap:
      return "String";
    case VAR_defaultRangeEnd:
      return "ZonedDateTime";
    case VAR_defaultRangeStart:
      return "ZonedDateTime";
    case VAR_defaultRangeVar:
      return "String";
    case VAR_defaultFacetSort:
      return "String";
    case VAR_defaultFacetLimit:
      return "Integer";
    case VAR_defaultFacetMinCount:
      return "Integer";
    case VAR_defaultPivotMinCount:
      return "Integer";
    case VAR_DEFAULT_MAP_LOCATION:
      return "JsonObject";
    case VAR_DEFAULT_MAP_ZOOM:
      return "BigDecimal";
    case VAR_queryStr:
      return "String";
    case VAR_promiseAfter:
      return "Void";
    case VAR_pageImageUri:
      return "String";
    case VAR_pageImageWidth:
      return "Integer";
    case VAR_pageImageHeight:
      return "Integer";
    case VAR_pageVideoId:
      return "String";
    case VAR_classIconGroup:
      return "String";
    case VAR_classIconName:
      return "String";
    case VAR_classIconCssClasses:
      return "String";
    case VAR_pageDescription:
      return "String";
      default:
        return null;
    }
  }

  public static Integer htmColumnComputatePageLayout(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer htmRowComputatePageLayout(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer htmCellComputatePageLayout(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer lengthMinComputatePageLayout(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer lengthMaxComputatePageLayout(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer maxComputatePageLayout(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer minComputatePageLayout(String var) {
    switch(var) {
      default:
        return null;
    }
  }
}
