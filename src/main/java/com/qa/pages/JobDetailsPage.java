package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.base.TestBase;
import com.qa.util.Utility;

public class JobDetailsPage extends TestBase {
	
	@FindBy(id="sTest-dashboradIcon")
	WebElement dashboardIcon;
	@FindBy(id="sTest-jobsIcon")
	WebElement jobsIcon;
	@FindBy(css="div[class*='toast']")
	WebElement popupMsg	;
	
	@FindBy(id="sTest-quickViewHotList")
	WebElement quickView	;
	@FindBy(id="sTest-jobsBreadcumb")
	WebElement jobsList;
	@FindBy(id="sTest-addJobListBtn")
	WebElement addJobBtn;
	
	public JobDetailsPage() throws IOException {
		PageFactory.initElements(getDriver(), this);

	}

	//Open jobs menu
	public void goToJobsMenu()
	
	{	
		Utility.wait.until(ExpectedConditions.elementToBeClickable(dashboardIcon));
		Utility.js.executeScript("arguments[0].click()", dashboardIcon);
		Utility.wait.until(ExpectedConditions.titleContains("Dashboard"));
		Utility.wait.until(ExpectedConditions.elementToBeClickable(jobsIcon));
		Utility.js.executeScript("arguments[0].click()", jobsIcon);
		Utility.wait.until(ExpectedConditions.urlContains("jobs"));

	}
	
	//Select jobID for the jobname user entered
	public String getJobDetails(String jobName) throws InterruptedException {
	Utility.wait.until(ExpectedConditions.visibilityOf(jobsList));
	Utility.wait.until(ExpectedConditions.visibilityOf(addJobBtn));

	Utility.wait.until(ExpectedConditions.visibilityOf(quickView)).click();
	Thread.sleep(2000);
	
	
	Utility.wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[@label='"+jobName+"']"))));
	String jobID=Utility.wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[@label='"+jobName+"']//preceding::P[2]")))).getText();

	return jobID;
	
	}
	
}
