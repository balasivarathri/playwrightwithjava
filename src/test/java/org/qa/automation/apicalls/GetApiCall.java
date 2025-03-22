package org.qa.automation.apicalls;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.*;
import org.testng.Assert;

import java.io.IOException;

public class GetApiCall {


    public static String getUsersApi() throws IOException {
        Playwright playwright = Playwright.create();
        APIRequest apiRequest = playwright.request();
        APIRequestContext apiRequestContext = apiRequest.newContext();
        APIResponse apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users");
        int statusCode = apiResponse.status();
        System.out.println("Response Status Code is: " + statusCode);
        Assert.assertEquals(statusCode,200);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
        return jsonResponse.toPrettyString();
    }
}
