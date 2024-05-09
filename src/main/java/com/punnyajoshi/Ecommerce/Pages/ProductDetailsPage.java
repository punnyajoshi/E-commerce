package com.punnyajoshi.Ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    private WebDriver driver;
    private By productNameLocator = By.cssSelector("h1.product-name");
    private By productAvailabilityLocator = By.cssSelector("p.product-availability");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage(WebDriver driver, By productNameLocator, By productAvailabilityLocator) {
        this.driver = driver;
        this.productNameLocator = productNameLocator;
        this.productAvailabilityLocator = productAvailabilityLocator;
    }

    public String getProductName() {
        WebElement productNameElement = driver.findElement(productNameLocator);
        return productNameElement.getText();
    }

    public boolean isProductAvailable() {
        WebElement productAvailabilityElement = driver.findElement(productAvailabilityLocator);
        return productAvailabilityElement.getText().equals("In Stock");
    }

    public boolean isProductDetailsLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productNameLocator)).isDisplayed();
    }

    public void addToCart() {
        driver.findElement(By.cssSelector("button.add-to-cart")).click();
    }



}
