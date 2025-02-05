package org.qa.automation.testcontextsetup;

import org.qa.automation.base.TestBase;
import org.qa.automation.pageobjectmangaer.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public PageObjectManager pageObjectManager;
    public static TestBase testBase;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.browserInitialization());
    }
}
