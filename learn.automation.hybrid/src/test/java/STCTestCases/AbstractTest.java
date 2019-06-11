package STCTestCases;

import STCApplicationDriver.DriverFactory;
import STCDataProvider.ConfigDataProvider;
import STCUtil.BasePage;

public class AbstractTest extends BasePage {

	ConfigDataProvider config = new ConfigDataProvider();

	public void openOCP(String browser) {
//		PageFactory.initElements(driver, DriverFactory.class);
		DriverFactory.startApplication(browser, config.getOCPApplicationURL());
	}
}
