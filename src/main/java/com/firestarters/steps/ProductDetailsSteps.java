package com.firestarters.steps;

import com.firestarters.models.CartProduct;
import com.firestarters.page.ProductDetailsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage;

//    @Step
//    public void selectARandomColor(){
//        productDetailsPage.selectAColor();
//    }
//
//    @Step
//    public void selectARandomSize(){
//        productDetailsPage.selectSize();
//    }
//
//    @Step
//    public void addToCart(){
//        productDetailsPage.addToCart();
//    }

    //Ciuverca Ionut ( here I grouped all the above)
    @Step
    public void configureProductAndAddToCart(){
        productDetailsPage.selectAColor();
        productDetailsPage.selectSize();
        productDetailsPage.addToCart();
    }

    //Agota 10.03.2020
    @Step
    public CartProduct addProduct(String c, String s, String qty){
        CartProduct cartProduct=new CartProduct();
        productDetailsPage.selectColor(c);
        productDetailsPage.selectSize(s);
        productDetailsPage.selectQty(qty);
        String productName=productDetailsPage.getProductName();
        double productPrice=productDetailsPage.getProductPrice();
        cartProduct.setColor(c);
        cartProduct.setSize(s);
        cartProduct.setQty(qty);
        cartProduct.setProductName(productName);
        cartProduct.setProductPrice(productPrice);
        return cartProduct;
    }
    @Step
    public void clickAddToCartBtn(){
        productDetailsPage.addToCart();
    }

    //

}
