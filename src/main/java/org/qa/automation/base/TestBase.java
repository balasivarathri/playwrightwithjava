package org.qa.automation.base;

import com.microsoft.playwright.*;
import io.cucumber.java.Scenario;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class TestBase {
    public static Playwright playwright;
    public static Browser browser;
    public static BrowserContext browserContext;
    public static Page page;
    public static Properties prop;
    public static Scenario scenario;
    public String url;

    public Page browserInitialization() throws IOException {
        prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/config/config.properties");
        prop.load(fileInputStream);
        String browserName = prop.getProperty("browser");
        url = prop.getProperty("url");
        playwright = Playwright.create();
        switch (browserName.toLowerCase()) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(List.of("--start-maximized")));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized")));
                break;
            default:
                System.out.println("please provide the correct browserName ......");
                break;
        }
        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = browserContext.newPage();
        page.navigate(url);
        return page;
    }
}
