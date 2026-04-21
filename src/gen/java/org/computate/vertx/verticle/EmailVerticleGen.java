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
import com.fasterxml.jackson.databind.JsonDeserializer;
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
 * <li><p>
 *   You can add a class comment <kbd><b>Api: true</b></kbd> if you wish to GET, POST, PATCH or PUT these  objects in a RESTful API. 
 * </p>
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class EmailVerticleGen into the class EmailVerticle. 
 * </li>
 * <h3>About the EmailVerticle class and it's generated class EmailVerticleGen&lt;AbstractVerticle&gt;: </h3>extends EmailVerticleGen
 * <p>
 * This Java class extends a generated Java class EmailVerticleGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.verticle.EmailVerticle">Find the class EmailVerticle in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends EmailVerticleGen<AbstractVerticle>
 * <p>This <code>class EmailVerticle extends EmailVerticleGen&lt;AbstractVerticle&gt;</code>, which means it extends a newly generated EmailVerticleGen. 
 * The generated <code>class EmailVerticleGen extends AbstractVerticle</code> which means that EmailVerticle extends EmailVerticleGen which extends AbstractVerticle. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>
 *   Api: true
 * </h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the EmailVerticle class will inherit the helpful inherited class comments from the super class EmailVerticleGen. 
 * </p>
 * <h2>
 *   Rows: 10
 * </h2>
 * <p>This class contains a comment <kbd><b>Rows: 10</b></kbd>, which means the  API will return a default of 10 results instead of 10 by default. 
 * Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <p>
 *   You can add a class comment <kbd><b>Rows: 100</b></kbd> if you wish for the  API to return more or less than 10 results by default. 
 *   In this case, the API will return 100 results from the API instead of 10 by default. 
 *   Each API has built in pagination of the search results to ensure a user can query all the data a page at a time without running the application out of memory. 
 * </p>
 * <h2>
 *   Order: 1
 * </h2>
 * <p>
 *   This class contains a comment <kbd><b>Order: 1</b></kbd>, 
 *   which means this class will be sorted by the given number 1 
 *   ascending when code that relates to multiple classes at the same time is generated. 
 * </p>
 * <p>
 *   You can add a class comment <kbd><b>Order: </b></kbd>, followed by an Integer to sort this class compared to other classes in the project. 
 *   There is code that is generated that queries several classes and writes code for each class in a sequence. 
 *   The <kbd><b>Order</b></kbd> comment allows you to define which order the class code is generated. 
 * </p>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class EmailVerticle in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.verticle.EmailVerticle&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.verticle in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.verticle&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * <pre>
 * curl -k 'https://solr.apps-crc.testing/solr/computate/update?commitWithin=1000&amp;overwrite=true&amp;wt=json' -X POST -H 'Content-type: text/xml' -u "admin:$(oc -n solr get secret/solr-solrcloud-security-bootstrap -o jsonpath={.data.admin} | base64 -d)" --data-raw '&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;'
 * </pre>
 * </p>
 * Generated: true
 **/
public abstract class EmailVerticleGen<DEV> extends AbstractVerticle {
  protected static final Logger LOG = LoggerFactory.getLogger(EmailVerticle.class);

  //////////////
  // initDeep //
  //////////////

  public EmailVerticle initDeepEmailVerticle(ComputateSiteRequest siteRequest_) {
    initDeepEmailVerticle();
    return (EmailVerticle)this;
  }

  public void initDeepEmailVerticle() {
    initEmailVerticle();
  }

  public void initEmailVerticle() {
  }

  public void initDeepForClass(ComputateSiteRequest siteRequest_) {
    initDeepEmailVerticle(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainEmailVerticle(v);
      else if(o instanceof Map) {
        Map<?, ?> map = (Map<?, ?>)o;
        o = map.get(v);
      }
    }
    return o;
  }
  public Object obtainEmailVerticle(String var) {
    EmailVerticle oEmailVerticle = (EmailVerticle)this;
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
        o = relateEmailVerticle(v, val);
    }
    return o != null;
  }
  public Object relateEmailVerticle(String var, Object val) {
    EmailVerticle oEmailVerticle = (EmailVerticle)this;
    switch(var) {
      default:
        return null;
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String v, EmailVerticle o) {
    return staticSetEmailVerticle(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetEmailVerticle(String entityVar, ComputateSiteRequest siteRequest_, String v, EmailVerticle o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////////
  // staticSearch //
  //////////////////

  public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    return staticSearchEmailVerticle(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchEmailVerticle(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    return staticSearchStrEmailVerticle(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrEmailVerticle(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    switch(entityVar) {
      default:
        return null;
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
    return staticSearchFqEmailVerticle(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqEmailVerticle(String entityVar, ComputateSiteRequest siteRequest_, String o) {
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

  public static final String CLASS_SIMPLE_NAME = "EmailVerticle";
  public static final String CLASS_CANONICAL_NAME = "org.computate.vertx.verticle.EmailVerticle";
  public static final String CLASS_AUTH_RESOURCE = "";


  public static String displayNameForClass(String var) {
    return EmailVerticle.displayNameEmailVerticle(var);
  }
  public static String displayNameEmailVerticle(String var) {
    switch(var) {
    default:
      return null;
    }
  }
}
