
/* Test Case id: RETC-003
 * Test Case Description: To verify whether application allows the user to recover the password
 * Pre Condition: user should have launched the application by entering valid URL
                  user should register by entering valid credentials
 * Last Updated: 07/01/2020
 */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecoverPwdPOM {
private WebDriver driver; 
	
	public RecoverPwdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='right-side-menu-item']//a[@class='sign-in']")
	private WebElement login_register; 
	
	@FindBy(xpath="//a[contains(text(),' Lost Your Password?')]")
	private WebElement lostyourpwd; 
	
	@FindBy(xpath="//input[@id='user_login']")
	private WebElement EmailAddress;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement ResetPasswordBtn;
	
	@FindBy(xpath="//p[contains(text(),'confirmation mail should be sent to registered mail id')]")
	private WebElement registerMsg;

	public void clickLoginRegister() {
		this.login_register.click(); 
	}
	
	public void clickLostyourpwd() {
		this.lostyourpwd.click(); 
	}
	
	public void sendEmail(String email) {
		this.EmailAddress.clear();
		this.EmailAddress.sendKeys(email);
	}
	
	
	
	public void ClickResetPasswordBtn() {
		this.ResetPasswordBtn.click(); 
	}
	
	public Boolean ActualResult() {
		return this.registerMsg.isDisplayed();
	}
}


