package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
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

public class Level_14_Log_ReportNG extends BaseTest {
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
	public void User_01_Register() {
		log.info("Register - Step 01: click to Register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Enter to Frirstname textbox with value is '" + firstName + "'");
		registerPage.inPutToFirstnameTextbox(firstName);

		log.info("Register - Step 03: Enter to lastName textbox with value is '" + lastName + "'");
		registerPage.inPutToLastnameTextbox(lastName);

		log.info("Register - Step 04: Enter to Email textbox with value is '" + existingEmail + "'");
		registerPage.inPutToEmailTextbox(existingEmail);

		log.info("Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inPutToPasswordTextbox(validPassword);

		log.info("Register - Step 06: Enter to ConfirmPassword textbox with value is '" + validPassword + "'");
		registerPage.inPutToConfirmPasswordTextbox(validPassword);

		log.info("Register - Step 07: Click to 'Regiter' button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 08: verify register success message is diplayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		log.info("Register - Step 09: click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Enter to Email textbox with value is '" + existingEmail + "'");
		loginPage.inPutToEmailTextbox(existingEmail);

		log.info("Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inPutToPasswordTextbox(validPassword);

		log.info("Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Navigate to 'My Account' page");
		customerInforPage = homePage.clickToMyAccountLink();

		log.info("Login - Step 07: Verify 'Customer Infor' page is displayed");
		verifyFalse(customerInforPage.isCustomerInforPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
