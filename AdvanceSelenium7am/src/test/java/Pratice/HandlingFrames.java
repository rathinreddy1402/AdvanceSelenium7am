package Pratice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingFrames {

	public static void main(String[] args) throws Throwable {
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Frames.html");
driver.manage().window().maximize();
	
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("shobha");
	
/*	driver.switchTo().frame("singleframe");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");*/
	
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//a[.=\"Iframe with in an Iframe\"]")).click();
	}

}
