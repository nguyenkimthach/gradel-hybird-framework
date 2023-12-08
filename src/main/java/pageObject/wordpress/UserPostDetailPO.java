package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserPostDetailPageUI;

public class UserPostDetailPO extends BasePage {
	WebDriver driver;

	public UserPostDetailPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInforDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
		return isElementDisPlayed(driver, UserPostDetailPageUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInforDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisPlayed(driver, UserPostDetailPageUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostInforDisplayedWithAuthorname(String postTitle, String authorName) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_AUTHOR_NAME_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisPlayed(driver, UserPostDetailPageUI.POST_AUTHOR_NAME_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostInforDisplayedWithCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserPostDetailPageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisPlayed(driver, UserPostDetailPageUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}
}
