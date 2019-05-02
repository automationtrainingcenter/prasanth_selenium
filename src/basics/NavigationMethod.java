package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationMethod {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");

//		to launch the browser create an object of the browser driver class
		WebDriver driver = new ChromeDriver();

//		get() which accepts a string argument, which is the url of the application we want to navigate
		driver.get("http://google.com");
		Thread.sleep(2000);
		/*
		 * In WebDriver interface we have Navigation interface This Navigation interface
		 * contains methods to refresh, to navigate front and back of driver history In
		 * WebDriver interface we have navigate() which return Navigation interface
		 * reference
		 */

		// create Navigation interface reference
		Navigation nav = driver.navigate();

		// navigate to another page
		nav.to("http://www.gmail.com");
		Thread.sleep(2000);
//		driver.navigate().to("http://www.gmail.com");
		
//	 	automates back button of browser window 
		nav.back();
		Thread.sleep(3000);

//		automates forward button of browser window
		nav.forward();
		Thread.sleep(3000);

//		automate refresh button of browser window
		nav.refresh();
		Thread.sleep(3000);
		// or driver.get(driver.getCurrentUrl());

		driver.close();
	}

}
