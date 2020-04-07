package com.firestarters.steps;

import com.firestarters.models.CartProduct;
import com.firestarters.models.CartTotalPrices;
import com.firestarters.page.CartPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

import static com.firestarters.utils.Utils.convertStringToDouble;
import static com.firestarters.utils.Utils.stringReplace;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPageSteps {

    CartPage cartPage;
    ProductDetailsSteps productDetailsSteps;


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
    public CartTotalPrices calculatePricesThatComposeGrandTotal(List<CartProduct>products,double tax){
        return cartPage.calculatePricesThatComposeGrandTotal(products,tax);
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
   @Step
   public WebElement getAccount(){
        return cartPage.getAccount();
   }
   @Step
    public String getMyCartText(){
       return cartPage.getMyCartText();
   }
   @Step
    public void verifyCartItemsAreEqualToNrAddedItems(List<CartProduct> product){
     int sum=cartPage.sumOfQtys(product);
     String nrOfItemsExp=cartPage.convertIntToString(sum);
     String accountTextAct=getMyCartText();
     assertTrue(accountTextAct.contains(nrOfItemsExp));
   }
   //delete specified product from cart
    @Step
   public void deleteProductFromCart(String name){
        cartPage.deleteProductFromCart(name);
   }
   //stergerea unui anumit produs din lista de produse introduse in cart
    @Step
   public void removeProductFromAddedProdList(String name,List<CartProduct> products){
        cartPage.removeProductFromAddedProdList(name,products);
   }
   @Step
    public void modifyProductFromCart(String name,String value){
        cartPage.modifyProductQtyFromCart(name,value);
    }
    @Step
    public void modifyProductQty(String name,String value,List<CartProduct> products){
        cartPage.modifyProductQty(name,value,products);
    }
    //minicart from header
    public WebElement getMiniCart(){
        return cartPage.getMiniCart();
    }
    public List<CartProduct> getMiniCartRecentlyAddedProd(){
       return cartPage.getMiniCartRecentlyAddedProd();
    }
    @Step
    public void checkCartListContainsAnotherCartList(List<CartProduct> searchedProducts,List<CartProduct> products ){
        int productsSize=products.size();
        int searchedproductsSize=searchedProducts.size();
        int i=0;
        int j=productsSize-1;

        while(searchedproductsSize>0){
            Assert.assertTrue(products.get(j).getQty().equals(searchedProducts.get(i).getQty()));
            Assert.assertTrue(products.get(j).getName().equals(searchedProducts.get(i).getName()));
            Double price1= products.get(j).getPrice();
            Double price2=searchedProducts.get(i).getPrice();
            //Assert.assertTrue(products.get(i).getProductPrice().equals(cartProducts.get(i).getProductPrice()));
            Assert.assertTrue(price1.equals(price2));
            Double subtotal1=products.get(j).getSubtotal();
            Double subtotal2=searchedProducts.get(i).getSubtotal();
            Assert.assertTrue(subtotal1.equals(subtotal2));
            searchedproductsSize=searchedproductsSize-1;
            j=j-1;
            i=i+1;


        }
    }
    @Step
    public void modifyMiniCartProduct(String name,String qty){
        cartPage.modifyMiniCartProduct(name,qty);
    }
    @Step
    public void removeMiniCartProduct(String name){
        cartPage.removeMiniCartProduct(name);
    }
    @Step
    public void findProductInList(String name,List<CartProduct> products){
        boolean ok=cartPage.findProductInList(name,products);
        Assert.assertTrue(ok);
    }
    @Step
    public void pressEnter()  {
        cartPage.pressEnter();
    }

}


