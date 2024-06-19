package com.punnyajoshi.Ecommerce.CartTest;

import com.punnyajoshi.Ecommerce.BaseTest;
import com.punnyajoshi.Ecommerce.Pages.HomePage;
import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ViewSearchResultPage;
import com.punnyajoshi.Ecommerce.actions.SearchContentAction;
import com.punnyajoshi.Ecommerce.modals.CartModal;

import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.log4testng.Logger;


public class AddProductTest extends BaseTest {
    private static final Logger logger = (Logger) LogManager.getLogger(AddProductTest.class);
    public static final Logger searchLogger= (Logger) LogManager.getLogger("SearchLogger");
    private static final Logger cartLogger= (Logger) LogManager.getLogger("CartLogger");


    @Test(testName = "Verify that user adds product to cart when product in stock", description = "Verifies that a user is able to successfully add a product to the cart when it is available for purchase.")
    public void verifyUserIsAbleToAddProductToCart(){
        logger.info("Executing verifyUserIsAbleToAddProductToCart: Verifying that a user can add a product to the cart when product is in stock");
        SearchContentAction searchContentAction=SearchContentAction.builder().build().stellTop();
        searchLogger.info("Search Content : {}");
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContentAction.getInput());

        ViewSearchResultPage searchResultPage=new ViewSearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = searchResultPage.clickToViewProductByName();

        cartLogger.debug("Navigated to Product Details Page");
        CartModal cartModal=new CartModal(getWebDriver());
        if(!productDetailsPage.isProductSoldOut()){
            productDetailsPage.clickAddToCart();
            Assert.assertTrue(cartModal.getSuccessMessage().contains("Item added to your cart"));
            cartLogger.info("Product Added to the Cart");
        }else{
            Assert.fail("Product is Out of Stock");
            cartLogger.error("Product is Out of Stock");
        }
    }
}
