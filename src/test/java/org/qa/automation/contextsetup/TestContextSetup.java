package org.qa.automation.contextsetup;

import org.qa.automation.base.TestBase;
import org.qa.automation.objectmangaer.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public PageObjectManager pageObjectManager;
    public TestBase testBase;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.browserInitialization());
    }
}
