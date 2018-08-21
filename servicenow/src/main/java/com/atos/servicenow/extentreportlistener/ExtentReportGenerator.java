package com.atos.servicenow.extentreportlistener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportGenerator implements ITestListener {
	
	public void onTestStart(ITestResult result) {

		System.out.println("on test start");

		test = reports.startTest(result.getMethod().getMethodName());

		test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");

	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("on test success");

		test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");

	}

	public void onTestFailure(ITestResult result) {

		System.out.println("on test failure");

		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(src, new File("C:\\images\\" + result.getMethod().getMethodName() + ".png"));

			String file = test.addScreenCapture("C:\\images\\" + result.getMethod().getMethodName() + ".png");

			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);

			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
					result.getThrowable().getMessage());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("on test skipped");

		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("on test sucess within percentage");

	}

	public void onStart(ITestContext context) {

		System.out.println("on start");

		driver = new ChromeDriver(); // Set the drivers path in environment variables to avoid
										// code(System.setProperty())

		reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");

	}

	public void onFinish(ITestContext context) {

		System.out.println("on finish");

		driver.close();

		reports.endTest(test);

		reports.flush();

	}
}