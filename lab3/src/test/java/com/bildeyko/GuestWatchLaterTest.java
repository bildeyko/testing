package com.bildeyko;

import com.bildeyko.pages.HomePage;
import com.bildeyko.pages.WatchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ASUS on 29.05.2016.
 */
public class GuestWatchLaterTest extends JUnitTestBase {
    private HomePage homepage;

    @Before
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
        driver.get(HomePage.URL);
    }

    @Test
    public void test3() throws Exception {
        HomePage buf = homepage.toLaterList();
        String oldId = buf.laterBtn.getAttribute("data-object-id");
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(buf.laterCell));
        String newId = buf.laterCell.getAttribute("data-id");
        assertEquals(oldId, newId);
    }

    @Test(expected = NoSuchElementException.class)
    public void test4() throws Exception {
        homepage.laterCell.getAttribute("data-id");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
