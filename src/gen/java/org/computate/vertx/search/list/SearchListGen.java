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
package org.computate.vertx.search.list;

import org.computate.vertx.request.ComputateSiteRequest;
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
import java.lang.Class;
import java.lang.Boolean;
import org.computate.search.request.SearchRequest;
import java.lang.String;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.response.solr.SolrResponse.Doc;
import java.lang.Object;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**
 * <ol>
<h3>Suggestions that can generate more code for you: </h3> * </ol>
 * <li>You can add a class comment <b>"Api: true"</b> if you wish to GET, POST, PATCH or PUT these SearchList objects in a RESTful API. 
 * </li><li>You can add a class comment "{@inheritDoc}" if you wish to inherit the helpful inherited class comments from class SearchListGen into the class SearchList. 
 * </li>
 * <h3>About the SearchList class and it's generated class SearchListGen&lt;DEV&gt;: </h3>extends SearchListGen
 * <p>
 * This Java class extends a generated Java class SearchListGen built by the <a href="https://github.com/computate-org/computate">https://github.com/computate-org/computate</a> project. 
 * Whenever this Java class is modified or touched, the watch service installed as described in the README, indexes all the information about this Java class in a local Apache Solr Search Engine. 
 * If you are running the service, you can see the indexed data about this Java Class here: 
 * </p>
 * <p><a href="https://solr.apps-crc.testing/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList">Find the class SearchList in Solr. </a></p>
 * <p>
 * The extended class ending with "Gen" did not exist at first, but was automatically created by the same watch service based on the data retrieved from the local Apache Server search engine. 
 * The extended class contains many generated fields, getters, setters, initialization code, and helper methods to help build a website and API fast, reactive, and scalable. 
 * </p>
 * extends SearchListGen<DEV>
 * <p>This <code>class SearchList extends SearchListGen&lt;DEV&gt;</code>, which means it extends a newly generated SearchListGen. 
 * The generated <code>class SearchListGen extends DEV</code> which means that SearchList extends SearchListGen which extends DEV. 
 * This generated inheritance is a powerful feature that allows a lot of boiler plate code to be created for you automatically while still preserving inheritance through the power of Java Generic classes. 
 * </p>
 * <h2>Api: true</h2>
 * <h2>ApiTag.enUS: true</h2>
 * <h2>ApiUri.enUS: null</h2>
 * <h2>Color: null</h2>
 * <h2>Indexed: true</h2>
 * <h2>{@inheritDoc}</h2>
 * <p>By adding a class comment "{@inheritDoc}", the SearchList class will inherit the helpful inherited class comments from the super class SearchListGen. 
 * </p>
 * <h2>Rows: null</h2>
 * <h2>Model: true</h2>
 * <h2>Page: true</h2>
 * <h2>SuperPage.enUS: null</h2>
 * <h2>Promise: true</h2>
 * <p>
 *   This class contains a comment <b>"Promise: true"</b>
 *   Sometimes a Java class must be initialized asynchronously when it involves calling a blocking API. 
 *   This means that the SearchList Java class has promiseDeep methods which must be initialized asynchronously as a Vert.x Promise  instead of initDeep methods which are a simple non-asynchronous method. 
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
 * Delete the class SearchList in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the package org.computate.vertx.search.list in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.search.list&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * <p>
 * Delete  the project computate-vertx in Solr: 
 * curl -k 'https://solr.apps-crc.testing/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'
 * </p>
 * Generated: true
 **/
public abstract class SearchListGen<DEV> {
	protected static final Logger LOG = LoggerFactory.getLogger(SearchList.class);

	///////
	// c //
	///////


