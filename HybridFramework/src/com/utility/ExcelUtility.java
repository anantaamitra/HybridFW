package com.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static  XSSFWorkbook wb;
	private static  XSSFSheet gmailLogin;
	private static   XSSFCell Cell;
	 
	public static void readExcel(String Path,String SheetName) throws IOException {
	
	FileInputStream fs=new FileInputStream(Path);
	wb=new XSSFWorkbook(fs);
 	gmailLogin =wb.getSheet(SheetName);
	}
	
	public static int rowCount() {
		 int rowNo=gmailLogin.getLastRowNum();
		 return rowNo;
	}

	 public static String getCellData(int RowNum, int ColNum) throws Exception{
   	  Cell = gmailLogin.getRow(RowNum).getCell(ColNum);
         String CellData = Cell.getStringCellValue();
         return CellData;
   	}
	
	
	
	
}
