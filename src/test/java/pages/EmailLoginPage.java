package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailLoginPage {		
	    
	WebDriver driver;
	
	@FindBy(name="login_username")
	WebElement user_name;

	@FindBy(name="password")
	WebElement user_password;	
	
	@FindBy(id="btnSubmit")
	WebElement login;
	
	public EmailLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void clickLogin() {
		login.click();
	}
	
	public void setPassword(String strPassword){

		user_password.clear();
	    user_password.sendKeys(strPassword);
	}
	
	public void setUserName(String strName){
		
		user_name.clear();
	    user_name.sendKeys(strName);

	}
	
	public void loginToMail(String strUserName,String strPassword){

        this.setUserName(strUserName);

        this.setPassword(strPassword);

        this.clickLogin();
               
    }	
}	