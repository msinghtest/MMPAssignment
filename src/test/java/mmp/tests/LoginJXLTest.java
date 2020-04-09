package mmp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mmp.pages.LoginJXLDataProvider;
import mmp.pages.LoginPageUtility;
 

public class LoginJXLTest {
        WebDriver driver;	
	
	@Test(dataProvider= "jxlRead", dataProviderClass=LoginJXLDataProvider.class)
  	public void logintoapp(String Username,String password) {
	   boolean result=false;
	   SoftAssert sa= new SoftAssert();
	   
	   LoginPageUtility myObject= new LoginPageUtility(driver);
	   myObject.launchBrowser();
	   result = myObject.mmpLogin(Username, password);
	   System.out.println("Login result for " + Username + ":" +result);
	   sa.assertTrue(result);
	   
	   result = myObject.mmplogout();
	   System.out.println("Login result for " + Username + ":" +result);
	   sa.assertTrue(result);
	   
	   result = myObject.windowclose();
	   sa.assertTrue(result);
	   
 
	   sa.assertAll();
	  
	
  }
}
