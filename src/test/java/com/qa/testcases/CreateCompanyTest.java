package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CompanyPage;
import com.qa.pages.LoginPage;
import com.qa.util.Utility;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class CreateCompanyTest  extends TestBase {
	CompanyPage company;
	
  public CreateCompanyTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
  
  //Create a new company
@Test
@Parameters({ "expectedMsg"})

  public void CreateNewCompany(String expectedMsg) throws InterruptedException {
	
	company.goToCompanyMenu();
	String companyAddStatus = company.enterCompanyAndContactDetails();
	Utility.softAssert.assertEquals(companyAddStatus,expectedMsg);
	Utility.softAssert.assertAll();
  }
@BeforeTest
public void initialize() throws IOException {
	
	company=new CompanyPage();
	
}
@BeforeSuite
public void setup() {
	  getdriver();
	  getURL();
	 	  
}

}
