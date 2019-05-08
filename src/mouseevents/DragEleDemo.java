package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class DragEleDemo extends BrowserHelper {

	public static void main(String[] args) {
		launchBrowser("chrome", "https://jqueryui.com/draggable/");

		// switch to frame which contains draggable element
		driver.switchTo().frame(0);
		// now focus is in frame and locate draggable element
		WebElement dragEle = driver.findElement(By.id("draggable"));

		// create Actions class object
		Actions actions = new Actions(driver);

//		actions.clickAndHold(dragEle).moveByOffset(400, 200).release().build().perform();
		actions.dragAndDropBy(dragEle, 400, 200).build().perform();
		
		sleep(3);
		closeBrowser();

	}

}
