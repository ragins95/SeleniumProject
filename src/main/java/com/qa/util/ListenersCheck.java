package com.qa.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenersCheck implements ITestListener{
	String reportTitle;
	public static ExtentTest test;
	public static String suiteName;
	
	public void onStart(ITestContext context)
	{
		System.out.println("***Test Suit "+context.getName() + " started ***");
		reportTitle=context.getCurrentXmlTest().getParameter("TCName");
		suiteName=context.getCurrentXmlTest().getSuite().getName();
		System.out.println("reportTitle"+reportTitle);
		System.out.println("suiteName"+suiteName);
		test=ExtentTestManager.startTest(reportTitle);
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("***Test Suit "+context.getName() + " ending ***");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}
	
	 public void onTestStart(ITestResult result)					
	{		
	    System.out.println("*** Running test method "+ result.getMethod().getMethodName()+"...");					
	}
	 
	 public void onTestSuccess(ITestResult result)					
	{		
		System.out.println("*** Executed "+ result.getMethod().getMethodName()+" test successfully...");	
		ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test case PASSED", ExtentColor.GREEN));
	}
	 
	 public void onTestFailure(ITestResult result)					
	{		
	    System.out.println("*** Test Execution"+ result.getMethod().getMethodName()+"failed..");	
		ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues", ExtentColor.RED));
		ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable().toString());
		
	}
	 
	 public void onTestSkipped(ITestResult result)	
	 {
		  System.out.println("*** Test "+ result.getMethod().getMethodName()+"skipped..");	
			ExtentTestManager.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test case SKIPPED ", ExtentColor.ORANGE));
			ExtentTestManager.getTest().log(Status.SKIP, result.getThrowable().getMessage());
			
	 }
}
