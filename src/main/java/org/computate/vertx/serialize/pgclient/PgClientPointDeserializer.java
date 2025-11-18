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
import java.util.ArrayList;
import java.util.Stack;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.text.StringEscapeUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.github.jknack.handlebars.internal.lang3.StringUtils;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Point;

/**
 * Keyword: classSimpleNamePointDeserializer
 */
public class PgClientPointDeserializer extends JsonDeserializer<Point> {

	@Override
	public Point deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {

		String text = jsonParser.getText().strip();

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
		if(StringUtils.startsWith(text, "{")) {
			JsonObject json = new JsonObject(text);
			Point point = new Point();
			JsonArray points = json.getJsonArray("coordinates");

			if(points.size() == 2) {
				point.setX(Double.parseDouble(points.getString(0)));
				point.setY(Double.parseDouble(points.getString(1)));
				return point;
			}
			return null;
		} else {
			String[] vals = jsonParser.getText().split(",");
			if(vals.length == 2 && NumberUtils.isParsable(vals[0].strip()) && NumberUtils.isParsable(vals[1].strip()))
				return new Point(Double.parseDouble(vals[1].strip()), Double.parseDouble(vals[0].strip()));
			return null;
		}
	}
}
