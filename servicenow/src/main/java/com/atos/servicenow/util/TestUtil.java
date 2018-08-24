package com.atos.servicenow.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atos.servicenow.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "/Users/naveenkhunteta/Documents/workspace"
			+ "/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCrmTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	// dgsdgfghfdhfdh
	public void readCallData(String filePath, String fileName, String sheetName) throws IOException {
		// Create an object of File class to open xlsx file
		File file = new File(filePath + "\\" + fileName);
		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;
		// Find the file extension by splitting file name in substring and getting only
		// extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		// Check condition if the file is xlsx file
		if (fileExtensionName.equals(".xlsx")) {
			// If it is .xlsx file then create object of XSSFWorkbook class
			workbook = new XSSFWorkbook(inputStream);
		}
		// Check condition if the file is xls file
		else if (fileExtensionName.equals(".xls")) {
			// If it is xls file then create object of XSSFWorkbook class
			workbook = new HSSFWorkbook(inputStream);
		}

		// Read sheet inside the workbook by its name
		Sheet sheet = workbook.getSheet(sheetName);
		// Find number of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		// Create a loop over all the rows of excel file to read it
		for (int i = 0; i < rowCount + 1; i++) {
			Row row = sheet.getRow(i);
			// Create a loop to print cell values in a row
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// Print Excel data in console
				System.out.print(row.getCell(j).getStringCellValue() + "|| ");
			}
			System.out.println();
		}
	}

	/*
	 * public static String takeScreenshotAtEndOfTest(WebDriver driver, String name)
	 * throws IOException { File scrFile = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE); String currentDir =
	 * System.getProperty("user.dir"); String dateName = new
	 * SimpleDateFormat("yyyyMMddhhmms").format(new Date()); String destination =
	 * currentDir + "/screenshots/" + name + dateName + ".png"; File destFile = new
	 * File(destination); FileUtils.copyFile(scrFile, destFile); return destination;
	 * 
	 * }
	 */

}
