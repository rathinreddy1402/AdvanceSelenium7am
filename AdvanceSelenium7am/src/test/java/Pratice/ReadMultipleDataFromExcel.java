package Pratice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws Throwable {
		
		Workbook wb = WorkbookFactory.create(new FileInputStream("./src/test/resources/AdvSelenium7am.xlsx"));
		Sheet sh = wb.getSheet("Sheet1");
		int row = sh.getLastRowNum();
		
		for(int i=0;i<=row;i++)//250
		{
			Row r = sh.getRow(i);//0
			short rows = r.getLastCellNum();
			for(int j=0;j<=rows;j++)//0
			{
				Cell c = r.getCell(j);
				DataFormatter dataFormatter=new DataFormatter();
				String data = dataFormatter.formatCellValue(c);
				System.out.println(data);
			}
		}
	}
}