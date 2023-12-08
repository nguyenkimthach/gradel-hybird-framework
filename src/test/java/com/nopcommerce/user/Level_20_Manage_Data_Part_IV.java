package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_20_Manage_Data_Part_IV extends BaseTest {

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManage.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();

		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakemail.com";

		System.out.println(userData.getLoginUsername());
		System.out.println(userData.getLoginPassword());

		System.out.println(userData.getSubjects().get(0).getName());
		System.out.println(userData.getSubjects().get(0).getPoint());

		System.out.println(userData.getSubjects().get(1).getName());
		System.out.println(userData.getSubjects().get(1).getPoint());
	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: click to Register link");
		log.info("Register - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		showBrowserConsoleLogs(driver);

		log.info("Register - Step 02: Click To radio button by label with label is 'Female'");
		registerPage.clickToRadioButtonByLabel(driver, "Female");

		log.info("Register - Step 03: Enter to Frirstname textbox with value is '" + userData.getLoginUsername() + "'");
		registerPage.inPutToTextboxByID(driver, "FirstName", userData.getLoginUsername());

		// registerPage.inPutToTextboxByID(driver, "FirstName", userData.getLoginUsername());

		log.info("Register - Step 04: Enter to lastName textbox with value is '" + userData.getLastName() + "'");
		registerPage.inPutToTextboxByID(driver, "LastName", userData.getLastName());

		log.info("Register - Step 05: Select to Day dropdown with value is '" + userData.getDate() + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", userData.getDate());

		log.info("Register - Step 06: Select to Month dropdown with value is '" + userData.getMonth() + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", userData.getMonth());

		log.info("Register - Step 07: Select to Year dropdown with value is '" + userData.getYear() + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", userData.getYear());

		log.info("Register - Step 08: Enter to Email textbox with value is '" + emailAddress + "'");
		registerPage.inPutToTextboxByID(driver, "Email", emailAddress);

		log.info("Register - Step 09: Click To checkbox by label with label is 'Newsletter'");
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 10: Enter to Password textbox with value is '" + userData.getPassword() + "'");
		registerPage.inPutToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Register - Step 11: Enter to ConfirmPassword textbox with value is '" + userData.getPassword() + "'");
		registerPage.inPutToTextboxByID(driver, "ConfirmPassword", userData.getPassword());

		log.info("Register - Step 12: Click to 'Regiter' button");
		registerPage.clickTobuttonByText(driver, "Register");

		log.info("Register - Step 13: verify register success message is diplayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 14: click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();
		showBrowserConsoleLogs(driver);
	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: click to Register link");
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();
		showBrowserConsoleLogs(driver);

		log.info("Login - Step 02: Enter to Email textbox with value is '" + emailAddress + "'");
		loginPage.inPutToTextboxByID(driver, "Email", emailAddress);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + userData.getPassword() + "'");
		loginPage.inPutToTextboxByID(driver, "Password", userData.getPassword());

		log.info("Login - Step 04: Click to Login button");
		loginPage.clickTobuttonByText(driver, "Log in");
		homePage = PageGeneratorManage.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_My_Account(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with valid Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: click to Register link");
		log.info("Login - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.clickToMyAccountLink();
		showBrowserConsoleLogs(driver);

		log.info("Login - Step 02: Verify 'Customer Infor' page is displayed");
		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());

		log.info("Login - Step 03: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), userData.getFirstName());

		log.info("Login - Step 04: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), userData.getLastName());

		log.info("Login - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private String emailAddress;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	UserDataMapper userData;

}
