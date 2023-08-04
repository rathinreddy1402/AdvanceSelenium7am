package Pratice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args) throws Throwable {
		//	FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelenium.xlsx");
		FileInputStream fis = new FileInputStream("./src/test/resources/myexcel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
	    Sheet sheet = book.getSheet("Sheet3");
	    Row row = sheet.getRow(0);
	    Cell cell = row.getCell(0);
	//  String exceldata = cell.getStringCellValue();
	//System.out.println(exceldata);
	   DataFormatter formatter = new DataFormatter();
	    String data = formatter.formatCellValue(cell);
	System.out.println(data);
	}

}
