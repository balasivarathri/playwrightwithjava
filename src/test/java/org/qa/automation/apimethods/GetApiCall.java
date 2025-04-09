package org.qa.automation.apimethods;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.base.TestBase;
import org.qa.automation.report.Report;
import org.testng.Assert;

import java.io.IOException;

@Slf4j
public class GetApiCall extends TestBase {

    APIRequestContext apiRequestContext;
    APIResponse apiResponse;

    public GetApiCall(APIRequestContext apiRequestContext){
        this.apiRequestContext = apiRequestContext;
    }

    public void getApi() throws IOException {
        apiResponse = apiRequestContext.get("https://gorest.co.in/public/v2/users");
        int statusCode = apiResponse.status();
        System.out.println("Response Status Code is: " + statusCode);
        Assert.assertEquals(statusCode,200);
        Report.validate(scenario,"Status Code has successfully extracted", "Status Code has successfully extracted", 200, statusCode);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(apiResponse.body());
        String jsonBody = jsonResponse.toPrettyString();
        log.info(jsonBody);
        Report.log(scenario, "Reponse JsonBody is : " + jsonBody);
    }
}
