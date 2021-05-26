package ReportPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestCase
{
	static WebDriver driver;
	@BeforeTest
	public void chrome()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
	}
	
	@AfterTest
	public void chromeClose()
	{
		driver.quit();
	}

	@BeforeSuite
	public void beforeSuite()
	{
		ExtendReportManager.createReport();
		ExtentTest test = ExtendReportManager.extentReport
				.createTest("getUser"); // To decide test case name tobe displayed in the report
		ExtendReportManager.extentTest.set(test);
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtendReportManager.extentReport.flush();
	}
}
