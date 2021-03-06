
/* Test Case id: RETC-003
 * Test Case Description: To verify whether application allows the user to recover the password
 * Pre Condition: user should have launched the application by entering valid URL
                  user should register by entering valid credentials
 * Last Updated: 07/01/2020-
 */

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.RecoverPwdPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RecoverPwdTests {

	private WebDriver driver;
	private String baseUrl;
	private RecoverPwdPOM recoverPwdPOM;
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
		// declaration and instantiation of objects/variables
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		recoverPwdPOM = new RecoverPwdPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// launch Chrome and direct it to the Base URL 
		driver.get(baseUrl);

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validRecoverpwd() throws Exception {
		recoverPwdPOM.clickLoginRegister();
		recoverPwdPOM.clickLostyourpwd();
		String Email="manzoor@gmail.com";
		recoverPwdPOM.sendEmail(Email);
		WebElement TEmail=driver.findElement(By.id("user_login"));
		String Actual_TEmail =TEmail.getAttribute("value");//Fetching Entered credentials in Email
        Assert.assertEquals(Actual_TEmail, Email);//To Validate Email id
    	recoverPwdPOM.ClickResetPasswordBtn();
    	
	    Boolean ActualResult_value=recoverPwdPOM.ActualResult(); 
   	    Assert.assertTrue(ActualResult_value);// to validate A confirmation link has been sent to your email address text
        screenShot.captureScreenShot("First");
    
		}
}