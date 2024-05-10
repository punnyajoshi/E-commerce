package com.punnyajoshi.Ecommerce.Pages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private String size;
    private int quantity;
    private double price;

    public Product(String name, String size, int quantity, double price) {
        this.name = name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}
