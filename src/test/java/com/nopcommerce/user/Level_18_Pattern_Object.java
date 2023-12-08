package com.nopcommerce.user;

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

public class Level_18_Pattern_Object extends BaseTest {
	private WebDriver driver;
	private String day, month, year;
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
		showBrowserConsoleLogs(driver);

		firstName = "Automation";
		lastName = "FC";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
		day = "10";
		month = "June";
		year = "1995";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		showBrowserConsoleLogs(driver);

		log.info("Register - Step 02: Click To radio button by label with label is 'Female'");
		registerPage.clickToRadioButtonByLabel(driver, "Female");

		log.info("Register - Step 03: Enter to Frirstname textbox with value is '" + firstName + "'");
		registerPage.inPutToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 04: Enter to lastName textbox with value is '" + lastName + "'");
		registerPage.inPutToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Step 05: Select to Day dropdown with value is '" + day + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", day);

		log.info("Register - Step 06: Select to Month dropdown with value is '" + month + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", month);

		log.info("Register - Step 07: Select to Year dropdown with value is '" + year + "'");
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", year);

		log.info("Register - Step 08: Enter to Email textbox with value is '" + existingEmail + "'");
		registerPage.inPutToTextboxByID(driver, "Email", existingEmail);

		log.info("Register - Step 09: Click To checkbox by label with label is 'Newsletter'");
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		log.info("Register - Step 10: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inPutToTextboxByID(driver, "Password", validPassword);

		log.info("Register - Step 11: Enter to ConfirmPassword textbox with value is '" + validPassword + "'");
		registerPage.inPutToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register - Step 12: Click to 'Regiter' button");
		registerPage.clickTobuttonByText(driver, "Register");

		log.info("Register - Step 13: verify register success message is diplayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 14: click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();
		showBrowserConsoleLogs(driver);
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();
		showBrowserConsoleLogs(driver);

		log.info("Login - Step 02: Enter to Email textbox with value is '" + existingEmail + "'");
		loginPage.inPutToTextboxByID(driver, "Email", existingEmail);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inPutToTextboxByID(driver, "Password", validPassword);

		log.info("Login - Step 04: Click to Login button");
		loginPage.clickTobuttonByText(driver, "Log in");
		homePage = PageGeneratorManage.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		log.info("Login - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.clickToMyAccountLink();
		showBrowserConsoleLogs(driver);

		log.info("Login - Step 02: Verify 'Customer Infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

		log.info("Login - Step 03: Verify 'First Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("Login - Step 04: Verify 'Last Name' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("Login - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), existingEmail);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
