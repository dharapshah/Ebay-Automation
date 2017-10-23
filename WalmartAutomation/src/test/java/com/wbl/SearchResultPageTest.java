package com.wbl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.pages.HomePage;
import com.wbl.pages.SearchResultPage;
import com.wbl.utilities.WaitUtils;

public class SearchResultPageTest extends BaseTest {

	HomePage hm;
	SearchResultPage sp;
	
	public SearchResultPageTest(){
		PageFactory.initElements(driver, SearchResultPage.class);	
	}
	
	/*@Test
	public void MaxPriceSortTest(){
		hm = PageFactory.initElements(driver, HomePage.class);
		SearchResultPage sp= hm.search("Laptop");
	//	sp.PricesInSearchResult();
		sp.SelectSortDropDownValue("Price + Shipping: lowest first");
      // Assert.assertEquals(sp.ActualMaxPriceInSearchResult(),sp.MaxPriceInSearchResultPricesInSearch());
		
	}*/
	
	@Test(groups={"Smoke"})
	public void ClickSearchResult(){
		WaitUtils.implicitWait(driver,20);
		hm = PageFactory.initElements(driver, HomePage.class);
		sp = hm.search("Laptop");
		sp.SelectSortDropDownValue("Price + Shipping: lowest first");
		Assert.assertTrue(sp.ClickSearchResult(0).gettitle().contains("Laptop"));
		
		
	}
	

}
