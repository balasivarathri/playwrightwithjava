package org.qa.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.report.Report;

import static org.qa.automation.base.TestBase.scenario;

@Slf4j
public class CartPage {

    private final Locator checkOutButton;
    private final Locator enterFristName;
    private final Locator enterLastName;
    private final Locator enterPostalCode;
    private final Locator continueButton;


    public CartPage(Page page) {
        this.checkOutButton = page.locator("//button[@name='checkout']");
        this.enterFristName = page.locator("input[placeholder='First Name']");
        this.enterLastName = page.locator("//input[@placeholder='Last Name']");
        this.enterPostalCode = page.locator("//input[@placeholder='Zip/Postal Code']");
        this.continueButton = page.locator("//input[@name='continue']");
    }

    public void clickCheckOutButton() {
        checkOutButton.click();
    }

    public void enterFristName(String firstName) {
        enterFristName.fill(firstName);
    }
    public void enterLastName(String lastName) {
        enterLastName.fill(lastName);
    }
    public void enterPostalCode(String postalCode) {
        enterPostalCode.fill(postalCode);
    }
    public void clickcontinueButton() {
        continueButton.click();
    }

    public void doTheCheckOutProcess() {
        Report.log(scenario,"Verify that the two added items are displayed in the cart with the correct names and prices");
        Report.screenshot(scenario);
        clickCheckOutButton();
    }
    public void enterTheCheckOutDetails(){
        enterFristName("Balu");
        enterLastName("Sivarathri");
        enterPostalCode("1686");
        clickcontinueButton();
        Report.screenshot(scenario);
    }
}
