package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.apicalls.BookApiTest;
import org.qa.automation.apimethods.GetApiCall;
import org.qa.automation.apimethods.PostApiCall;
import org.qa.automation.base.TestBase;
import org.qa.automation.report.Report;
import org.qa.automation.contextsetup.ApiContextSetup;

import java.io.IOException;

@Slf4j
public class GoRestAPITest extends TestBase {

    ApiContextSetup apiContextSetup;
    GetApiCall getApiCall;
    PostApiCall postApiCall;
    int idNumber;

    public GoRestAPITest(ApiContextSetup apiContextSetup) {
        this.apiContextSetup = apiContextSetup;
    }
    @Given("User should be hit the POST gorest API to create the user")
    public void user_should_be_hit_the_post_gorest_api_to_create_the_user() throws IOException {
        postApiCall = apiContextSetup.apiObjectManager.postApiCall();
        postApiCall.postApi();
    }
    @Then("User should be validate the reponse and verify user has been created")
    public void user_should_be_validate_the_reponse_and_verify_user_has_been_created() throws IOException {
        idNumber = postApiCall.validatePostApiResponse();
    }
    @Given("^User should be to hit the gorest api to get the user response$")
    public void user_should_be_to_hit_the_gorest_api_to_get_the_user_response() throws IOException {
        getApiCall = apiContextSetup.apiObjectManager.getApiCall();
        getApiCall.getApi();
    }
    @Given("^User should validate the response with specific Id$")
    public void user_should_validate_the_response_with_specific_id() throws IOException {
        getApiCall = apiContextSetup.apiObjectManager.getApiCall();
        getApiCall.getSpecificUser(idNumber);
    }

//    @Given("^User should be able to login with given parameters payload (.+)$")
//    public void user_should_be_able_to_login_with_given_parameters_username_and_password(String payload) throws InterruptedException {
//        finalPayload = ExcelMultiline.unEscapeLineBreak(payload);
//        Response response = BookApiTest.postBookRequest(finalPayload);
//        Report.log(scenario, "Payload has been successfully posted : " + finalPayload);
//        Report.validate(scenario, "Message successfully posted", "Message was not posted successfully on the server", 200, response.getStatusCode());
//        log.info("Response status code: " + response.getStatusCode());
//    }

    @When("^User should be to validate the response$")
    public void user_should_be_to_validate_the_response() {
        Response response = BookApiTest.getBookRequest();
        log.info(String.valueOf(response.getBody()));
        Report.log(scenario, response.getBody().prettyPrint());
    }

    @Then("^User should validate all the responses$")
    public void user_should_validate_all_the_responses() {
        Response response = BookApiTest.getBookRequest();
        log.info(String.valueOf(response.getHeaders()));
        Report.log(scenario, response.getHeaders().toString());
    }

}