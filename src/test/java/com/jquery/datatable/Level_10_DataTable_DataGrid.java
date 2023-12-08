package com.jquery.datatable;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;
import pageObject.jQuery.dataTable.PageGeneratorManage;

public class Level_10_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValues;
	List<String> expectedAllCountryValues;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		homePage = PageGeneratorManage.getHomePage(driver);

	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActive("10"));
		homePage.openPagingByPageNumber("20");
		Assert.assertTrue(homePage.isPageNumberActive("20"));
		homePage.openPagingByPageNumber("15");
		Assert.assertTrue(homePage.isPageNumberActive("15"));
		homePage.openPagingByPageNumber("18");
		Assert.assertTrue(homePage.isPageNumberActive("18"));
	}

	// @Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);

		homePage.enterToHeaderTextboxLabel("Females", "384187");
		homePage.enterToHeaderTextboxLabel("Country", "Afghanistan");
		homePage.enterToHeaderTextboxLabel("Males", "407124");
		homePage.enterToHeaderTextboxLabel("Total", "791312");
		homePage.sleepInSecond(2);

		homePage.enterToHeaderTextboxLabel("Females", "338282");
		homePage.enterToHeaderTextboxLabel("Country", "Argentina");
		homePage.enterToHeaderTextboxLabel("Males", "349238");
		homePage.enterToHeaderTextboxLabel("Total", "687522");
		homePage.sleepInSecond(2);

	}

	// @Test
	public void Table_03_Enter_To_Header() {
		// Đọc dữ liệu của file country.txt ra
		// Lưu vào 1 List<String> = Expected Value = expectedAllCountryValues

		// Actual Value
		actualAllCountryValues = homePage.getValueEachRowAtAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}

	@Test
	public void Table_04_Enter_To_Textbox_At_Any_Row() {
		homePage.clickLoadButton();
		homePage.sleepInSecond(3);
		//
		// homePage.enterToTextboxByColumNameAtRowNumber("Company", "2", "Michael");
		// homePage.enterToTextboxByColumNameAtRowNumber("Contact Person", "4", "Michael 97");
		// homePage.enterToTextboxByColumNameAtRowNumber("Order Placed", "3", "197");
		// homePage.selectDropdownByColumNameAtRowNumber("Country", "1", "Japan");
		// homePage.enterToTextboxByColumNameAtRowNumber("Company", "5", "lucast");
		// homePage.enterToTextboxByColumNameAtRowNumber("Contact Person", "6", "lucast 200");
		// homePage.enterToTextboxByColumNameAtRowNumber("Order Placed", "7", "200");
		// homePage.selectDropdownByColumNameAtRowNumber("Country", "8", "Hong Kong");
		// homePage.sleepInSecond(3);
		//
		// homePage.checkToCheckBoxByColumNameAtRowNumber("NPO?", "2");
		// homePage.checkToCheckBoxByColumNameAtRowNumber("NPO?", "3");
		// homePage.checkToCheckBoxByColumNameAtRowNumber("NPO?", "6");
		// homePage.unCheckToCheckBoxByColumNameAtRowNumber("NPO?", "1");
		// homePage.unCheckToCheckBoxByColumNameAtRowNumber("NPO?", "4");
		// homePage.unCheckToCheckBoxByColumNameAtRowNumber("NPO?", "5");

		homePage.clickToIconByRowNumber("1", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Insert Row Above");
		homePage.clickToIconByRowNumber("4", "Move Up");
		homePage.clickToIconByRowNumber("3", "Move Down");
		homePage.clickToIconByRowNumber("8", "Remove Current Row");
		homePage.clickToIconByRowNumber("7", "Remove Current Row");
		homePage.clickToIconByRowNumber("6", "Remove Current Row");
		homePage.clickToIconByRowNumber("5", "Remove Current Row");
		homePage.clickToIconByRowNumber("4", "Remove Current Row");
		homePage.clickToIconByRowNumber("3", "Remove Current Row");
		homePage.clickToIconByRowNumber("2", "Remove Current Row");
		homePage.clickToIconByRowNumber("1", "Remove Current Row");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
