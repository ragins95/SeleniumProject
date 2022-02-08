package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ImportCandatesPage;
import com.qa.util.Utility;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;

public class ImportCandidatesTest extends TestBase {
	ImportCandatesPage candidate;
  public ImportCandidatesTest() throws IOException {
		super();
		
	}
  
  //Import candidates details
@Test(priority=1)
  public void importCandatesInfo() throws AWTException {
	 candidate.selectImportCandidatesMenu(); 
	
	 String fileUploadStatus =  candidate.uploadFile();
	 System.out.println("fileUploadStatus"+fileUploadStatus);
		Utility.softAssert.assertEquals(fileUploadStatus,"File attached and is ready to be used");
		Utility.softAssert.assertAll();
  }

@Test(priority=2)
public void MapFields() throws InterruptedException
{
	String mappingStatus =candidate.importMapping();
	 System.out.println("mappingStatus"+mappingStatus);
		Utility.softAssert.assertEquals(mappingStatus,"Import Successful");
		Utility.softAssert.assertAll();
}
  @BeforeTest
  public void initialize() throws IOException {
		
	  candidate=new ImportCandatesPage();
	 
	  
  }
}
