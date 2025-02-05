package org.qa.automation.pageobjectmangaer;

import com.microsoft.playwright.Page;
import org.qa.automation.pages.LoginPage;

public class PageObjectManager {

    public LoginPage loginPage;
    public Page page;

    public PageObjectManager(Page page) {
        this.page = page;
    }

    public LoginPage loginPage() {
        loginPage = new LoginPage(page);
        return loginPage;
    }
}
