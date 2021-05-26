package ReportPractise;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportManager
{

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static void createReport() {
		// Create report name with datestamp
		String date = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
		String reportPath = System.getProperty("user.dir") + "\\TestReports\\AutomationReport_" + date
				+ ".html";
		// location of the extent report
		htmlReporter = new ExtentSparkReporter(reportPath);
		// Title of the report
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extentReport = new ExtentReports(); // create object of ExtentReports
		extentReport.attachReporter(htmlReporter);
		//return extentReport;
	}

	public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "\\TestReports\\Screenshots\\Screenshot_"
				+ screenshotName + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
