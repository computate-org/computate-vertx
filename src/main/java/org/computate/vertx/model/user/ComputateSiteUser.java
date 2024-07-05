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
package org.computate.vertx.model.user;

import org.computate.vertx.model.base.ComputateBaseModel;
import org.computate.vertx.request.ComputateSiteRequest;

/**   
 * Keyword: classSimpleNameSiteUser
 */ 
public interface ComputateSiteUser extends ComputateBaseModel {

	public static final String CLASS_API_ADDRESS_ComputateSiteUser = "computate-vertx-enUS-ComputateSiteUser";
	public static String getClassApiAddress() {
		return CLASS_API_ADDRESS_ComputateSiteUser;
	}

	void setUserName(String userName);

	void setUserFirstName(String userFirstName);

	void setUserLastName(String userLastName);

	void setUserId(String userId);

	<T extends ComputateSiteRequest> void setSiteRequest_(T siteRequest);

	String getUserName();

	String getUserFirstName();

	String getUserLastName();

	void apiRequestSiteUser();

	ComputateSiteRequest getSiteRequest_();

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
