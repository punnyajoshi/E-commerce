package com.punnyajoshi.Ecommerce.CartTest;

import com.punnyajoshi.Ecommerce.BaseTest;

import com.punnyajoshi.Ecommerce.Pages.CartPage;
import com.punnyajoshi.Ecommerce.Pages.HomePage;
import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ViewSearchResultPage;
import com.punnyajoshi.Ecommerce.actions.SearchContentAction;
import com.punnyajoshi.Ecommerce.modals.CartModal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;



public class RemoveProductTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(RemoveProductTest.class);
    private static final Logger searchLogger = LogManager.getLogger("SearchLogger");
    private static final Logger cartLogger = LogManager.getLogger("CartLogger");

    @Test(testName = "RemoveProductAndCleanupTest", description = "Verify the product is removed from the cart and the cart is cleaned")
    public void verifyProductIsRemovedFromCart() throws InterruptedException {
        logger.info("Starting test: verifyProductIsRemovedFromCart");

        SearchContentAction searchContent = SearchContentAction.builder().build().stellTop();
        searchLogger.info("Search content: {}", searchContent.getInput());

        HomePage homePage = new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());
        searchLogger.info("Searched for product: {}", searchContent.getInput());

        ViewSearchResultPage searchResultPage = new ViewSearchResultPage(getWebDriver());
        logger.debug("Navigated to search result page");

        ProductDetailsPage productDetailsPage = searchResultPage.clickToViewProductByName();
        logger.debug("Viewing product details for: {}", productDetailsPage.getProductName());

        CartModal cartModal = new CartModal(getWebDriver());
        CartPage cartPage = new CartPage(getWebDriver());

        if (!productDetailsPage.isProductSoldOut()) {
            productDetailsPage.clickAddToCart();
            cartLogger.info("Added product to cart: {}", productDetailsPage.getProductName());
        } else {
            logger.error("Product is out of stock: {}", productDetailsPage.getProductName());
            Assert.fail("Product is Out of Stock");
        }

        cartModal.clickAddToCart();
        cartLogger.info("Product added to cart, navigating to cart page");

        String addedProductName = cartPage.getAddedProductName();
        cartLogger.debug("Added product in cart: {}", addedProductName);

        cartPage.removeProductFromCart(addedProductName);
        cartLogger.info("Removed product from cart: {}", addedProductName);

        boolean isCartEmpty = cartPage.CheckWeatherCartIsEmpty();
        cartLogger.debug("Checking if cart is empty: {}", isCartEmpty);

        Assert.assertTrue(isCartEmpty, "Cart should be empty after removing the product");
        logger.info("Test verifyProductIsRemovedFromCart completed successfully");
    }
}