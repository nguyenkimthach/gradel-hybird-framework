package pageObject.liveGuru.user;

import org.openqa.selenium.WebDriver;

import pageObject.liveGuru.admin.AdminDashboardPageObject;
import pageObject.liveGuru.admin.AdminLoginPageObject;

public class PageGeneratorManage {

	public static UserHomePageObject getHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}

	public static UserMyDashboardPageObject getMyDashbboardPage(WebDriver driver) {
		return new UserMyDashboardPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}

	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
}
