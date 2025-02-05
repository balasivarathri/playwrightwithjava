package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.qa.automation.base.TestBase;
import org.qa.automation.pages.LoginPage;
import org.qa.automation.testcontextsetup.TestContextSetup;

public class LoginPageTest extends TestBase {

    TestContextSetup testContextSetup;
    LoginPage loginPage;

    public LoginPageTest(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Given("^User should be able to login with given parameters username (.+) and password (.+)$")
    public void user_should_be_able_to_login_with_given_parameters_username_and_password(String username, String password) throws InterruptedException {
        loginPage = testContextSetup.pageObjectManager.loginPage();
        loginPage.loginTest(username,password);
        loginPage.validateErrorMessage();
    }

    @When("^User should be on Login Page$")
    public void user_should_be_on_login_page() {

       }

    @Then("^User should validate all the fields$")
    public void user_should_validate_all_the_fields() {

    }

}
