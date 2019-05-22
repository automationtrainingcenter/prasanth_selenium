package profilesandoptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

/*
 * Profile is a File where Firefox saves your personal information such as bookmarks, 
 * passwords, and user preferences. 
 * Multiple Firefox profiles can exist, each containing a separate set of preferences.
 * When starting Firefox in Selenium WebDriver, it starts new "anonymous" profile.
 * 
 * to open profiles in firefox browser type about:profiles
 */
public class FirefoxOptionsDemo {
	
	public static void main(String[] args) {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fprofile = profile.getProfile("automation");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fprofile);
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(options);
	}

}
