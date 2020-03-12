package com.firestarters.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

//url-ul pe care intra
@DefaultUrl("http://qa2.dev.evozon.com/customer/account/create/")
public class RegisterPage extends AbstractPage{

    @FindBy(id = "firstname")
    private WebElementFacade firstNameInput;

    @FindBy(id = "lastname")
    private WebElementFacade lastNameInput;

    @FindBy(name = "email")
    private WebElementFacade emailInput;

    @FindBy(name = "password")
    private WebElementFacade passInput;

    @FindBy(name = "confirmation")
    private WebElementFacade confirmPassInput;

    @FindBy(css ="button[title='Register']")
    private WebElementFacade registerButton;
    @FindBy(css="#advice-required-entry-firstname")
    private WebElementFacade MandatoryFieldErrorMessage;

    public void typeFirstName(String fName){
        firstNameInput.type(fName);
    }

    public void typeLastName(String lName){
        lastNameInput.type(lName);
    }

    public void typeEmailAdress(String email){
        emailInput.type(email);
    }

    public void typePassword(String pass){
        passInput.type(pass);
    }

    public void typeConfirmPassword(String confirmPass){
        confirmPassInput.type(confirmPass);
    }

    public void clickRegisterButton(){
        registerButton.click();
    }
    public String getMandatoryFieldErrorMessage(){
        return MandatoryFieldErrorMessage.getText();
    }



}
