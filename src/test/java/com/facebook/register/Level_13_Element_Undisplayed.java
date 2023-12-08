package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.LoginPageObject;
import pageObjects.facebook.PageGeneratorManage;

public class Level_13_Element_Undisplayed extends BaseTest {
	private LoginPageObject loginPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDriver(browserName, url);
		loginPage = PageGeneratorManage.getLoginPage(driver);
	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		loginPage.clickToCreateNewAccountButton();

		// Nếu 1 cái hàm chỉ mong đợi để verify element displayed thôi kết hợp cả wait + isDisplayed
		// waitForElementVisible
		// isElementDisplayed

		// Verify True - mong đợi Confirm Email displayed (true)
		loginPage.enterToEmailTextbox("automationfc@gmail.com");
		verifyTrue(loginPage.isconfirmEmailAddressTextboxDisplay());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		// Nếu như mình mong đợi 1 cái hàm vừa verify displayed/ undisplayed thì ko được kết hợp wait
		// waitForElementVisible
		// isElementDisplayed

		// Verify False - mong đợi Confirm birthday Age Undisplayed (false)
		// hamf isDisplayed khong the check element co trong DOM
		verifyFalse(loginPage.isConfirmBirthdayAgeDisplayed());

		verifyTrue(loginPage.isConfirmBirthdayAgeUndisplayed());
	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_DOM() {
		loginPage.clickCloseIconAtRegisterForm();

		// Khi close cái form Register đi thi Confirm Email ko còn trong DOM nữa
		// Nên hàm findElement sẽ bị fail vi ko tìm thấy element
		// 1 - Nó sẽ chờ hết timeout của implicit: 30s
		// 2 - Nó sẽ đánh fail testcase tại dùng step này luôn
		// 3 - Ko có chay các step còn lại nữa

		// Verify False mong đợi Confirm Email Undisplayed (false)
		// isDisplayed: bản chất ko kiem tra 1 element ko có trong DOM được
		// verifyFalse(loginPage.isconfirmEmailAddressTextboxDisplay());

		verifyTrue(loginPage.isconfirmEmailAddressTextboxUnsisplay());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
}
