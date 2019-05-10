package javascript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;
import utilities.JavaScriptHelper;

public class GetTextFieldValue extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.facebook.com");
		
		//locate email fied
		WebElement emailTextBox = driver.findElement(By.id("email"));
		//type some data into the text box
		emailTextBox.sendKeys("sunshine");
		
		//locate first name
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("selenium");
		sleep(3);
		
//		//type convert WebDriver object to JavaScriptExecutor object
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String text = js.executeScript("return arguments[0].value", emailTextBox).toString();

		String text = JavaScriptHelper.getTextBoxValue(driver, emailTextBox);
		System.out.println("the text of emailTextBox is "+text);
		
		text = JavaScriptHelper.getTextBoxValue(driver, firstName);
		System.out.println("the text of first name field is "+text);

		
		closeBrowser();
		
	}

}
