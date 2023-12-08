package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page UI
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErorrMessage;

	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement unsuccessfulErorrMessage;

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErorrMessage);
		return getElementText(driver, emailErorrMessage);
	}

	public void inPutToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inPutToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);
	}

	public String getErrorMessageUnsuccessful() {
		waitForElementVisible(driver, unsuccessfulErorrMessage);
		return getElementText(driver, unsuccessfulErorrMessage);
	}
}
