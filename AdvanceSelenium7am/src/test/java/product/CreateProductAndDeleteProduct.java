package product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.implicityWait(driver);
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		File_Utility flib=new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
	     driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRandomNum();
		//Random ran = new Random();
	   //  int ranNum = ran.nextInt(1000);
		
		Excel_Utility elib=new Excel_Utility();
		String ProductName = elib.getExcelDataUsingDataFormatter("Product", 0, 0)+ranNum;
		/*FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
	     Cell cell = row.getCell(0);
	    String ProductName = cell.getStringCellValue()+ranNum;*/
	    
	    driver.findElement(By.name("productname")).sendKeys(ProductName);
	    Thread.sleep(2000);
 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
 
 driver.findElement(By.xpath("//a[text()='Products']")).click();

WebElement prdData = driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+ProductName+"']/../preceding-sibling::td/input"));
 prdData.click();
	
 driver.findElement(By.xpath("//input[@value='Delete']")).click();
	wlib.alertAccep(driver);
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    driver.findElement(By.linkText("Sign Out")).click();
	
	
	}

}
