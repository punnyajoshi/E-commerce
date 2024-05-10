package com.punnyajoshi.Ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[contains(@href, 'product')]")
    private WebElement firstProduct;

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get("https://web-playground.ultralesson.com/store");
    }

    public void clickFirstProduct() {
        firstProduct.click();
    }

    public boolean isProductAvailable() {
        return firstProduct.isDisplayed();
    }
}
