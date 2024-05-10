package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.CartPage;
import com.punnyajoshi.Ecommerce.Pages.Product;

public class ShoppingCartApp{

public static void main(String[] args) {
    // Create cart instance
    Cart cart = new Cart();

    // Adding products to the cart (example products)
    Product product = new Product("Sweater", "L", 1, 49.99);
    cart.addProduct(product);

    // Navigate to the cart page
    CartPage cartPage = new CartPage(driver, cartUrl);
    cartPage.navigateToCartPage();

    // Logic to display cart contents
    for (Product p : cart.getProducts()) {
        System.out.println("Name: " + p.getName());
        System.out.println("Size: " + p.getSize());
        System.out.println("Price: " + p.getPrice());
        System.out.println("Quantity: " + p.getQuantity());
        System.out.println("--------------------");
    }

    // Compute and show total price here
    System.out.println("Total price: $" + cart.getTotalPrice());
}
}