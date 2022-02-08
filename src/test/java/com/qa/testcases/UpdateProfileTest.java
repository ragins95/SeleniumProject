package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.ProfilePage;
import com.qa.util.Utility;

public class UpdateProfileTest extends TestBase {
	
	ProfilePage profile;
	public UpdateProfileTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


//Check if user is able to update profile
	@Test
	  public void UpdateProfile() throws Exception {
		
			String signOutStatus = profile.toggleHelpVideos();
			Utility.softAssert.assertEquals(signOutStatus,"Field Updated Successfully");
			Utility.softAssert.assertAll();
	  }
	
	
	
	@BeforeTest
	public void initialize() throws IOException {
	
	  profile=new ProfilePage();
	}

	
	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void setup() {
	  getdriver();
	  getURL();
	 	  
	}

}

