package test;


import com.firestarters.page.ProductDetailsPage;
import com.firestarters.page.ProductListPage;
import com.firestarters.page.SearchPage;
import com.firestarters.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class AddToCartTest extends BaseTest{

   @Steps
    SearchPageSteps searchPageSteps;

   @Steps
    HomepageSteps homepageSteps;

   @Steps
   HeaderSteps headerSteps;

   @Steps
    ProductPageSteps productPageSteps;

   @Steps
   CartPageSteps cartPageSteps;

    @Test
    public void TestIfProductIsAddedBySearching(){
   searchPageSteps.addProductFromSearch("dress", "dress");
   cartPageSteps.verifyIfProductTableIsDisplayed();
    }

    @Test
    public void TestIfProducIsAddedFromHomepage(){
        homepageSteps.selectProductFromNewProductsOnHomepage();
        homepageSteps.selectDetails();
        cartPageSteps.verifyIfProductTableIsDisplayed();
    }

    @Test
    public void TestIfProductIsAddedByNavigate(){
        headerSteps.goToProductsPage();
        productPageSteps.selectAProduct();
        homepageSteps.selectDetails();
        cartPageSteps.verifyIfProductTableIsDisplayed();
    }




}
