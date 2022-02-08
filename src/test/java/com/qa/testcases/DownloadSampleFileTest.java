package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ImportCandatesPage;
import com.qa.pages.LoginPage;
import com.qa.util.Utility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.testng.annotations.AfterSuite;

public class DownloadSampleFileTest extends TestBase {
	
	ImportCandatesPage candidate;
  public DownloadSampleFileTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
  
  //Download sample file to import candidate details
@Test
  public void downloadFile() {
	
	candidate.selectImportCandidatesMenu();
	candidate.downloadSampleFile();
	boolean fileDownloadStatus = Utility.verifyFileDownloaded("sample_candidate_csv");
	Utility.softAssert.assertTrue(fileDownloadStatus);
	 System.out.println("fileDownloadStatus"+fileDownloadStatus);
	candidate.closeWindow();
	Utility.softAssert.assertAll();
  }
  @BeforeTest
  public void initialize() throws IOException {
	
	  candidate=new ImportCandatesPage();
  }


}
