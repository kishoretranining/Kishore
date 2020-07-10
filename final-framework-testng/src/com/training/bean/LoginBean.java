package com.training.bean;

public class LoginBean {
	private String email;
	private String fname;
	private String lname;

	public LoginBean() {
	}

	public LoginBean(String Email, String FName ,String LName) {
		super();
		this.email = Email;
		this.fname = FName;
		this.lname = LName;
		
	}

	public void setEmail(String Email) {
		this.email = Email;
	}

	public String getEmail() {
        return email;
    }
			
	public void setFname(String FName) {
		this.fname = FName;
	}
	
	public String getFname() {
        return fname;
    }

	public void setLName(String LName) {
		this.lname = LName;
	}
	
	public String getLname() {
        return lname;
    }
	
	@Override
	public String toString() {
		return "LoginBean [Email=" + email + ", FName=" + fname + ", LName=" + lname + "]";
	}

}
