package ru.stqa.work.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {

    app.getContactHelper().openContacts();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Name", "Middle Name",
              "Last Name", "Nickname", "Title", "Company", "Address",
              "1111111", "2222222", "3333333", "4444444",
              "email@email.com", "homepage", "1983", "1983",
              "group name","Address2", "5555555", "Notes"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Name", "Middle Name",
            "Last Name", "Nickname", "Title", "Company", "Address",
            "1111111", "2222222", "3333333", "4444444",
            "email@email.com", "homepage", "1983", "1983",
            null,"Address2", "5555555", "Notes"), false);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().openContacts();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }
}