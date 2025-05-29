package org.qa.automation.cucumberoptions;

import com.microsoft.playwright.Tracing;
import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.qa.automation.runner.CustomRunner;
import org.qa.automation.processor.Initialize;
import org.qa.automation.processor.Processor;
import org.qa.automation.processor.TearDown;

import java.io.IOException;
import java.nio.file.Paths;

import static org.qa.automation.base.TestBase.browserContext;

@Slf4j
@RunWith(CustomRunner.class)
@CucumberOptions(
        monochrome = true,
        features = "src/test/java/org/qa/automation/features",
        glue = {"org.qa.automation.cucumberoptions", "org.qa.automation.stepdefinitions"},
        plugin = {"json:target/jsonReports/cucumber-reports.json"}
)

public class TestRunner {
    private static String executionDateTime;
    private static final String DATEFORMAT = "dd-MM-yyyy_hh-mm-ss";

    @Initialize
    public static void initialize() throws IOException {
        log.info("------ Initialize: START ------");
        executionDateTime = Processor.getDateAsString(DATEFORMAT);
        Processor.setTeamFeatureDirectory();
        Processor.overrideFeature();
        log.info("------ Intialize: END ------");
    }

    @TearDown
    public static void teardown() {
        log.warn("------ Teardown: START ------");
        Processor.initializeTeardown(executionDateTime);
//                browserContext.tracing().stop(new Tracing.StopOptions()
//                .setPath(Paths.get("trace.zip")));
        log.info("Teardown: END ------");
    }
}
