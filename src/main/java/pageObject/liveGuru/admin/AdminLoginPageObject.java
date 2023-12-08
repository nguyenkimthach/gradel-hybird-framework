package pageObject.liveGuru.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.liveGuru.user.PageGeneratorManage;
import pageUIs.liveGuru.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage {
	private WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	private void inputToPassword(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX_ADMIN_LOGIN_PAGE);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX_ADMIN_LOGIN_PAGE, adminPassword);
	}

	private void inputToUserName(String adminUserName) {
		waitForElementVisible(driver, AdminLoginPageUI.USER_TEXTBOX_ADMIN_LOGIN_PAGE);
		senkeyToElement(driver, AdminLoginPageUI.USER_TEXTBOX_ADMIN_LOGIN_PAGE, adminUserName);
	}

	private AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON_ADMIN_LOGIN_PAGE);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON_ADMIN_LOGIN_PAGE);
		return PageGeneratorManage.getAdminDashboardPage(driver);
	}

	public AdminDashboardPageObject loginAsAdmin(String adminUserName, String adminPassword) {
		inputToUserName(adminUserName);
		inputToPassword(adminPassword);
		return clickToLoginButton();
	}

}
