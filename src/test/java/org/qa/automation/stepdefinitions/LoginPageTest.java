package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.qa.automation.base.TestBase;
import org.qa.automation.pages.SalesForceLoginPage;
import org.qa.automation.contextsetup.TestContextSetup;

public class LoginPageTest extends TestBase {

    TestContextSetup testContextSetup;
    SalesForceLoginPage loginPage;

    public LoginPageTest(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("^User should be able to salesforcelogin with given parameters url (.+), username (.+) and password (.+)$")
    public void user_should_be_able_to_salesforcelogin_with_given_parameters_url_username_and_password(String url, String username, String password) throws InterruptedException {
        loginPage = testContextSetup.pageObjectManager.loginPage();
        loginPage.salesForceLoginTest(url, username, password);
    }

    @When("^User should be on Login Page$")
    public void user_should_be_on_login_page() {

       }

    @Then("^User should validate all the fields$")
    public void user_should_validate_all_the_fields() {
    }

}
