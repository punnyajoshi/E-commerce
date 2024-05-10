package com.punnyajoshi.Ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class ProductDetailsPage {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(String.valueOf(ProductDetailsPage.class));

    @FindBy(xpath = "//h1")
    private WebElement productNameElement;

    @FindBy(xpath = "//button[contains(., 'Add to Cart')]")
    private WebElement addToCartButton;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductDetailsLoaded() {
        return productNameElement.isDisplayed();
    }

    public String getProductName() {
        return productNameElement.getText();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public boolean isProductAvailable() {
        return productNameElement.isDisplayed() && productNameElement.getText().contains("In Stock");
    }
}
