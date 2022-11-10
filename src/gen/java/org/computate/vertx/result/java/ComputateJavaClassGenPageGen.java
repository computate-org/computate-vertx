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
import java.lang.Object;
import org.computate.vertx.search.list.SearchList;
import org.computate.vertx.result.java.ComputateJavaClass;
import java.lang.String;
import org.computate.search.response.solr.SolrResponse.Stats;
import org.computate.search.response.solr.SolrResponse.FacetCounts;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import java.lang.Integer;
import java.lang.Void;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;

/**	
<ol>
<li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ComputateJavaClassGenPage objects in a RESTful API. 
</li>
<li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ComputateJavaClassGenPageGen into the class ComputateJavaClassGenPage. 
</li>
0<h3>Suggestions that can generate more code for you: </h3></ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these ComputateJavaClassGenPage objects in a RESTful API. 
 * </li>
 * <li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class ComputateJavaClassGenPageGen into the class ComputateJavaClassGenPage. 
 * </li>
 * 0<h3>Suggestions that can generate more code for you: </h3>
 * <h3>About the ComputateJavaClassGenPage class and it's generated class ComputateJavaClassGenPageGen&lt;Object&gt;: </h3>extends ComputateJavaClassGenPageGen
 * <p>
 * This Java class extends a generated Java class ComputateJavaClassGenPageGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage">Find the class ComputateJavaClassGenPage in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends ComputateJavaClassGenPageGen<Object>
 * <p>This <code>class ComputateJavaClassGenPage extends ComputateJavaClassGenPageGen&lt;Object&gt;</code>, which means it extends a newly generated ComputateJavaClassGenPageGen. 
 * The generated <code>class ComputateJavaClassGenPageGen extends Object</code> which means that ComputateJavaClassGenPage extends ComputateJavaClassGenPageGen which extends Object. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * Api: true
 * ApiTag.enUS: null
 * ApiUri.enUS: null
 * Color: null
 * IconGroup: null
 * IconName: null
 * Indexed: true
 * {@inheritDoc}
 * <p>By adding a class comment "{@inheritDoc}", the ComputateJavaClassGenPage class will inherit the helpful inherited class comments from the super class ComputateJavaClassGenPageGen. 
 * </p>
 * Rows: null
 * Model: true
 * Page: true
 * SuperPage.enUS: null
 * Promise: true
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
 * AName: null
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
public abstract class ComputateJavaClassGenPageGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateJavaClassGenPage.class);

	//////////////////
	// siteRequest_ //
	//////////////////


	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected ComputateSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
	protected ComputateJavaClassGenPage siteRequest_Init() {
		Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

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

	////////////////
	// pagination //
	////////////////


	/**	 The entity pagination
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject pagination = new JsonObject();

	/**	<br> The entity pagination
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:pagination">Find the entity pagination in Solr</a>
	 * <br>
	 * @param pagination is the entity already constructed. 
	 **/
	protected abstract void _pagination(JsonObject pagination);

	public JsonObject getPagination() {
		return pagination;
	}

	public void setPagination(JsonObject pagination) {
		this.pagination = pagination;
	}
	@JsonIgnore
	public void setPagination(String o) {
		this.pagination = ComputateJavaClassGenPage.staticSetPagination(siteRequest_, o);
	}
	public static JsonObject staticSetPagination(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputateJavaClassGenPage paginationInit() {
		_pagination(pagination);
		return (ComputateJavaClassGenPage)this;
	}

	public static JsonObject staticSearchPagination(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrPagination(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPagination(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrPagination(siteRequest_, ComputateJavaClassGenPage.staticSearchPagination(siteRequest_, ComputateJavaClassGenPage.staticSetPagination(siteRequest_, o)));
	}

	///////////
	// varsQ //
	///////////


	/**	 The entity varsQ
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject varsQ = new JsonObject();

	/**	<br> The entity varsQ
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:varsQ">Find the entity varsQ in Solr</a>
	 * <br>
	 * @param vars is the entity already constructed. 
	 **/
	protected abstract void _varsQ(JsonObject vars);

	public JsonObject getVarsQ() {
		return varsQ;
	}

	public void setVarsQ(JsonObject varsQ) {
		this.varsQ = varsQ;
	}
	@JsonIgnore
	public void setVarsQ(String o) {
		this.varsQ = ComputateJavaClassGenPage.staticSetVarsQ(siteRequest_, o);
	}
	public static JsonObject staticSetVarsQ(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputateJavaClassGenPage varsQInit() {
		_varsQ(varsQ);
		return (ComputateJavaClassGenPage)this;
	}

	public static JsonObject staticSearchVarsQ(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrVarsQ(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVarsQ(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrVarsQ(siteRequest_, ComputateJavaClassGenPage.staticSearchVarsQ(siteRequest_, ComputateJavaClassGenPage.staticSetVarsQ(siteRequest_, o)));
	}

	////////////
	// varsFq //
	////////////


	/**	 The entity varsFq
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject varsFq = new JsonObject();

	/**	<br> The entity varsFq
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:varsFq">Find the entity varsFq in Solr</a>
	 * <br>
	 * @param vars is the entity already constructed. 
	 **/
	protected abstract void _varsFq(JsonObject vars);

	public JsonObject getVarsFq() {
		return varsFq;
	}

	public void setVarsFq(JsonObject varsFq) {
		this.varsFq = varsFq;
	}
	@JsonIgnore
	public void setVarsFq(String o) {
		this.varsFq = ComputateJavaClassGenPage.staticSetVarsFq(siteRequest_, o);
	}
	public static JsonObject staticSetVarsFq(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputateJavaClassGenPage varsFqInit() {
		_varsFq(varsFq);
		return (ComputateJavaClassGenPage)this;
	}

	public static JsonObject staticSearchVarsFq(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrVarsFq(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVarsFq(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrVarsFq(siteRequest_, ComputateJavaClassGenPage.staticSearchVarsFq(siteRequest_, ComputateJavaClassGenPage.staticSetVarsFq(siteRequest_, o)));
	}

	///////////////
	// varsRange //
	///////////////


	/**	 The entity varsRange
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject varsRange = new JsonObject();

	/**	<br> The entity varsRange
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:varsRange">Find the entity varsRange in Solr</a>
	 * <br>
	 * @param vars is the entity already constructed. 
	 **/
	protected abstract void _varsRange(JsonObject vars);

	public JsonObject getVarsRange() {
		return varsRange;
	}

	public void setVarsRange(JsonObject varsRange) {
		this.varsRange = varsRange;
	}
	@JsonIgnore
	public void setVarsRange(String o) {
		this.varsRange = ComputateJavaClassGenPage.staticSetVarsRange(siteRequest_, o);
	}
	public static JsonObject staticSetVarsRange(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputateJavaClassGenPage varsRangeInit() {
		_varsRange(varsRange);
		return (ComputateJavaClassGenPage)this;
	}

	public static JsonObject staticSearchVarsRange(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrVarsRange(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqVarsRange(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrVarsRange(siteRequest_, ComputateJavaClassGenPage.staticSearchVarsRange(siteRequest_, ComputateJavaClassGenPage.staticSetVarsRange(siteRequest_, o)));
	}

	///////////
	// query //
	///////////


	/**	 The entity query
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject query = new JsonObject();

	/**	<br> The entity query
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:query">Find the entity query in Solr</a>
	 * <br>
	 * @param query is the entity already constructed. 
	 **/
	protected abstract void _query(JsonObject query);

	public JsonObject getQuery() {
		return query;
	}

	public void setQuery(JsonObject query) {
		this.query = query;
	}
	@JsonIgnore
	public void setQuery(String o) {
		this.query = ComputateJavaClassGenPage.staticSetQuery(siteRequest_, o);
	}
	public static JsonObject staticSetQuery(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputateJavaClassGenPage queryInit() {
		_query(query);
		return (ComputateJavaClassGenPage)this;
	}

	public static JsonObject staticSearchQuery(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrQuery(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqQuery(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrQuery(siteRequest_, ComputateJavaClassGenPage.staticSearchQuery(siteRequest_, ComputateJavaClassGenPage.staticSetQuery(siteRequest_, o)));
	}

	///////////////////////
	// defaultRangeStats //
	///////////////////////


	/**	 The entity defaultRangeStats
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject defaultRangeStats;

	/**	<br> The entity defaultRangeStats
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:defaultRangeStats">Find the entity defaultRangeStats in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultRangeStats(Wrap<JsonObject> w);

	public JsonObject getDefaultRangeStats() {
		return defaultRangeStats;
	}

	public void setDefaultRangeStats(JsonObject defaultRangeStats) {
		this.defaultRangeStats = defaultRangeStats;
	}
	@JsonIgnore
	public void setDefaultRangeStats(String o) {
		this.defaultRangeStats = ComputateJavaClassGenPage.staticSetDefaultRangeStats(siteRequest_, o);
	}
	public static JsonObject staticSetDefaultRangeStats(ComputateSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected ComputateJavaClassGenPage defaultRangeStatsInit() {
		Wrap<JsonObject> defaultRangeStatsWrap = new Wrap<JsonObject>().var("defaultRangeStats");
		if(defaultRangeStats == null) {
			_defaultRangeStats(defaultRangeStatsWrap);
			setDefaultRangeStats(defaultRangeStatsWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static JsonObject staticSearchDefaultRangeStats(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrDefaultRangeStats(ComputateSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultRangeStats(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrDefaultRangeStats(siteRequest_, ComputateJavaClassGenPage.staticSearchDefaultRangeStats(siteRequest_, ComputateJavaClassGenPage.staticSetDefaultRangeStats(siteRequest_, o)));
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

	///////////////////
	// promiseBefore //
	///////////////////


	/**	 The entity promiseBefore
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseBefore;

	/**	<br> The entity promiseBefore
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:promiseBefore">Find the entity promiseBefore in Solr</a>
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

	/////////////////////
	// classSimpleName //
	/////////////////////


	/**	 The entity classSimpleName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classSimpleName;

	/**	<br> The entity classSimpleName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSimpleName(Wrap<String> w);

	public String getClassSimpleName() {
		return classSimpleName;
	}
	public void setClassSimpleName(String o) {
		this.classSimpleName = ComputateJavaClassGenPage.staticSetClassSimpleName(siteRequest_, o);
	}
	public static String staticSetClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage classSimpleNameInit() {
		Wrap<String> classSimpleNameWrap = new Wrap<String>().var("classSimpleName");
		if(classSimpleName == null) {
			_classSimpleName(classSimpleNameWrap);
			setClassSimpleName(classSimpleNameWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassSimpleName(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrClassSimpleName(siteRequest_, ComputateJavaClassGenPage.staticSearchClassSimpleName(siteRequest_, ComputateJavaClassGenPage.staticSetClassSimpleName(siteRequest_, o)));
	}

	///////////////
	// pageTitle //
	///////////////


	/**	 The entity pageTitle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageTitle;

	/**	<br> The entity pageTitle
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:pageTitle">Find the entity pageTitle in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageTitle(Wrap<String> c);

	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String o) {
		this.pageTitle = ComputateJavaClassGenPage.staticSetPageTitle(siteRequest_, o);
	}
	public static String staticSetPageTitle(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage pageTitleInit() {
		Wrap<String> pageTitleWrap = new Wrap<String>().var("pageTitle");
		if(pageTitle == null) {
			_pageTitle(pageTitleWrap);
			setPageTitle(pageTitleWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchPageTitle(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageTitle(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageTitle(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrPageTitle(siteRequest_, ComputateJavaClassGenPage.staticSearchPageTitle(siteRequest_, ComputateJavaClassGenPage.staticSetPageTitle(siteRequest_, o)));
	}

	/////////////
	// pageUri //
	/////////////


	/**	 The entity pageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUri;

	/**	<br> The entity pageUri
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:pageUri">Find the entity pageUri in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUri(Wrap<String> c);

	public String getPageUri() {
		return pageUri;
	}
	public void setPageUri(String o) {
		this.pageUri = ComputateJavaClassGenPage.staticSetPageUri(siteRequest_, o);
	}
	public static String staticSetPageUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage pageUriInit() {
		Wrap<String> pageUriWrap = new Wrap<String>().var("pageUri");
		if(pageUri == null) {
			_pageUri(pageUriWrap);
			setPageUri(pageUriWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchPageUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageUri(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageUri(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrPageUri(siteRequest_, ComputateJavaClassGenPage.staticSearchPageUri(siteRequest_, ComputateJavaClassGenPage.staticSetPageUri(siteRequest_, o)));
	}

	////////////
	// apiUri //
	////////////


	/**	 The entity apiUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String apiUri;

	/**	<br> The entity apiUri
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:apiUri">Find the entity apiUri in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _apiUri(Wrap<String> c);

	public String getApiUri() {
		return apiUri;
	}
	public void setApiUri(String o) {
		this.apiUri = ComputateJavaClassGenPage.staticSetApiUri(siteRequest_, o);
	}
	public static String staticSetApiUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage apiUriInit() {
		Wrap<String> apiUriWrap = new Wrap<String>().var("apiUri");
		if(apiUri == null) {
			_apiUri(apiUriWrap);
			setApiUri(apiUriWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchApiUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrApiUri(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqApiUri(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrApiUri(siteRequest_, ComputateJavaClassGenPage.staticSearchApiUri(siteRequest_, ComputateJavaClassGenPage.staticSetApiUri(siteRequest_, o)));
	}

	///////////
	// roles //
	///////////


	/**	 The entity roles
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> roles = new ArrayList<String>();

	/**	<br> The entity roles
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:roles">Find the entity roles in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _roles(List<String> l);

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public static String staticSetRoles(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateJavaClassGenPage addRoles(String...objects) {
		for(String o : objects) {
			addRoles(o);
		}
		return (ComputateJavaClassGenPage)this;
	}
	public ComputateJavaClassGenPage addRoles(String o) {
		if(o != null)
			this.roles.add(o);
		return (ComputateJavaClassGenPage)this;
	}
	@JsonIgnore
	public void setRoles(JsonArray objects) {
		roles.clear();
		for(int i = 0; i < objects.size(); i++) {
			String o = objects.getString(i);
			addRoles(o);
		}
	}
	protected ComputateJavaClassGenPage rolesInit() {
		_roles(roles);
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchRoles(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrRoles(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqRoles(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrRoles(siteRequest_, ComputateJavaClassGenPage.staticSearchRoles(siteRequest_, ComputateJavaClassGenPage.staticSetRoles(siteRequest_, o)));
	}

	//////////////////
	// promiseAfter //
	//////////////////


	/**	 The entity promiseAfter
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Void promiseAfter;

	/**	<br> The entity promiseAfter
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:promiseAfter">Find the entity promiseAfter in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _promiseAfter(Promise<Void> promise);

	public Void getPromiseAfter() {
		return promiseAfter;
	}

	public void setPromiseAfter(Void promiseAfter) {
		this.promiseAfter = promiseAfter;
	}
	public static Void staticSetPromiseAfter(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected Future<Void> promiseAfterPromise() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		_promiseAfter(promise2);
		promise2.future().onSuccess(o -> {
			setPromiseAfter(o);
			promise.complete(o);
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	//////////////////
	// pageImageUri //
	//////////////////


	/**	 The entity pageImageUri
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageImageUri;

	/**	<br> The entity pageImageUri
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:pageImageUri">Find the entity pageImageUri in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageImageUri(Wrap<String> c);

	public String getPageImageUri() {
		return pageImageUri;
	}
	public void setPageImageUri(String o) {
		this.pageImageUri = ComputateJavaClassGenPage.staticSetPageImageUri(siteRequest_, o);
	}
	public static String staticSetPageImageUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage pageImageUriInit() {
		Wrap<String> pageImageUriWrap = new Wrap<String>().var("pageImageUri");
		if(pageImageUri == null) {
			_pageImageUri(pageImageUriWrap);
			setPageImageUri(pageImageUriWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchPageImageUri(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrPageImageUri(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPageImageUri(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrPageImageUri(siteRequest_, ComputateJavaClassGenPage.staticSearchPageImageUri(siteRequest_, ComputateJavaClassGenPage.staticSetPageImageUri(siteRequest_, o)));
	}

	////////////////////
	// classIconGroup //
	////////////////////


	/**	 The entity classIconGroup
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classIconGroup;

	/**	<br> The entity classIconGroup
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:classIconGroup">Find the entity classIconGroup in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classIconGroup(Wrap<String> c);

	public String getClassIconGroup() {
		return classIconGroup;
	}
	public void setClassIconGroup(String o) {
		this.classIconGroup = ComputateJavaClassGenPage.staticSetClassIconGroup(siteRequest_, o);
	}
	public static String staticSetClassIconGroup(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage classIconGroupInit() {
		Wrap<String> classIconGroupWrap = new Wrap<String>().var("classIconGroup");
		if(classIconGroup == null) {
			_classIconGroup(classIconGroupWrap);
			setClassIconGroup(classIconGroupWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchClassIconGroup(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassIconGroup(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassIconGroup(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrClassIconGroup(siteRequest_, ComputateJavaClassGenPage.staticSearchClassIconGroup(siteRequest_, ComputateJavaClassGenPage.staticSetClassIconGroup(siteRequest_, o)));
	}

	///////////////////
	// classIconName //
	///////////////////


	/**	 The entity classIconName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classIconName;

	/**	<br> The entity classIconName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.result.java.ComputateJavaClassGenPage&fq=entiteVar_enUS_indexed_string:classIconName">Find the entity classIconName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classIconName(Wrap<String> c);

	public String getClassIconName() {
		return classIconName;
	}
	public void setClassIconName(String o) {
		this.classIconName = ComputateJavaClassGenPage.staticSetClassIconName(siteRequest_, o);
	}
	public static String staticSetClassIconName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateJavaClassGenPage classIconNameInit() {
		Wrap<String> classIconNameWrap = new Wrap<String>().var("classIconName");
		if(classIconName == null) {
			_classIconName(classIconNameWrap);
			setClassIconName(classIconNameWrap.o);
		}
		return (ComputateJavaClassGenPage)this;
	}

	public static String staticSearchClassIconName(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrClassIconName(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqClassIconName(ComputateSiteRequest siteRequest_, String o) {
		return ComputateJavaClassGenPage.staticSearchStrClassIconName(siteRequest_, ComputateJavaClassGenPage.staticSearchClassIconName(siteRequest_, ComputateJavaClassGenPage.staticSetClassIconName(siteRequest_, o)));
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
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputateJavaClassGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				searchListComputateJavaClass_Init();
				pageResponseInit();
				statsInit();
				facetCountsInit();
				paginationInit();
				varsQInit();
				varsFqInit();
				varsRangeInit();
				queryInit();
				defaultRangeStatsInit();
				defaultFieldListVarsInit();
				defaultStatsVarsInit();
				defaultPivotVarsInit();
				listComputateJavaClassInit();
				computateJavaClassCountInit();
				computateJavaClass_Init();
				idInit();
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
				classSimpleNameInit();
				pageTitleInit();
				pageUriInit();
				apiUriInit();
				rolesInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			promiseAfterPromise().onSuccess(promiseAfter -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				pageImageUriInit();
				classIconGroupInit();
				classIconNameInit();
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

	public Future<Void> promiseDeepForClass(ComputateSiteRequest siteRequest_) {
		return promiseDeepComputateJavaClassGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateJavaClassGenPage(ComputateSiteRequest siteRequest_) {
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestComputateJavaClassGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
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
			case "siteRequest_":
				return oComputateJavaClassGenPage.siteRequest_;
			case "searchListComputateJavaClass_":
				return oComputateJavaClassGenPage.searchListComputateJavaClass_;
			case "pageResponse":
				return oComputateJavaClassGenPage.pageResponse;
			case "stats":
				return oComputateJavaClassGenPage.stats;
			case "facetCounts":
				return oComputateJavaClassGenPage.facetCounts;
			case "pagination":
				return oComputateJavaClassGenPage.pagination;
			case "varsQ":
				return oComputateJavaClassGenPage.varsQ;
			case "varsFq":
				return oComputateJavaClassGenPage.varsFq;
			case "varsRange":
				return oComputateJavaClassGenPage.varsRange;
			case "query":
				return oComputateJavaClassGenPage.query;
			case "defaultRangeStats":
				return oComputateJavaClassGenPage.defaultRangeStats;
			case "defaultFieldListVars":
				return oComputateJavaClassGenPage.defaultFieldListVars;
			case "defaultStatsVars":
				return oComputateJavaClassGenPage.defaultStatsVars;
			case "defaultPivotVars":
				return oComputateJavaClassGenPage.defaultPivotVars;
			case "listComputateJavaClass":
				return oComputateJavaClassGenPage.listComputateJavaClass;
			case "computateJavaClassCount":
				return oComputateJavaClassGenPage.computateJavaClassCount;
			case "computateJavaClass_":
				return oComputateJavaClassGenPage.computateJavaClass_;
			case "id":
				return oComputateJavaClassGenPage.id;
			case "promiseBefore":
				return oComputateJavaClassGenPage.promiseBefore;
			case "classSimpleName":
				return oComputateJavaClassGenPage.classSimpleName;
			case "pageTitle":
				return oComputateJavaClassGenPage.pageTitle;
			case "pageUri":
				return oComputateJavaClassGenPage.pageUri;
			case "apiUri":
				return oComputateJavaClassGenPage.apiUri;
			case "roles":
				return oComputateJavaClassGenPage.roles;
			case "promiseAfter":
				return oComputateJavaClassGenPage.promiseAfter;
			case "pageImageUri":
				return oComputateJavaClassGenPage.pageImageUri;
			case "classIconGroup":
				return oComputateJavaClassGenPage.classIconGroup;
			case "classIconName":
				return oComputateJavaClassGenPage.classIconName;
			case "pageUriComputateJavaClass":
				return oComputateJavaClassGenPage.pageUriComputateJavaClass;
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
				o = relateComputateJavaClassGenPage(v, val);
		}
		return o != null;
	}
	public Object relateComputateJavaClassGenPage(String var, Object val) {
		ComputateJavaClassGenPage oComputateJavaClassGenPage = (ComputateJavaClassGenPage)this;
		switch(var) {
			default:
				return null;
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
		case "pagination":
			return ComputateJavaClassGenPage.staticSetPagination(siteRequest_, o);
		case "varsQ":
			return ComputateJavaClassGenPage.staticSetVarsQ(siteRequest_, o);
		case "varsFq":
			return ComputateJavaClassGenPage.staticSetVarsFq(siteRequest_, o);
		case "varsRange":
			return ComputateJavaClassGenPage.staticSetVarsRange(siteRequest_, o);
		case "query":
			return ComputateJavaClassGenPage.staticSetQuery(siteRequest_, o);
		case "defaultRangeStats":
			return ComputateJavaClassGenPage.staticSetDefaultRangeStats(siteRequest_, o);
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
		case "classSimpleName":
			return ComputateJavaClassGenPage.staticSetClassSimpleName(siteRequest_, o);
		case "pageTitle":
			return ComputateJavaClassGenPage.staticSetPageTitle(siteRequest_, o);
		case "pageUri":
			return ComputateJavaClassGenPage.staticSetPageUri(siteRequest_, o);
		case "apiUri":
			return ComputateJavaClassGenPage.staticSetApiUri(siteRequest_, o);
		case "roles":
			return ComputateJavaClassGenPage.staticSetRoles(siteRequest_, o);
		case "pageImageUri":
			return ComputateJavaClassGenPage.staticSetPageImageUri(siteRequest_, o);
		case "classIconGroup":
			return ComputateJavaClassGenPage.staticSetClassIconGroup(siteRequest_, o);
		case "classIconName":
			return ComputateJavaClassGenPage.staticSetClassIconName(siteRequest_, o);
		case "pageUriComputateJavaClass":
			return ComputateJavaClassGenPage.staticSetPageUriComputateJavaClass(siteRequest_, o);
			default:
				return null;
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
		case "pagination":
			return ComputateJavaClassGenPage.staticSearchPagination(siteRequest_, (JsonObject)o);
		case "varsQ":
			return ComputateJavaClassGenPage.staticSearchVarsQ(siteRequest_, (JsonObject)o);
		case "varsFq":
			return ComputateJavaClassGenPage.staticSearchVarsFq(siteRequest_, (JsonObject)o);
		case "varsRange":
			return ComputateJavaClassGenPage.staticSearchVarsRange(siteRequest_, (JsonObject)o);
		case "query":
			return ComputateJavaClassGenPage.staticSearchQuery(siteRequest_, (JsonObject)o);
		case "defaultRangeStats":
			return ComputateJavaClassGenPage.staticSearchDefaultRangeStats(siteRequest_, (JsonObject)o);
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
		case "classSimpleName":
			return ComputateJavaClassGenPage.staticSearchClassSimpleName(siteRequest_, (String)o);
		case "pageTitle":
			return ComputateJavaClassGenPage.staticSearchPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return ComputateJavaClassGenPage.staticSearchPageUri(siteRequest_, (String)o);
		case "apiUri":
			return ComputateJavaClassGenPage.staticSearchApiUri(siteRequest_, (String)o);
		case "roles":
			return ComputateJavaClassGenPage.staticSearchRoles(siteRequest_, (String)o);
		case "pageImageUri":
			return ComputateJavaClassGenPage.staticSearchPageImageUri(siteRequest_, (String)o);
		case "classIconGroup":
			return ComputateJavaClassGenPage.staticSearchClassIconGroup(siteRequest_, (String)o);
		case "classIconName":
			return ComputateJavaClassGenPage.staticSearchClassIconName(siteRequest_, (String)o);
		case "pageUriComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchPageUriComputateJavaClass(siteRequest_, (String)o);
			default:
				return null;
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
		case "pagination":
			return ComputateJavaClassGenPage.staticSearchStrPagination(siteRequest_, (JsonObject)o);
		case "varsQ":
			return ComputateJavaClassGenPage.staticSearchStrVarsQ(siteRequest_, (JsonObject)o);
		case "varsFq":
			return ComputateJavaClassGenPage.staticSearchStrVarsFq(siteRequest_, (JsonObject)o);
		case "varsRange":
			return ComputateJavaClassGenPage.staticSearchStrVarsRange(siteRequest_, (JsonObject)o);
		case "query":
			return ComputateJavaClassGenPage.staticSearchStrQuery(siteRequest_, (JsonObject)o);
		case "defaultRangeStats":
			return ComputateJavaClassGenPage.staticSearchStrDefaultRangeStats(siteRequest_, (JsonObject)o);
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
		case "classSimpleName":
			return ComputateJavaClassGenPage.staticSearchStrClassSimpleName(siteRequest_, (String)o);
		case "pageTitle":
			return ComputateJavaClassGenPage.staticSearchStrPageTitle(siteRequest_, (String)o);
		case "pageUri":
			return ComputateJavaClassGenPage.staticSearchStrPageUri(siteRequest_, (String)o);
		case "apiUri":
			return ComputateJavaClassGenPage.staticSearchStrApiUri(siteRequest_, (String)o);
		case "roles":
			return ComputateJavaClassGenPage.staticSearchStrRoles(siteRequest_, (String)o);
		case "pageImageUri":
			return ComputateJavaClassGenPage.staticSearchStrPageImageUri(siteRequest_, (String)o);
		case "classIconGroup":
			return ComputateJavaClassGenPage.staticSearchStrClassIconGroup(siteRequest_, (String)o);
		case "classIconName":
			return ComputateJavaClassGenPage.staticSearchStrClassIconName(siteRequest_, (String)o);
		case "pageUriComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchStrPageUriComputateJavaClass(siteRequest_, (String)o);
			default:
				return null;
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
		case "pagination":
			return ComputateJavaClassGenPage.staticSearchFqPagination(siteRequest_, o);
		case "varsQ":
			return ComputateJavaClassGenPage.staticSearchFqVarsQ(siteRequest_, o);
		case "varsFq":
			return ComputateJavaClassGenPage.staticSearchFqVarsFq(siteRequest_, o);
		case "varsRange":
			return ComputateJavaClassGenPage.staticSearchFqVarsRange(siteRequest_, o);
		case "query":
			return ComputateJavaClassGenPage.staticSearchFqQuery(siteRequest_, o);
		case "defaultRangeStats":
			return ComputateJavaClassGenPage.staticSearchFqDefaultRangeStats(siteRequest_, o);
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
		case "classSimpleName":
			return ComputateJavaClassGenPage.staticSearchFqClassSimpleName(siteRequest_, o);
		case "pageTitle":
			return ComputateJavaClassGenPage.staticSearchFqPageTitle(siteRequest_, o);
		case "pageUri":
			return ComputateJavaClassGenPage.staticSearchFqPageUri(siteRequest_, o);
		case "apiUri":
			return ComputateJavaClassGenPage.staticSearchFqApiUri(siteRequest_, o);
		case "roles":
			return ComputateJavaClassGenPage.staticSearchFqRoles(siteRequest_, o);
		case "pageImageUri":
			return ComputateJavaClassGenPage.staticSearchFqPageImageUri(siteRequest_, o);
		case "classIconGroup":
			return ComputateJavaClassGenPage.staticSearchFqClassIconGroup(siteRequest_, o);
		case "classIconName":
			return ComputateJavaClassGenPage.staticSearchFqClassIconName(siteRequest_, o);
		case "pageUriComputateJavaClass":
			return ComputateJavaClassGenPage.staticSearchFqPageUriComputateJavaClass(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "ComputateJavaClassGenPage";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_searchListComputateJavaClass_ = "searchListComputateJavaClass_";
	public static final String VAR_pageResponse = "pageResponse";
	public static final String VAR_stats = "stats";
	public static final String VAR_facetCounts = "facetCounts";
	public static final String VAR_pagination = "pagination";
	public static final String VAR_varsQ = "varsQ";
	public static final String VAR_varsFq = "varsFq";
	public static final String VAR_varsRange = "varsRange";
	public static final String VAR_query = "query";
	public static final String VAR_defaultRangeStats = "defaultRangeStats";
	public static final String VAR_defaultFieldListVars = "defaultFieldListVars";
	public static final String VAR_defaultStatsVars = "defaultStatsVars";
	public static final String VAR_defaultPivotVars = "defaultPivotVars";
	public static final String VAR_listComputateJavaClass = "listComputateJavaClass";
	public static final String VAR_computateJavaClassCount = "computateJavaClassCount";
	public static final String VAR_computateJavaClass_ = "computateJavaClass_";
	public static final String VAR_id = "id";
	public static final String VAR_promiseBefore = "promiseBefore";
	public static final String VAR_classSimpleName = "classSimpleName";
	public static final String VAR_pageTitle = "pageTitle";
	public static final String VAR_pageUri = "pageUri";
	public static final String VAR_apiUri = "apiUri";
	public static final String VAR_roles = "roles";
	public static final String VAR_promiseAfter = "promiseAfter";
	public static final String VAR_pageImageUri = "pageImageUri";
	public static final String VAR_classIconGroup = "classIconGroup";
	public static final String VAR_classIconName = "classIconName";
	public static final String VAR_pageUriComputateJavaClass = "pageUriComputateJavaClass";

	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_searchListComputateJavaClass_ = "";
	public static final String DISPLAY_NAME_pageResponse = "";
	public static final String DISPLAY_NAME_stats = "";
	public static final String DISPLAY_NAME_facetCounts = "";
	public static final String DISPLAY_NAME_pagination = "";
	public static final String DISPLAY_NAME_varsQ = "";
	public static final String DISPLAY_NAME_varsFq = "";
	public static final String DISPLAY_NAME_varsRange = "";
	public static final String DISPLAY_NAME_query = "";
	public static final String DISPLAY_NAME_defaultRangeStats = "";
	public static final String DISPLAY_NAME_defaultFieldListVars = "";
	public static final String DISPLAY_NAME_defaultStatsVars = "";
	public static final String DISPLAY_NAME_defaultPivotVars = "";
	public static final String DISPLAY_NAME_listComputateJavaClass = "";
	public static final String DISPLAY_NAME_computateJavaClassCount = "";
	public static final String DISPLAY_NAME_computateJavaClass_ = "";
	public static final String DISPLAY_NAME_id = "";
	public static final String DISPLAY_NAME_promiseBefore = "";
	public static final String DISPLAY_NAME_classSimpleName = "";
	public static final String DISPLAY_NAME_pageTitle = "";
	public static final String DISPLAY_NAME_pageUri = "";
	public static final String DISPLAY_NAME_apiUri = "";
	public static final String DISPLAY_NAME_roles = "";
	public static final String DISPLAY_NAME_promiseAfter = "";
	public static final String DISPLAY_NAME_pageImageUri = "";
	public static final String DISPLAY_NAME_classIconGroup = "";
	public static final String DISPLAY_NAME_classIconName = "";
	public static final String DISPLAY_NAME_pageUriComputateJavaClass = "";

	public static String displayNameForClass(String var) {
		return ComputateJavaClassGenPage.displayNameComputateJavaClassGenPage(var);
	}
	public static String displayNameComputateJavaClassGenPage(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_searchListComputateJavaClass_:
			return DISPLAY_NAME_searchListComputateJavaClass_;
		case VAR_pageResponse:
			return DISPLAY_NAME_pageResponse;
		case VAR_stats:
			return DISPLAY_NAME_stats;
		case VAR_facetCounts:
			return DISPLAY_NAME_facetCounts;
		case VAR_pagination:
			return DISPLAY_NAME_pagination;
		case VAR_varsQ:
			return DISPLAY_NAME_varsQ;
		case VAR_varsFq:
			return DISPLAY_NAME_varsFq;
		case VAR_varsRange:
			return DISPLAY_NAME_varsRange;
		case VAR_query:
			return DISPLAY_NAME_query;
		case VAR_defaultRangeStats:
			return DISPLAY_NAME_defaultRangeStats;
		case VAR_defaultFieldListVars:
			return DISPLAY_NAME_defaultFieldListVars;
		case VAR_defaultStatsVars:
			return DISPLAY_NAME_defaultStatsVars;
		case VAR_defaultPivotVars:
			return DISPLAY_NAME_defaultPivotVars;
		case VAR_listComputateJavaClass:
			return DISPLAY_NAME_listComputateJavaClass;
		case VAR_computateJavaClassCount:
			return DISPLAY_NAME_computateJavaClassCount;
		case VAR_computateJavaClass_:
			return DISPLAY_NAME_computateJavaClass_;
		case VAR_id:
			return DISPLAY_NAME_id;
		case VAR_promiseBefore:
			return DISPLAY_NAME_promiseBefore;
		case VAR_classSimpleName:
			return DISPLAY_NAME_classSimpleName;
		case VAR_pageTitle:
			return DISPLAY_NAME_pageTitle;
		case VAR_pageUri:
			return DISPLAY_NAME_pageUri;
		case VAR_apiUri:
			return DISPLAY_NAME_apiUri;
		case VAR_roles:
			return DISPLAY_NAME_roles;
		case VAR_promiseAfter:
			return DISPLAY_NAME_promiseAfter;
		case VAR_pageImageUri:
			return DISPLAY_NAME_pageImageUri;
		case VAR_classIconGroup:
			return DISPLAY_NAME_classIconGroup;
		case VAR_classIconName:
			return DISPLAY_NAME_classIconName;
		case VAR_pageUriComputateJavaClass:
			return DISPLAY_NAME_pageUriComputateJavaClass;
		default:
			return null;
		}
	}
}
