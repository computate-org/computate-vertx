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

import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateVertxConfigKeys;
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
import org.computate.vertx.openapi.Swagger2Generator;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.OpenApi3Generator">Find the class OpenApi3Generator in Solr. </a>
 * <br><br>Delete the class OpenApi3Generator in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.OpenApi3Generator&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the package org.computate.vertx.openapi in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.openapi&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the project computate-vertx in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>
 **/
public abstract class OpenApi3GeneratorGen<DEV> extends Swagger2Generator {
	protected static final Logger LOG = LoggerFactory.getLogger(OpenApi3Generator.class);

	//////////////
	// initDeep //
	//////////////

	public OpenApi3Generator initDeepOpenApi3Generator(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepOpenApi3Generator();
		return (OpenApi3Generator)this;
	}

	public void initDeepOpenApi3Generator() {
		initOpenApi3Generator();
		super.initDeepSwagger2Generator(siteRequest_);
	}

	public void initOpenApi3Generator() {
	}

	@Override public void initDeepForClass(ComputateVertxSiteRequest siteRequest_) {
		initDeepOpenApi3Generator(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestOpenApi3Generator(ComputateVertxSiteRequest siteRequest_) {
			super.siteRequestSwagger2Generator(siteRequest_);
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
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

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetOpenApi3Generator(entityVar,  siteRequest_, o);
	}
	public static Object staticSetOpenApi3Generator(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
			default:
				return Swagger2Generator.staticSetSwagger2Generator(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchOpenApi3Generator(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchOpenApi3Generator(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return Swagger2Generator.staticSearchSwagger2Generator(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchStrOpenApi3Generator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrOpenApi3Generator(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return Swagger2Generator.staticSearchStrSwagger2Generator(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSearchFqOpenApi3Generator(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqOpenApi3Generator(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
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
