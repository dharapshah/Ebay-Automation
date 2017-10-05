package com.wbl.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionsEx {

     WebDriver driver;
     
     
     @BeforeClass
    public void before(){
    	
    	 System.setProperty("webdriver.chrome.driver","C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe" );
    	// driver = new ChromeDriver();
    //	 driver.manage().window().maximize(); 
    	 
    	 ChromeOptions cm = new ChromeOptions();
    	cm.addArguments("disable-notifications");
    	driver = new ChromeDriver(cm);
    	
    	
    	 
    }
	
   /*  @Test
	public void Mouseover(){
		
		driver.get("https://www.ebay.com/");
		System.out.println("Before title:"+ driver.getTitle());
		
 		WebDriverWait wait = new WebDriverWait(driver, 20);
 		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='s0-container']/li[5]/a")));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='s0-container']/li[5]/div[2]/div[1]/div[2]/ul/li[2]/a")));
		action.moveToElement(element).click().build().perform();
		System.out.println("after Title:"+ driver.getTitle());
			}*/
	
     @Test
     public void alert() throws InterruptedException{
    	 
    	 driver.get("https://www.jabong.com/");
    	 
    	// driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    	 
    	// Thread.sleep(5000);
    	 
    	// Alert alert = driver.switchTo().alert(); /// alerts based on browser window alert
    	 
    	// Thread.sleep(5000);
    	 
    	// alert.accept();
    	 
    	 
    	 
    	 
    	 
    	 
    	 
     }
     
}
