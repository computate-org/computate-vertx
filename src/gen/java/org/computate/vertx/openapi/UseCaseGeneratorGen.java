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
import org.computate.vertx.openapi.FiwareGenerator;
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
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these UseCaseGenerator objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class UseCaseGeneratorGen into the class UseCaseGenerator. 
 * </li>
 * <h3>About the UseCaseGenerator class and it's generated class UseCaseGeneratorGen&lt;FiwareGenerator&gt;: </h3>extends UseCaseGeneratorGen
 * <p>
 * This Java class extends a generated Java class UseCaseGeneratorGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator">Find the class UseCaseGenerator in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends UseCaseGeneratorGen<FiwareGenerator>
 * <p>This <code>class UseCaseGenerator extends UseCaseGeneratorGen&lt;FiwareGenerator&gt;</code>, which means it extends a newly generated UseCaseGeneratorGen. 
 * The generated <code>class UseCaseGeneratorGen extends FiwareGenerator</code> which means that UseCaseGenerator extends UseCaseGeneratorGen which extends FiwareGenerator. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the UseCaseGenerator class will inherit the helpful inherited class comments from the super class UseCaseGeneratorGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class UseCaseGenerator in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
public abstract class UseCaseGeneratorGen<DEV> extends FiwareGenerator {
	protected static final Logger LOG = LoggerFactory.getLogger(UseCaseGenerator.class);

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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:fiwareSwaggerYamlPath">Find the entity fiwareSwaggerYamlPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _fiwareSwaggerYamlPath(Wrap<String> c);

	public String getFiwareSwaggerYamlPath() {
		return fiwareSwaggerYamlPath;
	}
	public void setFiwareSwaggerYamlPath(String o) {
		this.fiwareSwaggerYamlPath = UseCaseGenerator.staticSetFiwareSwaggerYamlPath(siteRequest_, o);
	}
	public static String staticSetFiwareSwaggerYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected UseCaseGenerator fiwareSwaggerYamlPathInit() {
		Wrap<String> fiwareSwaggerYamlPathWrap = new Wrap<String>().var("fiwareSwaggerYamlPath");
		if(fiwareSwaggerYamlPath == null) {
			_fiwareSwaggerYamlPath(fiwareSwaggerYamlPathWrap);
			Optional.ofNullable(fiwareSwaggerYamlPathWrap.getO()).ifPresent(o -> {
				setFiwareSwaggerYamlPath(o);
			});
		}
		return (UseCaseGenerator)this;
	}

	public static String staticSearchFiwareSwaggerYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrFiwareSwaggerYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqFiwareSwaggerYamlPath(ComputateSiteRequest siteRequest_, String o) {
		return UseCaseGenerator.staticSearchFiwareSwaggerYamlPath(siteRequest_, UseCaseGenerator.staticSetFiwareSwaggerYamlPath(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:fiwareSwaggerYamlFile">Find the entity fiwareSwaggerYamlFile in Solr</a>
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
	protected UseCaseGenerator fiwareSwaggerYamlFileInit() {
		Wrap<File> fiwareSwaggerYamlFileWrap = new Wrap<File>().var("fiwareSwaggerYamlFile");
		if(fiwareSwaggerYamlFile == null) {
			_fiwareSwaggerYamlFile(fiwareSwaggerYamlFileWrap);
			Optional.ofNullable(fiwareSwaggerYamlFileWrap.getO()).ifPresent(o -> {
				setFiwareSwaggerYamlFile(o);
			});
		}
		return (UseCaseGenerator)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:wFiwareSwagger">Find the entity wFiwareSwagger in Solr</a>
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
	protected UseCaseGenerator wFiwareSwaggerInit() {
		Wrap<AllWriter> wFiwareSwaggerWrap = new Wrap<AllWriter>().var("wFiwareSwagger");
		if(wFiwareSwagger == null) {
			_wFiwareSwagger(wFiwareSwaggerWrap);
			Optional.ofNullable(wFiwareSwaggerWrap.getO()).ifPresent(o -> {
				setWFiwareSwagger(o);
			});
		}
		if(wFiwareSwagger != null)
			wFiwareSwagger.initDeepForClass(siteRequest_);
		return (UseCaseGenerator)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:wFiwareExamples">Find the entity wFiwareExamples in Solr</a>
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
	protected UseCaseGenerator wFiwareExamplesInit() {
		Wrap<AllWriter> wFiwareExamplesWrap = new Wrap<AllWriter>().var("wFiwareExamples");
		if(wFiwareExamples == null) {
			_wFiwareExamples(wFiwareExamplesWrap);
			Optional.ofNullable(wFiwareExamplesWrap.getO()).ifPresent(o -> {
				setWFiwareExamples(o);
			});
		}
		if(wFiwareExamples != null)
			wFiwareExamples.initDeepForClass(siteRequest_);
		return (UseCaseGenerator)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:wFiwareExamplesNormalized">Find the entity wFiwareExamplesNormalized in Solr</a>
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
	protected UseCaseGenerator wFiwareExamplesNormalizedInit() {
		Wrap<AllWriter> wFiwareExamplesNormalizedWrap = new Wrap<AllWriter>().var("wFiwareExamplesNormalized");
		if(wFiwareExamplesNormalized == null) {
			_wFiwareExamplesNormalized(wFiwareExamplesNormalizedWrap);
			Optional.ofNullable(wFiwareExamplesNormalizedWrap.getO()).ifPresent(o -> {
				setWFiwareExamplesNormalized(o);
			});
		}
		if(wFiwareExamplesNormalized != null)
			wFiwareExamplesNormalized.initDeepForClass(siteRequest_);
		return (UseCaseGenerator)this;
	}

	////////////////////
	// useCaseSummary //
	////////////////////


	/**	 The entity useCaseSummary
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject useCaseSummary = new JsonObject();

	/**	<br> The entity useCaseSummary
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:useCaseSummary">Find the entity useCaseSummary in Solr</a>
	 * <br>
	 * @param o is the entity already constructed. 
	 **/
	protected abstract void _useCaseSummary(JsonObject o);

	public JsonObject getUseCaseSummary() {
		return useCaseSummary;
	}

	public void setUseCaseSummary(JsonObject useCaseSummary) {
		this.useCaseSummary = useCaseSummary;
	}
	@JsonIgnore
	public void setUseCaseSummary(String o) {
		this.useCaseSummary = UseCaseGenerator.staticSetUseCaseSummary(siteRequest_, o);
	}
	public static JsonObject staticSetUseCaseSummary(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected UseCaseGenerator useCaseSummaryInit() {
		_useCaseSummary(useCaseSummary);
		return (UseCaseGenerator)this;
	}

	public static String staticSearchUseCaseSummary(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o.toString();
	}

	public static String staticSearchStrUseCaseSummary(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUseCaseSummary(ComputateSiteRequest siteRequest_, String o) {
		return UseCaseGenerator.staticSearchUseCaseSummary(siteRequest_, UseCaseGenerator.staticSetUseCaseSummary(siteRequest_, o)).toString();
	}

	//////////////////////////////
	// useCaseSummaryJsonldPath //
	//////////////////////////////


	/**	 The entity useCaseSummaryJsonldPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String useCaseSummaryJsonldPath;

	/**	<br> The entity useCaseSummaryJsonldPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:useCaseSummaryJsonldPath">Find the entity useCaseSummaryJsonldPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _useCaseSummaryJsonldPath(Wrap<String> c);

	public String getUseCaseSummaryJsonldPath() {
		return useCaseSummaryJsonldPath;
	}
	public void setUseCaseSummaryJsonldPath(String o) {
		this.useCaseSummaryJsonldPath = UseCaseGenerator.staticSetUseCaseSummaryJsonldPath(siteRequest_, o);
	}
	public static String staticSetUseCaseSummaryJsonldPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected UseCaseGenerator useCaseSummaryJsonldPathInit() {
		Wrap<String> useCaseSummaryJsonldPathWrap = new Wrap<String>().var("useCaseSummaryJsonldPath");
		if(useCaseSummaryJsonldPath == null) {
			_useCaseSummaryJsonldPath(useCaseSummaryJsonldPathWrap);
			Optional.ofNullable(useCaseSummaryJsonldPathWrap.getO()).ifPresent(o -> {
				setUseCaseSummaryJsonldPath(o);
			});
		}
		return (UseCaseGenerator)this;
	}

	public static String staticSearchUseCaseSummaryJsonldPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrUseCaseSummaryJsonldPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUseCaseSummaryJsonldPath(ComputateSiteRequest siteRequest_, String o) {
		return UseCaseGenerator.staticSearchUseCaseSummaryJsonldPath(siteRequest_, UseCaseGenerator.staticSetUseCaseSummaryJsonldPath(siteRequest_, o)).toString();
	}

	//////////////////////////////
	// useCaseSummaryJsonldFile //
	//////////////////////////////


	/**	 The entity useCaseSummaryJsonldFile
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File useCaseSummaryJsonldFile;

	/**	<br> The entity useCaseSummaryJsonldFile
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:useCaseSummaryJsonldFile">Find the entity useCaseSummaryJsonldFile in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _useCaseSummaryJsonldFile(Wrap<File> c);

	public File getUseCaseSummaryJsonldFile() {
		return useCaseSummaryJsonldFile;
	}

	public void setUseCaseSummaryJsonldFile(File useCaseSummaryJsonldFile) {
		this.useCaseSummaryJsonldFile = useCaseSummaryJsonldFile;
	}
	public static File staticSetUseCaseSummaryJsonldFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected UseCaseGenerator useCaseSummaryJsonldFileInit() {
		Wrap<File> useCaseSummaryJsonldFileWrap = new Wrap<File>().var("useCaseSummaryJsonldFile");
		if(useCaseSummaryJsonldFile == null) {
			_useCaseSummaryJsonldFile(useCaseSummaryJsonldFileWrap);
			Optional.ofNullable(useCaseSummaryJsonldFileWrap.getO()).ifPresent(o -> {
				setUseCaseSummaryJsonldFile(o);
			});
		}
		return (UseCaseGenerator)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:wFiwareContext">Find the entity wFiwareContext in Solr</a>
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
	protected UseCaseGenerator wFiwareContextInit() {
		Wrap<AllWriter> wFiwareContextWrap = new Wrap<AllWriter>().var("wFiwareContext");
		if(wFiwareContext == null) {
			_wFiwareContext(wFiwareContextWrap);
			Optional.ofNullable(wFiwareContextWrap.getO()).ifPresent(o -> {
				setWFiwareContext(o);
			});
		}
		if(wFiwareContext != null)
			wFiwareContext.initDeepForClass(siteRequest_);
		return (UseCaseGenerator)this;
	}

	//////////////
	// initDeep //
	//////////////

	public UseCaseGenerator initDeepUseCaseGenerator(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepUseCaseGenerator();
		return (UseCaseGenerator)this;
	}

	public void initDeepUseCaseGenerator() {
		super.initDeepFiwareGenerator(siteRequest_);
		initUseCaseGenerator();
	}

	public void initUseCaseGenerator() {
				fiwareSwaggerYamlPathInit();
				fiwareSwaggerYamlFileInit();
				wFiwareSwaggerInit();
				wFiwareExamplesInit();
				wFiwareExamplesNormalizedInit();
				useCaseSummaryInit();
				useCaseSummaryJsonldPathInit();
				useCaseSummaryJsonldFileInit();
				wFiwareContextInit();
	}

	@Override public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepUseCaseGenerator(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestUseCaseGenerator(ComputateSiteRequest siteRequest_) {
			super.siteRequestFiwareGenerator(siteRequest_);
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
		siteRequestUseCaseGenerator(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainUseCaseGenerator(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainUseCaseGenerator(String var) {
		UseCaseGenerator oUseCaseGenerator = (UseCaseGenerator)this;
		switch(var) {
			case "fiwareSwaggerYamlPath":
				return oUseCaseGenerator.fiwareSwaggerYamlPath;
			case "fiwareSwaggerYamlFile":
				return oUseCaseGenerator.fiwareSwaggerYamlFile;
			case "wFiwareSwagger":
				return oUseCaseGenerator.wFiwareSwagger;
			case "wFiwareExamples":
				return oUseCaseGenerator.wFiwareExamples;
			case "wFiwareExamplesNormalized":
				return oUseCaseGenerator.wFiwareExamplesNormalized;
			case "useCaseSummary":
				return oUseCaseGenerator.useCaseSummary;
			case "useCaseSummaryJsonldPath":
				return oUseCaseGenerator.useCaseSummaryJsonldPath;
			case "useCaseSummaryJsonldFile":
				return oUseCaseGenerator.useCaseSummaryJsonldFile;
			case "wFiwareContext":
				return oUseCaseGenerator.wFiwareContext;
			default:
				return super.obtainFiwareGenerator(var);
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
				o = relateUseCaseGenerator(v, val);
		}
		return o != null;
	}
	public Object relateUseCaseGenerator(String var, Object val) {
		UseCaseGenerator oUseCaseGenerator = (UseCaseGenerator)this;
		switch(var) {
			default:
				return super.relateFiwareGenerator(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetUseCaseGenerator(entityVar,  siteRequest_, o);
	}
	public static Object staticSetUseCaseGenerator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "fiwareSwaggerYamlPath":
			return UseCaseGenerator.staticSetFiwareSwaggerYamlPath(siteRequest_, o);
		case "useCaseSummary":
			return UseCaseGenerator.staticSetUseCaseSummary(siteRequest_, o);
		case "useCaseSummaryJsonldPath":
			return UseCaseGenerator.staticSetUseCaseSummaryJsonldPath(siteRequest_, o);
			default:
				return FiwareGenerator.staticSetFiwareGenerator(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchUseCaseGenerator(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchUseCaseGenerator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "fiwareSwaggerYamlPath":
			return UseCaseGenerator.staticSearchFiwareSwaggerYamlPath(siteRequest_, (String)o);
		case "useCaseSummary":
			return UseCaseGenerator.staticSearchUseCaseSummary(siteRequest_, (JsonObject)o);
		case "useCaseSummaryJsonldPath":
			return UseCaseGenerator.staticSearchUseCaseSummaryJsonldPath(siteRequest_, (String)o);
			default:
				return FiwareGenerator.staticSearchFiwareGenerator(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrUseCaseGenerator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrUseCaseGenerator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "fiwareSwaggerYamlPath":
			return UseCaseGenerator.staticSearchStrFiwareSwaggerYamlPath(siteRequest_, (String)o);
		case "useCaseSummary":
			return UseCaseGenerator.staticSearchStrUseCaseSummary(siteRequest_, (String)o);
		case "useCaseSummaryJsonldPath":
			return UseCaseGenerator.staticSearchStrUseCaseSummaryJsonldPath(siteRequest_, (String)o);
			default:
				return FiwareGenerator.staticSearchStrFiwareGenerator(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqUseCaseGenerator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqUseCaseGenerator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "fiwareSwaggerYamlPath":
			return UseCaseGenerator.staticSearchFqFiwareSwaggerYamlPath(siteRequest_, o);
		case "useCaseSummary":
			return UseCaseGenerator.staticSearchFqUseCaseSummary(siteRequest_, o);
		case "useCaseSummaryJsonldPath":
			return UseCaseGenerator.staticSearchFqUseCaseSummaryJsonldPath(siteRequest_, o);
			default:
				return FiwareGenerator.staticSearchFqFiwareGenerator(entityVar,  siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "UseCaseGenerator";
	public static final String VAR_fiwareSwaggerYamlPath = "fiwareSwaggerYamlPath";
	public static final String VAR_fiwareSwaggerYamlFile = "fiwareSwaggerYamlFile";
	public static final String VAR_wFiwareSwagger = "wFiwareSwagger";
	public static final String VAR_wFiwareExamples = "wFiwareExamples";
	public static final String VAR_wFiwareExamplesNormalized = "wFiwareExamplesNormalized";
	public static final String VAR_useCaseSummary = "useCaseSummary";
	public static final String VAR_useCaseSummaryJsonldPath = "useCaseSummaryJsonldPath";
	public static final String VAR_useCaseSummaryJsonldFile = "useCaseSummaryJsonldFile";
	public static final String VAR_wFiwareContext = "wFiwareContext";

	public static final String DISPLAY_NAME_fiwareSwaggerYamlPath = "";
	public static final String DISPLAY_NAME_fiwareSwaggerYamlFile = "";
	public static final String DISPLAY_NAME_wFiwareSwagger = "";
	public static final String DISPLAY_NAME_wFiwareExamples = "";
	public static final String DISPLAY_NAME_wFiwareExamplesNormalized = "";
	public static final String DISPLAY_NAME_useCaseSummary = "";
	public static final String DISPLAY_NAME_useCaseSummaryJsonldPath = "";
	public static final String DISPLAY_NAME_useCaseSummaryJsonldFile = "";
	public static final String DISPLAY_NAME_wFiwareContext = "";

	public static String displayNameForClass(String var) {
		return UseCaseGenerator.displayNameUseCaseGenerator(var);
	}
	public static String displayNameUseCaseGenerator(String var) {
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
		case VAR_useCaseSummary:
			return DISPLAY_NAME_useCaseSummary;
		case VAR_useCaseSummaryJsonldPath:
			return DISPLAY_NAME_useCaseSummaryJsonldPath;
		case VAR_useCaseSummaryJsonldFile:
			return DISPLAY_NAME_useCaseSummaryJsonldFile;
		case VAR_wFiwareContext:
			return DISPLAY_NAME_wFiwareContext;
		default:
			return FiwareGenerator.displayNameFiwareGenerator(var);
		}
	}
}
