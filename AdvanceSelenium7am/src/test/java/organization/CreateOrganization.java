package organization;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
	
        Thread.sleep(2000);
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	
	FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Desktop\\AdvSelenium7to9am.xlsx");
	Workbook book = WorkbookFactory.create(fis);
    Sheet sheet = book.getSheet("Organization");
    Row row = sheet.getRow(0);
    Cell cell = row.getCell(0);
    String orgName = cell.getStringCellValue()+ranNum;
	
     driver.findElement(By.name("accountname")).sendKeys(orgName);
	
	driver.findElement(By.id("phone")).sendKeys("468654684");
	driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	Thread.sleep(2000);
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(ele).click().perform();
	driver.findElement(By.linkText("Sign Out")).click();
	
	
	}

}
