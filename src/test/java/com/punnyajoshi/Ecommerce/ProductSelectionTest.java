package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.Product;
import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ProductListPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ProductSelectionTest {
    private WebDriver driver;
    private ProductListPage productListPage;
    private ProductSelectionPage productSelectionPage;
    private static final Logger logger = LogManager.getLogger(ProductSelectionPageTest.class);

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        productListPage = new ProductListPage(driver);
        productSelectionPage = new ProductSelectionPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testProductSelection() {
        String expectedProductName = "Test Product";

        productListPage.navigateTo();
        productListPage.clickFirstProduct();

        if (!productSelectionPage.isProductAvailable()) {
            logger.info("The product is sold out.");
            return;
        }

        productSelectionPage.selectProduct();
        String actualProductName = productSelectionPage.getSelectedProductName();
        Assert.assertEquals(actualProductName, expectedProductName, "Selected product name does not match the expected value.");
    }
}
