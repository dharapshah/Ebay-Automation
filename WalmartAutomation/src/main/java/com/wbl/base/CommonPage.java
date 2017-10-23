package com.wbl.base;

	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.wbl.pages.SearchResultPage;

	public class CommonPage {

		protected WebDriver driver;
		// if we use find by method we need to initialize locators and hence can be done at some common place
		@FindBy(how=How.ID,using="gh-ac")
		WebElement SearchBox;
		
		@FindBy(how=How.ID,using="gh-btn")
		WebElement SearchButton;
		
		@FindBy(how=How.CSS,using=".hl-cat-nav__js-tab>a")
		List<WebElement> HeaderLink; // because its going to return us the list 
		
		@FindBy(how=How.CSS,using=".gf-bttl.thrd")
		List<WebElement> FooterLink; 
		
		public CommonPage(WebDriver driver){
			this.driver=driver;
			
		}
		
		public SearchResultPage search(String searchdata){
			SearchBox.sendKeys(searchdata);
			SearchButton.click();
			return PageFactory.initElements(driver, SearchResultPage.class);	
			//return new SearchResultPage(driver);
		}

       public String gettitle(){
	    return driver.getTitle();
}
		
	   public int Headerlinks(){
		   return HeaderLink.size();	
		}

		public int footerlinks(){
			return FooterLink.size();
		}
		
		
			public void headerdropdown(){// My ebay - right side of the website
			List<WebElement> elements = driver.findElements(By.linkText("My eBay"));
			Actions action = new Actions(driver);
			for(WebElement elm : elements){
				action.moveToElement(elm).perform();
				driver.findElements(By.cssSelector(".gh-eb-oa.thrd"));
				for(WebElement elmt: elements){
					System.out.println(elmt.getText());
				}
			}
			
		}
	}


