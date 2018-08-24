package com.atos.servicenow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.atos.servicenow.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "html/body/div[1]/div/div/header/div[1]/div/div[1]/a")
	WebElement nokiaLogo;

	@FindBy(xpath = ".//*[@id='user_info_dropdown']/div/span[1]")
	WebElement loggedInUSerName;

	@FindBy(xpath = "//*[@id='filter']")
	@CacheLookup
	WebElement filterNavigator;

	@FindBy(linkText = ".//*[@id='e32a4f3e95df940094fc2cd59bc40653']/div[1]/div")
	WebElement createNewCallLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyUsernameDisplayed() {
		return loggedInUSerName.isDisplayed();
	}

	public void clickCreateNewCall() {
		createNewCallLink.click();
	}
	
	
	
	

	/*
	 * public ContactsPage clickOnContactsLink(){ contactsLink.click(); return new
	 * ContactsPage(); }
	 * 
	 * public DealsPage clickOnDealsLink(){ dealsLink.click(); return new
	 * DealsPage(); }
	 * 
	 * public TasksPage clickOnTasksLink(){ tasksLink.click(); return new
	 * TasksPage(); }
	 * 
	 * public void clickOnNewContactLink(){ Actions action = new Actions(driver);
	 * action.moveToElement(contactsLink).build().perform(); newContactLink.click();
	 */

}
