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

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.computate.search.request.SearchRequest;
import org.computate.search.response.solr.SolrResponse;
import org.computate.search.tool.SearchTool;
import org.computate.search.wrap.Wrap;
import org.computate.vertx.config.ComputateVertxConfigKeys;
import org.computate.vertx.model.user.ComputateVertxSiteUser;
import org.computate.vertx.request.ComputateVertxSiteRequest;

import io.vertx.core.Future;
import io.vertx.core.Promise;

/** 
 * Keyword: classSimpleNameSearchList
 */ 
public class SearchList<DEV> extends SearchListGen<DEV> implements Iterable<DEV> {

	public SearchList<DEV> q(String s) {
		request.q(s);
		return this;
	}
	public String getQuery() {
		return request.getQuery();
	}

	public SearchList<DEV> fq(String s) {
		request.fq(s);
		return this;
	}
	public List<String> getFilterQueries() {
		return request.getFilterQueries();
	}

	public SearchList<DEV> fl(String s) {
		request.fl(s);
		return this;
	}
	public List<String> getFields() {
		return request.getFields();
	}

	public SearchList<DEV> fl(String...fields) {
		request.fl(fields);
		return this;
	}

	public SearchList<DEV> rows(Long s) {
		request.rows(s);
		return this;
	}
	public SearchList<DEV> rows(Integer s) {
		request.rows(s);
		return this;
	}
	public Long getRows() {
		return request.getRows();
	}

	public SearchList<DEV> start(Long s) {
		request.start(s);
		return this;
	}
	public Long getStart() {
		return request.getStart();
	}

	public SearchList<DEV> sortAsc(String field) {
		request.sortAsc(field);
		return this;
	}
	public List<String> getSorts() {
		return request.getSorts();
	}

	public SearchList<DEV> sortDesc(String field) {
		request.sortDesc(field);
		return this;
	}

	public SearchList<DEV> sort(String field, String direction) {
		request.sort(field, direction);
		return this;
	}

	public SearchList<DEV> facetPivot(String s) {
		request.facetPivot(s);
		return this;
	}
	public List<String> getFacetPivots() {
		return request.getFacetPivots();
	}

	public SearchList<DEV> facet(Boolean facet) {
		request.facet(facet);
		return this;
	}
	public Boolean getFacet() {
		return request.getFacet();
	}

	public SearchList<DEV> facetLimit(Integer s) {
		request.facetLimit(s);
		return this;
	}
	public Integer getFacetLimit() {
		return request.getFacetLimit();
	}

	public SearchList<DEV> facetMinCount(Integer s) {
		request.facetMinCount(s);
		return this;
	}
	public Integer getFacetMinCount() {
		return request.getFacetMinCount();
	}

	public SearchList<DEV> facetOffset(Integer s) {
		request.facetOffset(s);
		return this;
	}
	public Integer getFacetOffset() {
		return request.getFacetOffset();
	}
	public void setFacetOffset(Integer facetOffset) {
		request.setFacetOffset(facetOffset);
	}

	public SearchList<DEV> facetRangeStart(String s) {
		request.facetRangeStart(s);
		return this;
	}
	public String getFacetRangeStart() {
		return request.getFacetRangeStart();
	}

	public SearchList<DEV> facetRangeEnd(String s) {
		request.facetRangeEnd(s);
		return this;
	}
	public String getFacetRangeEnd() {
		return request.getFacetRangeEnd();
	}

	public SearchList<DEV> facetRangeGap(String s) {
		request.facetRangeGap(s);
		return this;
	}
	public String getFacetRangeGap() {
		return request.getFacetRangeGap();
	}

	public SearchList<DEV> facetField(String s) {
		request.facetField(s);
		return this;
	}
	public List<String> getFacetFields() {
		return request.getFacetFields();
	}

	public SearchList<DEV> facetRange(String s) {
		request.facetRange(s);
		return this;
	}
	public List<String> getFacetRanges() {
		return request.getFacetRanges();
	}

