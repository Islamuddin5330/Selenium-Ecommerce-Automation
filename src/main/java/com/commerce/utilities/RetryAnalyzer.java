package com.commerce.utilities;

import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private static final Logger logger =
            LoggerManager.getLogger();

    private int retryCount = 0;

    private static final int maxRetryCount = 2;

    public static final String RETRY_ATTRIBUTE =
            "retryScheduled";

    @Override
    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {

            retryCount++;

            // Mark this result as a scheduled retry
            result.setAttribute(RETRY_ATTRIBUTE, true);

            logger.warn(
                "Retrying test: "
                + result.getName()
                + " | Retry attempt: "
                + retryCount
            );

            return true;
        }

        result.setAttribute(RETRY_ATTRIBUTE, false);

        logger.error(
            "Maximum retry attempts reached for: "
            + result.getName()
        );

        return false;
    }
		

	
}
