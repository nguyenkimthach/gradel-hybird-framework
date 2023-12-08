package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePageUI;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisPlayed(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisPlayed(driver, UserHomePageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostInforDisplayedWithAuthorname(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePageUI.POST_AUTHOR_NAME_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisPlayed(driver, UserHomePageUI.POST_AUTHOR_NAME_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostInforDisplayedWithCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserHomePageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisPlayed(driver, UserHomePageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePageUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManage.getUserPostDetailPage(driver);
	}

	public boolean isPostTitleUndisplayedWithPostTitle(String editPostTitle) {
		return isElementUndisplayed(driver, UserHomePageUI.POST_TITLE_TEXT, editPostTitle);
	}

	public void enterToSearchTextbox(String editPostTitle) {
		waitForElementVisible(driver, UserHomePageUI.SEARCH_TEXTBOX);
		senkeyToElement(driver, UserHomePageUI.SEARCH_TEXTBOX, editPostTitle);
	}

	public UserSearchPostPO clickToSearchButton() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePageUI.SEARCH_BUTTON);
		return PageGeneratorManage.getUserSearchPostPage(driver);
	}
}
