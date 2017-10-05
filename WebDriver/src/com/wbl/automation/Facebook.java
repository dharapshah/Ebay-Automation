package com.wbl.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Facebook {
	
WebDriver driver;

	
	@BeforeClass
	public void beforeclass(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");
	     driver = new ChromeDriver();
	     
	     driver.get("https://www.facebook.com/");
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	     driver.manage().window().maximize();
	     
		
	}
	
	@Test
	public void homepage(){
     
     
     driver.findElement(By.xpath(".//*[@id='u_0_9']")).sendKeys("Radha");
     
     driver.findElement(By.xpath(".//*[@id='u_0_b']")).sendKeys("Patel");
     
     driver.findElement(By.id("u_0_e")).sendKeys("8787");
     
     driver.findElement(By.id("u_0_l")).sendKeys("RadPat");
     
     Select Month = new Select (driver.findElement(By.id("month")));
     Month.selectByVisibleText("Nov");
     System.out.println("Is multi select or single select:" + Month.isMultiple());
     
     Select Date = new Select (driver.findElement(By.id("day")));
     Date.selectByValue("25");
     
     Select Year = new Select (driver.findElement(By.id("year")));
     Year.selectByValue("1990");
     
 	List<WebElement> options = Year.getOptions();
 	for(WebElement op: options){
 		System.out.println("is selected:"+ op.isSelected());
 		System.out.println(op.getText());
 		System.out.println("is enable:"+ op.isEnabled());
 		System.out.println("is displayed:" + op.isDisplayed());
 		// in above it will mention in each year its displayed, is enable, is selected. so better to use this for radio buttons
 		
 	}
     
     driver.findElement(By.id("u_0_6")).isDisplayed(); //select female
     Assert.assertTrue(true);
     System.out.println();
     
     driver.findElement(By.id("u_0_r")).click();//continue
     
    // driver.findElement(By.xpath(".//*[@id='reg_pages_msg']/a")).click();
     
     List<WebElement> Links = driver.findElements(By.tagName("a"));
		for (WebElement li: Links)	
		//System.out.println(li.getAttribute("href")); will print actual links i.e www....com
			
			// below will print name of all links i.e careers, forgot pswd, signup
		System.out.println(li.getText());
		
		
     
     //driver.findElement(By.xpath(".//*[@title='Make your next career move to our awesome company.']")).click();
		
	}

	@Test(enabled=false)
	public void getcontext() throws InterruptedException{
		Actions action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		action.contextClick(driver.findElement(By.cssSelector("#loginbutton")));
		Thread.sleep(2000);

	
	}
	
}
