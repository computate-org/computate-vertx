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
import java.lang.Class;
import java.lang.Boolean;
import org.computate.search.request.SearchRequest;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.response.solr.SolrResponse.Doc;
import java.lang.Object;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList">Find the class SearchList in Solr. </a>
 * <br><br>Delete the class SearchList in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the package org.computate.vertx.search.list in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.search.list&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the project computate-vertx in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:c">Find the entity c in Solr</a>
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
	public static Class<?> staticSetC(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected SearchList cInit() {
		Wrap<Class<?>> cWrap = new Wrap<Class<?>>().var("c");
		if(c == null) {
			_c(cWrap);
			setC(cWrap.o);
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
	protected ComputateVertxSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<ComputateVertxSiteRequest> c);

	public ComputateVertxSiteRequest getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(ComputateVertxSiteRequest siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static ComputateVertxSiteRequest staticSetSiteRequest_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected SearchList siteRequest_Init() {
		Wrap<ComputateVertxSiteRequest> siteRequest_Wrap = new Wrap<ComputateVertxSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:store">Find the entity store in Solr</a>
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
	public static Boolean staticSetStore(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SearchList storeInit() {
		Wrap<Boolean> storeWrap = new Wrap<Boolean>().var("store");
		if(store == null) {
			_store(storeWrap);
			setStore(storeWrap.o);
		}
		return (SearchList)this;
	}

	public static Boolean staticSearchStore(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrStore(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqStore(ComputateVertxSiteRequest siteRequest_, String o) {
		return SearchList.staticSearchStrStore(siteRequest_, SearchList.staticSearchStore(siteRequest_, SearchList.staticSetStore(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:populate">Find the entity populate in Solr</a>
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
	public static Boolean staticSetPopulate(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SearchList populateInit() {
		Wrap<Boolean> populateWrap = new Wrap<Boolean>().var("populate");
		if(populate == null) {
			_populate(populateWrap);
			setPopulate(populateWrap.o);
		}
		return (SearchList)this;
	}

	public static Boolean staticSearchPopulate(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSearchStrPopulate(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqPopulate(ComputateVertxSiteRequest siteRequest_, String o) {
		return SearchList.staticSearchStrPopulate(siteRequest_, SearchList.staticSearchPopulate(siteRequest_, SearchList.staticSetPopulate(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:request">Find the entity request in Solr</a>
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
	public static SearchRequest staticSetRequest(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected SearchList requestInit() {
		_request(request);
		request.initDeepForClass(siteRequest_);
		return (SearchList)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:response">Find the entity response in Solr</a>
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
	public static SolrResponse staticSetResponse(ComputateVertxSiteRequest siteRequest_, String o) {
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:docs">Find the entity docs in Solr</a>
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
	public static Doc staticSetDocs(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	public SearchList addDocs(Doc...objets) {
		for(Doc o : objets) {
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
			setDocs(docsWrap.o);
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:list">Find the entity list in Solr</a>
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
	public SearchList addList(DEV...objets) {
		for(DEV o : objets) {
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchList&fq=entiteVar_enUS_indexed_string:first">Find the entity first in Solr</a>
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
	public static Object staticSetFirst(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected SearchList firstInit() {
		Wrap<Object> firstWrap = new Wrap<Object>().var("first");
		if(first == null) {
			_first(firstWrap);
			setFirst(firstWrap.o);
		}
		return (SearchList)this;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepSearchList(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepSearchList();
	}

	public Future<Void> promiseDeepSearchList() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSearchList(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
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

	public Future<Void> promiseDeepForClass(ComputateVertxSiteRequest siteRequest_) {
		return promiseDeepSearchList(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSearchList(ComputateVertxSiteRequest siteRequest_) {
		if(request != null)
			request.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
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

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetSearchList(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSearchList(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSetStore(siteRequest_, o);
		case "populate":
			return SearchList.staticSetPopulate(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchSearchList(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchSearchList(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSearchStore(siteRequest_, (Boolean)o);
		case "populate":
			return SearchList.staticSearchPopulate(siteRequest_, (Boolean)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchStrSearchList(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrSearchList(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSearchStrStore(siteRequest_, (Boolean)o);
		case "populate":
			return SearchList.staticSearchStrPopulate(siteRequest_, (Boolean)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSearchFqSearchList(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqSearchList(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "store":
			return SearchList.staticSearchFqStore(siteRequest_, o);
		case "populate":
			return SearchList.staticSearchFqPopulate(siteRequest_, o);
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
	public static final String VAR_response = "response";
	public static final String VAR_docs = "docs";
	public static final String VAR_list = "list";
	public static final String VAR_first = "first";

	public static final String DISPLAY_NAME_c = "";
	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_store = "";
	public static final String DISPLAY_NAME_populate = "";
	public static final String DISPLAY_NAME_request = "";
	public static final String DISPLAY_NAME_response = "";
	public static final String DISPLAY_NAME_docs = "";
	public static final String DISPLAY_NAME_list = "";
	public static final String DISPLAY_NAME_first = "";

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
}
