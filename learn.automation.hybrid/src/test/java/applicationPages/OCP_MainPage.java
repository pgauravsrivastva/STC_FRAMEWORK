package applicationPages;

import helper.BasePage;

public class OCP_MainPage extends BasePage {
	
	public static String allDay = "//input[@name='cb_all_day_event']";
	public static String webserviceName = "//input[@id='DataPowerReportsUIpage_FilterCriteriawebservice_name_field']";
	public static String searchButton = "//input[@name='button_search']";
	public static String notificationCenterTab = "//span[text()='Notification Center']";
	
	
	

	
	
	
	
	
	public void clickAllDay() {

		syncWebElement(driver, allDay, 20);
		click(allDay);
	}
	
	public void enterWebserviceName(String text) {

		syncWebElement(driver, webserviceName, 20);
		enterText(webserviceName, text);
	}
	public void clickSearch() {

		syncWebElement(driver, searchButton, 20);
		click(searchButton);
	}
	
	public void clickWebserviceName() {

		syncWebElement(driver, webserviceName, 20);
		click(webserviceName);
	}
	

}
