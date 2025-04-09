package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtil;
import tests.BaseTest;

public class TestListner implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).driver;
        String testName = result.getName();
        ScreenshotUtil.captureScreenshot(driver, testName);
    }
}