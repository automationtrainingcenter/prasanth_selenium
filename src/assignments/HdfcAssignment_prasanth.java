package assignments;

import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;
/*
 * navigate to https://www.hdfcbank.com/
 * click on login
 * switch to child window
 * click on continue to net banking using this xpath
 * (//a[@class='btn btn-default redBtn'])[2]
 * click continue (this is in frame)
 * accept the alert
 * enter some data in customer id (six digit nubmer)
 * switch to parent window
 * enter some data in search field
 * 
 */

public class HdfcAssignment_prasanth {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		if (driver.findElements(By.xpath("//img[@class='popupCloseButton']")).size() != 0) {

			Actions actions = new Actions(driver);

			WebElement powerBanks = driver.findElement(By.xpath("//img[@class='popupCloseButton']"));

			actions.moveToElement(powerBanks).click().build().perform();

		}

		driver.findElement(By.id("loginsubmit")).click();
		Thread.sleep(2000);

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowIds = new ArrayList<>(windowHandles);
		driver.switchTo().window(windowIds.get(2));
		driver.manage().window().maximize();
		Thread.sleep(4000);

		driver.findElement(By.xpath("(//a[@class='btn btn-default redBtn'])[2]")).click();
		Thread.sleep(2000);

		driver.switchTo().frame("login_page");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='continue']")).click();
		Thread.sleep(3000);

		Alert alert = driver.switchTo().alert();

		alert.accept();
		Thread.sleep(2000);

		driver.findElement(By.name("fldLoginUserId")).sendKeys("123456");
		Thread.sleep(2000);

		driver.switchTo().window(windowIds.get(0));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Prasanth");
		
		System.out.println("Completed");

		driver.quit();

	}

}
