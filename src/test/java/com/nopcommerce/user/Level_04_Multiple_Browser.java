package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, emailAddress, password;
	private UserHomePageObject homepage;
	private UserRegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homepage = new UserHomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01-Step 01: Click register link");
		homepage.clickToRegisterLink();

		// Click Register link -> Nhảy qua trang Register => phải khởi tạo trang
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_01-Step 02: Click register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01-Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02-Step 01: Click Register link");
		homepage.clickToRegisterLink();

		// Click Register link -> Nhảy qua trang Register => phải khởi tạo trang
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_02-Step 02: Input to required fields");
		registerPage.inPutToFirstnameTextbox(firstName);
		registerPage.inPutToLastnameTextbox(lastName);
		registerPage.inPutToEmailTextbox("123@456#$");
		registerPage.inPutToPasswordTextbox(password);
		registerPage.inPutToConfirmPasswordTextbox(password);

		System.out.println("Register_02-Step 03: Click Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02-Step 03: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Register_03_Register_Success() {
		System.out.println("Register_03-Step 01: Click Register link");
		homepage.clickToRegisterLink();

		// Click Register link -> Nhảy qua trang Register => phải khởi tạo trang
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_03-Step 02: Input to required fields");
		registerPage.inPutToFirstnameTextbox(firstName);
		registerPage.inPutToLastnameTextbox(lastName);
		registerPage.inPutToEmailTextbox(emailAddress);
		registerPage.inPutToPasswordTextbox(password);
		registerPage.inPutToConfirmPasswordTextbox(password);

		System.out.println("Register_03-Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03-Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register_03-Step 05: Click to Continue button");
		registerPage.clickToContinueButton();
	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04-Step 01: Click Register link");
		homepage.clickToRegisterLink();

		// Click Register link -> Nhảy qua trang Register => phải khởi tạo trang
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_04-Step 02: Input to required fields");
		registerPage.inPutToFirstnameTextbox(firstName);
		registerPage.inPutToLastnameTextbox(lastName);
		registerPage.inPutToEmailTextbox(emailAddress);
		registerPage.inPutToPasswordTextbox(password);
		registerPage.inPutToConfirmPasswordTextbox(password);

		System.out.println("Register_04-Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04-Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorExistingEmailMessage(), "The specified email already exists");
	}

	@Test
	public void Register_05_Password_Less_Than_6_Char() {
		System.out.println("Register_0-Step 01: Click Register link");
		homepage.clickToRegisterLink();

		// Click Register link -> Nhảy qua trang Register => phải khởi tạo trang
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_05-Step 02: Input to required fields");
		registerPage.inPutToFirstnameTextbox(firstName);
		registerPage.inPutToLastnameTextbox(lastName);
		registerPage.inPutToEmailTextbox("123@456#$");
		registerPage.inPutToPasswordTextbox("123");
		registerPage.inPutToConfirmPasswordTextbox("123");

		System.out.println("Register_05-Step 03: Click Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_05-Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_06_Invalid_Password() {
		System.out.println("Register_06-Step 01: Click Register link");
		homepage.clickToRegisterLink();

		// Click Register link -> Nhảy qua trang Register => phải khởi tạo trang
		registerPage = new UserRegisterPageObject(driver);

		System.out.println("Register_06-Step 02: Input to required fields");
		registerPage.inPutToFirstnameTextbox(firstName);
		registerPage.inPutToLastnameTextbox(lastName);
		registerPage.inPutToEmailTextbox(emailAddress);
		registerPage.inPutToPasswordTextbox(password);
		registerPage.inPutToConfirmPasswordTextbox("666666");

		System.out.println("Register_06-Step 03: Click Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_06-Step 04: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
