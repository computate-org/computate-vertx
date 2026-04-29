package org.computate.vertx.tool;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.measure.Quantity;
import javax.measure.Unit;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.LineString;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.operation.distance.DistanceOp;

import systems.uom.common.USCustomary;
import tech.units.indriya.format.SimpleQuantityFormat;
import tech.units.indriya.format.SimpleUnitFormat;
import tech.units.indriya.internal.format.RationalNumberScanner;
import tech.units.indriya.quantity.Quantities;

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

  public static final String QUANTITY_REGEX = "^([-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?)\\s*(.*?)\\s*$";
  public static final Pattern QUANTITY_PATTERN = Pattern.compile(QUANTITY_REGEX);

  public static SimpleUnitFormat unitFormat() {
    SimpleUnitFormat unitFormat = SimpleUnitFormat.getInstance();
    unitFormat.label(USCustomary.ACRE, "ac");
    unitFormat.alias(USCustomary.ACRE, "acre");
    unitFormat.label(USCustomary.ACRE_FOOT, "ac ft");
    unitFormat.label(USCustomary.CUBIC_FOOT, "ft³");
    unitFormat.label(USCustomary.CUBIC_INCH, "in³");
    // unitFormat.label(USCustomary.CUP, USCustomary.CUP.getSymbol());
    // unitFormat.label(USCustomary.DEGREE_ANGLE, USCustomary.DEGREE_ANGLE.getSymbol());
    // unitFormat.label(USCustomary.ELECTRICAL_HORSEPOWER, USCustomary.ELECTRICAL_HORSEPOWER.getSymbol());
    // unitFormat.label(USCustomary.ELECTRON_VOLT, USCustomary.ELECTRON_VOLT.getSymbol());
    // unitFormat.label(USCustomary.FAHRENHEIT, USCustomary.FAHRENHEIT.getSymbol());
    // unitFormat.label(USCustomary.FLUID_OUNCE, USCustomary.FLUID_OUNCE.getSymbol());
    unitFormat.label(USCustomary.FOOT, "ft");
    unitFormat.alias(USCustomary.FOOT, "foot");
    unitFormat.alias(USCustomary.FOOT, "feet");
    // unitFormat.label(USCustomary.FOOT_PER_SECOND, USCustomary.FOOT_PER_SECOND.getSymbol());
    // unitFormat.label(USCustomary.FOOT_SURVEY, USCustomary.FOOT_SURVEY.getSymbol());
    // unitFormat.label(USCustomary.GALLON_DRY, USCustomary.GALLON_DRY.getSymbol());
    // unitFormat.label(USCustomary.GALLON_LIQUID, USCustomary.GALLON_LIQUID.getSymbol());
    // unitFormat.label(USCustomary.GRADE, USCustomary.GRADE.getSymbol());
    // unitFormat.label(USCustomary.HECTARE, USCustomary.HECTARE.getSymbol());
    // unitFormat.label(USCustomary.HORSEPOWER, USCustomary.HORSEPOWER.getSymbol());
    // unitFormat.label(USCustomary.HOUR, USCustomary.HOUR.getSymbol());
    // unitFormat.label(USCustomary.INCH, USCustomary.INCH.getSymbol());
    // unitFormat.label(USCustomary.KNOT, USCustomary.KNOT.getSymbol());
    // unitFormat.label(USCustomary.LIGHT_YEAR, USCustomary.LIGHT_YEAR.getSymbol());
    unitFormat.label(USCustomary.LITER, "L");
    unitFormat.label(USCustomary.METER, "meter");
    // unitFormat.label(USCustomary.MILE, USCustomary.MILE.getSymbol());
    // unitFormat.label(USCustomary.MILE_PER_HOUR, USCustomary.MILE_PER_HOUR.getSymbol());
    // unitFormat.label(USCustomary.MINUTE, USCustomary.MINUTE.getSymbol());
    // unitFormat.label(USCustomary.NAUTICAL_MILE, USCustomary.NAUTICAL_MILE.getSymbol());
    // unitFormat.label(USCustomary.OUNCE, USCustomary.OUNCE.getSymbol());
    // unitFormat.label(USCustomary.PINT, USCustomary.PINT.getSymbol());
    // unitFormat.label(USCustomary.POUND, USCustomary.POUND.getSymbol());
    // unitFormat.label(USCustomary.REVOLUTION, USCustomary.REVOLUTION.getSymbol());
    // unitFormat.label(USCustomary.REVOLUTION_PER_MINUTE, USCustomary.REVOLUTION_PER_MINUTE.getSymbol());
    // unitFormat.label(USCustomary.SQUARE_FOOT, USCustomary.SQUARE_FOOT.getSymbol());
    // unitFormat.label(USCustomary.TABLESPOON, USCustomary.TABLESPOON.getSymbol());
    // unitFormat.label(USCustomary.TEASPOON, USCustomary.TEASPOON.getSymbol());
    // unitFormat.label(USCustomary.TON, USCustomary.TON.getSymbol());
    // unitFormat.label(USCustomary.YARD, USCustomary.YARD.getSymbol());
    return unitFormat;
  }

  public static final SimpleUnitFormat UNIT_FORMAT = GeoTool.unitFormat();

  public static Quantity<?> parseQuantity(String quantity) {
    return GeoTool.parseQuantity(quantity, UNIT_FORMAT);
  }

  public static Quantity<?> parseQuantity(String quantity, SimpleUnitFormat unitFormat) {
    Matcher matcher = QUANTITY_PATTERN.matcher(quantity);
    if(matcher.find()) {
      return Quantities.getQuantity(new BigDecimal(matcher.group(1)), unitFormat.parse(matcher.group(3)));
    }
    return null;
  }
}
