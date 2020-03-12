package com.firestarters.steps;

import com.firestarters.page.MainPage;

import net.thucydides.core.annotations.Step;

public class MainPageSteps  {
 MainPage homepagePage;
 
 @Step
 public void clickOnSaleSection() {
 	homepagePage.clickOnSaleHeaderOption();
 }
 
 @Step
 public void clickOnMenSection() {
	 homepagePage.clickOnMenHeaderOption();
 }

}
