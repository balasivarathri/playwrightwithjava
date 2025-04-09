package org.qa.automation.contextsetup;

import org.qa.automation.base.TestBase;
import org.qa.automation.objectmangaer.ApiObjectManager;

import java.io.IOException;

public class ApiContextSetup {

    public ApiObjectManager apiObjectManager;
    public TestBase testBase;

    public ApiContextSetup() throws IOException {
        testBase = new TestBase();
        apiObjectManager = new ApiObjectManager(testBase.apiInitialization());
    }
}
