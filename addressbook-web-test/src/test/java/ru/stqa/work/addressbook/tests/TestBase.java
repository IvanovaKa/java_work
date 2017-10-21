package ru.stqa.work.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.work.addressbook.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

}