package mmp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mmp.pages.LoginExcelXlsxDataProvider;
import mmp.pages.LoginPageUtility;
 

public class LoginExcelXlsxTest {
	  WebDriver driver;
	  
	  	@Test(dataProvider= "excelxlsxRead", dataProviderClass=LoginExcelXlsxDataProvider.class)
	  	public void logintoapp(String Username,String password) {
		   boolean result=false;
		   SoftAssert sa= new SoftAssert();
		   
		   LoginPageUtility myObject= new LoginPageUtility(driver);
		   myObject.launchBrowser();
		   result = myObject.mmpLogin(Username, password);
		   sa.assertTrue(result);
		   
		   result = myObject.mmplogout();
		   sa.assertTrue(result);
		   
		   result = myObject.windowclose();
		   sa.assertTrue(result);
		   
		   sa.assertAll();
		  
		
	  }
}
