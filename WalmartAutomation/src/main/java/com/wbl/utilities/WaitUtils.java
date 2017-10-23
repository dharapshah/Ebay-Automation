package com.wbl.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	
	public static WebDriverWait explicitWait(WebDriver driver, long timeInSecs){
		WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
		return wait;
	}
	
	public static void implicitWait(WebDriver driver, long timeInSecs){
		driver.manage().timeouts().implicitlyWait(timeInSecs, TimeUnit.SECONDS);
	}

}


