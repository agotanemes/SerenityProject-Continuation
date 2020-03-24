package com.firestarters.steps;


import com.firestarters.models.User;
import com.firestarters.page.HeaderPage;
import com.firestarters.page.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import static com.firestarters.utils.Utils.getRandomString;


public class LoginSteps {
    LoginPage loginPage;

    @Step
    public User fillCredentials(String email,String password){
        return loginPage.fillCredentials(email,password);
    }

    @Step
    public void clickLogin(){
        loginPage.clickLoginButton();
    }

    @Step
    public void navigateToLoginPage(){
        loginPage.open();
    }
    @Step
    public void verifyUserIsLogedIn(String fName, String lName){
        String greetMessage = loginPage.getGreetMessage().toLowerCase();
        Assert.assertTrue(greetMessage.contains(fName.toLowerCase()));
        Assert.assertTrue(greetMessage.contains(lName.toLowerCase()));
    }

    @Step
    public void verifyMessegesAreDisplayed(){
        String requiredEmailMessage=loginPage.getRequiredEmailMessage();
        String requiredPassMessage=loginPage.getRequiredPassMessage();
        Assert.assertEquals(requiredEmailMessage,"This is a required field.");
        Assert.assertEquals(requiredPassMessage,"This is a required field.");
    }
    @Step
    public void displayMessageEmailMandatoryField(){
        String requiredEmailMessage=loginPage.getRequiredEmailMessage();
        Assert.assertEquals(requiredEmailMessage,"This is a required field.");
    }
    @Step
    public void displayMessagePassMandatoryField(){
        String requiredPasslMessage=loginPage.getRequiredPassMessage();
        Assert.assertEquals(requiredPasslMessage,"This is a required field.");
    }
    @Step
    public void displayErrorMessage(){
        String errorMessage=loginPage.getErrormessage();
        Assert.assertEquals(errorMessage,"Invalid login or password.");
    }


}
