package helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationFactory.BrowserFactory;
import applicationFactory.DataProviderFactory;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger = null;

	@BeforeSuite
	public void setupReprt() {
		System.out.println("INFO: Setting up the reports");
		report = new ExtentReports(
				System.getProperty("user.dir") + "/Reports/" + Utility.getCurrentDateTime() + ".html");
	}

	@Parameters("Browser")
	@BeforeClass
	public void startSession(String browser) {
		driver = BrowserFactory.startApplication(browser, DataProviderFactory.getConfig().getTestApplicationURL());
	}

	@AfterClass
	public void terminateSession() {
		driver.quit();
		System.out.println("INFO: Closing the current active Browser sessions");
	}

	@AfterSuite
	public void tearDownReport() {
		report.close();
		System.out.println("INFO: Reports generated and can be checked in Report folder");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Passed Successfully");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Utility.captureScreenshot(driver)));
		} else if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Failed");
			logger.log(LogStatus.INFO, logger.addScreenCapture(Utility.captureScreenshot(driver)));
			logger.log(LogStatus.ERROR, result.getThrowable().getMessage());
		}
		report.endTest(logger);
	}
}
