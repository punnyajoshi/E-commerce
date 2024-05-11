package com.punnyajoshi.Ecommerce.ProductTest;

import com.punnyajoshi.Ecommerce.Pages.Product;
import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ProductListPage;
import com.punnyajoshi.Ecommerce.Pages.ProductSelectionPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.logging.Logger;

public class ProductSelectionTest {
    private WebDriver driver;
    private ProductSelectionPage productSelectionPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.example.com/product-selection");
        productSelectionPage = new ProductSelectionPage(driver);
    }

    @Test
    public void testProductSelection() {
        Assert.assertTrue(productSelectionPage.isProductAvailable(), "The product is not available.");
        productSelectionPage.selectProduct();
        Assert.assertEquals(productSelectionPage.getSelectedProductName(), "Expected Product Name", "Product name does not match.");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
