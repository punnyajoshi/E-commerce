package com.punnyajoshi.Ecommerce.ProductTest;

import com.punnyajoshi.Ecommerce.product.ProductDetailsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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
        Assert.assertTrue(productDetailsPage.isProductAvailable(), "The product is sold out. Test aborted.");
    }

    @Test
    public void testProductDetails() {
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
