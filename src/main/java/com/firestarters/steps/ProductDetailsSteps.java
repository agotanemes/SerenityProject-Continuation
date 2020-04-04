package com.firestarters.steps;

import com.firestarters.models.CartProduct;
import com.firestarters.page.ProductDetailsPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage;

//    @Step
//    public void selectARandomColor(){
//        productDetailsPage.selectAColor();
//    }
//
//    @Step
//    public void selectARandomSize(){
//        productDetailsPage.selectSize();
//    }
//
//    @Step
//    public void addToCart(){
 //       productDetailsPage.addToCart();
//   }

    //Ciuverca Ionut ( here I grouped all the above)
    @Step
    public void configureProductAndAddToCart(){
        productDetailsPage.selectAColor();
        productDetailsPage.selectSize();
        productDetailsPage.addToCart();
    }

    //Agota 10.03.2020
    @Step
    public CartProduct addProduct(String c, String s, String qty){
        CartProduct cartProduct=new CartProduct();
        productDetailsPage.selectColor(c);
        productDetailsPage.selectSize(s);
        productDetailsPage.selectQty(qty);
        String productName=productDetailsPage.getProductName();
        double productPrice=productDetailsPage.getProductPrice();
        cartProduct.setColor(c);
        cartProduct.setSize(s);
        cartProduct.setQty(qty);
        cartProduct.setName(productName);
        cartProduct.setPrice(productPrice);
        double qtyAsdouble=productDetailsPage.getStringAsdouble(qty);
        cartProduct.setSubtotal(productPrice*qtyAsdouble);
        return cartProduct;
    }
    //
    @Step
    public void clickAddToCartBtn(){
        productDetailsPage.addToCart();
    }

    //Agota 13.03.2020
    @Step
    public void verifyTwoCartListsAreEqual(List<CartProduct> products,List<CartProduct> cartProducts ){
        int productsSize=products.size();
        int cartproductsSize=cartProducts.size();
        Assert.assertEquals(productsSize,cartproductsSize);
        for (int i = 0; i < products.size(); i++) {
            Assert.assertTrue(products.get(i).getColor().equals(cartProducts.get(i).getColor()));
            Assert.assertTrue(products.get(i).getSize().equals(cartProducts.get(i).getSize()));
            Assert.assertTrue(products.get(i).getQty().equals(cartProducts.get(i).getQty()));
            Assert.assertTrue(products.get(i).getName().equals(cartProducts.get(i).getName()));
            Double price1= products.get(i).getPrice();
            Double price2=cartProducts.get(i).getPrice();
            //Assert.assertTrue(products.get(i).getProductPrice().equals(cartProducts.get(i).getProductPrice()));
            Assert.assertTrue(price1.equals(price2));
            Double subtotal1=products.get(i).getSubtotal();
            Double subtotal2=cartProducts.get(i).getSubtotal();
            System.out.println("subtotaluri "+subtotal1+" "+subtotal2);
            Assert.assertTrue(subtotal1.equals(subtotal2));


        }
    }
    //
    // Mihai (corectare metoda verifyTwoCartListsAreEqual)
    @Step
    public void verifyToProductListAreEquals(List<CartProduct> expectedProducts,List<CartProduct> actualProducts ){

        for (CartProduct expectedProduct: expectedProducts) {
            CartProduct actualProduct = findProductInList(expectedProduct, actualProducts);
            Assert.assertTrue("Prices are not correct",expectedProduct.getPrice() == actualProduct.getPrice());
            Assert.assertTrue("Sizes are not correct",expectedProduct.getSize() == actualProduct.getSize());
            Assert.assertTrue("Names are not correct",expectedProduct.getName() == actualProduct.getName());
            Assert.assertTrue("Colors are not correct",expectedProduct.getColor() == actualProduct.getColor());
            Assert.assertTrue("Qty are not correct",expectedProduct.getQty() == actualProduct.getQty());
        }
    }
    @Step
    public CartProduct findProductInList(CartProduct searchedProduct,List<CartProduct> products){
        for (CartProduct product:products) {
            if(product.getName().contentEquals(searchedProduct.getName())){
                return product;
            }
        }
        return null;
    }

    //

}
