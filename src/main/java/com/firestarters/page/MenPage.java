package com.firestarters.page;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;

public class MenPage extends AbstractPage{
	
	 @FindBy(css ="img[alt=\"Tees, Knits and Polos\"]")
	 private WebElementFacade teesKnitsAndPolos;
	 
	 public void clickTeesKnitsAndPolos() {
		 teesKnitsAndPolos.click();
	 }

}
