package applicationPages;

import helper.BasePage;

public class JourneyDetailsPage extends BasePage {
	
	public static String phonenumber = "//table[@class='rev-pax-table']/tbody/tr[2]/td[2]";
	
	public String  getPhoneNumber() {
		
		return getText(phonenumber);
		
		


}
}
