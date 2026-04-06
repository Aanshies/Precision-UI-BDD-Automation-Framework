package com.veeva.stepdefinitions;

import com.veeva.base.BaseTest;
import com.veeva.utils.ExtentManager;
import com.veeva.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    @Before
    public void beforeScenario(Scenario scenario) {

        // Start Report
        ExtentManager.setup();
        ExtentManager.createTest(scenario.getName());

        // Open Browser
        initialization();
    }

    @After
    public void afterScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(driver, scenario.getName());
            ExtentManager.test.fail("Test Failed - Screenshot captured");
        }

        tearDown();
        ExtentManager.flush();
    }
}