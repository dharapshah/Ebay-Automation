package com.wbl.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {

	
	public static void takeScreenShot(String fileName, WebDriver driver){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(Constants.RESOURCE_PATH+"/screenshots/"+fileName+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
	

