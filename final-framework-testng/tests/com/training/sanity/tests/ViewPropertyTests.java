/* Test Case id: RETC_033
 * Test Case Severity: Meidum
 * Test Case Description: TO verify whether application allows admin to view added property details in All Properties window
 * Pre Condition: user should have launched the application by entering valid URL
                  admin should be logged in
 * Last Updated: 07/02/2020
 */

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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
import com.training.pom.ViewPropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewPropertyTests {

	private WebDriver driver;
	private String baseUrl;
	private ViewPropertyPOM viewPropertyPOM;
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
		viewPropertyPOM = new ViewPropertyPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// launch Chrome and direct it to the Base URL
		driver.get(baseUrl);

	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	@Test
	public void validViewProperty() throws Exception {
		viewPropertyPOM.clickLoginRegister();
		String Userlogin ="admin";
		viewPropertyPOM.sendUser_login(Userlogin);
		
		String Userpass="admin@123";
		viewPropertyPOM.sendUser_pass(Userpass);
		
		viewPropertyPOM.clickLoginBtn();
		
		viewPropertyPOM.ClickProptiesOpt();
		Boolean ActualResult_AddNewLink=viewPropertyPOM.ValidateAddNewLink(); 
   	    Assert.assertTrue(ActualResult_AddNewLink);// To validate AddNewLink
   	    Boolean ActualResult_AllPropertiesLink=viewPropertyPOM.ValidateAllPropertiesLink(); 
   	    Assert.assertTrue(ActualResult_AllPropertiesLink);// To validate AllPropertiesLink
   	    viewPropertyPOM.ClickAddNewLink();
   	    Boolean ActualResult_Addproperty=viewPropertyPOM.ValidateAddTitleTxtSenkeys();
   	    Assert.assertTrue(ActualResult_Addproperty);// To validate Addproperty Page
   	    
   	   viewPropertyPOM.AddTitleTxtSenkeys("new launch");
   	  
   	   viewPropertyPOM.ClickPublishBtn();
   	   
       Boolean ActualResult_ViewPostMsg=viewPropertyPOM.ValidateViewPostMsg();
   	   Assert.assertTrue(ActualResult_ViewPostMsg);// To validate ViewPostMsg after publishing
   	   screenShot.captureScreenShot("PostMsgscreen");
   	   viewPropertyPOM.ClickAllPropertiesLink();
   	   Boolean Actual_Addbutton=viewPropertyPOM.ValidateAddNewBtn();
   	   Assert.assertTrue(Actual_Addbutton);// To validate Add button on Page
   	  
	    }
	 
}
