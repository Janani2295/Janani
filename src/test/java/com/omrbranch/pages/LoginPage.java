package com.omrbranch.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.omrbranch.baseclass.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id = "email")
	private WebElement txtEmail;
	
	@FindBy(id = "pass")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btnLogin;
	
	
	
	//@FindBy(xpath = "//a[@data-testid='username']")
		@FindBy(xpath = "//a[contains(text(),'Welcome')]")
		private WebElement expLoginSuccessMessage;
	
	
	
	

        
         public void login(String userName,String password) {
        	 
        	 elementSendKeys(txtEmail, userName);
        	 elementSendKeys(txtPassword, password);
        	 elementClick(btnLogin);
		}
         
         public String loginMessage() {
     		String text = elementGetText(expLoginSuccessMessage);
     		return text;
     		
     	}
         
        
         
        
        
       
         
         
         
         
         
         

	
	

}
