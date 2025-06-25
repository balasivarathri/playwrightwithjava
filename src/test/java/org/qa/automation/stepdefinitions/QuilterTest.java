package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.qa.automation.base.TestBase;
import org.qa.automation.contextsetup.TestContextSetup;
import org.qa.automation.pages.QuilterHomePage;
import org.qa.automation.pages.ToolsqaRegistrationPage;
import org.qa.automation.report.Report;

public class QuilterTest extends TestBase {
    TestContextSetup testContextSetup;
    QuilterHomePage quilterHomePage;

    public QuilterTest(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("^User should be able to navigate to the Quilter page with url (.+)$")
    public void user_should_be_able_to_navigate_to_the_quilter_page_with_url(String url) throws InterruptedException {
        userUrl(url);
        Thread.sleep(2000);
        Report.screenshot(scenario);
    }

    @When("^User should be validate all the links present on the quilter homepage$")
    public void user_should_be_validate_all_the_links_present_on_the_quilter_homepage() throws InterruptedException {
        quilterHomePage = testContextSetup.pageObjectManager.quilterHomePage();
        quilterHomePage.navigateToCustomerTab();
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