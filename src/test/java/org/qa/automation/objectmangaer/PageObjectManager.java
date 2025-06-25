package org.qa.automation.objectmangaer;

import com.microsoft.playwright.Page;
import org.qa.automation.pages.*;

public class PageObjectManager {

    public SalesForceLoginPage salesForceLoginPage;
    public SauceLoginPage sauceLoginPage;
    public InventoryPage inventoryPage;
    public CartPage cartPage;
    public CheckOutOverViewPage checkOutOverViewPage;
    public ToolsqaRegistrationPage toolsqaRegistrationPage;
    public QuilterHomePage quilterHomePage;
    public Page page;

    public PageObjectManager(Page page) {
        this.page = page;
    }

    public SalesForceLoginPage salesForceLoginPage() {
        salesForceLoginPage = new SalesForceLoginPage(page);
        return salesForceLoginPage;
    }

    public SauceLoginPage sauceLoginPage() {
        sauceLoginPage = new SauceLoginPage(page);
        return sauceLoginPage;
    }
    public InventoryPage inventoryPage() {
        inventoryPage = new InventoryPage(page);
        return inventoryPage;
    }
    public CartPage cartPage() {
        cartPage = new CartPage(page);
        return cartPage;
    }
    public CheckOutOverViewPage checkOutOverViewPage() {
        checkOutOverViewPage = new CheckOutOverViewPage(page);
        return checkOutOverViewPage;
    }
    public ToolsqaRegistrationPage toolsqaRegistrationPage() {
        toolsqaRegistrationPage = new ToolsqaRegistrationPage(page);
        return toolsqaRegistrationPage;
    }
    public QuilterHomePage quilterHomePage() {
        quilterHomePage = new QuilterHomePage(page);
        return quilterHomePage;
    }
}
