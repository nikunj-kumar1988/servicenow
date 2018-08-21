/*
 * @autor : Naveen Khunteta
 * 
 */
package com.atos.servicenow.extentreportlistener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterGenerator {
	    ExtentHtmlReporter htmlReporter;
	    ExtentReports extent;
	    ExtentTest test;
	         
	    @BeforeTest
	    public void startReport()
	    {
	        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	         
	        extent.setSystemInfo("OS", "Mac Sierra");
	        extent.setSystemInfo("Host Name", "Krishna");
	        extent.setSystemInfo("Environment", "QA");
	        extent.setSystemInfo("User Name", "Krishna Sakinala");
	         
	        htmlReporter.config().setChartVisibilityOnOpen(true);
	        htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
	        htmlReporter.config().setReportName("My Own Report");
	        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	        htmlReporter.config().setTheme(Theme.DARK);
	    }
	     
	    @Test
	    public void demoTestPass()
	    {
	        test = extent.createTest("demoTestPass", "This test will demonstrate the PASS test case");
	        Assert.assertTrue(true);
	    }
	     
	    @Test
	    public void demoTestFail()
	    {
	        test = extent.createTest("demoTestFail", "This test will demonstrate the FAIL test case");
	        Assert.assertTrue(false);
	    }
	     
	    @Test
	    public void demoTestSkip()
	    {
	        test = extent.createTest("demoTestSkip", "This test will demonstrate the SKIP test case");
	        throw new SkipException("This test case not ready for execution");
	    }
	     
	    @AfterMethod
	    public void getResult(ITestResult result)
	    {
	        if(result.getStatus() == ITestResult.FAILURE)
	        {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	        }
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
	     
	    @AfterTest
	    public void tearDown()
	    {
	        extent.flush();
	    }
}