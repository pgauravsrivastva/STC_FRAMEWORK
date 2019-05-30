package applicationPages;

import helper.BasePage;

public class STC_OCP_Loginpage extends BasePage {
	
	public static String userId = "//input[@id='userID']";
	public static String password = "//input[@id='password']";
	public static String logIn = "//input[@value='Log in']";
	
	
	public void enterUserId(String text) {
		
		syncWebElement(driver, userId, 20);
		enterText(userId, text);
	}
	
public void enterPassword(String text) {
		
		syncWebElement(driver, password, 20);
		enterText(password, text);
	}

public void clickLogin() {
	
	syncWebElement(driver, logIn, 20);
	click(logIn);
}

	
	
	

}
