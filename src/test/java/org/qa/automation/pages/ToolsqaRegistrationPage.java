package org.qa.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.base.TestBase;
import org.qa.automation.report.Report;
import org.qa.automation.utils.Payloads;
import org.testng.Assert;

@Slf4j
public class ToolsqaRegistrationPage extends TestBase {


    private final Locator createNewAccount;
    private final Locator signUp;
    private final Locator firstName;
    private final Locator surName;

    public ToolsqaRegistrationPage(Page page) {
        this.createNewAccount = page.locator("//a[normalize-space()='Create new account']");
        this.signUp = page.locator("//button[@name='websubmit']");
        this.firstName = page.locator("//input[@name='firstname']");
        this.surName = page.locator("//input[@name='lastname']");
    }

    public void clickCreateNewAccountButton() {
        createNewAccount.click();
    }
    public void clicksignUpButton() {
        signUp.click();
    }
    public void enterFirstName(String firstname) {
        firstName.fill(firstname);
    }
    public void enterSurname(String surname) {
        surName.fill(surname);
    }

    public void userRegistration(String firstname, String surname) throws InterruptedException {
        clickCreateNewAccountButton();
        Thread.sleep(3000);
        clicksignUpButton();
        enterFirstName(Payloads.generateRandomString());
        enterSurname(Payloads.generateRandomString());
    }

    public void getTheUrl() {
        String actualUrl = page.url();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(actualUrl, expectedUrl);
        Report.log(scenario, "Assertion passed and Actual Url is : " + actualUrl);
    }

//    public void validateErrorMessage() {
//        String actualErrorMes = errorMessage.textContent();
//        String expectedErrorMes = "Epic sadface: Sorry, this user has been locked out.";
//        log.info("Actual Error Message is : " + actualErrorMes);
//        Assert.assertEquals(expectedErrorMes, actualErrorMes);
//        Report.log(scenario, "Actual Error Message is : " + actualErrorMes);
//    }

}
