/*
 * Copyright Computate Limited Liability Company in Utah, USA. 
 * SPDX-License-Identifier: AGPL-3.0
 * This program and the accompanying materials are made available under the
 * terms of the GNU AFFERO GENERAL PUBLIC LICENSE which is available at
 * 
 * https://www.gnu.org/licenses/agpl-3.0.html
 * 
 * You may not propagate or modify a covered work except as expressly provided 
 * under this License. Any attempt otherwise to propagate or modify it is void, 
 * and will automatically terminate your rights under this License (including 
 * any patent licenses granted under the third paragraph of section 11).
 */
package org.computate.vertx.openapi;

import java.util.Optional;

import org.computate.vertx.config.ComputateConfigKeys;

import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

/**
 * InitDeepBefore: true
 */
public class Swagger2Generator extends Swagger2GeneratorGen<FiwareGenerator> {

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
	 * Val.Error.enUS: An error occured while writing the API. 
	 * Val.Error2.enUS: An error occured while writing the API. 
	 */
	public Future<Void> writeApi() {
		Promise<Void> promise = Promise.promise();

		try {
			JsonObject authClients = Optional.ofNullable(config.getValue(ComputateConfigKeys.AUTH_CLIENTS))
					.map(v -> v instanceof JsonObject ? (JsonObject)v : new JsonObject(v.toString()))
					.orElse(new JsonObject().put(Optional.ofNullable(config.getString(ComputateConfigKeys.AUTH_OPEN_API_ID)).orElse("openIdConnect"), config))
					;

			wPaths.tl(0, "paths:");

			if(openApiVersionNumber == 2) {
				wSchemas.tl(0, "definitions:");
			}
			else {
				wRequestBodies.tl(0, "components:");
				if(authClients.size() > 0) {
					authClients.fieldNames().forEach(authClientOpenApiId -> {
						JsonObject authClient = authClients.getJsonObject(authClientOpenApiId);
							wRequestBodies.tl(1, "securitySchemes:");
								wRequestBodies.tl(2, authClientOpenApiId, ":");
								wRequestBodies.tl(3, "type: openIdConnect");
								wRequestBodies.tl(3, "openIdConnectUrl: ", authClient.getString(ComputateConfigKeys.AUTH_URL), "/realms/", authClient.getString(ComputateConfigKeys.AUTH_REALM), "/.well-known/openid-configuration");
					});
				}
				wRequestBodies.tl(1, "requestBodies:");

				wSchemas.tl(1, "schemas:");
			}

			loadClasses().onSuccess(classDoc -> {
				authClients.fieldNames().forEach(authClientOpenApiId -> {
					JsonObject authClient = authClients.getJsonObject(authClientOpenApiId);
					String authCallbackUri = authClient.getString(ComputateConfigKeys.AUTH_CALLBACK_URI);
					String authLogoutUri = authClient.getString(ComputateConfigKeys.AUTH_LOGOUT_URI);
	
					wPaths.l();
					wPaths.tl(1, authLogoutUri, ":");
					wPaths.tl(2, "get:");
					wPaths.tl(3, "operationId: logout");
					wPaths.tl(3, "x-vertx-event-bus: ", appName, "-", languageName, "-", authClientOpenApiId, "-logout");
					wPaths.tl(3, "description: >+");
					wPaths.tl(3, "responses:");
					wPaths.tl(4, "'200':");
					wPaths.tl(5, "description: >+");
					wPaths.tl(5, "content:");
					wPaths.tl(6, "application/json; charset=utf-8:");
					wPaths.tl(7, "schema:");
					wPaths.tl(8, "type: string");
				});
				authClients.fieldNames().forEach(authClientOpenApiId -> {
					JsonObject authClient = authClients.getJsonObject(authClientOpenApiId);
					String authCallbackUri = authClient.getString(ComputateConfigKeys.AUTH_CALLBACK_URI);
					String authLogoutUri = authClient.getString(ComputateConfigKeys.AUTH_LOGOUT_URI);
	
					wPaths.l();
					wPaths.tl(1, authCallbackUri, ":");
					wPaths.tl(2, "get:");
					wPaths.tl(3, "operationId: callback");
					wPaths.tl(3, "x-vertx-event-bus: ", appName, "-", languageName, "-", authClientOpenApiId, "-callback");
					wPaths.tl(3, "description: >+");
					wPaths.tl(3, "responses:");
					wPaths.tl(4, "'200':");
					wPaths.tl(5, "description: >+");
					wPaths.tl(5, "content:");
					wPaths.tl(6, "application/json; charset=utf-8:");
					wPaths.tl(7, "schema:");
					wPaths.tl(8, "type: string");
				});

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
}
