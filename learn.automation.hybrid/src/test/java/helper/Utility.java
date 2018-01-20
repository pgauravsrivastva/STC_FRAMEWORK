package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static String getCurrentDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");

		Date date = new Date();

		String formatedDate = dateFormat.format(date);

		return formatedDate;

	}

	public static String captureScreenshot(WebDriver driver) {

		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + Utility.getCurrentDateTime()
				+ ".png";
		
		File dest=new File(screenshotPath);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		try 
		{
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("ERROR: Unable to capture Screenshot");
			System.out.println("ERROR: "+e.getMessage());
		}

		return screenshotPath;
	}

}
