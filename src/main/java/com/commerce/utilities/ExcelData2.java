package com.commerce.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Logger logger = LoggerManager.getLogger();

		// First get the file path
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelFile\\ExcelData.xlsx";
		// File class
		FileInputStream fis = new FileInputStream(filePath);

		// Workbook class
		Workbook wk = new XSSFWorkbook(fis);

		// Get the sheet
		Sheet st = wk.getSheet("Sheet2");

		// Get rows and columns
		int rows = st.getLastRowNum();
		// first target row then columns
		int cols = st.getRow(0).getLastCellNum();

		// Now apply loop to each and every row and column
		for (int i = 0; i <= rows; i++) {
			Row row = st.getRow(i);
			for (int j = 0; j < cols; j++) {
				Cell cell = row.getCell(j);
				// this iner loop while print all the cell values of each row
//				  System.out.print(cell);

				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				}

				System.out.print(" | ");
			}

			System.out.println();
		}

	}

}