	/**	 The entity c
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Class<?> c;

	/**	<br> The entity c
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:c">Find the entity c in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _c(Wrap<Class<?>> c);

	public Class<?> getC() {
		return c;
	}

	public void setC(Class<?> c) {
		this.c = c;
	}
	public static Class<?> staticSetC(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected SearchList cInit() {
		Wrap<Class<?>> cWrap = new Wrap<Class<?>>().var("c");
		if(c == null) {
			_c(cWrap);
			Optional.ofNullable(cWrap.getO()).ifPresent(o -> {
				setC(o);
			});
		}
		return (SearchList)this;
	}

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
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
	protected SearchList siteRequest_Init() {
		Wrap<ComputateSiteRequest> siteRequest_Wrap = new Wrap<ComputateSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			Optional.ofNullable(siteRequest_Wrap.getO()).ifPresent(o -> {
				setSiteRequest_(o);
			});
		}
		return (SearchList)this;
	}

	///////////
	// store //
	///////////


	/**	 The entity store
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Boolean store;

	/**	<br> The entity store
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:store">Find the entity store in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _store(Wrap<Boolean> c);

	public Boolean getStore() {
		return store;
	}

	public void setStore(Boolean store) {
		this.store = store;
	}
	@JsonIgnore
	public void setStore(String o) {
		this.store = SearchList.staticSetStore(siteRequest_, o);
	}
	public static Boolean staticSetStore(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SearchList storeInit() {
		Wrap<Boolean> storeWrap = new Wrap<Boolean>().var("store");
		if(store == null) {
			_store(storeWrap);
			Optional.ofNullable(storeWrap.getO()).ifPresent(o -> {
				setStore(o);
			});
		}
		return (SearchList)this;
	}

	public static Boolean staticSearchStore(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrStore(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqStore(ComputateSiteRequest siteRequest_, String o) {
		return SearchList.staticSearchStore(siteRequest_, SearchList.staticSetStore(siteRequest_, o)).toString();
	}

	//////////////
	// populate //
	//////////////


	/**	 The entity populate
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected Boolean populate;

	/**	<br> The entity populate
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:populate">Find the entity populate in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _populate(Wrap<Boolean> c);

	public Boolean getPopulate() {
		return populate;
	}

	public void setPopulate(Boolean populate) {
		this.populate = populate;
	}
	@JsonIgnore
	public void setPopulate(String o) {
		this.populate = SearchList.staticSetPopulate(siteRequest_, o);
	}
	public static Boolean staticSetPopulate(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SearchList populateInit() {
		Wrap<Boolean> populateWrap = new Wrap<Boolean>().var("populate");
		if(populate == null) {
			_populate(populateWrap);
			Optional.ofNullable(populateWrap.getO()).ifPresent(o -> {
				setPopulate(o);
			});
		}
		return (SearchList)this;
	}

	public static Boolean staticSearchPopulate(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrPopulate(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPopulate(ComputateSiteRequest siteRequest_, String o) {
		return SearchList.staticSearchPopulate(siteRequest_, SearchList.staticSetPopulate(siteRequest_, o)).toString();
	}

	/////////////
	// request //
	/////////////


	/**	 The entity request
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected SearchRequest request = new SearchRequest();

	/**	<br> The entity request
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:request">Find the entity request in Solr</a>
	 * <br>
	 * @param o is the entity already constructed. 
	 **/
	protected abstract void _request(SearchRequest o);

	public SearchRequest getRequest() {
		return request;
	}

