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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateProductAndDeleteProduct1 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSeleCommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Random ran = new Random();
	     int ranNum = ran.nextInt(1000);
		
		FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Product");
		Row row = sheet.getRow(0);
	     Cell cell = row.getCell(0);
	    String ProductName = cell.getStringCellValue()+ranNum;
	    
	    driver.findElement(By.name("productname")).sendKeys(ProductName);
	    Thread.sleep(2000);
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

	driver.findElement(By.linkText("Products")).click();
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+ProductName+"']"
			+ "/../preceding-sibling::td/input")).click();
	
	driver.findElement(By.xpath("(//input[@value='Delete'])[1]")).click();
	
	Alert alt = driver.switchTo().alert();
	alt.accept();
	
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	    driver.findElement(By.linkText("Sign Out")).click();
	}

}
