package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;
/*
 * To automate mouse events Selenium provides Actions class
 * This class contains several methods to perform different mouse actions
 * every action must call build() and perform()
 */

public class MouseHoverDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.amazon.in");
		
		//create an object of Actions class
		Actions actions = new Actions(driver);
		
		//locate shop by category element
		WebElement shopByCat = driver.findElement(By.id("nav-link-shopall"));
		//move to shop by category element
		actions.moveToElement(shopByCat).build().perform();
		sleep(2);
		
		//locate mobile and computers
		WebElement mobilesAndComputers = driver.findElement(By.xpath("//span[text()='Mobiles, Computers']"));
		//move to mobiles and computers element
		actions.moveToElement(mobilesAndComputers).build().perform();
		sleep(2);
		
		//locate power banks 
		WebElement powerBanks = driver.findElement(By.xpath("//span[text()='Power Banks']"));
		//move to power banks element and click on it
		actions.moveToElement(powerBanks).click().build().perform();
		sleep(4);
		
		closeBrowser();
		
	}

}
