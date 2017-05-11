package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelReader {
	
	XSSFWorkbook wb;
	public ExcelReader() throws IOException
	{
		File src = new File("./DataProvider/projectdata1.xlsx");
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		
	}
	
	public String getData(String sheetName, int rowNum, int columnNum)
	{
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(columnNum).getStringCellValue();
		return data;
	}
	public String getData(int sheetIndex, int rowNum, int columnNum)
	{
		String data = wb.getSheetAt(sheetIndex).getRow(rowNum).getCell(columnNum).getStringCellValue();
		return data;
	}		
	
}
