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
public class UseCaseGenerator extends UseCaseGeneratorGen<FiwareGenerator> {

	protected void _useCasePath(Wrap<String> c) {
		c.o(config.getString(ComputateConfigKeys.USE_CASE_SRC));
	}

	protected void _useCaseSummary(JsonObject o) {
	}
	protected void _useCaseSummaryCells(JsonArray a) {
		useCaseSummary.put("cells", a);
	}
	protected void _useCaseSummaryNum(Wrap<Integer> c) {
		c.o(config.getInteger(ComputateConfigKeys.USE_CASE_SUMMARY_NUM));
	}
	protected void _useCaseSummaryFile(Wrap<File> c) {
		c.o(new File(String.format("%s/%s-use-case.ipynb", useCasePath, useCaseSummaryNum)));
	}
	protected void _wUseCaseSummary(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, useCaseSummaryFile, "  "));
	}

	public Future<Void> writeUseCase() {
		Promise<Void> promise = Promise.promise();

		loadUseCaseApis().onSuccess(apis -> {
			useCaseSummary.put("metadata", new JsonObject()
				.put("kernelspec", new JsonObject()
					.put("display_name", "Bash")
					.put("language", "bash")
					.put("name", "bash")
				)
				.put("language_info", new JsonObject()
					.put("codemirror_mode", "shell")
					.put("file_extension", ".sh")
					.put("mimetype", "text/x-sh")
					.put("name", "bash")
				)
			);
			useCaseSummary.put("nbformat", 4);
			useCaseSummary.put("nbformat_minor", 5);

			wUseCaseSummary.l(useCaseSummary.encodePrettily());
			wUseCaseSummary.flushClose();

			LOG.info("Write use case completed. ");
			promise.complete();
		}).onFailure(ex -> {
			wFiwareSwagger.flushClose();
			LOG.error("Write use case failed. ", ex);
			promise.fail(ex);
		});

		return promise.future();
	}

	public Future<SolrResponse> loadUseCaseApis() {
		Promise<SolrResponse> promise = Promise.promise();

		try {
			SearchRequest searchClasses = new SearchRequest();
			searchClasses.q("*:*");
			searchClasses.rows(1000000);
			searchClasses.fq("siteChemin_indexed_string:" + SearchTool.escapeQueryChars(appPath) + (platformPomArtifactId == null ? "" : (" OR siteNom_indexed_string:" + SearchTool.escapeQueryChars(platformPomArtifactId))));
			searchClasses.fq("classeApi_indexed_boolean:true");
			searchClasses.fq("partEstClasse_indexed_boolean:true");
			searchClasses.sortAsc("classeNomCanonique_enUS_indexed_string");
			searchClasses.sortAsc("partNumero_indexed_int");
			searchClasses.initDeepForClass(siteRequest_);

			String solrUsername = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_USERNAME);
			String solrPassword = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_PASSWORD);
			String solrHostName = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_HOST_NAME_COMPUTATE);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, searchClasses.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).ssl(solrSsl).authentication(new UsernamePasswordCredentials(solrUsername, solrPassword)).send().onSuccess(a -> {
				try {
					SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
					vertx_.fileSystem().mkdirs(fiwareSwaggerYamlFile.getParent()).onComplete(b -> {
						loadUseCaseApi(queryResponse.getResponse().getDocs(), 0).onSuccess(d -> {
							promise.complete(queryResponse);
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

	public Future<Void> loadUseCaseApi(List<SolrResponse.Doc> docs, Integer i) {
		Promise<Void> promise = Promise.promise();
		if(docs.size() >= (i + 1)) {
			SolrResponse.Doc doc = docs.get(i);
			ComputateEnUSClass classDoc = JsonObject.mapFrom(doc.getFields()).mapTo(ComputateEnUSClass.class);

			Integer modelNum = useCaseSummaryNum + i + 1;
			String classSimpleName = (String)doc.get("classeNomSimple_enUS_stored_string");
			String classPackageName = (String)doc.get("classeNomEnsemble_enUS_stored_string");
			String classAName = (String)doc.get("classeUnNom_enUS_stored_string");
			String classDescription = (String)doc.get("classeDescription_enUS_stored_string");
			String modelPath = String.format("%s/%s-%s.ipynb", useCasePath, modelNum, classSimpleName);
			File modelFile = new File(modelPath);
			AllWriter wModel = AllWriter.create(siteRequest_, modelFile, "  ");

			JsonObject modelNotebook = new JsonObject();
			modelNotebook.put("metadata", new JsonObject()
				.put("kernelspec", new JsonObject()
					.put("display_name", "Bash")
					.put("language", "bash")
					.put("name", "bash")
				)
				.put("language_info", new JsonObject()
					.put("codemirror_mode", "shell")
					.put("file_extension", ".sh")
					.put("mimetype", "text/x-sh")
					.put("name", "bash")
				)
			);
			modelNotebook.put("nbformat", 4);
			modelNotebook.put("nbformat_minor", 5);
			JsonArray modelCells = new JsonArray();
			modelNotebook.put("cells", modelCells);
			modelCells.add(new JsonObject()
				.put("cell_type", "markdown")
				.put("id", Integer.toString(modelCells.size()))
				.put("metadata", new JsonObject())
				.put("source", new JsonArray()
					.add("# Computate Smart Cloud Builder\n")
					.add("\n")
					.add("## About the open source GPL3 license and copyright for this product\n")
					.add("\n")
					.add("Copyright © 2024 Computate Limited Liability Company in Utah, USA\n")
					.add("\n")
					.add("This program is free software: you can redistribute it and/or modify\n")
					.add("it under the terms of the GNU General Public License as published by\n")
					.add("the Free Software Foundation, either version 3 of the License, or\n")
					.add("(at your option) any later version.\n")
					.add("\n")
					.add("This program is distributed in the hope that it will be useful,\n")
					.add("but WITHOUT ANY WARRANTY; without even the implied warranty of\n")
					.add("MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n")
					.add("GNU General Public License for more details.\n")
					.add("\n")
					.add("You should have received a copy of the GNU General Public License\n")
					.add("along with this program.  If not, see <https://www.gnu.org/licenses/>.\n")
					.add("\n")
					.add("ADDITIONAL TERMS\n")
					.add("\n")
					.add("As stated in section 7. c) and e) of the GPL3 license, \n")
					.add("\"you may supplement the terms of this License with terms,\" \n")
					.add("Computate has added the following additional terms to the license: \n")
					.add("\n")
					.add("  7 c) Prohibiting misrepresentation of the origin of that material, and\n")
					.add("    requiring that modified versions of such material be marked in\n")
					.add("    reasonable ways as different from the original version;\n")
					.add("\n")
					.add("  7 e) Declining to grant rights under trademark law for use of some\n")
					.add("    trade names, trademarks, or service marks;\n")
					.add("\n")
					.add("Please do not redistribute this use case until you have built your own platform with these tools, \n")
					.add("separate from the computate.org platform, and reconfigure your fork of this repo to deploy \n")
					.add("your own platform instead of the computate.org platform. \n")
					.add("\n")
					.add("QUESTIONS\n")
					.add("\n")
					.add("For questions about this open source license, please contact our public mailing list at computate@group.computate.org\n")
				)
			);
			modelCells.add(new JsonObject()
				.put("cell_type", "markdown")
				.put("id", Integer.toString(modelCells.size()))
				.put("metadata", new JsonObject())
				.put("source", new JsonArray()
					.add("## Create a new Java database and search model class\n")
					.add("Specify the details of your new Java class below. \n")
				)
			);
			modelCells.add(new JsonObject()
				.put("cell_type", "code")
				.put("execution_count", null)
				.put("id", Integer.toString(modelCells.size()))
				.put("metadata", new JsonObject()
					.put("vscode", new JsonObject()
						.put("languageId", "shellscript")
					)
				)
				.put("outputs", new JsonArray())
				.put("source", new JsonArray()
					.add("eval $(cd ../../ && ./vars.py)\n")
					.add(String.format("CLASS_PACKAGE=$SITE_JAVA_PACKAGE%s\n", StringUtils.substringAfter(classPackageName, config.getString(ComputateConfigKeys.SITE_JAVA_PACKAGE))))
					.add(String.format("CLASS_SIMPLE_NAME=%s\n", classSimpleName))
					.add(String.format("CLASS_A_NAME=\"%s\"\n", classAName))
					.add(String.format("CLASS_DESCRIPTION=\"\"\n", classDescription))
					.add(String.format("CLASS_ORDER=6\n"))
					.add(String.format("CLASS_ICON='<i class=\"fa-regular fa-conveyor-belt\"></i>'\n"))
					.add("echo DONE")
				)
			);


			loadUseCaseApiEntities(classDoc, wModel, modelNotebook).onSuccess(b -> {
				try {
					wModel.l(modelNotebook.encodePrettily());
					wModel.flushClose();
	
					loadUseCaseApi(docs, i + 1).onSuccess(c -> {
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

	public Future<List<SolrResponse.Doc>> loadUseCaseApiEntities(ComputateEnUSClass classDoc, AllWriter wModel, JsonObject modelNotebook) {
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
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateConfigKeys.SOLR_PORT_COMPUTATE);
			String solrCollection = siteRequest_.getConfig().getString(ComputateConfigKeys.SOLR_COLLECTION_COMPUTATE);
			Boolean solrSsl = siteRequest_.getConfig().getBoolean(ComputateConfigKeys.SOLR_SSL_COMPUTATE);
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
}
