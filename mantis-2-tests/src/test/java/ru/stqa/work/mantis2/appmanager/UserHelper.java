package ru.stqa.work.mantis2.appmanager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase{

  public UserHelper(ApplicationManager app) {
    super(app);
  }
  /*public void openUsersList(UserData user){
    app.getNavigationHelper().openManagementTab();
    app.getNavigationHelper().gotoUserManagementPage();
  }*/

  public void openUsersPage() {
    app.goTo().ManagementTab();
    app.goTo().UsersPage();
  }

  public void selectUser() {
    //wd.findElements(By.cssSelector(String.format("manage_user_edit_page.php?user_id=%s']"))).click();
    wd.findElement(By.linkText("dsdsd")).click();
  }

  public void resetPassword() {
    wd.findElement(By.xpath("//form[@id='manage-user-reset-form']/fieldset/span/input")).click();
  }

  public void logout() {
    wd.findElement(By.linkText("administrator")).click();
    wd.findElement(By.linkText("выход")).click();
  }


}
