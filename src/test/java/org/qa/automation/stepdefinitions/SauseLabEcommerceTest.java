package org.qa.automation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.qa.automation.pages.*;
import org.qa.automation.contextsetup.TestContextSetup;

public class SauseLabEcommerceTest {
    TestContextSetup testContextSetup;
    SauceLoginPage sauceLoginPage;
    InventoryPage inventoryPage;
    CheckOutOverViewPage checkOutOverViewPage;
    CartPage cartPage;

    public SauseLabEcommerceTest(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }


    @Given("^User should be able to saucelogin with given parameters url (.+) username (.+) and password (.+)$")
    public void user_should_be_able_to_saucelogin_with_given_parameters_url_username_and_password(String url, String username, String password) {
        sauceLoginPage = testContextSetup.pageObjectManager.sauceLoginPage();
        sauceLoginPage.userSauceLogin(url,username, password);
    }
    @When("User should be navigated to Sauce Login Page")
    public void user_should_be_navigated_to_sauce_login_page() {
        sauceLoginPage.userLoginPageScreenShot();
    }
    @And("User should be on Sauce Login page")
    public void user_should_be_on_sauce_login_page() {
        sauceLoginPage.getTheUrl();
    }
    @And("User can be able add the items to the cart")
    public void user_can_able_add_the_items_to_the_cart() {
        inventoryPage = testContextSetup.pageObjectManager.inventoryPage();
        inventoryPage.addItemsToTheCart();
    }
    @And("User should be on the cart page to checkout process")
    public void user_should_be_on_the_cart_page_to_checkout_process() {
        cartPage = testContextSetup.pageObjectManager.cartPage();
        cartPage.doTheCheckOutProcess();
        cartPage.enterTheCheckOutDetails();
    }
    @Then("User should successfully logged out the application")
    public void user_should_successfully_logged_out_the_application() {
        checkOutOverViewPage = testContextSetup.pageObjectManager.checkOutOverViewPage();
        checkOutOverViewPage.finishCheckOut();
        checkOutOverViewPage.logout();
    }
    @Then("^User should validate the error message$")
    public void user_should_validate_the_error_fields() {
        sauceLoginPage.validateErrorMessage();
    }
}