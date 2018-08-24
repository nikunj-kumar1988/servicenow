package com.atos.servicenow;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atos.servicenow.base.TestBase;
import com.atos.servicenow.pages.HomePage;
import com.atos.servicenow.pages.LoginPage;
import com.atos.servicenow.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	// ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		// contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,
				"BCA Dashboard | ServiceNow IT Service Management Suite - IT-Guardian Development");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Boolean usernameDispalyed = homePage.verifyUsernameDisplayed();
		Assert.assertTrue(usernameDispalyed);
	}

	@Test(priority = 3)
	public void clickOnCreateNewCall() {
		homePage.clickCreateNewCall();
		
		
	}

	/*
	 * @Test(priority = 3) public void verifyContactsLinkTest() {
	 * testUtil.switchToFrame(); contactsPage = homePage.clickOnContactsLink(); }
	 */

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
