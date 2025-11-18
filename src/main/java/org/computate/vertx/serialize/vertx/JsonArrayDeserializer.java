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
package org.computate.vertx.serialize.vertx;

import java.io.IOException;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import io.vertx.core.json.JsonArray;

/**
 * Keyword: classSimpleNameJsonArrayDeserializer
 */
public class JsonArrayDeserializer extends JsonDeserializer<JsonArray> {

	@Override
	public JsonArray deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
			throws IOException {
		String text = jsonParser.getText().strip();
		StringBuilder b = new StringBuilder();
		JsonToken token = jsonParser.currentToken();
		Stack<Boolean> isArrays = new Stack<>();
		while(token != null) {
			if(token == JsonToken.START_ARRAY) {
				if(!isArrays.isEmpty() && isArrays.peek()) {
					if(b.charAt(b.length() - 1) != '[')
						b.append(",");
				}
				isArrays.push(true);
				b.append(jsonParser.getText());
			} else if(token == JsonToken.END_ARRAY) {
				isArrays.pop();
				b.append(jsonParser.getText());
				if(isArrays.isEmpty())
					break;
			} else if(token == JsonToken.START_OBJECT) {
				if(!isArrays.isEmpty() && isArrays.peek()) {
					if(b.charAt(b.length() - 1) != '[')
						b.append(",");
				}
				isArrays.push(false);
				b.append(jsonParser.getText());
			} else if(token == JsonToken.END_OBJECT) {
				isArrays.pop();
				b.append(jsonParser.getText());
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
		return new JsonArray(text);
	}
}
