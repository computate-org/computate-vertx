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
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.text.StringEscapeUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
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

		if(StringUtils.equals(text, "{")) {
			StringBuilder b = new StringBuilder();
			b.append(text);
			JsonToken token = jsonParser.nextToken();
			Stack<Boolean> isArrays = new Stack<>();
			isArrays.push(false);
			while(token != null) {
				if(token == JsonToken.START_ARRAY) {
					if(isArrays.peek()) {
						if(b.charAt(b.length() - 1) != '[')
							b.append(",");
					}
					isArrays.push(true);
					b.append(jsonParser.getText());
				} else if(token == JsonToken.END_ARRAY) {
					isArrays.pop();
					b.append(jsonParser.getText());
				} else if(token == JsonToken.START_OBJECT) {
					if(isArrays.peek()) {
						if(b.charAt(b.length() - 1) != '[')
							b.append(",");
					}
					isArrays.push(false);
					b.append(jsonParser.getText());
				} else if(token == JsonToken.END_OBJECT) {
					isArrays.pop();
					b.append(jsonParser.getText());
					if(isArrays.isEmpty())
						break;
				} else if(token == JsonToken.FIELD_NAME) {
					if(b.charAt(b.length() - 1) != '{')
						b.append(",");
					b.append("\"").append(StringEscapeUtils.escapeJson(jsonParser.getText())).append("\":");
				} else if(token.isBoolean() || token.isNumeric() || token.isStructEnd() || token.isStructStart()) {
					if(isArrays.peek()) {
						if(b.charAt(b.length() - 1) != '[')
							b.append(",");
					}
					b.append(jsonParser.getText());
				} else {
					if(isArrays.peek())
						b.append(",");
					b.append("\"").append(StringEscapeUtils.escapeJson(jsonParser.getText())).append("\"");
				}
				token = jsonParser.nextToken();
			}
			text = b.toString();
		}
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
