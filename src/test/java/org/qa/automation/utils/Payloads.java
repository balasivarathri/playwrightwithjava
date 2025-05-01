package org.qa.automation.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Payloads {

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
}
