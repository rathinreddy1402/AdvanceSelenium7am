package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
/**
 * This method is used to fetch data from ExcelSheet
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @return
 * @throws Throwable
 * @author Shobha
 */
public String getExcelData(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
	     Cell cell = row.getCell(cellNum);
	    String ExcelData = cell.getStringCellValue();
	   return ExcelData;
	}

public String getExcelDataUsingDataFormatter(String sheetName,int rowNum ,int cellNum) throws Throwable
{
	FileInputStream fes = new FileInputStream("./src/test/resources/AdvSelenium7to9am.xlsx");
	Workbook book = WorkbookFactory.create(fes);
	Sheet sheet = book.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
     Cell cell = row.getCell(cellNum);
    DataFormatter formatter = new DataFormatter();
    String ExcelData = formatter.formatCellValue(cell);
	return ExcelData;
}
}
