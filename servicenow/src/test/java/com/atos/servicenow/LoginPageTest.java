package com.atos.servicenow;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.atos.servicenow.base.TestBase;
import com.atos.servicenow.pages.HomePage;
import com.atos.servicenow.pages.LoginPage;
/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	//ExtentReports extent;
	//ExtentTest test;

	public LoginPageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initialization();
		//extent = new ExtentReports();
		//test = extent.createTest("LoginPageTest");
		loginPage = new LoginPage();
		//test.log(Status.INFO, MarkupHelper.createLabel("Setup is Done", ExtentColor.YELLOW));
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		//extent = getExtent();
		//test = extent.createTest("LoginPage Test ","XXXXX");
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "ServiceNow IT Service Management Suite - IT-Guardian Development...");
		//test.log(Status.PASS, MarkupHelper.createLabel("loginPageTitleTest is OK", ExtentColor.GREEN));
		
	}

	/*@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}*/

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//test = extent.createTest("LoginTest");
		//test.log(Status.PASS, MarkupHelper.createLabel("Login is OK", ExtentColor.GREEN));
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
		//test = extent.createTest("Browser Closed");
		//flushExtentReference();
		//test.log(Status.PASS, MarkupHelper.createLabel("Login is OK", ExtentColor.GREEN));
	}

}
