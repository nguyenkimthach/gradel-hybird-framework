package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstantsLiveguru;
import pageObject.liveGuru.admin.AdminDashboardPageObject;
import pageObject.liveGuru.admin.AdminLoginPageObject;
import pageObject.liveGuru.user.PageGeneratorManage;
import pageObject.liveGuru.user.UserHomePageObject;
import pageObject.liveGuru.user.UserMyDashboardPageObject;
import pageObject.liveGuru.user.UserRegisterPageObject;

public class Level_10_Home_Work_DataTable_DataGrid extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserRegisterPageObject userRegisterPage;
	private UserMyDashboardPageObject userMyDashbboardPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	String firstname, middleName, lastName, userName, emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		userHomePage = PageGeneratorManage.getHomePage(driver);

		firstname = "Tony";
		middleName = "Leo";
		lastName = "Nguyen";
		userName = firstname + " " + middleName + " " + lastName;
		emailAddress = "afc" + generateFakeNumber() + "@gmail.net";
		password = "123456";
	}

	@Test
	public void Table_01_Register_To_System() {
		userHomePage.clickToAccountMenu();
		userRegisterPage = userHomePage.clickToRegisterLink();
		userRegisterPage.inputToFirstName(firstname);
		userRegisterPage.inputToMiddleName(middleName);
		userRegisterPage.inputToLastName(lastName);
		userRegisterPage.inputToEmailAddress(emailAddress);
		userRegisterPage.inputToPassword(password);
		userRegisterPage.inputToConfirmPassword(password);
		userMyDashbboardPage = userRegisterPage.clickToRegisterButton();
		Assert.assertEquals(userMyDashbboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		userMyDashbboardPage.clickToAccountMenu();
		userHomePage = userMyDashbboardPage.clickToLogoutLink();
	}

	@Test
	public void Table_02_Delete_User_Registed() {
		userHomePage.openPageUrl(driver, GlobalConstantsLiveguru.ADMIN_TESTING_URL);
		adminLoginPage = PageGeneratorManage.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(GlobalConstantsLiveguru.ADMIN_USER_NAME, GlobalConstantsLiveguru.ADMIN_PASSWORD);
		adminDashboardPage.closeMessagePopup();

		adminDashboardPage.enterToTextboxByColumName("Email", emailAddress);

		Assert.assertTrue(adminDashboardPage.isUserNameRegistedDisplay(userName));
		Assert.assertTrue(adminDashboardPage.isEmailRegistedDisplay(emailAddress));
		adminDashboardPage.clickToLogoutLinkAtAdminPageLiveguru(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
