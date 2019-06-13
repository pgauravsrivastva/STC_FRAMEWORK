package STCDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import helper.Logger;
/*
 * Method to set the test data file for the test
 * @Author Nitya Ranjan
 * 
 */


public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static int keyColumnNumber = 0;
	private static int valueColumnNumber = 1;

	
	
	
	/* Method to get data from excel file */

	public static Object[][] getTableArray(Class<?> cl) throws Exception {

		String[][] tabArray = null;
		try {

			FileInputStream ExcelFile = new FileInputStream(TestDataFolderSetUpUtils.setExcelTestDataFile(cl));
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");

			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();

			// Getting the column count
			int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			tabArray = new String[totalRows][totalCols];
			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);
				}
			}
		} catch (FileNotFoundException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);

	}

	public static Object[][] getTableArray(String fileName) throws Exception {

		String[][] tabArray = null;
		try {

			FileInputStream ExcelFile = new FileInputStream(fileName);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");

			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();

			// Getting the column count
			int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			tabArray = new String[totalRows][totalCols];
			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);
				}
			}
		} catch (FileNotFoundException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		}
		return (tabArray);

	}

	public Object[][] readSheetByName(Class<?> cl, String sheetName) throws Exception {
		Object[][] testObjArray = getTableArray(cl, sheetName);
		return (testObjArray);
	}

	public Object[][] readSheetByName(File dataFile, String sheetName) throws Exception {
		Object[][] testObjArray = getTableArray(dataFile, sheetName);
		return (testObjArray);
	}

	public static List<String> getAllSheetNames(Class<?> cl) throws Exception {
		List<String> allSheetNames = new LinkedList<String>();

		try {
			FileInputStream ExcelFile = new FileInputStream(TestDataFolderSetUpUtils.setExcelTestDataFile(cl));
			XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				allSheetNames.add(workbook.getSheetName(i));
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		}
		return allSheetNames;

	}

	public static List<String> getAllSheetNames(File dataFile) throws Exception {
		List<String> allSheetNames = new LinkedList<String>();

		try {
			FileInputStream ExcelFile = new FileInputStream(dataFile);
			XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				allSheetNames.add(workbook.getSheetName(i));
			}
			workbook.close();
		} catch (FileNotFoundException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		}
		return allSheetNames;

	}

	/*
	 * Method to get source data from master source data excel file based on the
	 * tab name and column
	 */

		

	/*
	 * Method to get data from master source data excel file based on the tab
	 * name, column and with the start year
	 */

		private static void checkInputYear(String value) throws Exception {
		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);
		int year = Integer.valueOf(value);
		if (currentYear < year || year < 1900)
			throw new Exception("the required start year is " + year + " it is not correct. Please change ...");

	}

	/*
	 * Method to get source data from master source data excel file based on tab
	 * name, column and with specific start year and return the rows based on
	 * the number of years
	 */

		/*
	 * Method to get source data from master source data excel file, tab and
	 * column and with specific value and return the rows based on start year
	 * and end year
	 */

		/* Method to get data from specific excel file and tab */

	public static Object[][] getTableArray(File dataFile, String sheetName) throws Exception {
		String[][] tabArray = null;
		try {

			FileInputStream ExcelFile = new FileInputStream(dataFile);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);

			int startRow = 1;
			int startCol = 0;
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();

			// Getting the column count
			int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();

			tabArray = new String[totalRows][totalCols];
			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				try {
					for (int j = startCol; j < totalCols; j++, cj++) {
						tabArray[ci][cj] = getCellData(i, j);
						if (tabArray[ci][cj] == null) {
							throw new NullPointerException();
						}
					}
				} catch (NullPointerException e) {
					Logger.LOG(Level.SEVERE,
							"Could not read " + sheetName + " Excel sheet --> the cell is blank or not in text format.");
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			Logger.LOG(Level.SEVERE, "Could not read " + sheetName + " Excel sheet --> File Not found");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.LOG(Level.SEVERE, "Could not read " + sheetName + " Excel sheet --> Can't read the file");
			e.printStackTrace();
		} catch (NullPointerException e) {
			Logger.LOG(Level.SEVERE,
					"Could not read " + sheetName + " Excel sheet --> data file has either empty spreadsheet, or the cell is blank or not in text format.");
			e.printStackTrace();
		}
		return (tabArray);
	}

	public static Object[][] getTableArray(Class<?> cl, String sheetName) throws Exception {
		String[][] tabArray = null;
		try {

			FileInputStream ExcelFile = new FileInputStream(TestDataFolderSetUpUtils.setExcelTestDataFile(cl));
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);

			int startRow = 1;
			int startCol = 0;
			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();
			// Getting the column count
			int totalCols = ExcelWSheet.getRow(0).getPhysicalNumberOfCells();
			tabArray = new String[totalRows][totalCols];

			ci = 0;
			for (int i = startRow; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = startCol; j < totalCols; j++, cj++) {
					tabArray[ci][cj] = getCellData(i, j);
					if (tabArray[ci][cj] == null) {
						throw new NullPointerException();
					}
				}
			}
		} catch (FileNotFoundException e) {
			Logger.LOG(Level.SEVERE, "Could not read " + sheetName + " Excel sheet --> File Not found");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.LOG(Level.SEVERE, "Could not read " + sheetName + " Excel sheet --> Can't read the file");
			e.printStackTrace();
		} catch (NullPointerException e) {
			Logger.LOG(Level.SEVERE,
					"Could not read " + sheetName + " Excel sheet --> SpreadSheet has problem, please fix the problem frist.");
			e.printStackTrace();
		}
		return (tabArray);

	}

	@SuppressWarnings("static-access")
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			if (Cell == null || dataType == Cell.CELL_TYPE_BLANK) {
				return "";
			} else {
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
		} catch (NullPointerException e) {
			Logger.LOG(Level.SEVERE,
					"Reading the cell in " + ExcelWSheet.getSheetName() + " sheet, row number [" + RowNum
							+ "], column number [" + ColNum + "] gets exception, and the error msg is "
							+ e.getMessage());
		} catch (Exception e) {
			Logger.LOG(Level.SEVERE,
					"Reading the cell in " + ExcelWSheet.getSheetName() + " sheet, row number [" + RowNum
							+ "], column number [" + ColNum + "] gets exception, and the error msg is "
							+ e.getMessage());
		}
		return null;
	}

	public static int findRowForKeyValue(int ColNum, String key) throws Exception {

		XSSFCell keyCellValue = keyCellValue = ExcelWSheet.getRow(0).getCell(ColNum);
		int i = 0;
		int totalRows = ExcelWSheet.getLastRowNum();
		while (!keyCellValue.getStringCellValue().equals(key) && i < totalRows) {
			i++;
			keyCellValue = ExcelWSheet.getRow(i).getCell(ColNum);

		}
		return i;
	}

	public static String findValueBasedOnKey(String key) throws Exception {
		int keyValueRow = findRowForKeyValue(keyColumnNumber, key);
		XSSFCell valueCell;
		valueCell = ExcelWSheet.getRow(keyValueRow).getCell(valueColumnNumber);
		return valueCell.getStringCellValue();
	}

	public static String getGolbalDataValueBasedOnKey(String key, String env, File globalTestDataFile)
			throws Exception {
		try {

			File ExcelFile = globalTestDataFile;
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(env);
		} catch (FileNotFoundException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.LOG(Level.SEVERE, "Could not read the Excel sheet");
			e.printStackTrace();
		}
		return findValueBasedOnKey(key);
	}

	public static int getNotNullLastColumnNumber(int RowNum, XSSFSheet ExcelWSheet) throws Exception {

		try {

			int ColNum = 0;
			while (Cell != null) {
				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
				ColNum++;
			}
			return ColNum;
		} catch (Exception e) {
			Logger.LOG(Level.SEVERE, e.getMessage());
			throw (e);
		}

	}

	public Object[][] combine(Object[][] a1, Object[][] a2) {
		List<Object[]> objectCodesList = new LinkedList<Object[]>();
		int i = 0;
		for (Object[] o : a1) {
			int j = 0;
			for (Object[] o2 : a2) {
				if (i == j)
					objectCodesList.add(concatAll(o, o2));
				j++;
			}
			i++;
		}
		return objectCodesList.toArray(new Object[0][0]);
	}

	@SafeVarargs
	public static <T> T[] concatAll(T[] first, T[]... rest) {
		// calculate the total length of the final object array after the concat
		int totalLength = first.length;
		for (T[] array : rest) {
			totalLength += array.length;
		}
		// copy the first array to result array and then copy each array
		// completely to result
		T[] result = Arrays.copyOf(first, totalLength);
		int offset = first.length;
		for (T[] array : rest) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}

		return result;
	}

	public Object[][] combinedAllDatasheets(Class<?> cl) throws Exception {
		List<String> allSheetNames = getAllSheetNames(cl);
		Object[][] dataCombine = readSheetByName(cl, allSheetNames.get(0).toString());

		for (int i = 1; i < allSheetNames.size(); i++)
			dataCombine = combine(dataCombine, readSheetByName(cl, allSheetNames.get(i).toString()));
		return dataCombine;
	}

	public Object[][] combinedAllDatasheets(File dataFile) throws Exception {
		List<String> allSheetNames = getAllSheetNames(dataFile);
		Object[][] dataCombine = readSheetByName(dataFile, allSheetNames.get(0).toString());

		for (int i = 1; i < allSheetNames.size(); i++)
			dataCombine = combine(dataCombine, readSheetByName(dataFile, allSheetNames.get(i).toString()));
		return dataCombine;
	}

	public static Object[][] append(Object[][] a, Object[][] b) {
		Object[][] result = new Object[a.length + b.length][];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}

	public Object[][] getAllDataFromFiles(String filePath) throws Exception {
		File folder = new File(filePath);
		File[] listOfFiles = folder.listFiles();
		ExcelUtils excelUtils = new ExcelUtils();
		Object[][] allData = combinedAllDatasheets(listOfFiles[0]);

		try {
			for (int i = 1; i < listOfFiles.length; i++) {
				allData = excelUtils.append(allData, combinedAllDatasheets(listOfFiles[i]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't find the file." + e);
			Logger.LOG(Level.INFO, "Can't find the file and get " + e);
		} catch (IOException e) {
			System.out.println("Can't open the file and get " + e);
		} catch (Exception e) {
			Logger.LOG(Level.INFO, "can't read the all data files and get " + e);
		}
		return allData;
	}

	public static void copyFile(File sourceFile, File destFile) throws IOException {
		if (!sourceFile.exists()) {
			return;
		}
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		source = new FileInputStream(sourceFile).getChannel();
		destination = new FileOutputStream(destFile).getChannel();
		if (destination != null && source != null) {
			destination.transferFrom(source, 0, source.size());
		}
		if (source != null) {
			source.close();
		}
		if (destination != null) {
			destination.close();
		}
	}

	/* to move the null value from the Array */

	public static String[] removeNullValueFromArray(String[] array) {
		List<String> list = new ArrayList<String>();
		for (String s : array) {
			if (s != null && s.length() > 0) {
				list.add(s);
			}
		}
		return list.toArray(new String[list.size()]);
	}

}
