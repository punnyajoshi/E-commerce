package com.punnyajoshi.Ecommerce.Pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private String cartUrl = "https://web-playground.ultralesson.com/cart";


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.cartUrl = cartUrl;
    }

    public void navigateToCartPage() {
        driver.get(cartUrl);
        Assertions.assertEquals(cartUrl, driver.getCurrentUrl(), "Navigation to the cart page failed.");
    }

    public boolean areProductsDisplayedCorrectly(String name, String size, double price, int quantity) {
        // Implement logic to find products in the cart and validate their details
        // return true if details are correct, false otherwise
        // Example:
        List<WebElement> productList = driver.findElements(By.xpath("//*[@id=\"shopify-section-template--15328405717213__main\"]/section/div/div[1]/slider-component/ul/li/modal-opener/button"));
        for (WebElement product : productList) {
            String productName = product.findElement(By.xpath("//*[@id=\"shopify-section-template--15328405717213__main\"]/section/div/div[1]/slider-component/ul/li/modal-opener/button")).getText();
            String productSize = product.findElement(By.xpath("//*[@id=\"ProductInfo-template--15328405717213__main\"]/h1")).getText();
            double productPrice = Double.parseDouble(product.findElement(By.xpath("//*[@id=\"price-template--15328405717213__main\"]/div/div/div[2]/span[4]")).getText().replace("$", ""));
            int productQuantity = Integer.parseInt(product.findElement(By.xpath("//*[@id=\"ProductInfo-template--15328405717213__main\"]/div[3]/quantity-input/button[1]")).getText());

            if (productName.equals(name) && productSize.equals(size) && productPrice == price && productQuantity == quantity) {
                return true;
            }
        }
        return false;
    }

    // Now this must be called to navigate to the Cart Page
    // Example usage in tests or application's flow
    CartPage cartPage = new CartPage(driver);


    // Implement logic to calculate the total price based on the web elements representing cart items
    public double calculateTotalPrice() {
        double totalPrice = 0;
        List<WebElement> productList = driver.findElements(By.xpath("//*[@id=\"shopify-section-template--15328405717213__main\"]/section/div/div[1]/slider-component/ul/li/modal-opener/button"));
        for (WebElement product : productList) {
            double productPrice = Double.parseDouble(product.findElement(By.xpath("//*[@id=\"price-template--15328405717213__main\"]/div/div/div[2]/span[4]")).getText().replace("$", ""));
            int productQuantity = Integer.parseInt(product.findElement(By.xpath("//*[@id=\"ProductInfo-template--15328405717213__main\"]/div[3]/quantity-input/button[1]")).getText());
            totalPrice += productPrice * productQuantity;
        }
        return totalPrice;
    }


    public void addProductToCart(String s) {
        driver.getCurrentUrl();
    }

    public String productsAreDisplayedCorrectly() {
        driver.getCurrentUrl();
        return null;
    }
}
