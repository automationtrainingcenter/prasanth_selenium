package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiframesHandling {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/SSTS/vibhav/prasanth_selenium/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		//driver focus is in main page
		//now automte frame 4 which is an inner frame of frame 3
		//first switch the driver focus to frame 3
		driver.switchTo().frame("fthree");
		//now focus is in frame 3
		//switch the focus to frame 4 i.e. inner frame of frame 3
		driver.switchTo().frame(0);
		//now focus is in frame 4
		driver.findElement(By.id("search")).sendKeys("selenium");
		Thread.sleep(2000);
		
		//now automate frame 3
		//focus is in frame 4 i.e. inner frame of frame 3
		//switch the focus from frame 4 to frame 3 using parentFrame()
		driver.switchTo().parentFrame();
		//now focus is in frame 3
		driver.findElement(By.id("click")).click();
		Thread.sleep(2000);
		
		//now automate frame 2
		//focus is in frame 3 
		//first switch the focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		//switch the focus to frame 2
		driver.switchTo().frame("ftwo");
		//now focus in frame 2
		driver.findElement(By.partialLinkText("selenium")).click();
		Thread.sleep(2000);
		
		//now automate frame 1
		//focus is in frame 2
		//first switch the focus to main page
		driver.switchTo().defaultContent();
		//switch the focus to frame 1
		driver.switchTo().frame("fone");
		//now focus is in frame 1
		driver.findElement(By.cssSelector("input[placeholder='Enter name']")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		
		//now automate main page
		//focus is in frame 1
		//switch focus to main page
		driver.switchTo().defaultContent();
		driver.findElement(By.id("opentWin")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
