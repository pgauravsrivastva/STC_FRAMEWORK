package unitTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HeadlessBrowserTest 
{

	@Test
	public void testBrowser() throws InterruptedException
	{
		
		ChromeOptions options=new ChromeOptions();
		
		options.addArguments("--headless");
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://www.google.co.in");
		
		
		System.out.println("Title Before  "+driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("Selenium webdriver");
		
		Thread.sleep(2000);
		
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		
		Thread.sleep(5000);
		
		System.out.println("Title after "+driver.getTitle());
		
	
	}
	
}
