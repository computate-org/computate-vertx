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

import org.apache.commons.lang3.math.NumberUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import io.vertx.pgclient.data.Point;

/**
 * Keyword: classSimpleNamePointDeserializer
 */
public class PgClientPointDeserializer extends JsonDeserializer<Point> {

	@Override
	public Point deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {

		String[] vals = jsonParser.getText().split(",");
		if(vals.length == 2 && NumberUtils.isParsable(vals[0]) && NumberUtils.isParsable(vals[1]))
			return new Point(Double.parseDouble(vals[0]), Double.parseDouble(vals[1]));
		return null;
	}
}
