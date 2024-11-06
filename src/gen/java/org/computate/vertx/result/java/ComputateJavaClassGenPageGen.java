package org.computate.vertx.result.java;

import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.page.ComputatePageLayout;
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
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.result.java.ComputateJavaClass;
import java.lang.String;
import org.computate.search.response.solr.SolrResponse.Stats;
import org.computate.search.response.solr.SolrResponse.FacetCounts;
import io.vertx.core.json.JsonObject;
import java.time.ZoneId;
import java.util.Locale;
import java.lang.Long;
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
import java.math.BigDecimal;
import io.vertx.core.json.JsonArray;
import java.lang.Void;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ComputateJavaClassGenPage objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ComputateJavaClassGenPageGen into the class ComputateJavaClassGenPage. 
 * </li>
 * <h3>About the ComputateJavaClassGenPage class and it's generated class ComputateJavaClassGenPageGen&lt;ComputatePageLayout&gt;: </h3>extends ComputateJavaClassGenPageGen
 * <p>
 * This Java class extends a generated Java class ComputateJavaClassGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage">Find the class ComputateJavaClassGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ComputateJavaClassGenPageGen<ComputatePageLayout>
 * <p>This <code>class ComputateJavaClassGenPage extends ComputateJavaClassGenPageGen&lt;ComputatePageLayout&gt;</code>, which means it extends a newly generated ComputateJavaClassGenPageGen. 
 * The generated <code>class ComputateJavaClassGenPageGen extends ComputatePageLayout</code> which means that ComputateJavaClassGenPage extends ComputateJavaClassGenPageGen which extends ComputatePageLayout. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the ComputateJavaClassGenPage class will inherit the helpful inherited class comments from the super class ComputateJavaClassGenPageGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the ComputateJavaClassGenPage Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class ComputateJavaClassGenPage in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:searchListComputateJavaClass_">Find the entity searchListComputateJavaClass_ in Solr</a>
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
			Optional.ofNullable(searchListComputateJavaClass_Wrap.getO()).ifPresent(o -> {
				setSearchListComputateJavaClass_(o);
			});
		}
		return (ComputateJavaClassGenPage)this;
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:listComputateJavaClass">Find the entity listComputateJavaClass in Solr</a>
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
	@JsonIgnore
	public void setListComputateJavaClass(String o) {
		this.listComputateJavaClass = ComputateJavaClassGenPage.staticSetListComputateJavaClass(siteRequest_, o);
	}
	public static JsonArray staticSetListComputateJavaClass(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonArray(o);
		}
		return null;
	}
	protected ComputateJavaClassGenPage listComputateJavaClassInit() {
		_listComputateJavaClass(listComputateJavaClass);
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchListComputateJavaClass(ComputateSiteRequest siteRequest_, JsonArray o) {
		return o.toString();
	}

	public static String staticSearchStrListComputateJavaClass(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqListComputateJavaClass(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchListComputateJavaClass(siteRequest_, ComputateJavaClassGenPage.staticSetListComputateJavaClass(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:computateJavaClassCount">Find the entity computateJavaClassCount in Solr</a>
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
			Optional.ofNullable(computateJavaClassCountWrap.getO()).ifPresent(o -> {
				setComputateJavaClassCount(o);
			});
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
		return ComputateJavaClassGenPage.staticSearchComputateJavaClassCount(siteRequest_, ComputateJavaClassGenPage.staticSetComputateJavaClassCount(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:computateJavaClass_">Find the entity computateJavaClass_ in Solr</a>
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
			Optional.ofNullable(computateJavaClass_Wrap.getO()).ifPresent(o -> {
				setComputateJavaClass_(o);
			});
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
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
			Optional.ofNullable(idWrap.getO()).ifPresent(o -> {
				setId(o);
			});
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
		return ComputateJavaClassGenPage.staticSearchId(siteRequest_, ComputateJavaClassGenPage.staticSetId(siteRequest_, o)).toString();
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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:pageUriComputateJavaClass">Find the entity pageUriComputateJavaClass in Solr</a>
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
			Optional.ofNullable(pageUriComputateJavaClassWrap.getO()).ifPresent(o -> {
				setPageUriComputateJavaClass(o);
			});
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
		return ComputateJavaClassGenPage.staticSearchPageUriComputateJavaClass(siteRequest_, ComputateJavaClassGenPage.staticSetPageUriComputateJavaClass(siteRequest_, o)).toString();
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
				listComputateJavaClassInit();
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
			case "listComputateJavaClass":
				return oComputateJavaClassGenPage.listComputateJavaClass;
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
		case "listComputateJavaClass":
			return ComputateJavaClassGenPage.staticSetListComputateJavaClass(siteRequest_, o);
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
		case "listComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchListComputateJavaClass(siteRequest_, (JsonArray)o);
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
		case "listComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchStrListComputateJavaClass(siteRequest_, (String)o);
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
		case "listComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchFqListComputateJavaClass(siteRequest_, o);
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
	public static final String VAR_listComputateJavaClass = "listComputateJavaClass";
	public static final String VAR_computateJavaClassCount = "computateJavaClassCount";
	public static final String VAR_computateJavaClass_ = "computateJavaClass_";
	public static final String VAR_id = "id";
	public static final String VAR_pageUriComputateJavaClass = "pageUriComputateJavaClass";

	public static final String DISPLAY_NAME_searchListComputateJavaClass_ = "";
	public static final String DISPLAY_NAME_listComputateJavaClass = "";
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
		case VAR_listComputateJavaClass:
			return DISPLAY_NAME_listComputateJavaClass;
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
