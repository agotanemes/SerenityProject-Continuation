package test;

import com.firestarters.models.CartProduct;
import com.firestarters.steps.CartPageSteps;
import com.firestarters.steps.HomepageSteps;
import com.firestarters.steps.ProductDetailsSteps;
import com.firestarters.steps.ProductPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(SerenityRunner.class)
public class ProductDetailsTest extends BaseTest{
    @Steps
    ProductPageSteps productPageSteps;
    @Steps
    HomepageSteps homepageSteps;
    @Steps
    ProductDetailsSteps productDetailsSteps;
    List<CartProduct> products = new ArrayList<CartProduct>();
    @Steps
    CartPageSteps cartPageSteps;
    @Test
    //modificare calc
    public void getCartProduct(){
        String name="TORI TANK";
        String name1="Lafayette Convertible Dress";
        String name2="ELIZABETH KNIT TOP";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name2);
        CartProduct cartProduct=productDetailsSteps.addProduct("Pink","S","2");
        productDetailsSteps.clickAddToCartBtn();
        products.add(cartProduct);

        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name1);
        //cand apelez metoda de addProduct imi setez si subtotalul pt un obiect de tip CartProduct ca fiind produsul dintre cantitate si pret
        CartProduct cartProduct1=productDetailsSteps.addProduct("Blue","2","1");
        productDetailsSteps.clickAddToCartBtn();
        products.add(cartProduct1);

        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name);
        CartProduct cartProduct2=productDetailsSteps.addProduct("Indigo","M","1");
        productDetailsSteps.clickAddToCartBtn();
        products.add(cartProduct2);

        //lista din cart
        List<CartProduct> productsFromCart=cartPageSteps.getProducts();
        //verificam ca produsele din cart sunt aceleasi cu cele pe care la-am introdus
        productDetailsSteps.verifyTwoCartListsAreEqual(products,productsFromCart);


    }


}
