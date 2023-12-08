package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_C extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManage.getUserHomePage(driver);
		existingEmail = Common_01_Register_End_User.existingEmail;
		validPassword = Common_01_Register_End_User.validPassword;

		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Set Cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.LoggedCookies);
		loginPage.refreshCurrentPage(driver);
	}

	@Test
	public void Search_01_Empty_Data() {
	}

	@Test
	public void Search_02_Relative_Product_Name() {
	}

	@Test
	public void Search_03_Absolute_Product_Name() {
	}

	@Test
	public void Search_04_Parent_Category() {
	}

	@Test
	public void Search_05_Incorrect_Manufactorer() {
	}

	@Test
	public void Search_06_Correct_Manufactorer() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private String existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

}
