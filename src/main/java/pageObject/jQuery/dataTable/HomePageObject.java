package pageObject.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxLabel(String headerLabel, String values) {
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, headerLabel);
		senkeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, values, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisPlayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);

		List<String> allRowValuesAllPage = new ArrayList<String>();

		// Duyet qua all page
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(index));

			// get text all row mỗi page đưa vào Array List
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValuesAllPage.add(eachRow.getText());
			}
		}
		for (String rowValue : allRowValuesAllPage) {
			System.out.println(rowValue);
		}
		return allRowValuesAllPage;
	}

	public void enterToTextboxByColumNameAtRowNumber(String columName, String rowNumber, String valueToEnter) {
		int columIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		senkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUM_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columIndex));
	}

	public void selectDropdownByColumNameAtRowNumber(String columName, String rowNumber, String valueToSelect) {
		int columIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		waitForElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		selectItemInDefaultDropDown(driver, HomePageUI.DROPDOWN_BY_COLUM_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columIndex));
	}

	public void clickLoadButton() {
		waitForElementVisible(driver, HomePageUI.LOAD_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_BUTTON);
	}

	public void checkToCheckBoxByColumNameAtRowNumber(String columName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
	}

	public void unCheckToCheckBoxByColumNameAtRowNumber(String columName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columName) + 1;
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
		unCheckToDefaultCheckboxRadio(driver, HomePageUI.CHECKBOX_BY_COLUM_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber, iconName);
	}

}
