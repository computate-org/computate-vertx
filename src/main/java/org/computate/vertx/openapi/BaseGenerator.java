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
import java.nio.file.Files;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.BooleanUtils;
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
import org.yaml.snakeyaml.Yaml;

import com.hubspot.jinjava.Jinjava;

import io.vertx.config.ConfigRetriever;
import io.vertx.config.ConfigRetrieverOptions;
import io.vertx.config.ConfigStoreOptions;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;
import io.vertx.ext.web.client.WebClient;

/**
 * InitDeepBefore: true
 */
public class BaseGenerator extends BaseGeneratorGen<Object> {

	/**
	 * Description: A helper method for generating a URL friendly unique ID for this object
	 */
	public String toId(String s) {
		if(s != null) {
			s = Normalizer.normalize(s, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
		}

		return s;
	}

	/**	
	 * Val.Complete.enUS:The config was configured successfully. 
	 * Val.Fail.enUS:Could not configure the config(). 
	 **/
	public static Future<JsonObject> configureConfig(Vertx vertx) {
		Promise<JsonObject> promise = Promise.promise();

		try {
			ConfigRetrieverOptions retrieverOptions = new ConfigRetrieverOptions();

			String configVarsPath = System.getenv(ComputateConfigKeys.VARS_PATH);
			if(StringUtils.isNotBlank(configVarsPath)) {
				Jinjava jinjava = ComputateConfigKeys.getJinjava();
				JsonObject config = ComputateConfigKeys.getConfig(jinjava);
				LOG.info(config.encodePrettily());
				ConfigStoreOptions configOptions = new ConfigStoreOptions().setConfig(config);
				retrieverOptions.addStore(configOptions);
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

	protected void _computateVertxSrc(Wrap<String> c) {
		c.o(config.getString(ComputateConfigKeys.COMPUTATE_VERTX_SRC));
	}

	protected void _i18n(Wrap<JsonObject> w) {
		try {
			File configFichier = new File(String.format("%s/src/main/resources/org/computate/i18n/i18n_%s.yaml", computateVertxSrc, languageName));
			String template = Files.readString(configFichier.toPath());
			Yaml yaml = new Yaml();
			Map<String, Object> map = yaml.load(template);
			w.o(new JsonObject(map));
		} catch(Throwable ex) {
			LOG.error("Error generating OpenAPI spec", ex);
			ExceptionUtils.rethrow(ex);
		}
	}

	protected void _appPath(Wrap<String> c) {
		c.o(config.getString(ComputateConfigKeys.SITE_SRC));
	}

	protected void _appStaticPath(Wrap<String> c) {
		c.o(config.getString(ComputateConfigKeys.STATIC_PATH));
	}

	protected void _platformPomArtifactId(Wrap<String> w) {
		w.o(config.getString(ComputateConfigKeys.PLATFORM_POM_ARTIFACT_ID));
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
		c.o(String.format("%s/src/main/resources/webroot/%s-%s.yaml", appPath, ("2.0".equals(apiVersion) ? "swagger2" : "openapi3"), languageName));
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

	protected void _w(Wrap<AllWriter> c) {
		openApiYamlFile.getParentFile().mkdirs();
		c.o(AllWriter.create(siteRequest_, openApiYamlFile, "  "));
	}

	protected void _wSqlCreate(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, sqlCreateFile, "  "));
	}

	protected void _wSqlDrop(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, sqlDropFile, "  "));
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

	public Future<Void> loadClasses() {
		Promise<Void> promise = Promise.promise();

		try {
			SearchRequest searchClasses = new SearchRequest();
			searchClasses.q("*:*");
			searchClasses.rows(1000000);
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath) + (platformPomArtifactId == null ? "" : (" OR siteNom_indexed_string:" + SearchTool.escapeQueryChars(platformPomArtifactId))));
			searchClasses.fq("classeApi_indexed_boolean:true");
			searchClasses.fq("classeEtendGen_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.sortAsc(String.format("classeNomCanonique_%s_indexed_string", languageName));
			searchClasses.initDeepForClass(siteRequest_);

			String solrUsername = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_USERNAME);
			String solrPassword = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PASSWORD);
			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = Integer.parseInt(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PORT_COMPUTATE));
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = Boolean.parseBoolean(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_SSL_COMPUTATE));
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).send().onSuccess(a -> {
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

			List<String> classApiMethods = classDoc.getClassApiMethods();
			classApiMethods.stream().sorted(Comparator.comparing(classApiMethod -> doc.get(String.format("classeApiMethode%s_%s_stored_string", classApiMethod, languageName))));
			for(String classApiMethod : classDoc.getClassApiMethods()) {
				ApiWriter apiWriter = new ApiWriter();
				apiWriter.setI18n(i18n);
				apiWriter.setLanguageName(languageName);
				apiWriter.setClassSolrDocument(doc);
				apiWriter.setClassApiMethod(classApiMethod);
				apiWriter.setContextRows(classDoc.getClassRows());
				apiWriter.setWPaths(wPaths);
				apiWriter.setWRequestBodies(wRequestBodies);
				apiWriter.setWSchemas(wSchemas);
				apiWriter.setOpenApiVersion(openApiVersion);
				apiWriter.setClassUris(classUris);
				apiWriter.setAuthClients(Optional.ofNullable(config.getValue(ComputateConfigKeys.AUTH_CLIENTS))
						.map(v -> v instanceof JsonObject ? (JsonObject)v : new JsonObject(v.toString()))
						.orElse(new JsonObject().put(Optional.ofNullable(config.getString(ComputateConfigKeys.AUTH_OPEN_API_ID)).orElse("openIdConnect"), config)));
				apiWriter.initDeepApiWriter(siteRequest_);
				apiWriters.add(apiWriter);
			}
			Collections.sort(apiWriters);
			loadEntities(classDoc, apiWriters).onSuccess(a -> {
				try {
					for(ApiWriter apiWriter : apiWriters) {
						apiWriter.getWriters().flushClose();
						apiWriter.writeApi();
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
			searchEntities.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath) + (platformPomArtifactId == null ? "" : (" OR siteNom_indexed_string:" + SearchTool.escapeQueryChars(platformPomArtifactId))));
			searchEntities.fq("classeCheminAbsolu_indexed_string:" + SearchTool.escapeQueryChars(classDoc.getClassAbsolutePath()));
			searchEntities.fq("partEstEntite_indexed_boolean:true");
			searchEntities.sortAsc("classeOrdreSql_indexed_int");
			searchEntities.sortAsc("partNumero_indexed_int");
			searchEntities.initDeepForClass(siteRequest_);

			String solrUsername = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_USERNAME);
			String solrPassword = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PASSWORD);
			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = Integer.parseInt(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PORT_COMPUTATE));
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = Boolean.parseBoolean(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_SSL_COMPUTATE));
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchEntities.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).send().onSuccess(a -> {
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
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath) + (platformPomArtifactId == null ? "" : (" OR siteNom_indexed_string:" + SearchTool.escapeQueryChars(platformPomArtifactId))));
			searchClasses.fq("classeSauvegarde_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.fq("classeEstBase_indexed_boolean:false");
			searchClasses.sortAsc("classeOrdreSql_indexed_int");
			searchClasses.initDeepForClass(siteRequest_);

			String solrUsername = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_USERNAME);
			String solrPassword = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PASSWORD);
			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = Integer.parseInt(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PORT_COMPUTATE));
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = Boolean.parseBoolean(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_SSL_COMPUTATE));
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).send().onSuccess(a -> {
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
	
				List<String> classeEntiteClassesSuperEtMoiSansGen = doc1.get("classesSuperEtMoiSansGen_stored_strings");
				String fqClassesSuperEtMoi = "(" + classeEntiteClassesSuperEtMoiSansGen.stream().map(c -> SearchTool.escapeQueryChars(c)).collect(Collectors.joining(" OR ")) + ")";

				SearchRequest searchClasses = new SearchRequest();
				searchClasses.q("*:*");
				searchClasses.rows(1000000);
				searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath) + (platformPomArtifactId == null ? "" : (" OR siteNom_indexed_string:" + SearchTool.escapeQueryChars(platformPomArtifactId))));
				searchClasses.fq("classeNomCanonique_" + languageName + "_indexed_string:" + fqClassesSuperEtMoi);
				searchClasses.fq("partEstEntite_indexed_boolean:true");
				searchClasses.fq("entiteEstSubstitue_indexed_boolean:false");
				searchClasses.fq("-(entiteAttribuer_indexed_boolean:true AND entiteTypeJson_indexed_string:array)");
				searchClasses.fq("(entiteAttribuer_indexed_boolean:true OR entiteDefinir_indexed_boolean:true OR entiteClePrimaire_indexed_boolean:true)");
				searchClasses.sortAsc("classeOrdreSql_indexed_int");
				searchClasses.sortAsc("partNumero_indexed_int");
				searchClasses.initDeepForClass(siteRequest_);
	
				String solrUsername = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_USERNAME);
				String solrPassword = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PASSWORD);
				String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
				Integer solrPort = Integer.parseInt(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PORT_COMPUTATE));
				String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
				Boolean solrSsl = Boolean.parseBoolean(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_SSL_COMPUTATE));
				String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
				siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).send().onSuccess(a -> {
					try {
						SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
	
						String classeNomSimple = (String)doc1.get("classeNomSimple_" + languageName + "_stored_string");
						wSqlDrop.l("DROP TABLE ", classeNomSimple, " CASCADE;");
						wSqlCreate.l();
						wSqlCreate.l("CREATE TABLE IF NOT EXISTS ", classeNomSimple, "();");

						List<Doc> entiteDocs = queryResponse.getResponse().getDocs();
						for(Integer j = 0; j < entiteDocs.size(); j++) {
							SolrResponse.Doc doc2 = entiteDocs.get(j);
							wSqlCreate.s("ALTER TABLE ", classeNomSimple, " ADD COLUMN IF NOT EXISTS ");
							wSqlCreate.s(doc2.get("entiteVar_" + languageName + "_stored_string"), " ", doc2.get("entiteTypeSql_stored_string"));
							if(doc2.get("entiteAttribuerTypeJson_stored_string") != null && BooleanUtils.isTrue((Boolean)doc2.get("entiteAttribuerEtendModeleBase_stored_boolean")))
								wSqlCreate.s(" references ", (String)doc2.get("entiteAttribuerNomSimple_" + languageName + "_stored_string"), "(", (String)doc2.get("entiteAttribuerVar_" + languageName + "_stored_string"), ")");
							if(BooleanUtils.isTrue((Boolean)doc2.get("entiteUnique_stored_boolean")))
								wSqlCreate.s(" UNIQUE");
							wSqlCreate.l(";");
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
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath) + (platformPomArtifactId == null ? "" : (" OR siteNom_indexed_string:" + SearchTool.escapeQueryChars(platformPomArtifactId))));
			searchClasses.fq("partEstEntite_indexed_boolean:true");
			searchClasses.fq("entiteTypeJson_indexed_string:array");
			searchClasses.fq("entiteAttribuerTypeJson_indexed_string:array");
			searchClasses.initDeepForClass(siteRequest_);

			String solrUsername = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_USERNAME);
			String solrPassword = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PASSWORD);
			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = Integer.parseInt(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PORT_COMPUTATE));
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = Boolean.parseBoolean(siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_SSL_COMPUTATE));
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).send().onSuccess(a -> {
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
				SolrResponse.Doc doc1 = docs.get(i);
				String var = doc1.get("entiteVar_" + languageName + "_stored_string");
				String varAttribuer = doc1.get("entiteAttribuerVar_" + languageName + "_stored_string");

				if(var.compareTo(varAttribuer) <= 0) {
					String c1 = doc1.get("classeNomSimple_" + languageName + "_stored_string");
					String c2 = doc1.get("entiteAttribuerNomSimple_" + languageName + "_stored_string");

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
}
