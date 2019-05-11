package screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import utilities.BrowserHelper;
import utilities.ScreenshotHelper;

public class ScreenshotDemo extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.facebook.com");
//		
//		/*
//		 * Selenium provides TakeScreenshot interface which contains getScreenshotAs()
//		 * Type convert WebDriver interface reference to TakeScreenshot interface reference
//		 */
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		//capture the screenshot using getScreenshotAs() and select OutputType as File
//		File srcImg = ts.getScreenshotAs(OutputType.FILE);
//		//create File class with the file path where you want to save the image
//		File destImg = new File(".\\screenshots\\image1.png");
//		try {
//			//use copyFile() of FileUtils class 
//			//import this class from org.apache.commons.io package
//			// to import download commons.io jar files and then associate the jars to the project build path 
//			FileUtils.copyFile(srcImg, destImg);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		ScreenshotHelper.captureScreenshot(driver, "screenshots", "image");
//		ScreenshotHelper.captureScreenshot(driver, "D:\\SSTS\\image1.png");
		driver.close();
	}

}
