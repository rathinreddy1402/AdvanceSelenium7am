package Pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertDataToPropertiesClass {

	public static void main(String[] args) throws Throwable {
		
		Properties pro = new Properties();
        pro.setProperty("username", "admin");
        pro.setProperty("password", "manager");
        pro.setProperty("url", "https://demo.actitime.com/login.do");
	
	FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvSeleCommonData.properties");
	pro.store(fos, "Common Data");
	System.out.println("data written Successfully");
	
	
	FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
    Properties pro1 = new Properties();
    pro1.load(fis);
   String URL = pro1.getProperty("url");
  String USERNAME = pro1.getProperty("username");
   String PASSWORD = pro1.getProperty("password");
   
   
  WebDriver driver=new ChromeDriver();
   driver.get(URL);
   driver.findElement(By.id("username")).sendKeys(USERNAME);
   driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
   driver.findElement(By.id("loginButton")).click();
	
	}

}
