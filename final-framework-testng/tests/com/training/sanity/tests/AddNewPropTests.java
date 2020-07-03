/* Test Case id: RETC_031
 * Test Case Severity: Meidum
 * Test Case Description: To verify whether application allows admin to add new property with all details
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
import com.training.pom.AddNewPropPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewPropTests {

	private WebDriver driver;
	private String baseUrl;
	private AddNewPropPOM addNewPropPOM;
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
		addNewPropPOM = new AddNewPropPOM(driver); 
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
	public void validAddNewProp() throws Exception {
		addNewPropPOM.clickLoginRegister();
		String Userlogin ="admin";
		addNewPropPOM.sendUser_login(Userlogin);
		
		String Userpass="admin@123";
		addNewPropPOM.sendUser_pass(Userpass);
		
		addNewPropPOM.clickLoginBtn();
		
		addNewPropPOM.ClickProptiesOpt();
		Boolean ActualResult_AddNewLink=addNewPropPOM.ValidateAddNewLink(); 
   	    Assert.assertTrue(ActualResult_AddNewLink);// To validate AddNewLink
   	    Boolean ActualResult_AllPropertiesLink=addNewPropPOM.ValidateAllPropertiesLink(); 
   	    Assert.assertTrue(ActualResult_AllPropertiesLink);// To validate AllPropertiesLink
   	    addNewPropPOM.ClickAddNewLink();
   	    Boolean ActualResult_Addproperty=addNewPropPOM.ValidateAddTitleTxtSenkeys();
   	    Assert.assertTrue(ActualResult_Addproperty);// To validate Addproperty Page
   	    
   	   addNewPropPOM.AddTitleTxtSenkeys("new launch");
   	   addNewPropPOM.PriceAmtTxtSenkeys("5000.00");
   	   addNewPropPOM.PricePerSqtTxtSenkeys("200.00");
   	   
   	   addNewPropPOM.ClickMainDetailsTab();
	   Boolean ActualResult_LocationTxt=addNewPropPOM.ValidateLocationTxt();
   	   Assert.assertTrue(ActualResult_LocationTxt);// To validate ActualResult_LocationTxt
	   Boolean ActualResult_PosessionTxt=addNewPropPOM.ValidatePosessionTxt();
   	   Assert.assertTrue(ActualResult_PosessionTxt);// To validate ActualResult_PosessionTxt
	   Boolean ActualResult_StatusTxt=addNewPropPOM.ValidateStatusTxtSenkeys();
   	   Assert.assertTrue(ActualResult_StatusTxt);// To validate ActualResult_LocationTxt
   	   
   	   addNewPropPOM.StatusTxtSenkeys("New");
   	   addNewPropPOM.LocationTxtSenkeys("Electronic city");
   	   addNewPropPOM.PosessionTxtSenkeys("immediate");
   	   
   	   addNewPropPOM.ClickLocationTab();
   	   Boolean ActualResult_LatitudeTxt=addNewPropPOM.ValidateLatitudeTxt();
   	   Assert.assertTrue(ActualResult_LatitudeTxt);// To validate LatitudeTxt
	   Boolean ActualResult_AddressTxt=addNewPropPOM.ValidateAddressTxt();
   	   Assert.assertTrue(ActualResult_AddressTxt);// To validate AddressTxt
	   Boolean ActualResult_LongitudeTxt=addNewPropPOM.ValidateLongitudeTxt();
   	   Assert.assertTrue(ActualResult_LongitudeTxt);// To validate LongitudeTxt
   	   
   	   addNewPropPOM.AddressTxtSenkeys("yeshwanthapur");
   	   addNewPropPOM.GoogleMapsAddTxtSenkeys("yeshwanthapur");
   	   addNewPropPOM.LatitudeTxtSenkeys("120");
   	   addNewPropPOM.LongitudeTxtSenkeys("56");
   	   
   	   addNewPropPOM.ClickDetailsTab();
  	   Boolean ActualResult_StorageRoomTxt=addNewPropPOM.ValidateStorageRoomTxt();
   	   Assert.assertTrue(ActualResult_StorageRoomTxt);// To validate StorageRoomTxt
   	   
   	   addNewPropPOM.StorageRoomTxtSenkeys("2");
       addNewPropPOM.ClickPublishBtn();
   	   
       Boolean ActualResult_ViewPostMsg=addNewPropPOM.ValidateViewPostMsg();
   	   Assert.assertTrue(ActualResult_ViewPostMsg);// To validate ViewPostMsg after publishing
   	  screenShot.captureScreenShot("PostMsgscreen");
	    }
	 
}
