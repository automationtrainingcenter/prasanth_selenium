package basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowserDemo {

	public static void main(String[] args) {
		/*
		 * to launch chrome browser set System property with the path of the
		 * chromedriver.exe file using webdriver.chrome.driver property create an object
		 * of ChromeDriver class
		 */
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver cObj = new ChromeDriver();
		
		
		/*
		 * to luanch firefox browser set  System property with the path of geckodrive.exe file using 
		 * webdriver.gecko.driver property
		 * Create an object of FirefoxDriver class
		 */
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		FirefoxDriver fObj = new FirefoxDriver();

	}

}
