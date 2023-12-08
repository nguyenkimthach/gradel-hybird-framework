package pageObject.saucelab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManage {

	public static LoginPageOpject getLoginPage(WebDriver driver) {
		return new LoginPageOpject(driver);
	}

	public static ProductPageOpject getProductPage(WebDriver driver) {
		return new ProductPageOpject(driver);
	}
}
