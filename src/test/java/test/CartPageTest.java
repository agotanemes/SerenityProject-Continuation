package test;

import com.firestarters.models.CartProduct;
import com.firestarters.models.CartTotalPrices;
import com.firestarters.page.CartPage;
import com.firestarters.steps.*;
import com.firestarters.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

//changes
//@RunWith(SerenityParameterizedRunner.class)
//@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "CartPageProducts.csv")
//old value
@RunWith(SerenityRunner.class)
public class CartPageTest extends BaseTest{

    @Steps
    CartPageSteps cartPageSteps;
    private String searchProduct,text;
    @Steps
    LoginSteps loginSteps;
    @Steps
    SearchPageSteps searchPageSteps;
    @Steps
    HomepageSteps homepageSteps;
    @Steps
    ProductPageSteps productPageSteps;
    @Steps
    ProductDetailsSteps productDetailsSteps;
    @Steps
    CheckoutPageSteps checkoutPageSteps;
    List<CartProduct> addedProducts=new ArrayList<>();
    @Test
    public void correctSubtotal(){
        loginSteps.navigateToLoginPage();
        loginSteps.fillCredentials("stanciu_georgiana@yahoo.com","stanciugeorgiana");
        //old values
        //searchPageSteps.addProductFromSearch("eye","eye");
       // searchPageSteps.addProductFromSearch("table","table");
        webdriver.get("http://qa2.dev.evozon.com/checkout/cart/");
        cartPageSteps.verifyIfSubtotalIsCorrect();
        //or
       //webdriver.get("http://qa2.dev.evozon.com/checkout/cart/");
        //changes
        //searchPageSteps.addProductFromSearch(searchProduct,text);
        //cartPageSteps.verifyIfSubtotalIsCorrect();
    }
    @Test
    public void getProducts(){
        //produse care se adauga in cos


        String name2="ELIZABETH KNIT TOP";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name2);
        CartProduct cartProduct=productDetailsSteps.addProduct("Pink","S","2");
        productDetailsSteps.clickAddToCartBtn();
        addedProducts.add(cartProduct);

        String name1="Lafayette Convertible Dress";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name1);
        CartProduct cartProduct1=productDetailsSteps.addProduct("Blue","2","2");
        productDetailsSteps.clickAddToCartBtn();
        addedProducts.add(cartProduct1);

        //un obiect care are calculate grand total,subtotal si tax pe baza listei de produse adaugate
        CartTotalPrices expected=cartPageSteps.calculatePricesThatComposeGrandTotal(addedProducts);
        //un obiect care ia grand Total,subtotal si tax de pe fron, din cart
        CartTotalPrices actual=cartPageSteps.getPricesThatComposeGrangTotal();
        //verificam ca cele doua obiecte sunt la fel
        cartPageSteps.verifyTotals(actual,expected);
        //nr de produse din cart ramane 0 indiferent cate produse bagam in cart
        cartPageSteps.verifyNrOfProductsFromCart();
        //verificarea faptului ca la Account->My Cart(x items) nr de itemuri este egal cu suma de qty-uri pentru lista de produse adaugate in cos
        cartPageSteps.clickOnWebElem(cartPageSteps.getAccount());
        cartPageSteps.verifyCartItemsAreEqualToNrAddedItems(addedProducts);

    }
}
