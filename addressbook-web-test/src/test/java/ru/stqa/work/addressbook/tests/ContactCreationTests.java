package ru.stqa.work.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.goToAddNewPage();
    app.fillContactForm(new ContactData("Name", "Middle Name", "Last Name", "Nickname", "Title", "Company", "Address", "1111111", "2222222", "3333333", "4444444", "email@email.com", "homepage", "1983", "1983", "Address2", "5555555", "Notes"));
    app.submitContactCreation();
  }

}