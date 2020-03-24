package com.firestarters.page;

        import com.firestarters.models.User;
        import net.serenitybdd.core.annotations.findby.FindBy;
        import net.serenitybdd.core.pages.WebElementFacade;
        import net.thucydides.core.annotations.DefaultUrl;
        import net.thucydides.core.annotations.Step;
        import org.junit.Assert;
        import org.openqa.selenium.WebElement;

        import static com.firestarters.utils.Utils.getRandomString;

@DefaultUrl("http://qa2.dev.evozon.com/customer/account/login/")
public class LoginPage extends AbstractPage {
    @FindBy(id = "email")
    private WebElementFacade emailInput;
    @FindBy(id = "pass")
    private WebElementFacade passInput;
    @FindBy(id = "send2")
    private WebElementFacade loginButton;
    @FindBy(id="advice-required-entry-email")
    private WebElementFacade requiredEmailMessage;
    @FindBy(id="advice-required-entry-pass")
    private WebElementFacade requiredPasslMessage;
    @FindBy(css = ".error-msg")
    private WebElement errorMessage;
    @FindBy(css="p.welcome-msg")
    private WebElementFacade greetMessage;

    public void typeEmail(String email) {
        emailInput.type(email);
    }

    public void typePass(String pass) {
        passInput.type(pass);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public String getRequiredEmailMessage(){
        return requiredEmailMessage.getText();
    }
    public String getRequiredPassMessage(){
        return requiredPasslMessage.getText();
    }
    public String getErrormessage(){return errorMessage.getText();}
    public String getGreetMessage(){
        return greetMessage.getText();
    }
    public User fillCredentials(String email,String password){
        User u=new User();
        u.setEmail(email);
        u.setPass(password);
        typeEmail(email);
        typePass(password);
        return u;
    }

}
