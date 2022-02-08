package com.qa.pages;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;
import com.qa.util.Utility;

public class ImportCandatesPage extends TestBase {

	@FindBy(id="sTest-dashboradIcon")
	WebElement dashboardIcon;
	@FindBy(xpath="//p[text()='Import Candidates']")
	WebElement menuImportCandidates;
	@FindBy(xpath="//span[text()='    Upload file']")
	WebElement uploadbtn;
	@FindBy(id="sTest-sampleFileLink")
	WebElement sampleFileLink;
	@FindBy(id="sTest-mappingColumns0")
	WebElement mapColDropDown;
	@FindBy(id="sTest-mappingColumnsValuesDD0")
	WebElement importBtn;
	@FindBy(id="sTest-donNotMergeDuplicateBtn")
	WebElement dntMergeBtn;
	@FindBy(id="sTest-startImportingBtn")
	WebElement startImportBtn;
	@FindBy(css="button[class*='close']")
		WebElement closeBtn;
	@FindBy(css="div[class*='toast']")
	WebElement popupMsg	;
	@FindBy(xpath="//span[text()=' No, Import Now! ']")
	WebElement importNow;
	
	public ImportCandatesPage() throws IOException {
		PageFactory.initElements(getDriver(), this);
		
	}
	
	//Select import candidates from dashbaord
	public void selectImportCandidatesMenu()
	{	Utility.wait.until(ExpectedConditions.elementToBeClickable(dashboardIcon));
		Utility.js.executeScript("arguments[0].click()", dashboardIcon);
		Utility.wait.until(ExpectedConditions.titleContains("Dashboard"));

		Utility.wait.until(ExpectedConditions.elementToBeClickable(menuImportCandidates));
		Utility.js.executeScript("arguments[0].click()", menuImportCandidates);

	}
	
	
	//download sample file to import candidate details
	public void downloadSampleFile()
	{
		Utility.wait.until(ExpectedConditions.elementToBeClickable(sampleFileLink)).click();

	}
	
	//Close import canndidates window
	public void closeWindow()
	{
		Utility.wait.until(ExpectedConditions.elementToBeClickable(closeBtn));
		Utility.js.executeScript("arguments[0].click()", closeBtn);

	}
	
	//Upload candidates details
	public String uploadFile() throws AWTException
	{
		Utility.wait.until(ExpectedConditions.elementToBeClickable(uploadbtn)).click();
		Utility.uploadFile(prop.getProperty("CANDIDATESHEET"));
		Utility.wait.until(ExpectedConditions.visibilityOf(popupMsg));
		return popupMsg.getText();
	}
	
	//Select mapping and import candidate details
	public String importMapping() throws InterruptedException
	{	Thread.sleep(3000);
		Utility.wait.until(ExpectedConditions.elementToBeClickable(mapColDropDown)).click();
		Utility.wait.until(ExpectedConditions.elementToBeClickable(importBtn)).click();
		Utility.wait.until(ExpectedConditions.elementToBeClickable(startImportBtn)).click();
		Utility.wait.until(ExpectedConditions.elementToBeClickable(dntMergeBtn)).click();
		Utility.wait.until(ExpectedConditions.elementToBeClickable(importNow)).click();
		Utility.wait.until(ExpectedConditions.visibilityOf(popupMsg));
		return popupMsg.getText();
	}
}
