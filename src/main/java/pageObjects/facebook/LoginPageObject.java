package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isconfirmEmailAddressTextboxDisplay() {
		sleepInSecond(3);
		return isElementDisPlayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}

	public boolean isConfirmBirthdayAgeDisplayed() {
		waitForElementInvisible(driver, LoginPageUI.BIRTHDAY_AGE);
		return isElementDisPlayed(driver, LoginPageUI.BIRTHDAY_AGE);
	}

	public boolean isConfirmBirthdayAgeUndisplayed() {
		waitForElementUndisplay(driver, LoginPageUI.BIRTHDAY_AGE);
		return isElementUndisplayed(driver, LoginPageUI.BIRTHDAY_AGE);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	}

	public void clickCloseIconAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}

	public boolean isconfirmEmailAddressTextboxUnsisplay() {
		waitForElementUndisplay(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		return isElementUndisplayed(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
	}
}
