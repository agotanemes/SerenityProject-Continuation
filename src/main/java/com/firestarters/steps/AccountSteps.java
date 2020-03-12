package com.firestarters.steps;

import com.firestarters.page.AccountPage;
import com.firestarters.page.CheckoutPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AccountSteps  {

    @Steps
    CheckoutPage checkoutPage;

    @Steps
    AccountPage accountPage;

    @Step
    public void checkoutAsUser(){
        checkoutPage.clickOnDifferentAddressRadioButton();
        checkoutPage.clickOnContinueButtonFromBilling();
        checkoutPage.clickOnContinueButtonFromShipping();
        checkoutPage.clickOnShippingRadioButton();
        checkoutPage.clickOnShippingMethodContinueButton();
        checkoutPage.clickOnPaymentContinueButton();
        checkoutPage.clickOnPlaceOrderButton();
    }

    @Step
    public void checkIfOrderHasBeenSent() {
        System.out.println(accountPage.getOrderConfirmationMessage());
        Assert.assertTrue(accountPage.getOrderConfirmationMessage().toUpperCase().contains("YOUR ORDER HAS BEEN RECEIVED."));
    }

    @Step
    public void getOrderNumber(){
        System.out.println(accountPage.getOrderNumber());
    }

    @Step
    public void clickMyOrdersButton(){
        accountPage.clickMyOrdersButton();
    }

/*    @Step
    public void checkMyOrdersListIsCorrect(){
        accountPage.checkMyOrdersList();
        Assert.assertEquals(accountPage.getOrderNumber(), accountPage.checkMyOrdersList());

    should check with objects cause we lose the number order
    }*/








}
