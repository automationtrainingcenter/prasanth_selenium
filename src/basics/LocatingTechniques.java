package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingTechniques {

	public static void main(String[] args) {
		// set system property
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// create an object of ChromeDriver class
		WebDriver driver = new ChromeDriver();
		// navigate to url
		driver.get("http://www.facebook.com");
		//maximize the browser widow
		driver.manage().window().maximize();

		/*
		 * findElement() -> is used to locate an element in the web page using locator
		 * information. If the element is not located using the given locator info this
		 * method throws NoSuchElementException.
		 */

		/*
		 * findElements() -> is used to locate multiple elements in the web page using
		 * locator information. This method returns a list of elements. if no element is
		 * not located then this method returns an empty list.
		 */

		// selenium provides 8 ways to locate elements in By class all the methods are
		// static methods
		// id -> By.id() locates element uniquely using id attribute of the element
//		By firstNameId = By.id("u_0_j");
//		driver.findElement(firstNameId);
		WebElement firstName = driver.findElement(By.id("u_0_j"));
		
		// name -> By.name() locates element uniquely using name attribute of the
		// element
		WebElement surname = driver.findElement(By.name("lastname"));

		// linkText -> By.linkText() locates links(anchor tags <a>) with text (inner text) of the link
		//inner text means the text in between any opening and closing tags
		WebElement createAPageLink = driver.findElement(By.linkText("Create a Page"));

		// partialLinkText -> By.partialLinkText() locates links(anchor tags) with
		// partial text of the link
		WebElement whyDOBLink = driver.findElement(By.partialLinkText("date of birth"));

		/* cssSelector -> By.cssSelector() locates element using css selector of the
		 *  element
		 *  syntax: tagName[attrName = 'attrValue']
		 */
		WebElement femaleRadio = driver.findElement(By.cssSelector("input[value = '1']"));

		// xpath -> By.xpath() locates element using xpath(XML path) of the element
		// syntax to xpath is //tagname[@attName = 'attValue' ]
		WebElement maleRadio = driver.findElement(By.xpath("//input[@value='2']"));

		// className -> By.className() locates element using class name the of the
		// element
		List<WebElement> textFields = driver.findElements(By.className("_58mg"));
		System.out.println(String.format("number of text fileds in the page are %d", textFields.size()));

		// tagName -> By.tagName() locates element by it's tag name
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(String.format("number of links in the page are %d", links.size()));
		
		/*
		 * There is a high probability of locating multiple elements by using class name
		 * and tag name
		 */
		
		
		driver.close();
	}

}
