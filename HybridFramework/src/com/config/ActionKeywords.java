package com.config;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ActionKeywords {

	public static WebDriver driver;
	static String Node = null;
	static DesiredCapabilities cap;
	

	public static void openBrowser() throws Exception {
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Chrome_Driver\\chromedriver.exe");
		driver = new FirefoxDriver();

	}

	public static void navigate() throws Exception {
		driver.manage()
				.timeouts()
				.implicitlyWait(2, TimeUnit.SECONDS);

		driver.manage()
				.window()
				.maximize();

		driver.get(Constants.URL);
	}

	public static void click_Gmail() {
		driver.findElement(By.linkText("Gmail"))
				.click();
		driver.manage()
				.timeouts()
				.implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static void signIn() {
		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']"))
				.click();
	}

	public static void userId() {
		driver.findElement(By.id("identifierId"))
				.sendKeys(Constants.UserId);
	}

	public static void userNext() {
		driver.findElement(By.id("identifierNext"))
				.click();
	}

	public static void input_Password() {
		driver.findElement(By.xpath("//input[@name='password']"))
				.sendKeys(Constants.Password);
	}

	public static void password_Next() {
		driver.findElement(By.xpath("//div[@id='passwordNext']"))
				.click();
	}

	public static void waitFor() throws Exception {
		Thread.sleep(10000);
		Assert.assertTrue(driver.getTitle()
				.contains(Constants.PageTitle));
	}

	public static void click_Logout() throws Exception {
		driver.findElement(By.xpath("//*[@class='gb_db gbii']"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.id("gb_71"))
				.click();
		Thread.sleep(5000);
	}
	
	public static void click(WebElement we) throws Exception {
	we.click();
		Thread.sleep(5000);
	}

	public static void closeBrowser() {
		driver.quit();
	}

}
