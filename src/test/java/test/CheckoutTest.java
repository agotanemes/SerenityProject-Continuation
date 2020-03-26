package test;

import com.firestarters.models.CartProduct;
import com.firestarters.models.CartTotalPrices;
import com.firestarters.page.CartPage;
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
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
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
    List<CartProduct> addedProducts=new ArrayList<>();

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
        //add products to cart

        String name2="ELIZABETH KNIT TOP";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name2);
        CartProduct cartProduct=productDetailsSteps.addProduct("Pink","S","2");
        addedProducts.add(cartProduct);
        productDetailsSteps.clickAddToCartBtn();

        String name1="Lafayette Convertible Dress";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name1);
        CartProduct cartProduct1=productDetailsSteps.addProduct("Blue","6","1");
        addedProducts.add(cartProduct1);
        productDetailsSteps.clickAddToCartBtn();

        //click on Proceed to Checkout
        cartPageSteps.clickOnWebElem(cartPageSteps.getProceedToCheckoutBtn());
        checkoutPageSteps.selectCheckoutMethod();
        checkoutPageSteps.selectContinue();
        checkoutPageSteps.fillRequestedFieldsForBilling("Nemes","Melinda","Agota","agotanemes96@gmail.com","Str Petrisat nr 212","Blaj","515400","0755096274","Romania","Alba");
        checkoutPageSteps.fillRequestedFieldsForShipping("Nemes","Agota","Str Petrisat Nr 212","Blaj","515400","075509627","Romania","Alba");
        checkoutPageSteps.selectShippingMet();
        //product from order review
        List<CartProduct> products=checkoutPageSteps.getOrderReviewProducts();
        //verificare ca lista de produse adaugate in cart este aceeasi cu cea din order review de la checkout
        productDetailsSteps.verifyTwoCartListsAreEqual(products,addedProducts);
        //verificare ca totalurile din order review coincid cu cele calculate pe lista de produse adaugate in cart
        CartTotalPrices expected=cartPageSteps.getTotalPricesForOrderReview(addedProducts);
        CartTotalPrices actual=checkoutPageSteps.getOrderReviewTotals();
        cartPageSteps.verifyTotals(actual,expected);
        System.out.println(checkoutPageSteps.getBillingCompletedInf());
        String s=checkoutPageSteps.getBillingCompletedInf();
        String[] splitStr=checkoutPageSteps.splitByEnter(s);
        //System.out.println("size"+splitStr.length);
        System.out.println("name: "+splitStr[0]);
        System.out.println(splitStr.length);
        checkoutPageSteps.clickPlaceOrder();

    }
}
