package mmp.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mmp.pages.LoginPageUtility;



public class LoginPropertyfileTest {
	WebDriver driver;
	public Properties prop;
	
	@Test
	public void loginWithPropertyfile() throws Exception {
	   prop = new Properties();
	   File src= new File(".\\properties\\Global.properties");
	   FileInputStream fis= new FileInputStream(src);
	   prop.load(fis);
	   String userValue = prop.getProperty("user");
	   String passwordValue = prop.getProperty("password");
	   
	   System.out.println(userValue + " " + passwordValue );
	   
		SoftAssert sa= new SoftAssert();
		boolean result = false;
		LoginPageUtility myObj= new LoginPageUtility(driver);
		myObj.launchBrowser();

		result = myObj.mmpLogin(userValue, passwordValue);
		sa.assertTrue(result);

		result= myObj.mmplogout();
		sa.assertTrue(result);

		result=myObj.windowclose();
		sa.assertTrue(result);
		sa.assertAll();
	   
	}
	

}
