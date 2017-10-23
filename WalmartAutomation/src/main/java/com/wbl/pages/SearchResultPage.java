package com.wbl.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.wbl.base.CommonPage;

public class SearchResultPage extends CommonPage {
	
	@FindBy(how=How.CSS,using="[aria-controls='SortMenu']")
	 WebElement SortDropDowns;
	
	@FindBy(how=How.CSS,using="#SortMenu>li>a")
	List<WebElement> SortDropDownValues;
	
	@FindBy(how=How.CSS,using="[class='bold']")
	List<WebElement> PricesInSearch;
	
	
	@FindBy(css=".vip")
	List<WebElement> SearchTitleLinks;
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	
	
    public String SelectSortDropDownValue(String Value){ 
	SortDropDowns.click();
	for (WebElement val:SortDropDownValues){
		if(val.getText().equals(Value)){
			val.click();
			break;	
		}		
	}	
	PricesInSearch = driver.findElements(By.cssSelector("[class='bold']"));
	return PricesInSearch.get(0).getText();
}
	
    
    public SearchResultsDetailsPage ClickSearchResult(int index){
    	SearchTitleLinks.get(index).click();
    	return new SearchResultsDetailsPage(driver);
    	
    }
    
    public float findMax(List<WebElement> elements){
		float max=0;
		for(WebElement elm : elements){
			float price=Float.parseFloat(elm.getText().replaceAll("[^0-9].", ""));
			if(price>max){
				max=price;
			}
		}
		return max;
	}
    
    
    
    /*public float ActualMaxPriceInSearchResult(){
    	
    	float price=Float.parseFloat(PricesInSearch.get(0).getText().replaceAll("[^0-9].", ""));
    	return price;
    }
    
    public float MaxPriceInSearchResultPricesInSearch(){
		float max=0;
		for(WebElement elm : PricesInSearch ){
			float price=Float.parseFloat(elm.getText().replaceAll("[^0-9].", ""));
			if(price>max){
				max=price;
			}
		}
		System.out.println(max);
		return max;
	}*/
	
    

    
	
	
}
