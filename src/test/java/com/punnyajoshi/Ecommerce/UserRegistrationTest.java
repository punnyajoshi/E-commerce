package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.HomePage;
import com.punnyajoshi.Ecommerce.Pages.account.LoginPage;
import com.punnyajoshi.Ecommerce.Pages.account.ProfilePage;
import com.punnyajoshi.Ecommerce.Pages.account.RegistrationPage;
import com.punnyajoshi.Ecommerce.modals.UserModal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends BaseTest{
    @Test(testName = "Verify That The User Registration Is Successful",description = "Verify that a new user is able to register on the website by creating an account and accessing their profile page.")
    public void VerifyThatTheUserRegistrationIsSuccessful(){

        UserModal user= UserModal.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();

        loginPage.navToRegisterationPage().createAccount(user);
        ProfilePage profilePage = homePage.getHeader().navToProfilePage();

        String accountDetails= profilePage.getAccountDetails();

        Assert.assertTrue(accountDetails.contains(user.getFirst_name()));
    }
    @Test(testName = "Registration Fails With Empty Email", description = "Verifies that the user is unable to register without providing an email address by attempting to create an account with an empty email field.")
    public void verifyThatTheUserIsNotAbleToRegisterWithEmptyEmail(){

        UserModal user= UserModal.builder().build().userWithoutEmail();
        HomePage homePage=new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        RegistrationPage registrationPage=new RegistrationPage(getWebDriver());

        loginPage.navToRegisterationPage().createAccount(user);

        String errorMessage = registrationPage.errorMessage();

        Assert.assertTrue(errorMessage.contains("Email cannot be blank"));

    }

    @Test(testName = "Registration Fails With Empty Password", description = "Validates that the user is prevented from registering without providing a password by attempting to create an account with an empty password field.")
    public void verifyThatTheUserIsNotAbleToRegisterWithEmptyPassword(){

        UserModal user= UserModal.builder().build().userWithoutPassword();
        HomePage homePage=new HomePage(getWebDriver());

        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        RegistrationPage registrationPage=new RegistrationPage(getWebDriver());

        loginPage.navToRegisterationPage().createAccount(user);

        String errorMessage = registrationPage.errorMessage();

        Assert.assertTrue(errorMessage.contains("Password cannot be blank"));
    }
}