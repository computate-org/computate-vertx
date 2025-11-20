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
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.pgclient.data.Path;
import io.vertx.pgclient.data.Point;
import io.vertx.pgclient.data.Polygon;

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

  /**
   * Description: A helper method to convert a Postgres Point to GeoJSON. 
   */
  public static JsonObject toGeoJson(Point point) {
    JsonObject result = null;
    if(point != null) {
      JsonArray pointsArray = new JsonArray();
      pointsArray.add(Double.valueOf(point.getX()));
      pointsArray.add(Double.valueOf(point.getY()));
      result = new JsonObject().put("type", "Point").put("coordinates", pointsArray);
    }
    return result;
  }

  /**
   * Description: A helper method to convert a Postgres Path to GeoJSON. 
   */
  public static JsonObject toGeoJson(Path path) {
    JsonObject result = null;
    if(path != null) {
      JsonArray pointsArray = new JsonArray();
      path.getPoints().stream().map(point -> new JsonArray().add(Double.valueOf(point.getX())).add(Double.valueOf(point.getY()))).collect(Collectors.toList()).forEach(pointArray -> pointsArray.add(pointArray));
      result = new JsonObject().put("type", "LineString").put("coordinates", pointsArray);
    }
    return result;
  }

  /**
   * Description: A helper method to convert a Postgres Polygon to GeoJSON. 
   */
  public static JsonObject toGeoJson(Polygon polygon) {
    JsonArray coordinates = new JsonArray();
    JsonObject json = new JsonObject().put("type", "Polygon").put("coordinates", coordinates);
    if(polygon != null) {
      JsonArray coordinates2 = new JsonArray();
      coordinates.add(coordinates2);
      polygon.getPoints().forEach(point -> {
        coordinates2.add(new JsonArray().add(point.getX()).add(point.getY()));
      });
    }
    return json;
  }

  /**
   * Description: A helper method to convert a List of Postgres Polygons to GeoJSON. 
   */
  public static JsonObject toGeoJson(List<Polygon> areaServed) {
    JsonArray coordinates = new JsonArray();
    JsonObject json = new JsonObject().put("type", "Polygon").put("coordinates", coordinates);
    for(Polygon o : areaServed) {
      JsonArray coordinates2 = new JsonArray();
      coordinates.add(coordinates2);
      o.getPoints().forEach(point -> {
        coordinates2.add(new JsonArray().add(point.getX()).add(point.getY()));
      });
    }
    return json;
  }
}
