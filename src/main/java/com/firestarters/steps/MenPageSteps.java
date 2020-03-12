package com.firestarters.steps;

import com.firestarters.page.MenPage;

import net.thucydides.core.annotations.Step;

public class MenPageSteps {
	MenPage menPage;
	
	@Step
	public void selectTeesKnitsPolosCategory() {
		menPage.clickTeesKnitsAndPolos();
	}
	
	

}
