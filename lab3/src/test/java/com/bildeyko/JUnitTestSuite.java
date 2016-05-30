package com.bildeyko;

import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;

@RunWith(Suite.class)
@SuiteClasses({
        AuthTest.class,
        RegistrationTest.class,
        GuestWatchLaterTest.class,
        UserWatchLaterTest.class,
        GuestWatchTest.class,
        UserWatchTest.class,
        SearchTest.class
})
public class JUnitTestSuite {

  @Rule
  public ExternalResource webDriverFactory = new ExternalResource() {
    @Override
    protected void before() throws Throwable {
      WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    };

    @Override
    protected void after() {
      WebDriverFactory.dismissAll();
    };
  };
}
