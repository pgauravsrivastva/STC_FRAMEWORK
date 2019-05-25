package applicationTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.relevantcodes.extentreports.LogStatus;


import applicationFactory.STCBrowserFactory;
import applicationPages.LoginPage;
import applicationPages.SpicejetLoginLandingPage;
import dataProvider.ConfigDataProvider;
import helper.BasePage;
import helper.Utility;

public class TestSpicejet extends BasePage {

	@Test
	public void SmokeSpicejet() throws Exception {

		ConfigDataProvider config = new ConfigDataProvider();

		STCBrowserFactory.startapplication("chrome", config.getTestApplicationURL());

		Thread.sleep(6000);
		
		SpicejetLoginLandingPage landing = new SpicejetLoginLandingPage();
		landing.ClickRoundtrip();
		landing.Clickdeparture();

		landing.ClickMumbai();
		landing.ClicktoCity();

		landing.bengloretoCity("ben");
        landing.clickdate();
		landing.clickSearch();
		
		landing = new SpicejetLoginLandingPage();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		landing.clickContinue();

	}

}
