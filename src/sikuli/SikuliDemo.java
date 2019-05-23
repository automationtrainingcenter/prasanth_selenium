package sikuli;

import org.openqa.selenium.By;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utilities.BrowserHelper;

public class SikuliDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "https://smallpdf.com/word-to-pdf");
		//locate choose file link and click on it 
		driver.findElement(By.xpath("//div[text()='Choose file']")).click();
		sleep(3);
		//create an object of Screen class
		Screen screen = new Screen();
		
		//Create an object of Pattern class
		Pattern fileName = new Pattern(getFilePath("images", "fileName.png"));
		Pattern open = new Pattern(getFilePath("images", "open.png"));
		
		try {
			screen.find(fileName);
			screen.type(fileName, "D:\\selenium\\Notes\\selenium wait types.docx");
			screen.find(open);
			screen.click(open);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		sleep(5);
		
		closeBrowser();
	}

}
