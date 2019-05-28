package applicationPages;

import helper.BasePage;

public class PaymentDetailsPage extends BasePage {
	
	public static String reviewBooking = "//div[@class='reviewText']";
	
public void clickReviewBooking() throws Exception {
		
		try {
			syncWebElement(driver, reviewBooking, 50);
			click(reviewBooking);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			}
			
		
	}

	
	
	

}
