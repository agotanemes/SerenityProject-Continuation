package com.firestarters.page;

import com.firestarters.models.BillingInf;
import com.firestarters.models.CartProduct;
import com.firestarters.models.CartTotalPrices;
import com.firestarters.models.ShippingInform;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.firestarters.utils.Utils.*;
import static org.junit.Assert.assertTrue;


public class CheckoutPage extends  AbstractPage {

   // @FindBy(id = "login:guest")
    @FindBy(css = "input[id='login:guest']")
    private WebElementFacade asGuestRadioButton;

    @FindBy(css = "#onepage-guest-register-button")
    private WebElementFacade continueButton;

    //Billing 20.03.2020
    //@FindBy(css = "select[title='Country']")
    @FindBy(css="select[id='billing:country_id']")
    private WebElementFacade countryDropdown;

    //@FindBy(css = "select[title='State/Province']")
    @FindBy(css="select[id='billing:region_id']")
    private WebElementFacade stateDropdown;

    @FindBy(css = "input[title*='different']")
    private WebElementFacade shipToDifferentAddressRadioButton;
    @FindBy(css="input[title*='different']")
    private WebElement shippingToThisAddressRadioBtn;

    @FindBy(css = "#billing-buttons-container button[title = 'Continue']")
    private WebElementFacade billingTabContinueButton;

//    @FindBy(id = "opc-shipping")
//    private WebElementFacade shippingTab;
    // Shipping
    @FindBy(css = "#shipping\\:firstname")
    private  WebElementFacade shippingFirstNameLabel;

    //@FindBy(css = "#shipping-new-address-form select[title='Country']")
    @FindBy(css="select[name*='shipping'][title='Country']")
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

    //Order review
    @FindBy(css="#checkout-review-table>tbody>tr")
    private List<WebElement> orderReviewProducts;
    @FindBy(css = "button[title='Place Order']")
    private WebElement placeOrderBtn;
    @FindBy(css="#checkout-review-table>tfoot td:nth-child(2)")
    private List<WebElement> totalPrices;
    //Billing completed inf from right
    @FindBy(css="#billing-progress-opcheckout>dd[class='complete']>address")
    //@FindBy(css = "#billing-progress-opcheckout address>br:nth-child(1)")
    private WebElement billingCompletedInf;


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
        getInputByTitle("First Name").sendKeys("Denes");
        getInputByTitle("Middle Name/Initial").sendKeys("Maria");
        getInputByTitle("Last Name").sendKeys("Ioana");
        getInputByTitle("Email Address").sendKeys("denes.maria@gmnail.com");
        getInputByTitle("Street Address").sendKeys("Petru Maior");
        getInputByTitle("City").sendKeys("Blaj");
        getInputByTitle("Zip/Postal Code").sendKeys("515400");
        getInputByTitle("Telephone").sendKeys("0755096274");
        countryDropdown.click();
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText("Romania");
        stateDropdown.click();
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText("Alba");
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
    //Agota 20.03.2020

    public ShippingInform fillRequestedFieldsForShipping(String firstN,String lastN,String strAddr,String city,String zip,String tel,String country,String state){
        //complete the fields
        getInputByTitle("First Name").sendKeys(firstN);
        getInputByTitle("Last Name").sendKeys(lastN);
        getInputByTitle("Street Address").sendKeys(strAddr);
        getInputByTitle("City").sendKeys(city);
        getInputByTitle("Zip/Postal Code").sendKeys(zip);
        getInputByTitle("Telephone").sendKeys(tel);
        clickOnWebElem(shippingConuntryDropdown);
        Select shippingCountrySelect = new Select(shippingConuntryDropdown);
        shippingCountrySelect.selectByVisibleText(country);
        clickOnWebElem(shippingStateDropdown);
        Select shippingStateSelect = new Select(shippingStateDropdown);
        shippingStateSelect.selectByVisibleText(state);
        //set the shiping inf in the shipininf obj.
        ShippingInform shippingInform=new ShippingInform();
        shippingInform.setFirstName(firstN);
        shippingInform.setLastName(lastN);
        shippingInform.setStreetAddr(strAddr);
        shippingInform.setCity(city);
        shippingInform.setZip(zip);
        shippingInform.setTelephone(tel);
        shippingInform.setCountry(country);
        shippingInform.setState(state);
        shippingTabContinueButton.click();
        //withTimeoutOf(Duration.ofSeconds(15)).waitFor(flatRateLabel);
        waitForWebElem(flatRateLabel);
        return shippingInform;
    }
    public void clickOnWebElem(WebElement element){
        element.click();
    }

