package pageObject.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPageUI;

public class AdminPostSearchPO extends BasePage {
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewLink() {
		waitForElementClickable(driver, AdminPostSearchPageUI.ADD_NEW_POST_LINK);
		clickToElement(driver, AdminPostSearchPageUI.ADD_NEW_POST_LINK);
		return PageGeneratorManage.getAdminPostAddNewPage(driver);
	}

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX);
		senkeyToElement(driver, AdminPostSearchPageUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.SEARCH_BUTTON);
	}

	public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_ID_HEADER_NAME, headerID) + 1;
		waitForElementVisible(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisPlayed(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}

	public AdminPostAddNewPO clickToPosttitleLink(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPageUI.TABLE_HEADER_INDEX_BY_ID_HEADER_NAME, headerID) + 1;
		waitForElementClickable(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		clickToElement(driver, AdminPostSearchPageUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return PageGeneratorManage.getAdminPostAddNewPage(driver);
	}

	public void selectCheckboxByTitle(String editPostTitle) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSearchPageUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
	}

	public void selectItemInActionDropdown(String dropdownItem) {
		waitForElementClickable(driver, AdminPostSearchPageUI.ACTION_DROPDOWN);
		selectItemInDefaultDropDown(driver, AdminPostSearchPageUI.ACTION_DROPDOWN, dropdownItem);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPageUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPageUI.APPLY_BUTTON);
	}

	public boolean isMoveToTrashMessageDisplay(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
		return isElementDisPlayed(driver, AdminPostSearchPageUI.MOVE_TO_TRASH_MESSAGE, message);
	}

	public boolean isNoPostFoundMessageDisplay(String message) {
		waitForElementVisible(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisPlayed(driver, AdminPostSearchPageUI.NO_POST_FOUND_MESSAGE, message);
	}
}
