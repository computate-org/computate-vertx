package org.computate.vertx.request;

import org.computate.search.request.ComputateSearchSiteRequest;
import org.computate.vertx.api.ApiRequest;
import org.computate.vertx.model.user.ComputateVertxSiteUser;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.User;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.ext.web.client.WebClient;
import io.vertx.sqlclient.Pool;

/**
 * Keyword: classSimpleNameSiteRequest
 */
public interface ComputateVertxSiteRequest extends ComputateSearchSiteRequest {

	JsonObject getConfig();

	ComputateVertxSiteRequest copy();

	void setJsonObject(JsonObject jsonObject);

	void initDeepSiteRequest(ComputateVertxSiteRequest siteRequest);

	void setApiRequest_(ApiRequest apiRequest);

	void setWebClient(WebClient webClient);

	void setUser(User user);

	void setConfig(JsonObject config);

	void setServiceRequest(ServiceRequest serviceRequest);

	void setUserName(String userName);

	void setUserFirstName(String userFirstName);

	void setUserLastName(String userLastName);

	void setUserKey(Long pk);

	ApiRequest getApiRequest_();

	JsonObject getJsonObject();

	Pool getSqlConnection();

	String getUserName();

	String getUserFullName();

	String getRequestUri();

	String getRequestMethod();

	ServiceRequest getServiceRequest();

	WebClient getWebClient();

	ComputateVertxSiteUser getSiteUser_();

