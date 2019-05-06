package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	/*
	 * To handle alerts or JavaScript popups Selenium provides
	 * Alert Interface. In this interface we have
	 * accept() which will click on ok button of the alert
	 * dismiss() which will click on cancel button of the alert
	 * sendKeys(String arg) which will type some data in an alert text field
	 * getText() return String value i.e. text of the alert
	 * 
	 * To automate these alerts, first of all switch driver focus from the web page to alert
	 * In WebDriver interface we have switchTo() which will return TargetLocator interface refernce
	 * In TargetLocator interface we have alert() which will return Alert interface reference
	 */

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		//locate enter your name text filed and enter some name
		WebElement nameField = driver.findElement(By.id("name"));
		nameField.sendKeys("sunshine");
		Thread.sleep(2000);
		
		//locate alert button and click on it
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		
		//now switch the driver focus from page to alert
		Alert alert = driver.switchTo().alert();
		//retrieve the text of alert and print on the console
		String alertText = alert.getText();
		System.out.println("alert came with text as "+alertText);
		//click on OK button of the alert using accept()
		alert.accept();
		Thread.sleep(2000);
		
		//enter some other name in enter your name text field
		nameField.sendKeys("ravali");
		//locate confirm button and click on it
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		//retrieve the text of alert and print on the console
		alertText = alert.getText();
		System.out.println("alert came with text as "+alertText);
		//click on Cancel button of the alert using dismiss()
		alert.dismiss();
		Thread.sleep(2000);
		
		driver.close();
		
		
		
		
	}
}
