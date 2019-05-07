package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Frame is used to store a web page inside another page
 * To work with frames first of all we have switch the driver focus to frame by using
 * either index number of the frame, id or name attribute of the frame and by locating 
 * frame using any attribute
 * 
 * we can switch to frame using following approach
 * In WebDriver interface we have switchTo() which returns TargetLocator interface
 * In TargerLocator interface we have several methods to switch to frame
 * 1 frame(int arg) it will switch to frame based on the index number of the frame
 * 2 frame(String arg) it will switch to frame based on id or name attribute value of the frame
 * 3 frame(WebElement arg) it will switch to frame based on the frame element we located
 * 4 parentFrame() it will switch to a parent frame from it's child frame or inner frame
 * 5 defaultContent() it will switch to main page from any frame
 */

public class FramesDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		//driver focus is in main page
		//locate enter your name text field and type some data
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		//switch the driver focus from main page to frame which contains search text field
//		driver.switchTo().frame(0); //index based
//		driver.switchTo().frame("courses-iframe"); //id attribute based
//		driver.switchTo().frame("iframe-name"); //name attribute based
		//locate the frame using any attribute
		WebElement frEle = driver.findElement(By.xpath("//iframe[contains(@src, 'courses')]"));
//		WebElement frEle = driver.findElement(By.cssSelector("iframe[src*='courses']"));
 		driver.switchTo().frame(frEle);
		
		//now focus is in frame
		//locate search text field and enter some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(2000);
		
		//switch the focus back to main page
		driver.switchTo().defaultContent();
		
		//now focus is in main page
		//locate hide and show text field and enter some data
		driver.findElement(By.id("displayed-text")).sendKeys("selenium");
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
}
