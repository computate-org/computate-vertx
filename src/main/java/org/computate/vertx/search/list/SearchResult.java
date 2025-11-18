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

import org.computate.search.wrap.Wrap;
import org.computate.vertx.request.ComputateSiteRequest;

import io.vertx.core.json.JsonObject;

/**
 * Keyword: classSimpleNameSearchResult
 */
public class SearchResult extends SearchResultGen<Object> {

	protected void _siteRequest_(Wrap<ComputateSiteRequest> c) {
	}

	protected void _solrDocument(Wrap<JsonObject> c) {
	}

	protected void _resultIndex(Wrap<Long> c) {
	}
}