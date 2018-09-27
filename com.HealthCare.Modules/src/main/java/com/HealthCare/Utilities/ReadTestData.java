package com.HealthCare.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadTestData {

	public static File src;
	public static FileInputStream fin;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static int rows;
	public static int cols;
	static String value = null;
	static String key = null;
	static Object[][] obj;

	@DataProvider(name="hms")
	public static Object[][] getData(Method method) {
		try {
			String sheetName = method.getName();
			src = new File("./TestData/HMS.xlsx");
			fin = new FileInputStream(src);
			wb = new XSSFWorkbook(fin);
			sh = wb.getSheet(sheetName);
			rows = sh.getLastRowNum() - sh.getFirstRowNum();
			cols = sh.getRow(0).getLastCellNum();
			System.out.println("Total No.of Rows is " + rows);
			System.out.println("Total No.of Cols is " + cols);

			obj = new Object[rows][1];
			
			Map<Object, Object> testData = null;

			for (int i = 0; i < rows; i++) {

				testData = new HashMap<Object, Object>();

				for (int j = 0; j < cols; j++) {

					key = sh.getRow(0).getCell(j).getStringCellValue();

					if (sh.getRow(i + 1).getCell(j).getCellType() == Cell.CELL_TYPE_STRING) {

						value = sh.getRow(i + 1).getCell(j).getStringCellValue().trim();
						
					} else {

						value = sh.getRow(i + 1).getCell(j).getRawValue().trim();
					}
					
					testData.put(key, value);
				}
				
				obj[i][0] = testData;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;	
	}
}
