package com.firestarters.page;

import java.util.List;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;

public class TopsAndBlousesPage extends AbstractPage {
	@FindBy(css= ".even>ol>li>a")
	private WebElementFacade firstPriceCategory;
	
	@FindBy(css=".even ol > li:nth-child(2)>a")
	private WebElementFacade secondPriceCategory;
	
	@FindBy(css = ".even ol > li:nth-child(3)>a")
	private WebElementFacade thirdPriceCategory;
	
	@FindBy(css=".regular-price>span")
	private List<WebElementFacade> productPriceList;
	
	public void selectFirstPriceCategory() {
		firstPriceCategory.click();	
	}
	

	public void selectSecondPriceCategory() {
		secondPriceCategory.click();	
	}
	

	public void selectThirdPriceCategory() {
		thirdPriceCategory.click();	
	}
	
	public boolean checkSortingByFirstPriceCategory() {
		double maxPrice = 99.99;
		boolean isCorrect = true;
		
		for(int i = 0; i < productPriceList.size(); i++ ) {
			String currentPrice = productPriceList.get(i).getText().replace("$", "");
			if(Double.valueOf(currentPrice) > maxPrice) {
				isCorrect = false;
				
				return isCorrect;	
			}	
		}
		
		return isCorrect;

	}
	
	
	public boolean checkSortingBySecondPriceCategory() {
		double minPrice = 100.00;
		double maxPrice = 199.99;
		boolean isCorrect = true;
		
		for(int i = 0; i < productPriceList.size(); i++ ) {
			String currentPrice = productPriceList.get(i).getText().replace("$", "");
			if( Double.valueOf(currentPrice) < minPrice || Double.valueOf(currentPrice) > maxPrice) {
				isCorrect = false;
				
				return isCorrect;	
			}	
		}
		
		return isCorrect;

	}
	
	public boolean checkSortingByThirdPriceCategory() {
		double minPrice = 200.00;
		boolean isCorrect = true;
		
		for(int i = 0; i < productPriceList.size(); i++ ) {
			String currentPrice = productPriceList.get(i).getText().replace("$", "");
			if(Double.valueOf(currentPrice) < minPrice) {
				isCorrect = false;
				
				return isCorrect;	
			}	
		}
		
		return isCorrect;

	}
	
	
	
	
	
}


