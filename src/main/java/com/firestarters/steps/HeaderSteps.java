package com.firestarters.steps;

        import com.firestarters.page.HeaderPage;
        import net.thucydides.core.annotations.Step;
        import org.junit.Assert;

public class HeaderSteps {

    HeaderPage headerPage;

    //Ciuverca Ionut
    @Step
    public void goToProductsPage() {

        headerPage.navigateToAProductSubcategory();
    }

    //Ciuverca Ionut
    @Step
    public void navigateToMenPantsSubcategory(){
        headerPage.navigateToMenPantsSubcategory();
    }

    @Step
    public void appearsOnHomepage() {
        Assert.assertEquals("Madison Island", headerPage.getTitle());
        System.out.println(headerPage.getTitle());
    }

    @Step
    public void isTheCorrectURL() {
        Assert.assertEquals("http://qa2.dev.evozon.com/", headerPage.getURL());
        System.out.println(headerPage.getURL());
    }

    @Step
    public void logoIsDisplayed() {
        Assert.assertTrue(headerPage.getLogo().isDisplayed());
    }

    @Step
    public void clickOnLogo() {
        logoIsDisplayed();
        headerPage.getLogo().click();
    }

    @Step
    public void navigateBack() {
        headerPage.navigateBack();
    }

    @Step
    public void clickOnAccountButton() {
        headerPage.getAccountButton().click();
    }

    @Step
    public void isAccountDropDownDIsplayed() {
        clickOnAccountButton();
        Assert.assertTrue(headerPage.getAccountDropDown().isDisplayed());
    }

    @Step
    public void checkAccountText() {
        Assert.assertEquals("ACCOUNT", headerPage.getAccountButton().getText());
    }

    @Step
    public void verifyTheNumberOfLanguages() {
        Assert.assertTrue(headerPage.getNumberOfOptions() == 3);
    }

    @Step
    public void selectTheNewLanguage() {
        headerPage.selectDropdownValues();
    }

    @Step
    public void clearsSearchField() {
        headerPage.clearSearchField();
    }

    @Step
    public void submitsInSearch() {
        headerPage.fillAndSubmitSearchField();
        Assert.assertTrue(headerPage.getSearchTitle().contains("DRESS"));
    }


    //Ciuverca Ionut
    @Step
    public void navigateToACathegory(){
        headerPage.navigateToACathegory("WOMEN");
    }

    @Step
    public void clickOnAccountButtonFromDropDown(){
        headerPage.clickOnMyAccountButtonFromDropDown();
    }



}