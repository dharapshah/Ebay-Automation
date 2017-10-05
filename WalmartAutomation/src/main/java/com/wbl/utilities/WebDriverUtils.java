package com.wbl.utilities;

import org.openqa.selenium.WebDriver;

public class WebDriverUtils {

	public static WebDriver getdriver(String browsername){
		
		WebDriver driver = null;
		try{
			
			switch(browsername){
			
			case"Chrome":
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\pranav.shah\\workspace\\WebDriver\\resources\\chromedriver.exe");
				break;
			
			case"Firefox":
			
				break;
				
			case"ie":
				break;
				
			case"htmlunit":
				break;
				
			case"safari":
				break;
				
			default:
			
			}		
			
		}catch(Exception e){
			System.out.println("There is an exception when creating webdriver object");
			System.out.println(e.getStackTrace());
			
		}
		
		return driver;
		
	}
		
}
