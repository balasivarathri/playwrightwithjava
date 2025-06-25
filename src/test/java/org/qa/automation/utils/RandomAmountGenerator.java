package org.qa.automation.utils;

import java.util.Random;

public class RandomAmountGenerator {

    public static double generateRandomAmount() {
        double min = 1000.00;
        double max = 5000.00;
        Random random = new Random();
        double amount = min + (max - min) * random.nextDouble();
        return Math.round(amount * 100.0) / 100.0;
    }
}

