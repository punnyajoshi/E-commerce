package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ProductListPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

public class ProductDetailsPageTest {
    private WebDriver driver;
    private ProductDetailsPage productDetailsPage;
    private static final Logger logger = Logger.getLogger(String.valueOf(ProductDetailsPageTest.class));

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.example.com/product-details");
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @Test
    public void testProductDetails() {
        Assert.assertTrue(productDetailsPage.isProductAvailable(), "The product is sold out.");
        Assert.assertTrue(productDetailsPage.isProductDetailsLoaded(), "Product details are not loaded.");
        String productName = productDetailsPage.getProductName();
        logger.info("Product Name: " + productName);
        productDetailsPage.addToCart();
        logger.info("Product added to cart.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
