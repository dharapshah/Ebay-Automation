package com.wbl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.CommonPage;

public class SearchResultsDetailsPage extends CommonPage{

	public SearchResultsDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy(xpath=".//*[@id='why2buy']/div/div[1]/span")
	WebElement button;
	
	public boolean isFreeShippingPresent(){
		return button.isDisplayed();
	}
}


