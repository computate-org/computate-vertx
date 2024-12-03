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
package org.computate.vertx.writer;

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
import org.computate.search.computate.enus.ComputateEnUSClass;
import org.computate.search.response.solr.SolrResponse.Doc;
import java.lang.Integer;
import io.vertx.core.json.JsonArray;
import org.computate.vertx.writer.AllWriter;
import org.computate.vertx.writer.AllWriters;
import java.lang.Boolean;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ApiWriter objects in a RESTful API. 
 * </li>
 * <h3>About the ApiWriter class and it's generated class ApiWriterGen&lt;Object&gt;: </h3>extends ApiWriterGen
 * <p>
 * This Java class extends a generated Java class ApiWriterGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter">Find the class ApiWriter in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ApiWriterGen<Object>
 * <p>This <code>class ApiWriter extends ApiWriterGen&lt;Object&gt;</code>, which means it extends a newly generated ApiWriterGen. 
 * The generated <code>class ApiWriterGen extends Object</code> which means that ApiWriter extends ApiWriterGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the ApiWriter class will inherit the helpful inherited class comments from the super class ApiWriterGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class ApiWriter in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.writer in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.writer&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class ApiWriterGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(ApiWriter.class);

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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
	protected ApiWriter siteRequest_Init() {
		Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			Optional.ofNullable(siteRequest_Wrap.getO()).ifPresent(o -> {
				setSiteRequest_(o);
			});
		}
		return (ApiWriter)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:languageName">Find the entity languageName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _languageName(Wrap<String> c);

	public String getLanguageName() {
		return languageName;
	}
	public void setLanguageName(String o) {
		this.languageName = ApiWriter.staticSetLanguageName(siteRequest_, o);
	}
	public static String staticSetLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter languageNameInit() {
		Wrap<String> languageNameWrap = new Wrap<String>().var("languageName");
		if(languageName == null) {
			_languageName(languageNameWrap);
			Optional.ofNullable(languageNameWrap.getO()).ifPresent(o -> {
				setLanguageName(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLanguageName(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchLanguageName(siteRequest_, ApiWriter.staticSetLanguageName(siteRequest_, o)).toString();
	}

	//////////
	// i18n //
	//////////


	/**	 The entity i18n
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject i18n;

	/**	<br> The entity i18n
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:i18n">Find the entity i18n in Solr</a>
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
		this.i18n = ApiWriter.staticSetI18n(siteRequest_, o);
	}
	public static JsonObject staticSetI18n(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ApiWriter i18nInit() {
		Wrap<JsonObject> i18nWrap = new Wrap<JsonObject>().var("i18n");
		if(i18n == null) {
			_i18n(i18nWrap);
			Optional.ofNullable(i18nWrap.getO()).ifPresent(o -> {
				setI18n(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchI18n(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrI18n(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqI18n(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchI18n(siteRequest_, ApiWriter.staticSetI18n(siteRequest_, o)).toString();
	}

	//////////////
	// classDoc //
	//////////////


	/**	 The entity classDoc
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateEnUSClass classDoc;

	/**	<br> The entity classDoc
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classDoc">Find the entity classDoc in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classDoc(Wrap<ComputateEnUSClass> w);

	public ComputateEnUSClass getClassDoc() {
		return classDoc;
	}

	public void setClassDoc(ComputateEnUSClass classDoc) {
		this.classDoc = classDoc;
	}
	public static ComputateEnUSClass staticSetClassDoc(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter classDocInit() {
		Wrap<ComputateEnUSClass> classDocWrap = new Wrap<ComputateEnUSClass>().var("classDoc");
		if(classDoc == null) {
			_classDoc(classDocWrap);
			Optional.ofNullable(classDocWrap.getO()).ifPresent(o -> {
				setClassDoc(o);
			});
		}
		return (ApiWriter)this;
	}

	///////////////////////
	// classSolrDocument //
	///////////////////////


	/**	 The entity classSolrDocument
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Doc classSolrDocument;

	/**	<br> The entity classSolrDocument
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classSolrDocument">Find the entity classSolrDocument in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSolrDocument(Wrap<Doc> c);

	public Doc getClassSolrDocument() {
		return classSolrDocument;
	}

	public void setClassSolrDocument(Doc classSolrDocument) {
		this.classSolrDocument = classSolrDocument;
	}
	public static Doc staticSetClassSolrDocument(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter classSolrDocumentInit() {
		Wrap<Doc> classSolrDocumentWrap = new Wrap<Doc>().var("classSolrDocument");
		if(classSolrDocument == null) {
			_classSolrDocument(classSolrDocumentWrap);
			Optional.ofNullable(classSolrDocumentWrap.getO()).ifPresent(o -> {
				setClassSolrDocument(o);
			});
		}
		return (ApiWriter)this;
	}

	/////////////////
	// contextRows //
	/////////////////


	/**	 The entity contextRows
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer contextRows;

	/**	<br> The entity contextRows
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:contextRows">Find the entity contextRows in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _contextRows(Wrap<Integer> c);

	public Integer getContextRows() {
		return contextRows;
	}

	public void setContextRows(Integer contextRows) {
		this.contextRows = contextRows;
	}
	@JsonIgnore
	public void setContextRows(String o) {
		this.contextRows = ApiWriter.staticSetContextRows(siteRequest_, o);
	}
	public static Integer staticSetContextRows(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ApiWriter contextRowsInit() {
		Wrap<Integer> contextRowsWrap = new Wrap<Integer>().var("contextRows");
		if(contextRows == null) {
			_contextRows(contextRowsWrap);
			Optional.ofNullable(contextRowsWrap.getO()).ifPresent(o -> {
				setContextRows(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Integer staticSearchContextRows(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrContextRows(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqContextRows(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchContextRows(siteRequest_, ApiWriter.staticSetContextRows(siteRequest_, o)).toString();
	}

	////////////////////
	// classApiMethod //
	////////////////////


	/**	 The entity classApiMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiMethod;

	/**	<br> The entity classApiMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiMethod">Find the entity classApiMethod in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiMethod(Wrap<String> c);

	public String getClassApiMethod() {
		return classApiMethod;
	}
	public void setClassApiMethod(String o) {
		this.classApiMethod = ApiWriter.staticSetClassApiMethod(siteRequest_, o);
	}
	public static String staticSetClassApiMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiMethodInit() {
		Wrap<String> classApiMethodWrap = new Wrap<String>().var("classApiMethod");
		if(classApiMethod == null) {
			_classApiMethod(classApiMethodWrap);
			Optional.ofNullable(classApiMethodWrap.getO()).ifPresent(o -> {
				setClassApiMethod(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiMethod(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiMethod(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiMethod(siteRequest_, ApiWriter.staticSetClassApiMethod(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:openApiVersion">Find the entity openApiVersion in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _openApiVersion(Wrap<String> c);

	public String getOpenApiVersion() {
		return openApiVersion;
	}
	public void setOpenApiVersion(String o) {
		this.openApiVersion = ApiWriter.staticSetOpenApiVersion(siteRequest_, o);
	}
	public static String staticSetOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter openApiVersionInit() {
		Wrap<String> openApiVersionWrap = new Wrap<String>().var("openApiVersion");
		if(openApiVersion == null) {
			_openApiVersion(openApiVersionWrap);
			Optional.ofNullable(openApiVersionWrap.getO()).ifPresent(o -> {
				setOpenApiVersion(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiVersion(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchOpenApiVersion(siteRequest_, ApiWriter.staticSetOpenApiVersion(siteRequest_, o)).toString();
	}

	///////////////
	// classUris //
	///////////////


	/**	 The entity classUris
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> classUris;

	/**	<br> The entity classUris
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classUris">Find the entity classUris in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classUris(Wrap<List<String>> w);

	public List<String> getClassUris() {
		return classUris;
	}

	public void setClassUris(List<String> classUris) {
		this.classUris = classUris;
	}
	@JsonIgnore
	public void setClassUris(String o) {
		String l = ApiWriter.staticSetClassUris(siteRequest_, o);
		if(l != null)
			addClassUris(l);
	}
	public static String staticSetClassUris(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassUris(String...objects) {
		for(String o : objects) {
			addClassUris(o);
		}
		return (ApiWriter)this;
	}
	public ApiWriter addClassUris(String o) {
		if(o != null)
			this.classUris.add(o);
		return (ApiWriter)this;
	}
	@JsonIgnore
	public void setClassUris(JsonArray objects) {
		classUris.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addClassUris(o);
		}
	}
	protected ApiWriter classUrisInit() {
		Wrap<List<String>> classUrisWrap = new Wrap<List<String>>().var("classUris");
		if(classUris == null) {
			_classUris(classUrisWrap);
			Optional.ofNullable(classUrisWrap.getO()).ifPresent(o -> {
				setClassUris(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassUris(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassUris(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassUris(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassUris(siteRequest_, ApiWriter.staticSetClassUris(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:openApiVersionNumber">Find the entity openApiVersionNumber in Solr</a>
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
		this.openApiVersionNumber = ApiWriter.staticSetOpenApiVersionNumber(siteRequest_, o);
	}
	public static Integer staticSetOpenApiVersionNumber(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ApiWriter openApiVersionNumberInit() {
		Wrap<Integer> openApiVersionNumberWrap = new Wrap<Integer>().var("openApiVersionNumber");
		if(openApiVersionNumber == null) {
			_openApiVersionNumber(openApiVersionNumberWrap);
			Optional.ofNullable(openApiVersionNumberWrap.getO()).ifPresent(o -> {
				setOpenApiVersionNumber(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Integer staticSearchOpenApiVersionNumber(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrOpenApiVersionNumber(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiVersionNumber(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchOpenApiVersionNumber(siteRequest_, ApiWriter.staticSetOpenApiVersionNumber(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:tabsSchema">Find the entity tabsSchema in Solr</a>
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
		this.tabsSchema = ApiWriter.staticSetTabsSchema(siteRequest_, o);
	}
	public static Integer staticSetTabsSchema(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ApiWriter tabsSchemaInit() {
		Wrap<Integer> tabsSchemaWrap = new Wrap<Integer>().var("tabsSchema");
		if(tabsSchema == null) {
			_tabsSchema(tabsSchemaWrap);
			Optional.ofNullable(tabsSchemaWrap.getO()).ifPresent(o -> {
				setTabsSchema(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Integer staticSearchTabsSchema(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTabsSchema(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTabsSchema(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchTabsSchema(siteRequest_, ApiWriter.staticSetTabsSchema(siteRequest_, o)).toString();
	}

	///////////////////
	// tabsResponses //
	///////////////////


	/**	 The entity tabsResponses
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer tabsResponses;

	/**	<br> The entity tabsResponses
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:tabsResponses">Find the entity tabsResponses in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _tabsResponses(Wrap<Integer> c);

	public Integer getTabsResponses() {
		return tabsResponses;
	}

	public void setTabsResponses(Integer tabsResponses) {
		this.tabsResponses = tabsResponses;
	}
	@JsonIgnore
	public void setTabsResponses(String o) {
		this.tabsResponses = ApiWriter.staticSetTabsResponses(siteRequest_, o);
	}
	public static Integer staticSetTabsResponses(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ApiWriter tabsResponsesInit() {
		Wrap<Integer> tabsResponsesWrap = new Wrap<Integer>().var("tabsResponses");
		if(tabsResponses == null) {
			_tabsResponses(tabsResponsesWrap);
			Optional.ofNullable(tabsResponsesWrap.getO()).ifPresent(o -> {
				setTabsResponses(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Integer staticSearchTabsResponses(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTabsResponses(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTabsResponses(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchTabsResponses(siteRequest_, ApiWriter.staticSetTabsResponses(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wPaths">Find the entity wPaths in Solr</a>
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
	protected ApiWriter wPathsInit() {
		Wrap<AllWriter> wPathsWrap = new Wrap<AllWriter>().var("wPaths");
		if(wPaths == null) {
			_wPaths(wPathsWrap);
			Optional.ofNullable(wPathsWrap.getO()).ifPresent(o -> {
				setWPaths(o);
			});
		}
		if(wPaths != null)
			wPaths.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wRequestBodies">Find the entity wRequestBodies in Solr</a>
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
	protected ApiWriter wRequestBodiesInit() {
		Wrap<AllWriter> wRequestBodiesWrap = new Wrap<AllWriter>().var("wRequestBodies");
		if(wRequestBodies == null) {
			_wRequestBodies(wRequestBodiesWrap);
			Optional.ofNullable(wRequestBodiesWrap.getO()).ifPresent(o -> {
				setWRequestBodies(o);
			});
		}
		if(wRequestBodies != null)
			wRequestBodies.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wSchemas">Find the entity wSchemas in Solr</a>
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
	protected ApiWriter wSchemasInit() {
		Wrap<AllWriter> wSchemasWrap = new Wrap<AllWriter>().var("wSchemas");
		if(wSchemas == null) {
			_wSchemas(wSchemasWrap);
			Optional.ofNullable(wSchemasWrap.getO()).ifPresent(o -> {
				setWSchemas(o);
			});
		}
		if(wSchemas != null)
			wSchemas.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:config">Find the entity config in Solr</a>
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
		this.config = ApiWriter.staticSetConfig(siteRequest_, o);
	}
	public static JsonObject staticSetConfig(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ApiWriter configInit() {
		Wrap<JsonObject> configWrap = new Wrap<JsonObject>().var("config");
		if(config == null) {
			_config(configWrap);
			Optional.ofNullable(configWrap.getO()).ifPresent(o -> {
				setConfig(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchConfig(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrConfig(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqConfig(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchConfig(siteRequest_, ApiWriter.staticSetConfig(siteRequest_, o)).toString();
	}

	/////////////////
	// authClients //
	/////////////////


	/**	 The entity authClients
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject authClients;

	/**	<br> The entity authClients
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:authClients">Find the entity authClients in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _authClients(Wrap<JsonObject> c);

	public JsonObject getAuthClients() {
		return authClients;
	}

	public void setAuthClients(JsonObject authClients) {
		this.authClients = authClients;
	}
	@JsonIgnore
	public void setAuthClients(String o) {
		this.authClients = ApiWriter.staticSetAuthClients(siteRequest_, o);
	}
	public static JsonObject staticSetAuthClients(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ApiWriter authClientsInit() {
		Wrap<JsonObject> authClientsWrap = new Wrap<JsonObject>().var("authClients");
		if(authClients == null) {
			_authClients(authClientsWrap);
			Optional.ofNullable(authClientsWrap.getO()).ifPresent(o -> {
				setAuthClients(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchAuthClients(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrAuthClients(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAuthClients(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchAuthClients(siteRequest_, ApiWriter.staticSetAuthClients(siteRequest_, o)).toString();
	}

	/////////////////////
	// wRequestHeaders //
	/////////////////////


	/**	 The entity wRequestHeaders
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wRequestHeaders;

	/**	<br> The entity wRequestHeaders
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wRequestHeaders">Find the entity wRequestHeaders in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wRequestHeaders(Wrap<AllWriter> c);

	public AllWriter getWRequestHeaders() {
		return wRequestHeaders;
	}

	public void setWRequestHeaders(AllWriter wRequestHeaders) {
		this.wRequestHeaders = wRequestHeaders;
	}
	public static AllWriter staticSetWRequestHeaders(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestHeadersInit() {
		Wrap<AllWriter> wRequestHeadersWrap = new Wrap<AllWriter>().var("wRequestHeaders");
		if(wRequestHeaders == null) {
			_wRequestHeaders(wRequestHeadersWrap);
			Optional.ofNullable(wRequestHeadersWrap.getO()).ifPresent(o -> {
				setWRequestHeaders(o);
			});
		}
		if(wRequestHeaders != null)
			wRequestHeaders.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
	}

	/////////////////////////
	// wRequestDescription //
	/////////////////////////


	/**	 The entity wRequestDescription
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wRequestDescription;

	/**	<br> The entity wRequestDescription
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wRequestDescription">Find the entity wRequestDescription in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wRequestDescription(Wrap<AllWriter> c);

	public AllWriter getWRequestDescription() {
		return wRequestDescription;
	}

	public void setWRequestDescription(AllWriter wRequestDescription) {
		this.wRequestDescription = wRequestDescription;
	}
	public static AllWriter staticSetWRequestDescription(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestDescriptionInit() {
		Wrap<AllWriter> wRequestDescriptionWrap = new Wrap<AllWriter>().var("wRequestDescription");
		if(wRequestDescription == null) {
			_wRequestDescription(wRequestDescriptionWrap);
			Optional.ofNullable(wRequestDescriptionWrap.getO()).ifPresent(o -> {
				setWRequestDescription(o);
			});
		}
		if(wRequestDescription != null)
			wRequestDescription.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
	}

	//////////////////////////
	// wResponseDescription //
	//////////////////////////


	/**	 The entity wResponseDescription
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wResponseDescription;

	/**	<br> The entity wResponseDescription
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wResponseDescription">Find the entity wResponseDescription in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wResponseDescription(Wrap<AllWriter> c);

	public AllWriter getWResponseDescription() {
		return wResponseDescription;
	}

	public void setWResponseDescription(AllWriter wResponseDescription) {
		this.wResponseDescription = wResponseDescription;
	}
	public static AllWriter staticSetWResponseDescription(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wResponseDescriptionInit() {
		Wrap<AllWriter> wResponseDescriptionWrap = new Wrap<AllWriter>().var("wResponseDescription");
		if(wResponseDescription == null) {
			_wResponseDescription(wResponseDescriptionWrap);
			Optional.ofNullable(wResponseDescriptionWrap.getO()).ifPresent(o -> {
				setWResponseDescription(o);
			});
		}
		if(wResponseDescription != null)
			wResponseDescription.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
	}

	//////////////////
	// wRequestBody //
	//////////////////


	/**	 The entity wRequestBody
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wRequestBody;

	/**	<br> The entity wRequestBody
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wRequestBody">Find the entity wRequestBody in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wRequestBody(Wrap<AllWriter> c);

	public AllWriter getWRequestBody() {
		return wRequestBody;
	}

	public void setWRequestBody(AllWriter wRequestBody) {
		this.wRequestBody = wRequestBody;
	}
	public static AllWriter staticSetWRequestBody(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestBodyInit() {
		Wrap<AllWriter> wRequestBodyWrap = new Wrap<AllWriter>().var("wRequestBody");
		if(wRequestBody == null) {
			_wRequestBody(wRequestBodyWrap);
			Optional.ofNullable(wRequestBodyWrap.getO()).ifPresent(o -> {
				setWRequestBody(o);
			});
		}
		if(wRequestBody != null)
			wRequestBody.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
	}

	///////////////////
	// wResponseBody //
	///////////////////


	/**	 The entity wResponseBody
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wResponseBody;

	/**	<br> The entity wResponseBody
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wResponseBody">Find the entity wResponseBody in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wResponseBody(Wrap<AllWriter> c);

	public AllWriter getWResponseBody() {
		return wResponseBody;
	}

	public void setWResponseBody(AllWriter wResponseBody) {
		this.wResponseBody = wResponseBody;
	}
	public static AllWriter staticSetWResponseBody(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wResponseBodyInit() {
		Wrap<AllWriter> wResponseBodyWrap = new Wrap<AllWriter>().var("wResponseBody");
		if(wResponseBody == null) {
			_wResponseBody(wResponseBodyWrap);
			Optional.ofNullable(wResponseBodyWrap.getO()).ifPresent(o -> {
				setWResponseBody(o);
			});
		}
		if(wResponseBody != null)
			wResponseBody.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
	}

	////////////////////
	// wRequestSchema //
	////////////////////


	/**	 The entity wRequestSchema
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wRequestSchema;

	/**	<br> The entity wRequestSchema
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wRequestSchema">Find the entity wRequestSchema in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wRequestSchema(Wrap<AllWriter> c);

	public AllWriter getWRequestSchema() {
		return wRequestSchema;
	}

	public void setWRequestSchema(AllWriter wRequestSchema) {
		this.wRequestSchema = wRequestSchema;
	}
	public static AllWriter staticSetWRequestSchema(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestSchemaInit() {
		Wrap<AllWriter> wRequestSchemaWrap = new Wrap<AllWriter>().var("wRequestSchema");
		if(wRequestSchema == null) {
			_wRequestSchema(wRequestSchemaWrap);
			Optional.ofNullable(wRequestSchemaWrap.getO()).ifPresent(o -> {
				setWRequestSchema(o);
			});
		}
		if(wRequestSchema != null)
			wRequestSchema.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
	}

	/////////////////////
	// wResponseSchema //
	/////////////////////


	/**	 The entity wResponseSchema
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wResponseSchema;

	/**	<br> The entity wResponseSchema
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:wResponseSchema">Find the entity wResponseSchema in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wResponseSchema(Wrap<AllWriter> c);

	public AllWriter getWResponseSchema() {
		return wResponseSchema;
	}

	public void setWResponseSchema(AllWriter wResponseSchema) {
		this.wResponseSchema = wResponseSchema;
	}
	public static AllWriter staticSetWResponseSchema(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wResponseSchemaInit() {
		Wrap<AllWriter> wResponseSchemaWrap = new Wrap<AllWriter>().var("wResponseSchema");
		if(wResponseSchema == null) {
			_wResponseSchema(wResponseSchemaWrap);
			Optional.ofNullable(wResponseSchemaWrap.getO()).ifPresent(o -> {
				setWResponseSchema(o);
			});
		}
		if(wResponseSchema != null)
			wResponseSchema.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
	}

	/////////////
	// writers //
	/////////////


	/**	 The entity writers
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriters writers;

	/**	<br> The entity writers
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:writers">Find the entity writers in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _writers(Wrap<AllWriters> c);

	public AllWriters getWriters() {
		return writers;
	}

	public void setWriters(AllWriters writers) {
		this.writers = writers;
	}
	public static AllWriters staticSetWriters(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter writersInit() {
		Wrap<AllWriters> writersWrap = new Wrap<AllWriters>().var("writers");
		if(writers == null) {
			_writers(writersWrap);
			Optional.ofNullable(writersWrap.getO()).ifPresent(o -> {
				setWriters(o);
			});
		}
		if(writers != null)
			writers.initDeepForClass(siteRequest_);
		return (ApiWriter)this;
	}

	/////////////////
	// classApiTag //
	/////////////////


	/**	 The entity classApiTag
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiTag;

	/**	<br> The entity classApiTag
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiTag">Find the entity classApiTag in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiTag(Wrap<String> c);

	public String getClassApiTag() {
		return classApiTag;
	}
	public void setClassApiTag(String o) {
		this.classApiTag = ApiWriter.staticSetClassApiTag(siteRequest_, o);
	}
	public static String staticSetClassApiTag(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiTagInit() {
		Wrap<String> classApiTagWrap = new Wrap<String>().var("classApiTag");
		if(classApiTag == null) {
			_classApiTag(classApiTagWrap);
			Optional.ofNullable(classApiTagWrap.getO()).ifPresent(o -> {
				setClassApiTag(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiTag(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiTag(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiTag(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiTag(siteRequest_, ApiWriter.staticSetClassApiTag(siteRequest_, o)).toString();
	}

	//////////////////////
	// classExtendsBase //
	//////////////////////


	/**	 The entity classExtendsBase
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classExtendsBase;

	/**	<br> The entity classExtendsBase
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classExtendsBase">Find the entity classExtendsBase in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classExtendsBase(Wrap<Boolean> c);

	public Boolean getClassExtendsBase() {
		return classExtendsBase;
	}

	public void setClassExtendsBase(Boolean classExtendsBase) {
		this.classExtendsBase = classExtendsBase;
	}
	@JsonIgnore
	public void setClassExtendsBase(String o) {
		this.classExtendsBase = ApiWriter.staticSetClassExtendsBase(siteRequest_, o);
	}
	public static Boolean staticSetClassExtendsBase(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classExtendsBaseInit() {
		Wrap<Boolean> classExtendsBaseWrap = new Wrap<Boolean>().var("classExtendsBase");
		if(classExtendsBase == null) {
			_classExtendsBase(classExtendsBaseWrap);
			Optional.ofNullable(classExtendsBaseWrap.getO()).ifPresent(o -> {
				setClassExtendsBase(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassExtendsBase(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassExtendsBase(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassExtendsBase(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassExtendsBase(siteRequest_, ApiWriter.staticSetClassExtendsBase(siteRequest_, o)).toString();
	}

	/////////////////
	// classIsBase //
	/////////////////


	/**	 The entity classIsBase
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classIsBase;

	/**	<br> The entity classIsBase
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classIsBase">Find the entity classIsBase in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classIsBase(Wrap<Boolean> c);

	public Boolean getClassIsBase() {
		return classIsBase;
	}

	public void setClassIsBase(Boolean classIsBase) {
		this.classIsBase = classIsBase;
	}
	@JsonIgnore
	public void setClassIsBase(String o) {
		this.classIsBase = ApiWriter.staticSetClassIsBase(siteRequest_, o);
	}
	public static Boolean staticSetClassIsBase(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classIsBaseInit() {
		Wrap<Boolean> classIsBaseWrap = new Wrap<Boolean>().var("classIsBase");
		if(classIsBase == null) {
			_classIsBase(classIsBaseWrap);
			Optional.ofNullable(classIsBaseWrap.getO()).ifPresent(o -> {
				setClassIsBase(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassIsBase(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassIsBase(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassIsBase(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassIsBase(siteRequest_, ApiWriter.staticSetClassIsBase(siteRequest_, o)).toString();
	}

	/////////////////
	// classFiware //
	/////////////////


	/**	 The entity classFiware
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classFiware;

	/**	<br> The entity classFiware
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classFiware">Find the entity classFiware in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classFiware(Wrap<Boolean> c);

	public Boolean getClassFiware() {
		return classFiware;
	}

	public void setClassFiware(Boolean classFiware) {
		this.classFiware = classFiware;
	}
	@JsonIgnore
	public void setClassFiware(String o) {
		this.classFiware = ApiWriter.staticSetClassFiware(siteRequest_, o);
	}
	public static Boolean staticSetClassFiware(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classFiwareInit() {
		Wrap<Boolean> classFiwareWrap = new Wrap<Boolean>().var("classFiware");
		if(classFiware == null) {
			_classFiware(classFiwareWrap);
			Optional.ofNullable(classFiwareWrap.getO()).ifPresent(o -> {
				setClassFiware(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassFiware(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassFiware(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassFiware(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassFiware(siteRequest_, ApiWriter.staticSetClassFiware(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSimpleName(Wrap<String> c);

	public String getClassSimpleName() {
		return classSimpleName;
	}
	public void setClassSimpleName(String o) {
		this.classSimpleName = ApiWriter.staticSetClassSimpleName(siteRequest_, o);
	}
	public static String staticSetClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classSimpleNameInit() {
		Wrap<String> classSimpleNameWrap = new Wrap<String>().var("classSimpleName");
		if(classSimpleName == null) {
			_classSimpleName(classSimpleNameWrap);
			Optional.ofNullable(classSimpleNameWrap.getO()).ifPresent(o -> {
				setClassSimpleName(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassSimpleName(siteRequest_, ApiWriter.staticSetClassSimpleName(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:appName">Find the entity appName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _appName(Wrap<String> c);

	public String getAppName() {
		return appName;
	}
	public void setAppName(String o) {
		this.appName = ApiWriter.staticSetAppName(siteRequest_, o);
	}
	public static String staticSetAppName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter appNameInit() {
		Wrap<String> appNameWrap = new Wrap<String>().var("appName");
		if(appName == null) {
			_appName(appNameWrap);
			Optional.ofNullable(appNameWrap.getO()).ifPresent(o -> {
				setAppName(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchAppName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAppName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAppName(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchAppName(siteRequest_, ApiWriter.staticSetAppName(siteRequest_, o)).toString();
	}

	///////////////////////
	// classAbsolutePath //
	///////////////////////


	/**	 The entity classAbsolutePath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classAbsolutePath;

	/**	<br> The entity classAbsolutePath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classAbsolutePath">Find the entity classAbsolutePath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classAbsolutePath(Wrap<String> c);

	public String getClassAbsolutePath() {
		return classAbsolutePath;
	}
	public void setClassAbsolutePath(String o) {
		this.classAbsolutePath = ApiWriter.staticSetClassAbsolutePath(siteRequest_, o);
	}
	public static String staticSetClassAbsolutePath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classAbsolutePathInit() {
		Wrap<String> classAbsolutePathWrap = new Wrap<String>().var("classAbsolutePath");
		if(classAbsolutePath == null) {
			_classAbsolutePath(classAbsolutePathWrap);
			Optional.ofNullable(classAbsolutePathWrap.getO()).ifPresent(o -> {
				setClassAbsolutePath(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassAbsolutePath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassAbsolutePath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassAbsolutePath(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassAbsolutePath(siteRequest_, ApiWriter.staticSetClassAbsolutePath(siteRequest_, o)).toString();
	}

	///////////////////////
	// classApiUriMethod //
	///////////////////////


	/**	 The entity classApiUriMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiUriMethod;

	/**	<br> The entity classApiUriMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiUriMethod">Find the entity classApiUriMethod in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiUriMethod(Wrap<String> c);

	public String getClassApiUriMethod() {
		return classApiUriMethod;
	}
	public void setClassApiUriMethod(String o) {
		this.classApiUriMethod = ApiWriter.staticSetClassApiUriMethod(siteRequest_, o);
	}
	public static String staticSetClassApiUriMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiUriMethodInit() {
		Wrap<String> classApiUriMethodWrap = new Wrap<String>().var("classApiUriMethod");
		if(classApiUriMethod == null) {
			_classApiUriMethod(classApiUriMethodWrap);
			Optional.ofNullable(classApiUriMethodWrap.getO()).ifPresent(o -> {
				setClassApiUriMethod(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiUriMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiUriMethod(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiUriMethod(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiUriMethod(siteRequest_, ApiWriter.staticSetClassApiUriMethod(siteRequest_, o)).toString();
	}

	/////////////////////////
	// classRoleUserMethod //
	/////////////////////////


	/**	 The entity classRoleUserMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classRoleUserMethod;

	/**	<br> The entity classRoleUserMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classRoleUserMethod">Find the entity classRoleUserMethod in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRoleUserMethod(Wrap<Boolean> c);

	public Boolean getClassRoleUserMethod() {
		return classRoleUserMethod;
	}

	public void setClassRoleUserMethod(Boolean classRoleUserMethod) {
		this.classRoleUserMethod = classRoleUserMethod;
	}
	@JsonIgnore
	public void setClassRoleUserMethod(String o) {
		this.classRoleUserMethod = ApiWriter.staticSetClassRoleUserMethod(siteRequest_, o);
	}
	public static Boolean staticSetClassRoleUserMethod(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRoleUserMethodInit() {
		Wrap<Boolean> classRoleUserMethodWrap = new Wrap<Boolean>().var("classRoleUserMethod");
		if(classRoleUserMethod == null) {
			_classRoleUserMethod(classRoleUserMethodWrap);
			Optional.ofNullable(classRoleUserMethodWrap.getO()).ifPresent(o -> {
				setClassRoleUserMethod(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRoleUserMethod(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRoleUserMethod(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleUserMethod(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassRoleUserMethod(siteRequest_, ApiWriter.staticSetClassRoleUserMethod(siteRequest_, o)).toString();
	}

	//////////////////////////
	// classApiMethodMethod //
	//////////////////////////


	/**	 The entity classApiMethodMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiMethodMethod;

	/**	<br> The entity classApiMethodMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiMethodMethod">Find the entity classApiMethodMethod in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiMethodMethod(Wrap<String> c);

	public String getClassApiMethodMethod() {
		return classApiMethodMethod;
	}
	public void setClassApiMethodMethod(String o) {
		this.classApiMethodMethod = ApiWriter.staticSetClassApiMethodMethod(siteRequest_, o);
	}
	public static String staticSetClassApiMethodMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiMethodMethodInit() {
		Wrap<String> classApiMethodMethodWrap = new Wrap<String>().var("classApiMethodMethod");
		if(classApiMethodMethod == null) {
			_classApiMethodMethod(classApiMethodMethodWrap);
			Optional.ofNullable(classApiMethodMethodWrap.getO()).ifPresent(o -> {
				setClassApiMethodMethod(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiMethodMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiMethodMethod(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiMethodMethod(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiMethodMethod(siteRequest_, ApiWriter.staticSetClassApiMethodMethod(siteRequest_, o)).toString();
	}

	////////////////////////////////////
	// classApiMediaTypeRequestMethod //
	////////////////////////////////////


	/**	 The entity classApiMediaTypeRequestMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiMediaTypeRequestMethod;

	/**	<br> The entity classApiMediaTypeRequestMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiMediaTypeRequestMethod">Find the entity classApiMediaTypeRequestMethod in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiMediaTypeRequestMethod(Wrap<String> c);

	public String getClassApiMediaTypeRequestMethod() {
		return classApiMediaTypeRequestMethod;
	}
	public void setClassApiMediaTypeRequestMethod(String o) {
		this.classApiMediaTypeRequestMethod = ApiWriter.staticSetClassApiMediaTypeRequestMethod(siteRequest_, o);
	}
	public static String staticSetClassApiMediaTypeRequestMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiMediaTypeRequestMethodInit() {
		Wrap<String> classApiMediaTypeRequestMethodWrap = new Wrap<String>().var("classApiMediaTypeRequestMethod");
		if(classApiMediaTypeRequestMethod == null) {
			_classApiMediaTypeRequestMethod(classApiMediaTypeRequestMethodWrap);
			Optional.ofNullable(classApiMediaTypeRequestMethodWrap.getO()).ifPresent(o -> {
				setClassApiMediaTypeRequestMethod(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiMediaTypeRequestMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiMediaTypeRequestMethod(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiMediaTypeRequestMethod(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiMediaTypeRequestMethod(siteRequest_, ApiWriter.staticSetClassApiMediaTypeRequestMethod(siteRequest_, o)).toString();
	}

	////////////////////////////////
	// classApiMediaType200Method //
	////////////////////////////////


	/**	 The entity classApiMediaType200Method
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiMediaType200Method;

	/**	<br> The entity classApiMediaType200Method
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiMediaType200Method">Find the entity classApiMediaType200Method in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiMediaType200Method(Wrap<String> c);

	public String getClassApiMediaType200Method() {
		return classApiMediaType200Method;
	}
	public void setClassApiMediaType200Method(String o) {
		this.classApiMediaType200Method = ApiWriter.staticSetClassApiMediaType200Method(siteRequest_, o);
	}
	public static String staticSetClassApiMediaType200Method(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiMediaType200MethodInit() {
		Wrap<String> classApiMediaType200MethodWrap = new Wrap<String>().var("classApiMediaType200Method");
		if(classApiMediaType200Method == null) {
			_classApiMediaType200Method(classApiMediaType200MethodWrap);
			Optional.ofNullable(classApiMediaType200MethodWrap.getO()).ifPresent(o -> {
				setClassApiMediaType200Method(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiMediaType200Method(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiMediaType200Method(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiMediaType200Method(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiMediaType200Method(siteRequest_, ApiWriter.staticSetClassApiMediaType200Method(siteRequest_, o)).toString();
	}

	///////////////////////////////
	// classApiOperationIdMethod //
	///////////////////////////////


	/**	 The entity classApiOperationIdMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiOperationIdMethod;

	/**	<br> The entity classApiOperationIdMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiOperationIdMethod">Find the entity classApiOperationIdMethod in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiOperationIdMethod(Wrap<String> c);

	public String getClassApiOperationIdMethod() {
		return classApiOperationIdMethod;
	}
	public void setClassApiOperationIdMethod(String o) {
		this.classApiOperationIdMethod = ApiWriter.staticSetClassApiOperationIdMethod(siteRequest_, o);
	}
	public static String staticSetClassApiOperationIdMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiOperationIdMethodInit() {
		Wrap<String> classApiOperationIdMethodWrap = new Wrap<String>().var("classApiOperationIdMethod");
		if(classApiOperationIdMethod == null) {
			_classApiOperationIdMethod(classApiOperationIdMethodWrap);
			Optional.ofNullable(classApiOperationIdMethodWrap.getO()).ifPresent(o -> {
				setClassApiOperationIdMethod(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiOperationIdMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiOperationIdMethod(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiOperationIdMethod(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiOperationIdMethod(siteRequest_, ApiWriter.staticSetClassApiOperationIdMethod(siteRequest_, o)).toString();
	}

	//////////////////////////////////////
	// classApiOperationIdMethodRequest //
	//////////////////////////////////////


	/**	 The entity classApiOperationIdMethodRequest
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiOperationIdMethodRequest;

	/**	<br> The entity classApiOperationIdMethodRequest
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiOperationIdMethodRequest">Find the entity classApiOperationIdMethodRequest in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiOperationIdMethodRequest(Wrap<String> c);

	public String getClassApiOperationIdMethodRequest() {
		return classApiOperationIdMethodRequest;
	}
	public void setClassApiOperationIdMethodRequest(String o) {
		this.classApiOperationIdMethodRequest = ApiWriter.staticSetClassApiOperationIdMethodRequest(siteRequest_, o);
	}
	public static String staticSetClassApiOperationIdMethodRequest(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiOperationIdMethodRequestInit() {
		Wrap<String> classApiOperationIdMethodRequestWrap = new Wrap<String>().var("classApiOperationIdMethodRequest");
		if(classApiOperationIdMethodRequest == null) {
			_classApiOperationIdMethodRequest(classApiOperationIdMethodRequestWrap);
			Optional.ofNullable(classApiOperationIdMethodRequestWrap.getO()).ifPresent(o -> {
				setClassApiOperationIdMethodRequest(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiOperationIdMethodRequest(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiOperationIdMethodRequest(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiOperationIdMethodRequest(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiOperationIdMethodRequest(siteRequest_, ApiWriter.staticSetClassApiOperationIdMethodRequest(siteRequest_, o)).toString();
	}

	///////////////////////////////////////
	// classApiOperationIdMethodResponse //
	///////////////////////////////////////


	/**	 The entity classApiOperationIdMethodResponse
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classApiOperationIdMethodResponse;

	/**	<br> The entity classApiOperationIdMethodResponse
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classApiOperationIdMethodResponse">Find the entity classApiOperationIdMethodResponse in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classApiOperationIdMethodResponse(Wrap<String> c);

	public String getClassApiOperationIdMethodResponse() {
		return classApiOperationIdMethodResponse;
	}
	public void setClassApiOperationIdMethodResponse(String o) {
		this.classApiOperationIdMethodResponse = ApiWriter.staticSetClassApiOperationIdMethodResponse(siteRequest_, o);
	}
	public static String staticSetClassApiOperationIdMethodResponse(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiOperationIdMethodResponseInit() {
		Wrap<String> classApiOperationIdMethodResponseWrap = new Wrap<String>().var("classApiOperationIdMethodResponse");
		if(classApiOperationIdMethodResponse == null) {
			_classApiOperationIdMethodResponse(classApiOperationIdMethodResponseWrap);
			Optional.ofNullable(classApiOperationIdMethodResponseWrap.getO()).ifPresent(o -> {
				setClassApiOperationIdMethodResponse(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiOperationIdMethodResponse(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiOperationIdMethodResponse(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiOperationIdMethodResponse(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassApiOperationIdMethodResponse(siteRequest_, ApiWriter.staticSetClassApiOperationIdMethodResponse(siteRequest_, o)).toString();
	}

	///////////////////////////////////////////
	// classSuperApiOperationIdMethodRequest //
	///////////////////////////////////////////


	/**	 The entity classSuperApiOperationIdMethodRequest
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classSuperApiOperationIdMethodRequest;

	/**	<br> The entity classSuperApiOperationIdMethodRequest
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classSuperApiOperationIdMethodRequest">Find the entity classSuperApiOperationIdMethodRequest in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSuperApiOperationIdMethodRequest(Wrap<String> c);

	public String getClassSuperApiOperationIdMethodRequest() {
		return classSuperApiOperationIdMethodRequest;
	}
	public void setClassSuperApiOperationIdMethodRequest(String o) {
		this.classSuperApiOperationIdMethodRequest = ApiWriter.staticSetClassSuperApiOperationIdMethodRequest(siteRequest_, o);
	}
	public static String staticSetClassSuperApiOperationIdMethodRequest(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classSuperApiOperationIdMethodRequestInit() {
		Wrap<String> classSuperApiOperationIdMethodRequestWrap = new Wrap<String>().var("classSuperApiOperationIdMethodRequest");
		if(classSuperApiOperationIdMethodRequest == null) {
			_classSuperApiOperationIdMethodRequest(classSuperApiOperationIdMethodRequestWrap);
			Optional.ofNullable(classSuperApiOperationIdMethodRequestWrap.getO()).ifPresent(o -> {
				setClassSuperApiOperationIdMethodRequest(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassSuperApiOperationIdMethodRequest(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassSuperApiOperationIdMethodRequest(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSuperApiOperationIdMethodRequest(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassSuperApiOperationIdMethodRequest(siteRequest_, ApiWriter.staticSetClassSuperApiOperationIdMethodRequest(siteRequest_, o)).toString();
	}

	////////////////////////////////////////////
	// classSuperApiOperationIdMethodResponse //
	////////////////////////////////////////////


	/**	 The entity classSuperApiOperationIdMethodResponse
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classSuperApiOperationIdMethodResponse;

	/**	<br> The entity classSuperApiOperationIdMethodResponse
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classSuperApiOperationIdMethodResponse">Find the entity classSuperApiOperationIdMethodResponse in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSuperApiOperationIdMethodResponse(Wrap<String> c);

	public String getClassSuperApiOperationIdMethodResponse() {
		return classSuperApiOperationIdMethodResponse;
	}
	public void setClassSuperApiOperationIdMethodResponse(String o) {
		this.classSuperApiOperationIdMethodResponse = ApiWriter.staticSetClassSuperApiOperationIdMethodResponse(siteRequest_, o);
	}
	public static String staticSetClassSuperApiOperationIdMethodResponse(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classSuperApiOperationIdMethodResponseInit() {
		Wrap<String> classSuperApiOperationIdMethodResponseWrap = new Wrap<String>().var("classSuperApiOperationIdMethodResponse");
		if(classSuperApiOperationIdMethodResponse == null) {
			_classSuperApiOperationIdMethodResponse(classSuperApiOperationIdMethodResponseWrap);
			Optional.ofNullable(classSuperApiOperationIdMethodResponseWrap.getO()).ifPresent(o -> {
				setClassSuperApiOperationIdMethodResponse(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassSuperApiOperationIdMethodResponse(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassSuperApiOperationIdMethodResponse(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSuperApiOperationIdMethodResponse(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassSuperApiOperationIdMethodResponse(siteRequest_, ApiWriter.staticSetClassSuperApiOperationIdMethodResponse(siteRequest_, o)).toString();
	}

	//////////////////////////////////
	// classPageCanonicalNameMethod //
	//////////////////////////////////


	/**	 The entity classPageCanonicalNameMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classPageCanonicalNameMethod;

	/**	<br> The entity classPageCanonicalNameMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classPageCanonicalNameMethod">Find the entity classPageCanonicalNameMethod in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classPageCanonicalNameMethod(Wrap<String> c);

	public String getClassPageCanonicalNameMethod() {
		return classPageCanonicalNameMethod;
	}
	public void setClassPageCanonicalNameMethod(String o) {
		this.classPageCanonicalNameMethod = ApiWriter.staticSetClassPageCanonicalNameMethod(siteRequest_, o);
	}
	public static String staticSetClassPageCanonicalNameMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classPageCanonicalNameMethodInit() {
		Wrap<String> classPageCanonicalNameMethodWrap = new Wrap<String>().var("classPageCanonicalNameMethod");
		if(classPageCanonicalNameMethod == null) {
			_classPageCanonicalNameMethod(classPageCanonicalNameMethodWrap);
			Optional.ofNullable(classPageCanonicalNameMethodWrap.getO()).ifPresent(o -> {
				setClassPageCanonicalNameMethod(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassPageCanonicalNameMethod(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassPageCanonicalNameMethod(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassPageCanonicalNameMethod(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassPageCanonicalNameMethod(siteRequest_, ApiWriter.staticSetClassPageCanonicalNameMethod(siteRequest_, o)).toString();
	}

	/////////////////////////////////
	// classPageWithTemplateMethod //
	/////////////////////////////////


	/**	 The entity classPageWithTemplateMethod
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classPageWithTemplateMethod;

	/**	<br> The entity classPageWithTemplateMethod
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classPageWithTemplateMethod">Find the entity classPageWithTemplateMethod in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classPageWithTemplateMethod(Wrap<Boolean> w);

	public Boolean getClassPageWithTemplateMethod() {
		return classPageWithTemplateMethod;
	}

	public void setClassPageWithTemplateMethod(Boolean classPageWithTemplateMethod) {
		this.classPageWithTemplateMethod = classPageWithTemplateMethod;
	}
	@JsonIgnore
	public void setClassPageWithTemplateMethod(String o) {
		this.classPageWithTemplateMethod = ApiWriter.staticSetClassPageWithTemplateMethod(siteRequest_, o);
	}
	public static Boolean staticSetClassPageWithTemplateMethod(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classPageWithTemplateMethodInit() {
		Wrap<Boolean> classPageWithTemplateMethodWrap = new Wrap<Boolean>().var("classPageWithTemplateMethod");
		if(classPageWithTemplateMethod == null) {
			_classPageWithTemplateMethod(classPageWithTemplateMethodWrap);
			Optional.ofNullable(classPageWithTemplateMethodWrap.getO()).ifPresent(o -> {
				setClassPageWithTemplateMethod(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassPageWithTemplateMethod(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassPageWithTemplateMethod(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassPageWithTemplateMethod(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassPageWithTemplateMethod(siteRequest_, ApiWriter.staticSetClassPageWithTemplateMethod(siteRequest_, o)).toString();
	}

	////////////////////////
	// classKeywordsFound //
	////////////////////////


	/**	 The entity classKeywordsFound
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classKeywordsFound;

	/**	<br> The entity classKeywordsFound
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classKeywordsFound">Find the entity classKeywordsFound in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classKeywordsFound(Wrap<Boolean> c);

	public Boolean getClassKeywordsFound() {
		return classKeywordsFound;
	}

	public void setClassKeywordsFound(Boolean classKeywordsFound) {
		this.classKeywordsFound = classKeywordsFound;
	}
	@JsonIgnore
	public void setClassKeywordsFound(String o) {
		this.classKeywordsFound = ApiWriter.staticSetClassKeywordsFound(siteRequest_, o);
	}
	public static Boolean staticSetClassKeywordsFound(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classKeywordsFoundInit() {
		Wrap<Boolean> classKeywordsFoundWrap = new Wrap<Boolean>().var("classKeywordsFound");
		if(classKeywordsFound == null) {
			_classKeywordsFound(classKeywordsFoundWrap);
			Optional.ofNullable(classKeywordsFoundWrap.getO()).ifPresent(o -> {
				setClassKeywordsFound(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassKeywordsFound(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassKeywordsFound(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassKeywordsFound(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassKeywordsFound(siteRequest_, ApiWriter.staticSetClassKeywordsFound(siteRequest_, o)).toString();
	}

	///////////////////
	// classKeywords //
	///////////////////


	/**	 The entity classKeywords
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> classKeywords;

	/**	<br> The entity classKeywords
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classKeywords">Find the entity classKeywords in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classKeywords(Wrap<List<String>> c);

	public List<String> getClassKeywords() {
		return classKeywords;
	}

	public void setClassKeywords(List<String> classKeywords) {
		this.classKeywords = classKeywords;
	}
	@JsonIgnore
	public void setClassKeywords(String o) {
		String l = ApiWriter.staticSetClassKeywords(siteRequest_, o);
		if(l != null)
			addClassKeywords(l);
	}
	public static String staticSetClassKeywords(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassKeywords(String...objects) {
		for(String o : objects) {
			addClassKeywords(o);
		}
		return (ApiWriter)this;
	}
	public ApiWriter addClassKeywords(String o) {
		if(o != null)
			this.classKeywords.add(o);
		return (ApiWriter)this;
	}
	@JsonIgnore
	public void setClassKeywords(JsonArray objects) {
		classKeywords.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addClassKeywords(o);
		}
	}
	protected ApiWriter classKeywordsInit() {
		Wrap<List<String>> classKeywordsWrap = new Wrap<List<String>>().var("classKeywords");
		if(classKeywords == null) {
			_classKeywords(classKeywordsWrap);
			Optional.ofNullable(classKeywordsWrap.getO()).ifPresent(o -> {
				setClassKeywords(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassKeywords(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassKeywords(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassKeywords(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassKeywords(siteRequest_, ApiWriter.staticSetClassKeywords(siteRequest_, o)).toString();
	}

	/////////////////////
	// classPublicRead //
	/////////////////////


	/**	 The entity classPublicRead
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classPublicRead;

	/**	<br> The entity classPublicRead
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classPublicRead">Find the entity classPublicRead in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classPublicRead(Wrap<Boolean> c);

	public Boolean getClassPublicRead() {
		return classPublicRead;
	}

	public void setClassPublicRead(Boolean classPublicRead) {
		this.classPublicRead = classPublicRead;
	}
	@JsonIgnore
	public void setClassPublicRead(String o) {
		this.classPublicRead = ApiWriter.staticSetClassPublicRead(siteRequest_, o);
	}
	public static Boolean staticSetClassPublicRead(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classPublicReadInit() {
		Wrap<Boolean> classPublicReadWrap = new Wrap<Boolean>().var("classPublicRead");
		if(classPublicRead == null) {
			_classPublicRead(classPublicReadWrap);
			Optional.ofNullable(classPublicReadWrap.getO()).ifPresent(o -> {
				setClassPublicRead(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassPublicRead(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassPublicRead(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassPublicRead(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassPublicRead(siteRequest_, ApiWriter.staticSetClassPublicRead(siteRequest_, o)).toString();
	}

	///////////////////////////////
	// classSearchPagePublicRead //
	///////////////////////////////


	/**	 The entity classSearchPagePublicRead
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classSearchPagePublicRead;

	/**	<br> The entity classSearchPagePublicRead
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classSearchPagePublicRead">Find the entity classSearchPagePublicRead in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSearchPagePublicRead(Wrap<Boolean> c);

	public Boolean getClassSearchPagePublicRead() {
		return classSearchPagePublicRead;
	}

	public void setClassSearchPagePublicRead(Boolean classSearchPagePublicRead) {
		this.classSearchPagePublicRead = classSearchPagePublicRead;
	}
	@JsonIgnore
	public void setClassSearchPagePublicRead(String o) {
		this.classSearchPagePublicRead = ApiWriter.staticSetClassSearchPagePublicRead(siteRequest_, o);
	}
	public static Boolean staticSetClassSearchPagePublicRead(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classSearchPagePublicReadInit() {
		Wrap<Boolean> classSearchPagePublicReadWrap = new Wrap<Boolean>().var("classSearchPagePublicRead");
		if(classSearchPagePublicRead == null) {
			_classSearchPagePublicRead(classSearchPagePublicReadWrap);
			Optional.ofNullable(classSearchPagePublicReadWrap.getO()).ifPresent(o -> {
				setClassSearchPagePublicRead(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassSearchPagePublicRead(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassSearchPagePublicRead(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSearchPagePublicRead(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassSearchPagePublicRead(siteRequest_, ApiWriter.staticSetClassSearchPagePublicRead(siteRequest_, o)).toString();
	}

	//////////////////////
	// classRoleSession //
	//////////////////////


	/**	 The entity classRoleSession
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classRoleSession;

	/**	<br> The entity classRoleSession
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classRoleSession">Find the entity classRoleSession in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRoleSession(Wrap<Boolean> c);

	public Boolean getClassRoleSession() {
		return classRoleSession;
	}

	public void setClassRoleSession(Boolean classRoleSession) {
		this.classRoleSession = classRoleSession;
	}
	@JsonIgnore
	public void setClassRoleSession(String o) {
		this.classRoleSession = ApiWriter.staticSetClassRoleSession(siteRequest_, o);
	}
	public static Boolean staticSetClassRoleSession(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRoleSessionInit() {
		Wrap<Boolean> classRoleSessionWrap = new Wrap<Boolean>().var("classRoleSession");
		if(classRoleSession == null) {
			_classRoleSession(classRoleSessionWrap);
			Optional.ofNullable(classRoleSessionWrap.getO()).ifPresent(o -> {
				setClassRoleSession(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRoleSession(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRoleSession(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleSession(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassRoleSession(siteRequest_, ApiWriter.staticSetClassRoleSession(siteRequest_, o)).toString();
	}

	///////////////////
	// classRoleUser //
	///////////////////


	/**	 The entity classRoleUser
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classRoleUser;

	/**	<br> The entity classRoleUser
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classRoleUser">Find the entity classRoleUser in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRoleUser(Wrap<Boolean> c);

	public Boolean getClassRoleUser() {
		return classRoleUser;
	}

	public void setClassRoleUser(Boolean classRoleUser) {
		this.classRoleUser = classRoleUser;
	}
	@JsonIgnore
	public void setClassRoleUser(String o) {
		this.classRoleUser = ApiWriter.staticSetClassRoleUser(siteRequest_, o);
	}
	public static Boolean staticSetClassRoleUser(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRoleUserInit() {
		Wrap<Boolean> classRoleUserWrap = new Wrap<Boolean>().var("classRoleUser");
		if(classRoleUser == null) {
			_classRoleUser(classRoleUserWrap);
			Optional.ofNullable(classRoleUserWrap.getO()).ifPresent(o -> {
				setClassRoleUser(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRoleUser(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRoleUser(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleUser(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassRoleUser(siteRequest_, ApiWriter.staticSetClassRoleUser(siteRequest_, o)).toString();
	}

	//////////////////
	// classRoleAll //
	//////////////////


	/**	 The entity classRoleAll
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classRoleAll;

	/**	<br> The entity classRoleAll
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classRoleAll">Find the entity classRoleAll in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRoleAll(Wrap<Boolean> c);

	public Boolean getClassRoleAll() {
		return classRoleAll;
	}

	public void setClassRoleAll(Boolean classRoleAll) {
		this.classRoleAll = classRoleAll;
	}
	@JsonIgnore
	public void setClassRoleAll(String o) {
		this.classRoleAll = ApiWriter.staticSetClassRoleAll(siteRequest_, o);
	}
	public static Boolean staticSetClassRoleAll(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRoleAllInit() {
		Wrap<Boolean> classRoleAllWrap = new Wrap<Boolean>().var("classRoleAll");
		if(classRoleAll == null) {
			_classRoleAll(classRoleAllWrap);
			Optional.ofNullable(classRoleAllWrap.getO()).ifPresent(o -> {
				setClassRoleAll(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRoleAll(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRoleAll(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleAll(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassRoleAll(siteRequest_, ApiWriter.staticSetClassRoleAll(siteRequest_, o)).toString();
	}

	///////////////
	// classAuth //
	///////////////


	/**	 The entity classAuth
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classAuth;

	/**	<br> The entity classAuth
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classAuth">Find the entity classAuth in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classAuth(Wrap<Boolean> c);

	public Boolean getClassAuth() {
		return classAuth;
	}

	public void setClassAuth(Boolean classAuth) {
		this.classAuth = classAuth;
	}
	@JsonIgnore
	public void setClassAuth(String o) {
		this.classAuth = ApiWriter.staticSetClassAuth(siteRequest_, o);
	}
	public static Boolean staticSetClassAuth(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classAuthInit() {
		Wrap<Boolean> classAuthWrap = new Wrap<Boolean>().var("classAuth");
		if(classAuth == null) {
			_classAuth(classAuthWrap);
			Optional.ofNullable(classAuthWrap.getO()).ifPresent(o -> {
				setClassAuth(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassAuth(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassAuth(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassAuth(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassAuth(siteRequest_, ApiWriter.staticSetClassAuth(siteRequest_, o)).toString();
	}

	/////////////////////
	// classRolesFound //
	/////////////////////


	/**	 The entity classRolesFound
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classRolesFound;

	/**	<br> The entity classRolesFound
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classRolesFound">Find the entity classRolesFound in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRolesFound(Wrap<Boolean> c);

	public Boolean getClassRolesFound() {
		return classRolesFound;
	}

	public void setClassRolesFound(Boolean classRolesFound) {
		this.classRolesFound = classRolesFound;
	}
	@JsonIgnore
	public void setClassRolesFound(String o) {
		this.classRolesFound = ApiWriter.staticSetClassRolesFound(siteRequest_, o);
	}
	public static Boolean staticSetClassRolesFound(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRolesFoundInit() {
		Wrap<Boolean> classRolesFoundWrap = new Wrap<Boolean>().var("classRolesFound");
		if(classRolesFound == null) {
			_classRolesFound(classRolesFoundWrap);
			Optional.ofNullable(classRolesFoundWrap.getO()).ifPresent(o -> {
				setClassRolesFound(o);
			});
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRolesFound(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRolesFound(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRolesFound(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassRolesFound(siteRequest_, ApiWriter.staticSetClassRolesFound(siteRequest_, o)).toString();
	}

	////////////////
	// classRoles //
	////////////////


	/**	 The entity classRoles
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> classRoles;

	/**	<br> The entity classRoles
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classRoles">Find the entity classRoles in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRoles(Wrap<List<String>> c);

	public List<String> getClassRoles() {
		return classRoles;
	}

	public void setClassRoles(List<String> classRoles) {
		this.classRoles = classRoles;
	}
	@JsonIgnore
	public void setClassRoles(String o) {
		String l = ApiWriter.staticSetClassRoles(siteRequest_, o);
		if(l != null)
			addClassRoles(l);
	}
	public static String staticSetClassRoles(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassRoles(String...objects) {
		for(String o : objects) {
			addClassRoles(o);
		}
		return (ApiWriter)this;
	}
	public ApiWriter addClassRoles(String o) {
		if(o != null)
			this.classRoles.add(o);
		return (ApiWriter)this;
	}
	@JsonIgnore
	public void setClassRoles(JsonArray objects) {
		classRoles.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addClassRoles(o);
		}
	}
	protected ApiWriter classRolesInit() {
		Wrap<List<String>> classRolesWrap = new Wrap<List<String>>().var("classRoles");
		if(classRoles == null) {
			_classRoles(classRolesWrap);
			Optional.ofNullable(classRolesWrap.getO()).ifPresent(o -> {
				setClassRoles(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassRoles(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassRoles(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoles(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassRoles(siteRequest_, ApiWriter.staticSetClassRoles(siteRequest_, o)).toString();
	}

	////////////////////
	// classRoleReads //
	////////////////////


	/**	 The entity classRoleReads
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> classRoleReads;

	/**	<br> The entity classRoleReads
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classRoleReads">Find the entity classRoleReads in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRoleReads(Wrap<List<String>> c);

	public List<String> getClassRoleReads() {
		return classRoleReads;
	}

	public void setClassRoleReads(List<String> classRoleReads) {
		this.classRoleReads = classRoleReads;
	}
	@JsonIgnore
	public void setClassRoleReads(String o) {
		String l = ApiWriter.staticSetClassRoleReads(siteRequest_, o);
		if(l != null)
			addClassRoleReads(l);
	}
	public static String staticSetClassRoleReads(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassRoleReads(String...objects) {
		for(String o : objects) {
			addClassRoleReads(o);
		}
		return (ApiWriter)this;
	}
	public ApiWriter addClassRoleReads(String o) {
		if(o != null)
			this.classRoleReads.add(o);
		return (ApiWriter)this;
	}
	@JsonIgnore
	public void setClassRoleReads(JsonArray objects) {
		classRoleReads.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addClassRoleReads(o);
		}
	}
	protected ApiWriter classRoleReadsInit() {
		Wrap<List<String>> classRoleReadsWrap = new Wrap<List<String>>().var("classRoleReads");
		if(classRoleReads == null) {
			_classRoleReads(classRoleReadsWrap);
			Optional.ofNullable(classRoleReadsWrap.getO()).ifPresent(o -> {
				setClassRoleReads(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassRoleReads(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassRoleReads(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleReads(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassRoleReads(siteRequest_, ApiWriter.staticSetClassRoleReads(siteRequest_, o)).toString();
	}

	////////////////////////
	// classRolesLanguage //
	////////////////////////


	/**	 The entity classRolesLanguage
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> classRolesLanguage;

	/**	<br> The entity classRolesLanguage
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:classRolesLanguage">Find the entity classRolesLanguage in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRolesLanguage(Wrap<List<String>> c);

	public List<String> getClassRolesLanguage() {
		return classRolesLanguage;
	}

	public void setClassRolesLanguage(List<String> classRolesLanguage) {
		this.classRolesLanguage = classRolesLanguage;
	}
	@JsonIgnore
	public void setClassRolesLanguage(String o) {
		String l = ApiWriter.staticSetClassRolesLanguage(siteRequest_, o);
		if(l != null)
			addClassRolesLanguage(l);
	}
	public static String staticSetClassRolesLanguage(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassRolesLanguage(String...objects) {
		for(String o : objects) {
			addClassRolesLanguage(o);
		}
		return (ApiWriter)this;
	}
	public ApiWriter addClassRolesLanguage(String o) {
		if(o != null)
			this.classRolesLanguage.add(o);
		return (ApiWriter)this;
	}
	@JsonIgnore
	public void setClassRolesLanguage(JsonArray objects) {
		classRolesLanguage.clear();
		if(objects == null)
			return;
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addClassRolesLanguage(o);
		}
	}
	protected ApiWriter classRolesLanguageInit() {
		Wrap<List<String>> classRolesLanguageWrap = new Wrap<List<String>>().var("classRolesLanguage");
		if(classRolesLanguage == null) {
			_classRolesLanguage(classRolesLanguageWrap);
			Optional.ofNullable(classRolesLanguageWrap.getO()).ifPresent(o -> {
				setClassRolesLanguage(o);
			});
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassRolesLanguage(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassRolesLanguage(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRolesLanguage(ComputateSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchClassRolesLanguage(siteRequest_, ApiWriter.staticSetClassRolesLanguage(siteRequest_, o)).toString();
	}

	////////////////////////
	// entitySolrDocument //
	////////////////////////


	/**	 The entity entitySolrDocument
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Doc entitySolrDocument;

	/**	<br> The entity entitySolrDocument
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=entiteVar_enUS_indexed_string:entitySolrDocument">Find the entity entitySolrDocument in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _entitySolrDocument(Wrap<Doc> c);

	public Doc getEntitySolrDocument() {
		return entitySolrDocument;
	}

	public void setEntitySolrDocument(Doc entitySolrDocument) {
		this.entitySolrDocument = entitySolrDocument;
	}
	public static Doc staticSetEntitySolrDocument(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter entitySolrDocumentInit() {
		Wrap<Doc> entitySolrDocumentWrap = new Wrap<Doc>().var("entitySolrDocument");
		if(entitySolrDocument == null) {
			_entitySolrDocument(entitySolrDocumentWrap);
			Optional.ofNullable(entitySolrDocumentWrap.getO()).ifPresent(o -> {
				setEntitySolrDocument(o);
			});
		}
		return (ApiWriter)this;
	}

	//////////////
	// initDeep //
	//////////////

	public ApiWriter initDeepApiWriter(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepApiWriter();
		return (ApiWriter)this;
	}

	public void initDeepApiWriter() {
		initApiWriter();
	}

	public void initApiWriter() {
				siteRequest_Init();
				languageNameInit();
				i18nInit();
				classDocInit();
				classSolrDocumentInit();
				contextRowsInit();
				classApiMethodInit();
				openApiVersionInit();
				classUrisInit();
				openApiVersionNumberInit();
				tabsSchemaInit();
				tabsResponsesInit();
				wPathsInit();
				wRequestBodiesInit();
				wSchemasInit();
				configInit();
				authClientsInit();
				wRequestHeadersInit();
				wRequestDescriptionInit();
				wResponseDescriptionInit();
				wRequestBodyInit();
				wResponseBodyInit();
				wRequestSchemaInit();
				wResponseSchemaInit();
				writersInit();
				classApiTagInit();
				classExtendsBaseInit();
				classIsBaseInit();
				classFiwareInit();
				classSimpleNameInit();
				appNameInit();
				classAbsolutePathInit();
				classApiUriMethodInit();
				classRoleUserMethodInit();
				classApiMethodMethodInit();
				classApiMediaTypeRequestMethodInit();
				classApiMediaType200MethodInit();
				classApiOperationIdMethodInit();
				classApiOperationIdMethodRequestInit();
				classApiOperationIdMethodResponseInit();
				classSuperApiOperationIdMethodRequestInit();
				classSuperApiOperationIdMethodResponseInit();
				classPageCanonicalNameMethodInit();
				classPageWithTemplateMethodInit();
				classKeywordsFoundInit();
				classKeywordsInit();
				classPublicReadInit();
				classSearchPagePublicReadInit();
				classRoleSessionInit();
				classRoleUserInit();
				classRoleAllInit();
				classAuthInit();
				classRolesFoundInit();
				classRolesInit();
				classRoleReadsInit();
				classRolesLanguageInit();
				entitySolrDocumentInit();
	}

	public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepApiWriter(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestApiWriter(ComputateSiteRequest siteRequest_) {
		if(wPaths != null)
			wPaths.setSiteRequest_(siteRequest_);
		if(wRequestBodies != null)
			wRequestBodies.setSiteRequest_(siteRequest_);
		if(wSchemas != null)
			wSchemas.setSiteRequest_(siteRequest_);
		if(wRequestHeaders != null)
			wRequestHeaders.setSiteRequest_(siteRequest_);
		if(wRequestDescription != null)
			wRequestDescription.setSiteRequest_(siteRequest_);
		if(wResponseDescription != null)
			wResponseDescription.setSiteRequest_(siteRequest_);
		if(wRequestBody != null)
			wRequestBody.setSiteRequest_(siteRequest_);
		if(wResponseBody != null)
			wResponseBody.setSiteRequest_(siteRequest_);
		if(wRequestSchema != null)
			wRequestSchema.setSiteRequest_(siteRequest_);
		if(wResponseSchema != null)
			wResponseSchema.setSiteRequest_(siteRequest_);
		if(writers != null)
			writers.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestApiWriter(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainApiWriter(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainApiWriter(String var) {
		ApiWriter oApiWriter = (ApiWriter)this;
		switch(var) {
			case "siteRequest_":
				return oApiWriter.siteRequest_;
			case "languageName":
				return oApiWriter.languageName;
			case "i18n":
				return oApiWriter.i18n;
			case "classDoc":
				return oApiWriter.classDoc;
			case "classSolrDocument":
				return oApiWriter.classSolrDocument;
			case "contextRows":
				return oApiWriter.contextRows;
			case "classApiMethod":
				return oApiWriter.classApiMethod;
			case "openApiVersion":
				return oApiWriter.openApiVersion;
			case "classUris":
				return oApiWriter.classUris;
			case "openApiVersionNumber":
				return oApiWriter.openApiVersionNumber;
			case "tabsSchema":
				return oApiWriter.tabsSchema;
			case "tabsResponses":
				return oApiWriter.tabsResponses;
			case "wPaths":
				return oApiWriter.wPaths;
			case "wRequestBodies":
				return oApiWriter.wRequestBodies;
			case "wSchemas":
				return oApiWriter.wSchemas;
			case "config":
				return oApiWriter.config;
			case "authClients":
				return oApiWriter.authClients;
			case "wRequestHeaders":
				return oApiWriter.wRequestHeaders;
			case "wRequestDescription":
				return oApiWriter.wRequestDescription;
			case "wResponseDescription":
				return oApiWriter.wResponseDescription;
			case "wRequestBody":
				return oApiWriter.wRequestBody;
			case "wResponseBody":
				return oApiWriter.wResponseBody;
			case "wRequestSchema":
				return oApiWriter.wRequestSchema;
			case "wResponseSchema":
				return oApiWriter.wResponseSchema;
			case "writers":
				return oApiWriter.writers;
			case "classApiTag":
				return oApiWriter.classApiTag;
			case "classExtendsBase":
				return oApiWriter.classExtendsBase;
			case "classIsBase":
				return oApiWriter.classIsBase;
			case "classFiware":
				return oApiWriter.classFiware;
			case "classSimpleName":
				return oApiWriter.classSimpleName;
			case "appName":
				return oApiWriter.appName;
			case "classAbsolutePath":
				return oApiWriter.classAbsolutePath;
			case "classApiUriMethod":
				return oApiWriter.classApiUriMethod;
			case "classRoleUserMethod":
				return oApiWriter.classRoleUserMethod;
			case "classApiMethodMethod":
				return oApiWriter.classApiMethodMethod;
			case "classApiMediaTypeRequestMethod":
				return oApiWriter.classApiMediaTypeRequestMethod;
			case "classApiMediaType200Method":
				return oApiWriter.classApiMediaType200Method;
			case "classApiOperationIdMethod":
				return oApiWriter.classApiOperationIdMethod;
			case "classApiOperationIdMethodRequest":
				return oApiWriter.classApiOperationIdMethodRequest;
			case "classApiOperationIdMethodResponse":
				return oApiWriter.classApiOperationIdMethodResponse;
			case "classSuperApiOperationIdMethodRequest":
				return oApiWriter.classSuperApiOperationIdMethodRequest;
			case "classSuperApiOperationIdMethodResponse":
				return oApiWriter.classSuperApiOperationIdMethodResponse;
			case "classPageCanonicalNameMethod":
				return oApiWriter.classPageCanonicalNameMethod;
			case "classPageWithTemplateMethod":
				return oApiWriter.classPageWithTemplateMethod;
			case "classKeywordsFound":
				return oApiWriter.classKeywordsFound;
			case "classKeywords":
				return oApiWriter.classKeywords;
			case "classPublicRead":
				return oApiWriter.classPublicRead;
			case "classSearchPagePublicRead":
				return oApiWriter.classSearchPagePublicRead;
			case "classRoleSession":
				return oApiWriter.classRoleSession;
			case "classRoleUser":
				return oApiWriter.classRoleUser;
			case "classRoleAll":
				return oApiWriter.classRoleAll;
			case "classAuth":
				return oApiWriter.classAuth;
			case "classRolesFound":
				return oApiWriter.classRolesFound;
			case "classRoles":
				return oApiWriter.classRoles;
			case "classRoleReads":
				return oApiWriter.classRoleReads;
			case "classRolesLanguage":
				return oApiWriter.classRolesLanguage;
			case "entitySolrDocument":
				return oApiWriter.entitySolrDocument;
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
				o = relateApiWriter(v, val);
		}
		return o != null;
	}
	public Object relateApiWriter(String var, Object val) {
		ApiWriter oApiWriter = (ApiWriter)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetApiWriter(entityVar,  siteRequest_, o);
	}
	public static Object staticSetApiWriter(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "languageName":
			return ApiWriter.staticSetLanguageName(siteRequest_, o);
		case "i18n":
			return ApiWriter.staticSetI18n(siteRequest_, o);
		case "contextRows":
			return ApiWriter.staticSetContextRows(siteRequest_, o);
		case "classApiMethod":
			return ApiWriter.staticSetClassApiMethod(siteRequest_, o);
		case "openApiVersion":
			return ApiWriter.staticSetOpenApiVersion(siteRequest_, o);
		case "classUris":
			return ApiWriter.staticSetClassUris(siteRequest_, o);
		case "openApiVersionNumber":
			return ApiWriter.staticSetOpenApiVersionNumber(siteRequest_, o);
		case "tabsSchema":
			return ApiWriter.staticSetTabsSchema(siteRequest_, o);
		case "tabsResponses":
			return ApiWriter.staticSetTabsResponses(siteRequest_, o);
		case "config":
			return ApiWriter.staticSetConfig(siteRequest_, o);
		case "authClients":
			return ApiWriter.staticSetAuthClients(siteRequest_, o);
		case "classApiTag":
			return ApiWriter.staticSetClassApiTag(siteRequest_, o);
		case "classExtendsBase":
			return ApiWriter.staticSetClassExtendsBase(siteRequest_, o);
		case "classIsBase":
			return ApiWriter.staticSetClassIsBase(siteRequest_, o);
		case "classFiware":
			return ApiWriter.staticSetClassFiware(siteRequest_, o);
		case "classSimpleName":
			return ApiWriter.staticSetClassSimpleName(siteRequest_, o);
		case "appName":
			return ApiWriter.staticSetAppName(siteRequest_, o);
		case "classAbsolutePath":
			return ApiWriter.staticSetClassAbsolutePath(siteRequest_, o);
		case "classApiUriMethod":
			return ApiWriter.staticSetClassApiUriMethod(siteRequest_, o);
		case "classRoleUserMethod":
			return ApiWriter.staticSetClassRoleUserMethod(siteRequest_, o);
		case "classApiMethodMethod":
			return ApiWriter.staticSetClassApiMethodMethod(siteRequest_, o);
		case "classApiMediaTypeRequestMethod":
			return ApiWriter.staticSetClassApiMediaTypeRequestMethod(siteRequest_, o);
		case "classApiMediaType200Method":
			return ApiWriter.staticSetClassApiMediaType200Method(siteRequest_, o);
		case "classApiOperationIdMethod":
			return ApiWriter.staticSetClassApiOperationIdMethod(siteRequest_, o);
		case "classApiOperationIdMethodRequest":
			return ApiWriter.staticSetClassApiOperationIdMethodRequest(siteRequest_, o);
		case "classApiOperationIdMethodResponse":
			return ApiWriter.staticSetClassApiOperationIdMethodResponse(siteRequest_, o);
		case "classSuperApiOperationIdMethodRequest":
			return ApiWriter.staticSetClassSuperApiOperationIdMethodRequest(siteRequest_, o);
		case "classSuperApiOperationIdMethodResponse":
			return ApiWriter.staticSetClassSuperApiOperationIdMethodResponse(siteRequest_, o);
		case "classPageCanonicalNameMethod":
			return ApiWriter.staticSetClassPageCanonicalNameMethod(siteRequest_, o);
		case "classPageWithTemplateMethod":
			return ApiWriter.staticSetClassPageWithTemplateMethod(siteRequest_, o);
		case "classKeywordsFound":
			return ApiWriter.staticSetClassKeywordsFound(siteRequest_, o);
		case "classKeywords":
			return ApiWriter.staticSetClassKeywords(siteRequest_, o);
		case "classPublicRead":
			return ApiWriter.staticSetClassPublicRead(siteRequest_, o);
		case "classSearchPagePublicRead":
			return ApiWriter.staticSetClassSearchPagePublicRead(siteRequest_, o);
		case "classRoleSession":
			return ApiWriter.staticSetClassRoleSession(siteRequest_, o);
		case "classRoleUser":
			return ApiWriter.staticSetClassRoleUser(siteRequest_, o);
		case "classRoleAll":
			return ApiWriter.staticSetClassRoleAll(siteRequest_, o);
		case "classAuth":
			return ApiWriter.staticSetClassAuth(siteRequest_, o);
		case "classRolesFound":
			return ApiWriter.staticSetClassRolesFound(siteRequest_, o);
		case "classRoles":
			return ApiWriter.staticSetClassRoles(siteRequest_, o);
		case "classRoleReads":
			return ApiWriter.staticSetClassRoleReads(siteRequest_, o);
		case "classRolesLanguage":
			return ApiWriter.staticSetClassRolesLanguage(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchApiWriter(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchApiWriter(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "languageName":
			return ApiWriter.staticSearchLanguageName(siteRequest_, (String)o);
		case "i18n":
			return ApiWriter.staticSearchI18n(siteRequest_, (JsonObject)o);
		case "contextRows":
			return ApiWriter.staticSearchContextRows(siteRequest_, (Integer)o);
		case "classApiMethod":
			return ApiWriter.staticSearchClassApiMethod(siteRequest_, (String)o);
		case "openApiVersion":
			return ApiWriter.staticSearchOpenApiVersion(siteRequest_, (String)o);
		case "classUris":
			return ApiWriter.staticSearchClassUris(siteRequest_, (String)o);
		case "openApiVersionNumber":
			return ApiWriter.staticSearchOpenApiVersionNumber(siteRequest_, (Integer)o);
		case "tabsSchema":
			return ApiWriter.staticSearchTabsSchema(siteRequest_, (Integer)o);
		case "tabsResponses":
			return ApiWriter.staticSearchTabsResponses(siteRequest_, (Integer)o);
		case "config":
			return ApiWriter.staticSearchConfig(siteRequest_, (JsonObject)o);
		case "authClients":
			return ApiWriter.staticSearchAuthClients(siteRequest_, (JsonObject)o);
		case "classApiTag":
			return ApiWriter.staticSearchClassApiTag(siteRequest_, (String)o);
		case "classExtendsBase":
			return ApiWriter.staticSearchClassExtendsBase(siteRequest_, (Boolean)o);
		case "classIsBase":
			return ApiWriter.staticSearchClassIsBase(siteRequest_, (Boolean)o);
		case "classFiware":
			return ApiWriter.staticSearchClassFiware(siteRequest_, (Boolean)o);
		case "classSimpleName":
			return ApiWriter.staticSearchClassSimpleName(siteRequest_, (String)o);
		case "appName":
			return ApiWriter.staticSearchAppName(siteRequest_, (String)o);
		case "classAbsolutePath":
			return ApiWriter.staticSearchClassAbsolutePath(siteRequest_, (String)o);
		case "classApiUriMethod":
			return ApiWriter.staticSearchClassApiUriMethod(siteRequest_, (String)o);
		case "classRoleUserMethod":
			return ApiWriter.staticSearchClassRoleUserMethod(siteRequest_, (Boolean)o);
		case "classApiMethodMethod":
			return ApiWriter.staticSearchClassApiMethodMethod(siteRequest_, (String)o);
		case "classApiMediaTypeRequestMethod":
			return ApiWriter.staticSearchClassApiMediaTypeRequestMethod(siteRequest_, (String)o);
		case "classApiMediaType200Method":
			return ApiWriter.staticSearchClassApiMediaType200Method(siteRequest_, (String)o);
		case "classApiOperationIdMethod":
			return ApiWriter.staticSearchClassApiOperationIdMethod(siteRequest_, (String)o);
		case "classApiOperationIdMethodRequest":
			return ApiWriter.staticSearchClassApiOperationIdMethodRequest(siteRequest_, (String)o);
		case "classApiOperationIdMethodResponse":
			return ApiWriter.staticSearchClassApiOperationIdMethodResponse(siteRequest_, (String)o);
		case "classSuperApiOperationIdMethodRequest":
			return ApiWriter.staticSearchClassSuperApiOperationIdMethodRequest(siteRequest_, (String)o);
		case "classSuperApiOperationIdMethodResponse":
			return ApiWriter.staticSearchClassSuperApiOperationIdMethodResponse(siteRequest_, (String)o);
		case "classPageCanonicalNameMethod":
			return ApiWriter.staticSearchClassPageCanonicalNameMethod(siteRequest_, (String)o);
		case "classPageWithTemplateMethod":
			return ApiWriter.staticSearchClassPageWithTemplateMethod(siteRequest_, (Boolean)o);
		case "classKeywordsFound":
			return ApiWriter.staticSearchClassKeywordsFound(siteRequest_, (Boolean)o);
		case "classKeywords":
			return ApiWriter.staticSearchClassKeywords(siteRequest_, (String)o);
		case "classPublicRead":
			return ApiWriter.staticSearchClassPublicRead(siteRequest_, (Boolean)o);
		case "classSearchPagePublicRead":
			return ApiWriter.staticSearchClassSearchPagePublicRead(siteRequest_, (Boolean)o);
		case "classRoleSession":
			return ApiWriter.staticSearchClassRoleSession(siteRequest_, (Boolean)o);
		case "classRoleUser":
			return ApiWriter.staticSearchClassRoleUser(siteRequest_, (Boolean)o);
		case "classRoleAll":
			return ApiWriter.staticSearchClassRoleAll(siteRequest_, (Boolean)o);
		case "classAuth":
			return ApiWriter.staticSearchClassAuth(siteRequest_, (Boolean)o);
		case "classRolesFound":
			return ApiWriter.staticSearchClassRolesFound(siteRequest_, (Boolean)o);
		case "classRoles":
			return ApiWriter.staticSearchClassRoles(siteRequest_, (String)o);
		case "classRoleReads":
			return ApiWriter.staticSearchClassRoleReads(siteRequest_, (String)o);
		case "classRolesLanguage":
			return ApiWriter.staticSearchClassRolesLanguage(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrApiWriter(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrApiWriter(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "languageName":
			return ApiWriter.staticSearchStrLanguageName(siteRequest_, (String)o);
		case "i18n":
			return ApiWriter.staticSearchStrI18n(siteRequest_, (String)o);
		case "contextRows":
			return ApiWriter.staticSearchStrContextRows(siteRequest_, (Integer)o);
		case "classApiMethod":
			return ApiWriter.staticSearchStrClassApiMethod(siteRequest_, (String)o);
		case "openApiVersion":
			return ApiWriter.staticSearchStrOpenApiVersion(siteRequest_, (String)o);
		case "classUris":
			return ApiWriter.staticSearchStrClassUris(siteRequest_, (String)o);
		case "openApiVersionNumber":
			return ApiWriter.staticSearchStrOpenApiVersionNumber(siteRequest_, (Integer)o);
		case "tabsSchema":
			return ApiWriter.staticSearchStrTabsSchema(siteRequest_, (Integer)o);
		case "tabsResponses":
			return ApiWriter.staticSearchStrTabsResponses(siteRequest_, (Integer)o);
		case "config":
			return ApiWriter.staticSearchStrConfig(siteRequest_, (String)o);
		case "authClients":
			return ApiWriter.staticSearchStrAuthClients(siteRequest_, (String)o);
		case "classApiTag":
			return ApiWriter.staticSearchStrClassApiTag(siteRequest_, (String)o);
		case "classExtendsBase":
			return ApiWriter.staticSearchStrClassExtendsBase(siteRequest_, (Boolean)o);
		case "classIsBase":
			return ApiWriter.staticSearchStrClassIsBase(siteRequest_, (Boolean)o);
		case "classFiware":
			return ApiWriter.staticSearchStrClassFiware(siteRequest_, (Boolean)o);
		case "classSimpleName":
			return ApiWriter.staticSearchStrClassSimpleName(siteRequest_, (String)o);
		case "appName":
			return ApiWriter.staticSearchStrAppName(siteRequest_, (String)o);
		case "classAbsolutePath":
			return ApiWriter.staticSearchStrClassAbsolutePath(siteRequest_, (String)o);
		case "classApiUriMethod":
			return ApiWriter.staticSearchStrClassApiUriMethod(siteRequest_, (String)o);
		case "classRoleUserMethod":
			return ApiWriter.staticSearchStrClassRoleUserMethod(siteRequest_, (Boolean)o);
		case "classApiMethodMethod":
			return ApiWriter.staticSearchStrClassApiMethodMethod(siteRequest_, (String)o);
		case "classApiMediaTypeRequestMethod":
			return ApiWriter.staticSearchStrClassApiMediaTypeRequestMethod(siteRequest_, (String)o);
		case "classApiMediaType200Method":
			return ApiWriter.staticSearchStrClassApiMediaType200Method(siteRequest_, (String)o);
		case "classApiOperationIdMethod":
			return ApiWriter.staticSearchStrClassApiOperationIdMethod(siteRequest_, (String)o);
		case "classApiOperationIdMethodRequest":
			return ApiWriter.staticSearchStrClassApiOperationIdMethodRequest(siteRequest_, (String)o);
		case "classApiOperationIdMethodResponse":
			return ApiWriter.staticSearchStrClassApiOperationIdMethodResponse(siteRequest_, (String)o);
		case "classSuperApiOperationIdMethodRequest":
			return ApiWriter.staticSearchStrClassSuperApiOperationIdMethodRequest(siteRequest_, (String)o);
		case "classSuperApiOperationIdMethodResponse":
			return ApiWriter.staticSearchStrClassSuperApiOperationIdMethodResponse(siteRequest_, (String)o);
		case "classPageCanonicalNameMethod":
			return ApiWriter.staticSearchStrClassPageCanonicalNameMethod(siteRequest_, (String)o);
		case "classPageWithTemplateMethod":
			return ApiWriter.staticSearchStrClassPageWithTemplateMethod(siteRequest_, (Boolean)o);
		case "classKeywordsFound":
			return ApiWriter.staticSearchStrClassKeywordsFound(siteRequest_, (Boolean)o);
		case "classKeywords":
			return ApiWriter.staticSearchStrClassKeywords(siteRequest_, (String)o);
		case "classPublicRead":
			return ApiWriter.staticSearchStrClassPublicRead(siteRequest_, (Boolean)o);
		case "classSearchPagePublicRead":
			return ApiWriter.staticSearchStrClassSearchPagePublicRead(siteRequest_, (Boolean)o);
		case "classRoleSession":
			return ApiWriter.staticSearchStrClassRoleSession(siteRequest_, (Boolean)o);
		case "classRoleUser":
			return ApiWriter.staticSearchStrClassRoleUser(siteRequest_, (Boolean)o);
		case "classRoleAll":
			return ApiWriter.staticSearchStrClassRoleAll(siteRequest_, (Boolean)o);
		case "classAuth":
			return ApiWriter.staticSearchStrClassAuth(siteRequest_, (Boolean)o);
		case "classRolesFound":
			return ApiWriter.staticSearchStrClassRolesFound(siteRequest_, (Boolean)o);
		case "classRoles":
			return ApiWriter.staticSearchStrClassRoles(siteRequest_, (String)o);
		case "classRoleReads":
			return ApiWriter.staticSearchStrClassRoleReads(siteRequest_, (String)o);
		case "classRolesLanguage":
			return ApiWriter.staticSearchStrClassRolesLanguage(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqApiWriter(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqApiWriter(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "languageName":
			return ApiWriter.staticSearchFqLanguageName(siteRequest_, o);
		case "i18n":
			return ApiWriter.staticSearchFqI18n(siteRequest_, o);
		case "contextRows":
			return ApiWriter.staticSearchFqContextRows(siteRequest_, o);
		case "classApiMethod":
			return ApiWriter.staticSearchFqClassApiMethod(siteRequest_, o);
		case "openApiVersion":
			return ApiWriter.staticSearchFqOpenApiVersion(siteRequest_, o);
		case "classUris":
			return ApiWriter.staticSearchFqClassUris(siteRequest_, o);
		case "openApiVersionNumber":
			return ApiWriter.staticSearchFqOpenApiVersionNumber(siteRequest_, o);
		case "tabsSchema":
			return ApiWriter.staticSearchFqTabsSchema(siteRequest_, o);
		case "tabsResponses":
			return ApiWriter.staticSearchFqTabsResponses(siteRequest_, o);
		case "config":
			return ApiWriter.staticSearchFqConfig(siteRequest_, o);
		case "authClients":
			return ApiWriter.staticSearchFqAuthClients(siteRequest_, o);
		case "classApiTag":
			return ApiWriter.staticSearchFqClassApiTag(siteRequest_, o);
		case "classExtendsBase":
			return ApiWriter.staticSearchFqClassExtendsBase(siteRequest_, o);
		case "classIsBase":
			return ApiWriter.staticSearchFqClassIsBase(siteRequest_, o);
		case "classFiware":
			return ApiWriter.staticSearchFqClassFiware(siteRequest_, o);
		case "classSimpleName":
			return ApiWriter.staticSearchFqClassSimpleName(siteRequest_, o);
		case "appName":
			return ApiWriter.staticSearchFqAppName(siteRequest_, o);
		case "classAbsolutePath":
			return ApiWriter.staticSearchFqClassAbsolutePath(siteRequest_, o);
		case "classApiUriMethod":
			return ApiWriter.staticSearchFqClassApiUriMethod(siteRequest_, o);
		case "classRoleUserMethod":
			return ApiWriter.staticSearchFqClassRoleUserMethod(siteRequest_, o);
		case "classApiMethodMethod":
			return ApiWriter.staticSearchFqClassApiMethodMethod(siteRequest_, o);
		case "classApiMediaTypeRequestMethod":
			return ApiWriter.staticSearchFqClassApiMediaTypeRequestMethod(siteRequest_, o);
		case "classApiMediaType200Method":
			return ApiWriter.staticSearchFqClassApiMediaType200Method(siteRequest_, o);
		case "classApiOperationIdMethod":
			return ApiWriter.staticSearchFqClassApiOperationIdMethod(siteRequest_, o);
		case "classApiOperationIdMethodRequest":
			return ApiWriter.staticSearchFqClassApiOperationIdMethodRequest(siteRequest_, o);
		case "classApiOperationIdMethodResponse":
			return ApiWriter.staticSearchFqClassApiOperationIdMethodResponse(siteRequest_, o);
		case "classSuperApiOperationIdMethodRequest":
			return ApiWriter.staticSearchFqClassSuperApiOperationIdMethodRequest(siteRequest_, o);
		case "classSuperApiOperationIdMethodResponse":
			return ApiWriter.staticSearchFqClassSuperApiOperationIdMethodResponse(siteRequest_, o);
		case "classPageCanonicalNameMethod":
			return ApiWriter.staticSearchFqClassPageCanonicalNameMethod(siteRequest_, o);
		case "classPageWithTemplateMethod":
			return ApiWriter.staticSearchFqClassPageWithTemplateMethod(siteRequest_, o);
		case "classKeywordsFound":
			return ApiWriter.staticSearchFqClassKeywordsFound(siteRequest_, o);
		case "classKeywords":
			return ApiWriter.staticSearchFqClassKeywords(siteRequest_, o);
		case "classPublicRead":
			return ApiWriter.staticSearchFqClassPublicRead(siteRequest_, o);
		case "classSearchPagePublicRead":
			return ApiWriter.staticSearchFqClassSearchPagePublicRead(siteRequest_, o);
		case "classRoleSession":
			return ApiWriter.staticSearchFqClassRoleSession(siteRequest_, o);
		case "classRoleUser":
			return ApiWriter.staticSearchFqClassRoleUser(siteRequest_, o);
		case "classRoleAll":
			return ApiWriter.staticSearchFqClassRoleAll(siteRequest_, o);
		case "classAuth":
			return ApiWriter.staticSearchFqClassAuth(siteRequest_, o);
		case "classRolesFound":
			return ApiWriter.staticSearchFqClassRolesFound(siteRequest_, o);
		case "classRoles":
			return ApiWriter.staticSearchFqClassRoles(siteRequest_, o);
		case "classRoleReads":
			return ApiWriter.staticSearchFqClassRoleReads(siteRequest_, o);
		case "classRolesLanguage":
			return ApiWriter.staticSearchFqClassRolesLanguage(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "ApiWriter";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_languageName = "languageName";
	public static final String VAR_i18n = "i18n";
	public static final String VAR_classDoc = "classDoc";
	public static final String VAR_classSolrDocument = "classSolrDocument";
	public static final String VAR_contextRows = "contextRows";
	public static final String VAR_classApiMethod = "classApiMethod";
	public static final String VAR_openApiVersion = "openApiVersion";
	public static final String VAR_classUris = "classUris";
	public static final String VAR_openApiVersionNumber = "openApiVersionNumber";
	public static final String VAR_tabsSchema = "tabsSchema";
	public static final String VAR_tabsResponses = "tabsResponses";
	public static final String VAR_wPaths = "wPaths";
	public static final String VAR_wRequestBodies = "wRequestBodies";
	public static final String VAR_wSchemas = "wSchemas";
	public static final String VAR_config = "config";
	public static final String VAR_authClients = "authClients";
	public static final String VAR_wRequestHeaders = "wRequestHeaders";
	public static final String VAR_wRequestDescription = "wRequestDescription";
	public static final String VAR_wResponseDescription = "wResponseDescription";
	public static final String VAR_wRequestBody = "wRequestBody";
	public static final String VAR_wResponseBody = "wResponseBody";
	public static final String VAR_wRequestSchema = "wRequestSchema";
	public static final String VAR_wResponseSchema = "wResponseSchema";
	public static final String VAR_writers = "writers";
	public static final String VAR_classApiTag = "classApiTag";
	public static final String VAR_classExtendsBase = "classExtendsBase";
	public static final String VAR_classIsBase = "classIsBase";
	public static final String VAR_classFiware = "classFiware";
	public static final String VAR_classSimpleName = "classSimpleName";
	public static final String VAR_appName = "appName";
	public static final String VAR_classAbsolutePath = "classAbsolutePath";
	public static final String VAR_classApiUriMethod = "classApiUriMethod";
	public static final String VAR_classRoleUserMethod = "classRoleUserMethod";
	public static final String VAR_classApiMethodMethod = "classApiMethodMethod";
	public static final String VAR_classApiMediaTypeRequestMethod = "classApiMediaTypeRequestMethod";
	public static final String VAR_classApiMediaType200Method = "classApiMediaType200Method";
	public static final String VAR_classApiOperationIdMethod = "classApiOperationIdMethod";
	public static final String VAR_classApiOperationIdMethodRequest = "classApiOperationIdMethodRequest";
	public static final String VAR_classApiOperationIdMethodResponse = "classApiOperationIdMethodResponse";
	public static final String VAR_classSuperApiOperationIdMethodRequest = "classSuperApiOperationIdMethodRequest";
	public static final String VAR_classSuperApiOperationIdMethodResponse = "classSuperApiOperationIdMethodResponse";
	public static final String VAR_classPageCanonicalNameMethod = "classPageCanonicalNameMethod";
	public static final String VAR_classPageWithTemplateMethod = "classPageWithTemplateMethod";
	public static final String VAR_classKeywordsFound = "classKeywordsFound";
	public static final String VAR_classKeywords = "classKeywords";
	public static final String VAR_classPublicRead = "classPublicRead";
	public static final String VAR_classSearchPagePublicRead = "classSearchPagePublicRead";
	public static final String VAR_classRoleSession = "classRoleSession";
	public static final String VAR_classRoleUser = "classRoleUser";
	public static final String VAR_classRoleAll = "classRoleAll";
	public static final String VAR_classAuth = "classAuth";
	public static final String VAR_classRolesFound = "classRolesFound";
	public static final String VAR_classRoles = "classRoles";
	public static final String VAR_classRoleReads = "classRoleReads";
	public static final String VAR_classRolesLanguage = "classRolesLanguage";
	public static final String VAR_entitySolrDocument = "entitySolrDocument";

	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_languageName = "";
	public static final String DISPLAY_NAME_i18n = "";
	public static final String DISPLAY_NAME_classDoc = "";
	public static final String DISPLAY_NAME_classSolrDocument = "";
	public static final String DISPLAY_NAME_contextRows = "";
	public static final String DISPLAY_NAME_classApiMethod = "";
	public static final String DISPLAY_NAME_openApiVersion = "";
	public static final String DISPLAY_NAME_classUris = "";
	public static final String DISPLAY_NAME_openApiVersionNumber = "";
	public static final String DISPLAY_NAME_tabsSchema = "";
	public static final String DISPLAY_NAME_tabsResponses = "";
	public static final String DISPLAY_NAME_wPaths = "";
	public static final String DISPLAY_NAME_wRequestBodies = "";
	public static final String DISPLAY_NAME_wSchemas = "";
	public static final String DISPLAY_NAME_config = "";
	public static final String DISPLAY_NAME_authClients = "";
	public static final String DISPLAY_NAME_wRequestHeaders = "";
	public static final String DISPLAY_NAME_wRequestDescription = "";
	public static final String DISPLAY_NAME_wResponseDescription = "";
	public static final String DISPLAY_NAME_wRequestBody = "";
	public static final String DISPLAY_NAME_wResponseBody = "";
	public static final String DISPLAY_NAME_wRequestSchema = "";
	public static final String DISPLAY_NAME_wResponseSchema = "";
	public static final String DISPLAY_NAME_writers = "";
	public static final String DISPLAY_NAME_classApiTag = "";
	public static final String DISPLAY_NAME_classExtendsBase = "";
	public static final String DISPLAY_NAME_classIsBase = "";
	public static final String DISPLAY_NAME_classFiware = "";
	public static final String DISPLAY_NAME_classSimpleName = "";
	public static final String DISPLAY_NAME_appName = "";
	public static final String DISPLAY_NAME_classAbsolutePath = "";
	public static final String DISPLAY_NAME_classApiUriMethod = "";
	public static final String DISPLAY_NAME_classRoleUserMethod = "";
	public static final String DISPLAY_NAME_classApiMethodMethod = "";
	public static final String DISPLAY_NAME_classApiMediaTypeRequestMethod = "";
	public static final String DISPLAY_NAME_classApiMediaType200Method = "";
	public static final String DISPLAY_NAME_classApiOperationIdMethod = "";
	public static final String DISPLAY_NAME_classApiOperationIdMethodRequest = "";
	public static final String DISPLAY_NAME_classApiOperationIdMethodResponse = "";
	public static final String DISPLAY_NAME_classSuperApiOperationIdMethodRequest = "";
	public static final String DISPLAY_NAME_classSuperApiOperationIdMethodResponse = "";
	public static final String DISPLAY_NAME_classPageCanonicalNameMethod = "";
	public static final String DISPLAY_NAME_classPageWithTemplateMethod = "";
	public static final String DISPLAY_NAME_classKeywordsFound = "";
	public static final String DISPLAY_NAME_classKeywords = "";
	public static final String DISPLAY_NAME_classPublicRead = "";
	public static final String DISPLAY_NAME_classSearchPagePublicRead = "";
	public static final String DISPLAY_NAME_classRoleSession = "";
	public static final String DISPLAY_NAME_classRoleUser = "";
	public static final String DISPLAY_NAME_classRoleAll = "";
	public static final String DISPLAY_NAME_classAuth = "";
	public static final String DISPLAY_NAME_classRolesFound = "";
	public static final String DISPLAY_NAME_classRoles = "";
	public static final String DISPLAY_NAME_classRoleReads = "";
	public static final String DISPLAY_NAME_classRolesLanguage = "";
	public static final String DISPLAY_NAME_entitySolrDocument = "";

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

	public static String displayNameForClass(String var) {
		return ApiWriter.displayNameApiWriter(var);
	}
	public static String displayNameApiWriter(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_languageName:
			return DISPLAY_NAME_languageName;
		case VAR_i18n:
			return DISPLAY_NAME_i18n;
		case VAR_classDoc:
			return DISPLAY_NAME_classDoc;
		case VAR_classSolrDocument:
			return DISPLAY_NAME_classSolrDocument;
		case VAR_contextRows:
			return DISPLAY_NAME_contextRows;
		case VAR_classApiMethod:
			return DISPLAY_NAME_classApiMethod;
		case VAR_openApiVersion:
			return DISPLAY_NAME_openApiVersion;
		case VAR_classUris:
			return DISPLAY_NAME_classUris;
		case VAR_openApiVersionNumber:
			return DISPLAY_NAME_openApiVersionNumber;
		case VAR_tabsSchema:
			return DISPLAY_NAME_tabsSchema;
		case VAR_tabsResponses:
			return DISPLAY_NAME_tabsResponses;
		case VAR_wPaths:
			return DISPLAY_NAME_wPaths;
		case VAR_wRequestBodies:
			return DISPLAY_NAME_wRequestBodies;
		case VAR_wSchemas:
			return DISPLAY_NAME_wSchemas;
		case VAR_config:
			return DISPLAY_NAME_config;
		case VAR_authClients:
			return DISPLAY_NAME_authClients;
		case VAR_wRequestHeaders:
			return DISPLAY_NAME_wRequestHeaders;
		case VAR_wRequestDescription:
			return DISPLAY_NAME_wRequestDescription;
		case VAR_wResponseDescription:
			return DISPLAY_NAME_wResponseDescription;
		case VAR_wRequestBody:
			return DISPLAY_NAME_wRequestBody;
		case VAR_wResponseBody:
			return DISPLAY_NAME_wResponseBody;
		case VAR_wRequestSchema:
			return DISPLAY_NAME_wRequestSchema;
		case VAR_wResponseSchema:
			return DISPLAY_NAME_wResponseSchema;
		case VAR_writers:
			return DISPLAY_NAME_writers;
		case VAR_classApiTag:
			return DISPLAY_NAME_classApiTag;
		case VAR_classExtendsBase:
			return DISPLAY_NAME_classExtendsBase;
		case VAR_classIsBase:
			return DISPLAY_NAME_classIsBase;
		case VAR_classFiware:
			return DISPLAY_NAME_classFiware;
		case VAR_classSimpleName:
			return DISPLAY_NAME_classSimpleName;
		case VAR_appName:
			return DISPLAY_NAME_appName;
		case VAR_classAbsolutePath:
			return DISPLAY_NAME_classAbsolutePath;
		case VAR_classApiUriMethod:
			return DISPLAY_NAME_classApiUriMethod;
		case VAR_classRoleUserMethod:
			return DISPLAY_NAME_classRoleUserMethod;
		case VAR_classApiMethodMethod:
			return DISPLAY_NAME_classApiMethodMethod;
		case VAR_classApiMediaTypeRequestMethod:
			return DISPLAY_NAME_classApiMediaTypeRequestMethod;
		case VAR_classApiMediaType200Method:
			return DISPLAY_NAME_classApiMediaType200Method;
		case VAR_classApiOperationIdMethod:
			return DISPLAY_NAME_classApiOperationIdMethod;
		case VAR_classApiOperationIdMethodRequest:
			return DISPLAY_NAME_classApiOperationIdMethodRequest;
		case VAR_classApiOperationIdMethodResponse:
			return DISPLAY_NAME_classApiOperationIdMethodResponse;
		case VAR_classSuperApiOperationIdMethodRequest:
			return DISPLAY_NAME_classSuperApiOperationIdMethodRequest;
		case VAR_classSuperApiOperationIdMethodResponse:
			return DISPLAY_NAME_classSuperApiOperationIdMethodResponse;
		case VAR_classPageCanonicalNameMethod:
			return DISPLAY_NAME_classPageCanonicalNameMethod;
		case VAR_classPageWithTemplateMethod:
			return DISPLAY_NAME_classPageWithTemplateMethod;
		case VAR_classKeywordsFound:
			return DISPLAY_NAME_classKeywordsFound;
		case VAR_classKeywords:
			return DISPLAY_NAME_classKeywords;
		case VAR_classPublicRead:
			return DISPLAY_NAME_classPublicRead;
		case VAR_classSearchPagePublicRead:
			return DISPLAY_NAME_classSearchPagePublicRead;
		case VAR_classRoleSession:
			return DISPLAY_NAME_classRoleSession;
		case VAR_classRoleUser:
			return DISPLAY_NAME_classRoleUser;
		case VAR_classRoleAll:
			return DISPLAY_NAME_classRoleAll;
		case VAR_classAuth:
			return DISPLAY_NAME_classAuth;
		case VAR_classRolesFound:
			return DISPLAY_NAME_classRolesFound;
		case VAR_classRoles:
			return DISPLAY_NAME_classRoles;
		case VAR_classRoleReads:
			return DISPLAY_NAME_classRoleReads;
		case VAR_classRolesLanguage:
			return DISPLAY_NAME_classRolesLanguage;
		case VAR_entitySolrDocument:
			return DISPLAY_NAME_entitySolrDocument;
		default:
			return null;
		}
	}

	public static String descriptionApiWriter(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static String classSimpleNameApiWriter(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return "ComputateSiteRequest";
		case VAR_languageName:
			return "String";
		case VAR_i18n:
			return "JsonObject";
		case VAR_classDoc:
			return "ComputateEnUSClass";
		case VAR_classSolrDocument:
			return "Doc";
		case VAR_contextRows:
			return "Integer";
		case VAR_classApiMethod:
			return "String";
		case VAR_openApiVersion:
			return "String";
		case VAR_classUris:
			return "List";
		case VAR_openApiVersionNumber:
			return "Integer";
		case VAR_tabsSchema:
			return "Integer";
		case VAR_tabsResponses:
			return "Integer";
		case VAR_wPaths:
			return "AllWriter";
		case VAR_wRequestBodies:
			return "AllWriter";
		case VAR_wSchemas:
			return "AllWriter";
		case VAR_config:
			return "JsonObject";
		case VAR_authClients:
			return "JsonObject";
		case VAR_wRequestHeaders:
			return "AllWriter";
		case VAR_wRequestDescription:
			return "AllWriter";
		case VAR_wResponseDescription:
			return "AllWriter";
		case VAR_wRequestBody:
			return "AllWriter";
		case VAR_wResponseBody:
			return "AllWriter";
		case VAR_wRequestSchema:
			return "AllWriter";
		case VAR_wResponseSchema:
			return "AllWriter";
		case VAR_writers:
			return "AllWriters";
		case VAR_classApiTag:
			return "String";
		case VAR_classExtendsBase:
			return "Boolean";
		case VAR_classIsBase:
			return "Boolean";
		case VAR_classFiware:
			return "Boolean";
		case VAR_classSimpleName:
			return "String";
		case VAR_appName:
			return "String";
		case VAR_classAbsolutePath:
			return "String";
		case VAR_classApiUriMethod:
			return "String";
		case VAR_classRoleUserMethod:
			return "Boolean";
		case VAR_classApiMethodMethod:
			return "String";
		case VAR_classApiMediaTypeRequestMethod:
			return "String";
		case VAR_classApiMediaType200Method:
			return "String";
		case VAR_classApiOperationIdMethod:
			return "String";
		case VAR_classApiOperationIdMethodRequest:
			return "String";
		case VAR_classApiOperationIdMethodResponse:
			return "String";
		case VAR_classSuperApiOperationIdMethodRequest:
			return "String";
		case VAR_classSuperApiOperationIdMethodResponse:
			return "String";
		case VAR_classPageCanonicalNameMethod:
			return "String";
		case VAR_classPageWithTemplateMethod:
			return "Boolean";
		case VAR_classKeywordsFound:
			return "Boolean";
		case VAR_classKeywords:
			return "List";
		case VAR_classPublicRead:
			return "Boolean";
		case VAR_classSearchPagePublicRead:
			return "Boolean";
		case VAR_classRoleSession:
			return "Boolean";
		case VAR_classRoleUser:
			return "Boolean";
		case VAR_classRoleAll:
			return "Boolean";
		case VAR_classAuth:
			return "Boolean";
		case VAR_classRolesFound:
			return "Boolean";
		case VAR_classRoles:
			return "List";
		case VAR_classRoleReads:
			return "List";
		case VAR_classRolesLanguage:
			return "List";
		case VAR_entitySolrDocument:
			return "Doc";
			default:
				return null;
		}
	}

	public static Integer htmColumnApiWriter(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmRowApiWriter(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmCellApiWriter(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMinApiWriter(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMaxApiWriter(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer maxApiWriter(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer minApiWriter(String var) {
		switch(var) {
			default:
				return null;
		}
	}
}
