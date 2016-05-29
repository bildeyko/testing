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
public class SearchResultPage extends Page {
    public static String URL;

    @FindBy(xpath = "//section[@class='gallery-wrapper ']/ul/li[2]//span[@class='title']/span")
    @CacheLookup
    public WebElement movieCell;

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
        URL = JUnitTestBase.baseUrl + "search";
        PageFactory.initElements(driver,this);
    }
}
