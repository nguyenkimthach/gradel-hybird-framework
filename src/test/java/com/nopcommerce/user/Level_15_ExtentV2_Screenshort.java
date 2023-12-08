package com.nopcommerce.user;

import java.lang.reflect.Method;

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

public class Level_15_ExtentV2_Screenshort extends BaseTest {
	WebDriver driver;
	String firstName, lastName, existingEmail, validPassword;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInforPage;

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
		// ExtentManager.startTest(method.getName(), "User_01_Register");
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: click to Register link");
		// registerPage = homePage.clickToRegisterLink();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to Frirstname textbox with value is '" + firstName + "'");
		// registerPage.inPutToFirstnameTextbox(firstName);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to lastName textbox with value is '" + lastName + "'");
		// registerPage.inPutToLastnameTextbox(lastName);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email textbox with value is '" + existingEmail + "'");
		// registerPage.inPutToEmailTextbox(existingEmail);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password textbox with value is '" + validPassword + "'");
		// registerPage.inPutToPasswordTextbox(validPassword);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to ConfirmPassword textbox with value is '" + validPassword + "'");
		// registerPage.inPutToConfirmPasswordTextbox(validPassword);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Regiter' button");
		// registerPage.clickToRegisterButton();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: verify register success message is diplayed");
		// Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 09: click to 'Continue' button");
		// homePage = registerPage.clickToContinueButton();
		//
		// ExtentManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
		// ExtentManager.startTest(method.getName(), "User_02_Login");
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to Login page");
		// loginPage = homePage.openLoginPage();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email textbox with value is '" + existingEmail + "'");
		// loginPage.inPutToEmailTextbox(existingEmail);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password textbox with value is '" + validPassword + "'");
		// loginPage.inPutToPasswordTextbox(validPassword);
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to Login button");
		// homePage = loginPage.clickToLoginButton();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
		// Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'My Account' page");
		// customerInforPage = homePage.clickToMyAccountLink();
		//
		// ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Customer Infor' page is displayed");
		// Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
		//
		// ExtentManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
