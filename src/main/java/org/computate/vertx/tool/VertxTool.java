package org.computate.vertx.tool;

import java.util.List;
import java.util.stream.Collectors;

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
}
