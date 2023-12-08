package com.wordpress.admin;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneratorManage;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailPO;
import pageObject.wordpress.UserSearchPostPO;
import reportConfig.ExtentTestManager;

public class Post_01_Creat_Read_Update_Delete_Search extends BaseTest {
	String adminUserName = "automationfc";
	String adminPassword = "automationfc";
	String searchPostUrl;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;
	String editPostTitle = "Edit Title " + randomNumber;
	String editPostBody = "Edit Body " + randomNumber;
	String authorName = "Automation FC";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUser) {
		this.adminUrl = adminUrl;
		this.endUserUrl = endUser;

		driver = getBrowserDriver(browserName, adminUrl);

		adminLoginPage = PageGeneratorManage.getAdminLoginPage(driver);

		adminLoginPage.enterToUserNameTextbox(adminUserName);
		adminLoginPage.enterToPasstestbox(adminPassword);
		adminDashboardPage = adminLoginPage.clickToLoginButton();
	}

	@Test
	public void Post_01_Creaat_New_Post(Method method) {
		ExtentTestManager.startTest(method.getName(), "Creaat New Post");
		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 01: Click to 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostmenuLink();

		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 02: Open 'Search Post' Page Url");
		searchPostUrl = adminPostSearchPage.getPageUrl(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 03: Click to 'Add New' link");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewLink();

		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 04: Enter to Post title");
		adminPostAddNewPage.enterToPostTitle(postTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 04: Enter to Post body");
		adminPostAddNewPage.enterToPostBody(postBody);

		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 07: Click to 'Pre Publish' button");
		adminPostAddNewPage.clickToPrePublishButton();

		ExtentTestManager.getTest().log(Status.INFO, "Create_Post - Step 07: Verify 'Post published.' message is displayed");
		Assert.assertTrue(adminPostAddNewPage.isPostPublicMessageDisplay("Post published."));
	}

	@Test
	public void Post_02_Seach_And_View_Post(Method method) {
		ExtentTestManager.startTest(method.getName(), "Post_02_Seach_And_View_Post");
		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 01: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPotPageUrl(searchPostUrl);

		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 02: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 03: Click to 'Search Post' Button");
		adminPostSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 04: Verify Seach table contains '" + postTitle + "'");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 05: Click to 'Search Post' Button" + authorName + "'");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 06: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, endUserUrl);

		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 07: Verify Post infor displayed at Home Page");
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostTitle(postTitle));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithAuthorname(postTitle, authorName));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithCurrentDay(postTitle, currentDay));

		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 08: Open End User site");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Seach_Post - Step 09: Verify Post infor displayed at Post detail Page");
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(postTitle));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(postTitle, postBody));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithAuthorname(postTitle, authorName));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithCurrentDay(postTitle, currentDay));
	}

	@Test
	public void Post_03_Edit_Post(Method method) {
		ExtentTestManager.startTest(method.getName(), "Post_03_Edit_Post");
		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 01: Open Admin side");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, adminUrl);

		adminLoginPage.enterToUserNameTextbox(adminUserName);
		adminLoginPage.enterToPasstestbox(adminPassword);
		adminDashboardPage = adminLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 02: Click to 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostmenuLink();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 03: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 04: Click to 'Search Post' Button");
		adminPostSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 05: Click to Post title and navigate to Edit post page");
		adminPostAddNewPage = adminPostSearchPage.clickToPosttitleLink("title", postTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 06: Enter to Post title");
		adminPostAddNewPage.enterToPostTitle(editPostTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 07: Enter to Post body");
		adminPostAddNewPage.enterToPostBody(editPostBody);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 09: Verify 'Post updated.' message is displayed");
		Assert.assertTrue(adminPostAddNewPage.isPostPublicMessageDisplay("Post updated."));

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 10: Open 'Search Post' page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPotPageUrl(searchPostUrl);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 11: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 12: Click to 'Search Post' Button");
		adminPostSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 13: Verify Seach table contains '" + editPostTitle + "'");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 14: Click to 'Search Post' Button" + authorName + "'");
		Assert.assertTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 15: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, endUserUrl);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 16: Verify Post infor displayed at Home Page");
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostTitle(editPostTitle));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithAuthorname(editPostTitle, authorName));
		Assert.assertTrue(userHomePage.isPostInforDisplayedWithCurrentDay(editPostTitle, currentDay));

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 17: Open End User site");
		userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 18: Verify Post infor displayed at Post detail Page");
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostTitle(editPostTitle));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithPostBody(editPostTitle, editPostBody));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithAuthorname(editPostTitle, authorName));
		Assert.assertTrue(userPostDetailPage.isPostInforDisplayedWithCurrentDay(editPostTitle, currentDay));
	}

	@Test
	public void Post_04_Delete_Post(Method method) {
		ExtentTestManager.startTest(method.getName(), "Post_04_Delete_Post");
		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 01: Open Admin side");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, adminUrl);

		adminLoginPage.enterToUserNameTextbox(adminUserName);
		adminLoginPage.enterToPasstestbox(adminPassword);
		adminDashboardPage = adminLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 02: Click to 'Post' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostmenuLink();

		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 03: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 04: Click to 'Search Post' Button");
		adminPostSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 05: Select Post detail checkbox");
		adminPostSearchPage.selectCheckboxByTitle(editPostTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 06: Select 'Move to Trash' item in dropdown");
		adminPostSearchPage.selectItemInActionDropdown("Move to Trash");

		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 07: Click to 'Apply' Button");
		adminPostSearchPage.clickToApplyButton();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		Assert.assertTrue(adminPostSearchPage.isMoveToTrashMessageDisplay("1 post moved to the Trash."));

		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 09: Enter to search textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Delete_Post - Step 10: Click to 'Search Post' Button");
		adminPostSearchPage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 11: Verify 'No posts found.' message is displayed");
		Assert.assertTrue(adminPostSearchPage.isNoPostFoundMessageDisplay("No posts found."));

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 12: Open End User site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, endUserUrl);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 13: Verify Post title undisplayed at Home Page");
		Assert.assertTrue(userHomePage.isPostTitleUndisplayedWithPostTitle(editPostTitle));

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 14: Enter to search textbox");
		userHomePage.enterToSearchTextbox(editPostTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 15: Click to 'Search' Button");
		userSearchPostPage = userHomePage.clickToSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Edit_Post - Step 16: Verify 'Nothing Found' message is displayed");
		Assert.assertTrue(userSearchPostPage.isNothingFoundMessageDisplay("Nothing Found"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	AdminPostSearchPO adminPostSearchPage;
	AdminPostAddNewPO adminPostAddNewPage;
	UserHomePO userHomePage;
	UserPostDetailPO userPostDetailPage;
	UserSearchPostPO userSearchPostPage;
}
