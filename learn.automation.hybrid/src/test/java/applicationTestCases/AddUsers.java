package applicationTestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import applicationFactory.DataProviderFactory;
import applicationPages.LoginPage;
import applicationPages.UserPage;
import helper.BaseClass;

public class AddUsers extends BaseClass
{
	@Test
	public void userAdd()
	{
	 logger=report.startTest("This test will add user in Portal");	
	 
     LoginPage login=PageFactory.initElements(driver,LoginPage.class);
     
     UserPage user=PageFactory.initElements(driver,UserPage.class);
     
     login.enterUsername(DataProviderFactory.getExcel().getStringData("Login", 0, 0));
     
     login.enterPassword(DataProviderFactory.getExcel().getStringData("Login",0,1));
     
     login.clickOnLoginButton();	
     
     user.addUser();
     
     logger.log(LogStatus.PASS,"User is able to login");    
	}

}
