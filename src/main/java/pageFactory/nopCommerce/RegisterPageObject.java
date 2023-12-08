package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page UI
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextbox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextbox;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextbox;

	@CacheLookup
	@FindBy(xpath = "//button[contains(@id,'register-button')]")
	private WebElement registerButton;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErorrMessage;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErorrMessage;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErorrMessage;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErorrMessage;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErorrMessage;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSucessMessage;

	@FindBy(xpath = "//a[contains(@class,'register-continue-button')]")
	private WebElement continueButton;

	@FindBy(xpath = "//div[contains(@class,'message-error')]//li")
	private WebElement existingemailErorrMessage;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErorrMessage);
		return getElementText(driver, firstNameErorrMessage);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameErorrMessage);
		return getElementText(driver, lastNameErorrMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErorrMessage);
		return getElementText(driver, emailErorrMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErorrMessage);
		return getElementText(driver, passwordErorrMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErorrMessage);
		return getElementText(driver, confirmPasswordErorrMessage);
	}

	public void inPutToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, firstNameTextbox);
		senkeyToElement(driver, firstNameTextbox, firstname);
	}

	public void inPutToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, lastNameTextbox);
		senkeyToElement(driver, lastNameTextbox, lastname);
	}

	public void inPutToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		senkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inPutToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		senkeyToElement(driver, passwordTextbox, password);
	}

	public void inPutToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		senkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSucessMessage);
		return getElementText(driver, registerSucessMessage);
	}

	public void clickToContinueButton() {
		waitForElementClickable(driver, continueButton);
		clickToElement(driver, continueButton);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, existingemailErorrMessage);
		return getElementText(driver, existingemailErorrMessage);
	}

}
