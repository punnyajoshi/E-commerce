package com.punnyajoshi.Ecommerce.cartPackage;


import com.punnyajoshi.Ecommerce.Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"shopify-section-template--15328405520605__cart-items\"]/cart-items/div[1]/h1")
    private WebElement cartHeading;

    @FindBy(xpath = "//*[@id=\"CartItem-1\"]/td[2]/a")
    private WebElement productAddedName;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/cart-items[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/dl[1]/div[2]/dd[1]")
    private WebElement productAddedSize;

    @FindBy(xpath = "//*[@id=\"CartItem-1\"]/td[4]/quantity-input/button[2]")
    private WebElement increaseQuantity;

    @FindBy(xpath = "//input[@id='Quantity-1']")
    private WebElement productAddedQuantity;

    @FindBy(xpath = "//*[@id=\"CartItem-1\"]/td[5]/div[2]/span")
    private WebElement productAddedPrice;



    public boolean areProductsDisplayedCorrectly(String name, String size, double price, int quantity) {
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

    public String getCartHeading(){
        return webActions.getText(cartHeading);
    }


    public void addProductToCart(String s) {
        driver.getCurrentUrl();
    }

    public String getAddedProductName(){
        return webActions.getText(productAddedName).trim();
    }

    public String productsAreDisplayedCorrectly() {
        driver.getCurrentUrl();
        return null;
    }

    public String getSizeOfAddedProduct(){
        return webActions.getText(productAddedSize).trim();
    }

    public int getQuantityOfAddedProduct(){
        int quantity=Integer.parseInt(productAddedQuantity.getAttribute("value"));
        return quantity;
    }

    public String getCartMessage() {
        return driver.findElement(By.xpath("//*[@id=\"product-form-template--15328405717213__main\"]/div/button/span")).getText();
    }

    public double getProductAddedPrice(){
        String getPrice= webActions.getText(productAddedPrice);
        String numberString = getPrice.replaceAll("[^0-9.]", "");
        return Double.parseDouble(numberString);
    }



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

    public int getItemCountInCart() {
        WebElement itemCountElement = driver.findElement(By.xpath("xpath-to-cart-item-count"));
        return Integer.parseInt(itemCountElement.getText().trim());
    }

    public boolean isCartEmpty() {
        return false;
    }


    public void navigateToCartPage() {
        return;
    }

    public CartPage removeProductFromCart(String addedProductName) {
        WebElement deleteBtn= driver.findElement(By.xpath("//*[@id=\"Remove-1\"]/a"));
        buttonActions.click(deleteBtn);
        return new CartPage(driver);
    }

    public boolean CheckWeatherCartIsEmpty() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement emptyCartMessage = driver.findElement(By.xpath("//h1[normalize-space()='Your cart is empty']"));
            webDriverWait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
            return emptyCartMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
