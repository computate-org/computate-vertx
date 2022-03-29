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
package org.computate.vertx.serialize.pgclient;

import java.io.IOException;
import java.time.LocalDate;

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
		generator.writeString(String.format(POINT_FORMAT, o.getX(), o.getY()));
	}
}
