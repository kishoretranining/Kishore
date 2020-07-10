/* Test Case id: RETC_063
 * Test Case Description: To Verify whether application allows registered user to login into application
 * Pre Condition: user should have launched the application by entering valid URL
                  user should register by entering valid credentials
 * Last Updated: 07/10/2020
 */

package com.training.regression.tests;

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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegistersExcelInvalidScenario {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
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
	@Test(dataProvider = "excel-invalidinputs", dataProviderClass = LoginDataProviders.class)
	public void validLoginTest(String Userlogin, String Userpass) throws Exception {
		loginPOM.clickLoginRegister();
		loginPOM.sendUser_login(Userlogin);
		WebElement UserName=driver.findElement(By.id("user_login"));
		String Actual_UserName =UserName.getAttribute("value");//Fetching Entered credentials in Email
        Assert.assertEquals(Actual_UserName, Userlogin);//To Validate Email id	
        
 
        loginPOM.sendUser_pass(Userpass);
		WebElement UserPassword=driver.findElement(By.id("user_pass"));//Fetching Entered credentials in User name
		String Actual_UserPassword =UserPassword.getAttribute("value");//To Validate Password	-
        Assert.assertEquals(Actual_UserPassword, Userpass);
        		
        loginPOM.clickLoginBtn();
   	    Boolean ActualResult_value=loginPOM.InvalidregisterMsg(); 
   	    Assert.assertTrue(ActualResult_value);// To validate when user entered invalid data
   	    screenShot.captureScreenShot("First");
	    }
}
