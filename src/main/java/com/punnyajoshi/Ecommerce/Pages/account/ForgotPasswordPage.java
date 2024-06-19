package com.punnyajoshi.Ecommerce.Pages.account;

import com.punnyajoshi.Ecommerce.Pages.BasePage;
import com.punnyajoshi.Ecommerce.modals.UserModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.punnyajoshi.Ecommerce.actions.*;

public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"recover\"]")
    private WebElement resetPageHeading;

    @FindBy(id = "RecoverEmail")
    private WebElement emailIdTextBox;

    @FindBy(xpath = "//*[@id=\"MainContent\"]/div/div[1]/form/button")
    private WebElement submitBtn;

    public LoginPage forgotPassword(UserModal user){
        TextBox.type(emailIdTextBox, Integer.parseInt(user.getEmailID()));
        ButtonAction.click(submitBtn);
        return new LoginPage(driver);
    }

    public String getResetPasswordPageHeading(){
        return WebActions.getText(resetPageHeading);
    }


}
