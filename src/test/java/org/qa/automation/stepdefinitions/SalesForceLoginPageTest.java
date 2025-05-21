package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.qa.automation.base.TestBase;
import org.qa.automation.pages.SalesForceLoginPage;
import org.qa.automation.contextsetup.TestContextSetup;

public class SalesForceLoginPageTest extends TestBase {

    TestContextSetup testContextSetup;
    SalesForceLoginPage salesForceLoginPage;

    public SalesForceLoginPageTest(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("^User should be able to salesforce login with given parameters url (.+), username (.+) and password (.+)$")
    public void user_should_be_able_to_salesforce_login_with_given_parameters_url_username_and_password(String url, String username, String password) throws InterruptedException {
        salesForceLoginPage = testContextSetup.pageObjectManager.salesForceLoginPage();
        salesForceLoginPage.salesForceLoginTest(url, username, password);
    }

    @When("^User should be on Login Page$")
    public void user_should_be_on_login_page() {

    }

    @Then("^User should validate all the fields$")
    public void user_should_validate_all_the_fields() {
    }

}