package org.qa.automation.pages;

import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.report.Report;
import org.testng.Assert;

import static org.qa.automation.base.TestBase.scenario;

@Slf4j
public class CheckOutOverViewPage {

    public Page page;

    public CheckOutOverViewPage(Page page) {
        this.page = page;
    }

    public String finishButton = "//button[@name='finish']";
    public String successMessage = "//h2[normalize-space()='Thank you for your order!']";
    public String clickOnOpenMenu = "//button[normalize-space()='Open Menu']";
    public String clickLogOut = "//a[normalize-space()='Logout']";
    public String expectedUrl = "https://www.saucedemo.com/";

    public void finishCheckOut() {
        page.click(finishButton);
        Report.screenshot(scenario);
        String sucesMsg = page.textContent(successMessage);
        Report.log(scenario,"Success Message is : " + sucesMsg);
    }
    public void logout(){
        page.click(clickOnOpenMenu);
        page.click(clickLogOut);
        String actualUrl = page.url();
        Assert.assertEquals(actualUrl, expectedUrl);
        Report.log(scenario,"user is logged out successfully by checking the URL : " + actualUrl);
    }
}
