package ru.stqa.work.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests1 extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("test group", "test", "tes"));
    submitTestCreation();
    returnToGroupPage();
  }

}
