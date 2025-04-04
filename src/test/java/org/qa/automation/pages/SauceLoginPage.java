package org.qa.automation.pages;

import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;
import org.qa.automation.report.Report;
import static org.qa.automation.base.TestBase.scenario;
import org.testng.Assert;

public class SauceLoginPage {

    public Page page;

    public SauceLoginPage(Page page){
        this.page = page;
    }

    public String userName = "//input[@placeholder='Username']";
    public String saucePassword = "//input[@placeholder='Password']";
    public String login = "//input[@name='login-button']";
    String expectedUrl = "https://www.saucedemo.com/inventory.html";

    public void userSauceLogin(String user, String password){
        page.fill(userName, user);
        page.fill(saucePassword, password);
        page.click(login);
        Report.log(scenario,"User has successfully logged in");
    }
    public void userLoginPageScreenShot(){
        Report.screenshot(scenario);
    }
    public void getTheUrl(){
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl);
        Report.log(scenario,"Assertion passed and Actual Url is : " + actualUrl);
    }

}
