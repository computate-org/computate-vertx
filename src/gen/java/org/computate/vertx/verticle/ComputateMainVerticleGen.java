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
package org.computate.vertx.verticle;

import org.computate.vertx.request.ComputateSiteRequest;
import io.vertx.core.AbstractVerticle;
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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ComputateMainVerticle objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ComputateMainVerticleGen into the class ComputateMainVerticle. 
 * </li>
 * <h3>About the ComputateMainVerticle class and it's generated class ComputateMainVerticleGen&lt;AbstractVerticle&gt;: </h3>extends ComputateMainVerticleGen
 * <p>
 * This Java class extends a generated Java class ComputateMainVerticleGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.verticle.ComputateMainVerticle">Find the class ComputateMainVerticle in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ComputateMainVerticleGen<AbstractVerticle>
 * <p>This <code>class ComputateMainVerticle extends ComputateMainVerticleGen&lt;AbstractVerticle&gt;</code>, which means it extends a newly generated ComputateMainVerticleGen. 
 * The generated <code>class ComputateMainVerticleGen extends AbstractVerticle</code> which means that ComputateMainVerticle extends ComputateMainVerticleGen which extends AbstractVerticle. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the ComputateMainVerticle class will inherit the helpful inherited class comments from the super class ComputateMainVerticleGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class ComputateMainVerticle in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.verticle.ComputateMainVerticle&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.verticle in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.verticle&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class ComputateMainVerticleGen<DEV> extends AbstractVerticle {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateMainVerticle.class);

	//////////////
	// initDeep //
	//////////////

	public ComputateMainVerticle initDeepComputateMainVerticle(ComputateSiteRequest siteRequest_) {
		initDeepComputateMainVerticle();
		return (ComputateMainVerticle)this;
	}

	public void initDeepComputateMainVerticle() {
		initComputateMainVerticle();
	}

	public void initComputateMainVerticle() {
	}

	public void initDeepForClass(ComputateSiteRequest siteRequest_) {
		initDeepComputateMainVerticle(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateMainVerticle(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainComputateMainVerticle(String var) {
		ComputateMainVerticle oComputateMainVerticle = (ComputateMainVerticle)this;
		switch(var) {
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
				o = relateComputateMainVerticle(v, val);
		}
		return o != null;
	}
	public Object relateComputateMainVerticle(String var, Object val) {
		ComputateMainVerticle oComputateMainVerticle = (ComputateMainVerticle)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetComputateMainVerticle(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateMainVerticle(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchComputateMainVerticle(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchComputateMainVerticle(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrComputateMainVerticle(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrComputateMainVerticle(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqComputateMainVerticle(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqComputateMainVerticle(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
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

	public static final String CLASS_SIMPLE_NAME = "ComputateMainVerticle";


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
		return ComputateMainVerticle.displayNameComputateMainVerticle(var);
	}
	public static String displayNameComputateMainVerticle(String var) {
		switch(var) {
		default:
			return null;
		}
	}

	public static String descriptionComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static String classSimpleNameComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmColumnComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmRowComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmCellComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMinComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMaxComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer maxComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer minComputateMainVerticle(String var) {
		switch(var) {
			default:
				return null;
		}
	}
}
