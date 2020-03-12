package com.firestarters.page;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa2.dev.evozon.com/men/tees-knits-and-polos.html")
public class MenTeesKnitsPage extends AbstractPage {
	
	@FindBy(css="span.price")
	private List<WebElementFacade> productPriceList;
	
	@FindBy(css="select[title=\"Sort By\"]")
	private WebElementFacade sortBySelect;
	
	@FindBy(css=".product-name")
	private List<WebElementFacade> productNameList;
	
	@FindBy(css= "a[title=\"Set Descending Direction\"]")
	private WebElementFacade sortDirectionArrow;
	
	public void clickSortByPriceOption() {
		sortBySelect.selectByVisibleText("Price");
	}
	
	public void clickSortByNameOption() {
		sortBySelect.selectByVisibleText("Name");
	}
	
	public void clickSortDirectionArrow() {
		sortDirectionArrow.click();
	}
	
	public boolean checkSortByPriceAscending() {
		boolean isCorrect = true;
		
		for(int i = 0; i < productPriceList.size()-1; i++) {
			String product1 = productPriceList.get(i).getText().replace("$", "");
			String product2 = productPriceList.get(i + 1).getText().replace("$", "");
			
			if(Double.valueOf(product1) > Double.valueOf(product2)) {
				isCorrect = false;
				return isCorrect;
			}
		}
		
		return isCorrect;
		
	}
	
	public boolean checkSortByPriceDescending() {
		boolean isCorrect = true;
		
		for(int i = 0; i < productPriceList.size()-1; i++) {
			String product1 = productPriceList.get(i).getText().replace("$", "");
			String product2 = productPriceList.get(i + 1).getText().replace("$", "");
			
			if(Double.valueOf(product1) < Double.valueOf(product2)) {
				isCorrect = false;
				return isCorrect;
			}
		}
		
		return isCorrect;
		
	}
	
	

	public boolean checkSortByNameAscending() {
		boolean isCorrect = true;
		
		for(int i = 0; i < productPriceList.size()-1; i++) {
			String product1 = productNameList.get(i).getText(); 
			String product2 = productNameList.get(i + 1).getText(); 
			int comparisonResult = product1.compareTo(product2);
			
		      if(comparisonResult > 0) {
		    	  isCorrect = false;
				  return isCorrect;
			}
		}
		
		return isCorrect;
			
	}
	
	
	public boolean checkSortByNameDescending() {
		boolean isCorrect = true;
		
		for(int i = 0; i < productPriceList.size()-1; i++) {
			String product1 = productNameList.get(i).getText(); 
			String product2 = productNameList.get(i + 1).getText(); 
			int comparisonResult = product1.compareTo(product2);
			
		      if(comparisonResult < 0) {
		    	  isCorrect = false;
				  return isCorrect;
			}
		}
		
		return isCorrect;
			
	}

	
	
	
	

}
