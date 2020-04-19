package mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadUtility{
	WebDriver driver;

	
	@Test
	public void FileUploadTest() throws Exception {
		// Open login browser
		// Test for reverting commit iD
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver() ;
		 driver.manage().window().maximize();
		 System.out.println("maximize window");
		

		String url = "http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php";
		driver.get(url);

		System.out.println("URL of the page :"+driver.getCurrentUrl());

		String title =driver.getTitle();
		System.out.println("Title of the page:"+title);

		//Login with admin credentials 
		String userName= "//input[@id='username']";
		String password ="//input[@id='password']";

		WebElement userid=driver.findElement(By.xpath(userName));
		userid.sendKeys("Thomas_444");

		WebElement pwd=driver.findElement(By.xpath(password));
		pwd.sendKeys("Edison_444");

		driver.findElement(By.xpath("//input[@type='submit']")).click();


		//click on Patient link
		driver.findElement(By.xpath("//a[@href='patients.php']")).click();

		//Enter Patient SSN and click on search

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("008976661");
		driver.findElement(By.xpath("//input[@value='search']")).click();


		// Click on patient name 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Ruby')]")).click();
		//driver.findElement(By.xpath("//table//a[@href='patientapp.php?pid=4426']")).click();
		System.out.println("Clicked on patient name");

		//Click on Reports
		Thread.sleep(3000);
       driver.findElement(By.xpath("//input[@value='Reports']")).click();
       System.out.println("clicked on report tab");

		//Robot use


	}	

}
