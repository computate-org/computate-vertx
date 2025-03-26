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
package org.computate.vertx.openapi;

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
import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.json.JsonObject;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.lang.String;
import java.lang.Integer;
import java.io.File;
import org.computate.vertx.writer.AllWriter;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these BaseGenerator objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class BaseGeneratorGen into the class BaseGenerator. 
 * </li>
 * <h3>About the BaseGenerator class and it's generated class BaseGeneratorGen&lt;Object&gt;: </h3>extends BaseGeneratorGen
 * <p>
 * This Java class extends a generated Java class BaseGeneratorGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator">Find the class BaseGenerator in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends BaseGeneratorGen<Object>
 * <p>This <code>class BaseGenerator extends BaseGeneratorGen&lt;Object&gt;</code>, which means it extends a newly generated BaseGeneratorGen. 
 * The generated <code>class BaseGeneratorGen extends Object</code> which means that BaseGenerator extends BaseGeneratorGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the BaseGenerator class will inherit the helpful inherited class comments from the super class BaseGeneratorGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class BaseGenerator in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.openapi in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.openapi&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class BaseGeneratorGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(BaseGenerator.class);

	////////////
	// vertx_ //
	////////////


	/**	 The entity vertx_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Vertx vertx_;

	/**	<br> The entity vertx_
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:vertx_">Find the entity vertx_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _vertx_(Wrap<Vertx> w);

	public Vertx getVertx_() {
		return vertx_;
	}

	public void setVertx_(Vertx vertx_) {
		this.vertx_ = vertx_;
	}
	public static Vertx staticSetVertx_(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator vertx_Init() {
		Wrap<Vertx> vertx_Wrap = new Wrap<Vertx>().var("vertx_");
		if(vertx_ == null) {
			_vertx_(vertx_Wrap);
			Optional.ofNullable(vertx_Wrap.getO()).ifPresent(o -> {
				setVertx_(o);
			});
		}
		return (BaseGenerator)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:webClient">Find the entity webClient in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _webClient(Wrap<WebClient> w);

	public WebClient getWebClient() {
		return webClient;
	}

	public void setWebClient(WebClient webClient) {
		this.webClient = webClient;
	}
	public static WebClient staticSetWebClient(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator webClientInit() {
		Wrap<WebClient> webClientWrap = new Wrap<WebClient>().var("webClient");
		if(webClient == null) {
			_webClient(webClientWrap);
			Optional.ofNullable(webClientWrap.getO()).ifPresent(o -> {
				setWebClient(o);
			});
		}
		return (BaseGenerator)this;
	}

	//////////////////
	// siteRequest_ //
	//////////////////


	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<ComputateSiteRequest> c);

	public ComputateSiteRequest getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(ComputateSiteRequest siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static ComputateSiteRequest staticSetSiteRequest_(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator siteRequest_Init() {
		Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			Optional.ofNullable(siteRequest_Wrap.getO()).ifPresent(o -> {
				setSiteRequest_(o);
			});
		}
		return (BaseGenerator)this;
	}

	////////////
	// config //
	////////////


	/**	 The entity config
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonObjectDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonObject config;

	/**	<br> The entity config
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:config">Find the entity config in Solr</a>
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
	@JsonIgnore
	public void setConfig(String o) {
		this.config = BaseGenerator.staticSetConfig(siteRequest_, o);
	}
	public static JsonObject staticSetConfig(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected BaseGenerator configInit() {
		Wrap<JsonObject> configWrap = new Wrap<JsonObject>().var("config");
		if(config == null) {
			_config(configWrap);
			Optional.ofNullable(configWrap.getO()).ifPresent(o -> {
				setConfig(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchConfig(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrConfig(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqConfig(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchConfig(siteRequest_, BaseGenerator.staticSetConfig(siteRequest_, o)).toString();
	}

	/////////////
	// appName //
	/////////////


	/**	 The entity appName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String appName;

	/**	<br> The entity appName
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:appName">Find the entity appName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _appName(Wrap<String> c);

	public String getAppName() {
		return appName;
	}
	public void setAppName(String o) {
		this.appName = BaseGenerator.staticSetAppName(siteRequest_, o);
	}
	public static String staticSetAppName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator appNameInit() {
		Wrap<String> appNameWrap = new Wrap<String>().var("appName");
		if(appName == null) {
			_appName(appNameWrap);
			Optional.ofNullable(appNameWrap.getO()).ifPresent(o -> {
				setAppName(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchAppName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAppName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAppName(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchAppName(siteRequest_, BaseGenerator.staticSetAppName(siteRequest_, o)).toString();
	}

	//////////////////
	// languageName //
	//////////////////


	/**	 The entity languageName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String languageName;

	/**	<br> The entity languageName
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:languageName">Find the entity languageName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _languageName(Wrap<String> c);

	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String o) {
		this.languageName = BaseGenerator.staticSetLanguageName(siteRequest_, o);
	}
	public static String staticSetLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator languageNameInit() {
		Wrap<String> languageNameWrap = new Wrap<String>().var("languageName");
		if(languageName == null) {
			_languageName(languageNameWrap);
			Optional.ofNullable(languageNameWrap.getO()).ifPresent(o -> {
				setLanguageName(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchLanguageName(siteRequest_, BaseGenerator.staticSetLanguageName(siteRequest_, o)).toString();
	}

	///////////////////////
	// computateVertxSrc //
	///////////////////////


	/**	 The entity computateVertxSrc
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String computateVertxSrc;

	/**	<br> The entity computateVertxSrc
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:computateVertxSrc">Find the entity computateVertxSrc in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _computateVertxSrc(Wrap<String> c);

	public String getComputateVertxSrc() {
		return computateVertxSrc;
	}
	public void setComputateVertxSrc(String o) {
		this.computateVertxSrc = BaseGenerator.staticSetComputateVertxSrc(siteRequest_, o);
	}
	public static String staticSetComputateVertxSrc(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator computateVertxSrcInit() {
		Wrap<String> computateVertxSrcWrap = new Wrap<String>().var("computateVertxSrc");
		if(computateVertxSrc == null) {
			_computateVertxSrc(computateVertxSrcWrap);
			Optional.ofNullable(computateVertxSrcWrap.getO()).ifPresent(o -> {
				setComputateVertxSrc(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchComputateVertxSrc(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrComputateVertxSrc(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqComputateVertxSrc(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchComputateVertxSrc(siteRequest_, BaseGenerator.staticSetComputateVertxSrc(siteRequest_, o)).toString();
	}

	//////////
	// i18n //
	//////////


	/**	 The entity i18n
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = JsonObjectDeserializer.class)
	@JsonInclude(Include.NON_NULL)
	protected JsonObject i18n;

	/**	<br> The entity i18n
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:i18n">Find the entity i18n in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _i18n(Wrap<JsonObject> w);

	public JsonObject getI18n() {
		return i18n;
	}

	public void setI18n(JsonObject i18n) {
		this.i18n = i18n;
	}
	@JsonIgnore
	public void setI18n(String o) {
		this.i18n = BaseGenerator.staticSetI18n(siteRequest_, o);
	}
	public static JsonObject staticSetI18n(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected BaseGenerator i18nInit() {
		Wrap<JsonObject> i18nWrap = new Wrap<JsonObject>().var("i18n");
		if(i18n == null) {
			_i18n(i18nWrap);
			Optional.ofNullable(i18nWrap.getO()).ifPresent(o -> {
				setI18n(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchI18n(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrI18n(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqI18n(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchI18n(siteRequest_, BaseGenerator.staticSetI18n(siteRequest_, o)).toString();
	}

	/////////////
	// appPath //
	/////////////


	/**	 The entity appPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String appPath;

	/**	<br> The entity appPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:appPath">Find the entity appPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _appPath(Wrap<String> c);

	public String getAppPath() {
		return appPath;
	}
	public void setAppPath(String o) {
		this.appPath = BaseGenerator.staticSetAppPath(siteRequest_, o);
	}
	public static String staticSetAppPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator appPathInit() {
		Wrap<String> appPathWrap = new Wrap<String>().var("appPath");
		if(appPath == null) {
			_appPath(appPathWrap);
			Optional.ofNullable(appPathWrap.getO()).ifPresent(o -> {
				setAppPath(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchAppPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAppPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAppPath(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchAppPath(siteRequest_, BaseGenerator.staticSetAppPath(siteRequest_, o)).toString();
	}

	///////////////////
	// appStaticPath //
	///////////////////


	/**	 The entity appStaticPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String appStaticPath;

	/**	<br> The entity appStaticPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:appStaticPath">Find the entity appStaticPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _appStaticPath(Wrap<String> c);

	public String getAppStaticPath() {
		return appStaticPath;
	}
	public void setAppStaticPath(String o) {
		this.appStaticPath = BaseGenerator.staticSetAppStaticPath(siteRequest_, o);
	}
	public static String staticSetAppStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator appStaticPathInit() {
		Wrap<String> appStaticPathWrap = new Wrap<String>().var("appStaticPath");
		if(appStaticPath == null) {
			_appStaticPath(appStaticPathWrap);
			Optional.ofNullable(appStaticPathWrap.getO()).ifPresent(o -> {
				setAppStaticPath(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchAppStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAppStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAppStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchAppStaticPath(siteRequest_, BaseGenerator.staticSetAppStaticPath(siteRequest_, o)).toString();
	}

	///////////////////////////
	// platformPomArtifactId //
	///////////////////////////


	/**	 The entity platformPomArtifactId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String platformPomArtifactId;

	/**	<br> The entity platformPomArtifactId
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:platformPomArtifactId">Find the entity platformPomArtifactId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _platformPomArtifactId(Wrap<String> w);

	public String getPlatformPomArtifactId() {
		return platformPomArtifactId;
	}
	public void setPlatformPomArtifactId(String o) {
		this.platformPomArtifactId = BaseGenerator.staticSetPlatformPomArtifactId(siteRequest_, o);
	}
	public static String staticSetPlatformPomArtifactId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator platformPomArtifactIdInit() {
		Wrap<String> platformPomArtifactIdWrap = new Wrap<String>().var("platformPomArtifactId");
		if(platformPomArtifactId == null) {
			_platformPomArtifactId(platformPomArtifactIdWrap);
			Optional.ofNullable(platformPomArtifactIdWrap.getO()).ifPresent(o -> {
				setPlatformPomArtifactId(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchPlatformPomArtifactId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPlatformPomArtifactId(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPlatformPomArtifactId(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchPlatformPomArtifactId(siteRequest_, BaseGenerator.staticSetPlatformPomArtifactId(siteRequest_, o)).toString();
	}

	////////////////////
	// openApiVersion //
	////////////////////


	/**	 The entity openApiVersion
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String openApiVersion;

	/**	<br> The entity openApiVersion
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:openApiVersion">Find the entity openApiVersion in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _openApiVersion(Wrap<String> c);

	public String getOpenApiVersion() {
		return openApiVersion;
	}
	public void setOpenApiVersion(String o) {
		this.openApiVersion = BaseGenerator.staticSetOpenApiVersion(siteRequest_, o);
	}
	public static String staticSetOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator openApiVersionInit() {
		Wrap<String> openApiVersionWrap = new Wrap<String>().var("openApiVersion");
		if(openApiVersion == null) {
			_openApiVersion(openApiVersionWrap);
			Optional.ofNullable(openApiVersionWrap.getO()).ifPresent(o -> {
				setOpenApiVersion(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchOpenApiVersion(siteRequest_, BaseGenerator.staticSetOpenApiVersion(siteRequest_, o)).toString();
	}

	//////////////////////////
	// openApiVersionNumber //
	//////////////////////////


	/**	 The entity openApiVersionNumber
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer openApiVersionNumber;

	/**	<br> The entity openApiVersionNumber
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:openApiVersionNumber">Find the entity openApiVersionNumber in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _openApiVersionNumber(Wrap<Integer> c);

	public Integer getOpenApiVersionNumber() {
		return openApiVersionNumber;
	}

	public void setOpenApiVersionNumber(Integer openApiVersionNumber) {
		this.openApiVersionNumber = openApiVersionNumber;
	}
	@JsonIgnore
	public void setOpenApiVersionNumber(String o) {
		this.openApiVersionNumber = BaseGenerator.staticSetOpenApiVersionNumber(siteRequest_, o);
	}
	public static Integer staticSetOpenApiVersionNumber(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected BaseGenerator openApiVersionNumberInit() {
		Wrap<Integer> openApiVersionNumberWrap = new Wrap<Integer>().var("openApiVersionNumber");
		if(openApiVersionNumber == null) {
			_openApiVersionNumber(openApiVersionNumberWrap);
			Optional.ofNullable(openApiVersionNumberWrap.getO()).ifPresent(o -> {
				setOpenApiVersionNumber(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static Integer staticSearchOpenApiVersionNumber(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrOpenApiVersionNumber(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiVersionNumber(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchOpenApiVersionNumber(siteRequest_, BaseGenerator.staticSetOpenApiVersionNumber(siteRequest_, o)).toString();
	}

	////////////////
	// tabsSchema //
	////////////////


	/**	 The entity tabsSchema
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer tabsSchema;

	/**	<br> The entity tabsSchema
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:tabsSchema">Find the entity tabsSchema in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _tabsSchema(Wrap<Integer> c);

	public Integer getTabsSchema() {
		return tabsSchema;
	}

	public void setTabsSchema(Integer tabsSchema) {
		this.tabsSchema = tabsSchema;
	}
	@JsonIgnore
	public void setTabsSchema(String o) {
		this.tabsSchema = BaseGenerator.staticSetTabsSchema(siteRequest_, o);
	}
	public static Integer staticSetTabsSchema(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected BaseGenerator tabsSchemaInit() {
		Wrap<Integer> tabsSchemaWrap = new Wrap<Integer>().var("tabsSchema");
		if(tabsSchema == null) {
			_tabsSchema(tabsSchemaWrap);
			Optional.ofNullable(tabsSchemaWrap.getO()).ifPresent(o -> {
				setTabsSchema(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static Integer staticSearchTabsSchema(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTabsSchema(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTabsSchema(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchTabsSchema(siteRequest_, BaseGenerator.staticSetTabsSchema(siteRequest_, o)).toString();
	}

	////////////////
	// apiVersion //
	////////////////


	/**	 The entity apiVersion
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String apiVersion;

	/**	<br> The entity apiVersion
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:apiVersion">Find the entity apiVersion in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _apiVersion(Wrap<String> c);

	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String o) {
		this.apiVersion = BaseGenerator.staticSetApiVersion(siteRequest_, o);
	}
	public static String staticSetApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator apiVersionInit() {
		Wrap<String> apiVersionWrap = new Wrap<String>().var("apiVersion");
		if(apiVersion == null) {
			_apiVersion(apiVersionWrap);
			Optional.ofNullable(apiVersionWrap.getO()).ifPresent(o -> {
				setApiVersion(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchApiVersion(siteRequest_, BaseGenerator.staticSetApiVersion(siteRequest_, o)).toString();
	}

	/////////////////////
	// openApiYamlPath //
	/////////////////////


	/**	 The entity openApiYamlPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String openApiYamlPath;

	/**	<br> The entity openApiYamlPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:openApiYamlPath">Find the entity openApiYamlPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _openApiYamlPath(Wrap<String> c);

	public String getOpenApiYamlPath() {
		return openApiYamlPath;
	}
	public void setOpenApiYamlPath(String o) {
		this.openApiYamlPath = BaseGenerator.staticSetOpenApiYamlPath(siteRequest_, o);
	}
	public static String staticSetOpenApiYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator openApiYamlPathInit() {
		Wrap<String> openApiYamlPathWrap = new Wrap<String>().var("openApiYamlPath");
		if(openApiYamlPath == null) {
			_openApiYamlPath(openApiYamlPathWrap);
			Optional.ofNullable(openApiYamlPathWrap.getO()).ifPresent(o -> {
				setOpenApiYamlPath(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchOpenApiYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrOpenApiYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchOpenApiYamlPath(siteRequest_, BaseGenerator.staticSetOpenApiYamlPath(siteRequest_, o)).toString();
	}

	/////////////////////
	// openApiYamlFile //
	/////////////////////


	/**	 The entity openApiYamlFile
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File openApiYamlFile;

	/**	<br> The entity openApiYamlFile
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:openApiYamlFile">Find the entity openApiYamlFile in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _openApiYamlFile(Wrap<File> c);

	public File getOpenApiYamlFile() {
		return openApiYamlFile;
	}

	public void setOpenApiYamlFile(File openApiYamlFile) {
		this.openApiYamlFile = openApiYamlFile;
	}
	public static File staticSetOpenApiYamlFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator openApiYamlFileInit() {
		Wrap<File> openApiYamlFileWrap = new Wrap<File>().var("openApiYamlFile");
		if(openApiYamlFile == null) {
			_openApiYamlFile(openApiYamlFileWrap);
			Optional.ofNullable(openApiYamlFileWrap.getO()).ifPresent(o -> {
				setOpenApiYamlFile(o);
			});
		}
		return (BaseGenerator)this;
	}

	///////////////////
	// sqlCreatePath //
	///////////////////


	/**	 The entity sqlCreatePath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String sqlCreatePath;

	/**	<br> The entity sqlCreatePath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:sqlCreatePath">Find the entity sqlCreatePath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sqlCreatePath(Wrap<String> c);

	public String getSqlCreatePath() {
		return sqlCreatePath;
	}
	public void setSqlCreatePath(String o) {
		this.sqlCreatePath = BaseGenerator.staticSetSqlCreatePath(siteRequest_, o);
	}
	public static String staticSetSqlCreatePath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator sqlCreatePathInit() {
		Wrap<String> sqlCreatePathWrap = new Wrap<String>().var("sqlCreatePath");
		if(sqlCreatePath == null) {
			_sqlCreatePath(sqlCreatePathWrap);
			Optional.ofNullable(sqlCreatePathWrap.getO()).ifPresent(o -> {
				setSqlCreatePath(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchSqlCreatePath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSqlCreatePath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSqlCreatePath(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchSqlCreatePath(siteRequest_, BaseGenerator.staticSetSqlCreatePath(siteRequest_, o)).toString();
	}

	///////////////////
	// sqlCreateFile //
	///////////////////


	/**	 The entity sqlCreateFile
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File sqlCreateFile;

	/**	<br> The entity sqlCreateFile
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:sqlCreateFile">Find the entity sqlCreateFile in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sqlCreateFile(Wrap<File> c);

	public File getSqlCreateFile() {
		return sqlCreateFile;
	}

	public void setSqlCreateFile(File sqlCreateFile) {
		this.sqlCreateFile = sqlCreateFile;
	}
	public static File staticSetSqlCreateFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator sqlCreateFileInit() {
		Wrap<File> sqlCreateFileWrap = new Wrap<File>().var("sqlCreateFile");
		if(sqlCreateFile == null) {
			_sqlCreateFile(sqlCreateFileWrap);
			Optional.ofNullable(sqlCreateFileWrap.getO()).ifPresent(o -> {
				setSqlCreateFile(o);
			});
		}
		return (BaseGenerator)this;
	}

	/////////////////
	// sqlDropPath //
	/////////////////


	/**	 The entity sqlDropPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String sqlDropPath;

	/**	<br> The entity sqlDropPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:sqlDropPath">Find the entity sqlDropPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sqlDropPath(Wrap<String> c);

	public String getSqlDropPath() {
		return sqlDropPath;
	}
	public void setSqlDropPath(String o) {
		this.sqlDropPath = BaseGenerator.staticSetSqlDropPath(siteRequest_, o);
	}
	public static String staticSetSqlDropPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected BaseGenerator sqlDropPathInit() {
		Wrap<String> sqlDropPathWrap = new Wrap<String>().var("sqlDropPath");
		if(sqlDropPath == null) {
			_sqlDropPath(sqlDropPathWrap);
			Optional.ofNullable(sqlDropPathWrap.getO()).ifPresent(o -> {
				setSqlDropPath(o);
			});
		}
		return (BaseGenerator)this;
	}

	public static String staticSearchSqlDropPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSqlDropPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSqlDropPath(ComputateSiteRequest siteRequest_, String o) {
		return BaseGenerator.staticSearchSqlDropPath(siteRequest_, BaseGenerator.staticSetSqlDropPath(siteRequest_, o)).toString();
	}

	/////////////////
	// sqlDropFile //
	/////////////////


	/**	 The entity sqlDropFile
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File sqlDropFile;

	/**	<br> The entity sqlDropFile
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:sqlDropFile">Find the entity sqlDropFile in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sqlDropFile(Wrap<File> c);

	public File getSqlDropFile() {
		return sqlDropFile;
	}

	public void setSqlDropFile(File sqlDropFile) {
		this.sqlDropFile = sqlDropFile;
	}
	public static File staticSetSqlDropFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator sqlDropFileInit() {
		Wrap<File> sqlDropFileWrap = new Wrap<File>().var("sqlDropFile");
		if(sqlDropFile == null) {
			_sqlDropFile(sqlDropFileWrap);
			Optional.ofNullable(sqlDropFileWrap.getO()).ifPresent(o -> {
				setSqlDropFile(o);
			});
		}
		return (BaseGenerator)this;
	}

	///////
	// w //
	///////


	/**	 The entity w
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter w;

	/**	<br> The entity w
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:w">Find the entity w in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _w(Wrap<AllWriter> c);

	public AllWriter getW() {
		return w;
	}

	public void setW(AllWriter w) {
		this.w = w;
	}
	public static AllWriter staticSetW(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator wInit() {
		Wrap<AllWriter> wWrap = new Wrap<AllWriter>().var("w");
		if(w == null) {
			_w(wWrap);
			Optional.ofNullable(wWrap.getO()).ifPresent(o -> {
				setW(o);
			});
		}
		if(w != null)
			w.initDeepForClass(siteRequest_);
		return (BaseGenerator)this;
	}

	////////////////
	// wSqlCreate //
	////////////////


	/**	 The entity wSqlCreate
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wSqlCreate;

	/**	<br> The entity wSqlCreate
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:wSqlCreate">Find the entity wSqlCreate in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wSqlCreate(Wrap<AllWriter> c);

	public AllWriter getWSqlCreate() {
		return wSqlCreate;
	}

	public void setWSqlCreate(AllWriter wSqlCreate) {
		this.wSqlCreate = wSqlCreate;
	}
	public static AllWriter staticSetWSqlCreate(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator wSqlCreateInit() {
		Wrap<AllWriter> wSqlCreateWrap = new Wrap<AllWriter>().var("wSqlCreate");
		if(wSqlCreate == null) {
			_wSqlCreate(wSqlCreateWrap);
			Optional.ofNullable(wSqlCreateWrap.getO()).ifPresent(o -> {
				setWSqlCreate(o);
			});
		}
		if(wSqlCreate != null)
			wSqlCreate.initDeepForClass(siteRequest_);
		return (BaseGenerator)this;
	}

	//////////////
	// wSqlDrop //
	//////////////


	/**	 The entity wSqlDrop
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wSqlDrop;

	/**	<br> The entity wSqlDrop
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:wSqlDrop">Find the entity wSqlDrop in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wSqlDrop(Wrap<AllWriter> c);

	public AllWriter getWSqlDrop() {
		return wSqlDrop;
	}

	public void setWSqlDrop(AllWriter wSqlDrop) {
		this.wSqlDrop = wSqlDrop;
	}
	public static AllWriter staticSetWSqlDrop(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator wSqlDropInit() {
		Wrap<AllWriter> wSqlDropWrap = new Wrap<AllWriter>().var("wSqlDrop");
		if(wSqlDrop == null) {
			_wSqlDrop(wSqlDropWrap);
			Optional.ofNullable(wSqlDropWrap.getO()).ifPresent(o -> {
				setWSqlDrop(o);
			});
		}
		if(wSqlDrop != null)
			wSqlDrop.initDeepForClass(siteRequest_);
		return (BaseGenerator)this;
	}

	////////////
	// wPaths //
	////////////


	/**	 The entity wPaths
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wPaths;

	/**	<br> The entity wPaths
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:wPaths">Find the entity wPaths in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wPaths(Wrap<AllWriter> c);

	public AllWriter getWPaths() {
		return wPaths;
	}

	public void setWPaths(AllWriter wPaths) {
		this.wPaths = wPaths;
	}
	public static AllWriter staticSetWPaths(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator wPathsInit() {
		Wrap<AllWriter> wPathsWrap = new Wrap<AllWriter>().var("wPaths");
		if(wPaths == null) {
			_wPaths(wPathsWrap);
			Optional.ofNullable(wPathsWrap.getO()).ifPresent(o -> {
				setWPaths(o);
			});
		}
		if(wPaths != null)
			wPaths.initDeepForClass(siteRequest_);
		return (BaseGenerator)this;
	}

	////////////////////
	// wRequestBodies //
	////////////////////


	/**	 The entity wRequestBodies
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wRequestBodies;

	/**	<br> The entity wRequestBodies
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:wRequestBodies">Find the entity wRequestBodies in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wRequestBodies(Wrap<AllWriter> c);

	public AllWriter getWRequestBodies() {
		return wRequestBodies;
	}

	public void setWRequestBodies(AllWriter wRequestBodies) {
		this.wRequestBodies = wRequestBodies;
	}
	public static AllWriter staticSetWRequestBodies(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator wRequestBodiesInit() {
		Wrap<AllWriter> wRequestBodiesWrap = new Wrap<AllWriter>().var("wRequestBodies");
		if(wRequestBodies == null) {
			_wRequestBodies(wRequestBodiesWrap);
			Optional.ofNullable(wRequestBodiesWrap.getO()).ifPresent(o -> {
				setWRequestBodies(o);
			});
		}
		if(wRequestBodies != null)
			wRequestBodies.initDeepForClass(siteRequest_);
		return (BaseGenerator)this;
	}

	//////////////
	// wSchemas //
	//////////////


	/**	 The entity wSchemas
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wSchemas;

	/**	<br> The entity wSchemas
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.BaseGenerator&fq=entiteVar_enUS_indexed_string:wSchemas">Find the entity wSchemas in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wSchemas(Wrap<AllWriter> c);

	public AllWriter getWSchemas() {
		return wSchemas;
	}

	public void setWSchemas(AllWriter wSchemas) {
		this.wSchemas = wSchemas;
	}
	public static AllWriter staticSetWSchemas(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected BaseGenerator wSchemasInit() {
		Wrap<AllWriter> wSchemasWrap = new Wrap<AllWriter>().var("wSchemas");
		if(wSchemas == null) {
			_wSchemas(wSchemasWrap);
			Optional.ofNullable(wSchemasWrap.getO()).ifPresent(o -> {
				setWSchemas(o);
			});
		}
		if(wSchemas != null)
			wSchemas.initDeepForClass(siteRequest_);
		return (BaseGenerator)this;
	}

	//////////////
	// initDeep //
	//////////////

	public BaseGenerator initDeepBaseGenerator(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepBaseGenerator();
		return (BaseGenerator)this;
	}

	public void initDeepBaseGenerator() {
		initBaseGenerator();
	}

	public void initBaseGenerator() {
				vertx_Init();
				webClientInit();
				siteRequest_Init();
				configInit();
				appNameInit();
				languageNameInit();
				computateVertxSrcInit();
				i18nInit();
				appPathInit();
				appStaticPathInit();
				platformPomArtifactIdInit();
				openApiVersionInit();
				openApiVersionNumberInit();
				tabsSchemaInit();
				apiVersionInit();
				openApiYamlPathInit();
				openApiYamlFileInit();
				sqlCreatePathInit();
				sqlCreateFileInit();
				sqlDropPathInit();
				sqlDropFileInit();
				wInit();
				wSqlCreateInit();
				wSqlDropInit();
				wPathsInit();
				wRequestBodiesInit();
				wSchemasInit();
	}

	public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepBaseGenerator(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestBaseGenerator(ComputateSiteRequest siteRequest_) {
		if(w != null)
			w.setSiteRequest_(siteRequest_);
		if(wSqlCreate != null)
			wSqlCreate.setSiteRequest_(siteRequest_);
		if(wSqlDrop != null)
			wSqlDrop.setSiteRequest_(siteRequest_);
		if(wPaths != null)
			wPaths.setSiteRequest_(siteRequest_);
		if(wRequestBodies != null)
			wRequestBodies.setSiteRequest_(siteRequest_);
		if(wSchemas != null)
			wSchemas.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestBaseGenerator(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainBaseGenerator(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainBaseGenerator(String var) {
		BaseGenerator oBaseGenerator = (BaseGenerator)this;
		switch(var) {
			case "vertx_":
				return oBaseGenerator.vertx_;
			case "webClient":
				return oBaseGenerator.webClient;
			case "siteRequest_":
				return oBaseGenerator.siteRequest_;
			case "config":
				return oBaseGenerator.config;
			case "appName":
				return oBaseGenerator.appName;
			case "languageName":
				return oBaseGenerator.languageName;
			case "computateVertxSrc":
				return oBaseGenerator.computateVertxSrc;
			case "i18n":
				return oBaseGenerator.i18n;
			case "appPath":
				return oBaseGenerator.appPath;
			case "appStaticPath":
				return oBaseGenerator.appStaticPath;
			case "platformPomArtifactId":
				return oBaseGenerator.platformPomArtifactId;
			case "openApiVersion":
				return oBaseGenerator.openApiVersion;
			case "openApiVersionNumber":
				return oBaseGenerator.openApiVersionNumber;
			case "tabsSchema":
				return oBaseGenerator.tabsSchema;
			case "apiVersion":
				return oBaseGenerator.apiVersion;
			case "openApiYamlPath":
				return oBaseGenerator.openApiYamlPath;
			case "openApiYamlFile":
				return oBaseGenerator.openApiYamlFile;
			case "sqlCreatePath":
				return oBaseGenerator.sqlCreatePath;
			case "sqlCreateFile":
				return oBaseGenerator.sqlCreateFile;
			case "sqlDropPath":
				return oBaseGenerator.sqlDropPath;
			case "sqlDropFile":
				return oBaseGenerator.sqlDropFile;
			case "w":
				return oBaseGenerator.w;
			case "wSqlCreate":
				return oBaseGenerator.wSqlCreate;
			case "wSqlDrop":
				return oBaseGenerator.wSqlDrop;
			case "wPaths":
				return oBaseGenerator.wPaths;
			case "wRequestBodies":
				return oBaseGenerator.wRequestBodies;
			case "wSchemas":
				return oBaseGenerator.wSchemas;
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
				o = relateBaseGenerator(v, val);
		}
		return o != null;
	}
	public Object relateBaseGenerator(String var, Object val) {
		BaseGenerator oBaseGenerator = (BaseGenerator)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetBaseGenerator(entityVar,  siteRequest_, o);
	}
	public static Object staticSetBaseGenerator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "config":
			return BaseGenerator.staticSetConfig(siteRequest_, o);
		case "appName":
			return BaseGenerator.staticSetAppName(siteRequest_, o);
		case "languageName":
			return BaseGenerator.staticSetLanguageName(siteRequest_, o);
		case "computateVertxSrc":
			return BaseGenerator.staticSetComputateVertxSrc(siteRequest_, o);
		case "i18n":
			return BaseGenerator.staticSetI18n(siteRequest_, o);
		case "appPath":
			return BaseGenerator.staticSetAppPath(siteRequest_, o);
		case "appStaticPath":
			return BaseGenerator.staticSetAppStaticPath(siteRequest_, o);
		case "platformPomArtifactId":
			return BaseGenerator.staticSetPlatformPomArtifactId(siteRequest_, o);
		case "openApiVersion":
			return BaseGenerator.staticSetOpenApiVersion(siteRequest_, o);
		case "openApiVersionNumber":
			return BaseGenerator.staticSetOpenApiVersionNumber(siteRequest_, o);
		case "tabsSchema":
			return BaseGenerator.staticSetTabsSchema(siteRequest_, o);
		case "apiVersion":
			return BaseGenerator.staticSetApiVersion(siteRequest_, o);
		case "openApiYamlPath":
			return BaseGenerator.staticSetOpenApiYamlPath(siteRequest_, o);
		case "sqlCreatePath":
			return BaseGenerator.staticSetSqlCreatePath(siteRequest_, o);
		case "sqlDropPath":
			return BaseGenerator.staticSetSqlDropPath(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchBaseGenerator(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchBaseGenerator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "config":
			return BaseGenerator.staticSearchConfig(siteRequest_, (JsonObject)o);
		case "appName":
			return BaseGenerator.staticSearchAppName(siteRequest_, (String)o);
		case "languageName":
			return BaseGenerator.staticSearchLanguageName(siteRequest_, (String)o);
		case "computateVertxSrc":
			return BaseGenerator.staticSearchComputateVertxSrc(siteRequest_, (String)o);
		case "i18n":
			return BaseGenerator.staticSearchI18n(siteRequest_, (JsonObject)o);
		case "appPath":
			return BaseGenerator.staticSearchAppPath(siteRequest_, (String)o);
		case "appStaticPath":
			return BaseGenerator.staticSearchAppStaticPath(siteRequest_, (String)o);
		case "platformPomArtifactId":
			return BaseGenerator.staticSearchPlatformPomArtifactId(siteRequest_, (String)o);
		case "openApiVersion":
			return BaseGenerator.staticSearchOpenApiVersion(siteRequest_, (String)o);
		case "openApiVersionNumber":
			return BaseGenerator.staticSearchOpenApiVersionNumber(siteRequest_, (Integer)o);
		case "tabsSchema":
			return BaseGenerator.staticSearchTabsSchema(siteRequest_, (Integer)o);
		case "apiVersion":
			return BaseGenerator.staticSearchApiVersion(siteRequest_, (String)o);
		case "openApiYamlPath":
			return BaseGenerator.staticSearchOpenApiYamlPath(siteRequest_, (String)o);
		case "sqlCreatePath":
			return BaseGenerator.staticSearchSqlCreatePath(siteRequest_, (String)o);
		case "sqlDropPath":
			return BaseGenerator.staticSearchSqlDropPath(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrBaseGenerator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrBaseGenerator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "config":
			return BaseGenerator.staticSearchStrConfig(siteRequest_, (String)o);
		case "appName":
			return BaseGenerator.staticSearchStrAppName(siteRequest_, (String)o);
		case "languageName":
			return BaseGenerator.staticSearchStrLanguageName(siteRequest_, (String)o);
		case "computateVertxSrc":
			return BaseGenerator.staticSearchStrComputateVertxSrc(siteRequest_, (String)o);
		case "i18n":
			return BaseGenerator.staticSearchStrI18n(siteRequest_, (String)o);
		case "appPath":
			return BaseGenerator.staticSearchStrAppPath(siteRequest_, (String)o);
		case "appStaticPath":
			return BaseGenerator.staticSearchStrAppStaticPath(siteRequest_, (String)o);
		case "platformPomArtifactId":
			return BaseGenerator.staticSearchStrPlatformPomArtifactId(siteRequest_, (String)o);
		case "openApiVersion":
			return BaseGenerator.staticSearchStrOpenApiVersion(siteRequest_, (String)o);
		case "openApiVersionNumber":
			return BaseGenerator.staticSearchStrOpenApiVersionNumber(siteRequest_, (Integer)o);
		case "tabsSchema":
			return BaseGenerator.staticSearchStrTabsSchema(siteRequest_, (Integer)o);
		case "apiVersion":
			return BaseGenerator.staticSearchStrApiVersion(siteRequest_, (String)o);
		case "openApiYamlPath":
			return BaseGenerator.staticSearchStrOpenApiYamlPath(siteRequest_, (String)o);
		case "sqlCreatePath":
			return BaseGenerator.staticSearchStrSqlCreatePath(siteRequest_, (String)o);
		case "sqlDropPath":
			return BaseGenerator.staticSearchStrSqlDropPath(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqBaseGenerator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqBaseGenerator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "config":
			return BaseGenerator.staticSearchFqConfig(siteRequest_, o);
		case "appName":
			return BaseGenerator.staticSearchFqAppName(siteRequest_, o);
		case "languageName":
			return BaseGenerator.staticSearchFqLanguageName(siteRequest_, o);
		case "computateVertxSrc":
			return BaseGenerator.staticSearchFqComputateVertxSrc(siteRequest_, o);
		case "i18n":
			return BaseGenerator.staticSearchFqI18n(siteRequest_, o);
		case "appPath":
			return BaseGenerator.staticSearchFqAppPath(siteRequest_, o);
		case "appStaticPath":
			return BaseGenerator.staticSearchFqAppStaticPath(siteRequest_, o);
		case "platformPomArtifactId":
			return BaseGenerator.staticSearchFqPlatformPomArtifactId(siteRequest_, o);
		case "openApiVersion":
			return BaseGenerator.staticSearchFqOpenApiVersion(siteRequest_, o);
		case "openApiVersionNumber":
			return BaseGenerator.staticSearchFqOpenApiVersionNumber(siteRequest_, o);
		case "tabsSchema":
			return BaseGenerator.staticSearchFqTabsSchema(siteRequest_, o);
		case "apiVersion":
			return BaseGenerator.staticSearchFqApiVersion(siteRequest_, o);
		case "openApiYamlPath":
			return BaseGenerator.staticSearchFqOpenApiYamlPath(siteRequest_, o);
		case "sqlCreatePath":
			return BaseGenerator.staticSearchFqSqlCreatePath(siteRequest_, o);
		case "sqlDropPath":
			return BaseGenerator.staticSearchFqSqlDropPath(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "BaseGenerator";
	public static final String CLASS_CANONICAL_NAME = "org.computate.vertx.openapi.BaseGenerator";
	public static final String VAR_vertx_ = "vertx_";
	public static final String VAR_webClient = "webClient";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_config = "config";
	public static final String VAR_appName = "appName";
	public static final String VAR_languageName = "languageName";
	public static final String VAR_computateVertxSrc = "computateVertxSrc";
	public static final String VAR_i18n = "i18n";
	public static final String VAR_appPath = "appPath";
	public static final String VAR_appStaticPath = "appStaticPath";
	public static final String VAR_platformPomArtifactId = "platformPomArtifactId";
	public static final String VAR_openApiVersion = "openApiVersion";
	public static final String VAR_openApiVersionNumber = "openApiVersionNumber";
	public static final String VAR_tabsSchema = "tabsSchema";
	public static final String VAR_apiVersion = "apiVersion";
	public static final String VAR_openApiYamlPath = "openApiYamlPath";
	public static final String VAR_openApiYamlFile = "openApiYamlFile";
	public static final String VAR_sqlCreatePath = "sqlCreatePath";
	public static final String VAR_sqlCreateFile = "sqlCreateFile";
	public static final String VAR_sqlDropPath = "sqlDropPath";
	public static final String VAR_sqlDropFile = "sqlDropFile";
	public static final String VAR_w = "w";
	public static final String VAR_wSqlCreate = "wSqlCreate";
	public static final String VAR_wSqlDrop = "wSqlDrop";
	public static final String VAR_wPaths = "wPaths";
	public static final String VAR_wRequestBodies = "wRequestBodies";
	public static final String VAR_wSchemas = "wSchemas";

	public static final String DISPLAY_NAME_vertx_ = "";
	public static final String DISPLAY_NAME_webClient = "";
	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_config = "";
	public static final String DISPLAY_NAME_appName = "";
	public static final String DISPLAY_NAME_languageName = "";
	public static final String DISPLAY_NAME_computateVertxSrc = "";
	public static final String DISPLAY_NAME_i18n = "";
	public static final String DISPLAY_NAME_appPath = "";
	public static final String DISPLAY_NAME_appStaticPath = "";
	public static final String DISPLAY_NAME_platformPomArtifactId = "";
	public static final String DISPLAY_NAME_openApiVersion = "";
	public static final String DISPLAY_NAME_openApiVersionNumber = "";
	public static final String DISPLAY_NAME_tabsSchema = "";
	public static final String DISPLAY_NAME_apiVersion = "";
	public static final String DISPLAY_NAME_openApiYamlPath = "";
	public static final String DISPLAY_NAME_openApiYamlFile = "";
	public static final String DISPLAY_NAME_sqlCreatePath = "";
	public static final String DISPLAY_NAME_sqlCreateFile = "";
	public static final String DISPLAY_NAME_sqlDropPath = "";
	public static final String DISPLAY_NAME_sqlDropFile = "";
	public static final String DISPLAY_NAME_w = "";
	public static final String DISPLAY_NAME_wSqlCreate = "";
	public static final String DISPLAY_NAME_wSqlDrop = "";
	public static final String DISPLAY_NAME_wPaths = "";
	public static final String DISPLAY_NAME_wRequestBodies = "";
	public static final String DISPLAY_NAME_wSchemas = "";

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
		return BaseGenerator.displayNameBaseGenerator(var);
	}
	public static String displayNameBaseGenerator(String var) {
		switch(var) {
		case VAR_vertx_:
			return DISPLAY_NAME_vertx_;
		case VAR_webClient:
			return DISPLAY_NAME_webClient;
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_config:
			return DISPLAY_NAME_config;
		case VAR_appName:
			return DISPLAY_NAME_appName;
		case VAR_languageName:
			return DISPLAY_NAME_languageName;
		case VAR_computateVertxSrc:
			return DISPLAY_NAME_computateVertxSrc;
		case VAR_i18n:
			return DISPLAY_NAME_i18n;
		case VAR_appPath:
			return DISPLAY_NAME_appPath;
		case VAR_appStaticPath:
			return DISPLAY_NAME_appStaticPath;
		case VAR_platformPomArtifactId:
			return DISPLAY_NAME_platformPomArtifactId;
		case VAR_openApiVersion:
			return DISPLAY_NAME_openApiVersion;
		case VAR_openApiVersionNumber:
			return DISPLAY_NAME_openApiVersionNumber;
		case VAR_tabsSchema:
			return DISPLAY_NAME_tabsSchema;
		case VAR_apiVersion:
			return DISPLAY_NAME_apiVersion;
		case VAR_openApiYamlPath:
			return DISPLAY_NAME_openApiYamlPath;
		case VAR_openApiYamlFile:
			return DISPLAY_NAME_openApiYamlFile;
		case VAR_sqlCreatePath:
			return DISPLAY_NAME_sqlCreatePath;
		case VAR_sqlCreateFile:
			return DISPLAY_NAME_sqlCreateFile;
		case VAR_sqlDropPath:
			return DISPLAY_NAME_sqlDropPath;
		case VAR_sqlDropFile:
			return DISPLAY_NAME_sqlDropFile;
		case VAR_w:
			return DISPLAY_NAME_w;
		case VAR_wSqlCreate:
			return DISPLAY_NAME_wSqlCreate;
		case VAR_wSqlDrop:
			return DISPLAY_NAME_wSqlDrop;
		case VAR_wPaths:
			return DISPLAY_NAME_wPaths;
		case VAR_wRequestBodies:
			return DISPLAY_NAME_wRequestBodies;
		case VAR_wSchemas:
			return DISPLAY_NAME_wSchemas;
		default:
			return null;
		}
	}

	public static String descriptionBaseGenerator(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static String classSimpleNameBaseGenerator(String var) {
		switch(var) {
		case VAR_vertx_:
			return "Vertx";
		case VAR_webClient:
			return "WebClient";
		case VAR_siteRequest_:
			return "ComputateSiteRequest";
		case VAR_config:
			return "JsonObject";
		case VAR_appName:
			return "String";
		case VAR_languageName:
			return "String";
		case VAR_computateVertxSrc:
			return "String";
		case VAR_i18n:
			return "JsonObject";
		case VAR_appPath:
			return "String";
		case VAR_appStaticPath:
			return "String";
		case VAR_platformPomArtifactId:
			return "String";
		case VAR_openApiVersion:
			return "String";
		case VAR_openApiVersionNumber:
			return "Integer";
		case VAR_tabsSchema:
			return "Integer";
		case VAR_apiVersion:
			return "String";
		case VAR_openApiYamlPath:
			return "String";
		case VAR_openApiYamlFile:
			return "File";
		case VAR_sqlCreatePath:
			return "String";
		case VAR_sqlCreateFile:
			return "File";
		case VAR_sqlDropPath:
			return "String";
		case VAR_sqlDropFile:
			return "File";
		case VAR_w:
			return "AllWriter";
		case VAR_wSqlCreate:
			return "AllWriter";
		case VAR_wSqlDrop:
			return "AllWriter";
		case VAR_wPaths:
			return "AllWriter";
		case VAR_wRequestBodies:
			return "AllWriter";
		case VAR_wSchemas:
			return "AllWriter";
			default:
				return null;
		}
	}

	public static Integer htmColumnBaseGenerator(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmRowBaseGenerator(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmCellBaseGenerator(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMinBaseGenerator(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMaxBaseGenerator(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer maxBaseGenerator(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer minBaseGenerator(String var) {
		switch(var) {
			default:
				return null;
		}
	}
}
