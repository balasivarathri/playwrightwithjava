package org.qa.automation.utils;

import java.util.UUID;

public class UETRGenerator {

    // Generate a random UUIDv4 (UETR)
    public static String generateUETR() {
        return UUID.randomUUID().toString();
    }
}
