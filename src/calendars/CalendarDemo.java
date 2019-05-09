package calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class CalendarDemo extends BrowserHelper {
	public static void main(String[] args) {
		String jdate = "17";
		launchBrowser("chrome", "https://www.redbus.in/");

		//

		// locate calendar text box and click on so that it will open calendar
		driver.findElement(By.xpath("//label[text()='Onward Date']")).click();
		sleep(2);

		// locate next button and click on it
		driver.findElement(By.cssSelector("#rb-calendar_onward_cal td.next")).click();

		// locate table body of the calendar
		WebElement caledar = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//tbody"));

		// locate all the rows in the table body
		List<WebElement> rows = caledar.findElements(By.tagName("tr"));
		boolean status = false;
		// iterate over the rows
		for (int i = 2; i < rows.size(); i++) {
			List<WebElement> dates = rows.get(i).findElements(By.tagName("td"));
			// iterate over the dates and get the text of every data
			for (WebElement date : dates) {
				if (date.getText().equals(jdate)) {
					date.click();
					status = true;
					break; // dates loop
				}
			}
			if (status) {
				break; // rows loop
			}
		}

		sleep(3);
		closeBrowser();
	}
}
