package com.firestarters.page;

public class SalePage extends AbstractPage {
	
	public String checkSalePageURL() {
		
		return getDriver().getCurrentUrl();
	}

}
