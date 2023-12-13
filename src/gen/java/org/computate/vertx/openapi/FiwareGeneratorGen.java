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
import org.computate.vertx.openapi.BaseGenerator;
import java.lang.String;
import java.io.File;
import org.computate.vertx.writer.AllWriter;
import io.vertx.core.json.JsonObject;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these FiwareGenerator objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class FiwareGeneratorGen into the class FiwareGenerator. 
 * </li>
 * <h3>About the FiwareGenerator class and it's generated class FiwareGeneratorGen&lt;BaseGenerator&gt;: </h3>extends FiwareGeneratorGen
 * <p>
 * This Java class extends a generated Java class FiwareGeneratorGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator">Find the class FiwareGenerator in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends FiwareGeneratorGen<BaseGenerator>
 * <p>This <code>class FiwareGenerator extends FiwareGeneratorGen&lt;BaseGenerator&gt;</code>, which means it extends a newly generated FiwareGeneratorGen. 
 * The generated <code>class FiwareGeneratorGen extends BaseGenerator</code> which means that FiwareGenerator extends FiwareGeneratorGen which extends BaseGenerator. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>IconGroup: null</h2>
 * <h2>IconName: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the FiwareGenerator class will inherit the helpful inherited class comments from the super class FiwareGeneratorGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class FiwareGenerator in Solr: 
 * curl -k 'https://solr-solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.openapi in Solr: 
 * curl -k 'https://solr-solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.openapi&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr-solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class FiwareGeneratorGen<DEV> extends BaseGenerator {
	protected static final Logger LOG = LoggerFactory.getLogger(FiwareGenerator.class);

	///////////////////////////
	// fiwareSwaggerYamlPath //
	///////////////////////////


	/**	 The entity fiwareSwaggerYamlPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String fiwareSwaggerYamlPath;

	/**	<br> The entity fiwareSwaggerYamlPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:fiwareSwaggerYamlPath">Find the entity fiwareSwaggerYamlPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _fiwareSwaggerYamlPath(Wrap<String> c);

	public String getFiwareSwaggerYamlPath() {
		return fiwareSwaggerYamlPath;
	}
	public void setFiwareSwaggerYamlPath(String o) {
		this.fiwareSwaggerYamlPath = FiwareGenerator.staticSetFiwareSwaggerYamlPath(siteRequest_, o);
	}
	public static String staticSetFiwareSwaggerYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected FiwareGenerator fiwareSwaggerYamlPathInit() {
		Wrap<String> fiwareSwaggerYamlPathWrap = new Wrap<String>().var("fiwareSwaggerYamlPath");
		if(fiwareSwaggerYamlPath == null) {
			_fiwareSwaggerYamlPath(fiwareSwaggerYamlPathWrap);
			Optional.ofNullable(fiwareSwaggerYamlPathWrap.getO()).ifPresent(o -> {
				setFiwareSwaggerYamlPath(o);
			});
		}
		return (FiwareGenerator)this;
	}

	public static String staticSearchFiwareSwaggerYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrFiwareSwaggerYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFiwareSwaggerYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return FiwareGenerator.staticSearchStrFiwareSwaggerYamlPath(siteRequest_, FiwareGenerator.staticSearchFiwareSwaggerYamlPath(siteRequest_, FiwareGenerator.staticSetFiwareSwaggerYamlPath(siteRequest_, o)));
	}

	///////////////////////////
	// fiwareSwaggerYamlFile //
	///////////////////////////


	/**	 The entity fiwareSwaggerYamlFile
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File fiwareSwaggerYamlFile;

	/**	<br> The entity fiwareSwaggerYamlFile
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:fiwareSwaggerYamlFile">Find the entity fiwareSwaggerYamlFile in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _fiwareSwaggerYamlFile(Wrap<File> c);

	public File getFiwareSwaggerYamlFile() {
		return fiwareSwaggerYamlFile;
	}

	public void setFiwareSwaggerYamlFile(File fiwareSwaggerYamlFile) {
		this.fiwareSwaggerYamlFile = fiwareSwaggerYamlFile;
	}
	public static File staticSetFiwareSwaggerYamlFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected FiwareGenerator fiwareSwaggerYamlFileInit() {
		Wrap<File> fiwareSwaggerYamlFileWrap = new Wrap<File>().var("fiwareSwaggerYamlFile");
		if(fiwareSwaggerYamlFile == null) {
			_fiwareSwaggerYamlFile(fiwareSwaggerYamlFileWrap);
			Optional.ofNullable(fiwareSwaggerYamlFileWrap.getO()).ifPresent(o -> {
				setFiwareSwaggerYamlFile(o);
			});
		}
		return (FiwareGenerator)this;
	}

	////////////////////
	// wFiwareSwagger //
	////////////////////


	/**	 The entity wFiwareSwagger
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wFiwareSwagger;

	/**	<br> The entity wFiwareSwagger
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:wFiwareSwagger">Find the entity wFiwareSwagger in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wFiwareSwagger(Wrap<AllWriter> c);

	public AllWriter getWFiwareSwagger() {
		return wFiwareSwagger;
	}

	public void setWFiwareSwagger(AllWriter wFiwareSwagger) {
		this.wFiwareSwagger = wFiwareSwagger;
	}
	public static AllWriter staticSetWFiwareSwagger(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected FiwareGenerator wFiwareSwaggerInit() {
		Wrap<AllWriter> wFiwareSwaggerWrap = new Wrap<AllWriter>().var("wFiwareSwagger");
		if(wFiwareSwagger == null) {
			_wFiwareSwagger(wFiwareSwaggerWrap);
			Optional.ofNullable(wFiwareSwaggerWrap.getO()).ifPresent(o -> {
				setWFiwareSwagger(o);
			});
		}
		if(wFiwareSwagger != null)
			wFiwareSwagger.initDeepForClass(siteRequest_);
		return (FiwareGenerator)this;
	}

	/////////////////////
	// wFiwareExamples //
	/////////////////////


	/**	 The entity wFiwareExamples
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wFiwareExamples;

	/**	<br> The entity wFiwareExamples
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:wFiwareExamples">Find the entity wFiwareExamples in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wFiwareExamples(Wrap<AllWriter> c);

	public AllWriter getWFiwareExamples() {
		return wFiwareExamples;
	}

	public void setWFiwareExamples(AllWriter wFiwareExamples) {
		this.wFiwareExamples = wFiwareExamples;
	}
	public static AllWriter staticSetWFiwareExamples(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected FiwareGenerator wFiwareExamplesInit() {
		Wrap<AllWriter> wFiwareExamplesWrap = new Wrap<AllWriter>().var("wFiwareExamples");
		if(wFiwareExamples == null) {
			_wFiwareExamples(wFiwareExamplesWrap);
			Optional.ofNullable(wFiwareExamplesWrap.getO()).ifPresent(o -> {
				setWFiwareExamples(o);
			});
		}
		if(wFiwareExamples != null)
			wFiwareExamples.initDeepForClass(siteRequest_);
		return (FiwareGenerator)this;
	}

	///////////////////////////////
	// wFiwareExamplesNormalized //
	///////////////////////////////


	/**	 The entity wFiwareExamplesNormalized
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wFiwareExamplesNormalized;

	/**	<br> The entity wFiwareExamplesNormalized
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:wFiwareExamplesNormalized">Find the entity wFiwareExamplesNormalized in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wFiwareExamplesNormalized(Wrap<AllWriter> c);

	public AllWriter getWFiwareExamplesNormalized() {
		return wFiwareExamplesNormalized;
	}

	public void setWFiwareExamplesNormalized(AllWriter wFiwareExamplesNormalized) {
		this.wFiwareExamplesNormalized = wFiwareExamplesNormalized;
	}
	public static AllWriter staticSetWFiwareExamplesNormalized(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected FiwareGenerator wFiwareExamplesNormalizedInit() {
		Wrap<AllWriter> wFiwareExamplesNormalizedWrap = new Wrap<AllWriter>().var("wFiwareExamplesNormalized");
		if(wFiwareExamplesNormalized == null) {
			_wFiwareExamplesNormalized(wFiwareExamplesNormalizedWrap);
			Optional.ofNullable(wFiwareExamplesNormalizedWrap.getO()).ifPresent(o -> {
				setWFiwareExamplesNormalized(o);
			});
		}
		if(wFiwareExamplesNormalized != null)
			wFiwareExamplesNormalized.initDeepForClass(siteRequest_);
		return (FiwareGenerator)this;
	}

	///////////////////
	// fiwareContext //
	///////////////////


	/**	 The entity fiwareContext
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject fiwareContext = new JsonObject();

	/**	<br> The entity fiwareContext
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:fiwareContext">Find the entity fiwareContext in Solr</a>
	 * <br>
	 * @param o is the entity already constructed. 
	 **/
	protected abstract void _fiwareContext(JsonObject o);

	public JsonObject getFiwareContext() {
		return fiwareContext;
	}

	public void setFiwareContext(JsonObject fiwareContext) {
		this.fiwareContext = fiwareContext;
	}
	@JsonIgnore
	public void setFiwareContext(String o) {
		this.fiwareContext = FiwareGenerator.staticSetFiwareContext(siteRequest_, o);
	}
	public static JsonObject staticSetFiwareContext(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected FiwareGenerator fiwareContextInit() {
		_fiwareContext(fiwareContext);
		return (FiwareGenerator)this;
	}

	public static String staticSearchFiwareContext(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrFiwareContext(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFiwareContext(ComputateSiteRequest siteRequest_, String o) {
		return FiwareGenerator.staticSearchStrFiwareContext(siteRequest_, FiwareGenerator.staticSearchFiwareContext(siteRequest_, FiwareGenerator.staticSetFiwareContext(siteRequest_, o)));
	}

	/////////////////////////////
	// fiwareContextJsonldPath //
	/////////////////////////////


	/**	 The entity fiwareContextJsonldPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String fiwareContextJsonldPath;

	/**	<br> The entity fiwareContextJsonldPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:fiwareContextJsonldPath">Find the entity fiwareContextJsonldPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _fiwareContextJsonldPath(Wrap<String> c);

	public String getFiwareContextJsonldPath() {
		return fiwareContextJsonldPath;
	}
	public void setFiwareContextJsonldPath(String o) {
		this.fiwareContextJsonldPath = FiwareGenerator.staticSetFiwareContextJsonldPath(siteRequest_, o);
	}
	public static String staticSetFiwareContextJsonldPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected FiwareGenerator fiwareContextJsonldPathInit() {
		Wrap<String> fiwareContextJsonldPathWrap = new Wrap<String>().var("fiwareContextJsonldPath");
		if(fiwareContextJsonldPath == null) {
			_fiwareContextJsonldPath(fiwareContextJsonldPathWrap);
			Optional.ofNullable(fiwareContextJsonldPathWrap.getO()).ifPresent(o -> {
				setFiwareContextJsonldPath(o);
			});
		}
		return (FiwareGenerator)this;
	}

	public static String staticSearchFiwareContextJsonldPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrFiwareContextJsonldPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFiwareContextJsonldPath(ComputateSiteRequest siteRequest_, String o) {
		return FiwareGenerator.staticSearchStrFiwareContextJsonldPath(siteRequest_, FiwareGenerator.staticSearchFiwareContextJsonldPath(siteRequest_, FiwareGenerator.staticSetFiwareContextJsonldPath(siteRequest_, o)));
	}

	/////////////////////////////
	// fiwareContextJsonldFile //
	/////////////////////////////


	/**	 The entity fiwareContextJsonldFile
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File fiwareContextJsonldFile;

	/**	<br> The entity fiwareContextJsonldFile
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:fiwareContextJsonldFile">Find the entity fiwareContextJsonldFile in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _fiwareContextJsonldFile(Wrap<File> c);

	public File getFiwareContextJsonldFile() {
		return fiwareContextJsonldFile;
	}

	public void setFiwareContextJsonldFile(File fiwareContextJsonldFile) {
		this.fiwareContextJsonldFile = fiwareContextJsonldFile;
	}
	public static File staticSetFiwareContextJsonldFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected FiwareGenerator fiwareContextJsonldFileInit() {
		Wrap<File> fiwareContextJsonldFileWrap = new Wrap<File>().var("fiwareContextJsonldFile");
		if(fiwareContextJsonldFile == null) {
			_fiwareContextJsonldFile(fiwareContextJsonldFileWrap);
			Optional.ofNullable(fiwareContextJsonldFileWrap.getO()).ifPresent(o -> {
				setFiwareContextJsonldFile(o);
			});
		}
		return (FiwareGenerator)this;
	}

	////////////////////
	// wFiwareContext //
	////////////////////


	/**	 The entity wFiwareContext
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wFiwareContext;

	/**	<br> The entity wFiwareContext
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr-solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.FiwareGenerator&fq=entiteVar_enUS_indexed_string:wFiwareContext">Find the entity wFiwareContext in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wFiwareContext(Wrap<AllWriter> c);

	public AllWriter getWFiwareContext() {
		return wFiwareContext;
	}

	public void setWFiwareContext(AllWriter wFiwareContext) {
		this.wFiwareContext = wFiwareContext;
	}
	public static AllWriter staticSetWFiwareContext(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected FiwareGenerator wFiwareContextInit() {
		Wrap<AllWriter> wFiwareContextWrap = new Wrap<AllWriter>().var("wFiwareContext");
		if(wFiwareContext == null) {
			_wFiwareContext(wFiwareContextWrap);
			Optional.ofNullable(wFiwareContextWrap.getO()).ifPresent(o -> {
				setWFiwareContext(o);
			});
		}
		if(wFiwareContext != null)
			wFiwareContext.initDeepForClass(siteRequest_);
		return (FiwareGenerator)this;
	}

	//////////////
	// initDeep //
	//////////////

	public FiwareGenerator initDeepFiwareGenerator(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepFiwareGenerator();
		return (FiwareGenerator)this;
	}

	public void initDeepFiwareGenerator() {
		super.initDeepBaseGenerator(siteRequest_);
		initFiwareGenerator();
	}

	public void initFiwareGenerator() {
				fiwareSwaggerYamlPathInit();
				fiwareSwaggerYamlFileInit();
				wFiwareSwaggerInit();
				wFiwareExamplesInit();
				wFiwareExamplesNormalizedInit();
				fiwareContextInit();
				fiwareContextJsonldPathInit();
				fiwareContextJsonldFileInit();
				wFiwareContextInit();
	}

	@Override public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepFiwareGenerator(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestFiwareGenerator(ComputateSiteRequest siteRequest_) {
			super.siteRequestBaseGenerator(siteRequest_);
		if(wFiwareSwagger != null)
			wFiwareSwagger.setSiteRequest_(siteRequest_);
		if(wFiwareExamples != null)
			wFiwareExamples.setSiteRequest_(siteRequest_);
		if(wFiwareExamplesNormalized != null)
			wFiwareExamplesNormalized.setSiteRequest_(siteRequest_);
		if(wFiwareContext != null)
			wFiwareContext.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestFiwareGenerator(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainFiwareGenerator(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainFiwareGenerator(String var) {
		FiwareGenerator oFiwareGenerator = (FiwareGenerator)this;
		switch(var) {
			case "fiwareSwaggerYamlPath":
				return oFiwareGenerator.fiwareSwaggerYamlPath;
			case "fiwareSwaggerYamlFile":
				return oFiwareGenerator.fiwareSwaggerYamlFile;
			case "wFiwareSwagger":
				return oFiwareGenerator.wFiwareSwagger;
			case "wFiwareExamples":
				return oFiwareGenerator.wFiwareExamples;
			case "wFiwareExamplesNormalized":
				return oFiwareGenerator.wFiwareExamplesNormalized;
			case "fiwareContext":
				return oFiwareGenerator.fiwareContext;
			case "fiwareContextJsonldPath":
				return oFiwareGenerator.fiwareContextJsonldPath;
			case "fiwareContextJsonldFile":
				return oFiwareGenerator.fiwareContextJsonldFile;
			case "wFiwareContext":
				return oFiwareGenerator.wFiwareContext;
			default:
				return super.obtainBaseGenerator(var);
		}
	}

	///////////////
	// relate //
	///////////////

	@Override public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateFiwareGenerator(v, val);
		}
		return o != null;
	}
	public Object relateFiwareGenerator(String var, Object val) {
		FiwareGenerator oFiwareGenerator = (FiwareGenerator)this;
		switch(var) {
			default:
				return super.relateBaseGenerator(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetFiwareGenerator(entityVar,  siteRequest_, o);
	}
	public static Object staticSetFiwareGenerator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "fiwareSwaggerYamlPath":
			return FiwareGenerator.staticSetFiwareSwaggerYamlPath(siteRequest_, o);
		case "fiwareContext":
			return FiwareGenerator.staticSetFiwareContext(siteRequest_, o);
		case "fiwareContextJsonldPath":
			return FiwareGenerator.staticSetFiwareContextJsonldPath(siteRequest_, o);
			default:
				return BaseGenerator.staticSetBaseGenerator(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchFiwareGenerator(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchFiwareGenerator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "fiwareSwaggerYamlPath":
			return FiwareGenerator.staticSearchFiwareSwaggerYamlPath(siteRequest_, (String)o);
		case "fiwareContext":
			return FiwareGenerator.staticSearchFiwareContext(siteRequest_, (JsonObject)o);
		case "fiwareContextJsonldPath":
			return FiwareGenerator.staticSearchFiwareContextJsonldPath(siteRequest_, (String)o);
			default:
				return BaseGenerator.staticSearchBaseGenerator(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrFiwareGenerator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrFiwareGenerator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "fiwareSwaggerYamlPath":
			return FiwareGenerator.staticSearchStrFiwareSwaggerYamlPath(siteRequest_, (String)o);
		case "fiwareContext":
			return FiwareGenerator.staticSearchStrFiwareContext(siteRequest_, (String)o);
		case "fiwareContextJsonldPath":
			return FiwareGenerator.staticSearchStrFiwareContextJsonldPath(siteRequest_, (String)o);
			default:
				return BaseGenerator.staticSearchStrBaseGenerator(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqFiwareGenerator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqFiwareGenerator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "fiwareSwaggerYamlPath":
			return FiwareGenerator.staticSearchFqFiwareSwaggerYamlPath(siteRequest_, o);
		case "fiwareContext":
			return FiwareGenerator.staticSearchFqFiwareContext(siteRequest_, o);
		case "fiwareContextJsonldPath":
			return FiwareGenerator.staticSearchFqFiwareContextJsonldPath(siteRequest_, o);
			default:
				return BaseGenerator.staticSearchFqBaseGenerator(entityVar,  siteRequest_, o);
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		return sb.toString();
	}

	public static final String CLASS_SIMPLE_NAME = "FiwareGenerator";
	public static final String CLASS_API_ADDRESS = "computate-vertx-enUS-FiwareGenerator";
	public static final String VAR_fiwareSwaggerYamlPath = "fiwareSwaggerYamlPath";
	public static final String VAR_fiwareSwaggerYamlFile = "fiwareSwaggerYamlFile";
	public static final String VAR_wFiwareSwagger = "wFiwareSwagger";
	public static final String VAR_wFiwareExamples = "wFiwareExamples";
	public static final String VAR_wFiwareExamplesNormalized = "wFiwareExamplesNormalized";
	public static final String VAR_fiwareContext = "fiwareContext";
	public static final String VAR_fiwareContextJsonldPath = "fiwareContextJsonldPath";
	public static final String VAR_fiwareContextJsonldFile = "fiwareContextJsonldFile";
	public static final String VAR_wFiwareContext = "wFiwareContext";

	public static final String DISPLAY_NAME_fiwareSwaggerYamlPath = "";
	public static final String DISPLAY_NAME_fiwareSwaggerYamlFile = "";
	public static final String DISPLAY_NAME_wFiwareSwagger = "";
	public static final String DISPLAY_NAME_wFiwareExamples = "";
	public static final String DISPLAY_NAME_wFiwareExamplesNormalized = "";
	public static final String DISPLAY_NAME_fiwareContext = "";
	public static final String DISPLAY_NAME_fiwareContextJsonldPath = "";
	public static final String DISPLAY_NAME_fiwareContextJsonldFile = "";
	public static final String DISPLAY_NAME_wFiwareContext = "";

	public static String displayNameForClass(String var) {
		return FiwareGenerator.displayNameFiwareGenerator(var);
	}
	public static String displayNameFiwareGenerator(String var) {
		switch(var) {
		case VAR_fiwareSwaggerYamlPath:
			return DISPLAY_NAME_fiwareSwaggerYamlPath;
		case VAR_fiwareSwaggerYamlFile:
			return DISPLAY_NAME_fiwareSwaggerYamlFile;
		case VAR_wFiwareSwagger:
			return DISPLAY_NAME_wFiwareSwagger;
		case VAR_wFiwareExamples:
			return DISPLAY_NAME_wFiwareExamples;
		case VAR_wFiwareExamplesNormalized:
			return DISPLAY_NAME_wFiwareExamplesNormalized;
		case VAR_fiwareContext:
			return DISPLAY_NAME_fiwareContext;
		case VAR_fiwareContextJsonldPath:
			return DISPLAY_NAME_fiwareContextJsonldPath;
		case VAR_fiwareContextJsonldFile:
			return DISPLAY_NAME_fiwareContextJsonldFile;
		case VAR_wFiwareContext:
			return DISPLAY_NAME_wFiwareContext;
		default:
			return BaseGenerator.displayNameBaseGenerator(var);
		}
	}
}
