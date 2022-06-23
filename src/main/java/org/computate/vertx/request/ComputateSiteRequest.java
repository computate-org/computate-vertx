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
package org.computate.vertx.request;

import java.util.List;
import java.util.Map;

import org.computate.search.request.ComputateSearchSiteRequest;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.user.ComputateSiteUser;

import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.sqlclient.SqlConnection;

/**
 * Keyword: classSimpleNameSiteRequest
 */
public interface ComputateSiteRequest extends ComputateSearchSiteRequest {

	String getUserName();

	String getUserFullName();

	String getRequestUri();

	String getRequestMethod();

	ServiceRequest getServiceRequest();

	ComputateSiteRequest copy();

	void setJsonObject(JsonObject jsonObject);

	void setApiRequest_(ApiRequest apiRequest);

	void setUserName(String userName);

	void setUserFirstName(String userFirstName);

	void setUserLastName(String userLastName);

	void setUserKey(Long pk);

	ApiRequest getApiRequest_();

	JsonObject getJsonObject();

	SqlConnection getSqlConnection();

	List<String> getUserResourceRoles();

	List<String> getUserRealmRoles();

	Map<String, String> getRequestVars();

	void setWebClient(WebClient webClient);

	void setUser(User user);

	void setConfig(JsonObject config);

	void setServiceRequest(ServiceRequest serviceRequest);

	void initDeepForClass();

	<T extends ComputateSiteRequest> void setSiteRequest_(T siteRequest);

	void setRequestHeaders(MultiMap requestHeaders);

	JsonObject getConfig();

	WebClient getWebClient();

	<T extends ComputateSiteUser> T getSiteUser_(Class<T> clazz);

	User getUser();

	JsonObject getUserPrincipal();

	void setUserPrincipal(JsonObject userPrincipal);

	void setUserEmail(String string);

	void setUserId(String string);

}