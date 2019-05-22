package waittypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		/*
		 * implicitlyWait() -- An implicit wait tells the WebDriver to wait for a
		 * certain amount of time when trying to locate element or elements if they are
		 * not available immediately on the page the implicit wait set for life of the
		 * WebDriver object
		 */
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		/*
		 * pageLoadTimeout() -- A pageLoadTimeout tells the WebDriver to wait for a
		 * certain amount of time for a page load to complete before throwing an
		 * exception
		 */
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		/*
		 * setScriptTimeout() -- setScriptTimeout tells the WebDriver to wait for a
		 * certain amount of time for an asynchronous script to finish execution before
		 * throwing an exception
		 */
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(0, 1700)");
		Thread.sleep(5000);
		/*
		 * Explicit wait or WebDriverWait with Expected conditions -- tells the
		 * WebDriver to wait for a certain condition to met before locating an element
		 * with in a given time frame
		 */
		// create an object of WebDriverWait class
		WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement navTotop = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        navTotop.sendKeys("sunshine");
//		driver.findElement(By.id("email")).sendKeys("sunshine");
		Thread.sleep(5000);
		// close the browser
		driver.close();

	}
}
