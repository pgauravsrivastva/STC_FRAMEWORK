package applicationPages;

import helper.BasePage;

public class AddonsPage extends BasePage {

	//public static String continueButton = "//span[@class='button-continue-text']";
	public static String continueButton = "//div[@id='continue-to-payment-page']";
	

	
public void scrolldownandclickContinue() throws Exception {
		
		try {
			syncWebElement(driver, continueButton, 120);
			scrolldown();
			
			click(continueButton);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage().contains("element click intercepted:")) {
				System.out.println(e.getMessage());
				click(continueButton);
			}
			
		
	}
		

	}
	
	
}
