package applicationFactory;

import org.openqa.selenium.chrome.ChromeDriver;

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
		
		
		
	}

}
