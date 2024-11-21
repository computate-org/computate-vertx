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
import org.computate.vertx.openapi.BaseGenerator;
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
import org.computate.search.serialize.ComputateLocalTimeDeserializer;
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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ProjectGenerator objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ProjectGeneratorGen into the class ProjectGenerator. 
 * </li>
 * <h3>About the ProjectGenerator class and it's generated class ProjectGeneratorGen&lt;BaseGenerator&gt;: </h3>extends ProjectGeneratorGen
 * <p>
 * This Java class extends a generated Java class ProjectGeneratorGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator">Find the class ProjectGenerator in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ProjectGeneratorGen<BaseGenerator>
 * <p>This <code>class ProjectGenerator extends ProjectGeneratorGen&lt;BaseGenerator&gt;</code>, which means it extends a newly generated ProjectGeneratorGen. 
 * The generated <code>class ProjectGeneratorGen extends BaseGenerator</code> which means that ProjectGenerator extends ProjectGeneratorGen which extends BaseGenerator. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the ProjectGenerator class will inherit the helpful inherited class comments from the super class ProjectGeneratorGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class ProjectGenerator in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
public abstract class ProjectGeneratorGen<DEV> extends BaseGenerator {
	protected static final Logger LOG = LoggerFactory.getLogger(ProjectGenerator.class);

	////////////////////
	// siteStaticPath //
	////////////////////


