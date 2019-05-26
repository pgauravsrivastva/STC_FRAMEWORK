package applicationPages;

import org.openqa.selenium.StaleElementReferenceException;

import helper.BasePage;

public class chooseAFlightPage extends BasePage {
	
	public static String continueButton = "//span[@class='button-continue-text']";

	
	public void clickContinue() throws Exception {
		
		try {
			syncWebElement(driver, continueButton, 120);
			Thread.sleep(5000);
			click(continueButton);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			}
			
		
	}
		

	}



