package baseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import report.ExtentListener;

public class BaseClass {
	
	 public WebDriver driver;
	
	    
	//here we create method which read excel sheet
	 
    @BeforeMethod
    public void invokeBrowser() {
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	       

	    }
    
    @AfterMethod
    public void closeBrowser() {
    	driver.close();
    	
    }
    

}
