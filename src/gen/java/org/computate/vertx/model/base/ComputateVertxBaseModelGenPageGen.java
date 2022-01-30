package org.computate.vertx.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.slf4j.LoggerFactory;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.lang.Integer;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import org.computate.vertx.page.ComputateVertxPageLayout;
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
import org.computate.vertx.search.list.SearchList;
import io.vertx.core.json.JsonArray;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModelGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ComputateVertxBaseModelGenPageGen<DEV> extends ComputateVertxPageLayout {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateVertxBaseModelGenPage.class);

	////////////////////////////////////////
	// searchListComputateVertxBaseModel_ //
	////////////////////////////////////////

	/**	 The entity searchListComputateVertxBaseModel_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ComputateVertxBaseModel> searchListComputateVertxBaseModel_;

	/**	<br> The entity searchListComputateVertxBaseModel_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListComputateVertxBaseModel_">Find the entity searchListComputateVertxBaseModel_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListComputateVertxBaseModel_(Wrap<SearchList<ComputateVertxBaseModel>> w);

	public SearchList<ComputateVertxBaseModel> getSearchListComputateVertxBaseModel_() {
		return searchListComputateVertxBaseModel_;
	}

	public void setSearchListComputateVertxBaseModel_(SearchList<ComputateVertxBaseModel> searchListComputateVertxBaseModel_) {
		this.searchListComputateVertxBaseModel_ = searchListComputateVertxBaseModel_;
	}
	public static SearchList<ComputateVertxBaseModel> staticSetSearchListComputateVertxBaseModel_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxBaseModelGenPage searchListComputateVertxBaseModel_Init() {
		Wrap<SearchList<ComputateVertxBaseModel>> searchListComputateVertxBaseModel_Wrap = new Wrap<SearchList<ComputateVertxBaseModel>>().var("searchListComputateVertxBaseModel_");
		if(searchListComputateVertxBaseModel_ == null) {
			_searchListComputateVertxBaseModel_(searchListComputateVertxBaseModel_Wrap);
			setSearchListComputateVertxBaseModel_(searchListComputateVertxBaseModel_Wrap.o);
		}
		return (ComputateVertxBaseModelGenPage)this;
	}

	/////////////////////////////////
	// listComputateVertxBaseModel //
	/////////////////////////////////

	/**	 The entity listComputateVertxBaseModel
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listComputateVertxBaseModel = new JsonArray();

	/**	<br> The entity listComputateVertxBaseModel
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listComputateVertxBaseModel">Find the entity listComputateVertxBaseModel in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listComputateVertxBaseModel(JsonArray l);

	public JsonArray getListComputateVertxBaseModel() {
		return listComputateVertxBaseModel;
	}

	public void setListComputateVertxBaseModel(JsonArray listComputateVertxBaseModel) {
		this.listComputateVertxBaseModel = listComputateVertxBaseModel;
	}
	public static JsonArray staticSetListComputateVertxBaseModel(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxBaseModelGenPage listComputateVertxBaseModelInit() {
		_listComputateVertxBaseModel(listComputateVertxBaseModel);
		return (ComputateVertxBaseModelGenPage)this;
	}

	//////////////////////////////////
	// computateVertxBaseModelCount //
	//////////////////////////////////

	/**	 The entity computateVertxBaseModelCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer computateVertxBaseModelCount;

	/**	<br> The entity computateVertxBaseModelCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:computateVertxBaseModelCount">Find the entity computateVertxBaseModelCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _computateVertxBaseModelCount(Wrap<Integer> w);

	public Integer getComputateVertxBaseModelCount() {
		return computateVertxBaseModelCount;
	}

	public void setComputateVertxBaseModelCount(Integer computateVertxBaseModelCount) {
		this.computateVertxBaseModelCount = computateVertxBaseModelCount;
	}
	@JsonIgnore
	public void setComputateVertxBaseModelCount(String o) {
		this.computateVertxBaseModelCount = ComputateVertxBaseModelGenPage.staticSetComputateVertxBaseModelCount(siteRequest_, o);
	}
	public static Integer staticSetComputateVertxBaseModelCount(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputateVertxBaseModelGenPage computateVertxBaseModelCountInit() {
		Wrap<Integer> computateVertxBaseModelCountWrap = new Wrap<Integer>().var("computateVertxBaseModelCount");
		if(computateVertxBaseModelCount == null) {
			_computateVertxBaseModelCount(computateVertxBaseModelCountWrap);
			setComputateVertxBaseModelCount(computateVertxBaseModelCountWrap.o);
		}
		return (ComputateVertxBaseModelGenPage)this;
	}

	public static Integer staticSolrComputateVertxBaseModelCount(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrComputateVertxBaseModelCount(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqComputateVertxBaseModelCount(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModelGenPage.staticSolrStrComputateVertxBaseModelCount(siteRequest_, ComputateVertxBaseModelGenPage.staticSolrComputateVertxBaseModelCount(siteRequest_, ComputateVertxBaseModelGenPage.staticSetComputateVertxBaseModelCount(siteRequest_, o)));
	}

	//////////////////////////////
	// computateVertxBaseModel_ //
	//////////////////////////////

	/**	 The entity computateVertxBaseModel_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateVertxBaseModel computateVertxBaseModel_;

	/**	<br> The entity computateVertxBaseModel_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:computateVertxBaseModel_">Find the entity computateVertxBaseModel_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _computateVertxBaseModel_(Wrap<ComputateVertxBaseModel> w);

	public ComputateVertxBaseModel getComputateVertxBaseModel_() {
		return computateVertxBaseModel_;
	}

	public void setComputateVertxBaseModel_(ComputateVertxBaseModel computateVertxBaseModel_) {
		this.computateVertxBaseModel_ = computateVertxBaseModel_;
	}
	public static ComputateVertxBaseModel staticSetComputateVertxBaseModel_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxBaseModelGenPage computateVertxBaseModel_Init() {
		Wrap<ComputateVertxBaseModel> computateVertxBaseModel_Wrap = new Wrap<ComputateVertxBaseModel>().var("computateVertxBaseModel_");
		if(computateVertxBaseModel_ == null) {
			_computateVertxBaseModel_(computateVertxBaseModel_Wrap);
			setComputateVertxBaseModel_(computateVertxBaseModel_Wrap.o);
		}
		return (ComputateVertxBaseModelGenPage)this;
	}

	////////
	// pk //
	////////

	/**	 The entity pk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long pk;

	/**	<br> The entity pk
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModelGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pk(Wrap<Long> w);

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}
	@JsonIgnore
	public void setPk(String o) {
		this.pk = ComputateVertxBaseModelGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxBaseModelGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ComputateVertxBaseModelGenPage)this;
	}

	public static Long staticSolrPk(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPk(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModelGenPage.staticSolrStrPk(siteRequest_, ComputateVertxBaseModelGenPage.staticSolrPk(siteRequest_, ComputateVertxBaseModelGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepComputateVertxBaseModelGenPage(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepComputateVertxBaseModelGenPage();
	}

	public Future<Void> promiseDeepComputateVertxBaseModelGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseComputateVertxBaseModelGenPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepComputateVertxPageLayout(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputateVertxBaseModelGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListComputateVertxBaseModel_Init();
				listComputateVertxBaseModelInit();
				computateVertxBaseModelCountInit();
				computateVertxBaseModel_Init();
				pkInit();
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

	@Override public Future<Void> promiseDeepForClass(ComputateVertxSiteRequest siteRequest_) {
		return promiseDeepComputateVertxBaseModelGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateVertxBaseModelGenPage(ComputateVertxSiteRequest siteRequest_) {
			super.siteRequestComputateVertxPageLayout(siteRequest_);
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
		siteRequestComputateVertxBaseModelGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateVertxBaseModelGenPage(v);
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
	public Object obtainComputateVertxBaseModelGenPage(String var) {
		ComputateVertxBaseModelGenPage oComputateVertxBaseModelGenPage = (ComputateVertxBaseModelGenPage)this;
		switch(var) {
			case "searchListComputateVertxBaseModel_":
				return oComputateVertxBaseModelGenPage.searchListComputateVertxBaseModel_;
			case "listComputateVertxBaseModel":
				return oComputateVertxBaseModelGenPage.listComputateVertxBaseModel;
			case "computateVertxBaseModelCount":
				return oComputateVertxBaseModelGenPage.computateVertxBaseModelCount;
			case "computateVertxBaseModel_":
				return oComputateVertxBaseModelGenPage.computateVertxBaseModel_;
			case "pk":
				return oComputateVertxBaseModelGenPage.pk;
			default:
				return super.obtainComputateVertxPageLayout(var);
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
				o = relateComputateVertxBaseModelGenPage(v, val);
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateComputateVertxBaseModelGenPage(String var, Object val) {
		ComputateVertxBaseModelGenPage oComputateVertxBaseModelGenPage = (ComputateVertxBaseModelGenPage)this;
		switch(var) {
			default:
				return super.relateComputateVertxPageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetComputateVertxBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateVertxBaseModelGenPage(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "computateVertxBaseModelCount":
			return ComputateVertxBaseModelGenPage.staticSetComputateVertxBaseModelCount(siteRequest_, o);
		case "pk":
			return ComputateVertxBaseModelGenPage.staticSetPk(siteRequest_, o);
			default:
				return ComputateVertxPageLayout.staticSetComputateVertxPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrComputateVertxBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrComputateVertxBaseModelGenPage(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "computateVertxBaseModelCount":
			return ComputateVertxBaseModelGenPage.staticSolrComputateVertxBaseModelCount(siteRequest_, (Integer)o);
		case "pk":
			return ComputateVertxBaseModelGenPage.staticSolrPk(siteRequest_, (Long)o);
			default:
				return ComputateVertxPageLayout.staticSolrComputateVertxPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrStrComputateVertxBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrComputateVertxBaseModelGenPage(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "computateVertxBaseModelCount":
			return ComputateVertxBaseModelGenPage.staticSolrStrComputateVertxBaseModelCount(siteRequest_, (Integer)o);
		case "pk":
			return ComputateVertxBaseModelGenPage.staticSolrStrPk(siteRequest_, (Long)o);
			default:
				return ComputateVertxPageLayout.staticSolrStrComputateVertxPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSolrFqComputateVertxBaseModelGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqComputateVertxBaseModelGenPage(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "computateVertxBaseModelCount":
			return ComputateVertxBaseModelGenPage.staticSolrFqComputateVertxBaseModelCount(siteRequest_, o);
		case "pk":
			return ComputateVertxBaseModelGenPage.staticSolrFqPk(siteRequest_, o);
			default:
				return ComputateVertxPageLayout.staticSolrFqComputateVertxPageLayout(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineComputateVertxBaseModelGenPage(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineComputateVertxBaseModelGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineComputateVertxPageLayout(var, val);
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

	public static final String VAR_searchListComputateVertxBaseModel_ = "searchListComputateVertxBaseModel_";
	public static final String VAR_listComputateVertxBaseModel = "listComputateVertxBaseModel";
	public static final String VAR_computateVertxBaseModelCount = "computateVertxBaseModelCount";
	public static final String VAR_computateVertxBaseModel_ = "computateVertxBaseModel_";
	public static final String VAR_pk = "pk";

	public static final String DISPLAY_NAME_searchListComputateVertxBaseModel_ = "";
	public static final String DISPLAY_NAME_listComputateVertxBaseModel = "";
	public static final String DISPLAY_NAME_computateVertxBaseModelCount = "";
	public static final String DISPLAY_NAME_computateVertxBaseModel_ = "";
	public static final String DISPLAY_NAME_pk = "";

	public static String displayNameForClass(String var) {
		return ComputateVertxBaseModelGenPage.displayNameComputateVertxBaseModelGenPage(var);
	}
	public static String displayNameComputateVertxBaseModelGenPage(String var) {
		switch(var) {
		case VAR_searchListComputateVertxBaseModel_:
			return DISPLAY_NAME_searchListComputateVertxBaseModel_;
		case VAR_listComputateVertxBaseModel:
			return DISPLAY_NAME_listComputateVertxBaseModel;
		case VAR_computateVertxBaseModelCount:
			return DISPLAY_NAME_computateVertxBaseModelCount;
		case VAR_computateVertxBaseModel_:
			return DISPLAY_NAME_computateVertxBaseModel_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		default:
			return ComputateVertxPageLayout.displayNameComputateVertxPageLayout(var);
		}
	}
}
