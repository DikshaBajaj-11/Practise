package ReportPractise;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

@Listeners(TestListerner.class)
public class GetuserTest extends BaseTestCase
{
	@Test
	public void getUser() throws IOException
	{
		GetrandomuserPage gu = new GetrandomuserPage(driver);
		gu.click(gu.getuser);
		String actualText = gu.getUserText(gu.name);
		assertTrue(actualText.contains("First      Name"));
		//Reporter.log("Actual Text Matched :" + actualText + "Expected text: First Name");
	
		/*ExtendReportManager.extentTest.get().log(Status.INFO, "Test Case Passed"); //Verfification mesaage display
		ExtendReportManager.takeScreenshot(driver, "GetUserDetails");*/
	}
}
