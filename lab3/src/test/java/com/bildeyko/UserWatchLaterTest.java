package com.bildeyko;

import com.bildeyko.pages.HomePage;
import com.bildeyko.pages.ProfilePage;
import com.bildeyko.util.PropertyLoader;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by ASUS on 30.05.2016.
 */
public class UserWatchLaterTest extends JUnitTestBase {
    private HomePage homepage;
    private ProfilePage profile;

    @Before
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        profile = PageFactory.initElements(driver, ProfilePage.class);
        driver.get(HomePage.URL);
        try {
            profile = homepage.LogIn(PropertyLoader.loadProperty("username"),
                    PropertyLoader.loadProperty("password"));
        }catch (Exception ex)
        {
            return;
        }
    }

    @Test
    public void test1() throws Exception {
        driver.get(HomePage.URL);
        HomePage buf = homepage.toLaterList();
        String oldId = buf.laterBtn.getAttribute("data-object-id");
        driver.navigate().to(profile.URL + "#favorites");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(profile.laterCell));
        String newId = profile.laterCell.getAttribute("data-content-id");
        wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(profile.name));
        profile = profile.deleteLater();
        assertEquals(oldId, newId);
    }

    @Test
    public void test2() throws Exception {
        driver.navigate().to(profile.URL + "#favorites");
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf( profile.emptyLater));
        assertEquals("У вас нет фильмов, добавленных для просмотра позже",
                     profile.emptyLater.getText());
    }
}
