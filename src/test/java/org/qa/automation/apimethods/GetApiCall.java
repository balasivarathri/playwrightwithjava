package org.qa.automation.apimethods;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.base.TestBase;
import org.qa.automation.report.Report;
import org.testng.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
public class GetApiCall extends TestBase {

    APIRequestContext apiRequestContext;
    APIResponse apiResponse;

    public GetApiCall(APIRequestContext apiRequestContext) {
        this.apiRequestContext = apiRequestContext;
    }

    public void getApi() throws IOException {
        apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users");
        int statusCode = apiResponse.status();
        System.out.println("Response Status Code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        Report.validate(scenario, "Status Code has successfully extracted", "Status Code has successfully extracted", 200, statusCode);
        System.out.println(apiResponse.headers().get("content-type"));
        String url = apiResponse.url();
        Report.log(scenario,"Extracted url from Response Body is  :  "+ url);
        System.out.println("Extracted url from Response Body is  : " + url);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonHeader = objectMapper.writeValueAsString(apiResponse.headers());
        System.out.println(jsonHeader);
        Report.log(scenario, "Reponse JsonHeader is : " + jsonHeader);

//        ObjectMapper om = new ObjectMapper();
//        JsonNode jsonResponse = om.readTree(apiResponse.body());
//        String jsonBody = jsonResponse.toPrettyString();
//        System.out.println(jsonBody);
//        Report.log(scenario, "Reponse JsonBody is : " + jsonBody);


        String res = apiResponse.text();
        List<Map<String, Object>> users = objectMapper.readValue(res, new TypeReference<List<Map<String, Object>>>() {});
        Map<String, Object> firstUser = users.get(2);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("Full JSON object:\n" + objectMapper.writeValueAsString(firstUser));
        System.out.println(firstUser.get("id"));
        System.out.println(firstUser.get("name"));
        System.out.println(firstUser.get("email"));

    }
    public void getSpecificUser() throws JsonProcessingException {
        apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users",
                RequestOptions.create().setQueryParam("id",7820278));
        String specificUser = apiResponse.text();
        ObjectMapper ob = new ObjectMapper();
        List<Map<String, Object>> speUsers = ob.readValue(specificUser, new TypeReference<>() {});
        Map<String, Object> firstUser = speUsers.get(0);
        ob.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println("Full JSON object:\n" + ob.writeValueAsString(firstUser));
//        System.out.println(specificUser.get());
//        System.out.println(apiResponse.url());

    }
}
