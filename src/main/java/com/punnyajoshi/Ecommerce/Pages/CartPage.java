package com.punnyajoshi.Ecommerce.Pages;

import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private String cartUrl;

    public CartPage(WebDriver driver, String cartUrl) {
        this.driver = driver;
        this.cartUrl = cartUrl;
    }

    public void navigateToCartPage() {
        driver.get(cartUrl);
    }
}
