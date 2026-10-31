
package com.commerce.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataModify {

    private Workbook wk;
    private Sheet st;
    private String filePath;

    public Object[][] getExcelData(String sheetName)
            throws IOException {

        filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelFile\\ExcelData.xlsx";
        FileInputStream fis = new FileInputStream(filePath);

        wk = new XSSFWorkbook(fis);
//        fis.close();
        st = wk.getSheet(sheetName);

        if (st == null) {
            throw new RuntimeException("Sheet not found: " + sheetName);
        }

        return getExcelData2();
    }

    public Object[][] getExcelData2() {

        int rows = st.getLastRowNum();
        int cols = st.getRow(0).getLastCellNum();

        if (rows <= 0) {
            throw new RuntimeException("No data found in Excel sheet");
        }

        DataFormatter formatter = new DataFormatter();
        List<Object[]> excelData = new ArrayList<>();

        for (int i = 1; i <= rows; i++) {
            Row row = st.getRow(i);
            if (row == null) {
                continue;
            }

            String username = formatter.formatCellValue(row.getCell(0)).trim();
            String password = formatter.formatCellValue(row.getCell(1)).trim();
            String productName = formatter.formatCellValue(row.getCell(2)).trim();

            if (username.isEmpty() || productName.isEmpty()) {
                continue;
            }

            // Read multiple products separated by commas
            String[] productNames = java.util.Arrays.stream(
                    productName.split(","))
                    .map(String::trim)
                    .filter(product -> !product.isEmpty())
                    .toArray(String[]::new);

            Object[] data = new Object[4];

            data[0] = username;
            data[1] = password;
            data[2] = productNames;

            // Store zero-based Excel row index
            data[3] = i;
            excelData.add(data);
        }

        return excelData.toArray(new Object[0][]);
    }

    // WRITE RESULT for Status colum
    public void setStatus(int row, int col, String value) throws IOException {
        Row rows = st.getRow(row);
        if (rows == null) {
            rows = st.createRow(row);
        }

        Cell cell = rows.getCell(col);

        if (cell == null) {
            cell = rows.createCell(col);
        }
        cell.setCellValue(value);

        
        CellStyle style = wk.createCellStyle();
        Font font = wk.createFont();

        font.setBold(true);

        if (value.equalsIgnoreCase("PASS")) {
            style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            font.setColor(IndexedColors.WHITE.getIndex());
        } else {
            style.setFillForegroundColor(IndexedColors.RED.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            font.setColor(IndexedColors.WHITE.getIndex());
        }

        style.setFont(font);
        cell.setCellStyle(style);

        FileOutputStream fos = new FileOutputStream(filePath);

        wk.write(fos);
        fos.close();
    }

    // WRITE for REMARK column
    public void setRemark(int row, int col, String remark)throws IOException {
        Row rows = st.getRow(row);
        if (rows == null) {
            rows = st.createRow(row);
        }
        Cell cell = rows.getCell(col);

        if (cell == null) {
            cell = rows.createCell(col);
        }

        cell.setCellValue(remark);

        FileOutputStream fos = new FileOutputStream(filePath);
        wk.write(fos);
        fos.close();
    }

    public void closeWorkbook() throws IOException {
        if (wk != null) {
            wk.close();
            wk = null;
            st = null;
        }
    }
}
