package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
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

public class Level_12_Assert_Verify extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, validPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressPageObject addressPage;
	private UserRewardPointPageObject rewardPointPage;
	private UserMyProductReviewPageObject myProductReviewPage;

	// Từ bài học Assert-Verify trở đi khi ứng dụng các hàm verifyTrue/False/ Equals
	// thì các bạn phải thêm cái listener vào trong các file xml để run testcase nó mới chạy đúng

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
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inPutToFirstnameTextbox(firstName);
		registerPage.inPutToLastnameTextbox(lastName);
		registerPage.inPutToEmailTextbox(existingEmail);
		registerPage.inPutToPasswordTextbox(validPassword);
		registerPage.inPutToConfirmPasswordTextbox(validPassword);
		registerPage.clickToRegisterButton();
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		homePage = registerPage.clickToContinueButton();
		loginPage = homePage.openLoginPage();

		loginPage.inPutToEmailTextbox(existingEmail);
		loginPage.inPutToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		// verify sai test error
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		customerInforPage = homePage.clickToMyAccountLink();
		// verify sai test error
		verifyFalse(customerInforPage.isCustomerInforPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
