package com.punnyajoshi.Ecommerce.Pages;

import com.punnyajoshi.Ecommerce.Pages.account.ForgotPasswordPage;
import com.punnyajoshi.Ecommerce.actions.ButtonAction;
import com.punnyajoshi.Ecommerce.actions.TextBox;
import com.punnyajoshi.Ecommerce.actions.WebActions;
import com.punnyajoshi.Ecommerce.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected ButtonAction buttonActions;
    protected TextBox textBox;
    protected WebActions webActions;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.buttonActions=new ButtonAction(driver);
        this.textBox=new TextBox(driver);
        this.webActions=new WebActions(driver);
    }
    public HeaderComponent getHeader(){
        return new HeaderComponent(driver);
    }


    public ForgotPasswordPage navToForgotPasswordPage() {
        return new ForgotPasswordPage(driver);
    }
}
