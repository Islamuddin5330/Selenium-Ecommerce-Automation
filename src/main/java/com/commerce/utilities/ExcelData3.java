
package com.commerce.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelData3 {
	
	//@DataProvider(parallel=true)	=> Different Excel data sets
	@DataProvider(name = "excelData", parallel = true)
	public static Object[][] getExcelData() throws IOException {

		String filePath = Paths
				.get(System.getProperty("user.dir"), "src", "test", "resources", "ExcelFile", "ExcelData.xlsx")
				.toString();

		List<Object[]> testData = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet("Sheet2");

			if (sheet == null || sheet.getRow(0) == null) {
				throw new IllegalArgumentException("Sheet2 or header row not found");
			}

			DataFormatter formatter = new DataFormatter();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);

				if (row == null) {
					continue;
				}

				String username = formatter.formatCellValue(row.getCell(0)).trim();

				String password = formatter.formatCellValue(row.getCell(1)).trim();

				String productCell = formatter.formatCellValue(row.getCell(2)).trim();

				if (username.isEmpty() || productCell.isEmpty()) {
					continue;
				}

				// Split comma-separated product names
				String[] productNames = productCell.split(",");

				List<String> products = new ArrayList<>();

				for (String product : productNames) {
					if (product != null && !product.trim().isEmpty()) {
						products.add(product.trim());
					}
				}

				if (products.isEmpty()) {
					continue;
				}

				String[] selectedProducts = products.toArray(new String[0]);

				testData.add(new Object[] { username, password, selectedProducts, i });

				System.out.println("Excel row " + (i + 1) + " products: " + products);
			}
		}

		if (testData.isEmpty()) {
			throw new IllegalArgumentException("No valid test data found in Sheet2");
		}

		return testData.toArray(new Object[0][]);
	}

	//Synchronize Excel result writing
	public static synchronized void updateResult(int rowIndex, String status, String remark) throws IOException {

		String filePath = Paths
				.get(System.getProperty("user.dir"), "src", "test", "resources", "ExcelFile", "ExcelData.xlsx")
				.toString();

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet("Sheet2");
			Row header = sheet.getRow(0);

			int statusColumn = -1;
			int remarkColumn = -1;

			// Find the result columns by header name
			for (int j = 0; j < header.getLastCellNum(); j++) {
				Cell cell = header.getCell(j);

				DataFormatter formatter = new DataFormatter();

				String heading = cell == null
				        ? ""
				        : formatter.formatCellValue(cell).trim();

				if (heading.equalsIgnoreCase("Pass/Fail")) {
					statusColumn = j;
				} else if (heading.equalsIgnoreCase("Remark")) {
					remarkColumn = j;
				}
			}

			// Create the columns if they don't already exist
			if (statusColumn == -1) {
				statusColumn = header.getLastCellNum();
				if (statusColumn < 0)
					statusColumn = 0;
				header.createCell(statusColumn).setCellValue("Pass/Fail");
			}

			if (remarkColumn == -1) {
				remarkColumn = header.getLastCellNum();
				if (remarkColumn < 0)
					remarkColumn = 0;
				header.createCell(remarkColumn).setCellValue("Remark");
			}

			Row resultRow = sheet.getRow(rowIndex);

			if (resultRow == null) {
				resultRow = sheet.createRow(rowIndex);
			}

			resultRow.createCell(statusColumn).setCellValue(status);
			resultRow.createCell(remarkColumn).setCellValue(remark);

			try (FileOutputStream fos = new FileOutputStream(filePath)) {
				workbook.write(fos);
			}
		}
	}

}
