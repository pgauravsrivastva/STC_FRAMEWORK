package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import helper.Utility;

public class LoginPage 
{
	
	WebDriver driver;
	
	 public LoginPage(WebDriver ldriver) 
	 {
		this.driver=ldriver;
	 }
	
	
	
	//@FindBy(id="txtUsername") WebElement username;
	@FindBy(how = How.ID, using = "txtUsername") WebElement username;
	
	@FindBy(name="txtPassword") WebElement password;

	@FindBy(xpath="//input[@name='Submit']") WebElement loginButton;

	
	public void enterUsername(String user)
	{
		//username.sendKeys(user);
		
		Utility.waitForWebElement(driver, username, 20).sendKeys(user);
		
	}
	
	public void enterPassword(String pass)
	{
		//password.sendKeys(pass);
		Utility.waitForWebElement(driver, password, 20).sendKeys(pass);
	}
	
	
	public void clickOnLoginButton()
	{
		//loginButton.click();
		Utility.waitForWebElement(driver, loginButton, 20).click();
	}
	
	public void loginToCRMApplication()
	{
		username.sendKeys("Admin");
		password.sendKeys("admin");
		loginButton.click();
		
	}
	
	
	
	
	
	
}
