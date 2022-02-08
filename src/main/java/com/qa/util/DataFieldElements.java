package com.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;

public class DataFieldElements extends TestBase {

	public DataFieldElements() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//Find element and Enter data to textbox
	public static void textBox(String elementID, String data, String elementName) {
		try
		{
		
			Utility.wait.until(ExpectedConditions.elementToBeClickable
					(getDriver().findElement(By.xpath("//*[@id='"+elementID+"']")))).sendKeys(data);
			System.out.println(elementName + " is enetered");
		}
		catch(Exception e)
		{System.out.println(e.getMessage());
			System.out.println(elementName + " is not enetred");

		}
		
	}

	//Select data from dropdown
	public static void dropDown(String elementID, String data, String elementName) {
		
		
	}
	//Find element and Enter data to typeDropDown
	public static void typeDropDown(String elementID, String data, String elementName) {
		try 
		{
			Actions action=new Actions(getDriver());
			Utility.wait.until(ExpectedConditions.elementToBeClickable
					(getDriver().findElement(By.xpath("//*[@id='"+elementID+"']"))));
			action.moveToElement(getDriver().findElement(By.xpath("//*[@id='"+elementID+"']"))).click().sendKeys(data);
			action.build().perform();
			action.sendKeys(Keys.DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			System.out.println(elementName + " is entered");
		}
		catch(Exception e)
		{System.out.println(e.getMessage());
			System.out.println(elementName + " is not entered");

		}
		
	}

}
