package com.firestarters.steps;

import com.firestarters.models.BillingInf;
import com.firestarters.page.CheckoutPage;
import net.thucydides.core.annotations.Step;

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
        checkoutPage.selectCheckoutMethod();
    }
    @Step
    public BillingInf fillRequestedFieldsForBilling(String firstN,String middleN,String lastN,String email,String adress,String city,String zip,String tel,String country,String state){
        return checkoutPage.fillRequestedFieldsForBilling(firstN,middleN,lastN,email,adress,city,zip,tel,country,state);

    }

}
