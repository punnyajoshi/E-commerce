package com.punnyajoshi.Ecommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Logger;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }
    private static final Logger logger = Logger.getLogger(String.valueOf(ProductDetailsPage.class));

    @FindBy(xpath = "//h1")
    private WebElement productNameElement;

    @FindBy(xpath = "//button[contains(., 'Add to Cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='price-item price-item--regular']")
    private WebElement productPrice;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/section[1]/section[1]/div[1]/div[2]/div[1]/div[3]/quantity-input[1]/input[1]")
    private WebElement quantitySelected;

    public boolean isProductDetailsLoaded() {
        return productNameElement.isDisplayed();
    }

    public String getProductName() {
        return productNameElement.getText();
    }

    public CartPage addToCart() {
        buttonActions.click(addToCartButton);
        return new CartPage(driver);
    }

    public boolean isProductAvailable() {
        return productNameElement.isDisplayed() && productNameElement.getText().contains("In Stock");
    }

    public double getProductPrice() {
        String getPrice = webActions.getText(productPrice);
        String numericString = getPrice.replace("Rs. ", "");
        double price = Double.parseDouble(numericString);
        return price;
    }

    public int getQuantitySelected(){
        return Integer.parseInt(quantitySelected.getAttribute("value"));
    }
    public String getSizeSelected() {
        WebElement selectedRadio = null;
        List<WebElement> sizeRadioButtons = driver.findElements(By.name("Size"));

        for (WebElement i : sizeRadioButtons) {
            if (i.isSelected()) {
                selectedRadio = i;
                return i.getAttribute("value");
            }
        }
        return null;
    }


    public CartPage addToCartButton() {
        return null;
    }
}
