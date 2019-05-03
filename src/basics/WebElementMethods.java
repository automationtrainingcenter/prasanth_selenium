package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		/*
		 * A web page is a combination of many different HTML elements, like images,
		 * buttons, tables, links, labels, forms, edit boxes, paragraphs, dropdown boxes
		 * and so on, these elements are WebElements in the context of WebDriver.
		 */

		// click -> click() clicks on any element
//		WebElement loginLink = driver.findElement(By.cssSelector("input[value='Log In']"));
//		loginLink.click();
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		Thread.sleep(2000);

		// sendKeys -> sendKeys() fills text box or text area with given value
		WebElement uname = driver.findElement(By.id("email"));
		uname.sendKeys("sunshine");
		Thread.sleep(2000);

		// clear -> clear() clears the text inside the text box or text area
		uname.clear();
		Thread.sleep(2000);
		
		// getAttribute -> getAttribute(String attName) returns the value of the given
		// attribute
		WebElement password = driver.findElement(By.id("pass"));
		String ariaLabelValue = password.getAttribute("aria-label");
		System.out.println(String.format("password field aria-label value is %s", ariaLabelValue));

		// getCssValue -> getCssValue(String arg) returns the value of the given css
		// property
		String fontSize = password.getCssValue("font-size");
		System.out.println(String.format("font size of the password field is %s", fontSize));
		
		// getText -> getText() returns the inner text of the element
		WebElement login = driver.findElement(By.id("loginbutton"));
		String loginText = login.getText();
		System.out.println(String.format("innert text of the login button is %s", loginText));

		// getTagName -> getTagName() return the tag name of the element
		String loginTag = login.getTagName();
		System.out.println("login tag name is "+loginTag);

		// getLocation -> getLocation() returns the location of the element as Point
		// class object from the top-left corner of the web page
		Point location = login.getLocation();
		System.out.println(String.format("login button is at x = %d and at y = %d", location.getX(), location.getY()));

		// getSize -> getSize() returns the size of the element in terms of width of
		// height as Dimension class object
		Dimension size = login.getSize();
		System.out.println(String.format("login buttion width is %d and height is %d", size.getWidth(), size.getHeight()));

		// isDiplayed -> isDisplayed() returns true if an element is visible on the page
		boolean unameDisplayed = uname.isDisplayed();
		System.out.println("username field is displayed "+unameDisplayed);

		// isElabled -> isEnabled() returns true if an element is enabled on the page
		boolean enabled = password.isEnabled();
		System.out.println("password field is enabled "+enabled);
		
		// isSelected -> isSelected() returns true if a radio button or check box or
		// list box or drop down button option is selected right now

		// submit -> submit() submit a form to the web server
		uname.submit();
		Thread.sleep(2000);
		
		driver.close();
	}

}
