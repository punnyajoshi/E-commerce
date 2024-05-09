package com.punnyajoshi.Ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListPage {
    private WebDriver driver;
    private By productListLocator = By.cssSelector("div.product-list ul li");
    private By productNameLocator = By.cssSelector("h2.product-name");

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public Product selectProductByName(String productName) {
        List<WebElement> products = driver.findElements(productListLocator);
        for (WebElement product : products) {
            WebElement productNameElement = product.findElement(productNameLocator);
            if (productNameElement.getText().equals(productName)) {
                product.click();
                return new Product(productName, products.indexOf(product));
            }
        }
        return null;
    }

    public Product selectProductByIndex(int index) {
        List<WebElement> products = driver.findElements(productListLocator);
        if (index < products.size()) {
            products.get(index).click();
            return new Product(products.get(index).findElement(productNameLocator).getText(), index);
        }
        return null;
    }
}
