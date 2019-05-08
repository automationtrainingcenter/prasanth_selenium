package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//now driver focus is in main window
		//locate open window button and click on it, it will new window
		driver.findElement(By.id("openwindow")).click();
		//switch the driver focus from main window to the child window
		/*
		 * get ids of all windows opened by driver instance using getWindowHandles() of WebDriver interface
		 * getWindowHanldes() returns a Set<String> and convert that set to List<String>
		 * In that list index 0 we will id of main window, index 1 will have id  of first child window
		 * , index 2 will id of second child window and so on 
		 * to switch the focus from main window to any window use following approach
		 * In WebDriver interface we have switchTo() which returns TargetLocator interface
		 * In TargerLocator interface we have window(String arg) i.e. id of the child window you want to switch
		 */
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowIds = new ArrayList<>(windowHandles);
		
		//switch the focus to child window
		driver.switchTo().window(windowIds.get(1));
		Thread.sleep(2000);
		//now focus is in child window
		//locate search text field and enter some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(2000);
		
		//now switch the focus back to main window and type some data in enter your name text field
		driver.switchTo().window(windowIds.get(0));
		//now focus is in main window
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}
}
