// package com.nopcommerce.user;
//
// import java.util.Random;
// import java.util.concurrent.TimeUnit;
//
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.testng.Assert;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;
//
// import commons.BasePage;
//
// public class Level_02_Apply_BagePage_I {
// WebDriver driver;
// String emailAddress;
// String projectPath = System.getProperty("user.dir");
//
// // Declare(Khai báo)
// BasePage basePage;
//
// @BeforeClass
// public void beforeClass() {
// System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
// driver = new FirefoxDriver();
//
// // Intitial (khởi tạo)
// basePage = new BasePage();
//
// emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
// driver.get("https://demo.nopcommerce.com/");
// }
//
// @Test
// public void TC_01_Register_Empty_Data() {
// basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basePage.clickToElement(driver, "//a[@class='ico-register']");
//
// basePage.waitForElementClickable(driver, "//button[@id='register-button']");
// basePage.clickToElement(driver, "//button[@id='register-button']");
//
// Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
// Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
// Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
// Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
// Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//
// }
//
// @Test
// public void TC_02_Register_Invalid_Email() {
// basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basePage.clickToElement(driver, "//a[@class='ico-register']");
//
// basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
// basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
// basePage.senkeyToElement(driver, "//input[@id='Email']", "123@456#$");
// basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
// basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
// basePage.waitForElementClickable(driver, "//button[@id='register-button']");
// basePage.clickToElement(driver, "//button[@id='register-button']");
//
// Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//
// }
//
// @Test
// public void TC_03_Register_Register_Success() {
// basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basePage.clickToElement(driver, "//a[@class='ico-register']");
//
// basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
// basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
// basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
// basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
// basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
// basePage.waitForElementClickable(driver, "//button[@id='register-button']");
// basePage.clickToElement(driver, "//button[@id='register-button']");
//
// basePage.waitForElementVisible(driver, "//div[@class='result']");
// Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//
// basePage.waitForElementClickable(driver, "//a[contains(@class,'register-continue-button')]");
// basePage.clickToElement(driver, "//a[contains(@class,'register-continue-button')]");
//
// }
//
// @Test
// public void TC_04_Register_Existing_Email() {
// basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basePage.clickToElement(driver, "//a[@class='ico-register']");
//
// basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
// basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
// basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
// basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
// basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
// basePage.waitForElementClickable(driver, "//button[@id='register-button']");
// basePage.clickToElement(driver, "//button[@id='register-button']");
//
// Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
// }
//
// @Test
// public void TC_05_Register_Password_Less_Than_6_Char() {
// basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basePage.clickToElement(driver, "//a[@class='ico-register']");
//
// basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
// basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
// basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
// basePage.senkeyToElement(driver, "//input[@id='Password']", "123");
// basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");
//
// basePage.waitForElementClickable(driver, "//button[@id='register-button']");
// basePage.clickToElement(driver, "//button[@id='register-button']");
//
// Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6
// characters");
//
// }
//
// @Test
// public void TC_06_Register_Invalid_Password() {
// basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
// basePage.clickToElement(driver, "//a[@class='ico-register']");
//
// basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
// basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
// basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
// basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
// basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "666666");
//
// basePage.waitForElementClickable(driver, "//button[@id='register-button']");
// basePage.clickToElement(driver, "//button[@id='register-button']");
//
// Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//
// }
//
// @AfterClass
// public void afterClass() {
// driver.quit();
// }
//
// public int generateFakeNumber() {
// Random rand = new Random();
// return rand.nextInt(9999);
// }
// }
