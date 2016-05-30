package com.bildeyko;

import com.bildeyko.pages.HomePage;
import com.bildeyko.pages.ProfilePage;
import com.bildeyko.util.PropertyLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by Makhnovets on 29.05.2016.
 */
public class AuthTest extends JUnitTestBase {
    private HomePage homepage;

    @Before
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void test1() throws Exception {
        driver.get(HomePage.URL);
        ProfilePage profile = homepage.LogIn(PropertyLoader.loadProperty("username"),
                PropertyLoader.loadProperty("password"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(profile.name));
        assertEquals("Мой профиль", profile.name.getText());
        homepage.LogOut();
    }

    @Test
    public void test2() throws Exception {
        driver.get(HomePage.URL);
        HomePage profile = homepage.NoLogIn(PropertyLoader.loadProperty("username"), "ololo");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(profile.logInError));
        assertEquals("Неверный e-mail или пароль", profile.logInError.getText());
        homepage.closeLogInBox.click();
    }

    @Test
    public void test3() throws Exception {
        driver.get(HomePage.URL);
        HomePage profile = homepage.NoLogIn("username",
                PropertyLoader.loadProperty("password"));
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(profile.name));
        assertEquals("Неверный e-mail или пароль", profile.logInError.getText());
        homepage.closeLogInBox.click();
    }

    @Test
    public void test4() throws Exception {
        driver.get(HomePage.URL);
        HomePage profile = homepage.NoLogIn("ololo", "ololo");
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOf(profile.logInError));
        assertEquals("Неверный e-mail или пароль", profile.logInError.getText());
        homepage.closeLogInBox.click();
    }
}
//    @After
//    public void After() throws InterruptedException {
//
//            homepage.LogOut();
//        }
//    }


