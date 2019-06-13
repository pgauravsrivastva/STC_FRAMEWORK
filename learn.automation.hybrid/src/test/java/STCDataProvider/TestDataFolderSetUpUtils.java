package STCDataProvider;

import java.io.File;
import java.util.logging.Level;

import helper.Logger;


/*
 * Method to set the test data file for the test
 * @Author Nitya Ranjan
 * Implement Date: 12/6/2019
 * 
 */

public class TestDataFolderSetUpUtils {
	
	private static String testResourceFolder = "src/test/java";
	


	public static String setTestDataFolderName(Class<?> cl) {
		String[] tokens = cl.getCanonicalName().split("\\.");
		String testDataFolderName = testResourceFolder;
		for (int i = 0; i < (tokens.length - 1); i++) {
			if (!tokens[i].equals("test")) {
				testDataFolderName = testDataFolderName + "/" + tokens[i];
			} else {
				testDataFolderName = testDataFolderName + "/" + "testdata";
			}
		}
		testDataFolderName = "./" + testDataFolderName;
		return testDataFolderName;
	}

	public static String setTestGlobalDataFolderName(Class<?> cl) {
		String[] tokens = cl.getCanonicalName().split("\\.");
		String testDataFolderName = testResourceFolder;
		for (int i = 0; i < (tokens.length - 1); i++) {
			if (!tokens[i].equals("test")) {
				testDataFolderName = testDataFolderName + "/" + tokens[i];
			} else {
				testDataFolderName = testDataFolderName + "/" + "testdata/Global";
				break;
			}
		}
		testDataFolderName = "./" + testDataFolderName;
		return testDataFolderName;
	}


	public static String setEnrollmentDataFolderName(Class<?> cl) {
		String[] tokens = cl.getCanonicalName().split("\\.");
		String testDataFolderName = testResourceFolder;
		for (int i = 0; i < (tokens.length - 1); i++) {
			if (!tokens[i].equals("test")) {
				testDataFolderName = testDataFolderName + "/" + tokens[i];
			} else {
				testDataFolderName = testDataFolderName + "/" + "testdata/EnrollmentData";
				break;
			}
		}
		testDataFolderName = "./" + testDataFolderName;
		return testDataFolderName;
	}


	public static String setTestMasterSourceDataFolderName() {
		return "./src/test/resources/com/omers/oasys/testdata/MasterSourceData";
	}

	public static String getEnrollmentDataFileName(Class<?> cl, String fileName) {
		return setEnrollmentDataFolderName(cl) + "/" + fileName;

	}


	// Get Master Source Data File name from the omers-testing-core package
	

	public static File setXMLTestDataFile(Class<?> cl) {
		String testDataFileName = cl.getSimpleName() + ".xml";
		String testDataFolderName = setTestDataFolderName(cl);
		File testDataFolder = new File(testDataFolderName);
		File testDataFile = new File(testDataFolderName + "/" + testDataFileName);
		if (testDataFolder.exists() && testDataFolder.isDirectory())
			if (testDataFile.exists() && !testDataFile.isDirectory()) {
				return testDataFile;
			} else {
				Logger.LOG(Level.SEVERE, "Test Data File not available");
			}
		else {
			Logger.LOG(Level.SEVERE, "Test Data Folder doesn't exist");
		}
		return null;
	}

	public static File setExcelTestDataFile(Class<?> cl) {
		String testDataFileName = cl.getSimpleName() + ".xlsx";
		String testDataFolderName = setTestDataFolderName(cl);
		File testDataFolder = new File(testDataFolderName);
		File testDataFile = new File(testDataFolderName + "/" + testDataFileName);
		if (testDataFolder.exists() && testDataFolder.isDirectory()) {
			if (testDataFile.exists() && !testDataFile.isDirectory()) {
				return testDataFile;
			} else {
				Logger.LOG(Level.SEVERE, "Test Data File not available");
			}
		} else {
			Logger.LOG(Level.SEVERE, "Test Data Folder doesn't exist");
		}
		return null;
	}

	

	


	
	public static File setExcelEnrollmentDataFile(Class<?> cl, String fileName) {
		String testDataFolderName = setEnrollmentDataFolderName(cl);
		File testDataFolder = new File(testDataFolderName);
		testDataFolderName = testDataFolderName + "/" + fileName;
		File testDataFile = new File(testDataFolderName);
		if (testDataFolder.exists() && testDataFolder.isDirectory()) {
			if (testDataFile.exists() && !testDataFile.isDirectory()) {
				return testDataFile;
			} else {
				Logger.LOG(Level.SEVERE, "Enrollment Data File not available");
			}
		} else {
			Logger.LOG(Level.SEVERE, "Enrollment Data Folder doesn't exist");
		}
		return null;
	}


		

	

}
