package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;
import ru.stqa.work.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().goToAddNewPage();
    ContactData contact = new ContactData("Name2", "Middle Name",
            "Last Name", "Nickname", "Title", "Company", "Address",
            "1111111", "2222222", "3333333", "4444444",
            "email@email.com", "homepage", "1983", "1983",
            "group name","Address2", "5555555", "Notes");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}