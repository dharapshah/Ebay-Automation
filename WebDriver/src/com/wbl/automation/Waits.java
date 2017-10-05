package com.wbl.automation;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Waits {

	WebDriver driver;
	private List<WebElement> elements;
	
	@Test
	public void HomePage() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("global-search-input")).sendKeys("iphone7");
		System.out.println("Title 1:"+ driver.getTitle());
		
		
		 WebDriverWait  wait = new WebDriverWait(driver, 20);
			//Will wait only while searching element mentioned in css selector
		  //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".typeahead-row-link")));
		
		 String result = wait.until(function);
		 System.out.print("Search page title:"+ result);
		 
		 
		 
		 driver.close();
}
	//In below it is unable to find iphone7 case in first go and hence will not show any exception but will give size "0"
			//Hence after adding explicit wait its able to found the element.
			//WebDriverWait  explicit = new WebDriverWait(driver, 20);
	  //(cltr + space will give u function)
	Function<WebDriver, String> function = new Function<WebDriver, String>() {

		@Override
		public String apply(WebDriver arg0) {
			WebDriverWait  wait = new WebDriverWait(driver, 20);
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".typeahead-row-link")));
					
			System.out.println("size:"+elements.size());
			for(WebElement ele:elements){
			if(ele.getText().equalsIgnoreCase("iphone7 case")){
				ele.click();
				System.out.println(driver.getTitle());
				break;
			}
			
}
			
			
			return driver.getTitle();
			
		}
		
		
	};
	
	@Test
	public void Fluentwait(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		FluentWait<WebDriver> fl = new FluentWait<WebDriver>(driver)
		.pollingEvery(5, TimeUnit.SECONDS)
		.withTimeout(20, TimeUnit.SECONDS)
		.ignoring(NoSuchElementException.class);
		
		WebElement element = fl.until(ExpectedConditions.visibilityOfElementLocated(By.id("global-search-input")));
		
		element.sendKeys("iphone7");
		
		driver.close();
		
		
	}
	
	
}





