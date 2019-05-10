package webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;
import utilities.JavaScriptHelper;

public class NSEIndiaTableOne extends BrowserHelper {

	public static void main(String[] args) {
		String companyCode = "INFY";
		launchBrowser("chrome", "https://www.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");
		
		// locate table body
		WebElement tableBody = driver.findElement(By.xpath("//table[@id='preOpenNiftyTab']/tbody"));

		// locate all the rows inside that table body
		List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
		// iterate every row
		for (int i = 2; i < rows.size(); i++) {
			// find all cells in every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			//get the text of first cell and compare it with given company code
			if(cells.get(0).getText().equals(companyCode)) {
				//print text which is in fourth cell
				String text = cells.get(3).getText();
				System.out.println(String.format("price of %s is %s", companyCode, text));
				WebElement ele = cells.get(0).findElement(By.tagName("a"));
				JavaScriptHelper.bringElementToView(driver, ele);
				sleep(2);
				ele.click();
				break;
			}			
		}
		sleep(3);
		closeBrowser();
	}

}
