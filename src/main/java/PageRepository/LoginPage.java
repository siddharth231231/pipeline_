package PageRepository;

import org.openqa.selenium.WebDriver;

import utility.AbstractComponent;

public class LoginPage extends AbstractComponent {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		
	}

}
