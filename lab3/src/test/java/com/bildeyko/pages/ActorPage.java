package com.bildeyko.pages;

import com.bildeyko.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ASUS on 29.05.2016.
 */
public class ActorPage extends Page {
    @FindBy(xpath = "//h1")
    @CacheLookup
    public WebElement name;

    public ActorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(driver,this);
    }
}
