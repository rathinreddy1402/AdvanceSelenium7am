package Generic_Utilities;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriver_Utility {

	/**
	 * This method is used for maximizing window
	 * @param driver
	 * @author Shobha
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will the element to load in GUI
	 * @param driver
	 * @author Shobha
	 */
	public void implicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is used for switching windows
	 * 
	 * @author Shobha
	 */
	public void switchingWindows(WebDriver driver,String visibleText)
	{
		Set<String> allids = driver.getWindowHandles();
		Iterator<String> id = allids.iterator();
		while(id.hasNext())
		{
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			
			if(title.contains(visibleText))
			{
				break;
			}
			}
	}
		public void scrollPAge(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()", element);
		}
		
		public void alertAccep(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
}
	
	
