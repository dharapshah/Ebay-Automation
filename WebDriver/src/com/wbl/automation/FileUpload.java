package com.wbl.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUpload {

	
WebDriver driver;
	
	@Test
	public void HomePage() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.monsterindia.com/");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		//wait.until(ExpectedConditions.alertIsPresent());
		
		String currwin = driver.getWindowHandle();
		Set<String> allwins = driver.getWindowHandles();
		
		for(String win:allwins){
			if(!currwin.equals(win)){
				driver.switchTo().window(win).close();
				break;
			}
		}
		
		driver.switchTo().window(currwin);
		
		
		
		driver.findElement(By.cssSelector(".fileUpload.btn>span")).click();
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#wordresume"))).click();
		
		Runtime.getRuntime().exec("C:\\Users\\pranav.shah\\Desktop\\AutoIt\\fileupload.exe");
		
		System.out.println("file uploaded");
		
		driver.close();
		
		
		/*StringSelection selectpath = new StringSelection("C:\\Users\\pranav.shah\\Desktop\\AutoIt\\fileupload.exe");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectpath, null);
		
		
		

		try {
		Robot	robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
	} catch (AWTException e) {
		e.printStackTrace();
	}
		
		*/
		
		
}
}


