package com.veeva.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setup() {

        
        if (extent == null) {

            ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReport.html");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
    }

    public static void createTest(String name) {
        test = extent.createTest(name);
    }

    public static void flush() {
        extent.flush();
    }
}