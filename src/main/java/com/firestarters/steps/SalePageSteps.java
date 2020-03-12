package com.firestarters.steps;

import org.junit.Assert;

import com.firestarters.page.SalePage;

import net.thucydides.core.annotations.Step;

public class SalePageSteps {
	SalePage salePage;
	
	@Step
	public void checkUrl() {
		String actualURL = salePage.checkSalePageURL();
		String expectedURL = "http://qa2.dev.evozon.com/sale.html";
		
		Assert.assertTrue(actualURL.equals(expectedURL));
	}

}
