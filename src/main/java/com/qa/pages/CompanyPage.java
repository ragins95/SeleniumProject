package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;
import com.qa.util.Utility;

public class CompanyPage   extends TestBase{
	@FindBy(id="sTest-companiesIcon")
	WebElement companyIcon;
	@FindBy(id="sTest-addCompanyBtn")
	WebElement addCompanyBtn;
	@FindBy(id="sTest-companyNameListSpan")
	WebElement companyList;
	@FindBy(id="sTest-companySubmitBtn")
	WebElement submitBtn;
	@FindBy(css="div[class*='toast']")
	WebElement popupMsg	;
	@FindBy(id="sTest-selectAllTxtBtn")
	WebElement selctStatus	;
	@FindBy(id="sTest-quickViewHotList")
	WebElement quickView	;
	@FindBy(id="sTest-dashboradIcon")
	WebElement dashboardIcon;
	
	
	
	public CompanyPage() throws IOException {
		PageFactory.initElements(getDriver(), this);
	}
	
	/*Open company menu*/
	public void goToCompanyMenu() throws InterruptedException
	{
		Utility.wait.until(ExpectedConditions.elementToBeClickable(dashboardIcon));
		Utility.js.executeScript("arguments[0].click()", dashboardIcon);
		Utility.wait.until(ExpectedConditions.titleContains("Dashboard"));

		Utility.wait.until(ExpectedConditions.elementToBeClickable(companyIcon));
		Utility.js.executeScript("arguments[0].click()", companyIcon);
		Thread.sleep(3000);
		Utility.wait.until(ExpectedConditions.urlContains("companies"));
		
	}
	
	//Read excel and enter company & contact details for creating new company
	public String enterCompanyAndContactDetails() throws InterruptedException
	{		
		
		Utility.wait.until(ExpectedConditions.visibilityOf(companyList));

		Utility.wait.until(ExpectedConditions.elementToBeClickable(addCompanyBtn));
		Utility.js.executeScript("arguments[0].click()", addCompanyBtn);

		Utility.readExcel("TestData1.xls", "Company");
		Utility.readExcel("TestData1.xls", "Contact");
		Utility.wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		Utility.js.executeScript("arguments[0].click()", submitBtn);

		Utility.wait.until(ExpectedConditions.visibilityOf(popupMsg));
		return popupMsg.getText();
	}

	//Select the checkbox for the corresponding company name
	public String selectCompany(String companyName)
	{
		Utility.wait.until(ExpectedConditions.visibilityOf(companyList));
		Utility.wait.until(ExpectedConditions.visibilityOf(quickView)).click();
		Utility.wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[@label='"+companyName+"']//preceding::input[1]")))).click();

		Utility.wait.until(ExpectedConditions.visibilityOf(selctStatus));
		return selctStatus.getText();
	}
}
