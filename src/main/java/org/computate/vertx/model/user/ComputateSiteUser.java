/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
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

	void setCustomerProfileId(String customerProfileId);
	String getCustomerProfileId();

	void setUserName(String userName);

	void setUserFirstName(String userFirstName);

	void setUserLastName(String userLastName);

	void setUserId(String userId);

	<T extends ComputateSiteRequest> void setSiteRequest_(T siteRequest);

	String getUserId();

	String getUserEmail();

	String getUserName();

	String getUserFirstName();

	String getUserLastName();

	String getUserFullName();

	void apiRequestSiteUser();

	ComputateSiteRequest getSiteRequest_();

	void setArchived(Boolean boolean1);

	Object sqlArchived();

	Object sqlUserName();

	void setUserEmail(String string);

	Object sqlUserEmail();

	Object sqlUserFirstName();

	Object sqlUserLastName();

	void setUserFullName(String string);

	Object sqlUserFullName();

	void setSeeArchived(Boolean boolean1);

	Object sqlSeeArchived();

	void setPk(Long pk);

	void setCreated(String string);

	void setSessionId(String string);

	Boolean getSeeArchived();
}
