package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver launchBrowser() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;
	}

	public static void launchurl(String url) {
		driver.get(url);

	}

	public static void fillTextBox(WebElement e, String value) {

		e.sendKeys(value);

	}
	public static void fillTextBoxAndEnter(WebElement e, String value) {

		e.sendKeys(value, Keys.ENTER);

	}
	
	public static void btnClick(WebElement e) {
		e.click();

	}

	public static String getText(WebElement e) {
		return e.getText();

	}

	public static void closeCurrentTab() {
		driver.close();

	}

	public static void browserQuit() {
		driver.quit();

	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void javaScript(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);

	}

	public static void windowHandles(int a) {
		Set<String> winid = driver.getWindowHandles();
		List<String> li = new LinkedList<String>();
		li.addAll(winid);
		driver.switchTo().window(li.get(a));

	}

	public static void screenShot(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File temp = tk.getScreenshotAs(OutputType.FILE);
		File perm = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\screenShot\\" + name + ".png");
		FileUtils.copyFile(temp, perm);
		System.out.println("ScreenShot Captured");

	}

	
	public static void explicitWaitVis(WebElement e) {
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(e));
	}
	

	public static void waitforExecution() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

}
