package com.bildeyko;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

/**
 * Created by ASUS on 29.05.2016.
 */
public class Browser {
    public static WebDriver get() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();

        return driver;
    }
}
