package org.qa.automation.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class IsoDateTimeGenerator {

    public static String generateIsoDateTime() {
        // Use specific zone offset (+02:00) – example: Europe/South_Africa
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Africa/Johannesburg"))
                .withHour(8).withMinute(0).withSecond(0).withNano(0);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        return zonedDateTime.format(formatter);
    }
}

