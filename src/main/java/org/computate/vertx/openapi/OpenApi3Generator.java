package org.computate.vertx.openapi;

import org.computate.search.wrap.Wrap;
import org.computate.vertx.request.ComputateVertxSiteRequest;

import io.vertx.core.Vertx;
import io.vertx.ext.web.client.WebClient;

public class OpenApi3Generator extends OpenApi3GeneratorGen<Swagger2Generator> {

	@Override()
	protected void  _apiVersion(Wrap<String> c) {
		c.o("3.0.0");
	}

	public static void  main(String[] args) {
		Vertx vertx = Vertx.vertx();
		String configPath = System.getenv("CONFIG_PATH");
		configureConfig(vertx).onSuccess(config -> {
			OpenApi3Generator api = new OpenApi3Generator();
			WebClient webClient = WebClient.create(vertx);
			ComputateVertxSiteRequest siteRequest = ComputateVertxSiteRequest.create();
			siteRequest.setConfig(config);
			siteRequest.setWebClient(webClient);
			api.setWebClient(webClient);
			api.setConfig(config);
			siteRequest.initDeepSiteRequest();
			api.initDeepOpenApi3Generator(siteRequest);
			api.writeOpenApi().onSuccess(a -> {
				LOG.info("Write OpenAPI completed. ");
				vertx.close();
			}).onFailure(ex -> {
				LOG.error("Write OpenAPI failed. ", ex);
				vertx.close();
			});
			
		}).onFailure(ex -> {
			LOG.error(String.format("Error loading config: %s", configPath), ex);
			vertx.close();
		});
	}
}
