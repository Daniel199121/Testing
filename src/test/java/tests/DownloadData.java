package tests;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.EmailLoginPage;
import pages.MainPage;
import pages.MoneyPage;
import db.Inserted;

public class DownloadData {		
	    private WebDriver driver;		
	    private String URL = "http://www.wp.pl";
	    int before;
	    int after;
	    MainPage mainpage;
	    EmailLoginPage emailpage;
	    MoneyPage moneypage;
	    Inserted inserted;
	    
		@Test				
		public void testEasy() throws FileNotFoundException {	
			
			driver.get(URL);
			
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[3]/button[2]")).click();
			 
			WebElement ele = driver.findElement(By.xpath("//a[@href='https://www.money.pl']"));
			 
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
		
			WebDriverWait wait2 = new WebDriverWait(driver, 20);
			wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'funt')]/../div[@class='s190rzcf-3 caFXPz']")));
			moneypage = new MoneyPage(driver);
			
			System.out.format("%.6s\n", moneypage.getFRANK()); 
			System.out.format("%.6s\n", moneypage.getFUNT()); 
			System.out.format("%.6s\n", moneypage.getDOLAR()); 
			System.out.format("%.6s\n", moneypage.getEURO()); 
	
			inserted = new Inserted();
			before = inserted.getID();
			LocalDate currentDate = LocalDate.now();
			inserted.insertValue(Date.valueOf(currentDate), String.format("%.6s", moneypage.getEURO()), String.format("%.6s", moneypage.getFRANK()), String.format("%.6s", moneypage.getDOLAR()), String.format("%.6s", moneypage.getFUNT()));
			after = inserted.getID();    
			
			System.out.println("ID przed: " + before + " oraz po: " + after);
			
			AssertJUnit.assertEquals(before, after-1);
	
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