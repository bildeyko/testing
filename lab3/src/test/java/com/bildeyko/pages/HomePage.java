package com.bildeyko.pages;

import com.bildeyko.JUnitTestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class HomePage extends Page {
  public static String URL;

  @FindBy(xpath = "//header/div[3]/form/div/input")
  @CacheLookup
  public WebElement searchInput;

  @FindBy(xpath = "//header/div[3]/form/div/button")
  @CacheLookup
  public WebElement searchSubmit;

  @FindBy(xpath = "//ul[@class='persons-result']//a[contains(text(),'Кристофер Нолан')]")
  @CacheLookup
  public WebElement actorResult;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl;
  }

  public ActorPage ActorSearch(String request)
  {
    searchInput.sendKeys(request);
    actorResult.click();
    return new ActorPage(driver);
  }

  public SearchResultPage FullSearch(String request)
  {
    searchInput.sendKeys(request);
    searchSubmit.submit();
    return new SearchResultPage(driver);
  }
}
