package ru.stqa.work.mantis2.tests;

import org.testng.annotations.Test;

public class PasswordResetTests extends TestBase{

  @Test
  public void testPasswordReset() {
    app.userHelper().openUsersPage();
    //app.getUserHelper().openUsersList();
    app.userHelper().selectUser();
    app.userHelper().resetPassword();
    //app.getUserHelper().logout();
  }



}
