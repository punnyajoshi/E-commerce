package com.punnyajoshi.Ecommerce.CartTest;

import com.punnyajoshi.Ecommerce.BaseTest;
import com.punnyajoshi.Ecommerce.cartPackage.CartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CartTest extends BaseTest {
    @Test
    public void testProductListedCorrectlyOnCartPage() {

        CartPage cartPage = new CartPage(getWebDriver());
        cartPage.navigateToCartPage(); // Ensure navigating to the correct URL

        // Use the method to assert that product details are displayed correctly
        boolean areDisplayedCorrectly = cartPage.areProductsDisplayedCorrectly("Sweater", "L", 49.99, 1);
        assertTrue("Products are not displayed correctly.", areDisplayedCorrectly);

    }

    @Test
    public void testCorrectCartTotalPrice() {

        CartPage cartPage = new CartPage(getWebDriver());
        cartPage.navigateToCartPage(); // Ensure navigating to the correct URL

        double displayedTotalPrice = cartPage.calculateTotalPrice();
        double expectedTotal = 49.99 + 19.99 * 2; // Correct calculation of total price
        Assertions.assertEquals(expectedTotal, displayedTotalPrice, "Total price displayed is incorrect.");
    }
}
