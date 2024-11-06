package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import baseClass.BaseClass;
import utility.LogUtils;
//import utility.LogUtils;

public class LoginPageValidation extends BaseClass {

	public LoginPageValidation() {
		super();
	}
	
	
	@Test(groups = {"Regression"})
	private void errorMessageValidation() {
		invokeBrowser();
		driver.get("https://www.royallondon.com/");
		LogUtils.info("Url Opened");
		
		

	}
	
//	@Test(dataProvider = "getdata")
//	private void errorMessageValidation1(String name, String passward ) {
//		driver.findElement(null);
//
//	}
//
//	
//	@DataProvider
//	public Object[][]getdata(){
//		
//		//here we call method from base class
//		return null;
//		
//	}
	
	

}
