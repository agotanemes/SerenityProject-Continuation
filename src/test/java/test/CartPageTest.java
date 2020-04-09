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

import java.awt.*;
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
        //1)produse care se adauga in cos
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

        //2)verificare totaluri calculate pe produsele adaugate in cart (addedProducts) si cel luat din cart de pe ui
        //un obiect care are calculate grand total,subtotal si tax pe baza listei de produse adaugate
        CartTotalPrices expected=cartPageSteps.calculatePricesThatComposeGrandTotal(addedProducts);
        //un obiect care ia grand Total,subtotal si tax de pe fron, din cart
        CartTotalPrices actual=cartPageSteps.getPricesThatComposeGrangTotal();
        //verificam ca cele doua obiecte sunt la fel
        cartPageSteps.verifyTotals(actual,expected);

        //3)luam nr de produse de la cartul din headerul paginii (CART(0)) si verificam daca acesta este egal cu nr de produse din addedProducts
        cartPageSteps.verifyNrOfProductsFromCart(addedProducts);

        //4)verificarea faptului ca la Account->My Cart(x items) nr de itemuri este egal cu suma de qty-uri pentru lista de produse adaugate in cos
        cartPageSteps.clickOnWebElem(cartPageSteps.getAccount());
        cartPageSteps.verifyCartItemsAreEqualToNrAddedItems(addedProducts);

        //5)DELETE produs din cart +Verificari
        cartPageSteps.deleteProductFromCart("LAFAYETTE CONVERTIBLE DRESS");
        //stergere produs din lista de produse introduse in cart
        cartPageSteps.removeProductFromAddedProdList("LAFAYETTE CONVERTIBLE DRESS",addedProducts);
        //verificarea faptului ca listele sunt egale dupa stergere
        List<CartProduct> cartProducts=cartPageSteps.getProducts();
        productDetailsSteps.verifyTwoCartListsAreEqual(cartProducts,addedProducts);
        //6)verificare totalurile dupa stergerea unui produs din cart
        //un obiect care are calculate grand total,subtotal si tax pe baza listei de produse adaugate
        CartTotalPrices expectedAfterDelete=cartPageSteps.calculatePricesThatComposeGrandTotal(addedProducts);
        //un obiect care ia grand Total,subtotal si tax de pe fron, din cart
        CartTotalPrices actualAfterDelete=cartPageSteps.getPricesThatComposeGrangTotal();
        cartPageSteps.verifyTotals(actualAfterDelete,expectedAfterDelete);

        //7)modificarea cantitatii unui produs din cart + verificari
        cartPageSteps.modifyProductFromCart("ELIZABETH KNIT TOP","3");
        cartPageSteps.modifyProductQty("ELIZABETH KNIT TOP","3",addedProducts);
        List<CartProduct> cartProductsAfterChanges=cartPageSteps.getProducts();
        productDetailsSteps.verifyTwoCartListsAreEqual(cartProductsAfterChanges,addedProducts);
        //8)verificare totaluri dupa modificarea cantitatii unui produs din cart
        //un obiect care are calculate grand total,subtotal si tax pe baza listei de produse adaugate
        CartTotalPrices expectedAfterModify=cartPageSteps.calculatePricesThatComposeGrandTotal(addedProducts);
        //un obiect care ia grand Total,subtotal si tax de pe fron, din cart
        CartTotalPrices actualAfterModify=cartPageSteps.getPricesThatComposeGrangTotal();
        cartPageSteps.verifyTotals(actualAfterModify,expectedAfterModify);

        //Minicart
        cartPageSteps.clickOnWebElem(cartPageSteps.getMiniCart());
        List<CartProduct> minicartProducts=cartPageSteps.getMiniCartRecentlyAddedProd();
        //9)verificare ca produsele din mini cart (ultimele trei adaugate) sunt aceleasi cu ultimele 3 produse din lista de produse adaugate in cart
        cartPageSteps.checkCartListContainsAnotherCartList(minicartProducts,addedProducts);

        //10)modificarea cantitatii unui produs din mini cart+ teste
        cartPageSteps.modifyMiniCartProduct("ELIZABETH KNIT TOP","4");
        webdriver.navigate().refresh();
        //verificam ca s-a schimbat si in cart ce am modificat si in miniCart
        List<CartProduct> cartProductAfterChangesInMiniCart=cartPageSteps.getProducts();
        cartPageSteps.clickOnWebElem(cartPageSteps.getMiniCart());
        List<CartProduct> miniCartProductsAfterProdCartChanges=cartPageSteps.getMiniCartRecentlyAddedProd();
        cartPageSteps.checkCartListContainsAnotherCartList(miniCartProductsAfterProdCartChanges,cartProductAfterChangesInMiniCart);
        //modificam cantitatea produsului si in addedProducts si verificam ca ultimele 3 produse de aici sunt aceleasi cu cele din minicart
        System.out.println("Mini cart dupa modificare cantitate produs in 4");
        for(CartProduct p:miniCartProductsAfterProdCartChanges){
            System.out.println(p);
        }
        cartPageSteps.modifyProductQty("ELIZABETH KNIT TOP","4",addedProducts);
        System.out.println("adderProducts dupa modificare cantitate produs in 4");
        for(CartProduct p:addedProducts){
            System.out.println(p);
        }
        cartPageSteps.checkCartListContainsAnotherCartList(miniCartProductsAfterProdCartChanges,addedProducts);

        //11)stergem un produs din miniCart+teste
        //cartPageSteps.clickOnWebElem(cartPageSteps.getMiniCart());
        cartPageSteps.removeMiniCartProduct("ELIZABETH KNIT TOP");
        webdriver.navigate().refresh();
        cartPageSteps.clickOnWebElem(cartPageSteps.getMiniCart());
        List<CartProduct> miniCartProds=cartPageSteps.getMiniCartRecentlyAddedProd();
        cartPageSteps.findProductInList("ELIZABETH KNIT TOP",miniCartProds);
        //luam produsele din cart de pe front
        List<CartProduct> cartProductForMinicart=cartPageSteps.getProducts();
        //stergem produsul sters din mini cart si din addedProducts
        cartPageSteps.removeProductFromAddedProdList("ELIZABETH KNIT TOP",addedProducts);
        //verificam ca listele sunt egale
        productDetailsSteps.verifyTwoCartListsAreEqual(cartProductForMinicart,addedProducts);
        //verificam ca produsele din recently added se gasesc printre produsele din cart
        //cartPageSteps.clickOnWebElem(cartPageSteps.getMiniCart());
        List<CartProduct> miniCartProdsAfterDelete=cartPageSteps.getMiniCartRecentlyAddedProd();
        cartPageSteps.checkCartListContainsAnotherCartList(miniCartProdsAfterDelete,cartProductForMinicart);
        cartPageSteps.checkCartListContainsAnotherCartList(miniCartProdsAfterDelete,addedProducts);






    }
}
