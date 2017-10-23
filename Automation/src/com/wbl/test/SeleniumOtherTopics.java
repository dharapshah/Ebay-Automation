package com.wbl.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumOtherTopics {
   WebDriver driver;
   
   @Test
   public void javascriptExecutor() throws AWTException, InterruptedException{// this is to show that selenium also support javascripexecutor with .execute script and write java code in strings
	  
	   // script to check if page is loaded completely
	   ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	   
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");//key is standard for chrome browser.value is from properties from resources
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		driver.findElement(By.id("global-search-input")).sendKeys("laptop");
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("alert('Helo')");	
		
		((JavascriptExecutor)driver).executeScript("window.scrollby(0,900)");// this is based on javascript executer and is window..... is java script function to scroll
		
		
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("alert('Helo')");
		
		
		
	}

}