	void initDeepSiteRequest();
}
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.commons.lang3.StringUtils;
//import org.computate.search.request.ComputateSearchSiteRequest;
//import org.computate.search.wrap.Wrap;
//import org.computate.vertx.api.ApiRequest;
//import org.computate.vertx.model.user.ComputateVertxSiteUser;
//
//import io.vertx.core.MultiMap;
//import io.vertx.core.json.JsonArray;
//import io.vertx.core.json.JsonObject;
//import io.vertx.ext.auth.User;
//import io.vertx.ext.web.api.service.ServiceRequest;
//import io.vertx.ext.web.client.WebClient;
//import io.vertx.sqlclient.SqlConnection;
//
///**
// * Keyword: classSimpleNameSiteRequest
// */
//public class SiteRequest extends SiteRequestGen<Object> implements ComputateSearchSiteRequest {
//
//	private static final Pattern PATTERN_SESSION = Pattern.compile(".*vertx-web.session=(\\w+).*");
//
//	/**	
//	 *	The site configuration. 
//	 **/
//	protected void _config(Wrap<JsonObject> c) {
//	}
//
//	protected void _siteRequest_(Wrap<SiteRequest> c) { 
//		c.o(this);
//	}
//
//	protected void _webClient(Wrap<WebClient> c) { 
//	}
//
//	protected void _apiRequest_(Wrap<ApiRequest> c) { 
//	}
//
//	protected void _jsonObject(Wrap<JsonObject> c) {
//	}
//
//	protected void _serviceRequest(Wrap<ServiceRequest> c) {
//	}
//
//	protected void _user(Wrap<User> c) {
//	}
//
//	protected void _userId(Wrap<String> c) {
//		if(user != null) {
//			String o = user.attributes().getString("sub");
//			c.o(o);
//		}
//	}
//
//	protected void _userKey(Wrap<Long> c) {
//	}
//
//	protected void _sessionId(Wrap<String> c) {
//		if(serviceRequest != null) {
//			String cookie = serviceRequest.getHeaders().get("Cookie");
//			if(StringUtils.isNotBlank(cookie)) {
//				Matcher m = PATTERN_SESSION.matcher(cookie);
//				if(m.matches()) {
//					c.o(m.group(1));
//				}
//			}
//		}
//	}
//
//	protected void _sessionIdBefore(Wrap<String> c) {
//		if(serviceRequest != null) {
//			c.o(Optional.ofNullable(serviceRequest).map(r -> r.getParams()).map(p -> p.getJsonObject("cookie")).map(cookie -> cookie.getString("sessionIdBefore")).orElse(null));
//		}
//	}
//
//	protected void _userName(Wrap<String> c) {
//		if(user != null) {
//			String o = user.attributes().getJsonObject("accessToken").getString("preferred_username");
//			c.o(o);
//		}
//	}
//
//	protected void _userLastName(Wrap<String> c) {
//		if(user != null) {
//			String o = user.attributes().getJsonObject("accessToken").getString("family_name");
//			c.o(o);
//		}
//	}
//
//	protected void _userFirstName(Wrap<String> c) { 
//		if(user != null) {
//			String o = user.attributes().getJsonObject("accessToken").getString("given_name");
//			c.o(o);
//		}
//	}
//
//	protected void _userFullName(Wrap<String> c) {
//		if(user != null) {
//			String o = user.attributes().getJsonObject("accessToken").getString("name");
//			c.o(o);
//		}
//	}
//
//	protected void _userEmail(Wrap<String> c) {
//		if(user != null) {
//			String o = user.attributes().getJsonObject("accessToken").getString("email");
//			c.o(o);
//		}
//	}
//
//	protected void _userRealmRoles(List<String> o) {
//		JsonArray roles = Optional.ofNullable(user).map(user -> user.attributes()).map(attributes -> attributes.getJsonObject("accessToken")).map(o1 -> o1.getJsonObject("realm_access")).map(o2 -> o2.getJsonArray("roles")).orElse(new JsonArray());
//		roles.stream().forEach(r -> {
//			addUserRealmRoles((String)r);
//		});
//	}
//
//	protected void _userResource(Wrap<JsonObject> c) {
//		String authResource = config.getString("authResource");
//		JsonObject o = Optional.ofNullable(user).map(user -> user.attributes()).map(p -> p.getJsonObject("resource_access")).map(o1 -> o1.getJsonObject(authResource)).orElse(new JsonObject());
//		c.o(o);
//	}
//
//	protected void _userResourceRoles(List<String> o) {
//		JsonArray roles = Optional.ofNullable(userResource).map(o2 -> o2.getJsonArray("roles")).orElse(new JsonArray());
//		roles.stream().forEach(r -> {
//			addUserResourceRoles((String)r);
//		});
//	}
//
//	protected void _siteUser_(Wrap<ComputateVertxSiteUser> c) { 
//		if(userId != null) {
//			ComputateVertxSiteUser o = new ComputateVertxSiteUser();
//			o.setUserName(userName);
//			o.setUserFirstName(userFirstName);
//			o.setUserLastName(userLastName);
//			o.setUserId(userId);
//			c.o(o);
//		}
//	}
//
//	protected void _solrDocument(Wrap<JsonObject> c) {  
//	}
//
//	protected void _pageAdmin(Wrap<Boolean> c) { 
//		c.o(false);
//	}
//
//	protected void _requestPk(Wrap<Long> c) {
//		if(serviceRequest != null)
//			c.o(serviceRequest.getParams().getLong("pk"));
//	}
//
//	protected void _requestUri(Wrap<String> c) {
//		c.o(Optional.ofNullable(serviceRequest).map(r -> r.getExtra()).map(extra -> extra.getString("uri")).orElse(null));
//	}
//
//	protected void _requestMethod(Wrap<String> c) {
//		c.o(Optional.ofNullable(serviceRequest).map(r -> r.getExtra()).map(extra -> extra.getString("method")).orElse(null));
//	}
//
//	protected void _sqlConnection(Wrap<SqlConnection> c) {
//	}
//
//	protected void _requestHeaders(Wrap<MultiMap> c) {
//	}
//
//	protected void _requestVars(Map<String, String> m) {
//	}
//
//	public SiteRequest copy() {
//		SiteRequest o = new SiteRequest();
//		o.setJsonObject(jsonObject); // for copying the original data in the request
//		o.setConfig(config); // for site configuration info
//		o.setWebClient(webClient); // for performing searches
//		o.setServiceRequest(serviceRequest);  // for info about the original request
//		o.setUser(user); // The user principal
//		o.setUserKey(userKey); // The user primary key
//		o.setUserId(userId); // The user identifier in the authentication system
//		o.setApiRequest_(apiRequest_); // The current API request information
//		return o;
//	}
//}
