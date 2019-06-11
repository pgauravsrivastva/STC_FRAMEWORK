package STCTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OCPTest extends AbstractTest {

	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		openOCP(browser);
	}

	@Test
	public void testocp() {

//		STC_OCP_Loginpage login=new STC_OCP_Loginpage();
//		
//		login.enterUserId(config.getOCPUserid());
//		
//		login.enterPassword(config.getOCPPassword());
//		
//		login.clickLogin();
//		
//		STC_OCP_MainPage landingpage=new STC_OCP_MainPage();
//		
//		landingpage.clickAllDay();
//		landingpage.enterWebserviceName("Get User Details");
//		
//		landingpage.clickSearch();
//		
//		scrolldown();

		capturescreenshot();

	}

	@AfterClass
	public void tearDown() {
		this.driver.quit();
	}

}
