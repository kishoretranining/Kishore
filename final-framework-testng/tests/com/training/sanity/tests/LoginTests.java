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
import com.training.pom.SigninPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private SigninPOM signinPOM;
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
		signinPOM = new SigninPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validLoginTest() throws Exception {
		signinPOM.clickLoginRegister();
		String Userlogin ="manzoor@gmail.com";
		signinPOM.sendUser_login(Userlogin);
		WebElement UserName=driver.findElement(By.id("user_login"));
		String Actual_UserName =UserName.getAttribute("value");
        Assert.assertEquals(Actual_UserName, Userlogin);
	
        
        String Userpass="manzoor";
        signinPOM.sendUser_pass(Userpass);
		WebElement UserPassword=driver.findElement(By.id("user_pass"));
		String Actual_UserPassword =UserPassword.getAttribute("value");
        Assert.assertEquals(Actual_UserPassword, Userpass);
        		
        signinPOM.clickLoginBtn();
		Boolean Display=driver.findElement(By.xpath("//h2[contains(text(),'My Profile')]")).isDisplayed();
		 if (Display) {
			 System.out.println("Profile Page Disaplyed");
		 }
	screenShot.captureScreenShot("First");
	}
}
