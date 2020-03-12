package com.firestarters.steps;

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

}
