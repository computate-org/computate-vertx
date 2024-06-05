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
package org.computate.vertx.config;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.JinjavaConfig;
import com.hubspot.jinjava.interpret.JinjavaInterpreter;
import com.hubspot.jinjava.lib.filter.Filter;
import com.hubspot.jinjava.lib.fn.ELFunctionDefinition;

import io.kubernetes.client.common.KubernetesObject;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Secret;
import io.kubernetes.client.util.Config;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

/**
 * Keyword: classSimpleNameConfigKeys
 */
public class ComputateConfigKeys {


	public static String lookup(String type, String arg1) {
			System.out.println("JUNK");
		if("env".equals(type))
			return System.getenv(arg1);
		return null;
	}

	public static KubernetesObject[] query(String type, String kind, String resource_name, String namespace) {
		try {
			if("kubernetes.core.k8s".equals(type)) {
				ApiClient client = Config.defaultClient();
				Configuration.setDefaultApiClient(client);
				CoreV1Api api = new CoreV1Api();
				if("Secret".equals(kind)) {
					V1Secret secret = api.readNamespacedSecret(resource_name, namespace, "false");
					return new KubernetesObject[] {secret};
				}
			}
		} catch(Exception ex) {
			Logger LOG = LoggerFactory.getLogger(ComputateConfigKeys.class);
			LOG.error("kubernetes.core.k8s error", ex);
			return null;
		}
		return null;
	}

	public static JsonObject getConfig() {
		JsonObject configuration = null;

		try {
			String configChemin = System.getenv(CONFIG_VARS_PATH);
			JinjavaConfig jinjavaConfig = new JinjavaConfig();
			Jinjava jinjava = new Jinjava(jinjavaConfig);
			
			jinjava.registerFunction(new ELFunctionDefinition("", "lookup", ComputateConfigKeys.class, "lookup", String.class, String.class));
			jinjava.registerFunction(new ELFunctionDefinition("", "query", ComputateConfigKeys.class, "query", String.class, String.class, String.class, String.class));

			jinjava.registerFilter(new Filter() {
				@Override
				public String getName() {
					return "b64decode";
				}
				@Override
				public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
					try {
						if(var instanceof String) {
							return new String(Base64.getDecoder().decode(var.toString()));
						} else if(var instanceof byte[]) {
							return new String(Base64.getDecoder().decode((byte[])var), "UTF-8");
						}
					} catch(Exception ex) {
						try {
							return new String(new String((byte[])var, "UTF-8"));
						} catch(Exception ex2) {
							ExceptionUtils.rethrow(ex2);
						}
					}
					return null;
				}
			});

			jinjava.registerFilter(new Filter() {
				@Override
				public String getName() {
					return "basename";
				}
				@Override
				public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
					if(var != null) {
						return new File(var.toString()).getName();
					}
					return null;
				}
			});

