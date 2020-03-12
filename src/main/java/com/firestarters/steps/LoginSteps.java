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
    HeaderPage headerPage;
    //generate user types
    @Step
    public User generateUser(){
        User user=new User();
        user.setEmail("manolachi_ioana@yahoo.com");
        user.setPass("manolachiioana");
        return user;
    }
    @Step
    public User generateEmptyUser(){
        User user=new User();
        user.setEmail("");
        user.setPass("");
        return user;
    }
    @Step
    public User generateUserWithEmptyEmailAndWrongPass(){
        User user=new User();
        user.setEmail("");
        user.setPass(getRandomString());
        return user;
    }
    @Step
    public User generateUserWithEmptyEmailAndGoodPass(){
        User user=new User();
        user.setEmail("");
        user.setPass("manolachiioana");
        return user;
    }
    @Step
    public User generateUserWithEmptyPassAndWrongEmail(){
        User user=new User();
        user.setEmail(getRandomString()+"@gmail.com");
        user.setPass("");
        return user;
    }
    @Step
    public User generateUserWithEmptyPassAndGoodEmail(){
        User user=new User();
        user.setEmail("manolachi_ioana@gmail.com");
        user.setPass("");
        return user;
    }
    public User generateNonRegeisteredUser(){
        User user=new User();
        user.setEmail("pamparau_roxana@yahoo.com");
        user.setPass("pamparauroxana");
        return user;
    }
    //---------------------------------------
    @Step
    public void navigateToLoginPage(){
        loginPage.open();
    }
    @Step
    public void fillLoginData(User user){
        loginPage.typeEmail(user.getEmail());
        loginPage.typePass(user.getPass());
    }
    @Step
    public void clickLogin(){
        loginPage.clickLoginButton();
    }
    //login scenarious
    @Step
    public void loginUser(){
        //complete Login fields
        fillLoginData(generateUser());
        //click Login
        clickLogin();
    }
    @Step
    public void loginUserWithEmptyFields(){
        fillLoginData(generateEmptyUser());
        clickLogin();
    }
    @Step
    public void loginUserWithEmptyEmailAndWrongPass(){
        fillLoginData(generateUserWithEmptyEmailAndWrongPass());
        clickLogin();
    }
    @Step
    public void loginUserWithEmptyEmailAndGoodPass(){
        fillLoginData(generateUserWithEmptyEmailAndGoodPass());
        clickLogin();
    }
    @Step
    public void loginUserWithEmptyPassAndWrongEmail(){
        fillLoginData(generateUserWithEmptyPassAndWrongEmail());
        clickLogin();
    }
    @Step
    public void loginUserWithEmptyPassAndGoodEmail(){
        fillLoginData(generateUserWithEmptyPassAndGoodEmail());
        clickLogin();
    }
    @Step
    public void loginWithInvalidCredentials(){
        fillLoginData(generateNonRegeisteredUser());
        clickLogin();
    }
    //-----------------------------------
    @Step
    public void verifyUserIsLogedIn(String fName, String lName){
        String greetMessage = headerPage.getGreetMessage().toLowerCase();
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
