/* Test Case id: RETC_001
 * Test Case Description: To verify whether application allows the user to get registered upon entering valid credentials
 * Pre Condition: user should have launched the application by entering valid URL
 * Last Updated: 07/01/2020-
 */
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPOM {
	private WebDriver driver; 
	
	public RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='right-side-menu-item']//a[@class='sign-in']")
	private WebElement login_register; 
	
	@FindBy(xpath="//a[contains(text(),'Register') and @href='#tab2']")
	private WebElement register_Tab; 
	
	@FindBy(id="email")
	private WebElement email;
	

	@FindBy(xpath="//input[@id='first-name']")
	private WebElement firstname; 
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@CLASS='register-button']")
	private WebElement registerBtn;
	
	@FindBy(xpath="//p[contains(text(),'You have successfully registered to')]")
	private WebElement registerMsg;
	
	public void clickLoginRegister() {
		this.login_register.click(); 
	}
	
	public void clickRegTab() {
		this.register_Tab.click(); 
	}
	
	public void clickRegBtn() {
		this.register_Tab.click(); 
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendLastname(String lastname) {
		this.lastname.clear();
		this.lastname.sendKeys(lastname);
	}
	
	public void sendFirstname(String firstname) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);
	}
	
	
	public void clickRegisterBtn() {
		this.registerBtn.click(); 
	}
	
	public Boolean ActualResult() {
		return this.registerMsg.isDisplayed();
	}
	
}