			jinjava.registerFilter(new Filter() {
				@Override
				public String getName() {
					return "dirname";
				}
				@Override
				public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
					if(var != null) {
						return Paths.get(var.toString()).getParent().normalize().toAbsolutePath().toString();
					}
					return null;
				}
			});

			jinjava.registerFilter(new Filter() {
				@Override
				public String getName() {
					return "realpath";
				}
				@Override
				public Object filter(Object var, JinjavaInterpreter interpreter, String... args) {
					if(var != null) {
						return Paths.get(var.toString()).normalize().toAbsolutePath().toString();
					}
					return null;
				}
			});

			File configFichier = new File(configChemin);
			String template = Files.readString(configFichier.toPath());
			HashMap<String, Object> ctx = new HashMap<>();
			configuration = new JsonObject();
			Yaml yaml = new Yaml();
			Map<String, Object> map = yaml.load(template);
			for(String key : map.keySet()) {
				Object val = map.get(key);
				if(val instanceof String) {
					String rendered = jinjava.render(val.toString(), ctx);
					ctx.put(key, rendered);
					configuration.put(key, rendered);
				} else if(val instanceof ArrayList) {
					List<Object> list1 = (List<Object>)val;
					JsonArray list2 = new JsonArray();
					for(Object item : list1) {
						if(item instanceof String) {
							String rendered = jinjava.render(item.toString(), ctx);
							list2.add(rendered);
						} else {
							list2.add(item);
						}
						configuration.put(key, list2);
					}
				} else {
					ctx.put(key, val);
					configuration.put(key, val);
				}
			}
		} catch(Exception ex) {
			ExceptionUtils.rethrow(ex);
		}
		return configuration;
	}

	/**
	 * API counter fetch SitePage
	 */
	public static final String API_COUNTER_FETCH_SitePage = "API_COUNTER_FETCH_SitePage";

	/**
	 * API counter fetch SiteHtm
	 */
	public static final String API_COUNTER_FETCH_SiteHtm = "API_COUNTER_FETCH_SiteHtm";

	/**
	 * 
	 **/
	public static final String QUAYIO_ORG = "QUAYIO_ORG";

	/**
	 * 
	 **/
	public static final String MAILING_LIST_URL = "MAILING_LIST_URL";

	/**
	 * Run the OpenAPI3 Generator when this environment variable is set to true. 
	 **/
	public static final String RUN_OPENAPI3_GENERATOR = "RUN_OPENAPI3_GENERATOR";

	/**
	 * Run the SQL Generator when this environment variable is set to true. 
	 **/
	public static final String RUN_SQL_GENERATOR = "RUN_SQL_GENERATOR";

	/**
	 * Run the Article Generator when this environment variable is set to true. 
	 **/
	public static final String RUN_ARTICLE_GENERATOR = "RUN_ARTICLE_GENERATOR";

	/**
	 * Run the project Generator to copy platform static files and resources to the project. 
	 **/
	public static final String RUN_PROJECT_GENERATOR = "RUN_PROJECT_GENERATOR";

	/**
	 * Run the FIWARE Generator to generate Smart Model Data when this environment variable is set to true. 
	 **/
	public static final String RUN_FIWARE_GENERATOR = "RUN_FIWARE_GENERATOR";

	/**
	 * The path to the config file of the site. 
	 **/
	public static final String CONFIG_VARS_PATH = "CONFIG_VARS_PATH";

	/**
	 * The INI Configuration Object for the config file. 
	 **/
	public static final String CONFIG = "CONFIG";

	/**
	 * The cluster host name. 
	 **/
	public static final String CLUSTER_HOST_NAME = "CLUSTER_HOST_NAME";

	/**
	 * The cluster port. 
	 **/
	public static final String CLUSTER_PORT = "CLUSTER_PORT";

	/**
	 * The cluster public host name. 
	 **/
	public static final String CLUSTER_PUBLIC_HOST_NAME = "CLUSTER_PUBLIC_HOST_NAME";

	/**
	 * The cluster public port. 
	 **/
	public static final String CLUSTER_PUBLIC_PORT = "CLUSTER_PUBLIC_PORT";

	/**
	 * The hostname environment variable. 
	 **/
	public static final String HOSTNAME = "HOSTNAME";

	/**
	 * The OpenShift project. 
	 **/
	public static final String OPENSHIFT_SERVICE = "OPENSHIFT_SERVICE";

	/**
	 * The name of the principal group of settings of the config for this website. 
	 **/
	public static final String SITE_IDENTIFIER = "SITE_IDENTIFIER";

	/**
	 * The path to the project of the site cloned from git. 
	 **/
	public static final String SITE_PATH = "SITE_PATH";

	/**
	 * The path to the basic authentication properties file with users and passwords. 
	 **/
	public static final String DOC_ROOT = "DOC_ROOT";

	/**
	 * The path to the docroot for the project. 
	 **/
	public static final String COMPANY_NAME = "COMPANY_NAME";

	/**
	 * The domain name of the site. 
	 **/
	public static final String DOMAIN_NAME = "DOMAIN_NAME";

	/**
	 * The host name of the site. 
	 **/
	public static final String SITE_HOST_NAME = "SITE_HOST_NAME";

	/**
	 * The port of the site. 
	 **/
	public static final String SITE_PORT = "SITE_PORT";

	/**
	 * The number of instances of the Vertx verticle to deploy. 
	 **/
	public static final String SITE_INSTANCES = "SITE_INSTANCES";

	/**
	 * The Auth realm of the site. 
	 **/
	public static final String API_COUNTER_PAUSE = "API_COUNTER_PAUSE";

	/**
	 * 
	 **/
	public static final String API_COUNTER_RESUME = "API_COUNTER_RESUME";

	/**
	 * 
	 **/
	public static final String API_COUNTER_FETCH = "API_COUNTER_FETCH";

	/**
	 * 
	 **/
	public static final String AUTH_REALM = "AUTH_REALM";

	/**
	 * The Auth clients of the site. 
	 **/
	public static final String AUTH_CLIENTS = "AUTH_CLIENTS";

	/**
	 * The Auth client ID of the site. 
	 **/
	public static final String AUTH_CLIENT = "AUTH_CLIENT";

	/**
	 * The Auth client secret of the site. 
	 **/
	public static final String AUTH_SECRET = "AUTH_SECRET";

	/**
	 * The Auth Client callback URI
	 **/
	public static final String AUTH_CALLBACK_URI = "AUTH_CALLBACK_URI";

	/**
	 * The Auth Client logout URI
	 **/
	public static final String AUTH_LOGOUT_URI = "AUTH_LOGOUT_URI";

	/**
	 * The Auth Client OpenAPI ID
	 **/
	public static final String AUTH_OPEN_API_ID = "AUTH_OPEN_API_ID";

	/**
	 * The Auth client secret of the site. 
	 **/
	public static final String AUTH_FINE_GRAINED_POLICY_PERMISSIONS = "AUTH_FINE_GRAINED_POLICY_PERMISSIONS";

	/**
	 * Whether SSL is required in Auth for the site. 
	 **/
	public static final String AUTH_SSL_REQUIRED = "AUTH_SSL_REQUIRED";

	/**
	 * JsonArray of user roles required for an action. 
	 **/
	public static final String AUTH_ROLE_REQUIRED = "AUTH_ROLE_REQUIRED";

	/**
	 * JsonArray of user roles required for read access. 
	 **/
	public static final String AUTH_ROLE_READ_REQUIRED = "AUTH_ROLE_READ_REQUIRED";

	/**
	 * JsonArray of admin user roles. 
	 **/
	public static final String AUTH_ROLE_ADMIN = "AUTH_ROLE_ADMIN";

	/**
	 * JsonArray of super admin user roles. 
	 **/
	public static final String AUTH_ROLE_SUPER_ADMIN = "AUTH_ROLE_SUPER_ADMIN";

	/**
	 * Enable SSL Passthrough. 
	 **/
	public static final String SSL_PASSTHROUGH = "SSL_PASSTHROUGH";

	/**
	 * Whether to enable host verification otherwise trust all SSL/TLS certificates. 
	 **/
	public static final String SSL_VERIFY = "SSL_VERIFY";

	/**
	 * The path to the Java keystore for the site. 
	 **/
	public static final String SSL_JKS_PATH = "SSL_JKS_PATH";

	/**
	 * The password for the Java keystore for the site. 
	 **/
	public static final String SSL_JKS_PASSWORD = "SSL_JKS_PASSWORD";

	/**
	 * PEM Private Key path for enabling SSL
	 **/
	public static final String SSL_KEY_PATH = "SSL_KEY_PATH";

	/**
	 * PEM Public Certificate path for enabling SSL
	 **/
	public static final String SSL_CERT_PATH = "SSL_CERT_PATH";

	/**
	 * The path to the PEM key for the site. 
	 **/
	public static final String SSL_PEM_KEY_PATH = "SSL_PEM_KEY_PATH";

	/**
	 * The path to the PEM certificate for the site. 
	 **/
	public static final String SSL_PEM_CERT_PATH = "SSL_PEM_CERT_PATH";

	/**
	 * The port to the Auth server. 
	 **/
	public static final String AUTH_PORT = "AUTH_PORT";

	/**
	 * Whether the Auth server uses SSL. 
	 **/
	public static final String AUTH_SSL = "AUTH_SSL";

	/**
	 * The token URI to the Auth server. 
	 **/
	public static final String AUTH_TOKEN_URI = "AUTH_TOKEN_URI";

	/**
	 * 
	 **/
	public static final String AUTH_HOST_NAME = "AUTH_HOST_NAME";

	/**
	 * The URL of the Auth server. 
	 **/
	public static final String AUTH_URL = "AUTH_URL";

	/**
	 * The base URL for the URLs of the site. 
	 **/
	public static final String SITE_BASE_URL = "SITE_BASE_URL";

	/**
	 * The name of the site. 
	 **/
	public static final String SITE_NAME = "SITE_NAME";

	/**
	 * The path to the source code of the site. 
	 **/
	public static final String SITE_SRC = "SITE_SRC";

	/**
	 * The display name of the site. 
	 **/
	public static final String SITE_DISPLAY_NAME = "SITE_DISPLAY_NAME";

	/**
	 * 
	 **/
	public static final String SITE_PUBLIC_URL = "SITE_PUBLIC_URL";

	/**
	 * 
	 **/
	public static final String SITE_POM_GROUP_ID = "SITE_POM_GROUP_ID";

	/**
	 * 
	 **/
	public static final String SITE_POM_ARTIFACT_ID = "SITE_POM_ARTIFACT_ID";

	/**
	 * 
	 **/
	public static final String PLATFORM_POM_GROUP_ID = "PLATFORM_POM_GROUP_ID";

	/**
	 * 
	 **/
	public static final String PLATFORM_POM_ARTIFACT_ID = "PLATFORM_POM_ARTIFACT_ID";

	/**
	 * The name Github organization for the site. 
	 **/
	public static final String GITHUB_ORG = "GITHUB_ORG";

	/**
	 * The project powered by URL. 
	 **/
	public static final String SITE_POWERED_BY_URL = "SITE_POWERED_BY_URL";

	/**
	 * The project powered by organization name. 
	 **/
	public static final String SITE_POWERED_BY_NAME = "SITE_POWERED_BY_NAME";

	/**
	 * The project powered by image relative URI. 
	 **/
	public static final String SITE_POWERED_BY_IMAGE_URI = "SITE_POWERED_BY_IMAGE_URI";

	/**
	 * The class name of the JDBC driver class for the database. 
	 **/
	public static final String JDBC_DRIVER_CLASS = "JDBC_DRIVER_CLASS";

	/**
	 * The username for the database. 
	 **/
	public static final String JDBC_USERNAME = "JDBC_USERNAME";

	/**
	 * The password for the database. 
	 **/
	public static final String JDBC_PASSWORD = "JDBC_PASSWORD";

	/**
	 * The max pool size for the database. 
	 **/
	public static final String JDBC_MAX_POOL_SIZE = "JDBC_MAX_POOL_SIZE";

	/**
	 * Set the maximum connection request allowed in the wait queue, any requests beyond the max size will result in an failure. If the value is set to a negative number then the queue will be unbounded. 
	 **/
	public static final String JDBC_MAX_WAIT_QUEUE_SIZE = "JDBC_MAX_WAIT_QUEUE_SIZE";

	/**
	 * The max pool size for the database. 
	 **/
	public static final String JDBC_MIN_POOL_SIZE = "JDBC_MIN_POOL_SIZE";

	/**
	 * The max statements for the database. 
	 **/
	public static final String JDBC_MAX_STATEMENTS = "JDBC_MAX_STATEMENTS";

	/**
	 * The max statements per connection for the database. 
	 **/
	public static final String JDBC_MAX_STATEMENTS_PER_CONNECTION = "JDBC_MAX_STATEMENTS_PER_CONNECTION";

	/**
	 * The max idle time for the database. 
	 **/
	public static final String JDBC_MAX_IDLE_TIME = "JDBC_MAX_IDLE_TIME";

	/**
	 * The max idle time for the connection to the database. 
	 **/
	public static final String JDBC_CONNECT_TIMEOUT = "JDBC_CONNECT_TIMEOUT";

	/**
	 * The JDBC URL to the database. 
	 **/
	public static final String JDBC_HOST = "JDBC_HOST";

	/**
	 * The JDBC URL to the database. 
	 **/
	public static final String JDBC_PORT = "JDBC_PORT";

	/**
	 * The JDBC URL to the database. 
	 **/
	public static final String JDBC_DATABASE = "JDBC_DATABASE";

	/**
	 * The hostname to the SOLR search engine. 
	 **/
	public static final String SOLR_HOST_NAME = "SOLR_HOST_NAME";

	/**
	 * The port to the SOLR search engine. 
	 **/
	public static final String SOLR_PORT = "SOLR_PORT";

	/**
	 * The Solr collection. 
	 **/
	public static final String SOLR_COLLECTION = "SOLR_COLLECTION";

	/**
	 * Whether Solr uses SSL. 
	 **/
	public static final String SOLR_SSL = "SOLR_SSL";

	/**
	 * The hostname to the computate SOLR search engine. 
	 **/
	public static final String SOLR_HOST_NAME_COMPUTATE = "SOLR_HOST_NAME_COMPUTATE";

	/**
	 * The port to the computate SOLR search engine. 
	 **/
	public static final String SOLR_PORT_COMPUTATE = "SOLR_PORT_COMPUTATE";

	/**
	 * The computate Solr collection. 
	 **/
	public static final String SOLR_COLLECTION_COMPUTATE = "SOLR_COLLECTION_COMPUTATE";

	/**
	 * Whether computate Solr uses SSL. 
	 **/
	public static final String SOLR_SSL_COMPUTATE = "SOLR_SSL_COMPUTATE";

	/**
	 * The path to the computate source code. 
	 **/
	public static final String COMPUTATE_SRC = "COMPUTATE_SRC";

	/**
	 * The Email account for the site. 
	 **/
	public static final String ACCOUNT_EMAIL = "ACCOUNT_EMAIL";

	/**
	 * The OpenID Connect role for an administrator. 
	 **/
	public static final String ROLE_ADMIN = "ROLE_ADMIN";

	/**
	 * The OpenID Connect role for a super administrator. 
	 **/
	public static final String ROLE_SUPER_ADMIN = "ROLE_SUPER_ADMIN";

	/**
	 * The email address for the administrator of the site for the error reports. 
	 **/
	public static final String EMAIL_ADMIN = "EMAIL_ADMIN";

	/**
	 * The version of OpenAPI used with Vert.x which should probably be 3.0. 
	 **/
	public static final String OPEN_API_VERSION = "OPEN_API_VERSION";

	/**
	 * The description of your site API. 
	 **/
	public static final String API_DESCRIPTION = "API_DESCRIPTION";

	/**
	 * The title of your site API. 
	 **/
	public static final String API_TITLE = "API_TITLE";

	/**
	 * The terms of service of your site API. 
	 **/
	public static final String API_TERMS_SERVICE = "API_TERMS_SERVICE";

	/**
	 * The version of your site API. 
	 **/
	public static final String API_VERSION = "API_VERSION";

	/**
	 * The contact email of your site API. 
	 **/
	public static final String API_CONTACT_EMAIL = "API_CONTACT_EMAIL";

	/**
	 * The open source license name of your site API. 
	 **/
	public static final String API_LICENSE_NAME = "API_LICENSE_NAME";

	/**
	 * The open source license URL of your site API. 
	 **/
	public static final String API_LICENSE_URL = "API_LICENSE_URL";

	/**
	 * The host name of your site API. 
	 **/
	public static final String API_HOST_NAME = "API_HOST_NAME";

	/**
	 * The base path of your site API. 
	 **/
	public static final String API_BASE_PATH = "API_BASE_PATH";

	/**
	 * The base URL of your static files. 
	 **/
	public static final String STATIC_BASE_URL = "STATIC_BASE_URL";

	/**
	 * The path to the static files for the site. 
	 **/
	public static final String STATIC_PATH = "STATIC_PATH";

	/**
	 * The path to the handlebars template files for the site. 
	 **/
	public static final String TEMPLATE_PATH = "TEMPLATE_PATH";

	/**
	 * 
	 **/
	public static final String IMPORT_PATH = "IMPORT_PATH";

	/**
	 * The SMTP host name for sending email. 
	 **/
	public static final String EMAIL_HOST = "EMAIL_HOST";

	/**
	 * The SMTP port for sending email. 
	 **/
	public static final String EMAIL_PORT = "EMAIL_PORT";

	/**
	 * The SMTP username for sending email. 
	 **/
	public static final String EMAIL_USERNAME = "EMAIL_USERNAME";

	/**
	 * The SMTP password for sending email. 
	 **/
	public static final String EMAIL_PASSWORD = "EMAIL_PASSWORD";

	/**
	 * The from address for sending email. 
	 **/
	public static final String EMAIL_FROM = "EMAIL_FROM";

	/**
	 * Whether authentication is required for sending email. 
	 **/
	public static final String EMAIL_AUTH = "EMAIL_AUTH";

	/**
	 * Whether SSL is required for sending email. 
	 **/
	public static final String EMAIL_SSL = "EMAIL_SSL";

	/**
	 * The default timezone of the site. 
	 **/
	public static final String SITE_ZONE = "SITE_ZONE";

	/**
	 * The default locale of the site. 
	 **/
	public static final String SITE_LOCALE = "SITE_LOCALE";

	/**
	 * The max read buffer size to load in a batch. 
	 **/
	public static final String READ_BUFFER_SIZE = "READ_BUFFER_SIZE";

	/**
	 * Periodically check the sync operations to check that they are still progressing. 
	 * If not, fetch more data. 
	 **/
	public static final String API_CHECK_TIMER_MILLIS = "API_CHECK_TIMER_MILLIS";

	/**
	 * 
	 **/
	public static final String REFRESH_DATA_PAUSE_IN_SECONDS = "REFRESH_DATA_PAUSE_IN_SECONDS";

	/**
	 * 
	 **/
	public static final String ENABLE_REFRESH_DATA = "ENABLE_REFRESH_DATA";

	/**
	 * 
	 **/
	public static final String ENABLE_IMPORT_DATA = "ENABLE_IMPORT_DATA";

	/**
	 * Parse a zoned time (HH:mm VV, example: 18:12 UTC, 13:12 America/New_York, 12:12 America/Chicago). 
	 **/
	public static final String IMPORT_DATA_START_TIME = "IMPORT_DATA_START_TIME";

	/**
	 * 
	 **/
	public static final String IMPORT_DATA = "IMPORT_DATA";

	/**
	 * Parse a duration case-insensitive and add the duration to the given startDateTime. Examples:
	 * 1 YEAR, 2 Years, 3 years
	 * 1 MONTH, 2 Months, 3 months
	 * 1 WEEK, 2 Weeks, 3 weeks
	 * 1 DAY, 2 Days, 3 days
	 * 1 HOUR, 2 Hours, 3 hours
	 * 1 MINUTE, 2 Minutes, 3 minutes
	 * 1 SECONDS, 2 Seconds, 3 seconds
	 * 1 MILLISECOND, 1 milli, 2 Milliseconds, 3 millis
	 * 1 NANOSECOND, 1 nano, 2 Nanoseconds, 3 nanos
	 **/
	public static final String IMPORT_DATA_PERIOD = "IMPORT_DATA_PERIOD";

	/**
	 * 
	 **/
	public static final String WORKER_POOL_SIZE = "WORKER_POOL_SIZE";

	/**
	 * 
	 **/
	public static final String VERTX_WARNING_EXCEPTION_SECONDS = "VERTX_WARNING_EXCEPTION_SECONDS";

	/**
	 * 
	 **/
	public static final String VERTX_MAX_EVENT_LOOP_EXECUTE_TIME = "VERTX_MAX_EVENT_LOOP_EXECUTE_TIME";

	/**
	 * 
	 **/
	public static final String VERTX_MAX_WORKER_EXECUTE_TIME = "VERTX_MAX_WORKER_EXECUTE_TIME";

	/**
	 * 
	 **/
	public static final String KAFKA_ENABLED = "KAFKA_ENABLED";

	/**
	 * 
	 **/
	public static final String POSTGRES_ENABLED = "POSTGRES_ENABLED";

	/**
	 * 
	 **/
	public static final String ENABLE_ZOOKEEPER_CLUSTER = "ENABLE_ZOOKEEPER_CLUSTER";

	/**
	 * 
	 **/
	public static final String ZOOKEEPER_HOST_NAME = "ZOOKEEPER_HOST_NAME";

	/**
	 * 
	 **/
	public static final String ZOOKEEPER_PORT = "ZOOKEEPER_PORT";

	/**
	 * 
	 **/
	public static final String ZOOKEEPER_HOSTS = "ZOOKEEPER_HOSTS";

	/**
	 * 
	 * The possible value for the policy are:
	 * - exponential_backoff (default)
	 * - bounded_exponential_backoff
	 * - one_time
	 * - n_times
	 * - forever
	 * - until_elapsed
	 */
	public static final String ZOOKEEPER_RETRY_POLICY = "ZOOKEEPER_RETRY_POLICY";

	/**
	 * max number of times to retry
	 */
	public static final String ZOOKEEPER_MAX_RETRIES = "ZOOKEEPER_MAX_RETRIES";

	/**
	 * initial amount of time to wait between retries
	 */
	public static final String ZOOKEEPER_BASE_SLEEP_TIME_MILLIS = "ZOOKEEPER_BASE_SLEEP_TIME_MILLIS";

	/**
	 * max time in ms to sleep on each retry
	 */
	public static final String ZOOKEEPER_MAX_SLEEP_MILLIS = "ZOOKEEPER_MAX_SLEEP_MILLIS";

	/**
	 * Zookeeper connection timeout
	 */
	public static final String ZOOKEEPER_CONNECTION_TIMEOUT_MILLIS = "ZOOKEEPER_CONNECTION_TIMEOUT_MILLIS";

	/**
	 * Zookeeper session timeout
	 */
	public static final String ZOOKEEPER_SESSION_TIMEOUT_MILLIS = "ZOOKEEPER_SESSION_TIMEOUT_MILLIS";

	/**
	 * 
	 **/
	public static final String SOLR_WORKER_COMMIT_WITHIN_MILLIS = "SOLR_WORKER_COMMIT_WITHIN_MILLIS";

	/**
	 * 
	 **/
	public static final String VERTX_WORKER_SEND_TIMEOUT_MILLIS = "VERTX_WORKER_SEND_TIMEOUT_MILLIS";

	/**
	 * 
	 **/
	public static final String FONTAWESOME_KIT = "FONTAWESOME_KIT";

	/**
	 * 
	 **/
	public static final String DYNAMIC_PAGE_PATHS = "DYNAMIC_PAGE_PATHS";

	/**
	 * 
	 **/
	public static final String I18N_PATHS = "I18N_PATHS";

	/**
	 * Map default location. 
	 **/
	public static final String DEFAULT_MAP_LOCATION = "DEFAULT_MAP_LOCATION";

	/**
	 * Map default zoom. 
	 **/
	public static final String DEFAULT_MAP_ZOOM = "DEFAULT_MAP_ZOOM";

	/**
	 * Facebook Graph Version
	 **/
	public static final String FACEBOOK_GRAPH_VERSION = "FACEBOOK_GRAPH_VERSION";

	/**
	 * Facebook App ID
	 **/
	public static final String FACEBOOK_APP_ID = "FACEBOOK_APP_ID";

	public static final String MQTT_ENABLED = "MQTT_ENABLED";
	public static final String MQTT_HOST = "MQTT_HOST";
	public static final String MQTT_PORT = "MQTT_PORT";
	public static final String MQTT_IOT_SUBSCRIBE_TOPIC = "MQTT_IOT_SUBSCRIBE_TOPIC";

	public static final String OPEN_TELEMETRY_ENABLED = "OPEN_TELEMETRY_ENABLED";
}
