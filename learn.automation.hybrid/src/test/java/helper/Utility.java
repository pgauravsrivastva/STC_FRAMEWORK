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

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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

	public static void syncWebElement(WebDriver driver, WebElement element, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public static WebElement waitForWebElement(WebDriver driver, WebElement element, int time) {

		syncWebElement(driver, element, time);

		highLightElement(driver, element);

		return element;
	}

	public static void verifyBrokenLink(String linkurl) {
		URL url = null;
		HttpURLConnection connection = null;

		try {
			url = new URL(linkurl);
		} catch (MalformedURLException e) {
			System.out.println("URL is not configured");
		}

		try {
			connection = (HttpURLConnection) url.openConnection();

			connection.setConnectTimeout(5000);

			connection.connect();

		} catch (IOException e) {

		}

		int code = 0;
		try {
			code = connection.getResponseCode();
		} catch (IOException e) {

		}

		System.out.println("Response Code from Server is " + code);

		Assert.assertEquals(code, 200);
	}

	public static void verifyMultipleBrokenLink(WebDriver ldriver, String xpath) {

		SoftAssert soft = new SoftAssert();
		URL url = null;
		HttpURLConnection connection = null;

		List<WebElement> allLinks = ldriver.findElements(By.xpath(xpath));

		System.out.println("Total link to verify " + allLinks.size());

		for (WebElement ele : allLinks) {

			String hrefurl = ele.getAttribute("href");

			System.out.println("Testing link with this url " + hrefurl);

			try {
				url = new URL(hrefurl);
			} catch (MalformedURLException e) {
				System.out.println("URL is not configured");
			}

			try {
				connection = (HttpURLConnection) url.openConnection();

				connection.setConnectTimeout(5000);

				connection.connect();

			} catch (IOException e) {

			}

			int code = 0;
			try {
				code = connection.getResponseCode();
			} catch (IOException e) {

			}

			System.out.println("Response Code from Server is " + code);
			soft.assertEquals(code, 200);

		}

		soft.assertAll();

	}

	public static void verifyMultipleBrokenImages(WebDriver ldriver, String xpath) {

		SoftAssert soft = new SoftAssert();
		URL url = null;
		HttpURLConnection connection = null;

		List<WebElement> allLinks = ldriver.findElements(By.xpath(xpath));

		System.out.println("Total Images to verify " + allLinks.size());

		for (WebElement ele : allLinks) {

			String hrefurl = ele.getAttribute("src");

			System.out.println("Testing Images with this url " + hrefurl);

			try {
				url = new URL(hrefurl);
			} catch (MalformedURLException e) {
				System.out.println("URL is not configured");
			}

			try {
				connection = (HttpURLConnection) url.openConnection();

				connection.setConnectTimeout(5000);

				connection.connect();

			} catch (IOException e) {

			}

			int code = 0;
			try {
				code = connection.getResponseCode();

			} catch (IOException e) {

			}

			System.out.println("Response Code from Server is " + code);

			soft.assertEquals(code, 200);

		}

		soft.assertAll();

	}

}
