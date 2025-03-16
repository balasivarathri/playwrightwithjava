package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.apicalls.BookApiTest;
import org.qa.automation.base.TestBase;
import org.qa.automation.pages.LoginPage;
import org.qa.automation.report.Report;
import org.qa.automation.supporting.ExcelMultiline;
import org.qa.automation.testcontextsetup.TestContextSetup;

@Slf4j
public class BookAPITest extends TestBase {

    private String finalPayload = "";

    TestContextSetup testContextSetup;

    public BookAPITest(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("^User should be able to login with given parameters payload (.+)$")
    public void user_should_be_able_to_login_with_given_parameters_username_and_password(String payload) throws InterruptedException {
        finalPayload = ExcelMultiline.unEscapeLineBreak(payload);
        Response response = BookApiTest.postBookRequest(finalPayload);
        Report.log(scenario, "Payload has been successfully posted : " + finalPayload);
        Report.validate(scenario, "Message successfully posted", "Message was not posted successfully on the server", 200, response.getStatusCode());
        log.info("Response status code: " + response.getStatusCode());
    }

    @When("^User should be to validate the response$")
    public void user_should_be_to_validate_the_response() {
        Response response = BookApiTest.getDogRequest();
//        log.info(String.valueOf(response.getBody()));
        log.info(String.valueOf(response.getHeaders()));
        Report.log(scenario, response.getBody().prettyPrint());
    }

    @Then("^User should validate all the responses$")
    public void user_should_validate_all_the_responses() {
        Response response = BookApiTest.getDogRequest();
        Report.log(scenario, response.getHeaders().toString());
    }

}
