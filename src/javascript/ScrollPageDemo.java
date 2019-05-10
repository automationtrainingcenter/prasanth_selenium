package javascript;

import org.openqa.selenium.JavascriptExecutor;

import utilities.BrowserHelper;
import utilities.JavaScriptHelper;

public class ScrollPageDemo extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "http://amazon.in");
		/*
		 * To execute JavaScript Selenium provides JavaScriptExecuter interface
		 * In this interface we have executeScript(String arg, Object... arg)
		 */
		//type convert WebDrier interface reference to JavaScriptExecutor reference
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("document.documentElement.scrollBy(0, arguments[0])", y);
		JavaScriptHelper.scrollPageBy(driver, 0, 1200);
		
		sleep(3);
		
//		js.executeScript("document.documentElement.scrollBy(0, arguments[0])", y);
		JavaScriptHelper.scrollPageBy(driver, 0, -800);
		
		sleep(3);
		closeBrowser();
	}

}
