package com.firestarters.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

import com.firestarters.page.HomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class HomepageSteps  {

    @Steps
    HomePage homePage;

    @Steps
    ProductDetailsSteps productDetailsSteps;


    @Step
    public void selectProductFromNewProductsOnHomepage(){
        homePage.selectRandomProductFromNewProductsOnHomepage();
    }

    @Step
    public void selectDetails(){
        productDetailsSteps.configureProductAndAddToCart();
    }
    @Step
    public void clickOnSaleSection() {
    	homePage.clickOnSaleHeaderOption();
    }
    
    @Step
    public void clickOnMenSection() {
   	 homePage.clickOnMenHeaderOption();
    }
    
    @Step
    public void clickOnWomenSection() {
    	homePage.womenHeaderOption();
    }
    
    @Step
    public void testSubscriptionInput(String emailAddress, String expectedResult) {
    	homePage.fillInNewsletterInput(emailAddress);
    	homePage.clickNewsletterSubscribe();
    	String actualResult = homePage.getSubscriptionSuccessMessage();
    	Assert.assertTrue(actualResult.equals(expectedResult));
    	
    }
    //Agota 10.03.2020
    @Step
    public void clickOnSubcategoryOfACategory(String searchedCategory,String searchedSubcategory){
        homePage.selectSubcategory(searchedSubcategory,searchedCategory);
    }
    //
    
   
}
