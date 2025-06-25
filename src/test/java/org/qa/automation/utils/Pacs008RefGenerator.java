package org.qa.automation.utils;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Pacs008RefGenerator {

    private static final String PREFIX = "PACS008";
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int RANDOM_STRING_LENGTH = 5;
    private static final AtomicInteger counter = new AtomicInteger(1);
    private static final Random random = new Random();

    // Generate a 5-character random string
    private static String generateRandomString() {
        StringBuilder sb = new StringBuilder(RANDOM_STRING_LENGTH);
        for (int i = 0; i < RANDOM_STRING_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    // Generate the full reference number
    public static String generateReference() {
        String randomString = generateRandomString();
        int increment = counter.getAndIncrement();
        return PREFIX + randomString + String.format("%05d", increment);
    }
}

