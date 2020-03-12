package com.firestarters.page;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;

public class WomenPage extends AbstractPage {
	
	@FindBy(css="img[alt=\"Tops & Blouses\"]")
	private WebElementFacade topsAndBlousesCategory;

	
	public void clickOnTopsCategory() {
		topsAndBlousesCategory.click();
	}
	
	
	
	
}	

