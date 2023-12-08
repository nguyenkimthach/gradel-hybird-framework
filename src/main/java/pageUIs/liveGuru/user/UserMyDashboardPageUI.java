package pageUIs.liveGuru.user;

public class UserMyDashboardPageUI {
	public static final String ACCOUNT_MENU = "xpath=//a[contains(@class, 'skip-account')]";
	public static final String LOGOUT_LINK = "xpath=//a[@title = 'Log Out']";
	public static final String DASHBOARD_TITLE = "xpath=//div[@class='page-title']//h1[text()='My Dashboard']";
	public static final String REGISTER_SUCCESS_MESSAGE = "xpath=//li[@class='success-msg']//span";
	public static final String CHECKBOX_BY_EMAIL = "xpath=//td[contains(text(),'%s')]//preceding-sibling::td[@class='a-center ']/input";
	public static final String ACTION_MANAGE_USER_DROPDOWN = "xpath=//select[@id='customerGrid_massaction-select']/option[text()='%s']";
}
