package com.bildeyko;

import com.bildeyko.pages.ActorPage;
import com.bildeyko.pages.SearchResultPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.support.PageFactory;

import com.bildeyko.pages.HomePage;

public class SearchTest extends JUnitTestBase {

  private HomePage homepage;

  @Before
  public void initPageObjects() {
    homepage = PageFactory.initElements(driver, HomePage.class);
  }

  /*@Test
  public void test1() throws Exception {
    driver.get(HomePage.URL);
    ActorPage actor = homepage.ActorSearch("Нолан");
    assertEquals("Кристофер Нолан", actor.name.getText());
  }*/

  /*@Test
  public void test2() throws Exception {
    driver.get(HomePage.URL);
    SearchResultPage res = homepage.Search("Начало");
    assertEquals("Начало", res.movieCell.getText());
  }*/

  @Test
  public void test3() throws Exception {
    driver.get(HomePage.URL);
    SearchResultPage res = homepage.FullSearch("Начало");
    assertEquals("Начало", res.movieCell.getText());
  }
}
