package applicationPages;

import helper.BasePage;

public class TravellerDetailsPage extends BasePage {
	
	public static String firstName = "//input[@id='CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxFirstName']";
	public static String lastName = "//input[@id='CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxLastName']";
	public static String mobileNumber = "//input[@id='CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxHomePhone']";
	public static String emailAddress = "//input[@id='CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxEmailAddress']";
	public static String townorcity = "//select[@name='contact_cities_list_india']";
	public static String iamflaying = "//input[@name='CONTROLGROUPPASSENGER$PassengerInputViewPassengerView$SJFlyingView$IamFlying']";
	public static String continueButton = "//span[@class='button-continue-text']";
	
	
	
	public void enterFirstName(String text) {

		syncWebElement(driver, firstName, 20);
		enterText(firstName, text);
	}
	
	public void enterlasttName(String text) {

		syncWebElement(driver, lastName, 20);
		enterText(lastName, text);
	}
	
	public void entermobilenumber(String text) {

		syncWebElement(driver, mobileNumber, 20);
		enterText(mobileNumber, text);
	}
	
	public void enteremailaddress(String text) {

		syncWebElement(driver, emailAddress, 20);
		enterText(emailAddress, text);
	}
	
	public void selecttownorcity() {

		syncWebElement(driver, townorcity, 20);
		selectbyindex(townorcity, 6);
	}
	
	public void clickiamflying() {

		syncWebElement(driver, iamflaying, 20);
		click(iamflaying);
	}
	public void clickContinue() {

		syncWebElement(driver, continueButton, 20);
		click(continueButton);
	}
	
	
	
	
	

}
