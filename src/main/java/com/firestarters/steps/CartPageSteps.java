package com.firestarters.steps;

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

}


