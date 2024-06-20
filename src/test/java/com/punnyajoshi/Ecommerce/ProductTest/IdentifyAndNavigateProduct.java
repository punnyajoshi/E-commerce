package com.punnyajoshi.Ecommerce.ProductTest;

import com.punnyajoshi.Ecommerce.BaseTest;
import com.punnyajoshi.Ecommerce.Pages.HomePage;
import com.punnyajoshi.Ecommerce.product.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ViewSearchResultPage;
import com.punnyajoshi.Ecommerce.actions.SearchContentAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IdentifyAndNavigateProduct extends BaseTest {
    @Test(testName = "Navigate to Search page",description = "User should be able to navigate to the Search Page")
    public void userIsAbleToNavigateToSearchPage(){
        SearchContentAction searchContent= SearchContentAction.builder().build().init();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());

        ViewSearchResultPage searchResultPage=new ViewSearchResultPage(getWebDriver());
        String searchResultHeading = searchResultPage.getSearchResultHeading();

        Assert.assertTrue(searchResultHeading.contains("Search results"));
    }

    @Test(testName = "Navigate to Search page by Name",description = "User should be able to search a product by Name")
    public void userIsAbleToNavigateToSearchPageByName(){
        SearchContentAction searchContent= SearchContentAction.builder().build().stellTop();
        HomePage homePage=new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());

        ViewSearchResultPage searchResultPage=new ViewSearchResultPage(getWebDriver());
        Assert.assertTrue(searchContent.getInput().contains(searchResultPage.getProductName()));

        ProductDetailsPage productDetailsPage = searchResultPage.clickToViewProductByName();
        Assert.assertTrue((searchContent.getInput().contains(productDetailsPage.getProductName())));
    }
}