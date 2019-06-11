package applicationTestCases;



import java.util.logging.Level;

import org.testng.annotations.Test;

import applicationFactory.STCBrowserFactory;
import applicationPages.STC_OCP_MainPage;
import applicationPages.STC_OCP_Loginpage;
import dataProvider.ConfigDataProvider;
import helper.BasePage;
import helper.Logger;

public class STC_OCP_Test extends BasePage {
	
	
	@Test
	public void testocp() {
		
		Logger.LOG(Level.INFO, "******* TFS Testcase ID # *******");
		Logger.LOG(Level.INFO, "******* Starting Testcase " + tresult.getMethod().getMethodName() + " *******");
		Logger.TestStepStart("Login to OCP");
		
		
		
		ConfigDataProvider config = new ConfigDataProvider();
		
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
