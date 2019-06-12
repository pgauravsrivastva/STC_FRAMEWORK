package STCPageConstants;

import static STCPageConstants.OCPLoginPage.PASSWORD_TEXTBOX;
import static STCPageConstants.OCPLoginPage.USERID_TEXTBOX;

import helper.BasePage;

public class OCPLoginPage extends BasePage {

	public static final String USERID_TEXTBOX = "//input[@id='userID']";

	public static final String PASSWORD_TEXTBOX = "//input[@id='password']";

	public static final String LOGIN_BUTTON = "//input[@value='Log in']";
	
	public void enterUser(String user) {
		enterText(USERID_TEXTBOX, user);
	}
	
	public void enterPassword(String password) {
		enterText(PASSWORD_TEXTBOX, password);
	}
	
	public void clickLogin() {
		click(LOGIN_BUTTON);
	}
	
	

	
	
}
