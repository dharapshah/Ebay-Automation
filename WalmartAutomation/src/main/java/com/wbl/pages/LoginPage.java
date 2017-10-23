package com.wbl.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.wbl.base.CommonPage;

@Test
public class LoginPage extends CommonPage{

	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	

	
	@FindBy(how=How.ID,using="gh-ug")
	WebElement clicksignin;
	
	@FindBy(how=How.ID,using="userid")
	WebElement typeemailid;
	
	@FindBy(how=How.ID,using="pass")
	WebElement typepassword;
	
	@FindBy(how=How.ID,using="sgnBt")
	WebElement ok;
	
	@Test
	public String login(String emailid, String password, String expected){
		clicksignin.click();
		typeemailid.sendKeys(emailid);
		typepassword.sendKeys(password);
		ok.click();
	   return driver.getTitle();
		

	}
	
}


