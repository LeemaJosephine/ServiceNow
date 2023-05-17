package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	
	public static String[][] readExcelSheet(String excelFile) throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+excelFile+".xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		short columnCount = sheet.getRow(0).getLastCellNum();
		
		String[][] data= new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = row.getCell(j);
				//System.out.println(cell.getStringCellValue());
				data[i-1][j]=cell.getStringCellValue();
				
			}
		}
		wb.close();
		return data;
	}

}
