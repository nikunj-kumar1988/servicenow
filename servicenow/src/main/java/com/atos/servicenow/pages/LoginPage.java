package com.atos.servicenow.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atos.servicenow.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="user_name")
	WebElement username;
	
	@FindBy(id="user_password")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='remembermeoption']/span/label")
	WebElement rememberMe;
	
	@FindBy(id="sysverb_login")
	WebElement loginButton;
	
	@FindBy(linkText="Forgot Password ?")
	WebElement forgotPassword;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	/*public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}*/
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginButton);
		    	
		    	
		    
		
		return new HomePage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
