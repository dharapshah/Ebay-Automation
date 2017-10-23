package com.wbl.test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void before(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");//key is standard for chrome browser.value is from properties from resources
		driver = new ChromeDriver();	
	}

	@Test
	public void testWalmartHomePage()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");//key is standard for chrome browser.value is from properties from resources
		//WebDriver driver = new ChromeDriver();
		driver.get("https://www.walmart.com/");
		/*WebElement element = driver.findElement(By.cssSelector(".elc-icon.elc-icon-cart"));
		element.click();*/
		
		//or
		
		List<WebElement> elements = driver.findElements(By.cssSelector("[class*='m-margin-left']"));
		Assert.assertEquals(elements.size(), 4);
		
		System.out.println("Current url before :"+driver.getCurrentUrl());
		driver.findElement(By.cssSelector(".elc-icon.elc-icon-cart")).click();
		System.out.println("Current url after :"+driver.getCurrentUrl());
		//System.out.println("Html code of application:" +driver.getPageSource());
		driver.navigate().back();//takes back to home page from cart page
		System.out.println("home page title:"+ driver.getTitle());
		driver.navigate().forward();// take forwards to cart page from home page
		System.out.println("cart page title:" + driver.getTitle());
		driver.navigate().refresh();//will refresh the page
		driver.navigate().to("https://www.walmart.com/account/signup");// similar to get method
		
		WebElement element_FirstName = driver.findElement(By.name("firstName"));
		element_FirstName.sendKeys("Dhara");
		//element.clear();

	    /*elements = driver.findElements(By.className(".validation-group"));
		element = elements.get(1);*/
		driver.findElement(By.name("lastName")).sendKeys("Shah");
		
		System.out.println("elements attribute value"+element_FirstName.getAttribute("placeholder"));
		System.out.println("Tag Name"+element_FirstName.getTagName());//input
		System.out.println("css value::"+ element_FirstName.getCssValue("line-height"));
	}
	
	/*// windowhandles and quit example
	@Test
	public void testwblHomePage(){
		
		driver.get("http://whiteboxqa.com/");
		driver.findElement(By.id("headerfblogin")).click();
		
		String currWindowName = driver.getWindowHandle();//current window name
		
		Set<String> windows = driver.getWindowHandles();// set of all windows that are open
		for(String win : windows){
		// trying to switch control to child window
		System.out.println("window name:: "+win);
		if(win!=currWindowName){
			driver.switchTo().window(win);
		}
		}
		
		driver.findElement(By.id("email")).sendKeys("abc@a.com");
		driver.findElement(By.id("pass")).sendKeys("pass");
		driver.findElement(By.name("login")).click();
		
		driver.close();//it just closes current window/i.e will close child window only
		driver.quit();//it closes all windows/instances of current browser/ie will also close email/pwd window
		}*/
		
	@AfterClass
		public void after(){
			driver.quit();
		}
	
	}

