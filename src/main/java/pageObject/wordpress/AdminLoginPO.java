package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String adminUserName) {
		waitForAllElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, adminUserName);
	}

	public void enterToPasstestbox(String adminPassword) {
		waitForAllElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManage.getAdminDashboardPage(driver);
	}
}
