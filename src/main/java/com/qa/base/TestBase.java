package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Functionality - To read properties file, open browser and load URL

public class TestBase {

	private static WebDriver driver=null;
	public static Properties prop;
	
	/*Read the properties file*/
	public TestBase() throws IOException{
		prop=new Properties();
		FileInputStream reader=new FileInputStream("C:\\Users\\Ajay-PC\\eclipse-workspace\\RecruitCRM\\src\\main\\java\\com\\qa\\config\\FilePath.properties");
		prop.load(reader);
	}
	
	
	/*Open the browser*/
	public WebDriver getdriver() 
	{
		String browserName=prop.getProperty("BROWSER");
		if(getDriver() == null && browserName.equalsIgnoreCase("chrome"))
		{	System.setProperty("webdriver.chrome.driver", prop.getProperty("FILEPATH")+"\\assets\\chromedriver.exe");
			setDriver(new ChromeDriver());
		}
		return getDriver();
	}
	
	
	/*Load URL*/
	public void getURL()
	{
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("URL"));
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public void setDriver(WebDriver driver) {
		TestBase.driver=driver;
	}

}
