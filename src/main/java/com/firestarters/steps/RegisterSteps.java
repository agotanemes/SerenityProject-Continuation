package com.firestarters.steps;



import com.firestarters.models.User;
import com.firestarters.page.HeaderPage;
import com.firestarters.page.RegisterPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static com.firestarters.utils.Utils.getRandomString;


public class RegisterSteps {

    RegisterPage registerPage;
    HeaderPage headerPage;

    //complete register mandatory fields
    @Step
    public User fillRegisterData(User user){
        registerPage.typeFirstName(user.getFirstName());
        registerPage.typeLastName(user.getLastName());
        registerPage.typeEmailAdress(user.getEmail());
        registerPage.typePassword(user.getPass());
        registerPage.typeConfirmPassword(user.getConfirmPass());
        return user;
    }

    @Step
    public void navigateToRegisterPage(){
        registerPage.open();
    }
    //click on register button
    @Step
    public void confirmRegister(){
        registerPage.clickRegisterButton();
    }
    //generate User Types---------------------------------
    @Step
    public User generateRabdomUser(){
        User user = new User();
        user.setFirstName(getRandomString());
        user.setLastName(getRandomString());
        user.setEmail(getRandomString()+"@gmail.com");
        String password=getRandomString();
        user.setPass(password);
        user.setConfirmPass(password);
        return user;
    }
    @Step
    public User generateUserWithEmptyFields(){
        User user=new User();
        user.setFirstName("");
        user.setLastName("");
        user.setEmail("");
        user.setPass("");
        user.setConfirmPass("");
        return user;
    }
    //-----------------------------------------------

    @Step
    public User registerUser(){
        User u=fillRegisterData(generateRabdomUser());
        confirmRegister();
        return u;
    }
    @Step
    public User registerUserWithEmptyFields(){
        User u=fillRegisterData(generateUserWithEmptyFields());
        confirmRegister();
        return u;
    }

    @Step
    public void verifyUserIsRegistered(String fName, String lName){
        String greetMessage = headerPage.getGreetMessage().toLowerCase();
        Assert.assertTrue(greetMessage.contains(fName.toLowerCase()));
        Assert.assertTrue(greetMessage.contains(lName.toLowerCase()));
    }
    @Step
    public void isDisplayedMandatoryFieldErrorMessage(){
        String text=registerPage.getMandatoryFieldErrorMessage();
        Assert.assertEquals(text,"This is a required field.");
    }



}
