package applicationTestCases;



import org.testng.annotations.Test;

import applicationFactory.STCBrowserFactory;
import applicationPages.STC_OCP_MainPage;
import applicationPages.STC_OCP_Loginpage;
import dataProvider.ConfigDataProvider;
import helper.BasePage;

public class STC_OCP_Test extends BasePage {
	
	
	@Test
	public void testocp() {
		ConfigDataProvider config = new ConfigDataProvider();

		STCBrowserFactory.startapplication("chrome", config.getOCPApplicationURL());
		
		
		STC_OCP_Loginpage login=new STC_OCP_Loginpage();
		
		login.enterUserId(config.getOCPUserid());
		
		login.enterPassword(config.getOCPPassword());
		
		login.clickLogin();
		
		STC_OCP_MainPage landingpage=new STC_OCP_MainPage();
		
		landingpage.clickAllDay();
		landingpage.enterWebserviceName("Get User Details");
		
		landingpage.clickSearch();
		
		scrolldown();
		
		capturescreenshot();
		
	
	}

}
