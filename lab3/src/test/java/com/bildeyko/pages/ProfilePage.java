package com.bildeyko.pages;

import com.bildeyko.JUnitTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Makhnovets on 29.05.2016.
 */
public class ProfilePage extends Page {
    public static String URL;

    @FindBy(xpath = "//h1")
    @CacheLookup
    public WebElement name;

    @FindBy(xpath = "//*[contains(@class,'js-favorites-block')]/ul[1]/li[1]")
    @CacheLookup
    public WebElement laterCell;

    @FindBy(xpath = "//*[contains(@class,'js-favorites-block')]/ul[1]/li[1]//span[@class='remove']")
    @CacheLookup
    public WebElement deleteBtn;

    @FindBy(xpath = "html/body/div[2]/div/section[2]/section/div")
    @CacheLookup
    public WebElement emptyLater;

    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        URL = JUnitTestBase.baseUrl + "/profile";
    }

    public ProfilePage deleteLater()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        Point p = laterCell.getLocation();
        action.moveToElement(name, p.getX(), p.getY()).build().perform();
        deleteBtn.click();
        return this;
    }
}
