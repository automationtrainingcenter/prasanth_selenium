package reportsandlogs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class LogsDemo {
	WebDriver driver;
	

	// launch browser
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//create Listener class object
		Listener listener = new Listener();
		//create EventFiringWebDriver class object
		EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
		//register Listener class object to EventFiringWebDriver class object
		edriver.register(listener);
		driver = edriver;
		driver.get("http://srssprojects.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// login
	public void login() {
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();

	}

	// role creation
	public void roleCreation() {
		driver.findElement(By.xpath("//a[@href = 'Admin_Roles_details.aspx']")).click();
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys("anyRoleone");
		new Select(driver.findElement(By.id("lstRtypeN"))).selectByVisibleText("E");
		driver.findElement(By.id("btninsert")).click();
		driver.switchTo().alert().accept();
	}

	// logout
	public void logout() {
		driver.findElement(By.xpath("//a[@href='home.aspx']")).click();
	}

	// close browser
	public void close() {
		driver.close();
	}

	public static void main(String[] args) {
		LogsDemo obj = new LogsDemo();
		obj.launchBrowser();
		obj.login();
		obj.roleCreation();
		obj.logout();
		obj.close();
	}

}
