package mmp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mmp.pages.LoginMySQLDataProvider;
import mmp.pages.LoginPageUtility;


public class LoginMySQLTest {

	WebDriver driver;

	@Test(dataProvider="mysqlDataProvider", dataProviderClass=LoginMySQLDataProvider.class)
	public void logintoApp(String Usernmvalue, String pwdvalue) {
		SoftAssert sa= new SoftAssert();
		boolean result = false;
		LoginPageUtility myObj= new LoginPageUtility(driver);
		myObj.launchBrowser();

		result = myObj.mmpLogin(Usernmvalue, pwdvalue);
		sa.assertTrue(result);

		result= myObj.mmplogout();
		sa.assertTrue(result);

		result=myObj.windowclose();
		sa.assertTrue(result);
		sa.assertAll();

	}

}
