package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_II extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, incorrectPassword;
	private UserHomePageObject homepage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject myAccountPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homepage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		invalidEmail = "fc@1232@.vn";
		notFoundEmail = "aufc" + generateFakeNumber() + "@mail.com";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
		incorrectPassword = "666666";

		System.out.println("Pre-Condition-Step 01: Click Register link");
		registerPage = homepage.clickToRegisterLink();

		System.out.println("Pre-Condition-Step 02: input infor");
		registerPage.inPutToFirstnameTextbox(firstName);
		registerPage.inPutToLastnameTextbox(lastName);
		registerPage.inPutToEmailTextbox(existingEmail);
		registerPage.inPutToPasswordTextbox(validPassword);
		registerPage.inPutToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-Condition-Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition-Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Pre-Condition-Step 05: Click to Continue button");
		homepage = registerPage.clickToContinueButton();
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data-Step 01: Click Login link");
		loginPage = homepage.openLoginPage();
		System.out.println("Login_01_Empty_Data-Step 02: Click Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_01_Empty_Data-Step 03: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login_02_Invalid_Email-Step 01: Click Login link");
		loginPage = homepage.openLoginPage();
		System.out.println("Login_02_Invalid_Email-Step 02: Input to required fields");
		loginPage.inPutToEmailTextbox(invalidEmail);
		System.out.println("Login_02_Invalid_Email-Step 03: Click Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_02_Invalid_Email-Step 04: Verify error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		System.out.println("Login_03_Email_Not_Found-Step 01: Click Login link");
		loginPage = homepage.openLoginPage();
		System.out.println("Login_03_Email_Not_Found-Step 02: Input to required fields");
		loginPage.inPutToEmailTextbox(notFoundEmail);
		System.out.println("Login_03_Email_Not_Found-Step 03: Click Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_03_Email_Not_Found-Step 04: Verify unsuccessful error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Exiting_Email_Empty_Password() {
		System.out.println("Login_04_Exiting_Email_Empty_Password-Step 01: Click Login link");
		loginPage = homepage.openLoginPage();
		System.out.println("Login_04_Exiting_Email_Empty_Password-Step 02: Input to required fields");
		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox("");
		System.out.println("Login_04_Exiting_Email_Empty_Password-Step 03: Click Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_04_Exiting_Email_Empty_Password-Step 04: Verify unsuccessful error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	// @Test
	public void Login_05_Exiting_Email_Incorrect_Password() {
		System.out.println("Login_05_Exiting_Email_Incorrect_Password-Step 01: Click Login link");
		loginPage = homepage.openLoginPage();
		System.out.println("Login_05_Exiting_Email_Incorrect_Password-Step 02: Input to required fields");
		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox(incorrectPassword);
		System.out.println("Login_05_Exiting_Email_Incorrect_Password-Step 03: Click Login Button");
		loginPage.clickToLoginButton();
		System.out.println("Login_05_Exiting_Email_Incorrect_Password-Step 04: Verify unsuccessful error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		System.out.println("Login_06_Valid_Email_Password-Step 01: Click Login link");
		loginPage = homepage.openLoginPage();
		System.out.println("Login_06_Valid_Email_Password-Step 02: Input to required fields");
		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox(validPassword);
		System.out.println("Login_06_Valid_Email_Password-Step 03: Click Login Button");
		homepage = loginPage.clickToLoginButton();
		System.out.println("Login_06_Valid_Email_Password-Step 04: Verify My Account link displayed");
		Assert.assertTrue(homepage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
