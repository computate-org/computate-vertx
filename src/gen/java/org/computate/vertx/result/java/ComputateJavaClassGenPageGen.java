package org.computate.vertx.result.java;

import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.config.ComputateConfigKeys;
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
import org.computate.vertx.page.ComputatePageLayout;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.result.java.ComputateJavaClass;
import java.lang.String;
import java.time.ZoneId;
import java.util.Locale;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.lang.Integer;
import io.vertx.core.json.JsonObject;
import java.math.BigDecimal;
import io.vertx.core.json.JsonArray;
import org.computate.search.response.solr.SolrResponse.Stats;
import org.computate.search.response.solr.SolrResponse.FacetCounts;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**	
 * <h1>Suggestions that can generate more code for you: </h1>
 * <ol>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ComputateJavaClassGenPageGen into the class ComputateJavaClassGenPage. 
 * </li>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ComputateJavaClassGenPage objects in a RESTful API. 
 * </li>
 * </ol>
 * <h1>About the ComputateJavaClassGenPage class and it's generated class ComputateJavaClassGenPageGen&lt;ComputatePageLayout&gt;: </h1>
 * <p>
 * This Java class extends a generated Java class built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage">Find the class ComputateJavaClassGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * <p>
 * Delete the class ComputateJavaClassGenPage in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.result.java in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.result.java&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 **/
