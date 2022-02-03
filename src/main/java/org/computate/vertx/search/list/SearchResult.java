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
package org.computate.vertx.search.list;

import org.computate.search.wrap.Wrap;
import org.computate.vertx.request.ComputateVertxSiteRequest;

import io.vertx.core.json.JsonObject;

/**
 * Keyword: classSimpleNameSearchResult
 */
public class SearchResult extends SearchResultGen<Object> {

	protected void _siteRequest_(Wrap<ComputateVertxSiteRequest> c) {
	}

	protected void _solrDocument(Wrap<JsonObject> c) {
	}

	protected void _resultIndex(Wrap<Long> c) {
	}
}