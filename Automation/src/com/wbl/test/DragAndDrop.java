package com.wbl.test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseTest{
	
	@Test(enabled=false)
	public void draganddropActions() throws InterruptedException{
		driver.get("http://code.makery.ch/library/dart-drag-and-drop/");
		Actions action = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(1);
		
		List<WebElement> elements = driver.findElements(By.cssSelector(".document"));
		
		System.out.println("Size after drag and drop::"+ elements.size());
		
		WebElement element = driver.findElement(By.cssSelector(".document:nth-of-type(1)"));
		
		WebElement to = driver.findElement(By.cssSelector(".trash"));
		
		action.dragAndDrop(element, to).perform();

	    elements = driver.findElements(By.cssSelector(".document"));
	    
	    Thread.sleep(2000);
		System.out.println("Size after drag and drop::"+ elements.size());
	}
	
	@Test(enabled=false)
	public void navigate() throws InterruptedException{
		
		driver.get("http://www.whiteboxqa.com/");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().to("https://talentscreen.io/#/website-pages/home");
		
	
	}
	
	@Test(enabled=false)
	public void WebElementMethods(){
		
		driver.get("https://www.walmart.com/");
		
		WebElement element = driver.findElement(By.id("global-search-input"));
		
		Assert.assertEquals("Search",element.getAttribute("placeholder"));
		Assert.assertEquals("query",element.getAttribute("name"));
		
		System.out.println("radius:"+ element.getCssValue("border-radius"));
		System.out.println("font-size:" + element.getCssValue("font-size"));
		System.out.println("width:" + element.getCssValue("width"));
		
		// check boxes, radio buttons, dropdowns
		//element.isSelected();
		
		Dimension dim = element.getSize();
		System.out.println("height:" + dim.height);
		System.out.println("width:" + dim.width);
		
	}
	
	@Test
	public void Handlecookies(){//  this is to know the list of cookies like wise we also have other methods to add and delete cookies
		driver.get("https://www.walmart.com/");
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie:cookies){
			System.out.println(cookie.getName());
		}
	}
}
