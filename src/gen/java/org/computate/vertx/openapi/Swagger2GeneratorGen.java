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
import io.vertx.ext.web.client.WebClient;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import java.lang.Integer;
import java.io.File;
import org.computate.vertx.writer.AllWriter;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**	
 * <h1>Suggestions that can generate more code for you: </h1>
 * <ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these Swagger2Generator objects in a RESTful API. 
 * </li>
 * </ol>
 * <h1>About the Swagger2Generator class and it's generated class Swagger2GeneratorGen&lt;Object&gt;: </h1>
 * <p>
 * This Java class extends a generated Java class built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator">Find the class Swagger2Generator in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * <p>
 * Delete the class Swagger2Generator in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.openapi in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.openapi&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 **/
public abstract class Swagger2GeneratorGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(Swagger2Generator.class);
	public static final String configureConfigComplete1 = "The config was configured successfully. ";
	public static final String configureConfigComplete = configureConfigComplete1;
	public static final String configureConfigFail1 = "Could not configure the config(). ";
	public static final String configureConfigFail = configureConfigFail1;


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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:webClient">Find the entity webClient in Solr</a>
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
	protected Swagger2Generator webClientInit() {
		Wrap<WebClient> webClientWrap = new Wrap<WebClient>().var("webClient");
		if(webClient == null) {
			_webClient(webClientWrap);
			setWebClient(webClientWrap.o);
		}
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
	protected Swagger2Generator siteRequest_Init() {
		Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (Swagger2Generator)this;
	}

	////////////
	// config //
	////////////

	/**	 The entity config
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject config;

	/**	<br> The entity config
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:config">Find the entity config in Solr</a>
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
		this.config = Swagger2Generator.staticSetConfig(siteRequest_, o);
	}
	public static JsonObject staticSetConfig(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected Swagger2Generator configInit() {
		Wrap<JsonObject> configWrap = new Wrap<JsonObject>().var("config");
		if(config == null) {
			_config(configWrap);
			setConfig(configWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static JsonObject staticSearchConfig(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrConfig(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqConfig(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrConfig(siteRequest_, Swagger2Generator.staticSearchConfig(siteRequest_, Swagger2Generator.staticSetConfig(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:appName">Find the entity appName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _appName(Wrap<String> c);

	public String getAppName() {
		return appName;
	}
	public void setAppName(String o) {
		this.appName = Swagger2Generator.staticSetAppName(siteRequest_, o);
	}
	public static String staticSetAppName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator appNameInit() {
		Wrap<String> appNameWrap = new Wrap<String>().var("appName");
		if(appName == null) {
			_appName(appNameWrap);
			setAppName(appNameWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchAppName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAppName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAppName(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrAppName(siteRequest_, Swagger2Generator.staticSearchAppName(siteRequest_, Swagger2Generator.staticSetAppName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:languageName">Find the entity languageName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _languageName(Wrap<String> c);

	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String o) {
		this.languageName = Swagger2Generator.staticSetLanguageName(siteRequest_, o);
	}
	public static String staticSetLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator languageNameInit() {
		Wrap<String> languageNameWrap = new Wrap<String>().var("languageName");
		if(languageName == null) {
			_languageName(languageNameWrap);
			setLanguageName(languageNameWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrLanguageName(siteRequest_, Swagger2Generator.staticSearchLanguageName(siteRequest_, Swagger2Generator.staticSetLanguageName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:appPath">Find the entity appPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _appPath(Wrap<String> c);

	public String getAppPath() {
		return appPath;
	}
	public void setAppPath(String o) {
		this.appPath = Swagger2Generator.staticSetAppPath(siteRequest_, o);
	}
	public static String staticSetAppPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator appPathInit() {
		Wrap<String> appPathWrap = new Wrap<String>().var("appPath");
		if(appPath == null) {
			_appPath(appPathWrap);
			setAppPath(appPathWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchAppPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAppPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAppPath(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrAppPath(siteRequest_, Swagger2Generator.staticSearchAppPath(siteRequest_, Swagger2Generator.staticSetAppPath(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:openApiVersion">Find the entity openApiVersion in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _openApiVersion(Wrap<String> c);

	public String getOpenApiVersion() {
		return openApiVersion;
	}
	public void setOpenApiVersion(String o) {
		this.openApiVersion = Swagger2Generator.staticSetOpenApiVersion(siteRequest_, o);
	}
	public static String staticSetOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator openApiVersionInit() {
		Wrap<String> openApiVersionWrap = new Wrap<String>().var("openApiVersion");
		if(openApiVersion == null) {
			_openApiVersion(openApiVersionWrap);
			setOpenApiVersion(openApiVersionWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrOpenApiVersion(siteRequest_, Swagger2Generator.staticSearchOpenApiVersion(siteRequest_, Swagger2Generator.staticSetOpenApiVersion(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:openApiVersionNumber">Find the entity openApiVersionNumber in Solr</a>
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
		this.openApiVersionNumber = Swagger2Generator.staticSetOpenApiVersionNumber(siteRequest_, o);
	}
	public static Integer staticSetOpenApiVersionNumber(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected Swagger2Generator openApiVersionNumberInit() {
		Wrap<Integer> openApiVersionNumberWrap = new Wrap<Integer>().var("openApiVersionNumber");
		if(openApiVersionNumber == null) {
			_openApiVersionNumber(openApiVersionNumberWrap);
			setOpenApiVersionNumber(openApiVersionNumberWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static Integer staticSearchOpenApiVersionNumber(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrOpenApiVersionNumber(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiVersionNumber(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrOpenApiVersionNumber(siteRequest_, Swagger2Generator.staticSearchOpenApiVersionNumber(siteRequest_, Swagger2Generator.staticSetOpenApiVersionNumber(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:tabsSchema">Find the entity tabsSchema in Solr</a>
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
		this.tabsSchema = Swagger2Generator.staticSetTabsSchema(siteRequest_, o);
	}
	public static Integer staticSetTabsSchema(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected Swagger2Generator tabsSchemaInit() {
		Wrap<Integer> tabsSchemaWrap = new Wrap<Integer>().var("tabsSchema");
		if(tabsSchema == null) {
			_tabsSchema(tabsSchemaWrap);
			setTabsSchema(tabsSchemaWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static Integer staticSearchTabsSchema(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTabsSchema(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTabsSchema(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrTabsSchema(siteRequest_, Swagger2Generator.staticSearchTabsSchema(siteRequest_, Swagger2Generator.staticSetTabsSchema(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:apiVersion">Find the entity apiVersion in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _apiVersion(Wrap<String> c);

	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String o) {
		this.apiVersion = Swagger2Generator.staticSetApiVersion(siteRequest_, o);
	}
	public static String staticSetApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator apiVersionInit() {
		Wrap<String> apiVersionWrap = new Wrap<String>().var("apiVersion");
		if(apiVersion == null) {
			_apiVersion(apiVersionWrap);
			setApiVersion(apiVersionWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrApiVersion(siteRequest_, Swagger2Generator.staticSearchApiVersion(siteRequest_, Swagger2Generator.staticSetApiVersion(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:openApiYamlPath">Find the entity openApiYamlPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _openApiYamlPath(Wrap<String> c);

	public String getOpenApiYamlPath() {
		return openApiYamlPath;
	}
	public void setOpenApiYamlPath(String o) {
		this.openApiYamlPath = Swagger2Generator.staticSetOpenApiYamlPath(siteRequest_, o);
	}
	public static String staticSetOpenApiYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator openApiYamlPathInit() {
		Wrap<String> openApiYamlPathWrap = new Wrap<String>().var("openApiYamlPath");
		if(openApiYamlPath == null) {
			_openApiYamlPath(openApiYamlPathWrap);
			setOpenApiYamlPath(openApiYamlPathWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchOpenApiYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrOpenApiYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrOpenApiYamlPath(siteRequest_, Swagger2Generator.staticSearchOpenApiYamlPath(siteRequest_, Swagger2Generator.staticSetOpenApiYamlPath(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:openApiYamlFile">Find the entity openApiYamlFile in Solr</a>
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
	protected Swagger2Generator openApiYamlFileInit() {
		Wrap<File> openApiYamlFileWrap = new Wrap<File>().var("openApiYamlFile");
		if(openApiYamlFile == null) {
			_openApiYamlFile(openApiYamlFileWrap);
			setOpenApiYamlFile(openApiYamlFileWrap.o);
		}
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:sqlCreatePath">Find the entity sqlCreatePath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sqlCreatePath(Wrap<String> c);

	public String getSqlCreatePath() {
		return sqlCreatePath;
	}
	public void setSqlCreatePath(String o) {
		this.sqlCreatePath = Swagger2Generator.staticSetSqlCreatePath(siteRequest_, o);
	}
	public static String staticSetSqlCreatePath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator sqlCreatePathInit() {
		Wrap<String> sqlCreatePathWrap = new Wrap<String>().var("sqlCreatePath");
		if(sqlCreatePath == null) {
			_sqlCreatePath(sqlCreatePathWrap);
			setSqlCreatePath(sqlCreatePathWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchSqlCreatePath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSqlCreatePath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSqlCreatePath(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrSqlCreatePath(siteRequest_, Swagger2Generator.staticSearchSqlCreatePath(siteRequest_, Swagger2Generator.staticSetSqlCreatePath(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:sqlCreateFile">Find the entity sqlCreateFile in Solr</a>
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
	protected Swagger2Generator sqlCreateFileInit() {
		Wrap<File> sqlCreateFileWrap = new Wrap<File>().var("sqlCreateFile");
		if(sqlCreateFile == null) {
			_sqlCreateFile(sqlCreateFileWrap);
			setSqlCreateFile(sqlCreateFileWrap.o);
		}
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:sqlDropPath">Find the entity sqlDropPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sqlDropPath(Wrap<String> c);

	public String getSqlDropPath() {
		return sqlDropPath;
	}
	public void setSqlDropPath(String o) {
		this.sqlDropPath = Swagger2Generator.staticSetSqlDropPath(siteRequest_, o);
	}
	public static String staticSetSqlDropPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator sqlDropPathInit() {
		Wrap<String> sqlDropPathWrap = new Wrap<String>().var("sqlDropPath");
		if(sqlDropPath == null) {
			_sqlDropPath(sqlDropPathWrap);
			setSqlDropPath(sqlDropPathWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchSqlDropPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSqlDropPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSqlDropPath(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrSqlDropPath(siteRequest_, Swagger2Generator.staticSearchSqlDropPath(siteRequest_, Swagger2Generator.staticSetSqlDropPath(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:sqlDropFile">Find the entity sqlDropFile in Solr</a>
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
	protected Swagger2Generator sqlDropFileInit() {
		Wrap<File> sqlDropFileWrap = new Wrap<File>().var("sqlDropFile");
		if(sqlDropFile == null) {
			_sqlDropFile(sqlDropFileWrap);
			setSqlDropFile(sqlDropFileWrap.o);
		}
		return (Swagger2Generator)this;
	}

	/////////////////////
	// articleYamlPath //
	/////////////////////

	/**	 The entity articleYamlPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String articleYamlPath;

	/**	<br> The entity articleYamlPath
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:articleYamlPath">Find the entity articleYamlPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _articleYamlPath(Wrap<String> c);

	public String getArticleYamlPath() {
		return articleYamlPath;
	}
	public void setArticleYamlPath(String o) {
		this.articleYamlPath = Swagger2Generator.staticSetArticleYamlPath(siteRequest_, o);
	}
	public static String staticSetArticleYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected Swagger2Generator articleYamlPathInit() {
		Wrap<String> articleYamlPathWrap = new Wrap<String>().var("articleYamlPath");
		if(articleYamlPath == null) {
			_articleYamlPath(articleYamlPathWrap);
			setArticleYamlPath(articleYamlPathWrap.o);
		}
		return (Swagger2Generator)this;
	}

	public static String staticSearchArticleYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrArticleYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqArticleYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return Swagger2Generator.staticSearchStrArticleYamlPath(siteRequest_, Swagger2Generator.staticSearchArticleYamlPath(siteRequest_, Swagger2Generator.staticSetArticleYamlPath(siteRequest_, o)));
	}

	/////////////////////
	// articleYamlFile //
	/////////////////////

	/**	 The entity articleYamlFile
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File articleYamlFile;

	/**	<br> The entity articleYamlFile
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:articleYamlFile">Find the entity articleYamlFile in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _articleYamlFile(Wrap<File> c);

	public File getArticleYamlFile() {
		return articleYamlFile;
	}

	public void setArticleYamlFile(File articleYamlFile) {
		this.articleYamlFile = articleYamlFile;
	}
	public static File staticSetArticleYamlFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected Swagger2Generator articleYamlFileInit() {
		Wrap<File> articleYamlFileWrap = new Wrap<File>().var("articleYamlFile");
		if(articleYamlFile == null) {
			_articleYamlFile(articleYamlFileWrap);
			setArticleYamlFile(articleYamlFileWrap.o);
		}
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:w">Find the entity w in Solr</a>
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
	protected Swagger2Generator wInit() {
		Wrap<AllWriter> wWrap = new Wrap<AllWriter>().var("w");
		if(w == null) {
			_w(wWrap);
			setW(wWrap.o);
		}
		if(w != null)
			w.initDeepForClass(siteRequest_);
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:wSqlCreate">Find the entity wSqlCreate in Solr</a>
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
	protected Swagger2Generator wSqlCreateInit() {
		Wrap<AllWriter> wSqlCreateWrap = new Wrap<AllWriter>().var("wSqlCreate");
		if(wSqlCreate == null) {
			_wSqlCreate(wSqlCreateWrap);
			setWSqlCreate(wSqlCreateWrap.o);
		}
		if(wSqlCreate != null)
			wSqlCreate.initDeepForClass(siteRequest_);
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:wSqlDrop">Find the entity wSqlDrop in Solr</a>
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
	protected Swagger2Generator wSqlDropInit() {
		Wrap<AllWriter> wSqlDropWrap = new Wrap<AllWriter>().var("wSqlDrop");
		if(wSqlDrop == null) {
			_wSqlDrop(wSqlDropWrap);
			setWSqlDrop(wSqlDropWrap.o);
		}
		if(wSqlDrop != null)
			wSqlDrop.initDeepForClass(siteRequest_);
		return (Swagger2Generator)this;
	}

	//////////////
	// wArticle //
	//////////////

	/**	 The entity wArticle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wArticle;

	/**	<br> The entity wArticle
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:wArticle">Find the entity wArticle in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wArticle(Wrap<AllWriter> c);

	public AllWriter getWArticle() {
		return wArticle;
	}

	public void setWArticle(AllWriter wArticle) {
		this.wArticle = wArticle;
	}
	public static AllWriter staticSetWArticle(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected Swagger2Generator wArticleInit() {
		Wrap<AllWriter> wArticleWrap = new Wrap<AllWriter>().var("wArticle");
		if(wArticle == null) {
			_wArticle(wArticleWrap);
			setWArticle(wArticleWrap.o);
		}
		if(wArticle != null)
			wArticle.initDeepForClass(siteRequest_);
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:wPaths">Find the entity wPaths in Solr</a>
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
	protected Swagger2Generator wPathsInit() {
		Wrap<AllWriter> wPathsWrap = new Wrap<AllWriter>().var("wPaths");
		if(wPaths == null) {
			_wPaths(wPathsWrap);
			setWPaths(wPathsWrap.o);
		}
		if(wPaths != null)
			wPaths.initDeepForClass(siteRequest_);
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:wRequestBodies">Find the entity wRequestBodies in Solr</a>
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
	protected Swagger2Generator wRequestBodiesInit() {
		Wrap<AllWriter> wRequestBodiesWrap = new Wrap<AllWriter>().var("wRequestBodies");
		if(wRequestBodies == null) {
			_wRequestBodies(wRequestBodiesWrap);
			setWRequestBodies(wRequestBodiesWrap.o);
		}
		if(wRequestBodies != null)
			wRequestBodies.initDeepForClass(siteRequest_);
		return (Swagger2Generator)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&fq=entiteVar_enUS_indexed_string:wSchemas">Find the entity wSchemas in Solr</a>
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
	protected Swagger2Generator wSchemasInit() {
		Wrap<AllWriter> wSchemasWrap = new Wrap<AllWriter>().var("wSchemas");
		if(wSchemas == null) {
			_wSchemas(wSchemasWrap);
			setWSchemas(wSchemasWrap.o);
		}
		if(wSchemas != null)
			wSchemas.initDeepForClass(siteRequest_);
		return (Swagger2Generator)this;
	}
	public static final String writeApiError1 = "An error occured while writing the API. ";
	public static final String writeApiError = writeApiError1;
	public static final String writeApiError21 = "An error occured while writing the API. ";
	public static final String writeApiError2 = writeApiError21;


	//////////////
	// initDeep //
	//////////////

	public Swagger2Generator initDeepSwagger2Generator(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepSwagger2Generator();
		return (Swagger2Generator)this;
	}

	public void initDeepSwagger2Generator() {
		initSwagger2Generator();
	}

	public void initSwagger2Generator() {
				webClientInit();
				siteRequest_Init();
				configInit();
				appNameInit();
				languageNameInit();
				appPathInit();
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
				articleYamlPathInit();
				articleYamlFileInit();
				wInit();
				wSqlCreateInit();
				wSqlDropInit();
				wArticleInit();
				wPathsInit();
				wRequestBodiesInit();
				wSchemasInit();
	}

	public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepSwagger2Generator(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSwagger2Generator(ComputateSiteRequest siteRequest_) {
		if(w != null)
			w.setSiteRequest_(siteRequest_);
		if(wSqlCreate != null)
			wSqlCreate.setSiteRequest_(siteRequest_);
		if(wSqlDrop != null)
			wSqlDrop.setSiteRequest_(siteRequest_);
		if(wArticle != null)
			wArticle.setSiteRequest_(siteRequest_);
		if(wPaths != null)
			wPaths.setSiteRequest_(siteRequest_);
		if(wRequestBodies != null)
			wRequestBodies.setSiteRequest_(siteRequest_);
		if(wSchemas != null)
			wSchemas.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestSwagger2Generator(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSwagger2Generator(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainSwagger2Generator(String var) {
		Swagger2Generator oSwagger2Generator = (Swagger2Generator)this;
		switch(var) {
			case "webClient":
				return oSwagger2Generator.webClient;
			case "siteRequest_":
				return oSwagger2Generator.siteRequest_;
			case "config":
				return oSwagger2Generator.config;
			case "appName":
				return oSwagger2Generator.appName;
			case "languageName":
				return oSwagger2Generator.languageName;
			case "appPath":
				return oSwagger2Generator.appPath;
			case "openApiVersion":
				return oSwagger2Generator.openApiVersion;
			case "openApiVersionNumber":
				return oSwagger2Generator.openApiVersionNumber;
			case "tabsSchema":
				return oSwagger2Generator.tabsSchema;
			case "apiVersion":
				return oSwagger2Generator.apiVersion;
			case "openApiYamlPath":
				return oSwagger2Generator.openApiYamlPath;
			case "openApiYamlFile":
				return oSwagger2Generator.openApiYamlFile;
			case "sqlCreatePath":
				return oSwagger2Generator.sqlCreatePath;
			case "sqlCreateFile":
				return oSwagger2Generator.sqlCreateFile;
			case "sqlDropPath":
				return oSwagger2Generator.sqlDropPath;
			case "sqlDropFile":
				return oSwagger2Generator.sqlDropFile;
			case "articleYamlPath":
				return oSwagger2Generator.articleYamlPath;
			case "articleYamlFile":
				return oSwagger2Generator.articleYamlFile;
			case "w":
				return oSwagger2Generator.w;
			case "wSqlCreate":
				return oSwagger2Generator.wSqlCreate;
			case "wSqlDrop":
				return oSwagger2Generator.wSqlDrop;
			case "wArticle":
				return oSwagger2Generator.wArticle;
			case "wPaths":
				return oSwagger2Generator.wPaths;
			case "wRequestBodies":
				return oSwagger2Generator.wRequestBodies;
			case "wSchemas":
				return oSwagger2Generator.wSchemas;
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
				o = relateSwagger2Generator(v, val);
		}
		return o != null;
	}
	public Object relateSwagger2Generator(String var, Object val) {
		Swagger2Generator oSwagger2Generator = (Swagger2Generator)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetSwagger2Generator(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSwagger2Generator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "config":
			return Swagger2Generator.staticSetConfig(siteRequest_, o);
		case "appName":
			return Swagger2Generator.staticSetAppName(siteRequest_, o);
		case "languageName":
			return Swagger2Generator.staticSetLanguageName(siteRequest_, o);
		case "appPath":
			return Swagger2Generator.staticSetAppPath(siteRequest_, o);
		case "openApiVersion":
			return Swagger2Generator.staticSetOpenApiVersion(siteRequest_, o);
		case "openApiVersionNumber":
			return Swagger2Generator.staticSetOpenApiVersionNumber(siteRequest_, o);
		case "tabsSchema":
			return Swagger2Generator.staticSetTabsSchema(siteRequest_, o);
		case "apiVersion":
			return Swagger2Generator.staticSetApiVersion(siteRequest_, o);
		case "openApiYamlPath":
			return Swagger2Generator.staticSetOpenApiYamlPath(siteRequest_, o);
		case "sqlCreatePath":
			return Swagger2Generator.staticSetSqlCreatePath(siteRequest_, o);
		case "sqlDropPath":
			return Swagger2Generator.staticSetSqlDropPath(siteRequest_, o);
		case "articleYamlPath":
			return Swagger2Generator.staticSetArticleYamlPath(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchSwagger2Generator(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchSwagger2Generator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "config":
			return Swagger2Generator.staticSearchConfig(siteRequest_, (JsonObject)o);
		case "appName":
			return Swagger2Generator.staticSearchAppName(siteRequest_, (String)o);
		case "languageName":
			return Swagger2Generator.staticSearchLanguageName(siteRequest_, (String)o);
		case "appPath":
			return Swagger2Generator.staticSearchAppPath(siteRequest_, (String)o);
		case "openApiVersion":
			return Swagger2Generator.staticSearchOpenApiVersion(siteRequest_, (String)o);
		case "openApiVersionNumber":
			return Swagger2Generator.staticSearchOpenApiVersionNumber(siteRequest_, (Integer)o);
		case "tabsSchema":
			return Swagger2Generator.staticSearchTabsSchema(siteRequest_, (Integer)o);
		case "apiVersion":
			return Swagger2Generator.staticSearchApiVersion(siteRequest_, (String)o);
		case "openApiYamlPath":
			return Swagger2Generator.staticSearchOpenApiYamlPath(siteRequest_, (String)o);
		case "sqlCreatePath":
			return Swagger2Generator.staticSearchSqlCreatePath(siteRequest_, (String)o);
		case "sqlDropPath":
			return Swagger2Generator.staticSearchSqlDropPath(siteRequest_, (String)o);
		case "articleYamlPath":
			return Swagger2Generator.staticSearchArticleYamlPath(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrSwagger2Generator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrSwagger2Generator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "config":
			return Swagger2Generator.staticSearchStrConfig(siteRequest_, (JsonObject)o);
		case "appName":
			return Swagger2Generator.staticSearchStrAppName(siteRequest_, (String)o);
		case "languageName":
			return Swagger2Generator.staticSearchStrLanguageName(siteRequest_, (String)o);
		case "appPath":
			return Swagger2Generator.staticSearchStrAppPath(siteRequest_, (String)o);
		case "openApiVersion":
			return Swagger2Generator.staticSearchStrOpenApiVersion(siteRequest_, (String)o);
		case "openApiVersionNumber":
			return Swagger2Generator.staticSearchStrOpenApiVersionNumber(siteRequest_, (Integer)o);
		case "tabsSchema":
			return Swagger2Generator.staticSearchStrTabsSchema(siteRequest_, (Integer)o);
		case "apiVersion":
			return Swagger2Generator.staticSearchStrApiVersion(siteRequest_, (String)o);
		case "openApiYamlPath":
			return Swagger2Generator.staticSearchStrOpenApiYamlPath(siteRequest_, (String)o);
		case "sqlCreatePath":
			return Swagger2Generator.staticSearchStrSqlCreatePath(siteRequest_, (String)o);
		case "sqlDropPath":
			return Swagger2Generator.staticSearchStrSqlDropPath(siteRequest_, (String)o);
		case "articleYamlPath":
			return Swagger2Generator.staticSearchStrArticleYamlPath(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqSwagger2Generator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqSwagger2Generator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "config":
			return Swagger2Generator.staticSearchFqConfig(siteRequest_, o);
		case "appName":
			return Swagger2Generator.staticSearchFqAppName(siteRequest_, o);
		case "languageName":
			return Swagger2Generator.staticSearchFqLanguageName(siteRequest_, o);
		case "appPath":
			return Swagger2Generator.staticSearchFqAppPath(siteRequest_, o);
		case "openApiVersion":
			return Swagger2Generator.staticSearchFqOpenApiVersion(siteRequest_, o);
		case "openApiVersionNumber":
			return Swagger2Generator.staticSearchFqOpenApiVersionNumber(siteRequest_, o);
		case "tabsSchema":
			return Swagger2Generator.staticSearchFqTabsSchema(siteRequest_, o);
		case "apiVersion":
			return Swagger2Generator.staticSearchFqApiVersion(siteRequest_, o);
		case "openApiYamlPath":
			return Swagger2Generator.staticSearchFqOpenApiYamlPath(siteRequest_, o);
		case "sqlCreatePath":
			return Swagger2Generator.staticSearchFqSqlCreatePath(siteRequest_, o);
		case "sqlDropPath":
			return Swagger2Generator.staticSearchFqSqlDropPath(siteRequest_, o);
		case "articleYamlPath":
			return Swagger2Generator.staticSearchFqArticleYamlPath(siteRequest_, o);
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

	public static final String[] Swagger2GeneratorVals = new String[] { configureConfigComplete1, configureConfigFail1, writeApiError1, writeApiError21 };

	public static final String CLASS_SIMPLE_NAME = "Swagger2Generator";
	public static final String VAR_webClient = "webClient";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_config = "config";
	public static final String VAR_appName = "appName";
	public static final String VAR_languageName = "languageName";
	public static final String VAR_appPath = "appPath";
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
	public static final String VAR_articleYamlPath = "articleYamlPath";
	public static final String VAR_articleYamlFile = "articleYamlFile";
	public static final String VAR_w = "w";
	public static final String VAR_wSqlCreate = "wSqlCreate";
	public static final String VAR_wSqlDrop = "wSqlDrop";
	public static final String VAR_wArticle = "wArticle";
	public static final String VAR_wPaths = "wPaths";
	public static final String VAR_wRequestBodies = "wRequestBodies";
	public static final String VAR_wSchemas = "wSchemas";

	public static final String DISPLAY_NAME_webClient = "";
	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_config = "";
	public static final String DISPLAY_NAME_appName = "";
	public static final String DISPLAY_NAME_languageName = "";
	public static final String DISPLAY_NAME_appPath = "";
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
	public static final String DISPLAY_NAME_articleYamlPath = "";
	public static final String DISPLAY_NAME_articleYamlFile = "";
	public static final String DISPLAY_NAME_w = "";
	public static final String DISPLAY_NAME_wSqlCreate = "";
	public static final String DISPLAY_NAME_wSqlDrop = "";
	public static final String DISPLAY_NAME_wArticle = "";
	public static final String DISPLAY_NAME_wPaths = "";
	public static final String DISPLAY_NAME_wRequestBodies = "";
	public static final String DISPLAY_NAME_wSchemas = "";

	public static String displayNameForClass(String var) {
		return Swagger2Generator.displayNameSwagger2Generator(var);
	}
	public static String displayNameSwagger2Generator(String var) {
		switch(var) {
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
		case VAR_appPath:
			return DISPLAY_NAME_appPath;
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
		case VAR_articleYamlPath:
			return DISPLAY_NAME_articleYamlPath;
		case VAR_articleYamlFile:
			return DISPLAY_NAME_articleYamlFile;
		case VAR_w:
			return DISPLAY_NAME_w;
		case VAR_wSqlCreate:
			return DISPLAY_NAME_wSqlCreate;
		case VAR_wSqlDrop:
			return DISPLAY_NAME_wSqlDrop;
		case VAR_wArticle:
			return DISPLAY_NAME_wArticle;
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
}
