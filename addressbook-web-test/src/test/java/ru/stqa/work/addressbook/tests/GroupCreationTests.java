package ru.stqa.work.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    app.getGroupHelper().createGroup(new GroupData("group name", null, null));
    //app.getGroupHelper().initGroupCreation();
    //app.getGroupHelper().fillGroupForm(new GroupData("group name", null, null));
    //app.getGroupHelper().submitGroupCreation();
    //app.getGroupHelper().returnToGroupPage();
  }

}
