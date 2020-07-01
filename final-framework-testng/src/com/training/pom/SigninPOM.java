package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPOM {
	private WebDriver driver; 
	
	public SigninPOM(WebDriver driver) {
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
	
}
