package ru.stqa.work.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().goToGroupPage();
    if (app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("group name", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("group name", null, null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
