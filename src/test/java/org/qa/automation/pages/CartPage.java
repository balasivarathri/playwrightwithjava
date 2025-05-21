package org.qa.automation.pages;

import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.report.Report;

import static org.qa.automation.base.TestBase.scenario;

@Slf4j
public class CartPage {

    public Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public String checkOutButton = "//button[@name='checkout']";
    public String enterFristName = "input[placeholder='First Name']";
    public String enterLastName = "//input[@placeholder='Last Name']";
    public String enterPostalCode = "//input[@placeholder='Zip/Postal Code']";
    public String continueButton = "//input[@name='continue']";

    public void doTheCheckOutProcess() {
        Report.log(scenario,"Verify that the two added items are displayed in the cart with the correct names and prices");
        Report.screenshot(scenario);
        page.click(checkOutButton);
    }
    public void enterTheCheckOutDetails(){
        page.fill(enterFristName,"John");
        page.fill(enterLastName,"Doe");
        page.fill(enterPostalCode,"12345");
        page.click(continueButton);
        Report.screenshot(scenario);

    }
}
