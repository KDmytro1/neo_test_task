package com.neobank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    public static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tatyana.kuzmenok\\chromedriver\\chromedriver.exe");
        return new ChromeDriver();
    }
}