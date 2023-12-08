package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManage {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

}
