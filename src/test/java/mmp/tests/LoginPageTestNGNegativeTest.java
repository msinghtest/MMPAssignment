package mmp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mmp.pages.LoginPageUtility;

public class LoginPageTestNGNegativeTest {
	WebDriver driver; 
	
    @Parameters({"user","password"})
	@Test
	public void logintoApptest(String Usernm, String password) throws Exception {

		boolean result=false;
		SoftAssert sa= new SoftAssert();

		//Launch Browswer
		LoginPageUtility myObj = new LoginPageUtility(driver);
		myObj.launchBrowser();

		//Login to website
		
		result= myObj.mmpLogin(Usernm,password);
		sa.assertTrue(result);
		
		//Handle popup for invalid login
		result=myObj.validateInvalidLogin(); 
		sa.assertTrue(result);
	
		//close browser
		Thread.sleep(3000);
		result = myObj.windowclose();
		sa.assertTrue(result);
		
		sa.assertAll();
	}






}