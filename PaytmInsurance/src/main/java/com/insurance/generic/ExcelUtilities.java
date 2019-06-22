package com.insurance.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

public class ExcelUtilities 
{
	String filepath;
	
	public ExcelUtilities(String filepath)
	{
		this.filepath=filepath;
	}
	
	public String readData(String sheetName,int row,int cell)
	{
		String value=null;
		Workbook wb=null;
		
		try 
		{
			FileInputStream fis=new FileInputStream(new File(filepath));
			
			if(filepath.contains(".xlsx"))
			{
				wb=XSSFWorkbookFactory.create(fis);
			}
			
			else if(filepath.contains(".xls"))
			{
				wb=HSSFWorkbookFactory.create(fis);
			}
			
			Cell cl=wb.getSheet(sheetName).getRow(row).getCell(cell);
			
			switch(cl.getCellType())
			{
				case STRING:
					value=cl.getStringCellValue();
					break;
				
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cl))
					{
						SimpleDateFormat sdf=new SimpleDateFormat("MMM dd,yyyy");
						value=sdf.format(cl.getDateCellValue());
					} 
					else 
					{
						int numValue=(int)cl.getNumericCellValue();
						value=Integer.toString(numValue);
					}
					break;
					
				case BOOLEAN:
					 value=Boolean.toString(cl.getBooleanCellValue());
					break;
					
				default:
					System.out.println("cell format is not matching");
					break;
			}
		} 
		
		catch (EncryptedDocumentException e) 
		{
			System.out.println(e.getClass().getSimpleName());
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}

}
