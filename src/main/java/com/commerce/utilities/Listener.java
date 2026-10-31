
package com.commerce.utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.commerce.actionclass.ActionClass;
import com.commerce.baseclass.BaseClass;

public class Listener implements ITestListener {

	private static final Logger logger = LoggerManager.getLogger();

	@Override
	public void onTestStart(ITestResult result) {

		logger.info("Test Started : " + result.getName());

		// Create only one Extent test
		ExtentManager.setTest(ExtentManager.getInstance().createTest(result.getName()));

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		logger.info("Test Passed : " + result.getName());

		ExtentManager.getTest().log(Status.PASS, "Test Passed");

		ExtentManager.unload();

	}

	@Override
	public void onTestFailure(ITestResult result) {

		logger.error("Test Failed: " + result.getName());

		logger.error("Failure Reason: ", result.getThrowable());

		WebDriver driver = BaseClass.getDriver();

		if (ExtentManager.getTest() != null) {

			ExtentManager.getTest().log(Status.FAIL, result.getThrowable());
		}

		if (driver != null) {

			String screenshotPath = ActionClass.captureScreenshot(driver, result.getName());

			if (screenshotPath != null) {

				try {

					ExtentManager.getTest().addScreenCaptureFromPath(screenshotPath);

					logger.info("Screenshot attached successfully: " + screenshotPath);

				} catch (Exception e) {

					logger.error("Screenshot attachment failed: " + e.getMessage());
				}

			} else {

				logger.error("Screenshot capture failed.");
			}

		} else {

			logger.error("WebDriver is null. Screenshot cannot be captured.");
		}

		ExtentManager.unload();

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		boolean retryScheduled = Boolean.TRUE.equals(result.getAttribute(RetryAnalyzer.RETRY_ATTRIBUTE));

		if (retryScheduled) {

			logger.warn("Retry scheduled for test: " + result.getName());

			logger.warn("Original failure reason: ", result.getThrowable());

			if (ExtentManager.getTest() != null) {

				ExtentManager.getTest().log(Status.WARNING, "Test failed. Retry scheduled.");

				ExtentManager.getTest().log(Status.INFO, "Failure reason: " + result.getThrowable());
			}

		} else {

			logger.warn("Test Skipped : " + result.getName());

			logger.warn("Skipped Reason : " + result.getThrowable());

			if (ExtentManager.getTest() != null) {

				ExtentManager.getTest().log(Status.SKIP, "Test Skipped");
			}
		}

		ExtentManager.unload();

	}

	@Override
	public void onStart(ITestContext context) {

		logger.info("Test Execution Started : " + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {

		logger.info("Test Execution Finished : " + context.getName());

		int passed = context.getPassedTests().size();

		int failed = context.getFailedTests().size();

		int actualSkipped = 0;

		for (ITestResult result : context.getSkippedTests().getAllResults()) {

			boolean retryScheduled = Boolean.TRUE.equals(result.getAttribute(RetryAnalyzer.RETRY_ATTRIBUTE));

			if (!retryScheduled) {
				actualSkipped++;
			}
		}

		logger.info("Passed Tests : " + passed);

		logger.info("Failed Tests : " + failed);

		logger.info("Skipped Tests : " + actualSkipped);

		ExtentManager.getInstance().flush();

	}

}
