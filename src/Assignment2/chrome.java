package Assignment2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class chrome 
{
	WebDriver driver;
	@BeforeTest
	public void chrome()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html"); ---First
		//driver.get("https://www.seleniumeasy.com/test/bootstrap-modal-demo.html"); --- Second
		driver.get("https://www.seleniumeasy.com/test/");
	}
	
	@AfterTest
	public void chromeClose()
	{
		driver.quit();
	}
}
