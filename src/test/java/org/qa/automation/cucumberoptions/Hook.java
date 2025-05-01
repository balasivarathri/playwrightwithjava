package org.qa.automation.cucumberoptions;

import com.microsoft.playwright.Tracing;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.qa.automation.base.TestBase;

import java.nio.file.Paths;

@Slf4j
public class Hook extends TestBase {
    public Hook() {
    }

    @Before(order = 0)
    public void beforeScenario(Scenario scenario) {
        TestBase.scenario = scenario;
        log.info("------ Scenario: START ------");
        log.info("Scenario Name: " + scenario.getName());
    }

    @After(order = 0)
    public void afterScenario(Scenario scenario) {
        log.info("Scenarios Result: " + scenario.getStatus());
        log.info("------ Scenario: END ------");
    }
}



