package applicationPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{
	
	//@FindBy(id="txtUsername") WebElement username;
	@FindBy(how = How.ID, using = "txtUsername") WebElement username;
	
	@FindBy(name="txtPassword") WebElement password;

	@FindBy(xpath="//input[@name='Submit']") WebElement loginButton;

	
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public void loginToCRMApplication()
	{
		username.sendKeys("Admin");
		password.sendKeys("admin");
		loginButton.click();
		
	}
	
	
	
	
	
	
}
