package com.firestarters.steps;

import com.firestarters.models.BillingInf;
import com.firestarters.models.CartProduct;
import com.firestarters.models.CartTotalPrices;
import com.firestarters.models.ShippingInform;
import com.firestarters.page.CheckoutPage;
import net.thucydides.core.annotations.Step;
import org.intellij.lang.annotations.JdkConstants;
import org.junit.Assert;

import java.util.List;

public class CheckoutPageSteps {

    CheckoutPage checkoutPage;
    //Ciuverca Ionut
    @Step
    public void selectCheckoutMethodAndContinue(){
        checkoutPage.selectCheckoutMethod();
        checkoutPage.continueToCheckout();
    }
    //Ciuverca Ionut
    @Step
    public void completeTheCheckoutStepsAndPlaceOrder(){
        checkoutPage.fillTheRequiredFieldsForBilling();
        checkoutPage.fillTheRequiredFieldsForShipping();
        checkoutPage.setShippingMethodPaymentAndPlaceOrder();
    }
    @Step
    public void selectCheckoutMethod(){
        checkoutPage.clickOnWebElem(checkoutPage.getAsGuestRadioBtn());
        //checkoutPage.selectCheckoutMethod();
    }
    @Step
    public BillingInf fillRequestedFieldsForBilling(String firstN,String middleN,String lastN,String email,String adress,String city,String zip,String tel,String country,String state){
        return checkoutPage.fillRequestedFieldsForBilling(firstN,middleN,lastN,email,adress,city,zip,tel,country,state);

    }
    @Step
    public ShippingInform fillRequestedFieldsForShipping(String firstN,String lastN,String strAddr,String city,String zip,String tel,String country,String state){
        return checkoutPage.fillRequestedFieldsForShipping(firstN,lastN,strAddr,city,zip,tel,country,state);
    }
    @Step
    public void selectContinue(){
        checkoutPage.clickOnWebElem(checkoutPage.getContinueBtn());
    }
    @Step
    public void selectShippingMet(){
        checkoutPage.selectShippingMet();
    }
    @Step
    public void clickPlaceOrder(){
        checkoutPage.clickPlaceOrder();
    }
    @Step
    public List<CartProduct> getOrderReviewProducts(){
        return checkoutPage.getOrderReviewProd();
    }
    @Step
    public CartTotalPrices getOrderReviewTotals(){
        return checkoutPage.getOrderReviewTotals();
    }
    //Billing completed inf from right part
    //billing completed inf cu totul din dr,dupa ce completez la cheout billing inf
    @Step
    public String getBillingCompletedInf() {
    return checkoutPage.getBillingCompletedInf();
    }
    @Step
    public String[] splitByEnter(String s){
        return checkoutPage.splitedByEnter(s);
    }
    @Step
    public BillingInf getBillingCompletedInfAsObj(){
        return checkoutPage.getBillingCompletedInfAsObj();
    }
    @Step
    public void verifyIfBillingObjAreEqual(BillingInf actual,BillingInf expected){
        Assert.assertEquals(actual.getFirstN(),expected.getFirstN());
        Assert.assertEquals(actual.getMiddleN(),expected.getMiddleN());
        Assert.assertEquals(actual.getLastN(),expected.getLastN());
        Assert.assertEquals(actual.getCity(),expected.getCity());
        Assert.assertEquals(actual.getZip(),expected.getZip());
        Assert.assertEquals(actual.getState(),expected.getState());
        Assert.assertEquals(actual.getCountry(),expected.getCountry());
        Assert.assertEquals(actual.getTelephone(),expected.getTelephone());
        Assert.assertEquals(actual.getAddress(),expected.getAddress());
    }
    @Step
    public void verifyIfShippingObjAreEquals(ShippingInform actual,ShippingInform expected){
        Assert.assertEquals(actual.getFirstName(),expected.getFirstName());
        Assert.assertEquals(actual.getLastName(),expected.getLastName());
        Assert.assertEquals(actual.getCity(),expected.getCity());
        Assert.assertEquals(actual.getZip(),expected.getZip());
        Assert.assertEquals(actual.getState(),expected.getState());
        Assert.assertEquals(actual.getCountry(),expected.getCountry());
        Assert.assertEquals(actual.getTelephone(),expected.getTelephone());
        Assert.assertEquals(actual.getStreetAddr(),expected.getStreetAddr());
    }
    @Step
    public ShippingInform getShippingCompletedInfAsObj(){
        return checkoutPage.getShippingCompletedInfAsObj();
    }

}
