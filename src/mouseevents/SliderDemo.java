package mouseevents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class SliderDemo extends BrowserHelper{
	public static void main(String[] args) {
		launchBrowser("chrome", "https://leads.hdfcbank.com/StartDoing/personal-loan.aspx?promo_code=p16_google_search_ntb&utm_source=google&utm_medium=cpc&utm_campaign=personalloanbrand&utm_content=pl-core-exact-location-occ-emi-calculator&utm_device=c&utm_term=personal%20loan%20emi%20calculator&campid=pl-core-exact-location-occ&adwcode=emi-calculator&keyw=personal%20loan%20emi%20calculator&source_code=HNET&ef_id=EAIaIQobChMItNmr2ZOM4gIV146PCh17ggbUEAAYAiAAEgIBxvD_BwE:G:s&network=g&campaignid=1451653659&adgroupid=60153746327&keyword=personal%20loan%20emi%20calculator&matchtype=e&placement=&device=c&creative=345156838071&adposition=1t2&targetid=kwd-365071425757&random=156259996456778433&&gclid=EAIaIQobChMItNmr2ZOM4gIV146PCh17ggbUEAAYAiAAEgIBxvD_BwE");
		
		WebElement sliderHead = driver.findElement(By.xpath("//div[@id='loan_amount']//div[contains(@class,'my-handle')]"));
		
		//create Actions class object
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(sliderHead, -100, 0).build().perform();
		
		sleep(3);
		closeBrowser();
		
	}

}
