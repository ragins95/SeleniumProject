package com.qa.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.util.ListenersCheck;
import com.qa.util.Utility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class LoginPageTest extends TestBase{
	LoginPage login;
	
  public LoginPageTest() throws IOException {
		super();
	}
  
  //User trying to login with incorrect password
  @Test(priority=1)
 

    public void loginWithIncorrectPwd() throws Exception {
	  	String email="test@gmail.com";
		String password="test1236";
  		String loginStatus = login.login(email,password);
  		Utility.softAssert.assertEquals(loginStatus,"Failed to Login : Please check your Email ID & Password, if you still can’t login, email us at support@recruitcrm.io");
  		Utility.softAssert.assertAll();
  		
  		
    }

  //User trying to login with invalid mail
  @Test(priority=0)
 public void loginWithInvalidEmail()
  {		String email="ragins";
  		String password=" ";
		String emailStatus = login.checkEmailValidity(email,password);
		Utility.softAssert.assertEquals(emailStatus,"The email field must be a valid email.");
		Utility.softAssert.assertAll();
  }
  
  
  //Check if user is able to login to application successfully
@Test(priority=2)
@Parameters({ "email", "password" })

  public void loginTest(String email, String password) throws Exception {
	
		String loginStatus = login.login(email,password);
		Utility.softAssert.assertEquals(loginStatus,"Login Successful");
		Utility.softAssert.assertAll();
		
		
  }


@BeforeTest
	public void initialize() throws IOException {
	
		login=new LoginPage();
	
}

@AfterMethod
	public void refreshPage()
	{
		getDriver().navigate().refresh();
	}

  @AfterSuite
  		public void afterSuite() {
  	}

}
