package ru.stqa.work.mantis2.appmanager;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void ManagementTab() {
    wd.findElement(By.linkText("управление")).click();
  }

  public void UsersPage() {
    wd.findElement(By.linkText("Управление пользователями")).click();
  }
}
