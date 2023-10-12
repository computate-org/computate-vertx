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

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

/**
 * Keyword: classSimpleNamePolygonDeserializer
 */
public class PgClientPolygonDeserializer extends JsonDeserializer<Polygon> {

	@Override
	public Polygon deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		String text = jsonParser.getText();
		Polygon polygon = new Polygon();

		if(StringUtils.startsWith(text, "[")) {
			String[] pathVals;

			text = text.replaceAll("\\s", "");
			pathVals = StringUtils.substringBeforeLast(StringUtils.substringAfter(text, "[("), ")]").split("\\),\\(");
			for(String pointStr : pathVals) {
				String[] pointVals = pointStr.split(",");
				if(pointVals.length == 2 && NumberUtils.isParsable(pointVals[0]) && NumberUtils.isParsable(pointVals[1]))
					polygon.addPoint(new Point(Double.parseDouble(pointVals[0]), Double.parseDouble(pointVals[1])));
			}
		} else {
			JsonObject json = new JsonObject(text);

			if(json.getJsonArray("coordinates").stream().findFirst().map(a -> (JsonArray)a).orElse(new JsonArray()).stream().findFirst().map(a -> (a instanceof JsonArray)).orElse(false)) {
				for(Object shapesObject : json.getJsonArray("coordinates")) {
					JsonArray shapes = (JsonArray)shapesObject;
					for(Object pointObject : shapes) {
						JsonArray points = (JsonArray)pointObject;
						if(points.size() == 2)
							polygon.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
					}
				}
			} else {
				for(Object pointObject : json.getJsonArray("coordinates")) {
					JsonArray points = (JsonArray)pointObject;
					if(points.size() == 2)
						polygon.addPoint(new Point(Double.parseDouble(points.getString(0)), Double.parseDouble(points.getString(1))));
				}
			}
		}
		return polygon;
	}
}
