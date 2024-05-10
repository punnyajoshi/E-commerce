package com.punnyajoshi.Ecommerce;

import com.punnyajoshi.Ecommerce.Pages.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {


    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Item added to your cart");
    }

    public int getItemCount() {
        return products.size();
    }
}
