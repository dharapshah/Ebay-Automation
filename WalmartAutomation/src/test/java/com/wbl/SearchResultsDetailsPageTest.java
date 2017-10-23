package com.wbl;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.wbl.base.BaseTest;
import com.wbl.pages.HomePage;
import com.wbl.pages.SearchResultPage;
import com.wbl.pages.SearchResultsDetailsPage;

public class SearchResultsDetailsPageTest extends BaseTest {

	
	HomePage hm;
	SearchResultPage sp;
	SearchResultsDetailsPage sdp;
	
	public SearchResultsDetailsPageTest(){
		PageFactory.initElements(driver, SearchResultsDetailsPage.class);	
	}
	
	@Test
	public void FreeShippingButtonPresent(){
		hm = PageFactory.initElements(driver, HomePage.class);
		sp = hm.search("Laptop");
		sdp= sp.ClickSearchResult(0);
		Assert.assertTrue(sdp.isFreeShippingPresent());
	
		
		
	}
	
}
