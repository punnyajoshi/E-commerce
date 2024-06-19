package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.HomePage;
import com.punnyajoshi.Ecommerce.Pages.account.LoginPage;
import com.punnyajoshi.Ecommerce.Pages.account.ProfilePage;
import com.punnyajoshi.Ecommerce.Pages.account.RegistrationPage;
import com.punnyajoshi.Ecommerce.modals.UserModal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;




public class UserRegistrationTest extends BaseTest{
    private static final Logger logger = LogManager.getLogger(String.valueOf(UserRegistrationTest.class));
    private static final Logger registrationLogger = LogManager.getLogger("RegistrationLogger");

    @Test(testName = "Verify That The User Registration Is Successful", description = "Verify that a new user is able to register on the website by creating an account and accessing their profile page.")
    public void VerifyThatTheUserRegistrationIsSuccessful() {
        logger.info("Starting test: VerifyThatTheUserRegistrationIsSuccessful");

        // arrange
        UserModal user = UserModal.builder().build().init();
        registrationLogger.info("Initialized user: {}");

        HomePage homePage = new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        registrationLogger.debug("Navigated to login page");

        // act
        loginPage.navToRegisterationPage().createAccount(user);
        registrationLogger.info("Created account for user: {}");

        ProfilePage profilePage = homePage.getHeader().navToProfilePage();
        registrationLogger.debug("Navigated to profile page");

        // assert
        String accountDetails = profilePage.getAccountDetails();
        registrationLogger.debug("Retrieved account details: {}", accountDetails);
        Assert.assertTrue(accountDetails.contains(user.getFirst_name()), "Account details verification");

        logger.info("Test VerifyThatTheUserRegistrationIsSuccessful completed successfully");
    }

    @Test(testName = "Registration Fails With Empty Email", description = "Verifies that the user is unable to register without providing an email address by attempting to create an account with an empty email field.")
    public void verifyThatTheUserIsNotAbleToRegisterWithEmptyEmail() {
        logger.info("Starting test: verifyThatTheUserIsNotAbleToRegisterWithEmptyEmail");

        // arrange
        UserModal user = UserModal.builder().build().userWithoutEmail();
        registrationLogger.info("Initialized user without email: {}", user);

        HomePage homePage = new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        registrationLogger.debug("Navigated to login page");

        RegistrationPage registrationPage = new RegistrationPage(getWebDriver());

        // act
        loginPage.navToRegisterationPage().createAccount(user);
        registrationLogger.info("Attempted to create account for user without email");

        // assert
        String errorMessage = registrationPage.errorMessage();
        registrationLogger.debug("Retrieved error message: {}", errorMessage);
        Assert.assertTrue(errorMessage.contains("Email cannot be blank"), "Error message verification");

        logger.info("Test verifyThatTheUserIsNotAbleToRegisterWithEmptyEmail completed successfully");
    }

    @Test
    public void verifyThatTheUserIsNotAbleToRegisterWithEmptyPassword() {
        logger.info("Starting test: verifyThatTheUserIsNotAbleToRegisterWithEmptyPassword");

        // arrange
        UserModal user = UserModal.builder().build().userWithoutPassword();
        registrationLogger.info("Initialized user without password: {}");

        HomePage homePage = new HomePage(getWebDriver());
        LoginPage loginPage = homePage.getHeader().navToLoginPage();
        registrationLogger.debug("Navigated to login page");

        RegistrationPage registrationPage = new RegistrationPage(getWebDriver());

        // act
        loginPage.navToRegisterationPage().createAccount(user);
        registrationLogger.info("Attempted to create account for user without password");

        // assert
        String errorMessage = registrationPage.errorMessage();
        registrationLogger.debug("Retrieved error message: {}", errorMessage);
        Assert.assertTrue(errorMessage.contains("Password cannot be blank"), "Error message verification");

        logger.info("Test completed successfully");
    }
}