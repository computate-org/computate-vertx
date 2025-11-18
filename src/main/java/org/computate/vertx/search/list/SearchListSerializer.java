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
package org.computate.vertx.search.list;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;

/**
 * Keyword: classSimpleNamePathSerializer
 */
public class SearchListSerializer extends JsonSerializer<SearchList<?>> {

	@Override()
	public void serialize(SearchList<?> o, JsonGenerator generator, SerializerProvider provider) throws IOException, IOException {
		if(o != null) {
			JsonObject result = new JsonObject();
			JsonArray list = new JsonArray();
			result.put("list", list);
			for(Object o2 : o.getList()) {
				list.add(JsonObject.mapFrom(o2));
			}
			generator.writeObject(result.toString());
		}
	}
}
