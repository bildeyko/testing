package com.bildeyko.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Makhnovets on 29.05.2016.
 */
public class ProfilePage extends Page {
    @FindBy(xpath = "//h1")
    @CacheLookup
    public WebElement name;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
