package pageObject.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManage {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

}
