package org.qa.automation.pages;

import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.base.TestBase;
import org.qa.automation.report.Report;
import org.testng.Assert;

@Slf4j
public class SauceLoginPage extends TestBase {

    public Page page;

    public SauceLoginPage(Page page) {
        this.page = page;
    }

    public String userName = "//input[@placeholder='Username']";
    public String saucePassword = "//input[@placeholder='Password']";
    public String login = "//input[@name='login-button']";
    public String expectedUrl = "https://www.saucedemo.com/inventory.html";
    public String errorMessage = "h3[data-test='error']";

    public void userSauceLogin(String user, String password) {
        page.fill(userName, user);
        page.fill(saucePassword, password);
        page.click(login);
        Report.log(scenario, "User has successfully logged in");
    }

    public void userLoginPageScreenShot() {
        Report.screenshot(scenario);
    }

    public void getTheUrl() {
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl);
        Report.log(scenario, "Assertion passed and Actual Url is : " + actualUrl);
    }

    public void validateErrorMessage() {
        String actualErrorMes = page.locator(errorMessage).textContent();
        String expectedErrorMes = "Epic sadface: Sorry, this user has been locked out.";
        log.info("Actual Error Message is : " + actualErrorMes);
        Assert.assertEquals(expectedErrorMes, actualErrorMes);
        Report.log(scenario, "Actual Error Message is : " + actualErrorMes);
    }

}
