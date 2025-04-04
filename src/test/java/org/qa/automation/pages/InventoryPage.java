package org.qa.automation.pages;

import com.microsoft.playwright.Page;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.report.Report;
import org.testng.Assert;

import static org.qa.automation.base.TestBase.scenario;

@Slf4j
public class InventoryPage {

    public Page page;

    public InventoryPage(Page page) {
        this.page = page;
    }

    public String firstItem = "//button[@name='add-to-cart-sauce-labs-backpack']";
    public String secondItem = "//button[@name='add-to-cart-sauce-labs-bike-light']";
    public String cartIcon = "//a[@data-test='shopping-cart-link']";

    public void addItemsToTheCart() {
        String expectedAddedItems = "2";
        page.click(firstItem);
        page.click(secondItem);
        String actualaAddedItems = page.textContent(cartIcon);
        log.info("User has add the items to the cart");
        Assert.assertEquals(actualaAddedItems, expectedAddedItems);
        Report.screenshot(scenario);
        Report.log(scenario, "Added items are : " + actualaAddedItems);
        page.click(cartIcon);
    }
}
