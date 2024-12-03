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
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.lang.Integer;
import java.io.File;
import org.computate.vertx.writer.AllWriter;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

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

	/////////////////
	// useCasePath //
	/////////////////


	/**	 The entity useCasePath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String useCasePath;

	/**	<br> The entity useCasePath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:useCasePath">Find the entity useCasePath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _useCasePath(Wrap<String> c);

	public String getUseCasePath() {
		return useCasePath;
	}
	public void setUseCasePath(String o) {
		this.useCasePath = UseCaseGenerator.staticSetUseCasePath(siteRequest_, o);
	}
	public static String staticSetUseCasePath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected UseCaseGenerator useCasePathInit() {
		Wrap<String> useCasePathWrap = new Wrap<String>().var("useCasePath");
		if(useCasePath == null) {
			_useCasePath(useCasePathWrap);
			Optional.ofNullable(useCasePathWrap.getO()).ifPresent(o -> {
				setUseCasePath(o);
			});
		}
		return (UseCaseGenerator)this;
	}

	public static String staticSearchUseCasePath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrUseCasePath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUseCasePath(ComputateSiteRequest siteRequest_, String o) {
		return UseCaseGenerator.staticSearchUseCasePath(siteRequest_, UseCaseGenerator.staticSetUseCasePath(siteRequest_, o)).toString();
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

	/////////////////////////
	// useCaseSummaryCells //
	/////////////////////////


	/**	 The entity useCaseSummaryCells
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray useCaseSummaryCells = new JsonArray();

	/**	<br> The entity useCaseSummaryCells
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:useCaseSummaryCells">Find the entity useCaseSummaryCells in Solr</a>
	 * <br>
	 * @param a is the entity already constructed. 
	 **/
	protected abstract void _useCaseSummaryCells(JsonArray a);

	public JsonArray getUseCaseSummaryCells() {
		return useCaseSummaryCells;
	}

	public void setUseCaseSummaryCells(JsonArray useCaseSummaryCells) {
		this.useCaseSummaryCells = useCaseSummaryCells;
	}
	@JsonIgnore
	public void setUseCaseSummaryCells(String o) {
		this.useCaseSummaryCells = UseCaseGenerator.staticSetUseCaseSummaryCells(siteRequest_, o);
	}
	public static JsonArray staticSetUseCaseSummaryCells(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected UseCaseGenerator useCaseSummaryCellsInit() {
		_useCaseSummaryCells(useCaseSummaryCells);
		return (UseCaseGenerator)this;
	}

	public static String staticSearchUseCaseSummaryCells(ComputateSiteRequest siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrUseCaseSummaryCells(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUseCaseSummaryCells(ComputateSiteRequest siteRequest_, String o) {
		return UseCaseGenerator.staticSearchUseCaseSummaryCells(siteRequest_, UseCaseGenerator.staticSetUseCaseSummaryCells(siteRequest_, o)).toString();
	}

	///////////////////////
	// useCaseSummaryNum //
	///////////////////////


	/**	 The entity useCaseSummaryNum
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer useCaseSummaryNum;

	/**	<br> The entity useCaseSummaryNum
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:useCaseSummaryNum">Find the entity useCaseSummaryNum in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _useCaseSummaryNum(Wrap<Integer> c);

	public Integer getUseCaseSummaryNum() {
		return useCaseSummaryNum;
	}

	public void setUseCaseSummaryNum(Integer useCaseSummaryNum) {
		this.useCaseSummaryNum = useCaseSummaryNum;
	}
	@JsonIgnore
	public void setUseCaseSummaryNum(String o) {
		this.useCaseSummaryNum = UseCaseGenerator.staticSetUseCaseSummaryNum(siteRequest_, o);
	}
	public static Integer staticSetUseCaseSummaryNum(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected UseCaseGenerator useCaseSummaryNumInit() {
		Wrap<Integer> useCaseSummaryNumWrap = new Wrap<Integer>().var("useCaseSummaryNum");
		if(useCaseSummaryNum == null) {
			_useCaseSummaryNum(useCaseSummaryNumWrap);
			Optional.ofNullable(useCaseSummaryNumWrap.getO()).ifPresent(o -> {
				setUseCaseSummaryNum(o);
			});
		}
		return (UseCaseGenerator)this;
	}

	public static Integer staticSearchUseCaseSummaryNum(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrUseCaseSummaryNum(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqUseCaseSummaryNum(ComputateSiteRequest siteRequest_, String o) {
		return UseCaseGenerator.staticSearchUseCaseSummaryNum(siteRequest_, UseCaseGenerator.staticSetUseCaseSummaryNum(siteRequest_, o)).toString();
	}

	////////////////////////
	// useCaseSummaryFile //
	////////////////////////


	/**	 The entity useCaseSummaryFile
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File useCaseSummaryFile;

	/**	<br> The entity useCaseSummaryFile
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:useCaseSummaryFile">Find the entity useCaseSummaryFile in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _useCaseSummaryFile(Wrap<File> c);

	public File getUseCaseSummaryFile() {
		return useCaseSummaryFile;
	}

	public void setUseCaseSummaryFile(File useCaseSummaryFile) {
		this.useCaseSummaryFile = useCaseSummaryFile;
	}
	public static File staticSetUseCaseSummaryFile(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected UseCaseGenerator useCaseSummaryFileInit() {
		Wrap<File> useCaseSummaryFileWrap = new Wrap<File>().var("useCaseSummaryFile");
		if(useCaseSummaryFile == null) {
			_useCaseSummaryFile(useCaseSummaryFileWrap);
			Optional.ofNullable(useCaseSummaryFileWrap.getO()).ifPresent(o -> {
				setUseCaseSummaryFile(o);
			});
		}
		return (UseCaseGenerator)this;
	}

	/////////////////////
	// wUseCaseSummary //
	/////////////////////


	/**	 The entity wUseCaseSummary
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected AllWriter wUseCaseSummary;

	/**	<br> The entity wUseCaseSummary
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.UseCaseGenerator&fq=entiteVar_enUS_indexed_string:wUseCaseSummary">Find the entity wUseCaseSummary in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _wUseCaseSummary(Wrap<AllWriter> c);

	public AllWriter getWUseCaseSummary() {
		return wUseCaseSummary;
	}

	public void setWUseCaseSummary(AllWriter wUseCaseSummary) {
		this.wUseCaseSummary = wUseCaseSummary;
	}
	public static AllWriter staticSetWUseCaseSummary(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected UseCaseGenerator wUseCaseSummaryInit() {
		Wrap<AllWriter> wUseCaseSummaryWrap = new Wrap<AllWriter>().var("wUseCaseSummary");
		if(wUseCaseSummary == null) {
			_wUseCaseSummary(wUseCaseSummaryWrap);
			Optional.ofNullable(wUseCaseSummaryWrap.getO()).ifPresent(o -> {
				setWUseCaseSummary(o);
			});
		}
		if(wUseCaseSummary != null)
			wUseCaseSummary.initDeepForClass(siteRequest_);
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
				useCasePathInit();
				useCaseSummaryInit();
				useCaseSummaryCellsInit();
				useCaseSummaryNumInit();
				useCaseSummaryFileInit();
				wUseCaseSummaryInit();
	}

	@Override public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepUseCaseGenerator(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestUseCaseGenerator(ComputateSiteRequest siteRequest_) {
			super.siteRequestFiwareGenerator(siteRequest_);
		if(wUseCaseSummary != null)
			wUseCaseSummary.setSiteRequest_(siteRequest_);
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
			case "useCasePath":
				return oUseCaseGenerator.useCasePath;
			case "useCaseSummary":
				return oUseCaseGenerator.useCaseSummary;
			case "useCaseSummaryCells":
				return oUseCaseGenerator.useCaseSummaryCells;
			case "useCaseSummaryNum":
				return oUseCaseGenerator.useCaseSummaryNum;
			case "useCaseSummaryFile":
				return oUseCaseGenerator.useCaseSummaryFile;
			case "wUseCaseSummary":
				return oUseCaseGenerator.wUseCaseSummary;
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
		case "useCasePath":
			return UseCaseGenerator.staticSetUseCasePath(siteRequest_, o);
		case "useCaseSummary":
			return UseCaseGenerator.staticSetUseCaseSummary(siteRequest_, o);
		case "useCaseSummaryCells":
			return UseCaseGenerator.staticSetUseCaseSummaryCells(siteRequest_, o);
		case "useCaseSummaryNum":
			return UseCaseGenerator.staticSetUseCaseSummaryNum(siteRequest_, o);
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
		case "useCasePath":
			return UseCaseGenerator.staticSearchUseCasePath(siteRequest_, (String)o);
		case "useCaseSummary":
			return UseCaseGenerator.staticSearchUseCaseSummary(siteRequest_, (JsonObject)o);
		case "useCaseSummaryCells":
			return UseCaseGenerator.staticSearchUseCaseSummaryCells(siteRequest_, (JsonArray)o);
		case "useCaseSummaryNum":
			return UseCaseGenerator.staticSearchUseCaseSummaryNum(siteRequest_, (Integer)o);
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
		case "useCasePath":
			return UseCaseGenerator.staticSearchStrUseCasePath(siteRequest_, (String)o);
		case "useCaseSummary":
			return UseCaseGenerator.staticSearchStrUseCaseSummary(siteRequest_, (String)o);
		case "useCaseSummaryCells":
			return UseCaseGenerator.staticSearchStrUseCaseSummaryCells(siteRequest_, (String)o);
		case "useCaseSummaryNum":
			return UseCaseGenerator.staticSearchStrUseCaseSummaryNum(siteRequest_, (Integer)o);
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
		case "useCasePath":
			return UseCaseGenerator.staticSearchFqUseCasePath(siteRequest_, o);
		case "useCaseSummary":
			return UseCaseGenerator.staticSearchFqUseCaseSummary(siteRequest_, o);
		case "useCaseSummaryCells":
			return UseCaseGenerator.staticSearchFqUseCaseSummaryCells(siteRequest_, o);
		case "useCaseSummaryNum":
			return UseCaseGenerator.staticSearchFqUseCaseSummaryNum(siteRequest_, o);
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
	public static final String VAR_useCasePath = "useCasePath";
	public static final String VAR_useCaseSummary = "useCaseSummary";
	public static final String VAR_useCaseSummaryCells = "useCaseSummaryCells";
	public static final String VAR_useCaseSummaryNum = "useCaseSummaryNum";
	public static final String VAR_useCaseSummaryFile = "useCaseSummaryFile";
	public static final String VAR_wUseCaseSummary = "wUseCaseSummary";

	public static final String DISPLAY_NAME_useCasePath = "";
	public static final String DISPLAY_NAME_useCaseSummary = "";
	public static final String DISPLAY_NAME_useCaseSummaryCells = "";
	public static final String DISPLAY_NAME_useCaseSummaryNum = "";
	public static final String DISPLAY_NAME_useCaseSummaryFile = "";
	public static final String DISPLAY_NAME_wUseCaseSummary = "";

	@Override
	public String idForClass() {
		return null;
	}

	@Override
	public String titleForClass() {
		return null;
	}

	@Override
	public String nameForClass() {
		return null;
	}

	@Override
	public String classNameAdjectiveSingularForClass() {
		return null;
	}

	@Override
	public String descriptionForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlEditPageForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlDisplayPageForClass() {
		return null;
	}

	@Override
	public String classStringFormatUrlUserPageForClass() {
		return null;
	}

	public static String displayNameForClass(String var) {
		return UseCaseGenerator.displayNameUseCaseGenerator(var);
	}
	public static String displayNameUseCaseGenerator(String var) {
		switch(var) {
		case VAR_useCasePath:
			return DISPLAY_NAME_useCasePath;
		case VAR_useCaseSummary:
			return DISPLAY_NAME_useCaseSummary;
		case VAR_useCaseSummaryCells:
			return DISPLAY_NAME_useCaseSummaryCells;
		case VAR_useCaseSummaryNum:
			return DISPLAY_NAME_useCaseSummaryNum;
		case VAR_useCaseSummaryFile:
			return DISPLAY_NAME_useCaseSummaryFile;
		case VAR_wUseCaseSummary:
			return DISPLAY_NAME_wUseCaseSummary;
		default:
			return FiwareGenerator.displayNameFiwareGenerator(var);
		}
	}

	public static String descriptionUseCaseGenerator(String var) {
		switch(var) {
			default:
				return FiwareGenerator.descriptionFiwareGenerator(var);
		}
	}

	public static String classSimpleNameUseCaseGenerator(String var) {
		switch(var) {
		case VAR_useCasePath:
			return "String";
		case VAR_useCaseSummary:
			return "JsonObject";
		case VAR_useCaseSummaryCells:
			return "JsonArray";
		case VAR_useCaseSummaryNum:
			return "Integer";
		case VAR_useCaseSummaryFile:
			return "File";
		case VAR_wUseCaseSummary:
			return "AllWriter";
			default:
				return FiwareGenerator.classSimpleNameFiwareGenerator(var);
		}
	}

	public static Integer htmColumnUseCaseGenerator(String var) {
		switch(var) {
			default:
				return FiwareGenerator.htmColumnFiwareGenerator(var);
		}
	}

	public static Integer htmRowUseCaseGenerator(String var) {
		switch(var) {
			default:
				return FiwareGenerator.htmRowFiwareGenerator(var);
		}
	}

	public static Integer htmCellUseCaseGenerator(String var) {
		switch(var) {
			default:
				return FiwareGenerator.htmCellFiwareGenerator(var);
		}
	}

	public static Integer lengthMinUseCaseGenerator(String var) {
		switch(var) {
			default:
				return FiwareGenerator.lengthMinFiwareGenerator(var);
		}
	}

	public static Integer lengthMaxUseCaseGenerator(String var) {
		switch(var) {
			default:
				return FiwareGenerator.lengthMaxFiwareGenerator(var);
		}
	}

	public static Integer maxUseCaseGenerator(String var) {
		switch(var) {
			default:
				return FiwareGenerator.maxFiwareGenerator(var);
		}
	}

	public static Integer minUseCaseGenerator(String var) {
		switch(var) {
			default:
				return FiwareGenerator.minFiwareGenerator(var);
		}
	}
}
