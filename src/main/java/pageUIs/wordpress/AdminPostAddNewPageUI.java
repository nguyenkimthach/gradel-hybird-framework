package pageUIs.wordpress;

public class AdminPostAddNewPageUI {
	public static final String TITLE_TEXTBOX = "css=h1.wp-block-post-title";
	public static final String BODY_TEXTBOX = "css=div.wp-block-post-content p";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "CSS=div[aria-label='Editor top bar'] button[class*='editor-post-publish-button']";
	public static final String PRE_PUBLISH_BUTTON = "CSS=div[aria-label='Editor publish'] button[class*='editor-post-publish-button']";
	public static final String PUBLISHED_OR_UPDATE_MESSAGE = "xpath=//div[@class='components-snackbar__content' and contains(text(),'%s')]";
}
