package STCDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;

	public ConfigDataProvider() {

		File src = new File(System.getProperty("user.dir") + "/Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			prop = new Properties();

			prop.load(fis);
		} catch (Exception e) {

			System.out.println("ERROR: Failed to load config file " + e.getMessage());
		}

	}

	public String getTestApplicationURL() {

		String data = prop.getProperty("testURL");
		System.out.println("take testurl");
		return data;
	}

	public String getOCPApplicationURL() {

		String data = prop.getProperty("OCPURL");
		return data;
	}

	public String getOCPUserid() {

		String data = prop.getProperty("OCPuserid");
		return data;
	}

	public String getOCPPassword() {

		String data = prop.getProperty("OCPPassword");
		return data;
	}

	public String getUATApplicationURL() {

		String data = prop.getProperty("uatURL");

		return data;
	}

	public String getValue(String key) {

		String data = prop.getProperty(key);

		return data;
	}

}
