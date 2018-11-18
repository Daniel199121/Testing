package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {		
	    
	WebDriver driver;
	@FindBy(xpath="/html/body/div[4]/div/div[4]/div[1]/div[3]/a[1]")
	WebElement email;
	
	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void goToMail() {
		email.click();
	}
	
}	