package pageObject.saucelab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.saucelab.LoginPageUI;

public class LoginPageOpject extends BasePage {
	private WebDriver driver;

	public LoginPageOpject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUserNameTextbox(String userName) {
		waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userName);
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public ProductPageOpject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManage.getProductPage(driver);
	}
}
