package test;

import com.firestarters.models.CartProduct;
import com.firestarters.models.CartTotalPrices;
import com.firestarters.steps.*;
import com.firestarters.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

import static net.thucydides.core.steps.stepdata.StepData.withTestDataFrom;


/**
 *
 * @author ionutciuverca
 *
 */
@RunWith(SerenityRunner.class)
public class CheckoutTest extends BaseTest {

//    @Managed(uniqueSession = true)
//    private WebDriver webdriver;
    @Steps
    HeaderSteps headerSteps;

    @Steps
    ProductPageSteps productPageSteps;

    @Steps
    ProductDetailsSteps productDetailsSteps;

    @Steps
    SearchPageSteps searchPageSteps;

    @Steps
    CartPageSteps cartPageSteps;

    @Steps
    CheckoutPageSteps checkoutPageSteps;
    @Steps
    HomepageSteps homepageSteps;
    public String searchWord, expectedWordInTitle;

    @Test
    public void checkoutTest(){
        headerSteps.goToProductsPage();
        productPageSteps.selectAProduct();
        productDetailsSteps.configureProductAndAddToCart();
        //give this params : // "Eye" and "eye"
        searchPageSteps.addProductFromSearch(searchWord, expectedWordInTitle);
        cartPageSteps.proceedToCheckout(2);
        checkoutPageSteps.selectCheckoutMethodAndContinue();
        checkoutPageSteps.completeTheCheckoutStepsAndPlaceOrder();
    }

    @Test
    public void checkoutTestWithDDTOnlySteps() throws IOException {

        headerSteps.goToProductsPage();
        productPageSteps.selectAProduct();
        productDetailsSteps.configureProductAndAddToCart();
        //give this params : // "Eye" and "eye"
        withTestDataFrom(Constants.CSV_FILES_PATH + "ciuve.csv")
                .run(searchPageSteps).addProductFromSearchDDT();
        cartPageSteps.proceedToCheckout(2);
        checkoutPageSteps.selectCheckoutMethodAndContinue();
        checkoutPageSteps.completeTheCheckoutStepsAndPlaceOrder();
    }
    @Test
    public void checkoutTests(){
        String name2="ELIZABETH KNIT TOP";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name2);
        CartProduct cartProduct=productDetailsSteps.addProduct("Pink","S","2");
        productDetailsSteps.clickAddToCartBtn();
        //click on Proceed to Checkout
        cartPageSteps.clickOnWebElem(cartPageSteps.getProceedToCheckoutBtn());
        checkoutPageSteps.selectCheckoutMethod();
        checkoutPageSteps.selectContinue();
        checkoutPageSteps.fillRequestedFieldsForBilling("Nemes","Melinda","Agota","agotanemes96@gmail.com","Str Petrisat nr 212","Blaj","515400","0755096274","Romania","Alba");
        checkoutPageSteps.fillRequestedFieldsForShipping("Nemes","Agota","Str Petrisat Nr 212","Blaj","515400","0755096274");

    }
}
