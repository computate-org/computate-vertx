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
import java.lang.Object;
import io.vertx.core.json.JsonObject;
import java.lang.Long;
import java.lang.String;
import org.computate.search.wrap.Wrap;
import io.vertx.core.Promise;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult">Find the class SearchResult in Solr. </a>
 * <br><br>Delete the class SearchResult in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the package org.computate.vertx.search.list in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;classeNomEnsemble_enUS_indexed_string:org.computate.vertx.search.list&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>Delete  the project computate-vertx in Solr. 
 * <br><pre>curl 'http://localhost:8983/solr/computate/update?commitWithin=1000&overwrite=true&wt=json' -X POST -H 'Content-type: text/xml' --data-raw '&lt;add&gt;&lt;delete&gt;&lt;query&gt;siteNom_indexed_string:computate\-vertx&lt;/query&gt;&lt;/delete&gt;&lt;/add&gt;'</pre>
 * <br>
 **/
public abstract class SearchResultGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(SearchResult.class);

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateVertxSiteRequest siteRequest_;

	/**	<br> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
	protected SearchResult siteRequest_Init() {
		Wrap<ComputateVertxSiteRequest> siteRequest_Wrap = new Wrap<ComputateVertxSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (SearchResult)this;
	}

	//////////////////
	// solrDocument //
	//////////////////

	/**	 The entity solrDocument
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected JsonObject solrDocument;

	/**	<br> The entity solrDocument
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult&fq=entiteVar_enUS_indexed_string:solrDocument">Find the entity solrDocument in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _solrDocument(Wrap<JsonObject> c);

	public JsonObject getSolrDocument() {
		return solrDocument;
	}

	public void setSolrDocument(JsonObject solrDocument) {
		this.solrDocument = solrDocument;
	}
	@JsonIgnore
	public void setSolrDocument(String o) {
		this.solrDocument = SearchResult.staticSetSolrDocument(siteRequest_, o);
	}
	public static JsonObject staticSetSolrDocument(ComputateVertxSiteRequest siteRequest_, String o) {
		if(o != null) {
				return new JsonObject(o);
		}
		return null;
	}
	protected SearchResult solrDocumentInit() {
		Wrap<JsonObject> solrDocumentWrap = new Wrap<JsonObject>().var("solrDocument");
		if(solrDocument == null) {
			_solrDocument(solrDocumentWrap);
			setSolrDocument(solrDocumentWrap.o);
		}
		return (SearchResult)this;
	}

	public static JsonObject staticSearchSolrDocument(ComputateVertxSiteRequest siteRequest_, JsonObject o) {
		return o;
	}

	public static String staticSearchStrSolrDocument(ComputateVertxSiteRequest siteRequest_, JsonObject o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqSolrDocument(ComputateVertxSiteRequest siteRequest_, String o) {
		return SearchResult.staticSearchStrSolrDocument(siteRequest_, SearchResult.staticSearchSolrDocument(siteRequest_, SearchResult.staticSetSolrDocument(siteRequest_, o)));
	}

	/////////////////
	// resultIndex //
	/////////////////

	/**	 The entity resultIndex
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long resultIndex;

	/**	<br> The entity resultIndex
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult&fq=entiteVar_enUS_indexed_string:resultIndex">Find the entity resultIndex in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _resultIndex(Wrap<Long> c);

	public Long getResultIndex() {
		return resultIndex;
	}

	public void setResultIndex(Long resultIndex) {
		this.resultIndex = resultIndex;
	}
	@JsonIgnore
	public void setResultIndex(String o) {
		this.resultIndex = SearchResult.staticSetResultIndex(siteRequest_, o);
	}
	public static Long staticSetResultIndex(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected SearchResult resultIndexInit() {
		Wrap<Long> resultIndexWrap = new Wrap<Long>().var("resultIndex");
		if(resultIndex == null) {
			_resultIndex(resultIndexWrap);
			setResultIndex(resultIndexWrap.o);
		}
		return (SearchResult)this;
	}

	public static Long staticSearchResultIndex(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSearchStrResultIndex(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSearchFqResultIndex(ComputateVertxSiteRequest siteRequest_, String o) {
		return SearchResult.staticSearchStrResultIndex(siteRequest_, SearchResult.staticSearchResultIndex(siteRequest_, SearchResult.staticSetResultIndex(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public SearchResult initDeepSearchResult(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		initDeepSearchResult();
		return (SearchResult)this;
	}

	public void initDeepSearchResult() {
		initSearchResult();
	}

	public void initSearchResult() {
				siteRequest_Init();
				solrDocumentInit();
				resultIndexInit();
	}

	public void initDeepForClass(ComputateVertxSiteRequest siteRequest_) {
		initDeepSearchResult(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSearchResult(ComputateVertxSiteRequest siteRequest_) {
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
		siteRequestSearchResult(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSearchResult(v);
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainSearchResult(String var) {
		SearchResult oSearchResult = (SearchResult)this;
		switch(var) {
			case "siteRequest_":
				return oSearchResult.siteRequest_;
			case "solrDocument":
				return oSearchResult.solrDocument;
			case "resultIndex":
				return oSearchResult.resultIndex;
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
				o = relateSearchResult(v, val);
		}
		return o != null;
	}
	public Object relateSearchResult(String var, Object val) {
		SearchResult oSearchResult = (SearchResult)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetSearchResult(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSearchResult(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "solrDocument":
			return SearchResult.staticSetSolrDocument(siteRequest_, o);
		case "resultIndex":
			return SearchResult.staticSetResultIndex(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSearch //
	////////////////

	public static Object staticSearchForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchSearchResult(entityVar,  siteRequest_, o);
	}
	public static Object staticSearchSearchResult(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "solrDocument":
			return SearchResult.staticSearchSolrDocument(siteRequest_, (JsonObject)o);
		case "resultIndex":
			return SearchResult.staticSearchResultIndex(siteRequest_, (Long)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSearchStr //
	///////////////////

	public static String staticSearchStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSearchStrSearchResult(entityVar,  siteRequest_, o);
	}
	public static String staticSearchStrSearchResult(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "solrDocument":
			return SearchResult.staticSearchStrSolrDocument(siteRequest_, (JsonObject)o);
		case "resultIndex":
			return SearchResult.staticSearchStrResultIndex(siteRequest_, (Long)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSearchFq //
	//////////////////

	public static String staticSearchFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSearchFqSearchResult(entityVar,  siteRequest_, o);
	}
	public static String staticSearchFqSearchResult(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "solrDocument":
			return SearchResult.staticSearchFqSolrDocument(siteRequest_, o);
		case "resultIndex":
			return SearchResult.staticSearchFqResultIndex(siteRequest_, o);
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

	public static final String CLASS_SIMPLE_NAME = "SearchResult";
	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_solrDocument = "solrDocument";
	public static final String VAR_resultIndex = "resultIndex";

	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_solrDocument = "";
	public static final String DISPLAY_NAME_resultIndex = "";

	public static String displayNameForClass(String var) {
		return SearchResult.displayNameSearchResult(var);
	}
	public static String displayNameSearchResult(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_solrDocument:
			return DISPLAY_NAME_solrDocument;
		case VAR_resultIndex:
			return DISPLAY_NAME_resultIndex;
		default:
			return null;
		}
	}
}
