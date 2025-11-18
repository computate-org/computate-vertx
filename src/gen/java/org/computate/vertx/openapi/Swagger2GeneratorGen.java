/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
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
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these Swagger2Generator objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class Swagger2GeneratorGen into the class Swagger2Generator. 
 * </li>
 * <h3>About the Swagger2Generator class and it's generated class Swagger2GeneratorGen&lt;FiwareGenerator&gt;: </h3>extends Swagger2GeneratorGen
 * <p>
 * This Java class extends a generated Java class Swagger2GeneratorGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator">Find the class Swagger2Generator in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends Swagger2GeneratorGen<FiwareGenerator>
 * <p>This <code>class Swagger2Generator extends Swagger2GeneratorGen&lt;FiwareGenerator&gt;</code>, which means it extends a newly generated Swagger2GeneratorGen. 
 * The generated <code>class Swagger2GeneratorGen extends FiwareGenerator</code> which means that Swagger2Generator extends Swagger2GeneratorGen which extends FiwareGenerator. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the Swagger2Generator class will inherit the helpful inherited class comments from the super class Swagger2GeneratorGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class Swagger2Generator in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.openapi.Swagger2Generator&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
public abstract class Swagger2GeneratorGen<DEV> extends FiwareGenerator {
  protected static final Logger LOG = LoggerFactory.getLogger(Swagger2Generator.class);
  public static final String writeApiError1 = "An error occured while writing the API. ";
  public static final String writeApiError = writeApiError1;
  public static final String writeApiError21 = "An error occured while writing the API. ";
  public static final String writeApiError2 = writeApiError21;


  //////////////
  // initDeep //
  //////////////

  public Swagger2Generator initDeepSwagger2Generator(ComputateSiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    initDeepSwagger2Generator();
    return (Swagger2Generator)this;
  }

  public void initDeepSwagger2Generator() {
    super.initDeepFiwareGenerator(siteRequest_);
    initSwagger2Generator();
  }

  public void initSwagger2Generator() {
  }

  @Override public void initDeepForClass(ComputateSiteRequest siteRequest_) {
    initDeepSwagger2Generator(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestSwagger2Generator(ComputateSiteRequest siteRequest_) {
      super.siteRequestFiwareGenerator(siteRequest_);
  }

  public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
    siteRequestSwagger2Generator(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  @Override public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainSwagger2Generator(v);
      else if(o instanceof Map) {
        Map<?, ?> map = (Map<?, ?>)o;
        o = map.get(v);
      }
    }
    return o;
  }
  public Object obtainSwagger2Generator(String var) {
    Swagger2Generator oSwagger2Generator = (Swagger2Generator)this;
    switch(var) {
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
        o = relateSwagger2Generator(v, val);
    }
    return o != null;
  }
  public Object relateSwagger2Generator(String var, Object val) {
    Swagger2Generator oSwagger2Generator = (Swagger2Generator)this;
    switch(var) {
      default:
        return super.relateFiwareGenerator(var, val);
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String v, Swagger2Generator o) {
    return staticSetSwagger2Generator(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetSwagger2Generator(String entityVar, ComputateSiteRequest siteRequest_, String v, Swagger2Generator o) {
    switch(entityVar) {
      default:
        return FiwareGenerator.staticSetFiwareGenerator(entityVar,  siteRequest_, v, o);
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    return staticSearchSwagger2Generator(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchSwagger2Generator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return FiwareGenerator.staticSearchFiwareGenerator(entityVar,  siteRequest_, o);
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    return staticSearchStrSwagger2Generator(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrSwagger2Generator(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return FiwareGenerator.staticSearchStrFiwareGenerator(entityVar,  siteRequest_, o);
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
    return staticSearchFqSwagger2Generator(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqSwagger2Generator(String entityVar, ComputateSiteRequest siteRequest_, String o) {
    switch(entityVar) {
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

  public static final String[] Swagger2GeneratorVals = new String[] { writeApiError1, writeApiError21 };

  public static final String CLASS_SIMPLE_NAME = "Swagger2Generator";
  public static final String CLASS_CANONICAL_NAME = "org.computate.vertx.openapi.Swagger2Generator";
  public static final String CLASS_AUTH_RESOURCE = "";


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

  @Override
  public String classStringFormatUrlDownloadForClass() {
    return null;
  }

  public static String displayNameForClass(String var) {
    return Swagger2Generator.displayNameSwagger2Generator(var);
  }
  public static String displayNameSwagger2Generator(String var) {
    switch(var) {
    default:
      return FiwareGenerator.displayNameFiwareGenerator(var);
    }
  }

  public static String descriptionSwagger2Generator(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return FiwareGenerator.descriptionFiwareGenerator(var);
    }
  }

  public static String classSimpleNameSwagger2Generator(String var) {
    switch(var) {
      default:
        return FiwareGenerator.classSimpleNameFiwareGenerator(var);
    }
  }

  public static Integer htmColumnSwagger2Generator(String var) {
    switch(var) {
      default:
        return FiwareGenerator.htmColumnFiwareGenerator(var);
    }
  }

  public static Integer htmRowSwagger2Generator(String var) {
    switch(var) {
      default:
        return FiwareGenerator.htmRowFiwareGenerator(var);
    }
  }

  public static Integer htmCellSwagger2Generator(String var) {
    switch(var) {
      default:
        return FiwareGenerator.htmCellFiwareGenerator(var);
    }
  }

  public static Integer lengthMinSwagger2Generator(String var) {
    switch(var) {
      default:
        return FiwareGenerator.lengthMinFiwareGenerator(var);
    }
  }

  public static Integer lengthMaxSwagger2Generator(String var) {
    switch(var) {
      default:
        return FiwareGenerator.lengthMaxFiwareGenerator(var);
    }
  }

  public static Integer maxSwagger2Generator(String var) {
    switch(var) {
      default:
        return FiwareGenerator.maxFiwareGenerator(var);
    }
  }

  public static Integer minSwagger2Generator(String var) {
    switch(var) {
      default:
        return FiwareGenerator.minFiwareGenerator(var);
    }
  }
}
