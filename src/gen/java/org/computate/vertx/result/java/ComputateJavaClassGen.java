package org.computate.vertx.result.java;

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
import java.lang.Void;
import java.lang.String;
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
import java.lang.Boolean;
import io.vertx.core.json.JsonArray;
import java.lang.Long;
import io.vertx.core.json.JsonObject;
import org.computate.vertx.serialize.vertx.JsonObjectDeserializer;
import java.lang.Integer;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ComputateJavaClass objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ComputateJavaClassGen into the class ComputateJavaClass. 
 * </li>
 * <h3>About the ComputateJavaClass class and it's generated class ComputateJavaClassGen&lt;Object&gt;: </h3>extends ComputateJavaClassGen
 * <p>
 * This Java class extends a generated Java class ComputateJavaClassGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass">Find the class ComputateJavaClass in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ComputateJavaClassGen<Object>
 * <p>This <code>class ComputateJavaClass extends ComputateJavaClassGen&lt;Object&gt;</code>, which means it extends a newly generated ComputateJavaClassGen. 
 * The generated <code>class ComputateJavaClassGen extends Object</code> which means that ComputateJavaClass extends ComputateJavaClassGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the ComputateJavaClass class will inherit the helpful inherited class comments from the super class ComputateJavaClassGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the ComputateJavaClass Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
 * </p>
 * <p>
 *   Adding protected void methods beginning with an underscore with a Promise as the only parameter will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   <pre>
 *   
 *   	protected void _promiseBefore(Promise&lt;Void&gt; promise) {
 *   		promise.complete();
 *   	}
 *   </pre>
 * </p>
 * <p>
 *   Java classes with the `Model: true` will automatically set `Promise: true`. 
 * </p>
 * <p>
 *   If a super class of this Java class with `Model: true`, then the child class will also inherit `Promise: true`. 
 * </p>
 * <h2>AName.enUS: null</h2>
 * <p>
 * Delete the class ComputateJavaClass in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.result.java in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.result.java&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class ComputateJavaClassGen<DEV> extends Object {
  protected static final Logger LOG = LoggerFactory.getLogger(ComputateJavaClass.class);

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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _siteRequest_(Wrap<ComputateSiteRequest> w);

  public ComputateSiteRequest getSiteRequest_() {
    return siteRequest_;
  }

  public void setSiteRequest_(ComputateSiteRequest siteRequest_) {
    this.siteRequest_ = siteRequest_;
  }
  public static ComputateSiteRequest staticSetSiteRequest_(ComputateSiteRequest siteRequest_, String o) {
    return null;
  }
  protected ComputateJavaClass siteRequest_Init() {
    Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
    if(siteRequest_ == null) {
      _siteRequest_(siteRequest_Wrap);
      Optional.ofNullable(siteRequest_Wrap.getO()).ifPresent(o -> {
        setSiteRequest_(o);
      });
    }
    return (ComputateJavaClass)this;
  }

	///////////////////
  // promiseBefore //
	///////////////////


  /**
   *  The entity promiseBefore
   *	 is defined as null before being initialized. 
   */
  @JsonIgnore
  @JsonInclude(Include.NON_NULL)
  protected Void promiseBefore;

  /**
   * <br> The entity promiseBefore
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
   * <br>
   * @param promise is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _promiseBefore(Promise<Void> promise);

  public Void getPromiseBefore() {
    return promiseBefore;
  }

  public void setPromiseBefore(Void promiseBefore) {
    this.promiseBefore = promiseBefore;
  }
  public static Void staticSetPromiseBefore(ComputateSiteRequest siteRequest_, String o) {
    return null;
  }
  protected Future<Void> promiseBeforePromise() {
    Promise<Void> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    _promiseBefore(promise2);
    promise2.future().onSuccess(o -> {
      setPromiseBefore(o);
      promise.complete(o);
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

	///////////////
  // inheritPk //
	///////////////


  /**
   *  The entity inheritPk
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String inheritPk;

  /**
   * <br> The entity inheritPk
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:inheritPk">Find the entity inheritPk in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _inheritPk(Wrap<String> w);

  public String getInheritPk() {
    return inheritPk;
  }
  public void setInheritPk(String o) {
    this.inheritPk = ComputateJavaClass.staticSetInheritPk(siteRequest_, o);
  }
  public static String staticSetInheritPk(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass inheritPkInit() {
    Wrap<String> inheritPkWrap = new Wrap<String>().var("inheritPk");
    if(inheritPk == null) {
      _inheritPk(inheritPkWrap);
      Optional.ofNullable(inheritPkWrap.getO()).ifPresent(o -> {
        setInheritPk(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchInheritPk(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrInheritPk(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqInheritPk(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchInheritPk(siteRequest_, ComputateJavaClass.staticSetInheritPk(siteRequest_, o)).toString();
  }

  public String sqlInheritPk() {
    return inheritPk;
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:created">Find the entity created in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _created(Wrap<ZonedDateTime> w);

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
    this.created = ComputateJavaClass.staticSetCreated(siteRequest_, o, zoneId);
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
  protected ComputateJavaClass createdInit() {
    Wrap<ZonedDateTime> createdWrap = new Wrap<ZonedDateTime>().var("created");
    if(created == null) {
      _created(createdWrap);
      Optional.ofNullable(createdWrap.getO()).ifPresent(o -> {
        setCreated(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchCreated(ComputateSiteRequest siteRequest_, ZonedDateTime o) {
    return o == null ? null : ComputateZonedDateTimeSerializer.UTC_DATE_TIME_FORMATTER.format(o.toInstant().atOffset(ZoneOffset.UTC));
  }

  public static String staticSearchStrCreated(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputateJavaClass.staticSearchCreated(siteRequest_, ComputateJavaClass.staticSetCreated(siteRequest_, o, zoneId));
  }

  public static String staticSearchFqCreated(ComputateSiteRequest siteRequest_, String o) {
    ZoneId zoneId = ZoneId.of("UTC");
    return ComputateJavaClass.staticSearchCreated(siteRequest_, ComputateJavaClass.staticSetCreated(siteRequest_, o, zoneId)).toString();
  }

  public OffsetDateTime sqlCreated() {
    return created == null ? null : created.toOffsetDateTime();
  }

	//////////////
  // archived //
	//////////////


  /**
   *  The entity archived
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean archived;

  /**
   * <br> The entity archived
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:archived">Find the entity archived in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _archived(Wrap<Boolean> w);

  public Boolean getArchived() {
    return archived;
  }

  public void setArchived(Boolean archived) {
    this.archived = archived;
  }
  @JsonIgnore
  public void setArchived(String o) {
    this.archived = ComputateJavaClass.staticSetArchived(siteRequest_, o);
  }
  public static Boolean staticSetArchived(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass archivedInit() {
    Wrap<Boolean> archivedWrap = new Wrap<Boolean>().var("archived");
    if(archived == null) {
      _archived(archivedWrap);
      Optional.ofNullable(archivedWrap.getO()).ifPresent(o -> {
        setArchived(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchArchived(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrArchived(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqArchived(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchArchived(siteRequest_, ComputateJavaClass.staticSetArchived(siteRequest_, o)).toString();
  }

  public Boolean sqlArchived() {
    return archived;
  }

	/////////////
  // deleted //
	/////////////


  /**
   *  The entity deleted
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean deleted;

  /**
   * <br> The entity deleted
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:deleted">Find the entity deleted in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _deleted(Wrap<Boolean> w);

  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }
  @JsonIgnore
  public void setDeleted(String o) {
    this.deleted = ComputateJavaClass.staticSetDeleted(siteRequest_, o);
  }
  public static Boolean staticSetDeleted(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass deletedInit() {
    Wrap<Boolean> deletedWrap = new Wrap<Boolean>().var("deleted");
    if(deleted == null) {
      _deleted(deletedWrap);
      Optional.ofNullable(deletedWrap.getO()).ifPresent(o -> {
        setDeleted(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchDeleted(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrDeleted(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDeleted(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchDeleted(siteRequest_, ComputateJavaClass.staticSetDeleted(siteRequest_, o)).toString();
  }

  public Boolean sqlDeleted() {
    return deleted;
  }

	/////////////////////////
  // classCanonicalNames //
	/////////////////////////


  /**
   *  The entity classCanonicalNames
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classCanonicalNames = new ArrayList<String>();

  /**
   * <br> The entity classCanonicalNames
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classCanonicalNames">Find the entity classCanonicalNames in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _classCanonicalNames(List<String> l);

  public List<String> getClassCanonicalNames() {
    return classCanonicalNames;
  }

  public void setClassCanonicalNames(List<String> classCanonicalNames) {
    this.classCanonicalNames = classCanonicalNames;
  }
  @JsonIgnore
  public void setClassCanonicalNames(String o) {
    String l = ComputateJavaClass.staticSetClassCanonicalNames(siteRequest_, o);
    if(l != null)
      addClassCanonicalNames(l);
  }
  public static String staticSetClassCanonicalNames(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassCanonicalNames(String...objects) {
    for(String o : objects) {
      addClassCanonicalNames(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassCanonicalNames(String o) {
    if(o != null)
      this.classCanonicalNames.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassCanonicalNames(JsonArray objects) {
    classCanonicalNames.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassCanonicalNames(o);
    }
  }
  protected ComputateJavaClass classCanonicalNamesInit() {
    _classCanonicalNames(classCanonicalNames);
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassCanonicalNames(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassCanonicalNames(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassCanonicalNames(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassCanonicalNames(siteRequest_, ComputateJavaClass.staticSetClassCanonicalNames(siteRequest_, o)).toString();
  }

	///////////////
  // sessionId //
	///////////////


  /**
   *  The entity sessionId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String sessionId;

  /**
   * <br> The entity sessionId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:sessionId">Find the entity sessionId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _sessionId(Wrap<String> w);

  public String getSessionId() {
    return sessionId;
  }
  public void setSessionId(String o) {
    this.sessionId = ComputateJavaClass.staticSetSessionId(siteRequest_, o);
  }
  public static String staticSetSessionId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass sessionIdInit() {
    Wrap<String> sessionIdWrap = new Wrap<String>().var("sessionId");
    if(sessionId == null) {
      _sessionId(sessionIdWrap);
      Optional.ofNullable(sessionIdWrap.getO()).ifPresent(o -> {
        setSessionId(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSessionId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSessionId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSessionId(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSessionId(siteRequest_, ComputateJavaClass.staticSetSessionId(siteRequest_, o)).toString();
  }

  public String sqlSessionId() {
    return sessionId;
  }

	/////////////
  // userKey //
	/////////////


  /**
   *  The entity userKey
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Long userKey;

  /**
   * <br> The entity userKey
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:userKey">Find the entity userKey in Solr</a>
   * <br>
   * @param c is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _userKey(Wrap<Long> c);

  public Long getUserKey() {
    return userKey;
  }

  public void setUserKey(Long userKey) {
    this.userKey = userKey;
  }
  @JsonIgnore
  public void setUserKey(String o) {
    this.userKey = ComputateJavaClass.staticSetUserKey(siteRequest_, o);
  }
  public static Long staticSetUserKey(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Long.parseLong(o);
    return null;
  }
  protected ComputateJavaClass userKeyInit() {
    Wrap<Long> userKeyWrap = new Wrap<Long>().var("userKey");
    if(userKey == null) {
      _userKey(userKeyWrap);
      Optional.ofNullable(userKeyWrap.getO()).ifPresent(o -> {
        setUserKey(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Long staticSearchUserKey(ComputateSiteRequest siteRequest_, Long o) {
    return o;
  }

  public static String staticSearchStrUserKey(ComputateSiteRequest siteRequest_, Long o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqUserKey(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchUserKey(siteRequest_, ComputateJavaClass.staticSetUserKey(siteRequest_, o)).toString();
  }

  public Long sqlUserKey() {
    return userKey;
  }

	///////////
  // saves //
	///////////


  /**
   *  The entity saves
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> saves = new ArrayList<String>();

  /**
   * <br> The entity saves
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:saves">Find the entity saves in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _saves(List<String> l);

  public List<String> getSaves() {
    return saves;
  }

  public void setSaves(List<String> saves) {
    this.saves = saves;
  }
  @JsonIgnore
  public void setSaves(String o) {
    String l = ComputateJavaClass.staticSetSaves(siteRequest_, o);
    if(l != null)
      addSaves(l);
  }
  public static String staticSetSaves(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addSaves(String...objects) {
    for(String o : objects) {
      addSaves(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addSaves(String o) {
    if(o != null)
      this.saves.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setSaves(JsonArray objects) {
    saves.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addSaves(o);
    }
  }
  protected ComputateJavaClass savesInit() {
    _saves(saves);
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSaves(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSaves(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSaves(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSaves(siteRequest_, ComputateJavaClass.staticSetSaves(siteRequest_, o)).toString();
  }

	/////////////////
  // objectTitle //
	/////////////////


  /**
   *  The entity objectTitle
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String objectTitle;

  /**
   * <br> The entity objectTitle
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:objectTitle">Find the entity objectTitle in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _objectTitle(Wrap<String> w);

  public String getObjectTitle() {
    return objectTitle;
  }
  public void setObjectTitle(String o) {
    this.objectTitle = ComputateJavaClass.staticSetObjectTitle(siteRequest_, o);
  }
  public static String staticSetObjectTitle(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass objectTitleInit() {
    Wrap<String> objectTitleWrap = new Wrap<String>().var("objectTitle");
    if(objectTitle == null) {
      _objectTitle(objectTitleWrap);
      Optional.ofNullable(objectTitleWrap.getO()).ifPresent(o -> {
        setObjectTitle(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchObjectTitle(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrObjectTitle(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqObjectTitle(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchObjectTitle(siteRequest_, ComputateJavaClass.staticSetObjectTitle(siteRequest_, o)).toString();
  }

	//////////////
  // objectId //
	//////////////


  /**
   *  The entity objectId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String objectId;

  /**
   * <br> The entity objectId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:objectId">Find the entity objectId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _objectId(Wrap<String> w);

  public String getObjectId() {
    return objectId;
  }
  public void setObjectId(String o) {
    this.objectId = ComputateJavaClass.staticSetObjectId(siteRequest_, o);
  }
  public static String staticSetObjectId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass objectIdInit() {
    Wrap<String> objectIdWrap = new Wrap<String>().var("objectId");
    if(objectId == null) {
      _objectId(objectIdWrap);
      Optional.ofNullable(objectIdWrap.getO()).ifPresent(o -> {
        setObjectId(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchObjectId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrObjectId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqObjectId(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchObjectId(siteRequest_, ComputateJavaClass.staticSetObjectId(siteRequest_, o)).toString();
  }

  public String sqlObjectId() {
    return objectId;
  }

	///////////////////
  // objectSuggest //
	///////////////////


  /**
   *  The entity objectSuggest
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String objectSuggest;

  /**
   * <br> The entity objectSuggest
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:objectSuggest">Find the entity objectSuggest in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _objectSuggest(Wrap<String> w);

  public String getObjectSuggest() {
    return objectSuggest;
  }
  public void setObjectSuggest(String o) {
    this.objectSuggest = ComputateJavaClass.staticSetObjectSuggest(siteRequest_, o);
  }
  public static String staticSetObjectSuggest(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass objectSuggestInit() {
    Wrap<String> objectSuggestWrap = new Wrap<String>().var("objectSuggest");
    if(objectSuggest == null) {
      _objectSuggest(objectSuggestWrap);
      Optional.ofNullable(objectSuggestWrap.getO()).ifPresent(o -> {
        setObjectSuggest(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchObjectSuggest(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrObjectSuggest(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqObjectSuggest(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchObjectSuggest(siteRequest_, ComputateJavaClass.staticSetObjectSuggest(siteRequest_, o)).toString();
  }

	////////////////
  // objectText //
	////////////////


  /**
   *  The entity objectText
   *	 It is constructed before being initialized with the constructor by default. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> objectText = new ArrayList<String>();

  /**
   * <br> The entity objectText
   *  It is constructed before being initialized with the constructor by default. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:objectText">Find the entity objectText in Solr</a>
   * <br>
   * @param l is the entity already constructed. 
   **/
  protected abstract void _objectText(List<String> l);

  public List<String> getObjectText() {
    return objectText;
  }

  public void setObjectText(List<String> objectText) {
    this.objectText = objectText;
  }
  @JsonIgnore
  public void setObjectText(String o) {
    String l = ComputateJavaClass.staticSetObjectText(siteRequest_, o);
    if(l != null)
      addObjectText(l);
  }
  public static String staticSetObjectText(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addObjectText(String...objects) {
    for(String o : objects) {
      addObjectText(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addObjectText(String o) {
    if(o != null)
      this.objectText.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setObjectText(JsonArray objects) {
    objectText.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addObjectText(o);
    }
  }
  protected ComputateJavaClass objectTextInit() {
    _objectText(objectText);
    return (ComputateJavaClass)this;
  }

  public static String staticSearchObjectText(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrObjectText(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqObjectText(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchObjectText(siteRequest_, ComputateJavaClass.staticSetObjectText(siteRequest_, o)).toString();
  }

	///////////////
  // pageUrlId //
	///////////////


  /**
   *  The entity pageUrlId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUrlId;

  /**
   * <br> The entity pageUrlId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:pageUrlId">Find the entity pageUrlId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUrlId(Wrap<String> w);

  public String getPageUrlId() {
    return pageUrlId;
  }
  public void setPageUrlId(String o) {
    this.pageUrlId = ComputateJavaClass.staticSetPageUrlId(siteRequest_, o);
  }
  public static String staticSetPageUrlId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass pageUrlIdInit() {
    Wrap<String> pageUrlIdWrap = new Wrap<String>().var("pageUrlId");
    if(pageUrlId == null) {
      _pageUrlId(pageUrlIdWrap);
      Optional.ofNullable(pageUrlIdWrap.getO()).ifPresent(o -> {
        setPageUrlId(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchPageUrlId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUrlId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUrlId(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchPageUrlId(siteRequest_, ComputateJavaClass.staticSetPageUrlId(siteRequest_, o)).toString();
  }

	///////////////
  // pageUrlPk //
	///////////////


  /**
   *  The entity pageUrlPk
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUrlPk;

  /**
   * <br> The entity pageUrlPk
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:pageUrlPk">Find the entity pageUrlPk in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUrlPk(Wrap<String> w);

  public String getPageUrlPk() {
    return pageUrlPk;
  }
  public void setPageUrlPk(String o) {
    this.pageUrlPk = ComputateJavaClass.staticSetPageUrlPk(siteRequest_, o);
  }
  public static String staticSetPageUrlPk(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass pageUrlPkInit() {
    Wrap<String> pageUrlPkWrap = new Wrap<String>().var("pageUrlPk");
    if(pageUrlPk == null) {
      _pageUrlPk(pageUrlPkWrap);
      Optional.ofNullable(pageUrlPkWrap.getO()).ifPresent(o -> {
        setPageUrlPk(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchPageUrlPk(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUrlPk(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUrlPk(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchPageUrlPk(siteRequest_, ComputateJavaClass.staticSetPageUrlPk(siteRequest_, o)).toString();
  }

	////////////////
  // pageUrlApi //
	////////////////


  /**
   *  The entity pageUrlApi
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String pageUrlApi;

  /**
   * <br> The entity pageUrlApi
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:pageUrlApi">Find the entity pageUrlApi in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _pageUrlApi(Wrap<String> w);

  public String getPageUrlApi() {
    return pageUrlApi;
  }
  public void setPageUrlApi(String o) {
    this.pageUrlApi = ComputateJavaClass.staticSetPageUrlApi(siteRequest_, o);
  }
  public static String staticSetPageUrlApi(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass pageUrlApiInit() {
    Wrap<String> pageUrlApiWrap = new Wrap<String>().var("pageUrlApi");
    if(pageUrlApi == null) {
      _pageUrlApi(pageUrlApiWrap);
      Optional.ofNullable(pageUrlApiWrap.getO()).ifPresent(o -> {
        setPageUrlApi(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchPageUrlApi(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrPageUrlApi(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPageUrlApi(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchPageUrlApi(siteRequest_, ComputateJavaClass.staticSetPageUrlApi(siteRequest_, o)).toString();
  }

	/////////
  // doc //
	/////////


  /**
   *  The entity doc
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonDeserialize(using = JsonObjectDeserializer.class)
  @JsonInclude(Include.NON_NULL)
  protected JsonObject doc;

  /**
   * <br> The entity doc
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:doc">Find the entity doc in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _doc(Wrap<JsonObject> w);

  public JsonObject getDoc() {
    return doc;
  }

  public void setDoc(JsonObject doc) {
    this.doc = doc;
  }
  @JsonIgnore
  public void setDoc(String o) {
    this.doc = ComputateJavaClass.staticSetDoc(siteRequest_, o);
  }
  public static JsonObject staticSetDoc(ComputateSiteRequest siteRequest_, String o) {
    if(o != null) {
        return new JsonObject(o);
    }
    return null;
  }
  protected ComputateJavaClass docInit() {
    Wrap<JsonObject> docWrap = new Wrap<JsonObject>().var("doc");
    if(doc == null) {
      _doc(docWrap);
      Optional.ofNullable(docWrap.getO()).ifPresent(o -> {
        setDoc(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchDoc(ComputateSiteRequest siteRequest_, JsonObject o) {
    return o.toString();
  }

  public static String staticSearchStrDoc(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDoc(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchDoc(siteRequest_, ComputateJavaClass.staticSetDoc(siteRequest_, o)).toString();
  }

	//////////////
  // sitePath //
	//////////////


  /**
   *  The entity sitePath
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String sitePath;

  /**
   * <br> The entity sitePath
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:sitePath">Find the entity sitePath in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _sitePath(Wrap<String> w);

  public String getSitePath() {
    return sitePath;
  }
  public void setSitePath(String o) {
    this.sitePath = ComputateJavaClass.staticSetSitePath(siteRequest_, o);
  }
  public static String staticSetSitePath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass sitePathInit() {
    Wrap<String> sitePathWrap = new Wrap<String>().var("sitePath");
    if(sitePath == null) {
      _sitePath(sitePathWrap);
      Optional.ofNullable(sitePathWrap.getO()).ifPresent(o -> {
        setSitePath(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSitePath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSitePath(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSitePath(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSitePath(siteRequest_, ComputateJavaClass.staticSetSitePath(siteRequest_, o)).toString();
  }

	//////////////
  // siteName //
	//////////////


  /**
   *  The entity siteName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String siteName;

  /**
   * <br> The entity siteName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:siteName">Find the entity siteName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _siteName(Wrap<String> w);

  public String getSiteName() {
    return siteName;
  }
  public void setSiteName(String o) {
    this.siteName = ComputateJavaClass.staticSetSiteName(siteRequest_, o);
  }
  public static String staticSetSiteName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass siteNameInit() {
    Wrap<String> siteNameWrap = new Wrap<String>().var("siteName");
    if(siteName == null) {
      _siteName(siteNameWrap);
      Optional.ofNullable(siteNameWrap.getO()).ifPresent(o -> {
        setSiteName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSiteName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSiteName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSiteName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSiteName(siteRequest_, ComputateJavaClass.staticSetSiteName(siteRequest_, o)).toString();
  }

	//////////////////////////////
  // superClassParamsTypeName //
	//////////////////////////////


  /**
   *  The entity superClassParamsTypeName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> superClassParamsTypeName;

  /**
   * <br> The entity superClassParamsTypeName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:superClassParamsTypeName">Find the entity superClassParamsTypeName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _superClassParamsTypeName(Wrap<List<String>> w);

  public List<String> getSuperClassParamsTypeName() {
    return superClassParamsTypeName;
  }

  public void setSuperClassParamsTypeName(List<String> superClassParamsTypeName) {
    this.superClassParamsTypeName = superClassParamsTypeName;
  }
  @JsonIgnore
  public void setSuperClassParamsTypeName(String o) {
    String l = ComputateJavaClass.staticSetSuperClassParamsTypeName(siteRequest_, o);
    if(l != null)
      addSuperClassParamsTypeName(l);
  }
  public static String staticSetSuperClassParamsTypeName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addSuperClassParamsTypeName(String...objects) {
    for(String o : objects) {
      addSuperClassParamsTypeName(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addSuperClassParamsTypeName(String o) {
    if(o != null)
      this.superClassParamsTypeName.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setSuperClassParamsTypeName(JsonArray objects) {
    superClassParamsTypeName.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addSuperClassParamsTypeName(o);
    }
  }
  protected ComputateJavaClass superClassParamsTypeNameInit() {
    Wrap<List<String>> superClassParamsTypeNameWrap = new Wrap<List<String>>().var("superClassParamsTypeName");
    if(superClassParamsTypeName == null) {
      _superClassParamsTypeName(superClassParamsTypeNameWrap);
      Optional.ofNullable(superClassParamsTypeNameWrap.getO()).ifPresent(o -> {
        setSuperClassParamsTypeName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSuperClassParamsTypeName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSuperClassParamsTypeName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSuperClassParamsTypeName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSuperClassParamsTypeName(siteRequest_, ComputateJavaClass.staticSetSuperClassParamsTypeName(siteRequest_, o)).toString();
  }

	////////////////////////////
  // superClassCompleteName //
	////////////////////////////


  /**
   *  The entity superClassCompleteName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String superClassCompleteName;

  /**
   * <br> The entity superClassCompleteName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:superClassCompleteName">Find the entity superClassCompleteName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _superClassCompleteName(Wrap<String> w);

  public String getSuperClassCompleteName() {
    return superClassCompleteName;
  }
  public void setSuperClassCompleteName(String o) {
    this.superClassCompleteName = ComputateJavaClass.staticSetSuperClassCompleteName(siteRequest_, o);
  }
  public static String staticSetSuperClassCompleteName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass superClassCompleteNameInit() {
    Wrap<String> superClassCompleteNameWrap = new Wrap<String>().var("superClassCompleteName");
    if(superClassCompleteName == null) {
      _superClassCompleteName(superClassCompleteNameWrap);
      Optional.ofNullable(superClassCompleteNameWrap.getO()).ifPresent(o -> {
        setSuperClassCompleteName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSuperClassCompleteName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSuperClassCompleteName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSuperClassCompleteName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSuperClassCompleteName(siteRequest_, ComputateJavaClass.staticSetSuperClassCompleteName(siteRequest_, o)).toString();
  }

	///////////////////////////////////
  // superClassGenericCompleteName //
	///////////////////////////////////


  /**
   *  The entity superClassGenericCompleteName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String superClassGenericCompleteName;

  /**
   * <br> The entity superClassGenericCompleteName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:superClassGenericCompleteName">Find the entity superClassGenericCompleteName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _superClassGenericCompleteName(Wrap<String> w);

  public String getSuperClassGenericCompleteName() {
    return superClassGenericCompleteName;
  }
  public void setSuperClassGenericCompleteName(String o) {
    this.superClassGenericCompleteName = ComputateJavaClass.staticSetSuperClassGenericCompleteName(siteRequest_, o);
  }
  public static String staticSetSuperClassGenericCompleteName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass superClassGenericCompleteNameInit() {
    Wrap<String> superClassGenericCompleteNameWrap = new Wrap<String>().var("superClassGenericCompleteName");
    if(superClassGenericCompleteName == null) {
      _superClassGenericCompleteName(superClassGenericCompleteNameWrap);
      Optional.ofNullable(superClassGenericCompleteNameWrap.getO()).ifPresent(o -> {
        setSuperClassGenericCompleteName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSuperClassGenericCompleteName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSuperClassGenericCompleteName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSuperClassGenericCompleteName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSuperClassGenericCompleteName(siteRequest_, ComputateJavaClass.staticSetSuperClassGenericCompleteName(siteRequest_, o)).toString();
  }

	////////////////////////////////////
  // superClassGenericCanonicalName //
	////////////////////////////////////


  /**
   *  The entity superClassGenericCanonicalName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String superClassGenericCanonicalName;

  /**
   * <br> The entity superClassGenericCanonicalName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:superClassGenericCanonicalName">Find the entity superClassGenericCanonicalName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _superClassGenericCanonicalName(Wrap<String> w);

  public String getSuperClassGenericCanonicalName() {
    return superClassGenericCanonicalName;
  }
  public void setSuperClassGenericCanonicalName(String o) {
    this.superClassGenericCanonicalName = ComputateJavaClass.staticSetSuperClassGenericCanonicalName(siteRequest_, o);
  }
  public static String staticSetSuperClassGenericCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass superClassGenericCanonicalNameInit() {
    Wrap<String> superClassGenericCanonicalNameWrap = new Wrap<String>().var("superClassGenericCanonicalName");
    if(superClassGenericCanonicalName == null) {
      _superClassGenericCanonicalName(superClassGenericCanonicalNameWrap);
      Optional.ofNullable(superClassGenericCanonicalNameWrap.getO()).ifPresent(o -> {
        setSuperClassGenericCanonicalName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSuperClassGenericCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSuperClassGenericCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSuperClassGenericCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSuperClassGenericCanonicalName(siteRequest_, ComputateJavaClass.staticSetSuperClassGenericCanonicalName(siteRequest_, o)).toString();
  }

	/////////////////////////////////
  // superClassGenericSimpleName //
	/////////////////////////////////


  /**
   *  The entity superClassGenericSimpleName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String superClassGenericSimpleName;

  /**
   * <br> The entity superClassGenericSimpleName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:superClassGenericSimpleName">Find the entity superClassGenericSimpleName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _superClassGenericSimpleName(Wrap<String> w);

  public String getSuperClassGenericSimpleName() {
    return superClassGenericSimpleName;
  }
  public void setSuperClassGenericSimpleName(String o) {
    this.superClassGenericSimpleName = ComputateJavaClass.staticSetSuperClassGenericSimpleName(siteRequest_, o);
  }
  public static String staticSetSuperClassGenericSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass superClassGenericSimpleNameInit() {
    Wrap<String> superClassGenericSimpleNameWrap = new Wrap<String>().var("superClassGenericSimpleName");
    if(superClassGenericSimpleName == null) {
      _superClassGenericSimpleName(superClassGenericSimpleNameWrap);
      Optional.ofNullable(superClassGenericSimpleNameWrap.getO()).ifPresent(o -> {
        setSuperClassGenericSimpleName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSuperClassGenericSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSuperClassGenericSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSuperClassGenericSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSuperClassGenericSimpleName(siteRequest_, ComputateJavaClass.staticSetSuperClassGenericSimpleName(siteRequest_, o)).toString();
  }

	/////////////////
  // classIsBase //
	/////////////////


  /**
   *  The entity classIsBase
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classIsBase;

  /**
   * <br> The entity classIsBase
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classIsBase">Find the entity classIsBase in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classIsBase(Wrap<Boolean> w);

  public Boolean getClassIsBase() {
    return classIsBase;
  }

  public void setClassIsBase(Boolean classIsBase) {
    this.classIsBase = classIsBase;
  }
  @JsonIgnore
  public void setClassIsBase(String o) {
    this.classIsBase = ComputateJavaClass.staticSetClassIsBase(siteRequest_, o);
  }
  public static Boolean staticSetClassIsBase(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classIsBaseInit() {
    Wrap<Boolean> classIsBaseWrap = new Wrap<Boolean>().var("classIsBase");
    if(classIsBase == null) {
      _classIsBase(classIsBaseWrap);
      Optional.ofNullable(classIsBaseWrap.getO()).ifPresent(o -> {
        setClassIsBase(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassIsBase(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassIsBase(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassIsBase(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassIsBase(siteRequest_, ComputateJavaClass.staticSetClassIsBase(siteRequest_, o)).toString();
  }

	//////////////////////
  // classExtendsBase //
	//////////////////////


  /**
   *  The entity classExtendsBase
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classExtendsBase;

  /**
   * <br> The entity classExtendsBase
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classExtendsBase">Find the entity classExtendsBase in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classExtendsBase(Wrap<Boolean> w);

  public Boolean getClassExtendsBase() {
    return classExtendsBase;
  }

  public void setClassExtendsBase(Boolean classExtendsBase) {
    this.classExtendsBase = classExtendsBase;
  }
  @JsonIgnore
  public void setClassExtendsBase(String o) {
    this.classExtendsBase = ComputateJavaClass.staticSetClassExtendsBase(siteRequest_, o);
  }
  public static Boolean staticSetClassExtendsBase(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classExtendsBaseInit() {
    Wrap<Boolean> classExtendsBaseWrap = new Wrap<Boolean>().var("classExtendsBase");
    if(classExtendsBase == null) {
      _classExtendsBase(classExtendsBaseWrap);
      Optional.ofNullable(classExtendsBaseWrap.getO()).ifPresent(o -> {
        setClassExtendsBase(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassExtendsBase(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassExtendsBase(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassExtendsBase(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassExtendsBase(siteRequest_, ComputateJavaClass.staticSetClassExtendsBase(siteRequest_, o)).toString();
  }

	/////////////////////////
  // classBaseExtendsGen //
	/////////////////////////


  /**
   *  The entity classBaseExtendsGen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classBaseExtendsGen;

  /**
   * <br> The entity classBaseExtendsGen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classBaseExtendsGen">Find the entity classBaseExtendsGen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classBaseExtendsGen(Wrap<Boolean> w);

  public Boolean getClassBaseExtendsGen() {
    return classBaseExtendsGen;
  }

  public void setClassBaseExtendsGen(Boolean classBaseExtendsGen) {
    this.classBaseExtendsGen = classBaseExtendsGen;
  }
  @JsonIgnore
  public void setClassBaseExtendsGen(String o) {
    this.classBaseExtendsGen = ComputateJavaClass.staticSetClassBaseExtendsGen(siteRequest_, o);
  }
  public static Boolean staticSetClassBaseExtendsGen(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classBaseExtendsGenInit() {
    Wrap<Boolean> classBaseExtendsGenWrap = new Wrap<Boolean>().var("classBaseExtendsGen");
    if(classBaseExtendsGen == null) {
      _classBaseExtendsGen(classBaseExtendsGenWrap);
      Optional.ofNullable(classBaseExtendsGenWrap.getO()).ifPresent(o -> {
        setClassBaseExtendsGen(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassBaseExtendsGen(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassBaseExtendsGen(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassBaseExtendsGen(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassBaseExtendsGen(siteRequest_, ComputateJavaClass.staticSetClassBaseExtendsGen(siteRequest_, o)).toString();
  }

	//////////////////////////////
  // classContainsSiteRequest //
	//////////////////////////////


  /**
   *  The entity classContainsSiteRequest
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classContainsSiteRequest;

  /**
   * <br> The entity classContainsSiteRequest
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classContainsSiteRequest">Find the entity classContainsSiteRequest in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classContainsSiteRequest(Wrap<Boolean> w);

  public Boolean getClassContainsSiteRequest() {
    return classContainsSiteRequest;
  }

  public void setClassContainsSiteRequest(Boolean classContainsSiteRequest) {
    this.classContainsSiteRequest = classContainsSiteRequest;
  }
  @JsonIgnore
  public void setClassContainsSiteRequest(String o) {
    this.classContainsSiteRequest = ComputateJavaClass.staticSetClassContainsSiteRequest(siteRequest_, o);
  }
  public static Boolean staticSetClassContainsSiteRequest(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classContainsSiteRequestInit() {
    Wrap<Boolean> classContainsSiteRequestWrap = new Wrap<Boolean>().var("classContainsSiteRequest");
    if(classContainsSiteRequest == null) {
      _classContainsSiteRequest(classContainsSiteRequestWrap);
      Optional.ofNullable(classContainsSiteRequestWrap.getO()).ifPresent(o -> {
        setClassContainsSiteRequest(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassContainsSiteRequest(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassContainsSiteRequest(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassContainsSiteRequest(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassContainsSiteRequest(siteRequest_, ComputateJavaClass.staticSetClassContainsSiteRequest(siteRequest_, o)).toString();
  }

	////////////////////
  // classTranslate //
	////////////////////


  /**
   *  The entity classTranslate
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classTranslate;

  /**
   * <br> The entity classTranslate
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classTranslate">Find the entity classTranslate in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classTranslate(Wrap<Boolean> w);

  public Boolean getClassTranslate() {
    return classTranslate;
  }

  public void setClassTranslate(Boolean classTranslate) {
    this.classTranslate = classTranslate;
  }
  @JsonIgnore
  public void setClassTranslate(String o) {
    this.classTranslate = ComputateJavaClass.staticSetClassTranslate(siteRequest_, o);
  }
  public static Boolean staticSetClassTranslate(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classTranslateInit() {
    Wrap<Boolean> classTranslateWrap = new Wrap<Boolean>().var("classTranslate");
    if(classTranslate == null) {
      _classTranslate(classTranslateWrap);
      Optional.ofNullable(classTranslateWrap.getO()).ifPresent(o -> {
        setClassTranslate(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassTranslate(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassTranslate(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassTranslate(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassTranslate(siteRequest_, ComputateJavaClass.staticSetClassTranslate(siteRequest_, o)).toString();
  }

	///////////////////
  // classInitDeep //
	///////////////////


  /**
   *  The entity classInitDeep
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classInitDeep;

  /**
   * <br> The entity classInitDeep
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classInitDeep">Find the entity classInitDeep in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classInitDeep(Wrap<Boolean> w);

  public Boolean getClassInitDeep() {
    return classInitDeep;
  }

  public void setClassInitDeep(Boolean classInitDeep) {
    this.classInitDeep = classInitDeep;
  }
  @JsonIgnore
  public void setClassInitDeep(String o) {
    this.classInitDeep = ComputateJavaClass.staticSetClassInitDeep(siteRequest_, o);
  }
  public static Boolean staticSetClassInitDeep(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classInitDeepInit() {
    Wrap<Boolean> classInitDeepWrap = new Wrap<Boolean>().var("classInitDeep");
    if(classInitDeep == null) {
      _classInitDeep(classInitDeepWrap);
      Optional.ofNullable(classInitDeepWrap.getO()).ifPresent(o -> {
        setClassInitDeep(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassInitDeep(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassInitDeep(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassInitDeep(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassInitDeep(siteRequest_, ComputateJavaClass.staticSetClassInitDeep(siteRequest_, o)).toString();
  }

	/////////////////////
  // classExtendsGen //
	/////////////////////


  /**
   *  The entity classExtendsGen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classExtendsGen;

  /**
   * <br> The entity classExtendsGen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classExtendsGen">Find the entity classExtendsGen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classExtendsGen(Wrap<Boolean> w);

  public Boolean getClassExtendsGen() {
    return classExtendsGen;
  }

  public void setClassExtendsGen(Boolean classExtendsGen) {
    this.classExtendsGen = classExtendsGen;
  }
  @JsonIgnore
  public void setClassExtendsGen(String o) {
    this.classExtendsGen = ComputateJavaClass.staticSetClassExtendsGen(siteRequest_, o);
  }
  public static Boolean staticSetClassExtendsGen(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classExtendsGenInit() {
    Wrap<Boolean> classExtendsGenWrap = new Wrap<Boolean>().var("classExtendsGen");
    if(classExtendsGen == null) {
      _classExtendsGen(classExtendsGenWrap);
      Optional.ofNullable(classExtendsGenWrap.getO()).ifPresent(o -> {
        setClassExtendsGen(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassExtendsGen(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassExtendsGen(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassExtendsGen(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassExtendsGen(siteRequest_, ComputateJavaClass.staticSetClassExtendsGen(siteRequest_, o)).toString();
  }

	//////////////////
  // languageName //
	//////////////////


  /**
   *  The entity languageName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String languageName;

  /**
   * <br> The entity languageName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:languageName">Find the entity languageName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _languageName(Wrap<String> w);

  public String getLanguageName() {
    return languageName;
  }
  public void setLanguageName(String o) {
    this.languageName = ComputateJavaClass.staticSetLanguageName(siteRequest_, o);
  }
  public static String staticSetLanguageName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass languageNameInit() {
    Wrap<String> languageNameWrap = new Wrap<String>().var("languageName");
    if(languageName == null) {
      _languageName(languageNameWrap);
      Optional.ofNullable(languageNameWrap.getO()).ifPresent(o -> {
        setLanguageName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchLanguageName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrLanguageName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqLanguageName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchLanguageName(siteRequest_, ComputateJavaClass.staticSetLanguageName(siteRequest_, o)).toString();
  }

	//////////////
  // modified //
	//////////////


  /**
   *  The entity modified
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String modified;

  /**
   * <br> The entity modified
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:modified">Find the entity modified in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _modified(Wrap<String> w);

  public String getModified() {
    return modified;
  }
  public void setModified(String o) {
    this.modified = ComputateJavaClass.staticSetModified(siteRequest_, o);
  }
  public static String staticSetModified(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass modifiedInit() {
    Wrap<String> modifiedWrap = new Wrap<String>().var("modified");
    if(modified == null) {
      _modified(modifiedWrap);
      Optional.ofNullable(modifiedWrap.getO()).ifPresent(o -> {
        setModified(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchModified(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrModified(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqModified(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchModified(siteRequest_, ComputateJavaClass.staticSetModified(siteRequest_, o)).toString();
  }

	////////////////////////
  // classCanonicalName //
	////////////////////////


  /**
   *  The entity classCanonicalName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classCanonicalName;

  /**
   * <br> The entity classCanonicalName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classCanonicalName">Find the entity classCanonicalName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classCanonicalName(Wrap<String> w);

  public String getClassCanonicalName() {
    return classCanonicalName;
  }
  public void setClassCanonicalName(String o) {
    this.classCanonicalName = ComputateJavaClass.staticSetClassCanonicalName(siteRequest_, o);
  }
  public static String staticSetClassCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classCanonicalNameInit() {
    Wrap<String> classCanonicalNameWrap = new Wrap<String>().var("classCanonicalName");
    if(classCanonicalName == null) {
      _classCanonicalName(classCanonicalNameWrap);
      Optional.ofNullable(classCanonicalNameWrap.getO()).ifPresent(o -> {
        setClassCanonicalName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassCanonicalName(siteRequest_, ComputateJavaClass.staticSetClassCanonicalName(siteRequest_, o)).toString();
  }

	/////////////////////
  // classSimpleName //
	/////////////////////


  /**
   *  The entity classSimpleName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classSimpleName;

  /**
   * <br> The entity classSimpleName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSimpleName(Wrap<String> w);

  public String getClassSimpleName() {
    return classSimpleName;
  }
  public void setClassSimpleName(String o) {
    this.classSimpleName = ComputateJavaClass.staticSetClassSimpleName(siteRequest_, o);
  }
  public static String staticSetClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classSimpleNameInit() {
    Wrap<String> classSimpleNameWrap = new Wrap<String>().var("classSimpleName");
    if(classSimpleName == null) {
      _classSimpleName(classSimpleNameWrap);
      Optional.ofNullable(classSimpleNameWrap.getO()).ifPresent(o -> {
        setClassSimpleName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSimpleName(siteRequest_, ComputateJavaClass.staticSetClassSimpleName(siteRequest_, o)).toString();
  }

	//////////////////////
  // classPackageName //
	//////////////////////


  /**
   *  The entity classPackageName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPackageName;

  /**
   * <br> The entity classPackageName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPackageName">Find the entity classPackageName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPackageName(Wrap<String> w);

  public String getClassPackageName() {
    return classPackageName;
  }
  public void setClassPackageName(String o) {
    this.classPackageName = ComputateJavaClass.staticSetClassPackageName(siteRequest_, o);
  }
  public static String staticSetClassPackageName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPackageNameInit() {
    Wrap<String> classPackageNameWrap = new Wrap<String>().var("classPackageName");
    if(classPackageName == null) {
      _classPackageName(classPackageNameWrap);
      Optional.ofNullable(classPackageNameWrap.getO()).ifPresent(o -> {
        setClassPackageName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPackageName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPackageName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPackageName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPackageName(siteRequest_, ComputateJavaClass.staticSetClassPackageName(siteRequest_, o)).toString();
  }

	///////////////////////////
  // classCanonicalNameGen //
	///////////////////////////


  /**
   *  The entity classCanonicalNameGen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classCanonicalNameGen;

  /**
   * <br> The entity classCanonicalNameGen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classCanonicalNameGen">Find the entity classCanonicalNameGen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classCanonicalNameGen(Wrap<String> w);

  public String getClassCanonicalNameGen() {
    return classCanonicalNameGen;
  }
  public void setClassCanonicalNameGen(String o) {
    this.classCanonicalNameGen = ComputateJavaClass.staticSetClassCanonicalNameGen(siteRequest_, o);
  }
  public static String staticSetClassCanonicalNameGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classCanonicalNameGenInit() {
    Wrap<String> classCanonicalNameGenWrap = new Wrap<String>().var("classCanonicalNameGen");
    if(classCanonicalNameGen == null) {
      _classCanonicalNameGen(classCanonicalNameGenWrap);
      Optional.ofNullable(classCanonicalNameGenWrap.getO()).ifPresent(o -> {
        setClassCanonicalNameGen(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassCanonicalNameGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassCanonicalNameGen(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassCanonicalNameGen(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassCanonicalNameGen(siteRequest_, ComputateJavaClass.staticSetClassCanonicalNameGen(siteRequest_, o)).toString();
  }

	////////////////////////
  // classSimpleNameGen //
	////////////////////////


  /**
   *  The entity classSimpleNameGen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classSimpleNameGen;

  /**
   * <br> The entity classSimpleNameGen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSimpleNameGen">Find the entity classSimpleNameGen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSimpleNameGen(Wrap<String> w);

  public String getClassSimpleNameGen() {
    return classSimpleNameGen;
  }
  public void setClassSimpleNameGen(String o) {
    this.classSimpleNameGen = ComputateJavaClass.staticSetClassSimpleNameGen(siteRequest_, o);
  }
  public static String staticSetClassSimpleNameGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classSimpleNameGenInit() {
    Wrap<String> classSimpleNameGenWrap = new Wrap<String>().var("classSimpleNameGen");
    if(classSimpleNameGen == null) {
      _classSimpleNameGen(classSimpleNameGenWrap);
      Optional.ofNullable(classSimpleNameGenWrap.getO()).ifPresent(o -> {
        setClassSimpleNameGen(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSimpleNameGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSimpleNameGen(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSimpleNameGen(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSimpleNameGen(siteRequest_, ComputateJavaClass.staticSetClassSimpleNameGen(siteRequest_, o)).toString();
  }

	/////////////////////////////
  // superClassCanonicalName //
	/////////////////////////////


  /**
   *  The entity superClassCanonicalName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String superClassCanonicalName;

  /**
   * <br> The entity superClassCanonicalName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:superClassCanonicalName">Find the entity superClassCanonicalName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _superClassCanonicalName(Wrap<String> w);

  public String getSuperClassCanonicalName() {
    return superClassCanonicalName;
  }
  public void setSuperClassCanonicalName(String o) {
    this.superClassCanonicalName = ComputateJavaClass.staticSetSuperClassCanonicalName(siteRequest_, o);
  }
  public static String staticSetSuperClassCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass superClassCanonicalNameInit() {
    Wrap<String> superClassCanonicalNameWrap = new Wrap<String>().var("superClassCanonicalName");
    if(superClassCanonicalName == null) {
      _superClassCanonicalName(superClassCanonicalNameWrap);
      Optional.ofNullable(superClassCanonicalNameWrap.getO()).ifPresent(o -> {
        setSuperClassCanonicalName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSuperClassCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSuperClassCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSuperClassCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSuperClassCanonicalName(siteRequest_, ComputateJavaClass.staticSetSuperClassCanonicalName(siteRequest_, o)).toString();
  }

	//////////////////////////
  // superClassSimpleName //
	//////////////////////////


  /**
   *  The entity superClassSimpleName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String superClassSimpleName;

  /**
   * <br> The entity superClassSimpleName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:superClassSimpleName">Find the entity superClassSimpleName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _superClassSimpleName(Wrap<String> w);

  public String getSuperClassSimpleName() {
    return superClassSimpleName;
  }
  public void setSuperClassSimpleName(String o) {
    this.superClassSimpleName = ComputateJavaClass.staticSetSuperClassSimpleName(siteRequest_, o);
  }
  public static String staticSetSuperClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass superClassSimpleNameInit() {
    Wrap<String> superClassSimpleNameWrap = new Wrap<String>().var("superClassSimpleName");
    if(superClassSimpleName == null) {
      _superClassSimpleName(superClassSimpleNameWrap);
      Optional.ofNullable(superClassSimpleNameWrap.getO()).ifPresent(o -> {
        setSuperClassSimpleName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchSuperClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrSuperClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSuperClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSuperClassSimpleName(siteRequest_, ComputateJavaClass.staticSetSuperClassSimpleName(siteRequest_, o)).toString();
  }

	///////////////////////
  // classAbsolutePath //
	///////////////////////


  /**
   *  The entity classAbsolutePath
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classAbsolutePath;

  /**
   * <br> The entity classAbsolutePath
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classAbsolutePath">Find the entity classAbsolutePath in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classAbsolutePath(Wrap<String> w);

  public String getClassAbsolutePath() {
    return classAbsolutePath;
  }
  public void setClassAbsolutePath(String o) {
    this.classAbsolutePath = ComputateJavaClass.staticSetClassAbsolutePath(siteRequest_, o);
  }
  public static String staticSetClassAbsolutePath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classAbsolutePathInit() {
    Wrap<String> classAbsolutePathWrap = new Wrap<String>().var("classAbsolutePath");
    if(classAbsolutePath == null) {
      _classAbsolutePath(classAbsolutePathWrap);
      Optional.ofNullable(classAbsolutePathWrap.getO()).ifPresent(o -> {
        setClassAbsolutePath(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassAbsolutePath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassAbsolutePath(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassAbsolutePath(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassAbsolutePath(siteRequest_, ComputateJavaClass.staticSetClassAbsolutePath(siteRequest_, o)).toString();
  }

	///////////////
  // classPath //
	///////////////


  /**
   *  The entity classPath
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPath;

  /**
   * <br> The entity classPath
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPath">Find the entity classPath in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPath(Wrap<String> w);

  public String getClassPath() {
    return classPath;
  }
  public void setClassPath(String o) {
    this.classPath = ComputateJavaClass.staticSetClassPath(siteRequest_, o);
  }
  public static String staticSetClassPath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPathInit() {
    Wrap<String> classPathWrap = new Wrap<String>().var("classPath");
    if(classPath == null) {
      _classPath(classPathWrap);
      Optional.ofNullable(classPathWrap.getO()).ifPresent(o -> {
        setClassPath(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPath(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPath(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPath(siteRequest_, ComputateJavaClass.staticSetClassPath(siteRequest_, o)).toString();
  }

	////////////////////////
  // classDirectoryPath //
	////////////////////////


  /**
   *  The entity classDirectoryPath
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classDirectoryPath;

  /**
   * <br> The entity classDirectoryPath
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classDirectoryPath">Find the entity classDirectoryPath in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classDirectoryPath(Wrap<String> w);

  public String getClassDirectoryPath() {
    return classDirectoryPath;
  }
  public void setClassDirectoryPath(String o) {
    this.classDirectoryPath = ComputateJavaClass.staticSetClassDirectoryPath(siteRequest_, o);
  }
  public static String staticSetClassDirectoryPath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classDirectoryPathInit() {
    Wrap<String> classDirectoryPathWrap = new Wrap<String>().var("classDirectoryPath");
    if(classDirectoryPath == null) {
      _classDirectoryPath(classDirectoryPathWrap);
      Optional.ofNullable(classDirectoryPathWrap.getO()).ifPresent(o -> {
        setClassDirectoryPath(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassDirectoryPath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassDirectoryPath(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassDirectoryPath(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassDirectoryPath(siteRequest_, ComputateJavaClass.staticSetClassDirectoryPath(siteRequest_, o)).toString();
  }

	//////////////////
  // classPathGen //
	//////////////////


  /**
   *  The entity classPathGen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPathGen;

  /**
   * <br> The entity classPathGen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPathGen">Find the entity classPathGen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPathGen(Wrap<String> w);

  public String getClassPathGen() {
    return classPathGen;
  }
  public void setClassPathGen(String o) {
    this.classPathGen = ComputateJavaClass.staticSetClassPathGen(siteRequest_, o);
  }
  public static String staticSetClassPathGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPathGenInit() {
    Wrap<String> classPathGenWrap = new Wrap<String>().var("classPathGen");
    if(classPathGen == null) {
      _classPathGen(classPathGenWrap);
      Optional.ofNullable(classPathGenWrap.getO()).ifPresent(o -> {
        setClassPathGen(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPathGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPathGen(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPathGen(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPathGen(siteRequest_, ComputateJavaClass.staticSetClassPathGen(siteRequest_, o)).toString();
  }

	///////////////////////////
  // classDirectoryPathGen //
	///////////////////////////


  /**
   *  The entity classDirectoryPathGen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classDirectoryPathGen;

  /**
   * <br> The entity classDirectoryPathGen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classDirectoryPathGen">Find the entity classDirectoryPathGen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classDirectoryPathGen(Wrap<String> w);

  public String getClassDirectoryPathGen() {
    return classDirectoryPathGen;
  }
  public void setClassDirectoryPathGen(String o) {
    this.classDirectoryPathGen = ComputateJavaClass.staticSetClassDirectoryPathGen(siteRequest_, o);
  }
  public static String staticSetClassDirectoryPathGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classDirectoryPathGenInit() {
    Wrap<String> classDirectoryPathGenWrap = new Wrap<String>().var("classDirectoryPathGen");
    if(classDirectoryPathGen == null) {
      _classDirectoryPathGen(classDirectoryPathGenWrap);
      Optional.ofNullable(classDirectoryPathGenWrap.getO()).ifPresent(o -> {
        setClassDirectoryPathGen(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassDirectoryPathGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassDirectoryPathGen(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassDirectoryPathGen(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassDirectoryPathGen(siteRequest_, ComputateJavaClass.staticSetClassDirectoryPathGen(siteRequest_, o)).toString();
  }

	///////////////////////
  // domainPackageName //
	///////////////////////


  /**
   *  The entity domainPackageName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String domainPackageName;

  /**
   * <br> The entity domainPackageName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:domainPackageName">Find the entity domainPackageName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _domainPackageName(Wrap<String> w);

  public String getDomainPackageName() {
    return domainPackageName;
  }
  public void setDomainPackageName(String o) {
    this.domainPackageName = ComputateJavaClass.staticSetDomainPackageName(siteRequest_, o);
  }
  public static String staticSetDomainPackageName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass domainPackageNameInit() {
    Wrap<String> domainPackageNameWrap = new Wrap<String>().var("domainPackageName");
    if(domainPackageName == null) {
      _domainPackageName(domainPackageNameWrap);
      Optional.ofNullable(domainPackageNameWrap.getO()).ifPresent(o -> {
        setDomainPackageName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchDomainPackageName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrDomainPackageName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqDomainPackageName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchDomainPackageName(siteRequest_, ComputateJavaClass.staticSetDomainPackageName(siteRequest_, o)).toString();
  }

	///////////////////////////////////////
  // entityClassesSuperAndMeWithoutGen //
	///////////////////////////////////////


  /**
   *  The entity entityClassesSuperAndMeWithoutGen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> entityClassesSuperAndMeWithoutGen;

  /**
   * <br> The entity entityClassesSuperAndMeWithoutGen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:entityClassesSuperAndMeWithoutGen">Find the entity entityClassesSuperAndMeWithoutGen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _entityClassesSuperAndMeWithoutGen(Wrap<List<String>> w);

  public List<String> getEntityClassesSuperAndMeWithoutGen() {
    return entityClassesSuperAndMeWithoutGen;
  }

  public void setEntityClassesSuperAndMeWithoutGen(List<String> entityClassesSuperAndMeWithoutGen) {
    this.entityClassesSuperAndMeWithoutGen = entityClassesSuperAndMeWithoutGen;
  }
  @JsonIgnore
  public void setEntityClassesSuperAndMeWithoutGen(String o) {
    String l = ComputateJavaClass.staticSetEntityClassesSuperAndMeWithoutGen(siteRequest_, o);
    if(l != null)
      addEntityClassesSuperAndMeWithoutGen(l);
  }
  public static String staticSetEntityClassesSuperAndMeWithoutGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addEntityClassesSuperAndMeWithoutGen(String...objects) {
    for(String o : objects) {
      addEntityClassesSuperAndMeWithoutGen(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addEntityClassesSuperAndMeWithoutGen(String o) {
    if(o != null)
      this.entityClassesSuperAndMeWithoutGen.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setEntityClassesSuperAndMeWithoutGen(JsonArray objects) {
    entityClassesSuperAndMeWithoutGen.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addEntityClassesSuperAndMeWithoutGen(o);
    }
  }
  protected ComputateJavaClass entityClassesSuperAndMeWithoutGenInit() {
    Wrap<List<String>> entityClassesSuperAndMeWithoutGenWrap = new Wrap<List<String>>().var("entityClassesSuperAndMeWithoutGen");
    if(entityClassesSuperAndMeWithoutGen == null) {
      _entityClassesSuperAndMeWithoutGen(entityClassesSuperAndMeWithoutGenWrap);
      Optional.ofNullable(entityClassesSuperAndMeWithoutGenWrap.getO()).ifPresent(o -> {
        setEntityClassesSuperAndMeWithoutGen(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchEntityClassesSuperAndMeWithoutGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrEntityClassesSuperAndMeWithoutGen(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqEntityClassesSuperAndMeWithoutGen(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchEntityClassesSuperAndMeWithoutGen(siteRequest_, ComputateJavaClass.staticSetEntityClassesSuperAndMeWithoutGen(siteRequest_, o)).toString();
  }

	/////////////////////
  // classIsAbstract //
	/////////////////////


  /**
   *  The entity classIsAbstract
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classIsAbstract;

  /**
   * <br> The entity classIsAbstract
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classIsAbstract">Find the entity classIsAbstract in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classIsAbstract(Wrap<Boolean> w);

  public Boolean getClassIsAbstract() {
    return classIsAbstract;
  }

  public void setClassIsAbstract(Boolean classIsAbstract) {
    this.classIsAbstract = classIsAbstract;
  }
  @JsonIgnore
  public void setClassIsAbstract(String o) {
    this.classIsAbstract = ComputateJavaClass.staticSetClassIsAbstract(siteRequest_, o);
  }
  public static Boolean staticSetClassIsAbstract(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classIsAbstractInit() {
    Wrap<Boolean> classIsAbstractWrap = new Wrap<Boolean>().var("classIsAbstract");
    if(classIsAbstract == null) {
      _classIsAbstract(classIsAbstractWrap);
      Optional.ofNullable(classIsAbstractWrap.getO()).ifPresent(o -> {
        setClassIsAbstract(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassIsAbstract(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassIsAbstract(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassIsAbstract(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassIsAbstract(siteRequest_, ComputateJavaClass.staticSetClassIsAbstract(siteRequest_, o)).toString();
  }

	////////////////
  // classModel //
	////////////////


  /**
   *  The entity classModel
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classModel;

  /**
   * <br> The entity classModel
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classModel">Find the entity classModel in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classModel(Wrap<Boolean> w);

  public Boolean getClassModel() {
    return classModel;
  }

  public void setClassModel(Boolean classModel) {
    this.classModel = classModel;
  }
  @JsonIgnore
  public void setClassModel(String o) {
    this.classModel = ComputateJavaClass.staticSetClassModel(siteRequest_, o);
  }
  public static Boolean staticSetClassModel(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classModelInit() {
    Wrap<Boolean> classModelWrap = new Wrap<Boolean>().var("classModel");
    if(classModel == null) {
      _classModel(classModelWrap);
      Optional.ofNullable(classModelWrap.getO()).ifPresent(o -> {
        setClassModel(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassModel(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassModel(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassModel(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassModel(siteRequest_, ComputateJavaClass.staticSetClassModel(siteRequest_, o)).toString();
  }

	//////////////
  // classApi //
	//////////////


  /**
   *  The entity classApi
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classApi;

  /**
   * <br> The entity classApi
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classApi">Find the entity classApi in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classApi(Wrap<Boolean> w);

  public Boolean getClassApi() {
    return classApi;
  }

  public void setClassApi(Boolean classApi) {
    this.classApi = classApi;
  }
  @JsonIgnore
  public void setClassApi(String o) {
    this.classApi = ComputateJavaClass.staticSetClassApi(siteRequest_, o);
  }
  public static Boolean staticSetClassApi(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classApiInit() {
    Wrap<Boolean> classApiWrap = new Wrap<Boolean>().var("classApi");
    if(classApi == null) {
      _classApi(classApiWrap);
      Optional.ofNullable(classApiWrap.getO()).ifPresent(o -> {
        setClassApi(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassApi(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassApi(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassApi(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassApi(siteRequest_, ComputateJavaClass.staticSetClassApi(siteRequest_, o)).toString();
  }

	/////////////////////
  // classSimplePage //
	/////////////////////


  /**
   *  The entity classSimplePage
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classSimplePage;

  /**
   * <br> The entity classSimplePage
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSimplePage">Find the entity classSimplePage in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSimplePage(Wrap<Boolean> w);

  public Boolean getClassSimplePage() {
    return classSimplePage;
  }

  public void setClassSimplePage(Boolean classSimplePage) {
    this.classSimplePage = classSimplePage;
  }
  @JsonIgnore
  public void setClassSimplePage(String o) {
    this.classSimplePage = ComputateJavaClass.staticSetClassSimplePage(siteRequest_, o);
  }
  public static Boolean staticSetClassSimplePage(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classSimplePageInit() {
    Wrap<Boolean> classSimplePageWrap = new Wrap<Boolean>().var("classSimplePage");
    if(classSimplePage == null) {
      _classSimplePage(classSimplePageWrap);
      Optional.ofNullable(classSimplePageWrap.getO()).ifPresent(o -> {
        setClassSimplePage(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassSimplePage(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassSimplePage(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSimplePage(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSimplePage(siteRequest_, ComputateJavaClass.staticSetClassSimplePage(siteRequest_, o)).toString();
  }

	////////////////
  // classSaved //
	////////////////


  /**
   *  The entity classSaved
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classSaved;

  /**
   * <br> The entity classSaved
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSaved">Find the entity classSaved in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSaved(Wrap<Boolean> w);

  public Boolean getClassSaved() {
    return classSaved;
  }

  public void setClassSaved(Boolean classSaved) {
    this.classSaved = classSaved;
  }
  @JsonIgnore
  public void setClassSaved(String o) {
    this.classSaved = ComputateJavaClass.staticSetClassSaved(siteRequest_, o);
  }
  public static Boolean staticSetClassSaved(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classSavedInit() {
    Wrap<Boolean> classSavedWrap = new Wrap<Boolean>().var("classSaved");
    if(classSaved == null) {
      _classSaved(classSavedWrap);
      Optional.ofNullable(classSavedWrap.getO()).ifPresent(o -> {
        setClassSaved(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassSaved(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassSaved(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSaved(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSaved(siteRequest_, ComputateJavaClass.staticSetClassSaved(siteRequest_, o)).toString();
  }

	///////////////////////////////////
  // classSimpleNameApiPackageInfo //
	///////////////////////////////////


  /**
   *  The entity classSimpleNameApiPackageInfo
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classSimpleNameApiPackageInfo;

  /**
   * <br> The entity classSimpleNameApiPackageInfo
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSimpleNameApiPackageInfo">Find the entity classSimpleNameApiPackageInfo in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSimpleNameApiPackageInfo(Wrap<String> w);

  public String getClassSimpleNameApiPackageInfo() {
    return classSimpleNameApiPackageInfo;
  }
  public void setClassSimpleNameApiPackageInfo(String o) {
    this.classSimpleNameApiPackageInfo = ComputateJavaClass.staticSetClassSimpleNameApiPackageInfo(siteRequest_, o);
  }
  public static String staticSetClassSimpleNameApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classSimpleNameApiPackageInfoInit() {
    Wrap<String> classSimpleNameApiPackageInfoWrap = new Wrap<String>().var("classSimpleNameApiPackageInfo");
    if(classSimpleNameApiPackageInfo == null) {
      _classSimpleNameApiPackageInfo(classSimpleNameApiPackageInfoWrap);
      Optional.ofNullable(classSimpleNameApiPackageInfoWrap.getO()).ifPresent(o -> {
        setClassSimpleNameApiPackageInfo(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSimpleNameApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSimpleNameApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSimpleNameApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSimpleNameApiPackageInfo(siteRequest_, ComputateJavaClass.staticSetClassSimpleNameApiPackageInfo(siteRequest_, o)).toString();
  }

	//////////////////////////////////////
  // classSimpleNameGenApiServiceImpl //
	//////////////////////////////////////


  /**
   *  The entity classSimpleNameGenApiServiceImpl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classSimpleNameGenApiServiceImpl;

  /**
   * <br> The entity classSimpleNameGenApiServiceImpl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSimpleNameGenApiServiceImpl">Find the entity classSimpleNameGenApiServiceImpl in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSimpleNameGenApiServiceImpl(Wrap<String> w);

  public String getClassSimpleNameGenApiServiceImpl() {
    return classSimpleNameGenApiServiceImpl;
  }
  public void setClassSimpleNameGenApiServiceImpl(String o) {
    this.classSimpleNameGenApiServiceImpl = ComputateJavaClass.staticSetClassSimpleNameGenApiServiceImpl(siteRequest_, o);
  }
  public static String staticSetClassSimpleNameGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classSimpleNameGenApiServiceImplInit() {
    Wrap<String> classSimpleNameGenApiServiceImplWrap = new Wrap<String>().var("classSimpleNameGenApiServiceImpl");
    if(classSimpleNameGenApiServiceImpl == null) {
      _classSimpleNameGenApiServiceImpl(classSimpleNameGenApiServiceImplWrap);
      Optional.ofNullable(classSimpleNameGenApiServiceImplWrap.getO()).ifPresent(o -> {
        setClassSimpleNameGenApiServiceImpl(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSimpleNameGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSimpleNameGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSimpleNameGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSimpleNameGenApiServiceImpl(siteRequest_, ComputateJavaClass.staticSetClassSimpleNameGenApiServiceImpl(siteRequest_, o)).toString();
  }

	///////////////////////////////////
  // classSimpleNameApiServiceImpl //
	///////////////////////////////////


  /**
   *  The entity classSimpleNameApiServiceImpl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classSimpleNameApiServiceImpl;

  /**
   * <br> The entity classSimpleNameApiServiceImpl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSimpleNameApiServiceImpl">Find the entity classSimpleNameApiServiceImpl in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSimpleNameApiServiceImpl(Wrap<String> w);

  public String getClassSimpleNameApiServiceImpl() {
    return classSimpleNameApiServiceImpl;
  }
  public void setClassSimpleNameApiServiceImpl(String o) {
    this.classSimpleNameApiServiceImpl = ComputateJavaClass.staticSetClassSimpleNameApiServiceImpl(siteRequest_, o);
  }
  public static String staticSetClassSimpleNameApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classSimpleNameApiServiceImplInit() {
    Wrap<String> classSimpleNameApiServiceImplWrap = new Wrap<String>().var("classSimpleNameApiServiceImpl");
    if(classSimpleNameApiServiceImpl == null) {
      _classSimpleNameApiServiceImpl(classSimpleNameApiServiceImplWrap);
      Optional.ofNullable(classSimpleNameApiServiceImplWrap.getO()).ifPresent(o -> {
        setClassSimpleNameApiServiceImpl(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSimpleNameApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSimpleNameApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSimpleNameApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSimpleNameApiServiceImpl(siteRequest_, ComputateJavaClass.staticSetClassSimpleNameApiServiceImpl(siteRequest_, o)).toString();
  }

	//////////////////////////////////
  // classSimpleNameGenApiService //
	//////////////////////////////////


  /**
   *  The entity classSimpleNameGenApiService
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classSimpleNameGenApiService;

  /**
   * <br> The entity classSimpleNameGenApiService
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSimpleNameGenApiService">Find the entity classSimpleNameGenApiService in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSimpleNameGenApiService(Wrap<String> w);

  public String getClassSimpleNameGenApiService() {
    return classSimpleNameGenApiService;
  }
  public void setClassSimpleNameGenApiService(String o) {
    this.classSimpleNameGenApiService = ComputateJavaClass.staticSetClassSimpleNameGenApiService(siteRequest_, o);
  }
  public static String staticSetClassSimpleNameGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classSimpleNameGenApiServiceInit() {
    Wrap<String> classSimpleNameGenApiServiceWrap = new Wrap<String>().var("classSimpleNameGenApiService");
    if(classSimpleNameGenApiService == null) {
      _classSimpleNameGenApiService(classSimpleNameGenApiServiceWrap);
      Optional.ofNullable(classSimpleNameGenApiServiceWrap.getO()).ifPresent(o -> {
        setClassSimpleNameGenApiService(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSimpleNameGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSimpleNameGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSimpleNameGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSimpleNameGenApiService(siteRequest_, ComputateJavaClass.staticSetClassSimpleNameGenApiService(siteRequest_, o)).toString();
  }

	//////////////////////////////////////
  // classCanonicalNameApiPackageInfo //
	//////////////////////////////////////


  /**
   *  The entity classCanonicalNameApiPackageInfo
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classCanonicalNameApiPackageInfo;

  /**
   * <br> The entity classCanonicalNameApiPackageInfo
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classCanonicalNameApiPackageInfo">Find the entity classCanonicalNameApiPackageInfo in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classCanonicalNameApiPackageInfo(Wrap<String> w);

  public String getClassCanonicalNameApiPackageInfo() {
    return classCanonicalNameApiPackageInfo;
  }
  public void setClassCanonicalNameApiPackageInfo(String o) {
    this.classCanonicalNameApiPackageInfo = ComputateJavaClass.staticSetClassCanonicalNameApiPackageInfo(siteRequest_, o);
  }
  public static String staticSetClassCanonicalNameApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classCanonicalNameApiPackageInfoInit() {
    Wrap<String> classCanonicalNameApiPackageInfoWrap = new Wrap<String>().var("classCanonicalNameApiPackageInfo");
    if(classCanonicalNameApiPackageInfo == null) {
      _classCanonicalNameApiPackageInfo(classCanonicalNameApiPackageInfoWrap);
      Optional.ofNullable(classCanonicalNameApiPackageInfoWrap.getO()).ifPresent(o -> {
        setClassCanonicalNameApiPackageInfo(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassCanonicalNameApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassCanonicalNameApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassCanonicalNameApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassCanonicalNameApiPackageInfo(siteRequest_, ComputateJavaClass.staticSetClassCanonicalNameApiPackageInfo(siteRequest_, o)).toString();
  }

	/////////////////////////////////////////
  // classCanonicalNameGenApiServiceImpl //
	/////////////////////////////////////////


  /**
   *  The entity classCanonicalNameGenApiServiceImpl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classCanonicalNameGenApiServiceImpl;

  /**
   * <br> The entity classCanonicalNameGenApiServiceImpl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classCanonicalNameGenApiServiceImpl">Find the entity classCanonicalNameGenApiServiceImpl in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classCanonicalNameGenApiServiceImpl(Wrap<String> w);

  public String getClassCanonicalNameGenApiServiceImpl() {
    return classCanonicalNameGenApiServiceImpl;
  }
  public void setClassCanonicalNameGenApiServiceImpl(String o) {
    this.classCanonicalNameGenApiServiceImpl = ComputateJavaClass.staticSetClassCanonicalNameGenApiServiceImpl(siteRequest_, o);
  }
  public static String staticSetClassCanonicalNameGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classCanonicalNameGenApiServiceImplInit() {
    Wrap<String> classCanonicalNameGenApiServiceImplWrap = new Wrap<String>().var("classCanonicalNameGenApiServiceImpl");
    if(classCanonicalNameGenApiServiceImpl == null) {
      _classCanonicalNameGenApiServiceImpl(classCanonicalNameGenApiServiceImplWrap);
      Optional.ofNullable(classCanonicalNameGenApiServiceImplWrap.getO()).ifPresent(o -> {
        setClassCanonicalNameGenApiServiceImpl(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassCanonicalNameGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassCanonicalNameGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassCanonicalNameGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassCanonicalNameGenApiServiceImpl(siteRequest_, ComputateJavaClass.staticSetClassCanonicalNameGenApiServiceImpl(siteRequest_, o)).toString();
  }

	//////////////////////////////////////
  // classCanonicalNameApiServiceImpl //
	//////////////////////////////////////


  /**
   *  The entity classCanonicalNameApiServiceImpl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classCanonicalNameApiServiceImpl;

  /**
   * <br> The entity classCanonicalNameApiServiceImpl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classCanonicalNameApiServiceImpl">Find the entity classCanonicalNameApiServiceImpl in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classCanonicalNameApiServiceImpl(Wrap<String> w);

  public String getClassCanonicalNameApiServiceImpl() {
    return classCanonicalNameApiServiceImpl;
  }
  public void setClassCanonicalNameApiServiceImpl(String o) {
    this.classCanonicalNameApiServiceImpl = ComputateJavaClass.staticSetClassCanonicalNameApiServiceImpl(siteRequest_, o);
  }
  public static String staticSetClassCanonicalNameApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classCanonicalNameApiServiceImplInit() {
    Wrap<String> classCanonicalNameApiServiceImplWrap = new Wrap<String>().var("classCanonicalNameApiServiceImpl");
    if(classCanonicalNameApiServiceImpl == null) {
      _classCanonicalNameApiServiceImpl(classCanonicalNameApiServiceImplWrap);
      Optional.ofNullable(classCanonicalNameApiServiceImplWrap.getO()).ifPresent(o -> {
        setClassCanonicalNameApiServiceImpl(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassCanonicalNameApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassCanonicalNameApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassCanonicalNameApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassCanonicalNameApiServiceImpl(siteRequest_, ComputateJavaClass.staticSetClassCanonicalNameApiServiceImpl(siteRequest_, o)).toString();
  }

	/////////////////////////////////////
  // classCanonicalNameGenApiService //
	/////////////////////////////////////


  /**
   *  The entity classCanonicalNameGenApiService
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classCanonicalNameGenApiService;

  /**
   * <br> The entity classCanonicalNameGenApiService
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classCanonicalNameGenApiService">Find the entity classCanonicalNameGenApiService in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classCanonicalNameGenApiService(Wrap<String> w);

  public String getClassCanonicalNameGenApiService() {
    return classCanonicalNameGenApiService;
  }
  public void setClassCanonicalNameGenApiService(String o) {
    this.classCanonicalNameGenApiService = ComputateJavaClass.staticSetClassCanonicalNameGenApiService(siteRequest_, o);
  }
  public static String staticSetClassCanonicalNameGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classCanonicalNameGenApiServiceInit() {
    Wrap<String> classCanonicalNameGenApiServiceWrap = new Wrap<String>().var("classCanonicalNameGenApiService");
    if(classCanonicalNameGenApiService == null) {
      _classCanonicalNameGenApiService(classCanonicalNameGenApiServiceWrap);
      Optional.ofNullable(classCanonicalNameGenApiServiceWrap.getO()).ifPresent(o -> {
        setClassCanonicalNameGenApiService(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassCanonicalNameGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassCanonicalNameGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassCanonicalNameGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassCanonicalNameGenApiService(siteRequest_, ComputateJavaClass.staticSetClassCanonicalNameGenApiService(siteRequest_, o)).toString();
  }

	/////////////////////////////
  // classPathApiPackageInfo //
	/////////////////////////////


  /**
   *  The entity classPathApiPackageInfo
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPathApiPackageInfo;

  /**
   * <br> The entity classPathApiPackageInfo
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPathApiPackageInfo">Find the entity classPathApiPackageInfo in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPathApiPackageInfo(Wrap<String> w);

  public String getClassPathApiPackageInfo() {
    return classPathApiPackageInfo;
  }
  public void setClassPathApiPackageInfo(String o) {
    this.classPathApiPackageInfo = ComputateJavaClass.staticSetClassPathApiPackageInfo(siteRequest_, o);
  }
  public static String staticSetClassPathApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPathApiPackageInfoInit() {
    Wrap<String> classPathApiPackageInfoWrap = new Wrap<String>().var("classPathApiPackageInfo");
    if(classPathApiPackageInfo == null) {
      _classPathApiPackageInfo(classPathApiPackageInfoWrap);
      Optional.ofNullable(classPathApiPackageInfoWrap.getO()).ifPresent(o -> {
        setClassPathApiPackageInfo(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPathApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPathApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPathApiPackageInfo(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPathApiPackageInfo(siteRequest_, ComputateJavaClass.staticSetClassPathApiPackageInfo(siteRequest_, o)).toString();
  }

	////////////////////////////////
  // classPathGenApiServiceImpl //
	////////////////////////////////


  /**
   *  The entity classPathGenApiServiceImpl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPathGenApiServiceImpl;

  /**
   * <br> The entity classPathGenApiServiceImpl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPathGenApiServiceImpl">Find the entity classPathGenApiServiceImpl in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPathGenApiServiceImpl(Wrap<String> w);

  public String getClassPathGenApiServiceImpl() {
    return classPathGenApiServiceImpl;
  }
  public void setClassPathGenApiServiceImpl(String o) {
    this.classPathGenApiServiceImpl = ComputateJavaClass.staticSetClassPathGenApiServiceImpl(siteRequest_, o);
  }
  public static String staticSetClassPathGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPathGenApiServiceImplInit() {
    Wrap<String> classPathGenApiServiceImplWrap = new Wrap<String>().var("classPathGenApiServiceImpl");
    if(classPathGenApiServiceImpl == null) {
      _classPathGenApiServiceImpl(classPathGenApiServiceImplWrap);
      Optional.ofNullable(classPathGenApiServiceImplWrap.getO()).ifPresent(o -> {
        setClassPathGenApiServiceImpl(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPathGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPathGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPathGenApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPathGenApiServiceImpl(siteRequest_, ComputateJavaClass.staticSetClassPathGenApiServiceImpl(siteRequest_, o)).toString();
  }

	/////////////////////////////
  // classPathApiServiceImpl //
	/////////////////////////////


  /**
   *  The entity classPathApiServiceImpl
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPathApiServiceImpl;

  /**
   * <br> The entity classPathApiServiceImpl
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPathApiServiceImpl">Find the entity classPathApiServiceImpl in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPathApiServiceImpl(Wrap<String> w);

  public String getClassPathApiServiceImpl() {
    return classPathApiServiceImpl;
  }
  public void setClassPathApiServiceImpl(String o) {
    this.classPathApiServiceImpl = ComputateJavaClass.staticSetClassPathApiServiceImpl(siteRequest_, o);
  }
  public static String staticSetClassPathApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPathApiServiceImplInit() {
    Wrap<String> classPathApiServiceImplWrap = new Wrap<String>().var("classPathApiServiceImpl");
    if(classPathApiServiceImpl == null) {
      _classPathApiServiceImpl(classPathApiServiceImplWrap);
      Optional.ofNullable(classPathApiServiceImplWrap.getO()).ifPresent(o -> {
        setClassPathApiServiceImpl(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPathApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPathApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPathApiServiceImpl(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPathApiServiceImpl(siteRequest_, ComputateJavaClass.staticSetClassPathApiServiceImpl(siteRequest_, o)).toString();
  }

	////////////////////////////
  // classPathGenApiService //
	////////////////////////////


  /**
   *  The entity classPathGenApiService
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPathGenApiService;

  /**
   * <br> The entity classPathGenApiService
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPathGenApiService">Find the entity classPathGenApiService in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPathGenApiService(Wrap<String> w);

  public String getClassPathGenApiService() {
    return classPathGenApiService;
  }
  public void setClassPathGenApiService(String o) {
    this.classPathGenApiService = ComputateJavaClass.staticSetClassPathGenApiService(siteRequest_, o);
  }
  public static String staticSetClassPathGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPathGenApiServiceInit() {
    Wrap<String> classPathGenApiServiceWrap = new Wrap<String>().var("classPathGenApiService");
    if(classPathGenApiService == null) {
      _classPathGenApiService(classPathGenApiServiceWrap);
      Optional.ofNullable(classPathGenApiServiceWrap.getO()).ifPresent(o -> {
        setClassPathGenApiService(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPathGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPathGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPathGenApiService(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPathGenApiService(siteRequest_, ComputateJavaClass.staticSetClassPathGenApiService(siteRequest_, o)).toString();
  }

	/////////////////////
  // classPublicRead //
	/////////////////////


  /**
   *  The entity classPublicRead
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classPublicRead;

  /**
   * <br> The entity classPublicRead
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPublicRead">Find the entity classPublicRead in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPublicRead(Wrap<Boolean> w);

  public Boolean getClassPublicRead() {
    return classPublicRead;
  }

  public void setClassPublicRead(Boolean classPublicRead) {
    this.classPublicRead = classPublicRead;
  }
  @JsonIgnore
  public void setClassPublicRead(String o) {
    this.classPublicRead = ComputateJavaClass.staticSetClassPublicRead(siteRequest_, o);
  }
  public static Boolean staticSetClassPublicRead(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classPublicReadInit() {
    Wrap<Boolean> classPublicReadWrap = new Wrap<Boolean>().var("classPublicRead");
    if(classPublicRead == null) {
      _classPublicRead(classPublicReadWrap);
      Optional.ofNullable(classPublicReadWrap.getO()).ifPresent(o -> {
        setClassPublicRead(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassPublicRead(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassPublicRead(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPublicRead(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPublicRead(siteRequest_, ComputateJavaClass.staticSetClassPublicRead(siteRequest_, o)).toString();
  }

	//////////////////////
  // classRoleSession //
	//////////////////////


  /**
   *  The entity classRoleSession
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classRoleSession;

  /**
   * <br> The entity classRoleSession
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classRoleSession">Find the entity classRoleSession in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classRoleSession(Wrap<Boolean> w);

  public Boolean getClassRoleSession() {
    return classRoleSession;
  }

  public void setClassRoleSession(Boolean classRoleSession) {
    this.classRoleSession = classRoleSession;
  }
  @JsonIgnore
  public void setClassRoleSession(String o) {
    this.classRoleSession = ComputateJavaClass.staticSetClassRoleSession(siteRequest_, o);
  }
  public static Boolean staticSetClassRoleSession(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classRoleSessionInit() {
    Wrap<Boolean> classRoleSessionWrap = new Wrap<Boolean>().var("classRoleSession");
    if(classRoleSession == null) {
      _classRoleSession(classRoleSessionWrap);
      Optional.ofNullable(classRoleSessionWrap.getO()).ifPresent(o -> {
        setClassRoleSession(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassRoleSession(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassRoleSession(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassRoleSession(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassRoleSession(siteRequest_, ComputateJavaClass.staticSetClassRoleSession(siteRequest_, o)).toString();
  }

	///////////////////
  // classRoleUser //
	///////////////////


  /**
   *  The entity classRoleUser
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classRoleUser;

  /**
   * <br> The entity classRoleUser
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classRoleUser">Find the entity classRoleUser in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classRoleUser(Wrap<Boolean> w);

  public Boolean getClassRoleUser() {
    return classRoleUser;
  }

  public void setClassRoleUser(Boolean classRoleUser) {
    this.classRoleUser = classRoleUser;
  }
  @JsonIgnore
  public void setClassRoleUser(String o) {
    this.classRoleUser = ComputateJavaClass.staticSetClassRoleUser(siteRequest_, o);
  }
  public static Boolean staticSetClassRoleUser(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classRoleUserInit() {
    Wrap<Boolean> classRoleUserWrap = new Wrap<Boolean>().var("classRoleUser");
    if(classRoleUser == null) {
      _classRoleUser(classRoleUserWrap);
      Optional.ofNullable(classRoleUserWrap.getO()).ifPresent(o -> {
        setClassRoleUser(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassRoleUser(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassRoleUser(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassRoleUser(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassRoleUser(siteRequest_, ComputateJavaClass.staticSetClassRoleUser(siteRequest_, o)).toString();
  }

	///////////////////
  // classRoleEach //
	///////////////////


  /**
   *  The entity classRoleEach
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classRoleEach;

  /**
   * <br> The entity classRoleEach
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classRoleEach">Find the entity classRoleEach in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classRoleEach(Wrap<Boolean> w);

  public Boolean getClassRoleEach() {
    return classRoleEach;
  }

  public void setClassRoleEach(Boolean classRoleEach) {
    this.classRoleEach = classRoleEach;
  }
  @JsonIgnore
  public void setClassRoleEach(String o) {
    this.classRoleEach = ComputateJavaClass.staticSetClassRoleEach(siteRequest_, o);
  }
  public static Boolean staticSetClassRoleEach(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classRoleEachInit() {
    Wrap<Boolean> classRoleEachWrap = new Wrap<Boolean>().var("classRoleEach");
    if(classRoleEach == null) {
      _classRoleEach(classRoleEachWrap);
      Optional.ofNullable(classRoleEachWrap.getO()).ifPresent(o -> {
        setClassRoleEach(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassRoleEach(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassRoleEach(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassRoleEach(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassRoleEach(siteRequest_, ComputateJavaClass.staticSetClassRoleEach(siteRequest_, o)).toString();
  }

	////////////////
  // classRoles //
	////////////////


  /**
   *  The entity classRoles
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classRoles;

  /**
   * <br> The entity classRoles
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classRoles">Find the entity classRoles in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classRoles(Wrap<List<String>> w);

  public List<String> getClassRoles() {
    return classRoles;
  }

  public void setClassRoles(List<String> classRoles) {
    this.classRoles = classRoles;
  }
  @JsonIgnore
  public void setClassRoles(String o) {
    String l = ComputateJavaClass.staticSetClassRoles(siteRequest_, o);
    if(l != null)
      addClassRoles(l);
  }
  public static String staticSetClassRoles(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassRoles(String...objects) {
    for(String o : objects) {
      addClassRoles(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassRoles(String o) {
    if(o != null)
      this.classRoles.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassRoles(JsonArray objects) {
    classRoles.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassRoles(o);
    }
  }
  protected ComputateJavaClass classRolesInit() {
    Wrap<List<String>> classRolesWrap = new Wrap<List<String>>().var("classRoles");
    if(classRoles == null) {
      _classRoles(classRolesWrap);
      Optional.ofNullable(classRolesWrap.getO()).ifPresent(o -> {
        setClassRoles(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassRoles(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassRoles(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassRoles(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassRoles(siteRequest_, ComputateJavaClass.staticSetClassRoles(siteRequest_, o)).toString();
  }

	////////////////////////
  // classRolesLanguage //
	////////////////////////


  /**
   *  The entity classRolesLanguage
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classRolesLanguage;

  /**
   * <br> The entity classRolesLanguage
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classRolesLanguage">Find the entity classRolesLanguage in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classRolesLanguage(Wrap<List<String>> w);

  public List<String> getClassRolesLanguage() {
    return classRolesLanguage;
  }

  public void setClassRolesLanguage(List<String> classRolesLanguage) {
    this.classRolesLanguage = classRolesLanguage;
  }
  @JsonIgnore
  public void setClassRolesLanguage(String o) {
    String l = ComputateJavaClass.staticSetClassRolesLanguage(siteRequest_, o);
    if(l != null)
      addClassRolesLanguage(l);
  }
  public static String staticSetClassRolesLanguage(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassRolesLanguage(String...objects) {
    for(String o : objects) {
      addClassRolesLanguage(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassRolesLanguage(String o) {
    if(o != null)
      this.classRolesLanguage.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassRolesLanguage(JsonArray objects) {
    classRolesLanguage.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassRolesLanguage(o);
    }
  }
  protected ComputateJavaClass classRolesLanguageInit() {
    Wrap<List<String>> classRolesLanguageWrap = new Wrap<List<String>>().var("classRolesLanguage");
    if(classRolesLanguage == null) {
      _classRolesLanguage(classRolesLanguageWrap);
      Optional.ofNullable(classRolesLanguageWrap.getO()).ifPresent(o -> {
        setClassRolesLanguage(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassRolesLanguage(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassRolesLanguage(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassRolesLanguage(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassRolesLanguage(siteRequest_, ComputateJavaClass.staticSetClassRolesLanguage(siteRequest_, o)).toString();
  }

	/////////////////////
  // classRolesFound //
	/////////////////////


  /**
   *  The entity classRolesFound
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classRolesFound;

  /**
   * <br> The entity classRolesFound
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classRolesFound">Find the entity classRolesFound in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classRolesFound(Wrap<Boolean> w);

  public Boolean getClassRolesFound() {
    return classRolesFound;
  }

  public void setClassRolesFound(Boolean classRolesFound) {
    this.classRolesFound = classRolesFound;
  }
  @JsonIgnore
  public void setClassRolesFound(String o) {
    this.classRolesFound = ComputateJavaClass.staticSetClassRolesFound(siteRequest_, o);
  }
  public static Boolean staticSetClassRolesFound(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classRolesFoundInit() {
    Wrap<Boolean> classRolesFoundWrap = new Wrap<Boolean>().var("classRolesFound");
    if(classRolesFound == null) {
      _classRolesFound(classRolesFoundWrap);
      Optional.ofNullable(classRolesFoundWrap.getO()).ifPresent(o -> {
        setClassRolesFound(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassRolesFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassRolesFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassRolesFound(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassRolesFound(siteRequest_, ComputateJavaClass.staticSetClassRolesFound(siteRequest_, o)).toString();
  }

	////////////////////////
  // classRoleReadFound //
	////////////////////////


  /**
   *  The entity classRoleReadFound
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classRoleReadFound;

  /**
   * <br> The entity classRoleReadFound
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classRoleReadFound">Find the entity classRoleReadFound in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classRoleReadFound(Wrap<Boolean> w);

  public Boolean getClassRoleReadFound() {
    return classRoleReadFound;
  }

  public void setClassRoleReadFound(Boolean classRoleReadFound) {
    this.classRoleReadFound = classRoleReadFound;
  }
  @JsonIgnore
  public void setClassRoleReadFound(String o) {
    this.classRoleReadFound = ComputateJavaClass.staticSetClassRoleReadFound(siteRequest_, o);
  }
  public static Boolean staticSetClassRoleReadFound(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classRoleReadFoundInit() {
    Wrap<Boolean> classRoleReadFoundWrap = new Wrap<Boolean>().var("classRoleReadFound");
    if(classRoleReadFound == null) {
      _classRoleReadFound(classRoleReadFoundWrap);
      Optional.ofNullable(classRoleReadFoundWrap.getO()).ifPresent(o -> {
        setClassRoleReadFound(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassRoleReadFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassRoleReadFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassRoleReadFound(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassRoleReadFound(siteRequest_, ComputateJavaClass.staticSetClassRoleReadFound(siteRequest_, o)).toString();
  }

	///////////////////////
  // classSessionWrite //
	///////////////////////


  /**
   *  The entity classSessionWrite
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classSessionWrite;

  /**
   * <br> The entity classSessionWrite
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSessionWrite">Find the entity classSessionWrite in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSessionWrite(Wrap<Boolean> w);

  public Boolean getClassSessionWrite() {
    return classSessionWrite;
  }

  public void setClassSessionWrite(Boolean classSessionWrite) {
    this.classSessionWrite = classSessionWrite;
  }
  @JsonIgnore
  public void setClassSessionWrite(String o) {
    this.classSessionWrite = ComputateJavaClass.staticSetClassSessionWrite(siteRequest_, o);
  }
  public static Boolean staticSetClassSessionWrite(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classSessionWriteInit() {
    Wrap<Boolean> classSessionWriteWrap = new Wrap<Boolean>().var("classSessionWrite");
    if(classSessionWrite == null) {
      _classSessionWrite(classSessionWriteWrap);
      Optional.ofNullable(classSessionWriteWrap.getO()).ifPresent(o -> {
        setClassSessionWrite(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassSessionWrite(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassSessionWrite(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSessionWrite(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSessionWrite(siteRequest_, ComputateJavaClass.staticSetClassSessionWrite(siteRequest_, o)).toString();
  }

	////////////////////
  // classUserWrite //
	////////////////////


  /**
   *  The entity classUserWrite
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classUserWrite;

  /**
   * <br> The entity classUserWrite
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classUserWrite">Find the entity classUserWrite in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classUserWrite(Wrap<Boolean> w);

  public Boolean getClassUserWrite() {
    return classUserWrite;
  }

  public void setClassUserWrite(Boolean classUserWrite) {
    this.classUserWrite = classUserWrite;
  }
  @JsonIgnore
  public void setClassUserWrite(String o) {
    this.classUserWrite = ComputateJavaClass.staticSetClassUserWrite(siteRequest_, o);
  }
  public static Boolean staticSetClassUserWrite(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classUserWriteInit() {
    Wrap<Boolean> classUserWriteWrap = new Wrap<Boolean>().var("classUserWrite");
    if(classUserWrite == null) {
      _classUserWrite(classUserWriteWrap);
      Optional.ofNullable(classUserWriteWrap.getO()).ifPresent(o -> {
        setClassUserWrite(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassUserWrite(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassUserWrite(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassUserWrite(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassUserWrite(siteRequest_, ComputateJavaClass.staticSetClassUserWrite(siteRequest_, o)).toString();
  }

	//////////////////////
  // classPublicWrite //
	//////////////////////


  /**
   *  The entity classPublicWrite
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classPublicWrite;

  /**
   * <br> The entity classPublicWrite
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPublicWrite">Find the entity classPublicWrite in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPublicWrite(Wrap<Boolean> w);

  public Boolean getClassPublicWrite() {
    return classPublicWrite;
  }

  public void setClassPublicWrite(Boolean classPublicWrite) {
    this.classPublicWrite = classPublicWrite;
  }
  @JsonIgnore
  public void setClassPublicWrite(String o) {
    this.classPublicWrite = ComputateJavaClass.staticSetClassPublicWrite(siteRequest_, o);
  }
  public static Boolean staticSetClassPublicWrite(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classPublicWriteInit() {
    Wrap<Boolean> classPublicWriteWrap = new Wrap<Boolean>().var("classPublicWrite");
    if(classPublicWrite == null) {
      _classPublicWrite(classPublicWriteWrap);
      Optional.ofNullable(classPublicWriteWrap.getO()).ifPresent(o -> {
        setClassPublicWrite(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassPublicWrite(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassPublicWrite(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPublicWrite(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPublicWrite(siteRequest_, ComputateJavaClass.staticSetClassPublicWrite(siteRequest_, o)).toString();
  }

	//////////////////////
  // classSessionRead //
	//////////////////////


  /**
   *  The entity classSessionRead
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classSessionRead;

  /**
   * <br> The entity classSessionRead
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSessionRead">Find the entity classSessionRead in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSessionRead(Wrap<Boolean> w);

  public Boolean getClassSessionRead() {
    return classSessionRead;
  }

  public void setClassSessionRead(Boolean classSessionRead) {
    this.classSessionRead = classSessionRead;
  }
  @JsonIgnore
  public void setClassSessionRead(String o) {
    this.classSessionRead = ComputateJavaClass.staticSetClassSessionRead(siteRequest_, o);
  }
  public static Boolean staticSetClassSessionRead(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classSessionReadInit() {
    Wrap<Boolean> classSessionReadWrap = new Wrap<Boolean>().var("classSessionRead");
    if(classSessionRead == null) {
      _classSessionRead(classSessionReadWrap);
      Optional.ofNullable(classSessionReadWrap.getO()).ifPresent(o -> {
        setClassSessionRead(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassSessionRead(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassSessionRead(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSessionRead(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSessionRead(siteRequest_, ComputateJavaClass.staticSetClassSessionRead(siteRequest_, o)).toString();
  }

	///////////////////
  // classUserRead //
	///////////////////


  /**
   *  The entity classUserRead
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classUserRead;

  /**
   * <br> The entity classUserRead
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classUserRead">Find the entity classUserRead in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classUserRead(Wrap<Boolean> w);

  public Boolean getClassUserRead() {
    return classUserRead;
  }

  public void setClassUserRead(Boolean classUserRead) {
    this.classUserRead = classUserRead;
  }
  @JsonIgnore
  public void setClassUserRead(String o) {
    this.classUserRead = ComputateJavaClass.staticSetClassUserRead(siteRequest_, o);
  }
  public static Boolean staticSetClassUserRead(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classUserReadInit() {
    Wrap<Boolean> classUserReadWrap = new Wrap<Boolean>().var("classUserRead");
    if(classUserRead == null) {
      _classUserRead(classUserReadWrap);
      Optional.ofNullable(classUserReadWrap.getO()).ifPresent(o -> {
        setClassUserRead(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassUserRead(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassUserRead(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassUserRead(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassUserRead(siteRequest_, ComputateJavaClass.staticSetClassUserRead(siteRequest_, o)).toString();
  }

	///////////////////////
  // classFiltersFound //
	///////////////////////


  /**
   *  The entity classFiltersFound
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classFiltersFound;

  /**
   * <br> The entity classFiltersFound
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classFiltersFound">Find the entity classFiltersFound in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classFiltersFound(Wrap<Boolean> w);

  public Boolean getClassFiltersFound() {
    return classFiltersFound;
  }

  public void setClassFiltersFound(Boolean classFiltersFound) {
    this.classFiltersFound = classFiltersFound;
  }
  @JsonIgnore
  public void setClassFiltersFound(String o) {
    this.classFiltersFound = ComputateJavaClass.staticSetClassFiltersFound(siteRequest_, o);
  }
  public static Boolean staticSetClassFiltersFound(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classFiltersFoundInit() {
    Wrap<Boolean> classFiltersFoundWrap = new Wrap<Boolean>().var("classFiltersFound");
    if(classFiltersFound == null) {
      _classFiltersFound(classFiltersFoundWrap);
      Optional.ofNullable(classFiltersFoundWrap.getO()).ifPresent(o -> {
        setClassFiltersFound(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassFiltersFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassFiltersFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassFiltersFound(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassFiltersFound(siteRequest_, ComputateJavaClass.staticSetClassFiltersFound(siteRequest_, o)).toString();
  }

	/////////////
  // sqlSort //
	/////////////


  /**
   *  The entity sqlSort
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer sqlSort;

  /**
   * <br> The entity sqlSort
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:sqlSort">Find the entity sqlSort in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _sqlSort(Wrap<Integer> w);

  public Integer getSqlSort() {
    return sqlSort;
  }

  public void setSqlSort(Integer sqlSort) {
    this.sqlSort = sqlSort;
  }
  @JsonIgnore
  public void setSqlSort(String o) {
    this.sqlSort = ComputateJavaClass.staticSetSqlSort(siteRequest_, o);
  }
  public static Integer staticSetSqlSort(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected ComputateJavaClass sqlSortInit() {
    Wrap<Integer> sqlSortWrap = new Wrap<Integer>().var("sqlSort");
    if(sqlSort == null) {
      _sqlSort(sqlSortWrap);
      Optional.ofNullable(sqlSortWrap.getO()).ifPresent(o -> {
        setSqlSort(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Integer staticSearchSqlSort(ComputateSiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrSqlSort(ComputateSiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqSqlSort(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchSqlSort(siteRequest_, ComputateJavaClass.staticSetSqlSort(siteRequest_, o)).toString();
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
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _id(Wrap<String> w);

  public String getId() {
    return id;
  }
  public void setId(String o) {
    this.id = ComputateJavaClass.staticSetId(siteRequest_, o);
  }
  public static String staticSetId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass idInit() {
    Wrap<String> idWrap = new Wrap<String>().var("id");
    if(id == null) {
      _id(idWrap);
      Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
        setId(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqId(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchId(siteRequest_, ComputateJavaClass.staticSetId(siteRequest_, o)).toString();
  }

  public String sqlId() {
    return id;
  }

	/////////////////
  // partIsClass //
	/////////////////


  /**
   *  The entity partIsClass
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean partIsClass;

  /**
   * <br> The entity partIsClass
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:partIsClass">Find the entity partIsClass in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _partIsClass(Wrap<Boolean> w);

  public Boolean getPartIsClass() {
    return partIsClass;
  }

  public void setPartIsClass(Boolean partIsClass) {
    this.partIsClass = partIsClass;
  }
  @JsonIgnore
  public void setPartIsClass(String o) {
    this.partIsClass = ComputateJavaClass.staticSetPartIsClass(siteRequest_, o);
  }
  public static Boolean staticSetPartIsClass(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass partIsClassInit() {
    Wrap<Boolean> partIsClassWrap = new Wrap<Boolean>().var("partIsClass");
    if(partIsClass == null) {
      _partIsClass(partIsClassWrap);
      Optional.ofNullable(partIsClassWrap.getO()).ifPresent(o -> {
        setPartIsClass(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchPartIsClass(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrPartIsClass(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPartIsClass(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchPartIsClass(siteRequest_, ComputateJavaClass.staticSetPartIsClass(siteRequest_, o)).toString();
  }

	////////////////
  // partNumber //
	////////////////


  /**
   *  The entity partNumber
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer partNumber;

  /**
   * <br> The entity partNumber
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:partNumber">Find the entity partNumber in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _partNumber(Wrap<Integer> w);

  public Integer getPartNumber() {
    return partNumber;
  }

  public void setPartNumber(Integer partNumber) {
    this.partNumber = partNumber;
  }
  @JsonIgnore
  public void setPartNumber(String o) {
    this.partNumber = ComputateJavaClass.staticSetPartNumber(siteRequest_, o);
  }
  public static Integer staticSetPartNumber(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected ComputateJavaClass partNumberInit() {
    Wrap<Integer> partNumberWrap = new Wrap<Integer>().var("partNumber");
    if(partNumber == null) {
      _partNumber(partNumberWrap);
      Optional.ofNullable(partNumberWrap.getO()).ifPresent(o -> {
        setPartNumber(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Integer staticSearchPartNumber(ComputateSiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrPartNumber(ComputateSiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqPartNumber(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchPartNumber(siteRequest_, ComputateJavaClass.staticSetPartNumber(siteRequest_, o)).toString();
  }

	//////////////////
  // classImports //
	//////////////////


  /**
   *  The entity classImports
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classImports;

  /**
   * <br> The entity classImports
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classImports">Find the entity classImports in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classImports(Wrap<List<String>> w);

  public List<String> getClassImports() {
    return classImports;
  }

  public void setClassImports(List<String> classImports) {
    this.classImports = classImports;
  }
  @JsonIgnore
  public void setClassImports(String o) {
    String l = ComputateJavaClass.staticSetClassImports(siteRequest_, o);
    if(l != null)
      addClassImports(l);
  }
  public static String staticSetClassImports(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassImports(String...objects) {
    for(String o : objects) {
      addClassImports(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassImports(String o) {
    if(o != null)
      this.classImports.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassImports(JsonArray objects) {
    classImports.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassImports(o);
    }
  }
  protected ComputateJavaClass classImportsInit() {
    Wrap<List<String>> classImportsWrap = new Wrap<List<String>>().var("classImports");
    if(classImports == null) {
      _classImports(classImportsWrap);
      Optional.ofNullable(classImportsWrap.getO()).ifPresent(o -> {
        setClassImports(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassImports(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassImports(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassImports(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassImports(siteRequest_, ComputateJavaClass.staticSetClassImports(siteRequest_, o)).toString();
  }

	/////////////////////
  // classEntityVars //
	/////////////////////


  /**
   *  The entity classEntityVars
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classEntityVars;

  /**
   * <br> The entity classEntityVars
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classEntityVars">Find the entity classEntityVars in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classEntityVars(Wrap<List<String>> w);

  public List<String> getClassEntityVars() {
    return classEntityVars;
  }

  public void setClassEntityVars(List<String> classEntityVars) {
    this.classEntityVars = classEntityVars;
  }
  @JsonIgnore
  public void setClassEntityVars(String o) {
    String l = ComputateJavaClass.staticSetClassEntityVars(siteRequest_, o);
    if(l != null)
      addClassEntityVars(l);
  }
  public static String staticSetClassEntityVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassEntityVars(String...objects) {
    for(String o : objects) {
      addClassEntityVars(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassEntityVars(String o) {
    if(o != null)
      this.classEntityVars.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassEntityVars(JsonArray objects) {
    classEntityVars.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassEntityVars(o);
    }
  }
  protected ComputateJavaClass classEntityVarsInit() {
    Wrap<List<String>> classEntityVarsWrap = new Wrap<List<String>>().var("classEntityVars");
    if(classEntityVars == null) {
      _classEntityVars(classEntityVarsWrap);
      Optional.ofNullable(classEntityVarsWrap.getO()).ifPresent(o -> {
        setClassEntityVars(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassEntityVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassEntityVars(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassEntityVars(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassEntityVars(siteRequest_, ComputateJavaClass.staticSetClassEntityVars(siteRequest_, o)).toString();
  }

	////////////////////////
  // classImportsGenApi //
	////////////////////////


  /**
   *  The entity classImportsGenApi
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classImportsGenApi;

  /**
   * <br> The entity classImportsGenApi
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classImportsGenApi">Find the entity classImportsGenApi in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classImportsGenApi(Wrap<List<String>> w);

  public List<String> getClassImportsGenApi() {
    return classImportsGenApi;
  }

  public void setClassImportsGenApi(List<String> classImportsGenApi) {
    this.classImportsGenApi = classImportsGenApi;
  }
  @JsonIgnore
  public void setClassImportsGenApi(String o) {
    String l = ComputateJavaClass.staticSetClassImportsGenApi(siteRequest_, o);
    if(l != null)
      addClassImportsGenApi(l);
  }
  public static String staticSetClassImportsGenApi(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassImportsGenApi(String...objects) {
    for(String o : objects) {
      addClassImportsGenApi(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassImportsGenApi(String o) {
    if(o != null)
      this.classImportsGenApi.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassImportsGenApi(JsonArray objects) {
    classImportsGenApi.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassImportsGenApi(o);
    }
  }
  protected ComputateJavaClass classImportsGenApiInit() {
    Wrap<List<String>> classImportsGenApiWrap = new Wrap<List<String>>().var("classImportsGenApi");
    if(classImportsGenApi == null) {
      _classImportsGenApi(classImportsGenApiWrap);
      Optional.ofNullable(classImportsGenApiWrap.getO()).ifPresent(o -> {
        setClassImportsGenApi(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassImportsGenApi(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassImportsGenApi(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassImportsGenApi(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassImportsGenApi(siteRequest_, ComputateJavaClass.staticSetClassImportsGenApi(siteRequest_, o)).toString();
  }

	///////////////////////////////////
  // classAttributeSimpleNamePages //
	///////////////////////////////////


  /**
   *  The entity classAttributeSimpleNamePages
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classAttributeSimpleNamePages;

  /**
   * <br> The entity classAttributeSimpleNamePages
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classAttributeSimpleNamePages">Find the entity classAttributeSimpleNamePages in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classAttributeSimpleNamePages(Wrap<List<String>> w);

  public List<String> getClassAttributeSimpleNamePages() {
    return classAttributeSimpleNamePages;
  }

  public void setClassAttributeSimpleNamePages(List<String> classAttributeSimpleNamePages) {
    this.classAttributeSimpleNamePages = classAttributeSimpleNamePages;
  }
  @JsonIgnore
  public void setClassAttributeSimpleNamePages(String o) {
    String l = ComputateJavaClass.staticSetClassAttributeSimpleNamePages(siteRequest_, o);
    if(l != null)
      addClassAttributeSimpleNamePages(l);
  }
  public static String staticSetClassAttributeSimpleNamePages(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassAttributeSimpleNamePages(String...objects) {
    for(String o : objects) {
      addClassAttributeSimpleNamePages(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassAttributeSimpleNamePages(String o) {
    if(o != null)
      this.classAttributeSimpleNamePages.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassAttributeSimpleNamePages(JsonArray objects) {
    classAttributeSimpleNamePages.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassAttributeSimpleNamePages(o);
    }
  }
  protected ComputateJavaClass classAttributeSimpleNamePagesInit() {
    Wrap<List<String>> classAttributeSimpleNamePagesWrap = new Wrap<List<String>>().var("classAttributeSimpleNamePages");
    if(classAttributeSimpleNamePages == null) {
      _classAttributeSimpleNamePages(classAttributeSimpleNamePagesWrap);
      Optional.ofNullable(classAttributeSimpleNamePagesWrap.getO()).ifPresent(o -> {
        setClassAttributeSimpleNamePages(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassAttributeSimpleNamePages(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassAttributeSimpleNamePages(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassAttributeSimpleNamePages(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassAttributeSimpleNamePages(siteRequest_, ComputateJavaClass.staticSetClassAttributeSimpleNamePages(siteRequest_, o)).toString();
  }

	/////////////////////
  // classMethodVars //
	/////////////////////


  /**
   *  The entity classMethodVars
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classMethodVars;

  /**
   * <br> The entity classMethodVars
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classMethodVars">Find the entity classMethodVars in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classMethodVars(Wrap<List<String>> w);

  public List<String> getClassMethodVars() {
    return classMethodVars;
  }

  public void setClassMethodVars(List<String> classMethodVars) {
    this.classMethodVars = classMethodVars;
  }
  @JsonIgnore
  public void setClassMethodVars(String o) {
    String l = ComputateJavaClass.staticSetClassMethodVars(siteRequest_, o);
    if(l != null)
      addClassMethodVars(l);
  }
  public static String staticSetClassMethodVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassMethodVars(String...objects) {
    for(String o : objects) {
      addClassMethodVars(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassMethodVars(String o) {
    if(o != null)
      this.classMethodVars.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassMethodVars(JsonArray objects) {
    classMethodVars.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassMethodVars(o);
    }
  }
  protected ComputateJavaClass classMethodVarsInit() {
    Wrap<List<String>> classMethodVarsWrap = new Wrap<List<String>>().var("classMethodVars");
    if(classMethodVars == null) {
      _classMethodVars(classMethodVarsWrap);
      Optional.ofNullable(classMethodVarsWrap.getO()).ifPresent(o -> {
        setClassMethodVars(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassMethodVars(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassMethodVars(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassMethodVars(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassMethodVars(siteRequest_, ComputateJavaClass.staticSetClassMethodVars(siteRequest_, o)).toString();
  }

	///////////////////////
  // classVarSuggested //
	///////////////////////


  /**
   *  The entity classVarSuggested
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarSuggested;

  /**
   * <br> The entity classVarSuggested
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarSuggested">Find the entity classVarSuggested in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarSuggested(Wrap<String> w);

  public String getClassVarSuggested() {
    return classVarSuggested;
  }
  public void setClassVarSuggested(String o) {
    this.classVarSuggested = ComputateJavaClass.staticSetClassVarSuggested(siteRequest_, o);
  }
  public static String staticSetClassVarSuggested(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarSuggestedInit() {
    Wrap<String> classVarSuggestedWrap = new Wrap<String>().var("classVarSuggested");
    if(classVarSuggested == null) {
      _classVarSuggested(classVarSuggestedWrap);
      Optional.ofNullable(classVarSuggestedWrap.getO()).ifPresent(o -> {
        setClassVarSuggested(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarSuggested(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarSuggested(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarSuggested(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarSuggested(siteRequest_, ComputateJavaClass.staticSetClassVarSuggested(siteRequest_, o)).toString();
  }

	//////////////////
  // classVarText //
	//////////////////


  /**
   *  The entity classVarText
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarText;

  /**
   * <br> The entity classVarText
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarText">Find the entity classVarText in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarText(Wrap<String> w);

  public String getClassVarText() {
    return classVarText;
  }
  public void setClassVarText(String o) {
    this.classVarText = ComputateJavaClass.staticSetClassVarText(siteRequest_, o);
  }
  public static String staticSetClassVarText(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarTextInit() {
    Wrap<String> classVarTextWrap = new Wrap<String>().var("classVarText");
    if(classVarText == null) {
      _classVarText(classVarTextWrap);
      Optional.ofNullable(classVarTextWrap.getO()).ifPresent(o -> {
        setClassVarText(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarText(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarText(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarText(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarText(siteRequest_, ComputateJavaClass.staticSetClassVarText(siteRequest_, o)).toString();
  }

	////////////////////////
  // classVarPrimaryKey //
	////////////////////////


  /**
   *  The entity classVarPrimaryKey
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarPrimaryKey;

  /**
   * <br> The entity classVarPrimaryKey
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarPrimaryKey">Find the entity classVarPrimaryKey in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarPrimaryKey(Wrap<String> w);

  public String getClassVarPrimaryKey() {
    return classVarPrimaryKey;
  }
  public void setClassVarPrimaryKey(String o) {
    this.classVarPrimaryKey = ComputateJavaClass.staticSetClassVarPrimaryKey(siteRequest_, o);
  }
  public static String staticSetClassVarPrimaryKey(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarPrimaryKeyInit() {
    Wrap<String> classVarPrimaryKeyWrap = new Wrap<String>().var("classVarPrimaryKey");
    if(classVarPrimaryKey == null) {
      _classVarPrimaryKey(classVarPrimaryKeyWrap);
      Optional.ofNullable(classVarPrimaryKeyWrap.getO()).ifPresent(o -> {
        setClassVarPrimaryKey(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarPrimaryKey(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarPrimaryKey(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarPrimaryKey(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarPrimaryKey(siteRequest_, ComputateJavaClass.staticSetClassVarPrimaryKey(siteRequest_, o)).toString();
  }

	///////////////////////////////
  // classVarInheritPrimaryKey //
	///////////////////////////////


  /**
   *  The entity classVarInheritPrimaryKey
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarInheritPrimaryKey;

  /**
   * <br> The entity classVarInheritPrimaryKey
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarInheritPrimaryKey">Find the entity classVarInheritPrimaryKey in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarInheritPrimaryKey(Wrap<String> w);

  public String getClassVarInheritPrimaryKey() {
    return classVarInheritPrimaryKey;
  }
  public void setClassVarInheritPrimaryKey(String o) {
    this.classVarInheritPrimaryKey = ComputateJavaClass.staticSetClassVarInheritPrimaryKey(siteRequest_, o);
  }
  public static String staticSetClassVarInheritPrimaryKey(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarInheritPrimaryKeyInit() {
    Wrap<String> classVarInheritPrimaryKeyWrap = new Wrap<String>().var("classVarInheritPrimaryKey");
    if(classVarInheritPrimaryKey == null) {
      _classVarInheritPrimaryKey(classVarInheritPrimaryKeyWrap);
      Optional.ofNullable(classVarInheritPrimaryKeyWrap.getO()).ifPresent(o -> {
        setClassVarInheritPrimaryKey(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarInheritPrimaryKey(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarInheritPrimaryKey(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarInheritPrimaryKey(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarInheritPrimaryKey(siteRequest_, ComputateJavaClass.staticSetClassVarInheritPrimaryKey(siteRequest_, o)).toString();
  }

	///////////////////
  // classVarSaves //
	///////////////////


  /**
   *  The entity classVarSaves
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarSaves;

  /**
   * <br> The entity classVarSaves
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarSaves">Find the entity classVarSaves in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarSaves(Wrap<String> w);

  public String getClassVarSaves() {
    return classVarSaves;
  }
  public void setClassVarSaves(String o) {
    this.classVarSaves = ComputateJavaClass.staticSetClassVarSaves(siteRequest_, o);
  }
  public static String staticSetClassVarSaves(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarSavesInit() {
    Wrap<String> classVarSavesWrap = new Wrap<String>().var("classVarSaves");
    if(classVarSaves == null) {
      _classVarSaves(classVarSavesWrap);
      Optional.ofNullable(classVarSavesWrap.getO()).ifPresent(o -> {
        setClassVarSaves(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarSaves(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarSaves(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarSaves(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarSaves(siteRequest_, ComputateJavaClass.staticSetClassVarSaves(siteRequest_, o)).toString();
  }

	///////////////////////
  // classvarUniqueKey //
	///////////////////////


  /**
   *  The entity classvarUniqueKey
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classvarUniqueKey;

  /**
   * <br> The entity classvarUniqueKey
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classvarUniqueKey">Find the entity classvarUniqueKey in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classvarUniqueKey(Wrap<String> w);

  public String getClassvarUniqueKey() {
    return classvarUniqueKey;
  }
  public void setClassvarUniqueKey(String o) {
    this.classvarUniqueKey = ComputateJavaClass.staticSetClassvarUniqueKey(siteRequest_, o);
  }
  public static String staticSetClassvarUniqueKey(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classvarUniqueKeyInit() {
    Wrap<String> classvarUniqueKeyWrap = new Wrap<String>().var("classvarUniqueKey");
    if(classvarUniqueKey == null) {
      _classvarUniqueKey(classvarUniqueKeyWrap);
      Optional.ofNullable(classvarUniqueKeyWrap.getO()).ifPresent(o -> {
        setClassvarUniqueKey(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassvarUniqueKey(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassvarUniqueKey(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassvarUniqueKey(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassvarUniqueKey(siteRequest_, ComputateJavaClass.staticSetClassvarUniqueKey(siteRequest_, o)).toString();
  }

	//////////////////////
  // classVarModified //
	//////////////////////


  /**
   *  The entity classVarModified
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarModified;

  /**
   * <br> The entity classVarModified
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarModified">Find the entity classVarModified in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarModified(Wrap<String> w);

  public String getClassVarModified() {
    return classVarModified;
  }
  public void setClassVarModified(String o) {
    this.classVarModified = ComputateJavaClass.staticSetClassVarModified(siteRequest_, o);
  }
  public static String staticSetClassVarModified(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarModifiedInit() {
    Wrap<String> classVarModifiedWrap = new Wrap<String>().var("classVarModified");
    if(classVarModified == null) {
      _classVarModified(classVarModifiedWrap);
      Optional.ofNullable(classVarModifiedWrap.getO()).ifPresent(o -> {
        setClassVarModified(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarModified(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarModified(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarModified(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarModified(siteRequest_, ComputateJavaClass.staticSetClassVarModified(siteRequest_, o)).toString();
  }

	/////////////////////
  // classVarCreated //
	/////////////////////


  /**
   *  The entity classVarCreated
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarCreated;

  /**
   * <br> The entity classVarCreated
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarCreated">Find the entity classVarCreated in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarCreated(Wrap<String> w);

  public String getClassVarCreated() {
    return classVarCreated;
  }
  public void setClassVarCreated(String o) {
    this.classVarCreated = ComputateJavaClass.staticSetClassVarCreated(siteRequest_, o);
  }
  public static String staticSetClassVarCreated(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarCreatedInit() {
    Wrap<String> classVarCreatedWrap = new Wrap<String>().var("classVarCreated");
    if(classVarCreated == null) {
      _classVarCreated(classVarCreatedWrap);
      Optional.ofNullable(classVarCreatedWrap.getO()).ifPresent(o -> {
        setClassVarCreated(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarCreated(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarCreated(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarCreated(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarCreated(siteRequest_, ComputateJavaClass.staticSetClassVarCreated(siteRequest_, o)).toString();
  }

	///////////////////
  // classVarUrlId //
	///////////////////


  /**
   *  The entity classVarUrlId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarUrlId;

  /**
   * <br> The entity classVarUrlId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarUrlId">Find the entity classVarUrlId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarUrlId(Wrap<String> w);

  public String getClassVarUrlId() {
    return classVarUrlId;
  }
  public void setClassVarUrlId(String o) {
    this.classVarUrlId = ComputateJavaClass.staticSetClassVarUrlId(siteRequest_, o);
  }
  public static String staticSetClassVarUrlId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarUrlIdInit() {
    Wrap<String> classVarUrlIdWrap = new Wrap<String>().var("classVarUrlId");
    if(classVarUrlId == null) {
      _classVarUrlId(classVarUrlIdWrap);
      Optional.ofNullable(classVarUrlIdWrap.getO()).ifPresent(o -> {
        setClassVarUrlId(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarUrlId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarUrlId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarUrlId(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarUrlId(siteRequest_, ComputateJavaClass.staticSetClassVarUrlId(siteRequest_, o)).toString();
  }

	///////////////////
  // classVarUrlPk //
	///////////////////


  /**
   *  The entity classVarUrlPk
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarUrlPk;

  /**
   * <br> The entity classVarUrlPk
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarUrlPk">Find the entity classVarUrlPk in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarUrlPk(Wrap<String> w);

  public String getClassVarUrlPk() {
    return classVarUrlPk;
  }
  public void setClassVarUrlPk(String o) {
    this.classVarUrlPk = ComputateJavaClass.staticSetClassVarUrlPk(siteRequest_, o);
  }
  public static String staticSetClassVarUrlPk(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarUrlPkInit() {
    Wrap<String> classVarUrlPkWrap = new Wrap<String>().var("classVarUrlPk");
    if(classVarUrlPk == null) {
      _classVarUrlPk(classVarUrlPkWrap);
      Optional.ofNullable(classVarUrlPkWrap.getO()).ifPresent(o -> {
        setClassVarUrlPk(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarUrlPk(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarUrlPk(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarUrlPk(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarUrlPk(siteRequest_, ComputateJavaClass.staticSetClassVarUrlPk(siteRequest_, o)).toString();
  }

	////////////////
  // classVarId //
	////////////////


  /**
   *  The entity classVarId
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarId;

  /**
   * <br> The entity classVarId
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarId">Find the entity classVarId in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarId(Wrap<String> w);

  public String getClassVarId() {
    return classVarId;
  }
  public void setClassVarId(String o) {
    this.classVarId = ComputateJavaClass.staticSetClassVarId(siteRequest_, o);
  }
  public static String staticSetClassVarId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarIdInit() {
    Wrap<String> classVarIdWrap = new Wrap<String>().var("classVarId");
    if(classVarId == null) {
      _classVarId(classVarIdWrap);
      Optional.ofNullable(classVarIdWrap.getO()).ifPresent(o -> {
        setClassVarId(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarId(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarId(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarId(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarId(siteRequest_, ComputateJavaClass.staticSetClassVarId(siteRequest_, o)).toString();
  }

	///////////////////
  // classVarTitle //
	///////////////////


  /**
   *  The entity classVarTitle
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classVarTitle;

  /**
   * <br> The entity classVarTitle
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classVarTitle">Find the entity classVarTitle in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classVarTitle(Wrap<String> w);

  public String getClassVarTitle() {
    return classVarTitle;
  }
  public void setClassVarTitle(String o) {
    this.classVarTitle = ComputateJavaClass.staticSetClassVarTitle(siteRequest_, o);
  }
  public static String staticSetClassVarTitle(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classVarTitleInit() {
    Wrap<String> classVarTitleWrap = new Wrap<String>().var("classVarTitle");
    if(classVarTitle == null) {
      _classVarTitle(classVarTitleWrap);
      Optional.ofNullable(classVarTitleWrap.getO()).ifPresent(o -> {
        setClassVarTitle(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassVarTitle(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassVarTitle(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassVarTitle(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassVarTitle(siteRequest_, ComputateJavaClass.staticSetClassVarTitle(siteRequest_, o)).toString();
  }

	////////////////////////
  // classKeywordsFound //
	////////////////////////


  /**
   *  The entity classKeywordsFound
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classKeywordsFound;

  /**
   * <br> The entity classKeywordsFound
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classKeywordsFound">Find the entity classKeywordsFound in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classKeywordsFound(Wrap<Boolean> w);

  public Boolean getClassKeywordsFound() {
    return classKeywordsFound;
  }

  public void setClassKeywordsFound(Boolean classKeywordsFound) {
    this.classKeywordsFound = classKeywordsFound;
  }
  @JsonIgnore
  public void setClassKeywordsFound(String o) {
    this.classKeywordsFound = ComputateJavaClass.staticSetClassKeywordsFound(siteRequest_, o);
  }
  public static Boolean staticSetClassKeywordsFound(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classKeywordsFoundInit() {
    Wrap<Boolean> classKeywordsFoundWrap = new Wrap<Boolean>().var("classKeywordsFound");
    if(classKeywordsFound == null) {
      _classKeywordsFound(classKeywordsFoundWrap);
      Optional.ofNullable(classKeywordsFoundWrap.getO()).ifPresent(o -> {
        setClassKeywordsFound(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassKeywordsFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassKeywordsFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassKeywordsFound(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassKeywordsFound(siteRequest_, ComputateJavaClass.staticSetClassKeywordsFound(siteRequest_, o)).toString();
  }

	////////////////////////////
  // classPageCanonicalName //
	////////////////////////////


  /**
   *  The entity classPageCanonicalName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPageCanonicalName;

  /**
   * <br> The entity classPageCanonicalName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPageCanonicalName">Find the entity classPageCanonicalName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPageCanonicalName(Wrap<String> w);

  public String getClassPageCanonicalName() {
    return classPageCanonicalName;
  }
  public void setClassPageCanonicalName(String o) {
    this.classPageCanonicalName = ComputateJavaClass.staticSetClassPageCanonicalName(siteRequest_, o);
  }
  public static String staticSetClassPageCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPageCanonicalNameInit() {
    Wrap<String> classPageCanonicalNameWrap = new Wrap<String>().var("classPageCanonicalName");
    if(classPageCanonicalName == null) {
      _classPageCanonicalName(classPageCanonicalNameWrap);
      Optional.ofNullable(classPageCanonicalNameWrap.getO()).ifPresent(o -> {
        setClassPageCanonicalName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPageCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPageCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPageCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPageCanonicalName(siteRequest_, ComputateJavaClass.staticSetClassPageCanonicalName(siteRequest_, o)).toString();
  }

	/////////////////////////
  // classPageSimpleName //
	/////////////////////////


  /**
   *  The entity classPageSimpleName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPageSimpleName;

  /**
   * <br> The entity classPageSimpleName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPageSimpleName">Find the entity classPageSimpleName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPageSimpleName(Wrap<String> w);

  public String getClassPageSimpleName() {
    return classPageSimpleName;
  }
  public void setClassPageSimpleName(String o) {
    this.classPageSimpleName = ComputateJavaClass.staticSetClassPageSimpleName(siteRequest_, o);
  }
  public static String staticSetClassPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPageSimpleNameInit() {
    Wrap<String> classPageSimpleNameWrap = new Wrap<String>().var("classPageSimpleName");
    if(classPageSimpleName == null) {
      _classPageSimpleName(classPageSimpleNameWrap);
      Optional.ofNullable(classPageSimpleNameWrap.getO()).ifPresent(o -> {
        setClassPageSimpleName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPageSimpleName(siteRequest_, ComputateJavaClass.staticSetClassPageSimpleName(siteRequest_, o)).toString();
  }

	////////////////////////////
  // classGenPageSimpleName //
	////////////////////////////


  /**
   *  The entity classGenPageSimpleName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classGenPageSimpleName;

  /**
   * <br> The entity classGenPageSimpleName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classGenPageSimpleName">Find the entity classGenPageSimpleName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classGenPageSimpleName(Wrap<String> w);

  public String getClassGenPageSimpleName() {
    return classGenPageSimpleName;
  }
  public void setClassGenPageSimpleName(String o) {
    this.classGenPageSimpleName = ComputateJavaClass.staticSetClassGenPageSimpleName(siteRequest_, o);
  }
  public static String staticSetClassGenPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classGenPageSimpleNameInit() {
    Wrap<String> classGenPageSimpleNameWrap = new Wrap<String>().var("classGenPageSimpleName");
    if(classGenPageSimpleName == null) {
      _classGenPageSimpleName(classGenPageSimpleNameWrap);
      Optional.ofNullable(classGenPageSimpleNameWrap.getO()).ifPresent(o -> {
        setClassGenPageSimpleName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassGenPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassGenPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassGenPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassGenPageSimpleName(siteRequest_, ComputateJavaClass.staticSetClassGenPageSimpleName(siteRequest_, o)).toString();
  }

	///////////////////////////////
  // classGenPageCanonicalName //
	///////////////////////////////


  /**
   *  The entity classGenPageCanonicalName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classGenPageCanonicalName;

  /**
   * <br> The entity classGenPageCanonicalName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classGenPageCanonicalName">Find the entity classGenPageCanonicalName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classGenPageCanonicalName(Wrap<String> w);

  public String getClassGenPageCanonicalName() {
    return classGenPageCanonicalName;
  }
  public void setClassGenPageCanonicalName(String o) {
    this.classGenPageCanonicalName = ComputateJavaClass.staticSetClassGenPageCanonicalName(siteRequest_, o);
  }
  public static String staticSetClassGenPageCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classGenPageCanonicalNameInit() {
    Wrap<String> classGenPageCanonicalNameWrap = new Wrap<String>().var("classGenPageCanonicalName");
    if(classGenPageCanonicalName == null) {
      _classGenPageCanonicalName(classGenPageCanonicalNameWrap);
      Optional.ofNullable(classGenPageCanonicalNameWrap.getO()).ifPresent(o -> {
        setClassGenPageCanonicalName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassGenPageCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassGenPageCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassGenPageCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassGenPageCanonicalName(siteRequest_, ComputateJavaClass.staticSetClassGenPageCanonicalName(siteRequest_, o)).toString();
  }

	//////////////////////
  // classGenPagePath //
	//////////////////////


  /**
   *  The entity classGenPagePath
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classGenPagePath;

  /**
   * <br> The entity classGenPagePath
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classGenPagePath">Find the entity classGenPagePath in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classGenPagePath(Wrap<String> w);

  public String getClassGenPagePath() {
    return classGenPagePath;
  }
  public void setClassGenPagePath(String o) {
    this.classGenPagePath = ComputateJavaClass.staticSetClassGenPagePath(siteRequest_, o);
  }
  public static String staticSetClassGenPagePath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classGenPagePathInit() {
    Wrap<String> classGenPagePathWrap = new Wrap<String>().var("classGenPagePath");
    if(classGenPagePath == null) {
      _classGenPagePath(classGenPagePathWrap);
      Optional.ofNullable(classGenPagePathWrap.getO()).ifPresent(o -> {
        setClassGenPagePath(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassGenPagePath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassGenPagePath(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassGenPagePath(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassGenPagePath(siteRequest_, ComputateJavaClass.staticSetClassGenPagePath(siteRequest_, o)).toString();
  }

	///////////////////
  // classPagePath //
	///////////////////


  /**
   *  The entity classPagePath
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPagePath;

  /**
   * <br> The entity classPagePath
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPagePath">Find the entity classPagePath in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPagePath(Wrap<String> w);

  public String getClassPagePath() {
    return classPagePath;
  }
  public void setClassPagePath(String o) {
    this.classPagePath = ComputateJavaClass.staticSetClassPagePath(siteRequest_, o);
  }
  public static String staticSetClassPagePath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPagePathInit() {
    Wrap<String> classPagePathWrap = new Wrap<String>().var("classPagePath");
    if(classPagePath == null) {
      _classPagePath(classPagePathWrap);
      Optional.ofNullable(classPagePathWrap.getO()).ifPresent(o -> {
        setClassPagePath(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPagePath(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPagePath(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPagePath(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPagePath(siteRequest_, ComputateJavaClass.staticSetClassPagePath(siteRequest_, o)).toString();
  }

	//////////////////////
  // classPagePathCss //
	//////////////////////


  /**
   *  The entity classPagePathCss
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPagePathCss;

  /**
   * <br> The entity classPagePathCss
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPagePathCss">Find the entity classPagePathCss in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPagePathCss(Wrap<String> w);

  public String getClassPagePathCss() {
    return classPagePathCss;
  }
  public void setClassPagePathCss(String o) {
    this.classPagePathCss = ComputateJavaClass.staticSetClassPagePathCss(siteRequest_, o);
  }
  public static String staticSetClassPagePathCss(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPagePathCssInit() {
    Wrap<String> classPagePathCssWrap = new Wrap<String>().var("classPagePathCss");
    if(classPagePathCss == null) {
      _classPagePathCss(classPagePathCssWrap);
      Optional.ofNullable(classPagePathCssWrap.getO()).ifPresent(o -> {
        setClassPagePathCss(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPagePathCss(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPagePathCss(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPagePathCss(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPagePathCss(siteRequest_, ComputateJavaClass.staticSetClassPagePathCss(siteRequest_, o)).toString();
  }

	/////////////////////
  // classPagePathJs //
	/////////////////////


  /**
   *  The entity classPagePathJs
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPagePathJs;

  /**
   * <br> The entity classPagePathJs
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPagePathJs">Find the entity classPagePathJs in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPagePathJs(Wrap<String> w);

  public String getClassPagePathJs() {
    return classPagePathJs;
  }
  public void setClassPagePathJs(String o) {
    this.classPagePathJs = ComputateJavaClass.staticSetClassPagePathJs(siteRequest_, o);
  }
  public static String staticSetClassPagePathJs(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPagePathJsInit() {
    Wrap<String> classPagePathJsWrap = new Wrap<String>().var("classPagePathJs");
    if(classPagePathJs == null) {
      _classPagePathJs(classPagePathJsWrap);
      Optional.ofNullable(classPagePathJsWrap.getO()).ifPresent(o -> {
        setClassPagePathJs(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPagePathJs(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPagePathJs(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPagePathJs(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPagePathJs(siteRequest_, ComputateJavaClass.staticSetClassPagePathJs(siteRequest_, o)).toString();
  }

	//////////////////////
  // classPagePathHbs //
	//////////////////////


  /**
   *  The entity classPagePathHbs
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPagePathHbs;

  /**
   * <br> The entity classPagePathHbs
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPagePathHbs">Find the entity classPagePathHbs in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPagePathHbs(Wrap<String> w);

  public String getClassPagePathHbs() {
    return classPagePathHbs;
  }
  public void setClassPagePathHbs(String o) {
    this.classPagePathHbs = ComputateJavaClass.staticSetClassPagePathHbs(siteRequest_, o);
  }
  public static String staticSetClassPagePathHbs(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPagePathHbsInit() {
    Wrap<String> classPagePathHbsWrap = new Wrap<String>().var("classPagePathHbs");
    if(classPagePathHbs == null) {
      _classPagePathHbs(classPagePathHbsWrap);
      Optional.ofNullable(classPagePathHbsWrap.getO()).ifPresent(o -> {
        setClassPagePathHbs(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPagePathHbs(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPagePathHbs(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPagePathHbs(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPagePathHbs(siteRequest_, ComputateJavaClass.staticSetClassPagePathHbs(siteRequest_, o)).toString();
  }

	/////////////////////////
  // classGenPagePathHbs //
	/////////////////////////


  /**
   *  The entity classGenPagePathHbs
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classGenPagePathHbs;

  /**
   * <br> The entity classGenPagePathHbs
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classGenPagePathHbs">Find the entity classGenPagePathHbs in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classGenPagePathHbs(Wrap<String> w);

  public String getClassGenPagePathHbs() {
    return classGenPagePathHbs;
  }
  public void setClassGenPagePathHbs(String o) {
    this.classGenPagePathHbs = ComputateJavaClass.staticSetClassGenPagePathHbs(siteRequest_, o);
  }
  public static String staticSetClassGenPagePathHbs(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classGenPagePathHbsInit() {
    Wrap<String> classGenPagePathHbsWrap = new Wrap<String>().var("classGenPagePathHbs");
    if(classGenPagePathHbs == null) {
      _classGenPagePathHbs(classGenPagePathHbsWrap);
      Optional.ofNullable(classGenPagePathHbsWrap.getO()).ifPresent(o -> {
        setClassGenPagePathHbs(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassGenPagePathHbs(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassGenPagePathHbs(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassGenPagePathHbs(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassGenPagePathHbs(siteRequest_, ComputateJavaClass.staticSetClassGenPagePathHbs(siteRequest_, o)).toString();
  }

	///////////////////////////
  // classPageLanguageName //
	///////////////////////////


  /**
   *  The entity classPageLanguageName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPageLanguageName;

  /**
   * <br> The entity classPageLanguageName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPageLanguageName">Find the entity classPageLanguageName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPageLanguageName(Wrap<String> w);

  public String getClassPageLanguageName() {
    return classPageLanguageName;
  }
  public void setClassPageLanguageName(String o) {
    this.classPageLanguageName = ComputateJavaClass.staticSetClassPageLanguageName(siteRequest_, o);
  }
  public static String staticSetClassPageLanguageName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPageLanguageNameInit() {
    Wrap<String> classPageLanguageNameWrap = new Wrap<String>().var("classPageLanguageName");
    if(classPageLanguageName == null) {
      _classPageLanguageName(classPageLanguageNameWrap);
      Optional.ofNullable(classPageLanguageNameWrap.getO()).ifPresent(o -> {
        setClassPageLanguageName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPageLanguageName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPageLanguageName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPageLanguageName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPageLanguageName(siteRequest_, ComputateJavaClass.staticSetClassPageLanguageName(siteRequest_, o)).toString();
  }

	/////////////////////////////////
  // classPageSuperCanonicalName //
	/////////////////////////////////


  /**
   *  The entity classPageSuperCanonicalName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classPageSuperCanonicalName;

  /**
   * <br> The entity classPageSuperCanonicalName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPageSuperCanonicalName">Find the entity classPageSuperCanonicalName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPageSuperCanonicalName(Wrap<String> w);

  public String getClassPageSuperCanonicalName() {
    return classPageSuperCanonicalName;
  }
  public void setClassPageSuperCanonicalName(String o) {
    this.classPageSuperCanonicalName = ComputateJavaClass.staticSetClassPageSuperCanonicalName(siteRequest_, o);
  }
  public static String staticSetClassPageSuperCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classPageSuperCanonicalNameInit() {
    Wrap<String> classPageSuperCanonicalNameWrap = new Wrap<String>().var("classPageSuperCanonicalName");
    if(classPageSuperCanonicalName == null) {
      _classPageSuperCanonicalName(classPageSuperCanonicalNameWrap);
      Optional.ofNullable(classPageSuperCanonicalNameWrap.getO()).ifPresent(o -> {
        setClassPageSuperCanonicalName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassPageSuperCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassPageSuperCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPageSuperCanonicalName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPageSuperCanonicalName(siteRequest_, ComputateJavaClass.staticSetClassPageSuperCanonicalName(siteRequest_, o)).toString();
  }

	//////////////////////////////
  // classSuperPageSimpleName //
	//////////////////////////////


  /**
   *  The entity classSuperPageSimpleName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classSuperPageSimpleName;

  /**
   * <br> The entity classSuperPageSimpleName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSuperPageSimpleName">Find the entity classSuperPageSimpleName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSuperPageSimpleName(Wrap<String> w);

  public String getClassSuperPageSimpleName() {
    return classSuperPageSimpleName;
  }
  public void setClassSuperPageSimpleName(String o) {
    this.classSuperPageSimpleName = ComputateJavaClass.staticSetClassSuperPageSimpleName(siteRequest_, o);
  }
  public static String staticSetClassSuperPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classSuperPageSimpleNameInit() {
    Wrap<String> classSuperPageSimpleNameWrap = new Wrap<String>().var("classSuperPageSimpleName");
    if(classSuperPageSimpleName == null) {
      _classSuperPageSimpleName(classSuperPageSimpleNameWrap);
      Optional.ofNullable(classSuperPageSimpleNameWrap.getO()).ifPresent(o -> {
        setClassSuperPageSimpleName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSuperPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSuperPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSuperPageSimpleName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSuperPageSimpleName(siteRequest_, ComputateJavaClass.staticSetClassSuperPageSimpleName(siteRequest_, o)).toString();
  }

	/////////////////////////
  // classImportsGenPage //
	/////////////////////////


  /**
   *  The entity classImportsGenPage
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classImportsGenPage;

  /**
   * <br> The entity classImportsGenPage
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classImportsGenPage">Find the entity classImportsGenPage in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classImportsGenPage(Wrap<List<String>> w);

  public List<String> getClassImportsGenPage() {
    return classImportsGenPage;
  }

  public void setClassImportsGenPage(List<String> classImportsGenPage) {
    this.classImportsGenPage = classImportsGenPage;
  }
  @JsonIgnore
  public void setClassImportsGenPage(String o) {
    String l = ComputateJavaClass.staticSetClassImportsGenPage(siteRequest_, o);
    if(l != null)
      addClassImportsGenPage(l);
  }
  public static String staticSetClassImportsGenPage(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassImportsGenPage(String...objects) {
    for(String o : objects) {
      addClassImportsGenPage(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassImportsGenPage(String o) {
    if(o != null)
      this.classImportsGenPage.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassImportsGenPage(JsonArray objects) {
    classImportsGenPage.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassImportsGenPage(o);
    }
  }
  protected ComputateJavaClass classImportsGenPageInit() {
    Wrap<List<String>> classImportsGenPageWrap = new Wrap<List<String>>().var("classImportsGenPage");
    if(classImportsGenPage == null) {
      _classImportsGenPage(classImportsGenPageWrap);
      Optional.ofNullable(classImportsGenPageWrap.getO()).ifPresent(o -> {
        setClassImportsGenPage(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassImportsGenPage(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassImportsGenPage(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassImportsGenPage(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassImportsGenPage(siteRequest_, ComputateJavaClass.staticSetClassImportsGenPage(siteRequest_, o)).toString();
  }

	/////////////////
  // classApiUri //
	/////////////////


  /**
   *  The entity classApiUri
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classApiUri;

  /**
   * <br> The entity classApiUri
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classApiUri">Find the entity classApiUri in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classApiUri(Wrap<String> w);

  public String getClassApiUri() {
    return classApiUri;
  }
  public void setClassApiUri(String o) {
    this.classApiUri = ComputateJavaClass.staticSetClassApiUri(siteRequest_, o);
  }
  public static String staticSetClassApiUri(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classApiUriInit() {
    Wrap<String> classApiUriWrap = new Wrap<String>().var("classApiUri");
    if(classApiUri == null) {
      _classApiUri(classApiUriWrap);
      Optional.ofNullable(classApiUriWrap.getO()).ifPresent(o -> {
        setClassApiUri(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassApiUri(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassApiUri(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassApiUri(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassApiUri(siteRequest_, ComputateJavaClass.staticSetClassApiUri(siteRequest_, o)).toString();
  }

	/////////////////
  // classApiTag //
	/////////////////


  /**
   *  The entity classApiTag
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String classApiTag;

  /**
   * <br> The entity classApiTag
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classApiTag">Find the entity classApiTag in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classApiTag(Wrap<String> w);

  public String getClassApiTag() {
    return classApiTag;
  }
  public void setClassApiTag(String o) {
    this.classApiTag = ComputateJavaClass.staticSetClassApiTag(siteRequest_, o);
  }
  public static String staticSetClassApiTag(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass classApiTagInit() {
    Wrap<String> classApiTagWrap = new Wrap<String>().var("classApiTag");
    if(classApiTag == null) {
      _classApiTag(classApiTagWrap);
      Optional.ofNullable(classApiTagWrap.getO()).ifPresent(o -> {
        setClassApiTag(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassApiTag(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassApiTag(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassApiTag(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassApiTag(siteRequest_, ComputateJavaClass.staticSetClassApiTag(siteRequest_, o)).toString();
  }

	/////////////////////
  // classApiMethods //
	/////////////////////


  /**
   *  The entity classApiMethods
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classApiMethods;

  /**
   * <br> The entity classApiMethods
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classApiMethods">Find the entity classApiMethods in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classApiMethods(Wrap<List<String>> w);

  public List<String> getClassApiMethods() {
    return classApiMethods;
  }

  public void setClassApiMethods(List<String> classApiMethods) {
    this.classApiMethods = classApiMethods;
  }
  @JsonIgnore
  public void setClassApiMethods(String o) {
    String l = ComputateJavaClass.staticSetClassApiMethods(siteRequest_, o);
    if(l != null)
      addClassApiMethods(l);
  }
  public static String staticSetClassApiMethods(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassApiMethods(String...objects) {
    for(String o : objects) {
      addClassApiMethods(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassApiMethods(String o) {
    if(o != null)
      this.classApiMethods.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassApiMethods(JsonArray objects) {
    classApiMethods.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassApiMethods(o);
    }
  }
  protected ComputateJavaClass classApiMethodsInit() {
    Wrap<List<String>> classApiMethodsWrap = new Wrap<List<String>>().var("classApiMethods");
    if(classApiMethods == null) {
      _classApiMethods(classApiMethodsWrap);
      Optional.ofNullable(classApiMethodsWrap.getO()).ifPresent(o -> {
        setClassApiMethods(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassApiMethods(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassApiMethods(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassApiMethods(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassApiMethods(siteRequest_, ComputateJavaClass.staticSetClassApiMethods(siteRequest_, o)).toString();
  }

	//////////////////
  // classContext //
	//////////////////


  /**
   *  The entity classContext
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classContext;

  /**
   * <br> The entity classContext
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classContext">Find the entity classContext in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classContext(Wrap<Boolean> w);

  public Boolean getClassContext() {
    return classContext;
  }

  public void setClassContext(Boolean classContext) {
    this.classContext = classContext;
  }
  @JsonIgnore
  public void setClassContext(String o) {
    this.classContext = ComputateJavaClass.staticSetClassContext(siteRequest_, o);
  }
  public static Boolean staticSetClassContext(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classContextInit() {
    Wrap<Boolean> classContextWrap = new Wrap<Boolean>().var("classContext");
    if(classContext == null) {
      _classContext(classContextWrap);
      Optional.ofNullable(classContextWrap.getO()).ifPresent(o -> {
        setClassContext(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassContext(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassContext(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassContext(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassContext(siteRequest_, ComputateJavaClass.staticSetClassContext(siteRequest_, o)).toString();
  }

	//////////////////
  // contextColor //
	//////////////////


  /**
   *  The entity contextColor
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextColor;

  /**
   * <br> The entity contextColor
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextColor">Find the entity contextColor in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextColor(Wrap<String> w);

  public String getContextColor() {
    return contextColor;
  }
  public void setContextColor(String o) {
    this.contextColor = ComputateJavaClass.staticSetContextColor(siteRequest_, o);
  }
  public static String staticSetContextColor(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextColorInit() {
    Wrap<String> contextColorWrap = new Wrap<String>().var("contextColor");
    if(contextColor == null) {
      _contextColor(contextColorWrap);
      Optional.ofNullable(contextColorWrap.getO()).ifPresent(o -> {
        setContextColor(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextColor(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextColor(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextColor(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextColor(siteRequest_, ComputateJavaClass.staticSetContextColor(siteRequest_, o)).toString();
  }

	//////////////////////
  // contextIconGroup //
	//////////////////////


  /**
   *  The entity contextIconGroup
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextIconGroup;

  /**
   * <br> The entity contextIconGroup
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextIconGroup">Find the entity contextIconGroup in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextIconGroup(Wrap<String> w);

  public String getContextIconGroup() {
    return contextIconGroup;
  }
  public void setContextIconGroup(String o) {
    this.contextIconGroup = ComputateJavaClass.staticSetContextIconGroup(siteRequest_, o);
  }
  public static String staticSetContextIconGroup(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextIconGroupInit() {
    Wrap<String> contextIconGroupWrap = new Wrap<String>().var("contextIconGroup");
    if(contextIconGroup == null) {
      _contextIconGroup(contextIconGroupWrap);
      Optional.ofNullable(contextIconGroupWrap.getO()).ifPresent(o -> {
        setContextIconGroup(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextIconGroup(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextIconGroup(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextIconGroup(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextIconGroup(siteRequest_, ComputateJavaClass.staticSetContextIconGroup(siteRequest_, o)).toString();
  }

	/////////////////////
  // contextIconName //
	/////////////////////


  /**
   *  The entity contextIconName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextIconName;

  /**
   * <br> The entity contextIconName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextIconName">Find the entity contextIconName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextIconName(Wrap<String> w);

  public String getContextIconName() {
    return contextIconName;
  }
  public void setContextIconName(String o) {
    this.contextIconName = ComputateJavaClass.staticSetContextIconName(siteRequest_, o);
  }
  public static String staticSetContextIconName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextIconNameInit() {
    Wrap<String> contextIconNameWrap = new Wrap<String>().var("contextIconName");
    if(contextIconName == null) {
      _contextIconName(contextIconNameWrap);
      Optional.ofNullable(contextIconNameWrap.getO()).ifPresent(o -> {
        setContextIconName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextIconName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextIconName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextIconName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextIconName(siteRequest_, ComputateJavaClass.staticSetContextIconName(siteRequest_, o)).toString();
  }

	/////////////////
  // contextRows //
	/////////////////


  /**
   *  The entity contextRows
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonSerialize(using = ToStringSerializer.class)
  @JsonInclude(Include.NON_NULL)
  protected Integer contextRows;

  /**
   * <br> The entity contextRows
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextRows">Find the entity contextRows in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextRows(Wrap<Integer> w);

  public Integer getContextRows() {
    return contextRows;
  }

  public void setContextRows(Integer contextRows) {
    this.contextRows = contextRows;
  }
  @JsonIgnore
  public void setContextRows(String o) {
    this.contextRows = ComputateJavaClass.staticSetContextRows(siteRequest_, o);
  }
  public static Integer staticSetContextRows(ComputateSiteRequest siteRequest_, String o) {
    if(NumberUtils.isParsable(o))
      return Integer.parseInt(o);
    return null;
  }
  protected ComputateJavaClass contextRowsInit() {
    Wrap<Integer> contextRowsWrap = new Wrap<Integer>().var("contextRows");
    if(contextRows == null) {
      _contextRows(contextRowsWrap);
      Optional.ofNullable(contextRowsWrap.getO()).ifPresent(o -> {
        setContextRows(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Integer staticSearchContextRows(ComputateSiteRequest siteRequest_, Integer o) {
    return o;
  }

  public static String staticSearchStrContextRows(ComputateSiteRequest siteRequest_, Integer o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextRows(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextRows(siteRequest_, ComputateJavaClass.staticSetContextRows(siteRequest_, o)).toString();
  }

	//////////////////
  // contextAName //
	//////////////////


  /**
   *  The entity contextAName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextAName;

  /**
   * <br> The entity contextAName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextAName">Find the entity contextAName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextAName(Wrap<String> w);

  public String getContextAName() {
    return contextAName;
  }
  public void setContextAName(String o) {
    this.contextAName = ComputateJavaClass.staticSetContextAName(siteRequest_, o);
  }
  public static String staticSetContextAName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextANameInit() {
    Wrap<String> contextANameWrap = new Wrap<String>().var("contextAName");
    if(contextAName == null) {
      _contextAName(contextANameWrap);
      Optional.ofNullable(contextANameWrap.getO()).ifPresent(o -> {
        setContextAName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextAName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextAName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextAName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextAName(siteRequest_, ComputateJavaClass.staticSetContextAName(siteRequest_, o)).toString();
  }

	/////////////////////////
  // contextNameSingular //
	/////////////////////////


  /**
   *  The entity contextNameSingular
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextNameSingular;

  /**
   * <br> The entity contextNameSingular
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextNameSingular">Find the entity contextNameSingular in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextNameSingular(Wrap<String> w);

  public String getContextNameSingular() {
    return contextNameSingular;
  }
  public void setContextNameSingular(String o) {
    this.contextNameSingular = ComputateJavaClass.staticSetContextNameSingular(siteRequest_, o);
  }
  public static String staticSetContextNameSingular(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextNameSingularInit() {
    Wrap<String> contextNameSingularWrap = new Wrap<String>().var("contextNameSingular");
    if(contextNameSingular == null) {
      _contextNameSingular(contextNameSingularWrap);
      Optional.ofNullable(contextNameSingularWrap.getO()).ifPresent(o -> {
        setContextNameSingular(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextNameSingular(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextNameSingular(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextNameSingular(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextNameSingular(siteRequest_, ComputateJavaClass.staticSetContextNameSingular(siteRequest_, o)).toString();
  }

	///////////////////////
  // contextNamePlural //
	///////////////////////


  /**
   *  The entity contextNamePlural
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextNamePlural;

  /**
   * <br> The entity contextNamePlural
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextNamePlural">Find the entity contextNamePlural in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextNamePlural(Wrap<String> w);

  public String getContextNamePlural() {
    return contextNamePlural;
  }
  public void setContextNamePlural(String o) {
    this.contextNamePlural = ComputateJavaClass.staticSetContextNamePlural(siteRequest_, o);
  }
  public static String staticSetContextNamePlural(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextNamePluralInit() {
    Wrap<String> contextNamePluralWrap = new Wrap<String>().var("contextNamePlural");
    if(contextNamePlural == null) {
      _contextNamePlural(contextNamePluralWrap);
      Optional.ofNullable(contextNamePluralWrap.getO()).ifPresent(o -> {
        setContextNamePlural(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextNamePlural(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextNamePlural(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextNamePlural(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextNamePlural(siteRequest_, ComputateJavaClass.staticSetContextNamePlural(siteRequest_, o)).toString();
  }

	////////////////////
  // contextNameVar //
	////////////////////


  /**
   *  The entity contextNameVar
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextNameVar;

  /**
   * <br> The entity contextNameVar
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextNameVar">Find the entity contextNameVar in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextNameVar(Wrap<String> w);

  public String getContextNameVar() {
    return contextNameVar;
  }
  public void setContextNameVar(String o) {
    this.contextNameVar = ComputateJavaClass.staticSetContextNameVar(siteRequest_, o);
  }
  public static String staticSetContextNameVar(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextNameVarInit() {
    Wrap<String> contextNameVarWrap = new Wrap<String>().var("contextNameVar");
    if(contextNameVar == null) {
      _contextNameVar(contextNameVarWrap);
      Optional.ofNullable(contextNameVarWrap.getO()).ifPresent(o -> {
        setContextNameVar(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextNameVar(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextNameVar(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextNameVar(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextNameVar(siteRequest_, ComputateJavaClass.staticSetContextNameVar(siteRequest_, o)).toString();
  }

	/////////////////////
  // contextTheNames //
	/////////////////////


  /**
   *  The entity contextTheNames
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextTheNames;

  /**
   * <br> The entity contextTheNames
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextTheNames">Find the entity contextTheNames in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextTheNames(Wrap<String> w);

  public String getContextTheNames() {
    return contextTheNames;
  }
  public void setContextTheNames(String o) {
    this.contextTheNames = ComputateJavaClass.staticSetContextTheNames(siteRequest_, o);
  }
  public static String staticSetContextTheNames(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextTheNamesInit() {
    Wrap<String> contextTheNamesWrap = new Wrap<String>().var("contextTheNames");
    if(contextTheNames == null) {
      _contextTheNames(contextTheNamesWrap);
      Optional.ofNullable(contextTheNamesWrap.getO()).ifPresent(o -> {
        setContextTheNames(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextTheNames(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextTheNames(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextTheNames(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextTheNames(siteRequest_, ComputateJavaClass.staticSetContextTheNames(siteRequest_, o)).toString();
  }

	//////////////////////////////////
  // contextNameAdjectiveSingular //
	//////////////////////////////////


  /**
   *  The entity contextNameAdjectiveSingular
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextNameAdjectiveSingular;

  /**
   * <br> The entity contextNameAdjectiveSingular
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextNameAdjectiveSingular">Find the entity contextNameAdjectiveSingular in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextNameAdjectiveSingular(Wrap<String> w);

  public String getContextNameAdjectiveSingular() {
    return contextNameAdjectiveSingular;
  }
  public void setContextNameAdjectiveSingular(String o) {
    this.contextNameAdjectiveSingular = ComputateJavaClass.staticSetContextNameAdjectiveSingular(siteRequest_, o);
  }
  public static String staticSetContextNameAdjectiveSingular(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextNameAdjectiveSingularInit() {
    Wrap<String> contextNameAdjectiveSingularWrap = new Wrap<String>().var("contextNameAdjectiveSingular");
    if(contextNameAdjectiveSingular == null) {
      _contextNameAdjectiveSingular(contextNameAdjectiveSingularWrap);
      Optional.ofNullable(contextNameAdjectiveSingularWrap.getO()).ifPresent(o -> {
        setContextNameAdjectiveSingular(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextNameAdjectiveSingular(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextNameAdjectiveSingular(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextNameAdjectiveSingular(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextNameAdjectiveSingular(siteRequest_, ComputateJavaClass.staticSetContextNameAdjectiveSingular(siteRequest_, o)).toString();
  }

	////////////////////////////////
  // contextNameAdjectivePlural //
	////////////////////////////////


  /**
   *  The entity contextNameAdjectivePlural
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextNameAdjectivePlural;

  /**
   * <br> The entity contextNameAdjectivePlural
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextNameAdjectivePlural">Find the entity contextNameAdjectivePlural in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextNameAdjectivePlural(Wrap<String> w);

  public String getContextNameAdjectivePlural() {
    return contextNameAdjectivePlural;
  }
  public void setContextNameAdjectivePlural(String o) {
    this.contextNameAdjectivePlural = ComputateJavaClass.staticSetContextNameAdjectivePlural(siteRequest_, o);
  }
  public static String staticSetContextNameAdjectivePlural(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextNameAdjectivePluralInit() {
    Wrap<String> contextNameAdjectivePluralWrap = new Wrap<String>().var("contextNameAdjectivePlural");
    if(contextNameAdjectivePlural == null) {
      _contextNameAdjectivePlural(contextNameAdjectivePluralWrap);
      Optional.ofNullable(contextNameAdjectivePluralWrap.getO()).ifPresent(o -> {
        setContextNameAdjectivePlural(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextNameAdjectivePlural(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextNameAdjectivePlural(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextNameAdjectivePlural(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextNameAdjectivePlural(siteRequest_, ComputateJavaClass.staticSetContextNameAdjectivePlural(siteRequest_, o)).toString();
  }

	/////////////////
  // contextThis //
	/////////////////


  /**
   *  The entity contextThis
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextThis;

  /**
   * <br> The entity contextThis
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextThis">Find the entity contextThis in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextThis(Wrap<String> w);

  public String getContextThis() {
    return contextThis;
  }
  public void setContextThis(String o) {
    this.contextThis = ComputateJavaClass.staticSetContextThis(siteRequest_, o);
  }
  public static String staticSetContextThis(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextThisInit() {
    Wrap<String> contextThisWrap = new Wrap<String>().var("contextThis");
    if(contextThis == null) {
      _contextThis(contextThisWrap);
      Optional.ofNullable(contextThisWrap.getO()).ifPresent(o -> {
        setContextThis(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextThis(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextThis(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextThis(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextThis(siteRequest_, ComputateJavaClass.staticSetContextThis(siteRequest_, o)).toString();
  }

	//////////////
  // contextA //
	//////////////


  /**
   *  The entity contextA
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextA;

  /**
   * <br> The entity contextA
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextA">Find the entity contextA in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextA(Wrap<String> w);

  public String getContextA() {
    return contextA;
  }
  public void setContextA(String o) {
    this.contextA = ComputateJavaClass.staticSetContextA(siteRequest_, o);
  }
  public static String staticSetContextA(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextAInit() {
    Wrap<String> contextAWrap = new Wrap<String>().var("contextA");
    if(contextA == null) {
      _contextA(contextAWrap);
      Optional.ofNullable(contextAWrap.getO()).ifPresent(o -> {
        setContextA(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextA(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextA(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextA(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextA(siteRequest_, ComputateJavaClass.staticSetContextA(siteRequest_, o)).toString();
  }

	////////////////////
  // contextCreated //
	////////////////////


  /**
   *  The entity contextCreated
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextCreated;

  /**
   * <br> The entity contextCreated
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextCreated">Find the entity contextCreated in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextCreated(Wrap<String> w);

  public String getContextCreated() {
    return contextCreated;
  }
  public void setContextCreated(String o) {
    this.contextCreated = ComputateJavaClass.staticSetContextCreated(siteRequest_, o);
  }
  public static String staticSetContextCreated(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextCreatedInit() {
    Wrap<String> contextCreatedWrap = new Wrap<String>().var("contextCreated");
    if(contextCreated == null) {
      _contextCreated(contextCreatedWrap);
      Optional.ofNullable(contextCreatedWrap.getO()).ifPresent(o -> {
        setContextCreated(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextCreated(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextCreated(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextCreated(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextCreated(siteRequest_, ComputateJavaClass.staticSetContextCreated(siteRequest_, o)).toString();
  }

	/////////////////////
  // contextModified //
	/////////////////////


  /**
   *  The entity contextModified
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextModified;

  /**
   * <br> The entity contextModified
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextModified">Find the entity contextModified in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextModified(Wrap<String> w);

  public String getContextModified() {
    return contextModified;
  }
  public void setContextModified(String o) {
    this.contextModified = ComputateJavaClass.staticSetContextModified(siteRequest_, o);
  }
  public static String staticSetContextModified(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextModifiedInit() {
    Wrap<String> contextModifiedWrap = new Wrap<String>().var("contextModified");
    if(contextModified == null) {
      _contextModified(contextModifiedWrap);
      Optional.ofNullable(contextModifiedWrap.getO()).ifPresent(o -> {
        setContextModified(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextModified(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextModified(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextModified(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextModified(siteRequest_, ComputateJavaClass.staticSetContextModified(siteRequest_, o)).toString();
  }

	///////////////////////
  // contextActualName //
	///////////////////////


  /**
   *  The entity contextActualName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextActualName;

  /**
   * <br> The entity contextActualName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextActualName">Find the entity contextActualName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextActualName(Wrap<String> w);

  public String getContextActualName() {
    return contextActualName;
  }
  public void setContextActualName(String o) {
    this.contextActualName = ComputateJavaClass.staticSetContextActualName(siteRequest_, o);
  }
  public static String staticSetContextActualName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextActualNameInit() {
    Wrap<String> contextActualNameWrap = new Wrap<String>().var("contextActualName");
    if(contextActualName == null) {
      _contextActualName(contextActualNameWrap);
      Optional.ofNullable(contextActualNameWrap.getO()).ifPresent(o -> {
        setContextActualName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextActualName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextActualName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextActualName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextActualName(siteRequest_, ComputateJavaClass.staticSetContextActualName(siteRequest_, o)).toString();
  }

	////////////////
  // contextAll //
	////////////////


  /**
   *  The entity contextAll
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextAll;

  /**
   * <br> The entity contextAll
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextAll">Find the entity contextAll in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextAll(Wrap<String> w);

  public String getContextAll() {
    return contextAll;
  }
  public void setContextAll(String o) {
    this.contextAll = ComputateJavaClass.staticSetContextAll(siteRequest_, o);
  }
  public static String staticSetContextAll(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextAllInit() {
    Wrap<String> contextAllWrap = new Wrap<String>().var("contextAll");
    if(contextAll == null) {
      _contextAll(contextAllWrap);
      Optional.ofNullable(contextAllWrap.getO()).ifPresent(o -> {
        setContextAll(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextAll(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextAll(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextAll(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextAll(siteRequest_, ComputateJavaClass.staticSetContextAll(siteRequest_, o)).toString();
  }

	////////////////////
  // contextAllName //
	////////////////////


  /**
   *  The entity contextAllName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextAllName;

  /**
   * <br> The entity contextAllName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextAllName">Find the entity contextAllName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextAllName(Wrap<String> w);

  public String getContextAllName() {
    return contextAllName;
  }
  public void setContextAllName(String o) {
    this.contextAllName = ComputateJavaClass.staticSetContextAllName(siteRequest_, o);
  }
  public static String staticSetContextAllName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextAllNameInit() {
    Wrap<String> contextAllNameWrap = new Wrap<String>().var("contextAllName");
    if(contextAllName == null) {
      _contextAllName(contextAllNameWrap);
      Optional.ofNullable(contextAllNameWrap.getO()).ifPresent(o -> {
        setContextAllName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextAllName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextAllName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextAllName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextAllName(siteRequest_, ComputateJavaClass.staticSetContextAllName(siteRequest_, o)).toString();
  }

	////////////////////////////
  // contextSearchAllNameBy //
	////////////////////////////


  /**
   *  The entity contextSearchAllNameBy
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextSearchAllNameBy;

  /**
   * <br> The entity contextSearchAllNameBy
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextSearchAllNameBy">Find the entity contextSearchAllNameBy in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextSearchAllNameBy(Wrap<String> w);

  public String getContextSearchAllNameBy() {
    return contextSearchAllNameBy;
  }
  public void setContextSearchAllNameBy(String o) {
    this.contextSearchAllNameBy = ComputateJavaClass.staticSetContextSearchAllNameBy(siteRequest_, o);
  }
  public static String staticSetContextSearchAllNameBy(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextSearchAllNameByInit() {
    Wrap<String> contextSearchAllNameByWrap = new Wrap<String>().var("contextSearchAllNameBy");
    if(contextSearchAllNameBy == null) {
      _contextSearchAllNameBy(contextSearchAllNameByWrap);
      Optional.ofNullable(contextSearchAllNameByWrap.getO()).ifPresent(o -> {
        setContextSearchAllNameBy(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextSearchAllNameBy(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextSearchAllNameBy(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextSearchAllNameBy(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextSearchAllNameBy(siteRequest_, ComputateJavaClass.staticSetContextSearchAllNameBy(siteRequest_, o)).toString();
  }

	//////////////////////////
  // contextSearchAllName //
	//////////////////////////


  /**
   *  The entity contextSearchAllName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextSearchAllName;

  /**
   * <br> The entity contextSearchAllName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextSearchAllName">Find the entity contextSearchAllName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextSearchAllName(Wrap<String> w);

  public String getContextSearchAllName() {
    return contextSearchAllName;
  }
  public void setContextSearchAllName(String o) {
    this.contextSearchAllName = ComputateJavaClass.staticSetContextSearchAllName(siteRequest_, o);
  }
  public static String staticSetContextSearchAllName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextSearchAllNameInit() {
    Wrap<String> contextSearchAllNameWrap = new Wrap<String>().var("contextSearchAllName");
    if(contextSearchAllName == null) {
      _contextSearchAllName(contextSearchAllNameWrap);
      Optional.ofNullable(contextSearchAllNameWrap.getO()).ifPresent(o -> {
        setContextSearchAllName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextSearchAllName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextSearchAllName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextSearchAllName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextSearchAllName(siteRequest_, ComputateJavaClass.staticSetContextSearchAllName(siteRequest_, o)).toString();
  }

	////////////////////////
  // contextNoNameFound //
	////////////////////////


  /**
   *  The entity contextNoNameFound
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextNoNameFound;

  /**
   * <br> The entity contextNoNameFound
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextNoNameFound">Find the entity contextNoNameFound in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextNoNameFound(Wrap<String> w);

  public String getContextNoNameFound() {
    return contextNoNameFound;
  }
  public void setContextNoNameFound(String o) {
    this.contextNoNameFound = ComputateJavaClass.staticSetContextNoNameFound(siteRequest_, o);
  }
  public static String staticSetContextNoNameFound(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextNoNameFoundInit() {
    Wrap<String> contextNoNameFoundWrap = new Wrap<String>().var("contextNoNameFound");
    if(contextNoNameFound == null) {
      _contextNoNameFound(contextNoNameFoundWrap);
      Optional.ofNullable(contextNoNameFoundWrap.getO()).ifPresent(o -> {
        setContextNoNameFound(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextNoNameFound(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextNoNameFound(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextNoNameFound(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextNoNameFound(siteRequest_, ComputateJavaClass.staticSetContextNoNameFound(siteRequest_, o)).toString();
  }

	///////////////////////////
  // contextANameAdjective //
	///////////////////////////


  /**
   *  The entity contextANameAdjective
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextANameAdjective;

  /**
   * <br> The entity contextANameAdjective
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextANameAdjective">Find the entity contextANameAdjective in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextANameAdjective(Wrap<String> w);

  public String getContextANameAdjective() {
    return contextANameAdjective;
  }
  public void setContextANameAdjective(String o) {
    this.contextANameAdjective = ComputateJavaClass.staticSetContextANameAdjective(siteRequest_, o);
  }
  public static String staticSetContextANameAdjective(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextANameAdjectiveInit() {
    Wrap<String> contextANameAdjectiveWrap = new Wrap<String>().var("contextANameAdjective");
    if(contextANameAdjective == null) {
      _contextANameAdjective(contextANameAdjectiveWrap);
      Optional.ofNullable(contextANameAdjectiveWrap.getO()).ifPresent(o -> {
        setContextANameAdjective(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextANameAdjective(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextANameAdjective(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextANameAdjective(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextANameAdjective(siteRequest_, ComputateJavaClass.staticSetContextANameAdjective(siteRequest_, o)).toString();
  }

	/////////////////////
  // contextThisName //
	/////////////////////


  /**
   *  The entity contextThisName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextThisName;

  /**
   * <br> The entity contextThisName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextThisName">Find the entity contextThisName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextThisName(Wrap<String> w);

  public String getContextThisName() {
    return contextThisName;
  }
  public void setContextThisName(String o) {
    this.contextThisName = ComputateJavaClass.staticSetContextThisName(siteRequest_, o);
  }
  public static String staticSetContextThisName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextThisNameInit() {
    Wrap<String> contextThisNameWrap = new Wrap<String>().var("contextThisName");
    if(contextThisName == null) {
      _contextThisName(contextThisNameWrap);
      Optional.ofNullable(contextThisNameWrap.getO()).ifPresent(o -> {
        setContextThisName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextThisName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextThisName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextThisName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextThisName(siteRequest_, ComputateJavaClass.staticSetContextThisName(siteRequest_, o)).toString();
  }

	////////////////////
  // contextTheName //
	////////////////////


  /**
   *  The entity contextTheName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextTheName;

  /**
   * <br> The entity contextTheName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextTheName">Find the entity contextTheName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextTheName(Wrap<String> w);

  public String getContextTheName() {
    return contextTheName;
  }
  public void setContextTheName(String o) {
    this.contextTheName = ComputateJavaClass.staticSetContextTheName(siteRequest_, o);
  }
  public static String staticSetContextTheName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextTheNameInit() {
    Wrap<String> contextTheNameWrap = new Wrap<String>().var("contextTheName");
    if(contextTheName == null) {
      _contextTheName(contextTheNameWrap);
      Optional.ofNullable(contextTheNameWrap.getO()).ifPresent(o -> {
        setContextTheName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextTheName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextTheName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextTheName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextTheName(siteRequest_, ComputateJavaClass.staticSetContextTheName(siteRequest_, o)).toString();
  }

	///////////////////
  // contextOfName //
	///////////////////


  /**
   *  The entity contextOfName
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextOfName;

  /**
   * <br> The entity contextOfName
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextOfName">Find the entity contextOfName in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextOfName(Wrap<String> w);

  public String getContextOfName() {
    return contextOfName;
  }
  public void setContextOfName(String o) {
    this.contextOfName = ComputateJavaClass.staticSetContextOfName(siteRequest_, o);
  }
  public static String staticSetContextOfName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextOfNameInit() {
    Wrap<String> contextOfNameWrap = new Wrap<String>().var("contextOfName");
    if(contextOfName == null) {
      _contextOfName(contextOfNameWrap);
      Optional.ofNullable(contextOfNameWrap.getO()).ifPresent(o -> {
        setContextOfName(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextOfName(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextOfName(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextOfName(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextOfName(siteRequest_, ComputateJavaClass.staticSetContextOfName(siteRequest_, o)).toString();
  }

	//////////////////////////
  // contextThisLowercase //
	//////////////////////////


  /**
   *  The entity contextThisLowercase
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextThisLowercase;

  /**
   * <br> The entity contextThisLowercase
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextThisLowercase">Find the entity contextThisLowercase in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextThisLowercase(Wrap<String> w);

  public String getContextThisLowercase() {
    return contextThisLowercase;
  }
  public void setContextThisLowercase(String o) {
    this.contextThisLowercase = ComputateJavaClass.staticSetContextThisLowercase(siteRequest_, o);
  }
  public static String staticSetContextThisLowercase(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextThisLowercaseInit() {
    Wrap<String> contextThisLowercaseWrap = new Wrap<String>().var("contextThisLowercase");
    if(contextThisLowercase == null) {
      _contextThisLowercase(contextThisLowercaseWrap);
      Optional.ofNullable(contextThisLowercaseWrap.getO()).ifPresent(o -> {
        setContextThisLowercase(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextThisLowercase(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextThisLowercase(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextThisLowercase(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextThisLowercase(siteRequest_, ComputateJavaClass.staticSetContextThisLowercase(siteRequest_, o)).toString();
  }

	//////////////////
  // contextTitle //
	//////////////////


  /**
   *  The entity contextTitle
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected String contextTitle;

  /**
   * <br> The entity contextTitle
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:contextTitle">Find the entity contextTitle in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _contextTitle(Wrap<String> w);

  public String getContextTitle() {
    return contextTitle;
  }
  public void setContextTitle(String o) {
    this.contextTitle = ComputateJavaClass.staticSetContextTitle(siteRequest_, o);
  }
  public static String staticSetContextTitle(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  protected ComputateJavaClass contextTitleInit() {
    Wrap<String> contextTitleWrap = new Wrap<String>().var("contextTitle");
    if(contextTitle == null) {
      _contextTitle(contextTitleWrap);
      Optional.ofNullable(contextTitleWrap.getO()).ifPresent(o -> {
        setContextTitle(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchContextTitle(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrContextTitle(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqContextTitle(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchContextTitle(siteRequest_, ComputateJavaClass.staticSetContextTitle(siteRequest_, o)).toString();
  }

	//////////////////
  // classIndexed //
	//////////////////


  /**
   *  The entity classIndexed
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classIndexed;

  /**
   * <br> The entity classIndexed
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classIndexed">Find the entity classIndexed in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classIndexed(Wrap<Boolean> w);

  public Boolean getClassIndexed() {
    return classIndexed;
  }

  public void setClassIndexed(Boolean classIndexed) {
    this.classIndexed = classIndexed;
  }
  @JsonIgnore
  public void setClassIndexed(String o) {
    this.classIndexed = ComputateJavaClass.staticSetClassIndexed(siteRequest_, o);
  }
  public static Boolean staticSetClassIndexed(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classIndexedInit() {
    Wrap<Boolean> classIndexedWrap = new Wrap<Boolean>().var("classIndexed");
    if(classIndexed == null) {
      _classIndexed(classIndexedWrap);
      Optional.ofNullable(classIndexedWrap.getO()).ifPresent(o -> {
        setClassIndexed(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassIndexed(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassIndexed(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassIndexed(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassIndexed(siteRequest_, ComputateJavaClass.staticSetClassIndexed(siteRequest_, o)).toString();
  }

	////////////////
  // classImage //
	////////////////


  /**
   *  The entity classImage
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classImage;

  /**
   * <br> The entity classImage
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classImage">Find the entity classImage in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classImage(Wrap<Boolean> w);

  public Boolean getClassImage() {
    return classImage;
  }

  public void setClassImage(Boolean classImage) {
    this.classImage = classImage;
  }
  @JsonIgnore
  public void setClassImage(String o) {
    this.classImage = ComputateJavaClass.staticSetClassImage(siteRequest_, o);
  }
  public static Boolean staticSetClassImage(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classImageInit() {
    Wrap<Boolean> classImageWrap = new Wrap<Boolean>().var("classImage");
    if(classImage == null) {
      _classImage(classImageWrap);
      Optional.ofNullable(classImageWrap.getO()).ifPresent(o -> {
        setClassImage(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassImage(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassImage(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassImage(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassImage(siteRequest_, ComputateJavaClass.staticSetClassImage(siteRequest_, o)).toString();
  }

	//////////////////
  // classPromise //
	//////////////////


  /**
   *  The entity classPromise
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classPromise;

  /**
   * <br> The entity classPromise
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPromise">Find the entity classPromise in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPromise(Wrap<Boolean> w);

  public Boolean getClassPromise() {
    return classPromise;
  }

  public void setClassPromise(Boolean classPromise) {
    this.classPromise = classPromise;
  }
  @JsonIgnore
  public void setClassPromise(String o) {
    this.classPromise = ComputateJavaClass.staticSetClassPromise(siteRequest_, o);
  }
  public static Boolean staticSetClassPromise(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classPromiseInit() {
    Wrap<Boolean> classPromiseWrap = new Wrap<Boolean>().var("classPromise");
    if(classPromise == null) {
      _classPromise(classPromiseWrap);
      Optional.ofNullable(classPromiseWrap.getO()).ifPresent(o -> {
        setClassPromise(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassPromise(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassPromise(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPromise(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPromise(siteRequest_, ComputateJavaClass.staticSetClassPromise(siteRequest_, o)).toString();
  }

	/////////////////////
  // classImportsGen //
	/////////////////////


  /**
   *  The entity classImportsGen
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classImportsGen;

  /**
   * <br> The entity classImportsGen
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classImportsGen">Find the entity classImportsGen in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classImportsGen(Wrap<List<String>> w);

  public List<String> getClassImportsGen() {
    return classImportsGen;
  }

  public void setClassImportsGen(List<String> classImportsGen) {
    this.classImportsGen = classImportsGen;
  }
  @JsonIgnore
  public void setClassImportsGen(String o) {
    String l = ComputateJavaClass.staticSetClassImportsGen(siteRequest_, o);
    if(l != null)
      addClassImportsGen(l);
  }
  public static String staticSetClassImportsGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassImportsGen(String...objects) {
    for(String o : objects) {
      addClassImportsGen(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassImportsGen(String o) {
    if(o != null)
      this.classImportsGen.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassImportsGen(JsonArray objects) {
    classImportsGen.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassImportsGen(o);
    }
  }
  protected ComputateJavaClass classImportsGenInit() {
    Wrap<List<String>> classImportsGenWrap = new Wrap<List<String>>().var("classImportsGen");
    if(classImportsGen == null) {
      _classImportsGen(classImportsGenWrap);
      Optional.ofNullable(classImportsGenWrap.getO()).ifPresent(o -> {
        setClassImportsGen(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassImportsGen(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassImportsGen(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassImportsGen(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassImportsGen(siteRequest_, ComputateJavaClass.staticSetClassImportsGen(siteRequest_, o)).toString();
  }

	/////////////////////
  // classSortsFound //
	/////////////////////


  /**
   *  The entity classSortsFound
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classSortsFound;

  /**
   * <br> The entity classSortsFound
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSortsFound">Find the entity classSortsFound in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSortsFound(Wrap<Boolean> w);

  public Boolean getClassSortsFound() {
    return classSortsFound;
  }

  public void setClassSortsFound(Boolean classSortsFound) {
    this.classSortsFound = classSortsFound;
  }
  @JsonIgnore
  public void setClassSortsFound(String o) {
    this.classSortsFound = ComputateJavaClass.staticSetClassSortsFound(siteRequest_, o);
  }
  public static Boolean staticSetClassSortsFound(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classSortsFoundInit() {
    Wrap<Boolean> classSortsFoundWrap = new Wrap<Boolean>().var("classSortsFound");
    if(classSortsFound == null) {
      _classSortsFound(classSortsFoundWrap);
      Optional.ofNullable(classSortsFoundWrap.getO()).ifPresent(o -> {
        setClassSortsFound(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassSortsFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassSortsFound(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSortsFound(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSortsFound(siteRequest_, ComputateJavaClass.staticSetClassSortsFound(siteRequest_, o)).toString();
  }

	//////////////////////////
  // classSortsSuffixType //
	//////////////////////////


  /**
   *  The entity classSortsSuffixType
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classSortsSuffixType;

  /**
   * <br> The entity classSortsSuffixType
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSortsSuffixType">Find the entity classSortsSuffixType in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSortsSuffixType(Wrap<List<String>> w);

  public List<String> getClassSortsSuffixType() {
    return classSortsSuffixType;
  }

  public void setClassSortsSuffixType(List<String> classSortsSuffixType) {
    this.classSortsSuffixType = classSortsSuffixType;
  }
  @JsonIgnore
  public void setClassSortsSuffixType(String o) {
    String l = ComputateJavaClass.staticSetClassSortsSuffixType(siteRequest_, o);
    if(l != null)
      addClassSortsSuffixType(l);
  }
  public static String staticSetClassSortsSuffixType(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassSortsSuffixType(String...objects) {
    for(String o : objects) {
      addClassSortsSuffixType(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassSortsSuffixType(String o) {
    if(o != null)
      this.classSortsSuffixType.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassSortsSuffixType(JsonArray objects) {
    classSortsSuffixType.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassSortsSuffixType(o);
    }
  }
  protected ComputateJavaClass classSortsSuffixTypeInit() {
    Wrap<List<String>> classSortsSuffixTypeWrap = new Wrap<List<String>>().var("classSortsSuffixType");
    if(classSortsSuffixType == null) {
      _classSortsSuffixType(classSortsSuffixTypeWrap);
      Optional.ofNullable(classSortsSuffixTypeWrap.getO()).ifPresent(o -> {
        setClassSortsSuffixType(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSortsSuffixType(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSortsSuffixType(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSortsSuffixType(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSortsSuffixType(siteRequest_, ComputateJavaClass.staticSetClassSortsSuffixType(siteRequest_, o)).toString();
  }

	/////////////////////
  // classSortsOrder //
	/////////////////////


  /**
   *  The entity classSortsOrder
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classSortsOrder;

  /**
   * <br> The entity classSortsOrder
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSortsOrder">Find the entity classSortsOrder in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSortsOrder(Wrap<List<String>> w);

  public List<String> getClassSortsOrder() {
    return classSortsOrder;
  }

  public void setClassSortsOrder(List<String> classSortsOrder) {
    this.classSortsOrder = classSortsOrder;
  }
  @JsonIgnore
  public void setClassSortsOrder(String o) {
    String l = ComputateJavaClass.staticSetClassSortsOrder(siteRequest_, o);
    if(l != null)
      addClassSortsOrder(l);
  }
  public static String staticSetClassSortsOrder(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassSortsOrder(String...objects) {
    for(String o : objects) {
      addClassSortsOrder(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassSortsOrder(String o) {
    if(o != null)
      this.classSortsOrder.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassSortsOrder(JsonArray objects) {
    classSortsOrder.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassSortsOrder(o);
    }
  }
  protected ComputateJavaClass classSortsOrderInit() {
    Wrap<List<String>> classSortsOrderWrap = new Wrap<List<String>>().var("classSortsOrder");
    if(classSortsOrder == null) {
      _classSortsOrder(classSortsOrderWrap);
      Optional.ofNullable(classSortsOrderWrap.getO()).ifPresent(o -> {
        setClassSortsOrder(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSortsOrder(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSortsOrder(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSortsOrder(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSortsOrder(siteRequest_, ComputateJavaClass.staticSetClassSortsOrder(siteRequest_, o)).toString();
  }

	///////////////////
  // classSortsVar //
	///////////////////


  /**
   *  The entity classSortsVar
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonFormat(shape = JsonFormat.Shape.ARRAY)
  @JsonInclude(Include.NON_NULL)
  protected List<String> classSortsVar;

  /**
   * <br> The entity classSortsVar
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classSortsVar">Find the entity classSortsVar in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classSortsVar(Wrap<List<String>> w);

  public List<String> getClassSortsVar() {
    return classSortsVar;
  }

  public void setClassSortsVar(List<String> classSortsVar) {
    this.classSortsVar = classSortsVar;
  }
  @JsonIgnore
  public void setClassSortsVar(String o) {
    String l = ComputateJavaClass.staticSetClassSortsVar(siteRequest_, o);
    if(l != null)
      addClassSortsVar(l);
  }
  public static String staticSetClassSortsVar(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }
  public ComputateJavaClass addClassSortsVar(String...objects) {
    for(String o : objects) {
      addClassSortsVar(o);
    }
    return (ComputateJavaClass)this;
  }
  public ComputateJavaClass addClassSortsVar(String o) {
    if(o != null)
      this.classSortsVar.add(o);
    return (ComputateJavaClass)this;
  }
  @JsonIgnore
  public void setClassSortsVar(JsonArray objects) {
    classSortsVar.clear();
    if(objects == null)
      return;
    for(int i = 0; i < objects.size(); i++) {
      String o = objects.getString(i);
      addClassSortsVar(o);
    }
  }
  protected ComputateJavaClass classSortsVarInit() {
    Wrap<List<String>> classSortsVarWrap = new Wrap<List<String>>().var("classSortsVar");
    if(classSortsVar == null) {
      _classSortsVar(classSortsVarWrap);
      Optional.ofNullable(classSortsVarWrap.getO()).ifPresent(o -> {
        setClassSortsVar(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static String staticSearchClassSortsVar(ComputateSiteRequest siteRequest_, String o) {
    return o;
  }

  public static String staticSearchStrClassSortsVar(ComputateSiteRequest siteRequest_, String o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassSortsVar(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassSortsVar(siteRequest_, ComputateJavaClass.staticSetClassSortsVar(siteRequest_, o)).toString();
  }

	///////////////
  // classPage //
	///////////////


  /**
   *  The entity classPage
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean classPage;

  /**
   * <br> The entity classPage
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:classPage">Find the entity classPage in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _classPage(Wrap<Boolean> w);

  public Boolean getClassPage() {
    return classPage;
  }

  public void setClassPage(Boolean classPage) {
    this.classPage = classPage;
  }
  @JsonIgnore
  public void setClassPage(String o) {
    this.classPage = ComputateJavaClass.staticSetClassPage(siteRequest_, o);
  }
  public static Boolean staticSetClassPage(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass classPageInit() {
    Wrap<Boolean> classPageWrap = new Wrap<Boolean>().var("classPage");
    if(classPage == null) {
      _classPage(classPageWrap);
      Optional.ofNullable(classPageWrap.getO()).ifPresent(o -> {
        setClassPage(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchClassPage(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrClassPage(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqClassPage(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchClassPage(siteRequest_, ComputateJavaClass.staticSetClassPage(siteRequest_, o)).toString();
  }

	/////////////
  // version //
	/////////////


  /**
   *  The entity version
   *	 is defined as null before being initialized. 
   */
  @JsonProperty
  @JsonInclude(Include.NON_NULL)
  protected Boolean version;

  /**
   * <br> The entity version
   *  is defined as null before being initialized. 
   * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClass&fq=entiteVar_enUS_indexed_string:version">Find the entity version in Solr</a>
   * <br>
   * @param w is for wrapping a value to assign to this entity during initialization. 
   **/
  protected abstract void _version(Wrap<Boolean> w);

  public Boolean getVersion() {
    return version;
  }

  public void setVersion(Boolean version) {
    this.version = version;
  }
  @JsonIgnore
  public void setVersion(String o) {
    this.version = ComputateJavaClass.staticSetVersion(siteRequest_, o);
  }
  public static Boolean staticSetVersion(ComputateSiteRequest siteRequest_, String o) {
    return Boolean.parseBoolean(o);
  }
  protected ComputateJavaClass versionInit() {
    Wrap<Boolean> versionWrap = new Wrap<Boolean>().var("version");
    if(version == null) {
      _version(versionWrap);
      Optional.ofNullable(versionWrap.getO()).ifPresent(o -> {
        setVersion(o);
      });
    }
    return (ComputateJavaClass)this;
  }

  public static Boolean staticSearchVersion(ComputateSiteRequest siteRequest_, Boolean o) {
    return o;
  }

  public static String staticSearchStrVersion(ComputateSiteRequest siteRequest_, Boolean o) {
    return o == null ? null : o.toString();
  }

  public static String staticSearchFqVersion(ComputateSiteRequest siteRequest_, String o) {
    return ComputateJavaClass.staticSearchVersion(siteRequest_, ComputateJavaClass.staticSetVersion(siteRequest_, o)).toString();
  }

  //////////////
  // initDeep //
  //////////////

  public Future<ComputateJavaClassGen<DEV>> promiseDeepComputateJavaClass(ComputateSiteRequest siteRequest_) {
    setSiteRequest_(siteRequest_);
    return promiseDeepComputateJavaClass();
  }

  public Future<ComputateJavaClassGen<DEV>> promiseDeepComputateJavaClass() {
    Promise<ComputateJavaClassGen<DEV>> promise = Promise.promise();
    Promise<Void> promise2 = Promise.promise();
    promiseComputateJavaClass(promise2);
    promise2.future().onSuccess(a -> {
      promise.complete(this);
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<Void> promiseComputateJavaClass(Promise<Void> promise) {
    Future.future(a -> a.complete()).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        siteRequest_Init();
        promise2.complete();
      } catch(Exception ex) {
        promise2.fail(ex);
      }
      return promise2.future();
    }).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      promiseBeforePromise().onSuccess(promiseBefore -> {
        promise2.complete();
      }).onFailure(ex -> {
        promise2.fail(ex);
      });
      return promise2.future();
    }).compose(a -> {
      Promise<Void> promise2 = Promise.promise();
      try {
        inheritPkInit();
        createdInit();
        archivedInit();
        deletedInit();
        classCanonicalNamesInit();
        sessionIdInit();
        userKeyInit();
        savesInit();
        objectTitleInit();
        objectIdInit();
        objectSuggestInit();
        objectTextInit();
        pageUrlIdInit();
        pageUrlPkInit();
        pageUrlApiInit();
        docInit();
        sitePathInit();
        siteNameInit();
        superClassParamsTypeNameInit();
        superClassCompleteNameInit();
        superClassGenericCompleteNameInit();
        superClassGenericCanonicalNameInit();
        superClassGenericSimpleNameInit();
        classIsBaseInit();
        classExtendsBaseInit();
        classBaseExtendsGenInit();
        classContainsSiteRequestInit();
        classTranslateInit();
        classInitDeepInit();
        classExtendsGenInit();
        languageNameInit();
        modifiedInit();
        classCanonicalNameInit();
        classSimpleNameInit();
        classPackageNameInit();
        classCanonicalNameGenInit();
        classSimpleNameGenInit();
        superClassCanonicalNameInit();
        superClassSimpleNameInit();
        classAbsolutePathInit();
        classPathInit();
        classDirectoryPathInit();
        classPathGenInit();
        classDirectoryPathGenInit();
        domainPackageNameInit();
        entityClassesSuperAndMeWithoutGenInit();
        classIsAbstractInit();
        classModelInit();
        classApiInit();
        classSimplePageInit();
        classSavedInit();
        classSimpleNameApiPackageInfoInit();
        classSimpleNameGenApiServiceImplInit();
        classSimpleNameApiServiceImplInit();
        classSimpleNameGenApiServiceInit();
        classCanonicalNameApiPackageInfoInit();
        classCanonicalNameGenApiServiceImplInit();
        classCanonicalNameApiServiceImplInit();
        classCanonicalNameGenApiServiceInit();
        classPathApiPackageInfoInit();
        classPathGenApiServiceImplInit();
        classPathApiServiceImplInit();
        classPathGenApiServiceInit();
        classPublicReadInit();
        classRoleSessionInit();
        classRoleUserInit();
        classRoleEachInit();
        classRolesInit();
        classRolesLanguageInit();
        classRolesFoundInit();
        classRoleReadFoundInit();
        classSessionWriteInit();
        classUserWriteInit();
        classPublicWriteInit();
        classSessionReadInit();
        classUserReadInit();
        classFiltersFoundInit();
        sqlSortInit();
        idInit();
        partIsClassInit();
        partNumberInit();
        classImportsInit();
        classEntityVarsInit();
        classImportsGenApiInit();
        classAttributeSimpleNamePagesInit();
        classMethodVarsInit();
        classVarSuggestedInit();
        classVarTextInit();
        classVarPrimaryKeyInit();
        classVarInheritPrimaryKeyInit();
        classVarSavesInit();
        classvarUniqueKeyInit();
        classVarModifiedInit();
        classVarCreatedInit();
        classVarUrlIdInit();
        classVarUrlPkInit();
        classVarIdInit();
        classVarTitleInit();
        classKeywordsFoundInit();
        classPageCanonicalNameInit();
        classPageSimpleNameInit();
        classGenPageSimpleNameInit();
        classGenPageCanonicalNameInit();
        classGenPagePathInit();
        classPagePathInit();
        classPagePathCssInit();
        classPagePathJsInit();
        classPagePathHbsInit();
        classGenPagePathHbsInit();
        classPageLanguageNameInit();
        classPageSuperCanonicalNameInit();
        classSuperPageSimpleNameInit();
        classImportsGenPageInit();
        classApiUriInit();
        classApiTagInit();
        classApiMethodsInit();
        classContextInit();
        contextColorInit();
        contextIconGroupInit();
        contextIconNameInit();
        contextRowsInit();
        contextANameInit();
        contextNameSingularInit();
        contextNamePluralInit();
        contextNameVarInit();
        contextTheNamesInit();
        contextNameAdjectiveSingularInit();
        contextNameAdjectivePluralInit();
        contextThisInit();
        contextAInit();
        contextCreatedInit();
        contextModifiedInit();
        contextActualNameInit();
        contextAllInit();
        contextAllNameInit();
        contextSearchAllNameByInit();
        contextSearchAllNameInit();
        contextNoNameFoundInit();
        contextANameAdjectiveInit();
        contextThisNameInit();
        contextTheNameInit();
        contextOfNameInit();
        contextThisLowercaseInit();
        contextTitleInit();
        classIndexedInit();
        classImageInit();
        classPromiseInit();
        classImportsGenInit();
        classSortsFoundInit();
        classSortsSuffixTypeInit();
        classSortsOrderInit();
        classSortsVarInit();
        classPageInit();
        versionInit();
        promise2.complete();
      } catch(Exception ex) {
        promise2.fail(ex);
      }
      return promise2.future();
    }).onSuccess(a -> {
      promise.complete();
    }).onFailure(ex -> {
      promise.fail(ex);
    });
    return promise.future();
  }

  public Future<? extends ComputateJavaClassGen<DEV>> promiseDeepForClass(ComputateSiteRequest siteRequest_) {
    return promiseDeepComputateJavaClass(siteRequest_);
  }

  /////////////////
  // siteRequest //
  /////////////////

  public void siteRequestComputateJavaClass(ComputateSiteRequest siteRequest_) {
  }

  public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
    siteRequestComputateJavaClass(siteRequest_);
  }

  /////////////
  // obtain //
  /////////////

  public Object obtainForClass(String var) {
    String[] vars = StringUtils.split(var, ".");
    Object o = null;
    for(String v : vars) {
      if(o == null)
        o = obtainComputateJavaClass(v);
      else if(o instanceof Map) {
        Map<?, ?> map = (Map<?, ?>)o;
        o = map.get(v);
      }
    }
    return o;
  }
  public Object obtainComputateJavaClass(String var) {
    ComputateJavaClass oComputateJavaClass = (ComputateJavaClass)this;
    switch(var) {
      case "siteRequest_":
        return oComputateJavaClass.siteRequest_;
      case "promiseBefore":
        return oComputateJavaClass.promiseBefore;
      case "inheritPk":
        return oComputateJavaClass.inheritPk;
      case "created":
        return oComputateJavaClass.created;
      case "archived":
        return oComputateJavaClass.archived;
      case "deleted":
        return oComputateJavaClass.deleted;
      case "classCanonicalNames":
        return oComputateJavaClass.classCanonicalNames;
      case "sessionId":
        return oComputateJavaClass.sessionId;
      case "userKey":
        return oComputateJavaClass.userKey;
      case "saves":
        return oComputateJavaClass.saves;
      case "objectTitle":
        return oComputateJavaClass.objectTitle;
      case "objectId":
        return oComputateJavaClass.objectId;
      case "objectSuggest":
        return oComputateJavaClass.objectSuggest;
      case "objectText":
        return oComputateJavaClass.objectText;
      case "pageUrlId":
        return oComputateJavaClass.pageUrlId;
      case "pageUrlPk":
        return oComputateJavaClass.pageUrlPk;
      case "pageUrlApi":
        return oComputateJavaClass.pageUrlApi;
      case "doc":
        return oComputateJavaClass.doc;
      case "sitePath":
        return oComputateJavaClass.sitePath;
      case "siteName":
        return oComputateJavaClass.siteName;
      case "superClassParamsTypeName":
        return oComputateJavaClass.superClassParamsTypeName;
      case "superClassCompleteName":
        return oComputateJavaClass.superClassCompleteName;
      case "superClassGenericCompleteName":
        return oComputateJavaClass.superClassGenericCompleteName;
      case "superClassGenericCanonicalName":
        return oComputateJavaClass.superClassGenericCanonicalName;
      case "superClassGenericSimpleName":
        return oComputateJavaClass.superClassGenericSimpleName;
      case "classIsBase":
        return oComputateJavaClass.classIsBase;
      case "classExtendsBase":
        return oComputateJavaClass.classExtendsBase;
      case "classBaseExtendsGen":
        return oComputateJavaClass.classBaseExtendsGen;
      case "classContainsSiteRequest":
        return oComputateJavaClass.classContainsSiteRequest;
      case "classTranslate":
        return oComputateJavaClass.classTranslate;
      case "classInitDeep":
        return oComputateJavaClass.classInitDeep;
      case "classExtendsGen":
        return oComputateJavaClass.classExtendsGen;
      case "languageName":
        return oComputateJavaClass.languageName;
      case "modified":
        return oComputateJavaClass.modified;
      case "classCanonicalName":
        return oComputateJavaClass.classCanonicalName;
      case "classSimpleName":
        return oComputateJavaClass.classSimpleName;
      case "classPackageName":
        return oComputateJavaClass.classPackageName;
      case "classCanonicalNameGen":
        return oComputateJavaClass.classCanonicalNameGen;
      case "classSimpleNameGen":
        return oComputateJavaClass.classSimpleNameGen;
      case "superClassCanonicalName":
        return oComputateJavaClass.superClassCanonicalName;
      case "superClassSimpleName":
        return oComputateJavaClass.superClassSimpleName;
      case "classAbsolutePath":
        return oComputateJavaClass.classAbsolutePath;
      case "classPath":
        return oComputateJavaClass.classPath;
      case "classDirectoryPath":
        return oComputateJavaClass.classDirectoryPath;
      case "classPathGen":
        return oComputateJavaClass.classPathGen;
      case "classDirectoryPathGen":
        return oComputateJavaClass.classDirectoryPathGen;
      case "domainPackageName":
        return oComputateJavaClass.domainPackageName;
      case "entityClassesSuperAndMeWithoutGen":
        return oComputateJavaClass.entityClassesSuperAndMeWithoutGen;
      case "classIsAbstract":
        return oComputateJavaClass.classIsAbstract;
      case "classModel":
        return oComputateJavaClass.classModel;
      case "classApi":
        return oComputateJavaClass.classApi;
      case "classSimplePage":
        return oComputateJavaClass.classSimplePage;
      case "classSaved":
        return oComputateJavaClass.classSaved;
      case "classSimpleNameApiPackageInfo":
        return oComputateJavaClass.classSimpleNameApiPackageInfo;
      case "classSimpleNameGenApiServiceImpl":
        return oComputateJavaClass.classSimpleNameGenApiServiceImpl;
      case "classSimpleNameApiServiceImpl":
        return oComputateJavaClass.classSimpleNameApiServiceImpl;
      case "classSimpleNameGenApiService":
        return oComputateJavaClass.classSimpleNameGenApiService;
      case "classCanonicalNameApiPackageInfo":
        return oComputateJavaClass.classCanonicalNameApiPackageInfo;
      case "classCanonicalNameGenApiServiceImpl":
        return oComputateJavaClass.classCanonicalNameGenApiServiceImpl;
      case "classCanonicalNameApiServiceImpl":
        return oComputateJavaClass.classCanonicalNameApiServiceImpl;
      case "classCanonicalNameGenApiService":
        return oComputateJavaClass.classCanonicalNameGenApiService;
      case "classPathApiPackageInfo":
        return oComputateJavaClass.classPathApiPackageInfo;
      case "classPathGenApiServiceImpl":
        return oComputateJavaClass.classPathGenApiServiceImpl;
      case "classPathApiServiceImpl":
        return oComputateJavaClass.classPathApiServiceImpl;
      case "classPathGenApiService":
        return oComputateJavaClass.classPathGenApiService;
      case "classPublicRead":
        return oComputateJavaClass.classPublicRead;
      case "classRoleSession":
        return oComputateJavaClass.classRoleSession;
      case "classRoleUser":
        return oComputateJavaClass.classRoleUser;
      case "classRoleEach":
        return oComputateJavaClass.classRoleEach;
      case "classRoles":
        return oComputateJavaClass.classRoles;
      case "classRolesLanguage":
        return oComputateJavaClass.classRolesLanguage;
      case "classRolesFound":
        return oComputateJavaClass.classRolesFound;
      case "classRoleReadFound":
        return oComputateJavaClass.classRoleReadFound;
      case "classSessionWrite":
        return oComputateJavaClass.classSessionWrite;
      case "classUserWrite":
        return oComputateJavaClass.classUserWrite;
      case "classPublicWrite":
        return oComputateJavaClass.classPublicWrite;
      case "classSessionRead":
        return oComputateJavaClass.classSessionRead;
      case "classUserRead":
        return oComputateJavaClass.classUserRead;
      case "classFiltersFound":
        return oComputateJavaClass.classFiltersFound;
      case "sqlSort":
        return oComputateJavaClass.sqlSort;
      case "id":
        return oComputateJavaClass.id;
      case "partIsClass":
        return oComputateJavaClass.partIsClass;
      case "partNumber":
        return oComputateJavaClass.partNumber;
      case "classImports":
        return oComputateJavaClass.classImports;
      case "classEntityVars":
        return oComputateJavaClass.classEntityVars;
      case "classImportsGenApi":
        return oComputateJavaClass.classImportsGenApi;
      case "classAttributeSimpleNamePages":
        return oComputateJavaClass.classAttributeSimpleNamePages;
      case "classMethodVars":
        return oComputateJavaClass.classMethodVars;
      case "classVarSuggested":
        return oComputateJavaClass.classVarSuggested;
      case "classVarText":
        return oComputateJavaClass.classVarText;
      case "classVarPrimaryKey":
        return oComputateJavaClass.classVarPrimaryKey;
      case "classVarInheritPrimaryKey":
        return oComputateJavaClass.classVarInheritPrimaryKey;
      case "classVarSaves":
        return oComputateJavaClass.classVarSaves;
      case "classvarUniqueKey":
        return oComputateJavaClass.classvarUniqueKey;
      case "classVarModified":
        return oComputateJavaClass.classVarModified;
      case "classVarCreated":
        return oComputateJavaClass.classVarCreated;
      case "classVarUrlId":
        return oComputateJavaClass.classVarUrlId;
      case "classVarUrlPk":
        return oComputateJavaClass.classVarUrlPk;
      case "classVarId":
        return oComputateJavaClass.classVarId;
      case "classVarTitle":
        return oComputateJavaClass.classVarTitle;
      case "classKeywordsFound":
        return oComputateJavaClass.classKeywordsFound;
      case "classPageCanonicalName":
        return oComputateJavaClass.classPageCanonicalName;
      case "classPageSimpleName":
        return oComputateJavaClass.classPageSimpleName;
      case "classGenPageSimpleName":
        return oComputateJavaClass.classGenPageSimpleName;
      case "classGenPageCanonicalName":
        return oComputateJavaClass.classGenPageCanonicalName;
      case "classGenPagePath":
        return oComputateJavaClass.classGenPagePath;
      case "classPagePath":
        return oComputateJavaClass.classPagePath;
      case "classPagePathCss":
        return oComputateJavaClass.classPagePathCss;
      case "classPagePathJs":
        return oComputateJavaClass.classPagePathJs;
      case "classPagePathHbs":
        return oComputateJavaClass.classPagePathHbs;
      case "classGenPagePathHbs":
        return oComputateJavaClass.classGenPagePathHbs;
      case "classPageLanguageName":
        return oComputateJavaClass.classPageLanguageName;
      case "classPageSuperCanonicalName":
        return oComputateJavaClass.classPageSuperCanonicalName;
      case "classSuperPageSimpleName":
        return oComputateJavaClass.classSuperPageSimpleName;
      case "classImportsGenPage":
        return oComputateJavaClass.classImportsGenPage;
      case "classApiUri":
        return oComputateJavaClass.classApiUri;
      case "classApiTag":
        return oComputateJavaClass.classApiTag;
      case "classApiMethods":
        return oComputateJavaClass.classApiMethods;
      case "classContext":
        return oComputateJavaClass.classContext;
      case "contextColor":
        return oComputateJavaClass.contextColor;
      case "contextIconGroup":
        return oComputateJavaClass.contextIconGroup;
      case "contextIconName":
        return oComputateJavaClass.contextIconName;
      case "contextRows":
        return oComputateJavaClass.contextRows;
      case "contextAName":
        return oComputateJavaClass.contextAName;
      case "contextNameSingular":
        return oComputateJavaClass.contextNameSingular;
      case "contextNamePlural":
        return oComputateJavaClass.contextNamePlural;
      case "contextNameVar":
        return oComputateJavaClass.contextNameVar;
      case "contextTheNames":
        return oComputateJavaClass.contextTheNames;
      case "contextNameAdjectiveSingular":
        return oComputateJavaClass.contextNameAdjectiveSingular;
      case "contextNameAdjectivePlural":
        return oComputateJavaClass.contextNameAdjectivePlural;
      case "contextThis":
        return oComputateJavaClass.contextThis;
      case "contextA":
        return oComputateJavaClass.contextA;
      case "contextCreated":
        return oComputateJavaClass.contextCreated;
      case "contextModified":
        return oComputateJavaClass.contextModified;
      case "contextActualName":
        return oComputateJavaClass.contextActualName;
      case "contextAll":
        return oComputateJavaClass.contextAll;
      case "contextAllName":
        return oComputateJavaClass.contextAllName;
      case "contextSearchAllNameBy":
        return oComputateJavaClass.contextSearchAllNameBy;
      case "contextSearchAllName":
        return oComputateJavaClass.contextSearchAllName;
      case "contextNoNameFound":
        return oComputateJavaClass.contextNoNameFound;
      case "contextANameAdjective":
        return oComputateJavaClass.contextANameAdjective;
      case "contextThisName":
        return oComputateJavaClass.contextThisName;
      case "contextTheName":
        return oComputateJavaClass.contextTheName;
      case "contextOfName":
        return oComputateJavaClass.contextOfName;
      case "contextThisLowercase":
        return oComputateJavaClass.contextThisLowercase;
      case "contextTitle":
        return oComputateJavaClass.contextTitle;
      case "classIndexed":
        return oComputateJavaClass.classIndexed;
      case "classImage":
        return oComputateJavaClass.classImage;
      case "classPromise":
        return oComputateJavaClass.classPromise;
      case "classImportsGen":
        return oComputateJavaClass.classImportsGen;
      case "classSortsFound":
        return oComputateJavaClass.classSortsFound;
      case "classSortsSuffixType":
        return oComputateJavaClass.classSortsSuffixType;
      case "classSortsOrder":
        return oComputateJavaClass.classSortsOrder;
      case "classSortsVar":
        return oComputateJavaClass.classSortsVar;
      case "classPage":
        return oComputateJavaClass.classPage;
      case "version":
        return oComputateJavaClass.version;
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
        o = relateComputateJavaClass(v, val);
    }
    return o != null;
  }
  public Object relateComputateJavaClass(String var, Object val) {
    ComputateJavaClass oComputateJavaClass = (ComputateJavaClass)this;
    switch(var) {
      default:
        return null;
    }
  }

  ///////////////
  // staticSet //
  ///////////////

  public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String v, ComputateJavaClass o) {
    return staticSetComputateJavaClass(entityVar,  siteRequest_, v, o);
  }
  public static Object staticSetComputateJavaClass(String entityVar, ComputateSiteRequest siteRequest_, String v, ComputateJavaClass o) {
    switch(entityVar) {
    case "inheritPk":
      return ComputateJavaClass.staticSetInheritPk(siteRequest_, v);
    case "created":
    case "archived":
      return ComputateJavaClass.staticSetArchived(siteRequest_, v);
    case "deleted":
      return ComputateJavaClass.staticSetDeleted(siteRequest_, v);
    case "classCanonicalNames":
      return ComputateJavaClass.staticSetClassCanonicalNames(siteRequest_, v);
    case "sessionId":
      return ComputateJavaClass.staticSetSessionId(siteRequest_, v);
    case "userKey":
      return ComputateJavaClass.staticSetUserKey(siteRequest_, v);
    case "saves":
      return ComputateJavaClass.staticSetSaves(siteRequest_, v);
    case "objectTitle":
      return ComputateJavaClass.staticSetObjectTitle(siteRequest_, v);
    case "objectId":
      return ComputateJavaClass.staticSetObjectId(siteRequest_, v);
    case "objectSuggest":
      return ComputateJavaClass.staticSetObjectSuggest(siteRequest_, v);
    case "objectText":
      return ComputateJavaClass.staticSetObjectText(siteRequest_, v);
    case "pageUrlId":
      return ComputateJavaClass.staticSetPageUrlId(siteRequest_, v);
    case "pageUrlPk":
      return ComputateJavaClass.staticSetPageUrlPk(siteRequest_, v);
    case "pageUrlApi":
      return ComputateJavaClass.staticSetPageUrlApi(siteRequest_, v);
    case "doc":
      return ComputateJavaClass.staticSetDoc(siteRequest_, v);
    case "sitePath":
      return ComputateJavaClass.staticSetSitePath(siteRequest_, v);
    case "siteName":
      return ComputateJavaClass.staticSetSiteName(siteRequest_, v);
    case "superClassParamsTypeName":
      return ComputateJavaClass.staticSetSuperClassParamsTypeName(siteRequest_, v);
    case "superClassCompleteName":
      return ComputateJavaClass.staticSetSuperClassCompleteName(siteRequest_, v);
    case "superClassGenericCompleteName":
      return ComputateJavaClass.staticSetSuperClassGenericCompleteName(siteRequest_, v);
    case "superClassGenericCanonicalName":
      return ComputateJavaClass.staticSetSuperClassGenericCanonicalName(siteRequest_, v);
    case "superClassGenericSimpleName":
      return ComputateJavaClass.staticSetSuperClassGenericSimpleName(siteRequest_, v);
    case "classIsBase":
      return ComputateJavaClass.staticSetClassIsBase(siteRequest_, v);
    case "classExtendsBase":
      return ComputateJavaClass.staticSetClassExtendsBase(siteRequest_, v);
    case "classBaseExtendsGen":
      return ComputateJavaClass.staticSetClassBaseExtendsGen(siteRequest_, v);
    case "classContainsSiteRequest":
      return ComputateJavaClass.staticSetClassContainsSiteRequest(siteRequest_, v);
    case "classTranslate":
      return ComputateJavaClass.staticSetClassTranslate(siteRequest_, v);
    case "classInitDeep":
      return ComputateJavaClass.staticSetClassInitDeep(siteRequest_, v);
    case "classExtendsGen":
      return ComputateJavaClass.staticSetClassExtendsGen(siteRequest_, v);
    case "languageName":
      return ComputateJavaClass.staticSetLanguageName(siteRequest_, v);
    case "modified":
      return ComputateJavaClass.staticSetModified(siteRequest_, v);
    case "classCanonicalName":
      return ComputateJavaClass.staticSetClassCanonicalName(siteRequest_, v);
    case "classSimpleName":
      return ComputateJavaClass.staticSetClassSimpleName(siteRequest_, v);
    case "classPackageName":
      return ComputateJavaClass.staticSetClassPackageName(siteRequest_, v);
    case "classCanonicalNameGen":
      return ComputateJavaClass.staticSetClassCanonicalNameGen(siteRequest_, v);
    case "classSimpleNameGen":
      return ComputateJavaClass.staticSetClassSimpleNameGen(siteRequest_, v);
    case "superClassCanonicalName":
      return ComputateJavaClass.staticSetSuperClassCanonicalName(siteRequest_, v);
    case "superClassSimpleName":
      return ComputateJavaClass.staticSetSuperClassSimpleName(siteRequest_, v);
    case "classAbsolutePath":
      return ComputateJavaClass.staticSetClassAbsolutePath(siteRequest_, v);
    case "classPath":
      return ComputateJavaClass.staticSetClassPath(siteRequest_, v);
    case "classDirectoryPath":
      return ComputateJavaClass.staticSetClassDirectoryPath(siteRequest_, v);
    case "classPathGen":
      return ComputateJavaClass.staticSetClassPathGen(siteRequest_, v);
    case "classDirectoryPathGen":
      return ComputateJavaClass.staticSetClassDirectoryPathGen(siteRequest_, v);
    case "domainPackageName":
      return ComputateJavaClass.staticSetDomainPackageName(siteRequest_, v);
    case "entityClassesSuperAndMeWithoutGen":
      return ComputateJavaClass.staticSetEntityClassesSuperAndMeWithoutGen(siteRequest_, v);
    case "classIsAbstract":
      return ComputateJavaClass.staticSetClassIsAbstract(siteRequest_, v);
    case "classModel":
      return ComputateJavaClass.staticSetClassModel(siteRequest_, v);
    case "classApi":
      return ComputateJavaClass.staticSetClassApi(siteRequest_, v);
    case "classSimplePage":
      return ComputateJavaClass.staticSetClassSimplePage(siteRequest_, v);
    case "classSaved":
      return ComputateJavaClass.staticSetClassSaved(siteRequest_, v);
    case "classSimpleNameApiPackageInfo":
      return ComputateJavaClass.staticSetClassSimpleNameApiPackageInfo(siteRequest_, v);
    case "classSimpleNameGenApiServiceImpl":
      return ComputateJavaClass.staticSetClassSimpleNameGenApiServiceImpl(siteRequest_, v);
    case "classSimpleNameApiServiceImpl":
      return ComputateJavaClass.staticSetClassSimpleNameApiServiceImpl(siteRequest_, v);
    case "classSimpleNameGenApiService":
      return ComputateJavaClass.staticSetClassSimpleNameGenApiService(siteRequest_, v);
    case "classCanonicalNameApiPackageInfo":
      return ComputateJavaClass.staticSetClassCanonicalNameApiPackageInfo(siteRequest_, v);
    case "classCanonicalNameGenApiServiceImpl":
      return ComputateJavaClass.staticSetClassCanonicalNameGenApiServiceImpl(siteRequest_, v);
    case "classCanonicalNameApiServiceImpl":
      return ComputateJavaClass.staticSetClassCanonicalNameApiServiceImpl(siteRequest_, v);
    case "classCanonicalNameGenApiService":
      return ComputateJavaClass.staticSetClassCanonicalNameGenApiService(siteRequest_, v);
    case "classPathApiPackageInfo":
      return ComputateJavaClass.staticSetClassPathApiPackageInfo(siteRequest_, v);
    case "classPathGenApiServiceImpl":
      return ComputateJavaClass.staticSetClassPathGenApiServiceImpl(siteRequest_, v);
    case "classPathApiServiceImpl":
      return ComputateJavaClass.staticSetClassPathApiServiceImpl(siteRequest_, v);
    case "classPathGenApiService":
      return ComputateJavaClass.staticSetClassPathGenApiService(siteRequest_, v);
    case "classPublicRead":
      return ComputateJavaClass.staticSetClassPublicRead(siteRequest_, v);
    case "classRoleSession":
      return ComputateJavaClass.staticSetClassRoleSession(siteRequest_, v);
    case "classRoleUser":
      return ComputateJavaClass.staticSetClassRoleUser(siteRequest_, v);
    case "classRoleEach":
      return ComputateJavaClass.staticSetClassRoleEach(siteRequest_, v);
    case "classRoles":
      return ComputateJavaClass.staticSetClassRoles(siteRequest_, v);
    case "classRolesLanguage":
      return ComputateJavaClass.staticSetClassRolesLanguage(siteRequest_, v);
    case "classRolesFound":
      return ComputateJavaClass.staticSetClassRolesFound(siteRequest_, v);
    case "classRoleReadFound":
      return ComputateJavaClass.staticSetClassRoleReadFound(siteRequest_, v);
    case "classSessionWrite":
      return ComputateJavaClass.staticSetClassSessionWrite(siteRequest_, v);
    case "classUserWrite":
      return ComputateJavaClass.staticSetClassUserWrite(siteRequest_, v);
    case "classPublicWrite":
      return ComputateJavaClass.staticSetClassPublicWrite(siteRequest_, v);
    case "classSessionRead":
      return ComputateJavaClass.staticSetClassSessionRead(siteRequest_, v);
    case "classUserRead":
      return ComputateJavaClass.staticSetClassUserRead(siteRequest_, v);
    case "classFiltersFound":
      return ComputateJavaClass.staticSetClassFiltersFound(siteRequest_, v);
    case "sqlSort":
      return ComputateJavaClass.staticSetSqlSort(siteRequest_, v);
    case "id":
      return ComputateJavaClass.staticSetId(siteRequest_, v);
    case "partIsClass":
      return ComputateJavaClass.staticSetPartIsClass(siteRequest_, v);
    case "partNumber":
      return ComputateJavaClass.staticSetPartNumber(siteRequest_, v);
    case "classImports":
      return ComputateJavaClass.staticSetClassImports(siteRequest_, v);
    case "classEntityVars":
      return ComputateJavaClass.staticSetClassEntityVars(siteRequest_, v);
    case "classImportsGenApi":
      return ComputateJavaClass.staticSetClassImportsGenApi(siteRequest_, v);
    case "classAttributeSimpleNamePages":
      return ComputateJavaClass.staticSetClassAttributeSimpleNamePages(siteRequest_, v);
    case "classMethodVars":
      return ComputateJavaClass.staticSetClassMethodVars(siteRequest_, v);
    case "classVarSuggested":
      return ComputateJavaClass.staticSetClassVarSuggested(siteRequest_, v);
    case "classVarText":
      return ComputateJavaClass.staticSetClassVarText(siteRequest_, v);
    case "classVarPrimaryKey":
      return ComputateJavaClass.staticSetClassVarPrimaryKey(siteRequest_, v);
    case "classVarInheritPrimaryKey":
      return ComputateJavaClass.staticSetClassVarInheritPrimaryKey(siteRequest_, v);
    case "classVarSaves":
      return ComputateJavaClass.staticSetClassVarSaves(siteRequest_, v);
    case "classvarUniqueKey":
      return ComputateJavaClass.staticSetClassvarUniqueKey(siteRequest_, v);
    case "classVarModified":
      return ComputateJavaClass.staticSetClassVarModified(siteRequest_, v);
    case "classVarCreated":
      return ComputateJavaClass.staticSetClassVarCreated(siteRequest_, v);
    case "classVarUrlId":
      return ComputateJavaClass.staticSetClassVarUrlId(siteRequest_, v);
    case "classVarUrlPk":
      return ComputateJavaClass.staticSetClassVarUrlPk(siteRequest_, v);
    case "classVarId":
      return ComputateJavaClass.staticSetClassVarId(siteRequest_, v);
    case "classVarTitle":
      return ComputateJavaClass.staticSetClassVarTitle(siteRequest_, v);
    case "classKeywordsFound":
      return ComputateJavaClass.staticSetClassKeywordsFound(siteRequest_, v);
    case "classPageCanonicalName":
      return ComputateJavaClass.staticSetClassPageCanonicalName(siteRequest_, v);
    case "classPageSimpleName":
      return ComputateJavaClass.staticSetClassPageSimpleName(siteRequest_, v);
    case "classGenPageSimpleName":
      return ComputateJavaClass.staticSetClassGenPageSimpleName(siteRequest_, v);
    case "classGenPageCanonicalName":
      return ComputateJavaClass.staticSetClassGenPageCanonicalName(siteRequest_, v);
    case "classGenPagePath":
      return ComputateJavaClass.staticSetClassGenPagePath(siteRequest_, v);
    case "classPagePath":
      return ComputateJavaClass.staticSetClassPagePath(siteRequest_, v);
    case "classPagePathCss":
      return ComputateJavaClass.staticSetClassPagePathCss(siteRequest_, v);
    case "classPagePathJs":
      return ComputateJavaClass.staticSetClassPagePathJs(siteRequest_, v);
    case "classPagePathHbs":
      return ComputateJavaClass.staticSetClassPagePathHbs(siteRequest_, v);
    case "classGenPagePathHbs":
      return ComputateJavaClass.staticSetClassGenPagePathHbs(siteRequest_, v);
    case "classPageLanguageName":
      return ComputateJavaClass.staticSetClassPageLanguageName(siteRequest_, v);
    case "classPageSuperCanonicalName":
      return ComputateJavaClass.staticSetClassPageSuperCanonicalName(siteRequest_, v);
    case "classSuperPageSimpleName":
      return ComputateJavaClass.staticSetClassSuperPageSimpleName(siteRequest_, v);
    case "classImportsGenPage":
      return ComputateJavaClass.staticSetClassImportsGenPage(siteRequest_, v);
    case "classApiUri":
      return ComputateJavaClass.staticSetClassApiUri(siteRequest_, v);
    case "classApiTag":
      return ComputateJavaClass.staticSetClassApiTag(siteRequest_, v);
    case "classApiMethods":
      return ComputateJavaClass.staticSetClassApiMethods(siteRequest_, v);
    case "classContext":
      return ComputateJavaClass.staticSetClassContext(siteRequest_, v);
    case "contextColor":
      return ComputateJavaClass.staticSetContextColor(siteRequest_, v);
    case "contextIconGroup":
      return ComputateJavaClass.staticSetContextIconGroup(siteRequest_, v);
    case "contextIconName":
      return ComputateJavaClass.staticSetContextIconName(siteRequest_, v);
    case "contextRows":
      return ComputateJavaClass.staticSetContextRows(siteRequest_, v);
    case "contextAName":
      return ComputateJavaClass.staticSetContextAName(siteRequest_, v);
    case "contextNameSingular":
      return ComputateJavaClass.staticSetContextNameSingular(siteRequest_, v);
    case "contextNamePlural":
      return ComputateJavaClass.staticSetContextNamePlural(siteRequest_, v);
    case "contextNameVar":
      return ComputateJavaClass.staticSetContextNameVar(siteRequest_, v);
    case "contextTheNames":
      return ComputateJavaClass.staticSetContextTheNames(siteRequest_, v);
    case "contextNameAdjectiveSingular":
      return ComputateJavaClass.staticSetContextNameAdjectiveSingular(siteRequest_, v);
    case "contextNameAdjectivePlural":
      return ComputateJavaClass.staticSetContextNameAdjectivePlural(siteRequest_, v);
    case "contextThis":
      return ComputateJavaClass.staticSetContextThis(siteRequest_, v);
    case "contextA":
      return ComputateJavaClass.staticSetContextA(siteRequest_, v);
    case "contextCreated":
      return ComputateJavaClass.staticSetContextCreated(siteRequest_, v);
    case "contextModified":
      return ComputateJavaClass.staticSetContextModified(siteRequest_, v);
    case "contextActualName":
      return ComputateJavaClass.staticSetContextActualName(siteRequest_, v);
    case "contextAll":
      return ComputateJavaClass.staticSetContextAll(siteRequest_, v);
    case "contextAllName":
      return ComputateJavaClass.staticSetContextAllName(siteRequest_, v);
    case "contextSearchAllNameBy":
      return ComputateJavaClass.staticSetContextSearchAllNameBy(siteRequest_, v);
    case "contextSearchAllName":
      return ComputateJavaClass.staticSetContextSearchAllName(siteRequest_, v);
    case "contextNoNameFound":
      return ComputateJavaClass.staticSetContextNoNameFound(siteRequest_, v);
    case "contextANameAdjective":
      return ComputateJavaClass.staticSetContextANameAdjective(siteRequest_, v);
    case "contextThisName":
      return ComputateJavaClass.staticSetContextThisName(siteRequest_, v);
    case "contextTheName":
      return ComputateJavaClass.staticSetContextTheName(siteRequest_, v);
    case "contextOfName":
      return ComputateJavaClass.staticSetContextOfName(siteRequest_, v);
    case "contextThisLowercase":
      return ComputateJavaClass.staticSetContextThisLowercase(siteRequest_, v);
    case "contextTitle":
      return ComputateJavaClass.staticSetContextTitle(siteRequest_, v);
    case "classIndexed":
      return ComputateJavaClass.staticSetClassIndexed(siteRequest_, v);
    case "classImage":
      return ComputateJavaClass.staticSetClassImage(siteRequest_, v);
    case "classPromise":
      return ComputateJavaClass.staticSetClassPromise(siteRequest_, v);
    case "classImportsGen":
      return ComputateJavaClass.staticSetClassImportsGen(siteRequest_, v);
    case "classSortsFound":
      return ComputateJavaClass.staticSetClassSortsFound(siteRequest_, v);
    case "classSortsSuffixType":
      return ComputateJavaClass.staticSetClassSortsSuffixType(siteRequest_, v);
    case "classSortsOrder":
      return ComputateJavaClass.staticSetClassSortsOrder(siteRequest_, v);
    case "classSortsVar":
      return ComputateJavaClass.staticSetClassSortsVar(siteRequest_, v);
    case "classPage":
      return ComputateJavaClass.staticSetClassPage(siteRequest_, v);
    case "version":
      return ComputateJavaClass.staticSetVersion(siteRequest_, v);
      default:
        return null;
    }
  }

  ////////////////
  // staticSearch //
  ////////////////

  public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    return staticSearchComputateJavaClass(entityVar,  siteRequest_, o);
  }
  public static Object staticSearchComputateJavaClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "inheritPk":
      return ComputateJavaClass.staticSearchInheritPk(siteRequest_, (String)o);
    case "created":
      return ComputateJavaClass.staticSearchCreated(siteRequest_, (ZonedDateTime)o);
    case "archived":
      return ComputateJavaClass.staticSearchArchived(siteRequest_, (Boolean)o);
    case "deleted":
      return ComputateJavaClass.staticSearchDeleted(siteRequest_, (Boolean)o);
    case "classCanonicalNames":
      return ComputateJavaClass.staticSearchClassCanonicalNames(siteRequest_, (String)o);
    case "sessionId":
      return ComputateJavaClass.staticSearchSessionId(siteRequest_, (String)o);
    case "userKey":
      return ComputateJavaClass.staticSearchUserKey(siteRequest_, (Long)o);
    case "saves":
      return ComputateJavaClass.staticSearchSaves(siteRequest_, (String)o);
    case "objectTitle":
      return ComputateJavaClass.staticSearchObjectTitle(siteRequest_, (String)o);
    case "objectId":
      return ComputateJavaClass.staticSearchObjectId(siteRequest_, (String)o);
    case "objectSuggest":
      return ComputateJavaClass.staticSearchObjectSuggest(siteRequest_, (String)o);
    case "objectText":
      return ComputateJavaClass.staticSearchObjectText(siteRequest_, (String)o);
    case "pageUrlId":
      return ComputateJavaClass.staticSearchPageUrlId(siteRequest_, (String)o);
    case "pageUrlPk":
      return ComputateJavaClass.staticSearchPageUrlPk(siteRequest_, (String)o);
    case "pageUrlApi":
      return ComputateJavaClass.staticSearchPageUrlApi(siteRequest_, (String)o);
    case "doc":
      return ComputateJavaClass.staticSearchDoc(siteRequest_, (JsonObject)o);
    case "sitePath":
      return ComputateJavaClass.staticSearchSitePath(siteRequest_, (String)o);
    case "siteName":
      return ComputateJavaClass.staticSearchSiteName(siteRequest_, (String)o);
    case "superClassParamsTypeName":
      return ComputateJavaClass.staticSearchSuperClassParamsTypeName(siteRequest_, (String)o);
    case "superClassCompleteName":
      return ComputateJavaClass.staticSearchSuperClassCompleteName(siteRequest_, (String)o);
    case "superClassGenericCompleteName":
      return ComputateJavaClass.staticSearchSuperClassGenericCompleteName(siteRequest_, (String)o);
    case "superClassGenericCanonicalName":
      return ComputateJavaClass.staticSearchSuperClassGenericCanonicalName(siteRequest_, (String)o);
    case "superClassGenericSimpleName":
      return ComputateJavaClass.staticSearchSuperClassGenericSimpleName(siteRequest_, (String)o);
    case "classIsBase":
      return ComputateJavaClass.staticSearchClassIsBase(siteRequest_, (Boolean)o);
    case "classExtendsBase":
      return ComputateJavaClass.staticSearchClassExtendsBase(siteRequest_, (Boolean)o);
    case "classBaseExtendsGen":
      return ComputateJavaClass.staticSearchClassBaseExtendsGen(siteRequest_, (Boolean)o);
    case "classContainsSiteRequest":
      return ComputateJavaClass.staticSearchClassContainsSiteRequest(siteRequest_, (Boolean)o);
    case "classTranslate":
      return ComputateJavaClass.staticSearchClassTranslate(siteRequest_, (Boolean)o);
    case "classInitDeep":
      return ComputateJavaClass.staticSearchClassInitDeep(siteRequest_, (Boolean)o);
    case "classExtendsGen":
      return ComputateJavaClass.staticSearchClassExtendsGen(siteRequest_, (Boolean)o);
    case "languageName":
      return ComputateJavaClass.staticSearchLanguageName(siteRequest_, (String)o);
    case "modified":
      return ComputateJavaClass.staticSearchModified(siteRequest_, (String)o);
    case "classCanonicalName":
      return ComputateJavaClass.staticSearchClassCanonicalName(siteRequest_, (String)o);
    case "classSimpleName":
      return ComputateJavaClass.staticSearchClassSimpleName(siteRequest_, (String)o);
    case "classPackageName":
      return ComputateJavaClass.staticSearchClassPackageName(siteRequest_, (String)o);
    case "classCanonicalNameGen":
      return ComputateJavaClass.staticSearchClassCanonicalNameGen(siteRequest_, (String)o);
    case "classSimpleNameGen":
      return ComputateJavaClass.staticSearchClassSimpleNameGen(siteRequest_, (String)o);
    case "superClassCanonicalName":
      return ComputateJavaClass.staticSearchSuperClassCanonicalName(siteRequest_, (String)o);
    case "superClassSimpleName":
      return ComputateJavaClass.staticSearchSuperClassSimpleName(siteRequest_, (String)o);
    case "classAbsolutePath":
      return ComputateJavaClass.staticSearchClassAbsolutePath(siteRequest_, (String)o);
    case "classPath":
      return ComputateJavaClass.staticSearchClassPath(siteRequest_, (String)o);
    case "classDirectoryPath":
      return ComputateJavaClass.staticSearchClassDirectoryPath(siteRequest_, (String)o);
    case "classPathGen":
      return ComputateJavaClass.staticSearchClassPathGen(siteRequest_, (String)o);
    case "classDirectoryPathGen":
      return ComputateJavaClass.staticSearchClassDirectoryPathGen(siteRequest_, (String)o);
    case "domainPackageName":
      return ComputateJavaClass.staticSearchDomainPackageName(siteRequest_, (String)o);
    case "entityClassesSuperAndMeWithoutGen":
      return ComputateJavaClass.staticSearchEntityClassesSuperAndMeWithoutGen(siteRequest_, (String)o);
    case "classIsAbstract":
      return ComputateJavaClass.staticSearchClassIsAbstract(siteRequest_, (Boolean)o);
    case "classModel":
      return ComputateJavaClass.staticSearchClassModel(siteRequest_, (Boolean)o);
    case "classApi":
      return ComputateJavaClass.staticSearchClassApi(siteRequest_, (Boolean)o);
    case "classSimplePage":
      return ComputateJavaClass.staticSearchClassSimplePage(siteRequest_, (Boolean)o);
    case "classSaved":
      return ComputateJavaClass.staticSearchClassSaved(siteRequest_, (Boolean)o);
    case "classSimpleNameApiPackageInfo":
      return ComputateJavaClass.staticSearchClassSimpleNameApiPackageInfo(siteRequest_, (String)o);
    case "classSimpleNameGenApiServiceImpl":
      return ComputateJavaClass.staticSearchClassSimpleNameGenApiServiceImpl(siteRequest_, (String)o);
    case "classSimpleNameApiServiceImpl":
      return ComputateJavaClass.staticSearchClassSimpleNameApiServiceImpl(siteRequest_, (String)o);
    case "classSimpleNameGenApiService":
      return ComputateJavaClass.staticSearchClassSimpleNameGenApiService(siteRequest_, (String)o);
    case "classCanonicalNameApiPackageInfo":
      return ComputateJavaClass.staticSearchClassCanonicalNameApiPackageInfo(siteRequest_, (String)o);
    case "classCanonicalNameGenApiServiceImpl":
      return ComputateJavaClass.staticSearchClassCanonicalNameGenApiServiceImpl(siteRequest_, (String)o);
    case "classCanonicalNameApiServiceImpl":
      return ComputateJavaClass.staticSearchClassCanonicalNameApiServiceImpl(siteRequest_, (String)o);
    case "classCanonicalNameGenApiService":
      return ComputateJavaClass.staticSearchClassCanonicalNameGenApiService(siteRequest_, (String)o);
    case "classPathApiPackageInfo":
      return ComputateJavaClass.staticSearchClassPathApiPackageInfo(siteRequest_, (String)o);
    case "classPathGenApiServiceImpl":
      return ComputateJavaClass.staticSearchClassPathGenApiServiceImpl(siteRequest_, (String)o);
    case "classPathApiServiceImpl":
      return ComputateJavaClass.staticSearchClassPathApiServiceImpl(siteRequest_, (String)o);
    case "classPathGenApiService":
      return ComputateJavaClass.staticSearchClassPathGenApiService(siteRequest_, (String)o);
    case "classPublicRead":
      return ComputateJavaClass.staticSearchClassPublicRead(siteRequest_, (Boolean)o);
    case "classRoleSession":
      return ComputateJavaClass.staticSearchClassRoleSession(siteRequest_, (Boolean)o);
    case "classRoleUser":
      return ComputateJavaClass.staticSearchClassRoleUser(siteRequest_, (Boolean)o);
    case "classRoleEach":
      return ComputateJavaClass.staticSearchClassRoleEach(siteRequest_, (Boolean)o);
    case "classRoles":
      return ComputateJavaClass.staticSearchClassRoles(siteRequest_, (String)o);
    case "classRolesLanguage":
      return ComputateJavaClass.staticSearchClassRolesLanguage(siteRequest_, (String)o);
    case "classRolesFound":
      return ComputateJavaClass.staticSearchClassRolesFound(siteRequest_, (Boolean)o);
    case "classRoleReadFound":
      return ComputateJavaClass.staticSearchClassRoleReadFound(siteRequest_, (Boolean)o);
    case "classSessionWrite":
      return ComputateJavaClass.staticSearchClassSessionWrite(siteRequest_, (Boolean)o);
    case "classUserWrite":
      return ComputateJavaClass.staticSearchClassUserWrite(siteRequest_, (Boolean)o);
    case "classPublicWrite":
      return ComputateJavaClass.staticSearchClassPublicWrite(siteRequest_, (Boolean)o);
    case "classSessionRead":
      return ComputateJavaClass.staticSearchClassSessionRead(siteRequest_, (Boolean)o);
    case "classUserRead":
      return ComputateJavaClass.staticSearchClassUserRead(siteRequest_, (Boolean)o);
    case "classFiltersFound":
      return ComputateJavaClass.staticSearchClassFiltersFound(siteRequest_, (Boolean)o);
    case "sqlSort":
      return ComputateJavaClass.staticSearchSqlSort(siteRequest_, (Integer)o);
    case "id":
      return ComputateJavaClass.staticSearchId(siteRequest_, (String)o);
    case "partIsClass":
      return ComputateJavaClass.staticSearchPartIsClass(siteRequest_, (Boolean)o);
    case "partNumber":
      return ComputateJavaClass.staticSearchPartNumber(siteRequest_, (Integer)o);
    case "classImports":
      return ComputateJavaClass.staticSearchClassImports(siteRequest_, (String)o);
    case "classEntityVars":
      return ComputateJavaClass.staticSearchClassEntityVars(siteRequest_, (String)o);
    case "classImportsGenApi":
      return ComputateJavaClass.staticSearchClassImportsGenApi(siteRequest_, (String)o);
    case "classAttributeSimpleNamePages":
      return ComputateJavaClass.staticSearchClassAttributeSimpleNamePages(siteRequest_, (String)o);
    case "classMethodVars":
      return ComputateJavaClass.staticSearchClassMethodVars(siteRequest_, (String)o);
    case "classVarSuggested":
      return ComputateJavaClass.staticSearchClassVarSuggested(siteRequest_, (String)o);
    case "classVarText":
      return ComputateJavaClass.staticSearchClassVarText(siteRequest_, (String)o);
    case "classVarPrimaryKey":
      return ComputateJavaClass.staticSearchClassVarPrimaryKey(siteRequest_, (String)o);
    case "classVarInheritPrimaryKey":
      return ComputateJavaClass.staticSearchClassVarInheritPrimaryKey(siteRequest_, (String)o);
    case "classVarSaves":
      return ComputateJavaClass.staticSearchClassVarSaves(siteRequest_, (String)o);
    case "classvarUniqueKey":
      return ComputateJavaClass.staticSearchClassvarUniqueKey(siteRequest_, (String)o);
    case "classVarModified":
      return ComputateJavaClass.staticSearchClassVarModified(siteRequest_, (String)o);
    case "classVarCreated":
      return ComputateJavaClass.staticSearchClassVarCreated(siteRequest_, (String)o);
    case "classVarUrlId":
      return ComputateJavaClass.staticSearchClassVarUrlId(siteRequest_, (String)o);
    case "classVarUrlPk":
      return ComputateJavaClass.staticSearchClassVarUrlPk(siteRequest_, (String)o);
    case "classVarId":
      return ComputateJavaClass.staticSearchClassVarId(siteRequest_, (String)o);
    case "classVarTitle":
      return ComputateJavaClass.staticSearchClassVarTitle(siteRequest_, (String)o);
    case "classKeywordsFound":
      return ComputateJavaClass.staticSearchClassKeywordsFound(siteRequest_, (Boolean)o);
    case "classPageCanonicalName":
      return ComputateJavaClass.staticSearchClassPageCanonicalName(siteRequest_, (String)o);
    case "classPageSimpleName":
      return ComputateJavaClass.staticSearchClassPageSimpleName(siteRequest_, (String)o);
    case "classGenPageSimpleName":
      return ComputateJavaClass.staticSearchClassGenPageSimpleName(siteRequest_, (String)o);
    case "classGenPageCanonicalName":
      return ComputateJavaClass.staticSearchClassGenPageCanonicalName(siteRequest_, (String)o);
    case "classGenPagePath":
      return ComputateJavaClass.staticSearchClassGenPagePath(siteRequest_, (String)o);
    case "classPagePath":
      return ComputateJavaClass.staticSearchClassPagePath(siteRequest_, (String)o);
    case "classPagePathCss":
      return ComputateJavaClass.staticSearchClassPagePathCss(siteRequest_, (String)o);
    case "classPagePathJs":
      return ComputateJavaClass.staticSearchClassPagePathJs(siteRequest_, (String)o);
    case "classPagePathHbs":
      return ComputateJavaClass.staticSearchClassPagePathHbs(siteRequest_, (String)o);
    case "classGenPagePathHbs":
      return ComputateJavaClass.staticSearchClassGenPagePathHbs(siteRequest_, (String)o);
    case "classPageLanguageName":
      return ComputateJavaClass.staticSearchClassPageLanguageName(siteRequest_, (String)o);
    case "classPageSuperCanonicalName":
      return ComputateJavaClass.staticSearchClassPageSuperCanonicalName(siteRequest_, (String)o);
    case "classSuperPageSimpleName":
      return ComputateJavaClass.staticSearchClassSuperPageSimpleName(siteRequest_, (String)o);
    case "classImportsGenPage":
      return ComputateJavaClass.staticSearchClassImportsGenPage(siteRequest_, (String)o);
    case "classApiUri":
      return ComputateJavaClass.staticSearchClassApiUri(siteRequest_, (String)o);
    case "classApiTag":
      return ComputateJavaClass.staticSearchClassApiTag(siteRequest_, (String)o);
    case "classApiMethods":
      return ComputateJavaClass.staticSearchClassApiMethods(siteRequest_, (String)o);
    case "classContext":
      return ComputateJavaClass.staticSearchClassContext(siteRequest_, (Boolean)o);
    case "contextColor":
      return ComputateJavaClass.staticSearchContextColor(siteRequest_, (String)o);
    case "contextIconGroup":
      return ComputateJavaClass.staticSearchContextIconGroup(siteRequest_, (String)o);
    case "contextIconName":
      return ComputateJavaClass.staticSearchContextIconName(siteRequest_, (String)o);
    case "contextRows":
      return ComputateJavaClass.staticSearchContextRows(siteRequest_, (Integer)o);
    case "contextAName":
      return ComputateJavaClass.staticSearchContextAName(siteRequest_, (String)o);
    case "contextNameSingular":
      return ComputateJavaClass.staticSearchContextNameSingular(siteRequest_, (String)o);
    case "contextNamePlural":
      return ComputateJavaClass.staticSearchContextNamePlural(siteRequest_, (String)o);
    case "contextNameVar":
      return ComputateJavaClass.staticSearchContextNameVar(siteRequest_, (String)o);
    case "contextTheNames":
      return ComputateJavaClass.staticSearchContextTheNames(siteRequest_, (String)o);
    case "contextNameAdjectiveSingular":
      return ComputateJavaClass.staticSearchContextNameAdjectiveSingular(siteRequest_, (String)o);
    case "contextNameAdjectivePlural":
      return ComputateJavaClass.staticSearchContextNameAdjectivePlural(siteRequest_, (String)o);
    case "contextThis":
      return ComputateJavaClass.staticSearchContextThis(siteRequest_, (String)o);
    case "contextA":
      return ComputateJavaClass.staticSearchContextA(siteRequest_, (String)o);
    case "contextCreated":
      return ComputateJavaClass.staticSearchContextCreated(siteRequest_, (String)o);
    case "contextModified":
      return ComputateJavaClass.staticSearchContextModified(siteRequest_, (String)o);
    case "contextActualName":
      return ComputateJavaClass.staticSearchContextActualName(siteRequest_, (String)o);
    case "contextAll":
      return ComputateJavaClass.staticSearchContextAll(siteRequest_, (String)o);
    case "contextAllName":
      return ComputateJavaClass.staticSearchContextAllName(siteRequest_, (String)o);
    case "contextSearchAllNameBy":
      return ComputateJavaClass.staticSearchContextSearchAllNameBy(siteRequest_, (String)o);
    case "contextSearchAllName":
      return ComputateJavaClass.staticSearchContextSearchAllName(siteRequest_, (String)o);
    case "contextNoNameFound":
      return ComputateJavaClass.staticSearchContextNoNameFound(siteRequest_, (String)o);
    case "contextANameAdjective":
      return ComputateJavaClass.staticSearchContextANameAdjective(siteRequest_, (String)o);
    case "contextThisName":
      return ComputateJavaClass.staticSearchContextThisName(siteRequest_, (String)o);
    case "contextTheName":
      return ComputateJavaClass.staticSearchContextTheName(siteRequest_, (String)o);
    case "contextOfName":
      return ComputateJavaClass.staticSearchContextOfName(siteRequest_, (String)o);
    case "contextThisLowercase":
      return ComputateJavaClass.staticSearchContextThisLowercase(siteRequest_, (String)o);
    case "contextTitle":
      return ComputateJavaClass.staticSearchContextTitle(siteRequest_, (String)o);
    case "classIndexed":
      return ComputateJavaClass.staticSearchClassIndexed(siteRequest_, (Boolean)o);
    case "classImage":
      return ComputateJavaClass.staticSearchClassImage(siteRequest_, (Boolean)o);
    case "classPromise":
      return ComputateJavaClass.staticSearchClassPromise(siteRequest_, (Boolean)o);
    case "classImportsGen":
      return ComputateJavaClass.staticSearchClassImportsGen(siteRequest_, (String)o);
    case "classSortsFound":
      return ComputateJavaClass.staticSearchClassSortsFound(siteRequest_, (Boolean)o);
    case "classSortsSuffixType":
      return ComputateJavaClass.staticSearchClassSortsSuffixType(siteRequest_, (String)o);
    case "classSortsOrder":
      return ComputateJavaClass.staticSearchClassSortsOrder(siteRequest_, (String)o);
    case "classSortsVar":
      return ComputateJavaClass.staticSearchClassSortsVar(siteRequest_, (String)o);
    case "classPage":
      return ComputateJavaClass.staticSearchClassPage(siteRequest_, (Boolean)o);
    case "version":
      return ComputateJavaClass.staticSearchVersion(siteRequest_, (Boolean)o);
      default:
        return null;
    }
  }

  ///////////////////
  // staticSearchStr //
  ///////////////////

  public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    return staticSearchStrComputateJavaClass(entityVar,  siteRequest_, o);
  }
  public static String staticSearchStrComputateJavaClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
    switch(entityVar) {
    case "inheritPk":
      return ComputateJavaClass.staticSearchStrInheritPk(siteRequest_, (String)o);
    case "created":
      return ComputateJavaClass.staticSearchStrCreated(siteRequest_, (String)o);
    case "archived":
      return ComputateJavaClass.staticSearchStrArchived(siteRequest_, (Boolean)o);
    case "deleted":
      return ComputateJavaClass.staticSearchStrDeleted(siteRequest_, (Boolean)o);
    case "classCanonicalNames":
      return ComputateJavaClass.staticSearchStrClassCanonicalNames(siteRequest_, (String)o);
    case "sessionId":
      return ComputateJavaClass.staticSearchStrSessionId(siteRequest_, (String)o);
    case "userKey":
      return ComputateJavaClass.staticSearchStrUserKey(siteRequest_, (Long)o);
    case "saves":
      return ComputateJavaClass.staticSearchStrSaves(siteRequest_, (String)o);
    case "objectTitle":
      return ComputateJavaClass.staticSearchStrObjectTitle(siteRequest_, (String)o);
    case "objectId":
      return ComputateJavaClass.staticSearchStrObjectId(siteRequest_, (String)o);
    case "objectSuggest":
      return ComputateJavaClass.staticSearchStrObjectSuggest(siteRequest_, (String)o);
    case "objectText":
      return ComputateJavaClass.staticSearchStrObjectText(siteRequest_, (String)o);
    case "pageUrlId":
      return ComputateJavaClass.staticSearchStrPageUrlId(siteRequest_, (String)o);
    case "pageUrlPk":
      return ComputateJavaClass.staticSearchStrPageUrlPk(siteRequest_, (String)o);
    case "pageUrlApi":
      return ComputateJavaClass.staticSearchStrPageUrlApi(siteRequest_, (String)o);
    case "doc":
      return ComputateJavaClass.staticSearchStrDoc(siteRequest_, (String)o);
    case "sitePath":
      return ComputateJavaClass.staticSearchStrSitePath(siteRequest_, (String)o);
    case "siteName":
      return ComputateJavaClass.staticSearchStrSiteName(siteRequest_, (String)o);
    case "superClassParamsTypeName":
      return ComputateJavaClass.staticSearchStrSuperClassParamsTypeName(siteRequest_, (String)o);
    case "superClassCompleteName":
      return ComputateJavaClass.staticSearchStrSuperClassCompleteName(siteRequest_, (String)o);
    case "superClassGenericCompleteName":
      return ComputateJavaClass.staticSearchStrSuperClassGenericCompleteName(siteRequest_, (String)o);
    case "superClassGenericCanonicalName":
      return ComputateJavaClass.staticSearchStrSuperClassGenericCanonicalName(siteRequest_, (String)o);
    case "superClassGenericSimpleName":
      return ComputateJavaClass.staticSearchStrSuperClassGenericSimpleName(siteRequest_, (String)o);
    case "classIsBase":
      return ComputateJavaClass.staticSearchStrClassIsBase(siteRequest_, (Boolean)o);
    case "classExtendsBase":
      return ComputateJavaClass.staticSearchStrClassExtendsBase(siteRequest_, (Boolean)o);
    case "classBaseExtendsGen":
      return ComputateJavaClass.staticSearchStrClassBaseExtendsGen(siteRequest_, (Boolean)o);
    case "classContainsSiteRequest":
      return ComputateJavaClass.staticSearchStrClassContainsSiteRequest(siteRequest_, (Boolean)o);
    case "classTranslate":
      return ComputateJavaClass.staticSearchStrClassTranslate(siteRequest_, (Boolean)o);
    case "classInitDeep":
      return ComputateJavaClass.staticSearchStrClassInitDeep(siteRequest_, (Boolean)o);
    case "classExtendsGen":
      return ComputateJavaClass.staticSearchStrClassExtendsGen(siteRequest_, (Boolean)o);
    case "languageName":
      return ComputateJavaClass.staticSearchStrLanguageName(siteRequest_, (String)o);
    case "modified":
      return ComputateJavaClass.staticSearchStrModified(siteRequest_, (String)o);
    case "classCanonicalName":
      return ComputateJavaClass.staticSearchStrClassCanonicalName(siteRequest_, (String)o);
    case "classSimpleName":
      return ComputateJavaClass.staticSearchStrClassSimpleName(siteRequest_, (String)o);
    case "classPackageName":
      return ComputateJavaClass.staticSearchStrClassPackageName(siteRequest_, (String)o);
    case "classCanonicalNameGen":
      return ComputateJavaClass.staticSearchStrClassCanonicalNameGen(siteRequest_, (String)o);
    case "classSimpleNameGen":
      return ComputateJavaClass.staticSearchStrClassSimpleNameGen(siteRequest_, (String)o);
    case "superClassCanonicalName":
      return ComputateJavaClass.staticSearchStrSuperClassCanonicalName(siteRequest_, (String)o);
    case "superClassSimpleName":
      return ComputateJavaClass.staticSearchStrSuperClassSimpleName(siteRequest_, (String)o);
    case "classAbsolutePath":
      return ComputateJavaClass.staticSearchStrClassAbsolutePath(siteRequest_, (String)o);
    case "classPath":
      return ComputateJavaClass.staticSearchStrClassPath(siteRequest_, (String)o);
    case "classDirectoryPath":
      return ComputateJavaClass.staticSearchStrClassDirectoryPath(siteRequest_, (String)o);
    case "classPathGen":
      return ComputateJavaClass.staticSearchStrClassPathGen(siteRequest_, (String)o);
    case "classDirectoryPathGen":
      return ComputateJavaClass.staticSearchStrClassDirectoryPathGen(siteRequest_, (String)o);
    case "domainPackageName":
      return ComputateJavaClass.staticSearchStrDomainPackageName(siteRequest_, (String)o);
    case "entityClassesSuperAndMeWithoutGen":
      return ComputateJavaClass.staticSearchStrEntityClassesSuperAndMeWithoutGen(siteRequest_, (String)o);
    case "classIsAbstract":
      return ComputateJavaClass.staticSearchStrClassIsAbstract(siteRequest_, (Boolean)o);
    case "classModel":
      return ComputateJavaClass.staticSearchStrClassModel(siteRequest_, (Boolean)o);
    case "classApi":
      return ComputateJavaClass.staticSearchStrClassApi(siteRequest_, (Boolean)o);
    case "classSimplePage":
      return ComputateJavaClass.staticSearchStrClassSimplePage(siteRequest_, (Boolean)o);
    case "classSaved":
      return ComputateJavaClass.staticSearchStrClassSaved(siteRequest_, (Boolean)o);
    case "classSimpleNameApiPackageInfo":
      return ComputateJavaClass.staticSearchStrClassSimpleNameApiPackageInfo(siteRequest_, (String)o);
    case "classSimpleNameGenApiServiceImpl":
      return ComputateJavaClass.staticSearchStrClassSimpleNameGenApiServiceImpl(siteRequest_, (String)o);
    case "classSimpleNameApiServiceImpl":
      return ComputateJavaClass.staticSearchStrClassSimpleNameApiServiceImpl(siteRequest_, (String)o);
    case "classSimpleNameGenApiService":
      return ComputateJavaClass.staticSearchStrClassSimpleNameGenApiService(siteRequest_, (String)o);
    case "classCanonicalNameApiPackageInfo":
      return ComputateJavaClass.staticSearchStrClassCanonicalNameApiPackageInfo(siteRequest_, (String)o);
    case "classCanonicalNameGenApiServiceImpl":
      return ComputateJavaClass.staticSearchStrClassCanonicalNameGenApiServiceImpl(siteRequest_, (String)o);
    case "classCanonicalNameApiServiceImpl":
      return ComputateJavaClass.staticSearchStrClassCanonicalNameApiServiceImpl(siteRequest_, (String)o);
    case "classCanonicalNameGenApiService":
      return ComputateJavaClass.staticSearchStrClassCanonicalNameGenApiService(siteRequest_, (String)o);
    case "classPathApiPackageInfo":
      return ComputateJavaClass.staticSearchStrClassPathApiPackageInfo(siteRequest_, (String)o);
    case "classPathGenApiServiceImpl":
      return ComputateJavaClass.staticSearchStrClassPathGenApiServiceImpl(siteRequest_, (String)o);
    case "classPathApiServiceImpl":
      return ComputateJavaClass.staticSearchStrClassPathApiServiceImpl(siteRequest_, (String)o);
    case "classPathGenApiService":
      return ComputateJavaClass.staticSearchStrClassPathGenApiService(siteRequest_, (String)o);
    case "classPublicRead":
      return ComputateJavaClass.staticSearchStrClassPublicRead(siteRequest_, (Boolean)o);
    case "classRoleSession":
      return ComputateJavaClass.staticSearchStrClassRoleSession(siteRequest_, (Boolean)o);
    case "classRoleUser":
      return ComputateJavaClass.staticSearchStrClassRoleUser(siteRequest_, (Boolean)o);
    case "classRoleEach":
      return ComputateJavaClass.staticSearchStrClassRoleEach(siteRequest_, (Boolean)o);
    case "classRoles":
      return ComputateJavaClass.staticSearchStrClassRoles(siteRequest_, (String)o);
    case "classRolesLanguage":
      return ComputateJavaClass.staticSearchStrClassRolesLanguage(siteRequest_, (String)o);
    case "classRolesFound":
      return ComputateJavaClass.staticSearchStrClassRolesFound(siteRequest_, (Boolean)o);
    case "classRoleReadFound":
      return ComputateJavaClass.staticSearchStrClassRoleReadFound(siteRequest_, (Boolean)o);
    case "classSessionWrite":
      return ComputateJavaClass.staticSearchStrClassSessionWrite(siteRequest_, (Boolean)o);
    case "classUserWrite":
      return ComputateJavaClass.staticSearchStrClassUserWrite(siteRequest_, (Boolean)o);
    case "classPublicWrite":
      return ComputateJavaClass.staticSearchStrClassPublicWrite(siteRequest_, (Boolean)o);
    case "classSessionRead":
      return ComputateJavaClass.staticSearchStrClassSessionRead(siteRequest_, (Boolean)o);
    case "classUserRead":
      return ComputateJavaClass.staticSearchStrClassUserRead(siteRequest_, (Boolean)o);
    case "classFiltersFound":
      return ComputateJavaClass.staticSearchStrClassFiltersFound(siteRequest_, (Boolean)o);
    case "sqlSort":
      return ComputateJavaClass.staticSearchStrSqlSort(siteRequest_, (Integer)o);
    case "id":
      return ComputateJavaClass.staticSearchStrId(siteRequest_, (String)o);
    case "partIsClass":
      return ComputateJavaClass.staticSearchStrPartIsClass(siteRequest_, (Boolean)o);
    case "partNumber":
      return ComputateJavaClass.staticSearchStrPartNumber(siteRequest_, (Integer)o);
    case "classImports":
      return ComputateJavaClass.staticSearchStrClassImports(siteRequest_, (String)o);
    case "classEntityVars":
      return ComputateJavaClass.staticSearchStrClassEntityVars(siteRequest_, (String)o);
    case "classImportsGenApi":
      return ComputateJavaClass.staticSearchStrClassImportsGenApi(siteRequest_, (String)o);
    case "classAttributeSimpleNamePages":
      return ComputateJavaClass.staticSearchStrClassAttributeSimpleNamePages(siteRequest_, (String)o);
    case "classMethodVars":
      return ComputateJavaClass.staticSearchStrClassMethodVars(siteRequest_, (String)o);
    case "classVarSuggested":
      return ComputateJavaClass.staticSearchStrClassVarSuggested(siteRequest_, (String)o);
    case "classVarText":
      return ComputateJavaClass.staticSearchStrClassVarText(siteRequest_, (String)o);
    case "classVarPrimaryKey":
      return ComputateJavaClass.staticSearchStrClassVarPrimaryKey(siteRequest_, (String)o);
    case "classVarInheritPrimaryKey":
      return ComputateJavaClass.staticSearchStrClassVarInheritPrimaryKey(siteRequest_, (String)o);
    case "classVarSaves":
      return ComputateJavaClass.staticSearchStrClassVarSaves(siteRequest_, (String)o);
    case "classvarUniqueKey":
      return ComputateJavaClass.staticSearchStrClassvarUniqueKey(siteRequest_, (String)o);
    case "classVarModified":
      return ComputateJavaClass.staticSearchStrClassVarModified(siteRequest_, (String)o);
    case "classVarCreated":
      return ComputateJavaClass.staticSearchStrClassVarCreated(siteRequest_, (String)o);
    case "classVarUrlId":
      return ComputateJavaClass.staticSearchStrClassVarUrlId(siteRequest_, (String)o);
    case "classVarUrlPk":
      return ComputateJavaClass.staticSearchStrClassVarUrlPk(siteRequest_, (String)o);
    case "classVarId":
      return ComputateJavaClass.staticSearchStrClassVarId(siteRequest_, (String)o);
    case "classVarTitle":
      return ComputateJavaClass.staticSearchStrClassVarTitle(siteRequest_, (String)o);
    case "classKeywordsFound":
      return ComputateJavaClass.staticSearchStrClassKeywordsFound(siteRequest_, (Boolean)o);
    case "classPageCanonicalName":
      return ComputateJavaClass.staticSearchStrClassPageCanonicalName(siteRequest_, (String)o);
    case "classPageSimpleName":
      return ComputateJavaClass.staticSearchStrClassPageSimpleName(siteRequest_, (String)o);
    case "classGenPageSimpleName":
      return ComputateJavaClass.staticSearchStrClassGenPageSimpleName(siteRequest_, (String)o);
    case "classGenPageCanonicalName":
      return ComputateJavaClass.staticSearchStrClassGenPageCanonicalName(siteRequest_, (String)o);
    case "classGenPagePath":
      return ComputateJavaClass.staticSearchStrClassGenPagePath(siteRequest_, (String)o);
    case "classPagePath":
      return ComputateJavaClass.staticSearchStrClassPagePath(siteRequest_, (String)o);
    case "classPagePathCss":
      return ComputateJavaClass.staticSearchStrClassPagePathCss(siteRequest_, (String)o);
    case "classPagePathJs":
      return ComputateJavaClass.staticSearchStrClassPagePathJs(siteRequest_, (String)o);
    case "classPagePathHbs":
      return ComputateJavaClass.staticSearchStrClassPagePathHbs(siteRequest_, (String)o);
    case "classGenPagePathHbs":
      return ComputateJavaClass.staticSearchStrClassGenPagePathHbs(siteRequest_, (String)o);
    case "classPageLanguageName":
      return ComputateJavaClass.staticSearchStrClassPageLanguageName(siteRequest_, (String)o);
    case "classPageSuperCanonicalName":
      return ComputateJavaClass.staticSearchStrClassPageSuperCanonicalName(siteRequest_, (String)o);
    case "classSuperPageSimpleName":
      return ComputateJavaClass.staticSearchStrClassSuperPageSimpleName(siteRequest_, (String)o);
    case "classImportsGenPage":
      return ComputateJavaClass.staticSearchStrClassImportsGenPage(siteRequest_, (String)o);
    case "classApiUri":
      return ComputateJavaClass.staticSearchStrClassApiUri(siteRequest_, (String)o);
    case "classApiTag":
      return ComputateJavaClass.staticSearchStrClassApiTag(siteRequest_, (String)o);
    case "classApiMethods":
      return ComputateJavaClass.staticSearchStrClassApiMethods(siteRequest_, (String)o);
    case "classContext":
      return ComputateJavaClass.staticSearchStrClassContext(siteRequest_, (Boolean)o);
    case "contextColor":
      return ComputateJavaClass.staticSearchStrContextColor(siteRequest_, (String)o);
    case "contextIconGroup":
      return ComputateJavaClass.staticSearchStrContextIconGroup(siteRequest_, (String)o);
    case "contextIconName":
      return ComputateJavaClass.staticSearchStrContextIconName(siteRequest_, (String)o);
    case "contextRows":
      return ComputateJavaClass.staticSearchStrContextRows(siteRequest_, (Integer)o);
    case "contextAName":
      return ComputateJavaClass.staticSearchStrContextAName(siteRequest_, (String)o);
    case "contextNameSingular":
      return ComputateJavaClass.staticSearchStrContextNameSingular(siteRequest_, (String)o);
    case "contextNamePlural":
      return ComputateJavaClass.staticSearchStrContextNamePlural(siteRequest_, (String)o);
    case "contextNameVar":
      return ComputateJavaClass.staticSearchStrContextNameVar(siteRequest_, (String)o);
    case "contextTheNames":
      return ComputateJavaClass.staticSearchStrContextTheNames(siteRequest_, (String)o);
    case "contextNameAdjectiveSingular":
      return ComputateJavaClass.staticSearchStrContextNameAdjectiveSingular(siteRequest_, (String)o);
    case "contextNameAdjectivePlural":
      return ComputateJavaClass.staticSearchStrContextNameAdjectivePlural(siteRequest_, (String)o);
    case "contextThis":
      return ComputateJavaClass.staticSearchStrContextThis(siteRequest_, (String)o);
    case "contextA":
      return ComputateJavaClass.staticSearchStrContextA(siteRequest_, (String)o);
    case "contextCreated":
      return ComputateJavaClass.staticSearchStrContextCreated(siteRequest_, (String)o);
    case "contextModified":
      return ComputateJavaClass.staticSearchStrContextModified(siteRequest_, (String)o);
    case "contextActualName":
      return ComputateJavaClass.staticSearchStrContextActualName(siteRequest_, (String)o);
    case "contextAll":
      return ComputateJavaClass.staticSearchStrContextAll(siteRequest_, (String)o);
    case "contextAllName":
      return ComputateJavaClass.staticSearchStrContextAllName(siteRequest_, (String)o);
    case "contextSearchAllNameBy":
      return ComputateJavaClass.staticSearchStrContextSearchAllNameBy(siteRequest_, (String)o);
    case "contextSearchAllName":
      return ComputateJavaClass.staticSearchStrContextSearchAllName(siteRequest_, (String)o);
    case "contextNoNameFound":
      return ComputateJavaClass.staticSearchStrContextNoNameFound(siteRequest_, (String)o);
    case "contextANameAdjective":
      return ComputateJavaClass.staticSearchStrContextANameAdjective(siteRequest_, (String)o);
    case "contextThisName":
      return ComputateJavaClass.staticSearchStrContextThisName(siteRequest_, (String)o);
    case "contextTheName":
      return ComputateJavaClass.staticSearchStrContextTheName(siteRequest_, (String)o);
    case "contextOfName":
      return ComputateJavaClass.staticSearchStrContextOfName(siteRequest_, (String)o);
    case "contextThisLowercase":
      return ComputateJavaClass.staticSearchStrContextThisLowercase(siteRequest_, (String)o);
    case "contextTitle":
      return ComputateJavaClass.staticSearchStrContextTitle(siteRequest_, (String)o);
    case "classIndexed":
      return ComputateJavaClass.staticSearchStrClassIndexed(siteRequest_, (Boolean)o);
    case "classImage":
      return ComputateJavaClass.staticSearchStrClassImage(siteRequest_, (Boolean)o);
    case "classPromise":
      return ComputateJavaClass.staticSearchStrClassPromise(siteRequest_, (Boolean)o);
    case "classImportsGen":
      return ComputateJavaClass.staticSearchStrClassImportsGen(siteRequest_, (String)o);
    case "classSortsFound":
      return ComputateJavaClass.staticSearchStrClassSortsFound(siteRequest_, (Boolean)o);
    case "classSortsSuffixType":
      return ComputateJavaClass.staticSearchStrClassSortsSuffixType(siteRequest_, (String)o);
    case "classSortsOrder":
      return ComputateJavaClass.staticSearchStrClassSortsOrder(siteRequest_, (String)o);
    case "classSortsVar":
      return ComputateJavaClass.staticSearchStrClassSortsVar(siteRequest_, (String)o);
    case "classPage":
      return ComputateJavaClass.staticSearchStrClassPage(siteRequest_, (Boolean)o);
    case "version":
      return ComputateJavaClass.staticSearchStrVersion(siteRequest_, (Boolean)o);
      default:
        return null;
    }
  }

  //////////////////
  // staticSearchFq //
  //////////////////

  public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
    return staticSearchFqComputateJavaClass(entityVar,  siteRequest_, o);
  }
  public static String staticSearchFqComputateJavaClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
    switch(entityVar) {
    case "inheritPk":
      return ComputateJavaClass.staticSearchFqInheritPk(siteRequest_, o);
    case "created":
      return ComputateJavaClass.staticSearchFqCreated(siteRequest_, o);
    case "archived":
      return ComputateJavaClass.staticSearchFqArchived(siteRequest_, o);
    case "deleted":
      return ComputateJavaClass.staticSearchFqDeleted(siteRequest_, o);
    case "classCanonicalNames":
      return ComputateJavaClass.staticSearchFqClassCanonicalNames(siteRequest_, o);
    case "sessionId":
      return ComputateJavaClass.staticSearchFqSessionId(siteRequest_, o);
    case "userKey":
      return ComputateJavaClass.staticSearchFqUserKey(siteRequest_, o);
    case "saves":
      return ComputateJavaClass.staticSearchFqSaves(siteRequest_, o);
    case "objectTitle":
      return ComputateJavaClass.staticSearchFqObjectTitle(siteRequest_, o);
    case "objectId":
      return ComputateJavaClass.staticSearchFqObjectId(siteRequest_, o);
    case "objectSuggest":
      return ComputateJavaClass.staticSearchFqObjectSuggest(siteRequest_, o);
    case "objectText":
      return ComputateJavaClass.staticSearchFqObjectText(siteRequest_, o);
    case "pageUrlId":
      return ComputateJavaClass.staticSearchFqPageUrlId(siteRequest_, o);
    case "pageUrlPk":
      return ComputateJavaClass.staticSearchFqPageUrlPk(siteRequest_, o);
    case "pageUrlApi":
      return ComputateJavaClass.staticSearchFqPageUrlApi(siteRequest_, o);
    case "doc":
      return ComputateJavaClass.staticSearchFqDoc(siteRequest_, o);
    case "sitePath":
      return ComputateJavaClass.staticSearchFqSitePath(siteRequest_, o);
    case "siteName":
      return ComputateJavaClass.staticSearchFqSiteName(siteRequest_, o);
    case "superClassParamsTypeName":
      return ComputateJavaClass.staticSearchFqSuperClassParamsTypeName(siteRequest_, o);
    case "superClassCompleteName":
      return ComputateJavaClass.staticSearchFqSuperClassCompleteName(siteRequest_, o);
    case "superClassGenericCompleteName":
      return ComputateJavaClass.staticSearchFqSuperClassGenericCompleteName(siteRequest_, o);
    case "superClassGenericCanonicalName":
      return ComputateJavaClass.staticSearchFqSuperClassGenericCanonicalName(siteRequest_, o);
    case "superClassGenericSimpleName":
      return ComputateJavaClass.staticSearchFqSuperClassGenericSimpleName(siteRequest_, o);
    case "classIsBase":
      return ComputateJavaClass.staticSearchFqClassIsBase(siteRequest_, o);
    case "classExtendsBase":
      return ComputateJavaClass.staticSearchFqClassExtendsBase(siteRequest_, o);
    case "classBaseExtendsGen":
      return ComputateJavaClass.staticSearchFqClassBaseExtendsGen(siteRequest_, o);
    case "classContainsSiteRequest":
      return ComputateJavaClass.staticSearchFqClassContainsSiteRequest(siteRequest_, o);
    case "classTranslate":
      return ComputateJavaClass.staticSearchFqClassTranslate(siteRequest_, o);
    case "classInitDeep":
      return ComputateJavaClass.staticSearchFqClassInitDeep(siteRequest_, o);
    case "classExtendsGen":
      return ComputateJavaClass.staticSearchFqClassExtendsGen(siteRequest_, o);
    case "languageName":
      return ComputateJavaClass.staticSearchFqLanguageName(siteRequest_, o);
    case "modified":
      return ComputateJavaClass.staticSearchFqModified(siteRequest_, o);
    case "classCanonicalName":
      return ComputateJavaClass.staticSearchFqClassCanonicalName(siteRequest_, o);
    case "classSimpleName":
      return ComputateJavaClass.staticSearchFqClassSimpleName(siteRequest_, o);
    case "classPackageName":
      return ComputateJavaClass.staticSearchFqClassPackageName(siteRequest_, o);
    case "classCanonicalNameGen":
      return ComputateJavaClass.staticSearchFqClassCanonicalNameGen(siteRequest_, o);
    case "classSimpleNameGen":
      return ComputateJavaClass.staticSearchFqClassSimpleNameGen(siteRequest_, o);
    case "superClassCanonicalName":
      return ComputateJavaClass.staticSearchFqSuperClassCanonicalName(siteRequest_, o);
    case "superClassSimpleName":
      return ComputateJavaClass.staticSearchFqSuperClassSimpleName(siteRequest_, o);
    case "classAbsolutePath":
      return ComputateJavaClass.staticSearchFqClassAbsolutePath(siteRequest_, o);
    case "classPath":
      return ComputateJavaClass.staticSearchFqClassPath(siteRequest_, o);
    case "classDirectoryPath":
      return ComputateJavaClass.staticSearchFqClassDirectoryPath(siteRequest_, o);
    case "classPathGen":
      return ComputateJavaClass.staticSearchFqClassPathGen(siteRequest_, o);
    case "classDirectoryPathGen":
      return ComputateJavaClass.staticSearchFqClassDirectoryPathGen(siteRequest_, o);
    case "domainPackageName":
      return ComputateJavaClass.staticSearchFqDomainPackageName(siteRequest_, o);
    case "entityClassesSuperAndMeWithoutGen":
      return ComputateJavaClass.staticSearchFqEntityClassesSuperAndMeWithoutGen(siteRequest_, o);
    case "classIsAbstract":
      return ComputateJavaClass.staticSearchFqClassIsAbstract(siteRequest_, o);
    case "classModel":
      return ComputateJavaClass.staticSearchFqClassModel(siteRequest_, o);
    case "classApi":
      return ComputateJavaClass.staticSearchFqClassApi(siteRequest_, o);
    case "classSimplePage":
      return ComputateJavaClass.staticSearchFqClassSimplePage(siteRequest_, o);
    case "classSaved":
      return ComputateJavaClass.staticSearchFqClassSaved(siteRequest_, o);
    case "classSimpleNameApiPackageInfo":
      return ComputateJavaClass.staticSearchFqClassSimpleNameApiPackageInfo(siteRequest_, o);
    case "classSimpleNameGenApiServiceImpl":
      return ComputateJavaClass.staticSearchFqClassSimpleNameGenApiServiceImpl(siteRequest_, o);
    case "classSimpleNameApiServiceImpl":
      return ComputateJavaClass.staticSearchFqClassSimpleNameApiServiceImpl(siteRequest_, o);
    case "classSimpleNameGenApiService":
      return ComputateJavaClass.staticSearchFqClassSimpleNameGenApiService(siteRequest_, o);
    case "classCanonicalNameApiPackageInfo":
      return ComputateJavaClass.staticSearchFqClassCanonicalNameApiPackageInfo(siteRequest_, o);
    case "classCanonicalNameGenApiServiceImpl":
      return ComputateJavaClass.staticSearchFqClassCanonicalNameGenApiServiceImpl(siteRequest_, o);
    case "classCanonicalNameApiServiceImpl":
      return ComputateJavaClass.staticSearchFqClassCanonicalNameApiServiceImpl(siteRequest_, o);
    case "classCanonicalNameGenApiService":
      return ComputateJavaClass.staticSearchFqClassCanonicalNameGenApiService(siteRequest_, o);
    case "classPathApiPackageInfo":
      return ComputateJavaClass.staticSearchFqClassPathApiPackageInfo(siteRequest_, o);
    case "classPathGenApiServiceImpl":
      return ComputateJavaClass.staticSearchFqClassPathGenApiServiceImpl(siteRequest_, o);
    case "classPathApiServiceImpl":
      return ComputateJavaClass.staticSearchFqClassPathApiServiceImpl(siteRequest_, o);
    case "classPathGenApiService":
      return ComputateJavaClass.staticSearchFqClassPathGenApiService(siteRequest_, o);
    case "classPublicRead":
      return ComputateJavaClass.staticSearchFqClassPublicRead(siteRequest_, o);
    case "classRoleSession":
      return ComputateJavaClass.staticSearchFqClassRoleSession(siteRequest_, o);
    case "classRoleUser":
      return ComputateJavaClass.staticSearchFqClassRoleUser(siteRequest_, o);
    case "classRoleEach":
      return ComputateJavaClass.staticSearchFqClassRoleEach(siteRequest_, o);
    case "classRoles":
      return ComputateJavaClass.staticSearchFqClassRoles(siteRequest_, o);
    case "classRolesLanguage":
      return ComputateJavaClass.staticSearchFqClassRolesLanguage(siteRequest_, o);
    case "classRolesFound":
      return ComputateJavaClass.staticSearchFqClassRolesFound(siteRequest_, o);
    case "classRoleReadFound":
      return ComputateJavaClass.staticSearchFqClassRoleReadFound(siteRequest_, o);
    case "classSessionWrite":
      return ComputateJavaClass.staticSearchFqClassSessionWrite(siteRequest_, o);
    case "classUserWrite":
      return ComputateJavaClass.staticSearchFqClassUserWrite(siteRequest_, o);
    case "classPublicWrite":
      return ComputateJavaClass.staticSearchFqClassPublicWrite(siteRequest_, o);
    case "classSessionRead":
      return ComputateJavaClass.staticSearchFqClassSessionRead(siteRequest_, o);
    case "classUserRead":
      return ComputateJavaClass.staticSearchFqClassUserRead(siteRequest_, o);
    case "classFiltersFound":
      return ComputateJavaClass.staticSearchFqClassFiltersFound(siteRequest_, o);
    case "sqlSort":
      return ComputateJavaClass.staticSearchFqSqlSort(siteRequest_, o);
    case "id":
      return ComputateJavaClass.staticSearchFqId(siteRequest_, o);
    case "partIsClass":
      return ComputateJavaClass.staticSearchFqPartIsClass(siteRequest_, o);
    case "partNumber":
      return ComputateJavaClass.staticSearchFqPartNumber(siteRequest_, o);
    case "classImports":
      return ComputateJavaClass.staticSearchFqClassImports(siteRequest_, o);
    case "classEntityVars":
      return ComputateJavaClass.staticSearchFqClassEntityVars(siteRequest_, o);
    case "classImportsGenApi":
      return ComputateJavaClass.staticSearchFqClassImportsGenApi(siteRequest_, o);
    case "classAttributeSimpleNamePages":
      return ComputateJavaClass.staticSearchFqClassAttributeSimpleNamePages(siteRequest_, o);
    case "classMethodVars":
      return ComputateJavaClass.staticSearchFqClassMethodVars(siteRequest_, o);
    case "classVarSuggested":
      return ComputateJavaClass.staticSearchFqClassVarSuggested(siteRequest_, o);
    case "classVarText":
      return ComputateJavaClass.staticSearchFqClassVarText(siteRequest_, o);
    case "classVarPrimaryKey":
      return ComputateJavaClass.staticSearchFqClassVarPrimaryKey(siteRequest_, o);
    case "classVarInheritPrimaryKey":
      return ComputateJavaClass.staticSearchFqClassVarInheritPrimaryKey(siteRequest_, o);
    case "classVarSaves":
      return ComputateJavaClass.staticSearchFqClassVarSaves(siteRequest_, o);
    case "classvarUniqueKey":
      return ComputateJavaClass.staticSearchFqClassvarUniqueKey(siteRequest_, o);
    case "classVarModified":
      return ComputateJavaClass.staticSearchFqClassVarModified(siteRequest_, o);
    case "classVarCreated":
      return ComputateJavaClass.staticSearchFqClassVarCreated(siteRequest_, o);
    case "classVarUrlId":
      return ComputateJavaClass.staticSearchFqClassVarUrlId(siteRequest_, o);
    case "classVarUrlPk":
      return ComputateJavaClass.staticSearchFqClassVarUrlPk(siteRequest_, o);
    case "classVarId":
      return ComputateJavaClass.staticSearchFqClassVarId(siteRequest_, o);
    case "classVarTitle":
      return ComputateJavaClass.staticSearchFqClassVarTitle(siteRequest_, o);
    case "classKeywordsFound":
      return ComputateJavaClass.staticSearchFqClassKeywordsFound(siteRequest_, o);
    case "classPageCanonicalName":
      return ComputateJavaClass.staticSearchFqClassPageCanonicalName(siteRequest_, o);
    case "classPageSimpleName":
      return ComputateJavaClass.staticSearchFqClassPageSimpleName(siteRequest_, o);
    case "classGenPageSimpleName":
      return ComputateJavaClass.staticSearchFqClassGenPageSimpleName(siteRequest_, o);
    case "classGenPageCanonicalName":
      return ComputateJavaClass.staticSearchFqClassGenPageCanonicalName(siteRequest_, o);
    case "classGenPagePath":
      return ComputateJavaClass.staticSearchFqClassGenPagePath(siteRequest_, o);
    case "classPagePath":
      return ComputateJavaClass.staticSearchFqClassPagePath(siteRequest_, o);
    case "classPagePathCss":
      return ComputateJavaClass.staticSearchFqClassPagePathCss(siteRequest_, o);
    case "classPagePathJs":
      return ComputateJavaClass.staticSearchFqClassPagePathJs(siteRequest_, o);
    case "classPagePathHbs":
      return ComputateJavaClass.staticSearchFqClassPagePathHbs(siteRequest_, o);
    case "classGenPagePathHbs":
      return ComputateJavaClass.staticSearchFqClassGenPagePathHbs(siteRequest_, o);
    case "classPageLanguageName":
      return ComputateJavaClass.staticSearchFqClassPageLanguageName(siteRequest_, o);
    case "classPageSuperCanonicalName":
      return ComputateJavaClass.staticSearchFqClassPageSuperCanonicalName(siteRequest_, o);
    case "classSuperPageSimpleName":
      return ComputateJavaClass.staticSearchFqClassSuperPageSimpleName(siteRequest_, o);
    case "classImportsGenPage":
      return ComputateJavaClass.staticSearchFqClassImportsGenPage(siteRequest_, o);
    case "classApiUri":
      return ComputateJavaClass.staticSearchFqClassApiUri(siteRequest_, o);
    case "classApiTag":
      return ComputateJavaClass.staticSearchFqClassApiTag(siteRequest_, o);
    case "classApiMethods":
      return ComputateJavaClass.staticSearchFqClassApiMethods(siteRequest_, o);
    case "classContext":
      return ComputateJavaClass.staticSearchFqClassContext(siteRequest_, o);
    case "contextColor":
      return ComputateJavaClass.staticSearchFqContextColor(siteRequest_, o);
    case "contextIconGroup":
      return ComputateJavaClass.staticSearchFqContextIconGroup(siteRequest_, o);
    case "contextIconName":
      return ComputateJavaClass.staticSearchFqContextIconName(siteRequest_, o);
    case "contextRows":
      return ComputateJavaClass.staticSearchFqContextRows(siteRequest_, o);
    case "contextAName":
      return ComputateJavaClass.staticSearchFqContextAName(siteRequest_, o);
    case "contextNameSingular":
      return ComputateJavaClass.staticSearchFqContextNameSingular(siteRequest_, o);
    case "contextNamePlural":
      return ComputateJavaClass.staticSearchFqContextNamePlural(siteRequest_, o);
    case "contextNameVar":
      return ComputateJavaClass.staticSearchFqContextNameVar(siteRequest_, o);
    case "contextTheNames":
      return ComputateJavaClass.staticSearchFqContextTheNames(siteRequest_, o);
    case "contextNameAdjectiveSingular":
      return ComputateJavaClass.staticSearchFqContextNameAdjectiveSingular(siteRequest_, o);
    case "contextNameAdjectivePlural":
      return ComputateJavaClass.staticSearchFqContextNameAdjectivePlural(siteRequest_, o);
    case "contextThis":
      return ComputateJavaClass.staticSearchFqContextThis(siteRequest_, o);
    case "contextA":
      return ComputateJavaClass.staticSearchFqContextA(siteRequest_, o);
    case "contextCreated":
      return ComputateJavaClass.staticSearchFqContextCreated(siteRequest_, o);
    case "contextModified":
      return ComputateJavaClass.staticSearchFqContextModified(siteRequest_, o);
    case "contextActualName":
      return ComputateJavaClass.staticSearchFqContextActualName(siteRequest_, o);
    case "contextAll":
      return ComputateJavaClass.staticSearchFqContextAll(siteRequest_, o);
    case "contextAllName":
      return ComputateJavaClass.staticSearchFqContextAllName(siteRequest_, o);
    case "contextSearchAllNameBy":
      return ComputateJavaClass.staticSearchFqContextSearchAllNameBy(siteRequest_, o);
    case "contextSearchAllName":
      return ComputateJavaClass.staticSearchFqContextSearchAllName(siteRequest_, o);
    case "contextNoNameFound":
      return ComputateJavaClass.staticSearchFqContextNoNameFound(siteRequest_, o);
    case "contextANameAdjective":
      return ComputateJavaClass.staticSearchFqContextANameAdjective(siteRequest_, o);
    case "contextThisName":
      return ComputateJavaClass.staticSearchFqContextThisName(siteRequest_, o);
    case "contextTheName":
      return ComputateJavaClass.staticSearchFqContextTheName(siteRequest_, o);
    case "contextOfName":
      return ComputateJavaClass.staticSearchFqContextOfName(siteRequest_, o);
    case "contextThisLowercase":
      return ComputateJavaClass.staticSearchFqContextThisLowercase(siteRequest_, o);
    case "contextTitle":
      return ComputateJavaClass.staticSearchFqContextTitle(siteRequest_, o);
    case "classIndexed":
      return ComputateJavaClass.staticSearchFqClassIndexed(siteRequest_, o);
    case "classImage":
      return ComputateJavaClass.staticSearchFqClassImage(siteRequest_, o);
    case "classPromise":
      return ComputateJavaClass.staticSearchFqClassPromise(siteRequest_, o);
    case "classImportsGen":
      return ComputateJavaClass.staticSearchFqClassImportsGen(siteRequest_, o);
    case "classSortsFound":
      return ComputateJavaClass.staticSearchFqClassSortsFound(siteRequest_, o);
    case "classSortsSuffixType":
      return ComputateJavaClass.staticSearchFqClassSortsSuffixType(siteRequest_, o);
    case "classSortsOrder":
      return ComputateJavaClass.staticSearchFqClassSortsOrder(siteRequest_, o);
    case "classSortsVar":
      return ComputateJavaClass.staticSearchFqClassSortsVar(siteRequest_, o);
    case "classPage":
      return ComputateJavaClass.staticSearchFqClassPage(siteRequest_, o);
    case "version":
      return ComputateJavaClass.staticSearchFqVersion(siteRequest_, o);
      default:
        return null;
    }
  }

  //////////////
  // toString //
  //////////////

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(Optional.ofNullable(inheritPk).map(v -> "inheritPk: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(created).map(v -> "created: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(archived).map(v -> "archived: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(deleted).map(v -> "deleted: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(classCanonicalNames).map(v -> "classCanonicalNames: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(sessionId).map(v -> "sessionId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(userKey).map(v -> "userKey: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(saves).map(v -> "saves: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(objectTitle).map(v -> "objectTitle: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(objectId).map(v -> "objectId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(objectSuggest).map(v -> "objectSuggest: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(objectText).map(v -> "objectText: " + v + "\n").orElse(""));
    sb.append(Optional.ofNullable(pageUrlId).map(v -> "pageUrlId: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(pageUrlPk).map(v -> "pageUrlPk: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(pageUrlApi).map(v -> "pageUrlApi: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(modified).map(v -> "modified: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(classCanonicalName).map(v -> "classCanonicalName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(classSimpleName).map(v -> "classSimpleName: \"" + v + "\"\n" ).orElse(""));
    sb.append(Optional.ofNullable(id).map(v -> "id: \"" + v + "\"\n" ).orElse(""));
    return sb.toString();
  }

  public static final String CLASS_SIMPLE_NAME = "ComputateJavaClass";
  public static final String CLASS_CANONICAL_NAME = "org.computate.vertx.result.java.ComputateJavaClass";
  public static final String CLASS_AUTH_RESOURCE = "";
  public static final String VAR_siteRequest_ = "siteRequest_";
  public static final String VAR_promiseBefore = "promiseBefore";
  public static final String VAR_inheritPk = "inheritPk";
  public static final String VAR_created = "created";
  public static final String VAR_archived = "archived";
  public static final String VAR_deleted = "deleted";
  public static final String VAR_classCanonicalNames = "classCanonicalNames";
  public static final String VAR_sessionId = "sessionId";
  public static final String VAR_userKey = "userKey";
  public static final String VAR_saves = "saves";
  public static final String VAR_objectTitle = "objectTitle";
  public static final String VAR_objectId = "objectId";
  public static final String VAR_objectSuggest = "objectSuggest";
  public static final String VAR_objectText = "objectText";
  public static final String VAR_pageUrlId = "pageUrlId";
  public static final String VAR_pageUrlPk = "pageUrlPk";
  public static final String VAR_pageUrlApi = "pageUrlApi";
  public static final String VAR_doc = "doc";
  public static final String VAR_sitePath = "sitePath";
  public static final String VAR_siteName = "siteName";
  public static final String VAR_superClassParamsTypeName = "superClassParamsTypeName";
  public static final String VAR_superClassCompleteName = "superClassCompleteName";
  public static final String VAR_superClassGenericCompleteName = "superClassGenericCompleteName";
  public static final String VAR_superClassGenericCanonicalName = "superClassGenericCanonicalName";
  public static final String VAR_superClassGenericSimpleName = "superClassGenericSimpleName";
  public static final String VAR_classIsBase = "classIsBase";
  public static final String VAR_classExtendsBase = "classExtendsBase";
  public static final String VAR_classBaseExtendsGen = "classBaseExtendsGen";
  public static final String VAR_classContainsSiteRequest = "classContainsSiteRequest";
  public static final String VAR_classTranslate = "classTranslate";
  public static final String VAR_classInitDeep = "classInitDeep";
  public static final String VAR_classExtendsGen = "classExtendsGen";
  public static final String VAR_languageName = "languageName";
  public static final String VAR_modified = "modified";
  public static final String VAR_classCanonicalName = "classCanonicalName";
  public static final String VAR_classSimpleName = "classSimpleName";
  public static final String VAR_classPackageName = "classPackageName";
  public static final String VAR_classCanonicalNameGen = "classCanonicalNameGen";
  public static final String VAR_classSimpleNameGen = "classSimpleNameGen";
  public static final String VAR_superClassCanonicalName = "superClassCanonicalName";
  public static final String VAR_superClassSimpleName = "superClassSimpleName";
  public static final String VAR_classAbsolutePath = "classAbsolutePath";
  public static final String VAR_classPath = "classPath";
  public static final String VAR_classDirectoryPath = "classDirectoryPath";
  public static final String VAR_classPathGen = "classPathGen";
  public static final String VAR_classDirectoryPathGen = "classDirectoryPathGen";
  public static final String VAR_domainPackageName = "domainPackageName";
  public static final String VAR_entityClassesSuperAndMeWithoutGen = "entityClassesSuperAndMeWithoutGen";
  public static final String VAR_classIsAbstract = "classIsAbstract";
  public static final String VAR_classModel = "classModel";
  public static final String VAR_classApi = "classApi";
  public static final String VAR_classSimplePage = "classSimplePage";
  public static final String VAR_classSaved = "classSaved";
  public static final String VAR_classSimpleNameApiPackageInfo = "classSimpleNameApiPackageInfo";
  public static final String VAR_classSimpleNameGenApiServiceImpl = "classSimpleNameGenApiServiceImpl";
  public static final String VAR_classSimpleNameApiServiceImpl = "classSimpleNameApiServiceImpl";
  public static final String VAR_classSimpleNameGenApiService = "classSimpleNameGenApiService";
  public static final String VAR_classCanonicalNameApiPackageInfo = "classCanonicalNameApiPackageInfo";
  public static final String VAR_classCanonicalNameGenApiServiceImpl = "classCanonicalNameGenApiServiceImpl";
  public static final String VAR_classCanonicalNameApiServiceImpl = "classCanonicalNameApiServiceImpl";
  public static final String VAR_classCanonicalNameGenApiService = "classCanonicalNameGenApiService";
  public static final String VAR_classPathApiPackageInfo = "classPathApiPackageInfo";
  public static final String VAR_classPathGenApiServiceImpl = "classPathGenApiServiceImpl";
  public static final String VAR_classPathApiServiceImpl = "classPathApiServiceImpl";
  public static final String VAR_classPathGenApiService = "classPathGenApiService";
  public static final String VAR_classPublicRead = "classPublicRead";
  public static final String VAR_classRoleSession = "classRoleSession";
  public static final String VAR_classRoleUser = "classRoleUser";
  public static final String VAR_classRoleEach = "classRoleEach";
  public static final String VAR_classRoles = "classRoles";
  public static final String VAR_classRolesLanguage = "classRolesLanguage";
  public static final String VAR_classRolesFound = "classRolesFound";
  public static final String VAR_classRoleReadFound = "classRoleReadFound";
  public static final String VAR_classSessionWrite = "classSessionWrite";
  public static final String VAR_classUserWrite = "classUserWrite";
  public static final String VAR_classPublicWrite = "classPublicWrite";
  public static final String VAR_classSessionRead = "classSessionRead";
  public static final String VAR_classUserRead = "classUserRead";
  public static final String VAR_classFiltersFound = "classFiltersFound";
  public static final String VAR_sqlSort = "sqlSort";
  public static final String VAR_id = "id";
  public static final String VAR_partIsClass = "partIsClass";
  public static final String VAR_partNumber = "partNumber";
  public static final String VAR_classImports = "classImports";
  public static final String VAR_classEntityVars = "classEntityVars";
  public static final String VAR_classImportsGenApi = "classImportsGenApi";
  public static final String VAR_classAttributeSimpleNamePages = "classAttributeSimpleNamePages";
  public static final String VAR_classMethodVars = "classMethodVars";
  public static final String VAR_classVarSuggested = "classVarSuggested";
  public static final String VAR_classVarText = "classVarText";
  public static final String VAR_classVarPrimaryKey = "classVarPrimaryKey";
  public static final String VAR_classVarInheritPrimaryKey = "classVarInheritPrimaryKey";
  public static final String VAR_classVarSaves = "classVarSaves";
  public static final String VAR_classvarUniqueKey = "classvarUniqueKey";
  public static final String VAR_classVarModified = "classVarModified";
  public static final String VAR_classVarCreated = "classVarCreated";
  public static final String VAR_classVarUrlId = "classVarUrlId";
  public static final String VAR_classVarUrlPk = "classVarUrlPk";
  public static final String VAR_classVarId = "classVarId";
  public static final String VAR_classVarTitle = "classVarTitle";
  public static final String VAR_classKeywordsFound = "classKeywordsFound";
  public static final String VAR_classPageCanonicalName = "classPageCanonicalName";
  public static final String VAR_classPageSimpleName = "classPageSimpleName";
  public static final String VAR_classGenPageSimpleName = "classGenPageSimpleName";
  public static final String VAR_classGenPageCanonicalName = "classGenPageCanonicalName";
  public static final String VAR_classGenPagePath = "classGenPagePath";
  public static final String VAR_classPagePath = "classPagePath";
  public static final String VAR_classPagePathCss = "classPagePathCss";
  public static final String VAR_classPagePathJs = "classPagePathJs";
  public static final String VAR_classPagePathHbs = "classPagePathHbs";
  public static final String VAR_classGenPagePathHbs = "classGenPagePathHbs";
  public static final String VAR_classPageLanguageName = "classPageLanguageName";
  public static final String VAR_classPageSuperCanonicalName = "classPageSuperCanonicalName";
  public static final String VAR_classSuperPageSimpleName = "classSuperPageSimpleName";
  public static final String VAR_classImportsGenPage = "classImportsGenPage";
  public static final String VAR_classApiUri = "classApiUri";
  public static final String VAR_classApiTag = "classApiTag";
  public static final String VAR_classApiMethods = "classApiMethods";
  public static final String VAR_classContext = "classContext";
  public static final String VAR_contextColor = "contextColor";
  public static final String VAR_contextIconGroup = "contextIconGroup";
  public static final String VAR_contextIconName = "contextIconName";
  public static final String VAR_contextRows = "contextRows";
  public static final String VAR_contextAName = "contextAName";
  public static final String VAR_contextNameSingular = "contextNameSingular";
  public static final String VAR_contextNamePlural = "contextNamePlural";
  public static final String VAR_contextNameVar = "contextNameVar";
  public static final String VAR_contextTheNames = "contextTheNames";
  public static final String VAR_contextNameAdjectiveSingular = "contextNameAdjectiveSingular";
  public static final String VAR_contextNameAdjectivePlural = "contextNameAdjectivePlural";
  public static final String VAR_contextThis = "contextThis";
  public static final String VAR_contextA = "contextA";
  public static final String VAR_contextCreated = "contextCreated";
  public static final String VAR_contextModified = "contextModified";
  public static final String VAR_contextActualName = "contextActualName";
  public static final String VAR_contextAll = "contextAll";
  public static final String VAR_contextAllName = "contextAllName";
  public static final String VAR_contextSearchAllNameBy = "contextSearchAllNameBy";
  public static final String VAR_contextSearchAllName = "contextSearchAllName";
  public static final String VAR_contextNoNameFound = "contextNoNameFound";
  public static final String VAR_contextANameAdjective = "contextANameAdjective";
  public static final String VAR_contextThisName = "contextThisName";
  public static final String VAR_contextTheName = "contextTheName";
  public static final String VAR_contextOfName = "contextOfName";
  public static final String VAR_contextThisLowercase = "contextThisLowercase";
  public static final String VAR_contextTitle = "contextTitle";
  public static final String VAR_classIndexed = "classIndexed";
  public static final String VAR_classImage = "classImage";
  public static final String VAR_classPromise = "classPromise";
  public static final String VAR_classImportsGen = "classImportsGen";
  public static final String VAR_classSortsFound = "classSortsFound";
  public static final String VAR_classSortsSuffixType = "classSortsSuffixType";
  public static final String VAR_classSortsOrder = "classSortsOrder";
  public static final String VAR_classSortsVar = "classSortsVar";
  public static final String VAR_classPage = "classPage";
  public static final String VAR_version = "version";

  public static final String DISPLAY_NAME_siteRequest_ = "";
  public static final String DISPLAY_NAME_promiseBefore = "";
  public static final String DISPLAY_NAME_inheritPk = "";
  public static final String DISPLAY_NAME_created = "created";
  public static final String DISPLAY_NAME_archived = "archived";
  public static final String DISPLAY_NAME_deleted = "deleted";
  public static final String DISPLAY_NAME_classCanonicalNames = "";
  public static final String DISPLAY_NAME_sessionId = "";
  public static final String DISPLAY_NAME_userKey = "";
  public static final String DISPLAY_NAME_saves = "";
  public static final String DISPLAY_NAME_objectTitle = "";
  public static final String DISPLAY_NAME_objectId = "ID";
  public static final String DISPLAY_NAME_objectSuggest = "autosuggest";
  public static final String DISPLAY_NAME_objectText = "text";
  public static final String DISPLAY_NAME_pageUrlId = "";
  public static final String DISPLAY_NAME_pageUrlPk = "";
  public static final String DISPLAY_NAME_pageUrlApi = "";
  public static final String DISPLAY_NAME_doc = "";
  public static final String DISPLAY_NAME_sitePath = "";
  public static final String DISPLAY_NAME_siteName = "";
  public static final String DISPLAY_NAME_superClassParamsTypeName = "";
  public static final String DISPLAY_NAME_superClassCompleteName = "";
  public static final String DISPLAY_NAME_superClassGenericCompleteName = "";
  public static final String DISPLAY_NAME_superClassGenericCanonicalName = "";
  public static final String DISPLAY_NAME_superClassGenericSimpleName = "";
  public static final String DISPLAY_NAME_classIsBase = "";
  public static final String DISPLAY_NAME_classExtendsBase = "";
  public static final String DISPLAY_NAME_classBaseExtendsGen = "";
  public static final String DISPLAY_NAME_classContainsSiteRequest = "";
  public static final String DISPLAY_NAME_classTranslate = "";
  public static final String DISPLAY_NAME_classInitDeep = "";
  public static final String DISPLAY_NAME_classExtendsGen = "";
  public static final String DISPLAY_NAME_languageName = "";
  public static final String DISPLAY_NAME_modified = "modified";
  public static final String DISPLAY_NAME_classCanonicalName = "";
  public static final String DISPLAY_NAME_classSimpleName = "object type";
  public static final String DISPLAY_NAME_classPackageName = "";
  public static final String DISPLAY_NAME_classCanonicalNameGen = "";
  public static final String DISPLAY_NAME_classSimpleNameGen = "";
  public static final String DISPLAY_NAME_superClassCanonicalName = "";
  public static final String DISPLAY_NAME_superClassSimpleName = "";
  public static final String DISPLAY_NAME_classAbsolutePath = "";
  public static final String DISPLAY_NAME_classPath = "";
  public static final String DISPLAY_NAME_classDirectoryPath = "";
  public static final String DISPLAY_NAME_classPathGen = "";
  public static final String DISPLAY_NAME_classDirectoryPathGen = "";
  public static final String DISPLAY_NAME_domainPackageName = "";
  public static final String DISPLAY_NAME_entityClassesSuperAndMeWithoutGen = "";
  public static final String DISPLAY_NAME_classIsAbstract = "";
  public static final String DISPLAY_NAME_classModel = "";
  public static final String DISPLAY_NAME_classApi = "";
  public static final String DISPLAY_NAME_classSimplePage = "";
  public static final String DISPLAY_NAME_classSaved = "";
  public static final String DISPLAY_NAME_classSimpleNameApiPackageInfo = "";
  public static final String DISPLAY_NAME_classSimpleNameGenApiServiceImpl = "";
  public static final String DISPLAY_NAME_classSimpleNameApiServiceImpl = "";
  public static final String DISPLAY_NAME_classSimpleNameGenApiService = "";
  public static final String DISPLAY_NAME_classCanonicalNameApiPackageInfo = "";
  public static final String DISPLAY_NAME_classCanonicalNameGenApiServiceImpl = "";
  public static final String DISPLAY_NAME_classCanonicalNameApiServiceImpl = "";
  public static final String DISPLAY_NAME_classCanonicalNameGenApiService = "";
  public static final String DISPLAY_NAME_classPathApiPackageInfo = "";
  public static final String DISPLAY_NAME_classPathGenApiServiceImpl = "";
  public static final String DISPLAY_NAME_classPathApiServiceImpl = "";
  public static final String DISPLAY_NAME_classPathGenApiService = "";
  public static final String DISPLAY_NAME_classPublicRead = "";
  public static final String DISPLAY_NAME_classRoleSession = "";
  public static final String DISPLAY_NAME_classRoleUser = "";
  public static final String DISPLAY_NAME_classRoleEach = "";
  public static final String DISPLAY_NAME_classRoles = "";
  public static final String DISPLAY_NAME_classRolesLanguage = "";
  public static final String DISPLAY_NAME_classRolesFound = "";
  public static final String DISPLAY_NAME_classRoleReadFound = "";
  public static final String DISPLAY_NAME_classSessionWrite = "";
  public static final String DISPLAY_NAME_classUserWrite = "";
  public static final String DISPLAY_NAME_classPublicWrite = "";
  public static final String DISPLAY_NAME_classSessionRead = "";
  public static final String DISPLAY_NAME_classUserRead = "";
  public static final String DISPLAY_NAME_classFiltersFound = "";
  public static final String DISPLAY_NAME_sqlSort = "";
  public static final String DISPLAY_NAME_id = "";
  public static final String DISPLAY_NAME_partIsClass = "";
  public static final String DISPLAY_NAME_partNumber = "";
  public static final String DISPLAY_NAME_classImports = "";
  public static final String DISPLAY_NAME_classEntityVars = "";
  public static final String DISPLAY_NAME_classImportsGenApi = "";
  public static final String DISPLAY_NAME_classAttributeSimpleNamePages = "";
  public static final String DISPLAY_NAME_classMethodVars = "";
  public static final String DISPLAY_NAME_classVarSuggested = "";
  public static final String DISPLAY_NAME_classVarText = "";
  public static final String DISPLAY_NAME_classVarPrimaryKey = "";
  public static final String DISPLAY_NAME_classVarInheritPrimaryKey = "";
  public static final String DISPLAY_NAME_classVarSaves = "";
  public static final String DISPLAY_NAME_classvarUniqueKey = "";
  public static final String DISPLAY_NAME_classVarModified = "";
  public static final String DISPLAY_NAME_classVarCreated = "";
  public static final String DISPLAY_NAME_classVarUrlId = "";
  public static final String DISPLAY_NAME_classVarUrlPk = "";
  public static final String DISPLAY_NAME_classVarId = "";
  public static final String DISPLAY_NAME_classVarTitle = "";
  public static final String DISPLAY_NAME_classKeywordsFound = "";
  public static final String DISPLAY_NAME_classPageCanonicalName = "";
  public static final String DISPLAY_NAME_classPageSimpleName = "";
  public static final String DISPLAY_NAME_classGenPageSimpleName = "";
  public static final String DISPLAY_NAME_classGenPageCanonicalName = "";
  public static final String DISPLAY_NAME_classGenPagePath = "";
  public static final String DISPLAY_NAME_classPagePath = "";
  public static final String DISPLAY_NAME_classPagePathCss = "";
  public static final String DISPLAY_NAME_classPagePathJs = "";
  public static final String DISPLAY_NAME_classPagePathHbs = "";
  public static final String DISPLAY_NAME_classGenPagePathHbs = "";
  public static final String DISPLAY_NAME_classPageLanguageName = "";
  public static final String DISPLAY_NAME_classPageSuperCanonicalName = "";
  public static final String DISPLAY_NAME_classSuperPageSimpleName = "";
  public static final String DISPLAY_NAME_classImportsGenPage = "";
  public static final String DISPLAY_NAME_classApiUri = "";
  public static final String DISPLAY_NAME_classApiTag = "";
  public static final String DISPLAY_NAME_classApiMethods = "";
  public static final String DISPLAY_NAME_classContext = "";
  public static final String DISPLAY_NAME_contextColor = "";
  public static final String DISPLAY_NAME_contextIconGroup = "";
  public static final String DISPLAY_NAME_contextIconName = "";
  public static final String DISPLAY_NAME_contextRows = "";
  public static final String DISPLAY_NAME_contextAName = "";
  public static final String DISPLAY_NAME_contextNameSingular = "";
  public static final String DISPLAY_NAME_contextNamePlural = "";
  public static final String DISPLAY_NAME_contextNameVar = "";
  public static final String DISPLAY_NAME_contextTheNames = "";
  public static final String DISPLAY_NAME_contextNameAdjectiveSingular = "";
  public static final String DISPLAY_NAME_contextNameAdjectivePlural = "";
  public static final String DISPLAY_NAME_contextThis = "";
  public static final String DISPLAY_NAME_contextA = "";
  public static final String DISPLAY_NAME_contextCreated = "";
  public static final String DISPLAY_NAME_contextModified = "";
  public static final String DISPLAY_NAME_contextActualName = "";
  public static final String DISPLAY_NAME_contextAll = "";
  public static final String DISPLAY_NAME_contextAllName = "";
  public static final String DISPLAY_NAME_contextSearchAllNameBy = "";
  public static final String DISPLAY_NAME_contextSearchAllName = "";
  public static final String DISPLAY_NAME_contextNoNameFound = "";
  public static final String DISPLAY_NAME_contextANameAdjective = "";
  public static final String DISPLAY_NAME_contextThisName = "";
  public static final String DISPLAY_NAME_contextTheName = "";
  public static final String DISPLAY_NAME_contextOfName = "";
  public static final String DISPLAY_NAME_contextThisLowercase = "";
  public static final String DISPLAY_NAME_contextTitle = "";
  public static final String DISPLAY_NAME_classIndexed = "";
  public static final String DISPLAY_NAME_classImage = "";
  public static final String DISPLAY_NAME_classPromise = "";
  public static final String DISPLAY_NAME_classImportsGen = "";
  public static final String DISPLAY_NAME_classSortsFound = "";
  public static final String DISPLAY_NAME_classSortsSuffixType = "";
  public static final String DISPLAY_NAME_classSortsOrder = "";
  public static final String DISPLAY_NAME_classSortsVar = "";
  public static final String DISPLAY_NAME_classPage = "";
  public static final String DISPLAY_NAME_version = "";

  public String idForClass() {
    return objectId;
  }

  public String titleForClass() {
    return objectTitle;
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
    return ComputateJavaClass.displayNameComputateJavaClass(var);
  }
  public static String displayNameComputateJavaClass(String var) {
    switch(var) {
    case VAR_siteRequest_:
      return DISPLAY_NAME_siteRequest_;
    case VAR_promiseBefore:
      return DISPLAY_NAME_promiseBefore;
    case VAR_inheritPk:
      return DISPLAY_NAME_inheritPk;
    case VAR_created:
      return DISPLAY_NAME_created;
    case VAR_archived:
      return DISPLAY_NAME_archived;
    case VAR_deleted:
      return DISPLAY_NAME_deleted;
    case VAR_classCanonicalNames:
      return DISPLAY_NAME_classCanonicalNames;
    case VAR_sessionId:
      return DISPLAY_NAME_sessionId;
    case VAR_userKey:
      return DISPLAY_NAME_userKey;
    case VAR_saves:
      return DISPLAY_NAME_saves;
    case VAR_objectTitle:
      return DISPLAY_NAME_objectTitle;
    case VAR_objectId:
      return DISPLAY_NAME_objectId;
    case VAR_objectSuggest:
      return DISPLAY_NAME_objectSuggest;
    case VAR_objectText:
      return DISPLAY_NAME_objectText;
    case VAR_pageUrlId:
      return DISPLAY_NAME_pageUrlId;
    case VAR_pageUrlPk:
      return DISPLAY_NAME_pageUrlPk;
    case VAR_pageUrlApi:
      return DISPLAY_NAME_pageUrlApi;
    case VAR_doc:
      return DISPLAY_NAME_doc;
    case VAR_sitePath:
      return DISPLAY_NAME_sitePath;
    case VAR_siteName:
      return DISPLAY_NAME_siteName;
    case VAR_superClassParamsTypeName:
      return DISPLAY_NAME_superClassParamsTypeName;
    case VAR_superClassCompleteName:
      return DISPLAY_NAME_superClassCompleteName;
    case VAR_superClassGenericCompleteName:
      return DISPLAY_NAME_superClassGenericCompleteName;
    case VAR_superClassGenericCanonicalName:
      return DISPLAY_NAME_superClassGenericCanonicalName;
    case VAR_superClassGenericSimpleName:
      return DISPLAY_NAME_superClassGenericSimpleName;
    case VAR_classIsBase:
      return DISPLAY_NAME_classIsBase;
    case VAR_classExtendsBase:
      return DISPLAY_NAME_classExtendsBase;
    case VAR_classBaseExtendsGen:
      return DISPLAY_NAME_classBaseExtendsGen;
    case VAR_classContainsSiteRequest:
      return DISPLAY_NAME_classContainsSiteRequest;
    case VAR_classTranslate:
      return DISPLAY_NAME_classTranslate;
    case VAR_classInitDeep:
      return DISPLAY_NAME_classInitDeep;
    case VAR_classExtendsGen:
      return DISPLAY_NAME_classExtendsGen;
    case VAR_languageName:
      return DISPLAY_NAME_languageName;
    case VAR_modified:
      return DISPLAY_NAME_modified;
    case VAR_classCanonicalName:
      return DISPLAY_NAME_classCanonicalName;
    case VAR_classSimpleName:
      return DISPLAY_NAME_classSimpleName;
    case VAR_classPackageName:
      return DISPLAY_NAME_classPackageName;
    case VAR_classCanonicalNameGen:
      return DISPLAY_NAME_classCanonicalNameGen;
    case VAR_classSimpleNameGen:
      return DISPLAY_NAME_classSimpleNameGen;
    case VAR_superClassCanonicalName:
      return DISPLAY_NAME_superClassCanonicalName;
    case VAR_superClassSimpleName:
      return DISPLAY_NAME_superClassSimpleName;
    case VAR_classAbsolutePath:
      return DISPLAY_NAME_classAbsolutePath;
    case VAR_classPath:
      return DISPLAY_NAME_classPath;
    case VAR_classDirectoryPath:
      return DISPLAY_NAME_classDirectoryPath;
    case VAR_classPathGen:
      return DISPLAY_NAME_classPathGen;
    case VAR_classDirectoryPathGen:
      return DISPLAY_NAME_classDirectoryPathGen;
    case VAR_domainPackageName:
      return DISPLAY_NAME_domainPackageName;
    case VAR_entityClassesSuperAndMeWithoutGen:
      return DISPLAY_NAME_entityClassesSuperAndMeWithoutGen;
    case VAR_classIsAbstract:
      return DISPLAY_NAME_classIsAbstract;
    case VAR_classModel:
      return DISPLAY_NAME_classModel;
    case VAR_classApi:
      return DISPLAY_NAME_classApi;
    case VAR_classSimplePage:
      return DISPLAY_NAME_classSimplePage;
    case VAR_classSaved:
      return DISPLAY_NAME_classSaved;
    case VAR_classSimpleNameApiPackageInfo:
      return DISPLAY_NAME_classSimpleNameApiPackageInfo;
    case VAR_classSimpleNameGenApiServiceImpl:
      return DISPLAY_NAME_classSimpleNameGenApiServiceImpl;
    case VAR_classSimpleNameApiServiceImpl:
      return DISPLAY_NAME_classSimpleNameApiServiceImpl;
    case VAR_classSimpleNameGenApiService:
      return DISPLAY_NAME_classSimpleNameGenApiService;
    case VAR_classCanonicalNameApiPackageInfo:
      return DISPLAY_NAME_classCanonicalNameApiPackageInfo;
    case VAR_classCanonicalNameGenApiServiceImpl:
      return DISPLAY_NAME_classCanonicalNameGenApiServiceImpl;
    case VAR_classCanonicalNameApiServiceImpl:
      return DISPLAY_NAME_classCanonicalNameApiServiceImpl;
    case VAR_classCanonicalNameGenApiService:
      return DISPLAY_NAME_classCanonicalNameGenApiService;
    case VAR_classPathApiPackageInfo:
      return DISPLAY_NAME_classPathApiPackageInfo;
    case VAR_classPathGenApiServiceImpl:
      return DISPLAY_NAME_classPathGenApiServiceImpl;
    case VAR_classPathApiServiceImpl:
      return DISPLAY_NAME_classPathApiServiceImpl;
    case VAR_classPathGenApiService:
      return DISPLAY_NAME_classPathGenApiService;
    case VAR_classPublicRead:
      return DISPLAY_NAME_classPublicRead;
    case VAR_classRoleSession:
      return DISPLAY_NAME_classRoleSession;
    case VAR_classRoleUser:
      return DISPLAY_NAME_classRoleUser;
    case VAR_classRoleEach:
      return DISPLAY_NAME_classRoleEach;
    case VAR_classRoles:
      return DISPLAY_NAME_classRoles;
    case VAR_classRolesLanguage:
      return DISPLAY_NAME_classRolesLanguage;
    case VAR_classRolesFound:
      return DISPLAY_NAME_classRolesFound;
    case VAR_classRoleReadFound:
      return DISPLAY_NAME_classRoleReadFound;
    case VAR_classSessionWrite:
      return DISPLAY_NAME_classSessionWrite;
    case VAR_classUserWrite:
      return DISPLAY_NAME_classUserWrite;
    case VAR_classPublicWrite:
      return DISPLAY_NAME_classPublicWrite;
    case VAR_classSessionRead:
      return DISPLAY_NAME_classSessionRead;
    case VAR_classUserRead:
      return DISPLAY_NAME_classUserRead;
    case VAR_classFiltersFound:
      return DISPLAY_NAME_classFiltersFound;
    case VAR_sqlSort:
      return DISPLAY_NAME_sqlSort;
    case VAR_id:
      return DISPLAY_NAME_id;
    case VAR_partIsClass:
      return DISPLAY_NAME_partIsClass;
    case VAR_partNumber:
      return DISPLAY_NAME_partNumber;
    case VAR_classImports:
      return DISPLAY_NAME_classImports;
    case VAR_classEntityVars:
      return DISPLAY_NAME_classEntityVars;
    case VAR_classImportsGenApi:
      return DISPLAY_NAME_classImportsGenApi;
    case VAR_classAttributeSimpleNamePages:
      return DISPLAY_NAME_classAttributeSimpleNamePages;
    case VAR_classMethodVars:
      return DISPLAY_NAME_classMethodVars;
    case VAR_classVarSuggested:
      return DISPLAY_NAME_classVarSuggested;
    case VAR_classVarText:
      return DISPLAY_NAME_classVarText;
    case VAR_classVarPrimaryKey:
      return DISPLAY_NAME_classVarPrimaryKey;
    case VAR_classVarInheritPrimaryKey:
      return DISPLAY_NAME_classVarInheritPrimaryKey;
    case VAR_classVarSaves:
      return DISPLAY_NAME_classVarSaves;
    case VAR_classvarUniqueKey:
      return DISPLAY_NAME_classvarUniqueKey;
    case VAR_classVarModified:
      return DISPLAY_NAME_classVarModified;
    case VAR_classVarCreated:
      return DISPLAY_NAME_classVarCreated;
    case VAR_classVarUrlId:
      return DISPLAY_NAME_classVarUrlId;
    case VAR_classVarUrlPk:
      return DISPLAY_NAME_classVarUrlPk;
    case VAR_classVarId:
      return DISPLAY_NAME_classVarId;
    case VAR_classVarTitle:
      return DISPLAY_NAME_classVarTitle;
    case VAR_classKeywordsFound:
      return DISPLAY_NAME_classKeywordsFound;
    case VAR_classPageCanonicalName:
      return DISPLAY_NAME_classPageCanonicalName;
    case VAR_classPageSimpleName:
      return DISPLAY_NAME_classPageSimpleName;
    case VAR_classGenPageSimpleName:
      return DISPLAY_NAME_classGenPageSimpleName;
    case VAR_classGenPageCanonicalName:
      return DISPLAY_NAME_classGenPageCanonicalName;
    case VAR_classGenPagePath:
      return DISPLAY_NAME_classGenPagePath;
    case VAR_classPagePath:
      return DISPLAY_NAME_classPagePath;
    case VAR_classPagePathCss:
      return DISPLAY_NAME_classPagePathCss;
    case VAR_classPagePathJs:
      return DISPLAY_NAME_classPagePathJs;
    case VAR_classPagePathHbs:
      return DISPLAY_NAME_classPagePathHbs;
    case VAR_classGenPagePathHbs:
      return DISPLAY_NAME_classGenPagePathHbs;
    case VAR_classPageLanguageName:
      return DISPLAY_NAME_classPageLanguageName;
    case VAR_classPageSuperCanonicalName:
      return DISPLAY_NAME_classPageSuperCanonicalName;
    case VAR_classSuperPageSimpleName:
      return DISPLAY_NAME_classSuperPageSimpleName;
    case VAR_classImportsGenPage:
      return DISPLAY_NAME_classImportsGenPage;
    case VAR_classApiUri:
      return DISPLAY_NAME_classApiUri;
    case VAR_classApiTag:
      return DISPLAY_NAME_classApiTag;
    case VAR_classApiMethods:
      return DISPLAY_NAME_classApiMethods;
    case VAR_classContext:
      return DISPLAY_NAME_classContext;
    case VAR_contextColor:
      return DISPLAY_NAME_contextColor;
    case VAR_contextIconGroup:
      return DISPLAY_NAME_contextIconGroup;
    case VAR_contextIconName:
      return DISPLAY_NAME_contextIconName;
    case VAR_contextRows:
      return DISPLAY_NAME_contextRows;
    case VAR_contextAName:
      return DISPLAY_NAME_contextAName;
    case VAR_contextNameSingular:
      return DISPLAY_NAME_contextNameSingular;
    case VAR_contextNamePlural:
      return DISPLAY_NAME_contextNamePlural;
    case VAR_contextNameVar:
      return DISPLAY_NAME_contextNameVar;
    case VAR_contextTheNames:
      return DISPLAY_NAME_contextTheNames;
    case VAR_contextNameAdjectiveSingular:
      return DISPLAY_NAME_contextNameAdjectiveSingular;
    case VAR_contextNameAdjectivePlural:
      return DISPLAY_NAME_contextNameAdjectivePlural;
    case VAR_contextThis:
      return DISPLAY_NAME_contextThis;
    case VAR_contextA:
      return DISPLAY_NAME_contextA;
    case VAR_contextCreated:
      return DISPLAY_NAME_contextCreated;
    case VAR_contextModified:
      return DISPLAY_NAME_contextModified;
    case VAR_contextActualName:
      return DISPLAY_NAME_contextActualName;
    case VAR_contextAll:
      return DISPLAY_NAME_contextAll;
    case VAR_contextAllName:
      return DISPLAY_NAME_contextAllName;
    case VAR_contextSearchAllNameBy:
      return DISPLAY_NAME_contextSearchAllNameBy;
    case VAR_contextSearchAllName:
      return DISPLAY_NAME_contextSearchAllName;
    case VAR_contextNoNameFound:
      return DISPLAY_NAME_contextNoNameFound;
    case VAR_contextANameAdjective:
      return DISPLAY_NAME_contextANameAdjective;
    case VAR_contextThisName:
      return DISPLAY_NAME_contextThisName;
    case VAR_contextTheName:
      return DISPLAY_NAME_contextTheName;
    case VAR_contextOfName:
      return DISPLAY_NAME_contextOfName;
    case VAR_contextThisLowercase:
      return DISPLAY_NAME_contextThisLowercase;
    case VAR_contextTitle:
      return DISPLAY_NAME_contextTitle;
    case VAR_classIndexed:
      return DISPLAY_NAME_classIndexed;
    case VAR_classImage:
      return DISPLAY_NAME_classImage;
    case VAR_classPromise:
      return DISPLAY_NAME_classPromise;
    case VAR_classImportsGen:
      return DISPLAY_NAME_classImportsGen;
    case VAR_classSortsFound:
      return DISPLAY_NAME_classSortsFound;
    case VAR_classSortsSuffixType:
      return DISPLAY_NAME_classSortsSuffixType;
    case VAR_classSortsOrder:
      return DISPLAY_NAME_classSortsOrder;
    case VAR_classSortsVar:
      return DISPLAY_NAME_classSortsVar;
    case VAR_classPage:
      return DISPLAY_NAME_classPage;
    case VAR_version:
      return DISPLAY_NAME_version;
    default:
      return null;
    }
  }

  public static String descriptionComputateJavaClass(String var) {
    if(var == null)
      return null;
    switch(var) {
    case VAR_siteRequest_:
      return "The current request object";
    case VAR_promiseBefore:
      return "An asynchronous method for searching for a computer related to this message";
    case VAR_inheritPk:
      return "An optional inherited primary key from a legacy system for this object in the database";
    case VAR_created:
      return "A created timestamp for this record in the database";
    case VAR_archived:
      return "For archiving this record";
    case VAR_deleted:
      return "For deleting this record";
    case VAR_classCanonicalNames:
      return "All the inherited canonical names of this Java class";
    case VAR_sessionId:
      return "The session ID of the user that created this object";
    case VAR_userKey:
      return "The primary key of the user that created this record";
    case VAR_saves:
      return "A list of fields that are saved for this record in the database";
    case VAR_objectTitle:
      return "The title of this object";
    case VAR_objectId:
      return "A URL friendly unique ID for this object";
    case VAR_objectSuggest:
      return "The indexed field in the search engine for this record while using autosuggest";
    case VAR_objectText:
      return "The full text search field in the search engine for this record while using autosuggest";
    case VAR_pageUrlId:
      return "The link by name for this object in the UI";
    case VAR_pageUrlPk:
      return "The link by primary key for this object in the UI";
    case VAR_pageUrlApi:
      return "The link to this object in the API";
    case VAR_modified:
      return "A modified timestamp for this record in the database";
    case VAR_classCanonicalName:
      return "the canonical name of this Java class";
    case VAR_classSimpleName:
      return "The simple name of this Java class";
    case VAR_id:
      return "The unique key for this record in the search engine";
      default:
        return null;
    }
  }

  public static String classSimpleNameComputateJavaClass(String var) {
    switch(var) {
    case VAR_siteRequest_:
      return "ComputateSiteRequest";
    case VAR_promiseBefore:
      return "Void";
    case VAR_inheritPk:
      return "String";
    case VAR_created:
      return "ZonedDateTime";
    case VAR_archived:
      return "Boolean";
    case VAR_deleted:
      return "Boolean";
    case VAR_classCanonicalNames:
      return "List";
    case VAR_sessionId:
      return "String";
    case VAR_userKey:
      return "Long";
    case VAR_saves:
      return "List";
    case VAR_objectTitle:
      return "String";
    case VAR_objectId:
      return "String";
    case VAR_objectSuggest:
      return "String";
    case VAR_objectText:
      return "List";
    case VAR_pageUrlId:
      return "String";
    case VAR_pageUrlPk:
      return "String";
    case VAR_pageUrlApi:
      return "String";
    case VAR_doc:
      return "JsonObject";
    case VAR_sitePath:
      return "String";
    case VAR_siteName:
      return "String";
    case VAR_superClassParamsTypeName:
      return "List";
    case VAR_superClassCompleteName:
      return "String";
    case VAR_superClassGenericCompleteName:
      return "String";
    case VAR_superClassGenericCanonicalName:
      return "String";
    case VAR_superClassGenericSimpleName:
      return "String";
    case VAR_classIsBase:
      return "Boolean";
    case VAR_classExtendsBase:
      return "Boolean";
    case VAR_classBaseExtendsGen:
      return "Boolean";
    case VAR_classContainsSiteRequest:
      return "Boolean";
    case VAR_classTranslate:
      return "Boolean";
    case VAR_classInitDeep:
      return "Boolean";
    case VAR_classExtendsGen:
      return "Boolean";
    case VAR_languageName:
      return "String";
    case VAR_modified:
      return "String";
    case VAR_classCanonicalName:
      return "String";
    case VAR_classSimpleName:
      return "String";
    case VAR_classPackageName:
      return "String";
    case VAR_classCanonicalNameGen:
      return "String";
    case VAR_classSimpleNameGen:
      return "String";
    case VAR_superClassCanonicalName:
      return "String";
    case VAR_superClassSimpleName:
      return "String";
    case VAR_classAbsolutePath:
      return "String";
    case VAR_classPath:
      return "String";
    case VAR_classDirectoryPath:
      return "String";
    case VAR_classPathGen:
      return "String";
    case VAR_classDirectoryPathGen:
      return "String";
    case VAR_domainPackageName:
      return "String";
    case VAR_entityClassesSuperAndMeWithoutGen:
      return "List";
    case VAR_classIsAbstract:
      return "Boolean";
    case VAR_classModel:
      return "Boolean";
    case VAR_classApi:
      return "Boolean";
    case VAR_classSimplePage:
      return "Boolean";
    case VAR_classSaved:
      return "Boolean";
    case VAR_classSimpleNameApiPackageInfo:
      return "String";
    case VAR_classSimpleNameGenApiServiceImpl:
      return "String";
    case VAR_classSimpleNameApiServiceImpl:
      return "String";
    case VAR_classSimpleNameGenApiService:
      return "String";
    case VAR_classCanonicalNameApiPackageInfo:
      return "String";
    case VAR_classCanonicalNameGenApiServiceImpl:
      return "String";
    case VAR_classCanonicalNameApiServiceImpl:
      return "String";
    case VAR_classCanonicalNameGenApiService:
      return "String";
    case VAR_classPathApiPackageInfo:
      return "String";
    case VAR_classPathGenApiServiceImpl:
      return "String";
    case VAR_classPathApiServiceImpl:
      return "String";
    case VAR_classPathGenApiService:
      return "String";
    case VAR_classPublicRead:
      return "Boolean";
    case VAR_classRoleSession:
      return "Boolean";
    case VAR_classRoleUser:
      return "Boolean";
    case VAR_classRoleEach:
      return "Boolean";
    case VAR_classRoles:
      return "List";
    case VAR_classRolesLanguage:
      return "List";
    case VAR_classRolesFound:
      return "Boolean";
    case VAR_classRoleReadFound:
      return "Boolean";
    case VAR_classSessionWrite:
      return "Boolean";
    case VAR_classUserWrite:
      return "Boolean";
    case VAR_classPublicWrite:
      return "Boolean";
    case VAR_classSessionRead:
      return "Boolean";
    case VAR_classUserRead:
      return "Boolean";
    case VAR_classFiltersFound:
      return "Boolean";
    case VAR_sqlSort:
      return "Integer";
    case VAR_id:
      return "String";
    case VAR_partIsClass:
      return "Boolean";
    case VAR_partNumber:
      return "Integer";
    case VAR_classImports:
      return "List";
    case VAR_classEntityVars:
      return "List";
    case VAR_classImportsGenApi:
      return "List";
    case VAR_classAttributeSimpleNamePages:
      return "List";
    case VAR_classMethodVars:
      return "List";
    case VAR_classVarSuggested:
      return "String";
    case VAR_classVarText:
      return "String";
    case VAR_classVarPrimaryKey:
      return "String";
    case VAR_classVarInheritPrimaryKey:
      return "String";
    case VAR_classVarSaves:
      return "String";
    case VAR_classvarUniqueKey:
      return "String";
    case VAR_classVarModified:
      return "String";
    case VAR_classVarCreated:
      return "String";
    case VAR_classVarUrlId:
      return "String";
    case VAR_classVarUrlPk:
      return "String";
    case VAR_classVarId:
      return "String";
    case VAR_classVarTitle:
      return "String";
    case VAR_classKeywordsFound:
      return "Boolean";
    case VAR_classPageCanonicalName:
      return "String";
    case VAR_classPageSimpleName:
      return "String";
    case VAR_classGenPageSimpleName:
      return "String";
    case VAR_classGenPageCanonicalName:
      return "String";
    case VAR_classGenPagePath:
      return "String";
    case VAR_classPagePath:
      return "String";
    case VAR_classPagePathCss:
      return "String";
    case VAR_classPagePathJs:
      return "String";
    case VAR_classPagePathHbs:
      return "String";
    case VAR_classGenPagePathHbs:
      return "String";
    case VAR_classPageLanguageName:
      return "String";
    case VAR_classPageSuperCanonicalName:
      return "String";
    case VAR_classSuperPageSimpleName:
      return "String";
    case VAR_classImportsGenPage:
      return "List";
    case VAR_classApiUri:
      return "String";
    case VAR_classApiTag:
      return "String";
    case VAR_classApiMethods:
      return "List";
    case VAR_classContext:
      return "Boolean";
    case VAR_contextColor:
      return "String";
    case VAR_contextIconGroup:
      return "String";
    case VAR_contextIconName:
      return "String";
    case VAR_contextRows:
      return "Integer";
    case VAR_contextAName:
      return "String";
    case VAR_contextNameSingular:
      return "String";
    case VAR_contextNamePlural:
      return "String";
    case VAR_contextNameVar:
      return "String";
    case VAR_contextTheNames:
      return "String";
    case VAR_contextNameAdjectiveSingular:
      return "String";
    case VAR_contextNameAdjectivePlural:
      return "String";
    case VAR_contextThis:
      return "String";
    case VAR_contextA:
      return "String";
    case VAR_contextCreated:
      return "String";
    case VAR_contextModified:
      return "String";
    case VAR_contextActualName:
      return "String";
    case VAR_contextAll:
      return "String";
    case VAR_contextAllName:
      return "String";
    case VAR_contextSearchAllNameBy:
      return "String";
    case VAR_contextSearchAllName:
      return "String";
    case VAR_contextNoNameFound:
      return "String";
    case VAR_contextANameAdjective:
      return "String";
    case VAR_contextThisName:
      return "String";
    case VAR_contextTheName:
      return "String";
    case VAR_contextOfName:
      return "String";
    case VAR_contextThisLowercase:
      return "String";
    case VAR_contextTitle:
      return "String";
    case VAR_classIndexed:
      return "Boolean";
    case VAR_classImage:
      return "Boolean";
    case VAR_classPromise:
      return "Boolean";
    case VAR_classImportsGen:
      return "List";
    case VAR_classSortsFound:
      return "Boolean";
    case VAR_classSortsSuffixType:
      return "List";
    case VAR_classSortsOrder:
      return "List";
    case VAR_classSortsVar:
      return "List";
    case VAR_classPage:
      return "Boolean";
    case VAR_version:
      return "Boolean";
      default:
        return null;
    }
  }

  public static Integer htmColumnComputateJavaClass(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer htmRowComputateJavaClass(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer htmCellComputateJavaClass(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer lengthMinComputateJavaClass(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer lengthMaxComputateJavaClass(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer maxComputateJavaClass(String var) {
    switch(var) {
      default:
        return null;
    }
  }

  public static Integer minComputateJavaClass(String var) {
    switch(var) {
      default:
        return null;
    }
  }
}
