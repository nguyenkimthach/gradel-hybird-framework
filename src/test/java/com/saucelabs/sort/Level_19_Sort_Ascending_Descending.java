package com.saucelabs.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.saucelab.LoginPageOpject;
import pageObject.saucelab.PageGeneratorManage;
import pageObject.saucelab.ProductPageOpject;

public class Level_19_Sort_Ascending_Descending extends BaseTest {

	String userName = "standard_user";
	String password = "secret_sauce";

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String saucelabUrl) {
		driver = getBrowserDriver(browserName, saucelabUrl);
		loginPage = PageGeneratorManage.getLoginPage(driver);

		loginPage.enterToUserNameTextbox(userName);
		loginPage.enterToPasswordTextbox(password);
		productPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Sort_01_Name() {
		// Ascending
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(1);

		Assert.assertTrue(productPage.isProductNameSortByAscending());
		Assert.assertTrue(productPage.isProductNameSortByAscendingByLambda());

		// Descending
		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(1);

		Assert.assertTrue(productPage.isProductNameSortByDescending());
		Assert.assertTrue(productPage.isProductNameSortByDescendingByLambda());
	}

	// @Test
	public void Sort_02_Price() {
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(1);

		Assert.assertTrue(productPage.isProductPriceSortByAscending());

		// Descending
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(1);

		Assert.assertTrue(productPage.isProductPriceSortByDescending());
	}

	@Test
	public void Sort_03_My_Account() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	LoginPageOpject loginPage;
	ProductPageOpject productPage;
}
