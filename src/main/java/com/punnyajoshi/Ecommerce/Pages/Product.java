package com.punnyajoshi.Ecommerce.Pages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private final String name;
    private final int index;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.index = index;
        this.price = price;
    }

}
