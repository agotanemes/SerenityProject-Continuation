package test;

import com.firestarters.models.CartProduct;
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

       // webdriver.get("http://qa2.dev.evozon.com/");
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name1);
        CartProduct cartProduct1=productDetailsSteps.addProduct("Blue","2","1");
        productDetailsSteps.clickAddToCartBtn();
        products.add(cartProduct1);

        webdriver.get("http://qa2.dev.evozon.com/");
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name);
        CartProduct cartProduct2=productDetailsSteps.addProduct("Indigo","M","1");
        productDetailsSteps.clickAddToCartBtn();
        products.add(cartProduct2);

        System.out.println(products.size());
        System.out.println(cartProduct.getColor()+" "+cartProduct.getSize()+" "+cartProduct.getQty()+" "+cartProduct.getProductName()+" "+cartProduct.getProductPrice());
        System.out.println(cartProduct1.getColor()+" "+cartProduct1.getSize()+" "+cartProduct1.getQty()+" "+cartProduct1.getProductName()+" "+cartProduct1.getProductPrice());
        System.out.println(cartProduct2.getColor()+" "+cartProduct2.getSize()+" "+cartProduct2.getQty()+" "+cartProduct2.getProductName()+" "+cartProduct2.getProductPrice());

    }


}
