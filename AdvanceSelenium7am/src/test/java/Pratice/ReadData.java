package Pratice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/myexcel.xlsx");
        Workbook book = WorkbookFactory.create(fis);
        Sheet sheet = book.getSheet("Sheet2");
        int rows = sheet.getLastRowNum();//50
        System.out.println(rows);//2
	
       LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	
 //      LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		
		for(int i=0;i<=rows;i++)
		{
			Integer key = (int) sheet.getRow(i).getCell(0).getNumericCellValue();
			String value = sheet.getRow(i).getCell(1).toString();
			map.put(key, value);
		}
		
		for(Entry<Integer, String> m:map.entrySet())
		{
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}

}
