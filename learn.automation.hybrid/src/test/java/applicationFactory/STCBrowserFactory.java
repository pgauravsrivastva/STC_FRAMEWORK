package applicationFactory;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import helper.BasePage;

public class STCBrowserFactory extends BasePage{
	
	public static void startapplication(String browser,String url) {
		System.out.println("INFO: Setting up the browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

			driver = new ChromeDriver();
			driver.get(url);
			BasePage.maximizewindow();
		}
		
		if (browser.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.get(url);
			BasePage.maximizewindow();
		}
		
		
		
	}

}
