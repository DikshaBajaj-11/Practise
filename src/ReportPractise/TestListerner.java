package ReportPractise;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListerner implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) //Before test case
	{
		ExtentTest test = ExtendReportManager.extentReport
				.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName()); //gets test case name with package name
		ExtendReportManager.extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) //Test case passed
	{
		result.getHost(); // it will get machine name
		if (result.getParameters().length > 0) { // for in case of data provider (data driven testing)
			String paramName = Arrays.asList(result.getParameters()).toString();
			ExtendReportManager.extentTest.get().log(Status.INFO, "Test Data: " + paramName);
			ExtendReportManager.extentTest.get().log(Status.PASS, MarkupHelper
					.createLabel(result.getMethod().getMethodName() + " Test Case PASSED", ExtentColor.GREEN));
		} else {
			ExtendReportManager.extentTest.get().log(Status.PASS, MarkupHelper
					.createLabel(result.getMethod().getMethodName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	@Override
	public void onTestFailure(ITestResult result) // test case failed
	{
		String methodName = result.getMethod().getMethodName();
		// String exceptionMessage =
		// Arrays.toString(result.getThrowable().getStackTrace());
		ExtendReportManager.extentTest.get().log(Status.FAIL,
				MarkupHelper.createLabel(methodName + " - Test Case FAILED", ExtentColor.RED));
		ExtendReportManager.extentTest.get().fail("Click on the log below to expand...");
		ExtendReportManager.extentTest.get().log(Status.FAIL, result.getThrowable());

		String screenshotpath = null;
		try {
			screenshotpath = ExtendReportManager.takeScreenshot(BaseTestCase.driver, methodName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		ExtendReportManager.extentTest.get().fail("Test Case Failed. Click below screenshot to view");
		ExtendReportManager.extentTest.get().addScreenCaptureFromPath(screenshotpath);
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		ExtendReportManager.extentTest.get().log(Status.SKIP, MarkupHelper
				.createLabel(result.getMethod().getMethodName() + " Test Case SKIPPED", ExtentColor.ORANGE));
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		ExtendReportManager.createReport();

	}

	@Override
	public void onFinish(ITestContext context) 
	{
		if (ExtendReportManager.extentReport != null) {
			ExtendReportManager.extentReport.flush();
		}

	}

			

}
