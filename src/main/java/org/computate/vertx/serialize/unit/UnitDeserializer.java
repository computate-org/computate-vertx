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
package org.computate.vertx.serialize.unit;

import java.io.IOException;

import javax.measure.Unit;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import tech.units.indriya.format.SimpleUnitFormat;

/**
 * Keyword: classSimpleNameUnit<?>Deserializer
 */
public class UnitDeserializer extends JsonDeserializer<Unit<?>> {

	@Override
	public Unit<?> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
		return SimpleUnitFormat.getInstance().parse(jsonParser.getText());
	}
}
