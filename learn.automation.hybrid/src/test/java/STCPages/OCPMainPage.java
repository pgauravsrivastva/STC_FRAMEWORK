package STCPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import STCUtil.BasePage;

import static STCPageConstants.OCPMainPageConstants.*;

public class OCPMainPage extends BasePage {

	@FindBy(xpath = ALLDAY_CHECKBOX)
	WebElement cbx_AllDay;

	@FindBy(xpath = WEBSERVICENAME_TEXTBOX)
	WebElement txt_WebserviceName;

	@FindBy(xpath = SEARCH_BUTTON)
	WebElement btn_Search;

	@FindBy(xpath = NOTIFICATIONCENTER_BUTTON)
	WebElement btn_NotificationCenter;

	public void clickAllDay() {
		click(cbx_AllDay);
	}

	public void enterWebserviceName(String text) {
		enterText(txt_WebserviceName, text);
	}

	public void clickSearch() {
		click(btn_Search);
	}

	public void clickWebserviceName() {
		click(txt_WebserviceName);
	}

}
