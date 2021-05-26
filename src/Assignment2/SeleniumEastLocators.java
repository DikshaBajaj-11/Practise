package Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Factory;

public class SeleniumEastLocators 
{
	public SeleniumEastLocators(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// First Ans
	/*@FindBy(xpath = "//a[text()=2]")
	public WebElement table;
	
	@FindBy(xpath = "//td[text() ='6']/following-sibling::td[1]")
	public WebElement col;*/
	
	//Second And
	/*@FindBy(xpath = "//a[text()='Launch modal']")
	public WebElement launch;
	
	@FindBy(xpath = "//a[text()='Save changes']")
	public WebElement save;*/
	
	//Thrid Ans
	By drop = By.xpath("//li[@class='dropdown open']//a[normalize-space(text())='Input Forms']");
	
	public void dropdown()
	{
		Select s = new Select((WebElement) drop);
		s.selectByVisibleText("Radio Buttons Demo");
	}

	
	public void click(WebElement wb)
	{
		wb.click();
	}
}
