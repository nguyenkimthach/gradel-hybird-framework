package pageUIs.liveGuru.admin;

public class AdminDashboardPageUI {
	public static final String POPUP_ADMIN_DASHBOARD_PAGE = "css=div#message-popup-window";
	public static final String CLOSE_POPUP_BUTTON_ADMIN_DASHBOARD_PAGE = "css=div#message-popup-window a[title='close']";
	public static final String LOGOUT_LINK_ADMIN_DASHBOARD_PAGE = "css=a.link-logout";
	public static final String LOADDING_MASK = "css=div#loading-mask";

	public static final String COLUM_INDEX_BY_NAME = "xpath=//tr[@class='headings']/th//span[text()='%s']//ancestor::th//preceding-sibling::th";
	public static final String TEXTBOX_AT_FIRST_ROW_BY_COLUM_INDEX = "xpath=//tr[@class='filter']/th[%s]/div//input";
	public static final String EMAIL_ADDRESS_TEXT = "xpath=//td[contains(text(),'%s')]";
	public static final String USER_NAME_TEXT = "xpath=//td[contains(text(),'%s')]";

}
