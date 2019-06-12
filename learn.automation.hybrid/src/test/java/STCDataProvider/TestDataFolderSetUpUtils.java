package STCDataProvider;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;

import helper.Logger;


/*
 * Method to set the test data file for the test
 * @Author Parasar Saha
 * 
 */

public class TestDataFolderSetUpUtils {
	private static String testResourceFolder = "src/test/java";
	private static String testGlobalDataFileName = "GlobalData.xlsx";
	private static String testGlobalDataFolder = "/src/test/resources/testdata/Global";
	private static String testGlobalSourceDataFileName = "SourceData.xlsx";
	private static String enrollmentDataFileName = "EnrollmentData.xlsx";
	private static String masterEnrollmentFolderInJenkin = "C:/MasterEnrollmentData";



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
	public static String setTestGlobalSourceDataFileName(Class<?> cl) throws URISyntaxException {
		System.out.println("start to get the source data file name.");
		String sourceFilePath = cl.getResource(testGlobalSourceDataFileName).toString().replace("/target/classes",
				testGlobalDataFolder);
		// String sourceFilePath =
		// "../src/test/resources/testdata/Global/SourceData.xlsx";
		System.out.println("the source data file in the path: " + sourceFilePath);
		System.out.println("the source data file name is " + sourceFilePath.replace("file:/", "").trim());
		return sourceFilePath.replace("file:/", "").trim();
	}

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

	public static File setExcelGolbalTestDataFile(Class<?> cl) {
		String testDataFolderName = setTestGlobalDataFolderName(cl);
		File testDataFolder = new File(testDataFolderName);
		testDataFolderName = testDataFolderName + "/" + testGlobalDataFileName;
		File testDataFile = new File(testDataFolderName);
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

	public File setExcelMasterSourceDataFile() {
		String testDataFolderName = setTestMasterSourceDataFolderName();
		File testDataFolder = new File(testDataFolderName);
		testDataFolderName = testDataFolderName + "/" + testGlobalSourceDataFileName;
		File testDataFile = new File(testDataFolderName);
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


	public static File setExcelEnrollmentDataFileInJenkin(Class<?> cl, String fileNameInJenkin) throws Exception {
		String enrollmentFolderInSmokeTest = setEnrollmentDataFolderName(cl);
		File sourceFolder = new File(enrollmentFolderInSmokeTest);
		File testDataFile = new File(fileNameInJenkin);
		String testDataFolderName = fileNameInJenkin.substring(0, 23);
		File testDataFolder = new File(testDataFolderName);
		if (!testDataFolder.exists()) {
			if (testDataFolder.mkdir()) {
				System.out.println("Master Enrollment Folder Directory is created!");
			} else {
				System.out.println("Failed to create Master Enrollment Folder directory!");
			}
		}
		if (testDataFile.exists() && !testDataFile.isDirectory()) {
			return testDataFile;
		} else {
			try {
				FolderUtils.copy(sourceFolder, testDataFolder);
			} catch (IOException e) {
				Logger.LOG(Level.WARNING, "Enrollment Output Data File not available");
				e.printStackTrace();
			}

		}
		return null;
	}

	public File setExcelGolbalSourceDataFile(Class<?> cl) throws Exception {
		String testDataFileName = setTestGlobalSourceDataFileName(cl);
		System.out.println("the source data file name is " + testDataFileName);
		String testDataFolderName = setTestGlobalSourceDataFileName(cl).replace("/" + testGlobalSourceDataFileName, "")
				.trim();
		System.out.println("te source data folder name is " + testDataFolderName);
		File testDataFile = new File(testDataFileName);
		File testDataFolder = new File(testDataFolderName);
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

}
