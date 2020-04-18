package mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginPageUtility {

	WebDriver driver;

	//added constructor 
	// fix master and branch issue
	public LoginPageUtility(WebDriver mydriver) {
		this.driver = mydriver;

	}

	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Maximize the window");

		String url= "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php";
		driver.get(url);
		System.out.println("url of the page:"+driver.getCurrentUrl());

		//validate title of website
		String title =  driver.getTitle();
		System.out.println("Title of page :"+ title); 

	}

	public boolean mmpLogin(String Usernamevalue, String passwordvalue) {

		String username ="//input[@name='username']";
		WebElement usernameXpath= driver.findElement(By.xpath(username));
		usernameXpath.sendKeys(Usernamevalue);
		System.out.println("Login: Username entered");

		String password ="//input[@name='password']";
		WebElement pswordXpath = driver.findElement(By.xpath(password));
		pswordXpath.sendKeys(passwordvalue);
		System.out.println("Login: Password entered");

		String signinXpath= "//input[@value='Sign In' and @type='submit']";
		WebElement signIn = driver.findElement(By.xpath(signinXpath));
		signIn.click();
		System.out.println("Login: Successful");

		boolean result =true;
		return result;

	}
	//Validate patient login logo
	public boolean validatelogo() {
		
		boolean result=false;
		String logoXpath= "//form/span[contains(text(),'Patient Login')]";
		if(driver.findElement(By.xpath(logoXpath)).isDisplayed()) {
			result=true;
			System.out.println("Patient loginlogo is displaying");	
		}
		else 
		{
			System.out.println("Patient loginlogo is not displaying");
		}
		return result;
	}
        
	public boolean validateInvalidLogin() throws Exception {
		boolean result=false;

		String expectedText= "Wrong username and password.";
		String actualText= driver.switchTo().alert().getText().trim();
		driver.switchTo().alert().accept();

		System.out.println("displaying text:" + actualText);
		
		//validation for popup text
		if(actualText.equalsIgnoreCase(expectedText))
		{
			result=true;
			System.out.println("actual text and expected text are matching");
		}
		else {
			result=false;
			System.out.println("actual text and expected text are not matching");

		}
		return result;
	}


	public boolean mmplogout() {

		driver.findElement(By.xpath("//a[@class='dropdown' and @href='logout.php']")).click();
		System.out.println("logout: successful");
		boolean result=true;
		return result;
	}

	public boolean windowclose()
	{       
		driver.close();
		System.out.println("browser closed");
		boolean result= true;
		return result;

	}

}
