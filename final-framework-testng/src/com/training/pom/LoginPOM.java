/* Test Case id: RETC_002
 * Test Case Description: To Verify whether application allows registered user to login into application
 * Pre Condition: user should have launched the application by entering valid URL
                  user should register by entering valid credentials
 * Last Updated: 07/01/2020
 */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
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
	
	@FindBy(xpath="//h2[contains(text(),'My Profile')]")
	private WebElement registerMsg;
	
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
	
	public Boolean ActualResult() {
		return this.registerMsg.isDisplayed();
	}
	
}
