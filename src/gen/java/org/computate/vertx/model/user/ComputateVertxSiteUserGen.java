package org.computate.vertx.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.computate.vertx.request.ComputateVertxSiteRequest;
import org.computate.search.serialize.ComputateLocalDateDeserializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.vertx.api.ApiRequest;
import org.computate.search.response.solr.SolrResponse;
import org.computate.vertx.model.base.ComputateVertxBaseModel;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import java.math.RoundingMode;
import org.slf4j.Logger;
import java.math.MathContext;
import io.vertx.core.Promise;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.vertx.core.Future;
import org.computate.search.serialize.ComputateZonedDateTimeDeserializer;
import java.util.Objects;
import org.computate.search.serialize.ComputateLocalDateSerializer;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.computate.search.wrap.Wrap;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br>
 **/
public abstract class ComputateVertxSiteUserGen<DEV> extends ComputateVertxBaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(ComputateVertxSiteUser.class);

	public static final String ComputateVertxSiteUser_AName = "a site user";
	public static final String ComputateVertxSiteUser_This = "this ";
	public static final String ComputateVertxSiteUser_ThisName = "this site user";
	public static final String ComputateVertxSiteUser_A = "a ";
	public static final String ComputateVertxSiteUser_TheName = "the site user";
	public static final String ComputateVertxSiteUser_NameSingular = "site user";
	public static final String ComputateVertxSiteUser_NamePlural = "site users";
	public static final String ComputateVertxSiteUser_NameActual = "current site user";
	public static final String ComputateVertxSiteUser_AllName = "all the site users";
	public static final String ComputateVertxSiteUser_SearchAllNameBy = "search site users by ";
	public static final String ComputateVertxSiteUser_Title = "site users";
	public static final String ComputateVertxSiteUser_ThePluralName = "the site users";
	public static final String ComputateVertxSiteUser_NoNameFound = "no site user found";
	public static final String ComputateVertxSiteUser_NameVar = "user";
	public static final String ComputateVertxSiteUser_OfName = "of site user";
	public static final String ComputateVertxSiteUser_ANameAdjective = "a site user";
	public static final String ComputateVertxSiteUser_NameAdjectiveSingular = "site user";
	public static final String ComputateVertxSiteUser_NameAdjectivePlural = "site users";
	public static final String ComputateVertxSiteUser_Color = "teal";
	public static final String ComputateVertxSiteUser_IconGroup = "regular";
	public static final String ComputateVertxSiteUser_IconName = "user-cog";

	//////////////
	// userKeys //
	//////////////

	/**	 The entity userKeys
	 *	 It is constructed before being initialized with the constructor by default. 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> userKeys = new ArrayList<Long>();

	/**	<br> The entity userKeys
	 *  It is constructed before being initialized with the constructor by default. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKeys">Find the entity userKeys in Solr</a>
	 * <br>
	 * @param l is the entity already constructed. 
	 **/
	protected abstract void _userKeys(List<Long> l);

	public List<Long> getUserKeys() {
		return userKeys;
	}

	public void setUserKeys(List<Long> userKeys) {
		this.userKeys = userKeys;
	}
	@JsonIgnore
	public void setUserKeys(String o) {
		Long l = ComputateVertxSiteUser.staticSetUserKeys(siteRequest_, o);
		if(l != null)
			addUserKeys(l);
	}
	public static Long staticSetUserKeys(ComputateVertxSiteRequest siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public ComputateVertxSiteUser addUserKeys(Long...objets) {
		for(Long o : objets) {
			addUserKeys(o);
		}
		return (ComputateVertxSiteUser)this;
	}
	public ComputateVertxSiteUser addUserKeys(Long o) {
		if(o != null)
			this.userKeys.add(o);
		return (ComputateVertxSiteUser)this;
	}
	@JsonIgnore
	public void setUserKeys(JsonArray objets) {
		userKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addUserKeys(o);
		}
	}
	public ComputateVertxSiteUser addUserKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addUserKeys(p);
		}
		return (ComputateVertxSiteUser)this;
	}
	protected ComputateVertxSiteUser userKeysInit() {
		_userKeys(userKeys);
		return (ComputateVertxSiteUser)this;
	}

	public static Long staticSolrUserKeys(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrUserKeys(ComputateVertxSiteRequest siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserKeys(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrUserKeys(siteRequest_, ComputateVertxSiteUser.staticSolrUserKeys(siteRequest_, ComputateVertxSiteUser.staticSetUserKeys(siteRequest_, o)));
	}

	////////////
	// userId //
	////////////

	/**	 The entity userId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userId;

	/**	<br> The entity userId
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userId">Find the entity userId in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userId(Wrap<String> c);

	public String getUserId() {
		return userId;
	}
	public void setUserId(String o) {
		this.userId = ComputateVertxSiteUser.staticSetUserId(siteRequest_, o);
	}
	public static String staticSetUserId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteUser userIdInit() {
		Wrap<String> userIdWrap = new Wrap<String>().var("userId");
		if(userId == null) {
			_userId(userIdWrap);
			setUserId(userIdWrap.o);
		}
		return (ComputateVertxSiteUser)this;
	}

	public static String staticSolrUserId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserId(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserId(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrUserId(siteRequest_, ComputateVertxSiteUser.staticSolrUserId(siteRequest_, ComputateVertxSiteUser.staticSetUserId(siteRequest_, o)));
	}

	public String sqlUserId() {
		return userId;
	}

	//////////////
	// userName //
	//////////////

	/**	 The entity userName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userName;

	/**	<br> The entity userName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userName">Find the entity userName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userName(Wrap<String> c);

	public String getUserName() {
		return userName;
	}
	public void setUserName(String o) {
		this.userName = ComputateVertxSiteUser.staticSetUserName(siteRequest_, o);
	}
	public static String staticSetUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteUser userNameInit() {
		Wrap<String> userNameWrap = new Wrap<String>().var("userName");
		if(userName == null) {
			_userName(userNameWrap);
			setUserName(userNameWrap.o);
		}
		return (ComputateVertxSiteUser)this;
	}

	public static String staticSolrUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrUserName(siteRequest_, ComputateVertxSiteUser.staticSolrUserName(siteRequest_, ComputateVertxSiteUser.staticSetUserName(siteRequest_, o)));
	}

	public String sqlUserName() {
		return userName;
	}

	///////////////
	// userEmail //
	///////////////

	/**	 The entity userEmail
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userEmail;

	/**	<br> The entity userEmail
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userEmail">Find the entity userEmail in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userEmail(Wrap<String> c);

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String o) {
		this.userEmail = ComputateVertxSiteUser.staticSetUserEmail(siteRequest_, o);
	}
	public static String staticSetUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteUser userEmailInit() {
		Wrap<String> userEmailWrap = new Wrap<String>().var("userEmail");
		if(userEmail == null) {
			_userEmail(userEmailWrap);
			setUserEmail(userEmailWrap.o);
		}
		return (ComputateVertxSiteUser)this;
	}

	public static String staticSolrUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserEmail(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrUserEmail(siteRequest_, ComputateVertxSiteUser.staticSolrUserEmail(siteRequest_, ComputateVertxSiteUser.staticSetUserEmail(siteRequest_, o)));
	}

	public String sqlUserEmail() {
		return userEmail;
	}

	///////////////////
	// userFirstName //
	///////////////////

	/**	 The entity userFirstName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userFirstName;

	/**	<br> The entity userFirstName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userFirstName">Find the entity userFirstName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userFirstName(Wrap<String> c);

	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String o) {
		this.userFirstName = ComputateVertxSiteUser.staticSetUserFirstName(siteRequest_, o);
	}
	public static String staticSetUserFirstName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteUser userFirstNameInit() {
		Wrap<String> userFirstNameWrap = new Wrap<String>().var("userFirstName");
		if(userFirstName == null) {
			_userFirstName(userFirstNameWrap);
			setUserFirstName(userFirstNameWrap.o);
		}
		return (ComputateVertxSiteUser)this;
	}

	public static String staticSolrUserFirstName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserFirstName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserFirstName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrUserFirstName(siteRequest_, ComputateVertxSiteUser.staticSolrUserFirstName(siteRequest_, ComputateVertxSiteUser.staticSetUserFirstName(siteRequest_, o)));
	}

	public String sqlUserFirstName() {
		return userFirstName;
	}

	//////////////////
	// userLastName //
	//////////////////

	/**	 The entity userLastName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userLastName;

	/**	<br> The entity userLastName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userLastName">Find the entity userLastName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userLastName(Wrap<String> c);

	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String o) {
		this.userLastName = ComputateVertxSiteUser.staticSetUserLastName(siteRequest_, o);
	}
	public static String staticSetUserLastName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteUser userLastNameInit() {
		Wrap<String> userLastNameWrap = new Wrap<String>().var("userLastName");
		if(userLastName == null) {
			_userLastName(userLastNameWrap);
			setUserLastName(userLastNameWrap.o);
		}
		return (ComputateVertxSiteUser)this;
	}

	public static String staticSolrUserLastName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserLastName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserLastName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrUserLastName(siteRequest_, ComputateVertxSiteUser.staticSolrUserLastName(siteRequest_, ComputateVertxSiteUser.staticSetUserLastName(siteRequest_, o)));
	}

	public String sqlUserLastName() {
		return userLastName;
	}

	//////////////////
	// userFullName //
	//////////////////

	/**	 The entity userFullName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userFullName;

	/**	<br> The entity userFullName
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userFullName">Find the entity userFullName in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userFullName(Wrap<String> c);

	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String o) {
		this.userFullName = ComputateVertxSiteUser.staticSetUserFullName(siteRequest_, o);
	}
	public static String staticSetUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}
	protected ComputateVertxSiteUser userFullNameInit() {
		Wrap<String> userFullNameWrap = new Wrap<String>().var("userFullName");
		if(userFullName == null) {
			_userFullName(userFullNameWrap);
			setUserFullName(userFullNameWrap.o);
		}
		return (ComputateVertxSiteUser)this;
	}

	public static String staticSolrUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserFullName(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrUserFullName(siteRequest_, ComputateVertxSiteUser.staticSolrUserFullName(siteRequest_, ComputateVertxSiteUser.staticSetUserFullName(siteRequest_, o)));
	}

	public String sqlUserFullName() {
		return userFullName;
	}

	/////////////////
	// seeArchived //
	/////////////////

	/**	 The entity seeArchived
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean seeArchived;

	/**	<br> The entity seeArchived
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:seeArchived">Find the entity seeArchived in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _seeArchived(Wrap<Boolean> c);

	public Boolean getSeeArchived() {
		return seeArchived;
	}

	public void setSeeArchived(Boolean seeArchived) {
		this.seeArchived = seeArchived;
	}
	@JsonIgnore
	public void setSeeArchived(String o) {
		this.seeArchived = ComputateVertxSiteUser.staticSetSeeArchived(siteRequest_, o);
	}
	public static Boolean staticSetSeeArchived(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ComputateVertxSiteUser seeArchivedInit() {
		Wrap<Boolean> seeArchivedWrap = new Wrap<Boolean>().var("seeArchived");
		if(seeArchived == null) {
			_seeArchived(seeArchivedWrap);
			setSeeArchived(seeArchivedWrap.o);
		}
		return (ComputateVertxSiteUser)this;
	}

	public static Boolean staticSolrSeeArchived(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrSeeArchived(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSeeArchived(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrSeeArchived(siteRequest_, ComputateVertxSiteUser.staticSolrSeeArchived(siteRequest_, ComputateVertxSiteUser.staticSetSeeArchived(siteRequest_, o)));
	}

	public Boolean sqlSeeArchived() {
		return seeArchived;
	}

	////////////////
	// seeDeleted //
	////////////////

	/**	 The entity seeDeleted
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean seeDeleted;

	/**	<br> The entity seeDeleted
	 *  is defined as null before being initialized. 
	 * <br><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.vertx.model.user.ComputateVertxSiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:seeDeleted">Find the entity seeDeleted in Solr</a>
	 * <br>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _seeDeleted(Wrap<Boolean> c);

	public Boolean getSeeDeleted() {
		return seeDeleted;
	}

	public void setSeeDeleted(Boolean seeDeleted) {
		this.seeDeleted = seeDeleted;
	}
	@JsonIgnore
	public void setSeeDeleted(String o) {
		this.seeDeleted = ComputateVertxSiteUser.staticSetSeeDeleted(siteRequest_, o);
	}
	public static Boolean staticSetSeeDeleted(ComputateVertxSiteRequest siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected ComputateVertxSiteUser seeDeletedInit() {
		Wrap<Boolean> seeDeletedWrap = new Wrap<Boolean>().var("seeDeleted");
		if(seeDeleted == null) {
			_seeDeleted(seeDeletedWrap);
			setSeeDeleted(seeDeletedWrap.o);
		}
		return (ComputateVertxSiteUser)this;
	}

	public static Boolean staticSolrSeeDeleted(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrSeeDeleted(ComputateVertxSiteRequest siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSeeDeleted(ComputateVertxSiteRequest siteRequest_, String o) {
		return ComputateVertxSiteUser.staticSolrStrSeeDeleted(siteRequest_, ComputateVertxSiteUser.staticSolrSeeDeleted(siteRequest_, ComputateVertxSiteUser.staticSetSeeDeleted(siteRequest_, o)));
	}

	public Boolean sqlSeeDeleted() {
		return seeDeleted;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepComputateVertxSiteUser(ComputateVertxSiteRequest siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepComputateVertxSiteUser();
	}

	public Future<Void> promiseDeepComputateVertxSiteUser() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseComputateVertxSiteUser(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepComputateVertxBaseModel(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseComputateVertxSiteUser(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				userKeysInit();
				userIdInit();
				userNameInit();
				userEmailInit();
				userFirstNameInit();
				userLastNameInit();
				userFullNameInit();
				seeArchivedInit();
				seeDeletedInit();
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
		return promiseDeepComputateVertxSiteUser(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestComputateVertxSiteUser(ComputateVertxSiteRequest siteRequest_) {
			super.siteRequestComputateVertxBaseModel(siteRequest_);
	}

	public void siteRequestForClass(ComputateVertxSiteRequest siteRequest_) {
		siteRequestComputateVertxSiteUser(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainComputateVertxSiteUser(v);
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
	public Object obtainComputateVertxSiteUser(String var) {
		ComputateVertxSiteUser oComputateVertxSiteUser = (ComputateVertxSiteUser)this;
		switch(var) {
			case "userKeys":
				return oComputateVertxSiteUser.userKeys;
			case "userId":
				return oComputateVertxSiteUser.userId;
			case "userName":
				return oComputateVertxSiteUser.userName;
			case "userEmail":
				return oComputateVertxSiteUser.userEmail;
			case "userFirstName":
				return oComputateVertxSiteUser.userFirstName;
			case "userLastName":
				return oComputateVertxSiteUser.userLastName;
			case "userFullName":
				return oComputateVertxSiteUser.userFullName;
			case "seeArchived":
				return oComputateVertxSiteUser.seeArchived;
			case "seeDeleted":
				return oComputateVertxSiteUser.seeDeleted;
			default:
				return super.obtainComputateVertxBaseModel(var);
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
				o = relateComputateVertxSiteUser(v, val);
			else if(o instanceof ComputateVertxBaseModel) {
				ComputateVertxBaseModel computateVertxBaseModel = (ComputateVertxBaseModel)o;
				o = computateVertxBaseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateComputateVertxSiteUser(String var, Object val) {
		ComputateVertxSiteUser oComputateVertxSiteUser = (ComputateVertxSiteUser)this;
		switch(var) {
			default:
				return super.relateComputateVertxBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSetComputateVertxSiteUser(entityVar,  siteRequest_, o);
	}
	public static Object staticSetComputateVertxSiteUser(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "userKeys":
			return ComputateVertxSiteUser.staticSetUserKeys(siteRequest_, o);
		case "userId":
			return ComputateVertxSiteUser.staticSetUserId(siteRequest_, o);
		case "userName":
			return ComputateVertxSiteUser.staticSetUserName(siteRequest_, o);
		case "userEmail":
			return ComputateVertxSiteUser.staticSetUserEmail(siteRequest_, o);
		case "userFirstName":
			return ComputateVertxSiteUser.staticSetUserFirstName(siteRequest_, o);
		case "userLastName":
			return ComputateVertxSiteUser.staticSetUserLastName(siteRequest_, o);
		case "userFullName":
			return ComputateVertxSiteUser.staticSetUserFullName(siteRequest_, o);
		case "seeArchived":
			return ComputateVertxSiteUser.staticSetSeeArchived(siteRequest_, o);
		case "seeDeleted":
			return ComputateVertxSiteUser.staticSetSeeDeleted(siteRequest_, o);
			default:
				return ComputateVertxBaseModel.staticSetComputateVertxBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrComputateVertxSiteUser(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrComputateVertxSiteUser(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "userKeys":
			return ComputateVertxSiteUser.staticSolrUserKeys(siteRequest_, (Long)o);
		case "userId":
			return ComputateVertxSiteUser.staticSolrUserId(siteRequest_, (String)o);
		case "userName":
			return ComputateVertxSiteUser.staticSolrUserName(siteRequest_, (String)o);
		case "userEmail":
			return ComputateVertxSiteUser.staticSolrUserEmail(siteRequest_, (String)o);
		case "userFirstName":
			return ComputateVertxSiteUser.staticSolrUserFirstName(siteRequest_, (String)o);
		case "userLastName":
			return ComputateVertxSiteUser.staticSolrUserLastName(siteRequest_, (String)o);
		case "userFullName":
			return ComputateVertxSiteUser.staticSolrUserFullName(siteRequest_, (String)o);
		case "seeArchived":
			return ComputateVertxSiteUser.staticSolrSeeArchived(siteRequest_, (Boolean)o);
		case "seeDeleted":
			return ComputateVertxSiteUser.staticSolrSeeDeleted(siteRequest_, (Boolean)o);
			default:
				return ComputateVertxBaseModel.staticSolrComputateVertxBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		return staticSolrStrComputateVertxSiteUser(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrComputateVertxSiteUser(String entityVar, ComputateVertxSiteRequest siteRequest_, Object o) {
		switch(entityVar) {
		case "userKeys":
			return ComputateVertxSiteUser.staticSolrStrUserKeys(siteRequest_, (Long)o);
		case "userId":
			return ComputateVertxSiteUser.staticSolrStrUserId(siteRequest_, (String)o);
		case "userName":
			return ComputateVertxSiteUser.staticSolrStrUserName(siteRequest_, (String)o);
		case "userEmail":
			return ComputateVertxSiteUser.staticSolrStrUserEmail(siteRequest_, (String)o);
		case "userFirstName":
			return ComputateVertxSiteUser.staticSolrStrUserFirstName(siteRequest_, (String)o);
		case "userLastName":
			return ComputateVertxSiteUser.staticSolrStrUserLastName(siteRequest_, (String)o);
		case "userFullName":
			return ComputateVertxSiteUser.staticSolrStrUserFullName(siteRequest_, (String)o);
		case "seeArchived":
			return ComputateVertxSiteUser.staticSolrStrSeeArchived(siteRequest_, (Boolean)o);
		case "seeDeleted":
			return ComputateVertxSiteUser.staticSolrStrSeeDeleted(siteRequest_, (Boolean)o);
			default:
				return ComputateVertxBaseModel.staticSolrStrComputateVertxBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		return staticSolrFqComputateVertxSiteUser(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqComputateVertxSiteUser(String entityVar, ComputateVertxSiteRequest siteRequest_, String o) {
		switch(entityVar) {
		case "userKeys":
			return ComputateVertxSiteUser.staticSolrFqUserKeys(siteRequest_, o);
		case "userId":
			return ComputateVertxSiteUser.staticSolrFqUserId(siteRequest_, o);
		case "userName":
			return ComputateVertxSiteUser.staticSolrFqUserName(siteRequest_, o);
		case "userEmail":
			return ComputateVertxSiteUser.staticSolrFqUserEmail(siteRequest_, o);
		case "userFirstName":
			return ComputateVertxSiteUser.staticSolrFqUserFirstName(siteRequest_, o);
		case "userLastName":
			return ComputateVertxSiteUser.staticSolrFqUserLastName(siteRequest_, o);
		case "userFullName":
			return ComputateVertxSiteUser.staticSolrFqUserFullName(siteRequest_, o);
		case "seeArchived":
			return ComputateVertxSiteUser.staticSolrFqSeeArchived(siteRequest_, o);
		case "seeDeleted":
			return ComputateVertxSiteUser.staticSolrFqSeeDeleted(siteRequest_, o);
			default:
				return ComputateVertxBaseModel.staticSolrFqComputateVertxBaseModel(entityVar,  siteRequest_, o);
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
					o = defineComputateVertxSiteUser(v, val);
				else if(o instanceof ComputateVertxBaseModel) {
					ComputateVertxBaseModel oComputateVertxBaseModel = (ComputateVertxBaseModel)o;
					o = oComputateVertxBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineComputateVertxSiteUser(String var, Object val) {
		switch(var.toLowerCase()) {
			case "userid":
				if(val instanceof String)
					setUserId((String)val);
				saves.add("userId");
				return val;
			case "username":
				if(val instanceof String)
					setUserName((String)val);
				saves.add("userName");
				return val;
			case "useremail":
				if(val instanceof String)
					setUserEmail((String)val);
				saves.add("userEmail");
				return val;
			case "userfirstname":
				if(val instanceof String)
					setUserFirstName((String)val);
				saves.add("userFirstName");
				return val;
			case "userlastname":
				if(val instanceof String)
					setUserLastName((String)val);
				saves.add("userLastName");
				return val;
			case "userfullname":
				if(val instanceof String)
					setUserFullName((String)val);
				saves.add("userFullName");
				return val;
			case "seearchived":
				if(val instanceof Boolean)
					setSeeArchived((Boolean)val);
				saves.add("seeArchived");
				return val;
			case "seedeleted":
				if(val instanceof Boolean)
					setSeeDeleted((Boolean)val);
				saves.add("seeDeleted");
				return val;
			default:
				return super.defineComputateVertxBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrResponse.Doc doc) {
		populateComputateVertxSiteUser(doc);
	}
	public void populateComputateVertxSiteUser(SolrResponse.Doc doc) {
		ComputateVertxSiteUser oComputateVertxSiteUser = (ComputateVertxSiteUser)this;
		saves = doc.get("saves_docvalues_strings");
		if(saves != null) {
		}

		super.populateComputateVertxBaseModel(doc);
	}

	public void indexComputateVertxSiteUser(JsonObject doc) {
		if(userKeys != null) {
			for(java.lang.Long o : userKeys) {
				doc.put("userKeys_docvalues_longs", o);
			}
		}
		if(userId != null) {
			doc.put("userId_docvalues_string", userId);
		}
		if(userName != null) {
			doc.put("userName_docvalues_string", userName);
		}
		if(userEmail != null) {
			doc.put("userEmail_docvalues_string", userEmail);
		}
		if(userFirstName != null) {
			doc.put("userFirstName_docvalues_string", userFirstName);
		}
		if(userLastName != null) {
			doc.put("userLastName_docvalues_string", userLastName);
		}
		if(userFullName != null) {
			doc.put("userFullName_docvalues_string", userFullName);
		}
		if(seeArchived != null) {
			doc.put("seeArchived_docvalues_boolean", seeArchived);
		}
		if(seeDeleted != null) {
			doc.put("seeDeleted_docvalues_boolean", seeDeleted);
		}
		super.indexComputateVertxBaseModel(doc);

	}

	public static String varIndexedComputateVertxSiteUser(String entityVar) {
		switch(entityVar) {
			case "userKeys":
				return "userKeys_docvalues_longs";
			case "userId":
				return "userId_docvalues_string";
			case "userName":
				return "userName_docvalues_string";
			case "userEmail":
				return "userEmail_docvalues_string";
			case "userFirstName":
				return "userFirstName_docvalues_string";
			case "userLastName":
				return "userLastName_docvalues_string";
			case "userFullName":
				return "userFullName_docvalues_string";
			case "seeArchived":
				return "seeArchived_docvalues_boolean";
			case "seeDeleted":
				return "seeDeleted_docvalues_boolean";
			default:
				return ComputateVertxBaseModel.varIndexedComputateVertxBaseModel(entityVar);
		}
	}

	public static String varSearchComputateVertxSiteUser(String entityVar) {
		switch(entityVar) {
			default:
				return ComputateVertxBaseModel.varSearchComputateVertxBaseModel(entityVar);
		}
	}

	public static String varSuggestedComputateVertxSiteUser(String entityVar) {
		switch(entityVar) {
			default:
				return ComputateVertxBaseModel.varSuggestedComputateVertxBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrResponse.Doc doc) {
		storeComputateVertxSiteUser(doc);
	}
	public void storeComputateVertxSiteUser(SolrResponse.Doc doc) {
		ComputateVertxSiteUser oComputateVertxSiteUser = (ComputateVertxSiteUser)this;

		Optional.ofNullable((List<?>)doc.get("userKeys_docvalues_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oComputateVertxSiteUser.addUserKeys(v.toString());
		});
		oComputateVertxSiteUser.setUserId(Optional.ofNullable(doc.get("userId_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxSiteUser.setUserName(Optional.ofNullable(doc.get("userName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxSiteUser.setUserEmail(Optional.ofNullable(doc.get("userEmail_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxSiteUser.setUserFirstName(Optional.ofNullable(doc.get("userFirstName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxSiteUser.setUserLastName(Optional.ofNullable(doc.get("userLastName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxSiteUser.setUserFullName(Optional.ofNullable(doc.get("userFullName_docvalues_string")).map(v -> v.toString()).orElse(null));
		oComputateVertxSiteUser.setSeeArchived(Optional.ofNullable(doc.get("seeArchived_docvalues_boolean")).map(v -> v.toString()).orElse(null));
		oComputateVertxSiteUser.setSeeDeleted(Optional.ofNullable(doc.get("seeDeleted_docvalues_boolean")).map(v -> v.toString()).orElse(null));

		super.storeComputateVertxBaseModel(doc);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestComputateVertxSiteUser() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(ComputateVertxSiteRequest::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof ComputateVertxSiteUser) {
			ComputateVertxSiteUser original = (ComputateVertxSiteUser)o;
			if(!Objects.equals(userKeys, original.getUserKeys()))
				apiRequest.addVars("userKeys");
			if(!Objects.equals(userId, original.getUserId()))
				apiRequest.addVars("userId");
			if(!Objects.equals(userName, original.getUserName()))
				apiRequest.addVars("userName");
			if(!Objects.equals(userEmail, original.getUserEmail()))
				apiRequest.addVars("userEmail");
			if(!Objects.equals(userFirstName, original.getUserFirstName()))
				apiRequest.addVars("userFirstName");
			if(!Objects.equals(userLastName, original.getUserLastName()))
				apiRequest.addVars("userLastName");
			if(!Objects.equals(userFullName, original.getUserFullName()))
				apiRequest.addVars("userFullName");
			if(!Objects.equals(seeArchived, original.getSeeArchived()))
				apiRequest.addVars("seeArchived");
			if(!Objects.equals(seeDeleted, original.getSeeDeleted()))
				apiRequest.addVars("seeDeleted");
			super.apiRequestComputateVertxBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(Optional.ofNullable(userKeys).map(v -> "userKeys: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(userId).map(v -> "userId: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(userName).map(v -> "userName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(userEmail).map(v -> "userEmail: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(userFirstName).map(v -> "userFirstName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(userLastName).map(v -> "userLastName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(userFullName).map(v -> "userFullName: \"" + v + "\"\n" ).orElse(""));
		sb.append(Optional.ofNullable(seeArchived).map(v -> "seeArchived: " + v + "\n").orElse(""));
		sb.append(Optional.ofNullable(seeDeleted).map(v -> "seeDeleted: " + v + "\n").orElse(""));
		return sb.toString();
	}

	public static final String VAR_userKeys = "userKeys";
	public static final String VAR_userId = "userId";
	public static final String VAR_userName = "userName";
	public static final String VAR_userEmail = "userEmail";
	public static final String VAR_userFirstName = "userFirstName";
	public static final String VAR_userLastName = "userLastName";
	public static final String VAR_userFullName = "userFullName";
	public static final String VAR_seeArchived = "seeArchived";
	public static final String VAR_seeDeleted = "seeDeleted";

	public static final String DISPLAY_NAME_userKeys = "";
	public static final String DISPLAY_NAME_userId = "";
	public static final String DISPLAY_NAME_userName = "";
	public static final String DISPLAY_NAME_userEmail = "";
	public static final String DISPLAY_NAME_userFirstName = "";
	public static final String DISPLAY_NAME_userLastName = "";
	public static final String DISPLAY_NAME_userFullName = "";
	public static final String DISPLAY_NAME_seeArchived = "see archived";
	public static final String DISPLAY_NAME_seeDeleted = "see deleted";

	public static String displayNameForClass(String var) {
		return ComputateVertxSiteUser.displayNameComputateVertxSiteUser(var);
	}
	public static String displayNameComputateVertxSiteUser(String var) {
		switch(var) {
		case VAR_userKeys:
			return DISPLAY_NAME_userKeys;
		case VAR_userId:
			return DISPLAY_NAME_userId;
		case VAR_userName:
			return DISPLAY_NAME_userName;
		case VAR_userEmail:
			return DISPLAY_NAME_userEmail;
		case VAR_userFirstName:
			return DISPLAY_NAME_userFirstName;
		case VAR_userLastName:
			return DISPLAY_NAME_userLastName;
		case VAR_userFullName:
			return DISPLAY_NAME_userFullName;
		case VAR_seeArchived:
			return DISPLAY_NAME_seeArchived;
		case VAR_seeDeleted:
			return DISPLAY_NAME_seeDeleted;
		default:
			return ComputateVertxBaseModel.displayNameComputateVertxBaseModel(var);
		}
	}
}
