package test;

import com.firestarters.steps.CartPageSteps;
import com.firestarters.steps.LoginSteps;
import com.firestarters.steps.SearchPageSteps;
import com.firestarters.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
//old value
//@RunWith(SerenityRunner.class)
//changes
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = Constants.CSV_FILES_PATH + "CartPageProducts.csv")
public class CartPageTest extends BaseTest{

    @Steps
    CartPageSteps cartPageSteps;
    private String searchProduct,text;
    @Steps
    LoginSteps loginSteps;
    @Steps
    SearchPageSteps searchPageSteps;

    @Test
    public void correctSubtotal(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginUser();
        //old values
        //searchPageSteps.addProductFromSearch("eye","eye");
        //searchPageSteps.addProductFromSearch("table","table");
        //or
       // webdriver.get("http://qa2.dev.evozon.com/checkout/cart/");
        //changes
        searchPageSteps.addProductFromSearch(searchProduct,text);
        cartPageSteps.verifyIfSubtotalIsCorrect();
    }
}
