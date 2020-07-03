/* Test Case id: RETC_032
 * Test Case Severity: Medium
 * Test Case Description: To verify whether application allows customer to view, enquire & calculate loan on New launches
 * Pre Condition: user should have launched the application by entering valid URL
                  admin should be logged in
 * Last Updated: 07/02/2020
 */

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.NewLaunchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class NewLaunchTests {

	private WebDriver driver;
	private String NewbaseURL;
	private NewLaunchPOM newLaunchPOM;
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
		newLaunchPOM = new NewLaunchPOM(driver); 
		NewbaseURL = properties.getProperty("NewbaseURL");
		screenShot = new ScreenShot(driver); 
		// launch Chrome and direct it to the Base URL
		driver.get(NewbaseURL);

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validNewLaunchTest() throws Exception {
		newLaunchPOM.MouseoverNewLaunchTab();
		Thread.sleep(1000);
		newLaunchPOM.NewLaunchSelection();
		newLaunchPOM.sendyournametxt("selenium");
		newLaunchPOM.sendyoursubjecttxt("apartment");
		newLaunchPOM.sendyouremailtxt("selenium@gmail.com");
		newLaunchPOM.sendyourmessagetxt("looking for apartment");
		newLaunchPOM.Clicksendbtn();
		
		try 
		{
   	    Boolean ActualResult_ThankyouMsg=newLaunchPOM.ValidateThankyouMsg();
   	    Assert.assertTrue(ActualResult_ThankyouMsg);// To validate ThankyouMsg
		}
		catch (NoSuchElementException e)
		{
			boolean ThankyouMsg=false;
	   	    Assert.assertFalse(ThankyouMsg);// when unable to validate ThankyouMsg
		}
   	    newLaunchPOM.sendamountxt("40000");
   	    newLaunchPOM.senddownpaymenttxt("2000");
   	    newLaunchPOM.sendyearstxt("2");
   	    newLaunchPOM.sendinteresttxt("5");
   	    newLaunchPOM.Clickcalculatebtn();
   	    
   	   Boolean ActualResult_monthlypayment=newLaunchPOM.Validatemonthlypayment();
  	    Assert.assertTrue(ActualResult_monthlypayment);  // To validate monthlypayment
	    }
	 
}
