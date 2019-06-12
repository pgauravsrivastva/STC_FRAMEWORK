package STCUtil;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.google.common.base.Stopwatch;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import STCApplicationDriver.DriverFactory;
import helper.Logger;

public class BasePage {

	public static WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	public WebDriverWait wait;
	public Stopwatch stopwatch;
	public ITestResult tresult;
	

	public StopWatch pageLoad = new StopWatch();

	
	 /* @BeforeTest
	  public void startApplication() {
	  
	  pageLoad.start(); System.out.println("Execution Start Timing is " +
	  pageLoad.getStartTime());
	  
	  
	  
	  }*/
	  
	  @BeforeMethod
		public void setUp(ITestResult testrun) throws Exception {
			STCDataProvider.ConfigDataProvider config=new STCDataProvider.ConfigDataProvider();
			helper.Logger.LOG(Level.INFO, "Browser Opened and Maximized");
			DriverFactory.startApplication("chrome", config.getOCPApplicationURL());
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 15);
			tresult = testrun;
			stopwatch = Stopwatch.createStarted();
			

		}

	 

	/**
	 * Method to click on the WebElement
	 * 
	 * @param element
	 */

	public static void click(WebElement element) {

		element.click();
	}

	/**
	 * Method to maximize browser window
	 */
	public static void maximizewindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Method to enter text in a textbox
	 * 
	 * @param element
	 * @param text
	 */
	public static void enterText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);

	}

	/**
	 * Method to fetch the string value of WebElement
	 * 
	 * @param xpath
	 * @return text
	 */
	public static String getText(WebElement element) {
		String text = element.getText();
		return text;

	}

	/**
	 * Method to select value in dropdown by text
	 * 
	 * @param element
	 * @param text
	 */
	public static void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * Method to select value in dropdown by index
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	/**
	 * Method to scroll page down
	 */
	public static void scrolldown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

	}

	/**
	 * Method to get current date and time
	 * 
	 * @return formatedDate
	 */
	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");

		Date date = new Date();

		String formatedDate = dateFormat.format(date);

		return formatedDate;

	}

	/**
	 * Method to capture screenshot
	 */
	public static void capturescreenshot() {
		try {
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(file, new File("./Screenshots/" + getCurrentDateTime() + ".png"));
			System.out.println("screenshot Captured");

		} catch (Exception e) {
			System.out.println("unable to take screenshot");
			System.out.println(e.getMessage());

		}

	}

	/**
	 * 
	 * @param driver2
	 * @return
	 */
	@SuppressWarnings("unused")
	private static TakesScreenshot TakeScreenshot(WebDriver driver2) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to synchronize
	 * 
	 * @param driver
	 * @param element
	 * @param time
	 */
	public static void syncWebElement(WebElement element, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		// wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));

		Boolean status = wait.until(ExpectedConditions.visibilityOfElementLocated((By) element)).isDisplayed();
		System.out.println("Wait for Element Visibility::Now Element visibility is " + status);

	}

	/**
	 * Method to determine total no. of links present in page
	 */
	public static void PresentTotalLinks() {

		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Total no. of links present in page is " + list.size());

		for (int i = 0; i < list.size(); i++) {

			WebElement ele = list.get(i);
			String linkurl = ele.getAttribute("href");
			System.out.println(linkurl);

		}

	}

	/**
	 * Method to determine whether the WebElement is displayed on the page
	 * 
	 * @param element
	 */
	public static void isWeblementPresent(WebElement element) {
		Boolean display = element.isDisplayed();
		System.out.println("Webelement is " + display + "ly" + " Present");
	}

	/**
	 * Method to take screenshot, if TC failed only.
	 * 
	 * @param result
	 */
//	@AfterMethod
//	public void tearDown(ITestResult result) {
//
//		if (ITestResult.FAILURE == result.getStatus()) {
//
//			capturescreenshot();
//
//		}
//		// driver.quit();
//		System.out.println("Applcation closed");
//
//	}

}
