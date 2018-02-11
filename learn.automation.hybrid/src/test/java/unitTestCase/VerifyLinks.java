package unitTestCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import applicationFactory.BrowserFactory;
import applicationFactory.DataProviderFactory;
import helper.BaseClass;
import helper.Utility;

public class VerifyLinks 
{

	@Test(enabled=false)
	public void testlinks()
	{
		
		Utility.verifyBrokenLink("http://www.apache.org/licenses/#grants");
		
	}
	
	@Test(enabled=false)
	public void testlinks1()
	{
		
	WebDriver driver=BrowserFactory.startApplication("Chrome","http://hc.apache.org/httpclient-3.x/");
		
	Utility.verifyMultipleBrokenLink(driver, "//div[@id='navcolumn']//a");
	
	}
	
	
	@Test
	public void testImages1()
	{
		
	WebDriver driver=BrowserFactory.startApplication("Chrome","http://demoqa.com/");
		
	Utility.verifyMultipleBrokenImages(driver, "//img");
	
	}
	
}
