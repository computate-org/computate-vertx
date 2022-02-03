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
package org.computate.vertx.writer;

import java.io.IOException;
import java.util.List;

import org.computate.search.wrap.Wrap;
import org.computate.vertx.request.ComputateVertxSiteRequest;

/**
 * Keyword: classSimpleNameAllWriters
 **/
public class AllWriters extends AllWritersGen<Object> {

	protected void _siteRequest_(Wrap<ComputateVertxSiteRequest> c) {
	}

	public static AllWriters create(ComputateVertxSiteRequest siteRequest_, AllWriter...writers) {
		AllWriters o = new AllWriters();
		o.initDeepForClass(siteRequest_);
		o.addWriters(writers);
		return o;
	}

	protected void _writers(List<AllWriter> c) {
	}

	public AllWriters t(int numberTabs, Object...objects) {
		for(AllWriter writer : writers) {
			writer.t(numberTabs, objects);
		}
		return this;
	}

	public AllWriters tl(int numberTabs, Object...objects) {
		for(AllWriter writer : writers) {
			writer.tl(numberTabs, objects);
		}
		return this;
	}

	public AllWriters l(Object...objects) {
		for(AllWriter writer : writers) {
			writer.l(objects);
		}
		return this;
	}

	public AllWriters s(Object...objects) { 
		for(AllWriter writer : writers) {
			writer.s(objects);
		}
		return this;
	}

	public void  flushClose() throws IOException, IOException {
		for(AllWriter writer : writers) {
			writer.flushClose();
		}
	}

	@Override()
	public String toString() {
		return writers.get(0).toString();
	}
}
