package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	public static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
	}

	private long longTimeout = 30;

	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitwait = new WebDriverWait(driver, longTimeout);
		return explicitwait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getlAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendKeyTolAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	protected void switchToWindowByID(WebDriver driver, String WindowsID) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			if (!id.equals(WindowsID)) {
				driver.switchTo().window(id);
			}
		}
	}

	protected void switchToWindowByPageTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			driver.switchTo().window(id);
			String actuaPageTitle = driver.getTitle();
			if (actuaPageTitle.equals(tabTitle)) {
				break;
			}
		}
	}

	protected void closeAllWindow_WithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowsIDs = driver.getWindowHandles();
		for (String id : allWindowsIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected void senkeyToElement(WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected boolean isElementDisPlayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	protected void waitForAllElementInvisible(WebDriver driver, List<WebElement> element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(element));
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