	/**	 The entity siteStaticPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String siteStaticPath;

	/**	<br> The entity siteStaticPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&fq=entiteVar_enUS_indexed_string:siteStaticPath">Find the entity siteStaticPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteStaticPath(Wrap<String> c);

	public String getSiteStaticPath() {
		return siteStaticPath;
	}
	public void setSiteStaticPath(String o) {
		this.siteStaticPath = ProjectGenerator.staticSetSiteStaticPath(siteRequest_, o);
	}
	public static String staticSetSiteStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ProjectGenerator siteStaticPathInit() {
		Wrap<String> siteStaticPathWrap = new Wrap<String>().var("siteStaticPath");
		if(siteStaticPath == null) {
			_siteStaticPath(siteStaticPathWrap);
			Optional.ofNullable(siteStaticPathWrap.getO()).ifPresent(o -> {
				setSiteStaticPath(o);
			});
		}
		return (ProjectGenerator)this;
	}

	public static String staticSearchSiteStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSiteStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSiteStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return ProjectGenerator.staticSearchSiteStaticPath(siteRequest_, ProjectGenerator.staticSetSiteStaticPath(siteRequest_, o)).toString();
	}

	/////////////////////
	// siteStaticJsDir //
	/////////////////////


	/**	 The entity siteStaticJsDir
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File siteStaticJsDir;

	/**	<br> The entity siteStaticJsDir
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&fq=entiteVar_enUS_indexed_string:siteStaticJsDir">Find the entity siteStaticJsDir in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteStaticJsDir(Wrap<File> c);

	public File getSiteStaticJsDir() {
		return siteStaticJsDir;
	}

	public void setSiteStaticJsDir(File siteStaticJsDir) {
		this.siteStaticJsDir = siteStaticJsDir;
	}
	public static File staticSetSiteStaticJsDir(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ProjectGenerator siteStaticJsDirInit() {
		Wrap<File> siteStaticJsDirWrap = new Wrap<File>().var("siteStaticJsDir");
		if(siteStaticJsDir == null) {
			_siteStaticJsDir(siteStaticJsDirWrap);
			Optional.ofNullable(siteStaticJsDirWrap.getO()).ifPresent(o -> {
				setSiteStaticJsDir(o);
			});
		}
		return (ProjectGenerator)this;
	}

	////////////////////////
	// platformStaticPath //
	////////////////////////


	/**	 The entity platformStaticPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String platformStaticPath;

	/**	<br> The entity platformStaticPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&fq=entiteVar_enUS_indexed_string:platformStaticPath">Find the entity platformStaticPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _platformStaticPath(Wrap<String> c);

	public String getPlatformStaticPath() {
		return platformStaticPath;
	}
	public void setPlatformStaticPath(String o) {
		this.platformStaticPath = ProjectGenerator.staticSetPlatformStaticPath(siteRequest_, o);
	}
	public static String staticSetPlatformStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ProjectGenerator platformStaticPathInit() {
		Wrap<String> platformStaticPathWrap = new Wrap<String>().var("platformStaticPath");
		if(platformStaticPath == null) {
			_platformStaticPath(platformStaticPathWrap);
			Optional.ofNullable(platformStaticPathWrap.getO()).ifPresent(o -> {
				setPlatformStaticPath(o);
			});
		}
		return (ProjectGenerator)this;
	}

	public static String staticSearchPlatformStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPlatformStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPlatformStaticPath(ComputateSiteRequest siteRequest_, String o) {
		return ProjectGenerator.staticSearchPlatformStaticPath(siteRequest_, ProjectGenerator.staticSetPlatformStaticPath(siteRequest_, o)).toString();
	}

	/////////////////////////
	// platformStaticJsDir //
	/////////////////////////


	/**	 The entity platformStaticJsDir
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File platformStaticJsDir;

	/**	<br> The entity platformStaticJsDir
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&fq=entiteVar_enUS_indexed_string:platformStaticJsDir">Find the entity platformStaticJsDir in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _platformStaticJsDir(Wrap<File> c);

	public File getPlatformStaticJsDir() {
		return platformStaticJsDir;
	}

	public void setPlatformStaticJsDir(File platformStaticJsDir) {
		this.platformStaticJsDir = platformStaticJsDir;
	}
	public static File staticSetPlatformStaticJsDir(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ProjectGenerator platformStaticJsDirInit() {
		Wrap<File> platformStaticJsDirWrap = new Wrap<File>().var("platformStaticJsDir");
		if(platformStaticJsDir == null) {
			_platformStaticJsDir(platformStaticJsDirWrap);
			Optional.ofNullable(platformStaticJsDirWrap.getO()).ifPresent(o -> {
				setPlatformStaticJsDir(o);
			});
		}
		return (ProjectGenerator)this;
	}

	///////////////////////
	// siteResourcesPath //
	///////////////////////


	/**	 The entity siteResourcesPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String siteResourcesPath;

	/**	<br> The entity siteResourcesPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&fq=entiteVar_enUS_indexed_string:siteResourcesPath">Find the entity siteResourcesPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteResourcesPath(Wrap<String> c);

	public String getSiteResourcesPath() {
		return siteResourcesPath;
	}
	public void setSiteResourcesPath(String o) {
		this.siteResourcesPath = ProjectGenerator.staticSetSiteResourcesPath(siteRequest_, o);
	}
	public static String staticSetSiteResourcesPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ProjectGenerator siteResourcesPathInit() {
		Wrap<String> siteResourcesPathWrap = new Wrap<String>().var("siteResourcesPath");
		if(siteResourcesPath == null) {
			_siteResourcesPath(siteResourcesPathWrap);
			Optional.ofNullable(siteResourcesPathWrap.getO()).ifPresent(o -> {
				setSiteResourcesPath(o);
			});
		}
		return (ProjectGenerator)this;
	}

	public static String staticSearchSiteResourcesPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSiteResourcesPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSiteResourcesPath(ComputateSiteRequest siteRequest_, String o) {
		return ProjectGenerator.staticSearchSiteResourcesPath(siteRequest_, ProjectGenerator.staticSetSiteResourcesPath(siteRequest_, o)).toString();
	}

	//////////////////////
	// siteTemplatesDir //
	//////////////////////


	/**	 The entity siteTemplatesDir
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File siteTemplatesDir;

	/**	<br> The entity siteTemplatesDir
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&fq=entiteVar_enUS_indexed_string:siteTemplatesDir">Find the entity siteTemplatesDir in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteTemplatesDir(Wrap<File> c);

	public File getSiteTemplatesDir() {
		return siteTemplatesDir;
	}

	public void setSiteTemplatesDir(File siteTemplatesDir) {
		this.siteTemplatesDir = siteTemplatesDir;
	}
	public static File staticSetSiteTemplatesDir(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ProjectGenerator siteTemplatesDirInit() {
		Wrap<File> siteTemplatesDirWrap = new Wrap<File>().var("siteTemplatesDir");
		if(siteTemplatesDir == null) {
			_siteTemplatesDir(siteTemplatesDirWrap);
			Optional.ofNullable(siteTemplatesDirWrap.getO()).ifPresent(o -> {
				setSiteTemplatesDir(o);
			});
		}
		return (ProjectGenerator)this;
	}

	///////////////////////////
	// platformResourcesPath //
	///////////////////////////


	/**	 The entity platformResourcesPath
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String platformResourcesPath;

	/**	<br> The entity platformResourcesPath
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&fq=entiteVar_enUS_indexed_string:platformResourcesPath">Find the entity platformResourcesPath in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _platformResourcesPath(Wrap<String> c);

	public String getPlatformResourcesPath() {
		return platformResourcesPath;
	}
	public void setPlatformResourcesPath(String o) {
		this.platformResourcesPath = ProjectGenerator.staticSetPlatformResourcesPath(siteRequest_, o);
	}
	public static String staticSetPlatformResourcesPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ProjectGenerator platformResourcesPathInit() {
		Wrap<String> platformResourcesPathWrap = new Wrap<String>().var("platformResourcesPath");
		if(platformResourcesPath == null) {
			_platformResourcesPath(platformResourcesPathWrap);
			Optional.ofNullable(platformResourcesPathWrap.getO()).ifPresent(o -> {
				setPlatformResourcesPath(o);
			});
		}
		return (ProjectGenerator)this;
	}

	public static String staticSearchPlatformResourcesPath(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPlatformResourcesPath(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPlatformResourcesPath(ComputateSiteRequest siteRequest_, String o) {
		return ProjectGenerator.staticSearchPlatformResourcesPath(siteRequest_, ProjectGenerator.staticSetPlatformResourcesPath(siteRequest_, o)).toString();
	}

	//////////////////////////
	// platformTemplatesDir //
	//////////////////////////


	/**	 The entity platformTemplatesDir
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected File platformTemplatesDir;

	/**	<br> The entity platformTemplatesDir
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.ProjectGenerator&fq=entiteVar_enUS_indexed_string:platformTemplatesDir">Find the entity platformTemplatesDir in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _platformTemplatesDir(Wrap<File> c);

	public File getPlatformTemplatesDir() {
		return platformTemplatesDir;
	}

	public void setPlatformTemplatesDir(File platformTemplatesDir) {
		this.platformTemplatesDir = platformTemplatesDir;
	}
	public static File staticSetPlatformTemplatesDir(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ProjectGenerator platformTemplatesDirInit() {
		Wrap<File> platformTemplatesDirWrap = new Wrap<File>().var("platformTemplatesDir");
		if(platformTemplatesDir == null) {
			_platformTemplatesDir(platformTemplatesDirWrap);
			Optional.ofNullable(platformTemplatesDirWrap.getO()).ifPresent(o -> {
				setPlatformTemplatesDir(o);
			});
		}
		return (ProjectGenerator)this;
	}
	public static final String writeProjectSuccess1 = "Copy platform static files succeeded. ";
	public static final String writeProjectSuccess = writeProjectSuccess1;
	public static final String writeProjectFail1 = "Copy platform static files failed. ";
	public static final String writeProjectFail = writeProjectFail1;

	public static final String copyPlatformStaticFilesSuccess1 = "Copy platform static files from %s to %s succeeded. ";
	public static final String copyPlatformStaticFilesSuccess = copyPlatformStaticFilesSuccess1;
	public static final String copyPlatformStaticFilesFail1 = "Copy platform static files from %s to %s failed. ";
	public static final String copyPlatformStaticFilesFail = copyPlatformStaticFilesFail1;

	public static final String copyPlatformResourceFilesSuccess1 = "Copy platform resource files from %s to %s succeeded. ";
	public static final String copyPlatformResourceFilesSuccess = copyPlatformResourceFilesSuccess1;
	public static final String copyPlatformResourceFilesFail1 = "Copy platform resource files from %s to %s failed. ";
	public static final String copyPlatformResourceFilesFail = copyPlatformResourceFilesFail1;

	public static final String copyRecursiveSuccess1 = "Copy files recursively succeeded. ";
	public static final String copyRecursiveSuccess = copyRecursiveSuccess1;
	public static final String copyRecursiveFail1 = "Copy files recursively failed. ";
	public static final String copyRecursiveFail = copyRecursiveFail1;


	//////////////
	// initDeep //
	//////////////

	public ProjectGenerator initDeepProjectGenerator(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepProjectGenerator();
		return (ProjectGenerator)this;
	}

	public void initDeepProjectGenerator() {
		super.initDeepBaseGenerator(siteRequest_);
		initProjectGenerator();
	}

	public void initProjectGenerator() {
				siteStaticPathInit();
				siteStaticJsDirInit();
				platformStaticPathInit();
				platformStaticJsDirInit();
				siteResourcesPathInit();
				siteTemplatesDirInit();
				platformResourcesPathInit();
				platformTemplatesDirInit();
	}

	@Override public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepProjectGenerator(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestProjectGenerator(ComputateSiteRequest siteRequest_) {
			super.siteRequestBaseGenerator(siteRequest_);
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestProjectGenerator(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainProjectGenerator(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainProjectGenerator(String var) {
		ProjectGenerator oProjectGenerator = (ProjectGenerator)this;
		switch(var) {
			case "siteStaticPath":
				return oProjectGenerator.siteStaticPath;
			case "siteStaticJsDir":
				return oProjectGenerator.siteStaticJsDir;
			case "platformStaticPath":
				return oProjectGenerator.platformStaticPath;
			case "platformStaticJsDir":
				return oProjectGenerator.platformStaticJsDir;
			case "siteResourcesPath":
				return oProjectGenerator.siteResourcesPath;
			case "siteTemplatesDir":
				return oProjectGenerator.siteTemplatesDir;
			case "platformResourcesPath":
				return oProjectGenerator.platformResourcesPath;
			case "platformTemplatesDir":
				return oProjectGenerator.platformTemplatesDir;
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
				o = relateProjectGenerator(v, val);
		}
		return o != null;
	}
	public Object relateProjectGenerator(String var, Object val) {
		ProjectGenerator oProjectGenerator = (ProjectGenerator)this;
		switch(var) {
			default:
				return super.relateBaseGenerator(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetProjectGenerator(entityVar,  siteRequest_, o);
	}
	public static Object staticSetProjectGenerator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "siteStaticPath":
			return ProjectGenerator.staticSetSiteStaticPath(siteRequest_, o);
		case "platformStaticPath":
			return ProjectGenerator.staticSetPlatformStaticPath(siteRequest_, o);
		case "siteResourcesPath":
			return ProjectGenerator.staticSetSiteResourcesPath(siteRequest_, o);
		case "platformResourcesPath":
			return ProjectGenerator.staticSetPlatformResourcesPath(siteRequest_, o);
			default:
				return BaseGenerator.staticSetBaseGenerator(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchProjectGenerator(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchProjectGenerator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "siteStaticPath":
			return ProjectGenerator.staticSearchSiteStaticPath(siteRequest_, (String)o);
		case "platformStaticPath":
			return ProjectGenerator.staticSearchPlatformStaticPath(siteRequest_, (String)o);
		case "siteResourcesPath":
			return ProjectGenerator.staticSearchSiteResourcesPath(siteRequest_, (String)o);
		case "platformResourcesPath":
			return ProjectGenerator.staticSearchPlatformResourcesPath(siteRequest_, (String)o);
			default:
				return BaseGenerator.staticSearchBaseGenerator(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrProjectGenerator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrProjectGenerator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "siteStaticPath":
			return ProjectGenerator.staticSearchStrSiteStaticPath(siteRequest_, (String)o);
		case "platformStaticPath":
			return ProjectGenerator.staticSearchStrPlatformStaticPath(siteRequest_, (String)o);
		case "siteResourcesPath":
			return ProjectGenerator.staticSearchStrSiteResourcesPath(siteRequest_, (String)o);
		case "platformResourcesPath":
			return ProjectGenerator.staticSearchStrPlatformResourcesPath(siteRequest_, (String)o);
			default:
				return BaseGenerator.staticSearchStrBaseGenerator(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqProjectGenerator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqProjectGenerator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "siteStaticPath":
			return ProjectGenerator.staticSearchFqSiteStaticPath(siteRequest_, o);
		case "platformStaticPath":
			return ProjectGenerator.staticSearchFqPlatformStaticPath(siteRequest_, o);
		case "siteResourcesPath":
			return ProjectGenerator.staticSearchFqSiteResourcesPath(siteRequest_, o);
		case "platformResourcesPath":
			return ProjectGenerator.staticSearchFqPlatformResourcesPath(siteRequest_, o);
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

	public static final String[] ProjectGeneratorVals = new String[] { writeProjectSuccess1, writeProjectFail1, copyPlatformStaticFilesSuccess1, copyPlatformStaticFilesFail1, copyPlatformResourceFilesSuccess1, copyPlatformResourceFilesFail1, copyRecursiveSuccess1, copyRecursiveFail1 };

	public static final String CLASS_SIMPLE_NAME = "ProjectGenerator";
	public static final String VAR_siteStaticPath = "siteStaticPath";
	public static final String VAR_siteStaticJsDir = "siteStaticJsDir";
	public static final String VAR_platformStaticPath = "platformStaticPath";
	public static final String VAR_platformStaticJsDir = "platformStaticJsDir";
	public static final String VAR_siteResourcesPath = "siteResourcesPath";
	public static final String VAR_siteTemplatesDir = "siteTemplatesDir";
	public static final String VAR_platformResourcesPath = "platformResourcesPath";
	public static final String VAR_platformTemplatesDir = "platformTemplatesDir";

	public static final String DISPLAY_NAME_siteStaticPath = "";
	public static final String DISPLAY_NAME_siteStaticJsDir = "";
	public static final String DISPLAY_NAME_platformStaticPath = "";
	public static final String DISPLAY_NAME_platformStaticJsDir = "";
	public static final String DISPLAY_NAME_siteResourcesPath = "";
	public static final String DISPLAY_NAME_siteTemplatesDir = "";
	public static final String DISPLAY_NAME_platformResourcesPath = "";
	public static final String DISPLAY_NAME_platformTemplatesDir = "";

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

	public static String displayNameForClass(String var) {
		return ProjectGenerator.displayNameProjectGenerator(var);
	}
	public static String displayNameProjectGenerator(String var) {
		switch(var) {
		case VAR_siteStaticPath:
			return DISPLAY_NAME_siteStaticPath;
		case VAR_siteStaticJsDir:
			return DISPLAY_NAME_siteStaticJsDir;
		case VAR_platformStaticPath:
			return DISPLAY_NAME_platformStaticPath;
		case VAR_platformStaticJsDir:
			return DISPLAY_NAME_platformStaticJsDir;
		case VAR_siteResourcesPath:
			return DISPLAY_NAME_siteResourcesPath;
		case VAR_siteTemplatesDir:
			return DISPLAY_NAME_siteTemplatesDir;
		case VAR_platformResourcesPath:
			return DISPLAY_NAME_platformResourcesPath;
		case VAR_platformTemplatesDir:
			return DISPLAY_NAME_platformTemplatesDir;
		default:
			return BaseGenerator.displayNameBaseGenerator(var);
		}
	}

	public static String descriptionProjectGenerator(String var) {
		switch(var) {
			default:
				return BaseGenerator.descriptionBaseGenerator(var);
		}
	}

	public static String classSimpleNameProjectGenerator(String var) {
		switch(var) {
		case VAR_siteStaticPath:
			return "String";
		case VAR_siteStaticJsDir:
			return "File";
		case VAR_platformStaticPath:
			return "String";
		case VAR_platformStaticJsDir:
			return "File";
		case VAR_siteResourcesPath:
			return "String";
		case VAR_siteTemplatesDir:
			return "File";
		case VAR_platformResourcesPath:
			return "String";
		case VAR_platformTemplatesDir:
			return "File";
			default:
				return BaseGenerator.classSimpleNameBaseGenerator(var);
		}
	}

	public static Integer htmColumnProjectGenerator(String var) {
		switch(var) {
			default:
				return BaseGenerator.htmColumnBaseGenerator(var);
		}
	}

	public static Integer htmRowProjectGenerator(String var) {
		switch(var) {
			default:
				return BaseGenerator.htmRowBaseGenerator(var);
		}
	}

	public static Integer htmCellProjectGenerator(String var) {
		switch(var) {
			default:
				return BaseGenerator.htmCellBaseGenerator(var);
		}
	}

	public static Integer lengthMinProjectGenerator(String var) {
		switch(var) {
			default:
				return BaseGenerator.lengthMinBaseGenerator(var);
		}
	}

	public static Integer lengthMaxProjectGenerator(String var) {
		switch(var) {
			default:
				return BaseGenerator.lengthMaxBaseGenerator(var);
		}
	}

	public static Integer maxProjectGenerator(String var) {
		switch(var) {
			default:
				return BaseGenerator.maxBaseGenerator(var);
		}
	}

	public static Integer minProjectGenerator(String var) {
		switch(var) {
			default:
				return BaseGenerator.minBaseGenerator(var);
		}
	}
}
