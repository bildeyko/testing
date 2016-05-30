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

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Makhnovets on 29.05.2016.
 */
public class RegistrationTest extends JUnitTestBase {
    private HomePage homepage;

    @Before
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        driver.get(HomePage.URL);
    }
    @Test
    public void test4() throws InterruptedException {
        HomePage registration=homepage.FailRegistration(" "," ");
        assertFalse(homepage.registrationButton.isEnabled());
        homepage.closeLogInBox.click();
    }
    @Test
    public void test2() throws InterruptedException {
        HomePage registration=homepage.FailRegistration("Lerunm","moloko");
        registration.registrationButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(registration.logInError));
        assertEquals("Неверный e-mail или пароль", registration.logInError.getText());
        homepage.closeLogInBox.click();
    }
    @Test
    public void test3() throws InterruptedException, IOException {
        HomePage registration=homepage.FailRegistration(PropertyLoader.loadProperty("username"),"moloko");
        registration.registrationButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(registration.logInError));
        assertEquals("Данный email уже зарегистрирован", registration.logInError.getText());
        homepage.closeLogInBox.click();
    }
    @Test
    public void test1() throws InterruptedException, IOException {
        ProfilePage registration=homepage.Registration(PropertyLoader.loadProperty("username"),PropertyLoader.loadProperty("password"));
        homepage.registrationButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(homepage.logInError));
        assertEquals("Мой профиль", registration.name.getText());
        homepage.LogOut();
    }


}