	public void setRequest(SearchRequest request) {
		this.request = request;
	}
	public static SearchRequest staticSetRequest(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected SearchList requestInit() {
		_request(request);
		request.initDeepForClass(siteRequest_);
		return (SearchList)this;
	}

	///////////////
	// searchUrl //
	///////////////


	/**	 The entity searchUrl
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String searchUrl;

	/**	<br> The entity searchUrl
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:searchUrl">Find the entity searchUrl in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchUrl(Wrap<String> w);

	public String getSearchUrl() {
		return searchUrl;
	}
	public void setSearchUrl(String o) {
		this.searchUrl = SearchList.staticSetSearchUrl(siteRequest_, o);
	}
	public static String staticSetSearchUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}
	protected SearchList searchUrlInit() {
		Wrap<String> searchUrlWrap = new Wrap<String>().var("searchUrl");
		if(searchUrl == null) {
			_searchUrl(searchUrlWrap);
			Optional.ofNullable(searchUrlWrap.getO()).ifPresent(o -> {
				setSearchUrl(o);
			});
		}
		return (SearchList)this;
	}

	public static String staticSearchSearchUrl(ComputateSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSearchStrSearchUrl(ComputateSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSearchUrl(ComputateSiteRequest siteRequest_, String o) {
		return SearchList.staticSearchSearchUrl(siteRequest_, SearchList.staticSetSearchUrl(siteRequest_, o)).toString();
	}

	/////////////////
	// defaultSort //
	/////////////////


	/**	 The entity defaultSort
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean defaultSort;

	/**	<br> The entity defaultSort
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:defaultSort">Find the entity defaultSort in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _defaultSort(Wrap<Boolean> w);

	public Boolean getDefaultSort() {
		return defaultSort;
	}

	public void setDefaultSort(Boolean defaultSort) {
		this.defaultSort = defaultSort;
	}
	@JsonIgnore
	public void setDefaultSort(String o) {
		this.defaultSort = SearchList.staticSetDefaultSort(siteRequest_, o);
	}
	public static Boolean staticSetDefaultSort(ComputateSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SearchList defaultSortInit() {
		Wrap<Boolean> defaultSortWrap = new Wrap<Boolean>().var("defaultSort");
		if(defaultSort == null) {
			_defaultSort(defaultSortWrap);
			Optional.ofNullable(defaultSortWrap.getO()).ifPresent(o -> {
				setDefaultSort(o);
			});
		}
		return (SearchList)this;
	}

	public static Boolean staticSearchDefaultSort(ComputateSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrDefaultSort(ComputateSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqDefaultSort(ComputateSiteRequest siteRequest_, String o) {
		return SearchList.staticSearchDefaultSort(siteRequest_, SearchList.staticSetDefaultSort(siteRequest_, o)).toString();
	}

	//////////////
	// response //
	//////////////


	/**	 The entity response
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SolrResponse response;

	/**	<br> The entity response
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:response">Find the entity response in Solr</a>
	 * <br>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _response(Promise<SolrResponse> promise);

	public SolrResponse getResponse() {
		return response;
	}

	public void setResponse(SolrResponse response) {
		this.response = response;
	}
	public static SolrResponse staticSetResponse(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected Future<SolrResponse> responsePromise() {
		Promise<SolrResponse> promise = Promise.promise();
		Promise<SolrResponse> promise2 = Promise.promise();
		_response(promise2);
		promise2.future().onSuccess(o -> {
			setResponse(o);
			promise.complete(o);
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	//////////
	// docs //
	//////////


	/**	 The entity docs
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected List<Doc> docs;

	/**	<br> The entity docs
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:docs">Find the entity docs in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _docs(Wrap<List<Doc>> w);

	public List<Doc> getDocs() {
		return docs;
	}

	public void setDocs(List<Doc> docs) {
		this.docs = docs;
	}
	public static Doc staticSetDocs(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	public SearchList addDocs(Doc...objects) {
		for(Doc o : objects) {
			addDocs(o);
		}
		return (SearchList)this;
	}
	public SearchList addDocs(Doc o) {
		if(o != null)
			this.docs.add(o);
		return (SearchList)this;
	}
	protected SearchList docsInit() {
		Wrap<List<Doc>> docsWrap = new Wrap<List<Doc>>().var("docs");
		if(docs == null) {
			_docs(docsWrap);
			Optional.ofNullable(docsWrap.getO()).ifPresent(o -> {
				setDocs(o);
			});
		}
		return (SearchList)this;
	}

	//////////
	// list //
	//////////


	/**	 The entity list
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<DEV> list = new ArrayList<DEV>();

	/**	<br> The entity list
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:list">Find the entity list in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _list(List<DEV> l);

	public List<DEV> getList() {
		return list;
	}

	public void setList(List<DEV> list) {
		this.list = list;
	}
	public SearchList addList(DEV...objects) {
		for(DEV o : objects) {
			addList(o);
		}
		return (SearchList)this;
	}
	public SearchList addList(DEV o) {
		if(o != null)
			this.list.add(o);
		return (SearchList)this;
	}
	protected SearchList listInit() {
		_list(list);
		return (SearchList)this;
	}

	///////////
	// first //
	///////////


	/**	 The entity first
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Object first;

	/**	<br> The entity first
	 *  is defined as null before being initialized. 
	 * <br><a href="https://solr.apps-crc.testing/solr/#/computate/query?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:first">Find the entity first in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _first(Wrap<Object> w);

	public Object getFirst() {
		return first;
	}

	public void setFirst(Object first) {
		this.first = first;
	}
	public static Object staticSetFirst(ComputateSiteRequest siteRequest_, String o) {
		return null;
	}
	protected SearchList firstInit() {
		Wrap<Object> firstWrap = new Wrap<Object>().var("first");
		if(first == null) {
			_first(firstWrap);
			Optional.ofNullable(firstWrap.getO()).ifPresent(o -> {
				setFirst(o);
			});
		}
		return (SearchList)this;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<SearchListGen<DEV>> promiseDeepSearchList(ComputateSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepSearchList();
	}

	public Future<SearchListGen<DEV>> promiseDeepSearchList() {
		Promise<SearchListGen<DEV>> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSearchList(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete(this);
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseSearchList(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				cInit();
				siteRequest_Init();
				storeInit();
				populateInit();
				requestInit();
				searchUrlInit();
				defaultSortInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			responsePromise().onSuccess(response -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				docsInit();
				listInit();
				firstInit();
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

	public Future<? extends SearchListGen<DEV>> promiseDeepForClass(ComputateSiteRequest siteRequest_) {
		return promiseDeepSearchList(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSearchList(ComputateSiteRequest siteRequest_) {
		if(request != null)
			request.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(ComputateSiteRequest siteRequest_) {
		siteRequestSearchList(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSearchList(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainSearchList(String var) {
		SearchList oSearchList = (SearchList)this;
		switch(var) {
			case "c":
				return oSearchList.c;
			case "siteRequest_":
				return oSearchList.siteRequest_;
			case "store":
				return oSearchList.store;
			case "populate":
				return oSearchList.populate;
			case "request":
				return oSearchList.request;
			case "searchUrl":
				return oSearchList.searchUrl;
			case "defaultSort":
				return oSearchList.defaultSort;
			case "response":
				return oSearchList.response;
			case "docs":
				return oSearchList.docs;
			case "list":
				return oSearchList.list;
			case "first":
				return oSearchList.first;
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
				o = relateSearchList(v, val);
		}
		return o != null;
	}
	public Object relateSearchList(String var, Object val) {
		SearchList oSearchList = (SearchList)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSetSearchList(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSearchList(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSetStore(siteRequest_, o);
		case "populate":
			return SearchList.staticSetPopulate(siteRequest_, o);
		case "searchUrl":
			return SearchList.staticSetSearchUrl(siteRequest_, o);
		case "defaultSort":
			return SearchList.staticSetDefaultSort(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchSearchList(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchSearchList(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSearchStore(siteRequest_, (Boolean)o);
		case "populate":
			return SearchList.staticSearchPopulate(siteRequest_, (Boolean)o);
		case "searchUrl":
			return SearchList.staticSearchSearchUrl(siteRequest_, (String)o);
		case "defaultSort":
			return SearchList.staticSearchDefaultSort(siteRequest_, (Boolean)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		return staticSearchStrSearchList(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrSearchList(String entityVar, ComputateSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSearchStrStore(siteRequest_, (Boolean)o);
		case "populate":
			return SearchList.staticSearchStrPopulate(siteRequest_, (Boolean)o);
		case "searchUrl":
			return SearchList.staticSearchStrSearchUrl(siteRequest_, (String)o);
		case "defaultSort":
			return SearchList.staticSearchStrDefaultSort(siteRequest_, (Boolean)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		return staticSearchFqSearchList(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqSearchList(String entityVar, ComputateSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSearchFqStore(siteRequest_, o);
		case "populate":
			return SearchList.staticSearchFqPopulate(siteRequest_, o);
		case "searchUrl":
			return SearchList.staticSearchFqSearchUrl(siteRequest_, o);
		case "defaultSort":
			return SearchList.staticSearchFqDefaultSort(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "SearchList";
	public static final String VAR_c = "c";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_store = "store";
	public static final String VAR_populate = "populate";
	public static final String VAR_request = "request";
	public static final String VAR_searchUrl = "searchUrl";
	public static final String VAR_defaultSort = "defaultSort";
	public static final String VAR_response = "response";
	public static final String VAR_docs = "docs";
	public static final String VAR_list = "list";
	public static final String VAR_first = "first";

	public static final String DISPLAY_NAME_c = "";
	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_store = "";
	public static final String DISPLAY_NAME_populate = "";
	public static final String DISPLAY_NAME_request = "";
	public static final String DISPLAY_NAME_searchUrl = "";
	public static final String DISPLAY_NAME_defaultSort = "";
	public static final String DISPLAY_NAME_response = "";
	public static final String DISPLAY_NAME_docs = "";
	public static final String DISPLAY_NAME_list = "";
	public static final String DISPLAY_NAME_first = "";

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
		return SearchList.displayNameSearchList(var);
	}
	public static String displayNameSearchList(String var) {
		switch(var) {
		case VAR_c:
			return DISPLAY_NAME_c;
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_store:
			return DISPLAY_NAME_store;
		case VAR_populate:
			return DISPLAY_NAME_populate;
		case VAR_request:
			return DISPLAY_NAME_request;
		case VAR_searchUrl:
			return DISPLAY_NAME_searchUrl;
		case VAR_defaultSort:
			return DISPLAY_NAME_defaultSort;
		case VAR_response:
			return DISPLAY_NAME_response;
		case VAR_docs:
			return DISPLAY_NAME_docs;
		case VAR_list:
			return DISPLAY_NAME_list;
		case VAR_first:
			return DISPLAY_NAME_first;
		default:
			return null;
		}
	}

	public static String descriptionSearchList(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static String classSimpleNameSearchList(String var) {
		switch(var) {
		case VAR_c:
			return "Class";
		case VAR_siteRequest_:
			return "ComputateSiteRequest";
		case VAR_store:
			return "Boolean";
		case VAR_populate:
			return "Boolean";
		case VAR_request:
			return "SearchRequest";
		case VAR_searchUrl:
			return "String";
		case VAR_defaultSort:
			return "Boolean";
		case VAR_response:
			return "SolrResponse";
		case VAR_docs:
			return "List";
		case VAR_list:
			return "List";
		case VAR_first:
			return "Object";
			default:
				return null;
		}
	}

	public static Integer htmColumnSearchList(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmRowSearchList(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer htmCellSearchList(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMinSearchList(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer lengthMaxSearchList(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer maxSearchList(String var) {
		switch(var) {
			default:
				return null;
		}
	}

	public static Integer minSearchList(String var) {
		switch(var) {
			default:
				return null;
		}
	}
}
