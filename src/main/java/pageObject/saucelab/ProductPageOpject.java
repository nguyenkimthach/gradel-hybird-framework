package pageObject.saucelab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.saucelab.ProductPageUI;

public class ProductPageOpject extends BasePage {
	private WebDriver driver;

	public ProductPageOpject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String itemDropdown) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropDown(driver, ProductPageUI.PRODUCT_CONTAINER_DROPDOWN, itemDropdown);
	}

	public boolean isProductNameSortByAscending() {
		ArrayList<String> productUIList = new ArrayList<String>();
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByAscendingByLambda() {
		List<WebElement> elementLists = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		return names.equals(sortedNames);
	}

	public boolean isProductNameSortByDescending() {
		// khai báo ra 1 ArayList để chứa các product name trên UI
		ArrayList<String> productUIList = new ArrayList<String>();

		// lấy ra hết tất cả các product Name
		List<WebElement> productNameText = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);

		// Dùng vòng lặp đê getText và add vào ArayList trên
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}

		// Tạo ra 1 ArayList mới để sort dữ liệu trong ArayList cũ xem đúng hay ko
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}

		// Sort cái productSortList băng thư viên java colections
		Collections.sort(productSortList);

		// Reverse cái productSortList băng thư viên java colections
		Collections.reverse(productSortList);

		// so sanh listUI and list javaColections sort la = nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescendingByLambda() {
		List<WebElement> elementLists = getListWebElement(driver, ProductPageUI.PRODUCT_NAME_TEXT);
		List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
		List<String> sortedNames = new ArrayList<String>(names);
		Collections.sort(sortedNames);
		Collections.reverse(sortedNames);
		return names.equals(sortedNames);
	}

	public boolean isProductPriceSortByAscending() {
		// khai báo ra 1 ArayList để chứa các product name trên UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// lấy ra hết tất cả các product Name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// Dùng vòng lặp đê getText và add vào ArayList trên
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		// Tạo ra 1 ArayList mới để sort dữ liệu trong ArayList cũ xem đúng hay ko
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// Sort cái productSortList băng thư viên java colections
		Collections.sort(productSortList);

		// so sanh listUI and list javaColections sort la = nhau
		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		// khai báo ra 1 ArayList để chứa các product name trên UI
		ArrayList<Float> productUIList = new ArrayList<Float>();

		// lấy ra hết tất cả các product Name
		List<WebElement> productPriceText = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

		// Dùng vòng lặp đê getText và add vào ArayList trên
		for (WebElement productPrice : productPriceText) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		// Tạo ra 1 ArayList mới để sort dữ liệu trong ArayList cũ xem đúng hay ko
		ArrayList<Float> productSortList = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortList.add(product);
		}

		// Sort cái productSortList băng thư viên java colections
		Collections.sort(productSortList);

		// Reverse cái productSortList băng thư viên java colections
		Collections.reverse(productSortList);

		// so sanh listUI and list javaColections sort la = nhau
		return productSortList.equals(productUIList);
	}
}
