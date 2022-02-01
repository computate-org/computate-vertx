package org.computate.vertx.request;

import java.util.List;
import java.util.Map;

import org.computate.search.request.ComputateSearchSiteRequest;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.user.ComputateVertxSiteUser;

import io.vertx.core.MultiMap;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.sqlclient.SqlConnection;

/**
 * Keyword: classSimpleNameSiteRequest
 */
public interface ComputateVertxSiteRequest extends ComputateSearchSiteRequest {

	String getUserName();

	String getUserFullName();

	String getRequestUri();

	String getRequestMethod();

	ServiceRequest getServiceRequest();

	ComputateVertxSiteRequest copy();

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

	<T extends ComputateVertxSiteRequest> void setSiteRequest_(T siteRequest);

	void setRequestHeaders(MultiMap requestHeaders);

	void setRequestPk(Long pk);

	JsonObject getConfig();

	WebClient getWebClient();

	<T extends ComputateVertxSiteUser> T getSiteUser_(Class<T> clazz);

	User getUser();

	void setUserEmail(String string);

	void setUserId(String string);

}