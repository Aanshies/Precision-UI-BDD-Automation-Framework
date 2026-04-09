package com.automation.stepdefinitions;

import com.automation.base.BaseTest;
import com.automation.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

    @Before
    public void setup() {
        init();
    }

    @After
    public void tearDown(Scenario scenario) {

        // ✅ capture screenshot on failure
        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(driver, scenario.getName());
        }

        if (driver != null) {
            driver.quit();
        }
    }
}