package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// Browser Launch

//	public static WebDriver launchBrowser() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		return driver;
//	}

	public static WebDriver launchBrowser(String browserName) {
//		
//		if(browserName.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if(browserName.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}
//		else if(browserName.equalsIgnoreCase("edge")) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		}
//		return driver;

		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "egde":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		}
		return driver;

	}

	// Url launch

	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	// wait

	public static void implicityWait(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	// getcurrent url

	public static String getCurrenturl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	// getTitle

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	// quit

	public static void quit() {
		driver.quit();
	}

	// sendkeys
	public static void sendkeys(WebElement e, String value) {
		e.sendKeys(value);
	}

	// getAttribute
	public static String getAttribute(WebElement e) {
		String value = e.getAttribute("value");
		return value;
	}

	// getText
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}

	// click
	public static void buttonClick(WebElement e) {
		e.click();
	}

	// Actions
	// movetoElement
	public static void movetoElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	// Drag&Drop
	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des).perform();
	}

	// Select
	// SelectByindex
	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	// DeselectByValue

	public static void deselectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByValue(value);

	}

	// findElement

	public static WebElement findElement(String locatorName, String locatorValue) {
		WebElement value = null;

		if (locatorName.equals("id")) {
			value = driver.findElement(By.id(locatorValue));
		} else if (locatorName.equals("name")) {
			value = driver.findElement(By.name(locatorValue));
		} else if (locatorName.equals("xpath")) {
			value = driver.findElement(By.xpath(locatorValue));
		}
		return value;

	}

	public static void screenShot(String FileName) throws IOException {

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(src);
		File des = new File(
				"C:\\Users\\kalai\\eclipse-workspace\\MavenProject12.00PM\\src\\test\\resources\\" + FileName + ".png");
		FileUtils.copyFile(src, des);

	}

	public static void js(WebElement e,String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','"+value+"')", e);
	}
	
	public static String jsgetAttribute(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object atUser = js.executeScript("return arguments[0].getAttribute('value')", e);
		String value = atUser.toString();
		return value;
	}
	
}
