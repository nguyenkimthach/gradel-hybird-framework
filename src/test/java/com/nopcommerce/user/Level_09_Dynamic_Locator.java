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

public class Level_09_Dynamic_Locator extends BaseTest {
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

		// Pre-Condition: Register
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
	public void User_01_Register_Login() {
		loginPage = homepage.openLoginPage();
		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox(validPassword);
		homepage = loginPage.clickToLoginButton();
		Assert.assertTrue(homepage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_02_Switch_Page() {
		// Knowledge của Page Object:
		// Một page A khi chuyển qua page B thì phải viết 1 hàm
		// (action: open/click/..: link/button/ image/..) để mở page B đó lên

		customerInforPage = homepage.clickToMyAccountLink();
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
	public void User_03_Dynamic_Page_01() {
		// My Product Review -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Reward points");
		// Reward Point -> Address
		addressPage = (UserAddressPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
		// Address -> Reward Point
		rewardPointPage = (UserRewardPointPageObject) addressPage.openPageAtMyAccountByName(driver, "Reward points");
		// Reward Point -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountByName(driver, "My product reviews");
		// My Product Review -> Address
		addressPage = (UserAddressPageObject) myProductReviewPage.openPageAtMyAccountByName(driver, "Addresses");
		// Address -> Customer Infor
		customerInforPage = (UserCustomerInforPageObject) addressPage.openPageAtMyAccountByName(driver, "Customer info");
		// Customer Infor -> My Product Review
		myProductReviewPage = (UserMyProductReviewPageObject) customerInforPage.openPageAtMyAccountByName(driver, "My product reviews");
	}

	@Test
	public void User_03_Dynamic_Page_02() {
		// My Product Review -> Reward Point
		myProductReviewPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManage.getUserRewardPointPage(driver);
		// Reward Point -> Address
		rewardPointPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManage.getUserAddressPage(driver);
		// Address -> Reward Point
		addressPage.openPageAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManage.getUserRewardPointPage(driver);
		// Reward Point -> My Product Review
		rewardPointPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManage.getUserMyProductReviewPage(driver);
		// My Product Review -> Address
		myProductReviewPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManage.getUserAddressPage(driver);
		// Address -> Customer Infor
		addressPage.openPageAtMyAccountByPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManage.getUserCustomerInforPage(driver);
		// Customer Infor -> My Product Review
		customerInforPage.openPageAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManage.getUserMyProductReviewPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
