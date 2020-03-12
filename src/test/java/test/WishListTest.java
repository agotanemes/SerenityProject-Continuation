package test;
import com.firestarters.steps.HeaderSteps;
import com.firestarters.steps.LoginSteps;
import com.firestarters.steps.SearchPageSteps;
import com.firestarters.steps.WishListSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class WishListTest extends BaseTest {

    @Steps
    WishListSteps wishListSteps;
    @Steps
    LoginSteps loginSteps;
    @Steps
    SearchPageSteps searchPageSteps;


    @Test
    public void checkLoginPageDisplayedWhenNotLoggedIn(){
        wishListSteps.clicksOnWishListBtnWhenNotLoggedIn();
    }
    @Test
    public void verifyMyWishlistPageDisplayedWhenLoggedIn(){
        wishListSteps.clicksOnWishListWhenLoggedIn();
    }

    @Test
    public void verifyMsgAddedInWishListIsDisplayed() {
        loginSteps.navigateToLoginPage();
        loginSteps.loginUser();
        searchPageSteps.addProductFromSearch("dress", "dress");
        wishListSteps.clickOnWishListBtninCart();
        Assert.assertTrue(wishListSteps.getSuccesMsgAddedInWishlist().contains("moved to wishlist Wishlist"));
    }
    @Test
    public void verifyQuantityOfproductInWishlistisUpdated(){
        wishListSteps.clicksOnWishListWhenLoggedIn();
        String newQuantity = "7";
        wishListSteps.updateQuantityOfInput(newQuantity);
    }

}