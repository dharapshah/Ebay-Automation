package com.wbl.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsExample {

WebDriver driver;
	
	@BeforeClass
	public void before(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");//key is standard for chrome browser.value is from properties from resources
		driver = new ChromeDriver();
	}
	
	@Test
	public void testActions(){
		driver.get("https://www.ebay.com/");
		System.out.println("title::" + driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='w0-container']/li[5]/a")));
		
		//WebElement element =  driver.findElement(By.xpath(".//*[@id='w0-container']/li[5]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();// the particular mouse action is executed
		
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='w0-container']/li[5]/div[2]/div[1]/div[2]/ul/li[2]/a")));
		
		action.moveToElement(element).click().build().perform();// build is to combine the actions togather and then execute using perform.
		
		System.out.println(" after title::" + driver.getTitle());
		
		
			
	
}
}


