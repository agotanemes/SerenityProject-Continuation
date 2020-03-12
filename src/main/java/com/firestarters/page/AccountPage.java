package com.firestarters.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;


import java.time.Duration;
import java.util.List;

@DefaultUrl("http://qa2.dev.evozon.com/customer/account/")
public class AccountPage extends AbstractPage {

    @FindBy(css = " .main-container.col1-layout >div  >div >div:nth-child(2) ")
    private WebElementFacade orderConfirmationMessage;

    @FindBy(css = " .col-main p:nth-child(4) >a ")
    private WebElementFacade orderNumber;

    @FindBy(css = " .block-account ul >li:nth-child(4) a")
    private WebElementFacade myOrdersButton;

    @FindBy ( css = " .first.odd>td.number ")
    private WebElementFacade myLastOrder;


    public String getOrderConfirmationMessage() {
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(orderConfirmationMessage);
        return orderConfirmationMessage.getText();
    }

    public String getOrderNumber() {
        return orderNumber.getText();
    }

    public void clickMyOrdersButton() {
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(myOrdersButton);
        myOrdersButton.click();
    }

    public String checkMyOrdersList() {
        return myLastOrder.getText();


    }




}





