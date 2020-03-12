package com.firestarters.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.Assert;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class CheckoutPage extends  AbstractPage {

    @FindBy(id = "login:guest")
    private WebElementFacade asGuestRadioButton;

    @FindBy(css = "#onepage-guest-register-button")
    private WebElementFacade continueButton;

    @FindBy(css = "select[title='Country']")
    private WebElementFacade countryDropdown;

    @FindBy(css = "select[title='State/Province']")
    private WebElementFacade stateDropdown;

    @FindBy(css = "input[title*='different']")
    private WebElementFacade shipToDifferentAddressRadioButton;

    @FindBy(css = "#billing-buttons-container button[title = 'Continue']")
    private WebElementFacade billingTabContinueButton;

//    @FindBy(id = "opc-shipping")
//    private WebElementFacade shippingTab;

    @FindBy(css = "#shipping\\:firstname")
    private  WebElementFacade shippingFirstNameLabel;

    @FindBy(css = "#shipping-new-address-form select[title='Country']")
    private WebElementFacade shippingConuntryDropdown;

    @FindBy(css = "#shipping\\:region_id")
    private WebElementFacade shippingStateDropdown;

    @FindBy(css = "#shipping-buttons-container button[title=\"Continue\"]")
    private  WebElementFacade shippingTabContinueButton;

    @FindBy(css = ".sp-methods dt:first-child")
    private WebElementFacade flatRateLabel;

    @FindBy(css = ".sp-methods label[for*='free']")
    private WebElementFacade shippingMethodRadioButton;

    @FindBy(css = "#shipping-method-buttons-container button")
    private WebElementFacade shippingMethodContinueButton;

    @FindBy(css = "#payment-buttons-container button")
    private WebElementFacade paymentContinueButton;

    @FindBy(css = "button[title*='Place']")
    private WebElementFacade placeOrderButton;

    @FindBy(css = ".checkout-onepage-success")
    private WebElementFacade orderSuccessPage;

    @FindBy(css = ".page-title >h1")
    private WebElementFacade checkoutPageTitle;


    public WebElement getInputByTitle(String title){
        return getDriver().findElement(By.cssSelector("li.active input[title='" + title + "']"));
    }

    //Ciuverca Ionut
    public void selectCheckoutMethod(){
        asGuestRadioButton.click();
    }
    //Ciuverca Ionut
    public void continueToCheckout(){
        continueButton.click();
    }
    //Ciuverca Ionut
    public void fillTheRequiredFieldsForBilling(){
        getInputByTitle("First Name").sendKeys("John");
        getInputByTitle("Middle Name/Initial").sendKeys("Dossse");
        getInputByTitle("Last Name").sendKeys("Doe");
        getInputByTitle("Email Address").sendKeys("johndoe@mail.com");
        getInputByTitle("Street Address").sendKeys("Somesului");
        getInputByTitle("City").sendKeys("Cluj-Napoca");
        getInputByTitle("Zip/Postal Code").sendKeys("123456789");
        getInputByTitle("Telephone").sendKeys("0745123456");
        countryDropdown.click();
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Romania");

        stateDropdown.click();
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText("Cluj");

        shipToDifferentAddressRadioButton.click();
        billingTabContinueButton.click();

        withTimeoutOf(Duration.ofSeconds(5)).waitFor(shippingFirstNameLabel);
    }
    //Ciuverca Ionut
    public void fillTheRequiredFieldsForShipping(){
        getInputByTitle("First Name").sendKeys("John");
        getInputByTitle("Last Name").sendKeys("Doe");
        getInputByTitle("Street Address").sendKeys("Somesului");
        getInputByTitle("City").sendKeys("Cluj-Napoca");
        getInputByTitle("Zip/Postal Code").sendKeys("123456789");
        getInputByTitle("Telephone").sendKeys("0745123456");

        shippingConuntryDropdown.click();
        Select shippingCountrySelect = new Select(shippingConuntryDropdown);
        shippingCountrySelect.selectByVisibleText("Romania");

        shippingStateDropdown.click();
        Select shippingStateSelect = new Select(shippingStateDropdown);
        shippingStateSelect.selectByVisibleText("Cluj");
        shippingTabContinueButton.click();

        withTimeoutOf(Duration.ofSeconds(10)).waitFor(flatRateLabel);
    }
    //Ciuverca Ionut
    public void setShippingMethodPaymentAndPlaceOrder(){
        shippingMethodRadioButton.click();
        shippingMethodContinueButton.click();
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(paymentContinueButton);
        paymentContinueButton.click();
        withTimeoutOf(Duration.ofSeconds(10)).waitFor(placeOrderButton);
        placeOrderButton.click();
        withTimeoutOf(Duration.ofSeconds(10));
        assertTrue(checkoutPageTitle.isDisplayed());

    }

    public void clickOnDifferentAddressRadioButton(){
        shipToDifferentAddressRadioButton.click();
    }

    public void clickOnContinueButtonFromBilling(){
        billingTabContinueButton.click();
    }

    public void clickOnContinueButtonFromShipping(){
       shippingTabContinueButton.click();
    }

    public void clickOnShippingRadioButton(){
        shippingMethodRadioButton.click();
    }

    public void clickOnShippingMethodContinueButton(){
        shippingMethodContinueButton.click();
    }

    public void clickOnPaymentContinueButton(){
        paymentContinueButton.click();
    }

    public void clickOnPlaceOrderButton(){
        placeOrderButton.click();
    }






}
