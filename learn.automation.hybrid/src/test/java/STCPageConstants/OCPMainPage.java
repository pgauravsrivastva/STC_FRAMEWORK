package STCPageConstants;

import static STCPageConstants.OCPMainPage.WEBSERVICENAME_TEXTBOX;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper.BasePage;

public class OCPMainPage extends BasePage {

	public static final String ALLDAY_CHECKBOX = "//input[@name='cb_all_day_event']";

	public static final String WEBSERVICENAME_TEXTBOX = "//input[@id='DataPowerReportsUIpage_FilterCriteriawebservice_name_field']";

	public static final String SEARCH_BUTTON = "//input[@name='button_search']";

	public static final String NOTIFICATIONCENTER_BUTTON = "//span[text()='Notification Center']";
	
	public static final String DATE_FORM__BUTTON = "//input[@id='DataPowerReportsUIpage_FilterCriteriatrans_date_from_field']";
	
	public static final String MONTH__BUTTON = "//div[@class='dijitCalendarMonthLabel dijitCalendarCurrentMonthLabel']";




	
	public void clickAllDay() {
		click(ALLDAY_CHECKBOX);
	}
	
	public void enterWebserviceName(String text) {
		enterText(WEBSERVICENAME_TEXTBOX, text);
	}
	
	public void clickSearch() {
		click(SEARCH_BUTTON);
	}
	
	public void clickDateForm() {
		click(DATE_FORM__BUTTON);
	}
	
	public void enterDateForm(String text) {
		enterText(DATE_FORM__BUTTON, text);
	}
	
	
	public void selectDate(String dateVal ) {
		WebElement element=driver.findElement(By.xpath(DATE_FORM__BUTTON));
		selectDate(driver, element, dateVal);
	}
	
	
	
	public void clickMonth() {
		click(MONTH__BUTTON);
	}



	
	
}
