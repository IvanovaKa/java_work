package ru.stqa.work.addressbook.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goToGroupPage();
    app.initGroupCreation();
    app.fillGroupForm("group name", "header", "footer");
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
