package com.atos.servicenow.extentreportlistener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListenerTest implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();
	// When Test case get started, this method is called.
	public void onStart(ITestContext Result) {
		System.out.println("The name of the testcase started is :" + Result.getName());
	}

	// When Test case get Finished, this method is called.
	public void onFinish(ITestContext Result) {
		System.out.println("The name of the testcase Finished is :- " + Result.getName());
		extent.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		System.out.println("The name of the testcase failed is ButWithinSuccessPercentage :- " + Result.getName());
	}

	// When Test case get failed, this method is called.
	public void onTestFailure(ITestResult Result) {
		System.out.println("The name of the testcase failed is :- " + Result.getName());
	}

	// When Test case get Skipped, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :- " + Result.getName());
	}

	// When Test case get Started, this method is called.
	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName() + " test case started");
		ExtentTest extentTest = extent.createTest(Result.getMethod().getMethodName(),Result.getMethod().getDescription());
        test.set(extentTest);
	}

	// When Test case get passed, this method is called.
	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the testcase passed is :" + Result.getName());
	}

}
