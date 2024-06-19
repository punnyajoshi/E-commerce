package com.punnyajoshi.Ecommerce.CartTest;

import com.punnyajoshi.Ecommerce.Pages.CartPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertTrue;

public class CartTest {
    @Test
    public void testProductListedCorrectlyOnCartPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://web-playground.ultralesson.com");
        CartPage cartPage = new CartPage(driver);
        cartPage.navigateToCartPage(); // Ensure navigating to the correct URL

        // Use the method to assert that product details are displayed correctly
        boolean areDisplayedCorrectly = cartPage.areProductsDisplayedCorrectly("Sweater", "L", 49.99, 1);
        assertTrue("Products are not displayed correctly.", areDisplayedCorrectly);

        driver.quit();
    }

    @Test
    public void testCorrectCartTotalPrice() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://web-playground.ultralesson.com");
        CartPage cartPage = new CartPage(driver);
        cartPage.navigateToCartPage(); // Ensure navigating to the correct URL

        double displayedTotalPrice = cartPage.calculateTotalPrice();
        double expectedTotal = 49.99 + 19.99 * 2; // Correct calculation of total price
        Assertions.assertEquals(expectedTotal, displayedTotalPrice, "Total price displayed is incorrect.");

        driver.quit();
    }
}