	public SearchList<DEV> cursorMark(String s) {
		request.cursorMark(s);
		return this;
	}
	public String getCursorMark() {
		return request.getCursorMark();
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _c(Wrap<Class<?>> c) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _siteRequest_(Wrap<ComputateVertxSiteRequest> c) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _store(Wrap<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _populate(Wrap<Boolean> c) {
		c.o(false);
	}

	public DEV get(Integer index) {
		return list.get(index);
	}

	public Future<Boolean> next() {
		Promise<Boolean> promise = Promise.promise();
		try {
			Long start = Optional.ofNullable(request.getStart()).orElse(0L);
			Long rows = Optional.ofNullable(request.getRows()).orElse(0L);
			Long numFound = Optional.ofNullable(queryResponse).map(r -> r.getResponse()).map(r -> r.getNumFound()).orElse(0L);
			if(rows > 0 && (start + rows) < numFound) {
				request.setStart(start + rows);
				String solrHostName = siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = siteRequest_.getConfig().getInteger(ComputateVertxConfigKeys.SOLR_PORT);
				String solrCollection = siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SOLR_COLLECTION);
				String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, request.getQueryString());
				siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).send().onSuccess(a -> {
					SolrResponse response = a.bodyAsJson(SolrResponse.class);
					setQueryResponse(response);
					Wrap<List<SolrResponse.Doc>> docsWrap = new Wrap<List<SolrResponse.Doc>>().var("docs").o(response.getResponse().getDocs());
					_docs(docsWrap);
					setDocs(docsWrap.o);
					list.clear();
					_list(list);

					promise.complete(true);
				}).onFailure(ex -> {
					LOG.error(String.format("Search failed. "), ex);
					promise.fail(ex);
				});
			} else {
				promise.complete(false);
			}
		} catch (Exception ex) {
			promise.fail(ex);
			LOG.error(String.format("Solr search failed. "), ex);
		}
		return promise.future();
	}

	public Future<Boolean> query() {
		Promise<Boolean> promise = Promise.promise();
		try {
			String solrHostName = siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SOLR_HOST_NAME);
			Integer solrPort = siteRequest_.getConfig().getInteger(ComputateVertxConfigKeys.SOLR_PORT);
			String solrCollection = siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SOLR_COLLECTION);
			String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, request.getQueryString());
			siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).send().onSuccess(a -> {
				SolrResponse response = a.bodyAsJson(SolrResponse.class);
				setQueryResponse(response);
				Wrap<List<SolrResponse.Doc>> docsWrap = new Wrap<List<SolrResponse.Doc>>().var("docs").o(response.getResponse().getDocs());
				_docs(docsWrap);
				setDocs(docsWrap.o);
				list.clear();
				_list(list);

				promise.complete(true);
			}).onFailure(ex -> {
				promise.fail(ex);
				LOG.error(String.format("Solr search failed. "), ex);
			});
		} catch (Exception ex) {
			promise.fail(ex);
			LOG.error(String.format("Solr search failed. "), ex);
		}
		return promise.future();
	}

	/**
	 * {@inheritDoc}
	 */
	protected void _request(SearchRequest o) {
		if(request.getQuery() != null) {
			if(this.c != null)
				request.fq("classCanonicalName_docvalues_string:" + SearchTool.escapeQueryChars(this.c.getCanonicalName()));
			ComputateVertxSiteUser siteUser = siteRequest_.getSiteUser_(ComputateVertxSiteUser.class);
			if(siteUser == null || BooleanUtils.isNotTrue(siteUser.getSeeDeleted()))
				request.fq("deleted_docvalues_boolean:false");
			if(siteUser == null || BooleanUtils.isNotTrue(siteUser.getSeeArchived()))
				request.fq("archived_docvalues_boolean:false");
		}
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _queryResponse(Promise<SolrResponse> promise) {        
		try {
			if(request.getQuery() != null) {
				request.initDeepForClass(siteRequest_);
				String solrHostName = siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SOLR_HOST_NAME);
				Integer solrPort = siteRequest_.getConfig().getInteger(ComputateVertxConfigKeys.SOLR_PORT);
				String solrCollection = siteRequest_.getConfig().getString(ComputateVertxConfigKeys.SOLR_COLLECTION);
				String solrRequestUri = String.format("/solr/%s/select%s", solrCollection, request.getQueryString());
				siteRequest_.getWebClient().get(solrPort, solrHostName, solrRequestUri).send().onSuccess(a -> {
					try {
						SolrResponse queryResponse = a.bodyAsJson(SolrResponse.class);
						setQueryResponse(queryResponse);
						promise.complete(queryResponse);
					} catch(Exception ex) {
						LOG.error(String.format("Could not read response from Solr: http://%s:%s%s", solrHostName, solrPort, solrRequestUri), ex);
						promise.fail(ex);
					}
				}).onFailure(ex -> {
					LOG.error(String.format("Search failed. "), new RuntimeException(ex));
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch (Exception ex) {
			promise.fail(ex);
			LOG.error(String.format("Search failed. "), ex);
		}
	}

	private void searchFacetPivot() {
		
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _docs(Wrap<List<SolrResponse.Doc>> w) {
		if(request.getQuery() != null) {
			w.o(queryResponse.getResponse().getDocs());
		}
	}

	protected void _list(List<DEV> l) {
		if(request.getQuery() != null) {
			for(SolrResponse.Doc doc : docs) {
				Map<String, Object> fields = doc.getFields();
				try {
					if(doc != null) {
						String classCanonicalName = (String)fields.get("classCanonicalName_docvalues_string");
						DEV o = (DEV)Class.forName(classCanonicalName).newInstance();
						MethodUtils.invokeMethod(o, "setSiteRequest_", siteRequest_);
						if(populate)
							MethodUtils.invokeMethod(o, "populateForClass", doc);
						if(store)
							MethodUtils.invokeMethod(o, "storeForClass", doc);
						l.add(o);
					}
				} catch (InstantiationException | IllegalAccessException | NoSuchMethodException
						| InvocationTargetException | ClassNotFoundException e) {
					ExceptionUtils.rethrow(e);
				}
			}
		}
	}

	protected void _first(Wrap<Object> w) {
		if(list.size() > 0)
			w.o(list.get(0));
	}

	public DEV first() {
		if(list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public int getSize() {
		return list.size();
	}

	public int size() {
		return list.size();
	}

	@Override()
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		try {
			sb.append(URLDecoder.decode(request.toString(), "UTF-8")).append("\n");
		} catch (UnsupportedEncodingException e) {
			ExceptionUtils.rethrow(e);
		}
		Long numFound = Optional.ofNullable(getQueryResponse()).map(l -> l.getResponse()).map(r -> r.getNumFound()).orElse(null);
		if(numFound != null)
			sb.append("numFound: ").append(numFound).append("\n");
		return sb.toString();
	}

	@Override
	public Iterator<DEV> iterator() {
		return list.iterator();
	}

	public <T extends ComputateVertxSiteRequest> T getSiteRequest_(Class<T> clazz) {
		return (T)siteRequest_;
	}
}
