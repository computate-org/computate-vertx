package org.computate.vertx.result.java;

import org.computate.vertx.request.ComputateSiteRequest;
import org.computate.vertx.model.user.ComputateSiteUser;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.computate.vertx.search.list.SearchList;
import org.computate.search.wrap.Wrap;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.core.json.JsonArray;
import java.net.URLDecoder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
import java.util.Objects;
import io.vertx.core.Promise;
import org.computate.vertx.config.ComputateConfigKeys;
import org.computate.search.response.solr.SolrResponse;
import java.util.HashMap;
import org.computate.search.tool.TimeTool;
import java.time.ZoneId;


/**
 * Translate: false
 **/
public class ComputateJavaClassGenPage extends ComputateJavaClassGenPageGen<Object> {

	/**
	 * Ignore: true
	**/
	protected void _siteRequest_(Wrap<ComputateSiteRequest> c) {
	}

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 **/
	protected void _searchListComputateJavaClass_(Wrap<SearchList<ComputateJavaClass>> w) {
	}

	protected void _pageResponse(Wrap<String> w) {
		if(searchListComputateJavaClass_ != null)
			w.o(JsonObject.mapFrom(searchListComputateJavaClass_.getResponse()).toString());
	}

	protected void _stats(Wrap<SolrResponse.Stats> w) {
		w.o(searchListComputateJavaClass_.getResponse().getStats());
	}

	protected void _facetCounts(Wrap<SolrResponse.FacetCounts> w) {
		w.o(searchListComputateJavaClass_.getResponse().getFacetCounts());
	}

	protected void _pagination(JsonObject pagination) {
		JsonArray pages = new JsonArray();
		Long start = searchListComputateJavaClass_.getStart().longValue();
		Long rows = searchListComputateJavaClass_.getRows().longValue();
		Long foundNum = searchListComputateJavaClass_.getResponse().getResponse().getNumFound().longValue();
		Long startNum = start + 1L;
		Long endNum = start + rows;
		Long floorMod = (rows == 0L ? 0L : Math.floorMod(foundNum, rows));
		Long last = (rows == 0L ? 0L : Math.floorDiv(foundNum, rows) - (floorMod.equals(0L) ? 1L : 0L) * rows);
		endNum = endNum < foundNum ? endNum : foundNum;
		startNum = foundNum == 0L ? 0L : startNum;
		Long paginationStart = start - 10L * rows;
		if(paginationStart < 0L)
			paginationStart = 0L;
		Long paginationEnd = start + 10L * rows;
		if(paginationEnd > foundNum)
			paginationEnd = foundNum;

		pagination.put("1L", 1L);
		pagination.put("0L", 0L);
		pagination.put("start", start);
		pagination.put("rows", rows);
		pagination.put("rowsPrevious", rows / 2);
		pagination.put("rowsNext", rows * 2);
		pagination.put("startNum", startNum);
		pagination.put("endNum", endNum);
		pagination.put("foundNum", foundNum);
		pagination.put("pageStart", new JsonObject().put("start", 0L).put("pageNumber", 1L));
		if(start > 0L)
			pagination.put("pagePrevious", new JsonObject().put("start", start - rows).put("pageNumber", start - rows + 1L));
		if(start + rows < foundNum)
			pagination.put("pageNext", new JsonObject().put("start", start + rows).put("pageNumber", start + rows + 1L));
		pagination.put("pageEnd", new JsonObject().put("start", last).put("pageNumber", last + 1L));
		pagination.put("pages", pages);
		for(Long i = paginationStart; i < paginationEnd; i += rows) {
			Long pageNumber = Math.floorDiv(i, rows) + 1L;
			JsonObject page = new JsonObject();
			page.put("pageNumber", pageNumber);
			page.put("currentPage", start.equals(i));
			page.put("start", i);
			pages.add(page);
		}
	}

