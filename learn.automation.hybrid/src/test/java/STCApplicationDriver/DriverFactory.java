package STCApplicationDriver;

import java.util.logging.Level;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import helper.BasePage;
import helper.Logger;

public class DriverFactory extends BasePage {

	public static void startApplication(String browser, String url) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			BasePage.maximizewindow();
			Logger.LOG(Level.INFO, "Chrome Browser is Opened and Maximized");
		}

		if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			BasePage.maximizewindow();
			Logger.LOG(Level.INFO, "IE Browser is Opened and Maximized");
		}

	}

}
