package com.wbl;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.pages.HomePage;
import com.wbl.pages.LoginPage;
import com.wbl.pages.SearchResultPage;
import com.wbl.utilities.ExcelHelper;
import com.wbl.utilities.WaitUtils;

import junit.framework.Assert;

public class LoginPageTest extends BaseTest{

HomePage hm;
LoginPage lp;


@DataProvider(name="signinsearch")
public Object[][] testdata(){
  return ExcelHelper.getExcelData("Title.xlsx", "Sheet2");		
}


@Test(dataProvider="signinsearch")
public void LoginPageTesttest(String emailid, String password, String expected){
	WaitUtils.implicitWait(driver,20);
	lp = PageFactory.initElements(driver, LoginPage.class);
    lp.login(emailid, password, expected);
	Assert.assertEquals(lp.gettitle(), expected);
	
} 


}


