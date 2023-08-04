package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities.File_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoEx {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		File_Utility flib=new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		driver.get(URL);
		WebElement UN = driver.findElement(By.name("user_name"));
		WebElement PW = driver.findElement(By.name("user_password"));
		WebElement login = driver.findElement(By.id("submitButton"));
	    UN.sendKeys("admin");
	    PW.sendKeys("admin");
		driver.navigate().refresh();
		UN.sendKeys("admin");
		PW.sendKeys("admin");
	
	
	}

}
