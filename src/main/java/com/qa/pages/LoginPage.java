package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;
import com.qa.util.Utility;

public class LoginPage  extends TestBase{

	@FindBy(name="email")
	WebElement email;
	@FindBy(name="password")
	WebElement password	;
	@FindBy(id="sTestLoginBtn")
	WebElement loginBtn	;
	@FindBy(css="div[class*='toast']")
	WebElement popupMsg	;
	@FindBy(css="p[class*='help']")
	WebElement emailValidity	;
	public LoginPage() throws IOException {
		PageFactory.initElements(getDriver(), this);
	}
	
	//Login to the application, return the pop up message after login
	public String login(String mail,String pwd)
	{
		Utility.wait.until(ExpectedConditions.elementToBeClickable(email)).clear();
		email.sendKeys(mail);
		Utility.wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
		password.sendKeys(pwd);
		Utility.wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	
		Utility.wait.until(ExpectedConditions.visibilityOf(popupMsg));
		
		String loginStatus=popupMsg.getText();
				return loginStatus;
	}
	
	
	//Check the validation for email field
	public String checkEmailValidity(String mail,String pwd)
	{
		Utility.wait.until(ExpectedConditions.elementToBeClickable(email)).clear();
		email.sendKeys(mail);
		Utility.wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
		password.sendKeys(pwd);
		
		Utility.wait.until(ExpectedConditions.visibilityOf(emailValidity));
		
		String emailStatus=emailValidity.getText();

				return emailStatus;
	}

}
