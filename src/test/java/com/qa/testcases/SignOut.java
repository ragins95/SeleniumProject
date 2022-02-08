package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ProfilePage;
import com.qa.util.Utility;

public class SignOut  extends TestBase{
	ProfilePage profile;
  public SignOut() throws IOException {
		super();
		
	}
//Check if user is able to signout from application
@Test
  public void signout() {

	String signOutStatus = profile.signOutFromApp();
	Utility.softAssert.assertEquals(signOutStatus,"You have been logged out");
	Utility.softAssert.assertAll();
  }


@BeforeTest
public void initialize() throws IOException {
	
	  profile=new ProfilePage();
}

@BeforeMethod
public void refreshPage()
{
	getDriver().navigate().refresh();
}
@BeforeSuite
public void setup() {
	  getdriver();
	  getURL();
	 	  
}
}
