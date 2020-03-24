package com.firestarters.steps;

import com.firestarters.models.BillingInf;
import com.firestarters.models.CartProduct;
import com.firestarters.models.CartTotalPrices;
import com.firestarters.models.ShippingInform;
import com.firestarters.page.CheckoutPage;
import net.thucydides.core.annotations.Step;
import org.intellij.lang.annotations.JdkConstants;

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

}
