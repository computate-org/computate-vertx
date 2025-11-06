package org.computate.vertx.tool;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.operation.distance.DistanceOp;

public class GeoTool {

  private static final BigDecimal METERS_PER_MILE = new BigDecimal("1609.344");
  private static final BigDecimal MILLISECONDS_PER_HOUR = new BigDecimal("3600000"); // 60 * 60 * 1000
  // The single unit conversion factor (Meters per Millisecond per MPH)
  private static final BigDecimal METERS_PER_MILLIS_CONVERSION_FACTOR = METERS_PER_MILE.divide(MILLISECONDS_PER_HOUR,
      20, RoundingMode.HALF_UP);
  private static final double ON_LINE_TOLERANCE = 0.001;

  /**
   * Determines if a Coordinate lies on a LineString within a given tolerance.
   * @param line The LineString to check against.
   * @param point The Point to check.
   * @return true if the distance is less than the tolerance, false otherwise.
   */
  public static boolean isCoordinateOnLine(LineString line, Point point, double tolerance) {
    double distance = DistanceOp.distance(line, point);
    return distance < tolerance;
  }

  /**
   * Calculates the distance traveled in meters.
   *
   * @param mph            The speed in miles per hour (as BigDecimal).
   * @param durationMillis The duration in milliseconds (as BigDecimal).
   * @return The distance traveled in meters (as BigDecimal).
   */
  public static BigDecimal calculateMeters(BigDecimal mph, BigDecimal durationMillis, Integer scale,
      RoundingMode roundingMode) {
    // Calculate Meters = MPH * Milliseconds * (1609.344 / 3,600,000)
    BigDecimal distancePreliminary = mph.multiply(durationMillis);
    BigDecimal distanceMeters = distancePreliminary.multiply(METERS_PER_MILLIS_CONVERSION_FACTOR).setScale(scale,
        roundingMode);

    return distanceMeters;
  }

  // /**
  // * Finds the index of the coordinate in the lineString.
  // *
  // * @param lineString The LineString to search.
  // * @param coordinate The coordinate near the LineString.
  // * @return The index of the matching Coordinate, or -1 if no match is found.
  // */
  // public static int findCoordinateIndex(LineString lineString, Coordinate
  // coordinate) {
  // Coordinate[] coordinates = lineString.getCoordinates();
  // for (int i = 0; i < coordinates.length; i++) {
  // Coordinate current = coordinates[i];
  // if (current.equals(coordinate)) {
  // return i;
  // }
  // }
  // return -1;
  // }

  /**
   * Finds the index of the point in the lineString.
   * 
   * @param lineString The LineString to search.
   * @param point      The point near the LineString.
   * @return The index of the matching Point, or -1 if no match is found.
   */
  public static int findCoordinateIndex(LineString lineString, Point point) {
    Coordinate[] coordinates = lineString.getCoordinates();
    for (int i = 0; i < coordinates.length; i++) {
      Coordinate current = coordinates[i];
      if (current.equals(point.getCoordinate())) {
        return i;
      }
    }
    return -1;
  }
}
