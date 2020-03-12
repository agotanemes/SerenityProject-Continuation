package com.firestarters.page;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa2.dev.evozon.com/")
public class WishListPage extends AbstractPage {

    @FindBy(css =".links > ul > li:nth-child(2) > a")
    private WebElementFacade wishListBtn;
    @FindBy(css = "success-msg")
    private WebElementFacade successMsg;
    @FindBy(css = "#item_198 td:nth-child(3) > div > div > input")
    private WebElementFacade quantityInput;
    @FindBy(css= "#item_198 button.button-secondary")
    private WebElementFacade updateWishlistFromMyWishlistBtn;

    public WebElementFacade getWishListBtn(){
        return wishListBtn;
    }

    public WebElementFacade getSuccessMsg(){
        return successMsg;
    }

    public WebElementFacade getQuantityInput(){
        return quantityInput;
    }
    public WebElementFacade getUpdateWishlistFromMyWishlist(){
        return updateWishlistFromMyWishlistBtn;
    }

}
