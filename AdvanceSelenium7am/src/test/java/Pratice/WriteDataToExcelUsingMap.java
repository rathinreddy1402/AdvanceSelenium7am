package Pratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcelUsingMap {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/AdvSelenium7am.xlsx");
        Workbook book = WorkbookFactory.create(fis);
        Sheet sheet = book.getSheet("Sheet2");
        
        LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
        map.put("10", "pune");
        map.put("20", "Bangalore");
        map.put("30", "Goa");
        map.put("40", "hyd");
        
        int rowNo=0;
        for(Entry<String, String> m:map.entrySet())//10,pune
        {         //10,pune
        	Row row = sheet.createRow(rowNo++);
        	row.createCell(0).setCellValue((String)m.getKey());//10
        	row.createCell(1).setCellValue((String)m.getValue());//pune
        	}
        FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvSelenium7am.xlsx");
        book.write(fos);
        book.close();
	
	
	}

}
