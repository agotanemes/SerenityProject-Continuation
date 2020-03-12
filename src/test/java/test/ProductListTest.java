package test;

import com.firestarters.steps.HomepageSteps;
import com.firestarters.steps.ProductPageSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ProductListTest extends BaseTest {
    @Steps
    ProductPageSteps productPageSteps;
    @Steps
    HomepageSteps homepageSteps;
    @Test
    public void openProduct(){
        String name="TORI TANK";
        String name1="Lafayette Convertible Dress";
        homepageSteps.clickOnSubcategoryOfACategory("Women","New Arrivals");
        productPageSteps.openProduct(name1);
    }
}
