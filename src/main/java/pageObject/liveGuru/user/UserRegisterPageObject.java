package pageObject.liveGuru.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.liveGuru.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToFirstName(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToMiddleName(String middleName) {
		waitForElementVisible(driver, UserRegisterPageUI.MIDDLE_NAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.MIDDLE_NAME_TEXTBOX, middleName);
	}

	public void inputToLastName(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailAddress(String emailAddress) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ADDRESS_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void inputToPassword(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPassword(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public UserMyDashboardPageObject clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManage.getMyDashbboardPage(driver);
	}

}
