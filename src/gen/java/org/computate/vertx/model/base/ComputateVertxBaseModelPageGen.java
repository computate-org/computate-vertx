package org.computate.vertx.model.base;

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
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import org.computate.vertx.model.base.ComputateVertxBaseModelGenPage;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModelPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ComputateVertxBaseModelPageGen<DEV> extends ComputateVertxBaseModelGenPage {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateVertxBaseModelPage.class);

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepComputateVertxBaseModelPage(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepComputateVertxBaseModelPage();
	}

	public Future<Void> promiseDeepComputateVertxBaseModelPage() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseComputateVertxBaseModelPage(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepComputateVertxBaseModelGenPage(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputateVertxBaseModelPage(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
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
		return promiseDeepComputateVertxBaseModelPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateVertxBaseModelPage(ComputateVertxSiteRequest siteRequest_) {
			super.siteRequestComputateVertxBaseModelGenPage(siteRequest_);
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
		siteRequestComputateVertxBaseModelPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateVertxBaseModelPage(v);
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
	public Object obtainComputateVertxBaseModelPage(String var) {
		ComputateVertxBaseModelPage oComputateVertxBaseModelPage = (ComputateVertxBaseModelPage)this;
		switch(var) {
			default:
				return super.obtainComputateVertxBaseModelGenPage(var);
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
				o = relateComputateVertxBaseModelPage(v, val);
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateComputateVertxBaseModelPage(String var, Object val) {
		ComputateVertxBaseModelPage oComputateVertxBaseModelPage = (ComputateVertxBaseModelPage)this;
		switch(var) {
			default:
				return super.relateComputateVertxBaseModelGenPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetComputateVertxBaseModelPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateVertxBaseModelPage(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
			default:
				return ComputateVertxBaseModelGenPage.staticSetComputateVertxBaseModelGenPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrComputateVertxBaseModelPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrComputateVertxBaseModelPage(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return ComputateVertxBaseModelGenPage.staticSolrComputateVertxBaseModelGenPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrStrComputateVertxBaseModelPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrComputateVertxBaseModelPage(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return ComputateVertxBaseModelGenPage.staticSolrStrComputateVertxBaseModelGenPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSolrFqComputateVertxBaseModelPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqComputateVertxBaseModelPage(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
			default:
				return ComputateVertxBaseModelGenPage.staticSolrFqComputateVertxBaseModelGenPage(entityVar,  siteRequest_, o);
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
					o = defineComputateVertxBaseModelPage(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineComputateVertxBaseModelPage(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineComputateVertxBaseModelGenPage(var, val);
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



	public static String displayNameForClass(String var) {
		return ComputateVertxBaseModelPage.displayNameComputateVertxBaseModelPage(var);
	}
	public static String displayNameComputateVertxBaseModelPage(String var) {
		switch(var) {
		default:
			return ComputateVertxBaseModelGenPage.displayNameComputateVertxBaseModelGenPage(var);
		}
	}
}
