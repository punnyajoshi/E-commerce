package com.punnyajoshi.Ecommerce.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSelectionPage extends BasePage {
    public ProductSelectionPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath =  "//*[@id=\"shopify-section-template--15328405553373__main\"]/div/div[1]/h1")
    private WebElement productElement;


    public boolean isProductAvailable() {
        return productElement.isDisplayed();
    }

    public void selectProduct() {
        productElement.click();
    }

    public String getSelectedProductName() {
        return productElement.getText();
    }
}
