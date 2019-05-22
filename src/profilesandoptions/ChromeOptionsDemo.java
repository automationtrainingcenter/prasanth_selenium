package profilesandoptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Choose the extension and get the complete path with the version.
 * Copy the path and paste it into Chrome Pack Extension window to get the .crx extension file
 * Use this path in ChromeOptions()
 * 
 * chrome extensions are available in below folder in windows os
 * C:\Users\%USERNAME%\AppData\Local\Google\Chrome\User Data\Default\Extensions
 */


public class ChromeOptionsDemo {
	
	public static void main(String[] args) {
		File chroPath = new File("C:\\Users\\SuryaPrakash\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ljngjbnaijcbncmcnjfhigebomdlkcjo\\5.0.3_0.crx");
		File katalonPath = new File("C:\\Users\\SuryaPrakash\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\ljdobmomdgdljniojadhoplhkpialdid\\3.7.0_0.crx");
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(chroPath, katalonPath);
		WebDriver driver = new ChromeDriver(options);
	}
	
	

}
