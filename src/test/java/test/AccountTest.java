package test;

import com.firestarters.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AccountTest extends BaseTest {

    @Steps
    CheckoutPageSteps checkoutPageSteps;

    @Steps
    HeaderSteps headerSteps;

    @Steps
    ProductPageSteps productPageSteps;

    @Steps
    ProductDetailsSteps productDetailsSteps;

    @Steps
    CartPageSteps cartPageSteps;

    @Steps
    SearchPageSteps searchPageSteps;

    @Steps
    LoginSteps loginSteps;

    @Steps
    HomepageSteps homepageSteps;

    @Steps
    AccountSteps accountSteps;




    @Test
    public void testIfMyordersAreCorrect(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginUser();
        headerSteps.goToProductsPage();
        productPageSteps.selectAProduct();
        homepageSteps.selectDetails();
        cartPageSteps.verifyIfProductTableIsDisplayed();
        cartPageSteps.proceedToCheckoutForVerify();
        accountSteps.checkoutAsUser();
        accountSteps.checkIfOrderHasBeenSent();
        accountSteps.getOrderNumber();
        headerSteps.clickOnAccountButton();
        headerSteps.clickOnAccountButtonFromDropDown();
        accountSteps.clickMyOrdersButton();
//        accountSteps.checkMyOrdersListIsCorrect();








    }


}
