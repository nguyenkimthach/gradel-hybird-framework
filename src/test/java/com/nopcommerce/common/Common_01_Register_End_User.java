package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	public static String existingEmail, validPassword;
	private String firstName, lastName;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeTest(description = "Create new common User for all classes Test")
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManage.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";

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
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 09: click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();
		driver.quit();
	}
}
