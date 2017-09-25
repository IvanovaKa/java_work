package ru.stqa.work.addressbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager();

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

}
