package Pratice;

import java.io.File;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadDataUsingJson {

	public static void main(String[] args) throws IOException, ParseException {
		File file = new File("./src/test/resources/jsonfile.json");
		ObjectMapper obj=new ObjectMapper();//to convert json to java language
		
		 JsonNode jsonData = obj.readTree(file);

         // Extract data from JSON
         String username = jsonData.get("username").asText();
        String password = jsonData.get("password").asText();
         String URL = jsonData.get("url").asText();
         
         WebDriver driver=new ChromeDriver();
         driver.get(URL);
  //       System.out.println(name+" "+age+" "+email);
  //        Enter the username and password
         driver.findElement(By.name("user_name")).sendKeys(username);
 		//enter the password
 		driver.findElement(By.name("user_password")).sendKeys(password);
 		//click on submit button
 		driver.findElement(By.id("submitButton")).click();
	}

}
