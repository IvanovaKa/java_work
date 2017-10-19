package ru.stqa.work.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.work.addressbook.model.ContactData;
import ru.stqa.work.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  //(enabled = false)

  @Test
  public void testContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    File photo = new File("src/test/resources/image.png");
    ContactData contact = new ContactData()
            .withFirst_name("Name").withMiddle_name("Middle Name").withLast_name("Last Name").withNickname("Nickname")
            .withPhoto(photo).withTitle("Title").withCompany("Company").withAddress("Address").withHome_phone("1111111")
            .withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444").withEmail("email@email.com")
            .withEmail2("email1@email.com").withEmail3("email2@email.com").withHomepage("homepage")
            .withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
            .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    /*Contacts after = app.contact().all();
    assertThat(after, equalTo
            (before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));*/
  }
/*
  @Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/image.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
*/

  @Test
  public void testBadContactCreation() {
    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    ContactData contact = new ContactData()
            .withFirst_name("Name'").withMiddle_name("Middle Name").withLast_name("Last Name'").withNickname("Nickname")
            .withTitle("Title").withCompany("Company").withAddress("Address").withHome_phone("1111111")
            .withMobile_phone("2222222").withWork_phone("3333333").withFax("4444444").withEmail("email@email.com")
            .withHomepage("homepage").withBirthday_year("1983").withAnniversary_year("1983").withGroup("group name")
            .withAddress2("Address2").withHome_phone2("5555555").withNotes("Notes");
    app.contact().create(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
}