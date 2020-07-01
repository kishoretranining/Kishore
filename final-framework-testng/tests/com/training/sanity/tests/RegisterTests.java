
/* Test Case id: RETC_001
 * Test Case Description: To verify whether application allows the user to get registered upon entering valid credentials
 * Pre Condition: user should have launched the application by entering valid URL
 * Last Updated: 07/01/2020
 */
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
		// declaration and instantiation of objects/variables
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		registerPOM = new RegisterPOM(driver); 
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
	public void validRegisterTest() throws Exception {
		registerPOM.clickLoginRegister();// To display registration screen 
		registerPOM.clickRegTab();
		String Email="testt.teest@gmail.com";
		registerPOM.sendEmail(Email);
	
        String TFname="Kumarre";
		registerPOM.sendFirstname(TFname);
		WebElement Fname=driver.findElement(By.id("first-name"));
		String Actual_Fname =Fname.getAttribute("value");//Pulling Entered credentials in First name
        Assert.assertEquals(Actual_Fname, TFname);//To Validate First name
        
        String TLname="M";
        registerPOM.sendLastname(TLname);
		WebElement Tlname=driver.findElement(By.id("last-name"));
		String Actual_Lname =Tlname.getAttribute("value");//Pulling Entered credentials in Last name
        Assert.assertEquals(Actual_Lname, TLname);//To Validate Last name
        		
		registerPOM.clickRegisterBtn();
   	    Boolean ActualResult_value=registerPOM.ActualResult(); 
   	    Assert.assertTrue(ActualResult_value);// To validate msg You have successfully registered to Real Estate
        screenShot.captureScreenShot("First");
	}
}
