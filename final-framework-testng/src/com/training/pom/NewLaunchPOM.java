/* Test Case id: RETC_032
 * Test Case Severity: Medium
 * Test Case Description: To verify whether application allows customer to view, enquire & calculate loan on New launches
 * Pre Condition: user should have launched the application by entering valid URL
                  admin should be logged in
 * Last Updated: 07/02/2020
 */

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchPOM {
private WebDriver driver; 
	
	public NewLaunchPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//li[@id='menu-item-354']/a[contains(text(),'New Launch')]")
	private WebElement NewLaunchTab;
	
	@FindBy(xpath="//div[@class='wpmm-post post-4505']/div/a/img[@class='wp-post-image']")
	private WebElement NewLaunchSelection;
	
	@FindBy(name="your-name")
	private WebElement yournametxt;
	
	@FindBy(name="your-email")
	private WebElement youremailtxt;
	
	@FindBy(name="your-subject")
	private WebElement yoursubjecttxt;
	
	@FindBy(name="your-message")
	private WebElement yourmessagetxt;
	
	@FindBy(xpath="//input[@class='wpcf7-form-control wpcf7-submit']")
	private WebElement sendbtn;		
	
	@FindBy(xpath="//div[contains(text(),'Thanks you for your message. It has been sent message should get displayed')]")
	private WebElement ThankyouMsg;	
	
	@FindBy(name="amount")
	private WebElement amountxt;
	
	@FindBy(id="downpayment")
	private WebElement downpaymenttxt;
	
	@FindBy(id="years")
	private WebElement yearstxt;
	
	@FindBy(id="interest")
	private WebElement interesttxt;
	
	@FindBy(xpath="//button[contains(text(),'Calculate')]")
	private WebElement calculatebtn;
	
	@FindBy(xpath="//strong[contains(text(),'1667.11 Rs.')]")
	private WebElement monthlypayment;
	
	
	public void NewLaunchSelection() {
		this.NewLaunchSelection.click();
	}
	
	public void MouseoverNewLaunchTab() {
		action_publishBtn(NewLaunchTab);
	}
	
	public void action_publishBtn(WebElement E) {
		Actions a=new Actions(driver);
		a.moveToElement(E).build().perform();
	
	}
	
	public void sendyournametxt(String yournametxt) {
		this.yournametxt.clear();
		this.yournametxt.sendKeys(yournametxt);
	}
	
	public void sendyouremailtxt(String youremailtxt) {
		this.youremailtxt.clear();
		this.youremailtxt.sendKeys(youremailtxt);
	}
	
	public void sendyoursubjecttxt(String yoursubjecttxt) {
		this.yoursubjecttxt.clear();
		this.yoursubjecttxt.sendKeys(yoursubjecttxt);
	}
	
	public void sendyourmessagetxt(String yourmessagetxt) {
		this.yourmessagetxt.clear();
		this.yourmessagetxt.sendKeys(yourmessagetxt);
	}

	public void Clicksendbtn() {
		this.sendbtn.click();
	}
	
	public Boolean ValidateThankyouMsg() {
		return this.ThankyouMsg.isDisplayed();
	}
	
	public void sendamountxt(String amountxt) {
		this.amountxt.clear();
		this.amountxt.sendKeys(amountxt);
	} 
	
	public void senddownpaymenttxt(String downpaymenttxt) {
		this.downpaymenttxt.clear();
		this.downpaymenttxt.sendKeys(downpaymenttxt);
	} 
	
	public void sendyearstxt(String yearstxt) {
		this.yearstxt.clear();
		this.yearstxt.sendKeys(yearstxt);
	}
	
	public void sendinteresttxt(String interesttxt) {
		this.interesttxt.clear();
		this.interesttxt.sendKeys(interesttxt);
	}
	
	public void Clickcalculatebtn() {
		this.calculatebtn.click();
	}
	
	public Boolean Validatemonthlypayment() {
		return this.monthlypayment.isDisplayed();
	}
	

}
