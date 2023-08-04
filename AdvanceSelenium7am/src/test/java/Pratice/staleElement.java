package Pratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class staleElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
	//	driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		WebElement ele1 = driver.findElement(By.name("user_name"));
        WebElement ele2 = driver.findElement(By.name("user_password"));
        ele1.sendKeys("admin");
        ele2.sendKeys("admin");
        driver.navigate().refresh();
        ele1.sendKeys("admin");
        ele2.sendKeys("admin");
	}
}