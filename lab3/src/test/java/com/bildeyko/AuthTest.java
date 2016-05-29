package com.bildeyko;

import com.bildeyko.pages.ActorPage;
import com.bildeyko.pages.HomePage;
import com.bildeyko.pages.HomePageAuth;
import com.bildeyko.pages.ProfilePage;
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
    public void test1() throws Exception {        driver.get(HomePage.URL);
        ProfilePage profile=homepage.LogIn("lerunm@yandex.ru","moloko@12345");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(profile.name));
        assertEquals("Мой профиль",profile.name.getText());
    }
}
