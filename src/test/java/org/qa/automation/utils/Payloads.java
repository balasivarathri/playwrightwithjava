package org.qa.automation.utils;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Payloads {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int LENGTH = 4;

    public static Map<String, Object> createUserPayload(){
        Map<String, Object> data =  new HashMap<>();
        data.put("name", "Bala Krishna");
        data.put("email", "test" + generateThreeDigitNumber() + "@gmail.com");
        data.put("gender", "male");
        data.put("status", "active");
        return data;
    }

    public static int generateThreeDigitNumber() {
        Random rand = new Random();
        return 100 + rand.nextInt(900);
    }

    public static String generateRandomString() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }

}