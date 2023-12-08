package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtentV5_Screenshort extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
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
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";

	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: click to Register link");
		registerPage = homePage.clickToRegisterLink();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to Frirstname textbox with value is '" + firstName + "'");
		registerPage.inPutToFirstnameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to lastName textbox with value is '" + lastName + "'");
		registerPage.inPutToLastnameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inPutToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password textbox with value is '" + password + "'");
		registerPage.inPutToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to ConfirmPassword textbox with value is '" + password + "'");
		registerPage.inPutToConfirmPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to 'Regiter' button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify register success message is diplayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 09: click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "User_02_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inPutToEmailTextbox(emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox with value is '" + password + "'");
		loginPage.inPutToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 06: Navigate to 'My Account' page");
		customerInforPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 07: Verify 'Customer Infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
