package com.atos.servicenow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atos.servicenow.base.TestBase;
import com.atos.servicenow.pages.ContactsPage;
import com.atos.servicenow.pages.HomePage;
import com.atos.servicenow.pages.LoginPage;
import com.atos.servicenow.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		AssertJUnit.assertEquals(homePageTitle, "CRMPRO", "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		AssertJUnit.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
