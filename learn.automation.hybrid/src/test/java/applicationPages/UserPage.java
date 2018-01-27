package applicationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class UserPage 
{

	WebDriver driver;
	
	public UserPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//b[text()='Admin']") WebElement admin;
	
	@FindBy(xpath="//a[text()='User Management']") WebElement userManagment;

	@FindBy(xpath="//*[@id='menu_admin_viewSystemUsers']") WebElement users;
	
	@FindBy(id="btnAdd") WebElement addButton;
	
	@FindBy(xpath=".//*[@id='systemUser_userName']") WebElement userName;

	@FindBy(xpath=".//*[@id='systemUser_employeeName_empName']") WebElement emplName;
	

	public void addUser()
	{
		
		Actions act=new Actions(driver);
		
		act.moveToElement(Utility.waitForWebElement(driver, admin, 20)).perform();
		
		act.moveToElement(Utility.waitForWebElement(driver, userManagment, 20)).perform();
		
		act.moveToElement(Utility.waitForWebElement(driver, users, 20)).click().build().perform();
		
		Utility.waitForWebElement(driver, addButton, 20).click();
		
		Utility.waitForWebElement(driver, userName, 20).sendKeys("Umera");
		
		Utility.waitForWebElement(driver, emplName, 20).sendKeys("A");
		
		
		List<WebElement> list=driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		
		
		for(WebElement element:list)
		{
			String text=element.getAttribute("innerHTML");
			
			if(text.contains("Robert"))
			{	
				element.click();
				break;
			}
			
		}
		
		
	}
	
	
	
}
