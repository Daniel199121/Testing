package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;		



public class CorrectUrl {		
	    WebDriver driver;		
	    String URL = "https://www.wp.pl";
	    
	    
		@Test				
		public void testEasy() {	
			
			
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Wirtualna Polska - Wszystko co wa¿ne - www.wp.pl")); 		
		}	
		@BeforeTest
		public void beforeTest() {	
			System.setProperty("webdriver.gecko.driver", "C://Users/danie/Desktop/geckodriver.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
		    driver = new FirefoxDriver(); 
		    driver.get(URL);  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	