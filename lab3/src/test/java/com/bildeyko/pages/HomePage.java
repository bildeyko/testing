package com.bildeyko.pages;

import com.bildeyko.JUnitTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Sample page
 */
public class HomePage extends Page {


    @FindBy(xpath = "//div/*[@class='login-btn']")
    @CacheLookup
    private WebElement authBotton;

    @FindBy(xpath = "//div/h1[contains(text(),'Вход')]")
    @CacheLookup
    private WebElement authBox;

    @FindBy(xpath = "//label[@for='email-tab']")
    @CacheLookup
    private WebElement authEmail;

    @FindBy(xpath = "//input[@id='email']")
    @CacheLookup
    private WebElement inputEmail;


    @FindBy(xpath = "//div/button[contains(text(),'Войти')]")
    @CacheLookup
    private WebElement buttonLogIn;

    @FindBy(xpath = "//input[@id='pass']")
    @CacheLookup
    private WebElement inputPassword;


    @FindBy(xpath = "//div[@class='profile-wrapper js-auth-info']/*")
    @CacheLookup
    public WebElement logInBox;


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

    @FindBy(xpath = "//form/p[@class='js-notice error']")
    @CacheLookup
    public WebElement logInError;

    @FindBy(xpath = "//*[@class='logout']/a")
    @CacheLookup
    public WebElement logOut;

    @FindBy(xpath = "//div[@class='profile-block']//*")
    @CacheLookup
    public WebElement loginBlock;

    @FindBy(xpath = "//div/*/*[contains(text(),'Закрыть')]")
    public WebElement closeLogInBox;

    @FindBy(xpath = "//div/*[contains(text(),'Регистрация')]")
    public WebElement registrationStrButton;
    @FindBy(xpath = "//div/h1[contains(text(),'Регистрация')]")
    public WebElement registrationBox;
    @FindBy(xpath = "//div/button[contains(text(),'Зарегистрироваться')]")
    public WebElement registrationButton;


    public HomePage(WebDriver webDriver) {
        super(webDriver);
        URL = JUnitTestBase.baseUrl;
    }

    public HomePage FailRegistration(String login, String password) throws InterruptedException {
        authBotton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(authBox));
        registrationStrButton.click();
        wait.until(ExpectedConditions.visibilityOf(registrationBox));
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        return this;
    }
    public ProfilePage Registration(String login, String password) throws InterruptedException {
        authBotton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(authBox));
        registrationStrButton.click();
        wait.until(ExpectedConditions.visibilityOf(registrationBox));
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        return new ProfilePage(driver);
    }
    public ProfilePage LogIn(String login, String password) throws InterruptedException {
        authBotton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(authBox));
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogIn.click();
        wait.until(ExpectedConditions.visibilityOf(logInBox));
        logInBox.click();
        return new ProfilePage(driver);
    }

    public HomePage NoLogIn(String login, String password) throws InterruptedException {
        authBotton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(authBox));
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLogIn.click();
        return this;
    }

    public HomePage LogOut() throws InterruptedException {

        logOut.click();


        return this;
    }


    public ActorPage ActorSearch(String request) {
        searchInput.sendKeys(request);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(resultBox));
        actorResult.click();
        return new ActorPage(driver);
    }

    public SearchResultPage FullSearchBtn(String request) {
        searchInput.sendKeys(request);
        searchSubmit.submit();
        return new SearchResultPage(driver);
    }

    public SearchResultPage FullSearchLink(String request) {
        searchInput.sendKeys(request);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(resultBox));
        allResults.click();
        return new SearchResultPage(driver);
    }

    public HomePage NoResultsSearch(String request) {
        searchInput.sendKeys(request);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(resultBox));
        return this;
    }

    public HomePage CancelSearch(String request) {
        searchInput.sendKeys(request);
        bodyWrapper.click();
        return this;
    }

    public HomePage toLaterList() {
        laterBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String tmp = "//a[contains(@class,'favorite bright large active')][1]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(tmp)));
        return this;
    }
}
