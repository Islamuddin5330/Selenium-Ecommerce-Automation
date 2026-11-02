
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

            String reportPath = System.getProperty("user.dir")
                    + File.separator
                    + "src"
                    + File.separator
                    + "test"
                    + File.separator
                    + "resources"
                    + File.separator
                    + "ExtentReport"
                    + File.separator
                    + "ExtentReport.html";

            File reportFile = new File(reportPath);

            // Create report directory if it does not exist
            reportFile.getParentFile().mkdirs();

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportFile);

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

    // Flush report after test execution
    public static synchronized void flushReport() {

        if (extent != null) {

            extent.flush();
        }
    }

}
