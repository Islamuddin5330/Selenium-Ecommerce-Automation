
package com.commerce.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    /*
     * Class                  Purpose
     * ExtentReports          Main reporting engine
     * ExtentSparkReporter    Generates the HTML report
     * ExtentTest             Represents an individual test
     */

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {

        if (extent == null) {

            File file = new File(
                    System.getProperty("user.dir")
                    + "\\src\\test\\resources\\ExtentReport\\ExtentReport.html"
            );

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(file);

            extent = new ExtentReports();

            extent.attachReporter(spark);

            extent.setSystemInfo("Project Name", "Commerce Automation");
            extent.setSystemInfo("Automation Tool", "Selenium WebDriver");
            extent.setSystemInfo("Programming Language", "Java");
            extent.setSystemInfo("Test Framework", "TestNG");
            extent.setSystemInfo("Tester", "Automation Tester");

        }

        return extent;
    }

    public static void createTest(String testName) {

        ExtentTest test =
                getInstance().createTest(testName);

        setTest(test);
    }
    
    public static void setTest(ExtentTest test) {

        extentTest.set(test);

    }

    public static ExtentTest getTest() {

        return extentTest.get();

    }

    public static void unload() {

        extentTest.remove();

    }

}
