package test;


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
        loginSteps.loginUser();
        String fName="Manolachi".toLowerCase();
        String lName="Ioana".toLowerCase();
        loginSteps.verifyUserIsLogedIn(fName,lName);
    }
    @Test
    public void loginWithoutUserAndPass(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginUserWithEmptyFields();
        loginSteps.verifyMessegesAreDisplayed();
    }
    @Test
    public void loginUserWithEmptyEmailAndWrongPass(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginUserWithEmptyEmailAndWrongPass();
        loginSteps.displayMessageEmailMandatoryField();
    }
    @Test
    public void loginUserWithEmptyEmailAndGoodPass(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginUserWithEmptyEmailAndGoodPass();
        loginSteps.displayMessageEmailMandatoryField();
    }
    @Test
    public void loginUserWithEmptyPassAndWrongEmail(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginUserWithEmptyPassAndWrongEmail();
        loginSteps.displayMessagePassMandatoryField();
    }
    @Test
    public void loginUserWithEmptyPassAndGoodEmail(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginUserWithEmptyPassAndGoodEmail();
        loginSteps.displayMessagePassMandatoryField();
    }
    @Test
    public void loginUserWithInvalidCredentials(){
        loginSteps.navigateToLoginPage();
        loginSteps.loginWithInvalidCredentials();
        loginSteps.displayErrorMessage();
    }
}
