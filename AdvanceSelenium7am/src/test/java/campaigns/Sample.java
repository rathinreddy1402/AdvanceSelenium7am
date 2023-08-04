package campaigns;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
driver.get("http://localhost:8888/");
driver.manage().window().maximize();
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.linkText("Products")).click();
driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
Random r=new Random();
 int data = r.nextInt(1000);
 
//Step1:-set the path
 FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	org.apache.poi.ss.usermodel.Sheet sheet = book.getSheet("Product");
	Row row = sheet.getRow(0);
    org.apache.poi.ss.usermodel.Cell cell = row.getCell(0);
   String ProductName = cell.getStringCellValue()+data;
 driver.findElement(By.name("productname")).sendKeys(ProductName);


driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

driver.findElement(By.linkText("More")).click();
driver.findElement(By.linkText("Campaigns")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
driver.findElement(By.name("campaignname")).sendKeys("marketing"+data);

driver.findElement(By.xpath("//img[@alt='Select']")).click();
 Set<String> allWindows = driver.getWindowHandles();
 Iterator<String> id = allWindows.iterator();
	while(id.hasNext())
 {
	 String win = id.next();
	 driver.switchTo().window(win);
	 String title = driver.getTitle();
	 
	 if(title.contains("Products&action"))
	 {
		 break;
	 }
	 }
	driver.findElement(By.name("search_text")).sendKeys(ProductName);
	driver.findElement(By.name("search")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	Set<String> allWindows1 = driver.getWindowHandles();
	 Iterator<String> id1= allWindows1.iterator();
		while(id1.hasNext())
	 {
		 String win1 = id1.next();
		 driver.switchTo().window(win1);
		 String title = driver.getTitle();
		 
		 if(title.contains("Campaigns&action"))
		 {
			 break;
		 }
		 }
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
