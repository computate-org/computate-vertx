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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import org.computate.vertx.writer.AllWriters;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
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
import org.computate.search.response.solr.SolrResponse.Doc;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.search.computate.enus.ComputateEnUSClass;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.writer.AllWriter;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
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
	protected ComputateVertxSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
	protected ApiWriter siteRequest_Init() {
		Wrap<ComputateVertxSiteRequest> siteRequest_Wrap = new Wrap<ComputateVertxSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (ApiWriter)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classDoc">Find the entity classDoc in Solr</a>
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
	public static ComputateEnUSClass staticSetClassDoc(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter classDocInit() {
		Wrap<ComputateEnUSClass> classDocWrap = new Wrap<ComputateEnUSClass>().var("classDoc");
		if(classDoc == null) {
			_classDoc(classDocWrap);
			setClassDoc(classDocWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classSolrDocument">Find the entity classSolrDocument in Solr</a>
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
	public static Doc staticSetClassSolrDocument(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter classSolrDocumentInit() {
		Wrap<Doc> classSolrDocumentWrap = new Wrap<Doc>().var("classSolrDocument");
		if(classSolrDocument == null) {
			_classSolrDocument(classSolrDocumentWrap);
			setClassSolrDocument(classSolrDocumentWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:contextRows">Find the entity contextRows in Solr</a>
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
	public static Integer staticSetContextRows(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ApiWriter contextRowsInit() {
		Wrap<Integer> contextRowsWrap = new Wrap<Integer>().var("contextRows");
		if(contextRows == null) {
			_contextRows(contextRowsWrap);
			setContextRows(contextRowsWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Integer staticSearchContextRows(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrContextRows(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqContextRows(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrContextRows(siteRequest_, ApiWriter.staticSearchContextRows(siteRequest_, ApiWriter.staticSetContextRows(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiMethod">Find the entity classApiMethod in Solr</a>
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
	public static String staticSetClassApiMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiMethodInit() {
		Wrap<String> classApiMethodWrap = new Wrap<String>().var("classApiMethod");
		if(classApiMethod == null) {
			_classApiMethod(classApiMethodWrap);
			setClassApiMethod(classApiMethodWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassApiMethod(siteRequest_, ApiWriter.staticSearchClassApiMethod(siteRequest_, ApiWriter.staticSetClassApiMethod(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:openApiVersion">Find the entity openApiVersion in Solr</a>
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
	public static String staticSetOpenApiVersion(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter openApiVersionInit() {
		Wrap<String> openApiVersionWrap = new Wrap<String>().var("openApiVersion");
		if(openApiVersion == null) {
			_openApiVersion(openApiVersionWrap);
			setOpenApiVersion(openApiVersionWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchOpenApiVersion(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrOpenApiVersion(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiVersion(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrOpenApiVersion(siteRequest_, ApiWriter.staticSearchOpenApiVersion(siteRequest_, ApiWriter.staticSetOpenApiVersion(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classUris">Find the entity classUris in Solr</a>
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
	public static String staticSetClassUris(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassUris(String...objets) {
		for(String o : objets) {
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
	public void setClassUris(JsonArray objets) {
		classUris.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addClassUris(o);
		}
	}
	protected ApiWriter classUrisInit() {
		Wrap<List<String>> classUrisWrap = new Wrap<List<String>>().var("classUris");
		if(classUris == null) {
			_classUris(classUrisWrap);
			setClassUris(classUrisWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassUris(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassUris(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassUris(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassUris(siteRequest_, ApiWriter.staticSearchClassUris(siteRequest_, ApiWriter.staticSetClassUris(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:openApiVersionNumber">Find the entity openApiVersionNumber in Solr</a>
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
	public static Integer staticSetOpenApiVersionNumber(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ApiWriter openApiVersionNumberInit() {
		Wrap<Integer> openApiVersionNumberWrap = new Wrap<Integer>().var("openApiVersionNumber");
		if(openApiVersionNumber == null) {
			_openApiVersionNumber(openApiVersionNumberWrap);
			setOpenApiVersionNumber(openApiVersionNumberWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Integer staticSearchOpenApiVersionNumber(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrOpenApiVersionNumber(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqOpenApiVersionNumber(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrOpenApiVersionNumber(siteRequest_, ApiWriter.staticSearchOpenApiVersionNumber(siteRequest_, ApiWriter.staticSetOpenApiVersionNumber(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:tabsSchema">Find the entity tabsSchema in Solr</a>
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
	public static Integer staticSetTabsSchema(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ApiWriter tabsSchemaInit() {
		Wrap<Integer> tabsSchemaWrap = new Wrap<Integer>().var("tabsSchema");
		if(tabsSchema == null) {
			_tabsSchema(tabsSchemaWrap);
			setTabsSchema(tabsSchemaWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Integer staticSearchTabsSchema(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTabsSchema(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTabsSchema(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrTabsSchema(siteRequest_, ApiWriter.staticSearchTabsSchema(siteRequest_, ApiWriter.staticSetTabsSchema(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:tabsResponses">Find the entity tabsResponses in Solr</a>
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
	public static Integer staticSetTabsResponses(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ApiWriter tabsResponsesInit() {
		Wrap<Integer> tabsResponsesWrap = new Wrap<Integer>().var("tabsResponses");
		if(tabsResponses == null) {
			_tabsResponses(tabsResponsesWrap);
			setTabsResponses(tabsResponsesWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Integer staticSearchTabsResponses(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrTabsResponses(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqTabsResponses(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrTabsResponses(siteRequest_, ApiWriter.staticSearchTabsResponses(siteRequest_, ApiWriter.staticSetTabsResponses(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wPaths">Find the entity wPaths in Solr</a>
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
	public static AllWriter staticSetWPaths(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wPathsInit() {
		Wrap<AllWriter> wPathsWrap = new Wrap<AllWriter>().var("wPaths");
		if(wPaths == null) {
			_wPaths(wPathsWrap);
			setWPaths(wPathsWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wRequestBodies">Find the entity wRequestBodies in Solr</a>
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
	public static AllWriter staticSetWRequestBodies(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestBodiesInit() {
		Wrap<AllWriter> wRequestBodiesWrap = new Wrap<AllWriter>().var("wRequestBodies");
		if(wRequestBodies == null) {
			_wRequestBodies(wRequestBodiesWrap);
			setWRequestBodies(wRequestBodiesWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wSchemas">Find the entity wSchemas in Solr</a>
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
	public static AllWriter staticSetWSchemas(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wSchemasInit() {
		Wrap<AllWriter> wSchemasWrap = new Wrap<AllWriter>().var("wSchemas");
		if(wSchemas == null) {
			_wSchemas(wSchemasWrap);
			setWSchemas(wSchemasWrap.o);
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
	@JsonInclude(Include.NON_NULL)
	protected JsonObject config;

	/**	<br> The entity config
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:config">Find the entity config in Solr</a>
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
	protected ApiWriter configInit() {
		Wrap<JsonObject> configWrap = new Wrap<JsonObject>().var("config");
		if(config == null) {
			_config(configWrap);
			setConfig(configWrap.o);
		}
		return (ApiWriter)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wRequestHeaders">Find the entity wRequestHeaders in Solr</a>
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
	public static AllWriter staticSetWRequestHeaders(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestHeadersInit() {
		Wrap<AllWriter> wRequestHeadersWrap = new Wrap<AllWriter>().var("wRequestHeaders");
		if(wRequestHeaders == null) {
			_wRequestHeaders(wRequestHeadersWrap);
			setWRequestHeaders(wRequestHeadersWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wRequestDescription">Find the entity wRequestDescription in Solr</a>
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
	public static AllWriter staticSetWRequestDescription(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestDescriptionInit() {
		Wrap<AllWriter> wRequestDescriptionWrap = new Wrap<AllWriter>().var("wRequestDescription");
		if(wRequestDescription == null) {
			_wRequestDescription(wRequestDescriptionWrap);
			setWRequestDescription(wRequestDescriptionWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wResponseDescription">Find the entity wResponseDescription in Solr</a>
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
	public static AllWriter staticSetWResponseDescription(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wResponseDescriptionInit() {
		Wrap<AllWriter> wResponseDescriptionWrap = new Wrap<AllWriter>().var("wResponseDescription");
		if(wResponseDescription == null) {
			_wResponseDescription(wResponseDescriptionWrap);
			setWResponseDescription(wResponseDescriptionWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wRequestBody">Find the entity wRequestBody in Solr</a>
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
	public static AllWriter staticSetWRequestBody(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestBodyInit() {
		Wrap<AllWriter> wRequestBodyWrap = new Wrap<AllWriter>().var("wRequestBody");
		if(wRequestBody == null) {
			_wRequestBody(wRequestBodyWrap);
			setWRequestBody(wRequestBodyWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wResponseBody">Find the entity wResponseBody in Solr</a>
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
	public static AllWriter staticSetWResponseBody(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wResponseBodyInit() {
		Wrap<AllWriter> wResponseBodyWrap = new Wrap<AllWriter>().var("wResponseBody");
		if(wResponseBody == null) {
			_wResponseBody(wResponseBodyWrap);
			setWResponseBody(wResponseBodyWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wRequestSchema">Find the entity wRequestSchema in Solr</a>
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
	public static AllWriter staticSetWRequestSchema(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wRequestSchemaInit() {
		Wrap<AllWriter> wRequestSchemaWrap = new Wrap<AllWriter>().var("wRequestSchema");
		if(wRequestSchema == null) {
			_wRequestSchema(wRequestSchemaWrap);
			setWRequestSchema(wRequestSchemaWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:wResponseSchema">Find the entity wResponseSchema in Solr</a>
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
	public static AllWriter staticSetWResponseSchema(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter wResponseSchemaInit() {
		Wrap<AllWriter> wResponseSchemaWrap = new Wrap<AllWriter>().var("wResponseSchema");
		if(wResponseSchema == null) {
			_wResponseSchema(wResponseSchemaWrap);
			setWResponseSchema(wResponseSchemaWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:writers">Find the entity writers in Solr</a>
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
	public static AllWriters staticSetWriters(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter writersInit() {
		Wrap<AllWriters> writersWrap = new Wrap<AllWriters>().var("writers");
		if(writers == null) {
			_writers(writersWrap);
			setWriters(writersWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiTag">Find the entity classApiTag in Solr</a>
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
	public static String staticSetClassApiTag(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiTagInit() {
		Wrap<String> classApiTagWrap = new Wrap<String>().var("classApiTag");
		if(classApiTag == null) {
			_classApiTag(classApiTagWrap);
			setClassApiTag(classApiTagWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiTag(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiTag(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiTag(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassApiTag(siteRequest_, ApiWriter.staticSearchClassApiTag(siteRequest_, ApiWriter.staticSetClassApiTag(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classExtendsBase">Find the entity classExtendsBase in Solr</a>
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
	public static Boolean staticSetClassExtendsBase(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classExtendsBaseInit() {
		Wrap<Boolean> classExtendsBaseWrap = new Wrap<Boolean>().var("classExtendsBase");
		if(classExtendsBase == null) {
			_classExtendsBase(classExtendsBaseWrap);
			setClassExtendsBase(classExtendsBaseWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassExtendsBase(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassExtendsBase(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassExtendsBase(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassExtendsBase(siteRequest_, ApiWriter.staticSearchClassExtendsBase(siteRequest_, ApiWriter.staticSetClassExtendsBase(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classIsBase">Find the entity classIsBase in Solr</a>
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
	public static Boolean staticSetClassIsBase(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classIsBaseInit() {
		Wrap<Boolean> classIsBaseWrap = new Wrap<Boolean>().var("classIsBase");
		if(classIsBase == null) {
			_classIsBase(classIsBaseWrap);
			setClassIsBase(classIsBaseWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassIsBase(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassIsBase(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassIsBase(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassIsBase(siteRequest_, ApiWriter.staticSearchClassIsBase(siteRequest_, ApiWriter.staticSetClassIsBase(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
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
	public static String staticSetClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classSimpleNameInit() {
		Wrap<String> classSimpleNameWrap = new Wrap<String>().var("classSimpleName");
		if(classSimpleName == null) {
			_classSimpleName(classSimpleNameWrap);
			setClassSimpleName(classSimpleNameWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassSimpleName(siteRequest_, ApiWriter.staticSearchClassSimpleName(siteRequest_, ApiWriter.staticSetClassSimpleName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:appName">Find the entity appName in Solr</a>
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
	public static String staticSetAppName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter appNameInit() {
		Wrap<String> appNameWrap = new Wrap<String>().var("appName");
		if(appName == null) {
			_appName(appNameWrap);
			setAppName(appNameWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchAppName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrAppName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqAppName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrAppName(siteRequest_, ApiWriter.staticSearchAppName(siteRequest_, ApiWriter.staticSetAppName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classAbsolutePath">Find the entity classAbsolutePath in Solr</a>
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
	public static String staticSetClassAbsolutePath(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classAbsolutePathInit() {
		Wrap<String> classAbsolutePathWrap = new Wrap<String>().var("classAbsolutePath");
		if(classAbsolutePath == null) {
			_classAbsolutePath(classAbsolutePathWrap);
			setClassAbsolutePath(classAbsolutePathWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassAbsolutePath(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassAbsolutePath(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassAbsolutePath(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassAbsolutePath(siteRequest_, ApiWriter.staticSearchClassAbsolutePath(siteRequest_, ApiWriter.staticSetClassAbsolutePath(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiUriMethod">Find the entity classApiUriMethod in Solr</a>
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
	public static String staticSetClassApiUriMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiUriMethodInit() {
		Wrap<String> classApiUriMethodWrap = new Wrap<String>().var("classApiUriMethod");
		if(classApiUriMethod == null) {
			_classApiUriMethod(classApiUriMethodWrap);
			setClassApiUriMethod(classApiUriMethodWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiUriMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiUriMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiUriMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassApiUriMethod(siteRequest_, ApiWriter.staticSearchClassApiUriMethod(siteRequest_, ApiWriter.staticSetClassApiUriMethod(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classRoleUserMethod">Find the entity classRoleUserMethod in Solr</a>
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
	public static Boolean staticSetClassRoleUserMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRoleUserMethodInit() {
		Wrap<Boolean> classRoleUserMethodWrap = new Wrap<Boolean>().var("classRoleUserMethod");
		if(classRoleUserMethod == null) {
			_classRoleUserMethod(classRoleUserMethodWrap);
			setClassRoleUserMethod(classRoleUserMethodWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRoleUserMethod(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRoleUserMethod(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleUserMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassRoleUserMethod(siteRequest_, ApiWriter.staticSearchClassRoleUserMethod(siteRequest_, ApiWriter.staticSetClassRoleUserMethod(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiMethodMethod">Find the entity classApiMethodMethod in Solr</a>
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
	public static String staticSetClassApiMethodMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiMethodMethodInit() {
		Wrap<String> classApiMethodMethodWrap = new Wrap<String>().var("classApiMethodMethod");
		if(classApiMethodMethod == null) {
			_classApiMethodMethod(classApiMethodMethodWrap);
			setClassApiMethodMethod(classApiMethodMethodWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiMethodMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiMethodMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiMethodMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassApiMethodMethod(siteRequest_, ApiWriter.staticSearchClassApiMethodMethod(siteRequest_, ApiWriter.staticSetClassApiMethodMethod(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiMediaType200Method">Find the entity classApiMediaType200Method in Solr</a>
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
	public static String staticSetClassApiMediaType200Method(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiMediaType200MethodInit() {
		Wrap<String> classApiMediaType200MethodWrap = new Wrap<String>().var("classApiMediaType200Method");
		if(classApiMediaType200Method == null) {
			_classApiMediaType200Method(classApiMediaType200MethodWrap);
			setClassApiMediaType200Method(classApiMediaType200MethodWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiMediaType200Method(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiMediaType200Method(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiMediaType200Method(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassApiMediaType200Method(siteRequest_, ApiWriter.staticSearchClassApiMediaType200Method(siteRequest_, ApiWriter.staticSetClassApiMediaType200Method(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiOperationIdMethod">Find the entity classApiOperationIdMethod in Solr</a>
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
	public static String staticSetClassApiOperationIdMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiOperationIdMethodInit() {
		Wrap<String> classApiOperationIdMethodWrap = new Wrap<String>().var("classApiOperationIdMethod");
		if(classApiOperationIdMethod == null) {
			_classApiOperationIdMethod(classApiOperationIdMethodWrap);
			setClassApiOperationIdMethod(classApiOperationIdMethodWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiOperationIdMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiOperationIdMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiOperationIdMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassApiOperationIdMethod(siteRequest_, ApiWriter.staticSearchClassApiOperationIdMethod(siteRequest_, ApiWriter.staticSetClassApiOperationIdMethod(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiOperationIdMethodRequest">Find the entity classApiOperationIdMethodRequest in Solr</a>
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
	public static String staticSetClassApiOperationIdMethodRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiOperationIdMethodRequestInit() {
		Wrap<String> classApiOperationIdMethodRequestWrap = new Wrap<String>().var("classApiOperationIdMethodRequest");
		if(classApiOperationIdMethodRequest == null) {
			_classApiOperationIdMethodRequest(classApiOperationIdMethodRequestWrap);
			setClassApiOperationIdMethodRequest(classApiOperationIdMethodRequestWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiOperationIdMethodRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiOperationIdMethodRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiOperationIdMethodRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassApiOperationIdMethodRequest(siteRequest_, ApiWriter.staticSearchClassApiOperationIdMethodRequest(siteRequest_, ApiWriter.staticSetClassApiOperationIdMethodRequest(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classApiOperationIdMethodResponse">Find the entity classApiOperationIdMethodResponse in Solr</a>
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
	public static String staticSetClassApiOperationIdMethodResponse(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classApiOperationIdMethodResponseInit() {
		Wrap<String> classApiOperationIdMethodResponseWrap = new Wrap<String>().var("classApiOperationIdMethodResponse");
		if(classApiOperationIdMethodResponse == null) {
			_classApiOperationIdMethodResponse(classApiOperationIdMethodResponseWrap);
			setClassApiOperationIdMethodResponse(classApiOperationIdMethodResponseWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassApiOperationIdMethodResponse(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassApiOperationIdMethodResponse(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassApiOperationIdMethodResponse(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassApiOperationIdMethodResponse(siteRequest_, ApiWriter.staticSearchClassApiOperationIdMethodResponse(siteRequest_, ApiWriter.staticSetClassApiOperationIdMethodResponse(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classSuperApiOperationIdMethodRequest">Find the entity classSuperApiOperationIdMethodRequest in Solr</a>
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
	public static String staticSetClassSuperApiOperationIdMethodRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classSuperApiOperationIdMethodRequestInit() {
		Wrap<String> classSuperApiOperationIdMethodRequestWrap = new Wrap<String>().var("classSuperApiOperationIdMethodRequest");
		if(classSuperApiOperationIdMethodRequest == null) {
			_classSuperApiOperationIdMethodRequest(classSuperApiOperationIdMethodRequestWrap);
			setClassSuperApiOperationIdMethodRequest(classSuperApiOperationIdMethodRequestWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassSuperApiOperationIdMethodRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassSuperApiOperationIdMethodRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSuperApiOperationIdMethodRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassSuperApiOperationIdMethodRequest(siteRequest_, ApiWriter.staticSearchClassSuperApiOperationIdMethodRequest(siteRequest_, ApiWriter.staticSetClassSuperApiOperationIdMethodRequest(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classSuperApiOperationIdMethodResponse">Find the entity classSuperApiOperationIdMethodResponse in Solr</a>
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
	public static String staticSetClassSuperApiOperationIdMethodResponse(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classSuperApiOperationIdMethodResponseInit() {
		Wrap<String> classSuperApiOperationIdMethodResponseWrap = new Wrap<String>().var("classSuperApiOperationIdMethodResponse");
		if(classSuperApiOperationIdMethodResponse == null) {
			_classSuperApiOperationIdMethodResponse(classSuperApiOperationIdMethodResponseWrap);
			setClassSuperApiOperationIdMethodResponse(classSuperApiOperationIdMethodResponseWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassSuperApiOperationIdMethodResponse(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassSuperApiOperationIdMethodResponse(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSuperApiOperationIdMethodResponse(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassSuperApiOperationIdMethodResponse(siteRequest_, ApiWriter.staticSearchClassSuperApiOperationIdMethodResponse(siteRequest_, ApiWriter.staticSetClassSuperApiOperationIdMethodResponse(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classPageCanonicalNameMethod">Find the entity classPageCanonicalNameMethod in Solr</a>
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
	public static String staticSetClassPageCanonicalNameMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter classPageCanonicalNameMethodInit() {
		Wrap<String> classPageCanonicalNameMethodWrap = new Wrap<String>().var("classPageCanonicalNameMethod");
		if(classPageCanonicalNameMethod == null) {
			_classPageCanonicalNameMethod(classPageCanonicalNameMethodWrap);
			setClassPageCanonicalNameMethod(classPageCanonicalNameMethodWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassPageCanonicalNameMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassPageCanonicalNameMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassPageCanonicalNameMethod(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassPageCanonicalNameMethod(siteRequest_, ApiWriter.staticSearchClassPageCanonicalNameMethod(siteRequest_, ApiWriter.staticSetClassPageCanonicalNameMethod(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classKeywordsFound">Find the entity classKeywordsFound in Solr</a>
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
	public static Boolean staticSetClassKeywordsFound(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classKeywordsFoundInit() {
		Wrap<Boolean> classKeywordsFoundWrap = new Wrap<Boolean>().var("classKeywordsFound");
		if(classKeywordsFound == null) {
			_classKeywordsFound(classKeywordsFoundWrap);
			setClassKeywordsFound(classKeywordsFoundWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassKeywordsFound(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassKeywordsFound(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassKeywordsFound(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassKeywordsFound(siteRequest_, ApiWriter.staticSearchClassKeywordsFound(siteRequest_, ApiWriter.staticSetClassKeywordsFound(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classKeywords">Find the entity classKeywords in Solr</a>
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
	public static String staticSetClassKeywords(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassKeywords(String...objets) {
		for(String o : objets) {
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
	public void setClassKeywords(JsonArray objets) {
		classKeywords.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addClassKeywords(o);
		}
	}
	protected ApiWriter classKeywordsInit() {
		Wrap<List<String>> classKeywordsWrap = new Wrap<List<String>>().var("classKeywords");
		if(classKeywords == null) {
			_classKeywords(classKeywordsWrap);
			setClassKeywords(classKeywordsWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassKeywords(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassKeywords(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassKeywords(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassKeywords(siteRequest_, ApiWriter.staticSearchClassKeywords(siteRequest_, ApiWriter.staticSetClassKeywords(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classPublicRead">Find the entity classPublicRead in Solr</a>
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
	public static Boolean staticSetClassPublicRead(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classPublicReadInit() {
		Wrap<Boolean> classPublicReadWrap = new Wrap<Boolean>().var("classPublicRead");
		if(classPublicRead == null) {
			_classPublicRead(classPublicReadWrap);
			setClassPublicRead(classPublicReadWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassPublicRead(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassPublicRead(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassPublicRead(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassPublicRead(siteRequest_, ApiWriter.staticSearchClassPublicRead(siteRequest_, ApiWriter.staticSetClassPublicRead(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classRoleSession">Find the entity classRoleSession in Solr</a>
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
	public static Boolean staticSetClassRoleSession(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRoleSessionInit() {
		Wrap<Boolean> classRoleSessionWrap = new Wrap<Boolean>().var("classRoleSession");
		if(classRoleSession == null) {
			_classRoleSession(classRoleSessionWrap);
			setClassRoleSession(classRoleSessionWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRoleSession(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRoleSession(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleSession(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassRoleSession(siteRequest_, ApiWriter.staticSearchClassRoleSession(siteRequest_, ApiWriter.staticSetClassRoleSession(siteRequest_, o)));
	}

	//////////////////////////
	// classRoleUtilisateur //
	//////////////////////////

	/**	 The entity classRoleUtilisateur
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean classRoleUtilisateur;

	/**	<br> The entity classRoleUtilisateur
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classRoleUtilisateur">Find the entity classRoleUtilisateur in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classRoleUtilisateur(Wrap<Boolean> c);

	public Boolean getClassRoleUtilisateur() {
		return classRoleUtilisateur;
	}

	public void setClassRoleUtilisateur(Boolean classRoleUtilisateur) {
		this.classRoleUtilisateur = classRoleUtilisateur;
	}
	@JsonIgnore
	public void setClassRoleUtilisateur(String o) {
		this.classRoleUtilisateur = ApiWriter.staticSetClassRoleUtilisateur(siteRequest_, o);
	}
	public static Boolean staticSetClassRoleUtilisateur(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRoleUtilisateurInit() {
		Wrap<Boolean> classRoleUtilisateurWrap = new Wrap<Boolean>().var("classRoleUtilisateur");
		if(classRoleUtilisateur == null) {
			_classRoleUtilisateur(classRoleUtilisateurWrap);
			setClassRoleUtilisateur(classRoleUtilisateurWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRoleUtilisateur(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRoleUtilisateur(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleUtilisateur(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassRoleUtilisateur(siteRequest_, ApiWriter.staticSearchClassRoleUtilisateur(siteRequest_, ApiWriter.staticSetClassRoleUtilisateur(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classRoleAll">Find the entity classRoleAll in Solr</a>
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
	public static Boolean staticSetClassRoleAll(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRoleAllInit() {
		Wrap<Boolean> classRoleAllWrap = new Wrap<Boolean>().var("classRoleAll");
		if(classRoleAll == null) {
			_classRoleAll(classRoleAllWrap);
			setClassRoleAll(classRoleAllWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRoleAll(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRoleAll(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoleAll(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassRoleAll(siteRequest_, ApiWriter.staticSearchClassRoleAll(siteRequest_, ApiWriter.staticSetClassRoleAll(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classRolesFound">Find the entity classRolesFound in Solr</a>
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
	public static Boolean staticSetClassRolesFound(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ApiWriter classRolesFoundInit() {
		Wrap<Boolean> classRolesFoundWrap = new Wrap<Boolean>().var("classRolesFound");
		if(classRolesFound == null) {
			_classRolesFound(classRolesFoundWrap);
			setClassRolesFound(classRolesFoundWrap.o);
		}
		return (ApiWriter)this;
	}

	public static Boolean staticSearchClassRolesFound(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrClassRolesFound(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRolesFound(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassRolesFound(siteRequest_, ApiWriter.staticSearchClassRolesFound(siteRequest_, ApiWriter.staticSetClassRolesFound(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classRoles">Find the entity classRoles in Solr</a>
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
	public static String staticSetClassRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassRoles(String...objets) {
		for(String o : objets) {
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
	public void setClassRoles(JsonArray objets) {
		classRoles.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addClassRoles(o);
		}
	}
	protected ApiWriter classRolesInit() {
		Wrap<List<String>> classRolesWrap = new Wrap<List<String>>().var("classRoles");
		if(classRoles == null) {
			_classRoles(classRolesWrap);
			setClassRoles(classRolesWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRoles(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassRoles(siteRequest_, ApiWriter.staticSearchClassRoles(siteRequest_, ApiWriter.staticSetClassRoles(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classRolesLanguage">Find the entity classRolesLanguage in Solr</a>
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
	public static String staticSetClassRolesLanguage(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ApiWriter addClassRolesLanguage(String...objets) {
		for(String o : objets) {
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
	public void setClassRolesLanguage(JsonArray objets) {
		classRolesLanguage.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addClassRolesLanguage(o);
		}
	}
	protected ApiWriter classRolesLanguageInit() {
		Wrap<List<String>> classRolesLanguageWrap = new Wrap<List<String>>().var("classRolesLanguage");
		if(classRolesLanguage == null) {
			_classRolesLanguage(classRolesLanguageWrap);
			setClassRolesLanguage(classRolesLanguageWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchClassRolesLanguage(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassRolesLanguage(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassRolesLanguage(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrClassRolesLanguage(siteRequest_, ApiWriter.staticSearchClassRolesLanguage(siteRequest_, ApiWriter.staticSetClassRolesLanguage(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:languageName">Find the entity languageName in Solr</a>
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
	public static String staticSetLanguageName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ApiWriter languageNameInit() {
		Wrap<String> languageNameWrap = new Wrap<String>().var("languageName");
		if(languageName == null) {
			_languageName(languageNameWrap);
			setLanguageName(languageNameWrap.o);
		}
		return (ApiWriter)this;
	}

	public static String staticSearchLanguageName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrLanguageName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqLanguageName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ApiWriter.staticSearchStrLanguageName(siteRequest_, ApiWriter.staticSearchLanguageName(siteRequest_, ApiWriter.staticSetLanguageName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.writer.ApiWriter&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:entitySolrDocument">Find the entity entitySolrDocument in Solr</a>
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
	public static Doc staticSetEntitySolrDocument(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ApiWriter entitySolrDocumentInit() {
		Wrap<Doc> entitySolrDocumentWrap = new Wrap<Doc>().var("entitySolrDocument");
		if(entitySolrDocument == null) {
			_entitySolrDocument(entitySolrDocumentWrap);
			setEntitySolrDocument(entitySolrDocumentWrap.o);
		}
		return (ApiWriter)this;
	}

	//////////////
	// initDeep //
	//////////////

	public ApiWriter initDeepApiWriter(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepApiWriter();
		return (ApiWriter)this;
	}

	public void initDeepApiWriter() {
		initApiWriter();
	}

	public void initApiWriter() {
				siteRequest_Init();
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
				classSimpleNameInit();
				appNameInit();
				classAbsolutePathInit();
				classApiUriMethodInit();
				classRoleUserMethodInit();
				classApiMethodMethodInit();
				classApiMediaType200MethodInit();
				classApiOperationIdMethodInit();
				classApiOperationIdMethodRequestInit();
				classApiOperationIdMethodResponseInit();
				classSuperApiOperationIdMethodRequestInit();
				classSuperApiOperationIdMethodResponseInit();
				classPageCanonicalNameMethodInit();
				classKeywordsFoundInit();
				classKeywordsInit();
				classPublicReadInit();
				classRoleSessionInit();
				classRoleUtilisateurInit();
				classRoleAllInit();
				classRolesFoundInit();
				classRolesInit();
				classRolesLanguageInit();
				languageNameInit();
				entitySolrDocumentInit();
	}

	public void initDeepForClass(ComputateVertxSiteRequest siteRequest_) {
		initDeepApiWriter(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestApiWriter(ComputateVertxSiteRequest siteRequest_) {
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

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
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
	public Object obtainApiWriter(String var) {
		ApiWriter oApiWriter = (ApiWriter)this;
		switch(var) {
			case "siteRequest_":
				return oApiWriter.siteRequest_;
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
			case "classKeywordsFound":
				return oApiWriter.classKeywordsFound;
			case "classKeywords":
				return oApiWriter.classKeywords;
			case "classPublicRead":
				return oApiWriter.classPublicRead;
			case "classRoleSession":
				return oApiWriter.classRoleSession;
			case "classRoleUtilisateur":
				return oApiWriter.classRoleUtilisateur;
			case "classRoleAll":
				return oApiWriter.classRoleAll;
			case "classRolesFound":
				return oApiWriter.classRolesFound;
			case "classRoles":
				return oApiWriter.classRoles;
			case "classRolesLanguage":
				return oApiWriter.classRolesLanguage;
			case "languageName":
				return oApiWriter.languageName;
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
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
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

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetApiWriter(entityVar,  siteRequest_, o);
	}
	public static Object staticSetApiWriter(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
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
		case "classApiTag":
			return ApiWriter.staticSetClassApiTag(siteRequest_, o);
		case "classExtendsBase":
			return ApiWriter.staticSetClassExtendsBase(siteRequest_, o);
		case "classIsBase":
			return ApiWriter.staticSetClassIsBase(siteRequest_, o);
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
		case "classKeywordsFound":
			return ApiWriter.staticSetClassKeywordsFound(siteRequest_, o);
		case "classKeywords":
			return ApiWriter.staticSetClassKeywords(siteRequest_, o);
		case "classPublicRead":
			return ApiWriter.staticSetClassPublicRead(siteRequest_, o);
		case "classRoleSession":
			return ApiWriter.staticSetClassRoleSession(siteRequest_, o);
		case "classRoleUtilisateur":
			return ApiWriter.staticSetClassRoleUtilisateur(siteRequest_, o);
		case "classRoleAll":
			return ApiWriter.staticSetClassRoleAll(siteRequest_, o);
		case "classRolesFound":
			return ApiWriter.staticSetClassRolesFound(siteRequest_, o);
		case "classRoles":
			return ApiWriter.staticSetClassRoles(siteRequest_, o);
		case "classRolesLanguage":
			return ApiWriter.staticSetClassRolesLanguage(siteRequest_, o);
		case "languageName":
			return ApiWriter.staticSetLanguageName(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchApiWriter(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchApiWriter(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
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
		case "classApiTag":
			return ApiWriter.staticSearchClassApiTag(siteRequest_, (String)o);
		case "classExtendsBase":
			return ApiWriter.staticSearchClassExtendsBase(siteRequest_, (Boolean)o);
		case "classIsBase":
			return ApiWriter.staticSearchClassIsBase(siteRequest_, (Boolean)o);
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
		case "classKeywordsFound":
			return ApiWriter.staticSearchClassKeywordsFound(siteRequest_, (Boolean)o);
		case "classKeywords":
			return ApiWriter.staticSearchClassKeywords(siteRequest_, (String)o);
		case "classPublicRead":
			return ApiWriter.staticSearchClassPublicRead(siteRequest_, (Boolean)o);
		case "classRoleSession":
			return ApiWriter.staticSearchClassRoleSession(siteRequest_, (Boolean)o);
		case "classRoleUtilisateur":
			return ApiWriter.staticSearchClassRoleUtilisateur(siteRequest_, (Boolean)o);
		case "classRoleAll":
			return ApiWriter.staticSearchClassRoleAll(siteRequest_, (Boolean)o);
		case "classRolesFound":
			return ApiWriter.staticSearchClassRolesFound(siteRequest_, (Boolean)o);
		case "classRoles":
			return ApiWriter.staticSearchClassRoles(siteRequest_, (String)o);
		case "classRolesLanguage":
			return ApiWriter.staticSearchClassRolesLanguage(siteRequest_, (String)o);
		case "languageName":
			return ApiWriter.staticSearchLanguageName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchStrApiWriter(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrApiWriter(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
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
		case "classApiTag":
			return ApiWriter.staticSearchStrClassApiTag(siteRequest_, (String)o);
		case "classExtendsBase":
			return ApiWriter.staticSearchStrClassExtendsBase(siteRequest_, (Boolean)o);
		case "classIsBase":
			return ApiWriter.staticSearchStrClassIsBase(siteRequest_, (Boolean)o);
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
		case "classKeywordsFound":
			return ApiWriter.staticSearchStrClassKeywordsFound(siteRequest_, (Boolean)o);
		case "classKeywords":
			return ApiWriter.staticSearchStrClassKeywords(siteRequest_, (String)o);
		case "classPublicRead":
			return ApiWriter.staticSearchStrClassPublicRead(siteRequest_, (Boolean)o);
		case "classRoleSession":
			return ApiWriter.staticSearchStrClassRoleSession(siteRequest_, (Boolean)o);
		case "classRoleUtilisateur":
			return ApiWriter.staticSearchStrClassRoleUtilisateur(siteRequest_, (Boolean)o);
		case "classRoleAll":
			return ApiWriter.staticSearchStrClassRoleAll(siteRequest_, (Boolean)o);
		case "classRolesFound":
			return ApiWriter.staticSearchStrClassRolesFound(siteRequest_, (Boolean)o);
		case "classRoles":
			return ApiWriter.staticSearchStrClassRoles(siteRequest_, (String)o);
		case "classRolesLanguage":
			return ApiWriter.staticSearchStrClassRolesLanguage(siteRequest_, (String)o);
		case "languageName":
			return ApiWriter.staticSearchStrLanguageName(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSearchFqApiWriter(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqApiWriter(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
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
		case "classApiTag":
			return ApiWriter.staticSearchFqClassApiTag(siteRequest_, o);
		case "classExtendsBase":
			return ApiWriter.staticSearchFqClassExtendsBase(siteRequest_, o);
		case "classIsBase":
			return ApiWriter.staticSearchFqClassIsBase(siteRequest_, o);
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
		case "classKeywordsFound":
			return ApiWriter.staticSearchFqClassKeywordsFound(siteRequest_, o);
		case "classKeywords":
			return ApiWriter.staticSearchFqClassKeywords(siteRequest_, o);
		case "classPublicRead":
			return ApiWriter.staticSearchFqClassPublicRead(siteRequest_, o);
		case "classRoleSession":
			return ApiWriter.staticSearchFqClassRoleSession(siteRequest_, o);
		case "classRoleUtilisateur":
			return ApiWriter.staticSearchFqClassRoleUtilisateur(siteRequest_, o);
		case "classRoleAll":
			return ApiWriter.staticSearchFqClassRoleAll(siteRequest_, o);
		case "classRolesFound":
			return ApiWriter.staticSearchFqClassRolesFound(siteRequest_, o);
		case "classRoles":
			return ApiWriter.staticSearchFqClassRoles(siteRequest_, o);
		case "classRolesLanguage":
			return ApiWriter.staticSearchFqClassRolesLanguage(siteRequest_, o);
		case "languageName":
			return ApiWriter.staticSearchFqLanguageName(siteRequest_, o);
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean persistForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineApiWriter(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.persistForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineApiWriter(String var, Object val) {
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
	public static final String VAR_classSimpleName = "classSimpleName";
	public static final String VAR_appName = "appName";
	public static final String VAR_classAbsolutePath = "classAbsolutePath";
	public static final String VAR_classApiUriMethod = "classApiUriMethod";
	public static final String VAR_classRoleUserMethod = "classRoleUserMethod";
	public static final String VAR_classApiMethodMethod = "classApiMethodMethod";
	public static final String VAR_classApiMediaType200Method = "classApiMediaType200Method";
	public static final String VAR_classApiOperationIdMethod = "classApiOperationIdMethod";
	public static final String VAR_classApiOperationIdMethodRequest = "classApiOperationIdMethodRequest";
	public static final String VAR_classApiOperationIdMethodResponse = "classApiOperationIdMethodResponse";
	public static final String VAR_classSuperApiOperationIdMethodRequest = "classSuperApiOperationIdMethodRequest";
	public static final String VAR_classSuperApiOperationIdMethodResponse = "classSuperApiOperationIdMethodResponse";
	public static final String VAR_classPageCanonicalNameMethod = "classPageCanonicalNameMethod";
	public static final String VAR_classKeywordsFound = "classKeywordsFound";
	public static final String VAR_classKeywords = "classKeywords";
	public static final String VAR_classPublicRead = "classPublicRead";
	public static final String VAR_classRoleSession = "classRoleSession";
	public static final String VAR_classRoleUtilisateur = "classRoleUtilisateur";
	public static final String VAR_classRoleAll = "classRoleAll";
	public static final String VAR_classRolesFound = "classRolesFound";
	public static final String VAR_classRoles = "classRoles";
	public static final String VAR_classRolesLanguage = "classRolesLanguage";
	public static final String VAR_languageName = "languageName";
	public static final String VAR_entitySolrDocument = "entitySolrDocument";

	public static final String DISPLAY_NAME_siteRequest_ = "";
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
	public static final String DISPLAY_NAME_classSimpleName = "";
	public static final String DISPLAY_NAME_appName = "";
	public static final String DISPLAY_NAME_classAbsolutePath = "";
	public static final String DISPLAY_NAME_classApiUriMethod = "";
	public static final String DISPLAY_NAME_classRoleUserMethod = "";
	public static final String DISPLAY_NAME_classApiMethodMethod = "";
	public static final String DISPLAY_NAME_classApiMediaType200Method = "";
	public static final String DISPLAY_NAME_classApiOperationIdMethod = "";
	public static final String DISPLAY_NAME_classApiOperationIdMethodRequest = "";
	public static final String DISPLAY_NAME_classApiOperationIdMethodResponse = "";
	public static final String DISPLAY_NAME_classSuperApiOperationIdMethodRequest = "";
	public static final String DISPLAY_NAME_classSuperApiOperationIdMethodResponse = "";
	public static final String DISPLAY_NAME_classPageCanonicalNameMethod = "";
	public static final String DISPLAY_NAME_classKeywordsFound = "";
	public static final String DISPLAY_NAME_classKeywords = "";
	public static final String DISPLAY_NAME_classPublicRead = "";
	public static final String DISPLAY_NAME_classRoleSession = "";
	public static final String DISPLAY_NAME_classRoleUtilisateur = "";
	public static final String DISPLAY_NAME_classRoleAll = "";
	public static final String DISPLAY_NAME_classRolesFound = "";
	public static final String DISPLAY_NAME_classRoles = "";
	public static final String DISPLAY_NAME_classRolesLanguage = "";
	public static final String DISPLAY_NAME_languageName = "";
	public static final String DISPLAY_NAME_entitySolrDocument = "";

	public static String displayNameForClass(String var) {
		return ApiWriter.displayNameApiWriter(var);
	}
	public static String displayNameApiWriter(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
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
		case VAR_classKeywordsFound:
			return DISPLAY_NAME_classKeywordsFound;
		case VAR_classKeywords:
			return DISPLAY_NAME_classKeywords;
		case VAR_classPublicRead:
			return DISPLAY_NAME_classPublicRead;
		case VAR_classRoleSession:
			return DISPLAY_NAME_classRoleSession;
		case VAR_classRoleUtilisateur:
			return DISPLAY_NAME_classRoleUtilisateur;
		case VAR_classRoleAll:
			return DISPLAY_NAME_classRoleAll;
		case VAR_classRolesFound:
			return DISPLAY_NAME_classRolesFound;
		case VAR_classRoles:
			return DISPLAY_NAME_classRoles;
		case VAR_classRolesLanguage:
			return DISPLAY_NAME_classRolesLanguage;
		case VAR_languageName:
			return DISPLAY_NAME_languageName;
		case VAR_entitySolrDocument:
			return DISPLAY_NAME_entitySolrDocument;
		default:
			return null;
		}
	}
}
