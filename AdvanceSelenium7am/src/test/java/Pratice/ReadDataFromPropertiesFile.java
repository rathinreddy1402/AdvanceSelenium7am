package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws Throwable {
		
	/*	FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
         Properties pro = new Properties();
         pro.load(fis);
        String URL = pro.getProperty("url");
       String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");*/
        
        
       /* WebDriver driver=new ChromeDriver();
        driver.get(URL);
        driver.findElement(By.id("username")).sendKeys(USERNAME);
        driver.findElement(By.name("pwd")).sendKeys(PASSWORD);
        driver.findElement(By.id("loginButton")).click();*/
        
	}

}
