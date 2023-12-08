package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManage;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_08_Switch_Role extends BaseTest {
	private WebDriver driver;
	private String userFirstName, userLastName, userEmailAddress, userPassword, adminEmailAddress, adminPassword;
	private UserHomePageObject userHomepage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject userLoginPage;
	private UserCustomerInforPageObject UserCustomerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;

	@Parameters({ "browser", "enviroment" })
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		driver = getBrowserDriver(browserName, enviromentName);
		userHomepage = PageGeneratorManage.getUserHomePage(driver);

		userFirstName = "Automation";
		userLastName = "FC";
		userEmailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

		// Pre-Condition: Register
		registerPage = userHomepage.clickToRegisterLink();
		registerPage.inPutToFirstnameTextbox(userFirstName);
		registerPage.inPutToLastnameTextbox(userLastName);
		registerPage.inPutToEmailTextbox(userEmailAddress);
		registerPage.inPutToPasswordTextbox(userPassword);
		registerPage.inPutToConfirmPasswordTextbox(userPassword);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		userHomepage = registerPage.clickToContinueButton();
	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomepage.openLoginPage();

		// Login as User Role
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomepage.isMyAccountLinkDisplayed());

		// Home page -> customerinfor page
		UserCustomerInforPage = userHomepage.clickToMyAccountLink();

		// customerinfor click logout -> Home page
		userHomepage = UserCustomerInforPage.clickToLogoutLinkAtUserPage(driver);

		// User Home Page > Open Admin page -> Login Page (Admin)
		userHomepage.openPageUrl(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManage.getAdminLoginPage(driver);

		// Login as Admin Role
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isAdminDashboardPageDisplay());

		// Dashboard Page -> Click Logout -> Login Page (Admin)
		adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdminPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		// Login Page (Admin) -> Open Portal url-> Home page (User)
		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_DEV_URL);
		userHomepage = PageGeneratorManage.getUserHomePage(driver);

		// home page -> login page
		userLoginPage = userHomepage.openLoginPage();

		// Login as User Role
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomepage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
