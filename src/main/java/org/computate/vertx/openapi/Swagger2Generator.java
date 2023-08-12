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
package org.computate.vertx.openapi;

import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.computate.enus.ComputateEnUSClass;
import org.computate.search.request.SearchRequest;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.response.solr.SolrResponse.Doc;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.writer.AllWriter;
import org.computate.vertx.writer.ApiWriter;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClient;

public class Swagger2Generator extends Swagger2GeneratorGen<Object> {

	/**	
	 * Val.Complete.enUS:The config was configured successfully. 
	 * Val.Fail.enUS:Could not configure the config(). 
	 **/
	public static Future<JsonObject> configureConfig(Vertx vertx) {
		Promise<JsonObject> promise = Promise.promise();

		try {
			ConfigRetrieverOptions retrieverOptions = new ConfigRetrieverOptions();

			retrieverOptions.addStore(new ConfigStoreOptions().setType("file").setFormat("yaml").setConfig(new JsonObject().put("path", Thread.currentThread().getContextClassLoader().getResource("application.yml").getPath())));

			String configPath = System.getenv(ComputateConfigKeys.CONFIG_PATH);
			if(StringUtils.isNotBlank(configPath)) {
				ConfigStoreOptions configIni = new ConfigStoreOptions().setType("file").setFormat("yaml").setConfig(new JsonObject().put("path", configPath));
				retrieverOptions.addStore(configIni);
			}

			ConfigStoreOptions storeEnv = new ConfigStoreOptions().setType("env");
			retrieverOptions.addStore(storeEnv);

			ConfigRetriever configRetriever = ConfigRetriever.create(vertx, retrieverOptions);
			configRetriever.getConfig().onSuccess(config -> {
				LOG.info("The config was configured successfully. ");
				promise.complete(config);
			}).onFailure(ex -> {
				LOG.error("Unable to configure site context. ", ex);
				promise.fail(ex);
			});
		} catch(Exception ex) {
			LOG.error("Unable to configure site context. ", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	protected void _vertx_(Wrap<Vertx> w) {
	}

	protected void _webClient(Wrap<WebClient> w) {
	}

	protected void _siteRequest_(Wrap<ComputateSiteRequest> c) {
	}

	protected void _config(Wrap<JsonObject> c) {
	}

	protected void _appName(Wrap<String> c) {
		c.o(config.getString(ComputateConfigKeys.SITE_NAME));
	}

	protected void _languageName(Wrap<String> c) {
		c.o("enUS");
	}

	protected void _appPath(Wrap<String> c) {
		c.o(config.getString(ComputateConfigKeys.SITE_PATH + "_" + languageName));
	}

	protected void _openApiVersion(Wrap<String> c) {
		c.o(config.getString(ComputateConfigKeys.OPEN_API_VERSION, "3.0"));
	}

	protected void _openApiVersionNumber(Wrap<Integer> c) {
		c.o((int)Double.parseDouble(StringUtils.substringBefore(openApiVersion, ".")));
	}

	protected void _tabsSchema(Wrap<Integer> c) {
		if(openApiVersionNumber == 2)
			c.o(1);
		else
			c.o(2);
	}

	protected void _apiVersion(Wrap<String> c) {
		c.o(config.getString(ComputateConfigKeys.API_VERSION));
	}

	protected void _openApiYamlPath(Wrap<String> c) {
		c.o(appPath + "/src/main/resources/webroot/" + ("2.0".equals(apiVersion) ? "swagger2" : "openapi3") + "-enUS.yml");
	}

	protected void _openApiYamlFile(Wrap<File> c) {
		c.o(new File(openApiYamlPath));
	}

	protected void _sqlCreatePath(Wrap<String> c) {
		c.o(appPath + "/src/main/resources/sql/db-create.sql");
	}

	protected void _sqlCreateFile(Wrap<File> c) {
		c.o(new File(sqlCreatePath));
	}

	protected void _sqlDropPath(Wrap<String> c) {
		c.o(appPath + "/src/main/resources/sql/db-drop.sql");
	}

	protected void _sqlDropFile(Wrap<File> c) {
		c.o(new File(sqlDropPath));
	}

	protected void _articleYamlPath(Wrap<String> c) {
		c.o(appPath + "/src/main/resources/article.yml");
	}

	protected void _articleYamlFile(Wrap<File> c) {
		c.o(new File(articleYamlPath));
	}

	protected void _w(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, openApiYamlFile, "  "));
	}

	protected void _wSqlCreate(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, sqlCreateFile, "  "));
	}

	protected void _wSqlDrop(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, sqlDropFile, "  "));
	}

	protected void _wArticle(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, articleYamlFile, "  "));
	}

	protected void _fiwareSwaggerYamlPath(Wrap<String> c) {
		c.o(appPath + "-static/fiware/swagger.yaml");
	}
	protected void _fiwareSwaggerYamlFile(Wrap<File> c) {
		c.o(new File(fiwareSwaggerYamlPath));
	}
	protected void _wFiwareSwagger(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, fiwareSwaggerYamlFile, "  "));
	}
	protected void _wFiwareExamples(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}
	protected void _wFiwareExamplesNormalized(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _fiwareContext(JsonObject o) {
	}
	protected void _fiwareContextJsonldPath(Wrap<String> c) {
		c.o(appPath + "-static/fiware/context.jsonld");
	}
	protected void _fiwareContextJsonldFile(Wrap<File> c) {
		c.o(new File(fiwareContextJsonldPath));
	}
	protected void _wFiwareContext(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, fiwareContextJsonldFile, "  "));
	}

	protected void _wPaths(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wRequestBodies(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wSchemas(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	public Future<Void> writeOpenApi() {
		Promise<Void> promise = Promise.promise();

		writeInfo();
		writeApi().onSuccess(a -> {
			w.s(wPaths.toString());
			w.s(wRequestBodies.toString());
			w.s(wSchemas.toString());
			w.flushClose();
			promise.complete();
		}).onFailure(ex -> {
			w.flushClose();
			promise.fail(ex);
		});

		return promise.future();
	}

	public void  writeInfo() {

		if(openApiVersionNumber == 2)
			wPaths.l("swagger: \"", apiVersion, "\"");
		else
			wPaths.l("openapi: ", apiVersion);

		wPaths.l("info:");

		wPaths.t(1, "title: ").string(config.getString(ComputateConfigKeys.API_TITLE)).l();
//		wPaths.t(1, "description: ").yamlStr(2, siteConfig.getApiDescription());
		if(openApiVersionNumber == 2) {
			wPaths.t(1, "version: ").string(apiVersion).l();
		}
		else if(openApiVersionNumber > 2) {
			wPaths.tl(1, "version: ", apiVersion);
		}
	}

	/**
	 * 
	 * Val.Error.enUS:An error occured while writing the API. 
	 * Val.Error2.enUS:An error occured while writing the API. 
	 */
	public Future<Void> writeApi() {
		Promise<Void> promise = Promise.promise();

		try {
			wPaths.tl(0, "paths:");
			wPaths.l();
			wPaths.tl(1, "/callback:");
			wPaths.tl(2, "get:");
			wPaths.tl(3, "operationId: callback");
			wPaths.tl(3, "x-vertx-event-bus: ", appName, "-", languageName, "-callback");
			wPaths.tl(3, "description: >+");
			wPaths.tl(3, "responses:");
			wPaths.tl(4, "'200':");
			wPaths.tl(5, "description: >+");
			wPaths.tl(5, "content:");
			wPaths.tl(6, "application/json; charset=utf-8:");
			wPaths.tl(7, "schema:");
			wPaths.tl(8, "type: string");
			wPaths.l();
			wPaths.tl(1, "/logout:");
			wPaths.tl(2, "get:");
			wPaths.tl(3, "operationId: logout");
			wPaths.tl(3, "x-vertx-event-bus: ", appName, "-", languageName, "-logout");
			wPaths.tl(3, "description: >+");
			wPaths.tl(3, "responses:");
			wPaths.tl(4, "'200':");
			wPaths.tl(5, "description: >+");
			wPaths.tl(5, "content:");
			wPaths.tl(6, "application/json; charset=utf-8:");
			wPaths.tl(7, "schema:");
			wPaths.tl(8, "type: string");
			wPaths.l();

			if(openApiVersionNumber == 2) {
				wSchemas.tl(0, "definitions:");
			}
			else {
				wRequestBodies.tl(0, "components:");
				if(config.getString(ComputateConfigKeys.AUTH_URL) != null) {
					wRequestBodies.tl(1, "securitySchemes:");
						wRequestBodies.tl(2, "openIdConnect:");
						wRequestBodies.tl(3, "type: openIdConnect");
						wRequestBodies.tl(3, "openIdConnectUrl: ", config.getString(ComputateConfigKeys.AUTH_URL), "/realms/", config.getString(ComputateConfigKeys.AUTH_REALM), "/.well-known/openid-configuration");
				}
				wRequestBodies.tl(1, "requestBodies:");

				wSchemas.tl(1, "schemas:");
			}

			loadClasses().onSuccess(classDoc -> {
				LOG.info("Write OpenAPI completed. ");
				promise.complete();
			}).onFailure(ex -> {
				LOG.error("Write OpenAPI failed. ", ex);
				promise.fail(ex);
			});

		} catch (Exception ex) {
			LOG.error("Write OpenAPI failed. ", ex);
			LOG.error(writeApiError, ex);
		}

		return promise.future();
	}

	public Future<Void> loadClasses() {
		Promise<Void> promise = Promise.promise();

		try {
			SearchRequest searchClasses = new SearchRequest();
			searchClasses.q("*:*");
			searchClasses.rows(1000000);
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchClasses.fq("classeApi_indexed_boolean:true");
			searchClasses.fq("classeEtendGen_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.sortAsc("classeNomCanonique_enUS_indexed_string");
			searchClasses.sortAsc("partNumero_indexed_int");
			searchClasses.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					loadClass(queryResponse.getResponse().getDocs(), 0).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception ex) {
			promise.fail(ex);
		}

		return promise.future();
	}

	public Future<Void> loadClass(List<SolrResponse.Doc> docs, Integer i) {
		Promise<Void> promise = Promise.promise();
		if(docs.size() >= (i + 1)) {
			SolrResponse.Doc doc = docs.get(i);
			ComputateEnUSClass classDoc = JsonObject.mapFrom(doc.getFields()).mapTo(ComputateEnUSClass.class);
			List<ApiWriter> apiWriters = new ArrayList<>();

			ArrayList<String> classUris = new ArrayList<>();

			for(String classApiMethode : classDoc.getClassApiMethods()) {
				ApiWriter apiWriter = new ApiWriter();
				apiWriter.setClassSolrDocument(doc);
				apiWriter.setClassApiMethod(classApiMethode);
				apiWriter.setContextRows(classDoc.getContextRows());
				apiWriter.setWPaths(wPaths);
				apiWriter.setWRequestBodies(wRequestBodies);
				apiWriter.setWSchemas(wSchemas);
				apiWriter.setOpenApiVersion(openApiVersion);
				apiWriter.setClassUris(classUris);
				apiWriter.initDeepApiWriter(siteRequest_);
				apiWriters.add(apiWriter);
			}
			Collections.sort(apiWriters);
			loadEntities(classDoc, apiWriters).onSuccess(a -> {
				try {
					for(ApiWriter apiWriter : apiWriters) {
						apiWriter.getWriters().flushClose();
						apiWriter.writeApi(false);
					}

					for(ApiWriter apiWriter : apiWriters) {
						apiWriter.getWResponseDescription().flushClose();
					}
					loadClass(docs, i + 1).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error("loadClass failed", ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
		return promise.future();
	}

	public Future<List<SolrResponse.Doc>> loadEntities(ComputateEnUSClass classDoc, List<ApiWriter> apiWriters) {
		Promise<List<SolrResponse.Doc>> promise = Promise.promise();

		try {
			SearchRequest searchEntities = new SearchRequest();
			searchEntities.q("*:*");
			searchEntities.rows(1000000);
			searchEntities.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchEntities.fq("classeCheminAbsolu_indexed_string:" + SearchTool.escapeQueryChars(classDoc.getClassAbsolutePath()));
			searchEntities.fq("partEstEntite_indexed_boolean:true");
			searchEntities.sortAsc("partNumero_indexed_int");
			searchEntities.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchEntities.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					List<SolrResponse.Doc> searchEntitiesResults = queryResponse.getResponse().getDocs();

					Long searchEntitesLines = queryResponse.getResponse().getNumFound();

					for(Long k = searchEntities.getStart(); k < queryResponse.getResponse().getNumFound(); k+=searchEntitesLines) {
						for(Integer l = 0; l < searchEntitiesResults.size(); l++) {
							for(ApiWriter apiWriter : apiWriters) {
								SolrResponse.Doc entiteDocumentSolr = searchEntitiesResults.get(l);

								apiWriter.initEntity(entiteDocumentSolr);
								apiWriter.writeEntityHeaders();
								apiWriter.writeEntitySchema(null);
							}
						}
					}

					promise.complete(searchEntitiesResults);
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception e) {
			ExceptionUtils.rethrow(e);
		}

		return promise.future();
	}

	public Future<Void> loadSql1() {
		Promise<Void> promise = Promise.promise();

		try {
			SearchRequest searchClasses = new SearchRequest();
			searchClasses.q("*:*");
			searchClasses.rows(1000000);
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchClasses.fq("classeSauvegarde_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.fq("classeEstBase_indexed_boolean:false");
			searchClasses.sortAsc("sqlSort_indexed_int");
			searchClasses.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					loadSql1(queryResponse.getResponse().getDocs(), 0).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception ex) {
			promise.fail(ex);
		}

		return promise.future();
	}

	public Future<Void> loadSql1(List<SolrResponse.Doc> docs, Integer i) {
		Promise<Void> promise = Promise.promise();

		try {
			if(docs.size() >= (i + 1)) {
				SolrResponse.Doc doc1 = docs.get(i);
				String langueNom = "enUS";
	
				List<String> classeEntiteClassesSuperEtMoiSansGen = doc1.get("entiteClassesSuperEtMoiSansGen_stored_strings");
				String fqClassesSuperEtMoi = "(" + classeEntiteClassesSuperEtMoiSansGen.stream().map(c -> SearchTool.escapeQueryChars(c)).collect(Collectors.joining(" OR ")) + ")";

				SearchRequest searchClasses = new SearchRequest();
				searchClasses.q("*:*");
				searchClasses.rows(1000000);
				searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
				searchClasses.fq("classeNomCanonique_" + langueNom + "_indexed_string:" + fqClassesSuperEtMoi);
				searchClasses.fq("partEstEntite_indexed_boolean:true");
				searchClasses.fq("-(entiteAttribuer_indexed_boolean:true AND entiteTypeJson_indexed_string:array)");
				searchClasses.fq("(entiteAttribuer_indexed_boolean:true OR entiteDefinir_indexed_boolean:true OR entiteClePrimaire_indexed_boolean:true)");
				searchClasses.sortAsc("classeEstBase_indexed_boolean");
				searchClasses.sortAsc("partNumero_indexed_int");
				searchClasses.initDeepForClass(siteRequest_);
	
				String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
				Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
				String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
				Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
				String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
				siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).send().onSuccess(a -> {
					try {
						SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
	
						String classeNomSimple = (String)doc1.get("classeNomSimple_" + langueNom + "_stored_string");
						wSqlDrop.l("DROP TABLE ", classeNomSimple, " CASCADE;");
						wSqlCreate.l();
						wSqlCreate.l("CREATE TABLE IF NOT EXISTS ", classeNomSimple, "();");

						List<Doc> entiteDocs = queryResponse.getResponse().getDocs();
						for(Integer j = 0; j < entiteDocs.size(); j++) {
							SolrResponse.Doc doc2 = entiteDocs.get(j);
							if(doc2.get("entiteAttribuerTypeJson_stored_string") != null && (((String)doc2.get("entiteVar_" + langueNom + "_stored_string")).compareTo((String)doc2.get("entiteAttribuerVar_" + langueNom + "_stored_string")) < 0 || "array".equals(doc2.get("entiteAttribuerTypeJson_stored_string"))) || doc2.get("entiteAttribuerTypeJson_stored_string") == null) {
								wSqlCreate.s("ALTER TABLE ", classeNomSimple, " ADD COLUMN IF NOT EXISTS ");
								wSqlCreate.s(doc2.get("entiteVar_" + langueNom + "_stored_string"), " ", doc2.get("entiteTypeSql_stored_string"));
								if(doc2.get("entiteAttribuerTypeJson_stored_string") != null)
									wSqlCreate.s(" references ", (String)doc2.get("entiteAttribuerNomSimple_" + langueNom + "_stored_string"), "(pk)");
								wSqlCreate.l(";");
							}
						}
	
						loadSql1(docs, i + 1).onSuccess(b -> {
							promise.complete();
						}).onFailure(ex -> {
							promise.fail(ex);
						});
					} catch(Exception ex) {
						LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
						promise.fail(ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("Search failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error("Could not load SQL. ", ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> loadSql2() {
		Promise<Void> promise = Promise.promise();

		try {
			SearchRequest searchClasses = new SearchRequest();
			searchClasses.q("*:*");
			searchClasses.rows(1000000);
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchClasses.fq("partEstEntite_indexed_boolean:true");
			searchClasses.fq("entiteTypeJson_indexed_string:array");
			searchClasses.fq("entiteAttribuerTypeJson_indexed_string:array");
			searchClasses.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					loadSql2(queryResponse.getResponse().getDocs(), 0).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception ex) {
			promise.fail(ex);
		}

		return promise.future();
	}

	public Future<Void> loadSql2(List<SolrResponse.Doc> docs, Integer i) {
		Promise<Void> promise = Promise.promise();

		try {
			if(docs.size() >= (i + 1)) {
				String langueNom = "enUS";
				SolrResponse.Doc doc1 = docs.get(i);
				String var = doc1.get("entiteVar_" + langueNom + "_stored_string");
				String varAttribuer = doc1.get("entiteAttribuerVar_" + langueNom + "_stored_string");

				if(var.compareTo(varAttribuer) < 0) {
					String c1 = doc1.get("classeNomSimple_" + langueNom + "_stored_string");
					String c2 = doc1.get("entiteAttribuerNomSimple_" + langueNom + "_stored_string");

					wSqlDrop.l("DROP TABLE ", c1, StringUtils.capitalize(var), "_", c2, StringUtils.capitalize(varAttribuer), " CASCADE;");
					wSqlCreate.l("CREATE TABLE IF NOT EXISTS ", c1, StringUtils.capitalize(var), "_", c2, StringUtils.capitalize(varAttribuer), "(");
					wSqlCreate.tl(1, "pk bigserial primary key");
					wSqlCreate.tl(1, ", pk1 bigint references ", c1, "(pk)");
					wSqlCreate.tl(1, ", pk2 bigint references ", c2, "(pk)");
					wSqlCreate.tl(1, ");");
					wSqlCreate.l("CREATE UNIQUE INDEX IF NOT EXISTS ", c1, StringUtils.capitalize(var), "_", c2, StringUtils.capitalize(varAttribuer), "_pk1_pk2 ON ", c1, StringUtils.capitalize(var), "_", c2, StringUtils.capitalize(varAttribuer), "(pk1, pk2);");
				}

				loadSql2(docs, i + 1).onSuccess(b -> {
					promise.complete();
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error("Could not load SQL. ", ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	public Future<Void> writeSql() {
		Promise<Void> promise = Promise.promise();

		loadSql1().onSuccess(a -> {
			loadSql2().onSuccess(b -> {
				wSqlCreate.flushClose();
				wSqlDrop.flushClose();
				LOG.info("Write SQL completed. ");
				promise.complete();
			}).onFailure(ex -> {
				wSqlCreate.flushClose();
				wSqlDrop.flushClose();
				LOG.error("Write SQL failed. ", ex);
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			wSqlCreate.flushClose();
			wSqlDrop.flushClose();
			LOG.error("Write SQL failed. ", ex);
			promise.fail(ex);
		});

		return promise.future();
	}

	public Future<Void> loadArticle() {
		Promise<Void> promise = Promise.promise();

		try {
			SearchRequest searchClasses = new SearchRequest();
			searchClasses.q("*:*");
			searchClasses.rows(1000000);
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchClasses.fq("article_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.sortAsc("classeNomCanonique_enUS_indexed_string");
			searchClasses.sortAsc("partNumero_indexed_int");
			searchClasses.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					loadArticle(queryResponse.getResponse().getDocs(), 0).onSuccess(b -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error("Write Articles failed. ", ex);
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception ex) {
			LOG.error("Write Articles failed. ", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	public Future<Void> loadArticle(List<SolrResponse.Doc> docs, Integer i) {
		Promise<Void> promise = Promise.promise();
		if(docs.size() >= (i + 1)) {
			SolrResponse.Doc doc = docs.get(i);
			ComputateEnUSClass classDoc = JsonObject.mapFrom(doc.getFields()).mapTo(ComputateEnUSClass.class);
			wArticle.l("- ", classDoc.getClassCanonicalName());
			loadArticle(docs, i + 1).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
		return promise.future();
	}

	public Future<Void> writeArticle() {
		Promise<Void> promise = Promise.promise();

		loadArticle().onSuccess(a -> {
			wArticle.flushClose();
			LOG.info("Write Articles completed. ");
			promise.complete();
		}).onFailure(ex -> {
			wArticle.flushClose();
			LOG.error("Write Articles failed. ", ex);
			promise.fail(ex);
		});

		return promise.future();
	}

	public Future<Void> writeFiware() {
		Promise<Void> promise = Promise.promise();

		wFiwareSwagger.tl(0, "---");
		wFiwareSwagger.tl(0, "components:");
		wFiwareSwagger.tl(1, "schemas:");

		loadSmartDataModels().onSuccess(a -> {

			wFiwareSwagger.tl(0, "info:");
			wFiwareSwagger.t(1, "description: ").yamlStr(2, config.getString(ComputateConfigKeys.API_DESCRIPTION));
			wFiwareSwagger.tl(0, "openapi: \"3.0.0\"");
			wFiwareSwagger.tl(0, "paths:");
			wFiwareSwagger.tl(1, "/ngsi-ld/v1/entities:");
			wFiwareSwagger.tl(2, "get:");
			wFiwareSwagger.tl(3, "description: \"Retrieve a set of entities which matches a specific query from an NGSI-LD system\"");
			wFiwareSwagger.tl(3, "parameters:");
			wFiwareSwagger.tl(4, "- in: query");
			wFiwareSwagger.tl(5, "name: type");
			wFiwareSwagger.tl(5, "required: true");
			wFiwareSwagger.tl(5, "schema:");
			wFiwareSwagger.tl(6, "enum:");
			wFiwareSwagger.tl(7, "- TrafficFlowObserved");
			wFiwareSwagger.tl(6, "type: string");
			wFiwareSwagger.tl(3, "responses:");
			wFiwareSwagger.tl(4, "\"200\":");
			wFiwareSwagger.tl(5, "content:");
			wFiwareSwagger.tl(6, "\"application/ld+json\":");
			wFiwareSwagger.tl(7, "examples:");
			wFiwareSwagger.tl(8, "keyvalues:");
			wFiwareSwagger.tl(9, "summary: \"Key-Values Pairs\"");
			wFiwareSwagger.tl(9, "value:");
			wFiwareSwagger.s(wFiwareExamples);
			wFiwareSwagger.tl(8, "normalized:");
			wFiwareSwagger.tl(9, "summary: \"Normalized NGSI-LD\"");
			wFiwareSwagger.tl(9, "value:");
			wFiwareSwagger.s(wFiwareExamplesNormalized);
			wFiwareSwagger.tl(5, "description: OK");
			wFiwareSwagger.tl(3, "tags:");
			wFiwareSwagger.tl(4, "- ngsi-ld");
			wFiwareSwagger.tl(0, "tags:");
			wFiwareSwagger.tl(1, "description: \"NGSI-LD Linked-data Format\"");
			wFiwareSwagger.tl(1, "name: ngsi-ld");
			wFiwareSwagger.flushClose();

			wFiwareContext.l(new JsonObject().put("@context", fiwareContext).encodePrettily());
			wFiwareContext.flushClose();

			LOG.info("Write FIWARE completed. ");
			promise.complete();
		}).onFailure(ex -> {
			wFiwareSwagger.flushClose();
			LOG.error("Write FIWARE failed. ", ex);
			promise.fail(ex);
		});

		return promise.future();
	}

	public Future<Void> loadSmartDataModels() {
		Promise<Void> promise = Promise.promise();

		try {
			SearchRequest searchClasses = new SearchRequest();
			searchClasses.q("*:*");
			searchClasses.rows(1000000);
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchClasses.fq("classeFiware_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.sortAsc("classeNomCanonique_enUS_indexed_string");
			searchClasses.sortAsc("partNumero_indexed_int");
			searchClasses.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					vertx_.fileSystem().mkdirs(fiwareSwaggerYamlFile.getParent()).onComplete(b -> {

						fiwareContext.put("ngsi-ld", "https://uri.etsi.org/ngsi-ld/");
						fiwareContext.put("fiware", "https://uri.fiware.org/ns/data-models#");
						fiwareContext.put("schema", "https://schema.org/");
						fiwareContext.put("smartvillage", "https://raw.githubusercontent.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "-static/main/fiware/");

						loadSmartDataModel(queryResponse.getResponse().getDocs(), 0).onSuccess(c -> {
							promise.complete();
						}).onFailure(ex -> {
							LOG.error("Write Articles failed. ", ex);
							promise.fail(ex);
						});
					}).onFailure(ex -> {
						LOG.error("Write Articles failed. ", ex);
						promise.fail(ex);
					});
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception ex) {
			LOG.error("Write Articles failed. ", ex);
			promise.fail(ex);
		}

		return promise.future();
	}

	public Future<Void> loadSmartDataModel(List<SolrResponse.Doc> docs, Integer i) {
		Promise<Void> promise = Promise.promise();
		if(docs.size() >= (i + 1)) {
			SolrResponse.Doc doc = docs.get(i);
			ComputateEnUSClass classDoc = JsonObject.mapFrom(doc.getFields()).mapTo(ComputateEnUSClass.class);

			wFiwareSwagger.tl(2, classDoc.getClassSimpleName());
//			wFiwareSwagger.tl(3, "\"$ref\": \"", config.getString(ComputateConfigKeys.SITE_PUBLIC_URL), "/static/fiware/", classDoc.getClassSimpleName(), "/model.yaml#/", classDoc.getClassSimpleName());
//			wFiwareSwagger.tl(3, "\"$ref\": \"", config.getString(ComputateConfigKeys.SITE_BASE_URL), "/static/fiware/", classDoc.getClassSimpleName(), "/model.yaml#/", classDoc.getClassSimpleName());
//			wFiwareSwagger.tl(3, "\"$ref\": \"", "https://computate.neocities.org/smart-village-view", "/fiware/", classDoc.getClassSimpleName(), "/model.yaml#/", classDoc.getClassSimpleName());
			wFiwareSwagger.tl(3, "\"$ref\": \"", "https://raw.githubusercontent.com/", config.getString(ComputateConfigKeys.GITHUB_ORG), "/", config.getString(ComputateConfigKeys.SITE_NAME), "-static/main/fiware/", classDoc.getClassSimpleName(), "/model.yaml#/", classDoc.getClassSimpleName());

			wFiwareExamples.tl(10, "- \"$ref\": \"https://raw.githubusercontent.com/", config.getString(ComputateConfigKeys.GITHUB_ORG), "/", config.getString(ComputateConfigKeys.SITE_NAME), "-static/main/fiware/", classDoc.getClassSimpleName(), "/examples/example.json\"");

			wFiwareExamplesNormalized.tl(10, "- $ref: \"https://raw.githubusercontent.com/", config.getString(ComputateConfigKeys.GITHUB_ORG), "/", config.getString(ComputateConfigKeys.SITE_NAME), "-static/main/fiware/", classDoc.getClassSimpleName(), "/examples/example-normalized.json\"");

			String modelPath = appPath + "-static/fiware/" + classDoc.getClassSimpleName() + "/model.yaml";
			File modelFile = new File(modelPath);
			AllWriter wModel = AllWriter.create(siteRequest_, modelFile, "  ");
			wModel.tl(0, classDoc.getClassSimpleName(), ":");
			if(classDoc.getClassDescription() != null)
				wModel.t(1, "description: ").yamlStr(2, classDoc.getClassDescription());
			wModel.tl(1, "properties:");

			String examplePath = appPath + "-static/fiware/" + classDoc.getClassSimpleName() + "/examples/example.json";
			File exampleFile = new File(examplePath);
			AllWriter wExample = AllWriter.create(siteRequest_, exampleFile, "  ");

			String examplePathLd = appPath + "-static/fiware/" + classDoc.getClassSimpleName() + "/examples/example.jsonld";
			File exampleFileLd = new File(examplePathLd);
			AllWriter wExampleLd = AllWriter.create(siteRequest_, exampleFileLd, "  ");

			String exampleNormalizedPath = appPath + "-static/fiware/" + classDoc.getClassSimpleName() + "/examples/example-normalized.json";
			File exampleNormalizedFile = new File(exampleNormalizedPath);
			AllWriter wExampleNormalized = AllWriter.create(siteRequest_, exampleNormalizedFile, "  ");

			String exampleNormalizedPathLd = appPath + "-static/fiware/" + classDoc.getClassSimpleName() + "/examples/example-normalized.jsonld";
			File exampleNormalizedFileLd = new File(exampleNormalizedPathLd);
			AllWriter wExampleNormalizedLd = AllWriter.create(siteRequest_, exampleNormalizedFileLd, "  ");

			String schemaPath = appPath + "-static/fiware/" + classDoc.getClassSimpleName() + "/schema.json";
			File schemaFile = new File(schemaPath);
			AllWriter wSchema = AllWriter.create(siteRequest_, schemaFile, "  ");
			JsonObject schema = new JsonObject();
			JsonArray allOf = new JsonArray();
			JsonArray required = new JsonArray();
			JsonObject properties = new JsonObject();
			schema.put("$schema", "http://json-schema.org/schema#");
			schema.put("$schemaVersion", "0.0.1");
			schema.put("modelTags", "");
			schema.put("$id", "https://raw.githubusercontent.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "-static/main/fiware/" + classDoc.getClassSimpleName() + "/schema.json");
			schema.put("title", classDoc.getClassSimpleName());
			schema.put("description", classDoc.getClassDescription());
			schema.put("type", "object");
			schema.put("allOf", allOf);
			schema.put("required", required);
			allOf.add(new JsonObject().put("$ref", "https://smart-data-models.github.io/data-models/common-schema.json#/definitions/GSMA-Commons"));
			allOf.add(new JsonObject().put("$ref", "https://smart-data-models.github.io/data-models/common-schema.json#/definitions/Location-Commons"));
			schema.put("properties", properties);

			String docPath = appPath + "-static/fiware/" + classDoc.getClassSimpleName() + "/README.md";
			File docFile = new File(docPath);
			AllWriter wDoc = AllWriter.create(siteRequest_, docFile, "  ");
			wDoc.tl(0, "# ", classDoc.getClassSimpleName());
			if(classDoc.getClassDescription() != null) {
				wDoc.l();
				wDoc.l("## Definition");
				wDoc.l(classDoc.getClassDescription());
			}
			wDoc.l();
			wDoc.l("## Version");
			wDoc.l(config.getString(ComputateConfigKeys.API_VERSION));
			wDoc.l();
			wDoc.l("## Original Schema");
			wDoc.l("https://github.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "-static/blob/main/fiware/" + classDoc.getClassSimpleName() + "/schema.json");
			wDoc.l();
			wDoc.l("## Attributes of the entity");
			wDoc.l();

//			fiwareContext.put(classDoc.getClassSimpleName(), "https://github.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "-static/blob/main/fiware/" + classDoc.getClassSimpleName() + "/");
			fiwareContext.put(classDoc.getClassSimpleName(), "smartvillage:" + classDoc.getClassSimpleName());

			vertx_.fileSystem().mkdirs(exampleFile.getParent()).onComplete(a -> {
				loadSmartDataModelEntities(classDoc, properties, required, wDoc, wModel, wExample, wExampleNormalized, wExampleLd, wExampleNormalizedLd).onSuccess(b -> {
					try {
						wModel.flushClose();
						wExample.flushClose();
						wExampleNormalized.flushClose();
						wExampleLd.flushClose();
						wExampleNormalizedLd.flushClose();
						wDoc.flushClose();

						wSchema.l(schema.encodePrettily());
						wSchema.flushClose();
	
						loadSmartDataModel(docs, i + 1).onSuccess(c -> {
							promise.complete();
						}).onFailure(ex -> {
							promise.fail(ex);
						});
					} catch(Exception ex) {
						LOG.error("loadClass failed", ex);
						promise.fail(ex);
					}
				}).onFailure(ex -> {
					promise.fail(ex);
				});
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
		return promise.future();
	}

	public Future<List<SolrResponse.Doc>> loadSmartDataModelEntities(ComputateEnUSClass classDoc, JsonObject properties, JsonArray required, AllWriter wDoc, AllWriter wModel, AllWriter wExample, AllWriter wExampleNormalized, AllWriter wExampleLd, AllWriter wExampleNormalizedLd) {
		Promise<List<SolrResponse.Doc>> promise = Promise.promise();

		try {
			SearchRequest searchEntities = new SearchRequest();
			searchEntities.q("*:*");
			searchEntities.rows(1000000);
			searchEntities.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath));
			searchEntities.fq("classeCheminAbsolu_indexed_string:" + SearchTool.escapeQueryChars(classDoc.getClassAbsolutePath()));
			searchEntities.fq("partEstEntite_indexed_boolean:true");
			searchEntities.sortAsc("partNumero_indexed_int");
			searchEntities.initDeepForClass(siteRequest_);

			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchEntities.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					List<SolrResponse.Doc> searchEntitiesResults = queryResponse.getResponse().getDocs();
					Long searchEntitesLines = queryResponse.getResponse().getNumFound();
					JsonObject example = new JsonObject();
					JsonObject exampleNormalized = new JsonObject();

					example.put("id", "urn:ngsi-ld:" + classDoc.getClassSimpleName() + "/1");
					example.put("type", classDoc.getClassSimpleName());

					exampleNormalized.put("id", "urn:ngsi-ld:" + classDoc.getClassSimpleName() + "/1");
					exampleNormalized.put("type", classDoc.getClassSimpleName());

					for(Long k = searchEntities.getStart(); k < queryResponse.getResponse().getNumFound(); k+=searchEntitesLines) {
						for(Integer l = 0; l < searchEntitiesResults.size(); l++) {
							SolrResponse.Doc entityDoc = searchEntitiesResults.get(l);
							String entityVar = (String)entityDoc.get("entiteVar_enUS_stored_string");
							String entityDescription = (String)entityDoc.get("entiteDescription_enUS_stored_string");
							String entityJsonFormat = (String)entityDoc.get("entiteFormatJson_stored_string");
							List<String> entityOptionsDescription = (List<String>)entityDoc.get("entiteOptionsDescription_stored_strings");
							String entityUnitLabel = (String)entityDoc.get("entiteUniteLabel_enUS_stored_string");
							String entityNgsiType = (String)entityDoc.get("entiteNgsiType_stored_string");
							String entityFiwareType = (String)entityDoc.get("entiteFiwareType_stored_string");
							String entityListeFiwareType = (String)entityDoc.get("entiteListeFiwareType_stored_string");
							String entityMin = (String)entityDoc.get("entiteMin_stored_string");
							String entityMax = (String)entityDoc.get("entiteMax_stored_string");
							String entityDefault = (String)entityDoc.get("entiteDefaut_stored_string");
							Boolean entityRequired = (Boolean)entityDoc.get("entiteRequis_stored_boolean");
							JsonObject property = new JsonObject();
							properties.put(entityVar, property);

							String ngsiModel = (String)entityDoc.get("entiteNgsiModel_stored_string");
							if(ngsiModel == null) {
								if("number".equals(entityFiwareType))
									ngsiModel = "https://schema.org/Number";
								if("boolean".equals(entityFiwareType))
									ngsiModel = "https://schema.org/Boolean";
								if("address".equals(entityVar))
									ngsiModel = "https://schema.org/address";
								if("date".equals(entityJsonFormat))
									ngsiModel = "https://schema.org/Date";
								if("time".equals(entityJsonFormat))
									ngsiModel = "https://schema.org/Time";
								if("date-time".equals(entityJsonFormat))
									ngsiModel = "https://schema.org/DateTime";
							}

							wModel.tl(2, entityVar, ":");
							if(StringUtils.isNotBlank(entityDescription)) {
								wModel.t(3, "description: ").yamlStr(4, entityDescription);
								property.put("description", entityDescription);
							}

							wModel.tl(3, "type: ", entityFiwareType);
							property.put("type", entityFiwareType);
							if(entityJsonFormat != null) {
								wModel.tl(3, "format: ", entityJsonFormat);
								property.put("format", entityJsonFormat);
							}

							if(entityRequired) {
								wModel.tl(3, "required: ", entityRequired);
								required.add(entityVar);
							}
							if(entityUnitLabel != null) {
								wModel.tl(3, "units: ", entityUnitLabel);
							}
							if(entityMin != null) {
								wModel.tl(3, "minimum: ", entityMin);
								property.put("minimum", entityMin);
							}
							if(entityMax != null) {
								wModel.tl(3, "maximum: ", entityMax);
								property.put("maximum", entityMax);
							}
							wModel.tl(3, "x-ngsi:");
							if(ngsiModel != null) {
								wModel.tl(4, "model: ", ngsiModel);
							}
							wModel.tl(4, "type: ", entityNgsiType);
							if(entityListeFiwareType != null) {
								wModel.tl(3, "items:");
								wModel.tl(4, "type: ", entityListeFiwareType);
							}

							if(StringUtils.isNotBlank(entityDefault)) {
								if("number".equals(entityFiwareType)) {
									example.put(entityVar, NumberFormat.getInstance().parse(entityDefault));
									exampleNormalized.put(entityVar, new JsonObject().put("type", entityNgsiType).put("value", NumberFormat.getInstance().parse(entityDefault)));
								} else if("boolean".equals(entityFiwareType)) {
									example.put(entityVar, Boolean.parseBoolean(entityDefault));
									exampleNormalized.put(entityVar, new JsonObject().put("type", entityNgsiType).put("value", Boolean.parseBoolean(entityDefault)));
								} else if("object".equals(entityFiwareType)) {
									example.put(entityVar, new JsonObject(entityDefault));
									exampleNormalized.put(entityVar, new JsonObject().put("type", entityNgsiType).put("value", new JsonObject(entityDefault)));
								} else if("array".equals(entityFiwareType)) {
									example.put(entityVar, new JsonArray(entityDefault));
									exampleNormalized.put(entityVar, new JsonObject().put("type", entityNgsiType).put("value", new JsonArray(entityDefault)));
								} else {
									example.put(entityVar, entityDefault);
									exampleNormalized.put(entityVar, new JsonObject().put("type", entityNgsiType).put("value", entityDefault));
								}
							}

							fiwareContext.put(entityVar, "https://github.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "-static/blob/main/fiware/" + classDoc.getClassSimpleName() + "/attributes/" + entityVar + ".md");

							wDoc.l("- [", entityVar, "](https://github.com/", config.getString(ComputateConfigKeys.GITHUB_ORG), "/", config.getString(ComputateConfigKeys.SITE_NAME), "-static/blob/main/fiware/", classDoc.getClassSimpleName(), "/attributes/", entityVar, ".md)");

							String docPath = appPath + "-static/fiware/" + classDoc.getClassSimpleName() + "/attributes/" + entityVar + ".md";
							File docFile = new File(docPath);
							AllWriter wEntityDoc = AllWriter.create(siteRequest_, docFile, "  ");
							wEntityDoc.tl(0, "# ", classDoc.getClassSimpleName(), ".", entityVar);
							if(entityDescription != null) {
								wEntityDoc.l();
								wEntityDoc.l("## Definition");
								wEntityDoc.l(entityDescription);
							}
							wEntityDoc.l();
							wEntityDoc.l("## Version");
							wEntityDoc.l(config.getString(ComputateConfigKeys.API_VERSION));
							wEntityDoc.l();
							wEntityDoc.l("## Original Schema");
							wEntityDoc.l("https://github.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "-static/blob/main/fiware/" + classDoc.getClassSimpleName() + "/schema.json");
							wEntityDoc.flushClose();
						}
					}

					wExample.l(example.encodePrettily());
					wExampleNormalized.l(exampleNormalized.encodePrettily());

					example.put("@context", new JsonArray().add("https://raw.githubusercontent.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "-static/main/fiware/" + classDoc.getClassSimpleName() + "/context.jsonld"));
					exampleNormalized.put("@context", new JsonArray().add("https://raw.githubusercontent.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "-static/main/fiware/" + classDoc.getClassSimpleName() + "/context.jsonld"));
					wExampleLd.l(example.encodePrettily());
					wExampleNormalizedLd.l(exampleNormalized.encodePrettily());

					promise.complete(searchEntitiesResults);
				} catch(Exception ex) {
					LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
					promise.fail(ex);
				}
			}).onFailure(ex -> {
				LOG.error(String.format("Search failed. "), new RuntimeException(ex));
				promise.fail(ex);
			});
		} catch (Exception e) {
			ExceptionUtils.rethrow(e);
		}

		return promise.future();
	}
}
