package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPropertyPOM {
	
private WebDriver driver; 
	
	public AddNewPropertyPOM(WebDriver driver) {
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

	

}
