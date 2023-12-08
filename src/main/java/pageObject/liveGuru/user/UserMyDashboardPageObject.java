package pageObject.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.user.UserMyDashboardPageUI;

public class UserMyDashboardPageObject extends BasePage {
	private WebDriver driver;

	public UserMyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAccountMenu() {
		waitForElementClickable(driver, UserMyDashboardPageUI.ACCOUNT_MENU);
		clickToElement(driver, UserMyDashboardPageUI.ACCOUNT_MENU);
	}

	public UserHomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserMyDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, UserMyDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManage.getHomePage(driver);
	}

	public boolean isAccountInformationDisplayed() {
		waitForElementVisible(driver, UserMyDashboardPageUI.DASHBOARD_TITLE);
		return isElementDisPlayed(driver, UserMyDashboardPageUI.DASHBOARD_TITLE);

	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserMyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserMyDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
	}

}
