package org.computate.vertx.search.list;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import java.math.RoundingMode;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
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
	@JsonInclude(Include.NON_NULL)
	protected JsonObject solrDocument;

	/**	<br> The entity solrDocument
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:solrDocument">Find the entity solrDocument in Solr</a>
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
	public static JsonObject staticSetSolrDocument(ComputateVertxSiteRequest siteRequest_, String o) {
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.search.list.SearchResult&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:resultIndex">Find the entity resultIndex in Solr</a>
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

	public static Long staticSolrResultIndex(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrResultIndex(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqResultIndex(ComputateVertxSiteRequest siteRequest_, String o) {
		return SearchResult.staticSolrStrResultIndex(siteRequest_, SearchResult.staticSolrResultIndex(siteRequest_, SearchResult.staticSetResultIndex(siteRequest_, o)));
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
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.obtainForClass(v);
			}
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
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
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
		case "resultIndex":
			return SearchResult.staticSetResultIndex(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrSearchResult(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSearchResult(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "resultIndex":
			return SearchResult.staticSolrResultIndex(siteRequest_, (Long)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrStrSearchResult(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSearchResult(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "resultIndex":
			return SearchResult.staticSolrStrResultIndex(siteRequest_, (Long)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSolrFqSearchResult(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSearchResult(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "resultIndex":
			return SearchResult.staticSolrFqResultIndex(siteRequest_, o);
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineSearchResult(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSearchResult(String var, Object val) {
		switch(var.toLowerCase()) {
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
