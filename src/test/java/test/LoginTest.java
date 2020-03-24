package test;


import com.firestarters.models.User;
import com.firestarters.steps.LoginSteps;
import com.firestarters.utils.Constants;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class LoginTest extends BaseTest {
    @Steps
    LoginSteps loginSteps;
    @Test
    public void loginHappyFlow(){
        loginSteps.navigateToLoginPage();
        String email="stanciu_georgiana@yahoo.com";
        String password="stanciugeorgiana";
        User user=loginSteps.fillCredentials(email,password);
        loginSteps.clickLogin();
        String fName="stanciu";
        String lName="georgiana";
        loginSteps.verifyUserIsLogedIn(fName,lName);
    }
    @Test
    public void loginWithoutUserAndPass(){
        loginSteps.navigateToLoginPage();
        loginSteps.fillCredentials("","");
        loginSteps.clickLogin();
        loginSteps.verifyMessegesAreDisplayed();
    }
    @Test
    public void loginUserWithEmptyEmailAndWrongPass(){
        loginSteps.navigateToLoginPage();
        loginSteps.fillCredentials("","password");
        loginSteps.clickLogin();
        loginSteps.displayMessageEmailMandatoryField();
    }
    @Test
    public void loginUserWithEmptyEmailAndGoodPass(){
        loginSteps.navigateToLoginPage();
        loginSteps.fillCredentials("","stanciugeorgiana");
        loginSteps.clickLogin();
        loginSteps.displayMessageEmailMandatoryField();
    }
    @Test
    public void loginUserWithEmptyPassAndWrongEmail(){
        loginSteps.navigateToLoginPage();
        loginSteps.fillCredentials("nemes_agota@yahoo.com","");
        loginSteps.clickLogin();
        loginSteps.displayMessagePassMandatoryField();
    }
    @Test
    public void loginUserWithEmptyPassAndGoodEmail(){
        loginSteps.navigateToLoginPage();
        loginSteps.fillCredentials("stanciu_georgiana@yahoo.com","");
        loginSteps.clickLogin();
        loginSteps.displayMessagePassMandatoryField();
    }
    @Test
    public void loginUserWithInvalidCredentials(){
        loginSteps.navigateToLoginPage();
        loginSteps.fillCredentials("nem_agi_96@yahoo.com","password");
        loginSteps.clickLogin();
        loginSteps.displayErrorMessage();
    }
}
