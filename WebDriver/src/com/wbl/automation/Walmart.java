package com.wbl.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.common.base.Function;

public class Walmart {
	
	WebDriver driver;
	private List<WebElement> elements;
	
	@Test
	public void HomePage() throws InterruptedException, AWTException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		
		System.out.println("Title for HomePage:" + driver.getTitle());
        System.out.println("URL for homepage:" + driver.getCurrentUrl());
		
		// to locate elements by using tagname / noofinputtextboxes
		//List<WebElement> noofinputtextboxes = driver.findElements(By.tagName("input"));
		//System.out.println("Total of textbox:" +noofinputtextboxes.size());
		
		/*// to get no of links 
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		for (WebElement li: Links)	
		System.out.println(li.getAttribute("href"));
		
		// to find no of drop downs and assert the actual and expected result /print it
		List<WebElement> dropdowns =driver.findElements(By.xpath(".//*[@class='header-GlobalEyebrowNav-button dropdown-link btn-fake-link']"));
        Assert.assertEquals(dropdowns.size(), 3);
        System.out.println("Total no of drop downs in header:"+ dropdowns.size());
	    //for(WebElement dp: dropdowns)
		//System.out.println(dp.getSize());
		
		//to find total no of headers i.e gift cards, weekly adds, help, etc
		//here id* - * indicates that this content is common rest .......
        List<WebElement> list = driver.findElements(By.cssSelector("[id*=header-GlobalEyebrowNav]"));
        System.out.println("List:" + list.size());
		
		driver.navigate().to("https://www.walmart.com/account/signup");
		System.out.println("Title for signup page:" +driver.getTitle());	
		 System.out.println("URL for signup:" + driver.getCurrentUrl());

		 WebElement element = driver.findElement(By.name("firstName"));
		 element.sendKeys("Dhara");
		 element.clear();// this will clear the contect of textbox
		 System.out.println("Title of 1st text box :" +element.getAttribute("title"));
		 System.out.println("Tag name:" + element.getTagName());// input
         System.out.println("Css Value:" + element.getCssValue("font-size"));
         
		 driver.findElement(By.name("lastName")).sendKeys("Shah"); */
		 
        
		/*driver.findElement(By.id("global-search-input")).sendKeys("iphone");
		driver.findElement(By.cssSelector(".header-GlobalSearch-submit.btn")).click();
		driver.findElement(By.cssSelector(".chooser-option-current")).click();
		List<WebElement> Sort = driver.findElements(By.cssSelector(".chooser-option"));
	      Sort.get(2).click();
	      System.out.println(driver.getTitle());*/
		
		
		
	
	  
		driver.findElement(By.id("global-search-input")).sendKeys("iphone7");
		driver.findElement(By.cssSelector(".header-GlobalSearch-submit.btn")).click();
		System.out.println("Title 1:"+ driver.getTitle());
		
		// for below if u remove wait then the size will be "0" and it will not show any exception even thought it does not go till the end.
		List<WebElement> element = driver.findElements(By.cssSelector(".typeahead-row-link"));
		System.out.println("size:"+element.size());
		for(WebElement ele:element){
		System.out.println("Title 2:"+ ele.getText());
		if(ele.getText().equalsIgnoreCase("case")){
			ele.click();
			System.out.println(driver.getTitle());
			break;
		}
		
		
}
		/*Robot robot = new Robot();// scroll by using robot class
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);*/
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,1000)");
				
			
		Thread.sleep(2000);
		
	
	
	}


}
			
		
			
			
		
		
	
		
	


		
		
		
			
		
	
		