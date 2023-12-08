package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.uploadFile.HomePageObject;
import pageObject.jQuery.uploadFile.PageGeneratorManage;

public class Level_11_Upload_Files extends BaseTest {
	String csharpFileName = "CSharp.png";
	String javaFileName = "Java.png";
	String pythonFileName = "Python.png";
	String rubyFileName = "Ruby.png";
	String[] multipleFileNames = { csharpFileName, javaFileName, pythonFileName, rubyFileName };

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManage.getHomePage(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, csharpFileName);

		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));

		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);

		homePage.uploadMultipleFiles(driver, multipleFileNames);
		Assert.assertTrue(homePage.isFileLoadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(rubyFileName));

		homePage.clickToStartButton();

		Assert.assertTrue(homePage.isFileLinkUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileLinkUploadedByName(rubyFileName));

		Assert.assertTrue(homePage.isFileImageUploadedByName(csharpFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(javaFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(pythonFileName));
		Assert.assertTrue(homePage.isFileImageUploadedByName(rubyFileName));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	private WebDriver driver;
}
