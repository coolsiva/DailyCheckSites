package Helper;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	int rowcount;
	
	public ExcelConfig(String Excelpath)
	{
		File excel = new File(Excelpath);
		try 
		{
			FileInputStream fis = new FileInputStream(excel);
			wb = new  XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public String getExcelDate(int sheetNumber, int row , int col)
	{
		sheet = wb.getSheetAt(sheetNumber);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
	
	public int getlastRow(int sheetNumber)
	{
		rowcount = wb.getSheetAt(sheetNumber).getLastRowNum();
		return rowcount+1;
	}
	
	public int getlastCol(int sheetNumber)
	{
		int colnum = wb.getSheetAt(sheetNumber).getRow(rowcount).getLastCellNum();
		return colnum;
	}

}
