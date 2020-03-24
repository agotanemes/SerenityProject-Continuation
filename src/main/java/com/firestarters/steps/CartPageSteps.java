package com.firestarters.steps;

import com.firestarters.models.CartProduct;
import com.firestarters.models.CartTotalPrices;
import com.firestarters.page.CartPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.firestarters.utils.Utils.convertStringToDouble;
import static com.firestarters.utils.Utils.stringReplace;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPageSteps {

    CartPage cartPage;


    //Ciuverca Ionut
    @Step
    public void proceedToCheckout(int expectedSize) {
        assertEquals(expectedSize, cartPage.getNumberOfElementsFromCartProductsList());
        cartPage.proceedToCheckout();
    }
    @Step
    public void proceedToCheckoutForVerify() {
        cartPage.proceedToCheckout();
    }

    @Step
        public void proceedToCheckout () {
            assertEquals(2, cartPage.getNumberOfElementsFromCartProductsList());
            cartPage.proceedToCheckout();
    }

    //Agota 12.03.2020
    @Step
    public void verifyIfSubtotalIsCorrect() {
        cartPage.verifyIfSubtotalIsCorrect();
    }
    //

    @Step
    public void verifyIfProductTableIsDisplayed() {
        assertTrue(cartPage.getProductTable().isDisplayed());
    }
    //Agota 13.03.2020
    @Step
    public List<CartProduct> getProducts(){
        return cartPage.getProducts();
    }


    //
    //13.03.2020

    //
    @Step
    public void getTax(){
        double tax=cartPage.getTax();
    }
    @Step
    public void getSubtotal(){
        double subtotal=cartPage.getSubtotal();
    }
    @Step
    public CartTotalPrices getPricesThatComposeGrangTotal(){
        CartTotalPrices cartTotalPrices=cartPage.getPricesThatComposeGrangTotal();
        double sum= cartTotalPrices.getSubtotal()+cartTotalPrices.getTax();
        Double sumDouble=sum;
        Double grandTotal=cartTotalPrices.getGrandTotal();
        Assert.assertTrue(sumDouble.equals(grandTotal));
        return cartTotalPrices;
    }
    @Step
    public CartTotalPrices calculatePricesThatComposeGrandTotal(List<CartProduct>products){
        return cartPage.calculatePricesThatComposeGrandTotal(products);
    }
    @Step
    public void verifyTotals(CartTotalPrices actual,CartTotalPrices expected){
        Double actualSubtotal=actual.getSubtotal();
        Double expectedSubtotal=expected.getSubtotal();
        Double actualTax=actual.getTax();
        Double expectedTax=expected.getTax();
        Double actualGrandTotal=actual.getGrandTotal();
        Double expectedGrandTotal=expected.getGrandTotal();
        Assert.assertTrue(actualSubtotal.equals(expectedSubtotal));
        Assert.assertTrue(actualTax.equals(expectedTax));
        Assert.assertTrue(actualGrandTotal.equals(expectedGrandTotal));
    }
    @Step
    public void verifyNrOfProductsFromCart(){

         String nrprod=cartPage.getNrOfProductsFromCart();
         Integer size=cartPage.getProducts().size();
         Integer nrProducts=Integer.parseInt(nrprod);
         Assert.assertFalse(size.equals(nrProducts));
    }

    @Step
    public WebElement getProceedToCheckoutBtn(){
        return cartPage.getProceedToCheckoutButton();
    }
    @Step
    public CartTotalPrices getTotalPricesForOrderReview(List<CartProduct> products){
        return cartPage.getTotalPricesForOrderReview(products);
    }
    @Step
    public void clickOnWebElem(WebElement element){
        cartPage.clickOnWebElem(element);
    }

}


