package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCout();
    if (! app.getContactHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group name", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCout();
    Assert.assertEquals(after, before - 1);
  }

}
