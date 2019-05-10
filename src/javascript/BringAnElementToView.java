package javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;
import utilities.JavaScriptHelper;

public class BringAnElementToView extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.amazon.in");
		
		//locate element back to top
		WebElement backToTop = driver.findElement(By.id("navBackToTop"));
		
		//type convert WebDriver to JavaScriptExecutor
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView()", backToTop);
		JavaScriptHelper.bringElementToView(driver, backToTop);
		sleep(3);
		JavaScriptHelper.scrollPageBy(driver, 0, -100);
		
		sleep(3);
		backToTop.click();
		sleep(3);
		closeBrowser();
		
	}
	

}
