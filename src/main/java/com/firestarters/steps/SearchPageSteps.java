package com.firestarters.steps;

import com.firestarters.page.SearchPage;
import net.thucydides.core.annotations.Step;

public class SearchPageSteps {

    SearchPage searchPage;



    //Ciuverca Ionut
    @Step
    public void addProductFromSearch(String searchWord, String expectedWordInTitle){
        searchPage.searchProduct(searchWord, expectedWordInTitle);
        searchPage.addToCartProduct();
    }

    public String searchWord, expectedWordInTitle;
    @Step
    public void addProductFromSearchDDT(){
        searchPage.searchProduct(searchWord, expectedWordInTitle);
        searchPage.addToCartProduct();
    }


}
