package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_15_ExtentV3_Screenshort extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManage.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
	}

	@Test
	public void User_01_Register(Method method) {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inPutToFirstnameTextbox(firstName);

		registerPage.inPutToLastnameTextbox(lastName);

		registerPage.inPutToEmailTextbox(existingEmail);

		registerPage.inPutToPasswordTextbox(validPassword);

		registerPage.inPutToConfirmPasswordTextbox(validPassword);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login(Method method) {
		loginPage = homePage.openLoginPage();

		loginPage.inPutToEmailTextbox(existingEmail);

		loginPage.inPutToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.clickToMyAccountLink();

		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
