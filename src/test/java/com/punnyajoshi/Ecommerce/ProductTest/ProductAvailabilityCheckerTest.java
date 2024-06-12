package com.punnyajoshi.Ecommerce.ProductTest;

import com.punnyajoshi.Ecommerce.BaseTest;
import com.punnyajoshi.Ecommerce.Pages.HomePage;
import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;
import com.punnyajoshi.Ecommerce.Pages.ViewSearchResultPage;
import com.punnyajoshi.Ecommerce.actions.SearchContentAction;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductAvailabilityCheckerTest extends BaseTest {
    @Test(testName = "verify the Availability of the Product",description = "user is able to verify that product is available")
    public void verifyAvailabilityOfProduct(){
        SearchContentAction searchContent=SearchContentAction.builder().build().stellTop();
        HomePage homePage=new HomePage(getWebDriver());

        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());
        ViewSearchResultPage searchResultPage=new ViewSearchResultPage(getWebDriver());

        ProductDetailsPage productDetailsPage = searchResultPage.clickToViewProductByIndex(0);

        Assert.assertFalse((productDetailsPage.isProductAvailable()), "Product is Available");
    }

    @Test(testName = "verify Product Is SoldOut",description = "verify that product is sold out")
    public void verifyProductIsSoldOut() {
        SearchContentAction searchContent = SearchContentAction.builder().build().soldOutProduct();

        HomePage homePage = new HomePage(getWebDriver());
        homePage.getHeader().clickSearchBtn().searchProduct(searchContent.getInput());

        ViewSearchResultPage searchResultPage = new ViewSearchResultPage(getWebDriver());
        ProductDetailsPage productDetailsPage = searchResultPage.clickToViewProductByIndex(0);

        Assert.assertTrue((productDetailsPage.isProductAvailable()), "Product is Out of Stock");
    }
}