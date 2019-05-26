package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider(String testcasename) {

		File src = new File(System.getProperty("user.dir") + "/TestData/"+testcasename+".xlsx");
		//File src = new File(System.getProperty(DataFileLocation));

		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("ERROR:Unable to load Excel File " + e.getMessage());

		}
	}

	public String getStringData(int sheetIndex, int row, int colum) {

		String data = wb.getSheetAt(sheetIndex).getRow(row).getCell(colum).getStringCellValue();

		return data;
	}
	
	
	public String getStringData(String sheetName, int row, int colum) {

		String data = wb.getSheet(sheetName).getRow(row).getCell(colum).getStringCellValue();

		return data;
	}
	
	public double getDoubleData(String sheetName, int row, int colum) {

		double data = wb.getSheet(sheetName).getRow(row).getCell(colum).getNumericCellValue();

		return data;
	}
	
	public int getIntData(String sheetName, int row, int colum) {

		int data = (int)wb.getSheet(sheetName).getRow(row).getCell(colum).getNumericCellValue();

		return data;
	}
	
	public int getlastrowno(String sheetname) {
		int row= wb.getSheet(sheetname).getLastRowNum();
		 row=row+1;
		 return row;
		
	}
	
}
