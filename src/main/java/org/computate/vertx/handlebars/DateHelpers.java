package org.computate.vertx.handlebars;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.computate.search.serialize.ComputateZonedDateTimeSerializer;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

/**
 * Map.hackathonMission: to create a new Java enum to handle date formatting in the frontend page requests
 * Map.hackathonColumn: Develop Web Backend
 * Map.hackathonLabels: Java,Handlebars
 */
public enum DateHelpers implements Helper<Object> {

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
			ZonedDateTime d = null;

			if(StringUtils.endsWith(str, "]"))
				d = str == null ? null : ZonedDateTime.parse(str, ComputateZonedDateTimeSerializer.ZONED_DATE_TIME_FORMATTER);
			else if(StringUtils.endsWith(str, "Z"))
				d = str == null ? null : Instant.parse(str).atZone(zoneId).truncatedTo(ChronoUnit.MILLIS);
			else if(StringUtils.contains(str, "T"))
				d = str == null ? null : ZonedDateTime.parse(str, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
			else
				d = str == null ? null : LocalDate.parse(str, DateTimeFormatter.ISO_DATE).atStartOfDay(zoneId).truncatedTo(ChronoUnit.MILLIS);

			return DateTimeFormatter.ofPattern(pattern, locale).format(d.withZoneSameInstant(zoneId));
		}
	}
	;
}
