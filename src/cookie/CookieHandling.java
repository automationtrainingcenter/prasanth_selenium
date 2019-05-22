package cookie;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver.Options;

import utilities.BrowserHelper;

public class CookieHandling extends BrowserHelper{
	
	public static void main(String[] args) {
		launchBrowser("chrome", "http://www.hdfcbank.com");
		sleep(4);
		Options manage = driver.manage();
		Set<Cookie> cookies = manage.getCookies();
		System.out.println(cookies.size());
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
		}
		 
//		manage.deleteAllCookies();
		manage.deleteCookieNamed("check");
		System.out.println("************************************************");
		cookies = manage.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName());
		}
//		System.out.println(cookies.size());
		closeBrowser();
	}

}
