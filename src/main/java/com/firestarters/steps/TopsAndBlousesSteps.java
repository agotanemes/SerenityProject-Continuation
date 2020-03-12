package com.firestarters.steps;

import org.junit.Assert;

import com.firestarters.page.TopsAndBlousesPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;



public class TopsAndBlousesSteps {
	
	
	TopsAndBlousesPage topsAndBlouses;
	
	@Step
	public void clickFirstPriceCategory() {
		topsAndBlouses.selectFirstPriceCategory();
		
	}
	
	@Step
	public void clickSecondPriceCategory() {
		topsAndBlouses.selectSecondPriceCategory();
		
	}
	
	@Step
	public void clickThirdPriceCategory() {
		topsAndBlouses.selectThirdPriceCategory();
		
	}
	
	@Step
	public void checkFirstPriceCategorySorting() {
		Assert.assertTrue(topsAndBlouses.checkSortingByFirstPriceCategory());
	}
	
	
	
	@Step
	public void checkSecondPriceCategorySorting() {
		Assert.assertTrue(topsAndBlouses.checkSortingBySecondPriceCategory());
	}
	
	@Step
	public void checkThirdPriceCategorySorting() {
		Assert.assertTrue(topsAndBlouses.checkSortingByThirdPriceCategory());
	}
	

}
