package com.commerce.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidar {
	
	@DataProvider(name = "readdata", parallel = true)
	public Object[][] readData() throws IOException {
		
		ExcelData4 data = new ExcelData4();
		return data.getExcelData("Sheet2");
	}
	
	

}
