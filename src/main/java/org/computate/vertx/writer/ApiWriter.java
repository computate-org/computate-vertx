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
package org.computate.vertx.writer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.search.computate.enus.ComputateEnUSClass;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.request.ComputateSiteRequest;

import io.vertx.core.json.JsonObject;

public class ApiWriter extends ApiWriterGen<Object> implements Comparable<ApiWriter> {

	protected void _siteRequest_(Wrap<ComputateSiteRequest> w) {
	}

	protected void _classDoc(Wrap<ComputateEnUSClass> w) {
	}

	protected void _classSolrDocument(Wrap<SolrResponse.Doc> c) {
	}

	protected void _contextRows(Wrap<Integer> c) {
	}

	protected void _classApiMethod(Wrap<String> c) {
	}

	protected void _openApiVersion(Wrap<String> c) {
	}

	protected void _classUris(Wrap<List<String>> w) {
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

	protected void _tabsResponses(Wrap<Integer> c) {
		if(StringUtils.equals(openApiVersion, "2.0"))
			c.o(0);
		else
			c.o(2);
	}

	protected void _wPaths(Wrap<AllWriter> c) {
	}

	protected void _wRequestBodies(Wrap<AllWriter> c) {
	}

	protected void _wSchemas(Wrap<AllWriter> c) {
	}

	protected void _config(Wrap<JsonObject> c) {
	}

	protected void _authClients(Wrap<JsonObject> c) {
	}

	protected void _wRequestHeaders(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wRequestDescription(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wResponseDescription(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wRequestBody(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wResponseBody(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wRequestSchema(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _wResponseSchema(Wrap<AllWriter> c) {
		c.o(AllWriter.create(siteRequest_, "  "));
	}

	protected void _writers(Wrap<AllWriters> c) {
		c.o(AllWriters.create(siteRequest_));
	}

	protected void _classApiTag(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeApiTag_enUS_stored_string"));
	}

	protected void _classExtendsBase(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classeEtendBase_stored_boolean"));
	}

	protected void _classIsBase(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classeEstBase_stored_boolean"));
	}

	protected void _classFiware(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classeFiware_stored_boolean"));
	}

	protected void _classSimpleName(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeNomSimple_enUS_stored_string"));
	}

	protected void _appName(Wrap<String> c) {
		c.o((String)classSolrDocument.get("siteNom_stored_string"));
	}

	protected void _classAbsolutePath(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeCheminAbsolu_enUS_stored_string"));
	}

	protected void _classApiUriMethod(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeApiUri" + classApiMethod + "_enUS_stored_string"));
	}

	protected void _classRoleUserMethod(Wrap<Boolean> c) {
		c.o(BooleanUtils.isTrue((Boolean)classSolrDocument.get("classeRoleUtilisateur" + classApiMethod + "_enUS_stored_boolean")));
	}

	protected void _classApiMethodMethod(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeApiMethode" + classApiMethod + "_enUS_stored_string"));
	}

	protected void _classApiMediaTypeRequestMethod(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeApiTypeMediaRequete" + classApiMethod + "_enUS_stored_string"));
	}

	protected void _classApiMediaType200Method(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeApiTypeMedia200" + classApiMethod + "_enUS_stored_string"));
	}

	protected void _classApiOperationIdMethod(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeApiOperationId" + classApiMethod + "_enUS_stored_string"));
	}

	protected void _classApiOperationIdMethodRequest(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeApiOperationId" + classApiMethod + "Requete_enUS_stored_string"));
	}

	protected void _classApiOperationIdMethodResponse(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeApiOperationId" + classApiMethod + "Reponse_enUS_stored_string"));
	}

	protected void _classSuperApiOperationIdMethodRequest(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeSuperApiOperationId" + classApiMethod + "Requete_enUS_stored_string"));
	}

	protected void _classSuperApiOperationIdMethodResponse(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classeSuperApiOperationId" + classApiMethod + "Reponse_enUS_stored_string"));
	}

	protected void _classPageCanonicalNameMethod(Wrap<String> c) {
		c.o((String)classSolrDocument.get("classePageNomCanonique" + classApiMethod + "_enUS_stored_string"));
	}

	protected void _classKeywordsFound(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classeMotsClesTrouves_stored_boolean"));
	}

	protected void _classKeywords(Wrap<List<String>> c) {
		List<String> o = (List<String>)classSolrDocument.get("classeMotsCles_stored_strings");
		if(o == null)
			o = new ArrayList<>();
		c.o(o);
	}

	protected void _classPublicRead(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classePublicLire_stored_boolean"));
	}

	protected void _classSearchPagePublicRead(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classePageRecherchePublicLire_stored_boolean"));
	}

	protected void _classRoleSession(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classeRoleSession_stored_boolean"));
	}

	protected void _classRoleUser(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classeRoleUtilisateur_stored_boolean"));
	}

	protected void _classRoleAll(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classeRoleChacun_stored_boolean"));
	}

	protected void _classAuth(Wrap<Boolean> c) {
		c.o(BooleanUtils.isTrue((Boolean)classSolrDocument.get("classeAuth_stored_boolean")));
	}

	protected void _classRolesFound(Wrap<Boolean> c) {
		c.o((Boolean)classSolrDocument.get("classeRolesTrouves_stored_boolean"));
	}

	protected void _classRoles(Wrap<List<String>> c) {
		List<String> o = (List<String>)classSolrDocument.get("classeRoles_stored_strings");
		if(o == null)
			o = new ArrayList<>();
		c.o(o);
	}

	protected void _classRoleReads(Wrap<List<String>> c) {
		List<String> o = (List<String>)classSolrDocument.get("classeRoleLires_stored_strings");
		if(o == null)
			o = new ArrayList<>();
		c.o(o);
	}

	protected void _classRolesLanguage(Wrap<List<String>> c) {
		List<String> o = (List<String>)classSolrDocument.get("classeRolesLangue_stored_strings");
		if(o == null)
			o = new ArrayList<>();
		c.o(o);
	}

	protected void _languageName(Wrap<String> c) {
		c.o("enUS");
	}

	protected void _entitySolrDocument(Wrap<SolrResponse.Doc> c) {
	}

	String entityVar;

	String entityCanonicalName;

	String entityCanonicalNameGeneric;

	String entityVarApi;

	String entityDescription;

	String entityDisplayName;

	Integer entityMinLength;

	Integer entityMaxLength;

	Double entityMin;

	Double entityMax;

	Boolean entityOptional;

	String entityVarCapitalized;

	String entityJsonType;

	String entityListJsonType;

	String entityJsonFormat;

	Boolean entityPrimaryKey;

	Boolean entityStored;

	Boolean entityIndexed;

	Boolean entityKeywordsFound;

	List<String> entityKeywords;

	List<String> entityOptionsVar;

	List<String> entityOptionsDescription;

	public void  initEntity(SolrResponse.Doc entitySolrDocument) {
		setEntitySolrDocument(entitySolrDocument);
		entityVar = (String)entitySolrDocument.get("entiteVar_enUS_stored_string");
		entityVarCapitalized = (String)entitySolrDocument.get("entiteVarCapitalise_enUS_stored_string");
		entityVarApi = StringUtils.defaultIfBlank((String)entitySolrDocument.get("entiteVarApi_stored_string"), entityVar);
		entityKeywordsFound = BooleanUtils.isTrue((Boolean)entitySolrDocument.get("entiteMotsClesTrouves_stored_boolean"));
		entityKeywords = (List<String>)entitySolrDocument.get("entiteMotsCles_stored_strings");
		if(entityKeywords == null)
			entityKeywords = new ArrayList<>();
		entityCanonicalNameGeneric = (String)entitySolrDocument.get("entiteNomCanoniqueGenerique_enUS_stored_string");
		entityCanonicalName = (String)entitySolrDocument.get("entiteNomCanonique_enUS_stored_string");
		entityListJsonType = (String)entitySolrDocument.get("entiteListeTypeJson_stored_string");
		entityJsonType = (String)entitySolrDocument.get("entiteTypeJson_stored_string");
		entityJsonFormat = (String)entitySolrDocument.get("entiteFormatJson_stored_string");
		entityOptionsVar = (List<String>)entitySolrDocument.get("entiteOptionsVar_stored_strings");
		entityOptionsDescription = (List<String>)entitySolrDocument.get("entiteOptionsDescription_stored_strings");
		entityDescription = (String)entitySolrDocument.get("entiteDescription_stored_string");
	}

	public void  writeEntityHeaders() throws Exception, Exception {

		if(entityKeywords.contains(classApiMethod + ".header")) {
			wRequestHeaders.tl(4, "- name: ", entityVarApi);
			wRequestHeaders.tl(5, "in: header");
			wRequestHeaders.t(5, "description: ").yamlStr(6, entityDescription);
			if(entityKeywords.contains(classApiMethod + ".header.required"))
				wRequestHeaders.tl(5, "required: true");
			wRequestHeaders.tl(5, "type: ", entityJsonType);
		}
	}

	public void  writeEntitySchema(Integer numberTabs) throws Exception, Exception {
		writeEntitySchema(numberTabs, wRequestSchema, "request");
		writeEntitySchema(numberTabs, wResponseSchema, "response");
	}

	public void  writeEntitySchema(Integer numberTabs, AllWriter w, String apiRequestOrResponse) throws Exception, Exception {
		numberTabs = numberTabs == null ? (classApiMethod.contains("Search") && "response".equals(apiRequestOrResponse) ? 3 : ("PUT".equals(classApiMethodMethod) ? 3 : 0)) : numberTabs;
		if(entityJsonType != null) {

			if("PATCH".equals(classApiMethodMethod)) {

				// set //
				w.tl(4 + tabsSchema + numberTabs, "set", entityVarCapitalized, ":");
				w.tl(5 + tabsSchema + numberTabs, "type: ", entityJsonType);
				w.tl(5 + tabsSchema + numberTabs, "nullable: true");
				if(entityMin != null)
				w.tl(5 + tabsSchema + numberTabs, String.format("minimum: %s", entityMin));
				if(entityListJsonType == null && entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
					w.tl(5 + tabsSchema + numberTabs, "enum:");
					for(String entiteOptionVar : entityOptionsVar) {
						w.tl(6 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						
					}
				}
				if(entityListJsonType != null) {
					w.tl(5 + tabsSchema + numberTabs, "items:");
					w.tl(6 + tabsSchema + numberTabs, "type: ", entityListJsonType);
					if(entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
						w.tl(6 + tabsSchema + numberTabs, "enum:");
						for(String entiteOptionVar : entityOptionsVar) {
							w.tl(7 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						}
					}
				}
				if(StringUtils.isNotBlank(entityDescription))
					w.t(5 + tabsSchema + numberTabs, "description: ").yamlStr(7 + numberTabs, "- " + entityDescription);
				if(entityJsonFormat != null)
					w.tl(5 + tabsSchema + numberTabs, "format: ", entityJsonFormat);

				// remove //
				w.tl(4 + tabsSchema + numberTabs, "remove", entityVarCapitalized, ":");

				if(entityListJsonType == null)
					w.tl(5 + tabsSchema + numberTabs, "type: ", entityJsonType);
				else
					w.tl(5 + tabsSchema + numberTabs, "type: ", entityListJsonType);

				if(entityListJsonType == null && entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
					w.tl(5 + tabsSchema + numberTabs, "type: ", entityJsonType);
					w.tl(5 + tabsSchema + numberTabs, "enum:");
					for(String entiteOptionVar : entityOptionsVar) {
						w.tl(6 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						
					}
				}
				if(entityListJsonType != null) {
					if(entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
						w.tl(6 + tabsSchema + numberTabs, "enum:");
						for(String entiteOptionVar : entityOptionsVar) {
							w.tl(7 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						}
					}
				}
				if(StringUtils.isNotBlank(entityDescription))
					w.t(5 + tabsSchema + numberTabs, "description: ").yamlStr(7 + numberTabs, "- " + entityDescription);
				if(entityJsonFormat != null)
					w.tl(5 + tabsSchema + numberTabs, "format: ", entityJsonFormat);

				// removeAll //
				w.tl(4 + tabsSchema + numberTabs, "removeAll", entityVarCapitalized, ":");
				w.tl(5 + tabsSchema + numberTabs, "type: ", entityJsonType);
				if(entityListJsonType == null && entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
					w.tl(5 + tabsSchema + numberTabs, "enum:");
					for(String entiteOptionVar : entityOptionsVar) {
						w.tl(6 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						
					}
				}
				if(entityListJsonType != null) {
					w.tl(5 + tabsSchema + numberTabs, "items:");
					w.tl(6 + tabsSchema + numberTabs, "type: ", entityListJsonType);
					if(entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
						w.tl(6 + tabsSchema + numberTabs, "enum:");
						for(String entiteOptionVar : entityOptionsVar) {
							w.tl(7 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						}
					}
				}
				if(StringUtils.isNotBlank(entityDescription))
					w.t(5 + tabsSchema + numberTabs, "description: ").yamlStr(7 + numberTabs, "- " + entityDescription);
				if(entityJsonFormat != null)
					w.tl(5 + tabsSchema + numberTabs, "format: ", entityJsonFormat);

				if(entityListJsonType != null) {

					// add //
					w.tl(4 + tabsSchema + numberTabs, "add", entityVarCapitalized, ":");
					w.tl(5 + tabsSchema + numberTabs, "type: ", entityListJsonType);
					if(entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
						w.tl(6 + tabsSchema + numberTabs, "enum:");
						for(String entiteOptionVar : entityOptionsVar) {
							w.tl(7 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						}
					}
					if(StringUtils.isNotBlank(entityDescription))
						w.t(5 + tabsSchema + numberTabs, "description: ").yamlStr(7 + numberTabs, "- " + entityDescription);
					if(entityJsonFormat != null)
						w.tl(5 + tabsSchema + numberTabs, "format: ", entityJsonFormat);
	
					// addAll //
					w.tl(4 + tabsSchema + numberTabs, "addAll", entityVarCapitalized, ":");
					w.tl(5 + tabsSchema + numberTabs, "type: ", entityJsonType);
					if(entityListJsonType != null) {
						w.tl(5 + tabsSchema + numberTabs, "items:");
						w.tl(6 + tabsSchema + numberTabs, "type: ", entityListJsonType);
						if(entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
							w.tl(6 + tabsSchema + numberTabs, "enum:");
							for(String entiteOptionVar : entityOptionsVar) {
								w.tl(7 + tabsSchema + numberTabs, "- ", entiteOptionVar);
							}
						}
					}
					if(StringUtils.isNotBlank(entityDescription))
						w.t(5 + tabsSchema + numberTabs, "description: ").yamlStr(7 + numberTabs, "- " + entityDescription);
					if(entityJsonFormat != null)
						w.tl(5 + tabsSchema + numberTabs, "format: ", entityJsonFormat);
				}
			}
			else {
				w.tl(4 + tabsSchema + numberTabs, entityVarApi, ":");
	
				w.tl(5 + tabsSchema + numberTabs, "type: ", entityJsonType);
				if(entityListJsonType == null && entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
					w.tl(5 + tabsSchema + numberTabs, "enum:");
					for(String entiteOptionVar : entityOptionsVar) {
						w.tl(6 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						
					}
				}
				if(entityListJsonType != null) {
					w.tl(5 + tabsSchema + numberTabs, "items:");
					w.tl(6 + tabsSchema + numberTabs, "type: ", entityListJsonType);
					if(entityOptionsVar != null && entityOptionsDescription != null && entityOptionsVar.size() > 0 && entityOptionsDescription.size() == entityOptionsVar.size()) {
						w.tl(6 + tabsSchema + numberTabs, "enum:");
						for(String entiteOptionVar : entityOptionsVar) {
							w.tl(7 + tabsSchema + numberTabs, "- ", entiteOptionVar);
						}
					}
				}
				if(StringUtils.isNotBlank(entityDescription))
					w.t(5 + tabsSchema + numberTabs, "description: ").yamlStr(7 + numberTabs, "- " + entityDescription);
				if(entityJsonFormat != null)
					w.tl(5 + tabsSchema + numberTabs, "format: ", entityJsonFormat);
			}
		}
	}

	public void  writeApi(Boolean id) throws Exception, Exception {

		if(classPageCanonicalNameMethod != null && BooleanUtils.isFalse(id) && !"/".equals(classApiUriMethod))
			writeApi(true);

		if(id || !classUris.contains(classApiUriMethod)) {
			wPaths.tl(1, classApiUriMethod, (id ? "/{id}" : ""), ":");
			classUris.add(classApiUriMethod + (id ? "/{id}" : ""));
		}

		wPaths.tl(2, StringUtils.lowerCase(classApiMethodMethod), ":");
		wPaths.tl(3, "operationId: ", classApiOperationIdMethod, (id ? "Id" : ""));
		wPaths.tl(3, "x-vertx-event-bus: ", appName, "-", languageName, "-", classSimpleName);

		if(
				StringUtils.containsAny(classApiMethod, "POST", "PUT", "PATCH", "DELETE") 
					&& !(classRoleSession || classRoleUser || classRoleAll)
					&& classAuth
				|| !StringUtils.containsAny(classApiMethod, "POST", "PUT", "PATCH", "DELETE") && (
					BooleanUtils.isNotTrue(classRoleSession) 
					&& BooleanUtils.isNotTrue(classPublicRead) 
					&& BooleanUtils.isNotTrue(classSearchPagePublicRead && classApiMethod.equals("SearchPage") && !id)
					&& classAuth
				)
				) {
		// if(classRoleAll 
		// 		|| classRoleUserMethod 
		// 		|| classRolesFound && BooleanUtils.isNotTrue(classRoleSession) && BooleanUtils.isNotTrue(classPublicRead)
		// 		|| classRolesFound && BooleanUtils.isNotTrue(classRoleSession) && BooleanUtils.isTrue(classPublicRead) && StringUtils.equalsAny(classApiMethodMethod, "POST", "PUT", "PATCH", "DELETE")
		// 		) {
			String roleSecurity = (String)classSolrDocument.get(String.format("RoleSecurity_%s_stored_string", classApiMethod));
			if(roleSecurity == null || roleSecurity.equals("true")) {
				wPaths.tl(3, "security:");
	//			wPaths.tl(4, "- basicAuth: []");
				authClients.fieldNames().forEach(authClientOpenApiId -> {
					wPaths.tl(4, "- ", authClientOpenApiId, ":");
					wPaths.tl(5, "- profile");
				});
			} else {
				roleSecurity.toString();
			}
		}

		wPaths.t(3, "description: ").yamlStr(4, "");
		wPaths.t(3, "summary: ").yamlStr(4, "");
		if(StringUtils.isNotBlank(classApiTag)) {
			wPaths.tl(3, "tags:");
			wPaths.tl(4, "- ", classApiTag);
		}

		if(openApiVersionNumber == 2) {
			wPaths.tl(3, "produces:");
			wPaths.tl(4, "- ", classApiMediaType200Method);
		}
		if(!id && classFiware) {
			wRequestHeaders.tl(4, "- name: Fiware-Service");
			wRequestHeaders.tl(5, "in: header");
			wRequestHeaders.tl(5, "schema:");
			wRequestHeaders.tl(6, "type: string");
			wRequestHeaders.tl(4, "- name: Fiware-ServicePath");
			wRequestHeaders.tl(5, "in: header");
			wRequestHeaders.tl(5, "schema:");
			wRequestHeaders.tl(6, "type: string");
			wRequestHeaders.tl(4, "- name: NGSILD-Tenant");
			wRequestHeaders.tl(5, "in: header");
			wRequestHeaders.tl(5, "schema:");
			wRequestHeaders.tl(6, "type: string");
			wRequestHeaders.tl(4, "- name: NGSILD-Path");
			wRequestHeaders.tl(5, "in: header");
			wRequestHeaders.tl(5, "schema:");
			wRequestHeaders.tl(6, "type: string");
		}
	
		if(!wRequestHeaders.getEmpty() || "GET".equals(classApiMethodMethod) || "DELETE".equals(classApiMethodMethod) || "PUT".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
			wPaths.tl(3, "parameters:");
			wPaths.s(wRequestHeaders);

			wPaths.tl(4, "- name: vertx-web.session");
			wPaths.tl(5, "in: cookie");
			wPaths.tl(5, "schema:");
			wPaths.tl(6, "type: string");
			wPaths.tl(4, "- name: sessionIdBefore");
			wPaths.tl(5, "in: cookie");
			wPaths.tl(5, "schema:");
			wPaths.tl(6, "type: string");

			if(id || "GET".equals(classApiMethod)) {
				wPaths.tl(4, "- name: id");
				wPaths.tl(5, "in: path");
				wPaths.t(5, "description: ").yamlStr(6, "");
				wPaths.tl(5, "required: true");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: string");
			}
			if(classApiMethod.contains("Search") || classApiMethod.contains("PATCH") || classApiMethod.contains("PUT") || classApiMethod.contains("DELETE")) {
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: q");
				wPaths.tl(5, "description: 'The query parameter defines a query using standard query syntax. This parameter is mandatory.'");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: string");
				wPaths.tl(6, "default: '*:*'");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: fq");
				wPaths.tl(5, "description: 'The filter query parameter defines a query that can be used to restrict the superset of documents that can be returned, without influencing score. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: var");
				wPaths.tl(5, "description: 'The var parameters are additional optional variables and values to pass into the application. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "  type: string");
			}
			if(classApiMethod.contains("Search")) {
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: fl");
				wPaths.tl(5, "description: 'The field list parameter limits the information included in a query response to a specified list of fields. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: sort");
				wPaths.tl(5, "description: 'The sort parameter arranges search results in either ascending (asc) or descending (desc) order. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: start");
				wPaths.tl(5, "description: 'The start parameter specifies an offset into a query result set and instructs Solr to begin displaying results from this offset. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: integer");
				wPaths.tl(6, "default: 0");
				wPaths.tl(6, "minimum: 0");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: rows");
				wPaths.tl(5, "description: 'The rows parameter specifies the maximum number of documents from the complete result set that Solr should return to the client at one time. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: integer");
				if(contextRows == null)
					wPaths.tl(6, "default: 10");
				else
					wPaths.tl(6, "default: ", contextRows);
				wPaths.tl(6, "minimum: 0");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: facet");
				wPaths.tl(5, "description: 'The facet parameter enables facet counts in the query response. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: boolean");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: facet.range.start");
				wPaths.tl(5, "description: 'The facet.range.start parameter specifies the lower bound of the ranges. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: facet.range.end");
				wPaths.tl(5, "description: 'The facet.range.end specifies the upper bound of the ranges. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: facet.range.gap");
				wPaths.tl(5, "description: 'The span of each range expressed as a value to be added to the lower bound. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: facet.pivot");
				wPaths.tl(5, "description: 'The facet.pivot parameter defines the fields to use for the pivot. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: facet.range");
				wPaths.tl(5, "description: 'The facet.range parameter defines the field for which Solr should create range facets. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: facet.field");
				wPaths.tl(5, "description: 'The facet.field parameter identifies a field that should be treated as a facet. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: d");
				wPaths.tl(5, "description: 'The radial distance, usually in kilometers. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: integer");
				wPaths.tl(6, "minimum: 0");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: pt");
				wPaths.tl(5, "description: 'he center point using the format lat,lon if latitude & longitude. Otherwise, x,y for PointType or x y for RPT field types. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: sfield");
				wPaths.tl(5, "description: 'A spatial indexed field. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: score");
				wPaths.tl(5, "description: '(Advanced option; not supported by LatLonType (deprecated) or PointType) If the query is used in a scoring context (e.g., as the main query in q), this local parameter determines what scores will be produced. Valid values are: none, kilometers, miles, degrees, distance, recipDistance, overlapRatio, area, area2D'");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: distanceUnits");
				wPaths.tl(5, "description: 'This is used to specify the units for distance measurements used throughout the use of this field. This can be degrees, kilometers or miles. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: string");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: stats");
				wPaths.tl(5, "description: 'The Stats component returns simple statistics for numeric, string, and date fields within the document set. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: boolean");
				wPaths.tl(4, "- in: query");
				wPaths.tl(5, "name: stats.field");
				wPaths.tl(5, "description: 'Specifies a field for which statistics should be generated. '");
				wPaths.tl(5, "required: false");
				wPaths.tl(5, "schema:");
				wPaths.tl(6, "type: array");
				wPaths.tl(6, "items:");
				wPaths.tl(7, "type: string");
			}
		}

		if(openApiVersionNumber > 2) {
			if(classApiMethodMethod == null)
				throw new Exception("Expected a comment for " + this.toString() + " like : ApiMethod: ...");
			if(!classApiMethodMethod.contains("GET") && !classApiMethodMethod.contains("DELETE")) {
				wPaths.tl(3, "requestBody:");
				String strRequestDescription = wRequestDescription.toString();
				wPaths.t(4, "description: ").yamlStr(5, StringUtils.trim(strRequestDescription));
				wPaths.tl(4, "required: true");
				wPaths.tl(4, "content:");
				wPaths.tl(5, classApiMediaTypeRequestMethod, ":");
				wPaths.tl(6, "schema:");
				wPaths.tl(7, "$ref: '#/components/schemas/", classApiOperationIdMethodRequest, "'");
			}
		}
		else {
			wPaths.tl(4, "- name: \"", classApiOperationIdMethodRequest, "\"");
			wPaths.tl(5, "in: body");

			String strRequestDescription = wRequestDescription.toString();
			wPaths.t(5, "description: ").yamlStr(6, StringUtils.trim(strRequestDescription));
			
			wPaths.tl(5, "schema:");
			wPaths.tl(6, "$ref: '#/components/requestBodies/", classApiOperationIdMethodRequest, "'");
		}

		wPaths.tl(3, "responses:");
		wPaths.tl(4, "'200':");
		if(openApiVersionNumber > 2) {
			String strResponseDescription = wResponseDescription.toString();
			wPaths.t(5, "description: ").yamlStr(6, strResponseDescription);
			wPaths.tl(5, "content:");

			if("application/pdf".equals(classApiMediaType200Method))
				wPaths.tl(6, classApiMediaType200Method, ":");
			else
				wPaths.tl(6, classApiMediaType200Method, "; charset=utf-8:");
		}
		else {
	
			String strResponseDescription = wResponseDescription.toString();
			wPaths.t(5 + tabsResponses, "description: ").yamlStr(6, strResponseDescription);
		}

		wPaths.tl(5 + tabsResponses, "schema:");
		wPaths.tl(6 + tabsResponses, "$ref: '#/components/schemas/", classApiOperationIdMethodResponse, "'");
		if(!id) {
			if(openApiVersionNumber > 2) {
				if(!"GET".equals(classApiMethodMethod) && !"DELETE".equals(classApiMethodMethod)) {
					wRequestBodies.tl(2, classApiOperationIdMethodRequest, ":");
					wRequestBodies.tl(3, "content:");
					wRequestBodies.tl(4, "application/json:");
					wRequestBodies.tl(5, "schema:");
					wRequestBodies.tl(6, "$ref: '#/components/schemas/", classApiOperationIdMethodRequest, "'");
				}
				wRequestBodies.tl(2, classApiOperationIdMethodResponse, ":");
				wRequestBodies.tl(3, "content:");

				if("application/pdf".equals(classApiMediaType200Method))
					wRequestBodies.tl(4, classApiMediaType200Method, ":");
				else
					wRequestBodies.tl(4, classApiMediaType200Method, "; charset=utf-8:");

				wRequestBodies.tl(5, "schema:");
				wRequestBodies.tl(6, "$ref: '#/components/schemas/", classApiOperationIdMethodResponse, "'");
			}
	
			if(!"GET".equals(classApiMethodMethod) && !"DELETE".equals(classApiMethodMethod)) {
				wSchemas.tl(tabsSchema, classApiOperationIdMethodRequest, ":");
				wSchemas.tl(tabsSchema + 1, "allOf:");
				if(BooleanUtils.isTrue(classExtendsBase) && StringUtils.isNotBlank(classSuperApiOperationIdMethodRequest)) {
					wSchemas.tl(tabsSchema + 2, "- $ref: \"#/components/schemas/", classSuperApiOperationIdMethodRequest, "\"");
				}
				wSchemas.tl(tabsSchema + 2, "- type: object");
				wSchemas.tl(tabsSchema + 3, "properties:");
				if("PUT".equals(classApiMethodMethod)) {
					wSchemas.tl(tabsSchema + 4, "list:");
					wSchemas.tl(tabsSchema + 5, "type: array");
					wSchemas.tl(tabsSchema + 5, "items:");
					wSchemas.tl(tabsSchema + 6, "type: object");
					wSchemas.tl(tabsSchema + 6, "properties:");
					
				}
				wSchemas.s(wRequestSchema.toString());
			}

			wSchemas.tl(tabsSchema, classApiOperationIdMethodResponse, ":");
			wSchemas.tl(tabsSchema + 1, "allOf:");
			if("text/html".equals(classApiMediaType200Method)) {
				wSchemas.tl(tabsSchema + 2, "- type: string");
			}
			else if("application/pdf".equals(classApiMediaType200Method)) {
				wSchemas.tl(tabsSchema + 2, "- type: string");
				wSchemas.tl(tabsSchema + 2, "- format: binary");
			}
			else {
				if(BooleanUtils.isTrue(classExtendsBase) && StringUtils.isNotBlank(classSuperApiOperationIdMethodResponse)) {
					wSchemas.tl(tabsSchema + 2, "- $ref: \"#/components/schemas/", classSuperApiOperationIdMethodResponse, "\"");
				}
	
				if(classApiMethod.contains("Search")) {
					wSchemas.tl(tabsSchema + 2, "- type: object");
					wSchemas.tl(tabsSchema + 3, "properties:");
					wSchemas.tl(tabsSchema + 4, "startNum:");
					wSchemas.tl(tabsSchema + 5, "type: integer");
					wSchemas.tl(tabsSchema + 5, "minimum: 0");
					wSchemas.tl(tabsSchema + 4, "foundNum:");
					wSchemas.tl(tabsSchema + 5, "type: integer");
					wSchemas.tl(tabsSchema + 5, "minimum: 0");
					wSchemas.tl(tabsSchema + 4, "returnedNum:");
					wSchemas.tl(tabsSchema + 5, "type: integer");
					wSchemas.tl(tabsSchema + 5, "minimum: 0");
					wSchemas.tl(tabsSchema + 4, "list:");
					wSchemas.tl(tabsSchema + 5, "type: array");
					wSchemas.tl(tabsSchema + 5, "items:");
					wSchemas.tl(tabsSchema + 6, "type: object");
					if(!wResponseSchema.getEmpty())
						wSchemas.tl(tabsSchema + 6, "properties:");
				}
				else {
					wSchemas.tl(tabsSchema + 2, "- type: object");
					if(!wResponseSchema.getEmpty())
						wSchemas.tl(tabsSchema + 3, "properties:");
				}
				wSchemas.s(wResponseSchema.toString());
			}
		}
	}

	@Override()
	public int compareTo(ApiWriter o) {
		return ObjectUtils.compare(classApiUriMethod, o.getClassApiUriMethod());
	}

	@Override()
	public String toString() {
		return (String)classSolrDocument.get("classSimpleName_enUS_stored_string") + " " + classApiMethod;
	}
}
