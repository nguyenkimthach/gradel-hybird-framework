package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.CustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage {
	private WebDriver driver;

	public UserCustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}

	@Step("Verify 'Customer Infor' page to displayed")
	public boolean isCustomerInforPageDisplayed() {
		waitForElementVisible(driver, CustomerInforPageUI.CUSSTOMER_INFOR_HEADER);
		return isElementDisPlayed(driver, CustomerInforPageUI.CUSSTOMER_INFOR_HEADER);
	}

}
