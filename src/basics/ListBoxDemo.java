package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBoxDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		/*
		 * To automate drop down list or list box selenium provides Select class To
		 * Select an option of drop down list we can use one of the following methods
		 * selectByIndex(int arg) : selects an option based on index number of the
		 * option and index number starts from 0 selectByValue(String arg) ; selects an
		 * option based on value of the value attribute selectByVisibleText(String arg):
		 * selects an option based on inner text of the <option>
		 */

		// locate list box
		WebElement listBox = driver.findElement(By.id("multiple-select-example"));
		// Create select class object by passing above located element
		Select fruitSelect = new Select(listBox);
		//find all the options in list box or drop down
		List<WebElement> options = fruitSelect.getOptions();
		System.out.println("number of elements in list box are "+options.size());
		
		//verify fruitSelect allows multiple selection or not using isMultiple()
		if(fruitSelect.isMultiple()) {
			//select an option based on index
			fruitSelect.selectByIndex(1);
			Thread.sleep(2000);
			//select an option based on value
			fruitSelect.selectByValue("peach");
			Thread.sleep(2000);
			//find all selected options in a list box
			List<WebElement> selectedOpitons = fruitSelect.getAllSelectedOptions();
			System.out.println("number of selected options are "+selectedOpitons.size());
			
			//select an option based on visible text
			fruitSelect.selectByVisibleText("Apple");
			Thread.sleep(2000);
			//deselect all selected options
//			fruitSelect.deselectAll();
//			Thread.sleep(2000);
			
			//deselect an option based on index
			fruitSelect.deselectByIndex(2);
			Thread.sleep(2000);
			
			//deselect an option based on value
			fruitSelect.deselectByValue("apple");
			Thread.sleep(2000);
			
			//deselect an option based on visible text
			fruitSelect.deselectByVisibleText("Orange");
			Thread.sleep(2000);
			
			
		}else {
			//select any option
			fruitSelect.selectByIndex(1);
		}
		
		driver.close();

	}

}
