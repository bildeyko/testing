package com.bildeyko;

import com.bildeyko.pages.HomePage;
import com.bildeyko.pages.ProfilePage;
import com.bildeyko.pages.WatchPage;
import com.bildeyko.util.PropertyLoader;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by ASUS on 30.05.2016.
 */
public class UserWatchTest extends JUnitTestBase {
    private WatchPage watchpage;
    private HomePage homepage;
    private ProfilePage profile;

    @Before
    public void initPageObjects() {
        watchpage = PageFactory.initElements(driver, WatchPage.class);
        homepage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void test1() throws Exception {
        homepage = PageFactory.initElements(driver, HomePage.class);
        driver.get(HomePage.URL);
        profile = homepage.LogIn(PropertyLoader.loadProperty("username"),
                PropertyLoader.loadProperty("password"));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WatchPage buf = watchpage.watch("103343");
        assertTrue(buf.player.isDisplayed());

        homepage.LogOut();
    }

    @Test(expected = NoSuchElementException.class)
    public void test4() throws Exception {
        driver.get(HomePage.URL);
        homepage = PageFactory.initElements(driver, HomePage.class);
        profile = homepage.LogIn(PropertyLoader.loadProperty("username"),
                PropertyLoader.loadProperty("password"));

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WatchPage buf = watchpage.watch("99906");
        assertFalse(buf.player.isDisplayed());

        driver.navigate().to(HomePage.URL);
        homepage.LogOut();
    }
}
