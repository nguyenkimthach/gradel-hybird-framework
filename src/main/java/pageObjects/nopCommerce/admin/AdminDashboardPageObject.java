package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAdminDashboardPageDisplay() {
		waitForElementVisible(driver, AdminDashboardPageUI.ADMIN_DASHBOARD_HEADER);
		return isElementDisPlayed(driver, AdminDashboardPageUI.ADMIN_DASHBOARD_HEADER);
	}
}
