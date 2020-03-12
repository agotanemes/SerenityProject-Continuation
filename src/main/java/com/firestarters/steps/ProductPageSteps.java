package com.firestarters.steps;

import com.firestarters.page.ProductListPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProductPageSteps {
    @Steps
    ProductListPage productListPage;

    //Ciuverca Ionut
    @Step
    public void selectAProduct(){
        productListPage.selectAProduct();
    }

    //Ciuverca Ionut
    @Step
    public void selectAdToCompare(){
        productListPage.clickOnAddToCompare();
    }

    //Ciuverca Ionut
    @Step
    public void addToCompare(){
        productListPage.addToCompare();
    }
    //Agota 10.03.2020
    @Step
    public void openProduct(String name){
        productListPage.openProduct(name);
    }
    //
}
