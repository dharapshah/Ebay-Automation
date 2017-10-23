package com.wbl.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectAndRadio {

WebDriver driver;
	
	@BeforeClass
	public void before(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");//key is standard for chrome browser.value is from properties from resources
		driver = new ChromeDriver();
	}
	
	@Test
	public void facebookHome(){
	driver.get("https://www.facebook.com/");
	
	driver.findElement(By.xpath(".//*[@id='u_0_2']")).sendKeys("Innvoapath");
	WebElement element = driver.findElement(By.id("month"));
	
	//select to deal with single drop downs
	Select select = new Select(element);
	select.selectByIndex(1);
	
	System.out.println("is multiselect or single select ::"+select.isMultiple());
	
	
	select = new Select (driver.findElement(By.id("day")));
	select.selectByVisibleText("23");
	

	select = new Select (driver.findElement(By.id("year")));
	select.selectByValue("2000");
	
	// get all the options in drop down and display the text
	
	List<WebElement> options = select.getOptions();
	for (WebElement element1 : options){
		System.out.println(element1.getText());
	}
		
		//radio button - find element and click like a simple button
		driver.findElement(By.id("u_0_f")).click();
	
	
		// multi select dropdowns

       driver.navigate().to("http://wenzhixin.net.cn/p/multiple-select/docs/");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       select = new Select(driver.findElement(By.xpath("//*[@id='e1_f']/select")));
       select.selectByVisibleText("October");
       select.selectByVisibleText("November");
       
       //deselect methods are applicable only for multi selectr drop downs where u can select more than one option
       // we cannot use this for single select drop downs
       
       select.deselectByVisibleText("October");
       select.deselectAll();
       
       driver.close();
	}
	
	}
	

