package applicationTestCases;



import java.util.logging.Level;

import org.testng.annotations.Test;

import STCDataProvider.ConfigDataProvider;
import STCPages.OCPLoginPage;
import STCPages.OCPMainPage;
import STCUtil.BasePage;
import helper.Logger;

public class STC_OCP_Test extends BasePage {
	
	
	@Test
	public void testocp() {
		
		Logger.LOG(Level.INFO, "******* TFS Testcase ID # *******");
		Logger.LOG(Level.INFO, "******* Starting Testcase " + tresult.getMethod().getMethodName() + " *******");
		Logger.TestStepStart("Login to OCP");
		
		
		
		ConfigDataProvider config = new ConfigDataProvider();
		
		OCPLoginPage login=new OCPLoginPage();
		
		login.enterUser(config.getOCPUserid());
		
		login.enterPassword(config.getOCPPassword());
		
		login.clickLogin();
		
		OCPMainPage landingpage=new OCPMainPage();
		
		landingpage.clickAllDay();
		landingpage.enterWebserviceName("Get User Details");
		
		landingpage.clickSearch();
		
		scrolldown();
		
		capturescreenshot();
		
	
	}

}