public abstract class ComputateJavaClassGenPageGen<DEV> extends ComputatePageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateJavaClassGenPage.class);

	///////////////////////////////////
	// searchListComputateJavaClass_ //
	///////////////////////////////////

	/**	 The entity searchListComputateJavaClass_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ComputateJavaClass> searchListComputateJavaClass_;

	/**	<br> The entity searchListComputateJavaClass_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:searchListComputateJavaClass_">Find the entity searchListComputateJavaClass_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListComputateJavaClass_(Wrap<SearchList<ComputateJavaClass>> w);

	public SearchList<ComputateJavaClass> getSearchListComputateJavaClass_() {
		return searchListComputateJavaClass_;
	}

	public void setSearchListComputateJavaClass_(SearchList<ComputateJavaClass> searchListComputateJavaClass_) {
		this.searchListComputateJavaClass_ = searchListComputateJavaClass_;
	}
	public static SearchList<ComputateJavaClass> staticSetSearchListComputateJavaClass_(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateJavaClassGenPage searchListComputateJavaClass_Init() {
		Wrap<SearchList<ComputateJavaClass>> searchListComputateJavaClass_Wrap = new Wrap<SearchList<ComputateJavaClass>>().var("searchListComputateJavaClass_");
		if(searchListComputateJavaClass_ == null) {
			_searchListComputateJavaClass_(searchListComputateJavaClass_Wrap);
			setSearchListComputateJavaClass_(searchListComputateJavaClass_Wrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	//////////////////
	// pageResponse //
	//////////////////

	/**	 The entity pageResponse
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageResponse;

	/**	<br> The entity pageResponse
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:pageResponse">Find the entity pageResponse in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageResponse(Wrap<String> w);

	public String getPageResponse() {
		return pageResponse;
	}
	public void setPageResponse(String o) {
		this.pageResponse = ComputateJavaClassGenPage.staticSetPageResponse(siteRequest_, o);
	}
	public static String staticSetPageResponse(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage pageResponseInit() {
		Wrap<String> pageResponseWrap = new Wrap<String>().var("pageResponse");
		if(pageResponse == null) {
			_pageResponse(pageResponseWrap);
			setPageResponse(pageResponseWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchPageResponse(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageResponse(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageResponse(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrPageResponse(siteRequest_, ComputateJavaClassGenPage.staticSearchPageResponse(siteRequest_, ComputateJavaClassGenPage.staticSetPageResponse(siteRequest_, o)));
	}

	///////////////////
	// defaultZoneId //
	///////////////////

	/**	 The entity defaultZoneId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultZoneId;

	/**	<br> The entity defaultZoneId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultZoneId">Find the entity defaultZoneId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultZoneId(Wrap<String> w);

	public String getDefaultZoneId() {
		return defaultZoneId;
	}
	public void setDefaultZoneId(String o) {
		this.defaultZoneId = ComputateJavaClassGenPage.staticSetDefaultZoneId(siteRequest_, o);
	}
	public static String staticSetDefaultZoneId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage defaultZoneIdInit() {
		Wrap<String> defaultZoneIdWrap = new Wrap<String>().var("defaultZoneId");
		if(defaultZoneId == null) {
			_defaultZoneId(defaultZoneIdWrap);
			setDefaultZoneId(defaultZoneIdWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchDefaultZoneId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultZoneId(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultZoneId(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultZoneId(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultZoneId(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultZoneId(siteRequest_, o)));
	}

	/////////////////////
	// defaultTimeZone //
	/////////////////////

	/**	 The entity defaultTimeZone
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected ZoneId defaultTimeZone;

	/**	<br> The entity defaultTimeZone
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultTimeZone">Find the entity defaultTimeZone in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultTimeZone(Wrap<ZoneId> w);

	public ZoneId getDefaultTimeZone() {
		return defaultTimeZone;
	}

	public void setDefaultTimeZone(ZoneId defaultTimeZone) {
		this.defaultTimeZone = defaultTimeZone;
	}
	public static ZoneId staticSetDefaultTimeZone(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateJavaClassGenPage defaultTimeZoneInit() {
		Wrap<ZoneId> defaultTimeZoneWrap = new Wrap<ZoneId>().var("defaultTimeZone");
		if(defaultTimeZone == null) {
			_defaultTimeZone(defaultTimeZoneWrap);
			setDefaultTimeZone(defaultTimeZoneWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	/////////////////////
	// defaultLocaleId //
	/////////////////////

	/**	 The entity defaultLocaleId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultLocaleId;

	/**	<br> The entity defaultLocaleId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultLocaleId">Find the entity defaultLocaleId in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultLocaleId(Wrap<String> w);

	public String getDefaultLocaleId() {
		return defaultLocaleId;
	}
	public void setDefaultLocaleId(String o) {
		this.defaultLocaleId = ComputateJavaClassGenPage.staticSetDefaultLocaleId(siteRequest_, o);
	}
	public static String staticSetDefaultLocaleId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage defaultLocaleIdInit() {
		Wrap<String> defaultLocaleIdWrap = new Wrap<String>().var("defaultLocaleId");
		if(defaultLocaleId == null) {
			_defaultLocaleId(defaultLocaleIdWrap);
			setDefaultLocaleId(defaultLocaleIdWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchDefaultLocaleId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultLocaleId(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultLocaleId(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultLocaleId(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultLocaleId(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultLocaleId(siteRequest_, o)));
	}

	///////////////////
	// defaultLocale //
	///////////////////

	/**	 The entity defaultLocale
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Locale defaultLocale;

	/**	<br> The entity defaultLocale
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultLocale">Find the entity defaultLocale in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultLocale(Wrap<Locale> w);

	public Locale getDefaultLocale() {
		return defaultLocale;
	}

	public void setDefaultLocale(Locale defaultLocale) {
		this.defaultLocale = defaultLocale;
	}
	public static Locale staticSetDefaultLocale(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateJavaClassGenPage defaultLocaleInit() {
		Wrap<Locale> defaultLocaleWrap = new Wrap<Locale>().var("defaultLocale");
		if(defaultLocale == null) {
			_defaultLocale(defaultLocaleWrap);
			setDefaultLocale(defaultLocaleWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	/////////////////////
	// defaultRangeGap //
	/////////////////////

	/**	 The entity defaultRangeGap
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultRangeGap;

	/**	<br> The entity defaultRangeGap
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultRangeGap">Find the entity defaultRangeGap in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeGap(Wrap<String> w);

	public String getDefaultRangeGap() {
		return defaultRangeGap;
	}
	public void setDefaultRangeGap(String o) {
		this.defaultRangeGap = ComputateJavaClassGenPage.staticSetDefaultRangeGap(siteRequest_, o);
	}
	public static String staticSetDefaultRangeGap(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage defaultRangeGapInit() {
		Wrap<String> defaultRangeGapWrap = new Wrap<String>().var("defaultRangeGap");
		if(defaultRangeGap == null) {
			_defaultRangeGap(defaultRangeGapWrap);
			setDefaultRangeGap(defaultRangeGapWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchDefaultRangeGap(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultRangeGap(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultRangeGap(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultRangeGap(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultRangeGap(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultRangeGap(siteRequest_, o)));
	}

	/////////////////////
	// defaultRangeEnd //
	/////////////////////

	/**	 The entity defaultRangeEnd
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime defaultRangeEnd;

	/**	<br> The entity defaultRangeEnd
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultRangeEnd">Find the entity defaultRangeEnd in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeEnd(Wrap<ZonedDateTime> w);

	public ZonedDateTime getDefaultRangeEnd() {
		return defaultRangeEnd;
	}

	public void setDefaultRangeEnd(ZonedDateTime defaultRangeEnd) {
		this.defaultRangeEnd = defaultRangeEnd;
	}
	@JsonIgnore
	public void setDefaultRangeEnd(Instant o) {
		this.defaultRangeEnd = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setDefaultRangeEnd(String o) {
		this.defaultRangeEnd = ComputateJavaClassGenPage.staticSetDefaultRangeEnd(siteRequest_, o);
	}
	public static ZonedDateTime staticSetDefaultRangeEnd(ComputateSiteRequest siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		else if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
		else if(StringUtils.contains(o, "T"))
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setDefaultRangeEnd(Date o) {
		this.defaultRangeEnd = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected ComputateJavaClassGenPage defaultRangeEndInit() {
		Wrap<ZonedDateTime> defaultRangeEndWrap = new Wrap<ZonedDateTime>().var("defaultRangeEnd");
		if(defaultRangeEnd == null) {
			_defaultRangeEnd(defaultRangeEndWrap);
			setDefaultRangeEnd(defaultRangeEndWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static Date staticSearchDefaultRangeEnd(ComputateSiteRequest siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrDefaultRangeEnd(ComputateSiteRequest siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqDefaultRangeEnd(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultRangeEnd(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultRangeEnd(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultRangeEnd(siteRequest_, o)));
	}

	///////////////////////
	// defaultRangeStart //
	///////////////////////

	/**	 The entity defaultRangeStart
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime defaultRangeStart;

	/**	<br> The entity defaultRangeStart
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultRangeStart">Find the entity defaultRangeStart in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeStart(Wrap<ZonedDateTime> w);

	public ZonedDateTime getDefaultRangeStart() {
		return defaultRangeStart;
	}

	public void setDefaultRangeStart(ZonedDateTime defaultRangeStart) {
		this.defaultRangeStart = defaultRangeStart;
	}
	@JsonIgnore
	public void setDefaultRangeStart(Instant o) {
		this.defaultRangeStart = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setDefaultRangeStart(String o) {
		this.defaultRangeStart = ComputateJavaClassGenPage.staticSetDefaultRangeStart(siteRequest_, o);
	}
	public static ZonedDateTime staticSetDefaultRangeStart(ComputateSiteRequest siteRequest_, String o) {
		if(StringUtils.endsWith(o, "]"))
			return o == null ? null : ZonedDateTime.parse(o, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
		else if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(Optional.ofNullable(siteRequest_).map(r -> r.getConfig()).map(config -> config.getString(ComputateConfigKeys.SITE_ZONE)).map(z -> ZoneId.of(z)).orElse(ZoneId.of("UTC"))).truncatedTo(ChronoUnit.MILLIS);
		else if(StringUtils.contains(o, "T"))
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : LocalDate.parse(o, DateTimeFormatter.ISO_DATE).atStartOfDay(ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setDefaultRangeStart(Date o) {
		this.defaultRangeStart = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected ComputateJavaClassGenPage defaultRangeStartInit() {
		Wrap<ZonedDateTime> defaultRangeStartWrap = new Wrap<ZonedDateTime>().var("defaultRangeStart");
		if(defaultRangeStart == null) {
			_defaultRangeStart(defaultRangeStartWrap);
			setDefaultRangeStart(defaultRangeStartWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static Date staticSearchDefaultRangeStart(ComputateSiteRequest siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSearchStrDefaultRangeStart(ComputateSiteRequest siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSearchFqDefaultRangeStart(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultRangeStart(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultRangeStart(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultRangeStart(siteRequest_, o)));
	}

	/////////////////////
	// defaultRangeVar //
	/////////////////////

	/**	 The entity defaultRangeVar
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultRangeVar;

	/**	<br> The entity defaultRangeVar
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultRangeVar">Find the entity defaultRangeVar in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeVar(Wrap<String> w);

	public String getDefaultRangeVar() {
		return defaultRangeVar;
	}
	public void setDefaultRangeVar(String o) {
		this.defaultRangeVar = ComputateJavaClassGenPage.staticSetDefaultRangeVar(siteRequest_, o);
	}
	public static String staticSetDefaultRangeVar(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage defaultRangeVarInit() {
		Wrap<String> defaultRangeVarWrap = new Wrap<String>().var("defaultRangeVar");
		if(defaultRangeVar == null) {
			_defaultRangeVar(defaultRangeVarWrap);
			setDefaultRangeVar(defaultRangeVarWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchDefaultRangeVar(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultRangeVar(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultRangeVar(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultRangeVar(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultRangeVar(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultRangeVar(siteRequest_, o)));
	}

	//////////////////////
	// defaultFacetSort //
	//////////////////////

	/**	 The entity defaultFacetSort
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String defaultFacetSort;

	/**	<br> The entity defaultFacetSort
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultFacetSort">Find the entity defaultFacetSort in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultFacetSort(Wrap<String> w);

	public String getDefaultFacetSort() {
		return defaultFacetSort;
	}
	public void setDefaultFacetSort(String o) {
		this.defaultFacetSort = ComputateJavaClassGenPage.staticSetDefaultFacetSort(siteRequest_, o);
	}
	public static String staticSetDefaultFacetSort(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage defaultFacetSortInit() {
		Wrap<String> defaultFacetSortWrap = new Wrap<String>().var("defaultFacetSort");
		if(defaultFacetSort == null) {
			_defaultFacetSort(defaultFacetSortWrap);
			setDefaultFacetSort(defaultFacetSortWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchDefaultFacetSort(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultFacetSort(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultFacetSort(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultFacetSort(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultFacetSort(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultFacetSort(siteRequest_, o)));
	}

	///////////////////////
	// defaultFacetLimit //
	///////////////////////

	/**	 The entity defaultFacetLimit
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer defaultFacetLimit;

	/**	<br> The entity defaultFacetLimit
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultFacetLimit">Find the entity defaultFacetLimit in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultFacetLimit(Wrap<Integer> w);

	public Integer getDefaultFacetLimit() {
		return defaultFacetLimit;
	}

	public void setDefaultFacetLimit(Integer defaultFacetLimit) {
		this.defaultFacetLimit = defaultFacetLimit;
	}
	@JsonIgnore
	public void setDefaultFacetLimit(String o) {
		this.defaultFacetLimit = ComputateJavaClassGenPage.staticSetDefaultFacetLimit(siteRequest_, o);
	}
	public static Integer staticSetDefaultFacetLimit(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputateJavaClassGenPage defaultFacetLimitInit() {
		Wrap<Integer> defaultFacetLimitWrap = new Wrap<Integer>().var("defaultFacetLimit");
		if(defaultFacetLimit == null) {
			_defaultFacetLimit(defaultFacetLimitWrap);
			setDefaultFacetLimit(defaultFacetLimitWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static Integer staticSearchDefaultFacetLimit(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrDefaultFacetLimit(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultFacetLimit(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultFacetLimit(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultFacetLimit(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultFacetLimit(siteRequest_, o)));
	}

	//////////////////////////
	// defaultFacetMinCount //
	//////////////////////////

	/**	 The entity defaultFacetMinCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer defaultFacetMinCount;

	/**	<br> The entity defaultFacetMinCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultFacetMinCount">Find the entity defaultFacetMinCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultFacetMinCount(Wrap<Integer> w);

	public Integer getDefaultFacetMinCount() {
		return defaultFacetMinCount;
	}

	public void setDefaultFacetMinCount(Integer defaultFacetMinCount) {
		this.defaultFacetMinCount = defaultFacetMinCount;
	}
	@JsonIgnore
	public void setDefaultFacetMinCount(String o) {
		this.defaultFacetMinCount = ComputateJavaClassGenPage.staticSetDefaultFacetMinCount(siteRequest_, o);
	}
	public static Integer staticSetDefaultFacetMinCount(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputateJavaClassGenPage defaultFacetMinCountInit() {
		Wrap<Integer> defaultFacetMinCountWrap = new Wrap<Integer>().var("defaultFacetMinCount");
		if(defaultFacetMinCount == null) {
			_defaultFacetMinCount(defaultFacetMinCountWrap);
			setDefaultFacetMinCount(defaultFacetMinCountWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static Integer staticSearchDefaultFacetMinCount(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrDefaultFacetMinCount(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultFacetMinCount(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultFacetMinCount(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultFacetMinCount(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultFacetMinCount(siteRequest_, o)));
	}

	//////////////////////////
	// defaultPivotMinCount //
	//////////////////////////

	/**	 The entity defaultPivotMinCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer defaultPivotMinCount;

	/**	<br> The entity defaultPivotMinCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultPivotMinCount">Find the entity defaultPivotMinCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultPivotMinCount(Wrap<Integer> w);

	public Integer getDefaultPivotMinCount() {
		return defaultPivotMinCount;
	}

	public void setDefaultPivotMinCount(Integer defaultPivotMinCount) {
		this.defaultPivotMinCount = defaultPivotMinCount;
	}
	@JsonIgnore
	public void setDefaultPivotMinCount(String o) {
		this.defaultPivotMinCount = ComputateJavaClassGenPage.staticSetDefaultPivotMinCount(siteRequest_, o);
	}
	public static Integer staticSetDefaultPivotMinCount(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputateJavaClassGenPage defaultPivotMinCountInit() {
		Wrap<Integer> defaultPivotMinCountWrap = new Wrap<Integer>().var("defaultPivotMinCount");
		if(defaultPivotMinCount == null) {
			_defaultPivotMinCount(defaultPivotMinCountWrap);
			setDefaultPivotMinCount(defaultPivotMinCountWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static Integer staticSearchDefaultPivotMinCount(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrDefaultPivotMinCount(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultPivotMinCount(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultPivotMinCount(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultPivotMinCount(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultPivotMinCount(siteRequest_, o)));
	}

	//////////////////////////
	// DEFAULT_MAP_LOCATION //
	//////////////////////////

	/**	 The entity DEFAULT_MAP_LOCATION
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject DEFAULT_MAP_LOCATION;

	/**	<br> The entity DEFAULT_MAP_LOCATION
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:DEFAULT_MAP_LOCATION">Find the entity DEFAULT_MAP_LOCATION in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _DEFAULT_MAP_LOCATION(Wrap<JsonObject> w);

	public JsonObject getDEFAULT_MAP_LOCATION() {
		return DEFAULT_MAP_LOCATION;
	}

	public void setDEFAULT_MAP_LOCATION(JsonObject DEFAULT_MAP_LOCATION) {
		this.DEFAULT_MAP_LOCATION = DEFAULT_MAP_LOCATION;
	}
	@JsonIgnore
	public void setDEFAULT_MAP_LOCATION(String o) {
		this.DEFAULT_MAP_LOCATION = ComputateJavaClassGenPage.staticSetDEFAULT_MAP_LOCATION(siteRequest_, o);
	}
	public static JsonObject staticSetDEFAULT_MAP_LOCATION(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputateJavaClassGenPage DEFAULT_MAP_LOCATIONInit() {
		Wrap<JsonObject> DEFAULT_MAP_LOCATIONWrap = new Wrap<JsonObject>().var("DEFAULT_MAP_LOCATION");
		if(DEFAULT_MAP_LOCATION == null) {
			_DEFAULT_MAP_LOCATION(DEFAULT_MAP_LOCATIONWrap);
			setDEFAULT_MAP_LOCATION(DEFAULT_MAP_LOCATIONWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static JsonObject staticSearchDEFAULT_MAP_LOCATION(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrDEFAULT_MAP_LOCATION(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDEFAULT_MAP_LOCATION(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDEFAULT_MAP_LOCATION(siteRequest_, ComputateJavaClassGenPage.staticSearchDEFAULT_MAP_LOCATION(siteRequest_, ComputateJavaClassGenPage.staticSetDEFAULT_MAP_LOCATION(siteRequest_, o)));
	}

	//////////////////////
	// DEFAULT_MAP_ZOOM //
	//////////////////////

	/**	 The entity DEFAULT_MAP_ZOOM
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected BigDecimal DEFAULT_MAP_ZOOM;

	/**	<br> The entity DEFAULT_MAP_ZOOM
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:DEFAULT_MAP_ZOOM">Find the entity DEFAULT_MAP_ZOOM in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _DEFAULT_MAP_ZOOM(Wrap<BigDecimal> w);

	public BigDecimal getDEFAULT_MAP_ZOOM() {
		return DEFAULT_MAP_ZOOM;
	}

	public void setDEFAULT_MAP_ZOOM(BigDecimal DEFAULT_MAP_ZOOM) {
		this.DEFAULT_MAP_ZOOM = DEFAULT_MAP_ZOOM;
	}
	@JsonIgnore
	public void setDEFAULT_MAP_ZOOM(String o) {
		this.DEFAULT_MAP_ZOOM = ComputateJavaClassGenPage.staticSetDEFAULT_MAP_ZOOM(siteRequest_, o);
	}
	public static BigDecimal staticSetDEFAULT_MAP_ZOOM(ComputateSiteRequest siteRequest_, String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			return new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
		return null;
	}
	@JsonIgnore
	public void setDEFAULT_MAP_ZOOM(Double o) {
			this.DEFAULT_MAP_ZOOM = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	@JsonIgnore
	public void setDEFAULT_MAP_ZOOM(Integer o) {
			this.DEFAULT_MAP_ZOOM = new BigDecimal(o, MathContext.DECIMAL64).setScale(2, RoundingMode.HALF_UP);
	}
	protected ComputateJavaClassGenPage DEFAULT_MAP_ZOOMInit() {
		Wrap<BigDecimal> DEFAULT_MAP_ZOOMWrap = new Wrap<BigDecimal>().var("DEFAULT_MAP_ZOOM");
		if(DEFAULT_MAP_ZOOM == null) {
			_DEFAULT_MAP_ZOOM(DEFAULT_MAP_ZOOMWrap);
			setDEFAULT_MAP_ZOOM(DEFAULT_MAP_ZOOMWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static Double staticSearchDEFAULT_MAP_ZOOM(ComputateSiteRequest siteRequest_, BigDecimal o) {
		return o == null ? null : o.doubleValue();
	}

	public static String staticSearchStrDEFAULT_MAP_ZOOM(ComputateSiteRequest siteRequest_, Double o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDEFAULT_MAP_ZOOM(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDEFAULT_MAP_ZOOM(siteRequest_, ComputateJavaClassGenPage.staticSearchDEFAULT_MAP_ZOOM(siteRequest_, ComputateJavaClassGenPage.staticSetDEFAULT_MAP_ZOOM(siteRequest_, o)));
	}

	//////////////////////////
	// defaultFieldListVars //
	//////////////////////////

	/**	 The entity defaultFieldListVars
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> defaultFieldListVars = new ArrayList<String>();

	/**	<br> The entity defaultFieldListVars
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultFieldListVars">Find the entity defaultFieldListVars in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _defaultFieldListVars(List<String> l);

	public List<String> getDefaultFieldListVars() {
		return defaultFieldListVars;
	}

	public void setDefaultFieldListVars(List<String> defaultFieldListVars) {
		this.defaultFieldListVars = defaultFieldListVars;
	}
	public static String staticSetDefaultFieldListVars(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateJavaClassGenPage addDefaultFieldListVars(String...objects) {
		for(String o : objects) {
			addDefaultFieldListVars(o);
		}
		return (ComputateJavaClassGenPage)this;
	}
	public ComputateJavaClassGenPage addDefaultFieldListVars(String o) {
		if(o != null)
			this.defaultFieldListVars.add(o);
		return (ComputateJavaClassGenPage)this;
	}
	@JsonIgnore
	public void setDefaultFieldListVars(JsonArray objects) {
		defaultFieldListVars.clear();
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addDefaultFieldListVars(o);
		}
	}
	protected ComputateJavaClassGenPage defaultFieldListVarsInit() {
		_defaultFieldListVars(defaultFieldListVars);
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchDefaultFieldListVars(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultFieldListVars(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultFieldListVars(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultFieldListVars(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultFieldListVars(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultFieldListVars(siteRequest_, o)));
	}

	//////////////////////
	// defaultStatsVars //
	//////////////////////

	/**	 The entity defaultStatsVars
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> defaultStatsVars = new ArrayList<String>();

	/**	<br> The entity defaultStatsVars
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultStatsVars">Find the entity defaultStatsVars in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _defaultStatsVars(List<String> l);

	public List<String> getDefaultStatsVars() {
		return defaultStatsVars;
	}

	public void setDefaultStatsVars(List<String> defaultStatsVars) {
		this.defaultStatsVars = defaultStatsVars;
	}
	public static String staticSetDefaultStatsVars(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateJavaClassGenPage addDefaultStatsVars(String...objects) {
		for(String o : objects) {
			addDefaultStatsVars(o);
		}
		return (ComputateJavaClassGenPage)this;
	}
	public ComputateJavaClassGenPage addDefaultStatsVars(String o) {
		if(o != null)
			this.defaultStatsVars.add(o);
		return (ComputateJavaClassGenPage)this;
	}
	@JsonIgnore
	public void setDefaultStatsVars(JsonArray objects) {
		defaultStatsVars.clear();
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addDefaultStatsVars(o);
		}
	}
	protected ComputateJavaClassGenPage defaultStatsVarsInit() {
		_defaultStatsVars(defaultStatsVars);
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchDefaultStatsVars(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultStatsVars(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultStatsVars(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultStatsVars(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultStatsVars(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultStatsVars(siteRequest_, o)));
	}

	//////////////////////
	// defaultPivotVars //
	//////////////////////

	/**	 The entity defaultPivotVars
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> defaultPivotVars = new ArrayList<String>();

	/**	<br> The entity defaultPivotVars
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultPivotVars">Find the entity defaultPivotVars in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _defaultPivotVars(List<String> l);

	public List<String> getDefaultPivotVars() {
		return defaultPivotVars;
	}

	public void setDefaultPivotVars(List<String> defaultPivotVars) {
		this.defaultPivotVars = defaultPivotVars;
	}
	public static String staticSetDefaultPivotVars(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateJavaClassGenPage addDefaultPivotVars(String...objects) {
		for(String o : objects) {
			addDefaultPivotVars(o);
		}
		return (ComputateJavaClassGenPage)this;
	}
	public ComputateJavaClassGenPage addDefaultPivotVars(String o) {
		if(o != null)
			this.defaultPivotVars.add(o);
		return (ComputateJavaClassGenPage)this;
	}
	@JsonIgnore
	public void setDefaultPivotVars(JsonArray objects) {
		defaultPivotVars.clear();
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addDefaultPivotVars(o);
		}
	}
	protected ComputateJavaClassGenPage defaultPivotVarsInit() {
		_defaultPivotVars(defaultPivotVars);
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchDefaultPivotVars(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrDefaultPivotVars(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultPivotVars(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultPivotVars(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultPivotVars(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultPivotVars(siteRequest_, o)));
	}

	////////////////////////////
	// listComputateJavaClass //
	////////////////////////////

	/**	 The entity listComputateJavaClass
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listComputateJavaClass = new JsonArray();

	/**	<br> The entity listComputateJavaClass
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:listComputateJavaClass">Find the entity listComputateJavaClass in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listComputateJavaClass(JsonArray l);

	public JsonArray getListComputateJavaClass() {
		return listComputateJavaClass;
	}

	public void setListComputateJavaClass(JsonArray listComputateJavaClass) {
		this.listComputateJavaClass = listComputateJavaClass;
	}
	public static JsonArray staticSetListComputateJavaClass(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateJavaClassGenPage listComputateJavaClassInit() {
		_listComputateJavaClass(listComputateJavaClass);
		return (ComputateJavaClassGenPage)this;
	}

	///////////
	// stats //
	///////////

	/**	 The entity stats
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Stats stats;

	/**	<br> The entity stats
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:stats">Find the entity stats in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _stats(Wrap<Stats> w);

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	public static Stats staticSetStats(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateJavaClassGenPage statsInit() {
		Wrap<Stats> statsWrap = new Wrap<Stats>().var("stats");
		if(stats == null) {
			_stats(statsWrap);
			setStats(statsWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	/////////////////
	// facetCounts //
	/////////////////

	/**	 The entity facetCounts
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected FacetCounts facetCounts;

	/**	<br> The entity facetCounts
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:facetCounts">Find the entity facetCounts in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _facetCounts(Wrap<FacetCounts> w);

	public FacetCounts getFacetCounts() {
		return facetCounts;
	}

	public void setFacetCounts(FacetCounts facetCounts) {
		this.facetCounts = facetCounts;
	}
	public static FacetCounts staticSetFacetCounts(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateJavaClassGenPage facetCountsInit() {
		Wrap<FacetCounts> facetCountsWrap = new Wrap<FacetCounts>().var("facetCounts");
		if(facetCounts == null) {
			_facetCounts(facetCountsWrap);
			setFacetCounts(facetCountsWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	/////////////////////////////
	// computateJavaClassCount //
	/////////////////////////////

	/**	 The entity computateJavaClassCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer computateJavaClassCount;

	/**	<br> The entity computateJavaClassCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:computateJavaClassCount">Find the entity computateJavaClassCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _computateJavaClassCount(Wrap<Integer> w);

	public Integer getComputateJavaClassCount() {
		return computateJavaClassCount;
	}

	public void setComputateJavaClassCount(Integer computateJavaClassCount) {
		this.computateJavaClassCount = computateJavaClassCount;
	}
	@JsonIgnore
	public void setComputateJavaClassCount(String o) {
		this.computateJavaClassCount = ComputateJavaClassGenPage.staticSetComputateJavaClassCount(siteRequest_, o);
	}
	public static Integer staticSetComputateJavaClassCount(ComputateSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputateJavaClassGenPage computateJavaClassCountInit() {
		Wrap<Integer> computateJavaClassCountWrap = new Wrap<Integer>().var("computateJavaClassCount");
		if(computateJavaClassCount == null) {
			_computateJavaClassCount(computateJavaClassCountWrap);
			setComputateJavaClassCount(computateJavaClassCountWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static Integer staticSearchComputateJavaClassCount(ComputateSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSearchStrComputateJavaClassCount(ComputateSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqComputateJavaClassCount(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrComputateJavaClassCount(siteRequest_, ComputateJavaClassGenPage.staticSearchComputateJavaClassCount(siteRequest_, ComputateJavaClassGenPage.staticSetComputateJavaClassCount(siteRequest_, o)));
	}

	/////////////////////////
	// computateJavaClass_ //
	/////////////////////////

	/**	 The entity computateJavaClass_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateJavaClass computateJavaClass_;

	/**	<br> The entity computateJavaClass_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:computateJavaClass_">Find the entity computateJavaClass_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _computateJavaClass_(Wrap<ComputateJavaClass> w);

	public ComputateJavaClass getComputateJavaClass_() {
		return computateJavaClass_;
	}

	public void setComputateJavaClass_(ComputateJavaClass computateJavaClass_) {
		this.computateJavaClass_ = computateJavaClass_;
	}
	public static ComputateJavaClass staticSetComputateJavaClass_(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateJavaClassGenPage computateJavaClass_Init() {
		Wrap<ComputateJavaClass> computateJavaClass_Wrap = new Wrap<ComputateJavaClass>().var("computateJavaClass_");
		if(computateJavaClass_ == null) {
			_computateJavaClass_(computateJavaClass_Wrap);
			setComputateJavaClass_(computateJavaClass_Wrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	////////
	// id //
	////////

	/**	 The entity id
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String id;

	/**	<br> The entity id
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = ComputateJavaClassGenPage.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			setId(idWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchId(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrId(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqId(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrId(siteRequest_, ComputateJavaClassGenPage.staticSearchId(siteRequest_, ComputateJavaClassGenPage.staticSetId(siteRequest_, o)));
	}

	///////////////////////////////
	// pageUriComputateJavaClass //
	///////////////////////////////

	/**	 The entity pageUriComputateJavaClass
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUriComputateJavaClass;

	/**	<br> The entity pageUriComputateJavaClass
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:pageUriComputateJavaClass">Find the entity pageUriComputateJavaClass in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUriComputateJavaClass(Wrap<String> c);

	public String getPageUriComputateJavaClass() {
		return pageUriComputateJavaClass;
	}
	public void setPageUriComputateJavaClass(String o) {
		this.pageUriComputateJavaClass = ComputateJavaClassGenPage.staticSetPageUriComputateJavaClass(siteRequest_, o);
	}
	public static String staticSetPageUriComputateJavaClass(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage pageUriComputateJavaClassInit() {
		Wrap<String> pageUriComputateJavaClassWrap = new Wrap<String>().var("pageUriComputateJavaClass");
		if(pageUriComputateJavaClass == null) {
			_pageUriComputateJavaClass(pageUriComputateJavaClassWrap);
			setPageUriComputateJavaClass(pageUriComputateJavaClassWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchPageUriComputateJavaClass(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUriComputateJavaClass(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUriComputateJavaClass(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrPageUriComputateJavaClass(siteRequest_, ComputateJavaClassGenPage.staticSearchPageUriComputateJavaClass(siteRequest_, ComputateJavaClassGenPage.staticSetPageUriComputateJavaClass(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepComputateJavaClassGenPage(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepComputateJavaClassGenPage();
	}

	public Future<Void> promiseDeepComputateJavaClassGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseComputateJavaClassGenPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepComputatePageLayout(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputateJavaClassGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListComputateJavaClass_Init();
				pageResponseInit();
				defaultZoneIdInit();
				defaultTimeZoneInit();
				defaultLocaleIdInit();
				defaultLocaleInit();
				defaultRangeGapInit();
				defaultRangeEndInit();
				defaultRangeStartInit();
				defaultRangeVarInit();
				defaultFacetSortInit();
				defaultFacetLimitInit();
				defaultFacetMinCountInit();
				defaultPivotMinCountInit();
				DEFAULT_MAP_LOCATIONInit();
				DEFAULT_MAP_ZOOMInit();
				defaultFieldListVarsInit();
				defaultStatsVarsInit();
				defaultPivotVarsInit();
				listComputateJavaClassInit();
				statsInit();
				facetCountsInit();
				computateJavaClassCountInit();
				computateJavaClass_Init();
				idInit();
				pageUriComputateJavaClassInit();
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

	@Override public Future<Void> promiseDeepForClass(ComputateSiteRequest siteRequest_) {
		return promiseDeepComputateJavaClassGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateJavaClassGenPage(ComputateSiteRequest siteRequest_) {
			super.siteRequestComputatePageLayout(siteRequest_);
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestComputateJavaClassGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateJavaClassGenPage(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainComputateJavaClassGenPage(String var) {
		ComputateJavaClassGenPage oComputateJavaClassGenPage = (ComputateJavaClassGenPage)this;
		switch(var) {
			case "searchListComputateJavaClass_":
				return oComputateJavaClassGenPage.searchListComputateJavaClass_;
			case "pageResponse":
				return oComputateJavaClassGenPage.pageResponse;
			case "defaultZoneId":
				return oComputateJavaClassGenPage.defaultZoneId;
			case "defaultTimeZone":
				return oComputateJavaClassGenPage.defaultTimeZone;
			case "defaultLocaleId":
				return oComputateJavaClassGenPage.defaultLocaleId;
			case "defaultLocale":
				return oComputateJavaClassGenPage.defaultLocale;
			case "defaultRangeGap":
				return oComputateJavaClassGenPage.defaultRangeGap;
			case "defaultRangeEnd":
				return oComputateJavaClassGenPage.defaultRangeEnd;
			case "defaultRangeStart":
				return oComputateJavaClassGenPage.defaultRangeStart;
			case "defaultRangeVar":
				return oComputateJavaClassGenPage.defaultRangeVar;
			case "defaultFacetSort":
				return oComputateJavaClassGenPage.defaultFacetSort;
			case "defaultFacetLimit":
				return oComputateJavaClassGenPage.defaultFacetLimit;
			case "defaultFacetMinCount":
				return oComputateJavaClassGenPage.defaultFacetMinCount;
			case "defaultPivotMinCount":
				return oComputateJavaClassGenPage.defaultPivotMinCount;
			case "DEFAULT_MAP_LOCATION":
				return oComputateJavaClassGenPage.DEFAULT_MAP_LOCATION;
			case "DEFAULT_MAP_ZOOM":
				return oComputateJavaClassGenPage.DEFAULT_MAP_ZOOM;
			case "defaultFieldListVars":
				return oComputateJavaClassGenPage.defaultFieldListVars;
			case "defaultStatsVars":
				return oComputateJavaClassGenPage.defaultStatsVars;
			case "defaultPivotVars":
				return oComputateJavaClassGenPage.defaultPivotVars;
			case "listComputateJavaClass":
				return oComputateJavaClassGenPage.listComputateJavaClass;
			case "stats":
				return oComputateJavaClassGenPage.stats;
			case "facetCounts":
				return oComputateJavaClassGenPage.facetCounts;
			case "computateJavaClassCount":
				return oComputateJavaClassGenPage.computateJavaClassCount;
			case "computateJavaClass_":
				return oComputateJavaClassGenPage.computateJavaClass_;
			case "id":
				return oComputateJavaClassGenPage.id;
			case "pageUriComputateJavaClass":
				return oComputateJavaClassGenPage.pageUriComputateJavaClass;
			default:
				return super.obtainComputatePageLayout(var);
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
				o = relateComputateJavaClassGenPage(v, val);
		}
		return o != null;
	}
	public Object relateComputateJavaClassGenPage(String var, Object val) {
		ComputateJavaClassGenPage oComputateJavaClassGenPage = (ComputateJavaClassGenPage)this;
		switch(var) {
			default:
				return super.relateComputatePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetComputateJavaClassGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateJavaClassGenPage(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "pageResponse":
			return ComputateJavaClassGenPage.staticSetPageResponse(siteRequest_, o);
		case "defaultZoneId":
			return ComputateJavaClassGenPage.staticSetDefaultZoneId(siteRequest_, o);
		case "defaultLocaleId":
			return ComputateJavaClassGenPage.staticSetDefaultLocaleId(siteRequest_, o);
		case "defaultRangeGap":
			return ComputateJavaClassGenPage.staticSetDefaultRangeGap(siteRequest_, o);
		case "defaultRangeEnd":
			return ComputateJavaClassGenPage.staticSetDefaultRangeEnd(siteRequest_, o);
		case "defaultRangeStart":
			return ComputateJavaClassGenPage.staticSetDefaultRangeStart(siteRequest_, o);
		case "defaultRangeVar":
			return ComputateJavaClassGenPage.staticSetDefaultRangeVar(siteRequest_, o);
		case "defaultFacetSort":
			return ComputateJavaClassGenPage.staticSetDefaultFacetSort(siteRequest_, o);
		case "defaultFacetLimit":
			return ComputateJavaClassGenPage.staticSetDefaultFacetLimit(siteRequest_, o);
		case "defaultFacetMinCount":
			return ComputateJavaClassGenPage.staticSetDefaultFacetMinCount(siteRequest_, o);
		case "defaultPivotMinCount":
			return ComputateJavaClassGenPage.staticSetDefaultPivotMinCount(siteRequest_, o);
		case "DEFAULT_MAP_LOCATION":
			return ComputateJavaClassGenPage.staticSetDEFAULT_MAP_LOCATION(siteRequest_, o);
		case "DEFAULT_MAP_ZOOM":
			return ComputateJavaClassGenPage.staticSetDEFAULT_MAP_ZOOM(siteRequest_, o);
		case "defaultFieldListVars":
			return ComputateJavaClassGenPage.staticSetDefaultFieldListVars(siteRequest_, o);
		case "defaultStatsVars":
			return ComputateJavaClassGenPage.staticSetDefaultStatsVars(siteRequest_, o);
		case "defaultPivotVars":
			return ComputateJavaClassGenPage.staticSetDefaultPivotVars(siteRequest_, o);
		case "computateJavaClassCount":
			return ComputateJavaClassGenPage.staticSetComputateJavaClassCount(siteRequest_, o);
		case "id":
			return ComputateJavaClassGenPage.staticSetId(siteRequest_, o);
		case "pageUriComputateJavaClass":
			return ComputateJavaClassGenPage.staticSetPageUriComputateJavaClass(siteRequest_, o);
			default:
				return ComputatePageLayout.staticSetComputatePageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchComputateJavaClassGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchComputateJavaClassGenPage(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "pageResponse":
			return ComputateJavaClassGenPage.staticSearchPageResponse(siteRequest_, (String)o);
		case "defaultZoneId":
			return ComputateJavaClassGenPage.staticSearchDefaultZoneId(siteRequest_, (String)o);
		case "defaultLocaleId":
			return ComputateJavaClassGenPage.staticSearchDefaultLocaleId(siteRequest_, (String)o);
		case "defaultRangeGap":
			return ComputateJavaClassGenPage.staticSearchDefaultRangeGap(siteRequest_, (String)o);
		case "defaultRangeEnd":
			return ComputateJavaClassGenPage.staticSearchDefaultRangeEnd(siteRequest_, (ZonedDateTime)o);
		case "defaultRangeStart":
			return ComputateJavaClassGenPage.staticSearchDefaultRangeStart(siteRequest_, (ZonedDateTime)o);
		case "defaultRangeVar":
			return ComputateJavaClassGenPage.staticSearchDefaultRangeVar(siteRequest_, (String)o);
		case "defaultFacetSort":
			return ComputateJavaClassGenPage.staticSearchDefaultFacetSort(siteRequest_, (String)o);
		case "defaultFacetLimit":
			return ComputateJavaClassGenPage.staticSearchDefaultFacetLimit(siteRequest_, (Integer)o);
		case "defaultFacetMinCount":
			return ComputateJavaClassGenPage.staticSearchDefaultFacetMinCount(siteRequest_, (Integer)o);
		case "defaultPivotMinCount":
			return ComputateJavaClassGenPage.staticSearchDefaultPivotMinCount(siteRequest_, (Integer)o);
		case "DEFAULT_MAP_LOCATION":
			return ComputateJavaClassGenPage.staticSearchDEFAULT_MAP_LOCATION(siteRequest_, (JsonObject)o);
		case "DEFAULT_MAP_ZOOM":
			return ComputateJavaClassGenPage.staticSearchDEFAULT_MAP_ZOOM(siteRequest_, (BigDecimal)o);
		case "defaultFieldListVars":
			return ComputateJavaClassGenPage.staticSearchDefaultFieldListVars(siteRequest_, (String)o);
		case "defaultStatsVars":
			return ComputateJavaClassGenPage.staticSearchDefaultStatsVars(siteRequest_, (String)o);
		case "defaultPivotVars":
			return ComputateJavaClassGenPage.staticSearchDefaultPivotVars(siteRequest_, (String)o);
		case "computateJavaClassCount":
			return ComputateJavaClassGenPage.staticSearchComputateJavaClassCount(siteRequest_, (Integer)o);
		case "id":
			return ComputateJavaClassGenPage.staticSearchId(siteRequest_, (String)o);
		case "pageUriComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchPageUriComputateJavaClass(siteRequest_, (String)o);
			default:
				return ComputatePageLayout.staticSearchComputatePageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrComputateJavaClassGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrComputateJavaClassGenPage(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "pageResponse":
			return ComputateJavaClassGenPage.staticSearchStrPageResponse(siteRequest_, (String)o);
		case "defaultZoneId":
			return ComputateJavaClassGenPage.staticSearchStrDefaultZoneId(siteRequest_, (String)o);
		case "defaultLocaleId":
			return ComputateJavaClassGenPage.staticSearchStrDefaultLocaleId(siteRequest_, (String)o);
		case "defaultRangeGap":
			return ComputateJavaClassGenPage.staticSearchStrDefaultRangeGap(siteRequest_, (String)o);
		case "defaultRangeEnd":
			return ComputateJavaClassGenPage.staticSearchStrDefaultRangeEnd(siteRequest_, (Date)o);
		case "defaultRangeStart":
			return ComputateJavaClassGenPage.staticSearchStrDefaultRangeStart(siteRequest_, (Date)o);
		case "defaultRangeVar":
			return ComputateJavaClassGenPage.staticSearchStrDefaultRangeVar(siteRequest_, (String)o);
		case "defaultFacetSort":
			return ComputateJavaClassGenPage.staticSearchStrDefaultFacetSort(siteRequest_, (String)o);
		case "defaultFacetLimit":
			return ComputateJavaClassGenPage.staticSearchStrDefaultFacetLimit(siteRequest_, (Integer)o);
		case "defaultFacetMinCount":
			return ComputateJavaClassGenPage.staticSearchStrDefaultFacetMinCount(siteRequest_, (Integer)o);
		case "defaultPivotMinCount":
			return ComputateJavaClassGenPage.staticSearchStrDefaultPivotMinCount(siteRequest_, (Integer)o);
		case "DEFAULT_MAP_LOCATION":
			return ComputateJavaClassGenPage.staticSearchStrDEFAULT_MAP_LOCATION(siteRequest_, (JsonObject)o);
		case "DEFAULT_MAP_ZOOM":
			return ComputateJavaClassGenPage.staticSearchStrDEFAULT_MAP_ZOOM(siteRequest_, (Double)o);
		case "defaultFieldListVars":
			return ComputateJavaClassGenPage.staticSearchStrDefaultFieldListVars(siteRequest_, (String)o);
		case "defaultStatsVars":
			return ComputateJavaClassGenPage.staticSearchStrDefaultStatsVars(siteRequest_, (String)o);
		case "defaultPivotVars":
			return ComputateJavaClassGenPage.staticSearchStrDefaultPivotVars(siteRequest_, (String)o);
		case "computateJavaClassCount":
			return ComputateJavaClassGenPage.staticSearchStrComputateJavaClassCount(siteRequest_, (Integer)o);
		case "id":
			return ComputateJavaClassGenPage.staticSearchStrId(siteRequest_, (String)o);
		case "pageUriComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchStrPageUriComputateJavaClass(siteRequest_, (String)o);
			default:
				return ComputatePageLayout.staticSearchStrComputatePageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqComputateJavaClassGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqComputateJavaClassGenPage(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "pageResponse":
			return ComputateJavaClassGenPage.staticSearchFqPageResponse(siteRequest_, o);
		case "defaultZoneId":
			return ComputateJavaClassGenPage.staticSearchFqDefaultZoneId(siteRequest_, o);
		case "defaultLocaleId":
			return ComputateJavaClassGenPage.staticSearchFqDefaultLocaleId(siteRequest_, o);
		case "defaultRangeGap":
			return ComputateJavaClassGenPage.staticSearchFqDefaultRangeGap(siteRequest_, o);
		case "defaultRangeEnd":
			return ComputateJavaClassGenPage.staticSearchFqDefaultRangeEnd(siteRequest_, o);
		case "defaultRangeStart":
			return ComputateJavaClassGenPage.staticSearchFqDefaultRangeStart(siteRequest_, o);
		case "defaultRangeVar":
			return ComputateJavaClassGenPage.staticSearchFqDefaultRangeVar(siteRequest_, o);
		case "defaultFacetSort":
			return ComputateJavaClassGenPage.staticSearchFqDefaultFacetSort(siteRequest_, o);
		case "defaultFacetLimit":
			return ComputateJavaClassGenPage.staticSearchFqDefaultFacetLimit(siteRequest_, o);
		case "defaultFacetMinCount":
			return ComputateJavaClassGenPage.staticSearchFqDefaultFacetMinCount(siteRequest_, o);
		case "defaultPivotMinCount":
			return ComputateJavaClassGenPage.staticSearchFqDefaultPivotMinCount(siteRequest_, o);
		case "DEFAULT_MAP_LOCATION":
			return ComputateJavaClassGenPage.staticSearchFqDEFAULT_MAP_LOCATION(siteRequest_, o);
		case "DEFAULT_MAP_ZOOM":
			return ComputateJavaClassGenPage.staticSearchFqDEFAULT_MAP_ZOOM(siteRequest_, o);
		case "defaultFieldListVars":
			return ComputateJavaClassGenPage.staticSearchFqDefaultFieldListVars(siteRequest_, o);
		case "defaultStatsVars":
			return ComputateJavaClassGenPage.staticSearchFqDefaultStatsVars(siteRequest_, o);
		case "defaultPivotVars":
			return ComputateJavaClassGenPage.staticSearchFqDefaultPivotVars(siteRequest_, o);
		case "computateJavaClassCount":
			return ComputateJavaClassGenPage.staticSearchFqComputateJavaClassCount(siteRequest_, o);
		case "id":
			return ComputateJavaClassGenPage.staticSearchFqId(siteRequest_, o);
		case "pageUriComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchFqPageUriComputateJavaClass(siteRequest_, o);
			default:
				return ComputatePageLayout.staticSearchFqComputatePageLayout(entityVar,  siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "ComputateJavaClassGenPage";
	public static final String VAR_searchListComputateJavaClass_ = "searchListComputateJavaClass_";
	public static final String VAR_pageResponse = "pageResponse";
	public static final String VAR_defaultZoneId = "defaultZoneId";
	public static final String VAR_defaultTimeZone = "defaultTimeZone";
	public static final String VAR_defaultLocaleId = "defaultLocaleId";
	public static final String VAR_defaultLocale = "defaultLocale";
	public static final String VAR_defaultRangeGap = "defaultRangeGap";
	public static final String VAR_defaultRangeEnd = "defaultRangeEnd";
	public static final String VAR_defaultRangeStart = "defaultRangeStart";
	public static final String VAR_defaultRangeVar = "defaultRangeVar";
	public static final String VAR_defaultFacetSort = "defaultFacetSort";
	public static final String VAR_defaultFacetLimit = "defaultFacetLimit";
	public static final String VAR_defaultFacetMinCount = "defaultFacetMinCount";
	public static final String VAR_defaultPivotMinCount = "defaultPivotMinCount";
	public static final String VAR_DEFAULT_MAP_LOCATION = "DEFAULT_MAP_LOCATION";
	public static final String VAR_DEFAULT_MAP_ZOOM = "DEFAULT_MAP_ZOOM";
	public static final String VAR_defaultFieldListVars = "defaultFieldListVars";
	public static final String VAR_defaultStatsVars = "defaultStatsVars";
	public static final String VAR_defaultPivotVars = "defaultPivotVars";
	public static final String VAR_listComputateJavaClass = "listComputateJavaClass";
	public static final String VAR_stats = "stats";
	public static final String VAR_facetCounts = "facetCounts";
	public static final String VAR_computateJavaClassCount = "computateJavaClassCount";
	public static final String VAR_computateJavaClass_ = "computateJavaClass_";
	public static final String VAR_id = "id";
	public static final String VAR_pageUriComputateJavaClass = "pageUriComputateJavaClass";

	public static final String DISPLAY_NAME_searchListComputateJavaClass_ = "";
	public static final String DISPLAY_NAME_pageResponse = "";
	public static final String DISPLAY_NAME_defaultZoneId = "";
	public static final String DISPLAY_NAME_defaultTimeZone = "";
	public static final String DISPLAY_NAME_defaultLocaleId = "";
	public static final String DISPLAY_NAME_defaultLocale = "";
	public static final String DISPLAY_NAME_defaultRangeGap = "";
	public static final String DISPLAY_NAME_defaultRangeEnd = "";
	public static final String DISPLAY_NAME_defaultRangeStart = "";
	public static final String DISPLAY_NAME_defaultRangeVar = "";
	public static final String DISPLAY_NAME_defaultFacetSort = "";
	public static final String DISPLAY_NAME_defaultFacetLimit = "";
	public static final String DISPLAY_NAME_defaultFacetMinCount = "";
	public static final String DISPLAY_NAME_defaultPivotMinCount = "";
	public static final String DISPLAY_NAME_DEFAULT_MAP_LOCATION = "";
	public static final String DISPLAY_NAME_DEFAULT_MAP_ZOOM = "";
	public static final String DISPLAY_NAME_defaultFieldListVars = "";
	public static final String DISPLAY_NAME_defaultStatsVars = "";
	public static final String DISPLAY_NAME_defaultPivotVars = "";
	public static final String DISPLAY_NAME_listComputateJavaClass = "";
	public static final String DISPLAY_NAME_stats = "";
	public static final String DISPLAY_NAME_facetCounts = "";
	public static final String DISPLAY_NAME_computateJavaClassCount = "";
	public static final String DISPLAY_NAME_computateJavaClass_ = "";
	public static final String DISPLAY_NAME_id = "";
	public static final String DISPLAY_NAME_pageUriComputateJavaClass = "";

	public static String displayNameForClass(String var) {
		return ComputateJavaClassGenPage.displayNameComputateJavaClassGenPage(var);
	}
	public static String displayNameComputateJavaClassGenPage(String var) {
		switch(var) {
		case VAR_searchListComputateJavaClass_:
			return DISPLAY_NAME_searchListComputateJavaClass_;
		case VAR_pageResponse:
			return DISPLAY_NAME_pageResponse;
		case VAR_defaultZoneId:
			return DISPLAY_NAME_defaultZoneId;
		case VAR_defaultTimeZone:
			return DISPLAY_NAME_defaultTimeZone;
		case VAR_defaultLocaleId:
			return DISPLAY_NAME_defaultLocaleId;
		case VAR_defaultLocale:
			return DISPLAY_NAME_defaultLocale;
		case VAR_defaultRangeGap:
			return DISPLAY_NAME_defaultRangeGap;
		case VAR_defaultRangeEnd:
			return DISPLAY_NAME_defaultRangeEnd;
		case VAR_defaultRangeStart:
			return DISPLAY_NAME_defaultRangeStart;
		case VAR_defaultRangeVar:
			return DISPLAY_NAME_defaultRangeVar;
		case VAR_defaultFacetSort:
			return DISPLAY_NAME_defaultFacetSort;
		case VAR_defaultFacetLimit:
			return DISPLAY_NAME_defaultFacetLimit;
		case VAR_defaultFacetMinCount:
			return DISPLAY_NAME_defaultFacetMinCount;
		case VAR_defaultPivotMinCount:
			return DISPLAY_NAME_defaultPivotMinCount;
		case VAR_DEFAULT_MAP_LOCATION:
			return DISPLAY_NAME_DEFAULT_MAP_LOCATION;
		case VAR_DEFAULT_MAP_ZOOM:
			return DISPLAY_NAME_DEFAULT_MAP_ZOOM;
		case VAR_defaultFieldListVars:
			return DISPLAY_NAME_defaultFieldListVars;
		case VAR_defaultStatsVars:
			return DISPLAY_NAME_defaultStatsVars;
		case VAR_defaultPivotVars:
			return DISPLAY_NAME_defaultPivotVars;
		case VAR_listComputateJavaClass:
			return DISPLAY_NAME_listComputateJavaClass;
		case VAR_stats:
			return DISPLAY_NAME_stats;
		case VAR_facetCounts:
			return DISPLAY_NAME_facetCounts;
		case VAR_computateJavaClassCount:
			return DISPLAY_NAME_computateJavaClassCount;
		case VAR_computateJavaClass_:
			return DISPLAY_NAME_computateJavaClass_;
		case VAR_id:
			return DISPLAY_NAME_id;
		case VAR_pageUriComputateJavaClass:
			return DISPLAY_NAME_pageUriComputateJavaClass;
		default:
			return ComputatePageLayout.displayNameComputatePageLayout(var);
		}
	}
}
