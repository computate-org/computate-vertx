package org.computate.vertx.tool;

import java.text.Normalizer;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.CompositeFuture;
import io.vertx.core.Future;
import io.vertx.core.Promise;

public class VertxTool {
	protected static final Logger LOG = LoggerFactory.getLogger(VertxTool.class);

	/**
	 * Description: Import futures in batches
	 */
	public static Future<Void> importFutures(List<Future> futures, Long i, Long rows) {
		Promise<Void> promise = Promise.promise();
		try {
			if(i < futures.size()) {
				List<Future> subList = futures.stream().skip(i).limit(rows).collect(Collectors.toList());
				CompositeFuture.all(subList).onSuccess(b -> {
					importFutures(futures, i + rows, rows).onSuccess(recordMetadata -> {
						promise.complete();
					}).onFailure(ex -> {
						LOG.error("Importing futures failed. ", ex);
						promise.fail(ex);
					});
				}).onFailure(ex -> {
					LOG.error("Importing futures failed. ", ex);
					promise.fail(ex);
				});
			} else {
				promise.complete();
			}
		} catch(Exception ex) {
			LOG.error("Importing futures failed. ", ex);
			promise.fail(ex);
		}
		return promise.future();
	}

	/**
	 * Description: A helper method for generating a URL friendly unique ID for this object
	 */
	public String toId(String s) {
		if(s != null) {
			s = Normalizer.normalize(s, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
		}

		return s;
	}
}
