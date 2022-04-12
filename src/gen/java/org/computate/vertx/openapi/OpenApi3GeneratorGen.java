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

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import org.computate.vertx.openapi.Swagger2Generator;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import java.math.RoundingMode;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.OpenApi3Generator&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
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
