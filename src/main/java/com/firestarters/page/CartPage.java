package com.firestarters.page;

import com.firestarters.models.CartProduct;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import static com.firestarters.utils.Utils.*;

@DefaultUrl("http://qa2.dev.evozon.com/checkout/cart/")
public class CartPage extends  AbstractPage{

    @FindBy(css = "#shopping-cart-table > tbody tr")
    private List<WebElementFacade> cartProductsList;

    @FindBy(css = ".button[title*='Proceed']")
    private WebElementFacade proceedToCheckoutButton;

    @FindBy(css = "#shopping-cart-table > tbody")
    private WebElementFacade listOfProductsInCart;
    @FindBy(css = ".product-cart-actions .link-wishlist")
    private WebElementFacade wishlistBtnInCart;
    @FindBy(css=".success-msg")
    private WebElementFacade successMsgAddedInWishlist;

    @FindBy ( css = "#shopping-cart-table" )
    private WebElementFacade productTable;

    //Agota
    @FindBy(css="#shopping-cart-table>tbody>tr")
    private List<WebElementFacade> productList;
    @FindBy(css = ".a-right>strong>span[class='price']")
    private WebElement totalPrice;

//-------------------
  //Ciuverca Ionut
    public int getNumberOfElementsFromCartProductsList(){

        return cartProductsList.size();
    }

   //Ciuverca Ionut
    public void proceedToCheckout(){
        proceedToCheckoutButton.click();
    }

    public List<WebElementFacade> getCartProductsList() {
        return cartProductsList;
    }
    //Agota
    public Double getProductTotalPriceAsDouble(){
        //get the total price
        String priceTotal=totalPrice.getText();
        //eliminate $US from price and replace , with .
        String priceTotal1=stringReplace(priceTotal);
        //change price as string to double
        Double priceTotalAsDouble=convertStringToDouble(priceTotal1);
        return priceTotalAsDouble;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    //return Product list from cart
    public List<WebElementFacade> getProductList() {
        return productList;
    }

    public WebElementFacade getProductTable(){
        return productTable;

    }


    public WebElementFacade getWishListBtnInCart(){
        return wishlistBtnInCart;
    }
    public WebElementFacade getSuccessMsgAddedInWishlist(){
        return successMsgAddedInWishlist;
    }
    //12.03.2020
    @Step
    public void verifyIfSubtotalIsCorrect() {
        //product list
        List<WebElementFacade> productList = getProductList();
        Double totalPrice=convertStringToDouble(stringReplace(getTotalPrice().getText()));
        double total=0;
        for (WebElementFacade product : productList) {
            String price = product.findElement(By.cssSelector(" td[class='product-cart-price']")).getText();
            String qty = product.findElement(By.cssSelector(" td[class='product-cart-actions']>input")).getAttribute("value");
            String subtotal = product.findElement(By.cssSelector(" .product-cart-total>span span[class='price']")).getText();

            Double correctPrice = convertStringToDouble(stringReplace(price));
            //System.out.println(correctPrice);
            Double correctQty = convertStringToDouble(qty);
            //System.out.println(correctQty);
            Double correctSubtotal = convertStringToDouble(stringReplace(subtotal));
            //System.out.println(correctSubtotal);
            Assert.assertTrue(correctSubtotal.equals(correctPrice * correctQty));
            double correctSubtotalAsdouble = correctSubtotal.doubleValue();
            total= total+correctSubtotalAsdouble;

        }
        Double totalpr=new Double(total);
        Assert.assertTrue(totalPrice.equals(totalpr));

    }
    public List<CartProduct> getProducts(){
        List<CartProduct> products=new ArrayList<>();
        List<WebElementFacade> productListFromWeb = getProductList();
        for (WebElementFacade product : productListFromWeb) {
            String price = product.findElement(By.cssSelector(" td[class='product-cart-price']")).getText();
            String qty = product.findElement(By.cssSelector("td[class='product-cart-actions']>input")).getAttribute("value");
            Double correctPrice = convertStringToDouble(stringReplace(price));
            double priceAsdouble = correctPrice.doubleValue();
            String productName=product.findElement(By.cssSelector(" .product-name>a")).getText();
            //String productColor=product.findElement(By.cssSelector());

        }
        return products;
    }
    //

}
