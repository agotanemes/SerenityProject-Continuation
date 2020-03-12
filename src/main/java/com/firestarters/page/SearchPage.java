package com.firestarters.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.junit.Assert.assertTrue;


public class SearchPage extends AbstractPage {

    @FindBy(id = "search")
    private WebElementFacade searchInput;

    @FindBy(css = "button[title = 'Search']")
    private WebElementFacade searchSubmitButton;

    @FindBy(css = ".category-products>.toolbar .sort-by")
    private WebElementFacade sortByLabel;

    @FindBy(css = "div.page-title")
    private WebElementFacade searchTitle;

    @FindBy(css = "div>.btn-cart")
    private WebElementFacade addToCartButton;



    //Ciuverca Ionut
    public void searchProduct(String productInput, String titleComparatorString){
        searchInput.clear();
        searchInput.type(productInput);
        searchSubmitButton.click();
        String searchTitleString = searchTitle.getText().toLowerCase();
        assertTrue(sortByLabel.isDisplayed());
        assertTrue(searchTitleString.contains(titleComparatorString));
    }

    //Ciuverca Ionut
    public void addToCartProduct(){
        addToCartButton.click();
    }








}
