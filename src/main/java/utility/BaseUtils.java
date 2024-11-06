package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BaseUtils {
	
	 protected WebDriver driver;
	    protected WebDriverWait wait;

	    // -------------------- WebDriver Setup and Teardown --------------------
	    
	    public void initializeDriver(String browserType) {
	        // Set up WebDriver based on browserType (Chrome, Firefox, etc.)
	        // Example: driver = new ChromeDriver(); or driver = new FirefoxDriver();
	        // You could use a DriverManager utility here for more flexibility
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds (10));
	        driver.manage().window().maximize();
	    }

	    public void quitDriver() {
	        if (driver != null) {
	            driver.close();
	        }
	    }

	    // -------------------- Navigation Helpers --------------------
	    
	    public void navigateToUrl(String url) {
	        driver.get(url);
	    }

	    public String getCurrentUrl() {
	        return driver.getCurrentUrl();
	    }

	    public void refreshPage() {
	        driver.navigate().refresh();
	    }

	    public void closeCurrentWindow() {
	        driver.close();
	    }

	    // -------------------- Basic Waits --------------------

//	    public void waitForPageToLoad(int timeoutInSeconds) {
//	        // WebDriverWait for page load; can be further enhanced with ExpectedConditions
//	        wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//	        wait().until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
//	    }

	    // -------------------- Basic Element Interactions --------------------

	    public void clickElement(WebElement element) {
	        element.click();
	    }

	    public void enterText(WebElement element, String text) {
	        element.clear();
	        element.sendKeys(text);
	    }

	    public String getElementText(WebElement element) {
	        return element.getText();
	    }

	    public String getElementAttribute(WebElement element, String attributeName) {
	        return element.getAttribute(attributeName);
	    }

	    // -------------------- Alert Handling --------------------
	    
	    public void acceptAlert() {
	        driver.switchTo().alert().accept();
	    }

	    public void dismissAlert() {
	        driver.switchTo().alert().dismiss();
	    }

	    public String getAlertText() {
	        return driver.switchTo().alert().getText();
	    }

	    // -------------------- Window Management --------------------

	    public void switchToWindow(String windowTitle) {
	        for (String handle : driver.getWindowHandles()) {
	            driver.switchTo().window(handle);
	            if (driver.getTitle().equals(windowTitle)) {
	                break;
	            }
	        }
	    }

}
