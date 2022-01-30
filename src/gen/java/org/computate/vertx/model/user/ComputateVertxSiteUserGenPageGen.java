package org.computate.vertx.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.computate.vertx.model.user.ComputateVertxSiteUser;
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
import org.computate.vertx.model.base.ComputateVertxBaseModelPage;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUserGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ComputateVertxSiteUserGenPageGen<DEV> extends ComputateVertxBaseModelPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateVertxSiteUserGenPage.class);

	///////////////////////////////////////
	// searchListComputateVertxSiteUser_ //
	///////////////////////////////////////

	/**	 The entity searchListComputateVertxSiteUser_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<ComputateVertxSiteUser> searchListComputateVertxSiteUser_;

	/**	<br> The entity searchListComputateVertxSiteUser_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:searchListComputateVertxSiteUser_">Find the entity searchListComputateVertxSiteUser_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _searchListComputateVertxSiteUser_(Wrap<SearchList<ComputateVertxSiteUser>> w);

	public SearchList<ComputateVertxSiteUser> getSearchListComputateVertxSiteUser_() {
		return searchListComputateVertxSiteUser_;
	}

	public void setSearchListComputateVertxSiteUser_(SearchList<ComputateVertxSiteUser> searchListComputateVertxSiteUser_) {
		this.searchListComputateVertxSiteUser_ = searchListComputateVertxSiteUser_;
	}
	public static SearchList<ComputateVertxSiteUser> staticSetSearchListComputateVertxSiteUser_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteUserGenPage searchListComputateVertxSiteUser_Init() {
		Wrap<SearchList<ComputateVertxSiteUser>> searchListComputateVertxSiteUser_Wrap = new Wrap<SearchList<ComputateVertxSiteUser>>().var("searchListComputateVertxSiteUser_");
		if(searchListComputateVertxSiteUser_ == null) {
			_searchListComputateVertxSiteUser_(searchListComputateVertxSiteUser_Wrap);
			setSearchListComputateVertxSiteUser_(searchListComputateVertxSiteUser_Wrap.o);
		}
		return (ComputateVertxSiteUserGenPage)this;
	}

	////////////////////////////////
	// listComputateVertxSiteUser //
	////////////////////////////////

	/**	 The entity listComputateVertxSiteUser
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected JsonArray listComputateVertxSiteUser = new JsonArray();

	/**	<br> The entity listComputateVertxSiteUser
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listComputateVertxSiteUser">Find the entity listComputateVertxSiteUser in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _listComputateVertxSiteUser(JsonArray l);

	public JsonArray getListComputateVertxSiteUser() {
		return listComputateVertxSiteUser;
	}

	public void setListComputateVertxSiteUser(JsonArray listComputateVertxSiteUser) {
		this.listComputateVertxSiteUser = listComputateVertxSiteUser;
	}
	public static JsonArray staticSetListComputateVertxSiteUser(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteUserGenPage listComputateVertxSiteUserInit() {
		_listComputateVertxSiteUser(listComputateVertxSiteUser);
		return (ComputateVertxSiteUserGenPage)this;
	}

	/////////////////////////////////
	// computateVertxSiteUserCount //
	/////////////////////////////////

	/**	 The entity computateVertxSiteUserCount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Integer computateVertxSiteUserCount;

	/**	<br> The entity computateVertxSiteUserCount
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:computateVertxSiteUserCount">Find the entity computateVertxSiteUserCount in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _computateVertxSiteUserCount(Wrap<Integer> w);

	public Integer getComputateVertxSiteUserCount() {
		return computateVertxSiteUserCount;
	}

	public void setComputateVertxSiteUserCount(Integer computateVertxSiteUserCount) {
		this.computateVertxSiteUserCount = computateVertxSiteUserCount;
	}
	@JsonIgnore
	public void setComputateVertxSiteUserCount(String o) {
		this.computateVertxSiteUserCount = ComputateVertxSiteUserGenPage.staticSetComputateVertxSiteUserCount(siteRequest_, o);
	}
	public static Integer staticSetComputateVertxSiteUserCount(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Integer.parseInt(o);
		return null;
	}
	protected ComputateVertxSiteUserGenPage computateVertxSiteUserCountInit() {
		Wrap<Integer> computateVertxSiteUserCountWrap = new Wrap<Integer>().var("computateVertxSiteUserCount");
		if(computateVertxSiteUserCount == null) {
			_computateVertxSiteUserCount(computateVertxSiteUserCountWrap);
			setComputateVertxSiteUserCount(computateVertxSiteUserCountWrap.o);
		}
		return (ComputateVertxSiteUserGenPage)this;
	}

	public static Integer staticSolrComputateVertxSiteUserCount(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o;
	}

	public static String staticSolrStrComputateVertxSiteUserCount(ComputateVertxSiteRequest siteRequest_, Integer o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqComputateVertxSiteUserCount(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUserGenPage.staticSolrStrComputateVertxSiteUserCount(siteRequest_, ComputateVertxSiteUserGenPage.staticSolrComputateVertxSiteUserCount(siteRequest_, ComputateVertxSiteUserGenPage.staticSetComputateVertxSiteUserCount(siteRequest_, o)));
	}

	/////////////////////////////
	// computateVertxSiteUser_ //
	/////////////////////////////

	/**	 The entity computateVertxSiteUser_
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected ComputateVertxSiteUser computateVertxSiteUser_;

	/**	<br> The entity computateVertxSiteUser_
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:computateVertxSiteUser_">Find the entity computateVertxSiteUser_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _computateVertxSiteUser_(Wrap<ComputateVertxSiteUser> w);

	public ComputateVertxSiteUser getComputateVertxSiteUser_() {
		return computateVertxSiteUser_;
	}

	public void setComputateVertxSiteUser_(ComputateVertxSiteUser computateVertxSiteUser_) {
		this.computateVertxSiteUser_ = computateVertxSiteUser_;
	}
	public static ComputateVertxSiteUser staticSetComputateVertxSiteUser_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxSiteUserGenPage computateVertxSiteUser_Init() {
		Wrap<ComputateVertxSiteUser> computateVertxSiteUser_Wrap = new Wrap<ComputateVertxSiteUser>().var("computateVertxSiteUser_");
		if(computateVertxSiteUser_ == null) {
			_computateVertxSiteUser_(computateVertxSiteUser_Wrap);
			setComputateVertxSiteUser_(computateVertxSiteUser_Wrap.o);
		}
		return (ComputateVertxSiteUserGenPage)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUserGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = ComputateVertxSiteUserGenPage.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxSiteUserGenPage pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ComputateVertxSiteUserGenPage)this;
	}

	public static Long staticSolrPk(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPk(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUserGenPage.staticSolrStrPk(siteRequest_, ComputateVertxSiteUserGenPage.staticSolrPk(siteRequest_, ComputateVertxSiteUserGenPage.staticSetPk(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepComputateVertxSiteUserGenPage(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepComputateVertxSiteUserGenPage();
	}

	public Future<Void> promiseDeepComputateVertxSiteUserGenPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseComputateVertxSiteUserGenPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepComputateVertxBaseModelPage(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputateVertxSiteUserGenPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				searchListComputateVertxSiteUser_Init();
				listComputateVertxSiteUserInit();
				computateVertxSiteUserCountInit();
				computateVertxSiteUser_Init();
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
		return promiseDeepComputateVertxSiteUserGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateVertxSiteUserGenPage(ComputateVertxSiteRequest siteRequest_) {
			super.siteRequestComputateVertxBaseModelPage(siteRequest_);
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
		siteRequestComputateVertxSiteUserGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateVertxSiteUserGenPage(v);
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
	public Object obtainComputateVertxSiteUserGenPage(String var) {
		ComputateVertxSiteUserGenPage oComputateVertxSiteUserGenPage = (ComputateVertxSiteUserGenPage)this;
		switch(var) {
			case "searchListComputateVertxSiteUser_":
				return oComputateVertxSiteUserGenPage.searchListComputateVertxSiteUser_;
			case "listComputateVertxSiteUser":
				return oComputateVertxSiteUserGenPage.listComputateVertxSiteUser;
			case "computateVertxSiteUserCount":
				return oComputateVertxSiteUserGenPage.computateVertxSiteUserCount;
			case "computateVertxSiteUser_":
				return oComputateVertxSiteUserGenPage.computateVertxSiteUser_;
			case "pk":
				return oComputateVertxSiteUserGenPage.pk;
			default:
				return super.obtainComputateVertxBaseModelPage(var);
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
				o = relateComputateVertxSiteUserGenPage(v, val);
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateComputateVertxSiteUserGenPage(String var, Object val) {
		ComputateVertxSiteUserGenPage oComputateVertxSiteUserGenPage = (ComputateVertxSiteUserGenPage)this;
		switch(var) {
			default:
				return super.relateComputateVertxBaseModelPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetComputateVertxSiteUserGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateVertxSiteUserGenPage(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "computateVertxSiteUserCount":
			return ComputateVertxSiteUserGenPage.staticSetComputateVertxSiteUserCount(siteRequest_, o);
		case "pk":
			return ComputateVertxSiteUserGenPage.staticSetPk(siteRequest_, o);
			default:
				return ComputateVertxBaseModelPage.staticSetComputateVertxBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrComputateVertxSiteUserGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrComputateVertxSiteUserGenPage(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "computateVertxSiteUserCount":
			return ComputateVertxSiteUserGenPage.staticSolrComputateVertxSiteUserCount(siteRequest_, (Integer)o);
		case "pk":
			return ComputateVertxSiteUserGenPage.staticSolrPk(siteRequest_, (Long)o);
			default:
				return ComputateVertxBaseModelPage.staticSolrComputateVertxBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrStrComputateVertxSiteUserGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrComputateVertxSiteUserGenPage(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "computateVertxSiteUserCount":
			return ComputateVertxSiteUserGenPage.staticSolrStrComputateVertxSiteUserCount(siteRequest_, (Integer)o);
		case "pk":
			return ComputateVertxSiteUserGenPage.staticSolrStrPk(siteRequest_, (Long)o);
			default:
				return ComputateVertxBaseModelPage.staticSolrStrComputateVertxBaseModelPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSolrFqComputateVertxSiteUserGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqComputateVertxSiteUserGenPage(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "computateVertxSiteUserCount":
			return ComputateVertxSiteUserGenPage.staticSolrFqComputateVertxSiteUserCount(siteRequest_, o);
		case "pk":
			return ComputateVertxSiteUserGenPage.staticSolrFqPk(siteRequest_, o);
			default:
				return ComputateVertxBaseModelPage.staticSolrFqComputateVertxBaseModelPage(entityVar,  siteRequest_, o);
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
					o = defineComputateVertxSiteUserGenPage(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineComputateVertxSiteUserGenPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineComputateVertxBaseModelPage(var, val);
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

	public static final String VAR_searchListComputateVertxSiteUser_ = "searchListComputateVertxSiteUser_";
	public static final String VAR_listComputateVertxSiteUser = "listComputateVertxSiteUser";
	public static final String VAR_computateVertxSiteUserCount = "computateVertxSiteUserCount";
	public static final String VAR_computateVertxSiteUser_ = "computateVertxSiteUser_";
	public static final String VAR_pk = "pk";

	public static final String DISPLAY_NAME_searchListComputateVertxSiteUser_ = "";
	public static final String DISPLAY_NAME_listComputateVertxSiteUser = "";
	public static final String DISPLAY_NAME_computateVertxSiteUserCount = "";
	public static final String DISPLAY_NAME_computateVertxSiteUser_ = "";
	public static final String DISPLAY_NAME_pk = "";

	public static String displayNameForClass(String var) {
		return ComputateVertxSiteUserGenPage.displayNameComputateVertxSiteUserGenPage(var);
	}
	public static String displayNameComputateVertxSiteUserGenPage(String var) {
		switch(var) {
		case VAR_searchListComputateVertxSiteUser_:
			return DISPLAY_NAME_searchListComputateVertxSiteUser_;
		case VAR_listComputateVertxSiteUser:
			return DISPLAY_NAME_listComputateVertxSiteUser;
		case VAR_computateVertxSiteUserCount:
			return DISPLAY_NAME_computateVertxSiteUserCount;
		case VAR_computateVertxSiteUser_:
			return DISPLAY_NAME_computateVertxSiteUser_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		default:
			return ComputateVertxBaseModelPage.displayNameComputateVertxBaseModelPage(var);
		}
	}
}
