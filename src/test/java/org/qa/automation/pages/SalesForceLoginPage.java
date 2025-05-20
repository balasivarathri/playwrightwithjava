package org.qa.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.qa.automation.report.Report;
import org.qa.automation.utils.Url;

import static org.qa.automation.base.TestBase.page;
import static org.qa.automation.base.TestBase.scenario;

public class SalesForceLoginPage {

    // Locators as Locator objects (better practice)
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginButton;
    private final Locator setupLink;
    private final Locator createLink;
    private final Locator appsLink;

    public SalesForceLoginPage(Page page) {

        // Initialize locators once
        this.usernameInput = page.locator("//input[@name='username']");
        this.passwordInput = page.locator("//input[@name='pw']");
        this.loginButton = page.locator("//input[@name='Login']");
        this.setupLink = page.locator("//a[normalize-space()='Setup']");
        this.createLink = page.locator("//a[normalize-space()='Create']");
        this.appsLink = page.locator("//a[normalize-space()='Apps']");
    }

    public void enterUsername(String username) {
        usernameInput.fill(username);
    }

    public void enterPassword(String password) {
        passwordInput.fill(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickSetup() {
        setupLink.click();
    }

    public void clickCreate() {
        createLink.scrollIntoViewIfNeeded();
        createLink.click();
    }

    public void clickApps() {
        appsLink.scrollIntoViewIfNeeded();
        appsLink.click();
    }

    public void salesForceLoginTest(String url, String userName, String password) {
        page.navigate(Url.getUrl(url));
        enterUsername(userName);
        enterPassword(password);
        clickLogin();
        Report.screenshot(scenario);
        clickSetup();
        clickCreate();
        clickApps();
    }
}