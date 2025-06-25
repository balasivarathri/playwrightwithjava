package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.qa.automation.base.TestBase;
import org.qa.automation.contextsetup.TestContextSetup;
import org.qa.automation.pages.*;

public class ToolsqaTest extends TestBase {
    TestContextSetup testContextSetup;
    ToolsqaRegistrationPage toolsqaRegistrationPage;

    public ToolsqaTest(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("^User should be able to navigate to the Toolsqa Registration page with url (.+)$")
    public void user_should_be_able_to_navigate_to_the_toolsqa_registration_page_with_url(String url) {
        userUrl(url);
    }

    @When("^User should be validate all the mandatory fields if user click on Sign Up button without entering the mandatory details firstName (.+), surName (.+)$")
    public void user_should_be_validate_all_the_mandatory_fields_if_user_click_on_sign_up_button_without_entering_the_mandatory_details_firstname_surname(String firstName, String surName) throws InterruptedException {
        toolsqaRegistrationPage = testContextSetup.pageObjectManager.toolsqaRegistrationPage();
        toolsqaRegistrationPage.userRegistration(firstName, surName);
    }
//    @And("User should be on Sauce Login page")
//    public void user_should_be_on_sauce_login_page() {
//        sauceLoginPage.getTheUrl();
//    }
//    @And("User should be able to see the all items from dropdown")
//    public void user_should_be_able_to_see_the_all_items_from_dropdown() {
//        inventoryPage = testContextSetup.pageObjectManager.inventoryPage();
//        inventoryPage.clickItemsDropDown();
//    }
}