package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.TestBase;
import com.qa.pages.CompanyPage;
import com.qa.pages.JobDetailsPage;
import com.qa.pages.LoginPage;
import com.qa.util.ListenersCheck;
import com.qa.util.Utility;

public class getJobIDTest extends TestBase{
	JobDetailsPage job;
	
	
	getJobIDTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//Get job ID for the job name entered by user
@Test@Parameters({ "jobName"})
  public void getJobId(String jobName) throws InterruptedException {
	job.goToJobsMenu();
	String jobId=job.getJobDetails(jobName);
	ListenersCheck.test.log(Status.INFO, "JOB ID IS  "+ jobId);
	
  }

@BeforeTest
public void initialize() throws IOException {
	
	job=new JobDetailsPage();
	
	
	
}
@BeforeSuite
public void setup() {
	  getdriver();
	  getURL();
	 	  
}
}
