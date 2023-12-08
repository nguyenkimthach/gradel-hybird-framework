package pageObject.jQuery.uploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.uploadFile.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisPlayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}

	public boolean isFileLinkUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisPlayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}

	public boolean isFileImageUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
		return isImageLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMAGE, fileName);
	}

	public void clickToStartButton() {
		List<WebElement> allStartButton = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement starbutton : allStartButton) {
			starbutton.click();
			sleepInSecond(2);
		}
	}
}
