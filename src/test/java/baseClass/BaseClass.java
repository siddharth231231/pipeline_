package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import report.ExtentListener;

public class BaseClass {
	
	 public WebDriver driver;
	 private String browser;
	 private String baseUrl;
	
	    
	//here we create method which read excel sheet
	 
    @BeforeMethod
    public void invokeBrowser() {       
        Properties properties = new Properties();
        // Load default properties from globalparam.properties
        try (FileInputStream fileInput = new FileInputStream("Configurations/Config/GlobalData.properties")) {
            properties.load(fileInput);
        } catch (IOException e) {
            System.out.println("Could not load properties file. Using defaults or command-line parameters.");
        }
        
        // Get properties from the file
        browser = properties.getProperty("browser", "chrome");
        baseUrl = properties.getProperty("baseUrl", "https://default-url.com");

        // Override with runtime parameters if provided
        browser = System.getProperty("browser", browser);
        baseUrl = System.getProperty("baseUrl", baseUrl);
        
        // Initialize WebDriver based on the browser property
        if (browser.equalsIgnoreCase("chrome")) {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        driver.get(baseUrl);
	        
	        
        } else if (browser.equalsIgnoreCase("firefox")) {
        	 WebDriverManager.firefoxdriver().setup();
        	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        	 driver = new FirefoxDriver();
        	 driver.get(baseUrl);
        	 //
        	 
        }

	    }
    
    @AfterMethod
    public void closeBrowser() {
    	driver.close();
    	
    }
    

}
