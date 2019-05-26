package applicationTestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import applicationFactory.STCBrowserFactory;
import applicationPages.AddonsPage;
import applicationPages.SpicejetLoginLandingPage;
import applicationPages.TravellerDetailsPage;
import applicationPages.chooseAFlightPage;
import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import helper.BasePage;

public class TestSpicejet extends BasePage {

	@Test
	public void SmokeSpicejet() throws Exception {

		ConfigDataProvider config = new ConfigDataProvider();

		STCBrowserFactory.startapplication("chrome", config.getTestApplicationURL());

		Thread.sleep(6000);

		SpicejetLoginLandingPage landing = new SpicejetLoginLandingPage();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		landing.ClickRoundtrip();
		landing.Clickdeparture();

		landing.ClickMumbai();
		landing.ClicktoCity();

		landing.bengloretoCity("ben");
		landing.clickdate();
		landing.clickSearch();

		chooseAFlightPage choose = new chooseAFlightPage();

		choose.clickContinue();

		TravellerDetailsPage travel = new TravellerDetailsPage();
		ExcelDataProvider excel = new ExcelDataProvider("TestSpicejet");
		travel.enterFirstName(excel.getStringData("BookingDetailss", 0, 1));

		travel.enterlasttName(excel.getStringData("BookingDetailss", 1, 1));

		travel.entermobilenumber(excel.getStringData("BookingDetailss", 2, 1));

		travel.enteremailaddress(excel.getStringData("BookingDetailss", 3, 1));
		travel.selecttownorcity();

		travel.clickiamflying();

		travel.clickContinue();

		AddonsPage addon = new AddonsPage();
		addon.scrolldownandclickContinue();

	}
	
	/*public Object[][]enterdata(){
		
		ExcelDataProvider excel=new ExcelDataProvider("TestSpicejet");
		int lastrow=excel.getlastrowno("BookingDetailss");
		for (int i = 0; i < lastrow; i++) {
			
			Object[][] data=new Object[lastrow][1];
			data[i][0]=excel.getStringData("BookingDetailss", i, 1);
			
			
		}
		return null;*/
		
		
		
	}
	
	


