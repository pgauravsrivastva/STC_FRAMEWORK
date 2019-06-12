package applicationTestCases;

import java.util.logging.Level;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import STCDataProvider.ConfigDataProvider;
import STCDataProvider.ExcelUtils;
import STCPageConstants.OCPLoginPage;
import STCPageConstants.OCPMainPage;
import helper.BasePage;
import helper.Logger;

public class STC_OCP_Test extends BasePage {
	
	
	
	String env = "TST";

	@Test(dataProvider = "OCP", enabled = true)
	public void testocp(String WebServicesName) throws Exception {

		Logger.LOG(Level.INFO, "******* TFS Testcase ID *******");
		
		Logger.TestStepStart("Login to OCP");

		ConfigDataProvider config = new ConfigDataProvider();

		OCPLoginPage login = new OCPLoginPage();

		login.enterUser(config.getOCPUserid());

		login.enterPassword(config.getOCPPassword());

		login.clickLogin();

		OCPMainPage landingpage = new OCPMainPage();

		landingpage.clickAllDay();
		landingpage.enterWebserviceName(WebServicesName);

		landingpage.clickSearch();

		scrolldown();

		Thread.sleep(9000);

		capturescreenshot();
		
		Logger.TestStepCompleted("");

	}

	@DataProvider(name = "OCP")
	public Object[][] excelData() throws Exception {

		// Setting up the Test Data Excel file
		new ExcelUtils();
		Object[][] testObjArry = ExcelUtils.getTableArray(this.getClass(), env);
		return (testObjArry);

	}

}
