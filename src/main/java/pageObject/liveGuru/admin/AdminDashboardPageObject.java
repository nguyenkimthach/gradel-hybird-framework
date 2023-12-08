package pageObject.liveGuru.admin;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closeMessagePopup() {
		if (areJQueryAndJSLoadedSuccess(driver))
			if (getElementSize(driver, AdminDashboardPageUI.POPUP_ADMIN_DASHBOARD_PAGE) != 0) {
				waitForElementClickable(driver, AdminDashboardPageUI.CLOSE_POPUP_BUTTON_ADMIN_DASHBOARD_PAGE);
				clickToElement(driver, AdminDashboardPageUI.CLOSE_POPUP_BUTTON_ADMIN_DASHBOARD_PAGE);
			}
	}

	public void clickToLogoutLinkAtAdminPageLiveguru(WebDriver driver) {
		waitForElementInvisible(driver, AdminDashboardPageUI.LOADDING_MASK);
		waitForElementClickable(driver, AdminDashboardPageUI.LOGOUT_LINK_ADMIN_DASHBOARD_PAGE);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK_ADMIN_DASHBOARD_PAGE);
	}

	public void enterToTextboxByColumName(String columName, String valueToEnter) {
		int columIndex = getElementSize(driver, AdminDashboardPageUI.COLUM_INDEX_BY_NAME, columName) + 1;
		waitForElementVisible(driver, AdminDashboardPageUI.TEXTBOX_AT_FIRST_ROW_BY_COLUM_INDEX, String.valueOf(columIndex));
		senkeyToElement(driver, AdminDashboardPageUI.TEXTBOX_AT_FIRST_ROW_BY_COLUM_INDEX, valueToEnter, String.valueOf(columIndex));
		pressKeyToElement(driver, AdminDashboardPageUI.TEXTBOX_AT_FIRST_ROW_BY_COLUM_INDEX, Keys.ENTER, String.valueOf(columIndex));
	}

	public boolean isUserNameRegistedDisplay(String userName) {
		waitForElementVisible(driver, AdminDashboardPageUI.USER_NAME_TEXT, userName);
		return isElementDisPlayed(driver, AdminDashboardPageUI.USER_NAME_TEXT, userName);
	}

	public boolean isEmailRegistedDisplay(String emailAddress) {
		waitForElementVisible(driver, AdminDashboardPageUI.EMAIL_ADDRESS_TEXT, emailAddress);
		return isElementDisPlayed(driver, AdminDashboardPageUI.EMAIL_ADDRESS_TEXT, emailAddress);
	}

}
