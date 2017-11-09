package ru.stqa.work.mantis2.appmanager;

import org.openqa.selenium.By;

public class SessionHelper extends HelperBase {

  public SessionHelper(ApplicationManager app) {
    super(app);
  }

  public void login(String username, String password) {
    type(By.name("username"), username);
    click(By.cssSelector("type='submit']"));
    type(By.name("password"), password);
    click(By.cssSelector("type='submit']"));
  }
}
