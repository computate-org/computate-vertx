package org.computate.vertx.model.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;
import java.time.ZonedDateTime;
import org.slf4j.LoggerFactory;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.response.solr.SolrResponse;
import java.lang.Long;
import java.util.Locale;
import java.util.Map;
import io.vertx.core.json.JsonObject;
import java.time.ZoneOffset;
import java.math.RoundingMode;
import java.math.MathContext;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import java.time.ZoneId;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import java.util.List;
import java.time.OffsetDateTime;
import org.computate.search.wrap.Wrap;
import java.util.Optional;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.exception.ExceptionUtils;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import java.lang.String;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import org.slf4j.Logger;
import io.vertx.core.Promise;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.vertx.core.json.JsonArray;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.math.NumberUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ComputateVertxBaseModelGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateVertxBaseModel.class);


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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<ComputateVertxSiteRequest> w);

	public ComputateVertxSiteRequest getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(ComputateVertxSiteRequest siteRequest_) {
		this.siteRequest_ = siteRequest_;
	}
	public static ComputateVertxSiteRequest staticSetSiteRequest_(ComputateVertxSiteRequest siteRequest_, String o) {
		return null;
	}
	protected ComputateVertxBaseModel siteRequest_Init() {
		Wrap<ComputateVertxSiteRequest> siteRequest_Wrap = new Wrap<ComputateVertxSiteRequest>().var("siteRequest_");
		if(siteRequest_ == null) {
			_siteRequest_(siteRequest_Wrap);
			setSiteRequest_(siteRequest_Wrap.o);
		}
		return (ComputateVertxBaseModel)this;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
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
		this.pk = ComputateVertxBaseModel.staticSetPk(siteRequest_, o);
	}
	public static Long staticSetPk(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxBaseModel pkInit() {
		Wrap<Long> pkWrap = new Wrap<Long>().var("pk");
		if(pk == null) {
			_pk(pkWrap);
			setPk(pkWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static Long staticSolrPk(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPk(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrPk(siteRequest_, ComputateVertxBaseModel.staticSolrPk(siteRequest_, ComputateVertxBaseModel.staticSetPk(siteRequest_, o)));
	}

	///////////////
	// inheritPk //
	///////////////

	/**	 The entity inheritPk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String inheritPk;

	/**	<br> The entity inheritPk
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:inheritPk">Find the entity inheritPk in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _inheritPk(Wrap<String> w);

	public String getInheritPk() {
		return inheritPk;
	}
	public void setInheritPk(String o) {
		this.inheritPk = ComputateVertxBaseModel.staticSetInheritPk(siteRequest_, o);
	}
	public static String staticSetInheritPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel inheritPkInit() {
		Wrap<String> inheritPkWrap = new Wrap<String>().var("inheritPk");
		if(inheritPk == null) {
			_inheritPk(inheritPkWrap);
			setInheritPk(inheritPkWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrInheritPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrInheritPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInheritPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrInheritPk(siteRequest_, ComputateVertxBaseModel.staticSolrInheritPk(siteRequest_, ComputateVertxBaseModel.staticSetInheritPk(siteRequest_, o)));
	}

	public String sqlInheritPk() {
		return inheritPk;
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = ComputateVertxBaseModel.staticSetId(siteRequest_, o);
	}
	public static String staticSetId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel idInit() {
		Wrap<String> idWrap = new Wrap<String>().var("id");
		if(id == null) {
			_id(idWrap);
			setId(idWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrId(siteRequest_, ComputateVertxBaseModel.staticSolrId(siteRequest_, ComputateVertxBaseModel.staticSetId(siteRequest_, o)));
	}

	/////////////
	// created //
	/////////////

	/**	 The entity created
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime created;

	/**	<br> The entity created
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:created">Find the entity created in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _created(Wrap<ZonedDateTime> w);

	public ZonedDateTime getCreated() {
		return created;
	}

	public void setCreated(ZonedDateTime created) {
		this.created = created;
	}
	@JsonIgnore
	public void setCreated(Instant o) {
		this.created = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setCreated(String o) {
		this.created = ComputateVertxBaseModel.staticSetCreated(siteRequest_, o);
	}
	public static ZonedDateTime staticSetCreated(ComputateVertxSiteRequest siteRequest_, String o) {
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setCreated(Date o) {
		this.created = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected ComputateVertxBaseModel createdInit() {
		Wrap<ZonedDateTime> createdWrap = new Wrap<ZonedDateTime>().var("created");
		if(created == null) {
			_created(createdWrap);
			setCreated(createdWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static Date staticSolrCreated(ComputateVertxSiteRequest siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrCreated(ComputateVertxSiteRequest siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqCreated(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrCreated(siteRequest_, ComputateVertxBaseModel.staticSolrCreated(siteRequest_, ComputateVertxBaseModel.staticSetCreated(siteRequest_, o)));
	}

	public OffsetDateTime sqlCreated() {
		return created == null ? null : created.toOffsetDateTime();
	}

	//////////////
	// modified //
	//////////////

	/**	 The entity modified
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ComputateZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ComputateZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime modified;

	/**	<br> The entity modified
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:modified">Find the entity modified in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _modified(Wrap<ZonedDateTime> w);

	public ZonedDateTime getModified() {
		return modified;
	}

	public void setModified(ZonedDateTime modified) {
		this.modified = modified;
	}
	@JsonIgnore
	public void setModified(Instant o) {
		this.modified = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setModified(String o) {
		this.modified = ComputateVertxBaseModel.staticSetModified(siteRequest_, o);
	}
	public static ZonedDateTime staticSetModified(ComputateVertxSiteRequest siteRequest_, String o) {
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setModified(Date o) {
		this.modified = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
	}
	protected ComputateVertxBaseModel modifiedInit() {
		Wrap<ZonedDateTime> modifiedWrap = new Wrap<ZonedDateTime>().var("modified");
		if(modified == null) {
			_modified(modifiedWrap);
			setModified(modifiedWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static Date staticSolrModified(ComputateVertxSiteRequest siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrModified(ComputateVertxSiteRequest siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqModified(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrModified(siteRequest_, ComputateVertxBaseModel.staticSolrModified(siteRequest_, ComputateVertxBaseModel.staticSetModified(siteRequest_, o)));
	}

	//////////////
	// archived //
	//////////////

	/**	 The entity archived
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean archived;

	/**	<br> The entity archived
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:archived">Find the entity archived in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _archived(Wrap<Boolean> w);

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	@JsonIgnore
	public void setArchived(String o) {
		this.archived = ComputateVertxBaseModel.staticSetArchived(siteRequest_, o);
	}
	public static Boolean staticSetArchived(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ComputateVertxBaseModel archivedInit() {
		Wrap<Boolean> archivedWrap = new Wrap<Boolean>().var("archived");
		if(archived == null) {
			_archived(archivedWrap);
			setArchived(archivedWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static Boolean staticSolrArchived(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrArchived(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqArchived(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrArchived(siteRequest_, ComputateVertxBaseModel.staticSolrArchived(siteRequest_, ComputateVertxBaseModel.staticSetArchived(siteRequest_, o)));
	}

	public Boolean sqlArchived() {
		return archived;
	}

	/////////////
	// deleted //
	/////////////

	/**	 The entity deleted
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean deleted;

	/**	<br> The entity deleted
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:deleted">Find the entity deleted in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _deleted(Wrap<Boolean> w);

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	@JsonIgnore
	public void setDeleted(String o) {
		this.deleted = ComputateVertxBaseModel.staticSetDeleted(siteRequest_, o);
	}
	public static Boolean staticSetDeleted(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ComputateVertxBaseModel deletedInit() {
		Wrap<Boolean> deletedWrap = new Wrap<Boolean>().var("deleted");
		if(deleted == null) {
			_deleted(deletedWrap);
			setDeleted(deletedWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static Boolean staticSolrDeleted(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrDeleted(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDeleted(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrDeleted(siteRequest_, ComputateVertxBaseModel.staticSolrDeleted(siteRequest_, ComputateVertxBaseModel.staticSetDeleted(siteRequest_, o)));
	}

	public Boolean sqlDeleted() {
		return deleted;
	}

	////////////////////////
	// classCanonicalName //
	////////////////////////

	/**	 The entity classCanonicalName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classCanonicalName;

	/**	<br> The entity classCanonicalName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classCanonicalName">Find the entity classCanonicalName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classCanonicalName(Wrap<String> w);

	public String getClassCanonicalName() {
		return classCanonicalName;
	}
	public void setClassCanonicalName(String o) {
		this.classCanonicalName = ComputateVertxBaseModel.staticSetClassCanonicalName(siteRequest_, o);
	}
	public static String staticSetClassCanonicalName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel classCanonicalNameInit() {
		Wrap<String> classCanonicalNameWrap = new Wrap<String>().var("classCanonicalName");
		if(classCanonicalName == null) {
			_classCanonicalName(classCanonicalNameWrap);
			setClassCanonicalName(classCanonicalNameWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrClassCanonicalName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrClassCanonicalName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqClassCanonicalName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrClassCanonicalName(siteRequest_, ComputateVertxBaseModel.staticSolrClassCanonicalName(siteRequest_, ComputateVertxBaseModel.staticSetClassCanonicalName(siteRequest_, o)));
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
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSimpleName(Wrap<String> w);

	public String getClassSimpleName() {
		return classSimpleName;
	}
	public void setClassSimpleName(String o) {
		this.classSimpleName = ComputateVertxBaseModel.staticSetClassSimpleName(siteRequest_, o);
	}
	public static String staticSetClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel classSimpleNameInit() {
		Wrap<String> classSimpleNameWrap = new Wrap<String>().var("classSimpleName");
		if(classSimpleName == null) {
			_classSimpleName(classSimpleNameWrap);
			setClassSimpleName(classSimpleNameWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqClassSimpleName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrClassSimpleName(siteRequest_, ComputateVertxBaseModel.staticSolrClassSimpleName(siteRequest_, ComputateVertxBaseModel.staticSetClassSimpleName(siteRequest_, o)));
	}

	/////////////////////////
	// classCanonicalNames //
	/////////////////////////

	/**	 The entity classCanonicalNames
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> classCanonicalNames = new ArrayList<String>();

	/**	<br> The entity classCanonicalNames
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classCanonicalNames">Find the entity classCanonicalNames in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _classCanonicalNames(List<String> l);

	public List<String> getClassCanonicalNames() {
		return classCanonicalNames;
	}

	public void setClassCanonicalNames(List<String> classCanonicalNames) {
		this.classCanonicalNames = classCanonicalNames;
	}
	public static String staticSetClassCanonicalNames(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateVertxBaseModel addClassCanonicalNames(String...objets) {
		for(String o : objets) {
			addClassCanonicalNames(o);
		}
		return (ComputateVertxBaseModel)this;
	}
	public ComputateVertxBaseModel addClassCanonicalNames(String o) {
		if(o != null)
			this.classCanonicalNames.add(o);
		return (ComputateVertxBaseModel)this;
	}
	@JsonIgnore
	public void setClassCanonicalNames(JsonArray objets) {
		classCanonicalNames.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addClassCanonicalNames(o);
		}
	}
	protected ComputateVertxBaseModel classCanonicalNamesInit() {
		_classCanonicalNames(classCanonicalNames);
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrClassCanonicalNames(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrClassCanonicalNames(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqClassCanonicalNames(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrClassCanonicalNames(siteRequest_, ComputateVertxBaseModel.staticSolrClassCanonicalNames(siteRequest_, ComputateVertxBaseModel.staticSetClassCanonicalNames(siteRequest_, o)));
	}

	///////////////
	// sessionId //
	///////////////

	/**	 The entity sessionId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String sessionId;

	/**	<br> The entity sessionId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sessionId">Find the entity sessionId in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sessionId(Wrap<String> c);

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String o) {
		this.sessionId = ComputateVertxBaseModel.staticSetSessionId(siteRequest_, o);
	}
	public static String staticSetSessionId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel sessionIdInit() {
		Wrap<String> sessionIdWrap = new Wrap<String>().var("sessionId");
		if(sessionId == null) {
			_sessionId(sessionIdWrap);
			setSessionId(sessionIdWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrSessionId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSessionId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSessionId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrSessionId(siteRequest_, ComputateVertxBaseModel.staticSolrSessionId(siteRequest_, ComputateVertxBaseModel.staticSetSessionId(siteRequest_, o)));
	}

	public String sqlSessionId() {
		return sessionId;
	}

	/////////////
	// userKey //
	/////////////

	/**	 The entity userKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long userKey;

	/**	<br> The entity userKey
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKey">Find the entity userKey in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userKey(Wrap<Long> c);

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
	}
	@JsonIgnore
	public void setUserKey(String o) {
		this.userKey = ComputateVertxBaseModel.staticSetUserKey(siteRequest_, o);
	}
	public static Long staticSetUserKey(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected ComputateVertxBaseModel userKeyInit() {
		Wrap<Long> userKeyWrap = new Wrap<Long>().var("userKey");
		if(userKey == null) {
			_userKey(userKeyWrap);
			setUserKey(userKeyWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static Long staticSolrUserKey(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrUserKey(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserKey(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrUserKey(siteRequest_, ComputateVertxBaseModel.staticSolrUserKey(siteRequest_, ComputateVertxBaseModel.staticSetUserKey(siteRequest_, o)));
	}

	public Long sqlUserKey() {
		return userKey;
	}

	///////////
	// saves //
	///////////

	/**	 The entity saves
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> saves = new ArrayList<String>();

	/**	<br> The entity saves
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:saves">Find the entity saves in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _saves(List<String> l);

	public List<String> getSaves() {
		return saves;
	}

	public void setSaves(List<String> saves) {
		this.saves = saves;
	}
	public static String staticSetSaves(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	public ComputateVertxBaseModel addSaves(String...objets) {
		for(String o : objets) {
			addSaves(o);
		}
		return (ComputateVertxBaseModel)this;
	}
	public ComputateVertxBaseModel addSaves(String o) {
		if(o != null)
			this.saves.add(o);
		return (ComputateVertxBaseModel)this;
	}
	@JsonIgnore
	public void setSaves(JsonArray objets) {
		saves.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addSaves(o);
		}
	}
	protected ComputateVertxBaseModel savesInit() {
		_saves(saves);
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrSaves(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSaves(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSaves(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrSaves(siteRequest_, ComputateVertxBaseModel.staticSolrSaves(siteRequest_, ComputateVertxBaseModel.staticSetSaves(siteRequest_, o)));
	}

	/////////////////
	// objectTitle //
	/////////////////

	/**	 The entity objectTitle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectTitle;

	/**	<br> The entity objectTitle
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectTitle">Find the entity objectTitle in Solr</a>
	 * <br>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectTitle(Wrap<String> w);

	public String getObjectTitle() {
		return objectTitle;
	}
	public void setObjectTitle(String o) {
		this.objectTitle = ComputateVertxBaseModel.staticSetObjectTitle(siteRequest_, o);
	}
	public static String staticSetObjectTitle(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel objectTitleInit() {
		Wrap<String> objectTitleWrap = new Wrap<String>().var("objectTitle");
		if(objectTitle == null) {
			_objectTitle(objectTitleWrap);
			setObjectTitle(objectTitleWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrObjectTitle(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectTitle(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectTitle(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrObjectTitle(siteRequest_, ComputateVertxBaseModel.staticSolrObjectTitle(siteRequest_, ComputateVertxBaseModel.staticSetObjectTitle(siteRequest_, o)));
	}

	//////////////
	// objectId //
	//////////////

	/**	 The entity objectId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectId;

	/**	<br> The entity objectId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectId">Find the entity objectId in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectId(Wrap<String> c);

	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String o) {
		this.objectId = ComputateVertxBaseModel.staticSetObjectId(siteRequest_, o);
	}
	public static String staticSetObjectId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel objectIdInit() {
		Wrap<String> objectIdWrap = new Wrap<String>().var("objectId");
		if(objectId == null) {
			_objectId(objectIdWrap);
			setObjectId(objectIdWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrObjectId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrObjectId(siteRequest_, ComputateVertxBaseModel.staticSolrObjectId(siteRequest_, ComputateVertxBaseModel.staticSetObjectId(siteRequest_, o)));
	}

	///////////////////
	// objectNameVar //
	///////////////////

	/**	 The entity objectNameVar
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectNameVar;

	/**	<br> The entity objectNameVar
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectNameVar">Find the entity objectNameVar in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectNameVar(Wrap<String> c);

	public String getObjectNameVar() {
		return objectNameVar;
	}
	public void setObjectNameVar(String o) {
		this.objectNameVar = ComputateVertxBaseModel.staticSetObjectNameVar(siteRequest_, o);
	}
	public static String staticSetObjectNameVar(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel objectNameVarInit() {
		Wrap<String> objectNameVarWrap = new Wrap<String>().var("objectNameVar");
		if(objectNameVar == null) {
			_objectNameVar(objectNameVarWrap);
			setObjectNameVar(objectNameVarWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrObjectNameVar(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectNameVar(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectNameVar(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrObjectNameVar(siteRequest_, ComputateVertxBaseModel.staticSolrObjectNameVar(siteRequest_, ComputateVertxBaseModel.staticSetObjectNameVar(siteRequest_, o)));
	}

	///////////////////
	// objectSuggest //
	///////////////////

	/**	 The entity objectSuggest
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectSuggest;

	/**	<br> The entity objectSuggest
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectSuggest">Find the entity objectSuggest in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectSuggest(Wrap<String> c);

	public String getObjectSuggest() {
		return objectSuggest;
	}
	public void setObjectSuggest(String o) {
		this.objectSuggest = ComputateVertxBaseModel.staticSetObjectSuggest(siteRequest_, o);
	}
	public static String staticSetObjectSuggest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel objectSuggestInit() {
		Wrap<String> objectSuggestWrap = new Wrap<String>().var("objectSuggest");
		if(objectSuggest == null) {
			_objectSuggest(objectSuggestWrap);
			setObjectSuggest(objectSuggestWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrObjectSuggest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectSuggest(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectSuggest(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrObjectSuggest(siteRequest_, ComputateVertxBaseModel.staticSolrObjectSuggest(siteRequest_, ComputateVertxBaseModel.staticSetObjectSuggest(siteRequest_, o)));
	}

	////////////////
	// objectText //
	////////////////

	/**	 The entity objectText
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectText;

	/**	<br> The entity objectText
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectText">Find the entity objectText in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectText(Wrap<String> c);

	public String getObjectText() {
		return objectText;
	}
	public void setObjectText(String o) {
		this.objectText = ComputateVertxBaseModel.staticSetObjectText(siteRequest_, o);
	}
	public static String staticSetObjectText(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel objectTextInit() {
		Wrap<String> objectTextWrap = new Wrap<String>().var("objectText");
		if(objectText == null) {
			_objectText(objectTextWrap);
			setObjectText(objectTextWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrObjectText(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectText(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectText(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrObjectText(siteRequest_, ComputateVertxBaseModel.staticSolrObjectText(siteRequest_, ComputateVertxBaseModel.staticSetObjectText(siteRequest_, o)));
	}

	///////////////
	// pageUrlId //
	///////////////

	/**	 The entity pageUrlId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUrlId;

	/**	<br> The entity pageUrlId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrlId">Find the entity pageUrlId in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUrlId(Wrap<String> c);

	public String getPageUrlId() {
		return pageUrlId;
	}
	public void setPageUrlId(String o) {
		this.pageUrlId = ComputateVertxBaseModel.staticSetPageUrlId(siteRequest_, o);
	}
	public static String staticSetPageUrlId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel pageUrlIdInit() {
		Wrap<String> pageUrlIdWrap = new Wrap<String>().var("pageUrlId");
		if(pageUrlId == null) {
			_pageUrlId(pageUrlIdWrap);
			setPageUrlId(pageUrlIdWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrPageUrlId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUrlId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUrlId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrPageUrlId(siteRequest_, ComputateVertxBaseModel.staticSolrPageUrlId(siteRequest_, ComputateVertxBaseModel.staticSetPageUrlId(siteRequest_, o)));
	}

	///////////////
	// pageUrlPk //
	///////////////

	/**	 The entity pageUrlPk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUrlPk;

	/**	<br> The entity pageUrlPk
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrlPk">Find the entity pageUrlPk in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUrlPk(Wrap<String> c);

	public String getPageUrlPk() {
		return pageUrlPk;
	}
	public void setPageUrlPk(String o) {
		this.pageUrlPk = ComputateVertxBaseModel.staticSetPageUrlPk(siteRequest_, o);
	}
	public static String staticSetPageUrlPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel pageUrlPkInit() {
		Wrap<String> pageUrlPkWrap = new Wrap<String>().var("pageUrlPk");
		if(pageUrlPk == null) {
			_pageUrlPk(pageUrlPkWrap);
			setPageUrlPk(pageUrlPkWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrPageUrlPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUrlPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUrlPk(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrPageUrlPk(siteRequest_, ComputateVertxBaseModel.staticSolrPageUrlPk(siteRequest_, ComputateVertxBaseModel.staticSetPageUrlPk(siteRequest_, o)));
	}

	////////////////
	// pageUrlApi //
	////////////////

	/**	 The entity pageUrlApi
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUrlApi;

	/**	<br> The entity pageUrlApi
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrlApi">Find the entity pageUrlApi in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUrlApi(Wrap<String> c);

	public String getPageUrlApi() {
		return pageUrlApi;
	}
	public void setPageUrlApi(String o) {
		this.pageUrlApi = ComputateVertxBaseModel.staticSetPageUrlApi(siteRequest_, o);
	}
	public static String staticSetPageUrlApi(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel pageUrlApiInit() {
		Wrap<String> pageUrlApiWrap = new Wrap<String>().var("pageUrlApi");
		if(pageUrlApi == null) {
			_pageUrlApi(pageUrlApiWrap);
			setPageUrlApi(pageUrlApiWrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrPageUrlApi(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUrlApi(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUrlApi(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrPageUrlApi(siteRequest_, ComputateVertxBaseModel.staticSolrPageUrlApi(siteRequest_, ComputateVertxBaseModel.staticSetPageUrlApi(siteRequest_, o)));
	}

	////////////
	// pageH1 //
	////////////

	/**	 The entity pageH1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageH1;

	/**	<br> The entity pageH1
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.base.ComputateVertxBaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH1">Find the entity pageH1 in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH1(Wrap<String> c);

	public String getPageH1() {
		return pageH1;
	}
	public void setPageH1(String o) {
		this.pageH1 = ComputateVertxBaseModel.staticSetPageH1(siteRequest_, o);
	}
	public static String staticSetPageH1(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxBaseModel pageH1Init() {
		Wrap<String> pageH1Wrap = new Wrap<String>().var("pageH1");
		if(pageH1 == null) {
			_pageH1(pageH1Wrap);
			setPageH1(pageH1Wrap.o);
		}
		return (ComputateVertxBaseModel)this;
	}

	public static String staticSolrPageH1(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH1(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH1(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxBaseModel.staticSolrStrPageH1(siteRequest_, ComputateVertxBaseModel.staticSolrPageH1(siteRequest_, ComputateVertxBaseModel.staticSetPageH1(siteRequest_, o)));
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepComputateVertxBaseModel(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepComputateVertxBaseModel();
	}

	public Future<Void> promiseDeepComputateVertxBaseModel() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseComputateVertxBaseModel(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputateVertxBaseModel(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				pkInit();
				inheritPkInit();
				idInit();
				createdInit();
				modifiedInit();
				archivedInit();
				deletedInit();
				classCanonicalNameInit();
				classSimpleNameInit();
				classCanonicalNamesInit();
				sessionIdInit();
				userKeyInit();
				savesInit();
				objectTitleInit();
				objectIdInit();
				objectNameVarInit();
				objectSuggestInit();
				objectTextInit();
				pageUrlIdInit();
				pageUrlPkInit();
				pageUrlApiInit();
				pageH1Init();
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
		return promiseDeepComputateVertxBaseModel(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateVertxBaseModel(ComputateVertxSiteRequest siteRequest_) {
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
		siteRequestComputateVertxBaseModel(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateVertxBaseModel(v);
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
	public Object obtainComputateVertxBaseModel(String var) {
		ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)this;
		switch(var) {
			case "siteRequest_":
				return oComputateVertxBaseModel.siteRequest_;
			case "pk":
				return oComputateVertxBaseModel.pk;
			case "inheritPk":
				return oComputateVertxBaseModel.inheritPk;
			case "id":
				return oComputateVertxBaseModel.id;
			case "created":
				return oComputateVertxBaseModel.created;
			case "modified":
				return oComputateVertxBaseModel.modified;
			case "archived":
				return oComputateVertxBaseModel.archived;
			case "deleted":
				return oComputateVertxBaseModel.deleted;
			case "classCanonicalName":
				return oComputateVertxBaseModel.classCanonicalName;
			case "classSimpleName":
				return oComputateVertxBaseModel.classSimpleName;
			case "classCanonicalNames":
				return oComputateVertxBaseModel.classCanonicalNames;
			case "sessionId":
				return oComputateVertxBaseModel.sessionId;
			case "userKey":
				return oComputateVertxBaseModel.userKey;
			case "saves":
				return oComputateVertxBaseModel.saves;
			case "objectTitle":
				return oComputateVertxBaseModel.objectTitle;
			case "objectId":
				return oComputateVertxBaseModel.objectId;
			case "objectNameVar":
				return oComputateVertxBaseModel.objectNameVar;
			case "objectSuggest":
				return oComputateVertxBaseModel.objectSuggest;
			case "objectText":
				return oComputateVertxBaseModel.objectText;
			case "pageUrlId":
				return oComputateVertxBaseModel.pageUrlId;
			case "pageUrlPk":
				return oComputateVertxBaseModel.pageUrlPk;
			case "pageUrlApi":
				return oComputateVertxBaseModel.pageUrlApi;
			case "pageH1":
				return oComputateVertxBaseModel.pageH1;
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
				o = relateComputateVertxBaseModel(v, val);
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateComputateVertxBaseModel(String var, Object val) {
		ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetComputateVertxBaseModel(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateVertxBaseModel(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "pk":
			return ComputateVertxBaseModel.staticSetPk(siteRequest_, o);
		case "inheritPk":
			return ComputateVertxBaseModel.staticSetInheritPk(siteRequest_, o);
		case "id":
			return ComputateVertxBaseModel.staticSetId(siteRequest_, o);
		case "created":
			return ComputateVertxBaseModel.staticSetCreated(siteRequest_, o);
		case "modified":
			return ComputateVertxBaseModel.staticSetModified(siteRequest_, o);
		case "archived":
			return ComputateVertxBaseModel.staticSetArchived(siteRequest_, o);
		case "deleted":
			return ComputateVertxBaseModel.staticSetDeleted(siteRequest_, o);
		case "classCanonicalName":
			return ComputateVertxBaseModel.staticSetClassCanonicalName(siteRequest_, o);
		case "classSimpleName":
			return ComputateVertxBaseModel.staticSetClassSimpleName(siteRequest_, o);
		case "classCanonicalNames":
			return ComputateVertxBaseModel.staticSetClassCanonicalNames(siteRequest_, o);
		case "sessionId":
			return ComputateVertxBaseModel.staticSetSessionId(siteRequest_, o);
		case "userKey":
			return ComputateVertxBaseModel.staticSetUserKey(siteRequest_, o);
		case "saves":
			return ComputateVertxBaseModel.staticSetSaves(siteRequest_, o);
		case "objectTitle":
			return ComputateVertxBaseModel.staticSetObjectTitle(siteRequest_, o);
		case "objectId":
			return ComputateVertxBaseModel.staticSetObjectId(siteRequest_, o);
		case "objectNameVar":
			return ComputateVertxBaseModel.staticSetObjectNameVar(siteRequest_, o);
		case "objectSuggest":
			return ComputateVertxBaseModel.staticSetObjectSuggest(siteRequest_, o);
		case "objectText":
			return ComputateVertxBaseModel.staticSetObjectText(siteRequest_, o);
		case "pageUrlId":
			return ComputateVertxBaseModel.staticSetPageUrlId(siteRequest_, o);
		case "pageUrlPk":
			return ComputateVertxBaseModel.staticSetPageUrlPk(siteRequest_, o);
		case "pageUrlApi":
			return ComputateVertxBaseModel.staticSetPageUrlApi(siteRequest_, o);
		case "pageH1":
			return ComputateVertxBaseModel.staticSetPageH1(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrComputateVertxBaseModel(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrComputateVertxBaseModel(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "pk":
			return ComputateVertxBaseModel.staticSolrPk(siteRequest_, (Long)o);
		case "inheritPk":
			return ComputateVertxBaseModel.staticSolrInheritPk(siteRequest_, (String)o);
		case "id":
			return ComputateVertxBaseModel.staticSolrId(siteRequest_, (String)o);
		case "created":
			return ComputateVertxBaseModel.staticSolrCreated(siteRequest_, (ZonedDateTime)o);
		case "modified":
			return ComputateVertxBaseModel.staticSolrModified(siteRequest_, (ZonedDateTime)o);
		case "archived":
			return ComputateVertxBaseModel.staticSolrArchived(siteRequest_, (Boolean)o);
		case "deleted":
			return ComputateVertxBaseModel.staticSolrDeleted(siteRequest_, (Boolean)o);
		case "classCanonicalName":
			return ComputateVertxBaseModel.staticSolrClassCanonicalName(siteRequest_, (String)o);
		case "classSimpleName":
			return ComputateVertxBaseModel.staticSolrClassSimpleName(siteRequest_, (String)o);
		case "classCanonicalNames":
			return ComputateVertxBaseModel.staticSolrClassCanonicalNames(siteRequest_, (String)o);
		case "sessionId":
			return ComputateVertxBaseModel.staticSolrSessionId(siteRequest_, (String)o);
		case "userKey":
			return ComputateVertxBaseModel.staticSolrUserKey(siteRequest_, (Long)o);
		case "saves":
			return ComputateVertxBaseModel.staticSolrSaves(siteRequest_, (String)o);
		case "objectTitle":
			return ComputateVertxBaseModel.staticSolrObjectTitle(siteRequest_, (String)o);
		case "objectId":
			return ComputateVertxBaseModel.staticSolrObjectId(siteRequest_, (String)o);
		case "objectNameVar":
			return ComputateVertxBaseModel.staticSolrObjectNameVar(siteRequest_, (String)o);
		case "objectSuggest":
			return ComputateVertxBaseModel.staticSolrObjectSuggest(siteRequest_, (String)o);
		case "objectText":
			return ComputateVertxBaseModel.staticSolrObjectText(siteRequest_, (String)o);
		case "pageUrlId":
			return ComputateVertxBaseModel.staticSolrPageUrlId(siteRequest_, (String)o);
		case "pageUrlPk":
			return ComputateVertxBaseModel.staticSolrPageUrlPk(siteRequest_, (String)o);
		case "pageUrlApi":
			return ComputateVertxBaseModel.staticSolrPageUrlApi(siteRequest_, (String)o);
		case "pageH1":
			return ComputateVertxBaseModel.staticSolrPageH1(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrStrComputateVertxBaseModel(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrComputateVertxBaseModel(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "pk":
			return ComputateVertxBaseModel.staticSolrStrPk(siteRequest_, (Long)o);
		case "inheritPk":
			return ComputateVertxBaseModel.staticSolrStrInheritPk(siteRequest_, (String)o);
		case "id":
			return ComputateVertxBaseModel.staticSolrStrId(siteRequest_, (String)o);
		case "created":
			return ComputateVertxBaseModel.staticSolrStrCreated(siteRequest_, (Date)o);
		case "modified":
			return ComputateVertxBaseModel.staticSolrStrModified(siteRequest_, (Date)o);
		case "archived":
			return ComputateVertxBaseModel.staticSolrStrArchived(siteRequest_, (Boolean)o);
		case "deleted":
			return ComputateVertxBaseModel.staticSolrStrDeleted(siteRequest_, (Boolean)o);
		case "classCanonicalName":
			return ComputateVertxBaseModel.staticSolrStrClassCanonicalName(siteRequest_, (String)o);
		case "classSimpleName":
			return ComputateVertxBaseModel.staticSolrStrClassSimpleName(siteRequest_, (String)o);
		case "classCanonicalNames":
			return ComputateVertxBaseModel.staticSolrStrClassCanonicalNames(siteRequest_, (String)o);
		case "sessionId":
			return ComputateVertxBaseModel.staticSolrStrSessionId(siteRequest_, (String)o);
		case "userKey":
			return ComputateVertxBaseModel.staticSolrStrUserKey(siteRequest_, (Long)o);
		case "saves":
			return ComputateVertxBaseModel.staticSolrStrSaves(siteRequest_, (String)o);
		case "objectTitle":
			return ComputateVertxBaseModel.staticSolrStrObjectTitle(siteRequest_, (String)o);
		case "objectId":
			return ComputateVertxBaseModel.staticSolrStrObjectId(siteRequest_, (String)o);
		case "objectNameVar":
			return ComputateVertxBaseModel.staticSolrStrObjectNameVar(siteRequest_, (String)o);
		case "objectSuggest":
			return ComputateVertxBaseModel.staticSolrStrObjectSuggest(siteRequest_, (String)o);
		case "objectText":
			return ComputateVertxBaseModel.staticSolrStrObjectText(siteRequest_, (String)o);
		case "pageUrlId":
			return ComputateVertxBaseModel.staticSolrStrPageUrlId(siteRequest_, (String)o);
		case "pageUrlPk":
			return ComputateVertxBaseModel.staticSolrStrPageUrlPk(siteRequest_, (String)o);
		case "pageUrlApi":
			return ComputateVertxBaseModel.staticSolrStrPageUrlApi(siteRequest_, (String)o);
		case "pageH1":
			return ComputateVertxBaseModel.staticSolrStrPageH1(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSolrFqComputateVertxBaseModel(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqComputateVertxBaseModel(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "pk":
			return ComputateVertxBaseModel.staticSolrFqPk(siteRequest_, o);
		case "inheritPk":
			return ComputateVertxBaseModel.staticSolrFqInheritPk(siteRequest_, o);
		case "id":
			return ComputateVertxBaseModel.staticSolrFqId(siteRequest_, o);
		case "created":
			return ComputateVertxBaseModel.staticSolrFqCreated(siteRequest_, o);
		case "modified":
			return ComputateVertxBaseModel.staticSolrFqModified(siteRequest_, o);
		case "archived":
			return ComputateVertxBaseModel.staticSolrFqArchived(siteRequest_, o);
		case "deleted":
			return ComputateVertxBaseModel.staticSolrFqDeleted(siteRequest_, o);
		case "classCanonicalName":
			return ComputateVertxBaseModel.staticSolrFqClassCanonicalName(siteRequest_, o);
		case "classSimpleName":
			return ComputateVertxBaseModel.staticSolrFqClassSimpleName(siteRequest_, o);
		case "classCanonicalNames":
			return ComputateVertxBaseModel.staticSolrFqClassCanonicalNames(siteRequest_, o);
		case "sessionId":
			return ComputateVertxBaseModel.staticSolrFqSessionId(siteRequest_, o);
		case "userKey":
			return ComputateVertxBaseModel.staticSolrFqUserKey(siteRequest_, o);
		case "saves":
			return ComputateVertxBaseModel.staticSolrFqSaves(siteRequest_, o);
		case "objectTitle":
			return ComputateVertxBaseModel.staticSolrFqObjectTitle(siteRequest_, o);
		case "objectId":
			return ComputateVertxBaseModel.staticSolrFqObjectId(siteRequest_, o);
		case "objectNameVar":
			return ComputateVertxBaseModel.staticSolrFqObjectNameVar(siteRequest_, o);
		case "objectSuggest":
			return ComputateVertxBaseModel.staticSolrFqObjectSuggest(siteRequest_, o);
		case "objectText":
			return ComputateVertxBaseModel.staticSolrFqObjectText(siteRequest_, o);
		case "pageUrlId":
			return ComputateVertxBaseModel.staticSolrFqPageUrlId(siteRequest_, o);
		case "pageUrlPk":
			return ComputateVertxBaseModel.staticSolrFqPageUrlPk(siteRequest_, o);
		case "pageUrlApi":
			return ComputateVertxBaseModel.staticSolrFqPageUrlApi(siteRequest_, o);
		case "pageH1":
			return ComputateVertxBaseModel.staticSolrFqPageH1(siteRequest_, o);
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
					o = defineComputateVertxBaseModel(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineComputateVertxBaseModel(String var, Object val) {
		switch(var.toLowerCase()) {
			case "inheritpk":
				if(val instanceof String)
					setInheritPk((String)val);
				saves.add("inheritPk");
				return val;
			case "created":
				if(val instanceof ZonedDateTime)
					setCreated((ZonedDateTime)val);
				else if(val instanceof OffsetDateTime)
					setCreated(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SITE_ZONE))));
				saves.add("created");
				return val;
			case "archived":
				if(val instanceof Boolean)
					setArchived((Boolean)val);
				saves.add("archived");
				return val;
			case "deleted":
				if(val instanceof Boolean)
					setDeleted((Boolean)val);
				saves.add("deleted");
				return val;
			case "sessionid":
				if(val instanceof String)
					setSessionId((String)val);
				saves.add("sessionId");
				return val;
			case "userkey":
				if(val instanceof Long)
					setUserKey((Long)val);
				saves.add("userKey");
				return val;
			default:
				return null;
		}
	}

	/////////////
	// populate //
	/////////////

	public void populateForClass(SolrResponse.Doc doc) {
		populateComputateVertxBaseModel(doc);
	}
	public void populateComputateVertxBaseModel(SolrResponse.Doc doc) {
		ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)this;
		saves = doc.get("saves_docvalues_strings");
		if(saves != null) {
		}
	}

	public void indexComputateVertxBaseModel(JsonObject doc) {
		if(pk != null) {
			doc.put("pk_docvalues_long", pk);
		}
		if(inheritPk != null) {
			doc.put("inheritPk_docvalues_string", inheritPk);
		}
		if(id != null) {
			doc.put("id", id);
		}
		if(created != null) {
			doc.put("created_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(created.toInstant(), ZoneId.of("UTC"))));
		}
		if(modified != null) {
			doc.put("modified_docvalues_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(modified.toInstant(), ZoneId.of("UTC"))));
		}
		if(archived != null) {
			doc.put("archived_docvalues_boolean", archived);
		}
		if(deleted != null) {
			doc.put("deleted_docvalues_boolean", deleted);
		}
		if(classCanonicalName != null) {
			doc.put("classCanonicalName_docvalues_string", classCanonicalName);
		}
		if(classSimpleName != null) {
			doc.put("classSimpleName_docvalues_string", classSimpleName);
		}
		if(classCanonicalNames != null) {
			for(java.lang.String o : classCanonicalNames) {
				doc.put("classCanonicalNames_docvalues_strings", o);
			}
		}
		if(sessionId != null) {
			doc.put("sessionId_docvalues_string", sessionId);
		}
		if(userKey != null) {
			doc.put("userKey_docvalues_long", userKey);
		}
		if(saves != null) {
			for(java.lang.String o : saves) {
				doc.put("saves_docvalues_strings", o);
			}
		}
		if(objectTitle != null) {
			doc.put("objectTitle_docvalues_string", objectTitle);
		}
		if(objectId != null) {
			doc.put("objectId_docvalues_string", objectId);
		}
		if(objectSuggest != null) {
			doc.put("objectSuggest_suggested", objectSuggest);
		}
		if(objectText != null) {
			doc.put("objectText_text_enUS", objectText.toString());
			doc.put("objectText_docvalues_string", objectText);
		}
		if(pageUrlId != null) {
			doc.put("pageUrlId_docvalues_string", pageUrlId);
		}
		if(pageUrlPk != null) {
			doc.put("pageUrlPk_docvalues_string", pageUrlPk);
		}
	}

	public static String varIndexedComputateVertxBaseModel(String entityVar) {
		switch(entityVar) {
			case "pk":
				return "pk_docvalues_long";
			case "inheritPk":
				return "inheritPk_docvalues_string";
			case "id":
				return "id";
			case "created":
				return "created_docvalues_date";
			case "modified":
				return "modified_docvalues_date";
			case "archived":
				return "archived_docvalues_boolean";
			case "deleted":
				return "deleted_docvalues_boolean";
			case "classCanonicalName":
				return "classCanonicalName_docvalues_string";
			case "classSimpleName":
				return "classSimpleName_docvalues_string";
			case "classCanonicalNames":
				return "classCanonicalNames_docvalues_strings";
			case "sessionId":
				return "sessionId_docvalues_string";
			case "userKey":
				return "userKey_docvalues_long";
			case "saves":
				return "saves_docvalues_strings";
			case "objectTitle":
				return "objectTitle_docvalues_string";
			case "objectId":
				return "objectId_docvalues_string";
			case "objectSuggest":
				return "objectSuggest_suggested";
			case "objectText":
				return "objectText_text_enUS";
			case "pageUrlId":
				return "pageUrlId_docvalues_string";
			case "pageUrlPk":
				return "pageUrlPk_docvalues_string";
			default:
				return null;
		}
	}

	public static String varSearchComputateVertxBaseModel(String entityVar) {
		switch(entityVar) {
			case "objectText":
				return "objectText_text_enUS";
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				return null;
		}
	}

	public static String varSuggestedComputateVertxBaseModel(String entityVar) {
		switch(entityVar) {
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				return null;
		}
	}

	/////////////
	// store //
	/////////////

	public void storeForClass(SolrResponse.Doc doc) {
		storeComputateVertxBaseModel(doc);
	}
	public void storeComputateVertxBaseModel(SolrResponse.Doc doc) {
		ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)this;

		oComputateVertxBaseModel.setPk(Optional.ofNullable(doc.get("pk_docvalues_long")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setInheritPk(Optional.ofNullable(doc.get("inheritPk_docvalues_string")).map(v -> v.toString()).orElse(null));
		String id = (String)doc.get("id");
		oComputateVertxBaseModel.setId(id);
		oComputateVertxBaseModel.setCreated(Optional.ofNullable(doc.get("created_docvalues_date")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setModified(Optional.ofNullable(doc.get("modified_docvalues_date")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setArchived(Optional.ofNullable(doc.get("archived_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setDeleted(Optional.ofNullable(doc.get("deleted_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setClassCanonicalName(Optional.ofNullable(doc.get("classCanonicalName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setClassSimpleName(Optional.ofNullable(doc.get("classSimpleName_docvalues_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("classCanonicalNames_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oComputateVertxBaseModel.addClassCanonicalNames(v.toString());
		});
		oComputateVertxBaseModel.setSessionId(Optional.ofNullable(doc.get("sessionId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setUserKey(Optional.ofNullable(doc.get("userKey_docvalues_long")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)doc.get("saves_docvalues_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oComputateVertxBaseModel.addSaves(v.toString());
		});
		oComputateVertxBaseModel.setObjectTitle(Optional.ofNullable(doc.get("objectTitle_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setObjectId(Optional.ofNullable(doc.get("objectId_docvalues_string")).map(v -> v.toString()).orElse(null));
		String objectSuggest = (String)doc.get("objectSuggest_suggested");
		oComputateVertxBaseModel.setObjectSuggest(objectSuggest);
		oComputateVertxBaseModel.setObjectText(Optional.ofNullable(doc.get("objectText_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setPageUrlId(Optional.ofNullable(doc.get("pageUrlId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxBaseModel.setPageUrlPk(Optional.ofNullable(doc.get("pageUrlPk_docvalues_string")).map(v -> v.toString()).orElse(null));
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestComputateVertxBaseModel() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(ComputateVertxSiteRequest::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ComputateVertxBaseModel) {
			ComputateVertxBaseModel original = (ComputateVertxBaseModel)o;
			if(!Objects.equals(pk, original.getPk()))
				apiRequest.addVars("pk");
			if(!Objects.equals(inheritPk, original.getInheritPk()))
				apiRequest.addVars("inheritPk");
			if(!Objects.equals(id, original.getId()))
				apiRequest.addVars("id");
			if(!Objects.equals(created, original.getCreated()))
				apiRequest.addVars("created");
			if(!Objects.equals(modified, original.getModified()))
				apiRequest.addVars("modified");
			if(!Objects.equals(archived, original.getArchived()))
				apiRequest.addVars("archived");
			if(!Objects.equals(deleted, original.getDeleted()))
				apiRequest.addVars("deleted");
			if(!Objects.equals(classCanonicalName, original.getClassCanonicalName()))
				apiRequest.addVars("classCanonicalName");
			if(!Objects.equals(classSimpleName, original.getClassSimpleName()))
				apiRequest.addVars("classSimpleName");
			if(!Objects.equals(classCanonicalNames, original.getClassCanonicalNames()))
				apiRequest.addVars("classCanonicalNames");
			if(!Objects.equals(sessionId, original.getSessionId()))
				apiRequest.addVars("sessionId");
			if(!Objects.equals(userKey, original.getUserKey()))
				apiRequest.addVars("userKey");
			if(!Objects.equals(saves, original.getSaves()))
				apiRequest.addVars("saves");
			if(!Objects.equals(objectTitle, original.getObjectTitle()))
				apiRequest.addVars("objectTitle");
			if(!Objects.equals(objectId, original.getObjectId()))
				apiRequest.addVars("objectId");
			if(!Objects.equals(objectSuggest, original.getObjectSuggest()))
				apiRequest.addVars("objectSuggest");
			if(!Objects.equals(objectText, original.getObjectText()))
				apiRequest.addVars("objectText");
			if(!Objects.equals(pageUrlId, original.getPageUrlId()))
				apiRequest.addVars("pageUrlId");
			if(!Objects.equals(pageUrlPk, original.getPageUrlPk()))
				apiRequest.addVars("pageUrlPk");
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Optional.ofNullable(pk).map(v -> "pk: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(inheritPk).map(v -> "inheritPk: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(id).map(v -> "id: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(created).map(v -> "created: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(modified).map(v -> "modified: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(archived).map(v -> "archived: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(deleted).map(v -> "deleted: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(classCanonicalName).map(v -> "classCanonicalName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(classSimpleName).map(v -> "classSimpleName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(classCanonicalNames).map(v -> "classCanonicalNames: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(sessionId).map(v -> "sessionId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(userKey).map(v -> "userKey: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(saves).map(v -> "saves: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(objectTitle).map(v -> "objectTitle: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(objectId).map(v -> "objectId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(objectSuggest).map(v -> "objectSuggest: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(objectText).map(v -> "objectText: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(pageUrlId).map(v -> "pageUrlId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(pageUrlPk).map(v -> "pageUrlPk: \"" + v + "\"\n" ).orElse(""));
		return sb.toString();
	}

	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_pk = "pk";
	public static final String VAR_inheritPk = "inheritPk";
	public static final String VAR_id = "id";
	public static final String VAR_created = "created";
	public static final String VAR_modified = "modified";
	public static final String VAR_archived = "archived";
	public static final String VAR_deleted = "deleted";
	public static final String VAR_classCanonicalName = "classCanonicalName";
	public static final String VAR_classSimpleName = "classSimpleName";
	public static final String VAR_classCanonicalNames = "classCanonicalNames";
	public static final String VAR_sessionId = "sessionId";
	public static final String VAR_userKey = "userKey";
	public static final String VAR_saves = "saves";
	public static final String VAR_objectTitle = "objectTitle";
	public static final String VAR_objectId = "objectId";
	public static final String VAR_objectNameVar = "objectNameVar";
	public static final String VAR_objectSuggest = "objectSuggest";
	public static final String VAR_objectText = "objectText";
	public static final String VAR_pageUrlId = "pageUrlId";
	public static final String VAR_pageUrlPk = "pageUrlPk";
	public static final String VAR_pageUrlApi = "pageUrlApi";
	public static final String VAR_pageH1 = "pageH1";

	public static final String DISPLAY_NAME_siteRequest_ = "";
	public static final String DISPLAY_NAME_pk = "primary key";
	public static final String DISPLAY_NAME_inheritPk = "";
	public static final String DISPLAY_NAME_id = "";
	public static final String DISPLAY_NAME_created = "created";
	public static final String DISPLAY_NAME_modified = "modified";
	public static final String DISPLAY_NAME_archived = "archived";
	public static final String DISPLAY_NAME_deleted = "deleted";
	public static final String DISPLAY_NAME_classCanonicalName = "";
	public static final String DISPLAY_NAME_classSimpleName = "";
	public static final String DISPLAY_NAME_classCanonicalNames = "";
	public static final String DISPLAY_NAME_sessionId = "";
	public static final String DISPLAY_NAME_userKey = "";
	public static final String DISPLAY_NAME_saves = "";
	public static final String DISPLAY_NAME_objectTitle = "";
	public static final String DISPLAY_NAME_objectId = "ID";
	public static final String DISPLAY_NAME_objectNameVar = "";
	public static final String DISPLAY_NAME_objectSuggest = "";
	public static final String DISPLAY_NAME_objectText = "";
	public static final String DISPLAY_NAME_pageUrlId = "";
	public static final String DISPLAY_NAME_pageUrlPk = "";
	public static final String DISPLAY_NAME_pageUrlApi = "";
	public static final String DISPLAY_NAME_pageH1 = "";

	public static String displayNameForClass(String var) {
		return ComputateVertxBaseModel.displayNameComputateVertxBaseModel(var);
	}
	public static String displayNameComputateVertxBaseModel(String var) {
		switch(var) {
		case VAR_siteRequest_:
			return DISPLAY_NAME_siteRequest_;
		case VAR_pk:
			return DISPLAY_NAME_pk;
		case VAR_inheritPk:
			return DISPLAY_NAME_inheritPk;
		case VAR_id:
			return DISPLAY_NAME_id;
		case VAR_created:
			return DISPLAY_NAME_created;
		case VAR_modified:
			return DISPLAY_NAME_modified;
		case VAR_archived:
			return DISPLAY_NAME_archived;
		case VAR_deleted:
			return DISPLAY_NAME_deleted;
		case VAR_classCanonicalName:
			return DISPLAY_NAME_classCanonicalName;
		case VAR_classSimpleName:
			return DISPLAY_NAME_classSimpleName;
		case VAR_classCanonicalNames:
			return DISPLAY_NAME_classCanonicalNames;
		case VAR_sessionId:
			return DISPLAY_NAME_sessionId;
		case VAR_userKey:
			return DISPLAY_NAME_userKey;
		case VAR_saves:
			return DISPLAY_NAME_saves;
		case VAR_objectTitle:
			return DISPLAY_NAME_objectTitle;
		case VAR_objectId:
			return DISPLAY_NAME_objectId;
		case VAR_objectNameVar:
			return DISPLAY_NAME_objectNameVar;
		case VAR_objectSuggest:
			return DISPLAY_NAME_objectSuggest;
		case VAR_objectText:
			return DISPLAY_NAME_objectText;
		case VAR_pageUrlId:
			return DISPLAY_NAME_pageUrlId;
		case VAR_pageUrlPk:
			return DISPLAY_NAME_pageUrlPk;
		case VAR_pageUrlApi:
			return DISPLAY_NAME_pageUrlApi;
		case VAR_pageH1:
			return DISPLAY_NAME_pageH1;
		default:
			return null;
		}
	}
}
