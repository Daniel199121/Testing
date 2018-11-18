package tests;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.EmailLoginPage;
import pages.MainPage;		



public class LoginFailed_EmptyValues {		
	    private WebDriver driver;		
	    private String URL = "http://www.wp.pl";
	    MainPage mainpage;
	    EmailLoginPage emailpage;
	    
		@Test				
		public void testEasy() throws FileNotFoundException {	
			
			driver.get(URL);
			
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[3]/button[2]")).click();
			 
			WebElement ele = driver.findElement(By.xpath("//div[@id='root']/div/div[4]//a[@href='https://poczta.wp.pl']"));
			 
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			 			
			WebDriverWait wait2 = new WebDriverWait(driver, 10);
			wait2.until(ExpectedConditions.elementToBeClickable(By.className("txt")));
			
			emailpage = new EmailLoginPage(driver);
			emailpage.loginToMail("", "");
			
			
			Assert.assertTrue(driver.getPageSource().contains("Niestety podany login lub has³o jest b³êdne"));
			
		
		}	
		@BeforeTest
		public void beforeTest() {	
			System.setProperty("webdriver.gecko.driver", "C://Users/danie/Desktop/geckodriver.exe");

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
		    driver = new FirefoxDriver();  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	