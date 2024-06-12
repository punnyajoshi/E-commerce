package com.punnyajoshi.Ecommerce.components;

import com.punnyajoshi.Ecommerce.Pages.BasePage;
import com.punnyajoshi.Ecommerce.Pages.account.LoginPage;
import com.punnyajoshi.Ecommerce.Pages.account.ProfilePage;
import com.punnyajoshi.Ecommerce.modals.SearchModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }
    public HeaderComponent getHeader(){
        return new HeaderComponent(driver);
    }
    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement productsLinkElement;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/div/details-modal/details/summary/span")
    private WebElement searchIconElement;

    @FindBy(xpath = "//*[@id=\"shopify-section-header\"]/sticky-header/header/div/a[1]")
    private WebElement profileBtnEle;
    public SearchModal clickSearchBtn(){
        buttonActions.click(searchIconElement);
        return new SearchModal(driver);
    }

    public LoginPage navToLoginPage(){
        buttonActions.click(profileBtnEle);
        return new LoginPage(driver);
    }

    public ProfilePage navToProfilePage(){
        buttonActions.click(profileBtnEle);
        return new ProfilePage(driver);
    }
    public void clickProductsLink() {
        WebElement productsLink = driver.findElement(By.id("products-link"));
        productsLink.click();
    }
}