package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.Product;
import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ProductListPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProductSelectionTest {
    private WebDriver driver;
    private ProductListPage productListPage;
    private ProductDetailsPage productDetailsPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        productListPage = new ProductListPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testSelectProductByName() {
        driver.get("https://web-playground.ultralesson.com/store");
        Product product = productListPage.selectProductByName("Product 1");
        assert product!= null;
        assert productDetailsPage.isProductDetailsLoaded();
        assert productDetailsPage.getProductName().equals(product.getName());
        productDetailsPage.addToCart();
    }

    @Test
    public void testSelectProductByIndex() {
        driver.get("https://web-playground.ultralesson.com/store");
        Product product = productListPage.selectProductByIndex(0);
        assert product!= null;
        assert productDetailsPage.isProductDetailsLoaded();
        assert productDetailsPage.getProductName().equals(product.getName());
        productDetailsPage.addToCart();
    }
}
