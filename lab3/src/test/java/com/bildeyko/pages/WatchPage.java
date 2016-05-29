package com.bildeyko.pages;

import com.bildeyko.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ASUS on 29.05.2016.
 */
public class WatchPage extends Page {
    public static String URL;

    @FindBy(xpath = "//iframe")
    @CacheLookup
    public WebElement player;

    public WatchPage(WebDriver webDriver) {
        super(webDriver);
        URL = JUnitTestBase.baseUrl + "/watch/";
    }

    public WatchPage watch(String id)
    {
        URL += id;
        driver.get(URL);
        return this;
    }
}
