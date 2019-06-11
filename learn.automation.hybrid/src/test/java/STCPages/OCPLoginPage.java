package STCPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import STCUtil.BasePage;

import static STCPageConstants.OCPLoginPageConstants.*;

public class OCPLoginPage extends BasePage {

	@FindBy(xpath = "//input[@id='userID']")
	WebElement txt_UserId;

	@FindBy(xpath = PASSWORD_TEXTBOX)
	WebElement txt_Password;

	@FindBy(xpath = LOGIN_BUTTON)
	WebElement btn_Login;

	public void enterUser(String user) {
		enterText(txt_UserId, user);
	}

	public void enterPassword(String password) {
		enterText(txt_Password, password);
	}

	public OCPMainPage clickLogin() {
		click(btn_Login);
		return PageFactory.initElements(driver, OCPMainPage.class);
	}
}
