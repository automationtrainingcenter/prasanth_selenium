package screenshots;

import org.openqa.selenium.By;

import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class AlertScreenshot extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		
		driver.findElement(By.id("alertbtn")).click();
		
		ScreenshotHelper.alertScreenCapture("screenshots", "alert");
		driver.switchTo().alert().accept();
		
		driver.close();
		
	}

}
