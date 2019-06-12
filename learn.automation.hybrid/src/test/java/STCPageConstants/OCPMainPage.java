package STCPageConstants;

import static STCPageConstants.OCPMainPage.WEBSERVICENAME_TEXTBOX;

import helper.BasePage;

public class OCPMainPage extends BasePage {

	public static final String ALLDAY_CHECKBOX = "//input[@name='cb_all_day_event']";

	public static final String WEBSERVICENAME_TEXTBOX = "//input[@id='DataPowerReportsUIpage_FilterCriteriawebservice_name_field']";

	public static final String SEARCH_BUTTON = "//input[@name='button_search']";

	public static final String NOTIFICATIONCENTER_BUTTON = "//span[text()='Notification Center']";


	
	public void clickAllDay() {
		click(ALLDAY_CHECKBOX);
	}
	
	public void enterWebserviceName(String text) {
		enterText(WEBSERVICENAME_TEXTBOX, text);
	}
	
	public void clickSearch() {
		click(SEARCH_BUTTON);
	}


	
	
}
