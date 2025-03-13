package org.qa.automation.pages;

import com.microsoft.playwright.Page;
import org.qa.automation.base.TestBase;
import org.qa.automation.report.Report;

import static org.qa.automation.base.TestBase.scenario;

public class LoginPage {

    public Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    //1. String Locators or Object Repository
    public String login_text = "input[placeholder='Username']";
    public String password_text = "input[placeholder='Password']";
    public String login_button = "input[value='Login']";
    public String errorMessage = "h3[data-test='error']";


    public void enterLoginText(String userName) {
        page.fill(login_text, userName);
    }

    public void enterPasswordText(String password) {
        page.fill(password_text, password);
    }

    public void clickLoginButton() {
        page.click(login_button);
    }

    public void loginTest(String userName, String password) throws InterruptedException {
        enterLoginText(userName);
        enterPasswordText(password);
        clickLoginButton();
        Thread.sleep(5000);
        Report.screenshot(scenario);
    }
    public void validateErrorMessage(){
        String actualErrorMes = page.locator(errorMessage).textContent();
        String expectedErrorMes = "Epic sadface: Sorry, this user has been locked out.";
        System.out.println(actualErrorMes);
        if (actualErrorMes.equals(expectedErrorMes)) {
            System.out.println("Message validated successfully!");
        } else {
            System.out.println("Message validation failed. Expected: " + expectedErrorMes + " but got: " + actualErrorMes);
        }
        Report.log(scenario,"Validated message is : " + actualErrorMes);
    }
}
