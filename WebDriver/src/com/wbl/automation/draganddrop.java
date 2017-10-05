package com.wbl.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//action class
public class draganddrop {

WebDriver driver;
	
	@BeforeClass
	public void Beforeclass() {
		
	System.setProperty("webdriver.chrome.driver","C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe" );
 	 driver = new ChromeDriver();
     driver.manage().window().maximize(); 
  
}
	@Test
	public void draganddrop(){
		driver.get("http://code.makery.ch/library/dart-drag-and-drop/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		  
		Actions action = new Actions(driver);
		
		driver.switchTo().frame(1);
		
		List<WebElement> element  = driver.findElements(By.cssSelector(".document"));
		System.out.println("size before:" + element.size());


		WebElement from = driver.findElement(By.cssSelector(".document:nth-of-type(1)"));
		System.out.println("from found:" + from.getText());
		WebElement to = driver.findElement(By.xpath("html/body/div/div"));
		
		System.out.println("Tash found:" + to.getText());
		
		//action.dragAndDrop(from, to).perform();
		
		action.clickAndHold(from).moveToElement(to).release(to).build().perform();
		
		List<WebElement> elements  = driver.findElements(By.cssSelector(".document"));
		System.out.println("size after:" + element.size());
						
	}
}
