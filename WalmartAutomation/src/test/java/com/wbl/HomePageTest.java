package com.wbl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.pages.HomePage;
import com.wbl.pages.SearchResultPage;
import com.wbl.utilities.ExcelHelper;

public class HomePageTest extends BaseTest{

	HomePage hm;
	
	/*@DataProvider(name="searchdata")
	public Object[][] testdata(){
      return ExcelHelper.getExcelData("Title.xlsx", "Sheet1");		
	}
	
	
	@Test(dataProvider="searchdata")//(groups={"Smoke"})
	public void Searchtabtest(String searchkeyword, String expected){
		hm = PageFactory.initElements(driver, HomePage.class);
		SearchResultPage sp= hm.search(searchkeyword);
		Assert.assertEquals(sp.gettitle(), expected);	
		
	} 
	
	@Test(enabled = false)//(groups={"Regression"})
	public void SliderImagestest(){
		hm = PageFactory.initElements(driver, HomePage.class);// this is how wee initialize findby 
		Assert.assertEquals(8, hm.SliderImages());
	}
	


	@Test(groups={"Smoke"})
	public void Headerlinktest(){
		hm = PageFactory.initElements(driver, HomePage.class);
		Assert.assertEquals(11, hm.Headerlinks());
		
	}*/
	
	@Test (enabled = true)//(groups={"Regression"})
	public void footerlinkstest(){
		hm = PageFactory.initElements(driver, HomePage.class);
		Assert.assertEquals(5, hm.footerlinks()); // expected 5 and found 5 
		
	}
	

	
}
