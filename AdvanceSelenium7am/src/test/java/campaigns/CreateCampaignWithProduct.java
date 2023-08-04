package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable {
WebDriver driver=new ChromeDriver();
         File_Utility flib=new File_Utility();
         Java_Utility jlib=new Java_Utility();
         Excel_Utility elib=new Excel_Utility();
         WebDriver_Utility wlib=new WebDriver_Utility();
         
        wlib.maximizeWindow(driver);
		wlib.implicityWait(driver);
	    String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.linkText("Products")).click();
        driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
        
        int ranNum = jlib.getRandomNum();
        String ProductName = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
        
	    driver.findElement(By.name("productname")).sendKeys(ProductName);
	    Thread.sleep(2000);
	 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	
	 driver.findElement(By.linkText("More")).click();
	 driver.findElement(By.linkText("Campaigns")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	wlib.switchingWindows(driver,"Products&action");

	Thread.sleep(1000);
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProductName);
	driver.findElement(By.xpath("//input[@name='search']")).click();
	
	//    "+value+"
	//driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	
	wlib.switchingWindows(driver, "Campaigns&action");

	
	String CampaginName = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
	
   driver.findElement(By.name("campaignname")).sendKeys(CampaginName);
   
   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	
   Thread.sleep(2000);
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    driver.findElement(By.linkText("Sign Out")).click();
	}

}
