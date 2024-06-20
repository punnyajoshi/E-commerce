package com.punnyajoshi.Ecommerce.CartTest;

import com.punnyajoshi.Ecommerce.BaseTest;
import com.punnyajoshi.Ecommerce.cartPackage.Cart;
import com.punnyajoshi.Ecommerce.cartPackage.CartPage;
import com.punnyajoshi.Ecommerce.modals.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.testng.AssertJUnit.assertTrue;

public class CarPageTest extends BaseTest {
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
        Cart cart = new Cart();
        cart.addProduct(new Product("Sweater", "L", 1, 49.99));
        cart.addProduct(new Product("Hat", "One size", 2, 19.99));

        double expectedTotal = 49.99 + 2 * 19.99; // Correct calculation of total price
        Assertions.assertEquals(expectedTotal, cart.getTotalPrice());
    }

}
