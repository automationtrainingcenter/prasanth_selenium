package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandling {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/SSTS/vibhav/prasanth_selenium/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		//locate button which will open multiple windows and click on it
		driver.findElement(By.id("opentTab")).click();
		//get all window handles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowIds = new ArrayList<>(windowHandles);
//		for(int i = 0; i< windowIds.size(); i++) {
//			driver.switchTo().window(windowIds.get(i));
//			System.out.println(driver.getTitle());
//		}
		
		//automate google window
		//switch the driver focus to google window and google is 3rd child window
		driver.switchTo().window(windowIds.get(3));
		//now focus in google window
		driver.findElement(By.name("q")).sendKeys("best testing institute in chandanagar"+Keys.ENTER);
		Thread.sleep(5000);
		
		//automate youtube window
		//switch the driver focus to youtube window i.e 2nd child window
		driver.switchTo().window(windowIds.get(2));
		//now driver focus is in youtube window
		driver.findElement(By.id("search")).sendKeys("selenium");
		Thread.sleep(2000);
		
		//automate facebook window
		//switch the driver focus to facebook window i.e 1st child window
		driver.switchTo().window(windowIds.get(1));
		//now driver focus is in facebook page
		driver.findElement(By.id("email")).sendKeys("surya@sunshine.com");
		Thread.sleep(2000);
		
		//automate main window
		//switch the driver focus ot main window
		driver.switchTo().window(windowIds.get(0));
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
