package helper;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationFactory.STCBrowserFactory;
import dataProvider.ConfigDataProvider;

public class BasePage {
	
	public static WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	public StopWatch pageLoad = new StopWatch();
	
	@BeforeTest
	public void startApplication() {

		pageLoad.start();
		System.out.println("Execution Start Timing is " + pageLoad.getStartTime());
		ConfigDataProvider config = new ConfigDataProvider();

		STCBrowserFactory.startapplication("chrome", config.getTestApplicationURL());
		
		

	}
	
	//info: to click
	public static void click(String xpath) {
		
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}
	
	
	//info: Enter Text in textbox
	public static void enterText(String xpath,String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}
	
	public static String getText(String xpath) {
		String text=driver.findElement(By.xpath(xpath)).getText();
		return text;
		
	}
	
	public static void select(String xpath, String text) {
		Select sec=new Select(driver.findElement(By.xpath(xpath)));
		sec.selectByVisibleText(text);
	}
	public static void selectbyindex(String xpath,int index) {
		Select sec=new Select(driver.findElement(By.xpath(xpath)));
		sec.selectByIndex(index);
	}
	
	public static void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}
	
	
	
	//info: Get curent date and time
	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");

		Date date = new Date();

		String formatedDate = dateFormat.format(date);

		return formatedDate;

	}

	//info: Capture Screenshot
	public static void capturescreenshot() {
		try {
			File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(f, new File("C:/Users/nitya.ranjan.behera/git/STC_FRAMEWORK/learn.automation.hybrid/Screenshots/"+BasePage.getCurrentDateTime()+".png"));
			System.out.println("screenshot Captured");
			
		} catch (Exception e) {
			System.out.println("unable to take screenshot");
			System.out.println(e.getMessage());
			
		}
		
	}
	
	@SuppressWarnings("unused")
	private static TakesScreenshot TakeScreenshot(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//Info: Wait until perticular webelement is not displayed.
	public static void syncWebElement(WebDriver driver, String xpath, int time) {
        
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(xpath))));
		
		Boolean status=ele.isDisplayed();
		System.out.println("Wait for Element Visibility::Now Element visibility is " + status);
	
		

	}
	
	
	
	
	
	
	//info: Total no. of links present in page
	public static void PresentTotalLinks() {
		
		List<WebElement>list=driver.findElements(By.tagName("a"));
		System.out.println("Total no. of links present in page is " + list.size());
		
		for (int i = 0; i < list.size(); i++) {
			
			WebElement ele=list.get(i);
			String linkurl=ele.getAttribute("href");
			System.out.println(linkurl);
			
			
		}
		
		
	}
	
	public static void isWeblementPresent(String xpath) {
		Boolean display=driver.findElement(By.xpath(xpath)).isDisplayed();
		System.out.println("Webelement is " +display+"ly" +" Present");
	}
	
	
	


    
	
	//info: Take screenshot, if TC failed only.
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			
			capturescreenshot();
			
			
		}
		//driver.quit();
		System.out.println("Applcation closed");
		
		
	

}
	
	
	
	
}
