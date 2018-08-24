package com.atos.servicenow.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.atos.servicenow.base.TestBase;
import com.atos.servicenow.extent.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentTestListener implements ITestListener {

	// Extent Report Declarations
	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static WebDriver driver;

	@Override
	public synchronized void onStart(ITestContext context) {
		System.out.println("Extent Reports Version 3 Test Suite started!");
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
		extent.flush();
	}

	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " started!"));
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		test.set(extentTest);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.get().pass("Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		String screenshotPath = null;
		try {
			screenshotPath = TestBase.takeScreenshotAtEndOfTest(result.getName());
			System.out.println("screenshotPath path " + screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.get().fail(result.getThrowable());
		try {
			test.get().addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.get().skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
	}

}
