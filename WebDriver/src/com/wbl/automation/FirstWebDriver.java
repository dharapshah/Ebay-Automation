package com.wbl.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstWebDriver {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");//key is standard for chrome browser.value is from properties from resources
		WebDriver driver = new ChromeDriver();
		//steps 	// open the browser with url
		driver.get("https://www.walmart.com");// get method it will load the browser with ur given URL.
		
		// find that element
		//By by = By.id("global-search-input");// by is the class and id is static method and we r calling method directly.right click,inspect on search box will give u ID
		//WebElement element = driver.findElement(by);// find element is again method
		
		/*or we can find element as per below
		driver.findElement(By.id("global-search-input"));*/
		
		
		// perform action
		//element.sendKeys("Laptop");// sendkeys is method.this means you are giving input in text box
		// assert for the result
		
		//element = driver.findElement(By.className("header-GlobalSearch-submit btn"));
		//element.click();
		//System.out.println("Result::"+ driver.getTitle());
		
		System.out.println("Current url before :"+driver.getCurrentUrl());
		driver.findElement(By.cssSelector(".elc-icon.elc-icon-cart")).click();
		System.out.println("Current url after :"+driver.getCurrentUrl());
		//System.out.println("Html code of application:" +driver.getPageSource());
		driver.navigate().back();//takes back to home page from cart page
		System.out.println("home page title:"+ driver.getTitle());
		driver.navigate().forward();// take forwards to cart page from home page
		System.out.println("cart page title:" + driver.getTitle());
		driver.navigate().refresh();//will refresh the page
		driver.navigate().to("https://www.walmart.com/account/signup");
		driver.close();// close the current instance of browser

		
	}

}
