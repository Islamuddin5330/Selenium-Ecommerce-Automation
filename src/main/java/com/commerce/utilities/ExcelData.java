
package com.commerce.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

    public Object[][] getExcelData() throws IOException {

        String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\ExcelFile\\ExcelData.xlsx";

        List<Object[]> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook wk = new XSSFWorkbook(fis)) {

            XSSFSheet st = wk.getSheet("Sheet2");
            DataFormatter formatter = new DataFormatter();

            int rownum = st.getLastRowNum();
            int colnum = st.getRow(0).getLastCellNum();

            for (int i = 1; i <= rownum; i++) {

                XSSFRow rows = st.getRow(i);

                if (rows == null) {
                    continue;
                }

                Object[] data = new Object[colnum];
                boolean isEmpty = true;

                for (int j = 0; j < colnum; j++) {

                    XSSFCell cell = rows.getCell(j);

                    String value = cell != null
                            ? formatter.formatCellValue(cell)
                            : "";

                    data[j] = value;

                    if (!value.trim().isEmpty()) {
                        isEmpty = false;
                    }
                }

                if (!isEmpty) {
                    dataList.add(data);
                }
            }
        }

        return dataList.toArray(new Object[0][]);
    }

    // Run independently to check the output
//    public static void main(String[] args) throws IOException {
//
//        ExcelData excel = new ExcelData();
//        Object[][] data = excel.getExcelData();
//
//        for (Object[] row : data) {
//            for (Object value : row) {
//                System.out.print(value + "\t");
//            }
//            System.out.println();
//        }
//    }
}
