package com.bildeyko;

import com.bildeyko.pages.ActorPage;
import com.bildeyko.pages.SearchResultPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.support.PageFactory;

import com.bildeyko.pages.HomePage;

import java.util.concurrent.TimeUnit;

public class SearchTest extends JUnitTestBase {

  private HomePage homepage;

  @Before
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  @Test
  public void test1() throws Exception {
    driver.get(HomePage.URL);
    ActorPage actor = homepage.ActorSearch("Нолан");
    assertEquals("Кристофер Нолан", actor.name.getText());
  }

  @Test
  public void test2() throws Exception {
    driver.get(HomePage.URL);
    SearchResultPage res = homepage.FullSearchLink("Начало");
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    assertEquals("Начало", res.movieCell.getText());
  }

  @Test
  public void test3() throws Exception {
    driver.get(HomePage.URL);
    SearchResultPage res = homepage.FullSearchBtn("Начало");
    assertEquals("Начало", res.movieCell.getText());
  }

  @Test
  public void test4() throws Exception {
    driver.get(HomePage.URL);
    HomePage res = homepage.CancelSearch("Аватар");
    assertFalse(res.resultBox.isDisplayed());
  }

  @Test
  public void test5() throws Exception {
    driver.get(HomePage.URL);
    HomePage res = homepage.NoResultsSearch("Пурум");
    assertEquals("К сожалению, по введенному вами запросу ничего не найдено.", res.noResults.getText());
  }

  @Test
  public void test6() throws Exception {
    driver.get(HomePage.URL);
    HomePage res = homepage.CancelSearch("Пурум");
    assertFalse(res.resultBox.isDisplayed());
  }

  @After
  public void tearDown() throws Exception {
    driver.close();
  }
}
