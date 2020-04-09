package mmp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mmp.pages.LoginPageUtility;



public class LoginPageTest {
	WebDriver driver;

	@Test 
	public void validateLogin() {
		SoftAssert sa= new SoftAssert();
		LoginPageUtility myObj = new LoginPageUtility(driver);
		myObj.launchBrowser();

		//Validate patient login logo
		

		boolean result1=myObj.validatelogo();
		
		sa.assertTrue(result1);

		//Validation for login method
		String Usernamevalue= "ruby1";
		String passwordvalue= "Ruby@12345";
		boolean result = myObj.mmpLogin(Usernamevalue, passwordvalue);
		sa.assertTrue(result);

		////Validation for logout method
		boolean result2= myObj.mmplogout();
		sa.assertTrue(result2);

		////Validation for browser close method
		boolean result3= myObj.windowclose();
		sa.assertTrue(result3);
		sa.assertAll();

	}


}