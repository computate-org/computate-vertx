package org.computate.vertx.handlebars;

import static org.apache.commons.lang3.Validate.isTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.computate.search.serialize.ComputateZonedDateTimeSerializer;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.TagType;
import com.github.jknack.handlebars.internal.lang3.LocaleUtils;
import org.apache.commons.text.StringEscapeUtils;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

public enum SiteHelpers implements Helper<Object> {


	/**
	 * Call the toString method on an object. 
	 */
	toString {
		@Override
		public CharSequence apply(final Object originalValue, final Options options) throws IOException {
			if(originalValue == null)
				return "";
			else
				return originalValue.toString();
		}
	},


	/**
	 * Call the toString method on an object. 
	 */
	toJsonObjectString {
		@Override
		public CharSequence apply(final Object originalValue, final Options options) throws IOException {
			if(originalValue == null)
				return "";
			else
				return new JsonObject((Map<String, Object>)originalValue).toString();
		}
	},


	/**
	 * Call the toString method on an object. 
	 */
	toJsonArrayString {
		@Override
		public CharSequence apply(final Object originalValue, final Options options) throws IOException {
			if(originalValue == null)
				return "";
			else
				return new JsonArray((List<Object>)originalValue).toString();
		}
	},


	/**
	 * Escape HTML in quotes
	 */
	escapeHtmlInQuotes {
		@Override
		public CharSequence apply(final Object originalValue, final Options options) throws IOException {
			if(originalValue == null) {
				return "";
			} else {
				return StringEscapeUtils.escapeHtml4(originalValue.toString());
			}
		}
	},


	/**
	 * Call the toString method on an object and replace apostrophes. 
	 */
	toJsonObjectStringInApostrophes {
		@Override
		public CharSequence apply(final Object originalValue, final Options options) throws IOException {
			if(originalValue == null) {
				return "";
			} else {
				if(originalValue instanceof String) {
					return new JsonObject((String)originalValue).toString().replace("'", "&apos;");
				} else {
					return new JsonObject((Map<String, Object>)originalValue).toString().replace("'", "&apos;");
				}
			}
		}
	},


	/**
	 * Call the toString method on an object and replace apostrophes. 
	 */
	toJsonArrayStringInApostrophes {
		@Override
		public CharSequence apply(final Object originalValue, final Options options) throws IOException {
			if(originalValue == null) {
				return "";
			} else {
				if(originalValue instanceof String) {
					return new JsonArray((String)originalValue).toString().replace("'", "&apos;");
				} else if(originalValue instanceof List){
					JsonArray result = new JsonArray();
					((List<?>)originalValue).forEach(o -> result.add(new JsonObject((Map)o)));
					return result.toString().replace("'", "&apos;");
				}
			}
			return null;
		}
	},


	/**
	 * Return the original value, otherwise the default value. 
	 */
	defaultVal {
		@Override
		public CharSequence apply(final Object originalValue, final Options options) throws IOException {
			if(originalValue == null)
				return options.param(0).toString();
			else
				return originalValue.toString();
		}
	},

