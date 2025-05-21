package org.qa.automation.utils;

public class Url {

    public static String getUrl(String specificUrl) {
        String url = "";
        switch (specificUrl.toLowerCase()) {
            case "saucelabs":
                url = "https://www.saucedemo.com";
                break;
            case "salesforce":
                url = "https://ability-dream-6004.my.salesforce.com";
                break;
            default:
                System.out.println("please provide the correct url ......");
                break;
        }
        return url;
    }
}