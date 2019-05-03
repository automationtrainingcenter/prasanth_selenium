package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserManagementMethods {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");

		/*
		 * In WebDriver interface we have manage() which return Options interface
		 * reference In Options interface we have window() which returns Window
		 * interface reference
		 */
		Options manage = driver.manage();
		Window window = manage.window();

		// getSize() -Dimension class object which is height and width of the browser
		// window
		Dimension size = window.getSize();
//		System.out.println("width of the window is "+size.getWidth()+" height of the window is "+size.getHeight());
		System.out.println(String.format("width of the window is  %d and height of the window is %d", size.getWidth(),
				size.getHeight()));

		// getPosition() - Point class object which is x and y coordinate location of
		// window
		Point position = window.getPosition();
		System.out.println(String.format("window at x = %d and at y =%d", position.getX(), position.getY()));

		// maximize() - it will maximizes the browser window
		window.maximize();
//		driver.manage().window().maximize();
		Thread.sleep(2000);

		// fullScreen() - F11 mode
		window.fullscreen();
		Thread.sleep(2000);

		// setSize(Dimesion arg) - set browser height and width with specified values
//		Dimension d = new Dimension(450, 250);
//		window.setSize(d);
		window.setSize(new Dimension(450, 250));
		Thread.sleep(2000);

		// setPosition(Point arg) - set browser location with specified x and y
		// coordinate value
		window.setPosition(new Point(700, 350));
		Thread.sleep(2000);

		driver.close();

	}

}
