package org.qa.automation.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.base.TestBase;
import org.qa.automation.report.Report;
import org.qa.automation.utils.Payloads;
import org.testng.Assert;

@Slf4j
public class QuilterHomePage extends TestBase {


    private final Locator customerTab;
    private final Locator regionDropdown;
    private final Locator regionSelect;
    private final Locator iamDropDown;
    private final Locator customerSelection;
    private final Locator acceptCookiesButton;
    private final Locator productsServicesTab;
    private final Locator productsNavigation;
    private final Locator pensionsPage;

    public QuilterHomePage(Page page) {
        this.customerTab = page.locator("//span[normalize-space()='Customer']");
        this.regionDropdown = page.locator("body > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > button:nth-child(1)");
        this.regionSelect = page.locator("#region-select-list-hat-app-uk");
        this.iamDropDown = page.locator("body > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > button:nth-child(1)");
        this.customerSelection = page.locator("#role-select-list-hat-app-cust");
        this.acceptCookiesButton = page.locator("//button[normalize-space()='Accept all cookies']");
        this.productsServicesTab = page.locator("//button[normalize-space()='Products & services']");
        this.productsNavigation = page.locator("//span[normalize-space()='Products']");
        this.pensionsPage = page.locator("//a[@href='/products-and-services/pensions/']");
    }

    public void clickCustomerTab() {
        customerTab.click();
    }
    public void clickBannerValues() {
        regionDropdown.click();
        regionSelect.click();
        iamDropDown.click();
        customerSelection.click();
        acceptCookiesButton.click();
    }
    public void clickProductsServicesTab() {
        productsServicesTab.click();
    }
    public void navigateProductsNavigation() {

//        Locator menuTab = page.locator("text=Products & services");
//        menuTab.hover();
//
//        // Step 2: Wait for flyout item "Products" to be visible
//        Locator flyoutItem = page.locator("text=Products", new Page.LocatorOptions().setHasText("Products"));
//        flyoutItem.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
//
//        // Step 3: Click on the "Products" item in the flyout
//        flyoutItem.click();
        productsNavigation.click();
    }
    public void clickPensionsPage() {
        pensionsPage.click();
    }
    public void getAllLinks(){

        Locator links = page.locator("a");

        int count = links.count();
        System.out.println("Total links found: " + count);

        for (int i = 0; i < count; i++) {
            String href = links.nth(i).getAttribute("href");
            String text = links.nth(i).innerText().trim();

            System.out.println("Link " + (i + 1) + ": [" + text + "] -> " + href);
        }
    }

    public void navigateToCustomerTab() throws InterruptedException {
        clickBannerValues();
        Report.screenshot(scenario);
        clickCustomerTab();
        getAllLinks();
        clickProductsServicesTab();
        Thread.sleep(3000);
        clickProductsServicesTab();
        Report.screenshot(scenario);
    }

}
