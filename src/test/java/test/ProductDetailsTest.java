package test;

import com.firestarters.models.CartProduct;
import com.firestarters.steps.HomepageSteps;
import com.firestarters.steps.ProductDetailsSteps;
import com.firestarters.steps.ProductPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ProductDetailsTest extends BaseTest{
    @Steps
    ProductPageSteps productPageSteps;
    @Steps
    HomepageSteps homepageSteps;
    @Steps
    ProductDetailsSteps productDetailsSteps;
    @Test
    //modificare laptop 1
    public void getCartProduct(){
        String name="TORI TANK";
        String name1="Lafayette Convertible Dress";
        String name2="ELIZABETH KNIT TOP";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name2);
        CartProduct cartProduct=productDetailsSteps.getCartProduct("Pink","S","2");
        System.out.println(cartProduct.getColor()+" "+cartProduct.getSize()+" "+cartProduct.getQty()+" "+cartProduct.getProductName()+" "+cartProduct.getProductPrice());
        productDetailsSteps.clickAddToCartBtn();
    }


}
