package applicationFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public static WebDriver startApplication(String browser, String url) {

		System.out.println("INFO: Setting up the browser");
		
		WebDriver driver = null;
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		if (browser.equalsIgnoreCase("Chrome")) 
		{
		
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver(cap);
		} 
		else if (browser.equalsIgnoreCase("Firefox")) 
		{
		
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver(cap);

		} else if (browser.equalsIgnoreCase("IE")) 
		{
			cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver(cap);	
		} else 
		{
			System.out.println("ERROR: Sorry This framework only support Chrome, FF, IE Browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("INFO: Browser and Application is set");

		return driver;
	}

}
