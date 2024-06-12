package com.punnyajoshi.Ecommerce.CartTest;

import com.punnyajoshi.Ecommerce.BaseTest;
import com.punnyajoshi.Ecommerce.Pages.CartPage;
import com.punnyajoshi.Ecommerce.Pages.HomePage;
import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ViewSearchResultPage;
import com.punnyajoshi.Ecommerce.actions.SearchContentAction;
import com.punnyajoshi.Ecommerce.modals.CartModal;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartContentValidationTest  extends BaseTest {
    @Test(testName = "able is navigate to cart page",description = "Verifies that the user is navigated to the cart page")
    public void userIsAbleToNavigateToCartPage(){
        SearchContentAction searchContent=SearchContentAction.builder().build().stellTop();
        HomePage homePage=new HomePage(getWebDriver());

        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());

        ViewSearchResultPage viewSearchResultPage=new ViewSearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = viewSearchResultPage.clickToViewProductByName();

        CartModal cartModel=new CartModal(getWebDriver());
        CartPage cartPage=new CartPage(getWebDriver());

        if(!productDetailsPage.isProductAvailable()){
            cartPage = productDetailsPage.addToCartButton();
        }

        else{
            Assert.fail("Product is not available, it is out of stock");
        }

        String cartHeading = cartModel.clickAddToCart().getCartHeading();

        Assert.assertTrue(cartHeading.contains("Your cart"));
    }


    @Test(testName = "verify that Product which is added Listed in Cart With Correct Details", description = "Checks that the product added is listed in the cart with the correct details such as name, size, and quantity.")
    public void checkTheProductWhichIsAddedIsListedInCartWithCorrectDetails() {
        SearchContentAction searchContent=SearchContentAction.builder().build().golfShoes();
        HomePage homePage=new HomePage(getWebDriver());

        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());

        ViewSearchResultPage viewSearchResultPage=new ViewSearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = viewSearchResultPage.clickToViewProductByName();

        CartModal cartModel=new CartModal(getWebDriver());
        CartPage cartPage=new CartPage(getWebDriver());

        if(!productDetailsPage.isProductAvailable()){
            cartPage = productDetailsPage.addToCart();

        }

        else{
            Assert.fail("Product is not available, it is out of stock");
        }

        cartModel.clickAddToCart();

        Assert.assertTrue(cartPage.getAddedProductName().contains(productDetailsPage.getProductName()));
        Assert.assertTrue((cartPage.getSizeOfAddedProduct().contains(productDetailsPage.getSizeSelected())));
        Assert.assertEquals(cartPage.getQuantityOfAddedProduct(),productDetailsPage.getQuantitySelected());
        Assert.assertEquals(cartPage.getProductAddedPrice(),productDetailsPage.getProductPrice());

    }
}
