package utilities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

	private static String getDateTime() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("HH_mm_ss-dd_MMM_yy");
		return df.format(date);
	}

	private static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName + getDateTime()
				+ ".png";
	}

	public static void captureScreenshot(WebDriver driver, String folderName, String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(getFilePath(folderName, fileName));
		try {
			BufferedImage bi = ImageIO.read(srcImg);
			ImageIO.write(bi, "png", destImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void captureScreenshot(WebDriver driver, String filePathOutsideTheProject) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcImg = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(filePathOutsideTheProject);
		try {
			BufferedImage bi = ImageIO.read(srcImg);
			ImageIO.write(bi, "png", destImg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void alertScreenCapture(String folderName, String fileName) {
		try {
			Robot r = new Robot();
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(d);
			BufferedImage bi = r.createScreenCapture(rect);
			File destImg = new File(getFilePath(folderName, fileName));
			ImageIO.write(bi, "png", destImg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
