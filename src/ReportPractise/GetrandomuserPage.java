package ReportPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetrandomuserPage extends BasePage
{
	public GetrandomuserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Get New User']")
	public WebElement getuser;
	
	@FindBy(xpath = "//img[@src='http://seleniumeasy.com/test/img/loader-image.gif']")
	public WebElement image;
	
	By image1 =  By.xpath("//img[@src='http://seleniumeasy.com/test/img/loader-image.gif']");
	
	@FindBy(xpath = "//div[@id='loading']")
	public WebElement name;
	
	public String getUserText(WebElement text)
	{
		fluentwait(image1);
		return text.getText();
	}
}
