package com.punnyajoshi.Ecommerce.Pages;

import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;
    private String cartUrl = "https://web-playground.ultralesson.com/cart";


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.cartUrl = cartUrl;
    }

    public void navigateToCartPage() {
        driver.get(cartUrl);
    }


    public void addProductToCart(String s) {
        driver.getCurrentUrl();
    }

    public String productsAreDisplayedCorrectly() {
        driver.getCurrentUrl();
        return null;
    }

    CartPage cartPage = new CartPage(driver);

    public boolean areProductsDisplayedCorrectly(String sweater, String l, double v, int i) {
        return false;
    }
}
