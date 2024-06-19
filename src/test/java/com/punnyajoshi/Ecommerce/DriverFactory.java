package com.punnyajoshi.Ecommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {
    private static DriverFactory instance = null;
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private Properties properties = new Properties();

    private DriverFactory() {
        loadConfiguration();
    }

    public static DriverFactory getInstance() {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver driver = createDriver();
            driverThreadLocal.set(driver);
        }
        return driverThreadLocal.get();
    }

    public synchronized void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }

    private void loadConfiguration() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("webdriver-config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find webdriver-config.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private WebDriver createDriver() {
        String browser = properties.getProperty("browser", "chrome");

        return switch (browser.toLowerCase()) {
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            default -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver();
            }
        };
    }
}
