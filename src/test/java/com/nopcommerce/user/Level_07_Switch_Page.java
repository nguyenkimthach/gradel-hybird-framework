package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword;
	private UserHomePageObject homepage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homepage = PageGeneratorManage.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		validPassword = "123456";
	}

	@Test
	public void User_01_Register() {
		registerPage = homepage.clickToRegisterLink();
		registerPage.inPutToFirstnameTextbox(firstName);
		registerPage.inPutToLastnameTextbox(lastName);
		registerPage.inPutToEmailTextbox(existingEmail);
		registerPage.inPutToPasswordTextbox(validPassword);
		registerPage.inPutToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homepage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login() {
		loginPage = homepage.openLoginPage();
		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox(validPassword);
		homepage = loginPage.clickToLoginButton();
		Assert.assertTrue(homepage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homepage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// Knowledge của Page Object:
		// Một page A khi chuyển qua page B thì phải viết 1 hàm
		// (action: open/click/..: link/button/ image/..) để mở page B đó lên

		// Customer Infor -> Address
		addressPage = customerInforPage.openAddressPage(driver);
		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		// My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		// Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		// Reward Point -> My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		// My Product Review -> Address
		addressPage = myProductReviewPage.openAddressPage(driver);
		// Address -> Customer Infor
		customerInforPage = addressPage.openCustomerInforPage(driver);
		// Customer Infor -> My Product Review
		myProductReviewPage = customerInforPage.openMyProductReviewPage(driver);
	}

	@Test
	public void User_05_Switch_Role() {
		// Role User -> Role Admin

		// Role Admin -> Role User
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
