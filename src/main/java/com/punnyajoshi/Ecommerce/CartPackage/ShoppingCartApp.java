package com.punnyajoshi.Ecommerce.CartPackage;

import com.punnyajoshi.Ecommerce.CartPackage.Cart;
import com.punnyajoshi.Ecommerce.Pages.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartApp{

    public static void main(String[] args) {
        // Initialize the WebDriver and cartUrl here
        WebDriver driver = new ChromeDriver();
        driver.get("https://web-playground.ultralesson.com");

        driver.findElement(By.xpath("//a[@href='/cart']")).click();

        // Create cart instance
        Cart cart = new Cart();

        // Adding products to the cart (example products)
        Product product = new Product("Sweater", "L", 1, 49.99);
        cart.addProduct(product);


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

        // Close the WebDriver
        driver.quit();
    }
}