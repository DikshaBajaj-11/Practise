package ReportPractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage 
{
	public void fluentwait(By webElement)
	{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(BaseTestCase.driver)
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(2))
		.ignoring(Exception.class);
		//wait.until(ExpectedConditions.invisibilityOf(webElement));
		wait.until(ExpectedConditions.numberOfElementsToBe(webElement, 0));
		
	}
	public void getText(WebElement w)
	{
		w.getText();
	}
	public void click(WebElement wb)
	{
		wb.click();
	}
}