	/**
	 */
	formatZonedDateTime {
		@Override
		public CharSequence apply(final Object a, final Options options) throws IOException {
			String pattern = options.param(0);
			String localeId = options.param(1);
			Locale locale = Locale.forLanguageTag(localeId);
			String zone = options.param(2);
			ZoneId zoneId = ZoneId.of(zone);
			String str = (String)a;
			ZonedDateTime d = ZonedDateTime.parse(str, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
			return DateTimeFormatter.ofPattern(pattern, locale).format(d.withZoneSameInstant(zoneId));
		}
	},

	/**
	 * <p>
	 * Usage:
	 * </p>
	 *
	 * <pre>
	 *		{{numberFormat number ["format"] [locale=default]}}
	 * </pre>
	 *
	 * Format parameters is one of:
	 * <ul>
	 * <li>"integer": the integer number format</li>
	 * <li>"percent": the percent number format</li>
	 * <li>"currency": the decimal number format</li>
	 * <li>"pattern": a decimal pattern.</li>
	 * </ul>
	 * Otherwise, the default formatter will be used.
	 *
	 * <p>
	 * More options:
	 * </p>
	 * <ul>
	 * <li>groupingUsed: Set whether or not grouping will be used in this format.</li>
	 * <li>maximumFractionDigits: Sets the maximum number of digits allowed in the fraction portion of
	 * a number.</li>
	 * <li>maximumIntegerDigits: Sets the maximum number of digits allowed in the integer portion of a
	 * number</li>
	 * <li>minimumFractionDigits: Sets the minimum number of digits allowed in the fraction portion of
	 * a number</li>
	 * <li>minimumIntegerDigits: Sets the minimum number of digits allowed in the integer portion of a
	 * number.</li>
	 * <li>parseIntegerOnly: Sets whether or not numbers should be parsed as integers only.</li>
	 * <li>roundingMode: Sets the {@link java.math.RoundingMode} used in this NumberFormat.</li>
	 * </ul>
	 *
	 * @see NumberFormat
	 * @see DecimalFormat
	 */
	siteNumberFormat {

		@Override
		public Object apply(final Object context, final Options options) throws IOException {
			if (context instanceof Number) {
				return safeApply(context, options);
			} else {
				return safeApply(new BigDecimal(context.toString()), options);
			}
		}

		protected CharSequence safeApply(final Object value, final Options options) {
			isTrue(value instanceof Number, "found '%s', expected 'number'", value);
			Number number = (Number) value;
			final NumberFormat numberFormat = build(options);

			Boolean groupingUsed = options.hash("groupingUsed");
			if (groupingUsed != null) {
				numberFormat.setGroupingUsed(groupingUsed);
			}

			Integer maximumFractionDigits = options.hash("maximumFractionDigits");
			if (maximumFractionDigits != null) {
				numberFormat.setMaximumFractionDigits(maximumFractionDigits);
			}

			Integer maximumIntegerDigits = options.hash("maximumIntegerDigits");
			if (maximumIntegerDigits != null) {
				numberFormat.setMaximumIntegerDigits(maximumIntegerDigits);
			}

			Integer minimumFractionDigits = options.hash("minimumFractionDigits");
			if (minimumFractionDigits != null) {
				numberFormat.setMinimumFractionDigits(minimumFractionDigits);
			}

			Integer minimumIntegerDigits = options.hash("minimumIntegerDigits");
			if (minimumIntegerDigits != null) {
				numberFormat.setMinimumIntegerDigits(minimumIntegerDigits);
			}

			Boolean parseIntegerOnly = options.hash("parseIntegerOnly");
			if (parseIntegerOnly != null) {
				numberFormat.setParseIntegerOnly(parseIntegerOnly);
			}

			String roundingMode = options.hash("roundingMode");
			if (roundingMode != null) {
				numberFormat.setRoundingMode(RoundingMode.valueOf(roundingMode.toUpperCase().trim()));
			}

			return numberFormat.format(number);
		}

		/**
		 * Build a number format from options.
		 *
		 * @param options The helper options.
		 * @return The number format to use.
		 */
		private NumberFormat build(final Options options) {
			if (options.params.length == 0) {
				return NumberStyle.DEFAULT.numberFormat(Locale.getDefault());
			}
			isTrue(options.params[0] instanceof String, "found '%s', expected 'string'",
					options.params[0]);
			String format = options.param(0);
			String localeStr = options.param(1, Locale.getDefault().toString());
			Locale locale = LocaleUtils.toLocale(localeStr);
			try {
				NumberStyle style = NumberStyle.valueOf(format.toUpperCase().trim());
				return style.numberFormat(locale);
			} catch (ArrayIndexOutOfBoundsException ex) {
				return NumberStyle.DEFAULT.numberFormat(locale);
			} catch (IllegalArgumentException ex) {
				return new DecimalFormat(format, new DecimalFormatSymbols(locale));
			}
		}

	},

	/**
	 * <p>
	 * Usage:
	 * </p>
	 *
	 * <pre>
	 *		{{dateFormat date ["format"] [format="format"][tz=timeZone|timeZoneId]}}
	 * </pre>
	 *
	 * Format parameters is one of:
	 * <ul>
	 * <li>"full": full date format. For example: Tuesday, June 19, 2012</li>
	 * <li>"long": long date format. For example: June 19, 2012</li>
	 * <li>"medium": medium date format. For example: Jun 19, 2012</li>
	 * <li>"short": short date format. For example: 6/19/12</li>
	 * <li>"pattern": a date pattern.</li>
	 * </ul>
	 * Otherwise, the default formatter will be used.
	 * The format option can be specified as a parameter or hash (a.k.a named parameter).
	 */
	siteZonedDateTimeFormat {

		public Object apply(final Object context, final Options options) throws IOException {
			if (options.isFalsy(context)) {
				Object param = options.param(0, null);
				return param == null ? null : param.toString();
			}
			return safeApply(context, options);
		}

		protected CharSequence safeApply(final Object value, final Options options) {
			final DateTimeFormatter dateFormatter;
			Object pattern = options.param(0, options.hash("format", "yyyy-MM-dd'T'HH:mm:ss.SSS'['VV']'"));
			String localeStr = options.param(1, options.hash("locale", Locale.getDefault().toString()));
			Locale locale = LocaleUtils.toLocale(localeStr);
			dateFormatter = DateTimeFormatter.ofPattern(pattern.toString(), locale);
			Object tz = options.hash("tz");
			if (tz != null) {
				final TimeZone timeZone = tz instanceof TimeZone ? (TimeZone) tz : TimeZone.getTimeZone(tz.toString());
				dateFormatter.withZone(timeZone.toZoneId());
			}
			ZonedDateTime date = value instanceof ZonedDateTime ? (ZonedDateTime)value : ZonedDateTime.parse(value.toString(), DateTimeFormatter.ofPattern(ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMAT, locale));
			return dateFormatter.format(date);
		}

	},


	/**
	 * URL Encode the value
	 */
	encodeURIComponent {
		@Override
		public CharSequence apply(final Object originalValue, final Options options) throws IOException {
			if(originalValue == null)
				return null;
			else
				return URLEncoder.encode(originalValue.toString(), "UTF-8");
		}
	},


	/**
	 * Return true if the value is an even number, otherwise false
	 */
	numberAdd{
		@Override
		public Object apply(final Object value, final Options options) throws IOException {
			isTrue(value instanceof Number, "found '%s', expected 'number'", value);
			Number number1 = (Number) value;
			Object object2 = options.param(0);
			isTrue(object2 instanceof Number, "found '%s', expected 'number'", object2);
			Number number2 = (Number) object2;
			if(number1 instanceof Integer && number2 instanceof Integer)
				return (Integer)number1 + (Integer)number2;
			else if(number1 instanceof Double && number2 instanceof Double)
				return (Double)number1 + (Double)number2;
			else
				return null;
		}
	},


	/**
	 * Return true if the value is an even number, otherwise false
	 */
	even{
		@Override
		public Object apply(final Object value, final Options options) throws IOException {
			isTrue(value instanceof Number, "found '%s', expected 'number'", value);
			Number number = (Number) value;
			boolean result = (number.intValue() % 2) == 0;
			if (options.tagType == TagType.SECTION) {
				return result ? options.fn() : options.inverse();
			}
			return result ? options.hash("yes", true) : options.hash("no", false);
		}
	},


	/**
	 * Return true if the value is an even number, otherwise false
	 */
	odd{
		@Override
		public Object apply(final Object value, final Options options) throws IOException {
			isTrue(value instanceof Number, "found '%s', expected 'number'", value);
			Number number = (Number) value;
			boolean result = (number.intValue() % 2) == 1;
			if (options.tagType == TagType.SECTION) {
				return result ? options.fn() : options.inverse();
			}
			return result ? options.hash("yes", true) : options.hash("no", false);
		}
	}
	;
}

/**
 * Number format styles.
 *
 * @author edgar.espina
 * @since 1.0.1
 */
enum NumberStyle {

	/**
	 * The default number format.
	 */
	DEFAULT {
	 @Override
		public NumberFormat numberFormat(final Locale locale) {
			return NumberFormat.getInstance(locale);
		}
	},

	/**
	 * The integer number format.
	 */
	INTEGER {
		@Override
		public NumberFormat numberFormat(final Locale locale) {
			return NumberFormat.getIntegerInstance(locale);
		}
	},

	/**
	 * The currency number format.
	 */
	CURRENCY {
		@Override
		public NumberFormat numberFormat(final Locale locale) {
			return NumberFormat.getCurrencyInstance(locale);
		}
	},

	/**
	 * The percent number format.
	 */
	PERCENT {
		@Override
		public NumberFormat numberFormat(final Locale locale) {
			return NumberFormat.getPercentInstance(locale);
		}
	};

	/**
	 * Build a new number format.
	 *
	 * @param locale The locale to use.
	 * @return A new number format.
	 */
	public abstract NumberFormat numberFormat(Locale locale);
}
