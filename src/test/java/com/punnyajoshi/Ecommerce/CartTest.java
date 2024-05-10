package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest {
    @Test
    public void testCorrectCartContents() {
        Cart cart = new Cart();
        Product product = new Product("Sweater", "L", 1, 49.99);
        cart.addProduct(product);
        Product[] productsInCart = cart.getProducts();
        Assertions.assertEquals("Sweater", productsInCart[0].getName());
        Assertions.assertEquals("L", productsInCart[0].getSize());
        Assertions.assertEquals(49.99, productsInCart[0].getPrice());
        Assertions.assertEquals(1, productsInCart[0].getQuantity());
    }

    @Test
    public void testCorrectCartTotalPrice() {
        Cart cart = new Cart();
        Product product = new Product("Sweater", "L", 1, 49.99);
        cart.addProduct(product);
        Assertions.assertEquals(49.99, cart.getTotalPrice());
    }
}
