package com.bildeyko;

import com.bildeyko.pages.ActorPage;
import com.bildeyko.pages.HomePage;
import com.bildeyko.pages.WatchPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;

/**
 * Created by ASUS on 29.05.2016.
 */
public class GuestWatchTest extends JUnitTestBase  {
    private WatchPage watchpage;

    @Before
    public void initPageObjects() {
        watchpage = PageFactory.initElements(driver, WatchPage.class);
    }

    @Test
    public void test2() throws Exception {
        WatchPage buf = watchpage.watch("103343");
        assertTrue(buf.player.isDisplayed());
    }

    @Test(expected = NoSuchElementException.class)
    public void test5() throws Exception {
        WatchPage buf = watchpage.watch("99906");
        assertFalse(buf.player.isDisplayed());
    }
}
