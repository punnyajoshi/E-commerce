package com.punnyajoshi.Ecommerce.cartPackage;

import com.punnyajoshi.Ecommerce.modals.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product[] getProducts() {
        return products.toArray(new Product[0]);
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }
}
