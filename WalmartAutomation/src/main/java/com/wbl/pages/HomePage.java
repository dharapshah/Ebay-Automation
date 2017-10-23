package com.wbl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.wbl.base.CommonPage;


public class HomePage extends CommonPage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(how=How.CSS,using=".ebayui-ellipsis-3")
	List<WebElement> SliderImage;
	
	
	public int SliderImages(){
		return SliderImage.size();
		
	}
	
}

	
	