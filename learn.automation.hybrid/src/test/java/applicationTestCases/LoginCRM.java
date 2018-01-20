package applicationTestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import applicationFactory.DataProviderFactory;
import applicationPages.LoginPage;
import helper.BaseClass;

public class LoginCRM extends BaseClass
{
	@Test
	public void loginAdmin()
	{
	 logger=report.startTest("LoginAdmin");	
     LoginPage login=PageFactory.initElements(driver,LoginPage.class);
     login.enterUsername(DataProviderFactory.getExcel().getStringData("Login", 0, 0));
     login.enterPassword(DataProviderFactory.getExcel().getStringData("Login",0,1));
     login.clickOnLoginButton();	
     logger.log(LogStatus.PASS,"User is able to login");    
	}

}
