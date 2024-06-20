package com.punnyajoshi.Ecommerce.CartTest;

import com.punnyajoshi.Ecommerce.BaseTest;
import com.punnyajoshi.Ecommerce.cartPackage.CartPage;
import com.punnyajoshi.Ecommerce.Pages.HomePage;
import com.punnyajoshi.Ecommerce.product.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ViewSearchResultPage;
import com.punnyajoshi.Ecommerce.actions.SearchContentAction;
import com.punnyajoshi.Ecommerce.modals.CartModal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartContentValidationTest  extends BaseTest {

    private static final Logger logger = LogManager.getLogger(CartContentValidationTest.class);
    private static final Logger cartLogger = LogManager.getLogger("CartLogger");

    @Test
    public void userIsAbleToNavigateToCartPage(){
        SearchContentAction searchContent=SearchContentAction.builder().build().stellTop();
        HomePage homePage=new HomePage(getWebDriver());

        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());

        ViewSearchResultPage viewSearchResultPage=new ViewSearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = viewSearchResultPage.clickToViewProductByName();

        CartModal cartModel=new CartModal(getWebDriver());
        CartPage cartPage=new CartPage(getWebDriver());

        if(!productDetailsPage.isProductAvailable()){
            cartPage = productDetailsPage.addToCartButton();
        }

        else{
            Assert.fail("Product is not available, it is out of stock");
        }

        String cartHeading = cartModel.clickAddToCart().getCartHeading();

        Assert.assertTrue(cartHeading.contains("Your cart"));
    }


    @Test
    public void checkTheProductListedInTheCartWithCorrectDetails() {
        SearchContentAction searchContent=SearchContentAction.builder().build().golfShoes();
        HomePage homePage=new HomePage(getWebDriver());

        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());

        ViewSearchResultPage viewSearchResultPage=new ViewSearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = viewSearchResultPage.clickToViewProductByName();

        CartModal cartModel=new CartModal(getWebDriver());
        CartPage cartPage=new CartPage(getWebDriver());

        if(!productDetailsPage.isProductAvailable()){
            cartPage = productDetailsPage.addToCart();

        }

        else{
            Assert.fail("Product is not available, it is out of stock");
        }

        cartModel.clickAddToCart();

        Assert.assertTrue(cartPage.getAddedProductName().contains(productDetailsPage.getProductName()));
        Assert.assertTrue((cartPage.getSizeOfAddedProduct().contains(productDetailsPage.getSizeSelected())));
        Assert.assertEquals(cartPage.getQuantityOfAddedProduct(),productDetailsPage.getQuantitySelected());
        Assert.assertEquals(cartPage.getProductAddedPrice(),productDetailsPage.getProductPrice());

        logger.info("Test checkTheProductWhichIsAddedIsListedInCartWithCorrectDetails completed successfully");

    }
}
