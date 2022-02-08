
package com.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;

public class Utility extends TestBase {

	public static WebDriverWait wait=new WebDriverWait(getDriver(),100);
	public static SoftAssert softAssert=new SoftAssert();
	private static FileInputStream inputStream;
	public static String FilePath=prop.getProperty("EXCELSHEET");
	public static HSSFSheet sheet;
	public static HSSFWorkbook workbook;
	private static int rowCount;
	public static String field,fieldType,identifier,data;
	private static HSSFRow row;
	public static JavascriptExecutor js = (JavascriptExecutor)getDriver();
	public Utility() throws IOException {
		super();
	}

	//Verify if file is downloaded
	public static boolean verifyFileDownloaded( String fileName) {
		boolean flag = false;
	    File dir = new File(System.getProperty("user.home")+"\\Downloads");
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().contains(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	//Read data from excel 
	public static void readExcel(String fileName,String sheetName)
	{
		try 
		{
			inputStream= new FileInputStream(FilePath+"\\"+fileName);
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			workbook=new HSSFWorkbook(inputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		rowCount=sheet.getLastRowNum();
		
		for(int i=1;i<rowCount+1;i++)
		{
			row=sheet.getRow(i);
			field=row.getCell(0).getStringCellValue();
			fieldType=row.getCell(1).getStringCellValue();
			identifier=row.getCell(2).getStringCellValue();
			data=row.getCell(3).getStringCellValue();
			
		
		switch(fieldType)
		{
		case "TextBox": DataFieldElements.textBox(identifier,data,field); break;
		case "DropDown": DataFieldElements.dropDown(identifier,data,field); break;
		case "TypeDropDown": DataFieldElements.typeDropDown(identifier,data,field); break;
		}
		}
	}
	
	//Upload a file
	public static void uploadFile(String filepath) throws AWTException
	{
		
	     StringSelection stringselection = new StringSelection(filepath);
	     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, stringselection);

	    
	     Robot robot = new Robot();
	     robot.delay(250);
	    
	     robot.keyPress(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_V);
	     robot.keyRelease(KeyEvent.VK_CONTROL);
	     robot.keyPress(KeyEvent.VK_ENTER);
	     robot.delay(90);
	     robot.keyRelease(KeyEvent.VK_ENTER);

	}
	public static void displayPassMessage(String message)
	{
		Log.info(message);
	}

	public static void displayFailmessage(String message, Exception e) throws Exception {
		Log.error(message);
		throw new Exception(e.getMessage());
		
	}
	
	
}
