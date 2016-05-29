package com.bildeyko.pages;

import com.bildeyko.JUnitTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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

  @FindBy(xpath = "//a[contains(text(),'Все результаты')]")
  @CacheLookup
  public WebElement allResults;

  @FindBy(xpath = "//div[@class='nothing-found']/p[1]")
  @CacheLookup
  public WebElement noResults;

  @FindBy(xpath = "//header/div[3]/form/div[@class='result-box dropdown']")
  @CacheLookup
  public WebElement resultBox;

  @FindBy(xpath = "//body/div[2]")
  @CacheLookup
  public WebElement bodyWrapper;

  @FindBy(xpath = "//a[contains(@class,'js-favourite-button')][1]")
  @CacheLookup
  public WebElement laterBtn;

  @FindBy(xpath = "//*[@id='favourites']/li[1]")
  @CacheLookup
  public WebElement laterCell;

  public HomePage(WebDriver webDriver) {
    super(webDriver);
    URL = JUnitTestBase.baseUrl;
  }

  public ActorPage ActorSearch(String request)
  {
    searchInput.sendKeys(request);
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOf(resultBox));
    actorResult.click();
    return new ActorPage(driver);
  }

  public SearchResultPage FullSearchBtn(String request)
  {
    searchInput.sendKeys(request);
    searchSubmit.submit();
    return new SearchResultPage(driver);
  }

  public SearchResultPage FullSearchLink(String request)
  {
    searchInput.sendKeys(request);
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOf(resultBox));
    allResults.click();
    return new SearchResultPage(driver);
  }

  public HomePage NoResultsSearch(String request)
  {
    searchInput.sendKeys(request);
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOf(resultBox));
    return this;
  }

  public HomePage CancelSearch(String request)
  {
    searchInput.sendKeys(request);
    bodyWrapper.click();
    return this;
  }

  public HomePage toLaterList()
  {
    laterBtn.click();
    WebDriverWait wait = new WebDriverWait(driver,30);
    String tmp = "//a[contains(@class,'favorite bright large active')][1]";
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tmp)));
    return this;
  }
}
