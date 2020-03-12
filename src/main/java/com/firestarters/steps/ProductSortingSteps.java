package com.firestarters.steps;

import org.junit.Assert;

import com.firestarters.page.MainPage;
import com.firestarters.page.MenTeesKnitsPage;
import com.firestarters.page.TopsAndBlousesPage;
import com.firestarters.page.WomenPage;

import net.thucydides.core.annotations.Step;

public class ProductSortingSteps {
	
	HomepageSteps mainPage;
	MenTeesKnitsPage teesKnitsProductPage;
	WomenPage womenPage;
	TopsAndBlousesPage topsAndBlouses;
	
	@Step
	public void verifyAscendingSortByPrice() {
		teesKnitsProductPage.clickSortByPriceOption();
		Assert.assertTrue(teesKnitsProductPage.checkSortByPriceAscending());;
		
	}
	
	@Step
	public void verifyDescendingSortByPrice() {
		teesKnitsProductPage.clickSortByPriceOption();
		teesKnitsProductPage.clickSortDirectionArrow();
		Assert.assertTrue(teesKnitsProductPage.checkSortByPriceDescending());
		
	}

	
	@Step
	public void verifyAscendingSortByName() {
		teesKnitsProductPage.clickSortByNameOption();
		Assert.assertTrue(teesKnitsProductPage.checkSortByNameAscending());
	}
	
	@Step
	public void verifyDescendingSortByName() {
		teesKnitsProductPage.clickSortByNameOption();
		teesKnitsProductPage.clickSortDirectionArrow();
		Assert.assertTrue(teesKnitsProductPage.checkSortByNameDescending());
		
	}
	
	

	
}
