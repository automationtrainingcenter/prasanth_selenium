package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		/*
		 * To automate drop down list or list box selenium provides Select class To
		 * Select an option of drop down list we can use one of the following methods
		 * selectByIndex(int arg) : selects an option based on index number of the
		 * option and index number starts from 0 selectByValue(String arg) ; selects an
		 * option based on value of the value attribute selectByVisibleText(String arg)
		 * : selects an option based on inner text of the <option>
		 */

		// locate drop down list
		WebElement dayEle = driver.findElement(By.id("day"));
		// create Select class object by passing element located in previous step
		Select daySelect = new Select(dayEle);
		// retrieve the default selected option
		WebElement defaultDate = daySelect.getFirstSelectedOption();
		System.out.println(String.format("default selected date is %s", defaultDate.getText()));
		// select an option based on index
		daySelect.selectByIndex(19);
		Thread.sleep(2000);

		// locate month drop down list
		WebElement monthEle = driver.findElement(By.id("month"));
		// Create Select class object
		Select monthSelect = new Select(monthEle);
		// retrieve the default selected option
		WebElement defaultMonth = monthSelect.getFirstSelectedOption();
		System.out.println(String.format("default selected month is %s", defaultMonth.getText()));
		// select an option based on value of the value attribute
		monthSelect.selectByValue("8");
		Thread.sleep(2000);

		// create SElect class object for year select
		Select yearSelect = new Select(driver.findElement(By.id("year")));
		WebElement defaultYear = yearSelect.getFirstSelectedOption();
		System.out.println(String.format("default selected year is %s", defaultYear.getText()));
		// select an option based on inner text
		yearSelect.selectByVisibleText("1989");
		Thread.sleep(2000);

		driver.close();
	}
}
