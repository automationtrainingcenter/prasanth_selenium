package waittypes;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");

		Function<WebDriver, WebElement> condition1 = new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.id("email"));
			}
		};

//		Function<WebDriver, Boolean> condition2 = new Function<WebDriver, Boolean>() {
//			@Override
//			public Boolean apply(WebDriver driver) {
//				return driver.getTitle().toLowerCase().contains("facebook");
//			}
//		};

//		Function<WebDriver, Boolean> condition2 = (WebDriver d) -> {
//			return d.getTitle().toLowerCase().contains("facebook");
//		};

		// create an object of FluentWait class
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(30));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);

//		WebElement email = wait.until(condition1);
//		email.sendKeys("sunshine");
		wait.until((WebDriver d ) -> d.findElement(By.id("email"))).sendKeys("sunshine");

//		if (wait.until((WebDriver d) -> {
//			return d.getTitle().toLowerCase().contains("facebook");
//		})) {
//			driver.findElement(By.id("email")).sendKeys("sunshine");
//		}

	}

}
