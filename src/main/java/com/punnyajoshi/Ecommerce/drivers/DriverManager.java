package com.punnyajoshi.Ecommerce.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private String browser=System.getProperty("browser","chrome");

    public WebDriver create(BrowserType type){
        return switch (type) {
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
            default -> new ChromeDriver();
        };
    }

    public WebDriver create(){
        BrowserType type=BrowserType.valueOf(browser.trim().toUpperCase());
        return create(type);
    }
}
