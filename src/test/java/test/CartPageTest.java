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

    @Test
    public void correctSubtotal(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginUser();
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
        String name1="Lafayette Convertible Dress";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name2);
        CartProduct cartProduct=productDetailsSteps.addProduct("Pink","S","2");
        productDetailsSteps.clickAddToCartBtn();

        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name1);
        CartProduct cartProduct1=productDetailsSteps.addProduct("Blue","2","2");
        productDetailsSteps.clickAddToCartBtn();

        List<CartProduct> products=cartPageSteps.getProducts();
        System.out.println("Products from cart:");
        for(CartProduct product:products){
            System.out.println(product.getName()+" "+product.getColor()+" "+product.getSize()+" "+product.getQty()+" "+product.getPrice()+" "+product.getSubtotal());
        }
        //un obiect care are calculate grand total,subtotal si tax
        CartTotalPrices actual=cartPageSteps.calculatePricesThatComposeGrandTotal();
        //un obiect care ia grand Total,subtotal si tax de pe fron, din cart
        CartTotalPrices expected=cartPageSteps.getPricesThatComposeGrangTotal();
        //verificam ca cele doua obiecte sunt la fel
        cartPageSteps.verifyTotals(actual,expected);
    }
}
