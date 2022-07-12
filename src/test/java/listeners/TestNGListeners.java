package listeners;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;

/**
 * Author: Bastian Silva
 */
public class TestNGListeners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(tests.Tests.class);

    public void onTestStart(ITestResult result) {
        logger.info("Test started: " + result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed: " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        TakesScreenshot screenshot = (TakesScreenshot) DriverFactory.getDriver();
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("./failed_tests/" + result.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.error("Test failed: " + result.getName() + " a screenshot was taken");
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn("Test skipped: " + result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.warn("Test failed but within success percentage: " + result.getName());
    }

    public void onStart(ITestContext context) {
        logger.info("Test started: " + context.getName());
    }

    public void onFinish(ITestContext context) {
        logger.info("Test finished: " + context.getName());
    }

}
