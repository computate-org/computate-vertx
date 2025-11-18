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
package org.computate.vertx.serialize.pgclient;

import java.io.IOException;

import org.computate.vertx.tool.VertxTool;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import io.vertx.pgclient.data.Point;

/**
 * Keyword: classSimpleNamePointSerializer
 */
public class PgClientPointSerializer extends JsonSerializer<Point> {

	public static String POINT_FORMAT = "%s,%s";

	@Override()
	public void  serialize(Point o, JsonGenerator generator, SerializerProvider provider) throws IOException, IOException {
		generator.writeObject(VertxTool.toGeoJson(o));
	}
}
