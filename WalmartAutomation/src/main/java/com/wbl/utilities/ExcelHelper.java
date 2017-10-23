package com.wbl.utilities;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;// sheet class in apache poi obj2
import org.apache.poi.xssf.usermodel.XSSFWorkbook;// class in apache poi obj1


public class ExcelHelper {

	static Logger log = LogManager.getLogger(ExcelHelper.class);
	
	public static Object[][] getExcelData(String fileName, String sheetName) {
		Object[][] data = null;
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(Constants.RESOURCE_PATH + "/Test-Data/"+ fileName); // here it is loading the file (filename) in workbook object XSSFWorkbook wb = null
			XSSFSheet sheet = wb.getSheet(sheetName);// then it is getting the sheet XSSFSheet
			log.info("Sheet Name:" + sheet.getSheetName());
			int rowsIndex = sheet.getLastRowNum();//return last row index-index starts from 0, once you get the sheet u will get no of rows using sheet.getLastRowNum();
			log.info("total rows:" + rowsIndex);
			data = new Object[rowsIndex][];
			
			for (int i = 1; i <= rowsIndex; i++) { // we dont want title (expected, actual, no, etc) to be iterated hence starting from index 1, i <= rowsIndex means end of index
				XSSFRow row = sheet.getRow(i);
				int cols = row.getLastCellNum();// returns no of columns- index start from 0, u will get no of rows using sheet.getLastCellNum();
				log.info("total cols:" + cols);
				Object[] colData = new Object[cols];
				for (int j = 0; j < cols; j++) {
					colData[j] = row.getCell(j).toString();
					log.info("Data" + row.getCell(j).toString());
				}
				data[i-1]=colData;
				
			}

		} catch (IOException e) {
			log.error("ExcelHelper exception:"+e);
		} finally {
			try {
				wb.close();
			} catch (IOException e) {
				log.error(e);
			}
		}

		return data;

	}

}