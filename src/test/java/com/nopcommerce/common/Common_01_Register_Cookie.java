package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {
	private WebDriver driver;
	public static String firstName, lastName, existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	public static Set<Cookie> LoggedCookies;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all classes Test")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManage.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";

		log.info("Pre-Condition - Step 01: click to Register link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-Condition - Step 02: Enter to Frirstname textbox with value is '" + firstName + "'");
		registerPage.inPutToFirstnameTextbox(firstName);

		log.info("Pre-Condition - Step 03: Enter to lastName textbox with value is '" + lastName + "'");
		registerPage.inPutToLastnameTextbox(lastName);

		log.info("Pre-Condition - Step 04: Enter to Email textbox with value is '" + existingEmail + "'");
		registerPage.inPutToEmailTextbox(existingEmail);

		log.info("Pre-Condition - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		registerPage.inPutToPasswordTextbox(validPassword);

		log.info("Pre-Condition - Step 06: Enter to ConfirmPassword textbox with value is '" + validPassword + "'");
		registerPage.inPutToConfirmPasswordTextbox(validPassword);

		log.info("Pre-Condition - Step 07: Click to 'Regiter' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 08: verify register success message is diplayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Pre-Condition - Step 09: click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();

		log.info("Pre-Condition - Step 10: Navigate to Login page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 11: Enter to Email textbox with value is '" + existingEmail + "'");
		loginPage.inPutToEmailTextbox(existingEmail);

		log.info("Pre-Condition - Step 12: Enter to Password textbox with value is '" + validPassword + "'");
		loginPage.inPutToPasswordTextbox(validPassword);

		log.info("Pre-Condition - Step 13: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		LoggedCookies = homePage.getAllCookies(driver);
	}

	@AfterTest
	public void afterClass() {
		driver.quit();
	}

}
