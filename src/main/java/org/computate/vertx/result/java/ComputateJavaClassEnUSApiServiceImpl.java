package org.computate.vertx.result.java;

import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.search.list.SearchList;

import io.vertx.core.WorkerExecutor;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authorization.AuthorizationProvider;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.templ.handlebars.HandlebarsTemplateEngine;
import io.vertx.pgclient.PgPool;

/**
 * Translate: false
 **/
public class ComputateJavaClassEnUSApiServiceImpl extends ComputateJavaClassEnUSGenApiServiceImpl {

	public ComputateJavaClassEnUSApiServiceImpl(EventBus eventBus, JsonObject config, WorkerExecutor workerExecutor, PgPool pgPool, WebClient webClient, OAuth2Auth oauth2AuthenticationProvider, AuthorizationProvider authorizationProvider, HandlebarsTemplateEngine templateEngine) {
		super(eventBus, config, workerExecutor, pgPool, webClient, oauth2AuthenticationProvider, authorizationProvider, templateEngine);
	}

	@Override
	public void searchComputateJavaClass2(ComputateSiteRequest siteRequest, Boolean populate, Boolean store,
			Boolean modify, SearchList<ComputateJavaClass> searchList) {
		super.searchComputateJavaClass2(siteRequest, populate, store, modify, searchList);

		String solrHostName = siteRequest.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME);
		Integer solrPort = siteRequest.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT);
		String solrCollection = "computate";
//		String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, request.getQueryString());
//		w.o(String.format("http://%s:%s%s", "localhost", solrPort, solrRequestUri));
		searchList.setSearchUrl(null);
	}
}
