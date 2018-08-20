package com.atos.servicenow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.bcel.classfile.Utility;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class AppTest {

	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void startReport() throws IOException {
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

		// log(Status, details)
		test.log(Status.INFO, "This step shows usage of log(status, details)");

		// info(details)
		test.info("This step shows usage of info(details)");

		// log with snapshot
		Assert.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");

		// calling flush writes everything to the log file
		extent.flush();
	}

	@BeforeMethod
	public void setup() {
		reporter = new ExtentHtmlReporter("test.html");
		extent.attachReporter(reporter);
		test = extent.createTest("Login Test");
	}


	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			Object driver;
			String temp = Utility.getScreenshot(driver);
			Assert.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		extent.flush();
	}
	
	@Test
	public void loginTest()
	{
		driver = new Chromedriver();
		driver.get("https://www.google.com");
		System.out.println("test ");
		AssertJUnit.assertTrue(driver.getTitle().contains("mukesh"));
	}
}
