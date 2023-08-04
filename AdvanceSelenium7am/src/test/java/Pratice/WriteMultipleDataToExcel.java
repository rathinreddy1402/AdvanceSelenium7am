package Pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteMultipleDataToExcel {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelenium7am.xlsx");

		Workbook workbook = WorkbookFactory.create(fis);
	
		Sheet sheet = workbook.getSheet("Sheet1");
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int count = links.size();
		for (int i = 0; i < count; i++) 
		{
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(links.get(i).getAttribute("href"));
		}
		FileOutputStream fileOutputStream=new FileOutputStream("./src/test/resources/AdvSelenium7am.xlsx");
		workbook.write(fileOutputStream);
        workbook.close();
	}

}
