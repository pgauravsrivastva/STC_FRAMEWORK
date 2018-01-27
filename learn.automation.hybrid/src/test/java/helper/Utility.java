package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");

		Date date = new Date();

		String formatedDate = dateFormat.format(date);

		return formatedDate;

	}

	public static String captureScreenshot(WebDriver driver) {

		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + Utility.getCurrentDateTime()
				+ ".png";

		File dest = new File(screenshotPath);

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("ERROR: Unable to capture Screenshot");
			System.out.println("ERROR: " + e.getMessage());
		}

		return screenshotPath;
	}

	public static void highLightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {

			System.out.println(e.getMessage());
		}

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);

	}
	
	
	public static void syncWebElement(WebDriver driver,WebElement element,int time)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	public static WebElement waitForWebElement(WebDriver driver,WebElement element,int time)
	{
		
		syncWebElement(driver, element, time);
		
		highLightElement(driver, element);
		
		return element;
	}
	
	
	
	

}
