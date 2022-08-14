package com.mystore.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtility {
	
	public FileInputStream fis ;
	public  FileOutputStream fos;
	public  Workbook wb;
	public  Sheet sh ;
	public  Row row ;
	public  Cell cell ;
	public CellStyle style ;
	String path ;
	
	public XLUtility(String path)
	{
		this.path=path;
	}
	
	public  int getRowCount(String sheetName) throws  Exception
	{
		fis=new FileInputStream(path);
	    wb = WorkbookFactory.create(fis);
	    sh =wb.getSheet(sheetName);
	    int rowcount =sh.getLastRowNum();
	    wb.close();
	    fis.close();
	    return rowcount;
	    
    }
	
	public  int getCellCount(String sheetName , int rownum) throws Exception 
	{
		fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellcount;
		
	}
	
	public  String getCellData(String sheetName , int rownum , int colnum) throws Exception 
	{
		fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rownum);
		cell = row.getCell(colnum);

		DataFormatter df = new DataFormatter();

		String data = df.formatCellValue(cell);

		wb.close();
		fis.close();
		return data;
		 
	}
	
	public void setCellData(String sheetName , int rownum , int colnum , String data) throws Exception 
	{
		
		
			 fis = new FileInputStream("usertable.xlsx");
		      wb = WorkbookFactory.create(fis);
		
		if(wb.getSheet("Sheet1")==null)  // If sheet not exists then create new sheet
			wb.createSheet(sheetName);
		   sh=wb.getSheet(sheetName);
		
		if(sh.getRow(rownum)==null) // If row not exists then create new Row
			sh.createRow(rownum);
		   row = sh.getRow(rownum);
		    
		    cell = row.createCell(colnum);
		    cell.setCellValue(data);
		    fos = new FileOutputStream("usertable.xlsx");
		    wb.write(fos);
		    fis.close();
		    fos.close(); 
	}
	
	
	
	
	

}
