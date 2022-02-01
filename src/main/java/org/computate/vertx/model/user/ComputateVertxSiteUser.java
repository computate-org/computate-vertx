package org.computate.vertx.model.user;

import org.computate.vertx.model.base.ComputateVertxBaseModel;
import org.computate.vertx.request.ComputateVertxSiteRequest;

/**   
 * Keyword: classSimpleNameSiteUser
 */ 
public interface ComputateVertxSiteUser extends ComputateVertxBaseModel {

	void setUserName(String userName);

	void setUserFirstName(String userFirstName);

	void setUserLastName(String userLastName);

	void setUserId(String userId);

	<T extends ComputateVertxSiteRequest> void setSiteRequest_(T siteRequest);

	String getUserName();

	String getUserFirstName();

	String getUserLastName();

	void apiRequestSiteUser();

	ComputateVertxSiteRequest getSiteRequest_();

	void setInheritPk(String string);

	void setArchived(Boolean boolean1);

	Object sqlArchived();

	Object sqlInheritPk();

	void setDeleted(Boolean boolean1);

	Object sqlDeleted();

	Object sqlUserName();

	void setUserEmail(String string);

	Object sqlUserEmail();

	Object sqlUserFirstName();

	Object sqlUserLastName();

	void setUserFullName(String string);

	Object sqlUserFullName();

	void setSeeArchived(Boolean boolean1);

	Object sqlSeeArchived();

	void setSeeDeleted(Boolean boolean1);

	Object sqlSeeDeleted();

	void setPk(Long pk);

	void setCreated(String string);

	void setSessionId(String string);

	Boolean getSeeDeleted();

	Boolean getSeeArchived();
	
}
//
//import java.util.List;
//
//import org.computate.search.wrap.Wrap;
//import org.computate.vertx.model.base.BaseModel;
//
//
///**   
// * Model: true
// * Api: true
// * Page: true
// * SuperPage.enUS: BaseModelPage
// * Indexed: true
// * Map.Integer.sqlSort: 3
// * 
// * ApiTag.enUS: User
// * ApiUri.enUS: /api/user
// * 
// * ApiMethod.enUS: Search
// * ApiMethod: PATCH
// * ApiMethod: POST
// * 
// * ApiMethod.enUS: SearchPage
// * PageSearchPage.enUS: SiteUserPage
// * PageSuperSearchPage.enUS: BaseModelPage
// * ApiUriSearchPage.enUS: /user
// * 
// * Keyword: classSimpleNameSiteUser
// * Role.enUS: SiteAdmin
// * Filter: userId
// * Saves: true
// * 
// * AName.enUS: a site user
// * Color: teal
// * IconGroup: regular
// * IconName: user-cog
// * NameVar.enUS: user
// * 
// * RoleUser: true
// * Role.enUS: SiteAdmin
// */ 
//public class SiteUser extends SiteUserGen<BaseModel> {
//
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 */
//	protected void _userKeys(List<Long> l) {
//		l.add(pk);
//	}
//
//	/**   
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Define: true
//	 * Modify: false
//	 */                 
//	protected void _userId(Wrap<String> c) {
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Define: true
//	 */
//	protected void _userName(Wrap<String> c) {
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Define: true
//	 */
//	protected void _userEmail(Wrap<String> c) {
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Define: true
//	 */
//	protected void _userFirstName(Wrap<String> c) {
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Define: true
//	 */
//	protected void _userLastName(Wrap<String> c) {
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Define: true
//	 */
//	protected void _userFullName(Wrap<String> c) {
//		c.o(String.format("%s %s", userFirstName, userLastName));
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Define: true
//	 * HtmlRow: 3
//	 * HtmlCell: 2
//	 * DisplayName.enUS: see archived
//	 */
//	protected void _seeArchived(Wrap<Boolean> c) {
//		c.o(false);
//	}
//
//	/**
//	 * {@inheritDoc}
//	 * DocValues: true
//	 * Define: true
//	 * HtmlRow: 3
//	 * HtmlCell: 3
//	 * DisplayName.enUS: see deleted
//	 */
//	protected void _seeDeleted(Wrap<Boolean> c) {
//		c.o(false);
//	}
//
//	@Override
//	protected void _objectTitle(Wrap<String> c) {
//		c.o(String.format("%s (%s) <%s>", userFullName, userName, userEmail));
//	}
//}
