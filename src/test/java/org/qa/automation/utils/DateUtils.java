package org.qa.automation.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DateUtils {
    private static final Random random = new Random();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String generateRandomCheckinDate() {
        LocalDate today = LocalDate.now();
        LocalDate checkin = today.plusDays(random.nextInt(10) + 1); // 1–10 days from today
        return checkin.format(formatter);
    }

    public static String generateRandomCheckoutDate(String checkinStr) {
        LocalDate checkin = LocalDate.parse(checkinStr, formatter);
        LocalDate checkout = checkin.plusDays(random.nextInt(5) + 1); // 1–5 days after check-in
        return checkout.format(formatter);
    }
}

