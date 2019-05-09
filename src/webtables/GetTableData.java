package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class GetTableData extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		
		//locate table body
		WebElement tableBody = driver.findElement(By.xpath("//table[@id='product']/tbody"));
		
		//locate all the rows inside that table body
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		//iterate every row
		for(int i = 1; i<rows.size(); i++) {
			//find all cells in every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			//iterate over every cell
			for(WebElement cell : cells) {
				//automate those cells
				System.out.print(cell.getText()+"\t");
			}
			System.out.println();
		}
		
		closeBrowser();
	}

}
