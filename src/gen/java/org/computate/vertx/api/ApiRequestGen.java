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
package org.computate.vertx.api;

import org.computate.vertx.request.ComputateSiteRequest;
import java.lang.Object;
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
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.util.Locale;
import java.time.OffsetDateTime;
import java.lang.String;
import java.lang.Long;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ApiRequest objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ApiRequestGen into the class ApiRequest. 
 * </li>
 * <h3>About the ApiRequest class and it's generated class ApiRequestGen&lt;Object&gt;: </h3>extends ApiRequestGen
 * <p>
 * This Java class extends a generated Java class ApiRequestGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest">Find the class ApiRequest in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ApiRequestGen<Object>
 * <p>This <code>class ApiRequest extends ApiRequestGen&lt;Object&gt;</code>, which means it extends a newly generated ApiRequestGen. 
 * The generated <code>class ApiRequestGen extends Object</code> which means that ApiRequest extends ApiRequestGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the ApiRequest class will inherit the helpful inherited class comments from the super class ApiRequestGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class ApiRequest in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.api in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.api&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class ApiRequestGen<DEV> extends Object {
  protected static final Logger LOG = LoggerFactory.getLogger(ApiRequest.class);

	//////////////////
  // siteRequest_ //
	//////////////////


  /**
   *  The entity siteRequest_
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected ComputateSiteRequest siteRequest_;

  /**
   * <br> The entity siteRequest_
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _siteRequest_(Wrap<ComputateSiteRequest> c);

  public ComputateSiteRequest getSiteRequest_() {
    return siteRequest_;
  }

  public void setSiteRequest_(ComputateSiteRequest siteRequest_) {
    this.siteRequest_ = siteRequest_;
  }
  public static ComputateSiteRequest staticSetSiteRequest_(ComputateSiteRequest siteRequest_, String o) {
    return null;
  }
  protected ApiRequest siteRequest_Init() {
    Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
    if(siteRequest_ == null) {
      _siteRequest_(siteRequest_Wrap);
      Optional.ofNullable(siteRequest_Wrap.getO()).ifPresent(o -> {
        setSiteRequest_(o);
      });
    }
    return (ApiRequest)this;
  }

	/////////////
  // created //
	/////////////


  /**
   *  The entity created
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
  @JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
  @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
  @JsonInclude(Include.NON_NULL)
  protected ZonedDateTime created;

  /**
   * <br> The entity created
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:created">Find the entity created in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _created(Wrap<ZonedDateTime> c);

  public ZonedDateTime getCreated() {
    return created;
  }

  public void setCreated(ZonedDateTime created) {
    this.created = Optional.ofNullable(created).map(v -> v.truncatedTo(ChronoUnit.MILLIS)).orElse(null);
  }
  @JsonIgnore
  public void setCreated(Instant o) {
    this.created = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
  }
  /** Example: 2011-12-03T10:15:30+01:00 **/
  @JsonIgnore
  public void setCreated(String o) {
    ZoneId zoneId = Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"));
    this.created = ApiRequest.staticSetCreated(siteRequest_, o, zoneId);
  }
  @JsonIgnore
  public void setCreated(Date o) {
    this.created = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
  }
  public static ZonedDateTime staticSetCreated(ComputateSiteRequest siteRequest_, String o, ZoneId zoneId) {
    if(StringUtils.endsWith(o, "]"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
    else if(StringUtils.endsWith(o, "Z"))
      return o == null ? null : Instant.parse(o).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
    else if(StringUtils.contains(o, "T"))
      return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER).truncatedTo(ChronoUnit.MILLIS);
    else
      return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);
  }
  protected ApiRequest createdInit() {
    Wrap<ZonedDateTime> createdWrap = new Wrap<ZonedDateTime>().var("created");
    if(created == null) {
      _created(createdWrap);
      Optional.ofNullable(createdWrap.getO()).ifPresent(o -> {
        setCreated(o);
      });
    }
    return (ApiRequest)this;
  }

  public static String staticSearchCreated(ComputateSiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrCreated(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ApiRequest.staticSearchCreated(siteRequest_, ApiRequest.staticSetCreated(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqCreated(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ApiRequest.staticSearchCreated(siteRequest_, ApiRequest.staticSetCreated(siteRequest_, o, zoneId)).toString();
  }

	//////////
  // rows //
	//////////


  /**
   *  The entity rows
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long rows;

  /**
   * <br> The entity rows
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:rows">Find the entity rows in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _rows(Wrap<Long> c);

  public Long getRows() {
    return rows;
  }

  public void setRows(Long rows) {
    this.rows = rows;
  }
  @JsonIgnore
  public void setRows(String o) {
    this.rows = ApiRequest.staticSetRows(siteRequest_, o);
  }
  public static Long staticSetRows(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected ApiRequest rowsInit() {
    Wrap<Long> rowsWrap = new Wrap<Long>().var("rows");
    if(rows == null) {
      _rows(rowsWrap);
      Optional.ofNullable(rowsWrap.getO()).ifPresent(o -> {
        setRows(o);
      });
    }
    return (ApiRequest)this;
  }

  public static Long staticSearchRows(ComputateSiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrRows(ComputateSiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqRows(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchRows(siteRequest_, ApiRequest.staticSetRows(siteRequest_, o)).toString();
  }

	//////////////
  // numFound //
	//////////////


  /**
   *  The entity numFound
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long numFound;

  /**
   * <br> The entity numFound
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:numFound">Find the entity numFound in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _numFound(Wrap<Long> c);

  public Long getNumFound() {
    return numFound;
  }

  public void setNumFound(Long numFound) {
    this.numFound = numFound;
  }
  @JsonIgnore
  public void setNumFound(String o) {
    this.numFound = ApiRequest.staticSetNumFound(siteRequest_, o);
  }
  public static Long staticSetNumFound(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected ApiRequest numFoundInit() {
    Wrap<Long> numFoundWrap = new Wrap<Long>().var("numFound");
    if(numFound == null) {
      _numFound(numFoundWrap);
      Optional.ofNullable(numFoundWrap.getO()).ifPresent(o -> {
        setNumFound(o);
      });
    }
    return (ApiRequest)this;
  }

  public static Long staticSearchNumFound(ComputateSiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrNumFound(ComputateSiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNumFound(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchNumFound(siteRequest_, ApiRequest.staticSetNumFound(siteRequest_, o)).toString();
  }

	//////////////
  // numPATCH //
	//////////////


  /**
   *  The entity numPATCH
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long numPATCH;

  /**
   * <br> The entity numPATCH
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:numPATCH">Find the entity numPATCH in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _numPATCH(Wrap<Long> c);

  public Long getNumPATCH() {
    return numPATCH;
  }

  public void setNumPATCH(Long numPATCH) {
    this.numPATCH = numPATCH;
  }
  @JsonIgnore
  public void setNumPATCH(String o) {
    this.numPATCH = ApiRequest.staticSetNumPATCH(siteRequest_, o);
  }
  public static Long staticSetNumPATCH(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected ApiRequest numPATCHInit() {
    Wrap<Long> numPATCHWrap = new Wrap<Long>().var("numPATCH");
    if(numPATCH == null) {
      _numPATCH(numPATCHWrap);
      Optional.ofNullable(numPATCHWrap.getO()).ifPresent(o -> {
        setNumPATCH(o);
      });
    }
    return (ApiRequest)this;
  }

  public static Long staticSearchNumPATCH(ComputateSiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrNumPATCH(ComputateSiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqNumPATCH(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchNumPATCH(siteRequest_, ApiRequest.staticSetNumPATCH(siteRequest_, o)).toString();
  }

	//////////
  // uuid //
	//////////


  /**
   *  The entity uuid
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String uuid;

  /**
   * <br> The entity uuid
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:uuid">Find the entity uuid in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _uuid(Wrap<String> c);

  public String getUuid() {
    return uuid;
  }
  public void setUuid(String o) {
    this.uuid = ApiRequest.staticSetUuid(siteRequest_, o);
  }
  public static String staticSetUuid(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ApiRequest uuidInit() {
    Wrap<String> uuidWrap = new Wrap<String>().var("uuid");
    if(uuid == null) {
      _uuid(uuidWrap);
      Optional.ofNullable(uuidWrap.getO()).ifPresent(o -> {
        setUuid(o);
      });
    }
    return (ApiRequest)this;
  }

  public static String staticSearchUuid(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrUuid(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqUuid(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchUuid(siteRequest_, ApiRequest.staticSetUuid(siteRequest_, o)).toString();
  }

	////////
  // id //
	////////


  /**
   *  The entity id
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String id;

  /**
   * <br> The entity id
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _id(Wrap<String> c);

  public String getId() {
    return id;
  }
  public void setId(String o) {
    this.id = ApiRequest.staticSetId(siteRequest_, o);
  }
  public static String staticSetId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ApiRequest idInit() {
    Wrap<String> idWrap = new Wrap<String>().var("id");
    if(id == null) {
      _id(idWrap);
      Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
        setId(o);
      });
    }
    return (ApiRequest)this;
  }

  public static String staticSearchId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqId(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchId(siteRequest_, ApiRequest.staticSetId(siteRequest_, o)).toString();
  }

	////////////
  // solrId //
	////////////


  /**
   *  The entity solrId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long solrId;

  /**
   * <br> The entity solrId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:solrId">Find the entity solrId in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _solrId(Wrap<Long> c);

  public Long getSolrId() {
    return solrId;
  }

  public void setSolrId(Long solrId) {
    this.solrId = solrId;
  }
  @JsonIgnore
  public void setSolrId(String o) {
    this.solrId = ApiRequest.staticSetSolrId(siteRequest_, o);
  }
  public static Long staticSetSolrId(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected ApiRequest solrIdInit() {
    Wrap<Long> solrIdWrap = new Wrap<Long>().var("solrId");
    if(solrId == null) {
      _solrId(solrIdWrap);
      Optional.ofNullable(solrIdWrap.getO()).ifPresent(o -> {
        setSolrId(o);
      });
    }
    return (ApiRequest)this;
  }

  public static Long staticSearchSolrId(ComputateSiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrSolrId(ComputateSiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrId(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchSolrId(siteRequest_, ApiRequest.staticSetSolrId(siteRequest_, o)).toString();
  }

	//////////////
  // original //
	//////////////


  /**
   *  The entity original
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected Object original;

  /**
   * <br> The entity original
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:original">Find the entity original in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _original(Wrap<Object> c);

  public Object getOriginal() {
    return original;
  }

  public void setOriginal(Object original) {
    this.original = original;
  }
  public static Object staticSetOriginal(ComputateSiteRequest siteRequest_, String o) {
    return null;
  }
  protected ApiRequest originalInit() {
    Wrap<Object> originalWrap = new Wrap<Object>().var("original");
    if(original == null) {
      _original(originalWrap);
      Optional.ofNullable(originalWrap.getO()).ifPresent(o -> {
        setOriginal(o);
      });
    }
    return (ApiRequest)this;
  }

	/////////////
  // solrIds //
	/////////////


  /**
   *  The entity solrIds
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> solrIds = new ArrayList<String>();

  /**
   * <br> The entity solrIds
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:solrIds">Find the entity solrIds in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _solrIds(List<String> l);

  public List<String> getSolrIds() {
    return solrIds;
  }

  public void setSolrIds(List<String> solrIds) {
    this.solrIds = solrIds;
  }
  @JsonIgnore
  public void setSolrIds(String o) {
    String l = ApiRequest.staticSetSolrIds(siteRequest_, o);
    if(l != null)
      addSolrIds(l);
  }
  public static String staticSetSolrIds(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ApiRequest addSolrIds(String...objects) {
    for(String o : objects) {
      addSolrIds(o);
    }
    return (ApiRequest)this;
  }
  public ApiRequest addSolrIds(String o) {
    if(o != null)
      this.solrIds.add(o);
    return (ApiRequest)this;
  }
  @JsonIgnore
  public void setSolrIds(JsonArray objects) {
    solrIds.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addSolrIds(o);
    }
  }
  protected ApiRequest solrIdsInit() {
    _solrIds(solrIds);
    return (ApiRequest)this;
  }

  public static String staticSearchSolrIds(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSolrIds(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSolrIds(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchSolrIds(siteRequest_, ApiRequest.staticSetSolrIds(siteRequest_, o)).toString();
  }

	/////////
  // ids //
	/////////


  /**
   *  The entity ids
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> ids = new ArrayList<String>();

  /**
   * <br> The entity ids
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:ids">Find the entity ids in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _ids(List<String> l);

  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }
  @JsonIgnore
  public void setIds(String o) {
    String l = ApiRequest.staticSetIds(siteRequest_, o);
    if(l != null)
      addIds(l);
  }
  public static String staticSetIds(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ApiRequest addIds(String...objects) {
    for(String o : objects) {
      addIds(o);
    }
    return (ApiRequest)this;
  }
  public ApiRequest addIds(String o) {
    if(o != null)
      this.ids.add(o);
    return (ApiRequest)this;
  }
  @JsonIgnore
  public void setIds(JsonArray objects) {
    ids.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addIds(o);
    }
  }
  protected ApiRequest idsInit() {
    _ids(ids);
    return (ApiRequest)this;
  }

  public static String staticSearchIds(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrIds(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqIds(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchIds(siteRequest_, ApiRequest.staticSetIds(siteRequest_, o)).toString();
  }

	/////////////
  // classes //
	/////////////


  /**
   *  The entity classes
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classes = new ArrayList<String>();

  /**
   * <br> The entity classes
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:classes">Find the entity classes in Solr</a>
   * <br>
   * @param c is the entity already constructed. 
   **/
  protected abstract void _classes(List<String> c);

  public List<String> getClasses() {
    return classes;
  }

  public void setClasses(List<String> classes) {
    this.classes = classes;
  }
  @JsonIgnore
  public void setClasses(String o) {
    String l = ApiRequest.staticSetClasses(siteRequest_, o);
    if(l != null)
      addClasses(l);
  }
  public static String staticSetClasses(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ApiRequest addClasses(String...objects) {
    for(String o : objects) {
      addClasses(o);
    }
    return (ApiRequest)this;
  }
  public ApiRequest addClasses(String o) {
    if(o != null)
      this.classes.add(o);
    return (ApiRequest)this;
  }
  @JsonIgnore
  public void setClasses(JsonArray objects) {
    classes.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClasses(o);
    }
  }
  protected ApiRequest classesInit() {
    _classes(classes);
    return (ApiRequest)this;
  }

  public static String staticSearchClasses(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClasses(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClasses(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchClasses(siteRequest_, ApiRequest.staticSetClasses(siteRequest_, o)).toString();
  }

	//////////
  // vars //
	//////////


  /**
   *  The entity vars
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> vars = new ArrayList<String>();

  /**
   * <br> The entity vars
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:vars">Find the entity vars in Solr</a>
   * <br>
   * @param c is the entity already constructed. 
   **/
  protected abstract void _vars(List<String> c);

  public List<String> getVars() {
    return vars;
  }

  public void setVars(List<String> vars) {
    this.vars = vars;
  }
  @JsonIgnore
  public void setVars(String o) {
    String l = ApiRequest.staticSetVars(siteRequest_, o);
    if(l != null)
      addVars(l);
  }
  public static String staticSetVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ApiRequest addVars(String...objects) {
    for(String o : objects) {
      addVars(o);
    }
    return (ApiRequest)this;
  }
  public ApiRequest addVars(String o) {
    if(o != null)
      this.vars.add(o);
    return (ApiRequest)this;
  }
  @JsonIgnore
  public void setVars(JsonArray objects) {
    vars.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addVars(o);
    }
  }
  protected ApiRequest varsInit() {
    _vars(vars);
    return (ApiRequest)this;
  }

  public static String staticSearchVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrVars(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVars(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchVars(siteRequest_, ApiRequest.staticSetVars(siteRequest_, o)).toString();
  }

	///////////////////
  // timeRemaining //
	///////////////////


  /**
   *  The entity timeRemaining
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String timeRemaining;

  /**
   * <br> The entity timeRemaining
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.api.ApiRequest&fq=entiteVar_enUS_indexed_string:timeRemaining">Find the entity timeRemaining in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _timeRemaining(Wrap<String> w);

  public String getTimeRemaining() {
    return timeRemaining;
  }
  public void setTimeRemaining(String o) {
    this.timeRemaining = ApiRequest.staticSetTimeRemaining(siteRequest_, o);
  }
  public static String staticSetTimeRemaining(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ApiRequest timeRemainingInit() {
    Wrap<String> timeRemainingWrap = new Wrap<String>().var("timeRemaining");
    if(timeRemaining == null) {
      _timeRemaining(timeRemainingWrap);
      Optional.ofNullable(timeRemainingWrap.getO()).ifPresent(o -> {
        setTimeRemaining(o);
      });
    }
    return (ApiRequest)this;
  }

  public static String staticSearchTimeRemaining(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrTimeRemaining(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqTimeRemaining(ComputateSiteRequest siteRequest_, String o) {
    return ApiRequest.staticSearchTimeRemaining(siteRequest_, ApiRequest.staticSetTimeRemaining(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public ApiRequest initDeepApiRequest(ComputateSiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    initDeepApiRequest();
    return (ApiRequest)this;
  }

  public void initDeepApiRequest() {
    initApiRequest();
  }

  public void initApiRequest() {
        siteRequest_Init();
        createdInit();
        rowsInit();
        numFoundInit();
        numPATCHInit();
        uuidInit();
        idInit();
        solrIdInit();
        originalInit();
        solrIdsInit();
        idsInit();
        classesInit();
        varsInit();
        timeRemainingInit();
  }

  public void initDeepForClass(ComputateSiteRequest siteRequest_) {
    initDeepApiRequest(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestApiRequest(ComputateSiteRequest siteRequest_) {
  }

  public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
    siteRequestApiRequest(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainApiRequest(v);
      else if(o instanceof Map) {
        Map<?, ?> map = (Map<?, ?>)o;
        o = map.get(v);
      }
    }
    return o;
  }
  public Object obtainApiRequest(String var) {
    ApiRequest oApiRequest = (ApiRequest)this;
    switch(var) {
      case "siteRequest_":
        return oApiRequest.siteRequest_;
      case "created":
        return oApiRequest.created;
      case "rows":
        return oApiRequest.rows;
      case "numFound":
        return oApiRequest.numFound;
      case "numPATCH":
        return oApiRequest.numPATCH;
      case "uuid":
        return oApiRequest.uuid;
      case "id":
        return oApiRequest.id;
      case "solrId":
        return oApiRequest.solrId;
      case "original":
        return oApiRequest.original;
      case "solrIds":
        return oApiRequest.solrIds;
      case "ids":
        return oApiRequest.ids;
      case "classes":
        return oApiRequest.classes;
      case "vars":
        return oApiRequest.vars;
      case "timeRemaining":
        return oApiRequest.timeRemaining;
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
        o = relateApiRequest(v, val);
    }
    return o != null;
  }
  public Object relateApiRequest(String var, Object val) {
    ApiRequest oApiRequest = (ApiRequest)this;
    switch(var) {
      default:
        return null;
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String v, ApiRequest o) {
    return staticSetApiRequest(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetApiRequest(String entityVar, ComputateSiteRequest siteRequest_, String v, ApiRequest o) {
    switch(entityVar) {
    case "created":
    case "rows":
      return ApiRequest.staticSetRows(siteRequest_, v);
    case "numFound":
      return ApiRequest.staticSetNumFound(siteRequest_, v);
    case "numPATCH":
      return ApiRequest.staticSetNumPATCH(siteRequest_, v);
    case "uuid":
      return ApiRequest.staticSetUuid(siteRequest_, v);
    case "id":
      return ApiRequest.staticSetId(siteRequest_, v);
    case "solrId":
      return ApiRequest.staticSetSolrId(siteRequest_, v);
    case "solrIds":
      return ApiRequest.staticSetSolrIds(siteRequest_, v);
    case "ids":
      return ApiRequest.staticSetIds(siteRequest_, v);
    case "classes":
      return ApiRequest.staticSetClasses(siteRequest_, v);
    case "vars":
      return ApiRequest.staticSetVars(siteRequest_, v);
    case "timeRemaining":
      return ApiRequest.staticSetTimeRemaining(siteRequest_, v);
      default:
        return null;
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    return staticSearchApiRequest(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchApiRequest(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "created":
      return ApiRequest.staticSearchCreated(siteRequest_, (ZonedDateTime)o);
    case "rows":
      return ApiRequest.staticSearchRows(siteRequest_, (Long)o);
    case "numFound":
      return ApiRequest.staticSearchNumFound(siteRequest_, (Long)o);
    case "numPATCH":
      return ApiRequest.staticSearchNumPATCH(siteRequest_, (Long)o);
    case "uuid":
      return ApiRequest.staticSearchUuid(siteRequest_, (String)o);
    case "id":
      return ApiRequest.staticSearchId(siteRequest_, (String)o);
    case "solrId":
      return ApiRequest.staticSearchSolrId(siteRequest_, (Long)o);
    case "solrIds":
      return ApiRequest.staticSearchSolrIds(siteRequest_, (String)o);
    case "ids":
      return ApiRequest.staticSearchIds(siteRequest_, (String)o);
    case "classes":
      return ApiRequest.staticSearchClasses(siteRequest_, (String)o);
    case "vars":
      return ApiRequest.staticSearchVars(siteRequest_, (String)o);
    case "timeRemaining":
      return ApiRequest.staticSearchTimeRemaining(siteRequest_, (String)o);
      default:
        return null;
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    return staticSearchStrApiRequest(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrApiRequest(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "created":
      return ApiRequest.staticSearchStrCreated(siteRequest_, (String)o);
    case "rows":
      return ApiRequest.staticSearchStrRows(siteRequest_, (Long)o);
    case "numFound":
      return ApiRequest.staticSearchStrNumFound(siteRequest_, (Long)o);
    case "numPATCH":
      return ApiRequest.staticSearchStrNumPATCH(siteRequest_, (Long)o);
    case "uuid":
      return ApiRequest.staticSearchStrUuid(siteRequest_, (String)o);
    case "id":
      return ApiRequest.staticSearchStrId(siteRequest_, (String)o);
    case "solrId":
      return ApiRequest.staticSearchStrSolrId(siteRequest_, (Long)o);
    case "solrIds":
      return ApiRequest.staticSearchStrSolrIds(siteRequest_, (String)o);
    case "ids":
      return ApiRequest.staticSearchStrIds(siteRequest_, (String)o);
    case "classes":
      return ApiRequest.staticSearchStrClasses(siteRequest_, (String)o);
    case "vars":
      return ApiRequest.staticSearchStrVars(siteRequest_, (String)o);
    case "timeRemaining":
      return ApiRequest.staticSearchStrTimeRemaining(siteRequest_, (String)o);
      default:
        return null;
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
    return staticSearchFqApiRequest(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqApiRequest(String entityVar, ComputateSiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "created":
      return ApiRequest.staticSearchFqCreated(siteRequest_, o);
    case "rows":
      return ApiRequest.staticSearchFqRows(siteRequest_, o);
    case "numFound":
      return ApiRequest.staticSearchFqNumFound(siteRequest_, o);
    case "numPATCH":
      return ApiRequest.staticSearchFqNumPATCH(siteRequest_, o);
    case "uuid":
      return ApiRequest.staticSearchFqUuid(siteRequest_, o);
    case "id":
      return ApiRequest.staticSearchFqId(siteRequest_, o);
    case "solrId":
      return ApiRequest.staticSearchFqSolrId(siteRequest_, o);
    case "solrIds":
      return ApiRequest.staticSearchFqSolrIds(siteRequest_, o);
    case "ids":
      return ApiRequest.staticSearchFqIds(siteRequest_, o);
    case "classes":
      return ApiRequest.staticSearchFqClasses(siteRequest_, o);
    case "vars":
      return ApiRequest.staticSearchFqVars(siteRequest_, o);
    case "timeRemaining":
      return ApiRequest.staticSearchFqTimeRemaining(siteRequest_, o);
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

  public static final String CLASS_SIMPLE_NAME = "ApiRequest";
  public static final String CLASS_CANONICAL_NAME = "org.computate.vertx.api.ApiRequest";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_siteRequest_ = "siteRequest_";
  public static final String VAR_created = "created";
  public static final String VAR_rows = "rows";
  public static final String VAR_numFound = "numFound";
  public static final String VAR_numPATCH = "numPATCH";
  public static final String VAR_uuid = "uuid";
  public static final String VAR_id = "id";
  public static final String VAR_solrId = "solrId";
  public static final String VAR_original = "original";
  public static final String VAR_solrIds = "solrIds";
  public static final String VAR_ids = "ids";
  public static final String VAR_classes = "classes";
  public static final String VAR_vars = "vars";
  public static final String VAR_timeRemaining = "timeRemaining";

  public static final String DISPLAY_NAME_siteRequest_ = "";
  public static final String DISPLAY_NAME_created = "";
  public static final String DISPLAY_NAME_rows = "";
  public static final String DISPLAY_NAME_numFound = "";
  public static final String DISPLAY_NAME_numPATCH = "";
  public static final String DISPLAY_NAME_uuid = "";
  public static final String DISPLAY_NAME_id = "";
  public static final String DISPLAY_NAME_solrId = "";
  public static final String DISPLAY_NAME_original = "";
  public static final String DISPLAY_NAME_solrIds = "";
  public static final String DISPLAY_NAME_ids = "";
  public static final String DISPLAY_NAME_classes = "";
  public static final String DISPLAY_NAME_vars = "";
  public static final String DISPLAY_NAME_timeRemaining = "";

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

  public String enUSStringFormatUrlEditPageForClass() {
    return null;
  }

  public String enUSStringFormatUrlDisplayPageForClass() {
    return null;
  }

  public String enUSStringFormatUrlUserPageForClass() {
    return null;
  }

  public String enUSStringFormatUrlDownloadForClass() {
    return null;
  }

  public static String displayNameForClass(String var) {
    return ApiRequest.displayNameApiRequest(var);
  }
  public static String displayNameApiRequest(String var) {
    switch(var) {
    case VAR_siteRequest_:
      return DISPLAY_NAME_siteRequest_;
    case VAR_created:
      return DISPLAY_NAME_created;
    case VAR_rows:
      return DISPLAY_NAME_rows;
    case VAR_numFound:
      return DISPLAY_NAME_numFound;
    case VAR_numPATCH:
      return DISPLAY_NAME_numPATCH;
    case VAR_uuid:
      return DISPLAY_NAME_uuid;
    case VAR_id:
      return DISPLAY_NAME_id;
    case VAR_solrId:
      return DISPLAY_NAME_solrId;
    case VAR_original:
      return DISPLAY_NAME_original;
    case VAR_solrIds:
      return DISPLAY_NAME_solrIds;
    case VAR_ids:
      return DISPLAY_NAME_ids;
    case VAR_classes:
      return DISPLAY_NAME_classes;
    case VAR_vars:
      return DISPLAY_NAME_vars;
    case VAR_timeRemaining:
      return DISPLAY_NAME_timeRemaining;
    default:
      return null;
    }
  }

  public static String descriptionApiRequest(String var) {
    if(var == null)
      return null;
    switch(var) {
      default:
        return null;
    }
  }

  public static String classSimpleNameApiRequest(String var) {
    switch(var) {
    case VAR_siteRequest_:
      return "ComputateSiteRequest";
    case VAR_created:
      return "ZonedDateTime";
    case VAR_rows:
      return "Long";
    case VAR_numFound:
      return "Long";
    case VAR_numPATCH:
      return "Long";
    case VAR_uuid:
      return "String";
    case VAR_id:
      return "String";
    case VAR_solrId:
      return "Long";
    case VAR_original:
      return "Object";
    case VAR_solrIds:
      return "List";
    case VAR_ids:
      return "List";
    case VAR_classes:
      return "List";
    case VAR_vars:
      return "List";
    case VAR_timeRemaining:
      return "String";
      default:
        return null;
    }
  }

  public static Integer htmColumnApiRequest(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer htmRowApiRequest(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer htmCellApiRequest(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer lengthMinApiRequest(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer lengthMaxApiRequest(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer maxApiRequest(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer minApiRequest(String var) {
    switch(var) {
      default:
        return null;
    }
  }
}