    public BillingInf fillRequestedFieldsForBilling(String firstN,String middleN,String lastN,String email,String adress,String city,String zip,String tel,String country,String state){
        getInputByTitle("First Name").sendKeys(firstN);
        getInputByTitle("Middle Name/Initial").sendKeys(middleN);
        getInputByTitle("Last Name").sendKeys(lastN);
        getInputByTitle("Email Address").sendKeys(email);
        getInputByTitle("Street Address").sendKeys(adress);
        getInputByTitle("City").sendKeys(city);
        getInputByTitle("Zip/Postal Code").sendKeys(zip);
        getInputByTitle("Telephone").sendKeys(tel);
        clickOnWebElem(countryDropdown);
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(country);
        clickOnWebElem(stateDropdown);
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText(state);
        clickOnWebElem(shippingToThisAddressRadioBtn);
        clickOnWebElem(billingTabContinueButton);
        //waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#shipping\\:firstname")));
        //withTimeoutOf(Duration.ofSeconds(60)).waitFor(shippingFirstNameLabel);
        waitForWebElem(shippingFirstNameLabel);
        BillingInf billingInf=new BillingInf();
        billingInf.setFirstN(firstN);
        billingInf.setMiddleN(middleN);
        billingInf.setLastN(lastN);
        billingInf.setEmailAdr(email);
        billingInf.setAddress(adress);
        billingInf.setCity(city);
        billingInf.setZip(zip);
        billingInf.setTelephone(tel);
        billingInf.setCountry(country);
        billingInf.setState(state);
        return billingInf;
    }
    public WebElement getAsGuestRadioBtn(){
        return asGuestRadioButton;
    }
    public WebElement getContinueBtn(){
        return continueButton;
    }
    public void selectShippingMet(){
        clickOnWebElem(shippingMethodRadioButton);
        clickOnWebElem(shippingMethodContinueButton);
        //withTimeoutOf(Duration.ofSeconds(10)).waitFor(paymentContinueButton);
        waitForWebElem(paymentContinueButton);
        paymentContinueButton.click();
        //withTimeoutOf(Duration.ofSeconds(20)).waitFor(placeOrderBtn);
        waitForWebElem(placeOrderBtn);

    }
    public void clickPlaceOrder(){
        clickOnWebElem(placeOrderButton);
        withTimeoutOf(Duration.ofSeconds(10));
    }
    public List<CartProduct> getOrderReviewProd(){
        List<CartProduct> cartProducts=new ArrayList<>();
        List<WebElement> orderReviewprod= orderReviewProducts;
        for(WebElement prod:orderReviewprod){
            CartProduct cartProduct=new CartProduct();
            String name=prod.findElement(By.cssSelector(".product-name")).getText();
            String color=prod.findElement(By.cssSelector("dd:nth-child(2)")).getText();
            String size=prod.findElement(By.cssSelector("dd:nth-child(4)")).getText();
            String price=prod.findElement(By.cssSelector("td[data-rwd-label='Price']")).getText();
            Double correctPrice = convertStringToDouble(stringReplace(price));
            double priceAsdouble = correctPrice.doubleValue();
            String qty=prod.findElement(By.cssSelector("td[data-rwd-label='Qty']")).getText();
            String subtotal=prod.findElement(By.cssSelector("td[data-rwd-label='Subtotal']")).getText();
            Double correctSub=convertStringToDouble(stringReplace(subtotal));
            double subtotalAsDouble=correctSub.doubleValue();
            cartProduct.setName(name);
            cartProduct.setColor(color);
            cartProduct.setSize(size);
            cartProduct.setPrice(priceAsdouble);
            cartProduct.setQty(qty);
            cartProduct.setSubtotal(subtotalAsDouble);
            cartProducts.add(cartProduct);
        }
        return cartProducts;
    }
    public CartTotalPrices getOrderReviewTotals(){
        CartTotalPrices cartTotalPrices=new CartTotalPrices();
        String subtotal=totalPrices.get(0).getText();
        String tax=totalPrices.get(1).getText();
        String grandTotal=totalPrices.get(2).getText();
        double dSubtotal=convertStringToDouble(stringReplace(subtotal));
        double dTax=convertStringToDouble(stringReplace(tax));
        double dGrandTotal=convertStringToDouble(stringReplace(grandTotal));
        cartTotalPrices.setGrandTotal(dGrandTotal);
        cartTotalPrices.setTax(dTax);
        cartTotalPrices.setSubtotal(dSubtotal);
        return cartTotalPrices;
    }
    //Billing completed information from right side
    public String getBillingCompletedInf(){
        String s=billingCompletedInf.getText();
        return billingCompletedInf.getText();
    }
    public String[] splitedByEnter(String s){
        String[] slitedStr= splitByEnter(s);
        return slitedStr;
    }




}
