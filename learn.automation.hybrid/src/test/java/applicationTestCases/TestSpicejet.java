package applicationTestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Stopwatch;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import applicationFactory.STCBrowserFactory;
import applicationPages.AddonsPage;
import applicationPages.JourneyDetailsPage;
import applicationPages.PaymentDetailsPage;
import applicationPages.SeatAssignmentPage;
import applicationPages.SpicejetLoginLandingPage;
import applicationPages.TravellerDetailsPage;
import applicationPages.chooseAFlightPage;
import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import helper.BasePage;

public class TestSpicejet extends BasePage {

	

	

	@Test
	public void SmokeSpicejet() throws Exception {

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

		SeatAssignmentPage seat = new SeatAssignmentPage();
		seat.clicSkipAndContinue();

		PaymentDetailsPage payment = new PaymentDetailsPage();
		payment.clickReviewBooking();

		JourneyDetailsPage journey = new JourneyDetailsPage();

		String actualPhoneNumber = journey.getPhoneNumber();

		System.out.println(actualPhoneNumber.substring(4));

		Assert.assertEquals(actualPhoneNumber.substring(4), excel.getStringData("BookingDetailss", 2, 1),
				"Phone number is not matched.");

		pageLoad.stop();
		System.out.println("Total Page Load Time: " + pageLoad.getTime(TimeUnit.SECONDS) + " Seconds");

	}
	

}
