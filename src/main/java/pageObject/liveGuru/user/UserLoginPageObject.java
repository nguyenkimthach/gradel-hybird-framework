package pageObject.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inPutToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void inPutToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public UserMyDashboardPageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManage.getMyDashbboardPage(driver);
	}

	public void loginAsUser(String emailAddress, String password) {
		inPutToEmailTextbox(emailAddress);
		inPutToPasswordTextbox(password);
		clickToLoginButton();
	}

	public String getErrorMessageLoginInvalid() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
	}

}
