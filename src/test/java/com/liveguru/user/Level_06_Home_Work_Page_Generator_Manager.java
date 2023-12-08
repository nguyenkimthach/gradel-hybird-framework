package com.liveguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.user.UserHomePageObject;
import pageObject.liveGuru.user.UserLoginPageObject;
import pageObject.liveGuru.user.UserMyDashboardPageObject;
import pageObject.liveGuru.user.PageGeneratorManage;
import pageObject.liveGuru.user.UserRegisterPageObject;

public class Level_06_Home_Work_Page_Generator_Manager extends BaseTest {
	private WebDriver driver;
	String firstname, middleName, lastName, emailAddress, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://live.techpanda.org/");
		homePage = PageGeneratorManage.getHomePage(driver);

		firstname = "Automation";
		middleName = "FC";
		lastName = "Testing";
		emailAddress = "afc" + generateFakeNumber() + "@gmail.net";
		password = "123456";
	}

	@Test
	public void User_01_Register_To_System() {
		System.out.println("User_01_Register_To_System - step01 : click Account Menu");
		homePage.clickToAccountMenu();
		System.out.println("User_01_Register_To_System - step02 : click Register Link");
		registerPage = homePage.clickToRegisterLink();
		System.out.println("User_01_Register_To_System - step03 : Input required fields");
		registerPage.inputToFirstName(firstname);
		registerPage.inputToMiddleName(middleName);
		registerPage.inputToLastName(lastName);
		registerPage.inputToEmailAddress(emailAddress);
		registerPage.inputToPassword(password);
		registerPage.inputToConfirmPassword(password);
		System.out.println("User_01_Register_To_System - step04 : click Register Button");
		myDashbboardPage = registerPage.clickToRegisterButton();
		System.out.println("User_01_Register_To_System - step05 : verify Register Success Message");
		Assert.assertEquals(myDashbboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
		System.out.println("User_01_Register_To_System - step06 : ");
		myDashbboardPage.clickToAccountMenu();
		System.out.println("User_01_Register_To_System - step07 : click Account Menu");
		homePage = myDashbboardPage.clickToLogoutLink();
	}

	@Test
	public void User_02_login_To_System() {
		System.out.println("User_02_login_To_System - step01 : ");
		loginPage = homePage.clickToMyAccountLink();
		System.out.println("User_02_login_To_System - step02 : Input required fields");
		loginPage.inPutToEmailTextbox(emailAddress);
		loginPage.inPutToPasswordTextbox(password);
		System.out.println("User_02_login_To_System - step03 : click Login Button");
		myDashbboardPage = loginPage.clickToLoginButton();
		System.out.println("User_02_login_To_System - step04 : verify Account Information Displayed");
		Assert.assertTrue(myDashbboardPage.isAccountInformationDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserMyDashboardPageObject myDashbboardPage;
}
