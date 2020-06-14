package DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String excelFile, String excelSheet) throws IOException{
		fis = new FileInputStream(excelFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(excelSheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public static int getCellCount(String excelFile, String excelSheet, int rownum) throws IOException{
		fis = new FileInputStream(excelFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(excelSheet);
		row = sh.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	
	public static String getCellData(String excelFile, String excelSheet, int rownum, int colnum)throws IOException{
		fis = new FileInputStream(excelFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(excelSheet);
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		}catch(Exception e) {
			data ="";
		}
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String excelFile, String excelSheet, int rownum, int colnum, String data) throws IOException{
		fis = new FileInputStream(excelFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(excelSheet);
		row = sh.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fos = new FileOutputStream(excelFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
			
	}
}
