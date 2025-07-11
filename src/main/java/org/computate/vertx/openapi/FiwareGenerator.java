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
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.search.computate.enus.ComputateEnUSClass;
import org.computate.search.request.SearchRequest;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.vertx.writer.AllWriter;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.authentication.UsernamePasswordCredentials;

/**
 * InitDeepBefore: true
 */
public class FiwareGenerator extends FiwareGeneratorGen<ProjectGenerator> {

	protected void _fiwareSwaggerYamlPath(Wrap<String> c) {
		c.o(appStaticPath + "/fiware/swagger.yaml");
	}

	protected void _fiwareSwaggerYamlFile(Wrap<File> c) {
		c.o(new File(fiwareSwaggerYamlPath));
	}
	protected void _wFiwareSwagger(Wrap<AllWriter> c) {
		fiwareSwaggerYamlFile.getParentFile().mkdirs();
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
		c.o(appStaticPath + "/fiware/context.jsonld");
	}
	protected void _fiwareContextJsonldFile(Wrap<File> c) {
		c.o(new File(fiwareContextJsonldPath));
	}
	protected void _wFiwareContext(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, fiwareContextJsonldFile, "  "));
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
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath) + (platformPomArtifactId == null ? "" : (" OR siteNom_indexed_string:" + SearchTool.escapeQueryChars(platformPomArtifactId))));
			searchClasses.fq("classeFiware_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.sortAsc("classeNomCanonique_enUS_indexed_string");
			searchClasses.sortAsc("partNumero_indexed_int");
			searchClasses.initDeepForClass(siteRequest_);

			String siteName = siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_NAME);
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
					vertx_.fileSystem().mkdirs(fiwareSwaggerYamlFile.getParent()).onComplete(b -> {

						fiwareContext.put("ngsi-ld", "https://uri.etsi.org/ngsi-ld/");
						fiwareContext.put("fiware", "https://uri.fiware.org/ns/data-models#");
						fiwareContext.put("schema", "https://schema.org/");
						fiwareContext.put(siteName, config.getString(ComputateConfigKeys.NGSILD_BASE_URL) + "/");

						loadSmartDataModel(queryResponse.getResponse().getDocs(), 0).onSuccess(d -> {
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
			wFiwareSwagger.tl(3, "\"$ref\": \"", config.getString(ComputateConfigKeys.NGSILD_BASE_URL), "/", classDoc.getClassSimpleName(), "/model.yaml#/", classDoc.getClassSimpleName());

			wFiwareExamples.tl(10, "- \"$ref\": \"", config.getString(ComputateConfigKeys.NGSILD_BASE_URL), "/", classDoc.getClassSimpleName(), "/examples/example.json\"");

			wFiwareExamplesNormalized.tl(10, "- $ref: \"", config.getString(ComputateConfigKeys.NGSILD_BASE_URL), "/", classDoc.getClassSimpleName(), "/examples/example-normalized.json\"");

			String modelPath = appStaticPath + "/fiware/" + classDoc.getClassSimpleName() + "/model.yaml";
			File modelFile = new File(modelPath);
			AllWriter wModel = AllWriter.create(siteRequest_, modelFile, "  ");
			wModel.tl(0, classDoc.getClassSimpleName(), ":");
			if(classDoc.getClassDescription() != null)
				wModel.t(1, "description: ").yamlStr(2, classDoc.getClassDescription());
			wModel.tl(1, "properties:");

			String examplePath = appStaticPath + "/fiware/" + classDoc.getClassSimpleName() + "/examples/example.json";
			File exampleFile = new File(examplePath);
			AllWriter wExample = AllWriter.create(siteRequest_, exampleFile, "  ");

			String examplePathLd = appStaticPath + "/fiware/" + classDoc.getClassSimpleName() + "/examples/example.jsonld";
			File exampleFileLd = new File(examplePathLd);
			AllWriter wExampleLd = AllWriter.create(siteRequest_, exampleFileLd, "  ");

			String exampleNormalizedPath = appStaticPath + "/fiware/" + classDoc.getClassSimpleName() + "/examples/example-normalized.json";
			File exampleNormalizedFile = new File(exampleNormalizedPath);
			AllWriter wExampleNormalized = AllWriter.create(siteRequest_, exampleNormalizedFile, "  ");

			String exampleNormalizedPathLd = appStaticPath + "/fiware/" + classDoc.getClassSimpleName() + "/examples/example-normalized.jsonld";
			File exampleNormalizedFileLd = new File(exampleNormalizedPathLd);
			AllWriter wExampleNormalizedLd = AllWriter.create(siteRequest_, exampleNormalizedFileLd, "  ");

			String schemaPath = appStaticPath + "/fiware/" + classDoc.getClassSimpleName() + "/schema.json";
			File schemaFile = new File(schemaPath);
			AllWriter wSchema = AllWriter.create(siteRequest_, schemaFile, "  ");

			JsonObject schema = new JsonObject();
			JsonArray allOf = new JsonArray();
			JsonArray required = new JsonArray();
			JsonObject properties = new JsonObject();
			schema.put("$schema", "http://json-schema.org/schema#");
			schema.put("$schemaVersion", "0.0.1");
			schema.put("modelTags", "");
			schema.put("$id", config.getString(ComputateConfigKeys.NGSILD_BASE_URL) + "/" + classDoc.getClassSimpleName() + "/schema.json");
			schema.put("title", classDoc.getClassSimpleName());
			schema.put("description", classDoc.getClassDescription());
			schema.put("type", "object");
			schema.put("allOf", allOf);
			schema.put("required", required);
			allOf.add(new JsonObject().put("$ref", "https://smart-data-models.github.io/data-models/common-schema.json#/definitions/GSMA-Commons"));
			allOf.add(new JsonObject().put("$ref", "https://smart-data-models.github.io/data-models/common-schema.json#/definitions/Location-Commons"));
			schema.put("properties", properties);

			String docPath = appStaticPath + "/fiware/" + classDoc.getClassSimpleName() + "/README.md";
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
			wDoc.l(config.getString(ComputateConfigKeys.NGSILD_BASE_URL) + "/" + classDoc.getClassSimpleName() + "/schema.json");
			wDoc.l();
			wDoc.l("## Attributes of the entity");
			wDoc.l();
//			fiwareContext.put(classDoc.getClassSimpleName(), config.getString(ComputateConfigKeys.NGSILD_BASE_URL) + "/" + classDoc.getClassSimpleName() + "/");
			String siteName = siteRequest_.getConfig().getString(ComputateConfigKeys.SITE_NAME);
			fiwareContext.put(classDoc.getClassSimpleName(), String.format("%s:%s", siteName, classDoc.getClassSimpleName()));

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
			searchEntities.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath) + (platformPomArtifactId == null ? "" : (" OR siteNom_indexed_string:" + SearchTool.escapeQueryChars(platformPomArtifactId))));
			searchEntities.fq("classeCheminAbsolu_indexed_string:" + SearchTool.escapeQueryChars(classDoc.getClassAbsolutePath()));
			searchEntities.fq("partEstEntite_indexed_boolean:true");
			searchEntities.fq("entiteDefinir_indexed_boolean:true");
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
							String entityFiwareContext = (String)entityDoc.get("entiteFiwareContexte_stored_string");
							String entityFiwareType = (String)entityDoc.get("entiteFiwareType_stored_string");
							String entityListeFiwareType = (String)entityDoc.get("entiteListeFiwareType_stored_string");
							String entityMin = (String)entityDoc.get("entiteMin_stored_string");
							String entityMax = (String)entityDoc.get("entiteMax_stored_string");
							String entityDefault = (String)entityDoc.get("entiteDefaut_stored_string");
							Boolean entityRequired = (Boolean)entityDoc.get("entiteRequis_stored_boolean");
							String entityDocs = (String)entityDoc.get("entiteDocs_stored_string");
							String entityAlternateDocs = (String)entityDoc.get("entiteDocsAlternatif_stored_string");
							String entityAlternateName = (String)entityDoc.get("entiteNomAlternatif_stored_string");
							String entityAlternateDescription = (String)entityDoc.get("entiteDescriptionAlternatif_stored_string");
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
							wModel.tl(3, "type: ", entityFiwareType);
							property.put("type", entityFiwareType);
							if(entityJsonFormat != null) {
								wModel.tl(3, "format: ", entityJsonFormat);
								property.put("format", entityJsonFormat);
							}

							if(StringUtils.isNotBlank(entityDescription)) {
								wModel.t(3, "description: ").yamlStr(4, entityDescription);
								property.put("description", entityDescription);
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

							fiwareContext.put(entityVar, Optional.ofNullable(entityFiwareContext).orElse("https://github.com/" + config.getString(ComputateConfigKeys.GITHUB_ORG) + "/" + config.getString(ComputateConfigKeys.SITE_NAME) + "/" + classDoc.getClassSimpleName() + "/attributes/" + entityVar + ".md"));

							wDoc.l("- [", entityVar, "](", config.getString(ComputateConfigKeys.NGSILD_BASE_URL), "/", classDoc.getClassSimpleName(), "/attributes/", entityVar, ".md)");

							String docPath = appStaticPath + "/fiware/" + classDoc.getClassSimpleName() + "/attributes/" + entityVar + ".md";
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
							wEntityDoc.l(config.getString(ComputateConfigKeys.NGSILD_BASE_URL) + "/" + classDoc.getClassSimpleName() + "/schema.json");
							wEntityDoc.flushClose();
						}
					}

					wExample.l(example.encodePrettily());
					wExampleNormalized.l(exampleNormalized.encodePrettily());

					example.put("@context", new JsonArray().add(config.getString(ComputateConfigKeys.NGSILD_BASE_URL) + "/" + classDoc.getClassSimpleName() + "/context.jsonld"));
					exampleNormalized.put("@context", new JsonArray().add(config.getString(ComputateConfigKeys.NGSILD_BASE_URL) + "/" + classDoc.getClassSimpleName() + "/context.jsonld"));
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
