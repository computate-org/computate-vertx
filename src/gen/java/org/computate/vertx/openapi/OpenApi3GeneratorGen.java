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
import org.computate.vertx.openapi.Swagger2Generator;
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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these OpenApi3Generator objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class OpenApi3GeneratorGen into the class OpenApi3Generator. 
 * </li>
 * <h3>About the OpenApi3Generator class and it's generated class OpenApi3GeneratorGen&lt;Swagger2Generator&gt;: </h3>extends OpenApi3GeneratorGen
 * <p>
 * This Java class extends a generated Java class OpenApi3GeneratorGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.OpenApi3Generator">Find the class OpenApi3Generator in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends OpenApi3GeneratorGen<Swagger2Generator>
 * <p>This <code>class OpenApi3Generator extends OpenApi3GeneratorGen&lt;Swagger2Generator&gt;</code>, which means it extends a newly generated OpenApi3GeneratorGen. 
 * The generated <code>class OpenApi3GeneratorGen extends Swagger2Generator</code> which means that OpenApi3Generator extends OpenApi3GeneratorGen which extends Swagger2Generator. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the OpenApi3Generator class will inherit the helpful inherited class comments from the super class OpenApi3GeneratorGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class OpenApi3Generator in Solr: 
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.OpenApi3Generator&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.openapi in Solr: 
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.openapi&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class OpenApi3GeneratorGen<DEV> extends Swagger2Generator {
	protected static final Logger LOG = LoggerFactory.getLogger(OpenApi3Generator.class);

	//////////////
	// initDeep //
	//////////////

	public OpenApi3Generator initDeepOpenApi3Generator(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepOpenApi3Generator();
		return (OpenApi3Generator)this;
	}

	public void initDeepOpenApi3Generator() {
		super.initDeepSwagger2Generator(siteRequest_);
		initOpenApi3Generator();
	}

	public void initOpenApi3Generator() {
	}

	@Override public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepOpenApi3Generator(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestOpenApi3Generator(ComputateSiteRequest siteRequest_) {
			super.siteRequestSwagger2Generator(siteRequest_);
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestOpenApi3Generator(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainOpenApi3Generator(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainOpenApi3Generator(String var) {
		OpenApi3Generator oOpenApi3Generator = (OpenApi3Generator)this;
		switch(var) {
			default:
				return super.obtainSwagger2Generator(var);
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
				o = relateOpenApi3Generator(v, val);
		}
		return o != null;
	}
	public Object relateOpenApi3Generator(String var, Object val) {
		OpenApi3Generator oOpenApi3Generator = (OpenApi3Generator)this;
		switch(var) {
			default:
				return super.relateSwagger2Generator(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetOpenApi3Generator(entityVar,  siteRequest_, o);
	}
	public static Object staticSetOpenApi3Generator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
			default:
				return Swagger2Generator.staticSetSwagger2Generator(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchOpenApi3Generator(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchOpenApi3Generator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return Swagger2Generator.staticSearchSwagger2Generator(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrOpenApi3Generator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrOpenApi3Generator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return Swagger2Generator.staticSearchStrSwagger2Generator(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqOpenApi3Generator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqOpenApi3Generator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
			default:
				return Swagger2Generator.staticSearchFqSwagger2Generator(entityVar,  siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "OpenApi3Generator";


	public static String displayNameForClass(String var) {
		return OpenApi3Generator.displayNameOpenApi3Generator(var);
	}
	public static String displayNameOpenApi3Generator(String var) {
		switch(var) {
		default:
			return Swagger2Generator.displayNameSwagger2Generator(var);
		}
	}
}
