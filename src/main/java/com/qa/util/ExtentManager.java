package com.qa.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.base.TestBase;

public class ExtentManager extends TestBase{
	
	private static ExtentReports extent;

	public ExtentManager() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static ExtentReports getInstance()
	
	{	if(extent==null)
		createInstance();
		return extent;
		
	}
	
	//Create an extent report instance
	public static ExtentReports createInstance()
	{	String currentSuiteName=ListenersCheck.suiteName;
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-DD HHmm");
		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//Extended Report//"+formatter.format(date.getTime())+" "+currentSuiteName +".html" );
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(currentSuiteName);
		htmlReporter.config().setDocumentTitle(prop.getProperty("EXTENT_TITLE"));
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Environment", "Automation Testing");
		return extent;
		
	}

}
