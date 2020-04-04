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
    /*final double tax=90.75;
    final double taxAfterDelete=34.65;
    final double taxAftermodify=51.98;*/
    final double tax=95.70;
    final double taxAfterDelete=39.60;
    final double taxAftermodify=56.93;
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
        CartProduct cartProduct1=productDetailsSteps.addProduct("Blue","6","2");
        productDetailsSteps.clickAddToCartBtn();
        addedProducts.add(cartProduct1);

        String name="TORI TANK";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name);
        CartProduct cartProduct2=productDetailsSteps.addProduct("Indigo","M","1");
        productDetailsSteps.clickAddToCartBtn();
        addedProducts.add(cartProduct2);

        //un obiect care are calculate grand total,subtotal si tax pe baza listei de produse adaugate
        CartTotalPrices expected=cartPageSteps.calculatePricesThatComposeGrandTotal(addedProducts,tax);
        //un obiect care ia grand Total,subtotal si tax de pe fron, din cart
        CartTotalPrices actual=cartPageSteps.getPricesThatComposeGrangTotal();
        //verificam ca cele doua obiecte sunt la fel
        cartPageSteps.verifyTotals(actual,expected);
        //nr de produse din cart ramane 0 indiferent cate produse bagam in cart
        cartPageSteps.verifyNrOfProductsFromCart();
        //verificarea faptului ca la Account->My Cart(x items) nr de itemuri este egal cu suma de qty-uri pentru lista de produse adaugate in cos
        cartPageSteps.clickOnWebElem(cartPageSteps.getAccount());
        cartPageSteps.verifyCartItemsAreEqualToNrAddedItems(addedProducts);

        //DELETE+Verificari
        //delete product from cart
        cartPageSteps.deleteProductFromCart("LAFAYETTE CONVERTIBLE DRESS");
        //stergere produs din lista de produse introduse in cart
        cartPageSteps.removeProductFromAddedProdList("LAFAYETTE CONVERTIBLE DRESS",addedProducts);
        //verificarea faptului ca listele sunt egale dupa stergere
        List<CartProduct> cartProducts=cartPageSteps.getProducts();
        productDetailsSteps.verifyTwoCartListsAreEqual(cartProducts,addedProducts);
        //verificare totaluri
        //un obiect care are calculate grand total,subtotal si tax pe baza listei de produse adaugate
        CartTotalPrices expectedAfterDelete=cartPageSteps.calculatePricesThatComposeGrandTotal(addedProducts,taxAfterDelete);
        //un obiect care ia grand Total,subtotal si tax de pe fron, din cart
        CartTotalPrices actualAfterDelete=cartPageSteps.getPricesThatComposeGrangTotal();
        cartPageSteps.verifyTotals(actualAfterDelete,expectedAfterDelete);
        //modify
        cartPageSteps.modifyProductFromCart("ELIZABETH KNIT TOP","3");
        cartPageSteps.modifyProductQty("ELIZABETH KNIT TOP","3",addedProducts);
        List<CartProduct> cartProductsAfterChanges=cartPageSteps.getProducts();
        productDetailsSteps.verifyTwoCartListsAreEqual(cartProductsAfterChanges,addedProducts);
        //verificare totaluri
        //un obiect care are calculate grand total,subtotal si tax pe baza listei de produse adaugate
        CartTotalPrices expectedAfterModify=cartPageSteps.calculatePricesThatComposeGrandTotal(addedProducts,taxAftermodify);
        //un obiect care ia grand Total,subtotal si tax de pe fron, din cart
        CartTotalPrices actualAfterModify=cartPageSteps.getPricesThatComposeGrangTotal();
        cartPageSteps.verifyTotals(actualAfterModify,expectedAfterModify);
        //minicart
        cartPageSteps.clickOnWebElem(cartPageSteps.getMiniCart());
        List<CartProduct> minicartProducts=cartPageSteps.getMiniCartRecentlyAddedProd();
        for(CartProduct p:minicartProducts){
            System.out.println("index ");
            System.out.println(p.getName());
            System.out.println(p.getQty());
            System.out.println(p.getPrice());
            System.out.println(p.getSubtotal());
        }
        cartPageSteps.checkCartListContainsAnotherCartList(minicartProducts,addedProducts);



    }
}
