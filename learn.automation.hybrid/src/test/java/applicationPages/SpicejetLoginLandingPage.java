package applicationPages;

import helper.BasePage;

public class SpicejetLoginLandingPage extends BasePage {

	public static String roundtrip = "//input[@id='ctl00_mainContent_rbtnl_Trip_1']";
	public static String departureCity = "//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']";
	public static String toCity = "//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']";
	public static String mumbai = "//a[@value='BOM']";
	public static String banglore = "//a[@value='BLR']";
	public static String departdateclander = "//span[@id='view_fulldate_id_1']/..";
	public static String search = "//input[@name='ctl00$mainContent$btn_FindFlights']";
	public static String clickdate = "//a[@class='ui-state-default']";
	public static String totalAmount = "//span[@class='total-price margin-left-30']";
	public static String continueButton = "//span[@class='button-continue-text']";

	public void ClickRoundtrip() {

		syncWebElement(driver, roundtrip, 20);
		click(roundtrip);
	}

	public void Clickdeparture() {

		syncWebElement(driver, departureCity, 20);
		click(departureCity);
	}

	public void ClicktoCity() {

		syncWebElement(driver, toCity, 20);
		click(toCity);
	}

	public void bengloretoCity(String text) {

		syncWebElement(driver, toCity, 20);
		enterText(toCity, text);
	}

	public void ClickMumbai() {

		syncWebElement(driver, mumbai, 20);
		click(mumbai);
	}

	public void ClickBanglore() {

		syncWebElement(driver, banglore, 20);
		click(banglore);
	}

	public void clickDepartDateCalender() {

		syncWebElement(driver, departdateclander, 20);
		click(departdateclander);
	}

	public void clickSearch() {

		syncWebElement(driver, search, 20);
		click(search);
	}

	public void clickdate() {

		syncWebElement(driver, clickdate, 20);
		click(clickdate);
	}

	public void getTotalAmount() {

		syncWebElement(driver, totalAmount, 90);
		System.out.println(getText(totalAmount));

	}

	public void clickContinue() {
		syncWebElement(driver, continueButton, 90);
		click(continueButton);

	}

}
