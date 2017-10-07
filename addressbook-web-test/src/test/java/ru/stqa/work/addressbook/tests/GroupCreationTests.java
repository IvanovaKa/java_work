package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().createGroup(new GroupData("group name", "header", "footer"));
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() +1);


   /* app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("group name", "header", "footer"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();*/
  }

}
