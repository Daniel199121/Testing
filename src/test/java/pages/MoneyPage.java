package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyPage {		
	    
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(),'euro')]/../div[@class='s190rzcf-3 caFXPz']")
	WebElement EUR;

	@FindBy(xpath="//div[contains(text(),'frank')]/../div[@class='s190rzcf-3 caFXPz']")
	WebElement FRANK;	
	
	@FindBy(xpath="//div[contains(text(),'dolar')]/../div[@class='s190rzcf-3 caFXPz']")
	WebElement DOLAR;
	
	@FindBy(xpath="//div[contains(text(),'funt')]/../div[@class='s190rzcf-3 caFXPz']")
	WebElement FUNT;
	
	public MoneyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getEURO() {
		
		return EUR.getText().replaceAll(",",".");
	}
	
	public String getFRANK() {
			
		return	FRANK.getText().replaceAll(",",".");
		}
		
	public String getDOLAR() {
		
		return DOLAR.getText().replaceAll(",",".");
	}
	
	public String getFUNT() {
		return FUNT.getText().replaceAll(",",".");
	}

	
}	