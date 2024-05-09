package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.ProductDetailsPage;

public class ProductAvailabilityChecker {
    public boolean isProductAvailable(ProductDetailsPage productDetailsPage) {
        return productDetailsPage.isProductAvailable();
    }
}
