package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;
import com.qa.util.Utility;

public class ProfilePage extends TestBase{
	
	@FindBy(id="sTest-dpLinkInAppBtn")
	WebElement dpBtn	;
	@FindBy(id="sTest-signOutInAppBtn")
	WebElement signOutBtn	;
	@FindBy(id="sTest-profileInAppBtn")
	WebElement profileBtn;
	@FindBy(id="sTest-helpVideosSwtich")
	WebElement helpVideoSwitch;
	@FindBy(css="div[class*='toast']")
	WebElement popupMsg	;
	public ProfilePage() throws IOException {
		PageFactory.initElements(getDriver(), this);
	}
	//Goto profile & toggle help videos option
	public String toggleHelpVideos()
	{		

		Utility.wait.until(ExpectedConditions.elementToBeClickable(dpBtn)).click();
		
		Utility.wait.until(ExpectedConditions.elementToBeClickable(profileBtn)).click();
		Utility.wait.until(ExpectedConditions.urlContains("profile"));

		Utility.wait.until(ExpectedConditions.visibilityOf(helpVideoSwitch)).click();
		Utility.wait.until(ExpectedConditions.visibilityOf(popupMsg));

		String toggleStatus=popupMsg.getText();

				return toggleStatus;
	}
	
	//Signout from application
	public String signOutFromApp()
	{
		Utility.wait.until(ExpectedConditions.elementToBeClickable(dpBtn)).click();
		
		Utility.wait.until(ExpectedConditions.elementToBeClickable(signOutBtn)).click();
		
		Utility.wait.until(ExpectedConditions.visibilityOf(popupMsg));
		
		String signoutStatus=popupMsg.getText();

				return signoutStatus;
	}
	
}
