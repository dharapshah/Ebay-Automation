package com.wbl.automation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iframe {

	WebDriver driver;
	
	@BeforeClass
	public void Beforeclass() {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe" );
 	 driver = new ChromeDriver();
     driver.manage().window().maximize(); 
  
}
	@Test
	public void testframe(){
		try{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		// iframe created by own 
		driver.get("file:///C:/Users/pranav.shah/Desktop/whiteiframe.htm");
		driver.switchTo().frame(driver.findElement(By.id("white")));
	    driver.findElement(By.xpath(".//*[@id='navbar-collapse']/ul/li[1]/a"));// click on home menu
	    driver.switchTo().parentFrame(); // to switch to main page 
        
	}catch(Exception e){
	
		File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);// this will take screen shot but it will be inside the memory.
		
		
			
			try {
				FileUtils.copyFile(file, new File("My.jpg"));//this will save screen shot in ur project . to view refresh and check in webdriver project.
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
			
		
		
}
	}
	
	
	
