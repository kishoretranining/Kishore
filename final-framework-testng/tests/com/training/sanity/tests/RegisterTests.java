package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterTests {

	private WebDriver driver;
	private String baseUrl;
	private RegisterPOM registerPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validRegisterTest() throws Exception {
		registerPOM.clickLoginRegister();
		registerPOM.clickRegTab();
		String Email="kishore.marri@gmail.com";
		registerPOM.sendEmail(Email);
	
        
        String TFname="Kumar";
		registerPOM.sendFirstname(TFname);
		WebElement Fname=driver.findElement(By.id("first-name"));
		String Actual_Fname =Fname.getAttribute("value");
        Assert.assertEquals(Actual_Fname, TFname);
        
        String TLname="M";
        registerPOM.sendLastname(TLname);
		WebElement Tlname=driver.findElement(By.id("last-name"));
		String Actual_Lname =Tlname.getAttribute("value");
        Assert.assertEquals(Actual_Lname, TLname);
        		
		registerPOM.clickRegisterBtn();
		Boolean Display=driver.findElement(By.xpath("//p[contains(text(),'You have successfully registered to')]")).isDisplayed();
		 if (Display) {
			 System.out.println("Registered successfully.");
		 }
	screenShot.captureScreenShot("First");
	}
}
