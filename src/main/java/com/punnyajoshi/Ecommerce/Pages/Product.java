package com.punnyajoshi.Ecommerce.Pages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private final String name;
    private final int index;

    public Product(String name, int index) {
        this.name = name;
        this.index = index;
    }

}