	protected void _varsQ(JsonObject vars) {
		ComputateJavaClass.varsQForClass().forEach(var -> {
			JsonObject json = new JsonObject();
			json.put("var", var);
			json.put("displayName", Optional.ofNullable(ComputateJavaClass.displayNameComputateJavaClass(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
			json.put("classSimpleName", Optional.ofNullable(ComputateJavaClass.classSimpleNameComputateJavaClass(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
			json.put("val", Optional.ofNullable(searchListComputateJavaClass_.getRequest().getQuery()).filter(fq -> fq.startsWith(ComputateJavaClass.varIndexedComputateJavaClass(var) + ":")).map(s -> StringUtils.substringAfter(s, ":")).orElse(null));
			vars.put(var, json);
		});
	}

	protected void _varsFq(JsonObject vars) {
		Map<String, SolrResponse.FacetField> facetFields = Optional.ofNullable(facetCounts).map(c -> c.getFacetFields()).map(f -> f.getFacets()).orElse(new HashMap<String,SolrResponse.FacetField>());
		ComputateJavaClass.varsFqForClass().forEach(var -> {
			String varIndexed = ComputateJavaClass.varIndexedComputateJavaClass(var);
			String varStored = ComputateJavaClass.varStoredComputateJavaClass(var);
			JsonObject json = new JsonObject();
			json.put("var", var);
			json.put("varStored", varStored);
			json.put("varIndexed", varIndexed);
			String type = StringUtils.substringAfterLast(varIndexed, "_");
			json.put("displayName", Optional.ofNullable(ComputateJavaClass.displayNameComputateJavaClass(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
			json.put("classSimpleName", Optional.ofNullable(ComputateJavaClass.classSimpleNameComputateJavaClass(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
			json.put("val", searchListComputateJavaClass_.getRequest().getFilterQueries().stream().filter(fq -> fq.startsWith(ComputateJavaClass.varIndexedComputateJavaClass(var) + ":")).findFirst().map(s -> StringUtils.substringAfter(s, ":")).orElse(null));
			Optional.ofNullable(stats).map(s -> s.get(varIndexed)).ifPresent(stat -> {
				json.put("stats", JsonObject.mapFrom(stat));
			});
			Optional.ofNullable(facetFields.get(varIndexed)).ifPresent(facetField -> {
				JsonObject facetJson = new JsonObject();
				JsonObject counts = new JsonObject();
				facetJson.put("var", var);
				facetField.getCounts().forEach((val, count) -> {
					counts.put(val, count);
				});
				facetJson.put("counts", counts);
				json.put("facetField", facetJson);
			});
			if(defaultFieldListVars.contains(var)) {
				json.put("fieldList", true);
			}
			if(StringUtils.equalsAny(type, "date") && json.containsKey("stats")) {
				JsonObject stats = json.getJsonObject("stats");
				Instant min = Instant.parse(stats.getString("min"));
				Instant max = Instant.parse(stats.getString("max"));
				Duration duration = Duration.between(min, max);
				String gap = "DAY";
				if(duration.toDays() >= 365)
					gap = "YEAR";
				else if(duration.toDays() >= 28)
					gap = "MONTH";
				else if(duration.toDays() >= 1)
					gap = "DAY";
				else if(duration.toHours() >= 1)
					gap = "HOUR";
				else if(duration.toMinutes() >= 1)
					gap = "MINUTE";
				else if(duration.toMillis() >= 1000)
					gap = "SECOND";
				else if(duration.toMillis() >= 1)
					gap = "MILLI";
				json.put("defaultRangeGap", String.format("+1%s", gap));
				json.put("defaultRangeEnd", stats.getString("max"));
				json.put("defaultRangeStart", stats.getString("min"));
				json.put("enableCalendar", true);
				setDefaultRangeStats(json);
			}
			json.put("enableStats", !StringUtils.equalsAny(type, "boolean", "location"));
			if(defaultStatsVars.contains(var)) {
				SolrResponse.StatsField varStats = stats.get(varIndexed);
				if(varStats != null)
					json.put("stats", varStats);
			}
			if(defaultPivotVars.contains(var)) {
				json.put("pivot", true);
			}
			vars.put(var, json);
		});
	}

	protected void _varsRange(JsonObject vars) {
		ComputateJavaClass.varsRangeForClass().forEach(var -> {
			String varIndexed = ComputateJavaClass.varIndexedComputateJavaClass(var);
			JsonObject json = new JsonObject();
			json.put("var", var);
			json.put("displayName", Optional.ofNullable(ComputateJavaClass.displayNameComputateJavaClass(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
			json.put("classSimpleName", Optional.ofNullable(ComputateJavaClass.classSimpleNameComputateJavaClass(var)).map(d -> StringUtils.isBlank(d) ? var : d).orElse(var));
			json.put("val", searchListComputateJavaClass_.getRequest().getFilterQueries().stream().filter(fq -> fq.startsWith(ComputateJavaClass.varIndexedComputateJavaClass(var) + ":")).findFirst().map(s -> StringUtils.substringAfter(s, ":")).orElse(null));
			vars.put(var, json);
		});
	}

	protected void _query(JsonObject query) {
		ServiceRequest serviceRequest = siteRequest_.getServiceRequest();
		JsonObject params = serviceRequest.getParams();

		JsonObject queryParams = Optional.ofNullable(serviceRequest).map(ServiceRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
		Long num = searchListComputateJavaClass_.getResponse().getResponse().getNumFound().longValue();
		String q = "*:*";
		String q1 = "objectText";
		String q2 = "";
		for(String paramName : queryParams.fieldNames()) {
			String entityVar = null;
			String valueIndexed = null;
			Object paramObjectValues = queryParams.getValue(paramName);
			JsonArray paramObjects = paramObjectValues instanceof JsonArray ? (JsonArray)paramObjectValues : new JsonArray().add(paramObjectValues);

			try {
				for(Object paramObject : paramObjects) {
					switch(paramName) {
					case "q":
						q = (String)paramObject;
						entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
						valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
						q1 = entityVar.equals("*") ? q1 : entityVar;
						q2 = valueIndexed;
						q = q1 + ":" + q2;
					}
				}
			} catch(Exception e) {
				ExceptionUtils.rethrow(e);
			}
		}
		query.put("q", q);

		Long rows1 = Optional.ofNullable(searchListComputateJavaClass_).map(l -> l.getRows()).orElse(10L);
		Long start1 = Optional.ofNullable(searchListComputateJavaClass_).map(l -> l.getStart()).orElse(1L);
		Long start2 = start1 - rows1;
		Long start3 = start1 + rows1;
		Long rows2 = rows1 / 2;
		Long rows3 = rows1 * 2;
		start2 = start2 < 0 ? 0 : start2;
		JsonObject fqs = new JsonObject();
		for(String fq : Optional.ofNullable(searchListComputateJavaClass_).map(l -> l.getFilterQueries()).orElse(Arrays.asList())) {
			if(!StringUtils.contains(fq, "(")) {
				String fq1 = ComputateJavaClass.searchVarComputateJavaClass(StringUtils.substringBefore(fq, ":"));
				String fq2 = StringUtils.substringAfter(fq, ":");
				if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
					fqs.put(fq1, new JsonObject().put("var", fq1).put("val", fq2).put("displayName", ComputateJavaClass.displayNameForClass(fq1)));
				}
			}
		query.put("fq", fqs);

		JsonArray sorts = new JsonArray();
		for(String sort : Optional.ofNullable(searchListComputateJavaClass_).map(l -> l.getSorts()).orElse(Arrays.asList())) {
			String sort1 = ComputateJavaClass.searchVarComputateJavaClass(StringUtils.substringBefore(sort, " "));
			sorts.add(new JsonObject().put("var", sort1).put("order", StringUtils.substringAfter(sort, " ")).put("displayName", ComputateJavaClass.displayNameForClass(sort1)));
		}
		query.put("sort", sorts);
	}

	protected void _defaultRangeStats(Wrap<JsonObject> w) {
	}

	protected void _defaultFieldListVars(List<String> l) {
		Optional.ofNullable(searchListComputateJavaClass_.getFields()).orElse(Arrays.asList()).forEach(varStored -> {
			String varStored2 = varStored;
			if(StringUtils.contains(varStored2, "}"))
				varStored2 = StringUtils.substringAfterLast(varStored2, "}");
			String[] parts = varStored2.split(",");
			for(String part : parts) {
				if(StringUtils.isNotBlank(part)) {
					String var = ComputateJavaClass.searchVarComputateJavaClass(part);
					if(StringUtils.isNotBlank(var))
						l.add(var);
				}
			}
		});
	}

	protected void _defaultStatsVars(List<String> l) {
		Optional.ofNullable(searchListComputateJavaClass_.getStatsFields()).orElse(Arrays.asList()).forEach(varIndexed -> {
			String varIndexed2 = varIndexed;
			if(StringUtils.contains(varIndexed2, "}"))
				varIndexed2 = StringUtils.substringAfterLast(varIndexed2, "}");
			String[] parts = varIndexed2.split(",");
			for(String part : parts) {
				if(StringUtils.isNotBlank(part)) {
					String var = ComputateJavaClass.searchVarComputateJavaClass(part);
					if(StringUtils.isNotBlank(var))
						l.add(var);
				}
			}
		});
	}

	protected void _defaultPivotVars(List<String> l) {
		Optional.ofNullable(searchListComputateJavaClass_.getFacetPivots()).orElse(Arrays.asList()).forEach(facetPivot -> {
			String facetPivot2 = facetPivot;
			if(StringUtils.contains(facetPivot2, "}"))
				facetPivot2 = StringUtils.substringAfterLast(facetPivot2, "}");
			String[] parts = facetPivot2.split(",");
			for(String part : parts) {
				if(StringUtils.isNotBlank(part)) {
					String var = ComputateJavaClass.searchVarComputateJavaClass(part);
					if(StringUtils.isNotBlank(var))
						l.add(var);
				}
			}
		});
	}

	/**
	 * {@inheritDoc}
	 **/
	protected void _listComputateJavaClass(JsonArray l) {
		Optional.ofNullable(searchListComputateJavaClass_).map(o -> o.getList()).orElse(Arrays.asList()).stream().map(o -> JsonObject.mapFrom(o)).forEach(o -> l.add(o));
	}

	protected void _computateJavaClassCount(Wrap<Integer> w) {
		w.o(searchListComputateJavaClass_ == null ? 0 : searchListComputateJavaClass_.size());
	}

	protected void _computateJavaClass_(Wrap<ComputateJavaClass> w) {
		if(computateJavaClassCount == 1)
			w.o(searchListComputateJavaClass_.get(0));
	}

	protected void _id(Wrap<String> w) {
		if(computateJavaClassCount == 1)
			w.o(computateJavaClass_.getId());
	}

	/**
	 * Ignore: true
	**/
	protected void _promiseBefore(Promise<Void> promise) {
		promise.complete();
	}

	protected void _classSimpleName(Wrap<String> w) {
		w.o("ComputateJavaClass");
	}

	protected void _pageTitle(Wrap<String> c) {
		if(computateJavaClass_ != null && computateJavaClass_.getObjectTitle() != null)
			c.o(computateJavaClass_.getObjectTitle());
		else if(computateJavaClass_ != null)
			c.o("java classs");
		else if(searchListComputateJavaClass_ == null || computateJavaClassCount == 0)
			c.o("no java class found");
		else
			c.o("java classs");
	}

	protected void _pageUri(Wrap<String> c) {
		c.o("/java-class");
	}

	protected void _apiUri(Wrap<String> c) {
		c.o("/api/java-class");
	}

	protected void _roles(List<String> l) {
		if(siteRequest_ != null) {
			l.addAll(Stream.concat(siteRequest_.getUserResourceRoles().stream(), siteRequest_.getUserRealmRoles().stream()).distinct().collect(Collectors.toList()));
		}
	}

	/**
	 * Ignore: true
	**/
	protected void _promiseAfter(Promise<Void> promise) {
		promise.complete();
	}

	protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/java-class-999.png");
	}

	protected void _classIconGroup(Wrap<String> c) {
			c.o("duotone");
	}

	protected void _classIconName(Wrap<String> c) {
			c.o("map-location-dot");
	}

	protected void _pageUriComputateJavaClass(Wrap<String> c) {
			c.o("/java-class");
	}
}
