package applicationPages;

import helper.BasePage;

public class SeatAssignmentPage extends BasePage {
	
	public static String skipAndcContinue = "//a[@id='ControlGroupUnitMapView_UnitMapViewControl_LinkButtonSubmit']";
	
	
public void clicSkipAndContinue() throws Exception {
		
		try {
			syncWebElement(driver, skipAndcContinue, 50);
			click(skipAndcContinue);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
			}
			
		
	}


}
