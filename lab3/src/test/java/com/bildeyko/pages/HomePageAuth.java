package com.bildeyko.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Makhnovets on 29.05.2016.
 */
public class HomePageAuth extends Page {
	@FindBy(xpath="//h1")
	private WebElement name;

    public HomePageAuth(WebDriver WebDriver) {
        super(WebDriver);
        PageFactory.initElements(driver,this);
    }
}
