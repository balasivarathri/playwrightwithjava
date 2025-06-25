package org.qa.automation.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ValueDateGenerator {

    public static String date1() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return today.format(formatter);
    }
    public static String date2() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        return today.format(formatter);
    }
}

