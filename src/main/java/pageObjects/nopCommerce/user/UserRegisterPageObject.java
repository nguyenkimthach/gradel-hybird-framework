package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {
	WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	@Step("Enter to Frirstname textbox with value is '{0}'")
	public void inPutToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstname);
	}

	@Step("Enter to Lastname textbox with value is '{0}'")
	public void inPutToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastname);
	}

	@Step("Enter to Email textbox with value is '{0}'")
	public void inPutToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_NAME_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.EMAIL_NAME_TEXTBOX, emailAddress);
	}

	@Step("Enter to Password textbox with value is '{0}'")
	public void inPutToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter to Confirm Password textbox with value is '{0}'")
	public void inPutToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD);
		senkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD, confirmPassword);
	}

	@Step("Verify register success message is diplayed")
	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	@Step("click to 'Continue' button")
	public UserHomePageObject clickToContinueButton() {
		waitForElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorManage.getUserHomePage(driver);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EXISTING_EMAIL_ERROR_MESSAGE);
	}

}
