package com.wbl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;
import com.google.common.base.Functions;

public class Waits {

WebDriver driver;
	
	@BeforeClass
	public void before(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");//key is standard for chrome browser.value is from properties from resources
		driver = new ChromeDriver();
	}
	
	@Test
	public void testExplicitwait(){
		driver.get("https://www.walmart.com/");
		System.out.println(driver.getTitle());
	    driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Laptop");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String result = wait.until(function);
		System.out.println("searchpage title::"+ result);
		driver.close();
			
		}

     Function<WebDriver, String> function = new Function<WebDriver, String>() { // click and add unimplemented method
    	 
     
    	 public String apply(WebDriver arg0) {
    		 WebDriverWait wait = new WebDriverWait(driver, 20);
			List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".header-Typeahead-row")));
			for(WebElement elm: elements){
			    if(elm.getText().equalsIgnoreCase("hp laptop")){
				elm.click();
			break;
			    }
			}
			return driver.getTitle();
		}

     };

  /*   @Test
    public void FluentWaitExample(){
 		driver.get("https://www.walmart.com/");
 		System.out.println(driver.getTitle());
 		
 		
 		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
 									.withTimeout(20, TimeUnit.SECONDS)
 									.pollingEvery(5, TimeUnit.SECONDS)// overriding default frequency 500ms
 									.ignoring(NoSuchElementException.class);
 		
 	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Search']")));
 	    		
 	
 	    element.sendKeys("Laptop");
 	    
 	    driver.close();
    }

	
	/*@Test
	public void walmart() throws InterruptedException{
		driver.get("https://www.walmart.com/");
		System.out.println(driver.getTitle());
		
		// implicit wait once given is available for entire time browser is open and on any element in page
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@placeholder='Search']")).sendKeys("Laptop");
		driver.findElement(By.cssSelector(".header-GlobalSearch-submit.btn")).click();
		driver.findElement(By.cssSelector(".chooser-option-current")).click();
		
		List<WebElement> sortElements = driver.findElements(By.cssSelector(".chooser-option-current"));
		System.out.println(sortElements.get(3).getText());
		sortElements.get(3).click();
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		driver.close();
		
	}*/

}
