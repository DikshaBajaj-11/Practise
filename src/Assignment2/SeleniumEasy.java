package Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumEasy extends chrome
{
	@Test
	public void table() throws InterruptedException
	{
		Thread.sleep(3000);
		SeleniumEastLocators seleniumEastLocators = new SeleniumEastLocators(driver);
		//seleniumEastLocators.table.click();
		//First Ans
		/*seleniumEastLocators.click(seleniumEastLocators.table);
		System.out.println(seleniumEastLocators.col.getText());

		//driver.findElement(By.xpath("//a[text()=2]")).click();
		/*Thread.sleep(3000);
		WebElement colValue = driver.findElement(By.xpath("//td[text() ='6']/following-sibling::td[1]"));
		System.out.println(colValue.getText());*/
		
		//Second Ans
		/*seleniumEastLocators.click(seleniumEastLocators.launch);
		Thread.sleep(3000);
		seleniumEastLocators.click(seleniumEastLocators.save);*/
		
		//Thrid ans
		//seleniumEastLocators.click(seleniumEastLocators.input);
		
		Select s = new Select(driver.findElement(By.xpath("//li[@class='dropdown open']//a[normalize-space(text())='Input Forms']")));
		Thread.sleep(3000);
		s.selectByVisibleText("Radio Buttons Demo");
	}
}
