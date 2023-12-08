package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPageUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToPostTitle(String postTitleValue) {
		waitForAllElementVisible(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX);
		senkeyToElement(driver, AdminPostAddNewPageUI.TITLE_TEXTBOX, postTitleValue);
	}

	public void enterToPostBody(String postBodyValue) {
		waitForElementClickable(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		clickToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);

		waitForElementVisible(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPageUI.BODY_TEXTBOX);
		senkeyToElement(driver, AdminPostAddNewPageUI.BODY_TEXTBOX, postBodyValue);
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PUBLISH_OR_UPDATE_BUTTON);
	}

	public void clickToPrePublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPageUI.PRE_PUBLISH_BUTTON);
	}

	public boolean isPostPublicMessageDisplay(String publishedMessage) {
		waitForElementVisible(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, publishedMessage);
		return isElementDisPlayed(driver, AdminPostAddNewPageUI.PUBLISHED_OR_UPDATE_MESSAGE, publishedMessage);
	}

	public AdminPostSearchPO openSearchPotPageUrl(String searchPostUrl) {
		openPageUrl(driver, searchPostUrl);
		return PageGeneratorManage.getAdminPostSearchPage(driver);
	}
}
