package com.wbl.automation;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandle {

	WebDriver driver;
	
	@Test
	public void HomePage() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://whiteboxqa.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
	
		// header and footer elements 
		List<WebElement> elements = driver.findElements(By.cssSelector(".fa.fa-twitter"));
		for (WebElement ele:elements){
			Point point = ele.getLocation();
			System.out.println("x:" + point.getX());
			System.out.println("Y:" + point.getY());
			
			
			Dimension Dim = ele.getSize();
			System.out.println("height:"+ Dim.height);
			System.out.println("width:"+ Dim.width);
			
		}
		
		
		
		
		
		/*driver.findElement(By.cssSelector("#headerfblogin")).click();
		
		String mainwindow = driver.getWindowHandle();
		Set<String> childwindow = driver.getWindowHandles();
		for(String ch:childwindow){
			if (ch!=mainwindow){
				driver.switchTo().window(ch);
			}
			
			
		}
		
		driver.findElement(By.id("email")).sendKeys("Pran");
		driver.findElement(By.id("pass")).sendKeys("9898");
		driver.findElement(By.cssSelector("#loginbutton")).click();	*/
		
		
	}
		
}
