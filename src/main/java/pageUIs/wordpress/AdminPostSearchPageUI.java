package pageUIs.wordpress;

public class AdminPostSearchPageUI {
	public static final String ADD_NEW_POST_LINK = "xpath=//a[text()='Add New Post']";
	public static final String SEARCH_TEXTBOX = "css=input#post-search-input";
	public static final String SEARCH_BUTTON = "css=input#search-submit";
	public static final String TABLE_HEADER_INDEX_BY_ID_HEADER_NAME = "xpath=//table[contains(@class,'table-view-list')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list')]/tbody[@id='the-list']/tr/*[%s]//a[text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list')]/tbody//a[text()='%s']/ancestor::td/preceding-sibling::th/input";
	public static final String ACTION_DROPDOWN = "css=select#bulk-action-selector-top";
	public static final String APPLY_BUTTON = "css=input#doaction";
	public static final String MOVE_TO_TRASH_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String NO_POST_FOUND_MESSAGE = "xpath= //tr[@class='no-items']/td[text()='%s']";
}
