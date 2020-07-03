
/* Test Case id: RETC_031
 * Test Case Severity: Meidum
 * Test Case Description: To verify whether application allows admin to add new property with all details
 * Pre Condition: user should have launched the application by entering valid URL
                  -admin should be logged in
 * Last Updated: 07/02/2020
 */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPropPOM {
private WebDriver driver; 
	
	public AddNewPropPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='right-side-menu-item']//a[@class='sign-in']")
	private WebElement login_register; 
	
	@FindBy(id="user_login")
	private WebElement User_login;
	

	@FindBy(id="user_pass")
	private WebElement User_pass;
	
	@FindBy(name="login")
	private WebElement LoginBtn; 
	
	@FindBy(xpath="//div[contains(text(),'Properties')]")
	private WebElement PropertiesOpt;
	
	@FindBy(xpath="//a[contains(text(),'Add New') and (@class='page-title-action')]")
	private WebElement AddNewBtn;
	
	@FindBy(xpath="//a[contains(text(),'All Properties') and (@class='wp-first-item current')]")
	private WebElement AllPropertiesLink;
	
	@FindBy(xpath="//li[@id='menu-posts-property']/ul/li[3]/a[contains(text(),'Add New')]")
	private WebElement AddNewLink;
	
	@FindBy(xpath="//input[@name='post_title']")
	private WebElement AddTitleTxt;
	
	@FindBy(xpath="//a[@id='ui-id-1']")
	private WebElement PriceTab;
	
	@FindBy(xpath="//textarea[@id='_price']")
	private WebElement PriceAmtTxt;
	
	@FindBy(xpath="//input[@id='_price_per']")
	private WebElement PricePerSqtTxt;
	
	@FindBy(xpath="//a[@id='ui-id-2']")
	private WebElement MainDetailsTab;
	
	@FindBy(name="_status")
	private WebElement StatusTxt;
	
	@FindBy(name="_location")
	private WebElement LocationTxt;
	
	@FindBy(name="_possession")
	private WebElement PosessionTxt;
	
	@FindBy(xpath="//a[@id='ui-id-3']")
	private WebElement LocationTab;
	
	@FindBy(name="_friendly_address")
	private WebElement AddressTxt;
	
	@FindBy(name="_address")
	private WebElement GoogleMapsAddTxt;
		
	@FindBy(name="_geolocation_lat")
	private WebElement LatitudeTxt;
	
	@FindBy(name="_geolocation_long")
	private WebElement LongitudeTxt;
	
	@FindBy(xpath="//a[@id='ui-id-4']")
	private WebElement DetailsTab;
		
	@FindBy(name="_storage_room")
	private WebElement StorageRoomTxt;
	
	@FindBy(name="//input[@name='acf[field_5aa678b4dbea3][]']")
	private WebElement CentralBangaloreChkBx;
	
	//@FindBy(name="publish")
	@FindBy(xpath="//input[@name='publish']")
	private WebElement PublishBtn;
	
	
	@FindBy(xpath="//input[@name='save']")
	private WebElement UpdateBtn;
	
	@FindBy(xpath="//p[contains(text(),'Post published. ')]")
	private WebElement ViewPostMsg;

	 
	
	
	public void clickLoginRegister() {
		this.login_register.click(); 
	}
	
	public void sendUser_login(String Userlogin) {
		this.User_login.clear();
		this.User_login.sendKeys(Userlogin);
	}
	
	public void sendUser_pass(String Userpass) {
		this.User_pass.clear();
		this.User_pass.sendKeys(Userpass);
	}
	public void clickLoginBtn() {
		this.LoginBtn.click(); 
	}

	
	public void ClickProptiesOpt() {
		this.PropertiesOpt.click(); 
	}
	
	public void ClickAddNewBtn() {
		this.AddNewBtn.click(); 
	}  
	
	public Boolean ValidateAllPropertiesLink() {
		return this.AllPropertiesLink.isDisplayed();
	}
	
	public void ClickAllPropertiesLink() {
		this.AllPropertiesLink.click(); 
	}
	
	public void ClickAddNewLink() {
		this.AddNewLink.click(); 
	} 
	
	public Boolean ValidateAddNewLink() {
		return this.AddNewLink.isDisplayed();
	}
	
	
	public void AddTitleTxtSenkeys(String txtAddTitle) {
		this.AddTitleTxt.clear();
		this.AddTitleTxt.sendKeys(txtAddTitle);
	}
	
	public Boolean ValidateAddTitleTxtSenkeys() {
		return this.AddTitleTxt.isDisplayed();
	}
	
	public void ClickPriceTab() {
		this.PriceTab.click(); 
	}
	
	public void PriceAmtTxtSenkeys(String txtPriceAmt) {
		this.PriceAmtTxt.clear();
		this.PriceAmtTxt.sendKeys(txtPriceAmt);
	}
	
	public void PricePerSqtTxtSenkeys(String txtPricePerSqt) {
		this.PricePerSqtTxt.clear();
		this.PricePerSqtTxt.sendKeys(txtPricePerSqt);
	} 
	
	public void ClickMainDetailsTab() {
		this.MainDetailsTab.click(); 
	}
	
	public void StatusTxtSenkeys(String txtStatus) {
		this.StatusTxt.clear();
		this.StatusTxt.sendKeys(txtStatus);
	}  
	
	public Boolean ValidateStatusTxtSenkeys() {
		return this.StatusTxt.isDisplayed();
	}
	
	
	public void LocationTxtSenkeys(String LocationTxt) {
		this.LocationTxt.clear();
		this.LocationTxt.sendKeys(LocationTxt);
	}
	
	public Boolean ValidateLocationTxt() {
		return this.LocationTxt.isDisplayed();
	}
	
	public void PosessionTxtSenkeys(String txtPosession) {
		this.PosessionTxt.clear();
		this.PosessionTxt.sendKeys(txtPosession);
	}
	
	public Boolean ValidatePosessionTxt() {
		return this.PosessionTxt.isDisplayed();
	}
	
	public void ClickLocationTab() {
		this.LocationTab.click(); 
	}
	
	public void AddressTxtSenkeys(String txtAddress) {
		this.AddressTxt.clear();
		this.AddressTxt.sendKeys(txtAddress);
	}
	
	public Boolean ValidateAddressTxt() {
		return this.AddressTxt.isDisplayed();
	}
	
	public void GoogleMapsAddTxtSenkeys(String txtGoogleMapsAdd) {
		this.GoogleMapsAddTxt.clear();
		this.GoogleMapsAddTxt.sendKeys(txtGoogleMapsAdd);
	}
		
	public void LatitudeTxtSenkeys(String txtLatitude){
		this.LatitudeTxt.clear();
		this.LatitudeTxt.sendKeys(txtLatitude);
	}
	
	public Boolean ValidateLatitudeTxt() {
		return this.LatitudeTxt.isDisplayed();
	}
	
	public void LongitudeTxtSenkeys(String txtLongitude) {
		this.LongitudeTxt.clear();
		this.LongitudeTxt.sendKeys(txtLongitude);
	}
	
	public Boolean ValidateLongitudeTxt() {
		return this.LongitudeTxt.isDisplayed();
	}
	
	public void ClickDetailsTab() {
		this.DetailsTab.click(); 
	} 
		
	public void StorageRoomTxtSenkeys(String txtStorageRoom) {
		this.StorageRoomTxt.clear();
		this.StorageRoomTxt.sendKeys(txtStorageRoom);
	} 
	
	public Boolean ValidateStorageRoomTxt() {
		return this.StorageRoomTxt.isDisplayed();
	}
	
	
	
	public void SelectCentralBangaloreChkBx() {
		this.CentralBangaloreChkBx.click();
	}
	public Boolean ValidateViewPostMsg() {
		return this.ViewPostMsg.isDisplayed();
	}
	
	public void ClickPublishBtn() {
		action_publishBtn(PublishBtn);
		//this.PublishBtn.click(); 
		
	}
	
	public void action_publishBtn(WebElement E) {
		Actions a=new Actions(driver);
		a.moveToElement(E).click().build().perform();
	
	}

}
