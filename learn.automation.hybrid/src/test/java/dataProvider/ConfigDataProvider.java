package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		File src = new File(System.getProperty("user.dir") + "/Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);
		} catch (Exception e) {

			System.out.println("ERROR: Failed to load config file " + e.getMessage());
		}

	}

	public String getTestApplicationURL() {

		String data = pro.getProperty("testURL");

		return data;
	}

	public String getProdApplicationURL() {

		String data = pro.getProperty("prodURL");

		return data;
	}

	public String getUATApplicationURL() {

		String data = pro.getProperty("uatURL");

		return data;
	}

	public String getValue(String key) {

		String data = pro.getProperty(key);

		return data;
	}

}
